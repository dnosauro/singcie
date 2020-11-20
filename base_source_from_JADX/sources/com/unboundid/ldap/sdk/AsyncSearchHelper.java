package com.unboundid.ldap.sdk;

import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.util.Debug;
import com.unboundid.util.DebugType;
import com.unboundid.util.InternalUseOnly;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;

@InternalUseOnly
final class AsyncSearchHelper implements CommonAsyncHelper, IntermediateResponseListener {
    private static final long serialVersionUID = 1006163445423767824L;
    private final AsyncRequestID asyncRequestID;
    private final LDAPConnection connection;
    private final long createTime;
    private final IntermediateResponseListener intermediateResponseListener;
    private int numEntries = 0;
    private int numReferences = 0;
    private final AtomicBoolean responseReturned;
    private final AsyncSearchResultListener resultListener;

    @InternalUseOnly
    AsyncSearchHelper(LDAPConnection lDAPConnection, int i, AsyncSearchResultListener asyncSearchResultListener, IntermediateResponseListener intermediateResponseListener2) {
        this.connection = lDAPConnection;
        this.resultListener = asyncSearchResultListener;
        this.intermediateResponseListener = intermediateResponseListener2;
        this.asyncRequestID = new AsyncRequestID(i, lDAPConnection);
        this.responseReturned = new AtomicBoolean(false);
        this.createTime = System.nanoTime();
    }

    public AsyncRequestID getAsyncRequestID() {
        return this.asyncRequestID;
    }

    public LDAPConnection getConnection() {
        return this.connection;
    }

    public long getCreateTimeNanos() {
        return this.createTime;
    }

    /* access modifiers changed from: package-private */
    public int getNumEntries() {
        return this.numEntries;
    }

    /* access modifiers changed from: package-private */
    public int getNumReferences() {
        return this.numReferences;
    }

    public OperationType getOperationType() {
        return OperationType.SEARCH;
    }

    @InternalUseOnly
    public void intermediateResponseReturned(IntermediateResponse intermediateResponse) {
        IntermediateResponseListener intermediateResponseListener2 = this.intermediateResponseListener;
        if (intermediateResponseListener2 == null) {
            Debug.debug(Level.WARNING, DebugType.LDAP, LDAPMessages.WARN_INTERMEDIATE_RESPONSE_WITH_NO_LISTENER.get(String.valueOf(intermediateResponse)));
            return;
        }
        intermediateResponseListener2.intermediateResponseReturned(intermediateResponse);
    }

    @InternalUseOnly
    public void responseReceived(LDAPResponse lDAPResponse) {
        if (!this.responseReturned.get()) {
            if (lDAPResponse instanceof ConnectionClosedResponse) {
                ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) lDAPResponse;
                String message = connectionClosedResponse.getMessage();
                if (message == null) {
                    throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_ASYNC_RESPONSE.get());
                }
                throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_ASYNC_RESPONSE_WITH_MESSAGE.get(message));
            } else if (lDAPResponse instanceof SearchResultEntry) {
                this.numEntries++;
                this.resultListener.searchEntryReturned((SearchResultEntry) lDAPResponse);
            } else if (lDAPResponse instanceof SearchResultReference) {
                this.numReferences++;
                this.resultListener.searchReferenceReturned((SearchResultReference) lDAPResponse);
            } else if (this.responseReturned.compareAndSet(false, true)) {
                this.connection.getConnectionStatistics().incrementNumSearchResponses(this.numEntries, this.numReferences, System.nanoTime() - this.createTime);
                SearchResult searchResult = (SearchResult) lDAPResponse;
                searchResult.setCounts(this.numEntries, (List<SearchResultEntry>) null, this.numReferences, (List<SearchResultReference>) null);
                this.resultListener.searchResultReceived(this.asyncRequestID, searchResult);
                this.asyncRequestID.setResult(searchResult);
            }
        }
    }
}
