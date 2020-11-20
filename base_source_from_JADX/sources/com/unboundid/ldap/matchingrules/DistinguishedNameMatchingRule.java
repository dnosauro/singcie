package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.C3122DN;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;

public final class DistinguishedNameMatchingRule extends MatchingRule {
    public static final String EQUALITY_RULE_NAME = "distinguishedNameMatch";
    public static final String EQUALITY_RULE_OID = "2.5.13.1";
    private static final DistinguishedNameMatchingRule INSTANCE = new DistinguishedNameMatchingRule();
    static final String LOWER_EQUALITY_RULE_NAME = StaticUtils.toLowerCase(EQUALITY_RULE_NAME);
    private static final long serialVersionUID = -2617356571703597868L;

    public static DistinguishedNameMatchingRule getInstance() {
        return INSTANCE;
    }

    public int compareValues(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_DN_ORDERING_MATCHING_NOT_SUPPORTED.get());
    }

    public String getEqualityMatchingRuleName() {
        return EQUALITY_RULE_NAME;
    }

    public String getEqualityMatchingRuleOID() {
        return EQUALITY_RULE_OID;
    }

    public String getOrderingMatchingRuleName() {
        return null;
    }

    public String getOrderingMatchingRuleOID() {
        return null;
    }

    public String getSubstringMatchingRuleName() {
        return null;
    }

    public String getSubstringMatchingRuleOID() {
        return null;
    }

    public boolean matchesSubstring(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1OctetString[] aSN1OctetStringArr, ASN1OctetString aSN1OctetString3) {
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_DN_SUBSTRING_MATCHING_NOT_SUPPORTED.get());
    }

    public ASN1OctetString normalize(ASN1OctetString aSN1OctetString) {
        try {
            return new ASN1OctetString(new C3122DN(aSN1OctetString.stringValue()).toNormalizedString());
        } catch (LDAPException e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, e.getMessage(), e);
        }
    }

    public ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b) {
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_DN_SUBSTRING_MATCHING_NOT_SUPPORTED.get());
    }

    public boolean valuesMatch(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        try {
            try {
                return new C3122DN(aSN1OctetString.stringValue()).equals((Object) new C3122DN(aSN1OctetString2.stringValue()));
            } catch (LDAPException e) {
                Debug.debugException(e);
                throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, e.getMessage(), e);
            }
        } catch (LDAPException e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, e2.getMessage(), e2);
        }
    }
}
