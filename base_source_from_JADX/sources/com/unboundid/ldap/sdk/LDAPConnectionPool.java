package com.unboundid.ldap.sdk;

import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public final class LDAPConnectionPool extends AbstractConnectionPool {
    private static final long DEFAULT_HEALTH_CHECK_INTERVAL = 60000;
    private final LinkedBlockingQueue<LDAPConnection> availableConnections;
    private final BindRequest bindRequest;
    private volatile boolean closed;
    private String connectionPoolName;
    private boolean createIfNecessary;
    private final AtomicInteger failedReplaceCount;
    private LDAPConnectionPoolHealthCheck healthCheck;
    private volatile long healthCheckInterval;
    private final LDAPConnectionPoolHealthCheckThread healthCheckThread;
    private volatile long lastExpiredDisconnectTime;
    private volatile long maxConnectionAge;
    private long maxWaitTime;
    private volatile long minDisconnectInterval;
    private final int numConnections;
    private final LDAPConnectionPoolStatistics poolStatistics;
    private final PostConnectProcessor postConnectProcessor;
    private final AtomicReference<Set<OperationType>> retryOperationTypes;
    private final ServerSet serverSet;
    private volatile boolean trySynchronousReadDuringHealthCheck;

    public LDAPConnectionPool(LDAPConnection lDAPConnection, int i) {
        this(lDAPConnection, 1, i, (PostConnectProcessor) null);
    }

    public LDAPConnectionPool(LDAPConnection lDAPConnection, int i, int i2) {
        this(lDAPConnection, i, i2, (PostConnectProcessor) null);
    }

    public LDAPConnectionPool(LDAPConnection lDAPConnection, int i, int i2, PostConnectProcessor postConnectProcessor2) {
        Validator.ensureNotNull(lDAPConnection);
        Validator.ensureTrue(i >= 1, "LDAPConnectionPool.initialConnections must be at least 1.");
        Validator.ensureTrue(i2 >= i, "LDAPConnectionPool.initialConnections must not be greater than maxConnections.");
        this.postConnectProcessor = postConnectProcessor2;
        this.trySynchronousReadDuringHealthCheck = true;
        this.healthCheck = new LDAPConnectionPoolHealthCheck();
        this.healthCheckInterval = DEFAULT_HEALTH_CHECK_INTERVAL;
        this.poolStatistics = new LDAPConnectionPoolStatistics(this);
        this.connectionPoolName = null;
        this.retryOperationTypes = new AtomicReference<>(Collections.unmodifiableSet(EnumSet.noneOf(OperationType.class)));
        if (lDAPConnection.isConnected()) {
            this.serverSet = new SingleServerSet(lDAPConnection.getConnectedAddress(), lDAPConnection.getConnectedPort(), lDAPConnection.getLastUsedSocketFactory(), lDAPConnection.getConnectionOptions());
            this.bindRequest = lDAPConnection.getLastBindRequest();
            ArrayList arrayList = new ArrayList(i);
            lDAPConnection.setConnectionName((String) null);
            lDAPConnection.setConnectionPool(this);
            arrayList.add(lDAPConnection);
            int i3 = 1;
            while (i3 < i) {
                try {
                    arrayList.add(createConnection());
                    i3++;
                } catch (LDAPException e) {
                    Debug.debugException(e);
                    Iterator it = arrayList.iterator();
                    while (it.hasNext()) {
                        LDAPConnection lDAPConnection2 = (LDAPConnection) it.next();
                        try {
                            lDAPConnection2.setDisconnectInfo(DisconnectType.POOL_CREATION_FAILURE, (String) null, e);
                            lDAPConnection2.terminate((Control[]) null);
                        } catch (Exception e2) {
                            Debug.debugException(e2);
                        }
                    }
                    throw e;
                }
            }
            this.numConnections = i2;
            this.availableConnections = new LinkedBlockingQueue<>(this.numConnections);
            this.availableConnections.addAll(arrayList);
            this.failedReplaceCount = new AtomicInteger(i2 - i);
            this.createIfNecessary = true;
            this.maxConnectionAge = 0;
            this.minDisconnectInterval = 0;
            this.lastExpiredDisconnectTime = 0;
            this.maxWaitTime = 5000;
            this.closed = false;
            this.healthCheckThread = new LDAPConnectionPoolHealthCheckThread(this);
            this.healthCheckThread.start();
            return;
        }
        throw new LDAPException(ResultCode.PARAM_ERROR, LDAPMessages.ERR_POOL_CONN_NOT_ESTABLISHED.get());
    }

    public LDAPConnectionPool(ServerSet serverSet2, BindRequest bindRequest2, int i) {
        this(serverSet2, bindRequest2, 1, i, (PostConnectProcessor) null);
    }

    public LDAPConnectionPool(ServerSet serverSet2, BindRequest bindRequest2, int i, int i2) {
        this(serverSet2, bindRequest2, i, i2, (PostConnectProcessor) null);
    }

    public LDAPConnectionPool(ServerSet serverSet2, BindRequest bindRequest2, int i, int i2, PostConnectProcessor postConnectProcessor2) {
        Validator.ensureNotNull(serverSet2);
        Validator.ensureTrue(i >= 0, "LDAPConnectionPool.initialConnections must be greater than or equal to 0.");
        Validator.ensureTrue(i2 > 0, "LDAPConnectionPool.maxConnections must be greater than 0.");
        Validator.ensureTrue(i2 >= i, "LDAPConnectionPool.initialConnections must not be greater than maxConnections.");
        this.serverSet = serverSet2;
        this.bindRequest = bindRequest2;
        this.postConnectProcessor = postConnectProcessor2;
        this.healthCheck = new LDAPConnectionPoolHealthCheck();
        this.healthCheckInterval = DEFAULT_HEALTH_CHECK_INTERVAL;
        this.poolStatistics = new LDAPConnectionPoolStatistics(this);
        this.connectionPoolName = null;
        this.retryOperationTypes = new AtomicReference<>(Collections.unmodifiableSet(EnumSet.noneOf(OperationType.class)));
        ArrayList arrayList = new ArrayList(i);
        int i3 = 0;
        while (i3 < i) {
            try {
                arrayList.add(createConnection());
                i3++;
            } catch (LDAPException e) {
                Debug.debugException(e);
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    LDAPConnection lDAPConnection = (LDAPConnection) it.next();
                    try {
                        lDAPConnection.setDisconnectInfo(DisconnectType.POOL_CREATION_FAILURE, (String) null, e);
                        lDAPConnection.terminate((Control[]) null);
                    } catch (Exception e2) {
                        Debug.debugException(e2);
                    }
                }
                throw e;
            }
        }
        this.numConnections = i2;
        this.availableConnections = new LinkedBlockingQueue<>(this.numConnections);
        this.availableConnections.addAll(arrayList);
        this.failedReplaceCount = new AtomicInteger(i2 - i);
        this.createIfNecessary = true;
        this.maxConnectionAge = 0;
        this.minDisconnectInterval = 0;
        this.lastExpiredDisconnectTime = 0;
        this.maxWaitTime = 5000;
        this.closed = false;
        this.healthCheckThread = new LDAPConnectionPoolHealthCheckThread(this);
        this.healthCheckThread.start();
    }

    private boolean connectionIsExpired(LDAPConnection lDAPConnection) {
        if (this.maxConnectionAge <= 0) {
            return false;
        }
        long currentTimeMillis = System.currentTimeMillis();
        return currentTimeMillis - this.lastExpiredDisconnectTime >= this.minDisconnectInterval && currentTimeMillis - lDAPConnection.getConnectTime() > this.maxConnectionAge;
    }

    private LDAPConnection createConnection() {
        LDAPConnection connection = this.serverSet.getConnection(this.healthCheck);
        connection.setConnectionPool(this);
        LDAPConnectionOptions connectionOptions = connection.getConnectionOptions();
        if (connectionOptions.autoReconnect()) {
            LDAPConnectionOptions duplicate = connectionOptions.duplicate();
            duplicate.setAutoReconnect(false);
            connection.setConnectionOptions(duplicate);
        }
        PostConnectProcessor postConnectProcessor2 = this.postConnectProcessor;
        if (postConnectProcessor2 != null) {
            try {
                postConnectProcessor2.processPreAuthenticatedConnection(connection);
            } catch (Exception e) {
                Debug.debugException(e);
                try {
                    this.poolStatistics.incrementNumFailedConnectionAttempts();
                    connection.setDisconnectInfo(DisconnectType.POOL_CREATION_FAILURE, (String) null, e);
                    connection.terminate((Control[]) null);
                } catch (Exception e2) {
                    Debug.debugException(e2);
                }
                if (e instanceof LDAPException) {
                    throw ((LDAPException) e);
                }
                throw new LDAPException(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_POOL_POST_CONNECT_ERROR.get(StaticUtils.getExceptionMessage(e)), e);
            }
        }
        try {
            if (this.bindRequest != null) {
                connection.bind(this.bindRequest.duplicate());
            }
            PostConnectProcessor postConnectProcessor3 = this.postConnectProcessor;
            if (postConnectProcessor3 != null) {
                try {
                    postConnectProcessor3.processPostAuthenticatedConnection(connection);
                } catch (Exception e3) {
                    Debug.debugException(e3);
                    try {
                        this.poolStatistics.incrementNumFailedConnectionAttempts();
                        connection.setDisconnectInfo(DisconnectType.POOL_CREATION_FAILURE, (String) null, e3);
                        connection.terminate((Control[]) null);
                    } catch (Exception e4) {
                        Debug.debugException(e4);
                    }
                    if (e3 instanceof LDAPException) {
                        throw ((LDAPException) e3);
                    }
                    throw new LDAPException(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_POOL_POST_CONNECT_ERROR.get(StaticUtils.getExceptionMessage(e3)), e3);
                }
            }
            connection.setConnectionPoolName(this.connectionPoolName);
            this.poolStatistics.incrementNumSuccessfulConnectionAttempts();
            return connection;
        } catch (Exception e5) {
            Debug.debugException(e5);
            try {
                this.poolStatistics.incrementNumFailedConnectionAttempts();
                connection.setDisconnectInfo(DisconnectType.BIND_FAILED, (String) null, e5);
                connection.terminate((Control[]) null);
            } catch (Exception e6) {
                Debug.debugException(e6);
            }
            if (e5 instanceof LDAPException) {
                throw ((LDAPException) e5);
            }
            throw new LDAPException(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_POOL_CONNECT_ERROR.get(StaticUtils.getExceptionMessage(e5)), e5);
        }
    }

    private LDAPConnection handleDefunctConnection(LDAPConnection lDAPConnection) {
        lDAPConnection.setDisconnectInfo(DisconnectType.POOLED_CONNECTION_DEFUNCT, (String) null, (Throwable) null);
        lDAPConnection.terminate((Control[]) null);
        if (this.closed) {
            return null;
        }
        if (this.createIfNecessary && this.availableConnections.remainingCapacity() <= 0) {
            return null;
        }
        try {
            LDAPConnection createConnection = createConnection();
            if (this.availableConnections.offer(createConnection)) {
                return createConnection;
            }
            createConnection.setDisconnectInfo(DisconnectType.POOLED_CONNECTION_UNNEEDED, (String) null, (Throwable) null);
            createConnection.terminate((Control[]) null);
            return null;
        } catch (LDAPException e) {
            Debug.debugException(e);
            this.failedReplaceCount.incrementAndGet();
            return null;
        }
    }

    public void close() {
        this.closed = true;
        this.healthCheckThread.stopRunning();
        while (true) {
            LDAPConnection poll = this.availableConnections.poll();
            if (poll != null) {
                this.poolStatistics.incrementNumConnectionsClosedUnneeded();
                poll.setDisconnectInfo(DisconnectType.POOL_CLOSED, (String) null, (Throwable) null);
                poll.terminate((Control[]) null);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0212 A[SYNTHETIC, Splitter:B:108:0x0212] */
    /* JADX WARNING: Removed duplicated region for block: B:117:0x023a A[Catch:{ Exception -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:118:0x023e A[Catch:{ Exception -> 0x024c }] */
    /* JADX WARNING: Removed duplicated region for block: B:125:0x022c A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:136:0x0258 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:78:0x0183 A[Catch:{ all -> 0x0153 }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0188 A[SYNTHETIC, Splitter:B:80:0x0188] */
    /* JADX WARNING: Removed duplicated region for block: B:90:0x01ae A[Catch:{ all -> 0x0153 }] */
    /* JADX WARNING: Removed duplicated region for block: B:97:0x01d0 A[SYNTHETIC, Splitter:B:97:0x01d0] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void doHealthCheck() {
        /*
            r13 = this;
            java.util.HashSet r0 = new java.util.HashSet
            int r1 = r13.numConnections
            r0.<init>(r1)
            r1 = 0
            r2 = 0
        L_0x0009:
            int r3 = r13.numConnections
            if (r2 >= r3) goto L_0x025c
            java.util.concurrent.LinkedBlockingQueue<com.unboundid.ldap.sdk.LDAPConnection> r3 = r13.availableConnections
            java.lang.Object r3 = r3.poll()
            com.unboundid.ldap.sdk.LDAPConnection r3 = (com.unboundid.ldap.sdk.LDAPConnection) r3
            if (r3 != 0) goto L_0x0019
            goto L_0x025c
        L_0x0019:
            boolean r4 = r0.contains(r3)
            r5 = 0
            if (r4 == 0) goto L_0x0037
            java.util.concurrent.LinkedBlockingQueue<com.unboundid.ldap.sdk.LDAPConnection> r0 = r13.availableConnections
            boolean r0 = r0.offer(r3)
            if (r0 != 0) goto L_0x025c
            com.unboundid.ldap.sdk.DisconnectType r0 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_UNNEEDED
            r3.setDisconnectInfo(r0, r5, r5)
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r0 = r13.poolStatistics
            r0.incrementNumConnectionsClosedUnneeded()
            r3.terminate(r5)
            goto L_0x025c
        L_0x0037:
            boolean r4 = r3.isConnected()
            if (r4 != 0) goto L_0x0048
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)
            if (r3 == 0) goto L_0x0258
        L_0x0043:
            r0.add(r3)
            goto L_0x0258
        L_0x0048:
            boolean r4 = r13.connectionIsExpired(r3)
            if (r4 == 0) goto L_0x0084
            com.unboundid.ldap.sdk.LDAPConnection r4 = r13.createConnection()     // Catch:{ LDAPException -> 0x0080 }
            java.util.concurrent.LinkedBlockingQueue<com.unboundid.ldap.sdk.LDAPConnection> r6 = r13.availableConnections     // Catch:{ LDAPException -> 0x0080 }
            boolean r6 = r6.offer(r4)     // Catch:{ LDAPException -> 0x0080 }
            if (r6 == 0) goto L_0x0072
            r0.add(r4)     // Catch:{ LDAPException -> 0x0080 }
            com.unboundid.ldap.sdk.DisconnectType r4 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_EXPIRED     // Catch:{ LDAPException -> 0x0080 }
            r3.setDisconnectInfo(r4, r5, r5)     // Catch:{ LDAPException -> 0x0080 }
            r3.terminate(r5)     // Catch:{ LDAPException -> 0x0080 }
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r4 = r13.poolStatistics     // Catch:{ LDAPException -> 0x0080 }
            r4.incrementNumConnectionsClosedExpired()     // Catch:{ LDAPException -> 0x0080 }
            long r6 = java.lang.System.currentTimeMillis()     // Catch:{ LDAPException -> 0x0080 }
            r13.lastExpiredDisconnectTime = r6     // Catch:{ LDAPException -> 0x0080 }
            goto L_0x0258
        L_0x0072:
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_UNNEEDED     // Catch:{ LDAPException -> 0x0080 }
            r4.setDisconnectInfo(r6, r5, r5)     // Catch:{ LDAPException -> 0x0080 }
            r4.terminate(r5)     // Catch:{ LDAPException -> 0x0080 }
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r4 = r13.poolStatistics     // Catch:{ LDAPException -> 0x0080 }
            r4.incrementNumConnectionsClosedUnneeded()     // Catch:{ LDAPException -> 0x0080 }
            goto L_0x0084
        L_0x0080:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)
        L_0x0084:
            boolean r4 = r13.trySynchronousReadDuringHealthCheck
            if (r4 == 0) goto L_0x022d
            boolean r4 = r3.synchronousMode()
            if (r4 == 0) goto L_0x022d
            com.unboundid.ldap.sdk.LDAPConnectionInternals r4 = r3.getConnectionInternals()
            java.net.Socket r4 = r4.getSocket()
            r6 = 1
            r7 = -2147483648(0xffffffff80000000, float:-0.0)
            int r8 = r4.getSoTimeout()     // Catch:{ LDAPException -> 0x01a3, Exception -> 0x015f, all -> 0x015a }
            r4.setSoTimeout(r6)     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            com.unboundid.ldap.protocol.LDAPResponse r9 = r3.readResponse(r1)     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            boolean r10 = r9 instanceof com.unboundid.ldap.sdk.ConnectionClosedResponse     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            if (r10 == 0) goto L_0x00de
            com.unboundid.ldap.sdk.DisconnectType r9 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            com.unboundid.ldap.sdk.LDAPMessages r10 = com.unboundid.ldap.sdk.LDAPMessages.ERR_POOL_HEALTH_CHECK_CONN_CLOSED     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            java.lang.String r10 = r10.get()     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            r3.setDisconnectInfo(r9, r10, r5)     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r9 = r13.poolStatistics     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            r9.incrementNumConnectionsClosedDefunct()     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            if (r3 == 0) goto L_0x00c1
            r0.add(r3)     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
        L_0x00c1:
            if (r8 == r7) goto L_0x0258
            r4.setSoTimeout(r8)     // Catch:{ Exception -> 0x00c8 }
            goto L_0x0258
        L_0x00c8:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT
            r3.setDisconnectInfo(r6, r5, r4)
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r4 = r13.poolStatistics
            r4.incrementNumConnectionsClosedDefunct()
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)
            if (r3 == 0) goto L_0x0258
            goto L_0x0043
        L_0x00de:
            boolean r10 = r9 instanceof com.unboundid.ldap.sdk.ExtendedResult     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            if (r10 == 0) goto L_0x00f2
            com.unboundid.ldap.sdk.LDAPConnectionOptions r10 = r3.getConnectionOptions()     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            com.unboundid.ldap.sdk.UnsolicitedNotificationHandler r10 = r10.getUnsolicitedNotificationHandler()     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            if (r10 == 0) goto L_0x0136
            com.unboundid.ldap.sdk.ExtendedResult r9 = (com.unboundid.ldap.sdk.ExtendedResult) r9     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            r10.handleUnsolicitedNotification(r3, r9)     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            goto L_0x0136
        L_0x00f2:
            boolean r10 = r9 instanceof com.unboundid.ldap.sdk.LDAPResult     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            if (r10 == 0) goto L_0x0136
            com.unboundid.ldap.sdk.LDAPResult r9 = (com.unboundid.ldap.sdk.LDAPResult) r9     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            com.unboundid.ldap.sdk.ResultCode r9 = r9.getResultCode()     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            com.unboundid.ldap.sdk.ResultCode r10 = com.unboundid.ldap.sdk.ResultCode.SERVER_DOWN     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            if (r9 != r10) goto L_0x0136
            com.unboundid.ldap.sdk.DisconnectType r9 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            com.unboundid.ldap.sdk.LDAPMessages r10 = com.unboundid.ldap.sdk.LDAPMessages.ERR_POOL_HEALTH_CHECK_CONN_CLOSED     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            java.lang.String r10 = r10.get()     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            r3.setDisconnectInfo(r9, r10, r5)     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r9 = r13.poolStatistics     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            r9.incrementNumConnectionsClosedDefunct()     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
            if (r3 == 0) goto L_0x0119
            r0.add(r3)     // Catch:{ LDAPException -> 0x0158, Exception -> 0x0156 }
        L_0x0119:
            if (r8 == r7) goto L_0x0258
            r4.setSoTimeout(r8)     // Catch:{ Exception -> 0x0120 }
            goto L_0x0258
        L_0x0120:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT
            r3.setDisconnectInfo(r6, r5, r4)
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r4 = r13.poolStatistics
            r4.incrementNumConnectionsClosedDefunct()
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)
            if (r3 == 0) goto L_0x0258
            goto L_0x0043
        L_0x0136:
            if (r8 == r7) goto L_0x022d
            r4.setSoTimeout(r8)     // Catch:{ Exception -> 0x013d }
            goto L_0x022d
        L_0x013d:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT
            r3.setDisconnectInfo(r6, r5, r4)
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r4 = r13.poolStatistics
            r4.incrementNumConnectionsClosedDefunct()
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)
            if (r3 == 0) goto L_0x0258
            goto L_0x0043
        L_0x0153:
            r6 = move-exception
            goto L_0x0210
        L_0x0156:
            r9 = move-exception
            goto L_0x0162
        L_0x0158:
            r9 = move-exception
            goto L_0x01a6
        L_0x015a:
            r6 = move-exception
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x0210
        L_0x015f:
            r9 = move-exception
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x0162:
            com.unboundid.util.Debug.debugException(r9)     // Catch:{ all -> 0x0153 }
            com.unboundid.ldap.sdk.DisconnectType r10 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT     // Catch:{ all -> 0x0153 }
            com.unboundid.ldap.sdk.LDAPMessages r11 = com.unboundid.ldap.sdk.LDAPMessages.ERR_POOL_HEALTH_CHECK_READ_FAILURE     // Catch:{ all -> 0x0153 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0153 }
            java.lang.String r12 = com.unboundid.util.StaticUtils.getExceptionMessage(r9)     // Catch:{ all -> 0x0153 }
            r6[r1] = r12     // Catch:{ all -> 0x0153 }
            java.lang.String r6 = r11.get(r6)     // Catch:{ all -> 0x0153 }
            r3.setDisconnectInfo(r10, r6, r9)     // Catch:{ all -> 0x0153 }
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r6 = r13.poolStatistics     // Catch:{ all -> 0x0153 }
            r6.incrementNumConnectionsClosedDefunct()     // Catch:{ all -> 0x0153 }
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)     // Catch:{ all -> 0x0153 }
            if (r3 == 0) goto L_0x0186
            r0.add(r3)     // Catch:{ all -> 0x0153 }
        L_0x0186:
            if (r8 == r7) goto L_0x0258
            r4.setSoTimeout(r8)     // Catch:{ Exception -> 0x018d }
            goto L_0x0258
        L_0x018d:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT
            r3.setDisconnectInfo(r6, r5, r4)
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r4 = r13.poolStatistics
            r4.incrementNumConnectionsClosedDefunct()
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)
            if (r3 == 0) goto L_0x0258
            goto L_0x0043
        L_0x01a3:
            r9 = move-exception
            r8 = -2147483648(0xffffffff80000000, float:-0.0)
        L_0x01a6:
            com.unboundid.ldap.sdk.ResultCode r10 = r9.getResultCode()     // Catch:{ all -> 0x0153 }
            com.unboundid.ldap.sdk.ResultCode r11 = com.unboundid.ldap.sdk.ResultCode.TIMEOUT     // Catch:{ all -> 0x0153 }
            if (r10 != r11) goto L_0x01d0
            java.util.logging.Level r6 = java.util.logging.Level.FINEST     // Catch:{ all -> 0x0153 }
            com.unboundid.util.Debug.debugException(r6, r9)     // Catch:{ all -> 0x0153 }
            if (r8 == r7) goto L_0x022d
            r4.setSoTimeout(r8)     // Catch:{ Exception -> 0x01ba }
            goto L_0x022d
        L_0x01ba:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT
            r3.setDisconnectInfo(r6, r5, r4)
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r4 = r13.poolStatistics
            r4.incrementNumConnectionsClosedDefunct()
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)
            if (r3 == 0) goto L_0x0258
            goto L_0x0043
        L_0x01d0:
            com.unboundid.util.Debug.debugException(r9)     // Catch:{ all -> 0x0153 }
            com.unboundid.ldap.sdk.DisconnectType r10 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT     // Catch:{ all -> 0x0153 }
            com.unboundid.ldap.sdk.LDAPMessages r11 = com.unboundid.ldap.sdk.LDAPMessages.ERR_POOL_HEALTH_CHECK_READ_FAILURE     // Catch:{ all -> 0x0153 }
            java.lang.Object[] r6 = new java.lang.Object[r6]     // Catch:{ all -> 0x0153 }
            java.lang.String r12 = com.unboundid.util.StaticUtils.getExceptionMessage(r9)     // Catch:{ all -> 0x0153 }
            r6[r1] = r12     // Catch:{ all -> 0x0153 }
            java.lang.String r6 = r11.get(r6)     // Catch:{ all -> 0x0153 }
            r3.setDisconnectInfo(r10, r6, r9)     // Catch:{ all -> 0x0153 }
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r6 = r13.poolStatistics     // Catch:{ all -> 0x0153 }
            r6.incrementNumConnectionsClosedDefunct()     // Catch:{ all -> 0x0153 }
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)     // Catch:{ all -> 0x0153 }
            if (r3 == 0) goto L_0x01f4
            r0.add(r3)     // Catch:{ all -> 0x0153 }
        L_0x01f4:
            if (r8 == r7) goto L_0x0258
            r4.setSoTimeout(r8)     // Catch:{ Exception -> 0x01fa }
            goto L_0x0258
        L_0x01fa:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT
            r3.setDisconnectInfo(r6, r5, r4)
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r4 = r13.poolStatistics
            r4.incrementNumConnectionsClosedDefunct()
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)
            if (r3 == 0) goto L_0x0258
            goto L_0x0043
        L_0x0210:
            if (r8 == r7) goto L_0x022c
            r4.setSoTimeout(r8)     // Catch:{ Exception -> 0x0216 }
            goto L_0x022c
        L_0x0216:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)
            com.unboundid.ldap.sdk.DisconnectType r6 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_DEFUNCT
            r3.setDisconnectInfo(r6, r5, r4)
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r4 = r13.poolStatistics
            r4.incrementNumConnectionsClosedDefunct()
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)
            if (r3 == 0) goto L_0x0258
            goto L_0x0043
        L_0x022c:
            throw r6
        L_0x022d:
            com.unboundid.ldap.sdk.LDAPConnectionPoolHealthCheck r4 = r13.healthCheck     // Catch:{ Exception -> 0x024c }
            r4.ensureConnectionValidForContinuedUse(r3)     // Catch:{ Exception -> 0x024c }
            java.util.concurrent.LinkedBlockingQueue<com.unboundid.ldap.sdk.LDAPConnection> r4 = r13.availableConnections     // Catch:{ Exception -> 0x024c }
            boolean r4 = r4.offer(r3)     // Catch:{ Exception -> 0x024c }
            if (r4 == 0) goto L_0x023e
            r0.add(r3)     // Catch:{ Exception -> 0x024c }
            goto L_0x0258
        L_0x023e:
            com.unboundid.ldap.sdk.DisconnectType r4 = com.unboundid.ldap.sdk.DisconnectType.POOLED_CONNECTION_UNNEEDED     // Catch:{ Exception -> 0x024c }
            r3.setDisconnectInfo(r4, r5, r5)     // Catch:{ Exception -> 0x024c }
            com.unboundid.ldap.sdk.LDAPConnectionPoolStatistics r4 = r13.poolStatistics     // Catch:{ Exception -> 0x024c }
            r4.incrementNumConnectionsClosedUnneeded()     // Catch:{ Exception -> 0x024c }
            r3.terminate(r5)     // Catch:{ Exception -> 0x024c }
            goto L_0x0258
        L_0x024c:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)
            com.unboundid.ldap.sdk.LDAPConnection r3 = r13.handleDefunctConnection(r3)
            if (r3 == 0) goto L_0x0258
            goto L_0x0043
        L_0x0258:
            int r2 = r2 + 1
            goto L_0x0009
        L_0x025c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.LDAPConnectionPool.doHealthCheck():void");
    }

    /* access modifiers changed from: protected */
    public void finalize() {
        super.finalize();
        close();
    }

    public LDAPConnection getConnection() {
        LDAPConnection poll;
        if (!this.closed) {
            LDAPConnection poll2 = this.availableConnections.poll();
            if (poll2 != null) {
                if (poll2.isConnected()) {
                    try {
                        this.healthCheck.ensureConnectionValidForCheckout(poll2);
                        this.poolStatistics.incrementNumSuccessfulCheckoutsWithoutWaiting();
                        return poll2;
                    } catch (LDAPException e) {
                        Debug.debugException(e);
                    }
                }
                handleDefunctConnection(poll2);
                int i = 0;
                while (i < this.numConnections && (poll = this.availableConnections.poll()) != null) {
                    if (poll.isConnected()) {
                        try {
                            this.healthCheck.ensureConnectionValidForCheckout(poll);
                            this.poolStatistics.incrementNumSuccessfulCheckoutsWithoutWaiting();
                            return poll;
                        } catch (LDAPException e2) {
                            Debug.debugException(e2);
                        }
                    } else {
                        handleDefunctConnection(poll);
                        i++;
                    }
                }
            }
            if (this.failedReplaceCount.get() <= 0) {
                long j = this.maxWaitTime;
                if (j > 0) {
                    try {
                        LDAPConnection poll3 = this.availableConnections.poll(j, TimeUnit.MILLISECONDS);
                        if (poll3 != null) {
                            try {
                                this.healthCheck.ensureConnectionValidForCheckout(poll3);
                                this.poolStatistics.incrementNumSuccessfulCheckoutsAfterWaiting();
                                return poll3;
                            } catch (LDAPException e3) {
                                Debug.debugException(e3);
                                handleDefunctConnection(poll3);
                            }
                        }
                    } catch (InterruptedException e4) {
                        Debug.debugException(e4);
                    }
                }
                if (this.createIfNecessary) {
                    try {
                        LDAPConnection createConnection = createConnection();
                        this.poolStatistics.incrementNumSuccessfulCheckoutsNewConnection();
                        return createConnection;
                    } catch (LDAPException e5) {
                        Debug.debugException(e5);
                        this.poolStatistics.incrementNumFailedCheckouts();
                        throw e5;
                    }
                } else {
                    this.poolStatistics.incrementNumFailedCheckouts();
                    throw new LDAPException(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_POOL_NO_CONNECTIONS.get());
                }
            } else if (this.failedReplaceCount.getAndDecrement() > 0) {
                try {
                    LDAPConnection createConnection2 = createConnection();
                    this.poolStatistics.incrementNumSuccessfulCheckoutsNewConnection();
                    return createConnection2;
                } catch (LDAPException e6) {
                    Debug.debugException(e6);
                    this.failedReplaceCount.incrementAndGet();
                    this.poolStatistics.incrementNumFailedCheckouts();
                    throw e6;
                }
            } else {
                this.failedReplaceCount.incrementAndGet();
                this.poolStatistics.incrementNumFailedCheckouts();
                throw new LDAPException(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_POOL_NO_CONNECTIONS.get());
            }
        } else {
            this.poolStatistics.incrementNumFailedCheckouts();
            throw new LDAPException(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_POOL_CLOSED.get());
        }
    }

    public String getConnectionPoolName() {
        return this.connectionPoolName;
    }

    public LDAPConnectionPoolStatistics getConnectionPoolStatistics() {
        return this.poolStatistics;
    }

    public boolean getCreateIfNecessary() {
        return this.createIfNecessary;
    }

    public int getCurrentAvailableConnections() {
        return this.availableConnections.size();
    }

    public LDAPConnectionPoolHealthCheck getHealthCheck() {
        return this.healthCheck;
    }

    public long getHealthCheckIntervalMillis() {
        return this.healthCheckInterval;
    }

    public long getMaxConnectionAgeMillis() {
        return this.maxConnectionAge;
    }

    public long getMaxWaitTimeMillis() {
        return this.maxWaitTime;
    }

    public int getMaximumAvailableConnections() {
        return this.numConnections;
    }

    public long getMinDisconnectIntervalMillis() {
        return this.minDisconnectInterval;
    }

    public Set<OperationType> getOperationTypesToRetryDueToInvalidConnections() {
        return this.retryOperationTypes.get();
    }

    public boolean isClosed() {
        return this.closed;
    }

    public void releaseConnection(LDAPConnection lDAPConnection) {
        if (lDAPConnection != null) {
            lDAPConnection.setConnectionPoolName(this.connectionPoolName);
            if (connectionIsExpired(lDAPConnection)) {
                try {
                    LDAPConnection createConnection = createConnection();
                    if (this.availableConnections.offer(createConnection)) {
                        lDAPConnection.setDisconnectInfo(DisconnectType.POOLED_CONNECTION_EXPIRED, (String) null, (Throwable) null);
                        lDAPConnection.terminate((Control[]) null);
                        this.poolStatistics.incrementNumConnectionsClosedExpired();
                        this.lastExpiredDisconnectTime = System.currentTimeMillis();
                        return;
                    }
                    createConnection.setDisconnectInfo(DisconnectType.POOLED_CONNECTION_UNNEEDED, (String) null, (Throwable) null);
                    createConnection.terminate((Control[]) null);
                    this.poolStatistics.incrementNumConnectionsClosedUnneeded();
                } catch (LDAPException e) {
                    Debug.debugException(e);
                }
            }
            try {
                this.healthCheck.ensureConnectionValidForRelease(lDAPConnection);
                if (this.availableConnections.offer(lDAPConnection)) {
                    this.poolStatistics.incrementNumReleasedValid();
                    if (this.closed) {
                        close();
                        return;
                    }
                    return;
                }
                lDAPConnection.setDisconnectInfo(DisconnectType.POOLED_CONNECTION_UNNEEDED, (String) null, (Throwable) null);
                this.poolStatistics.incrementNumConnectionsClosedUnneeded();
                lDAPConnection.terminate((Control[]) null);
            } catch (LDAPException unused) {
                releaseDefunctConnection(lDAPConnection);
            }
        }
    }

    public void releaseDefunctConnection(LDAPConnection lDAPConnection) {
        if (lDAPConnection != null) {
            lDAPConnection.setConnectionPoolName(this.connectionPoolName);
            this.poolStatistics.incrementNumConnectionsClosedDefunct();
            handleDefunctConnection(lDAPConnection);
        }
    }

    public LDAPConnection replaceDefunctConnection(LDAPConnection lDAPConnection) {
        lDAPConnection.setDisconnectInfo(DisconnectType.POOLED_CONNECTION_DEFUNCT, (String) null, (Throwable) null);
        lDAPConnection.terminate((Control[]) null);
        if (!this.closed) {
            return createConnection();
        }
        throw new LDAPException(ResultCode.CONNECT_ERROR, LDAPMessages.ERR_POOL_CLOSED.get());
    }

    public void setConnectionPoolName(String str) {
        this.connectionPoolName = str;
        Iterator<LDAPConnection> it = this.availableConnections.iterator();
        while (it.hasNext()) {
            it.next().setConnectionPoolName(str);
        }
    }

    public void setCreateIfNecessary(boolean z) {
        this.createIfNecessary = z;
    }

    public void setHealthCheck(LDAPConnectionPoolHealthCheck lDAPConnectionPoolHealthCheck) {
        Validator.ensureNotNull(lDAPConnectionPoolHealthCheck);
        this.healthCheck = lDAPConnectionPoolHealthCheck;
    }

    public void setHealthCheckIntervalMillis(long j) {
        Validator.ensureTrue(j > 0, "LDAPConnectionPool.healthCheckInterval must be greater than 0.");
        this.healthCheckInterval = j;
        this.healthCheckThread.wakeUp();
    }

    public void setMaxConnectionAgeMillis(long j) {
        if (j > 0) {
            this.maxConnectionAge = j;
        } else {
            this.maxConnectionAge = 0;
        }
    }

    public void setMaxWaitTimeMillis(long j) {
        if (j > 0) {
            this.maxWaitTime = j;
        } else {
            this.maxWaitTime = 0;
        }
    }

    public void setMinDisconnectIntervalMillis(long j) {
        if (j > 0) {
            this.minDisconnectInterval = j;
        } else {
            this.minDisconnectInterval = 0;
        }
    }

    public void setRetryFailedOperationsDueToInvalidConnections(Set<OperationType> set) {
        AtomicReference<Set<OperationType>> atomicReference;
        EnumSet<E> enumSet;
        if (set == null || set.isEmpty()) {
            atomicReference = this.retryOperationTypes;
            enumSet = EnumSet.noneOf(OperationType.class);
        } else {
            enumSet = EnumSet.noneOf(OperationType.class);
            enumSet.addAll(set);
            atomicReference = this.retryOperationTypes;
        }
        atomicReference.set(Collections.unmodifiableSet(enumSet));
    }

    public void setTrySynchronousReadDuringHealthCheck(boolean z) {
        this.trySynchronousReadDuringHealthCheck = z;
    }

    public void toString(StringBuilder sb) {
        sb.append("LDAPConnectionPool(");
        String str = this.connectionPoolName;
        if (str != null) {
            sb.append("name='");
            sb.append(str);
            sb.append("', ");
        }
        sb.append("serverSet=");
        this.serverSet.toString(sb);
        sb.append(", maxConnections=");
        sb.append(this.numConnections);
        sb.append(')');
    }

    public boolean trySynchronousReadDuringHealthCheck() {
        return this.trySynchronousReadDuringHealthCheck;
    }
}
