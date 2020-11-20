package com.unboundid.ldap.protocol;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.util.InternalUseOnly;
import java.util.List;

@InternalUseOnly
public final class SearchResultDoneProtocolOp extends GenericResponseProtocolOp {
    private static final long serialVersionUID = -8246922907244250622L;

    public SearchResultDoneProtocolOp(int i, String str, String str2, List<String> list) {
        super(LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, i, str, str2, list);
    }

    SearchResultDoneProtocolOp(ASN1StreamReader aSN1StreamReader) {
        super(aSN1StreamReader);
    }
}
