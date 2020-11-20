package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.util.InternalUseOnly;
import java.util.List;

@InternalUseOnly
public final class ModifyResponseProtocolOp extends GenericResponseProtocolOp {
    private static final long serialVersionUID = -6850364658234891786L;

    public ModifyResponseProtocolOp(int i, String str, String str2, List<String> list) {
        super(LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_RESPONSE, i, str, str2, list);
    }

    ModifyResponseProtocolOp(ASN1StreamReader aSN1StreamReader) {
        super(aSN1StreamReader);
    }
}
