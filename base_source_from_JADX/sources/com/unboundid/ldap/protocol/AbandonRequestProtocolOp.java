package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;

@InternalUseOnly
public final class AbandonRequestProtocolOp implements ProtocolOp {
    private static final long serialVersionUID = -7824390696388231825L;
    private final int idToAbandon;

    public AbandonRequestProtocolOp(int i) {
        this.idToAbandon = i;
    }

    AbandonRequestProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            this.idToAbandon = aSN1StreamReader.readInteger().intValue();
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_ABANDON_REQUEST_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public int getIDToAbandon() {
        return this.idToAbandon;
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("AbandonRequestProtocolOp(idToAbandon=");
        sb.append(this.idToAbandon);
        sb.append(')');
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        aSN1Buffer.addInteger((byte) LDAPMessage.PROTOCOL_OP_TYPE_ABANDON_REQUEST, this.idToAbandon);
    }
}
