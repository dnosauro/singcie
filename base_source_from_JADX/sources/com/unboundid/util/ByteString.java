package com.unboundid.util;

import com.unboundid.asn1.ASN1OctetString;
import java.io.Serializable;

public interface ByteString extends Serializable {
    void appendValueTo(ByteStringBuffer byteStringBuffer);

    byte[] getValue();

    String stringValue();

    ASN1OctetString toASN1OctetString();
}
