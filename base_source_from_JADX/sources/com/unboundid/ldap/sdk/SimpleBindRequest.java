package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.protocol.LDAPMessage;
import com.unboundid.ldap.protocol.LDAPResponse;
import com.unboundid.ldap.protocol.ProtocolOp;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import java.util.Arrays;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;

public final class SimpleBindRequest extends BindRequest implements ProtocolOp, ResponseAcceptor {
    private static final byte CRED_TYPE_SIMPLE = Byte.MIN_VALUE;
    private static final ASN1OctetString NO_BIND_DN = new ASN1OctetString();
    private static final ASN1OctetString NO_PASSWORD = new ASN1OctetString(Byte.MIN_VALUE);
    private static final long serialVersionUID = 4725871243149974407L;
    private final ASN1OctetString bindDN;
    private int messageID;
    private final ASN1OctetString password;
    private final PasswordProvider passwordProvider;
    private final LinkedBlockingQueue<LDAPResponse> responseQueue;

    public SimpleBindRequest() {
        this(NO_BIND_DN, NO_PASSWORD, (PasswordProvider) null, NO_CONTROLS);
    }

    private SimpleBindRequest(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, PasswordProvider passwordProvider2, Control... controlArr) {
        super(controlArr);
        this.messageID = -1;
        this.responseQueue = new LinkedBlockingQueue<>();
        this.bindDN = aSN1OctetString;
        this.password = aSN1OctetString2;
        this.passwordProvider = passwordProvider2;
    }

    public SimpleBindRequest(C3122DN dn, PasswordProvider passwordProvider2, Control... controlArr) {
        super(controlArr);
        this.messageID = -1;
        this.responseQueue = new LinkedBlockingQueue<>();
        this.bindDN = new ASN1OctetString(dn.toString());
        this.passwordProvider = passwordProvider2;
        this.password = null;
    }

    public SimpleBindRequest(C3122DN dn, String str) {
        this(dn, str, NO_CONTROLS);
    }

    public SimpleBindRequest(C3122DN dn, String str, Control... controlArr) {
        super(controlArr);
        this.messageID = -1;
        this.responseQueue = new LinkedBlockingQueue<>();
        if (dn == null) {
            this.bindDN = NO_BIND_DN;
        } else {
            this.bindDN = new ASN1OctetString(dn.toString());
        }
        this.password = str == null ? NO_PASSWORD : new ASN1OctetString(Byte.MIN_VALUE, str);
        this.passwordProvider = null;
    }

    public SimpleBindRequest(C3122DN dn, byte[] bArr) {
        this(dn, bArr, NO_CONTROLS);
    }

    public SimpleBindRequest(C3122DN dn, byte[] bArr, Control... controlArr) {
        super(controlArr);
        this.messageID = -1;
        this.responseQueue = new LinkedBlockingQueue<>();
        if (dn == null) {
            this.bindDN = NO_BIND_DN;
        } else {
            this.bindDN = new ASN1OctetString(dn.toString());
        }
        this.password = bArr == null ? NO_PASSWORD : new ASN1OctetString(Byte.MIN_VALUE, bArr);
        this.passwordProvider = null;
    }

    public SimpleBindRequest(String str, PasswordProvider passwordProvider2, Control... controlArr) {
        super(controlArr);
        this.messageID = -1;
        this.responseQueue = new LinkedBlockingQueue<>();
        this.bindDN = new ASN1OctetString(str);
        this.passwordProvider = passwordProvider2;
        this.password = null;
    }

    public SimpleBindRequest(String str, String str2) {
        this(str, str2, NO_CONTROLS);
    }

    public SimpleBindRequest(String str, String str2, Control... controlArr) {
        super(controlArr);
        this.messageID = -1;
        this.responseQueue = new LinkedBlockingQueue<>();
        if (str == null) {
            this.bindDN = NO_BIND_DN;
        } else {
            this.bindDN = new ASN1OctetString(str);
        }
        this.password = str2 == null ? NO_PASSWORD : new ASN1OctetString(Byte.MIN_VALUE, str2);
        this.passwordProvider = null;
    }

    public SimpleBindRequest(String str, byte[] bArr) {
        this(str, bArr, NO_CONTROLS);
    }

    public SimpleBindRequest(String str, byte[] bArr, Control... controlArr) {
        super(controlArr);
        this.messageID = -1;
        this.responseQueue = new LinkedBlockingQueue<>();
        if (str == null) {
            this.bindDN = NO_BIND_DN;
        } else {
            this.bindDN = new ASN1OctetString(str);
        }
        this.password = bArr == null ? NO_PASSWORD : new ASN1OctetString(Byte.MIN_VALUE, bArr);
        this.passwordProvider = null;
    }

