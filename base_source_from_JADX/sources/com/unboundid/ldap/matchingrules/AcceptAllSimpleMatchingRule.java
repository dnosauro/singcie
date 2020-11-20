package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.util.Debug;

public abstract class AcceptAllSimpleMatchingRule extends SimpleMatchingRule {
    private static final long serialVersionUID = -7450007924568660003L;

    public int compareValues(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        try {
            return super.compareValues(aSN1OctetString, aSN1OctetString2);
        } catch (LDAPException e) {
            Debug.debugException(e);
            return 0;
        }
    }

    public boolean matchesSubstring(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1OctetString[] aSN1OctetStringArr, ASN1OctetString aSN1OctetString3) {
        try {
            return super.matchesSubstring(aSN1OctetString, aSN1OctetString2, aSN1OctetStringArr, aSN1OctetString3);
        } catch (LDAPException e) {
            Debug.debugException(e);
            return false;
        }
    }

    public abstract ASN1OctetString normalize(ASN1OctetString aSN1OctetString);

    public abstract ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b);

    public boolean valuesMatch(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        return normalize(aSN1OctetString).equals(normalize(aSN1OctetString2));
    }
}
