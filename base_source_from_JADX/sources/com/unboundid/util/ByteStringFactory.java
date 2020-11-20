package com.unboundid.util;

import com.unboundid.asn1.ASN1OctetString;

public final class ByteStringFactory {
    private static final ASN1OctetString EMPTY_VALUE = new ASN1OctetString();

    private ByteStringFactory() {
    }

    public static ByteString create() {
        return EMPTY_VALUE;
    }

    public static ByteString create(String str) {
        return new ASN1OctetString(str);
    }

    public static ByteString create(byte[] bArr) {
        return new ASN1OctetString(bArr);
    }

    public static ByteString create(byte[] bArr, int i, int i2) {
        return new ASN1OctetString(bArr, i, i2);
    }
}
