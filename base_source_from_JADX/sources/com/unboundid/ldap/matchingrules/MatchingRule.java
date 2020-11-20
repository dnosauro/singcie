package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.schema.AttributeTypeDefinition;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.StaticUtils;
import java.io.Serializable;

public abstract class MatchingRule implements Serializable {
    public static final byte SUBSTRING_TYPE_SUBANY = -127;
    public static final byte SUBSTRING_TYPE_SUBFINAL = -126;
    public static final byte SUBSTRING_TYPE_SUBINITIAL = Byte.MIN_VALUE;
    private static final long serialVersionUID = 6050276733546358513L;

    protected MatchingRule() {
    }

    public static MatchingRule getDefaultEqualityMatchingRule() {
        return CaseIgnoreStringMatchingRule.getInstance();
    }

    public static MatchingRule getDefaultOrderingMatchingRule() {
        return CaseIgnoreStringMatchingRule.getInstance();
    }

    public static MatchingRule getDefaultSubstringMatchingRule() {
        return CaseIgnoreStringMatchingRule.getInstance();
    }

    public static MatchingRule selectEqualityMatchingRule(String str) {
        if (str == null || str.length() == 0) {
            return getDefaultEqualityMatchingRule();
        }
        String lowerCase = StaticUtils.toLowerCase(str);
        return (lowerCase.equals(BooleanMatchingRule.LOWER_EQUALITY_RULE_NAME) || lowerCase.equals(BooleanMatchingRule.EQUALITY_RULE_OID)) ? BooleanMatchingRule.getInstance() : (lowerCase.equals(CaseExactStringMatchingRule.LOWER_EQUALITY_RULE_NAME) || lowerCase.equals(CaseExactStringMatchingRule.EQUALITY_RULE_OID) || lowerCase.equals("caseexactia5match") || lowerCase.equals("1.3.6.1.4.1.1466.109.114.1")) ? CaseExactStringMatchingRule.getInstance() : (lowerCase.equals(CaseIgnoreListMatchingRule.LOWER_EQUALITY_RULE_NAME) || lowerCase.equals(CaseIgnoreListMatchingRule.EQUALITY_RULE_OID)) ? CaseIgnoreListMatchingRule.getInstance() : (lowerCase.equals(CaseIgnoreStringMatchingRule.LOWER_EQUALITY_RULE_NAME) || lowerCase.equals(CaseIgnoreStringMatchingRule.EQUALITY_RULE_OID) || lowerCase.equals("caseignoreia5match") || lowerCase.equals("1.3.6.1.4.1.1466.109.114.2")) ? CaseIgnoreStringMatchingRule.getInstance() : (lowerCase.equals(DistinguishedNameMatchingRule.LOWER_EQUALITY_RULE_NAME) || lowerCase.equals(DistinguishedNameMatchingRule.EQUALITY_RULE_OID) || lowerCase.equals("uniquemembermatch") || lowerCase.equals("2.5.13.23")) ? DistinguishedNameMatchingRule.getInstance() : (lowerCase.equals(GeneralizedTimeMatchingRule.LOWER_EQUALITY_RULE_NAME) || lowerCase.equals(GeneralizedTimeMatchingRule.EQUALITY_RULE_OID)) ? GeneralizedTimeMatchingRule.getInstance() : (lowerCase.equals(IntegerMatchingRule.LOWER_EQUALITY_RULE_NAME) || lowerCase.equals(IntegerMatchingRule.EQUALITY_RULE_OID)) ? IntegerMatchingRule.getInstance() : (lowerCase.equals(NumericStringMatchingRule.LOWER_EQUALITY_RULE_NAME) || lowerCase.equals(NumericStringMatchingRule.EQUALITY_RULE_OID)) ? NumericStringMatchingRule.getInstance() : (lowerCase.equals(OctetStringMatchingRule.LOWER_EQUALITY_RULE_NAME) || lowerCase.equals(OctetStringMatchingRule.EQUALITY_RULE_OID)) ? OctetStringMatchingRule.getInstance() : (lowerCase.equals(TelephoneNumberMatchingRule.LOWER_EQUALITY_RULE_NAME) || lowerCase.equals(TelephoneNumberMatchingRule.EQUALITY_RULE_OID)) ? TelephoneNumberMatchingRule.getInstance() : getDefaultEqualityMatchingRule();
    }

    public static MatchingRule selectEqualityMatchingRule(String str, Schema schema) {
        return selectEqualityMatchingRule(str, (String) null, schema);
    }

