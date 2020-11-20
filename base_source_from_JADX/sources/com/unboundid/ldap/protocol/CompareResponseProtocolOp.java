package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.util.InternalUseOnly;
import java.util.List;

@InternalUseOnly
public final class CompareResponseProtocolOp extends GenericResponseProtocolOp {
    private static final long serialVersionUID = 3237778285010810669L;

    public CompareResponseProtocolOp(int i, String str, String str2, List<String> list) {
        super(LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, i, str, str2, list);
    }

    CompareResponseProtocolOp(ASN1StreamReader aSN1StreamReader) {
        super(aSN1StreamReader);
    }
}
