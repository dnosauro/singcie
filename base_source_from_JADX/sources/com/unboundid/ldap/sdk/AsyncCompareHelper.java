package com.unboundid.ldap.sdk;

import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.util.Debug;
import com.unboundid.util.DebugType;
import com.unboundid.util.InternalUseOnly;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;

@InternalUseOnly
final class AsyncCompareHelper implements CommonAsyncHelper, IntermediateResponseListener {
    private static final long serialVersionUID = 8888333889563000881L;
    private final AsyncRequestID asyncRequestID;
    private final LDAPConnection connection;
    private final long createTime = System.nanoTime();
    private final IntermediateResponseListener intermediateResponseListener;
    private final AtomicBoolean responseReturned = new AtomicBoolean(false);
    private final AsyncCompareResultListener resultListener;

    @InternalUseOnly
    AsyncCompareHelper(LDAPConnection lDAPConnection, int i, AsyncCompareResultListener asyncCompareResultListener, IntermediateResponseListener intermediateResponseListener2) {
        this.connection = lDAPConnection;
        this.resultListener = asyncCompareResultListener;
        this.intermediateResponseListener = intermediateResponseListener2;
        this.asyncRequestID = new AsyncRequestID(i, lDAPConnection);
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

    public OperationType getOperationType() {
        return OperationType.COMPARE;
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
        if (this.responseReturned.compareAndSet(false, true)) {
            if (lDAPResponse instanceof ConnectionClosedResponse) {
                ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) lDAPResponse;
                String message = connectionClosedResponse.getMessage();
                if (message == null) {
                    throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_ASYNC_RESPONSE.get());
                }
                throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_ASYNC_RESPONSE_WITH_MESSAGE.get(message));
            }
            this.connection.getConnectionStatistics().incrementNumCompareResponses(System.nanoTime() - this.createTime);
            CompareResult compareResult = (CompareResult) lDAPResponse;
            this.resultListener.compareResultReceived(this.asyncRequestID, compareResult);
            this.asyncRequestID.setResult(compareResult);
        }
    }
}
