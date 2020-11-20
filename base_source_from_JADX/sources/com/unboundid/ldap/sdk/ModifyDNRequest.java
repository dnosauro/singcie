package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Boolean;
import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1Sequence;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.ldap.protocol.ProtocolOp;
import com.unboundid.ldif.LDIFModifyDNChangeRecord;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class ModifyDNRequest extends UpdatableLDAPRequest implements ProtocolOp, ReadOnlyModifyDNRequest, ResponseAcceptor {
    private static final byte NEW_SUPERIOR_TYPE = Byte.MIN_VALUE;
    private static final long serialVersionUID = -2325552729975091008L;
    private boolean deleteOldRDN;

    /* renamed from: dn */
    private String f7271dn;
    private int messageID = -1;
    private String newRDN;
    private String newSuperiorDN;
    private final LinkedBlockingQueue<LDAPResponse> responseQueue = new LinkedBlockingQueue<>();

    public ModifyDNRequest(C3122DN dn, RDN rdn, boolean z) {
        super((Control[]) null);
        Validator.ensureNotNull(dn, rdn);
        this.f7271dn = dn.toString();
        this.newRDN = rdn.toString();
        this.deleteOldRDN = z;
        this.newSuperiorDN = null;
    }

    public ModifyDNRequest(C3122DN dn, RDN rdn, boolean z, C3122DN dn2) {
        super((Control[]) null);
        Validator.ensureNotNull(dn, rdn);
        this.f7271dn = dn.toString();
        this.newRDN = rdn.toString();
        this.deleteOldRDN = z;
        if (dn2 == null) {
            this.newSuperiorDN = null;
        } else {
            this.newSuperiorDN = dn2.toString();
        }
    }

    public ModifyDNRequest(C3122DN dn, RDN rdn, boolean z, C3122DN dn2, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(dn, rdn);
        this.f7271dn = dn.toString();
        this.newRDN = rdn.toString();
        this.deleteOldRDN = z;
        this.newSuperiorDN = dn2 == null ? null : dn2.toString();
    }

    public ModifyDNRequest(C3122DN dn, RDN rdn, boolean z, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(dn, rdn);
        this.f7271dn = dn.toString();
        this.newRDN = rdn.toString();
        this.deleteOldRDN = z;
        this.newSuperiorDN = null;
    }

    public ModifyDNRequest(String str, String str2, boolean z) {
        super((Control[]) null);
        Validator.ensureNotNull(str, str2);
        this.f7271dn = str;
        this.newRDN = str2;
        this.deleteOldRDN = z;
        this.newSuperiorDN = null;
    }

    public ModifyDNRequest(String str, String str2, boolean z, String str3) {
        super((Control[]) null);
        Validator.ensureNotNull(str, str2);
        this.f7271dn = str;
        this.newRDN = str2;
        this.deleteOldRDN = z;
        this.newSuperiorDN = str3;
    }

    public ModifyDNRequest(String str, String str2, boolean z, String str3, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(str, str2);
        this.f7271dn = str;
        this.newRDN = str2;
        this.deleteOldRDN = z;
        this.newSuperiorDN = str3;
    }

    public ModifyDNRequest(String str, String str2, boolean z, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(str, str2);
        this.f7271dn = str;
        this.newRDN = str2;
        this.deleteOldRDN = z;
        this.newSuperiorDN = null;
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
                    ModifyDNRequest modifyDNRequest = ldapurl.baseDNProvided() ? new ModifyDNRequest(ldapurl.getBaseDN().toString(), this.newRDN, this.deleteOldRDN, this.newSuperiorDN, getControls()) : this;
                    referralConnection = lDAPConnection.getReferralConnector().getReferralConnection(ldapurl, lDAPConnection);
                    LDAPResult process = modifyDNRequest.process(referralConnection, i + 1);
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
            throw new LDAPException(ResultCode.TIMEOUT, LDAPMessages.ERR_MODIFY_DN_CLIENT_TIMEOUT.get(Long.valueOf(nanosToMillis), lDAPConnection.getHostPort()));
        }
        lDAPConnection.getConnectionStatistics().incrementNumModifyDNResponses(System.nanoTime() - j);
        if (lDAPResponse instanceof ConnectionClosedResponse) {
            ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) lDAPResponse;
            String message = connectionClosedResponse.getMessage();
            if (message == null) {
                throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_MODIFY_DN_RESPONSE.get(lDAPConnection.getHostPort(), toString()));
            }
            throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_MODIFY_DN_RESPONSE_WITH_MESSAGE.get(lDAPConnection.getHostPort(), toString(), message));
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
        lDAPConnection.getConnectionStatistics().incrementNumModifyDNRequests();
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

    public boolean deleteOldRDN() {
        return this.deleteOldRDN;
    }

    public ModifyDNRequest duplicate() {
        return duplicate(getControls());
    }

    public ModifyDNRequest duplicate(Control[] controlArr) {
        ModifyDNRequest modifyDNRequest = new ModifyDNRequest(this.f7271dn, this.newRDN, this.deleteOldRDN, this.newSuperiorDN, controlArr);
        if (followReferralsInternal() != null) {
            modifyDNRequest.setFollowReferrals(followReferralsInternal());
        }
        modifyDNRequest.setResponseTimeoutMillis(getResponseTimeoutMillis((LDAPConnection) null));
        return modifyDNRequest;
    }

    /* access modifiers changed from: package-private */
    public ASN1Element encodeProtocolOp() {
        return new ASN1Sequence((byte) LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST, this.newSuperiorDN == null ? new ASN1Element[]{new ASN1OctetString(this.f7271dn), new ASN1OctetString(this.newRDN), new ASN1Boolean(this.deleteOldRDN)} : new ASN1Element[]{new ASN1OctetString(this.f7271dn), new ASN1OctetString(this.newRDN), new ASN1Boolean(this.deleteOldRDN), new ASN1OctetString(Byte.MIN_VALUE, this.newSuperiorDN)});
    }

    public String getDN() {
        return this.f7271dn;
    }

    public int getLastMessageID() {
        return this.messageID;
    }

    public String getNewRDN() {
        return this.newRDN;
    }

    public String getNewSuperiorDN() {
        return this.newSuperiorDN;
    }

    public OperationType getOperationType() {
        return OperationType.MODIFY_DN;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST;
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
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_MODDN_INTERRUPTED.get(lDAPConnection.getHostPort()), e);
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
            AsyncHelper asyncHelper = new AsyncHelper(lDAPConnection, OperationType.MODIFY_DN, this.messageID, asyncResultListener, getIntermediateResponseListener());
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
            lDAPConnection.getConnectionStatistics().incrementNumModifyDNRequests();
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
        this.f7271dn = dn.toString();
    }

    public void setDN(String str) {
        Validator.ensureNotNull(str);
        this.f7271dn = str;
    }

    public void setDeleteOldRDN(boolean z) {
        this.deleteOldRDN = z;
    }

    public void setNewRDN(RDN rdn) {
        Validator.ensureNotNull(rdn);
        this.newRDN = rdn.toString();
    }

    public void setNewRDN(String str) {
        Validator.ensureNotNull(str);
        this.newRDN = str;
    }

    public void setNewSuperiorDN(C3122DN dn) {
        this.newSuperiorDN = dn == null ? null : dn.toString();
    }

    public void setNewSuperiorDN(String str) {
        this.newSuperiorDN = str;
    }

    public String[] toLDIF() {
        return toLDIFChangeRecord().toLDIF();
    }

    public LDIFModifyDNChangeRecord toLDIFChangeRecord() {
        return new LDIFModifyDNChangeRecord(this);
    }

    public String toLDIFString() {
        return toLDIFChangeRecord().toLDIFString();
    }

    public void toString(StringBuilder sb) {
        sb.append("ModifyDNRequest(dn='");
        sb.append(this.f7271dn);
        sb.append("', newRDN='");
        sb.append(this.newRDN);
        sb.append("', deleteOldRDN=");
        sb.append(this.deleteOldRDN);
        if (this.newSuperiorDN != null) {
            sb.append(", newSuperiorDN='");
            sb.append(this.newSuperiorDN);
            sb.append('\'');
        }
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
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_REQUEST);
        aSN1Buffer.addOctetString(this.f7271dn);
        aSN1Buffer.addOctetString(this.newRDN);
        aSN1Buffer.addBoolean(this.deleteOldRDN);
        String str = this.newSuperiorDN;
        if (str != null) {
            aSN1Buffer.addOctetString(Byte.MIN_VALUE, str);
        }
        beginSequence.end();
    }
}
