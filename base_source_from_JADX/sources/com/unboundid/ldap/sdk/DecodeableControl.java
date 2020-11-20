package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1OctetString;
import java.io.Serializable;

public interface DecodeableControl extends Serializable {
    Control decodeControl(String str, boolean z, ASN1OctetString aSN1OctetString);
}
