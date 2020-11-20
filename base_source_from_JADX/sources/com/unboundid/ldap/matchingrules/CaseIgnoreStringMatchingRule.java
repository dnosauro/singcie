package com.unboundid.ldap.matchingrules;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.util.StaticUtils;

public final class CaseIgnoreStringMatchingRule extends AcceptAllSimpleMatchingRule {
    public static final String EQUALITY_RULE_NAME = "caseIgnoreMatch";
    public static final String EQUALITY_RULE_OID = "2.5.13.2";
    private static final CaseIgnoreStringMatchingRule INSTANCE = new CaseIgnoreStringMatchingRule();
    static final String LOWER_EQUALITY_RULE_NAME = StaticUtils.toLowerCase(EQUALITY_RULE_NAME);
    static final String LOWER_ORDERING_RULE_NAME = StaticUtils.toLowerCase(ORDERING_RULE_NAME);
    static final String LOWER_SUBSTRING_RULE_NAME = StaticUtils.toLowerCase(SUBSTRING_RULE_NAME);
    public static final String ORDERING_RULE_NAME = "caseIgnoreOrderingMatch";
    public static final String ORDERING_RULE_OID = "2.5.13.3";
    public static final String SUBSTRING_RULE_NAME = "caseIgnoreSubstringsMatch";
    public static final String SUBSTRING_RULE_OID = "2.5.13.4";
    private static final long serialVersionUID = -1293370922676445525L;

