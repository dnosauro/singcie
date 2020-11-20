package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.extensions.StartTLSExtendedRequest;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.util.Collection;
import java.util.EnumSet;
import java.util.List;
import java.util.Set;

public abstract class AbstractConnectionPool implements LDAPInterface {
    private static Filter parseFilter(String str) {
        try {
            return Filter.create(str);
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw new LDAPSearchException(e);
        }
    }

    private LDAPConnection replaceDefunctConnection(Throwable th, LDAPConnection lDAPConnection) {
        try {
            return replaceDefunctConnection(lDAPConnection);
        } catch (LDAPException e) {
            Debug.debugException(e);
            if (th instanceof LDAPException) {
                throw ((LDAPException) th);
            }
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_POOL_OP_EXCEPTION.get(StaticUtils.getExceptionMessage(th)), th);
        }
    }

    private void throwLDAPExceptionIfShouldNotRetry(Throwable th, OperationType operationType, LDAPConnection lDAPConnection) {
        if ((th instanceof LDAPException) && getOperationTypesToRetryDueToInvalidConnections().contains(operationType)) {
            try {
                getHealthCheck().ensureConnectionValidAfterException(lDAPConnection, (LDAPException) th);
            } catch (Exception e) {
                Debug.debugException(e);
                return;
            }
        }
        throwLDAPException(th, lDAPConnection);
    }

    private void throwLDAPSearchExceptionIfShouldNotRetry(Throwable th, LDAPConnection lDAPConnection) {
        if ((th instanceof LDAPException) && getOperationTypesToRetryDueToInvalidConnections().contains(OperationType.SEARCH)) {
            try {
                getHealthCheck().ensureConnectionValidAfterException(lDAPConnection, (LDAPException) th);
            } catch (Exception e) {
                Debug.debugException(e);
                return;
            }
        }
        throwLDAPSearchException(th, lDAPConnection);
    }

    public final LDAPResult add(AddRequest addRequest) {
        LDAPConnection replaceDefunctConnection;
        LDAPConnection connection = getConnection();
        try {
            LDAPResult add = connection.add(addRequest);
            releaseConnection(connection);
            return add;
        } catch (Throwable th) {
            throwLDAPException(th, replaceDefunctConnection);
            return null;
        }
    }

    public final LDAPResult add(Entry entry) {
        return add(new AddRequest(entry));
    }

    public final LDAPResult add(ReadOnlyAddRequest readOnlyAddRequest) {
        return add((AddRequest) readOnlyAddRequest);
    }

    public final LDAPResult add(String str, Collection<Attribute> collection) {
        return add(new AddRequest(str, collection));
    }

    public final LDAPResult add(String str, Attribute... attributeArr) {
        return add(new AddRequest(str, attributeArr));
    }

    public final LDAPResult add(String... strArr) {
        return add(new AddRequest(strArr));
    }

    public final BindResult bind(BindRequest bindRequest) {
        LDAPConnection replaceDefunctConnection;
        LDAPConnection connection = getConnection();
        try {
            BindResult bind = connection.bind(bindRequest);
            releaseConnection(connection);
            return bind;
        } catch (Throwable th) {
            throwLDAPException(th, replaceDefunctConnection);
            return null;
        }
    }

    public final BindResult bind(String str, String str2) {
        return bind(new SimpleBindRequest(str, str2));
    }

    public abstract void close();

    public final CompareResult compare(CompareRequest compareRequest) {
        LDAPConnection replaceDefunctConnection;
        LDAPConnection connection = getConnection();
        try {
            CompareResult compare = connection.compare(compareRequest);
            releaseConnection(connection);
            return compare;
        } catch (Throwable th) {
            throwLDAPException(th, replaceDefunctConnection);
            return null;
        }
    }

    public final CompareResult compare(ReadOnlyCompareRequest readOnlyCompareRequest) {
        return compare((CompareRequest) readOnlyCompareRequest);
    }

    public final CompareResult compare(String str, String str2, String str3) {
        return compare(new CompareRequest(str, str2, str3));
    }

    public final LDAPResult delete(DeleteRequest deleteRequest) {
        LDAPConnection replaceDefunctConnection;
        LDAPConnection connection = getConnection();
        try {
            LDAPResult delete = connection.delete(deleteRequest);
            releaseConnection(connection);
            return delete;
        } catch (Throwable th) {
            throwLDAPException(th, replaceDefunctConnection);
            return null;
        }
    }

    public final LDAPResult delete(ReadOnlyDeleteRequest readOnlyDeleteRequest) {
        return delete((DeleteRequest) readOnlyDeleteRequest);
    }

    public final LDAPResult delete(String str) {
        return delete(new DeleteRequest(str));
    }

    /* access modifiers changed from: protected */
    public abstract void doHealthCheck();

    public abstract LDAPConnection getConnection();

    public abstract String getConnectionPoolName();

    public abstract LDAPConnectionPoolStatistics getConnectionPoolStatistics();

    public abstract int getCurrentAvailableConnections();

    public final SearchResultEntry getEntry(String str) {
        return getEntry(str, StaticUtils.NO_STRINGS);
    }

    public final SearchResultEntry getEntry(String str, String... strArr) {
        LDAPConnection replaceDefunctConnection;
        LDAPConnection connection = getConnection();
        try {
            SearchResultEntry entry = connection.getEntry(str, strArr);
            releaseConnection(connection);
            return entry;
        } catch (Throwable th) {
            throwLDAPException(th, replaceDefunctConnection);
            return null;
        }
    }

    public abstract LDAPConnectionPoolHealthCheck getHealthCheck();

    public abstract long getHealthCheckIntervalMillis();

    public abstract int getMaximumAvailableConnections();

    public abstract Set<OperationType> getOperationTypesToRetryDueToInvalidConnections();

    public final RootDSE getRootDSE() {
        LDAPConnection replaceDefunctConnection;
        LDAPConnection connection = getConnection();
        try {
            RootDSE rootDSE = connection.getRootDSE();
            releaseConnection(connection);
            return rootDSE;
        } catch (Throwable th) {
            throwLDAPException(th, replaceDefunctConnection);
            return null;
        }
    }

    public final Schema getSchema() {
        return getSchema("");
    }

    public final Schema getSchema(String str) {
        LDAPConnection replaceDefunctConnection;
        LDAPConnection connection = getConnection();
        try {
            Schema schema = connection.getSchema(str);
            releaseConnection(connection);
            return schema;
        } catch (Throwable th) {
            throwLDAPException(th, replaceDefunctConnection);
            return null;
        }
    }

    public abstract boolean isClosed();

    public final LDAPResult modify(ModifyRequest modifyRequest) {
        LDAPConnection replaceDefunctConnection;
        LDAPConnection connection = getConnection();
        try {
            LDAPResult modify = connection.modify(modifyRequest);
            releaseConnection(connection);
            return modify;
        } catch (Throwable th) {
            throwLDAPException(th, replaceDefunctConnection);
            return null;
        }
    }

    public final LDAPResult modify(ReadOnlyModifyRequest readOnlyModifyRequest) {
        return modify((ModifyRequest) readOnlyModifyRequest);
    }

    public final LDAPResult modify(String str, Modification modification) {
        return modify(new ModifyRequest(str, modification));
    }

    public final LDAPResult modify(String str, List<Modification> list) {
        return modify(new ModifyRequest(str, list));
    }

    public final LDAPResult modify(String str, Modification... modificationArr) {
        return modify(new ModifyRequest(str, modificationArr));
    }

    public final LDAPResult modify(String... strArr) {
        return modify(new ModifyRequest(strArr));
    }

    public final LDAPResult modifyDN(ModifyDNRequest modifyDNRequest) {
        LDAPConnection replaceDefunctConnection;
        LDAPConnection connection = getConnection();
        try {
            LDAPResult modifyDN = connection.modifyDN(modifyDNRequest);
            releaseConnection(connection);
            return modifyDN;
        } catch (Throwable th) {
            throwLDAPException(th, replaceDefunctConnection);
            return null;
        }
    }

    public final LDAPResult modifyDN(ReadOnlyModifyDNRequest readOnlyModifyDNRequest) {
        return modifyDN((ModifyDNRequest) readOnlyModifyDNRequest);
    }

    public final LDAPResult modifyDN(String str, String str2, boolean z) {
        return modifyDN(new ModifyDNRequest(str, str2, z));
    }

    public final LDAPResult modifyDN(String str, String str2, boolean z, String str3) {
        return modifyDN(new ModifyDNRequest(str, str2, z, str3));
    }

    public final ExtendedResult processExtendedOperation(ExtendedRequest extendedRequest) {
        LDAPConnection replaceDefunctConnection;
        if (!extendedRequest.getOID().equals(StartTLSExtendedRequest.STARTTLS_REQUEST_OID)) {
            LDAPConnection connection = getConnection();
            try {
                ExtendedResult processExtendedOperation = connection.processExtendedOperation(extendedRequest);
                releaseConnection(connection);
                return processExtendedOperation;
            } catch (Throwable th) {
                throwLDAPException(th, replaceDefunctConnection);
                return null;
            }
        } else {
            throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_POOL_STARTTLS_NOT_ALLOWED.get());
        }
    }

    public final ExtendedResult processExtendedOperation(String str) {
        return processExtendedOperation(new ExtendedRequest(str));
    }

    public final ExtendedResult processExtendedOperation(String str, ASN1OctetString aSN1OctetString) {
        return processExtendedOperation(new ExtendedRequest(str, aSN1OctetString));
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x0088  */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x008c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<com.unboundid.ldap.sdk.LDAPResult> processRequests(java.util.List<com.unboundid.ldap.sdk.LDAPRequest> r17, boolean r18) {
        /*
            r16 = this;
            r1 = r16
            com.unboundid.util.Validator.ensureNotNull(r17)
            boolean r0 = r17.isEmpty()
            java.lang.String r2 = "LDAPConnectionPool.processRequests.requests must not be empty."
            com.unboundid.util.Validator.ensureFalse(r0, r2)
            com.unboundid.ldap.sdk.LDAPConnection r2 = r16.getConnection()     // Catch:{ LDAPException -> 0x009b }
            java.util.ArrayList r3 = new java.util.ArrayList
            int r0 = r17.size()
            r3.<init>(r0)
            r4 = 0
            java.util.Iterator r5 = r17.iterator()     // Catch:{ all -> 0x0090 }
        L_0x0020:
            boolean r0 = r5.hasNext()     // Catch:{ all -> 0x0090 }
            if (r0 == 0) goto L_0x0086
            java.lang.Object r0 = r5.next()     // Catch:{ all -> 0x0090 }
            r6 = r0
            com.unboundid.ldap.sdk.LDAPRequest r6 = (com.unboundid.ldap.sdk.LDAPRequest) r6     // Catch:{ all -> 0x0090 }
            r7 = 1
            com.unboundid.ldap.sdk.LDAPResult r0 = r6.process(r2, r7)     // Catch:{ LDAPException -> 0x0054 }
            r3.add(r0)     // Catch:{ LDAPException -> 0x0054 }
            com.unboundid.ldap.sdk.ResultCode r8 = r0.getResultCode()     // Catch:{ LDAPException -> 0x0054 }
            int r8 = r8.intValue()     // Catch:{ LDAPException -> 0x0054 }
            if (r8 == 0) goto L_0x0020
            r9 = 16654(0x410e, float:2.3337E-41)
            if (r8 == r9) goto L_0x0020
            switch(r8) {
                case 5: goto L_0x0020;
                case 6: goto L_0x0020;
                default: goto L_0x0046;
            }     // Catch:{ LDAPException -> 0x0054 }
        L_0x0046:
            com.unboundid.ldap.sdk.ResultCode r0 = r0.getResultCode()     // Catch:{ LDAPException -> 0x0054 }
            boolean r0 = com.unboundid.ldap.sdk.ResultCode.isConnectionUsable(r0)     // Catch:{ LDAPException -> 0x0054 }
            if (r0 != 0) goto L_0x0051
            r4 = 1
        L_0x0051:
            if (r18 != 0) goto L_0x0020
            goto L_0x0086
        L_0x0054:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)     // Catch:{ all -> 0x0090 }
            com.unboundid.ldap.sdk.LDAPResult r15 = new com.unboundid.ldap.sdk.LDAPResult     // Catch:{ all -> 0x0090 }
            int r9 = r6.getLastMessageID()     // Catch:{ all -> 0x0090 }
            com.unboundid.ldap.sdk.ResultCode r10 = r0.getResultCode()     // Catch:{ all -> 0x0090 }
            java.lang.String r11 = r0.getMessage()     // Catch:{ all -> 0x0090 }
            java.lang.String r12 = r0.getMatchedDN()     // Catch:{ all -> 0x0090 }
            java.lang.String[] r13 = r0.getReferralURLs()     // Catch:{ all -> 0x0090 }
            com.unboundid.ldap.sdk.Control[] r14 = r0.getResponseControls()     // Catch:{ all -> 0x0090 }
            r8 = r15
            r8.<init>((int) r9, (com.unboundid.ldap.sdk.ResultCode) r10, (java.lang.String) r11, (java.lang.String) r12, (java.lang.String[]) r13, (com.unboundid.ldap.sdk.Control[]) r14)     // Catch:{ all -> 0x0090 }
            r3.add(r15)     // Catch:{ all -> 0x0090 }
            com.unboundid.ldap.sdk.ResultCode r0 = r0.getResultCode()     // Catch:{ all -> 0x0090 }
            boolean r0 = com.unboundid.ldap.sdk.ResultCode.isConnectionUsable(r0)     // Catch:{ all -> 0x0090 }
            if (r0 != 0) goto L_0x0084
            r4 = 1
        L_0x0084:
            if (r18 != 0) goto L_0x0020
        L_0x0086:
            if (r4 == 0) goto L_0x008c
            r1.releaseDefunctConnection(r2)
            goto L_0x008f
        L_0x008c:
            r1.releaseConnection(r2)
        L_0x008f:
            return r3
        L_0x0090:
            r0 = move-exception
            if (r4 == 0) goto L_0x0097
            r1.releaseDefunctConnection(r2)
            goto L_0x009a
        L_0x0097:
            r1.releaseConnection(r2)
        L_0x009a:
            throw r0
        L_0x009b:
            r0 = move-exception
            r2 = r0
            com.unboundid.util.Debug.debugException(r2)
            com.unboundid.ldap.sdk.LDAPSearchException r0 = new com.unboundid.ldap.sdk.LDAPSearchException
            r0.<init>((com.unboundid.ldap.sdk.LDAPException) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.AbstractConnectionPool.processRequests(java.util.List, boolean):java.util.List");
    }

    public abstract void releaseConnection(LDAPConnection lDAPConnection);

    public final void releaseConnectionAfterException(LDAPConnection lDAPConnection, LDAPException lDAPException) {
        try {
            getHealthCheck().ensureConnectionValidAfterException(lDAPConnection, lDAPException);
            releaseConnection(lDAPConnection);
        } catch (LDAPException e) {
            Debug.debugException(e);
            releaseDefunctConnection(lDAPConnection);
        }
    }

    public abstract void releaseDefunctConnection(LDAPConnection lDAPConnection);

    public abstract LDAPConnection replaceDefunctConnection(LDAPConnection lDAPConnection);

    public final boolean retryFailedOperationsDueToInvalidConnections() {
        return !getOperationTypesToRetryDueToInvalidConnections().isEmpty();
    }

    public final SearchResult search(ReadOnlySearchRequest readOnlySearchRequest) {
        return search((SearchRequest) readOnlySearchRequest);
    }

    public final SearchResult search(SearchRequest searchRequest) {
        LDAPConnection replaceDefunctConnection;
        try {
            LDAPConnection connection = getConnection();
            try {
                SearchResult search = connection.search(searchRequest);
                releaseConnection(connection);
                return search;
            } catch (Throwable th) {
                throwLDAPSearchException(th, replaceDefunctConnection);
                return null;
            }
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw new LDAPSearchException(e);
        }
    }

    public final SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, Filter filter, String... strArr) {
        return search(new SearchRequest(searchResultListener, str, searchScope, dereferencePolicy, i, i2, z, filter, strArr));
    }

    public final SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, String str2, String... strArr) {
        return search(new SearchRequest(searchResultListener, str, searchScope, dereferencePolicy, i, i2, z, parseFilter(str2), strArr));
    }

    public final SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, Filter filter, String... strArr) {
        return search(new SearchRequest(searchResultListener, str, searchScope, filter, strArr));
    }

    public final SearchResult search(SearchResultListener searchResultListener, String str, SearchScope searchScope, String str2, String... strArr) {
        return search(new SearchRequest(searchResultListener, str, searchScope, parseFilter(str2), strArr));
    }

    public final SearchResult search(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, Filter filter, String... strArr) {
        return search(new SearchRequest(str, searchScope, dereferencePolicy, i, i2, z, filter, strArr));
    }

    public final SearchResult search(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, int i2, boolean z, String str2, String... strArr) {
        return search(new SearchRequest(str, searchScope, dereferencePolicy, i, i2, z, parseFilter(str2), strArr));
    }

    public final SearchResult search(String str, SearchScope searchScope, Filter filter, String... strArr) {
        return search(new SearchRequest(str, searchScope, filter, strArr));
    }

    public final SearchResult search(String str, SearchScope searchScope, String str2, String... strArr) {
        return search(new SearchRequest(str, searchScope, parseFilter(str2), strArr));
    }

    public final SearchResultEntry searchForEntry(ReadOnlySearchRequest readOnlySearchRequest) {
        return searchForEntry((SearchRequest) readOnlySearchRequest);
    }

    public final SearchResultEntry searchForEntry(SearchRequest searchRequest) {
        LDAPConnection replaceDefunctConnection;
        try {
            LDAPConnection connection = getConnection();
            try {
                SearchResultEntry searchForEntry = connection.searchForEntry(searchRequest);
                releaseConnection(connection);
                return searchForEntry;
            } catch (Throwable th) {
                throwLDAPSearchException(th, replaceDefunctConnection);
                return null;
            }
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw new LDAPSearchException(e);
        }
    }

    public final SearchResultEntry searchForEntry(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, boolean z, Filter filter, String... strArr) {
        return searchForEntry(new SearchRequest(str, searchScope, dereferencePolicy, 1, i, z, filter, strArr));
    }

    public final SearchResultEntry searchForEntry(String str, SearchScope searchScope, DereferencePolicy dereferencePolicy, int i, boolean z, String str2, String... strArr) {
        return searchForEntry(new SearchRequest(str, searchScope, dereferencePolicy, 1, i, z, parseFilter(str2), strArr));
    }

    public final SearchResultEntry searchForEntry(String str, SearchScope searchScope, Filter filter, String... strArr) {
        return searchForEntry(new SearchRequest(str, searchScope, DereferencePolicy.NEVER, 1, 0, false, filter, strArr));
    }

    public final SearchResultEntry searchForEntry(String str, SearchScope searchScope, String str2, String... strArr) {
        return searchForEntry(new SearchRequest(str, searchScope, DereferencePolicy.NEVER, 1, 0, false, parseFilter(str2), strArr));
    }

    public abstract void setConnectionPoolName(String str);

    public abstract void setHealthCheckIntervalMillis(long j);

    public abstract void setRetryFailedOperationsDueToInvalidConnections(Set<OperationType> set);

    public final void setRetryFailedOperationsDueToInvalidConnections(boolean z) {
        setRetryFailedOperationsDueToInvalidConnections((Set<OperationType>) z ? EnumSet.allOf(OperationType.class) : EnumSet.noneOf(OperationType.class));
    }

    /* access modifiers changed from: package-private */
    public void throwLDAPException(Throwable th, LDAPConnection lDAPConnection) {
        Debug.debugException(th);
        if (th instanceof LDAPException) {
            LDAPException lDAPException = (LDAPException) th;
            releaseConnectionAfterException(lDAPConnection, lDAPException);
            throw lDAPException;
        }
        releaseDefunctConnection(lDAPConnection);
        throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_POOL_OP_EXCEPTION.get(StaticUtils.getExceptionMessage(th)), th);
    }

    /* access modifiers changed from: package-private */
    public void throwLDAPSearchException(Throwable th, LDAPConnection lDAPConnection) {
        Debug.debugException(th);
        if (th instanceof LDAPException) {
            LDAPSearchException lDAPSearchException = th instanceof LDAPSearchException ? (LDAPSearchException) th : new LDAPSearchException((LDAPException) th);
            releaseConnectionAfterException(lDAPConnection, lDAPSearchException);
            throw lDAPSearchException;
        }
        releaseDefunctConnection(lDAPConnection);
        throw new LDAPSearchException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_POOL_OP_EXCEPTION.get(StaticUtils.getExceptionMessage(th)), th);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public abstract void toString(StringBuilder sb);
}
