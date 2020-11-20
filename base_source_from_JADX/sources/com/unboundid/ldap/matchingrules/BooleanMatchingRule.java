package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.StaticUtils;

public final class BooleanMatchingRule extends MatchingRule {
    public static final String EQUALITY_RULE_NAME = "booleanMatch";
    public static final String EQUALITY_RULE_OID = "2.5.13.13";
    private static final ASN1OctetString FALSE_VALUE = new ASN1OctetString("FALSE");
    private static final BooleanMatchingRule INSTANCE = new BooleanMatchingRule();
    static final String LOWER_EQUALITY_RULE_NAME = StaticUtils.toLowerCase(EQUALITY_RULE_NAME);
    private static final ASN1OctetString TRUE_VALUE = new ASN1OctetString("TRUE");
    private static final long serialVersionUID = 5137725892611277972L;

    public static BooleanMatchingRule getInstance() {
        return INSTANCE;
    }

    public int compareValues(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_BOOLEAN_ORDERING_MATCHING_NOT_SUPPORTED.get());
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
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_BOOLEAN_SUBSTRING_MATCHING_NOT_SUPPORTED.get());
    }

    public ASN1OctetString normalize(ASN1OctetString aSN1OctetString) {
        byte[] value = aSN1OctetString.getValue();
        if (value.length == 4 && ((value[0] == 84 || value[0] == 116) && ((value[1] == 82 || value[1] == 114) && ((value[2] == 85 || value[2] == 117) && (value[3] == 69 || value[3] == 101))))) {
            return TRUE_VALUE;
        }
        if (value.length == 5 && ((value[0] == 70 || value[0] == 102) && ((value[1] == 65 || value[1] == 97) && ((value[2] == 76 || value[2] == 108) && ((value[3] == 83 || value[3] == 115) && (value[4] == 69 || value[4] == 101)))))) {
            return FALSE_VALUE;
        }
        throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_BOOLEAN_INVALID_VALUE.get());
    }

    public ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b) {
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_BOOLEAN_SUBSTRING_MATCHING_NOT_SUPPORTED.get());
    }

    public boolean valuesMatch(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        return normalize(aSN1OctetString).equals(normalize(aSN1OctetString2));
    }
}
