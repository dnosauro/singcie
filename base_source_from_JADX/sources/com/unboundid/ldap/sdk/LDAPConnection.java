package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.protocol.AbandonRequestProtocolOp;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.ldap.protocol.ProtocolOp;
import com.unboundid.ldap.protocol.UnbindRequestProtocolOp;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.Debug;
import com.unboundid.util.DebugType;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.SynchronizedSSLSocketFactory;
import com.unboundid.util.SynchronizedSocketFactory;
import com.unboundid.util.Validator;
import com.unboundid.util.WeakHashSet;
import java.util.Collection;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.atomic.AtomicLong;
import java.util.logging.Level;
import javax.net.SocketFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;

public final class LDAPConnection implements LDAPInterface, ReferralConnector {
    private static final SocketFactory DEFAULT_SOCKET_FACTORY = SocketFactory.getDefault();
    private static final AtomicLong NEXT_CONNECTION_ID = new AtomicLong(0);
    private static final WeakHashSet<Schema> SCHEMA_SET = new WeakHashSet<>();
    private volatile Schema cachedSchema;
    private volatile boolean closeRequested;
    private StackTraceElement[] connectStackTrace;
    private final long connectionID;
    private volatile LDAPConnectionInternals connectionInternals;
    private String connectionName;
    private LDAPConnectionOptions connectionOptions;
    private AbstractConnectionPool connectionPool;
    private String connectionPoolName;
    private final LDAPConnectionStatistics connectionStatistics;
    private volatile Throwable disconnectCause;
    private volatile String disconnectMessage;
    private volatile DisconnectType disconnectType;
    private String hostPort;
    private BindRequest lastBindRequest;
    private long lastReconnectTime;
    private SocketFactory lastUsedSocketFactory;
    private String reconnectAddress;
    private int reconnectPort;
    private ReferralConnector referralConnector;
    private SocketFactory socketFactory;
    private Timer timer;
    private volatile boolean unbindRequestSent;

    public LDAPConnection() {
        this((SocketFactory) null, (LDAPConnectionOptions) null);
    }

    public LDAPConnection(LDAPConnectionOptions lDAPConnectionOptions) {
        this((SocketFactory) null, lDAPConnectionOptions);
    }

    public LDAPConnection(LDAPConnectionOptions lDAPConnectionOptions, String str, int i) {
        this((SocketFactory) null, lDAPConnectionOptions, str, i);
    }

    public LDAPConnection(LDAPConnectionOptions lDAPConnectionOptions, String str, int i, String str2, String str3) {
        this((SocketFactory) null, lDAPConnectionOptions, str, i, str2, str3);
    }

    public LDAPConnection(String str, int i) {
        this((SocketFactory) null, (LDAPConnectionOptions) null, str, i);
    }

    public LDAPConnection(String str, int i, String str2, String str3) {
        this((SocketFactory) null, (LDAPConnectionOptions) null, str, i, str2, str3);
    }

    public LDAPConnection(SocketFactory socketFactory2) {
        this(socketFactory2, (LDAPConnectionOptions) null);
    }

    public LDAPConnection(SocketFactory socketFactory2, LDAPConnectionOptions lDAPConnectionOptions) {
        this.reconnectPort = -1;
        this.connectionID = NEXT_CONNECTION_ID.getAndIncrement();
        this.connectionOptions = lDAPConnectionOptions == null ? new LDAPConnectionOptions() : lDAPConnectionOptions.duplicate();
        socketFactory2 = socketFactory2 == null ? DEFAULT_SOCKET_FACTORY : socketFactory2;
        if (this.connectionOptions.allowConcurrentSocketFactoryUse()) {
            this.socketFactory = socketFactory2;
        } else {
            this.socketFactory = socketFactory2 instanceof SSLSocketFactory ? new SynchronizedSSLSocketFactory((SSLSocketFactory) socketFactory2) : new SynchronizedSocketFactory(socketFactory2);
        }
        this.connectionStatistics = new LDAPConnectionStatistics();
        this.connectionName = null;
        this.connectionPoolName = null;
        this.cachedSchema = null;
        this.timer = null;
        this.referralConnector = this.connectionOptions.getReferralConnector();
        if (this.referralConnector == null) {
            this.referralConnector = this;
        }
    }

    public LDAPConnection(SocketFactory socketFactory2, LDAPConnectionOptions lDAPConnectionOptions, String str, int i) {
        this(socketFactory2, lDAPConnectionOptions);
        connect(str, i);
    }

    public LDAPConnection(SocketFactory socketFactory2, LDAPConnectionOptions lDAPConnectionOptions, String str, int i, String str2, String str3) {
        this(socketFactory2, lDAPConnectionOptions, str, i);
        try {
            bind(new SimpleBindRequest(str2, str3));
        } catch (LDAPException e) {
            Debug.debugException(e);
            setDisconnectInfo(DisconnectType.BIND_FAILED, (String) null, e);
            close();
            throw e;
        }
    }

    public LDAPConnection(SocketFactory socketFactory2, String str, int i) {
        this(socketFactory2, (LDAPConnectionOptions) null, str, i);
    }

    public LDAPConnection(SocketFactory socketFactory2, String str, int i, String str2, String str3) {
        this(socketFactory2, (LDAPConnectionOptions) null, str, i, str2, str3);
    }

