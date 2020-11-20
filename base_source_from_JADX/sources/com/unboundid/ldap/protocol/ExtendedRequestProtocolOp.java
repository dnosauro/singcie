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
public final class ExtendedRequestProtocolOp implements ProtocolOp {
    public static final byte TYPE_OID = Byte.MIN_VALUE;
    public static final byte TYPE_VALUE = -127;
    private static final long serialVersionUID = -5343424210200494377L;
    private final String oid;
    private final ASN1OctetString value;

    ExtendedRequestProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
            this.oid = aSN1StreamReader.readString();
            Validator.ensureNotNull(this.oid);
            if (beginSequence.hasMoreElements()) {
                this.value = new ASN1OctetString((byte) -127, aSN1StreamReader.readBytes());
            } else {
                this.value = null;
            }
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_EXTENDED_REQUEST_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public ExtendedRequestProtocolOp(String str, ASN1OctetString aSN1OctetString) {
        this.oid = str;
        this.value = aSN1OctetString == null ? null : new ASN1OctetString((byte) -127, aSN1OctetString.getValue());
    }

    public String getOID() {
        return this.oid;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST;
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
        sb.append("ExtendedRequestProtocolOp(oid='");
        sb.append(this.oid);
        sb.append("')");
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence(LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_REQUEST);
        aSN1Buffer.addOctetString(Byte.MIN_VALUE, this.oid);
        ASN1OctetString aSN1OctetString = this.value;
        if (aSN1OctetString != null) {
            aSN1Buffer.addOctetString((byte) -127, aSN1OctetString.getValue());
        }
        beginSequence.end();
    }
}
