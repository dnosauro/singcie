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
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public class ExtendedRequest extends LDAPRequest implements ProtocolOp, ResponseAcceptor {
    protected static final byte TYPE_EXTENDED_REQUEST_OID = Byte.MIN_VALUE;
    protected static final byte TYPE_EXTENDED_REQUEST_VALUE = -127;
    private static final long serialVersionUID = 5572410770060685796L;
    private int messageID = -1;
    private final String oid;
    private final LinkedBlockingQueue<LDAPResponse> responseQueue = new LinkedBlockingQueue<>();
    private final ASN1OctetString value;

    protected ExtendedRequest(ExtendedRequest extendedRequest) {
        super(extendedRequest.getControls());
        this.oid = extendedRequest.oid;
        this.value = extendedRequest.value;
    }

    public ExtendedRequest(String str) {
        super((Control[]) null);
        Validator.ensureNotNull(str);
        this.oid = str;
        this.value = null;
    }

    public ExtendedRequest(String str, ASN1OctetString aSN1OctetString) {
        super((Control[]) null);
        Validator.ensureNotNull(str);
        this.oid = str;
        this.value = aSN1OctetString;
    }

    public ExtendedRequest(String str, ASN1OctetString aSN1OctetString, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(str);
        this.oid = str;
        this.value = aSN1OctetString;
    }

    public ExtendedRequest(String str, Control[] controlArr) {
        super(controlArr);
        Validator.ensureNotNull(str);
        this.oid = str;
        this.value = null;
    }

    private ExtendedResult handleResponse(LDAPConnection lDAPConnection, LDAPResponse lDAPResponse, long j) {
        if (lDAPResponse == null) {
            long nanosToMillis = StaticUtils.nanosToMillis(System.nanoTime() - j);
            if (lDAPConnection.getConnectionOptions().abandonOnTimeout()) {
                lDAPConnection.abandon(this.messageID, new Control[0]);
            }
            throw new LDAPException(ResultCode.TIMEOUT, LDAPMessages.ERR_EXTENDED_CLIENT_TIMEOUT.get(Long.valueOf(nanosToMillis), lDAPConnection.getHostPort()));
        } else if (lDAPResponse instanceof ConnectionClosedResponse) {
            ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) lDAPResponse;
            String message = connectionClosedResponse.getMessage();
            if (message == null) {
                throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_EXTENDED_RESPONSE.get(lDAPConnection.getHostPort(), toString()));
            }
            throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_EXTENDED_RESPONSE_WITH_MESSAGE.get(lDAPConnection.getHostPort(), toString(), message));
        } else {
            lDAPConnection.getConnectionStatistics().incrementNumExtendedResponses(System.nanoTime() - j);
            return (ExtendedResult) lDAPResponse;
        }
    }

    private ExtendedResult processSync(LDAPConnection lDAPConnection) {
        this.messageID = lDAPConnection.nextMessageID();
        LDAPMessage lDAPMessage = new LDAPMessage(this.messageID, (ProtocolOp) this, getControls());
        try {
            lDAPConnection.getConnectionInternals().getSocket().setSoTimeout((int) getResponseTimeoutMillis(lDAPConnection));
        } catch (Exception e) {
            Debug.debugException(e);
        }
        long nanoTime = System.nanoTime();
        Debug.debugLDAPRequest(this);
        lDAPConnection.getConnectionStatistics().incrementNumExtendedRequests();
        lDAPConnection.sendMessage(lDAPMessage);
        while (true) {
            try {
                LDAPResponse readResponse = lDAPConnection.readResponse(this.messageID);
                if (!(readResponse instanceof IntermediateResponse)) {
                    return handleResponse(lDAPConnection, readResponse, nanoTime);
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

    public ExtendedRequest duplicate() {
        return duplicate(getControls());
    }

    public ExtendedRequest duplicate(Control[] controlArr) {
        ExtendedRequest extendedRequest = new ExtendedRequest(this.oid, this.value, controlArr);
        extendedRequest.setResponseTimeoutMillis(getResponseTimeoutMillis((LDAPConnection) null));
        return extendedRequest;
    }

    /* access modifiers changed from: package-private */
    public ASN1Element encodeProtocolOp() {
        return new ASN1Sequence((byte) LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST, this.value == null ? new ASN1Element[]{new ASN1OctetString(Byte.MIN_VALUE, this.oid)} : new ASN1Element[]{new ASN1OctetString(Byte.MIN_VALUE, this.oid), new ASN1OctetString((byte) -127, this.value.getValue())});
    }

    public String getExtendedRequestName() {
        return this.oid;
    }

    public final int getLastMessageID() {
        return this.messageID;
    }

    public final String getOID() {
        return this.oid;
    }

    public final OperationType getOperationType() {
        return OperationType.EXTENDED;
    }

    public final byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST;
    }

    public final ASN1OctetString getValue() {
        return this.value;
    }

    public final boolean hasValue() {
        return this.value != null;
    }

    /* access modifiers changed from: protected */
    public ExtendedResult process(LDAPConnection lDAPConnection, int i) {
        if (lDAPConnection.synchronousMode()) {
            return processSync(lDAPConnection);
        }
        this.messageID = lDAPConnection.nextMessageID();
        LDAPMessage lDAPMessage = new LDAPMessage(this.messageID, (ProtocolOp) this, getControls());
        lDAPConnection.registerResponseAcceptor(this.messageID, this);
        try {
            Debug.debugLDAPRequest(this);
            long nanoTime = System.nanoTime();
            lDAPConnection.getConnectionStatistics().incrementNumExtendedRequests();
            lDAPConnection.sendMessage(lDAPMessage);
            long responseTimeoutMillis = getResponseTimeoutMillis(lDAPConnection);
            ExtendedResult handleResponse = handleResponse(lDAPConnection, (LDAPResponse) (responseTimeoutMillis > 0 ? this.responseQueue.poll(responseTimeoutMillis, TimeUnit.MILLISECONDS) : this.responseQueue.take()), nanoTime);
            lDAPConnection.deregisterResponseAcceptor(this.messageID);
            return handleResponse;
        } catch (InterruptedException e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_EXTOP_INTERRUPTED.get(lDAPConnection.getHostPort()), e);
        } catch (Throwable th) {
            lDAPConnection.deregisterResponseAcceptor(this.messageID);
            throw th;
        }
    }

    @InternalUseOnly
    public final void responseReceived(LDAPResponse lDAPResponse) {
        try {
            this.responseQueue.put(lDAPResponse);
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_EXCEPTION_HANDLING_RESPONSE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public void toString(StringBuilder sb) {
        sb.append("ExtendedRequest(oid='");
        sb.append(this.oid);
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

    public final void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST);
        aSN1Buffer.addOctetString(Byte.MIN_VALUE, this.oid);
        ASN1OctetString aSN1OctetString = this.value;
        if (aSN1OctetString != null) {
            aSN1Buffer.addOctetString((byte) -127, aSN1OctetString.getValue());
        }
        beginSequence.end();
    }
}
