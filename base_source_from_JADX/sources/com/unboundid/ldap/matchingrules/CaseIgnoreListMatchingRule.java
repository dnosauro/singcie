package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.sdk.LDAPException;
import com.unboundid.ldap.sdk.ResultCode;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public final class CaseIgnoreListMatchingRule extends MatchingRule {
    public static final String EQUALITY_RULE_NAME = "caseIgnoreListMatch";
    public static final String EQUALITY_RULE_OID = "2.5.13.11";
    private static final CaseIgnoreListMatchingRule INSTANCE = new CaseIgnoreListMatchingRule();
    static final String LOWER_EQUALITY_RULE_NAME = StaticUtils.toLowerCase(EQUALITY_RULE_NAME);
    static final String LOWER_SUBSTRING_RULE_NAME = StaticUtils.toLowerCase(SUBSTRING_RULE_NAME);
    public static final String SUBSTRING_RULE_NAME = "caseIgnoreListSubstringsMatch";
    public static final String SUBSTRING_RULE_OID = "2.5.13.12";
    private static final long serialVersionUID = 7795143670808983466L;

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r1 = r1 | 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0038, code lost:
        r1 = r1 | 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        r1 = r1 | 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x003e, code lost:
        r1 = r1 | 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0041, code lost:
        r1 = r1 | 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0032, code lost:
        r1 = r1 | 15;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static char decodeHexChar(java.lang.String r5, int r6) {
        /*
            r0 = 0
            r2 = r6
            r6 = 0
            r1 = 0
        L_0x0004:
            r3 = 2
            if (r6 >= r3) goto L_0x0064
            int r1 = r1 << 4
            char r1 = (char) r1
            char r3 = r5.charAt(r2)
            switch(r3) {
                case 48: goto L_0x005f;
                case 49: goto L_0x005c;
                case 50: goto L_0x0059;
                case 51: goto L_0x0056;
                case 52: goto L_0x0053;
                case 53: goto L_0x0050;
                case 54: goto L_0x004d;
                case 55: goto L_0x004a;
                case 56: goto L_0x0047;
                case 57: goto L_0x0044;
                default: goto L_0x0011;
            }
        L_0x0011:
            switch(r3) {
                case 65: goto L_0x0041;
                case 66: goto L_0x003e;
                case 67: goto L_0x003b;
                case 68: goto L_0x0038;
                case 69: goto L_0x0035;
                case 70: goto L_0x0032;
                default: goto L_0x0014;
            }
        L_0x0014:
            switch(r3) {
                case 97: goto L_0x0041;
                case 98: goto L_0x003e;
                case 99: goto L_0x003b;
                case 100: goto L_0x0038;
                case 101: goto L_0x0035;
                case 102: goto L_0x0032;
                default: goto L_0x0017;
            }
        L_0x0017:
            com.unboundid.ldap.sdk.LDAPException r6 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r1 = com.unboundid.ldap.sdk.ResultCode.INVALID_ATTRIBUTE_SYNTAX
            com.unboundid.ldap.matchingrules.MatchingRuleMessages r3 = com.unboundid.ldap.matchingrules.MatchingRuleMessages.ERR_CASE_IGNORE_LIST_NOT_HEX_DIGIT
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            char r5 = r5.charAt(r2)
            java.lang.Character r5 = java.lang.Character.valueOf(r5)
            r4[r0] = r5
            java.lang.String r5 = r3.get(r4)
            r6.<init>((com.unboundid.ldap.sdk.ResultCode) r1, (java.lang.String) r5)
            throw r6
        L_0x0032:
            r1 = r1 | 15
            goto L_0x005e
        L_0x0035:
            r1 = r1 | 14
            goto L_0x005e
        L_0x0038:
            r1 = r1 | 13
            goto L_0x005e
        L_0x003b:
            r1 = r1 | 12
            goto L_0x005e
        L_0x003e:
            r1 = r1 | 11
            goto L_0x005e
        L_0x0041:
            r1 = r1 | 10
            goto L_0x005e
        L_0x0044:
            r1 = r1 | 9
            goto L_0x005e
        L_0x0047:
            r1 = r1 | 8
            goto L_0x005e
        L_0x004a:
            r1 = r1 | 7
            goto L_0x005e
        L_0x004d:
            r1 = r1 | 6
            goto L_0x005e
        L_0x0050:
            r1 = r1 | 5
            goto L_0x005e
        L_0x0053:
            r1 = r1 | 4
            goto L_0x005e
        L_0x0056:
            r1 = r1 | 3
            goto L_0x005e
        L_0x0059:
            r1 = r1 | 2
            goto L_0x005e
        L_0x005c:
            r1 = r1 | 1
        L_0x005e:
            char r1 = (char) r1
        L_0x005f:
            int r6 = r6 + 1
            int r2 = r2 + 1
            goto L_0x0004
        L_0x0064:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.matchingrules.CaseIgnoreListMatchingRule.decodeHexChar(java.lang.String, int):char");
    }

    public static CaseIgnoreListMatchingRule getInstance() {
        return INSTANCE;
    }

    public static List<String> getItems(ASN1OctetString aSN1OctetString) {
        return getItems(aSN1OctetString.stringValue());
    }

    public static List<String> getItems(String str) {
        ArrayList arrayList = new ArrayList(10);
        int length = str.length();
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < length) {
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                try {
                    sb.append(decodeHexChar(str, i + 1));
                    i += 2;
                } catch (Exception e) {
                    Debug.debugException(e);
                    throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_CASE_IGNORE_LIST_MALFORMED_HEX_CHAR.get(str), e);
                }
            } else if (charAt == '$') {
                String trim = sb.toString().trim();
                if (trim.length() != 0) {
                    arrayList.add(trim);
                    sb.delete(0, sb.length());
                } else {
                    throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_CASE_IGNORE_LIST_EMPTY_ITEM.get(str));
                }
            } else {
                sb.append(charAt);
            }
            i++;
        }
        String trim2 = sb.toString().trim();
        if (trim2.length() != 0) {
            arrayList.add(trim2);
            return Collections.unmodifiableList(arrayList);
        } else if (arrayList.isEmpty()) {
            throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_CASE_IGNORE_LIST_EMPTY_LIST.get(str));
        } else {
            throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_CASE_IGNORE_LIST_EMPTY_ITEM.get(str));
        }
    }

    public static List<String> getLowercaseItems(ASN1OctetString aSN1OctetString) {
        return getLowercaseItems(aSN1OctetString.stringValue());
    }

    public static List<String> getLowercaseItems(String str) {
        return getItems(StaticUtils.toLowerCase(str));
    }

    static void normalizeItem(StringBuilder sb, String str) {
        String str2;
        int length = str.length();
        boolean z = false;
        for (int i = 0; i < length; i++) {
            char charAt = str.charAt(i);
            if (charAt == '\\') {
                str2 = "\\5c";
            } else if (charAt == '$') {
                str2 = "\\24";
            } else if (charAt == ' ') {
                if (!z) {
                    sb.append(' ');
                    z = true;
                }
            } else {
                sb.append(charAt);
                z = false;
            }
            sb.append(str2);
            z = false;
        }
    }

    public int compareValues(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        throw new LDAPException(ResultCode.INAPPROPRIATE_MATCHING, MatchingRuleMessages.ERR_CASE_IGNORE_LIST_ORDERING_MATCHING_NOT_SUPPORTED.get());
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

    public boolean matchesSubstring(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1OctetString[] aSN1OctetStringArr, ASN1OctetString aSN1OctetString3) {
        String stringValue = normalize(aSN1OctetString).stringValue();
        if (aSN1OctetString2 != null) {
            String stringValue2 = normalizeSubstring(aSN1OctetString2, Byte.MIN_VALUE).stringValue();
            if (stringValue2.indexOf(36) >= 0) {
                throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_CASE_IGNORE_LIST_SUBSTRING_COMPONENT_CONTAINS_DOLLAR.get(stringValue2));
            } else if (!stringValue.startsWith(stringValue2)) {
                return false;
            } else {
                stringValue = stringValue.substring(stringValue2.length());
            }
        }
        if (aSN1OctetString3 != null) {
            String stringValue3 = normalizeSubstring(aSN1OctetString3, MatchingRule.SUBSTRING_TYPE_SUBFINAL).stringValue();
            if (stringValue3.indexOf(36) >= 0) {
                throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_CASE_IGNORE_LIST_SUBSTRING_COMPONENT_CONTAINS_DOLLAR.get(stringValue3));
            } else if (!stringValue.endsWith(stringValue3)) {
                return false;
            } else {
                stringValue = stringValue.substring(0, stringValue.length() - stringValue3.length());
            }
        }
        if (aSN1OctetStringArr != null) {
            int length = aSN1OctetStringArr.length;
            String str = stringValue;
            int i = 0;
            while (i < length) {
                String stringValue4 = normalizeSubstring(aSN1OctetStringArr[i], (byte) -127).stringValue();
                if (stringValue4.indexOf(36) < 0) {
                    int indexOf = str.indexOf(stringValue4);
                    if (indexOf < 0) {
                        return false;
                    }
                    str = str.substring(indexOf + stringValue4.length());
                    i++;
                } else {
                    throw new LDAPException(ResultCode.INVALID_ATTRIBUTE_SYNTAX, MatchingRuleMessages.ERR_CASE_IGNORE_LIST_SUBSTRING_COMPONENT_CONTAINS_DOLLAR.get(stringValue4));
                }
            }
        }
        return true;
    }

    public ASN1OctetString normalize(ASN1OctetString aSN1OctetString) {
        Iterator<String> it = getLowercaseItems(aSN1OctetString).iterator();
        StringBuilder sb = new StringBuilder();
        while (it.hasNext()) {
            normalizeItem(sb, it.next());
            if (it.hasNext()) {
                sb.append('$');
            }
        }
        return new ASN1OctetString(sb.toString());
    }

    public ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b) {
        return CaseIgnoreStringMatchingRule.getInstance().normalizeSubstring(aSN1OctetString, b);
    }

    public boolean valuesMatch(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        return normalize(aSN1OctetString).equals(normalize(aSN1OctetString2));
    }
}
