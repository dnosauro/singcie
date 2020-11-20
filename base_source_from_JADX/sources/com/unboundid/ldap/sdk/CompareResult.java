package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;

public final class CompareResult extends LDAPResult {
    private static final long serialVersionUID = -6061844770039020617L;

    public CompareResult(int i, ResultCode resultCode, String str, String str2, String[] strArr, Control[] controlArr) {
        super(i, resultCode, str, str2, strArr, controlArr);
    }

    public CompareResult(LDAPResult lDAPResult) {
        super(lDAPResult);
    }

    static CompareResult readCompareResultFrom(int i, ASN1StreamReaderSequence aSN1StreamReaderSequence, ASN1StreamReader aSN1StreamReader) {
        return new CompareResult(LDAPResult.readLDAPResultFrom(i, aSN1StreamReaderSequence, aSN1StreamReader));
    }

    public boolean compareMatched() {
        return getResultCode().equals(ResultCode.COMPARE_TRUE);
    }
}
