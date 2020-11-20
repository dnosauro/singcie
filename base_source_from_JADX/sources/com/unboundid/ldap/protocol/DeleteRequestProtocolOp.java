package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;

@InternalUseOnly
public final class DeleteRequestProtocolOp implements ProtocolOp {
    private static final long serialVersionUID = 1577020640104649789L;

    /* renamed from: dn */
    private final String f7262dn;

    DeleteRequestProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            this.f7262dn = aSN1StreamReader.readString();
            Validator.ensureNotNull(this.f7262dn);
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_DELETE_REQUEST_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public DeleteRequestProtocolOp(String str) {
        this.f7262dn = str;
    }

    public String getDN() {
        return this.f7262dn;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("DeleteRequestProtocolOp(dn='");
        sb.append(this.f7262dn);
        sb.append("')");
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        aSN1Buffer.addOctetString((byte) LDAPMessage.PROTOCOL_OP_TYPE_DELETE_REQUEST, this.f7262dn);
    }
}
