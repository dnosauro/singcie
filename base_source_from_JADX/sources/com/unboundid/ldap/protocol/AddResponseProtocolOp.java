package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.util.InternalUseOnly;
import java.util.List;

@InternalUseOnly
public final class AddResponseProtocolOp extends GenericResponseProtocolOp {
    private static final long serialVersionUID = 5870546796977558902L;

    public AddResponseProtocolOp(int i, String str, String str2, List<String> list) {
        super(LDAPMessage.PROTOCOL_OP_TYPE_ADD_RESPONSE, i, str, str2, list);
    }

    AddResponseProtocolOp(ASN1StreamReader aSN1StreamReader) {
        super(aSN1StreamReader);
    }
}
