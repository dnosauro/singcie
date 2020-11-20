package com.unboundid.ldap.sdk;

import java.util.TimerTask;

final class AsyncTimeoutTimerTask extends TimerTask {
    private final CommonAsyncHelper helper;

    AsyncTimeoutTimerTask(CommonAsyncHelper commonAsyncHelper) {
        this.helper = commonAsyncHelper;
    }

    /* JADX WARNING: type inference failed for: r0v6, types: [com.unboundid.ldap.protocol.LDAPResponse] */
    /* JADX WARNING: type inference failed for: r0v14 */
    /* JADX WARNING: type inference failed for: r4v4, types: [com.unboundid.ldap.sdk.LDAPResult] */
    /* JADX WARNING: type inference failed for: r4v5, types: [com.unboundid.ldap.sdk.CompareResult] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r14 = this;
            long r0 = java.lang.System.nanoTime()
            com.unboundid.ldap.sdk.CommonAsyncHelper r2 = r14.helper
            long r2 = r2.getCreateTimeNanos()
            long r0 = r0 - r2
            r2 = 1000000(0xf4240, double:4.940656E-318)
            long r0 = r0 / r2
            com.unboundid.ldap.sdk.CommonAsyncHelper r2 = r14.helper
            com.unboundid.ldap.sdk.LDAPConnection r2 = r2.getConnection()
            com.unboundid.ldap.sdk.LDAPConnectionOptions r3 = r2.getConnectionOptions()
            boolean r3 = r3.abandonOnTimeout()
            r4 = 0
            r5 = 1
            if (r3 == 0) goto L_0x002c
            com.unboundid.ldap.sdk.LDAPMessages r6 = com.unboundid.ldap.sdk.LDAPMessages.INFO_ASYNC_OPERATION_TIMEOUT_WITH_ABANDON
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r5[r4] = r0
            goto L_0x0036
        L_0x002c:
            com.unboundid.ldap.sdk.LDAPMessages r6 = com.unboundid.ldap.sdk.LDAPMessages.INFO_ASYNC_OPERATION_TIMEOUT_WITHOUT_ABANDON
            java.lang.Object[] r5 = new java.lang.Object[r5]
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r5[r4] = r0
        L_0x0036:
            java.lang.String r0 = r6.get(r5)
            r7 = r0
            int[] r0 = com.unboundid.ldap.sdk.AsyncTimeoutTimerTask.C31211.$SwitchMap$com$unboundid$ldap$sdk$OperationType
            com.unboundid.ldap.sdk.CommonAsyncHelper r1 = r14.helper
            com.unboundid.ldap.sdk.OperationType r1 = r1.getOperationType()
            int r1 = r1.ordinal()
            r0 = r0[r1]
            switch(r0) {
                case 1: goto L_0x0089;
                case 2: goto L_0x0089;
                case 3: goto L_0x0089;
                case 4: goto L_0x0089;
                case 5: goto L_0x0071;
                case 6: goto L_0x004d;
                default: goto L_0x004c;
            }
        L_0x004c:
            return
        L_0x004d:
            com.unboundid.ldap.sdk.CommonAsyncHelper r0 = r14.helper
            r1 = r0
            com.unboundid.ldap.sdk.AsyncSearchHelper r1 = (com.unboundid.ldap.sdk.AsyncSearchHelper) r1
            com.unboundid.ldap.sdk.SearchResult r13 = new com.unboundid.ldap.sdk.SearchResult
            com.unboundid.ldap.sdk.AsyncRequestID r0 = r0.getAsyncRequestID()
            int r5 = r0.getMessageID()
            com.unboundid.ldap.sdk.ResultCode r6 = com.unboundid.ldap.sdk.ResultCode.TIMEOUT
            r8 = 0
            java.lang.String[] r9 = com.unboundid.util.StaticUtils.NO_STRINGS
            int r10 = r1.getNumEntries()
            int r11 = r1.getNumReferences()
            com.unboundid.ldap.sdk.Control[] r12 = com.unboundid.util.StaticUtils.NO_CONTROLS
            r4 = r13
            r4.<init>(r5, r6, r7, r8, r9, r10, r11, r12)
            r0 = r13
            goto L_0x00a0
        L_0x0071:
            com.unboundid.ldap.sdk.CompareResult r0 = new com.unboundid.ldap.sdk.CompareResult
            com.unboundid.ldap.sdk.CommonAsyncHelper r1 = r14.helper
            com.unboundid.ldap.sdk.AsyncRequestID r1 = r1.getAsyncRequestID()
            int r5 = r1.getMessageID()
            com.unboundid.ldap.sdk.ResultCode r6 = com.unboundid.ldap.sdk.ResultCode.TIMEOUT
            r8 = 0
            java.lang.String[] r9 = com.unboundid.util.StaticUtils.NO_STRINGS
            com.unboundid.ldap.sdk.Control[] r10 = com.unboundid.util.StaticUtils.NO_CONTROLS
            r4 = r0
            r4.<init>(r5, r6, r7, r8, r9, r10)
            goto L_0x00a0
        L_0x0089:
            com.unboundid.ldap.sdk.LDAPResult r0 = new com.unboundid.ldap.sdk.LDAPResult
            com.unboundid.ldap.sdk.CommonAsyncHelper r1 = r14.helper
            com.unboundid.ldap.sdk.AsyncRequestID r1 = r1.getAsyncRequestID()
            int r5 = r1.getMessageID()
            com.unboundid.ldap.sdk.ResultCode r6 = com.unboundid.ldap.sdk.ResultCode.TIMEOUT
            r8 = 0
            java.lang.String[] r9 = com.unboundid.util.StaticUtils.NO_STRINGS
            com.unboundid.ldap.sdk.Control[] r10 = com.unboundid.util.StaticUtils.NO_CONTROLS
            r4 = r0
            r4.<init>((int) r5, (com.unboundid.ldap.sdk.ResultCode) r6, (java.lang.String) r7, (java.lang.String) r8, (java.lang.String[]) r9, (com.unboundid.ldap.sdk.Control[]) r10)
        L_0x00a0:
            com.unboundid.ldap.sdk.CommonAsyncHelper r1 = r14.helper     // Catch:{ LDAPException -> 0x00b1 }
            r1.responseReceived(r0)     // Catch:{ LDAPException -> 0x00b1 }
            if (r3 == 0) goto L_0x00b5
            com.unboundid.ldap.sdk.CommonAsyncHelper r0 = r14.helper     // Catch:{ LDAPException -> 0x00b1 }
            com.unboundid.ldap.sdk.AsyncRequestID r0 = r0.getAsyncRequestID()     // Catch:{ LDAPException -> 0x00b1 }
            r2.abandon(r0)     // Catch:{ LDAPException -> 0x00b1 }
            goto L_0x00b5
        L_0x00b1:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)
        L_0x00b5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.AsyncTimeoutTimerTask.run():void");
    }
}
