package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1Sequence;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.ldap.protocol.ProtocolOp;
import com.unboundid.ldif.LDIFChangeRecord;
import com.unboundid.ldif.LDIFException;
import com.unboundid.ldif.LDIFModifyChangeRecord;
import com.unboundid.ldif.LDIFReader;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class ModifyRequest extends UpdatableLDAPRequest implements ProtocolOp, ReadOnlyModifyRequest, ResponseAcceptor {
    private static final long serialVersionUID = -4747622844001634758L;

    /* renamed from: dn */
    private String f7272dn;
    private int messageID = -1;
    private final ArrayList<Modification> modifications;
    private final LinkedBlockingQueue<LDAPResponse> responseQueue = new LinkedBlockingQueue<>();

    public ModifyRequest(C3122DN dn, Modification modification) {
        super((Control[]) null);
        Validator.ensureNotNull(dn, modification);
        this.f7272dn = dn.toString();
        this.modifications = new ArrayList<>(1);
        this.modifications.add(modification);
    }

    public ModifyRequest(C3122DN dn, Modification modification, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(dn, modification);
        this.f7272dn = dn.toString();
        this.modifications = new ArrayList<>(1);
        this.modifications.add(modification);
    }

    public ModifyRequest(C3122DN dn, List<Modification> list) {
        super((Control[]) null);
        Validator.ensureNotNull(dn, list);
        Validator.ensureFalse(list.isEmpty(), "ModifyRequest.mods must not be empty.");
        this.f7272dn = dn.toString();
        this.modifications = new ArrayList<>(list);
    }

    public ModifyRequest(C3122DN dn, List<Modification> list, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(dn, list);
        Validator.ensureFalse(list.isEmpty(), "ModifyRequest.mods must not be empty.");
        this.f7272dn = dn.toString();
        this.modifications = new ArrayList<>(list);
    }

    public ModifyRequest(C3122DN dn, Modification... modificationArr) {
        super((Control[]) null);
        Validator.ensureNotNull(dn, modificationArr);
        Validator.ensureFalse(modificationArr.length == 0, "ModifyRequest.mods must not be empty.");
        this.f7272dn = dn.toString();
        this.modifications = new ArrayList<>(modificationArr.length);
        this.modifications.addAll(Arrays.asList(modificationArr));
    }

    public ModifyRequest(C3122DN dn, Modification[] modificationArr, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(dn, modificationArr);
        Validator.ensureFalse(modificationArr.length == 0, "ModifyRequest.mods must not be empty.");
        this.f7272dn = dn.toString();
        this.modifications = new ArrayList<>(modificationArr.length);
        this.modifications.addAll(Arrays.asList(modificationArr));
    }

    public ModifyRequest(String str, Modification modification) {
        super((Control[]) null);
        Validator.ensureNotNull(str, modification);
        this.f7272dn = str;
        this.modifications = new ArrayList<>(1);
        this.modifications.add(modification);
    }

    public ModifyRequest(String str, Modification modification, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(str, modification);
        this.f7272dn = str;
        this.modifications = new ArrayList<>(1);
        this.modifications.add(modification);
    }

    public ModifyRequest(String str, List<Modification> list) {
        super((Control[]) null);
        Validator.ensureNotNull(str, list);
        Validator.ensureFalse(list.isEmpty(), "ModifyRequest.mods must not be empty.");
        this.f7272dn = str;
        this.modifications = new ArrayList<>(list);
    }

    public ModifyRequest(String str, List<Modification> list, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(str, list);
        Validator.ensureFalse(list.isEmpty(), "ModifyRequest.mods must not be empty.");
        this.f7272dn = str;
        this.modifications = new ArrayList<>(list);
    }

    public ModifyRequest(String str, Modification... modificationArr) {
        super((Control[]) null);
        Validator.ensureNotNull(str, modificationArr);
        Validator.ensureFalse(modificationArr.length == 0, "ModifyRequest.mods must not be empty.");
        this.f7272dn = str;
        this.modifications = new ArrayList<>(modificationArr.length);
        this.modifications.addAll(Arrays.asList(modificationArr));
    }

    public ModifyRequest(String str, Modification[] modificationArr, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(str, modificationArr);
        Validator.ensureFalse(modificationArr.length == 0, "ModifyRequest.mods must not be empty.");
        this.f7272dn = str;
        this.modifications = new ArrayList<>(modificationArr.length);
        this.modifications.addAll(Arrays.asList(modificationArr));
    }

    public ModifyRequest(String... strArr) {
        super((Control[]) null);
        LDIFChangeRecord decodeChangeRecord = LDIFReader.decodeChangeRecord(strArr);
        if (decodeChangeRecord instanceof LDIFModifyChangeRecord) {
            ModifyRequest modifyRequest = ((LDIFModifyChangeRecord) decodeChangeRecord).toModifyRequest();
            this.f7272dn = modifyRequest.f7272dn;
            this.modifications = modifyRequest.modifications;
            return;
        }
        throw new LDIFException(LDAPMessages.ERR_MODIFY_INVALID_LDIF.get(), 0, false, (CharSequence[]) strArr, (Throwable) null);
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
                    ModifyRequest modifyRequest = ldapurl.baseDNProvided() ? new ModifyRequest(ldapurl.getBaseDN(), (List<Modification>) this.modifications, getControls()) : this;
                    referralConnection = lDAPConnection.getReferralConnector().getReferralConnection(ldapurl, lDAPConnection);
                    LDAPResult process = modifyRequest.process(referralConnection, i + 1);
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
            throw new LDAPException(ResultCode.TIMEOUT, LDAPMessages.ERR_MODIFY_CLIENT_TIMEOUT.get(Long.valueOf(nanosToMillis), lDAPConnection.getHostPort()));
        }
        lDAPConnection.getConnectionStatistics().incrementNumModifyResponses(System.nanoTime() - j);
        if (lDAPResponse instanceof ConnectionClosedResponse) {
            ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) lDAPResponse;
            String message = connectionClosedResponse.getMessage();
            if (message == null) {
                throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_MODIFY_RESPONSE.get(lDAPConnection.getHostPort(), toString()));
            }
            throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_MODIFY_RESPONSE_WITH_MESSAGE.get(lDAPConnection.getHostPort(), toString(), message));
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
        lDAPConnection.getConnectionStatistics().incrementNumModifyRequests();
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

    public void addModification(Modification modification) {
        Validator.ensureNotNull(modification);
        this.modifications.add(modification);
    }

    public ModifyRequest duplicate() {
        return duplicate(getControls());
    }

    public ModifyRequest duplicate(Control[] controlArr) {
        ModifyRequest modifyRequest = new ModifyRequest(this.f7272dn, (List<Modification>) new ArrayList(this.modifications), controlArr);
        if (followReferralsInternal() != null) {
            modifyRequest.setFollowReferrals(followReferralsInternal());
        }
        modifyRequest.setResponseTimeoutMillis(getResponseTimeoutMillis((LDAPConnection) null));
        return modifyRequest;
    }

    /* access modifiers changed from: package-private */
    public ASN1Element encodeProtocolOp() {
        ASN1Element[] aSN1ElementArr = new ASN1Element[this.modifications.size()];
        for (int i = 0; i < aSN1ElementArr.length; i++) {
            aSN1ElementArr[i] = this.modifications.get(i).encode();
        }
        return new ASN1Sequence((byte) LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST, new ASN1OctetString(this.f7272dn), new ASN1Sequence(aSN1ElementArr));
    }

    public String getDN() {
        return this.f7272dn;
    }

    public int getLastMessageID() {
        return this.messageID;
    }

    public List<Modification> getModifications() {
        return Collections.unmodifiableList(this.modifications);
    }

    public OperationType getOperationType() {
        return OperationType.MODIFY;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST;
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
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_MODIFY_INTERRUPTED.get(lDAPConnection.getHostPort()), e);
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
            AsyncHelper asyncHelper = new AsyncHelper(lDAPConnection, OperationType.MODIFY, this.messageID, asyncResultListener, getIntermediateResponseListener());
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
            lDAPConnection.getConnectionStatistics().incrementNumModifyRequests();
            lDAPConnection.sendMessage(lDAPMessage);
            return asyncRequestID;
        } catch (LDAPException e) {
            Debug.debugException(e);
            lDAPConnection.deregisterResponseAcceptor(this.messageID);
            throw e;
        }
    }

    public boolean removeModification(Modification modification) {
        Validator.ensureNotNull(modification);
        return this.modifications.remove(modification);
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
        this.f7272dn = dn.toString();
    }

    public void setDN(String str) {
        Validator.ensureNotNull(str);
        this.f7272dn = str;
    }

    public void setModifications(Modification modification) {
        Validator.ensureNotNull(modification);
        this.modifications.clear();
        this.modifications.add(modification);
    }

    public void setModifications(List<Modification> list) {
        Validator.ensureNotNull(list);
        Validator.ensureFalse(list.isEmpty(), "ModifyRequest.setModifications.mods must not be empty.");
        this.modifications.clear();
        this.modifications.addAll(list);
    }

    public void setModifications(Modification[] modificationArr) {
        Validator.ensureNotNull(modificationArr);
        Validator.ensureFalse(modificationArr.length == 0, "ModifyRequest.setModifications.mods must not be empty.");
        this.modifications.clear();
        this.modifications.addAll(Arrays.asList(modificationArr));
    }

    public String[] toLDIF() {
        return toLDIFChangeRecord().toLDIF();
    }

    public LDIFModifyChangeRecord toLDIFChangeRecord() {
        return new LDIFModifyChangeRecord(this);
    }

    public String toLDIFString() {
        return toLDIFChangeRecord().toLDIFString();
    }

    public void toString(StringBuilder sb) {
        String str;
        sb.append("ModifyRequest(dn='");
        sb.append(this.f7272dn);
        sb.append("', mods={");
        for (int i = 0; i < this.modifications.size(); i++) {
            Modification modification = this.modifications.get(i);
            if (i > 0) {
                sb.append(", ");
            }
            switch (modification.getModificationType().intValue()) {
                case 0:
                    str = "ADD ";
                    break;
                case 1:
                    str = "DELETE ";
                    break;
                case 2:
                    str = "REPLACE ";
                    break;
                case 3:
                    str = "INCREMENT ";
                    break;
            }
            sb.append(str);
            sb.append(modification.getAttributeName());
        }
        sb.append('}');
        Control[] controls = getControls();
        if (controls.length > 0) {
            sb.append(", controls={");
            for (int i2 = 0; i2 < controls.length; i2++) {
                if (i2 > 0) {
                    sb.append(", ");
                }
                sb.append(controls[i2]);
            }
            sb.append('}');
        }
        sb.append(')');
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_REQUEST);
        aSN1Buffer.addOctetString(this.f7272dn);
        ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence();
        Iterator<Modification> it = this.modifications.iterator();
        while (it.hasNext()) {
            it.next().writeTo(aSN1Buffer);
        }
        beginSequence2.end();
        beginSequence.end();
    }
}
