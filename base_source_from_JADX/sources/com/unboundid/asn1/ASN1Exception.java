package com.unboundid.asn1;

import com.unboundid.util.LDAPSDKException;

public final class ASN1Exception extends LDAPSDKException {
    private static final long serialVersionUID = 3234714599495723483L;

    public ASN1Exception(String str) {
        super(str);
    }

    public ASN1Exception(String str, Throwable th) {
        super(str, th);
    }
}
