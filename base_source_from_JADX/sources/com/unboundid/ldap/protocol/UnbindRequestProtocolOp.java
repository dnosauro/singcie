package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import com.unboundid.util.InternalUseOnly;
import com.unboundid.util.StaticUtils;

@InternalUseOnly
public final class UnbindRequestProtocolOp implements ProtocolOp {
    private static final long serialVersionUID = 1703200292192488474L;

    public UnbindRequestProtocolOp() {
    }

    UnbindRequestProtocolOp(ASN1StreamReader aSN1StreamReader) {
        try {
            aSN1StreamReader.readNull();
        } catch (Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, ProtocolMessages.ERR_UNBIND_REQUEST_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e)), e);
        }
    }

    public byte getProtocolOpType() {
        return LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        toString(sb);
        return sb.toString();
    }

    public void toString(StringBuilder sb) {
        sb.append("UnbindRequestProtocolOp()");
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        aSN1Buffer.addNull(LDAPMessage.PROTOCOL_OP_TYPE_UNBIND_REQUEST);
    }
}