    public static MatchingRule selectEqualityMatchingRule(String str, String str2, Schema schema) {
        if (str2 != null) {
            return selectEqualityMatchingRule(str2);
        }
        if (str == null || schema == null) {
            return getDefaultEqualityMatchingRule();
        }
        AttributeTypeDefinition attributeType = schema.getAttributeType(str);
        if (attributeType == null) {
            return getDefaultEqualityMatchingRule();
        }
        String equalityMatchingRule = attributeType.getEqualityMatchingRule(schema);
        if (equalityMatchingRule != null) {
            return selectEqualityMatchingRule(equalityMatchingRule);
        }
        String baseSyntaxOID = attributeType.getBaseSyntaxOID(schema);
        return baseSyntaxOID != null ? selectMatchingRuleForSyntax(baseSyntaxOID) : getDefaultEqualityMatchingRule();
    }

    static MatchingRule selectMatchingRuleForSyntax(String str) {
        return str.equals("1.3.6.1.4.1.1466.115.121.1.7") ? BooleanMatchingRule.getInstance() : str.equals("1.3.6.1.4.1.1466.115.121.1.41") ? CaseIgnoreListMatchingRule.getInstance() : (str.equals("1.3.6.1.4.1.1466.115.121.1.12") || str.equals("1.3.6.1.4.1.1466.115.121.1.34")) ? DistinguishedNameMatchingRule.getInstance() : (str.equals("1.3.6.1.4.1.1466.115.121.1.24") || str.equals("1.3.6.1.4.1.1466.115.121.1.53")) ? GeneralizedTimeMatchingRule.getInstance() : str.equals("1.3.6.1.4.1.1466.115.121.1.27") ? IntegerMatchingRule.getInstance() : str.equals("1.3.6.1.4.1.1466.115.121.1.36") ? NumericStringMatchingRule.getInstance() : (str.equals("1.3.6.1.4.1.4203.1.1.2") || str.equals("1.3.6.1.4.1.1466.115.121.1.5") || str.equals("1.3.6.1.4.1.1466.115.121.1.8") || str.equals("1.3.6.1.4.1.1466.115.121.1.9") || str.equals("1.3.6.1.4.1.1466.115.121.1.10") || str.equals("1.3.6.1.4.1.1466.115.121.1.28") || str.equals("1.3.6.1.4.1.1466.115.121.1.40")) ? OctetStringMatchingRule.getInstance() : str.equals("1.3.6.1.4.1.1466.115.121.1.50") ? TelephoneNumberMatchingRule.getInstance() : CaseIgnoreStringMatchingRule.getInstance();
    }

    public static MatchingRule selectOrderingMatchingRule(String str) {
        if (str == null || str.length() == 0) {
            return getDefaultOrderingMatchingRule();
        }
        String lowerCase = StaticUtils.toLowerCase(str);
        return (lowerCase.equals(CaseExactStringMatchingRule.LOWER_ORDERING_RULE_NAME) || lowerCase.equals(CaseExactStringMatchingRule.ORDERING_RULE_OID)) ? CaseExactStringMatchingRule.getInstance() : (lowerCase.equals(CaseIgnoreStringMatchingRule.LOWER_ORDERING_RULE_NAME) || lowerCase.equals(CaseIgnoreStringMatchingRule.ORDERING_RULE_OID)) ? CaseIgnoreStringMatchingRule.getInstance() : (lowerCase.equals(GeneralizedTimeMatchingRule.LOWER_ORDERING_RULE_NAME) || lowerCase.equals(GeneralizedTimeMatchingRule.ORDERING_RULE_OID)) ? GeneralizedTimeMatchingRule.getInstance() : (lowerCase.equals(IntegerMatchingRule.LOWER_ORDERING_RULE_NAME) || lowerCase.equals(IntegerMatchingRule.ORDERING_RULE_OID)) ? IntegerMatchingRule.getInstance() : (lowerCase.equals(NumericStringMatchingRule.LOWER_ORDERING_RULE_NAME) || lowerCase.equals(NumericStringMatchingRule.ORDERING_RULE_OID)) ? NumericStringMatchingRule.getInstance() : (lowerCase.equals(OctetStringMatchingRule.LOWER_ORDERING_RULE_NAME) || lowerCase.equals(OctetStringMatchingRule.ORDERING_RULE_OID)) ? OctetStringMatchingRule.getInstance() : getDefaultOrderingMatchingRule();
    }

    public static MatchingRule selectOrderingMatchingRule(String str, Schema schema) {
        return selectOrderingMatchingRule(str, (String) null, schema);
    }

