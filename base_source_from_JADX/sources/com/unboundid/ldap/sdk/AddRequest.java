package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1Sequence;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.ldap.protocol.ProtocolOp;
import com.unboundid.ldif.LDIFAddChangeRecord;
import com.unboundid.ldif.LDIFReader;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Timer;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class AddRequest extends UpdatableLDAPRequest implements ProtocolOp, ReadOnlyAddRequest, ResponseAcceptor {
    private static final long serialVersionUID = 1320730292848237219L;
    private ArrayList<Attribute> attributes;

    /* renamed from: dn */
    private String f7266dn;
    private int messageID;
    private final LinkedBlockingQueue<LDAPResponse> responseQueue;

    public AddRequest(C3122DN dn, Collection<Attribute> collection) {
        super((Control[]) null);
        this.responseQueue = new LinkedBlockingQueue<>();
        this.messageID = -1;
        Validator.ensureNotNull(dn, collection);
        this.f7266dn = dn.toString();
        this.attributes = new ArrayList<>(collection);
    }

    public AddRequest(C3122DN dn, Collection<Attribute> collection, Control[] controlArr) {
        super(controlArr);
        this.responseQueue = new LinkedBlockingQueue<>();
        this.messageID = -1;
        Validator.ensureNotNull(dn, collection);
        this.f7266dn = dn.toString();
        this.attributes = new ArrayList<>(collection);
    }

    public AddRequest(C3122DN dn, Attribute... attributeArr) {
        super((Control[]) null);
        this.responseQueue = new LinkedBlockingQueue<>();
        this.messageID = -1;
        Validator.ensureNotNull(dn, attributeArr);
        this.f7266dn = dn.toString();
        this.attributes = new ArrayList<>(attributeArr.length);
        this.attributes.addAll(Arrays.asList(attributeArr));
    }

    public AddRequest(C3122DN dn, Attribute[] attributeArr, Control[] controlArr) {
        super(controlArr);
        this.responseQueue = new LinkedBlockingQueue<>();
        this.messageID = -1;
        Validator.ensureNotNull(dn, attributeArr);
        this.f7266dn = dn.toString();
        this.attributes = new ArrayList<>(attributeArr.length);
        this.attributes.addAll(Arrays.asList(attributeArr));
    }

    public AddRequest(Entry entry) {
        super((Control[]) null);
        this.responseQueue = new LinkedBlockingQueue<>();
        this.messageID = -1;
        Validator.ensureNotNull(entry);
        this.f7266dn = entry.getDN();
        this.attributes = new ArrayList<>(entry.getAttributes());
    }

    public AddRequest(Entry entry, Control[] controlArr) {
        super(controlArr);
        this.responseQueue = new LinkedBlockingQueue<>();
        this.messageID = -1;
        Validator.ensureNotNull(entry);
        this.f7266dn = entry.getDN();
        this.attributes = new ArrayList<>(entry.getAttributes());
    }

    public AddRequest(String str, Collection<Attribute> collection) {
        super((Control[]) null);
        this.responseQueue = new LinkedBlockingQueue<>();
        this.messageID = -1;
        Validator.ensureNotNull(str, collection);
        this.f7266dn = str;
        this.attributes = new ArrayList<>(collection);
    }

    public AddRequest(String str, Collection<Attribute> collection, Control[] controlArr) {
        super(controlArr);
        this.responseQueue = new LinkedBlockingQueue<>();
        this.messageID = -1;
        Validator.ensureNotNull(str, collection);
        this.f7266dn = str;
        this.attributes = new ArrayList<>(collection);
    }

    public AddRequest(String str, Attribute... attributeArr) {
        super((Control[]) null);
        this.responseQueue = new LinkedBlockingQueue<>();
        this.messageID = -1;
        Validator.ensureNotNull(str, attributeArr);
        this.f7266dn = str;
        this.attributes = new ArrayList<>(attributeArr.length);
        this.attributes.addAll(Arrays.asList(attributeArr));
    }

    public AddRequest(String str, Attribute[] attributeArr, Control[] controlArr) {
        super(controlArr);
        this.responseQueue = new LinkedBlockingQueue<>();
        this.messageID = -1;
        Validator.ensureNotNull(str, attributeArr);
        this.f7266dn = str;
        this.attributes = new ArrayList<>(attributeArr.length);
        this.attributes.addAll(Arrays.asList(attributeArr));
    }

    public AddRequest(String... strArr) {
        this(LDIFReader.decodeEntry(strArr));
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
                    AddRequest addRequest = ldapurl.baseDNProvided() ? new AddRequest(ldapurl.getBaseDN(), (Collection<Attribute>) this.attributes, getControls()) : this;
                    referralConnection = lDAPConnection.getReferralConnector().getReferralConnection(ldapurl, lDAPConnection);
                    LDAPResult process = addRequest.process(referralConnection, i + 1);
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
            throw new LDAPException(ResultCode.TIMEOUT, LDAPMessages.ERR_ADD_CLIENT_TIMEOUT.get(Long.valueOf(nanosToMillis), lDAPConnection.getHostPort()));
        }
        lDAPConnection.getConnectionStatistics().incrementNumAddResponses(System.nanoTime() - j);
        if (lDAPResponse instanceof ConnectionClosedResponse) {
            ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) lDAPResponse;
            String message = connectionClosedResponse.getMessage();
            if (message == null) {
                throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_ADD_RESPONSE.get(lDAPConnection.getHostPort(), toString()));
            }
            throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_ADD_RESPONSE_WITH_MESSAGE.get(lDAPConnection.getHostPort(), toString(), message));
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
        lDAPConnection.getConnectionStatistics().incrementNumAddRequests();
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

    public void addAttribute(Attribute attribute) {
        Validator.ensureNotNull(attribute);
        for (int i = 0; i < this.attributes.size(); i++) {
            Attribute attribute2 = this.attributes.get(i);
            if (attribute2.getName().equalsIgnoreCase(attribute.getName())) {
                this.attributes.set(i, Attribute.mergeAttributes(attribute2, attribute));
                return;
            }
        }
        this.attributes.add(attribute);
    }

    public void addAttribute(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        addAttribute(new Attribute(str, str2));
    }

    public void addAttribute(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        addAttribute(new Attribute(str, bArr));
    }

    public void addAttribute(String str, String... strArr) {
        Validator.ensureNotNull(str, strArr);
        addAttribute(new Attribute(str, strArr));
    }

    public void addAttribute(String str, byte[]... bArr) {
        Validator.ensureNotNull(str, bArr);
        addAttribute(new Attribute(str, bArr));
    }

    public AddRequest duplicate() {
        return duplicate(getControls());
    }

    public AddRequest duplicate(Control[] controlArr) {
        AddRequest addRequest = new AddRequest(this.f7266dn, (Collection<Attribute>) new ArrayList(this.attributes), controlArr);
        if (followReferralsInternal() != null) {
            addRequest.setFollowReferrals(followReferralsInternal());
        }
        addRequest.setResponseTimeoutMillis(getResponseTimeoutMillis((LDAPConnection) null));
        return addRequest;
    }

    /* access modifiers changed from: package-private */
    public ASN1Element encodeProtocolOp() {
        ASN1Element[] aSN1ElementArr = new ASN1Element[this.attributes.size()];
        for (int i = 0; i < aSN1ElementArr.length; i++) {
            aSN1ElementArr[i] = this.attributes.get(i).encode();
        }
        return new ASN1Sequence((byte) LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST, new ASN1OctetString(this.f7266dn), new ASN1Sequence(aSN1ElementArr));
    }

    public Attribute getAttribute(String str) {
        Validator.ensureNotNull(str);
        Iterator<Attribute> it = this.attributes.iterator();
        while (it.hasNext()) {
            Attribute next = it.next();
            if (next.getName().equalsIgnoreCase(str)) {
                return next;
            }
        }
        return null;
    }

    public List<Attribute> getAttributes() {
        return Collections.unmodifiableList(this.attributes);
    }

    public String getDN() {
        return this.f7266dn;
    }

    public int getLastMessageID() {
        return this.messageID;
    }

    public OperationType getOperationType() {
        return OperationType.ADD;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST;
    }

    public boolean hasAttribute(Attribute attribute) {
        Validator.ensureNotNull(attribute);
        Attribute attribute2 = getAttribute(attribute.getName());
        return attribute2 != null && attribute.equals(attribute2);
    }

    public boolean hasAttribute(String str) {
        return getAttribute(str) != null;
    }

    public boolean hasAttributeValue(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        Attribute attribute = getAttribute(str);
        return attribute != null && attribute.hasValue(str2);
    }

    public boolean hasAttributeValue(String str, String str2, MatchingRule matchingRule) {
        Validator.ensureNotNull(str, str2);
        Attribute attribute = getAttribute(str);
        return attribute != null && attribute.hasValue(str2, matchingRule);
    }

    public boolean hasAttributeValue(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        Attribute attribute = getAttribute(str);
        return attribute != null && attribute.hasValue(bArr);
    }

    public boolean hasAttributeValue(String str, byte[] bArr, MatchingRule matchingRule) {
        Validator.ensureNotNull(str, bArr);
        Attribute attribute = getAttribute(str);
        return attribute != null && attribute.hasValue(bArr, matchingRule);
    }

    public boolean hasObjectClass(String str) {
        return hasAttributeValue("objectClass", str);
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
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_ADD_INTERRUPTED.get(lDAPConnection.getHostPort()), e);
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
            AsyncHelper asyncHelper = new AsyncHelper(lDAPConnection, OperationType.ADD, this.messageID, asyncResultListener, getIntermediateResponseListener());
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
            lDAPConnection.getConnectionStatistics().incrementNumAddRequests();
            lDAPConnection.sendMessage(lDAPMessage);
            return asyncRequestID;
        } catch (LDAPException e) {
            Debug.debugException(e);
            lDAPConnection.deregisterResponseAcceptor(this.messageID);
            throw e;
        }
    }

    public boolean removeAttribute(String str) {
        Validator.ensureNotNull(str);
        Iterator<Attribute> it = this.attributes.iterator();
        while (it.hasNext()) {
            if (it.next().getName().equalsIgnoreCase(str)) {
                it.remove();
                return true;
            }
        }
        return false;
    }

    public boolean removeAttribute(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        int i = 0;
        while (true) {
            if (i >= this.attributes.size()) {
                i = -1;
                break;
            } else if (this.attributes.get(i).getName().equalsIgnoreCase(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return false;
        }
        Attribute attribute = this.attributes.get(i);
        Attribute removeValues = Attribute.removeValues(attribute, new Attribute(str, bArr));
        if (attribute.getRawValues().length == removeValues.getRawValues().length) {
            return false;
        }
        if (removeValues.getRawValues().length == 0) {
            this.attributes.remove(i);
            return true;
        }
        this.attributes.set(i, removeValues);
        return true;
    }

    public boolean removeAttributeValue(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        int i = 0;
        while (true) {
            if (i >= this.attributes.size()) {
                i = -1;
                break;
            } else if (this.attributes.get(i).getName().equalsIgnoreCase(str)) {
                break;
            } else {
                i++;
            }
        }
        if (i < 0) {
            return false;
        }
        Attribute attribute = this.attributes.get(i);
        Attribute removeValues = Attribute.removeValues(attribute, new Attribute(str, str2));
        if (attribute.getRawValues().length == removeValues.getRawValues().length) {
            return false;
        }
        if (removeValues.getRawValues().length == 0) {
            this.attributes.remove(i);
            return true;
        }
        this.attributes.set(i, removeValues);
        return true;
    }

    public void replaceAttribute(Attribute attribute) {
        Validator.ensureNotNull(attribute);
        for (int i = 0; i < this.attributes.size(); i++) {
            if (this.attributes.get(i).getName().equalsIgnoreCase(attribute.getName())) {
                this.attributes.set(i, attribute);
                return;
            }
        }
        this.attributes.add(attribute);
    }

    public void replaceAttribute(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        for (int i = 0; i < this.attributes.size(); i++) {
            if (this.attributes.get(i).getName().equalsIgnoreCase(str)) {
                this.attributes.set(i, new Attribute(str, str2));
                return;
            }
        }
        this.attributes.add(new Attribute(str, str2));
    }

    public void replaceAttribute(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        for (int i = 0; i < this.attributes.size(); i++) {
            if (this.attributes.get(i).getName().equalsIgnoreCase(str)) {
                this.attributes.set(i, new Attribute(str, bArr));
                return;
            }
        }
        this.attributes.add(new Attribute(str, bArr));
    }

    public void replaceAttribute(String str, String... strArr) {
        Validator.ensureNotNull(str, strArr);
        for (int i = 0; i < this.attributes.size(); i++) {
            if (this.attributes.get(i).getName().equalsIgnoreCase(str)) {
                this.attributes.set(i, new Attribute(str, strArr));
                return;
            }
        }
        this.attributes.add(new Attribute(str, strArr));
    }

    public void replaceAttribute(String str, byte[]... bArr) {
        Validator.ensureNotNull(str, bArr);
        for (int i = 0; i < this.attributes.size(); i++) {
            if (this.attributes.get(i).getName().equalsIgnoreCase(str)) {
                this.attributes.set(i, new Attribute(str, bArr));
                return;
            }
        }
        this.attributes.add(new Attribute(str, bArr));
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

    public void setAttributes(Collection<Attribute> collection) {
        Validator.ensureNotNull(collection);
        this.attributes.clear();
        this.attributes.addAll(collection);
    }

    public void setAttributes(Attribute[] attributeArr) {
        Validator.ensureNotNull(attributeArr);
        this.attributes.clear();
        this.attributes.addAll(Arrays.asList(attributeArr));
    }

    public void setDN(C3122DN dn) {
        Validator.ensureNotNull(dn);
        this.f7266dn = dn.toString();
    }

    public void setDN(String str) {
        Validator.ensureNotNull(str);
        this.f7266dn = str;
    }

    public Entry toEntry() {
        return new Entry(this.f7266dn, (Collection<Attribute>) this.attributes);
    }

    public String[] toLDIF() {
        return toLDIFChangeRecord().toLDIF();
    }

    public LDIFAddChangeRecord toLDIFChangeRecord() {
        return new LDIFAddChangeRecord(this);
    }

    public String toLDIFString() {
        return toLDIFChangeRecord().toLDIFString();
    }

    public void toString(StringBuilder sb) {
        sb.append("AddRequest(dn='");
        sb.append(this.f7266dn);
        sb.append("', attrs={");
        for (int i = 0; i < this.attributes.size(); i++) {
            if (i > 0) {
                sb.append(", ");
            }
            sb.append(this.attributes.get(i));
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
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_ADD_REQUEST);
        aSN1Buffer.addOctetString(this.f7266dn);
        ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence();
        Iterator<Attribute> it = this.attributes.iterator();
        while (it.hasNext()) {
            it.next().writeTo(aSN1Buffer);
        }
        beginSequence2.end();
        beginSequence.end();
    }
}
