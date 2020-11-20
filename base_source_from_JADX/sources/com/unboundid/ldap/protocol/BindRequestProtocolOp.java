package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;

@InternalUseOnly
public final class BindRequestProtocolOp implements ProtocolOp {
    public static final byte CRED_TYPE_SASL = -93;
    public static final byte CRED_TYPE_SIMPLE = Byte.MIN_VALUE;
    private static final long serialVersionUID = 6661208657485444954L;
    private final String bindDN;
    private final byte credentialsType;
    private final ASN1OctetString saslCredentials;
    private final String saslMechanism;
    private final ASN1OctetString simplePassword;
    private final int version;

    BindRequestProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            aSN1StreamReader.beginSequence();
            this.version = aSN1StreamReader.readInteger().intValue();
            this.bindDN = aSN1StreamReader.readString();
            this.credentialsType = (byte) aSN1StreamReader.peek();
            Validator.ensureNotNull(this.bindDN);
            byte b = this.credentialsType;
            if (b == Byte.MIN_VALUE) {
                this.simplePassword = new ASN1OctetString(this.credentialsType, aSN1StreamReader.readBytes());
                this.saslMechanism = null;
                this.saslCredentials = null;
                Validator.ensureNotNull(this.bindDN);
            } else if (b == -93) {
                ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
                this.saslMechanism = aSN1StreamReader.readString();
                Validator.ensureNotNull(this.saslMechanism);
                if (beginSequence.hasMoreElements()) {
                    this.saslCredentials = new ASN1OctetString(aSN1StreamReader.readBytes());
                } else {
                    this.saslCredentials = null;
                }
                this.simplePassword = null;
            } else {
                throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_BIND_REQUEST_INVALID_CRED_TYPE.get(StaticUtils.toHex(this.credentialsType)));
            }
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_BIND_REQUEST_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public BindRequestProtocolOp(String str, String str2) {
        this.bindDN = str == null ? "" : str;
        if (str2 == null) {
            this.simplePassword = new ASN1OctetString(Byte.MIN_VALUE);
        } else {
            this.simplePassword = new ASN1OctetString(Byte.MIN_VALUE, str2);
        }
        this.version = 3;
        this.credentialsType = Byte.MIN_VALUE;
        this.saslMechanism = null;
        this.saslCredentials = null;
    }

    public BindRequestProtocolOp(String str, String str2, ASN1OctetString aSN1OctetString) {
        this.saslMechanism = str2;
        this.saslCredentials = aSN1OctetString;
        this.bindDN = str == null ? "" : str;
        this.version = 3;
        this.credentialsType = -93;
        this.simplePassword = null;
    }

    public BindRequestProtocolOp(String str, byte[] bArr) {
        this.bindDN = str == null ? "" : str;
        if (bArr == null) {
            this.simplePassword = new ASN1OctetString(Byte.MIN_VALUE);
        } else {
            this.simplePassword = new ASN1OctetString(Byte.MIN_VALUE, bArr);
        }
        this.version = 3;
        this.credentialsType = Byte.MIN_VALUE;
        this.saslMechanism = null;
        this.saslCredentials = null;
    }

    public String getBindDN() {
        return this.bindDN;
    }

    public byte getCredentialsType() {
        return this.credentialsType;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST;
    }

    public ASN1OctetString getSASLCredentials() {
        return this.saslCredentials;
    }

    public String getSASLMechanism() {
        return this.saslMechanism;
    }

    public ASN1OctetString getSimplePassword() {
        return this.simplePassword;
    }

    public int getVersion() {
        return this.version;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        String str;
        sb.append("BindRequestProtocolOp(version=");
        sb.append(this.version);
        sb.append(", bindDN='");
        sb.append(this.bindDN);
        sb.append("', type=");
        if (this.credentialsType == Byte.MIN_VALUE) {
            str = "simple";
        } else {
            sb.append("SASL, mechanism=");
            str = this.saslMechanism;
        }
        sb.append(str);
        sb.append(')');
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_BIND_REQUEST);
        aSN1Buffer.addInteger(this.version);
        aSN1Buffer.addOctetString(this.bindDN);
        if (this.credentialsType == Byte.MIN_VALUE) {
            aSN1Buffer.addElement(this.simplePassword);
        } else {
            ASN1BufferSequence beginSequence2 = aSN1Buffer.beginSequence((byte) -93);
            aSN1Buffer.addOctetString(this.saslMechanism);
            ASN1OctetString aSN1OctetString = this.saslCredentials;
            if (aSN1OctetString != null) {
                aSN1Buffer.addElement(aSN1OctetString);
            }
            beginSequence2.end();
        }
        beginSequence.end();
        aSN1Buffer.setZeroBufferOnClear();
    }
}
