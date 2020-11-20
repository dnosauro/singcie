package com.unboundid.ldap.sdk;

import com.unboundid.util.Validator;
import javax.net.SocketFactory;

public final class SingleServerSet extends ServerSet {
    private final String address;
    private final LDAPConnectionOptions connectionOptions;
    private final int port;
    private final SocketFactory socketFactory;

    public SingleServerSet(String str, int i) {
        this(str, i, (SocketFactory) null, (LDAPConnectionOptions) null);
    }

    public SingleServerSet(String str, int i, LDAPConnectionOptions lDAPConnectionOptions) {
        this(str, i, (SocketFactory) null, lDAPConnectionOptions);
    }

    public SingleServerSet(String str, int i, SocketFactory socketFactory2) {
        this(str, i, socketFactory2, (LDAPConnectionOptions) null);
    }

    public SingleServerSet(String str, int i, SocketFactory socketFactory2, LDAPConnectionOptions lDAPConnectionOptions) {
        Validator.ensureNotNull(str);
        Validator.ensureTrue(i > 0 && i < 65536, "SingleServerSet.port must be between 1 and 65535.");
        this.address = str;
        this.port = i;
        if (socketFactory2 == null) {
            this.socketFactory = SocketFactory.getDefault();
        } else {
            this.socketFactory = socketFactory2;
        }
        if (lDAPConnectionOptions == null) {
            this.connectionOptions = new LDAPConnectionOptions();
        } else {
            this.connectionOptions = lDAPConnectionOptions;
        }
    }

    public String getAddress() {
        return this.address;
    }

    public LDAPConnection getConnection() {
        return new LDAPConnection(this.socketFactory, this.connectionOptions, this.address, this.port);
    }

    public LDAPConnectionOptions getConnectionOptions() {
        return this.connectionOptions;
    }

    public int getPort() {
        return this.port;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public void toString(StringBuilder sb) {
        sb.append("SingleServerSet(server=");
        sb.append(this.address);
        sb.append(':');
        sb.append(this.port);
        sb.append(')');
    }
}
