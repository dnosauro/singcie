package com.unboundid.ldap.sdk;

import com.unboundid.util.Validator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import javax.net.SocketFactory;

public final class FailoverServerSet extends ServerSet {
    private final AtomicBoolean reOrderOnFailover;
    private final ServerSet[] serverSets;

    public FailoverServerSet(List<ServerSet> list) {
        Validator.ensureNotNull(list);
        Validator.ensureFalse(list.isEmpty(), "FailoverServerSet.serverSets must not be empty.");
        this.serverSets = new ServerSet[list.size()];
        list.toArray(this.serverSets);
        this.reOrderOnFailover = new AtomicBoolean(false);
    }

    public FailoverServerSet(ServerSet... serverSetArr) {
        Validator.ensureNotNull(serverSetArr);
        Validator.ensureFalse(serverSetArr.length == 0, "FailoverServerSet.serverSets must not be empty.");
        this.serverSets = serverSetArr;
        this.reOrderOnFailover = new AtomicBoolean(false);
    }

    public FailoverServerSet(String[] strArr, int[] iArr) {
        this(strArr, iArr, (SocketFactory) null, (LDAPConnectionOptions) null);
    }

    public FailoverServerSet(String[] strArr, int[] iArr, LDAPConnectionOptions lDAPConnectionOptions) {
        this(strArr, iArr, (SocketFactory) null, lDAPConnectionOptions);
    }

    public FailoverServerSet(String[] strArr, int[] iArr, SocketFactory socketFactory) {
        this(strArr, iArr, socketFactory, (LDAPConnectionOptions) null);
    }

    public FailoverServerSet(String[] strArr, int[] iArr, SocketFactory socketFactory, LDAPConnectionOptions lDAPConnectionOptions) {
        Validator.ensureNotNull(strArr, iArr);
        boolean z = true;
        int i = 0;
        Validator.ensureTrue(strArr.length > 0, "FailoverServerSet.addresses must not be empty.");
        Validator.ensureTrue(strArr.length != iArr.length ? false : z, "FailoverServerSet addresses and ports arrays must be the same size.");
        this.reOrderOnFailover = new AtomicBoolean(false);
        socketFactory = socketFactory == null ? SocketFactory.getDefault() : socketFactory;
        lDAPConnectionOptions = lDAPConnectionOptions == null ? new LDAPConnectionOptions() : lDAPConnectionOptions;
        this.serverSets = new ServerSet[strArr.length];
        while (true) {
            ServerSet[] serverSetArr = this.serverSets;
            if (i < serverSetArr.length) {
                serverSetArr[i] = new SingleServerSet(strArr[i], iArr[i], socketFactory, lDAPConnectionOptions);
                i++;
            } else {
                return;
            }
        }
    }

