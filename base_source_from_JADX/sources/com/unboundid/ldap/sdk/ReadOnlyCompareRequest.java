package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1OctetString;

public interface ReadOnlyCompareRequest extends ReadOnlyLDAPRequest {
    CompareRequest duplicate();

    CompareRequest duplicate(Control[] controlArr);

    String getAssertionValue();

    byte[] getAssertionValueBytes();

    String getAttributeName();

    String getDN();

    ASN1OctetString getRawAssertionValue();
}
