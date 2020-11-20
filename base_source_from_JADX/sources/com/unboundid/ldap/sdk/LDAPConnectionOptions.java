package com.unboundid.ldap.sdk;

import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;

public final class LDAPConnectionOptions {
    static final boolean DEFAULT_ABANDON_ON_TIMEOUT = false;
    static final boolean DEFAULT_ALLOW_CONCURRENT_SOCKET_FACTORY_USE;
    static final boolean DEFAULT_AUTO_RECONNECT = false;
    static final boolean DEFAULT_BIND_WITH_DN_REQUIRES_PASSWORD = true;
    static final boolean DEFAULT_CAPTURE_CONNECT_STACK_TRACE = false;
    static final int DEFAULT_CONNECT_TIMEOUT_MILLIS = 60000;
    static final boolean DEFAULT_FOLLOW_REFERRALS = false;
    static final int DEFAULT_LINGER_TIMEOUT_SECONDS = 5;
    static final int DEFAULT_MAX_MESSAGE_SIZE = 20971520;
    static final int DEFAULT_RECEIVE_BUFFER_SIZE = 0;
    static final int DEFAULT_REFERRAL_HOP_LIMIT = 5;
    static final long DEFAULT_RESPONSE_TIMEOUT_MILLIS = 300000;
    static final int DEFAULT_SEND_BUFFER_SIZE = 0;
    static final boolean DEFAULT_USE_KEEPALIVE = true;
    static final boolean DEFAULT_USE_LINGER = true;
    static final boolean DEFAULT_USE_REUSE_ADDRESS = true;
    static final boolean DEFAULT_USE_SCHEMA = false;
    static final boolean DEFAULT_USE_SYNCHRONOUS_MODE = false;
    static final boolean DEFAULT_USE_TCP_NODELAY = true;
    private boolean abandonOnTimeout = false;
    private boolean allowConcurrentSocketFactoryUse = DEFAULT_ALLOW_CONCURRENT_SOCKET_FACTORY_USE;
    private boolean autoReconnect = false;
    private boolean bindWithDNRequiresPassword = true;
    private boolean captureConnectStackTrace = false;
    private int connectTimeout = DEFAULT_CONNECT_TIMEOUT_MILLIS;
    private DisconnectHandler disconnectHandler = null;
    private boolean followReferrals = false;
    private int lingerTimeout = 5;
    private int maxMessageSize = DEFAULT_MAX_MESSAGE_SIZE;
    private int receiveBufferSize = 0;
    private ReferralConnector referralConnector = null;
    private int referralHopLimit = 5;
    private long responseTimeout = DEFAULT_RESPONSE_TIMEOUT_MILLIS;
    private int sendBufferSize = 0;
    private UnsolicitedNotificationHandler unsolicitedNotificationHandler = null;
    private boolean useKeepAlive = true;
    private boolean useLinger = true;
    private boolean useReuseAddress = true;
    private boolean useSchema = false;
    private boolean useSynchronousMode = false;
    private boolean useTCPNoDelay = true;

    static {
        String lowerCase = StaticUtils.toLowerCase(System.getProperty("java.vm.vendor"));
        DEFAULT_ALLOW_CONCURRENT_SOCKET_FACTORY_USE = lowerCase != null && (lowerCase.contains("sun microsystems") || lowerCase.contains("oracle") || lowerCase.contains("apple"));
    }

    public boolean abandonOnTimeout() {
        return this.abandonOnTimeout;
    }

    public boolean allowConcurrentSocketFactoryUse() {
        return this.allowConcurrentSocketFactoryUse;
    }

    public boolean autoReconnect() {
        return this.autoReconnect;
    }

    public boolean bindWithDNRequiresPassword() {
        return this.bindWithDNRequiresPassword;
    }

    public boolean captureConnectStackTrace() {
        return this.captureConnectStackTrace;
    }

