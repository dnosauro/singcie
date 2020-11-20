package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.StaticUtils;

public final class TelephoneNumberMatchingRule extends SimpleMatchingRule {
    public static final String EQUALITY_RULE_NAME = "telephoneNumberMatch";
    public static final String EQUALITY_RULE_OID = "2.5.13.20";
    private static final TelephoneNumberMatchingRule INSTANCE = new TelephoneNumberMatchingRule();
    static final String LOWER_EQUALITY_RULE_NAME = StaticUtils.toLowerCase(EQUALITY_RULE_NAME);
    static final String LOWER_SUBSTRING_RULE_NAME = StaticUtils.toLowerCase(SUBSTRING_RULE_NAME);
    public static final String SUBSTRING_RULE_NAME = "telephoneNumberSubstringsMatch";
    public static final String SUBSTRING_RULE_OID = "2.5.13.21";
    private static final long serialVersionUID = -5463096544849211252L;

    public static TelephoneNumberMatchingRule getInstance() {
        return INSTANCE;
    }

    public int compareValues(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_TELEPHONE_NUMBER_ORDERING_MATCHING_NOT_SUPPORTED.get());
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
        return SUBSTRING_RULE_NAME;
    }

    public String getSubstringMatchingRuleOID() {
        return SUBSTRING_RULE_OID;
    }

    public ASN1OctetString normalize(ASN1OctetString aSN1OctetString) {
        byte b;
        byte[] value = aSN1OctetString.getValue();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < value.length; i++) {
            byte b2 = value[i];
            if (b2 != 32) {
                if (!(b2 == 58 || b2 == 61 || b2 == 63)) {
                    switch (b2) {
                        case 39:
                        case 40:
                        case 41:
                            break;
                        default:
                            switch (b2) {
                                case 43:
                                case 44:
                                case 46:
                                case 47:
                                    break;
                                case 45:
                                    continue;
                                default:
                                    byte b3 = value[i];
                                    if ((b3 >= 48 && b3 <= 57) || ((b3 >= 97 && b3 <= 122) || (b3 >= 65 && b3 <= 90))) {
                                        b = value[i];
                                        break;
                                    } else {
                                        throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_TELEPHONE_NUMBER_INVALID_CHARACTER.get(Integer.valueOf(i)));
                                    }
                            }
                    }
                }
                b = value[i];
                sb.append((char) b);
            }
        }
        return new ASN1OctetString(sb.toString());
    }

    public ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b) {
        return normalize(aSN1OctetString);
    }
}
