package com.unboundid.ldap.sdk;

import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.util.Debug;
import com.unboundid.util.DebugType;
import com.unboundid.util.InternalUseOnly;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.logging.Level;

@InternalUseOnly
final class AsyncHelper implements CommonAsyncHelper, IntermediateResponseListener {
    private static final long serialVersionUID = 7186731025240177443L;
    private final AsyncRequestID asyncRequestID;
    private final LDAPConnection connection;
    private final long createTime = System.nanoTime();
    private final IntermediateResponseListener intermediateResponseListener;
    private final OperationType operationType;
    private final AtomicBoolean responseReturned = new AtomicBoolean(false);
    private final AsyncResultListener resultListener;

    @InternalUseOnly
    AsyncHelper(LDAPConnection lDAPConnection, OperationType operationType2, int i, AsyncResultListener asyncResultListener, IntermediateResponseListener intermediateResponseListener2) {
        this.connection = lDAPConnection;
        this.operationType = operationType2;
        this.resultListener = asyncResultListener;
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
        return this.operationType;
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
            long nanoTime = System.nanoTime() - this.createTime;
            if (lDAPResponse instanceof ConnectionClosedResponse) {
                ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) lDAPResponse;
                String message = connectionClosedResponse.getMessage();
                if (message == null) {
                    throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_ASYNC_RESPONSE.get());
                }
                throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_ASYNC_RESPONSE_WITH_MESSAGE.get(message));
            }
            switch (this.operationType) {
                case ADD:
                    this.connection.getConnectionStatistics().incrementNumAddResponses(nanoTime);
                    break;
                case DELETE:
                    this.connection.getConnectionStatistics().incrementNumDeleteResponses(nanoTime);
                    break;
                case MODIFY:
                    this.connection.getConnectionStatistics().incrementNumModifyResponses(nanoTime);
                    break;
                case MODIFY_DN:
                    this.connection.getConnectionStatistics().incrementNumModifyDNResponses(nanoTime);
                    break;
            }
            LDAPResult lDAPResult = (LDAPResult) lDAPResponse;
            this.resultListener.ldapResultReceived(this.asyncRequestID, lDAPResult);
            this.asyncRequestID.setResult(lDAPResult);
        }
    }
}