    public LDAPConnectionOptions duplicate() {
        LDAPConnectionOptions lDAPConnectionOptions = new LDAPConnectionOptions();
        lDAPConnectionOptions.abandonOnTimeout = this.abandonOnTimeout;
        lDAPConnectionOptions.allowConcurrentSocketFactoryUse = this.allowConcurrentSocketFactoryUse;
        lDAPConnectionOptions.autoReconnect = this.autoReconnect;
        lDAPConnectionOptions.bindWithDNRequiresPassword = this.bindWithDNRequiresPassword;
        lDAPConnectionOptions.captureConnectStackTrace = this.captureConnectStackTrace;
        lDAPConnectionOptions.followReferrals = this.followReferrals;
        lDAPConnectionOptions.useKeepAlive = this.useKeepAlive;
        lDAPConnectionOptions.useLinger = this.useLinger;
        lDAPConnectionOptions.useReuseAddress = this.useReuseAddress;
        lDAPConnectionOptions.useSchema = this.useSchema;
        lDAPConnectionOptions.useSynchronousMode = this.useSynchronousMode;
        lDAPConnectionOptions.useTCPNoDelay = this.useTCPNoDelay;
        lDAPConnectionOptions.connectTimeout = this.connectTimeout;
        lDAPConnectionOptions.lingerTimeout = this.lingerTimeout;
        lDAPConnectionOptions.maxMessageSize = this.maxMessageSize;
        lDAPConnectionOptions.responseTimeout = this.responseTimeout;
        lDAPConnectionOptions.referralConnector = this.referralConnector;
        lDAPConnectionOptions.referralHopLimit = this.referralHopLimit;
        lDAPConnectionOptions.disconnectHandler = this.disconnectHandler;
        lDAPConnectionOptions.unsolicitedNotificationHandler = this.unsolicitedNotificationHandler;
        lDAPConnectionOptions.receiveBufferSize = this.receiveBufferSize;
        lDAPConnectionOptions.sendBufferSize = this.sendBufferSize;
        return lDAPConnectionOptions;
    }

    public boolean followReferrals() {
        return this.followReferrals;
    }

    public int getConnectTimeoutMillis() {
        return this.connectTimeout;
    }

    public DisconnectHandler getDisconnectHandler() {
        return this.disconnectHandler;
    }

    public int getLingerTimeoutSeconds() {
        return this.lingerTimeout;
    }

    public int getMaxMessageSize() {
        return this.maxMessageSize;
    }

    public int getReceiveBufferSize() {
        return this.receiveBufferSize;
    }

    public ReferralConnector getReferralConnector() {
        return this.referralConnector;
    }

    public int getReferralHopLimit() {
        return this.referralHopLimit;
    }

    public long getResponseTimeoutMillis() {
        return this.responseTimeout;
    }

    public int getSendBufferSize() {
        return this.sendBufferSize;
    }

    public UnsolicitedNotificationHandler getUnsolicitedNotificationHandler() {
        return this.unsolicitedNotificationHandler;
    }

    public void setAbandonOnTimeout(boolean z) {
        this.abandonOnTimeout = z;
    }

    public void setAllowConcurrentSocketFactoryUse(boolean z) {
        this.allowConcurrentSocketFactoryUse = z;
    }

    public void setAutoReconnect(boolean z) {
        this.autoReconnect = z;
    }

    public void setBindWithDNRequiresPassword(boolean z) {
        this.bindWithDNRequiresPassword = z;
    }

    public void setCaptureConnectStackTrace(boolean z) {
        this.captureConnectStackTrace = z;
    }

    public void setConnectTimeoutMillis(int i) {
        this.connectTimeout = i;
    }

    public void setDisconnectHandler(DisconnectHandler disconnectHandler2) {
        this.disconnectHandler = disconnectHandler2;
    }

    public void setFollowReferrals(boolean z) {
        this.followReferrals = z;
    }

    public void setMaxMessageSize(int i) {
        if (i <= 0) {
            i = 0;
        }
        this.maxMessageSize = i;
    }

    public void setReceiveBufferSize(int i) {
        if (i < 0) {
            i = 0;
        }
        this.receiveBufferSize = i;
    }

    public void setReferralConnector(ReferralConnector referralConnector2) {
        this.referralConnector = referralConnector2;
    }

