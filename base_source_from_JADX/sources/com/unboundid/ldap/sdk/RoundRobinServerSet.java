package com.unboundid.ldap.sdk;

import com.unboundid.util.Validator;
import javax.net.SocketFactory;

public final class RoundRobinServerSet extends ServerSet {
    private final String[] addresses;
    private final LDAPConnectionOptions connectionOptions;
    private int nextSlot;
    private final int[] ports;
    private final SocketFactory socketFactory;

    public RoundRobinServerSet(String[] strArr, int[] iArr) {
        this(strArr, iArr, (SocketFactory) null, (LDAPConnectionOptions) null);
    }

    public RoundRobinServerSet(String[] strArr, int[] iArr, LDAPConnectionOptions lDAPConnectionOptions) {
        this(strArr, iArr, (SocketFactory) null, lDAPConnectionOptions);
    }

    public RoundRobinServerSet(String[] strArr, int[] iArr, SocketFactory socketFactory2) {
        this(strArr, iArr, socketFactory2, (LDAPConnectionOptions) null);
    }

    public RoundRobinServerSet(String[] strArr, int[] iArr, SocketFactory socketFactory2, LDAPConnectionOptions lDAPConnectionOptions) {
        Validator.ensureNotNull(strArr, iArr);
        boolean z = true;
        Validator.ensureTrue(strArr.length > 0, "RoundRobinServerSet.addresses must not be empty.");
        Validator.ensureTrue(strArr.length != iArr.length ? false : z, "RoundRobinServerSet addresses and ports arrays must be the same size.");
        this.addresses = strArr;
        this.ports = iArr;
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
        this.nextSlot = 0;
    }

    public String[] getAddresses() {
        return this.addresses;
    }

    public synchronized LDAPConnection getConnection() {
        return getConnection((LDAPConnectionPoolHealthCheck) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x002d, code lost:
        continue;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.unboundid.ldap.sdk.LDAPConnection getConnection(com.unboundid.ldap.sdk.LDAPConnectionPoolHealthCheck r9) {
        /*
            r8 = this;
            int r0 = r8.nextSlot
            int r1 = r0 + 1
            r8.nextSlot = r1
            int r1 = r8.nextSlot
            java.lang.String[] r2 = r8.addresses
            int r2 = r2.length
            r3 = 0
            if (r1 < r2) goto L_0x0010
            r8.nextSlot = r3
        L_0x0010:
            com.unboundid.ldap.sdk.LDAPConnection r1 = new com.unboundid.ldap.sdk.LDAPConnection     // Catch:{ LDAPException -> 0x002d }
            javax.net.SocketFactory r2 = r8.socketFactory     // Catch:{ LDAPException -> 0x002d }
            com.unboundid.ldap.sdk.LDAPConnectionOptions r4 = r8.connectionOptions     // Catch:{ LDAPException -> 0x002d }
            java.lang.String[] r5 = r8.addresses     // Catch:{ LDAPException -> 0x002d }
            r5 = r5[r0]     // Catch:{ LDAPException -> 0x002d }
            int[] r6 = r8.ports     // Catch:{ LDAPException -> 0x002d }
            r6 = r6[r0]     // Catch:{ LDAPException -> 0x002d }
            r1.<init>((javax.net.SocketFactory) r2, (com.unboundid.ldap.sdk.LDAPConnectionOptions) r4, (java.lang.String) r5, (int) r6)     // Catch:{ LDAPException -> 0x002d }
            if (r9 == 0) goto L_0x002c
            r9.ensureNewConnectionValid(r1)     // Catch:{ LDAPException -> 0x0027 }
            goto L_0x002c
        L_0x0027:
            r2 = move-exception
            r1.close()     // Catch:{ LDAPException -> 0x002d }
            throw r2     // Catch:{ LDAPException -> 0x002d }
        L_0x002c:
            return r1
        L_0x002d:
            r1 = move-exception
            com.unboundid.util.Debug.debugException(r1)
            int r2 = r8.nextSlot
            if (r2 == r0) goto L_0x005f
            int r1 = r2 + 1
            r8.nextSlot = r1
            int r1 = r8.nextSlot
            java.lang.String[] r4 = r8.addresses
            int r4 = r4.length
            if (r1 < r4) goto L_0x0042
            r8.nextSlot = r3
        L_0x0042:
            com.unboundid.ldap.sdk.LDAPConnection r1 = new com.unboundid.ldap.sdk.LDAPConnection     // Catch:{ LDAPException -> 0x002d }
            javax.net.SocketFactory r4 = r8.socketFactory     // Catch:{ LDAPException -> 0x002d }
            com.unboundid.ldap.sdk.LDAPConnectionOptions r5 = r8.connectionOptions     // Catch:{ LDAPException -> 0x002d }
            java.lang.String[] r6 = r8.addresses     // Catch:{ LDAPException -> 0x002d }
            r6 = r6[r2]     // Catch:{ LDAPException -> 0x002d }
            int[] r7 = r8.ports     // Catch:{ LDAPException -> 0x002d }
            r2 = r7[r2]     // Catch:{ LDAPException -> 0x002d }
            r1.<init>((javax.net.SocketFactory) r4, (com.unboundid.ldap.sdk.LDAPConnectionOptions) r5, (java.lang.String) r6, (int) r2)     // Catch:{ LDAPException -> 0x002d }
            if (r9 == 0) goto L_0x005e
            r9.ensureNewConnectionValid(r1)     // Catch:{ LDAPException -> 0x0059 }
            goto L_0x005e
        L_0x0059:
            r2 = move-exception
            r1.close()     // Catch:{ LDAPException -> 0x002d }
            throw r2     // Catch:{ LDAPException -> 0x002d }
        L_0x005e:
            return r1
        L_0x005f:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.RoundRobinServerSet.getConnection(com.unboundid.ldap.sdk.LDAPConnectionPoolHealthCheck):com.unboundid.ldap.sdk.LDAPConnection");
    }

    public LDAPConnectionOptions getConnectionOptions() {
        return this.connectionOptions;
    }

    public int[] getPorts() {
        return this.ports;
    }

    public SocketFactory getSocketFactory() {
        return this.socketFactory;
    }

    public void toString(StringBuilder sb) {
        sb.append("RoundRobinServerSet(servers={");
        for (int i = 0; i < this.addresses.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.addresses[i]);
            sb.append(':');
            sb.append(this.ports[i]);
        }
        sb.append("})");
    }
}
