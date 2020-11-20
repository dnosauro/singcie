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

@InternalUseOnly
public final class IntermediateResponseProtocolOp implements ProtocolOp {
    public static final byte TYPE_OID = Byte.MIN_VALUE;
    public static final byte TYPE_VALUE = -127;
    private static final long serialVersionUID = 118549806265654465L;
    private final String oid;
    private final ASN1OctetString value;

    IntermediateResponseProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            String str = null;
            ASN1OctetString aSN1OctetString = null;
            while (beginSequence.hasMoreElements()) {
                byte peek = (byte) aSN1StreamReader.peek();
                if (peek == Byte.MIN_VALUE) {
                    str = aSN1StreamReader.readString();
                } else if (peek == -127) {
                    aSN1OctetString = new ASN1OctetString(peek, aSN1StreamReader.readBytes());
                } else {
                    throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_INTERMEDIATE_RESPONSE_INVALID_ELEMENT.get(StaticUtils.toHex(peek)));
                }
            }
            this.oid = str;
            this.value = aSN1OctetString;
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw e;
        } catch (Exception e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_INTERMEDIATE_RESPONSE_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e2)), e2);
        }
    }

    public IntermediateResponseProtocolOp(String str, ASN1OctetString aSN1OctetString) {
        this.oid = str;
        this.value = aSN1OctetString == null ? null : new ASN1OctetString((byte) -127, aSN1OctetString.getValue());
    }

    public String getOID() {
        return this.oid;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE;
    }

    public ASN1OctetString getValue() {
        return this.value;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("IntermediateResponseProtocolOp(");
        if (this.oid != null) {
            sb.append("oid='");
            sb.append(this.oid);
            sb.append('\'');
        }
        sb.append(')');
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE);
        String str = this.oid;
        if (str != null) {
            aSN1Buffer.addOctetString(Byte.MIN_VALUE, str);
        }
        ASN1OctetString aSN1OctetString = this.value;
        if (aSN1OctetString != null) {
            aSN1Buffer.addElement(aSN1OctetString);
        }
        beginSequence.end();
    }
}