    public static CaseIgnoreStringMatchingRule getInstance() {
        return INSTANCE;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0026  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x0043  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x004b A[ADDED_TO_REGION] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.unboundid.asn1.ASN1OctetString normalizeInternal(com.unboundid.asn1.ASN1OctetString r12, boolean r13, byte r14) {
        /*
            byte[] r0 = r12.getValue()
            int r1 = r0.length
            if (r1 != 0) goto L_0x0008
            return r12
        L_0x0008:
            r1 = 0
            r2 = 1
            if (r13 == 0) goto L_0x001b
            r13 = -128(0xffffffffffffff80, float:NaN)
            if (r14 == r13) goto L_0x0019
            r13 = -126(0xffffffffffffff82, float:NaN)
            if (r14 == r13) goto L_0x0017
            r13 = 0
        L_0x0015:
            r14 = 0
            goto L_0x001d
        L_0x0017:
            r13 = 0
            goto L_0x001c
        L_0x0019:
            r13 = 1
            goto L_0x0015
        L_0x001b:
            r13 = 1
        L_0x001c:
            r14 = 1
        L_0x001d:
            int r3 = r0.length
            r6 = r13
            r4 = 0
            r5 = 0
            r7 = 0
        L_0x0022:
            r8 = 32
            if (r4 >= r3) goto L_0x0041
            byte r9 = r0[r4]
            r10 = r9 & 127(0x7f, float:1.78E-43)
            r11 = r9 & 255(0xff, float:3.57E-43)
            if (r10 == r11) goto L_0x0033
            com.unboundid.asn1.ASN1OctetString r12 = normalizeNonASCII(r12, r13, r14)
            return r12
        L_0x0033:
            if (r9 != r8) goto L_0x003c
            if (r6 == 0) goto L_0x003a
            int r7 = r7 + 1
            goto L_0x003e
        L_0x003a:
            r6 = 1
            goto L_0x003e
        L_0x003c:
            r5 = 1
            r6 = 0
        L_0x003e:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x0041:
            if (r5 != 0) goto L_0x004b
            com.unboundid.asn1.ASN1OctetString r12 = new com.unboundid.asn1.ASN1OctetString
            java.lang.String r13 = " "
            r12.<init>((java.lang.String) r13)
            return r12
        L_0x004b:
            if (r6 == 0) goto L_0x0051
            if (r14 == 0) goto L_0x0051
            int r7 = r7 + 1
        L_0x0051:
            int r12 = r0.length
            int r12 = r12 - r7
            byte[] r12 = new byte[r12]
            r4 = r13
            r13 = 0
            r3 = 0
        L_0x0058:
            int r5 = r0.length
            if (r13 >= r5) goto L_0x0141
            byte r5 = r0[r13]
            if (r5 == r8) goto L_0x012b
            switch(r5) {
                case 65: goto L_0x0123;
                case 66: goto L_0x011b;
                case 67: goto L_0x0113;
                case 68: goto L_0x010b;
                case 69: goto L_0x0103;
                case 70: goto L_0x00fb;
                case 71: goto L_0x00f3;
                case 72: goto L_0x00eb;
                case 73: goto L_0x00e3;
                case 74: goto L_0x00dc;
                case 75: goto L_0x00d5;
                case 76: goto L_0x00ce;
                case 77: goto L_0x00c7;
                case 78: goto L_0x00c0;
                case 79: goto L_0x00b9;
                case 80: goto L_0x00b2;
                case 81: goto L_0x00ab;
                case 82: goto L_0x00a4;
                case 83: goto L_0x009d;
                case 84: goto L_0x0096;
                case 85: goto L_0x008f;
                case 86: goto L_0x0088;
                case 87: goto L_0x0081;
                case 88: goto L_0x007a;
                case 89: goto L_0x0073;
                case 90: goto L_0x006c;
                default: goto L_0x0062;
            }
        L_0x0062:
            int r4 = r3 + 1
            byte r5 = r0[r13]
            r12[r3] = r5
        L_0x0068:
            r3 = r4
            r4 = 0
            goto L_0x013d
        L_0x006c:
            int r4 = r3 + 1
            r5 = 122(0x7a, float:1.71E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x0073:
            int r4 = r3 + 1
            r5 = 121(0x79, float:1.7E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x007a:
            int r4 = r3 + 1
            r5 = 120(0x78, float:1.68E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x0081:
            int r4 = r3 + 1
            r5 = 119(0x77, float:1.67E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x0088:
            int r4 = r3 + 1
            r5 = 118(0x76, float:1.65E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x008f:
            int r4 = r3 + 1
            r5 = 117(0x75, float:1.64E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x0096:
            int r4 = r3 + 1
            r5 = 116(0x74, float:1.63E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x009d:
            int r4 = r3 + 1
            r5 = 115(0x73, float:1.61E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00a4:
            int r4 = r3 + 1
            r5 = 114(0x72, float:1.6E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00ab:
            int r4 = r3 + 1
            r5 = 113(0x71, float:1.58E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00b2:
            int r4 = r3 + 1
            r5 = 112(0x70, float:1.57E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00b9:
            int r4 = r3 + 1
            r5 = 111(0x6f, float:1.56E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00c0:
            int r4 = r3 + 1
            r5 = 110(0x6e, float:1.54E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00c7:
            int r4 = r3 + 1
            r5 = 109(0x6d, float:1.53E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00ce:
            int r4 = r3 + 1
            r5 = 108(0x6c, float:1.51E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00d5:
            int r4 = r3 + 1
            r5 = 107(0x6b, float:1.5E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00dc:
            int r4 = r3 + 1
            r5 = 106(0x6a, float:1.49E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00e3:
            int r4 = r3 + 1
            r5 = 105(0x69, float:1.47E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00eb:
            int r4 = r3 + 1
            r5 = 104(0x68, float:1.46E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00f3:
            int r4 = r3 + 1
            r5 = 103(0x67, float:1.44E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x00fb:
            int r4 = r3 + 1
            r5 = 102(0x66, float:1.43E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x0103:
            int r4 = r3 + 1
            r5 = 101(0x65, float:1.42E-43)
            r12[r3] = r5
            goto L_0x0068
        L_0x010b:
            int r4 = r3 + 1
            r5 = 100
            r12[r3] = r5
            goto L_0x0068
        L_0x0113:
            int r4 = r3 + 1
            r5 = 99
            r12[r3] = r5
            goto L_0x0068
        L_0x011b:
            int r4 = r3 + 1
            r5 = 98
            r12[r3] = r5
            goto L_0x0068
        L_0x0123:
            int r4 = r3 + 1
            r5 = 97
            r12[r3] = r5
            goto L_0x0068
        L_0x012b:
            if (r4 != 0) goto L_0x013d
            if (r14 == 0) goto L_0x0134
            int r5 = r0.length
            int r5 = r5 - r2
            if (r13 != r5) goto L_0x0134
            goto L_0x013d
        L_0x0134:
            int r5 = r12.length
            if (r3 >= r5) goto L_0x013d
            int r4 = r3 + 1
            r12[r3] = r8
            r3 = r4
            r4 = 1
        L_0x013d:
            int r13 = r13 + 1
            goto L_0x0058
        L_0x0141:
            com.unboundid.asn1.ASN1OctetString r13 = new com.unboundid.asn1.ASN1OctetString
            r13.<init>((byte[]) r12)
            return r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.matchingrules.CaseIgnoreStringMatchingRule.normalizeInternal(com.unboundid.asn1.ASN1OctetString, boolean, byte):com.unboundid.asn1.ASN1OctetString");
    }

    private static ASN1OctetString normalizeNonASCII(ASN1OctetString aSN1OctetString, boolean z, boolean z2) {
        StringBuilder sb = new StringBuilder(aSN1OctetString.stringValue());
        boolean z3 = z;
        int i = 0;
        while (i < sb.length()) {
            int i2 = i + 1;
            char charAt = sb.charAt(i);
            if (charAt != ' ') {
                if (Character.isUpperCase(charAt)) {
                    sb.setCharAt(i2 - 1, Character.toLowerCase(charAt));
                }
                i = i2;
                z3 = false;
            } else if (z3 || (z2 && i2 >= sb.length())) {
                int i3 = i2 - 1;
                sb.deleteCharAt(i3);
                i = i3;
            } else {
                i = i2;
                z3 = true;
            }
        }
        if (z2 && sb.length() > 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        return new ASN1OctetString(sb.toString());
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
        return normalizeInternal(aSN1OctetString, false, (byte) 0);
    }

    public ASN1OctetString normalizeSubstring(ASN1OctetString aSN1OctetString, byte b) {
        return normalizeInternal(aSN1OctetString, true, b);
    }

    public boolean valuesMatch(ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2) {
        ASN1OctetString normalizeInternal;
        ASN1OctetString normalizeInternal2;
        byte[] value = aSN1OctetString.getValue();
        byte[] value2 = aSN1OctetString2.getValue();
        if (value.length == value2.length) {
            int i = 0;
            while (i < value.length) {
                byte b = value[i];
                byte b2 = value2[i];
                if ((b & Byte.MAX_VALUE) == (b & 255) && (b2 & Byte.MAX_VALUE) == (b2 & 255)) {
                    if (b != b2) {
                        if (!(b == 32 || b2 == 32)) {
                            char c = (char) b;
                            if (!Character.isUpperCase(c)) {
                                char c2 = (char) b2;
                                if (!Character.isUpperCase(c2) || Character.toLowerCase(c2) != c) {
                                    return false;
                                }
                            } else if (Character.toLowerCase(c) != ((char) b2)) {
                                return false;
                            }
                        }
                    }
                    i++;
                }
                normalizeInternal = normalize(aSN1OctetString);
                normalizeInternal2 = normalize(aSN1OctetString2);
            }
            return true;
        }
        normalizeInternal = normalizeInternal(aSN1OctetString, false, (byte) 0);
        normalizeInternal2 = normalizeInternal(aSN1OctetString2, false, (byte) 0);
        return normalizeInternal.equals(normalizeInternal2);
    }
}
