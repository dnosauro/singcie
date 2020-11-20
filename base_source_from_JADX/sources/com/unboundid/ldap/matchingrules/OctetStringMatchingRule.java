package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.util.StaticUtils;

public final class OctetStringMatchingRule extends AcceptAllSimpleMatchingRule {
    public static final String EQUALITY_RULE_NAME = "octetStringMatch";
    public static final String EQUALITY_RULE_OID = "2.5.13.17";
    private static final OctetStringMatchingRule INSTANCE = new OctetStringMatchingRule();
    static final String LOWER_EQUALITY_RULE_NAME = StaticUtils.toLowerCase(EQUALITY_RULE_NAME);
    static final String LOWER_ORDERING_RULE_NAME = StaticUtils.toLowerCase(ORDERING_RULE_NAME);
    static final String LOWER_SUBSTRING_RULE_NAME = StaticUtils.toLowerCase(SUBSTRING_RULE_NAME);
    public static final String ORDERING_RULE_NAME = "octetStringOrderingMatch";
    public static final String ORDERING_RULE_OID = "2.5.13.18";
    public static final String SUBSTRING_RULE_NAME = "octetStringSubstringsMatch";
    public static final String SUBSTRING_RULE_OID = "2.5.13.19";
    private static final long serialVersionUID = -5655018388491186342L;

    public static OctetStringMatchingRule getInstance() {
        return INSTANCE;
    }

    public String getEqualityMatchingRuleName() {
        return EQUALITY_RULE_NAME;
    }

    public String getEqualityMatchingRuleOID() {
        return EQUALITY_RULE_OID;
    }

    public String getOrderingMatchingRuleName() {
        return ORDERING_RULE_NAME;
    }

    public String getOrderingMatchingRuleOID() {
        return ORDERING_RULE_OID;
    }

    public String getSubstringMatchingRuleName() {
        return SUBSTRING_RULE_NAME;
    }

    public String getSubstringMatchingRuleOID() {
        return SUBSTRING_RULE_OID;
    }

    public ASN1OctetString normalize(ASN1OctetString aSN1OctetString) {
        return aSN1OctetString;
    }

    public ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b) {
        return aSN1OctetString;
    }
}
