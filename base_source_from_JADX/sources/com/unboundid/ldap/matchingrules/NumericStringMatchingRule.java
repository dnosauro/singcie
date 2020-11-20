package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.StaticUtils;

public final class NumericStringMatchingRule extends SimpleMatchingRule {
    public static final String EQUALITY_RULE_NAME = "numericStringMatch";
    public static final String EQUALITY_RULE_OID = "2.5.13.8";
    private static final NumericStringMatchingRule INSTANCE = new NumericStringMatchingRule();
    static final String LOWER_EQUALITY_RULE_NAME = StaticUtils.toLowerCase(EQUALITY_RULE_NAME);
    static final String LOWER_ORDERING_RULE_NAME = StaticUtils.toLowerCase(ORDERING_RULE_NAME);
    static final String LOWER_SUBSTRING_RULE_NAME = StaticUtils.toLowerCase(SUBSTRING_RULE_NAME);
    public static final String ORDERING_RULE_NAME = "numericStringOrderingMatch";
    public static final String ORDERING_RULE_OID = "2.5.13.9";
    public static final String SUBSTRING_RULE_NAME = "numericStringSubstringsMatch";
    public static final String SUBSTRING_RULE_OID = "2.5.13.10";
    private static final long serialVersionUID = -898484312052746321L;

    public static NumericStringMatchingRule getInstance() {
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
        byte[] value = aSN1OctetString.getValue();
        int i = 0;
        for (int i2 = 0; i2 < value.length; i2++) {
            if (value[i2] == 32) {
                i++;
            } else if (value[i2] < 48 || value[i2] > 57) {
                throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_NUMERIC_STRING_INVALID_CHARACTER.get(Integer.valueOf(i2)));
            }
        }
        if (i == 0) {
            return aSN1OctetString;
        }
        byte[] bArr = new byte[(value.length - i)];
        int i3 = 0;
        for (byte b : value) {
            if (b != 32) {
                bArr[i3] = b;
                i3++;
            }
        }
        return new ASN1OctetString(bArr);
    }

    public ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b) {
        return normalize(aSN1OctetString);
    }
}
