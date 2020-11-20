package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.util.InternalUseOnly;
import java.util.List;

@InternalUseOnly
public final class ModifyDNResponseProtocolOp extends GenericResponseProtocolOp {
    private static final long serialVersionUID = -8133223270933706583L;

    public ModifyDNResponseProtocolOp(int i, String str, String str2, List<String> list) {
        super(LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE, i, str, str2, list);
    }

    ModifyDNResponseProtocolOp(ASN1StreamReader aSN1StreamReader) {
        super(aSN1StreamReader);
    }
}