    private BindResult handleResponse(LDAPConnection lDAPConnection, LDAPResponse lDAPResponse, long j) {
        if (lDAPResponse != null) {
            lDAPConnection.getConnectionStatistics().incrementNumBindResponses(System.nanoTime() - j);
            if (!(lDAPResponse instanceof ConnectionClosedResponse)) {
                return (BindResult) lDAPResponse;
            }
            ConnectionClosedResponse connectionClosedResponse = (ConnectionClosedResponse) lDAPResponse;
            String message = connectionClosedResponse.getMessage();
            if (message == null) {
                throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_BIND_RESPONSE.get(lDAPConnection.getHostPort(), toString()));
            }
            throw new LDAPException(connectionClosedResponse.getResultCode(), LDAPMessages.ERR_CONN_CLOSED_WAITING_FOR_BIND_RESPONSE_WITH_MESSAGE.get(lDAPConnection.getHostPort(), toString(), message));
        }
        long nanosToMillis = StaticUtils.nanosToMillis(System.nanoTime() - j);
        throw new LDAPException(ResultCode.TIMEOUT, LDAPMessages.ERR_BIND_CLIENT_TIMEOUT.get(Long.valueOf(nanosToMillis), lDAPConnection.getHostPort()));
    }

    private BindResult processSync(LDAPConnection lDAPConnection) {
        this.messageID = lDAPConnection.nextMessageID();
        LDAPMessage lDAPMessage = new LDAPMessage(this.messageID, (ProtocolOp) this, getControls());
        try {
            lDAPConnection.getConnectionInternals().getSocket().setSoTimeout((int) getResponseTimeoutMillis(lDAPConnection));
        } catch (Exception e) {
            Debug.debugException(e);
        }
        long nanoTime = System.nanoTime();
        Debug.debugLDAPRequest(this);
        lDAPConnection.getConnectionStatistics().incrementNumBindRequests();
        lDAPConnection.sendMessage(lDAPMessage);
        while (true) {
            LDAPResponse readResponse = lDAPConnection.readResponse(this.messageID);
            if (!(readResponse instanceof IntermediateResponse)) {
                return handleResponse(lDAPConnection, readResponse, nanoTime);
            }
            IntermediateResponseListener intermediateResponseListener = getIntermediateResponseListener();
            if (intermediateResponseListener != null) {
                intermediateResponseListener.intermediateResponseReturned((IntermediateResponse) readResponse);
            }
        }
    }

    public SimpleBindRequest duplicate() {
        return duplicate(getControls());
    }

    public SimpleBindRequest duplicate(Control[] controlArr) {
        SimpleBindRequest simpleBindRequest = new SimpleBindRequest(this.bindDN, this.password, this.passwordProvider, controlArr);
        simpleBindRequest.setResponseTimeoutMillis(getResponseTimeoutMillis((LDAPConnection) null));
        return simpleBindRequest;
    }

    public String getBindDN() {
        return this.bindDN.stringValue();
    }

    public String getBindType() {
        return "SIMPLE";
    }

    public int getLastMessageID() {
        return this.messageID;
    }

    public ASN1OctetString getPassword() {
        return this.password;
    }

    public PasswordProvider getPasswordProvider() {
        return this.passwordProvider;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST;
    }

    public SimpleBindRequest getRebindRequest(String str, int i) {
        return new SimpleBindRequest(this.bindDN, this.password, this.passwordProvider, getControls());
    }

    /* access modifiers changed from: protected */
    public BindResult process(LDAPConnection lDAPConnection, int i) {
        if (lDAPConnection.synchronousMode()) {
            return processSync(lDAPConnection);
        }
        if (this.password == null || this.bindDN.getValue().length <= 0 || this.password.getValue().length != 0 || !lDAPConnection.getConnectionOptions().bindWithDNRequiresPassword()) {
            this.messageID = lDAPConnection.nextMessageID();
            LDAPMessage lDAPMessage = new LDAPMessage(this.messageID, (ProtocolOp) this, getControls());
            lDAPConnection.registerResponseAcceptor(this.messageID, this);
            try {
                Debug.debugLDAPRequest(this);
                long nanoTime = System.nanoTime();
                lDAPConnection.getConnectionStatistics().incrementNumBindRequests();
                lDAPConnection.sendMessage(lDAPMessage);
                long responseTimeoutMillis = getResponseTimeoutMillis(lDAPConnection);
                BindResult handleResponse = handleResponse(lDAPConnection, (LDAPResponse) (responseTimeoutMillis > 0 ? this.responseQueue.poll(responseTimeoutMillis, TimeUnit.MILLISECONDS) : this.responseQueue.take()), nanoTime);
                lDAPConnection.deregisterResponseAcceptor(this.messageID);
                return handleResponse;
            } catch (InterruptedException e) {
                Debug.debugException(e);
                throw new LDAPException(ResultCode.LOCAL_ERROR, LDAPMessages.ERR_BIND_INTERRUPTED.get(lDAPConnection.getHostPort()), e);
            } catch (Throwable th) {
                lDAPConnection.deregisterResponseAcceptor(this.messageID);
                throw th;
            }
        } else {
            LDAPException lDAPException = new LDAPException(ResultCode.PARAM_ERROR, LDAPMessages.ERR_SIMPLE_BIND_DN_WITHOUT_PASSWORD.get());
            Debug.debugCodingError(lDAPException);
            throw lDAPException;
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

    public void toString(StringBuilder sb) {
        sb.append("SimpleBindRequest(dn='");
        sb.append(this.bindDN);
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
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST);
        aSN1Buffer.addElement(VERSION_ELEMENT);
        aSN1Buffer.addElement(this.bindDN);
        PasswordProvider passwordProvider2 = this.passwordProvider;
        if (passwordProvider2 == null) {
            aSN1Buffer.addElement(this.password);
        } else {
            try {
                byte[] passwordBytes = passwordProvider2.getPasswordBytes();
                aSN1Buffer.addElement(new ASN1OctetString(Byte.MIN_VALUE, passwordBytes));
                aSN1Buffer.setZeroBufferOnClear();
                Arrays.fill(passwordBytes, (byte) 0);
            } catch (LDAPException e) {
                Debug.debugException(e);
                throw new LDAPRuntimeException(e);
            }
        }
        beginSequence.end();
    }
}
