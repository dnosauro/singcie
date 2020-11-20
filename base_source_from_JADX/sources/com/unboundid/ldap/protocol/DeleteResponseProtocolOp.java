package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.util.InternalUseOnly;
import java.util.List;

@InternalUseOnly
public final class DeleteResponseProtocolOp extends GenericResponseProtocolOp {
    private static final long serialVersionUID = -7372719058693583245L;

    public DeleteResponseProtocolOp(int i, String str, String str2, List<String> list) {
        super(LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE, i, str, str2, list);
    }

    DeleteResponseProtocolOp(ASN1StreamReader aSN1StreamReader) {
        super(aSN1StreamReader);
    }
}
