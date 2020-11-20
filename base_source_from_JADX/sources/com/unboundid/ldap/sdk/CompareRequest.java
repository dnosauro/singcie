package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1Sequence;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.ldap.protocol.ProtocolOp;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class CompareRequest extends UpdatableLDAPRequest implements ProtocolOp, ReadOnlyCompareRequest, ResponseAcceptor {
    private static final long serialVersionUID = 6343453776330347024L;
    private ASN1OctetString assertionValue;
    private String attributeName;

    /* renamed from: dn */
    private String f7268dn;
    private int messageID = -1;
    private final LinkedBlockingQueue<LDAPResponse> responseQueue = new LinkedBlockingQueue<>();

    public CompareRequest(C3122DN dn, String str, ASN1OctetString aSN1OctetString, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(dn, str, aSN1OctetString);
        this.f7268dn = dn.toString();
        this.attributeName = str;
        this.assertionValue = aSN1OctetString;
    }

    public CompareRequest(C3122DN dn, String str, String str2) {
        super((Control[]) null);
        Validator.ensureNotNull(dn, str, str2);
        this.f7268dn = dn.toString();
        this.attributeName = str;
        this.assertionValue = new ASN1OctetString(str2);
    }

    public CompareRequest(C3122DN dn, String str, String str2, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(dn, str, str2);
        this.f7268dn = dn.toString();
        this.attributeName = str;
        this.assertionValue = new ASN1OctetString(str2);
    }

    public CompareRequest(C3122DN dn, String str, byte[] bArr) {
        super((Control[]) null);
        Validator.ensureNotNull(dn, str, bArr);
        this.f7268dn = dn.toString();
        this.attributeName = str;
        this.assertionValue = new ASN1OctetString(bArr);
    }

    public CompareRequest(C3122DN dn, String str, byte[] bArr, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(dn, str, bArr);
        this.f7268dn = dn.toString();
        this.attributeName = str;
        this.assertionValue = new ASN1OctetString(bArr);
    }

    public CompareRequest(String str, String str2, String str3) {
        super((Control[]) null);
        Validator.ensureNotNull(str, str2, str3);
        this.f7268dn = str;
        this.attributeName = str2;
        this.assertionValue = new ASN1OctetString(str3);
    }

    public CompareRequest(String str, String str2, String str3, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(str, str2, str3);
        this.f7268dn = str;
        this.attributeName = str2;
        this.assertionValue = new ASN1OctetString(str3);
    }

    public CompareRequest(String str, String str2, byte[] bArr) {
        super((Control[]) null);
        Validator.ensureNotNull(str, str2, bArr);
        this.f7268dn = str;
        this.attributeName = str2;
        this.assertionValue = new ASN1OctetString(bArr);
    }

    public CompareRequest(String str, String str2, byte[] bArr, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(str, str2, bArr);
        this.f7268dn = str;
        this.attributeName = str2;
        this.assertionValue = new ASN1OctetString(bArr);
    }

    private CompareResult followReferral(CompareResult compareResult, LDAPConnection lDAPConnection, int i) {
        LDAPConnection referralConnection;
        String[] referralURLs = compareResult.getReferralURLs();
        int length = referralURLs.length;
        int i2 = 0;
        while (i2 < length) {
            try {
                LDAPURL ldapurl = new LDAPURL(referralURLs[i2]);
                if (ldapurl.getHost() == null) {
                    i2++;
                } else {
                    CompareRequest compareRequest = ldapurl.baseDNProvided() ? new CompareRequest(ldapurl.getBaseDN(), this.attributeName, this.assertionValue, getControls()) : this;
                    referralConnection = lDAPConnection.getReferralConnector().getReferralConnection(ldapurl, lDAPConnection);
                    CompareResult process = compareRequest.process(referralConnection, i + 1);
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
        return compareResult;
    }

    private CompareResult handleResponse(LDAPConnection lDAPConnection, LDAPResponse lDAPResponse, long j, int i) {
        if (lDAPResponse == null) {
            long nanosToMillis = StaticUtils.nanosToMillis(System.nanoTime() - j);
            if (lDAPConnection.getConnectionOptions().abandonOnTimeout()) {
                lDAPConnection.abandon(this.messageID, new Control[0]);
            }
            throw new LDAPException(ResultCode.TIMEOUT, LDAPMessages.ERR_COMPARE_CLIENT_TIMEOUT.get(Long.valueOf(nanosToMillis), lDAPConnection.getHostPort()));
        }
        lDAPConnection.getConnectionStatistics().incrementNumCompareResponses(System.nanoTime() - j);
        if (lDAPResponse instanceof ConnectionClosedResponse) {
            ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) lDAPResponse;
            String message = connectionClosedResponse.getMessage();
            if (message == null) {
                throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_COMPARE_RESPONSE.get(lDAPConnection.getHostPort(), toString()));
            }
            throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_COMPARE_RESPONSE_WITH_MESSAGE.get(lDAPConnection.getHostPort(), toString(), message));
        }
        CompareResult compareResult = lDAPResponse instanceof CompareResult ? (CompareResult) lDAPResponse : new CompareResult((LDAPResult) lDAPResponse);
        return (!compareResult.getResultCode().equals(ResultCode.REFERRAL) || !followReferrals(lDAPConnection)) ? compareResult : i >= lDAPConnection.getConnectionOptions().getReferralHopLimit() ? new CompareResult(this.messageID, ResultCode.REFERRAL_LIMIT_EXCEEDED, LDAPMessages.ERR_TOO_MANY_REFERRALS.get(), compareResult.getMatchedDN(), compareResult.getReferralURLs(), compareResult.getResponseControls()) : followReferral(compareResult, lDAPConnection, i);
    }

    private CompareResult processSync(LDAPConnection lDAPConnection, int i) {
        this.messageID = lDAPConnection.nextMessageID();
        LDAPMessage lDAPMessage = new LDAPMessage(this.messageID, (ProtocolOp) this, getControls());
        try {
            lDAPConnection.getConnectionInternals().getSocket().setSoTimeout((int) getResponseTimeoutMillis(lDAPConnection));
        } catch (Exception e) {
            Debug.debugException(e);
        }
        long nanoTime = System.nanoTime();
        Debug.debugLDAPRequest(this);
        lDAPConnection.getConnectionStatistics().incrementNumCompareRequests();
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

    public CompareRequest duplicate() {
        return duplicate(getControls());
    }

    public CompareRequest duplicate(Control[] controlArr) {
        CompareRequest compareRequest = new CompareRequest(this.f7268dn, this.attributeName, this.assertionValue.getValue(), controlArr);
        if (followReferralsInternal() != null) {
            compareRequest.setFollowReferrals(followReferralsInternal());
        }
        compareRequest.setResponseTimeoutMillis(getResponseTimeoutMillis((LDAPConnection) null));
        return compareRequest;
    }

    /* access modifiers changed from: package-private */
    public ASN1Element encodeProtocolOp() {
        return new ASN1Sequence((byte) LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, new ASN1OctetString(this.f7268dn), new ASN1Sequence(new ASN1OctetString(this.attributeName), this.assertionValue));
    }

    public String getAssertionValue() {
        return this.assertionValue.stringValue();
    }

    public byte[] getAssertionValueBytes() {
        return this.assertionValue.getValue();
    }

    public String getAttributeName() {
        return this.attributeName;
    }

    public String getDN() {
        return this.f7268dn;
    }

    public int getLastMessageID() {
        return this.messageID;
    }

    public OperationType getOperationType() {
        return OperationType.COMPARE;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST;
    }

    public ASN1OctetString getRawAssertionValue() {
        return this.assertionValue;
    }

    /* access modifiers changed from: protected */
    public CompareResult process(LDAPConnection lDAPConnection, int i) {
        if (lDAPConnection.synchronousMode()) {
            return processSync(lDAPConnection, i);
        }
        long nanoTime = System.nanoTime();
        processAsync(lDAPConnection, (AsyncCompareResultListener) null);
        try {
            long responseTimeoutMillis = getResponseTimeoutMillis(lDAPConnection);
            CompareResult handleResponse = handleResponse(lDAPConnection, (LDAPResponse) (responseTimeoutMillis > 0 ? this.responseQueue.poll(responseTimeoutMillis, TimeUnit.MILLISECONDS) : this.responseQueue.take()), nanoTime, i);
            lDAPConnection.deregisterResponseAcceptor(this.messageID);
            return handleResponse;
        } catch (InterruptedException e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_COMPARE_INTERRUPTED.get(lDAPConnection.getHostPort()), e);
        } catch (Throwable th) {
            lDAPConnection.deregisterResponseAcceptor(this.messageID);
            throw th;
        }
    }

    /* access modifiers changed from: package-private */
    public AsyncRequestID processAsync(LDAPConnection lDAPConnection, AsyncCompareResultListener asyncCompareResultListener) {
        AsyncRequestID asyncRequestID;
        this.messageID = lDAPConnection.nextMessageID();
        LDAPMessage lDAPMessage = new LDAPMessage(this.messageID, (ProtocolOp) this, getControls());
        if (asyncCompareResultListener == null) {
            asyncRequestID = null;
            lDAPConnection.registerResponseAcceptor(this.messageID, this);
        } else {
            AsyncCompareHelper asyncCompareHelper = new AsyncCompareHelper(lDAPConnection, this.messageID, asyncCompareResultListener, getIntermediateResponseListener());
            lDAPConnection.registerResponseAcceptor(this.messageID, asyncCompareHelper);
            asyncRequestID = asyncCompareHelper.getAsyncRequestID();
            long responseTimeoutMillis = getResponseTimeoutMillis(lDAPConnection);
            if (responseTimeoutMillis > 0) {
                Timer timer = lDAPConnection.getTimer();
                AsyncTimeoutTimerTask asyncTimeoutTimerTask = new AsyncTimeoutTimerTask(asyncCompareHelper);
                timer.schedule(asyncTimeoutTimerTask, responseTimeoutMillis);
                asyncRequestID.setTimerTask(asyncTimeoutTimerTask);
            }
        }
        try {
            Debug.debugLDAPRequest(this);
            lDAPConnection.getConnectionStatistics().incrementNumCompareRequests();
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

    public void setAssertionValue(ASN1OctetString aSN1OctetString) {
        this.assertionValue = aSN1OctetString;
    }

    public void setAssertionValue(String str) {
        Validator.ensureNotNull(str);
        this.assertionValue = new ASN1OctetString(str);
    }

    public void setAssertionValue(byte[] bArr) {
        Validator.ensureNotNull(bArr);
        this.assertionValue = new ASN1OctetString(bArr);
    }

    public void setAttributeName(String str) {
        Validator.ensureNotNull(str);
        this.attributeName = str;
    }

    public void setDN(C3122DN dn) {
        Validator.ensureNotNull(dn);
        this.f7268dn = dn.toString();
    }

    public void setDN(String str) {
        Validator.ensureNotNull(str);
        this.f7268dn = str;
    }

    public void toString(StringBuilder sb) {
        sb.append("CompareRequest(dn='");
        sb.append(this.f7268dn);
        sb.append("', attr='");
        sb.append(this.attributeName);
        sb.append("', value='");
        sb.append(this.assertionValue.stringValue());
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
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST);
        aSN1Buffer.addOctetString(this.f7268dn);
        ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence();
        aSN1Buffer.addOctetString(this.attributeName);
        aSN1Buffer.addElement(this.assertionValue);
        beginSequence2.end();
        beginSequence.end();
    }
}