    private static Schema getCachedSchema(LDAPConnection lDAPConnection) {
        Schema addAndGet;
        Schema schema = lDAPConnection.getSchema();
        synchronized (SCHEMA_SET) {
            addAndGet = SCHEMA_SET.addAndGet(schema);
        }
        return addAndGet;
    }

    /* access modifiers changed from: package-private */
    public void abandon(int i, Control... controlArr) {
        if (Debug.debugEnabled(DebugType.LDAP)) {
            Level level = Level.INFO;
            DebugType debugType = DebugType.LDAP;
            Debug.debug(level, debugType, "Sending LDAP abandon request for message ID " + i);
        }
        this.connectionStatistics.incrementNumAbandonRequests();
        sendMessage(new LDAPMessage(nextMessageID(), (ProtocolOp) new AbandonRequestProtocolOp(i), controlArr));
    }

    public void abandon(AsyncRequestID asyncRequestID) {
        abandon(asyncRequestID, (Control[]) null);
    }

    public void abandon(AsyncRequestID asyncRequestID, Control[] controlArr) {
        if (Debug.debugEnabled(DebugType.LDAP)) {
            Level level = Level.INFO;
            DebugType debugType = DebugType.LDAP;
            Debug.debug(level, debugType, "Sending LDAP abandon request for message ID " + asyncRequestID);
        }
        if (!synchronousMode()) {
            this.connectionStatistics.incrementNumAbandonRequests();
            sendMessage(new LDAPMessage(nextMessageID(), (ProtocolOp) new AbandonRequestProtocolOp(asyncRequestID.getMessageID()), controlArr));
            return;
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ABANDON_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public LDAPResult add(AddRequest addRequest) {
        Validator.ensureNotNull(addRequest);
        LDAPResult process = addRequest.process(this, 1);
        int intValue = process.getResultCode().intValue();
        if (intValue == 0 || intValue == 16654) {
            return process;
        }
        throw new LDAPException(process);
    }

    public LDAPResult add(Entry entry) {
        Validator.ensureNotNull(entry);
        return add(new AddRequest(entry));
    }

    public LDAPResult add(ReadOnlyAddRequest readOnlyAddRequest) {
        return add((AddRequest) readOnlyAddRequest);
    }

    public LDAPResult add(String str, Collection<Attribute> collection) {
        Validator.ensureNotNull(str, collection);
        return add(new AddRequest(str, collection));
    }

    public LDAPResult add(String str, Attribute... attributeArr) {
        Validator.ensureNotNull(str, attributeArr);
        return add(new AddRequest(str, attributeArr));
    }

    public LDAPResult add(String... strArr) {
        return add(new AddRequest(strArr));
    }

    public AsyncRequestID asyncAdd(AddRequest addRequest, AsyncResultListener asyncResultListener) {
        Validator.ensureNotNull(addRequest, asyncResultListener);
        if (!synchronousMode()) {
            return addRequest.processAsync(this, asyncResultListener);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncAdd(ReadOnlyAddRequest readOnlyAddRequest, AsyncResultListener asyncResultListener) {
        if (!synchronousMode()) {
            return asyncAdd((AddRequest) readOnlyAddRequest, asyncResultListener);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncCompare(CompareRequest compareRequest, AsyncCompareResultListener asyncCompareResultListener) {
        Validator.ensureNotNull(compareRequest, asyncCompareResultListener);
        if (!synchronousMode()) {
            return compareRequest.processAsync(this, asyncCompareResultListener);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncCompare(ReadOnlyCompareRequest readOnlyCompareRequest, AsyncCompareResultListener asyncCompareResultListener) {
        if (!synchronousMode()) {
            return asyncCompare((CompareRequest) readOnlyCompareRequest, asyncCompareResultListener);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncDelete(DeleteRequest deleteRequest, AsyncResultListener asyncResultListener) {
        Validator.ensureNotNull(deleteRequest, asyncResultListener);
        if (!synchronousMode()) {
            return deleteRequest.processAsync(this, asyncResultListener);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncDelete(ReadOnlyDeleteRequest readOnlyDeleteRequest, AsyncResultListener asyncResultListener) {
        if (!synchronousMode()) {
            return asyncDelete((DeleteRequest) readOnlyDeleteRequest, asyncResultListener);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncModify(ModifyRequest modifyRequest, AsyncResultListener asyncResultListener) {
        Validator.ensureNotNull(modifyRequest, asyncResultListener);
        if (!synchronousMode()) {
            return modifyRequest.processAsync(this, asyncResultListener);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncModify(ReadOnlyModifyRequest readOnlyModifyRequest, AsyncResultListener asyncResultListener) {
        if (!synchronousMode()) {
            return asyncModify((ModifyRequest) readOnlyModifyRequest, asyncResultListener);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncModifyDN(ModifyDNRequest modifyDNRequest, AsyncResultListener asyncResultListener) {
        Validator.ensureNotNull(modifyDNRequest, asyncResultListener);
        if (!synchronousMode()) {
            return modifyDNRequest.processAsync(this, asyncResultListener);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncModifyDN(ReadOnlyModifyDNRequest readOnlyModifyDNRequest, AsyncResultListener asyncResultListener) {
        if (!synchronousMode()) {
            return asyncModifyDN((ModifyDNRequest) readOnlyModifyDNRequest, asyncResultListener);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncSearch(ReadOnlySearchRequest readOnlySearchRequest) {
        if (!synchronousMode()) {
            return asyncSearch((SearchRequest) readOnlySearchRequest);
        }
        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
    }

    public AsyncRequestID asyncSearch(SearchRequest searchRequest) {
        Validator.ensureNotNull(searchRequest);
        SearchResultListener searchResultListener = searchRequest.getSearchResultListener();
        if (searchResultListener == null) {
            LDAPException lDAPException = new LDAPException(ResultCode.PARAM_ERROR, LDAPMessages.ERR_ASYNC_SEARCH_NO_LISTENER.get());
            Debug.debugCodingError(lDAPException);
            throw lDAPException;
        } else if (!(searchResultListener instanceof AsyncSearchResultListener)) {
            LDAPException lDAPException2 = new LDAPException(ResultCode.PARAM_ERROR, LDAPMessages.ERR_ASYNC_SEARCH_INVALID_LISTENER.get());
            Debug.debugCodingError(lDAPException2);
            throw lDAPException2;
        } else if (!synchronousMode()) {
            return searchRequest.processAsync(this, (AsyncSearchResultListener) searchResultListener);
        } else {
            throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_ASYNC_NOT_SUPPORTED_IN_SYNCHRONOUS_MODE.get());
        }
    }

    public BindResult bind(BindRequest bindRequest) {
        Validator.ensureNotNull(bindRequest);
        this.lastBindRequest = null;
        boolean z = true;
        BindResult process = bindRequest.process(this, 1);
        if (process.getResultCode().equals(ResultCode.SUCCESS)) {
            Control[] controls = bindRequest.getControls();
            int length = controls.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    z = false;
                    break;
                } else if (controls[i].getOID().equals("1.3.6.1.4.1.30221.2.5.3")) {
                    break;
                } else {
                    i++;
                }
            }
            if (!z) {
                this.lastBindRequest = bindRequest;
                if (this.connectionOptions.useSchema()) {
                    try {
                        this.cachedSchema = getCachedSchema(this);
                    } catch (Exception e) {
                        Debug.debugException(e);
                    }
                }
            }
            return process;
        }
        throw new LDAPException((LDAPResult) process);
    }

    public BindResult bind(String str, String str2) {
        return bind(new SimpleBindRequest(str, str2));
    }

    public void close() {
        this.closeRequested = true;
        setDisconnectInfo(DisconnectType.UNBIND, (String) null, (Throwable) null);
        AbstractConnectionPool abstractConnectionPool = this.connectionPool;
        if (abstractConnectionPool == null) {
            terminate((Control[]) null);
        } else {
            abstractConnectionPool.releaseDefunctConnection(this);
        }
    }

    public void close(Control[] controlArr) {
        this.closeRequested = true;
        setDisconnectInfo(DisconnectType.UNBIND, (String) null, (Throwable) null);
        AbstractConnectionPool abstractConnectionPool = this.connectionPool;
        if (abstractConnectionPool == null) {
            terminate(controlArr);
        } else {
            abstractConnectionPool.releaseDefunctConnection(this);
        }
    }

    /* access modifiers changed from: package-private */
    public boolean closeRequested() {
        return this.closeRequested;
    }

    public CompareResult compare(CompareRequest compareRequest) {
        Validator.ensureNotNull(compareRequest);
        CompareResult process = compareRequest.process(this, 1);
        switch (process.getResultCode().intValue()) {
            case 5:
            case 6:
                return new CompareResult(process);
            default:
                throw new LDAPException((LDAPResult) process);
        }
    }

    public CompareResult compare(ReadOnlyCompareRequest readOnlyCompareRequest) {
        return compare((CompareRequest) readOnlyCompareRequest);
    }

    public CompareResult compare(String str, String str2, String str3) {
        Validator.ensureNotNull(str, str2, str3);
        return compare(new CompareRequest(str, str2, str3));
    }

    public void connect(String str, int i) {
        connect(str, i, this.connectionOptions.getConnectTimeoutMillis());
    }

    public void connect(String str, int i, int i2) {
        Validator.ensureNotNull(str, Integer.valueOf(i));
        this.hostPort = str + ':' + i;
        if (isConnected()) {
            setDisconnectInfo(DisconnectType.RECONNECT, (String) null, (Throwable) null);
            close();
        }
        this.lastUsedSocketFactory = this.socketFactory;
        this.disconnectType = null;
        this.disconnectMessage = null;
        this.disconnectCause = null;
        this.reconnectAddress = str;
        this.reconnectPort = i;
        this.cachedSchema = null;
        this.unbindRequestSent = false;
        try {
            this.connectionStatistics.incrementNumConnects();
            this.connectionInternals = new LDAPConnectionInternals(this, this.connectionOptions, this.lastUsedSocketFactory, str, i, i2);
            this.connectionInternals.startConnectionReader();
            if (this.connectionOptions.useSchema()) {
                try {
                    this.cachedSchema = getCachedSchema(this);
                } catch (Exception e) {
                    Debug.debugException(e);
                }
            }
        } catch (Exception e2) {
            Debug.debugException(e2);
            setDisconnectInfo(DisconnectType.LOCAL_ERROR, (String) null, e2);
            this.connectionInternals = null;
            throw new LDAPException(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_CONN_CONNECT_ERROR.get(getHostPort(), StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    /* access modifiers changed from: package-private */
    public void convertToTLS(SSLContext sSLContext) {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals != null) {
            lDAPConnectionInternals.convertToTLS(sSLContext);
            return;
        }
        throw new LDAPException(ResultCode.SERVER_DOWN, LDAPMessages.ERR_CONN_NOT_ESTABLISHED.get());
    }

    public LDAPResult delete(DeleteRequest deleteRequest) {
        Validator.ensureNotNull(deleteRequest);
        LDAPResult process = deleteRequest.process(this, 1);
        int intValue = process.getResultCode().intValue();
        if (intValue == 0 || intValue == 16654) {
            return process;
        }
        throw new LDAPException(process);
    }

    public LDAPResult delete(ReadOnlyDeleteRequest readOnlyDeleteRequest) {
        return delete((DeleteRequest) readOnlyDeleteRequest);
    }

    public LDAPResult delete(String str) {
        return delete(new DeleteRequest(str));
    }

    /* access modifiers changed from: package-private */
    public void deregisterResponseAcceptor(int i) {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals != null) {
            lDAPConnectionInternals.deregisterResponseAcceptor(i);
        }
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        super.finalize();
        setDisconnectInfo(DisconnectType.CLOSED_BY_FINALIZER, (String) null, (Throwable) null);
        terminate((Control[]) null);
    }

    public int getActiveOperationCount() {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals != null && !lDAPConnectionInternals.synchronousMode()) {
            return lDAPConnectionInternals.getConnectionReader().getActiveOperationCount();
        }
        return -1;
    }

    /* access modifiers changed from: package-private */
    public Schema getCachedSchema() {
        return this.cachedSchema;
    }

    public StackTraceElement[] getConnectStackTrace() {
        return this.connectStackTrace;
    }

    public long getConnectTime() {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals != null) {
            return lDAPConnectionInternals.getConnectTime();
        }
        return -1;
    }

    public String getConnectedAddress() {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals == null) {
            return null;
        }
        return lDAPConnectionInternals.getHost();
    }

    public int getConnectedPort() {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals == null) {
            return -1;
        }
        return lDAPConnectionInternals.getPort();
    }

    public long getConnectionID() {
        return this.connectionID;
    }

    /* access modifiers changed from: package-private */
    public LDAPConnectionInternals getConnectionInternals() {
        return this.connectionInternals;
    }

    public String getConnectionName() {
        return this.connectionName;
    }

    public LDAPConnectionOptions getConnectionOptions() {
        return this.connectionOptions;
    }

    public String getConnectionPoolName() {
        return this.connectionPoolName;
    }

    public LDAPConnectionStatistics getConnectionStatistics() {
        return this.connectionStatistics;
    }

    public Throwable getDisconnectCause() {
        return this.disconnectCause;
    }

    public String getDisconnectMessage() {
        return this.disconnectMessage;
    }

    public DisconnectType getDisconnectType() {
        return this.disconnectType;
    }

    public SearchResultEntry getEntry(String str) {
        return getEntry(str, (String[]) null);
    }

    public SearchResultEntry getEntry(String str, String... strArr) {
        try {
            SearchResult search = search(new SearchRequest(str, SearchScope.BASE, DereferencePolicy.NEVER, 1, 0, false, Filter.createPresenceFilter("objectClass"), strArr));
            if (search.getResultCode().equals(ResultCode.SUCCESS)) {
                List<SearchResultEntry> searchEntries = search.getSearchEntries();
                if (searchEntries.isEmpty()) {
                    return null;
                }
                return searchEntries.get(0);
            }
            throw new LDAPException((LDAPResult) search);
        } catch (LDAPException e) {
            if (e.getResultCode().equals(ResultCode.NO_SUCH_OBJECT)) {
                return null;
            }
            throw e;
        }
    }

    /* access modifiers changed from: package-private */
    public String getHostPort() {
        String str = this.hostPort;
        return str == null ? "" : str;
    }

    /* access modifiers changed from: package-private */
    public BindRequest getLastBindRequest() {
        return this.lastBindRequest;
    }

    public SocketFactory getLastUsedSocketFactory() {
        return this.lastUsedSocketFactory;
    }

    public LDAPConnection getReferralConnection(LDAPURL ldapurl, LDAPConnection lDAPConnection) {
        BindRequest bindRequest;
        String host = ldapurl.getHost();
        int port = ldapurl.getPort();
        BindRequest bindRequest2 = lDAPConnection.lastBindRequest;
        if (bindRequest2 != null) {
            bindRequest = bindRequest2.getRebindRequest(host, port);
            if (bindRequest == null) {
                throw new LDAPException(ResultCode.REFERRAL, LDAPMessages.ERR_CONN_CANNOT_AUTHENTICATE_FOR_REFERRAL.get(host, Integer.valueOf(port)));
            }
        } else {
            bindRequest = null;
        }
        LDAPConnection lDAPConnection2 = new LDAPConnection(lDAPConnection.socketFactory, lDAPConnection.connectionOptions, host, port);
        if (bindRequest != null) {
            try {
                lDAPConnection2.bind(bindRequest);
            } catch (LDAPException e) {
                Debug.debugException(e);
                lDAPConnection2.setDisconnectInfo(DisconnectType.BIND_FAILED, (String) null, e);
                lDAPConnection2.close();
                throw e;
            }
        }
        return lDAPConnection2;
    }

    public ReferralConnector getReferralConnector() {
        ReferralConnector referralConnector2 = this.referralConnector;
        return referralConnector2 == null ? this : referralConnector2;
    }

    public RootDSE getRootDSE() {
        return RootDSE.getRootDSE(this);
    }

    public Schema getSchema() {
        return Schema.getSchema(this, "");
    }

    public Schema getSchema(String str) {
        return Schema.getSchema(this, str);
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    /* access modifiers changed from: package-private */
    public synchronized Timer getTimer() {
        if (this.timer == null) {
            this.timer = new Timer("Timer thread for " + toString(), true);
        }
        return this.timer;
    }

    public boolean isConnected() {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals == null) {
            return false;
        }
        if (lDAPConnectionInternals.isConnected()) {
            return true;
        }
        setClosed();
        return false;
    }

    public LDAPResult modify(ModifyRequest modifyRequest) {
        Validator.ensureNotNull(modifyRequest);
        LDAPResult process = modifyRequest.process(this, 1);
        int intValue = process.getResultCode().intValue();
        if (intValue == 0 || intValue == 16654) {
            return process;
        }
        throw new LDAPException(process);
    }

    public LDAPResult modify(ReadOnlyModifyRequest readOnlyModifyRequest) {
        return modify((ModifyRequest) readOnlyModifyRequest);
    }

    public LDAPResult modify(String str, Modification modification) {
        Validator.ensureNotNull(str, modification);
        return modify(new ModifyRequest(str, modification));
    }

    public LDAPResult modify(String str, List<Modification> list) {
        Validator.ensureNotNull(str, list);
        return modify(new ModifyRequest(str, list));
    }

    public LDAPResult modify(String str, Modification... modificationArr) {
        Validator.ensureNotNull(str, modificationArr);
        return modify(new ModifyRequest(str, modificationArr));
    }

    public LDAPResult modify(String... strArr) {
        Validator.ensureNotNull(strArr);
        return modify(new ModifyRequest(strArr));
    }

    public LDAPResult modifyDN(ModifyDNRequest modifyDNRequest) {
        Validator.ensureNotNull(modifyDNRequest);
        LDAPResult process = modifyDNRequest.process(this, 1);
        int intValue = process.getResultCode().intValue();
        if (intValue == 0 || intValue == 16654) {
            return process;
        }
        throw new LDAPException(process);
    }

    public LDAPResult modifyDN(ReadOnlyModifyDNRequest readOnlyModifyDNRequest) {
        return modifyDN((ModifyDNRequest) readOnlyModifyDNRequest);
    }

    public LDAPResult modifyDN(String str, String str2, boolean z) {
        Validator.ensureNotNull(str, str2);
        return modifyDN(new ModifyDNRequest(str, str2, z));
    }

    public LDAPResult modifyDN(String str, String str2, boolean z, String str3) {
        Validator.ensureNotNull(str, str2);
        return modifyDN(new ModifyDNRequest(str, str2, z, str3));
    }

    /* access modifiers changed from: package-private */
    public int nextMessageID() {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals == null) {
            return -1;
        }
        return lDAPConnectionInternals.nextMessageID();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x002e, code lost:
        throw new com.unboundid.ldap.sdk.LDAPException((com.unboundid.ldap.sdk.LDAPResult) r2);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.unboundid.ldap.sdk.ExtendedResult processExtendedOperation(com.unboundid.ldap.sdk.ExtendedRequest r2) {
        /*
            r1 = this;
            com.unboundid.util.Validator.ensureNotNull(r2)
            r0 = 1
            com.unboundid.ldap.sdk.ExtendedResult r2 = r2.process((com.unboundid.ldap.sdk.LDAPConnection) r1, (int) r0)
            java.lang.String r0 = r2.getOID()
            if (r0 != 0) goto L_0x002f
            com.unboundid.asn1.ASN1OctetString r0 = r2.getValue()
            if (r0 != 0) goto L_0x002f
            com.unboundid.ldap.sdk.ResultCode r0 = r2.getResultCode()
            int r0 = r0.intValue()
            switch(r0) {
                case 1: goto L_0x0029;
                case 2: goto L_0x0029;
                default: goto L_0x001f;
            }
        L_0x001f:
            switch(r0) {
                case 51: goto L_0x0029;
                case 52: goto L_0x0029;
                default: goto L_0x0022;
            }
        L_0x0022:
            switch(r0) {
                case 80: goto L_0x0029;
                case 81: goto L_0x0029;
                case 82: goto L_0x0029;
                case 83: goto L_0x0029;
                case 84: goto L_0x0029;
                case 85: goto L_0x0029;
                default: goto L_0x0025;
            }
        L_0x0025:
            switch(r0) {
                case 90: goto L_0x0029;
                case 91: goto L_0x0029;
                default: goto L_0x0028;
            }
        L_0x0028:
            goto L_0x002f
        L_0x0029:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            r0.<init>((com.unboundid.ldap.sdk.LDAPResult) r2)
            throw r0
        L_0x002f:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.LDAPConnection.processExtendedOperation(com.unboundid.ldap.sdk.ExtendedRequest):com.unboundid.ldap.sdk.ExtendedResult");
    }

    public ExtendedResult processExtendedOperation(String str) {
        Validator.ensureNotNull(str);
        return processExtendedOperation(new ExtendedRequest(str));
    }

    public ExtendedResult processExtendedOperation(String str, ASN1OctetString aSN1OctetString) {
        Validator.ensureNotNull(str);
        return processExtendedOperation(new ExtendedRequest(str, aSN1OctetString));
    }

    public LDAPResult processOperation(LDAPRequest lDAPRequest) {
        return lDAPRequest.process(this, 1);
    }

    /* access modifiers changed from: package-private */
    public LDAPResponse readResponse(int i) {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        return lDAPConnectionInternals != null ? lDAPConnectionInternals.getConnectionReader().readResponse(i) : this.disconnectType == null ? new ConnectionClosedResponse(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_CONN_READ_RESPONSE_NOT_ESTABLISHED.get()) : new ConnectionClosedResponse(this.disconnectType.getResultCode(), this.disconnectMessage);
    }

    public void reconnect() {
        BindRequest bindRequest;
        if (System.currentTimeMillis() - this.lastReconnectTime >= 1000) {
            BindRequest bindRequest2 = this.lastBindRequest;
            if (bindRequest2 != null) {
                bindRequest = bindRequest2.getRebindRequest(this.reconnectAddress, this.reconnectPort);
                if (bindRequest == null) {
                    throw new LDAPException(ResultCode.SERVER_DOWN, LDAPMessages.ERR_CONN_CANNOT_REAUTHENTICATE.get(getHostPort()));
                }
            } else {
                bindRequest = null;
            }
            setDisconnectInfo(DisconnectType.RECONNECT, (String) null, (Throwable) null);
            terminate((Control[]) null);
            try {
                Thread.sleep(10);
            } catch (Exception unused) {
            }
            connect(this.reconnectAddress, this.reconnectPort);
            if (bindRequest != null) {
                try {
                    bind(bindRequest);
                } catch (LDAPException e) {
                    Debug.debugException(e);
                    setDisconnectInfo(DisconnectType.BIND_FAILED, (String) null, e);
                    terminate((Control[]) null);
                    throw e;
                }
            }
            this.lastReconnectTime = System.currentTimeMillis();
            return;
        }
        throw new LDAPException(ResultCode.SERVER_DOWN, LDAPMessages.ERR_CONN_MULTIPLE_FAILURES.get());
    }

    /* access modifiers changed from: package-private */
    public void registerResponseAcceptor(int i, ResponseAcceptor responseAcceptor) {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals != null) {
            lDAPConnectionInternals.registerResponseAcceptor(i, responseAcceptor);
            return;
        }
        throw new LDAPException(ResultCode.SERVER_DOWN, LDAPMessages.ERR_CONN_NOT_ESTABLISHED.get());
    }

    public SearchResult search(ReadOnlySearchRequest readOnlySearchRequest) {
        return search((SearchRequest) readOnlySearchRequest);
    }

    public SearchResult search(SearchRequest searchRequest) {
        Validator.ensureNotNull(searchRequest);
        try {
            SearchResult process = searchRequest.process(this, 1);
            if (process.getResultCode().equals(ResultCode.SUCCESS)) {
                return process;
            }
            throw new LDAPSearchException(process);
        } catch (LDAPSearchException e) {
            Debug.debugException(e);
            throw e;
        } catch (LDAPException e2) {
            Debug.debugException(e2);
            throw new LDAPSearchException(e2);
        }
    }

    public SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, Filter filter, String... strArr) {
        Filter filter2 = filter;
        Validator.ensureNotNull(str, filter2);
        return search(new SearchRequest(searchResultListener, str, searchScope, dereferencePolicy, i, i2, z, filter2, strArr));
    }

    public SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, String str2, String... strArr) {
        String str3 = str;
        Validator.ensureNotNull(str, str2);
        try {
            try {
                return search(new SearchRequest(searchResultListener, str, searchScope, dereferencePolicy, i, i2, z, str2, strArr));
            } catch (LDAPSearchException e) {
                e = e;
                Debug.debugException(e);
                throw e;
            } catch (LDAPException e2) {
                e = e2;
                Debug.debugException(e);
                throw new LDAPSearchException(e);
            }
        } catch (LDAPSearchException e3) {
            e = e3;
            Debug.debugException(e);
            throw e;
        } catch (LDAPException e4) {
            e = e4;
            Debug.debugException(e);
            throw new LDAPSearchException(e);
        }
    }

    public SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, Filter filter, String... strArr) {
        Validator.ensureNotNull(str, filter);
        try {
            return search(new SearchRequest(searchResultListener, str, searchScope, filter, strArr));
        } catch (LDAPSearchException e) {
            Debug.debugException(e);
            throw e;
        } catch (LDAPException e2) {
            Debug.debugException(e2);
            throw new LDAPSearchException(e2);
        }
    }

    public SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, String str2, String... strArr) {
        Validator.ensureNotNull(str, str2);
        try {
            return search(new SearchRequest(searchResultListener, str, searchScope, str2, strArr));
        } catch (LDAPSearchException e) {
            Debug.debugException(e);
            throw e;
        } catch (LDAPException e2) {
            Debug.debugException(e2);
            throw new LDAPSearchException(e2);
        }
    }

    public SearchResult search(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, Filter filter, String... strArr) {
        Filter filter2 = filter;
        Validator.ensureNotNull(str, filter2);
        return search(new SearchRequest(str, searchScope, dereferencePolicy, i, i2, z, filter2, strArr));
    }

    public SearchResult search(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, String str2, String... strArr) {
        String str3 = str;
        Validator.ensureNotNull(str, str2);
        try {
            try {
                return search(new SearchRequest(str, searchScope, dereferencePolicy, i, i2, z, str2, strArr));
            } catch (LDAPSearchException e) {
                e = e;
                Debug.debugException(e);
                throw e;
            } catch (LDAPException e2) {
                e = e2;
                Debug.debugException(e);
                throw new LDAPSearchException(e);
            }
        } catch (LDAPSearchException e3) {
            e = e3;
            Debug.debugException(e);
            throw e;
        } catch (LDAPException e4) {
            e = e4;
            Debug.debugException(e);
            throw new LDAPSearchException(e);
        }
    }

    public SearchResult search(String str, SearchScope searchScope, Filter filter, String... strArr) {
        Validator.ensureNotNull(str, filter);
        return search(new SearchRequest(str, searchScope, filter, strArr));
    }

    public SearchResult search(String str, SearchScope searchScope, String str2, String... strArr) {
        Validator.ensureNotNull(str, str2);
        try {
            return search(new SearchRequest(str, searchScope, str2, strArr));
        } catch (LDAPSearchException e) {
            Debug.debugException(e);
            throw e;
        } catch (LDAPException e2) {
            Debug.debugException(e2);
            throw new LDAPSearchException(e2);
        }
    }

    public SearchResultEntry searchForEntry(ReadOnlySearchRequest readOnlySearchRequest) {
        return searchForEntry((SearchRequest) readOnlySearchRequest);
    }

    public SearchResultEntry searchForEntry(SearchRequest searchRequest) {
        if (!(searchRequest.getSearchResultListener() == null && searchRequest.getSizeLimit() == 1)) {
            SearchRequest searchRequest2 = new SearchRequest(searchRequest.getBaseDN(), searchRequest.getScope(), searchRequest.getDereferencePolicy(), 1, searchRequest.getTimeLimitSeconds(), searchRequest.typesOnly(), searchRequest.getFilter(), searchRequest.getAttributes());
            searchRequest2.setFollowReferrals(searchRequest.followReferralsInternal());
            searchRequest2.setResponseTimeoutMillis(searchRequest.getResponseTimeoutMillis((LDAPConnection) null));
            if (searchRequest.hasControl()) {
                searchRequest2.setControlsInternal(searchRequest.getControls());
            }
            searchRequest = searchRequest2;
        }
        try {
            SearchResult search = search(searchRequest);
            if (search.getEntryCount() == 0) {
                return null;
            }
            return search.getSearchEntries().get(0);
        } catch (LDAPSearchException e) {
            Debug.debugException(e);
            if (e.getResultCode() == ResultCode.NO_SUCH_OBJECT) {
                return null;
            }
            throw e;
        }
    }

    public SearchResultEntry searchForEntry(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, boolean z, Filter filter, String... strArr) {
        return searchForEntry(new SearchRequest(str, searchScope, dereferencePolicy, 1, i, z, filter, strArr));
    }

    public SearchResultEntry searchForEntry(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, boolean z, String str2, String... strArr) {
        try {
            return searchForEntry(new SearchRequest(str, searchScope, dereferencePolicy, 1, i, z, str2, strArr));
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw new LDAPSearchException(e);
        }
    }

    public SearchResultEntry searchForEntry(String str, SearchScope searchScope, Filter filter, String... strArr) {
        return searchForEntry(new SearchRequest(str, searchScope, DereferencePolicy.NEVER, 1, 0, false, filter, strArr));
    }

    public SearchResultEntry searchForEntry(String str, SearchScope searchScope, String str2, String... strArr) {
        try {
            return searchForEntry(new SearchRequest(str, searchScope, DereferencePolicy.NEVER, 1, 0, false, str2, strArr));
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw new LDAPSearchException(e);
        }
    }

    /* access modifiers changed from: package-private */
    public void sendMessage(LDAPMessage lDAPMessage) {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals != null) {
            lDAPConnectionInternals.sendMessage(lDAPMessage);
            return;
        }
        throw new LDAPException(ResultCode.SERVER_DOWN, LDAPMessages.ERR_CONN_NOT_ESTABLISHED.get());
    }

    /* access modifiers changed from: package-private */
    public void setClosed() {
        this.connectionStatistics.incrementNumDisconnects();
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals != null) {
            lDAPConnectionInternals.close();
            this.connectionInternals = null;
        }
        this.cachedSchema = null;
        Timer timer2 = this.timer;
        if (timer2 != null) {
            timer2.cancel();
            this.timer = null;
        }
    }

    /* access modifiers changed from: package-private */
    public void setConnectStackTrace(StackTraceElement[] stackTraceElementArr) {
        this.connectStackTrace = stackTraceElementArr;
    }

    public void setConnectionName(String str) {
        if (this.connectionPool == null) {
            this.connectionName = str;
            if (this.connectionInternals != null) {
                this.connectionInternals.getConnectionReader().updateThreadName();
            }
        }
    }

    public void setConnectionOptions(LDAPConnectionOptions lDAPConnectionOptions) {
        if (lDAPConnectionOptions == null) {
            this.connectionOptions = new LDAPConnectionOptions();
            return;
        }
        LDAPConnectionOptions duplicate = lDAPConnectionOptions.duplicate();
        if (Debug.debugEnabled(DebugType.LDAP) && duplicate.useSynchronousMode() && !lDAPConnectionOptions.useSynchronousMode() && isConnected()) {
            Debug.debug(Level.WARNING, DebugType.LDAP, "A call to LDAPConnection.setConnectionOptions() with useSynchronousMode=true will have no effect for this connection because it is already established.  The useSynchronousMode option must be set before the connection is established to have any effect.");
        }
        this.connectionOptions = duplicate;
    }

    /* access modifiers changed from: package-private */
    public void setConnectionPool(AbstractConnectionPool abstractConnectionPool) {
        this.connectionPool = abstractConnectionPool;
    }

    /* access modifiers changed from: package-private */
    public void setConnectionPoolName(String str) {
        this.connectionPoolName = str;
        if (this.connectionInternals != null) {
            this.connectionInternals.getConnectionReader().updateThreadName();
        }
    }

    public synchronized void setDisconnectInfo(DisconnectType disconnectType2, String str, Throwable th) {
        Validator.ensureNotNull(disconnectType2);
        if (this.disconnectType == null) {
            this.disconnectType = disconnectType2;
            this.disconnectMessage = str;
            this.disconnectCause = th;
        }
    }

    public void setReferralConnector(ReferralConnector referralConnector2) {
        if (referralConnector2 == null) {
            this.referralConnector = this;
        } else {
            this.referralConnector = referralConnector2;
        }
    }

    public void setSocketFactory(SocketFactory socketFactory2) {
        if (socketFactory2 == null) {
            socketFactory2 = DEFAULT_SOCKET_FACTORY;
        }
        this.socketFactory = socketFactory2;
    }

    public boolean synchronousMode() {
        LDAPConnectionInternals lDAPConnectionInternals = this.connectionInternals;
        if (lDAPConnectionInternals == null) {
            return false;
        }
        return lDAPConnectionInternals.synchronousMode();
    }

    /* access modifiers changed from: package-private */
    public void terminate(Control[] controlArr) {
        if (isConnected() && !this.unbindRequestSent) {
            try {
                this.unbindRequestSent = true;
                if (Debug.debugEnabled(DebugType.LDAP)) {
                    Debug.debug(Level.INFO, DebugType.LDAP, "Sending LDAP unbind request.");
                }
                this.connectionStatistics.incrementNumUnbindRequests();
                sendMessage(new LDAPMessage(nextMessageID(), (ProtocolOp) new UnbindRequestProtocolOp(), controlArr));
            } catch (Exception e) {
                Debug.debugException(e);
            }
        }
        setClosed();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    /* JADX WARNING: Removed duplicated region for block: B:10:0x002e  */
    /* JADX WARNING: Removed duplicated region for block: B:11:0x0047  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void toString(java.lang.StringBuilder r3) {
        /*
            r2 = this;
            java.lang.String r0 = "LDAPConnection("
            r3.append(r0)
            java.lang.String r0 = r2.connectionName
            java.lang.String r1 = r2.connectionPoolName
            if (r0 == 0) goto L_0x0019
            java.lang.String r1 = "name='"
            r3.append(r1)
            r3.append(r0)
        L_0x0013:
            java.lang.String r0 = "', "
            r3.append(r0)
            goto L_0x0024
        L_0x0019:
            if (r1 == 0) goto L_0x0024
            java.lang.String r0 = "poolName='"
            r3.append(r0)
            r3.append(r1)
            goto L_0x0013
        L_0x0024:
            com.unboundid.ldap.sdk.LDAPConnectionInternals r0 = r2.connectionInternals
            if (r0 == 0) goto L_0x0047
            boolean r1 = r0.isConnected()
            if (r1 == 0) goto L_0x0047
            java.lang.String r1 = "connected to "
            r3.append(r1)
            java.lang.String r1 = r0.getHost()
            r3.append(r1)
            r1 = 58
            r3.append(r1)
            int r0 = r0.getPort()
            r3.append(r0)
            goto L_0x004c
        L_0x0047:
            java.lang.String r0 = "not connected"
            r3.append(r0)
        L_0x004c:
            r0 = 41
            r3.append(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.LDAPConnection.toString(java.lang.StringBuilder):void");
    }

    /* access modifiers changed from: package-private */
    public boolean unbindRequestSent() {
        return this.unbindRequestSent;
    }
}