    public LDAPConnection getConnection() {
        return getConnection((LDAPConnectionPoolHealthCheck) null);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.unboundid.ldap.sdk.LDAPConnection} */
    /* JADX WARNING: type inference failed for: r1v0 */
    /* JADX WARNING: type inference failed for: r1v1, types: [java.lang.Throwable] */
    /* JADX WARNING: type inference failed for: r1v6 */
    /* JADX WARNING: type inference failed for: r1v7 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.unboundid.ldap.sdk.LDAPConnection getConnection(com.unboundid.ldap.sdk.LDAPConnectionPoolHealthCheck r8) {
        /*
            r7 = this;
            java.util.concurrent.atomic.AtomicBoolean r0 = r7.reOrderOnFailover
            boolean r0 = r0.get()
            r1 = 0
            r2 = 0
            if (r0 == 0) goto L_0x006d
            com.unboundid.ldap.sdk.ServerSet[] r0 = r7.serverSets
            int r0 = r0.length
            r3 = 1
            if (r0 <= r3) goto L_0x006d
            monitor-enter(r7)
            com.unboundid.ldap.sdk.ServerSet[] r0 = r7.serverSets     // Catch:{ LDAPException -> 0x001d }
            r0 = r0[r2]     // Catch:{ LDAPException -> 0x001d }
            com.unboundid.ldap.sdk.LDAPConnection r8 = r0.getConnection(r8)     // Catch:{ LDAPException -> 0x001d }
            monitor-exit(r7)     // Catch:{ all -> 0x001b }
            return r8
        L_0x001b:
            r8 = move-exception
            goto L_0x006b
        L_0x001d:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)     // Catch:{ all -> 0x001b }
            r0 = -1
            r4 = r1
        L_0x0023:
            com.unboundid.ldap.sdk.ServerSet[] r5 = r7.serverSets     // Catch:{ all -> 0x001b }
            int r5 = r5.length     // Catch:{ all -> 0x001b }
            if (r3 >= r5) goto L_0x0039
            com.unboundid.ldap.sdk.ServerSet[] r5 = r7.serverSets     // Catch:{ LDAPException -> 0x0032 }
            r5 = r5[r3]     // Catch:{ LDAPException -> 0x0032 }
            com.unboundid.ldap.sdk.LDAPConnection r1 = r5.getConnection(r8)     // Catch:{ LDAPException -> 0x0032 }
            r0 = r3
            goto L_0x0039
        L_0x0032:
            r4 = move-exception
            com.unboundid.util.Debug.debugException(r4)     // Catch:{ all -> 0x001b }
            int r3 = r3 + 1
            goto L_0x0023
        L_0x0039:
            if (r0 <= 0) goto L_0x006a
            com.unboundid.ldap.sdk.ServerSet[] r8 = r7.serverSets     // Catch:{ all -> 0x001b }
            int r8 = r8.length     // Catch:{ all -> 0x001b }
            com.unboundid.ldap.sdk.ServerSet[] r8 = new com.unboundid.ldap.sdk.ServerSet[r8]     // Catch:{ all -> 0x001b }
            r3 = r0
            r4 = 0
        L_0x0042:
            com.unboundid.ldap.sdk.ServerSet[] r5 = r7.serverSets     // Catch:{ all -> 0x001b }
            int r5 = r5.length     // Catch:{ all -> 0x001b }
            if (r3 >= r5) goto L_0x0053
            int r5 = r4 + 1
            com.unboundid.ldap.sdk.ServerSet[] r6 = r7.serverSets     // Catch:{ all -> 0x001b }
            r6 = r6[r3]     // Catch:{ all -> 0x001b }
            r8[r4] = r6     // Catch:{ all -> 0x001b }
            int r3 = r3 + 1
            r4 = r5
            goto L_0x0042
        L_0x0053:
            r3 = 0
        L_0x0054:
            if (r3 >= r0) goto L_0x0062
            int r5 = r4 + 1
            com.unboundid.ldap.sdk.ServerSet[] r6 = r7.serverSets     // Catch:{ all -> 0x001b }
            r6 = r6[r3]     // Catch:{ all -> 0x001b }
            r8[r4] = r6     // Catch:{ all -> 0x001b }
            int r3 = r3 + 1
            r4 = r5
            goto L_0x0054
        L_0x0062:
            com.unboundid.ldap.sdk.ServerSet[] r0 = r7.serverSets     // Catch:{ all -> 0x001b }
            int r3 = r8.length     // Catch:{ all -> 0x001b }
            java.lang.System.arraycopy(r8, r2, r0, r2, r3)     // Catch:{ all -> 0x001b }
            monitor-exit(r7)     // Catch:{ all -> 0x001b }
            return r1
        L_0x006a:
            throw r4     // Catch:{ all -> 0x001b }
        L_0x006b:
            monitor-exit(r7)     // Catch:{ all -> 0x001b }
            throw r8
        L_0x006d:
            com.unboundid.ldap.sdk.ServerSet[] r0 = r7.serverSets
            int r3 = r0.length
        L_0x0070:
            if (r2 >= r3) goto L_0x0080
            r1 = r0[r2]
            com.unboundid.ldap.sdk.LDAPConnection r8 = r1.getConnection(r8)     // Catch:{ LDAPException -> 0x0079 }
            return r8
        L_0x0079:
            r1 = move-exception
            com.unboundid.util.Debug.debugException(r1)
            int r2 = r2 + 1
            goto L_0x0070
        L_0x0080:
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.FailoverServerSet.getConnection(com.unboundid.ldap.sdk.LDAPConnectionPoolHealthCheck):com.unboundid.ldap.sdk.LDAPConnection");
    }

    public ServerSet[] getServerSets() {
        return this.serverSets;
    }

    public boolean reOrderOnFailover() {
        return this.reOrderOnFailover.get();
    }

    public void setReOrderOnFailover(boolean z) {
        this.reOrderOnFailover.set(z);
    }

    public void toString(StringBuilder sb) {
        sb.append("FailoverServerSet(serverSets={");
        for (int i = 0; i < this.serverSets.length; i++) {
            if (i > 0) {
                sb.append(", ");
            }
            this.serverSets[i].toString(sb);
        }
        sb.append("})");
    }
}
