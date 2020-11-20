package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

public final class GeneralizedTimeMatchingRule extends MatchingRule {
    public static final String EQUALITY_RULE_NAME = "generalizedTimeMatch";
    public static final String EQUALITY_RULE_OID = "2.5.13.27";
    private static final String GENERALIZED_TIME_DATE_FORMAT = "yyyyMMddHHmmss.SSS'Z'";
    private static final GeneralizedTimeMatchingRule INSTANCE = new GeneralizedTimeMatchingRule();
    static final String LOWER_EQUALITY_RULE_NAME = StaticUtils.toLowerCase(EQUALITY_RULE_NAME);
    static final String LOWER_ORDERING_RULE_NAME = StaticUtils.toLowerCase(ORDERING_RULE_NAME);
    public static final String ORDERING_RULE_NAME = "generalizedTimeOrderingMatch";
    public static final String ORDERING_RULE_OID = "2.5.13.28";
    private static final TimeZone UTC_TIME_ZONE = TimeZone.getTimeZone("UTC");
    private static final ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<>();
    private static final long serialVersionUID = -6317451154598148593L;

    public static GeneralizedTimeMatchingRule getInstance() {
        return INSTANCE;
    }

    public int compareValues(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        try {
            try {
                return StaticUtils.decodeGeneralizedTime(aSN1OctetString.stringValue()).compareTo(StaticUtils.decodeGeneralizedTime(aSN1OctetString2.stringValue()));
            } catch (ParseException e) {
                Debug.debugException(e);
                throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_GENERALIZED_TIME_INVALID_VALUE.get(e.getMessage()), e);
            }
        } catch (ParseException e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_GENERALIZED_TIME_INVALID_VALUE.get(e2.getMessage()), e2);
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
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_GENERALIZED_TIME_SUBSTRING_MATCHING_NOT_SUPPORTED.get());
    }

    public ASN1OctetString normalize(ASN1OctetString aSN1OctetString) {
        try {
            Date decodeGeneralizedTime = StaticUtils.decodeGeneralizedTime(aSN1OctetString.stringValue());
            SimpleDateFormat simpleDateFormat = dateFormat.get();
            if (simpleDateFormat == null) {
                simpleDateFormat = new SimpleDateFormat(GENERALIZED_TIME_DATE_FORMAT);
                simpleDateFormat.setTimeZone(UTC_TIME_ZONE);
                dateFormat.set(simpleDateFormat);
            }
            return new ASN1OctetString(simpleDateFormat.format(decodeGeneralizedTime));
        } catch (ParseException e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_GENERALIZED_TIME_INVALID_VALUE.get(e.getMessage()), e);
        }
    }

    public ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b) {
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_GENERALIZED_TIME_SUBSTRING_MATCHING_NOT_SUPPORTED.get());
    }

    public boolean valuesMatch(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        try {
            try {
                return StaticUtils.decodeGeneralizedTime(aSN1OctetString.stringValue()).equals(StaticUtils.decodeGeneralizedTime(aSN1OctetString2.stringValue()));
            } catch (ParseException e) {
                Debug.debugException(e);
                throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_GENERALIZED_TIME_INVALID_VALUE.get(e.getMessage()), e);
            }
        } catch (ParseException e2) {
            Debug.debugException(e2);
            throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_GENERALIZED_TIME_INVALID_VALUE.get(e2.getMessage()), e2);
        }
    }
}
