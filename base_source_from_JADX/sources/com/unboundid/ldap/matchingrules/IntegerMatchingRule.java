package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.StaticUtils;

public final class IntegerMatchingRule extends MatchingRule {
    public static final String EQUALITY_RULE_NAME = "integerMatch";
    public static final String EQUALITY_RULE_OID = "2.5.13.14";
    private static final IntegerMatchingRule INSTANCE = new IntegerMatchingRule();
    static final String LOWER_EQUALITY_RULE_NAME = StaticUtils.toLowerCase(EQUALITY_RULE_NAME);
    static final String LOWER_ORDERING_RULE_NAME = StaticUtils.toLowerCase(ORDERING_RULE_NAME);
    public static final String ORDERING_RULE_NAME = "integerOrderingMatch";
    public static final String ORDERING_RULE_OID = "2.5.13.15";
    private static final long serialVersionUID = -9056942146971528818L;

    public static IntegerMatchingRule getInstance() {
        return INSTANCE;
    }

    public int compareValues(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        byte[] value = normalize(aSN1OctetString).getValue();
        byte[] value2 = normalize(aSN1OctetString2).getValue();
        if (value[0] == 45) {
            if (value2[0] != 45) {
                return -1;
            }
            if (value.length < value2.length) {
                return 1;
            }
            if (value.length > value2.length) {
                return -1;
            }
            for (int i = 1; i < value.length; i++) {
                int i2 = value2[i] - value[i];
                if (i2 != 0) {
                    return i2;
                }
            }
            return 0;
        } else if (value2[0] == 45) {
            return 1;
        } else {
            if (value.length < value2.length) {
                return -1;
            }
            if (value.length > value2.length) {
                return 1;
            }
            for (int i3 = 0; i3 < value.length; i3++) {
                int i4 = value[i3] - value2[i3];
                if (i4 != 0) {
                    return i4;
                }
            }
            return 0;
        }
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
        return null;
    }

    public String getSubstringMatchingRuleOID() {
        return null;
    }

    public boolean matchesSubstring(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1OctetString[] aSN1OctetStringArr, ASN1OctetString aSN1OctetString3) {
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_INTEGER_SUBSTRING_MATCHING_NOT_SUPPORTED.get());
    }

    public ASN1OctetString normalize(ASN1OctetString aSN1OctetString) {
        byte[] value = aSN1OctetString.getValue();
        if (value.length == 0) {
            throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_INTEGER_ZERO_LENGTH_NOT_ALLOWED.get());
        } else if (value[0] == 32 || value[value.length - 1] == 32) {
            String trim = aSN1OctetString.stringValue().trim();
            if (trim.length() != 0) {
                for (int i = 0; i < trim.length(); i++) {
                    char charAt = trim.charAt(i);
                    if (charAt != '-') {
                        switch (charAt) {
                            case '0':
                                if ((i == 0 && trim.length() > 1) || (i == 1 && trim.charAt(0) == '-')) {
                                    throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_INTEGER_INVALID_LEADING_ZERO.get());
                                }
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                break;
                            default:
                                throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_INTEGER_INVALID_CHARACTER.get(Integer.valueOf(i)));
                        }
                    } else if (i != 0 || trim.length() == 1) {
                        throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_INTEGER_INVALID_CHARACTER.get());
                    }
                }
                return new ASN1OctetString(trim);
            }
            throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_INTEGER_ZERO_LENGTH_NOT_ALLOWED.get());
        } else {
            for (int i2 = 0; i2 < value.length; i2++) {
                byte b = value[i2];
                if (b != 45) {
                    switch (b) {
                        case 48:
                            if ((i2 == 0 && value.length > 1) || (i2 == 1 && value[0] == 45)) {
                                throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_INTEGER_INVALID_LEADING_ZERO.get());
                            }
                        case 49:
                        case 50:
                        case 51:
                        case 52:
                        case 53:
                        case 54:
                        case 55:
                        case 56:
                        case 57:
                            break;
                        default:
                            throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_INTEGER_INVALID_CHARACTER.get(Integer.valueOf(i2)));
                    }
                } else if (i2 != 0 || value.length == 1) {
                    throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_INTEGER_INVALID_CHARACTER.get());
                }
            }
            return aSN1OctetString;
        }
    }

    public ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b) {
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_INTEGER_SUBSTRING_MATCHING_NOT_SUPPORTED.get());
    }

    public boolean valuesMatch(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        return normalize(aSN1OctetString).equals(normalize(aSN1OctetString2));
    }
}