    public void setReferralHopLimit(int i) {
        Validator.ensureTrue(i > 0, "LDAPConnectionOptions.referralHopLimit must be greater than 0.");
        this.referralHopLimit = i;
    }

    public void setResponseTimeoutMillis(long j) {
        if (j < 0) {
            this.responseTimeout = 0;
        } else {
            this.responseTimeout = j;
        }
    }

    public void setSendBufferSize(int i) {
        if (i < 0) {
            i = 0;
        }
        this.sendBufferSize = i;
    }

    public void setUnsolicitedNotificationHandler(UnsolicitedNotificationHandler unsolicitedNotificationHandler2) {
        this.unsolicitedNotificationHandler = unsolicitedNotificationHandler2;
    }

    public void setUseKeepAlive(boolean z) {
        this.useKeepAlive = z;
    }

    public void setUseLinger(boolean z, int i) {
        this.useLinger = z;
        this.lingerTimeout = i;
    }

    public void setUseReuseAddress(boolean z) {
        this.useReuseAddress = z;
    }

    public void setUseSchema(boolean z) {
        this.useSchema = z;
    }

    public void setUseSynchronousMode(boolean z) {
        this.useSynchronousMode = z;
    }

    public void setUseTCPNoDelay(boolean z) {
        this.useTCPNoDelay = z;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("LDAPConnectionOptions(autoReconnect=");
        sb.append(this.autoReconnect);
        sb.append(", bindWithDNRequiresPassword=");
        sb.append(this.bindWithDNRequiresPassword);
        sb.append(", followReferrals=");
        sb.append(this.followReferrals);
        if (this.followReferrals) {
            sb.append(", referralHopLimit=");
            sb.append(this.referralHopLimit);
        }
        if (this.referralConnector != null) {
            sb.append(", referralConnectorClass=");
            sb.append(this.referralConnector.getClass().getName());
        }
        sb.append(", useKeepAlive=");
        sb.append(this.useKeepAlive);
        sb.append(", useLinger=");
        if (this.useLinger) {
            sb.append("true, lingerTimeoutSeconds=");
            sb.append(this.lingerTimeout);
        } else {
            sb.append("false");
        }
        sb.append(", useReuseAddress=");
        sb.append(this.useReuseAddress);
        sb.append(", useSchema=");
        sb.append(this.useSchema);
        sb.append(", useSynchronousMode=");
        sb.append(this.useSynchronousMode);
        sb.append(", useTCPNoDelay=");
        sb.append(this.useTCPNoDelay);
        sb.append(", captureConnectStackTrace=");
        sb.append(this.captureConnectStackTrace);
        sb.append(", connectTimeoutMillis=");
        sb.append(this.connectTimeout);
        sb.append(", responseTimeoutMillis=");
        sb.append(this.responseTimeout);
        sb.append(", abandonOnTimeout=");
        sb.append(this.abandonOnTimeout);
        sb.append(", maxMessageSize=");
        sb.append(this.maxMessageSize);
        sb.append(", receiveBufferSize=");
        sb.append(this.receiveBufferSize);
        sb.append(", sendBufferSize=");
        sb.append(this.sendBufferSize);
        sb.append(", allowConcurrentSocketFactoryUse=");
        sb.append(this.allowConcurrentSocketFactoryUse);
        if (this.disconnectHandler != null) {
            sb.append(", disconnectHandlerClass=");
            sb.append(this.disconnectHandler.getClass().getName());
        }
        if (this.unsolicitedNotificationHandler != null) {
            sb.append(", unsolicitedNotificationHandlerClass=");
            sb.append(this.unsolicitedNotificationHandler.getClass().getName());
        }
        sb.append(')');
    }

    public boolean useKeepAlive() {
        return this.useKeepAlive;
    }

    public boolean useLinger() {
        return this.useLinger;
    }

    public boolean useReuseAddress() {
        return this.useReuseAddress;
    }

    public boolean useSchema() {
        return this.useSchema;
    }

    public boolean useSynchronousMode() {
        return this.useSynchronousMode;
    }

    public boolean useTCPNoDelay() {
        return this.useTCPNoDelay;
    }
}