    public static MatchingRule selectOrderingMatchingRule(String str, String str2, Schema schema) {
        if (str2 != null) {
            return selectOrderingMatchingRule(str2);
        }
        if (str == null || schema == null) {
            return getDefaultOrderingMatchingRule();
        }
        AttributeTypeDefinition attributeType = schema.getAttributeType(str);
        if (attributeType == null) {
            return getDefaultOrderingMatchingRule();
        }
        String orderingMatchingRule = attributeType.getOrderingMatchingRule(schema);
        if (orderingMatchingRule != null) {
            return selectOrderingMatchingRule(orderingMatchingRule);
        }
        String baseSyntaxOID = attributeType.getBaseSyntaxOID(schema);
        return baseSyntaxOID != null ? selectMatchingRuleForSyntax(baseSyntaxOID) : getDefaultOrderingMatchingRule();
    }

    public static MatchingRule selectSubstringMatchingRule(String str) {
        if (str == null || str.length() == 0) {
            return getDefaultSubstringMatchingRule();
        }
        String lowerCase = StaticUtils.toLowerCase(str);
        return (lowerCase.equals(CaseExactStringMatchingRule.LOWER_SUBSTRING_RULE_NAME) || lowerCase.equals(CaseExactStringMatchingRule.SUBSTRING_RULE_OID) || lowerCase.equals("caseexactia5substringsmatch")) ? CaseExactStringMatchingRule.getInstance() : (lowerCase.equals(CaseIgnoreListMatchingRule.LOWER_SUBSTRING_RULE_NAME) || lowerCase.equals(CaseIgnoreListMatchingRule.SUBSTRING_RULE_OID)) ? CaseIgnoreListMatchingRule.getInstance() : (lowerCase.equals(CaseIgnoreStringMatchingRule.LOWER_SUBSTRING_RULE_NAME) || lowerCase.equals(CaseIgnoreStringMatchingRule.SUBSTRING_RULE_OID) || lowerCase.equals("caseignoreia5substringsmatch") || lowerCase.equals("1.3.6.1.4.1.1466.109.114.3")) ? CaseIgnoreStringMatchingRule.getInstance() : (lowerCase.equals(NumericStringMatchingRule.LOWER_SUBSTRING_RULE_NAME) || lowerCase.equals(NumericStringMatchingRule.SUBSTRING_RULE_OID)) ? NumericStringMatchingRule.getInstance() : (lowerCase.equals(OctetStringMatchingRule.LOWER_SUBSTRING_RULE_NAME) || lowerCase.equals(OctetStringMatchingRule.SUBSTRING_RULE_OID)) ? OctetStringMatchingRule.getInstance() : (lowerCase.equals(TelephoneNumberMatchingRule.LOWER_SUBSTRING_RULE_NAME) || lowerCase.equals(TelephoneNumberMatchingRule.SUBSTRING_RULE_OID)) ? TelephoneNumberMatchingRule.getInstance() : getDefaultSubstringMatchingRule();
    }

    public static MatchingRule selectSubstringMatchingRule(String str, Schema schema) {
        return selectSubstringMatchingRule(str, (String) null, schema);
    }

    public static MatchingRule selectSubstringMatchingRule(String str, String str2, Schema schema) {
        if (str2 != null) {
            return selectSubstringMatchingRule(str2);
        }
        if (str == null || schema == null) {
            return getDefaultSubstringMatchingRule();
        }
        AttributeTypeDefinition attributeType = schema.getAttributeType(str);
        if (attributeType == null) {
            return getDefaultSubstringMatchingRule();
        }
        String substringMatchingRule = attributeType.getSubstringMatchingRule(schema);
        if (substringMatchingRule != null) {
            return selectSubstringMatchingRule(substringMatchingRule);
        }
        String baseSyntaxOID = attributeType.getBaseSyntaxOID(schema);
        return baseSyntaxOID != null ? selectMatchingRuleForSyntax(baseSyntaxOID) : getDefaultSubstringMatchingRule();
    }

    public abstract int compareValues(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2);

    public abstract String getEqualityMatchingRuleName();

    public abstract String getEqualityMatchingRuleOID();

    public abstract String getOrderingMatchingRuleName();

    public abstract String getOrderingMatchingRuleOID();

    public abstract String getSubstringMatchingRuleName();

    public abstract String getSubstringMatchingRuleOID();

    public abstract boolean matchesSubstring(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1OctetString[] aSN1OctetStringArr, ASN1OctetString aSN1OctetString3);

    public abstract ASN1OctetString normalize(ASN1OctetString aSN1OctetString);

    public abstract ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b);

    public abstract boolean valuesMatch(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2);
}
