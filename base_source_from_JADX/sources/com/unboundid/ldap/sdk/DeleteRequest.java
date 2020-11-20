package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.ldap.protocol.ProtocolOp;
import com.unboundid.ldif.LDIFDeleteChangeRecord;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class DeleteRequest extends UpdatableLDAPRequest implements ProtocolOp, ReadOnlyDeleteRequest, ResponseAcceptor {
    private static final long serialVersionUID = -6126029442850884239L;

    /* renamed from: dn */
    private String f7269dn;
    private int messageID = -1;
    private final LinkedBlockingQueue<LDAPResponse> responseQueue = new LinkedBlockingQueue<>();

    public DeleteRequest(C3122DN dn) {
        super((Control[]) null);
        Validator.ensureNotNull(dn);
        this.f7269dn = dn.toString();
    }

    public DeleteRequest(C3122DN dn, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(dn);
        this.f7269dn = dn.toString();
    }

    public DeleteRequest(String str) {
        super((Control[]) null);
        Validator.ensureNotNull(str);
        this.f7269dn = str;
    }

    public DeleteRequest(String str, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(str);
        this.f7269dn = str;
    }

    private LDAPResult followReferral(LDAPResult lDAPResult, LDAPConnection lDAPConnection, int i) {
        LDAPConnection referralConnection;
        String[] referralURLs = lDAPResult.getReferralURLs();
        int length = referralURLs.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                LDAPURL ldapurl = new LDAPURL(referralURLs[i2]);
                if (ldapurl.getHost() == null) {
                    i2++;
                } else {
                    DeleteRequest deleteRequest = ldapurl.baseDNProvided() ? new DeleteRequest(ldapurl.getBaseDN(), getControls()) : this;
                    referralConnection = lDAPConnection.getReferralConnector().getReferralConnection(ldapurl, lDAPConnection);
                    LDAPResult process = deleteRequest.process(referralConnection, i + 1);
                    referralConnection.setDisconnectInfo(DisconnectType.REFERRAL, (String) null, (Throwable) null);
                    referralConnection.close();
                    return process;
                }
            } catch (LDAPException e) {
                Debug.debugException(e);
            } catch (Throwable th) {
                referralConnection.setDisconnectInfo(DisconnectType.REFERRAL, (String) null, (Throwable) null);
                referralConnection.close();
                throw th;
            }
        }
        return lDAPResult;
    }

    private LDAPResult handleResponse(LDAPConnection lDAPConnection, LDAPResponse lDAPResponse, long j, int i) {
        if (lDAPResponse == null) {
            long nanosToMillis = StaticUtils.nanosToMillis(System.nanoTime() - j);
            if (lDAPConnection.getConnectionOptions().abandonOnTimeout()) {
                lDAPConnection.abandon(this.messageID, new Control[0]);
            }
            throw new LDAPException(ResultCode.TIMEOUT, LDAPMessages.ERR_DELETE_CLIENT_TIMEOUT.get(Long.valueOf(nanosToMillis), lDAPConnection.getHostPort()));
        }
        lDAPConnection.getConnectionStatistics().incrementNumDeleteResponses(System.nanoTime() - j);
        if (lDAPResponse instanceof ConnectionClosedResponse) {
            ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) lDAPResponse;
            String message = connectionClosedResponse.getMessage();
            if (message == null) {
                throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_DELETE_RESPONSE.get(lDAPConnection.getHostPort(), toString()));
            }
            throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_DELETE_RESPONSE_WITH_MESSAGE.get(lDAPConnection.getHostPort(), toString(), message));
        }
        LDAPResult lDAPResult = (LDAPResult) lDAPResponse;
        return (!lDAPResult.getResultCode().equals(ResultCode.REFERRAL) || !followReferrals(lDAPConnection)) ? lDAPResult : i >= lDAPConnection.getConnectionOptions().getReferralHopLimit() ? new LDAPResult(this.messageID, ResultCode.REFERRAL_LIMIT_EXCEEDED, LDAPMessages.ERR_TOO_MANY_REFERRALS.get(), lDAPResult.getMatchedDN(), lDAPResult.getReferralURLs(), lDAPResult.getResponseControls()) : followReferral(lDAPResult, lDAPConnection, i);
    }

    private LDAPResult processSync(LDAPConnection lDAPConnection, int i) {
        this.messageID = lDAPConnection.nextMessageID();
        LDAPMessage lDAPMessage = new LDAPMessage(this.messageID, (ProtocolOp) this, getControls());
        try {
            lDAPConnection.getConnectionInternals().getSocket().setSoTimeout((int) getResponseTimeoutMillis(lDAPConnection));
        } catch (Exception e) {
            Debug.debugException(e);
        }
        long nanoTime = System.nanoTime();
        Debug.debugLDAPRequest(this);
        lDAPConnection.getConnectionStatistics().incrementNumDeleteRequests();
        lDAPConnection.sendMessage(lDAPMessage);
        while (true) {
            try {
                LDAPResponse readResponse = lDAPConnection.readResponse(this.messageID);
                if (!(readResponse instanceof IntermediateResponse)) {
                    return handleResponse(lDAPConnection, readResponse, nanoTime, i);
                }
                IntermediateResponseListener intermediateResponseListener = getIntermediateResponseListener();
                if (intermediateResponseListener != null) {
                    intermediateResponseListener.intermediateResponseReturned((IntermediateResponse) readResponse);
                }
            } catch (LDAPException e2) {
                Debug.debugException(e2);
                if (e2.getResultCode() == ResultCode.TIMEOUT && lDAPConnection.getConnectionOptions().abandonOnTimeout()) {
                    lDAPConnection.abandon(this.messageID, new Control[0]);
                }
                throw e2;
            }
        }
    }

    public DeleteRequest duplicate() {
        return duplicate(getControls());
    }

    public DeleteRequest duplicate(Control[] controlArr) {
        DeleteRequest deleteRequest = new DeleteRequest(this.f7269dn, controlArr);
        if (followReferralsInternal() != null) {
            deleteRequest.setFollowReferrals(followReferralsInternal());
        }
        deleteRequest.setResponseTimeoutMillis(getResponseTimeoutMillis((LDAPConnection) null));
        return deleteRequest;
    }

    /* access modifiers changed from: package-private */
    public ASN1Element encodeProtocolOp() {
        return new ASN1OctetString((byte) LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, this.f7269dn);
    }

    public String getDN() {
        return this.f7269dn;
    }

    public int getLastMessageID() {
        return this.messageID;
    }

    public OperationType getOperationType() {
        return OperationType.DELETE;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST;
    }

    /* access modifiers changed from: protected */
    public LDAPResult process(LDAPConnection lDAPConnection, int i) {
        if (lDAPConnection.synchronousMode()) {
            return processSync(lDAPConnection, i);
        }
        long nanoTime = System.nanoTime();
        processAsync(lDAPConnection, (AsyncResultListener) null);
        try {
            long responseTimeoutMillis = getResponseTimeoutMillis(lDAPConnection);
            LDAPResult handleResponse = handleResponse(lDAPConnection, (LDAPResponse) (responseTimeoutMillis > 0 ? this.responseQueue.poll(responseTimeoutMillis, TimeUnit.MILLISECONDS) : this.responseQueue.take()), nanoTime, i);
            lDAPConnection.deregisterResponseAcceptor(this.messageID);
            return handleResponse;
        } catch (InterruptedException e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_DELETE_INTERRUPTED.get(lDAPConnection.getHostPort()), e);
        } catch (Throwable th) {
            lDAPConnection.deregisterResponseAcceptor(this.messageID);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public AsyncRequestID processAsync(LDAPConnection lDAPConnection, AsyncResultListener asyncResultListener) {
        AsyncRequestID asyncRequestID;
        this.messageID = lDAPConnection.nextMessageID();
        LDAPMessage lDAPMessage = new LDAPMessage(this.messageID, (ProtocolOp) this, getControls());
        if (asyncResultListener == null) {
            asyncRequestID = null;
            lDAPConnection.registerResponseAcceptor(this.messageID, this);
        } else {
            AsyncHelper asyncHelper = new AsyncHelper(lDAPConnection, OperationType.DELETE, this.messageID, asyncResultListener, getIntermediateResponseListener());
            lDAPConnection.registerResponseAcceptor(this.messageID, asyncHelper);
            asyncRequestID = asyncHelper.getAsyncRequestID();
            long responseTimeoutMillis = getResponseTimeoutMillis(lDAPConnection);
            if (responseTimeoutMillis > 0) {
                Timer timer = lDAPConnection.getTimer();
                AsyncTimeoutTimerTask asyncTimeoutTimerTask = new AsyncTimeoutTimerTask(asyncHelper);
                timer.schedule(asyncTimeoutTimerTask, responseTimeoutMillis);
                asyncRequestID.setTimerTask(asyncTimeoutTimerTask);
            }
        }
        try {
            Debug.debugLDAPRequest(this);
            lDAPConnection.getConnectionStatistics().incrementNumDeleteRequests();
            lDAPConnection.sendMessage(lDAPMessage);
            return asyncRequestID;
        } catch (LDAPException e) {
            Debug.debugException(e);
            lDAPConnection.deregisterResponseAcceptor(this.messageID);
            throw e;
        }
    }

    @InternalUseOnly
    public void responseReceived(LDAPResponse lDAPResponse) {
        try {
            this.responseQueue.put(lDAPResponse);
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_EXCEPTION_HANDLING_RESPONSE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public void setDN(C3122DN dn) {
        Validator.ensureNotNull(dn);
        this.f7269dn = dn.toString();
    }

    public void setDN(String str) {
        Validator.ensureNotNull(str);
        this.f7269dn = str;
    }

    public String[] toLDIF() {
        return toLDIFChangeRecord().toLDIF();
    }

    public LDIFDeleteChangeRecord toLDIFChangeRecord() {
        return new LDIFDeleteChangeRecord(this);
    }

    public String toLDIFString() {
        return toLDIFChangeRecord().toLDIFString();
    }

    public void toString(StringBuilder sb) {
        sb.append("DeleteRequest(dn='");
        sb.append(this.f7269dn);
        sb.append('\'');
        Control[] controls = getControls();
        if (controls.length > 0) {
            sb.append(", controls={");
            for (int i = 0; i < controls.length; i++) {
                if (i > 0) {
                    sb.append(", ");
                }
                sb.append(controls[i]);
            }
            sb.append('}');
        }
        sb.append(')');
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        aSN1Buffer.addOctetString((byte) LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, this.f7269dn);
    }
}
