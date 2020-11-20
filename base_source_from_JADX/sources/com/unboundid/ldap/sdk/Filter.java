package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1Boolean;
import com.unboundid.asn1.ASN1Buffer;
import com.unboundid.asn1.ASN1BufferSequence;
import com.unboundid.asn1.ASN1BufferSet;
import com.unboundid.asn1.ASN1Element;
import com.unboundid.asn1.ASN1Exception;
import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.asn1.ASN1Sequence;
import com.unboundid.asn1.ASN1Set;
import com.unboundid.asn1.ASN1StreamReader;
import com.unboundid.asn1.ASN1StreamReaderSequence;
import com.unboundid.asn1.ASN1StreamReaderSet;
import com.unboundid.ldap.matchingrules.CaseIgnoreStringMatchingRule;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

public final class Filter implements Serializable {
    private static final byte EXTENSIBLE_TYPE_ATTRIBUTE_NAME = -126;
    private static final byte EXTENSIBLE_TYPE_DN_ATTRIBUTES = -124;
    private static final byte EXTENSIBLE_TYPE_MATCHING_RULE_ID = -127;
    private static final byte EXTENSIBLE_TYPE_MATCH_VALUE = -125;
    public static final byte FILTER_TYPE_AND = -96;
    public static final byte FILTER_TYPE_APPROXIMATE_MATCH = -88;
    public static final byte FILTER_TYPE_EQUALITY = -93;
    public static final byte FILTER_TYPE_EXTENSIBLE_MATCH = -87;
    public static final byte FILTER_TYPE_GREATER_OR_EQUAL = -91;
    public static final byte FILTER_TYPE_LESS_OR_EQUAL = -90;
    public static final byte FILTER_TYPE_NOT = -94;
    public static final byte FILTER_TYPE_OR = -95;
    public static final byte FILTER_TYPE_PRESENCE = -121;
    public static final byte FILTER_TYPE_SUBSTRING = -92;
    private static final Filter[] NO_FILTERS = new Filter[0];
    private static final ASN1OctetString[] NO_SUB_ANY = new ASN1OctetString[0];
    private static final byte SUBSTRING_TYPE_SUBANY = -127;
    private static final byte SUBSTRING_TYPE_SUBFINAL = -126;
    private static final byte SUBSTRING_TYPE_SUBINITIAL = Byte.MIN_VALUE;
    private static final long serialVersionUID = -2734184402804691970L;
    private final ASN1OctetString assertionValue;
    private final String attrName;
    private final boolean dnAttributes;
    private final Filter[] filterComps;
    private volatile String filterString;
    private final byte filterType;
    private final String matchingRuleID;
    private volatile String normalizedString;
    private final Filter notComp;
    private final ASN1OctetString[] subAny;
    private final ASN1OctetString subFinal;
    private final ASN1OctetString subInitial;

    private Filter(String str, byte b, Filter[] filterArr, Filter filter, String str2, ASN1OctetString aSN1OctetString, ASN1OctetString aSN1OctetString2, ASN1OctetString[] aSN1OctetStringArr, ASN1OctetString aSN1OctetString3, String str3, boolean z) {
        this.filterString = str;
        this.filterType = b;
        this.filterComps = filterArr;
        this.notComp = filter;
        this.attrName = str2;
        this.assertionValue = aSN1OctetString;
        this.subInitial = aSN1OctetString2;
        this.subAny = aSN1OctetStringArr;
        this.subFinal = aSN1OctetString3;
        this.matchingRuleID = str3;
        this.dnAttributes = z;
    }

    public static Filter create(String str) {
        Validator.ensureNotNull(str);
        return create(str, 0, str.length() - 1, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:59:0x0163, code lost:
        r5 = false;
        r6 = 0;
     */
    /* JADX WARNING: Removed duplicated region for block: B:103:0x024f  */
    /* JADX WARNING: Removed duplicated region for block: B:108:0x0260  */
    /* JADX WARNING: Removed duplicated region for block: B:226:0x05d0  */
    /* JADX WARNING: Removed duplicated region for block: B:228:0x05ed  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static com.unboundid.ldap.sdk.Filter create(java.lang.String r30, int r31, int r32, int r33) {
        /*
            r1 = r30
            r0 = r31
            r2 = r32
            r3 = r33
            r4 = 50
            if (r3 > r4) goto L_0x0622
            if (r0 >= r2) goto L_0x0614
            char r4 = r30.charAt(r31)
            r5 = 41
            r6 = 40
            r7 = 2
            r8 = 0
            r9 = 1
            if (r4 != r6) goto L_0x0042
            char r4 = r1.charAt(r2)
            if (r4 != r5) goto L_0x0026
            int r4 = r0 + 1
            int r10 = r2 + -1
            goto L_0x0046
        L_0x0026:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_OPEN_WITHOUT_CLOSE
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5[r8] = r0
            java.lang.Integer r0 = java.lang.Integer.valueOf(r32)
            r5[r9] = r0
            java.lang.String r0 = r4.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r0)
            throw r1
        L_0x0042:
            if (r0 != 0) goto L_0x05fb
            r4 = r0
            r10 = r2
        L_0x0046:
            char r11 = r1.charAt(r4)
            r12 = 33
            r13 = -87
            if (r11 == r12) goto L_0x05ad
            r12 = 38
            if (r11 == r12) goto L_0x0599
            if (r11 == r6) goto L_0x0581
            r12 = 92
            r15 = 58
            r14 = 61
            if (r11 == r15) goto L_0x041b
            r5 = 124(0x7c, float:1.74E-43)
            if (r11 == r5) goto L_0x0408
            com.unboundid.ldap.sdk.Filter[] r3 = NO_FILTERS
            r5 = r4
        L_0x0065:
            if (r5 > r10) goto L_0x0161
            int r6 = r5 + 1
            char r5 = r1.charAt(r5)
            if (r5 == r15) goto L_0x015a
            r11 = 126(0x7e, float:1.77E-43)
            if (r5 == r11) goto L_0x0111
            switch(r5) {
                case 60: goto L_0x00c7;
                case 61: goto L_0x00c2;
                case 62: goto L_0x0078;
                default: goto L_0x0076;
            }
        L_0x0076:
            r5 = r6
            goto L_0x0065
        L_0x0078:
            r5 = -91
            int r11 = r6 + -1
            if (r6 > r10) goto L_0x00ac
            int r15 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 != r14) goto L_0x008b
            r5 = 1
            r6 = -91
            goto L_0x0165
        L_0x008b:
            com.unboundid.ldap.sdk.LDAPException r2 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_CHAR_AFTER_GT
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5[r8] = r0
            int r15 = r15 - r9
            char r0 = r1.charAt(r15)
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r5[r9] = r0
            java.lang.String r0 = r4.get(r5)
            r2.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r0)
            throw r2
        L_0x00ac:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_END_AFTER_GT
            java.lang.Object[] r4 = new java.lang.Object[r9]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r4[r8] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x00c2:
            int r11 = r6 + -1
            r15 = r6
            goto L_0x0163
        L_0x00c7:
            r5 = -90
            int r11 = r6 + -1
            if (r6 > r10) goto L_0x00fb
            int r15 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 != r14) goto L_0x00da
            r5 = 1
            r6 = -90
            goto L_0x0165
        L_0x00da:
            com.unboundid.ldap.sdk.LDAPException r2 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_CHAR_AFTER_LT
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5[r8] = r0
            int r15 = r15 - r9
            char r0 = r1.charAt(r15)
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r5[r9] = r0
            java.lang.String r0 = r4.get(r5)
            r2.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r0)
            throw r2
        L_0x00fb:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_END_AFTER_LT
            java.lang.Object[] r4 = new java.lang.Object[r9]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r4[r8] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x0111:
            r5 = -88
            int r11 = r6 + -1
            if (r6 > r10) goto L_0x0144
            int r15 = r6 + 1
            char r6 = r1.charAt(r6)
            if (r6 != r14) goto L_0x0123
            r5 = 1
            r6 = -88
            goto L_0x0165
        L_0x0123:
            com.unboundid.ldap.sdk.LDAPException r2 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_CHAR_AFTER_TILDE
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5[r8] = r0
            int r15 = r15 - r9
            char r0 = r1.charAt(r15)
            java.lang.Character r0 = java.lang.Character.valueOf(r0)
            r5[r9] = r0
            java.lang.String r0 = r4.get(r5)
            r2.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r0)
            throw r2
        L_0x0144:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_END_AFTER_TILDE
            java.lang.Object[] r4 = new java.lang.Object[r9]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r4[r8] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x015a:
            int r11 = r6 + -1
            r15 = r6
            r5 = 1
            r6 = -87
            goto L_0x0165
        L_0x0161:
            r11 = -1
            r15 = r5
        L_0x0163:
            r5 = 0
            r6 = 0
        L_0x0165:
            if (r11 <= r4) goto L_0x03f0
            java.lang.String r4 = r1.substring(r4, r11)
            if (r5 == 0) goto L_0x0249
            if (r6 != r13) goto L_0x0249
            if (r15 > r10) goto L_0x0233
            int r11 = r15 + 1
            char r13 = r1.charAt(r15)
            if (r13 != r14) goto L_0x017c
            r15 = r11
            goto L_0x0249
        L_0x017c:
            int r13 = r11 + -1
        L_0x017e:
            if (r11 > r10) goto L_0x018c
            int r15 = r11 + 1
            char r11 = r1.charAt(r11)
            if (r11 != r14) goto L_0x018a
            r11 = 1
            goto L_0x018e
        L_0x018a:
            r11 = r15
            goto L_0x017e
        L_0x018c:
            r15 = r11
            r11 = 0
        L_0x018e:
            if (r11 == 0) goto L_0x021d
            int r11 = r15 + -1
            java.lang.String r11 = r1.substring(r13, r11)
            java.lang.String r13 = com.unboundid.util.StaticUtils.toLowerCase(r11)
            java.lang.String r14 = ":"
            boolean r14 = r11.endsWith(r14)
            if (r14 == 0) goto L_0x0207
            java.lang.String r14 = "dn:"
            boolean r14 = r13.equals(r14)
            if (r14 == 0) goto L_0x01ad
            r11 = 1
            goto L_0x024a
        L_0x01ad:
            java.lang.String r14 = "dn:"
            boolean r13 = r13.startsWith(r14)
            if (r13 == 0) goto L_0x01df
            r13 = 3
            int r14 = r11.length()
            int r14 = r14 - r9
            java.lang.String r11 = r11.substring(r13, r14)
            int r13 = r11.length()
            if (r13 == 0) goto L_0x01c9
            r14 = r11
            r11 = 1
            goto L_0x024b
        L_0x01c9:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EMPTY_MRID
            java.lang.Object[] r4 = new java.lang.Object[r9]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r4[r8] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x01df:
            int r13 = r11.length()
            int r13 = r13 - r9
            java.lang.String r11 = r11.substring(r8, r13)
            int r13 = r11.length()
            if (r13 == 0) goto L_0x01f1
            r14 = r11
            r11 = 0
            goto L_0x024b
        L_0x01f1:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EMPTY_MRID
            java.lang.Object[] r4 = new java.lang.Object[r9]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r4[r8] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x0207:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_CANNOT_PARSE_MRID
            java.lang.Object[] r4 = new java.lang.Object[r9]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r4[r8] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x021d:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_NO_EQUALS
            java.lang.Object[] r4 = new java.lang.Object[r9]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r4[r8] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x0233:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_NO_EQUALS
            java.lang.Object[] r4 = new java.lang.Object[r9]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r4[r8] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x0249:
            r11 = 0
        L_0x024a:
            r14 = 0
        L_0x024b:
            r13 = -93
            if (r15 <= r10) goto L_0x0260
            com.unboundid.asn1.ASN1OctetString r7 = new com.unboundid.asn1.ASN1OctetString
            r7.<init>()
            if (r5 != 0) goto L_0x0257
            goto L_0x0258
        L_0x0257:
            r13 = r6
        L_0x0258:
            com.unboundid.asn1.ASN1OctetString[] r5 = NO_SUB_ANY
            r6 = r5
        L_0x025b:
            r5 = 0
            r16 = 0
            goto L_0x03da
        L_0x0260:
            if (r15 != r10) goto L_0x02d8
            if (r5 == 0) goto L_0x029a
            char r5 = r1.charAt(r15)
            if (r5 == r12) goto L_0x027a
            switch(r5) {
                case 40: goto L_0x027a;
                case 41: goto L_0x027a;
                case 42: goto L_0x027a;
                default: goto L_0x026d;
            }
        L_0x026d:
            com.unboundid.asn1.ASN1OctetString r5 = new com.unboundid.asn1.ASN1OctetString
            int r7 = r15 + 1
            java.lang.String r7 = r1.substring(r15, r7)
            r5.<init>((java.lang.String) r7)
            r13 = r6
            goto L_0x02b4
        L_0x027a:
            com.unboundid.ldap.sdk.LDAPException r2 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_CHAR_IN_AV
            java.lang.Object[] r5 = new java.lang.Object[r7]
            char r1 = r1.charAt(r15)
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r5[r8] = r1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5[r9] = r0
            java.lang.String r0 = r4.get(r5)
            r2.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r0)
            throw r2
        L_0x029a:
            char r5 = r1.charAt(r15)
            if (r5 == r12) goto L_0x02b8
            switch(r5) {
                case 40: goto L_0x02b8;
                case 41: goto L_0x02b8;
                case 42: goto L_0x02af;
                default: goto L_0x02a3;
            }
        L_0x02a3:
            com.unboundid.asn1.ASN1OctetString r5 = new com.unboundid.asn1.ASN1OctetString
            int r6 = r15 + 1
            java.lang.String r6 = r1.substring(r15, r6)
            r5.<init>((java.lang.String) r6)
            goto L_0x02b4
        L_0x02af:
            r6 = -121(0xffffffffffffff87, float:NaN)
            r5 = 0
            r13 = -121(0xffffffffffffff87, float:NaN)
        L_0x02b4:
            com.unboundid.asn1.ASN1OctetString[] r6 = NO_SUB_ANY
            r7 = r5
            goto L_0x025b
        L_0x02b8:
            com.unboundid.ldap.sdk.LDAPException r2 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_CHAR_IN_AV
            java.lang.Object[] r5 = new java.lang.Object[r7]
            char r1 = r1.charAt(r15)
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r5[r8] = r1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5[r9] = r0
            java.lang.String r0 = r4.get(r5)
            r2.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r0)
            throw r2
        L_0x02d8:
            if (r5 != 0) goto L_0x02db
            goto L_0x02dc
        L_0x02db:
            r13 = r6
        L_0x02dc:
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r9)
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            int r16 = r10 - r15
            int r8 = r16 + 1
            r7.<init>(r8)
            r8 = r7
            r7 = r15
            r16 = 0
        L_0x02ee:
            if (r7 > r10) goto L_0x03aa
            int r9 = r7 + 1
            char r7 = r1.charAt(r7)
            if (r7 == r12) goto L_0x03a2
            switch(r7) {
                case 40: goto L_0x038a;
                case 41: goto L_0x0372;
                case 42: goto L_0x0301;
                default: goto L_0x02fb;
            }
        L_0x02fb:
            r8.append(r7)
            r7 = r9
            goto L_0x03a6
        L_0x0301:
            if (r5 != 0) goto L_0x035a
            int r7 = r9 + -1
            if (r7 != r15) goto L_0x0309
            r13 = 1
            goto L_0x0356
        L_0x0309:
            r7 = -92
            if (r13 != r7) goto L_0x0341
            int r7 = r8.length()
            if (r7 == 0) goto L_0x0329
            com.unboundid.asn1.ASN1OctetString r7 = new com.unboundid.asn1.ASN1OctetString
            java.lang.String r8 = r8.toString()
            r7.<init>((java.lang.String) r8)
            r6.add(r7)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            int r7 = r10 - r9
            r13 = 1
            int r7 = r7 + r13
            r8.<init>(r7)
            goto L_0x0356
        L_0x0329:
            r13 = 1
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_DOUBLE_ASTERISK
            java.lang.Object[] r4 = new java.lang.Object[r13]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5 = 0
            r4[r5] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x0341:
            r13 = 1
            com.unboundid.asn1.ASN1OctetString r7 = new com.unboundid.asn1.ASN1OctetString
            java.lang.String r8 = r8.toString()
            r7.<init>((java.lang.String) r8)
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            int r16 = r10 - r9
            int r12 = r16 + 1
            r8.<init>(r12)
            r16 = r7
        L_0x0356:
            r7 = r9
            r13 = -92
            goto L_0x03a6
        L_0x035a:
            r13 = 1
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_ASTERISK
            java.lang.Object[] r4 = new java.lang.Object[r13]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5 = 0
            r4[r5] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x0372:
            r5 = 0
            r13 = 1
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r1 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_CLOSE_PAREN
            java.lang.Object[] r3 = new java.lang.Object[r13]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)
            r3[r5] = r4
            java.lang.String r2 = r2.get(r3)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r1, (java.lang.String) r2)
            throw r0
        L_0x038a:
            r5 = 0
            r13 = 1
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r1 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_OPEN_PAREN
            java.lang.Object[] r3 = new java.lang.Object[r13]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)
            r3[r5] = r4
            java.lang.String r2 = r2.get(r3)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r1, (java.lang.String) r2)
            throw r0
        L_0x03a2:
            int r7 = readEscapedHexString(r1, r9, r10, r8)
        L_0x03a6:
            r12 = 92
            goto L_0x02ee
        L_0x03aa:
            r7 = -92
            if (r13 != r7) goto L_0x03be
            int r5 = r8.length()
            if (r5 <= 0) goto L_0x03be
            com.unboundid.asn1.ASN1OctetString r5 = new com.unboundid.asn1.ASN1OctetString
            java.lang.String r7 = r8.toString()
            r5.<init>((java.lang.String) r7)
            goto L_0x03bf
        L_0x03be:
            r5 = 0
        L_0x03bf:
            int r7 = r6.size()
            com.unboundid.asn1.ASN1OctetString[] r7 = new com.unboundid.asn1.ASN1OctetString[r7]
            java.lang.Object[] r6 = r6.toArray(r7)
            com.unboundid.asn1.ASN1OctetString[] r6 = (com.unboundid.asn1.ASN1OctetString[]) r6
            r7 = -92
            if (r13 != r7) goto L_0x03d1
            r7 = 0
            goto L_0x03da
        L_0x03d1:
            com.unboundid.asn1.ASN1OctetString r7 = new com.unboundid.asn1.ASN1OctetString
            java.lang.String r8 = r8.toString()
            r7.<init>((java.lang.String) r8)
        L_0x03da:
            r20 = r3
            r22 = r4
            r26 = r5
            r25 = r6
            r23 = r7
            r28 = r11
            r19 = r13
            r27 = r14
            r24 = r16
            r21 = 0
            goto L_0x05ce
        L_0x03f0:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EMPTY_ATTR_NAME
            r8 = 1
            java.lang.Object[] r4 = new java.lang.Object[r8]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5 = 0
            r4[r5] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x0408:
            r8 = 1
            r5 = -95
            int r4 = r4 + r8
            int r3 = r3 + r8
            com.unboundid.ldap.sdk.Filter[] r3 = parseFilterComps(r1, r4, r10, r3)
            com.unboundid.asn1.ASN1OctetString[] r4 = NO_SUB_ANY
            r20 = r3
            r25 = r4
            r19 = -95
            goto L_0x05aa
        L_0x041b:
            r8 = 1
            com.unboundid.ldap.sdk.Filter[] r3 = NO_FILTERS
            com.unboundid.asn1.ASN1OctetString[] r9 = NO_SUB_ANY
            int r4 = r4 + r8
            r8 = r4
        L_0x0422:
            if (r8 > r10) goto L_0x042d
            char r11 = r1.charAt(r8)
            if (r11 == r15) goto L_0x042d
            int r8 = r8 + 1
            goto L_0x0422
        L_0x042d:
            if (r8 > r10) goto L_0x0569
            if (r8 == r4) goto L_0x0551
            int r11 = r8 + 1
            java.lang.String r4 = r1.substring(r4, r8)
            java.lang.String r8 = "dn"
            boolean r8 = r4.equalsIgnoreCase(r8)
            if (r8 == 0) goto L_0x04b7
            r4 = r11
        L_0x0440:
            if (r4 >= r10) goto L_0x044b
            char r8 = r1.charAt(r4)
            if (r8 == r15) goto L_0x044b
            int r4 = r4 + 1
            goto L_0x0440
        L_0x044b:
            if (r4 >= r10) goto L_0x049f
            java.lang.String r8 = r1.substring(r11, r4)
            int r11 = r8.length()
            if (r11 == 0) goto L_0x0487
            r11 = 1
            int r4 = r4 + r11
            if (r4 > r10) goto L_0x0465
            char r11 = r1.charAt(r4)
            if (r11 != r14) goto L_0x0465
            r11 = r8
            r7 = 1
            r8 = 1
            goto L_0x04c6
        L_0x0465:
            com.unboundid.ldap.sdk.LDAPException r2 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r5 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_CHAR_AFTER_MRID
            java.lang.Object[] r6 = new java.lang.Object[r7]
            char r1 = r1.charAt(r4)
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r4 = 0
            r6[r4] = r1
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r7 = 1
            r6[r7] = r0
            java.lang.String r0 = r5.get(r6)
            r2.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r0)
            throw r2
        L_0x0487:
            r4 = 0
            r7 = 1
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EMPTY_MRID
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5[r4] = r0
            java.lang.String r0 = r3.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x049f:
            r4 = 0
            r7 = 1
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_NO_COLON_AFTER_MRID
            java.lang.Object[] r5 = new java.lang.Object[r7]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r5[r4] = r0
            java.lang.String r0 = r3.get(r5)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x04b7:
            r7 = 1
            if (r11 > r10) goto L_0x0539
            char r8 = r1.charAt(r11)
            if (r8 != r14) goto L_0x0539
            r8 = 0
            r29 = r11
            r11 = r4
            r4 = r29
        L_0x04c6:
            int r4 = r4 + r7
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            int r14 = r10 - r4
            int r14 = r14 + r7
            r12.<init>(r14)
        L_0x04cf:
            if (r4 > r10) goto L_0x051a
            char r7 = r1.charAt(r4)
            r14 = 92
            if (r7 != r14) goto L_0x04e0
            int r4 = r4 + 1
            int r4 = readEscapedHexString(r1, r4, r10, r12)
            goto L_0x04cf
        L_0x04e0:
            if (r7 == r6) goto L_0x0502
            if (r7 == r5) goto L_0x04ea
            r12.append(r7)
            int r4 = r4 + 1
            goto L_0x04cf
        L_0x04ea:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r1 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_CLOSE_PAREN
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r5 = 0
            r3[r5] = r4
            java.lang.String r2 = r2.get(r3)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r1, (java.lang.String) r2)
            throw r0
        L_0x0502:
            r3 = 1
            r5 = 0
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r1 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_OPEN_PAREN
            java.lang.Object[] r3 = new java.lang.Object[r3]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r5] = r4
            java.lang.String r2 = r2.get(r3)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r1, (java.lang.String) r2)
            throw r0
        L_0x051a:
            com.unboundid.asn1.ASN1OctetString r4 = new com.unboundid.asn1.ASN1OctetString
            java.lang.String r5 = r12.toString()
            r4.<init>((java.lang.String) r5)
            r20 = r3
            r23 = r4
            r28 = r8
            r25 = r9
            r27 = r11
            r19 = -87
            r21 = 0
            r22 = 0
            r24 = 0
            r26 = 0
            goto L_0x05ce
        L_0x0539:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_NO_EQUAL_AFTER_MRID
            r5 = 1
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r6 = 0
            r4[r6] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x0551:
            r5 = 1
            r6 = 0
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EMPTY_MRID
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r4[r6] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x0569:
            r5 = 1
            r6 = 0
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_NO_COLON_AFTER_MRID
            java.lang.Object[] r4 = new java.lang.Object[r5]
            java.lang.Integer r0 = java.lang.Integer.valueOf(r31)
            r4[r6] = r0
            java.lang.String r0 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r0)
            throw r1
        L_0x0581:
            r5 = 1
            r6 = 0
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r1 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_UNEXPECTED_OPEN_PAREN
            java.lang.Object[] r3 = new java.lang.Object[r5]
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            r3[r6] = r4
            java.lang.String r2 = r2.get(r3)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r1, (java.lang.String) r2)
            throw r0
        L_0x0599:
            r5 = 1
            r6 = -96
            int r4 = r4 + r5
            int r3 = r3 + r5
            com.unboundid.ldap.sdk.Filter[] r3 = parseFilterComps(r1, r4, r10, r3)
            com.unboundid.asn1.ASN1OctetString[] r4 = NO_SUB_ANY
            r20 = r3
            r25 = r4
            r19 = -96
        L_0x05aa:
            r21 = 0
            goto L_0x05c2
        L_0x05ad:
            r5 = 1
            r6 = -94
            com.unboundid.ldap.sdk.Filter[] r7 = NO_FILTERS
            int r4 = r4 + r5
            int r3 = r3 + r5
            com.unboundid.ldap.sdk.Filter r3 = create(r1, r4, r10, r3)
            com.unboundid.asn1.ASN1OctetString[] r4 = NO_SUB_ANY
            r21 = r3
            r25 = r4
            r20 = r7
            r19 = -94
        L_0x05c2:
            r22 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r27 = 0
            r28 = 0
        L_0x05ce:
            if (r0 != 0) goto L_0x05ed
            com.unboundid.ldap.sdk.Filter r12 = new com.unboundid.ldap.sdk.Filter
            r0 = r12
            r1 = r30
            r2 = r19
            r3 = r20
            r4 = r21
            r5 = r22
            r6 = r23
            r7 = r24
            r8 = r25
            r9 = r26
            r10 = r27
            r11 = r28
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r12
        L_0x05ed:
            com.unboundid.ldap.sdk.Filter r3 = new com.unboundid.ldap.sdk.Filter
            r4 = 1
            int r2 = r2 + r4
            java.lang.String r18 = r1.substring(r0, r2)
            r17 = r3
            r17.<init>(r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28)
            return r3
        L_0x05fb:
            com.unboundid.ldap.sdk.LDAPException r3 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r4 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r5 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_MISSING_PARENTHESES
            r6 = 1
            java.lang.Object[] r7 = new java.lang.Object[r6]
            int r2 = r2 + r6
            java.lang.String r0 = r1.substring(r0, r2)
            r1 = 0
            r7[r1] = r0
            java.lang.String r0 = r5.get(r7)
            r3.<init>((com.unboundid.ldap.sdk.ResultCode) r4, (java.lang.String) r0)
            throw r3
        L_0x0614:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r1 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_TOO_SHORT
            java.lang.String r2 = r2.get()
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r1, (java.lang.String) r2)
            throw r0
        L_0x0622:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r1 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_TOO_DEEP
            java.lang.String r2 = r2.get()
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r1, (java.lang.String) r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.Filter.create(java.lang.String, int, int, int):com.unboundid.ldap.sdk.Filter");
    }

    public static Filter createANDFilter(List<Filter> list) {
        Validator.ensureNotNull(list);
        return new Filter((String) null, (byte) -96, (Filter[]) list.toArray(new Filter[list.size()]), (Filter) null, (String) null, (ASN1OctetString) null, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createANDFilter(Filter... filterArr) {
        Validator.ensureNotNull(filterArr);
        return new Filter((String) null, (byte) -96, filterArr, (Filter) null, (String) null, (ASN1OctetString) null, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    static Filter createApproximateMatchFilter(String str, ASN1OctetString aSN1OctetString) {
        Validator.ensureNotNull(str, aSN1OctetString);
        return new Filter((String) null, FILTER_TYPE_APPROXIMATE_MATCH, NO_FILTERS, (Filter) null, str, aSN1OctetString, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createApproximateMatchFilter(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        return new Filter((String) null, FILTER_TYPE_APPROXIMATE_MATCH, NO_FILTERS, (Filter) null, str, new ASN1OctetString(str2), (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createApproximateMatchFilter(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        return new Filter((String) null, FILTER_TYPE_APPROXIMATE_MATCH, NO_FILTERS, (Filter) null, str, new ASN1OctetString(bArr), (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    static Filter createEqualityFilter(String str, ASN1OctetString aSN1OctetString) {
        Validator.ensureNotNull(str, aSN1OctetString);
        return new Filter((String) null, (byte) -93, NO_FILTERS, (Filter) null, str, aSN1OctetString, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createEqualityFilter(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        return new Filter((String) null, (byte) -93, NO_FILTERS, (Filter) null, str, new ASN1OctetString(str2), (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createEqualityFilter(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        return new Filter((String) null, (byte) -93, NO_FILTERS, (Filter) null, str, new ASN1OctetString(bArr), (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    static Filter createExtensibleMatchFilter(String str, String str2, boolean z, ASN1OctetString aSN1OctetString) {
        Validator.ensureNotNull(aSN1OctetString);
        Validator.ensureFalse(str == null && str2 == null);
        return new Filter((String) null, FILTER_TYPE_EXTENSIBLE_MATCH, NO_FILTERS, (Filter) null, str, aSN1OctetString, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, str2, z);
    }

    public static Filter createExtensibleMatchFilter(String str, String str2, boolean z, String str3) {
        Validator.ensureNotNull(str3);
        Validator.ensureFalse(str == null && str2 == null);
        return new Filter((String) null, FILTER_TYPE_EXTENSIBLE_MATCH, NO_FILTERS, (Filter) null, str, new ASN1OctetString(str3), (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, str2, z);
    }

    public static Filter createExtensibleMatchFilter(String str, String str2, boolean z, byte[] bArr) {
        Validator.ensureNotNull(bArr);
        Validator.ensureFalse(str == null && str2 == null);
        return new Filter((String) null, FILTER_TYPE_EXTENSIBLE_MATCH, NO_FILTERS, (Filter) null, str, new ASN1OctetString(bArr), (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, str2, z);
    }

    static Filter createGreaterOrEqualFilter(String str, ASN1OctetString aSN1OctetString) {
        Validator.ensureNotNull(str, aSN1OctetString);
        return new Filter((String) null, FILTER_TYPE_GREATER_OR_EQUAL, NO_FILTERS, (Filter) null, str, aSN1OctetString, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createGreaterOrEqualFilter(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        return new Filter((String) null, FILTER_TYPE_GREATER_OR_EQUAL, NO_FILTERS, (Filter) null, str, new ASN1OctetString(str2), (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createGreaterOrEqualFilter(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        return new Filter((String) null, FILTER_TYPE_GREATER_OR_EQUAL, NO_FILTERS, (Filter) null, str, new ASN1OctetString(bArr), (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    static Filter createLessOrEqualFilter(String str, ASN1OctetString aSN1OctetString) {
        Validator.ensureNotNull(str, aSN1OctetString);
        return new Filter((String) null, FILTER_TYPE_LESS_OR_EQUAL, NO_FILTERS, (Filter) null, str, aSN1OctetString, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createLessOrEqualFilter(String str, String str2) {
        Validator.ensureNotNull(str, str2);
        return new Filter((String) null, FILTER_TYPE_LESS_OR_EQUAL, NO_FILTERS, (Filter) null, str, new ASN1OctetString(str2), (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createLessOrEqualFilter(String str, byte[] bArr) {
        Validator.ensureNotNull(str, bArr);
        return new Filter((String) null, FILTER_TYPE_LESS_OR_EQUAL, NO_FILTERS, (Filter) null, str, new ASN1OctetString(bArr), (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createNOTFilter(Filter filter) {
        Validator.ensureNotNull(filter);
        return new Filter((String) null, FILTER_TYPE_NOT, NO_FILTERS, filter, (String) null, (ASN1OctetString) null, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createORFilter(List<Filter> list) {
        Validator.ensureNotNull(list);
        return new Filter((String) null, FILTER_TYPE_OR, (Filter[]) list.toArray(new Filter[list.size()]), (Filter) null, (String) null, (ASN1OctetString) null, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createORFilter(Filter... filterArr) {
        Validator.ensureNotNull(filterArr);
        return new Filter((String) null, FILTER_TYPE_OR, filterArr, (Filter) null, (String) null, (ASN1OctetString) null, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    public static Filter createPresenceFilter(String str) {
        Validator.ensureNotNull(str);
        return new Filter((String) null, (byte) -121, NO_FILTERS, (Filter) null, str, (ASN1OctetString) null, (ASN1OctetString) null, NO_SUB_ANY, (ASN1OctetString) null, (String) null, false);
    }

    static Filter createSubstringFilter(String str, ASN1OctetString aSN1OctetString, ASN1OctetString[] aSN1OctetStringArr, ASN1OctetString aSN1OctetString2) {
        ASN1OctetString[] aSN1OctetStringArr2 = aSN1OctetStringArr;
        Validator.ensureNotNull(str);
        Validator.ensureTrue(aSN1OctetString != null || (aSN1OctetStringArr2 != null && aSN1OctetStringArr2.length > 0) || aSN1OctetString2 != null);
        if (aSN1OctetStringArr2 != null) {
            return new Filter((String) null, FILTER_TYPE_SUBSTRING, NO_FILTERS, (Filter) null, str, (ASN1OctetString) null, aSN1OctetString, aSN1OctetStringArr, aSN1OctetString2, (String) null, false);
        }
        return new Filter((String) null, FILTER_TYPE_SUBSTRING, NO_FILTERS, (Filter) null, str, (ASN1OctetString) null, aSN1OctetString, NO_SUB_ANY, aSN1OctetString2, (String) null, false);
    }

    public static Filter createSubstringFilter(String str, String str2, String[] strArr, String str3) {
        ASN1OctetString[] aSN1OctetStringArr;
        String str4 = str2;
        String[] strArr2 = strArr;
        String str5 = str3;
        Validator.ensureNotNull(str);
        Validator.ensureTrue(str4 != null || (strArr2 != null && strArr2.length > 0) || str5 != null);
        ASN1OctetString aSN1OctetString = null;
        ASN1OctetString aSN1OctetString2 = str4 == null ? null : new ASN1OctetString(str4);
        if (strArr2 == null) {
            aSN1OctetStringArr = NO_SUB_ANY;
        } else {
            aSN1OctetStringArr = new ASN1OctetString[strArr2.length];
            for (int i = 0; i < strArr2.length; i++) {
                aSN1OctetStringArr[i] = new ASN1OctetString(strArr2[i]);
            }
        }
        ASN1OctetString[] aSN1OctetStringArr2 = aSN1OctetStringArr;
        if (str5 != null) {
            aSN1OctetString = new ASN1OctetString(str5);
        }
        return new Filter((String) null, FILTER_TYPE_SUBSTRING, NO_FILTERS, (Filter) null, str, (ASN1OctetString) null, aSN1OctetString2, aSN1OctetStringArr2, aSN1OctetString, (String) null, false);
    }

    public static Filter createSubstringFilter(String str, byte[] bArr, byte[][] bArr2, byte[] bArr3) {
        ASN1OctetString[] aSN1OctetStringArr;
        byte[] bArr4 = bArr;
        byte[][] bArr5 = bArr2;
        byte[] bArr6 = bArr3;
        Validator.ensureNotNull(str);
        Validator.ensureTrue(bArr4 != null || (bArr5 != null && bArr5.length > 0) || bArr6 != null);
        ASN1OctetString aSN1OctetString = null;
        ASN1OctetString aSN1OctetString2 = bArr4 == null ? null : new ASN1OctetString(bArr4);
        if (bArr5 == null) {
            aSN1OctetStringArr = NO_SUB_ANY;
        } else {
            aSN1OctetStringArr = new ASN1OctetString[bArr5.length];
            for (int i = 0; i < bArr5.length; i++) {
                aSN1OctetStringArr[i] = new ASN1OctetString(bArr5[i]);
            }
        }
        ASN1OctetString[] aSN1OctetStringArr2 = aSN1OctetStringArr;
        if (bArr6 != null) {
            aSN1OctetString = new ASN1OctetString(bArr6);
        }
        return new Filter((String) null, FILTER_TYPE_SUBSTRING, NO_FILTERS, (Filter) null, str, (ASN1OctetString) null, aSN1OctetString2, aSN1OctetStringArr2, aSN1OctetString, (String) null, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:82:0x020d, code lost:
        r5 = NO_FILTERS;
        r6 = NO_SUB_ANY;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:85:0x0215, code lost:
        r15 = com.unboundid.asn1.ASN1Sequence.decodeAsSequence(r15).elements();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:86:0x021a, code lost:
        if (r15.length != 2) goto L_0x0237;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:87:0x021c, code lost:
        r0 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString(r15[0]).stringValue();
        r4 = null;
        r7 = null;
        r9 = null;
        r10 = null;
        r3 = r5;
        r8 = r6;
        r11 = false;
        r6 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString(r15[1]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:88:0x0234, code lost:
        r5 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:90:0x024d, code lost:
        throw new com.unboundid.ldap.sdk.LDAPException(com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR, com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_INVALID_AVA_ELEMENT_COUNT.get(java.lang.Integer.valueOf(r15.length)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:91:0x024e, code lost:
        r15 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:92:0x024f, code lost:
        com.unboundid.util.Debug.debugException(r15);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:93:0x0267, code lost:
        throw new com.unboundid.ldap.sdk.LDAPException(com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR, com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_CANNOT_DECODE_AVA.get(com.unboundid.util.StaticUtils.getExceptionMessage(r15)), r15);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.unboundid.ldap.sdk.Filter decode(com.unboundid.asn1.ASN1Element r15) {
        /*
            byte r2 = r15.getType()
            r0 = -121(0xffffffffffffff87, float:NaN)
            r1 = 0
            r3 = 0
            if (r2 == r0) goto L_0x02dc
            r0 = 2
            r4 = 1
            switch(r2) {
                case -96: goto L_0x029c;
                case -95: goto L_0x029c;
                case -94: goto L_0x0268;
                case -93: goto L_0x020d;
                case -92: goto L_0x0129;
                case -91: goto L_0x020d;
                case -90: goto L_0x020d;
                default: goto L_0x000f;
            }
        L_0x000f:
            switch(r2) {
                case -88: goto L_0x020d;
                case -87: goto L_0x002c;
                default: goto L_0x0012;
            }
        L_0x0012:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_ELEMENT_INVALID_TYPE
            java.lang.Object[] r4 = new java.lang.Object[r4]
            byte r15 = r15.getType()
            java.lang.String r15 = com.unboundid.util.StaticUtils.toHex((byte) r15)
            r4[r1] = r15
            java.lang.String r15 = r3.get(r4)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r15)
            throw r0
        L_0x002c:
            com.unboundid.ldap.sdk.Filter[] r0 = NO_FILTERS
            com.unboundid.asn1.ASN1OctetString[] r5 = NO_SUB_ANY
            com.unboundid.asn1.ASN1Sequence r15 = com.unboundid.asn1.ASN1Sequence.decodeAsSequence((com.unboundid.asn1.ASN1Element) r15)     // Catch:{ ASN1Exception -> 0x010f }
            com.unboundid.asn1.ASN1Element[] r15 = r15.elements()
            int r6 = r15.length
            r8 = r3
            r9 = r8
            r10 = r9
            r7 = 0
            r11 = 0
        L_0x003e:
            if (r7 >= r6) goto L_0x00e1
            r12 = r15[r7]
            byte r13 = r12.getType()
            switch(r13) {
                case -127: goto L_0x00c5;
                case -126: goto L_0x00ac;
                case -125: goto L_0x0097;
                case -124: goto L_0x0063;
                default: goto L_0x0049;
            }
        L_0x0049:
            com.unboundid.ldap.sdk.LDAPException r15 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EXTMATCH_INVALID_TYPE
            java.lang.Object[] r3 = new java.lang.Object[r4]
            byte r4 = r12.getType()
            java.lang.String r4 = com.unboundid.util.StaticUtils.toHex((byte) r4)
            r3[r1] = r4
            java.lang.String r1 = r2.get(r3)
            r15.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r1)
            throw r15
        L_0x0063:
            if (r11 != 0) goto L_0x0070
            com.unboundid.asn1.ASN1Boolean r11 = com.unboundid.asn1.ASN1Boolean.decodeAsBoolean((com.unboundid.asn1.ASN1Element) r12)     // Catch:{ ASN1Exception -> 0x006e }
            boolean r11 = r11.booleanValue()     // Catch:{ ASN1Exception -> 0x006e }
            goto L_0x00cf
        L_0x006e:
            r15 = move-exception
            goto L_0x007e
        L_0x0070:
            com.unboundid.ldap.sdk.LDAPException r15 = new com.unboundid.ldap.sdk.LDAPException     // Catch:{ ASN1Exception -> 0x006e }
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR     // Catch:{ ASN1Exception -> 0x006e }
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EXTMATCH_MULTIPLE_DNATTRS     // Catch:{ ASN1Exception -> 0x006e }
            java.lang.String r2 = r2.get()     // Catch:{ ASN1Exception -> 0x006e }
            r15.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r2)     // Catch:{ ASN1Exception -> 0x006e }
            throw r15     // Catch:{ ASN1Exception -> 0x006e }
        L_0x007e:
            com.unboundid.util.Debug.debugException(r15)
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EXTMATCH_DNATTRS_NOT_BOOLEAN
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = com.unboundid.util.StaticUtils.getExceptionMessage(r15)
            r4[r1] = r5
            java.lang.String r1 = r3.get(r4)
            r0.<init>(r2, r1, r15)
            throw r0
        L_0x0097:
            if (r10 != 0) goto L_0x009e
            com.unboundid.asn1.ASN1OctetString r10 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString((com.unboundid.asn1.ASN1Element) r12)
            goto L_0x00cf
        L_0x009e:
            com.unboundid.ldap.sdk.LDAPException r15 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EXTMATCH_MULTIPLE_VALUES
            java.lang.String r1 = r1.get()
            r15.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r1)
            throw r15
        L_0x00ac:
            if (r8 != 0) goto L_0x00b7
            com.unboundid.asn1.ASN1OctetString r8 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString((com.unboundid.asn1.ASN1Element) r12)
            java.lang.String r8 = r8.stringValue()
            goto L_0x00cf
        L_0x00b7:
            com.unboundid.ldap.sdk.LDAPException r15 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EXTMATCH_MULTIPLE_ATTRS
            java.lang.String r1 = r1.get()
            r15.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r1)
            throw r15
        L_0x00c5:
            if (r9 != 0) goto L_0x00d3
            com.unboundid.asn1.ASN1OctetString r9 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString((com.unboundid.asn1.ASN1Element) r12)
            java.lang.String r9 = r9.stringValue()
        L_0x00cf:
            int r7 = r7 + 1
            goto L_0x003e
        L_0x00d3:
            com.unboundid.ldap.sdk.LDAPException r15 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EXTMATCH_MULTIPLE_MRIDS
            java.lang.String r1 = r1.get()
            r15.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r1)
            throw r15
        L_0x00e1:
            if (r8 != 0) goto L_0x00f4
            if (r9 == 0) goto L_0x00e6
            goto L_0x00f4
        L_0x00e6:
            com.unboundid.ldap.sdk.LDAPException r15 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EXTMATCH_NO_ATTR_OR_MRID
            java.lang.String r1 = r1.get()
            r15.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r1)
            throw r15
        L_0x00f4:
            if (r10 == 0) goto L_0x0101
            r4 = r3
            r7 = r4
            r6 = r10
            r3 = r0
            r10 = r9
            r9 = r7
            r14 = r8
            r8 = r5
            r5 = r14
            goto L_0x02f1
        L_0x0101:
            com.unboundid.ldap.sdk.LDAPException r15 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_EXTMATCH_NO_VALUE
            java.lang.String r1 = r1.get()
            r15.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r1)
            throw r15
        L_0x010f:
            r15 = move-exception
            com.unboundid.util.Debug.debugException(r15)
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_CANNOT_DECODE_EXTMATCH
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = com.unboundid.util.StaticUtils.getExceptionMessage(r15)
            r4[r1] = r5
            java.lang.String r1 = r3.get(r4)
            r0.<init>(r2, r1, r15)
            throw r0
        L_0x0129:
            com.unboundid.ldap.sdk.Filter[] r5 = NO_FILTERS
            com.unboundid.asn1.ASN1Sequence r15 = com.unboundid.asn1.ASN1Sequence.decodeAsSequence((com.unboundid.asn1.ASN1Element) r15)     // Catch:{ ASN1Exception -> 0x01f3 }
            com.unboundid.asn1.ASN1Element[] r15 = r15.elements()
            int r6 = r15.length
            if (r6 != r0) goto L_0x01dc
            r0 = r15[r1]
            com.unboundid.asn1.ASN1OctetString r0 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString((com.unboundid.asn1.ASN1Element) r0)
            java.lang.String r0 = r0.stringValue()
            r15 = r15[r4]     // Catch:{ ASN1Exception -> 0x01c2 }
            com.unboundid.asn1.ASN1Sequence r15 = com.unboundid.asn1.ASN1Sequence.decodeAsSequence((com.unboundid.asn1.ASN1Element) r15)     // Catch:{ ASN1Exception -> 0x01c2 }
            java.util.ArrayList r6 = new java.util.ArrayList
            r6.<init>(r4)
            com.unboundid.asn1.ASN1Element[] r15 = r15.elements()
            int r7 = r15.length
            r9 = r3
            r10 = r9
            r8 = 0
        L_0x0153:
            if (r8 >= r7) goto L_0x01ac
            r11 = r15[r8]
            byte r12 = r11.getType()
            switch(r12) {
                case -128: goto L_0x0195;
                case -127: goto L_0x018d;
                case -126: goto L_0x0178;
                default: goto L_0x015e;
            }
        L_0x015e:
            com.unboundid.ldap.sdk.LDAPException r15 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_INVALID_SUBSTR_TYPE
            java.lang.Object[] r3 = new java.lang.Object[r4]
            byte r4 = r11.getType()
            java.lang.String r4 = com.unboundid.util.StaticUtils.toHex((byte) r4)
            r3[r1] = r4
            java.lang.String r1 = r2.get(r3)
            r15.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r1)
            throw r15
        L_0x0178:
            if (r10 != 0) goto L_0x017f
            com.unboundid.asn1.ASN1OctetString r10 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString((com.unboundid.asn1.ASN1Element) r11)
            goto L_0x019b
        L_0x017f:
            com.unboundid.ldap.sdk.LDAPException r15 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_MULTIPLE_SUBFINAL
            java.lang.String r1 = r1.get()
            r15.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r1)
            throw r15
        L_0x018d:
            com.unboundid.asn1.ASN1OctetString r11 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString((com.unboundid.asn1.ASN1Element) r11)
            r6.add(r11)
            goto L_0x019b
        L_0x0195:
            if (r9 != 0) goto L_0x019e
            com.unboundid.asn1.ASN1OctetString r9 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString((com.unboundid.asn1.ASN1Element) r11)
        L_0x019b:
            int r8 = r8 + 1
            goto L_0x0153
        L_0x019e:
            com.unboundid.ldap.sdk.LDAPException r15 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_MULTIPLE_SUBINITIAL
            java.lang.String r1 = r1.get()
            r15.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r1)
            throw r15
        L_0x01ac:
            int r15 = r6.size()
            com.unboundid.asn1.ASN1OctetString[] r15 = new com.unboundid.asn1.ASN1OctetString[r15]
            java.lang.Object[] r15 = r6.toArray(r15)
            com.unboundid.asn1.ASN1OctetString[] r15 = (com.unboundid.asn1.ASN1OctetString[]) r15
            r8 = r15
            r4 = r3
            r6 = r4
            r7 = r9
            r9 = r10
            r11 = 0
            r10 = r6
            r3 = r5
            goto L_0x0234
        L_0x01c2:
            r15 = move-exception
            com.unboundid.util.Debug.debugException(r15)
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_CANNOT_DECODE_SUBSTRING
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = com.unboundid.util.StaticUtils.getExceptionMessage(r15)
            r4[r1] = r5
            java.lang.String r1 = r3.get(r4)
            r0.<init>(r2, r1, r15)
            throw r0
        L_0x01dc:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_INVALID_SUBSTR_ASSERTION_COUNT
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r15 = r15.length
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r4[r1] = r15
            java.lang.String r15 = r3.get(r4)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r15)
            throw r0
        L_0x01f3:
            r15 = move-exception
            com.unboundid.util.Debug.debugException(r15)
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_CANNOT_DECODE_SUBSTRING
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = com.unboundid.util.StaticUtils.getExceptionMessage(r15)
            r4[r1] = r5
            java.lang.String r1 = r3.get(r4)
            r0.<init>(r2, r1, r15)
            throw r0
        L_0x020d:
            com.unboundid.ldap.sdk.Filter[] r5 = NO_FILTERS
            com.unboundid.asn1.ASN1OctetString[] r6 = NO_SUB_ANY
            com.unboundid.asn1.ASN1Sequence r15 = com.unboundid.asn1.ASN1Sequence.decodeAsSequence((com.unboundid.asn1.ASN1Element) r15)     // Catch:{ ASN1Exception -> 0x024e }
            com.unboundid.asn1.ASN1Element[] r15 = r15.elements()
            int r7 = r15.length
            if (r7 != r0) goto L_0x0237
            r0 = r15[r1]
            com.unboundid.asn1.ASN1OctetString r0 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString((com.unboundid.asn1.ASN1Element) r0)
            java.lang.String r0 = r0.stringValue()
            r15 = r15[r4]
            com.unboundid.asn1.ASN1OctetString r15 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString((com.unboundid.asn1.ASN1Element) r15)
            r4 = r3
            r7 = r4
            r9 = r7
            r10 = r9
            r3 = r5
            r8 = r6
            r11 = 0
            r6 = r15
        L_0x0234:
            r5 = r0
            goto L_0x02f1
        L_0x0237:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_INVALID_AVA_ELEMENT_COUNT
            java.lang.Object[] r4 = new java.lang.Object[r4]
            int r15 = r15.length
            java.lang.Integer r15 = java.lang.Integer.valueOf(r15)
            r4[r1] = r15
            java.lang.String r15 = r3.get(r4)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r15)
            throw r0
        L_0x024e:
            r15 = move-exception
            com.unboundid.util.Debug.debugException(r15)
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_CANNOT_DECODE_AVA
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = com.unboundid.util.StaticUtils.getExceptionMessage(r15)
            r4[r1] = r5
            java.lang.String r1 = r3.get(r4)
            r0.<init>(r2, r1, r15)
            throw r0
        L_0x0268:
            com.unboundid.ldap.sdk.Filter[] r0 = NO_FILTERS
            com.unboundid.asn1.ASN1OctetString[] r5 = NO_SUB_ANY
            byte[] r15 = r15.getValue()     // Catch:{ ASN1Exception -> 0x0282 }
            com.unboundid.asn1.ASN1Element r15 = com.unboundid.asn1.ASN1Element.decode(r15)     // Catch:{ ASN1Exception -> 0x0282 }
            com.unboundid.ldap.sdk.Filter r15 = decode(r15)
            r4 = r15
            r6 = r3
            r7 = r6
            r9 = r7
            r10 = r9
            r8 = r5
            r11 = 0
            r5 = r10
            goto L_0x02f0
        L_0x0282:
            r15 = move-exception
            com.unboundid.util.Debug.debugException(r15)
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_CANNOT_DECODE_NOT_COMP
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = com.unboundid.util.StaticUtils.getExceptionMessage(r15)
            r4[r1] = r5
            java.lang.String r1 = r3.get(r4)
            r0.<init>(r2, r1, r15)
            throw r0
        L_0x029c:
            com.unboundid.asn1.ASN1OctetString[] r0 = NO_SUB_ANY
            com.unboundid.asn1.ASN1Set r15 = com.unboundid.asn1.ASN1Set.decodeAsSet((com.unboundid.asn1.ASN1Element) r15)     // Catch:{ ASN1Exception -> 0x02c2 }
            com.unboundid.asn1.ASN1Element[] r15 = r15.elements()
            int r4 = r15.length
            com.unboundid.ldap.sdk.Filter[] r4 = new com.unboundid.ldap.sdk.Filter[r4]
            r5 = 0
        L_0x02aa:
            int r6 = r15.length
            if (r5 >= r6) goto L_0x02b8
            r6 = r15[r5]
            com.unboundid.ldap.sdk.Filter r6 = decode(r6)
            r4[r5] = r6
            int r5 = r5 + 1
            goto L_0x02aa
        L_0x02b8:
            r8 = r0
            r5 = r3
            r6 = r5
            r7 = r6
            r9 = r7
            r10 = r9
            r11 = 0
            r3 = r4
            r4 = r10
            goto L_0x02f1
        L_0x02c2:
            r15 = move-exception
            com.unboundid.util.Debug.debugException(r15)
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.DECODING_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_CANNOT_DECODE_COMPS
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.String r5 = com.unboundid.util.StaticUtils.getExceptionMessage(r15)
            r4[r1] = r5
            java.lang.String r1 = r3.get(r4)
            r0.<init>(r2, r1, r15)
            throw r0
        L_0x02dc:
            com.unboundid.ldap.sdk.Filter[] r0 = NO_FILTERS
            com.unboundid.asn1.ASN1OctetString[] r4 = NO_SUB_ANY
            com.unboundid.asn1.ASN1OctetString r15 = com.unboundid.asn1.ASN1OctetString.decodeAsOctetString((com.unboundid.asn1.ASN1Element) r15)
            java.lang.String r15 = r15.stringValue()
            r5 = r15
            r6 = r3
            r7 = r6
            r9 = r7
            r10 = r9
            r8 = r4
            r11 = 0
            r4 = r10
        L_0x02f0:
            r3 = r0
        L_0x02f1:
            com.unboundid.ldap.sdk.Filter r15 = new com.unboundid.ldap.sdk.Filter
            r1 = 0
            r0 = r15
            r0.<init>(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11)
            return r15
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.Filter.decode(com.unboundid.asn1.ASN1Element):com.unboundid.ldap.sdk.Filter");
    }

    public static String encodeValue(String str) {
        Validator.ensureNotNull(str);
        StringBuilder sb = new StringBuilder();
        encodeValue(new ASN1OctetString(str), sb);
        return sb.toString();
    }

    public static String encodeValue(byte[] bArr) {
        Validator.ensureNotNull(bArr);
        StringBuilder sb = new StringBuilder();
        encodeValue(new ASN1OctetString(bArr), sb);
        return sb.toString();
    }

    private static void encodeValue(ASN1OctetString aSN1OctetString, StringBuilder sb) {
        String stringValue = aSN1OctetString.stringValue();
        int length = stringValue.length();
        for (int i = 0; i < length; i++) {
            char charAt = stringValue.charAt(i);
            if (!(charAt == 0 || charAt == '\\')) {
                switch (charAt) {
                    case '(':
                    case ')':
                    case '*':
                        break;
                    default:
                        if (charAt <= 127) {
                            sb.append(charAt);
                            continue;
                        }
                        break;
                }
            }
            StaticUtils.hexEncode(charAt, sb);
        }
    }

    private static Filter[] parseFilterComps(String str, int i, int i2, int i3) {
        if (i > i2) {
            return NO_FILTERS;
        }
        if (str.charAt(i) != '(') {
            throw new LDAPException(ResultCode.FILTER_ERROR, LDAPMessages.ERR_FILTER_EXPECTED_OPEN_PAREN.get(Integer.valueOf(i)));
        } else if (str.charAt(i2) == ')') {
            ArrayList arrayList = new ArrayList(5);
            int i4 = i;
            int i5 = i4;
            int i6 = 0;
            while (i4 <= i2) {
                int i7 = i4 + 1;
                char charAt = str.charAt(i4);
                if (charAt == '(') {
                    i6++;
                } else if (charAt == ')' && i6 - 1 == 0) {
                    arrayList.add(create(str, i5, i7 - 1, i3));
                    i5 = i7;
                }
                i4 = i7;
            }
            if (i6 == 0) {
                return (Filter[]) arrayList.toArray(new Filter[arrayList.size()]);
            }
            throw new LDAPException(ResultCode.FILTER_ERROR, LDAPMessages.ERR_FILTER_MISMATCHED_PARENS.get(Integer.valueOf(i), Integer.valueOf(i2)));
        } else {
            throw new LDAPException(ResultCode.FILTER_ERROR, LDAPMessages.ERR_FILTER_EXPECTED_CLOSE_PAREN.get(Integer.valueOf(i)));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0041, code lost:
        r7 = -48;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0044, code lost:
        r7 = -64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0047, code lost:
        r7 = -80;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
        r7 = -96;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009b, code lost:
        r7 = r7 | 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x009e, code lost:
        r7 = r7 | 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a1, code lost:
        r7 = r7 | 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a4, code lost:
        r7 = r7 | 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a7, code lost:
        r7 = r7 | 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00aa, code lost:
        r7 = r7 | 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00c7, code lost:
        r7 = (byte) r7;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003b, code lost:
        r7 = -16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x003e, code lost:
        r7 = -32;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int readEscapedHexString(java.lang.String r6, int r7, int r8, java.lang.StringBuilder r9) {
        /*
            int r0 = r8 - r7
            java.nio.ByteBuffer r0 = java.nio.ByteBuffer.allocate(r0)
        L_0x0006:
            if (r7 > r8) goto L_0x00f6
            int r1 = r7 + 1
            char r7 = r6.charAt(r7)
            r2 = 2
            r3 = 0
            r4 = 1
            switch(r7) {
                case 48: goto L_0x0068;
                case 49: goto L_0x0065;
                case 50: goto L_0x0062;
                case 51: goto L_0x005f;
                case 52: goto L_0x005c;
                case 53: goto L_0x0059;
                case 54: goto L_0x0056;
                case 55: goto L_0x0053;
                case 56: goto L_0x0050;
                case 57: goto L_0x004d;
                default: goto L_0x0014;
            }
        L_0x0014:
            switch(r7) {
                case 65: goto L_0x004a;
                case 66: goto L_0x0047;
                case 67: goto L_0x0044;
                case 68: goto L_0x0041;
                case 69: goto L_0x003e;
                case 70: goto L_0x003b;
                default: goto L_0x0017;
            }
        L_0x0017:
            switch(r7) {
                case 97: goto L_0x004a;
                case 98: goto L_0x0047;
                case 99: goto L_0x0044;
                case 100: goto L_0x0041;
                case 101: goto L_0x003e;
                case 102: goto L_0x003b;
                default: goto L_0x001a;
            }
        L_0x001a:
            com.unboundid.ldap.sdk.LDAPException r7 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r8 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r9 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_INVALID_HEX_CHAR
            java.lang.Object[] r0 = new java.lang.Object[r2]
            int r1 = r1 - r4
            char r6 = r6.charAt(r1)
            java.lang.Character r6 = java.lang.Character.valueOf(r6)
            r0[r3] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r1)
            r0[r4] = r6
            java.lang.String r6 = r9.get(r0)
            r7.<init>((com.unboundid.ldap.sdk.ResultCode) r8, (java.lang.String) r6)
            throw r7
        L_0x003b:
            r7 = -16
            goto L_0x0069
        L_0x003e:
            r7 = -32
            goto L_0x0069
        L_0x0041:
            r7 = -48
            goto L_0x0069
        L_0x0044:
            r7 = -64
            goto L_0x0069
        L_0x0047:
            r7 = -80
            goto L_0x0069
        L_0x004a:
            r7 = -96
            goto L_0x0069
        L_0x004d:
            r7 = -112(0xffffffffffffff90, float:NaN)
            goto L_0x0069
        L_0x0050:
            r7 = -128(0xffffffffffffff80, float:NaN)
            goto L_0x0069
        L_0x0053:
            r7 = 112(0x70, float:1.57E-43)
            goto L_0x0069
        L_0x0056:
            r7 = 96
            goto L_0x0069
        L_0x0059:
            r7 = 80
            goto L_0x0069
        L_0x005c:
            r7 = 64
            goto L_0x0069
        L_0x005f:
            r7 = 48
            goto L_0x0069
        L_0x0062:
            r7 = 32
            goto L_0x0069
        L_0x0065:
            r7 = 16
            goto L_0x0069
        L_0x0068:
            r7 = 0
        L_0x0069:
            if (r1 > r8) goto L_0x00db
            int r5 = r1 + 1
            char r1 = r6.charAt(r1)
            switch(r1) {
                case 48: goto L_0x00c8;
                case 49: goto L_0x00c5;
                case 50: goto L_0x00c2;
                case 51: goto L_0x00bf;
                case 52: goto L_0x00bc;
                case 53: goto L_0x00b9;
                case 54: goto L_0x00b6;
                case 55: goto L_0x00b3;
                case 56: goto L_0x00b0;
                case 57: goto L_0x00ad;
                default: goto L_0x0074;
            }
        L_0x0074:
            switch(r1) {
                case 65: goto L_0x00aa;
                case 66: goto L_0x00a7;
                case 67: goto L_0x00a4;
                case 68: goto L_0x00a1;
                case 69: goto L_0x009e;
                case 70: goto L_0x009b;
                default: goto L_0x0077;
            }
        L_0x0077:
            switch(r1) {
                case 97: goto L_0x00aa;
                case 98: goto L_0x00a7;
                case 99: goto L_0x00a4;
                case 100: goto L_0x00a1;
                case 101: goto L_0x009e;
                case 102: goto L_0x009b;
                default: goto L_0x007a;
            }
        L_0x007a:
            com.unboundid.ldap.sdk.LDAPException r7 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r8 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r9 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_INVALID_HEX_CHAR
            java.lang.Object[] r0 = new java.lang.Object[r2]
            int r5 = r5 - r4
            char r6 = r6.charAt(r5)
            java.lang.Character r6 = java.lang.Character.valueOf(r6)
            r0[r3] = r6
            java.lang.Integer r6 = java.lang.Integer.valueOf(r5)
            r0[r4] = r6
            java.lang.String r6 = r9.get(r0)
            r7.<init>((com.unboundid.ldap.sdk.ResultCode) r8, (java.lang.String) r6)
            throw r7
        L_0x009b:
            r7 = r7 | 15
            goto L_0x00c7
        L_0x009e:
            r7 = r7 | 14
            goto L_0x00c7
        L_0x00a1:
            r7 = r7 | 13
            goto L_0x00c7
        L_0x00a4:
            r7 = r7 | 12
            goto L_0x00c7
        L_0x00a7:
            r7 = r7 | 11
            goto L_0x00c7
        L_0x00aa:
            r7 = r7 | 10
            goto L_0x00c7
        L_0x00ad:
            r7 = r7 | 9
            goto L_0x00c7
        L_0x00b0:
            r7 = r7 | 8
            goto L_0x00c7
        L_0x00b3:
            r7 = r7 | 7
            goto L_0x00c7
        L_0x00b6:
            r7 = r7 | 6
            goto L_0x00c7
        L_0x00b9:
            r7 = r7 | 5
            goto L_0x00c7
        L_0x00bc:
            r7 = r7 | 4
            goto L_0x00c7
        L_0x00bf:
            r7 = r7 | 3
            goto L_0x00c7
        L_0x00c2:
            r7 = r7 | 2
            goto L_0x00c7
        L_0x00c5:
            r7 = r7 | 1
        L_0x00c7:
            byte r7 = (byte) r7
        L_0x00c8:
            r0.put(r7)
            if (r5 > r8) goto L_0x00d9
            char r7 = r6.charAt(r5)
            r1 = 92
            if (r7 != r1) goto L_0x00d9
            int r7 = r5 + 1
            goto L_0x0006
        L_0x00d9:
            r7 = r5
            goto L_0x00f6
        L_0x00db:
            com.unboundid.ldap.sdk.LDAPException r7 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r8 = com.unboundid.ldap.sdk.ResultCode.FILTER_ERROR
            com.unboundid.ldap.sdk.LDAPMessages r9 = com.unboundid.ldap.sdk.LDAPMessages.ERR_FILTER_INVALID_ESCAPED_END_CHAR
            java.lang.Object[] r0 = new java.lang.Object[r4]
            int r1 = r1 - r4
            char r6 = r6.charAt(r1)
            java.lang.Character r6 = java.lang.Character.valueOf(r6)
            r0[r3] = r6
            java.lang.String r6 = r9.get(r0)
            r7.<init>((com.unboundid.ldap.sdk.ResultCode) r8, (java.lang.String) r6)
            throw r7
        L_0x00f6:
            r0.flip()
            int r6 = r0.limit()
            byte[] r6 = new byte[r6]
            r0.get(r6)
            java.lang.String r6 = com.unboundid.util.StaticUtils.toUTF8String(r6)
            r9.append(r6)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.Filter.readEscapedHexString(java.lang.String, int, int, java.lang.StringBuilder):int");
    }

    public static Filter readFrom(ASN1StreamReader aSN1StreamReader) {
        boolean z;
        String str;
        ASN1OctetString aSN1OctetString;
        ASN1OctetString[] aSN1OctetStringArr;
        ASN1OctetString aSN1OctetString2;
        ASN1OctetString aSN1OctetString3;
        String str2;
        Filter filter;
        Filter[] filterArr;
        ASN1OctetString[] aSN1OctetStringArr2;
        try {
            byte peek = (byte) aSN1StreamReader.peek();
            if (peek != -121) {
                switch (peek) {
                    case -96:
                    case -95:
                        ArrayList arrayList = new ArrayList(5);
                        ASN1StreamReaderSet beginSet = aSN1StreamReader.beginSet();
                        while (beginSet.hasMoreElements()) {
                            arrayList.add(readFrom(aSN1StreamReader));
                        }
                        Filter[] filterArr2 = new Filter[arrayList.size()];
                        arrayList.toArray(filterArr2);
                        filterArr = filterArr2;
                        aSN1OctetStringArr = NO_SUB_ANY;
                        filter = null;
                        str2 = null;
                        aSN1OctetString3 = null;
                        aSN1OctetString2 = null;
                        aSN1OctetString = null;
                        str = null;
                        break;
                    case -94:
                        Filter decode = decode(ASN1Element.decode(aSN1StreamReader.readElement().getValue()));
                        Filter[] filterArr3 = NO_FILTERS;
                        aSN1OctetStringArr2 = NO_SUB_ANY;
                        filter = decode;
                        filterArr = filterArr3;
                        str2 = null;
                        aSN1OctetString3 = null;
                        break;
                    case -93:
                    case -91:
                    case -90:
                        aSN1StreamReader.beginSequence();
                        String readString = aSN1StreamReader.readString();
                        ASN1OctetString aSN1OctetString4 = new ASN1OctetString(aSN1StreamReader.readBytes());
                        Filter[] filterArr4 = NO_FILTERS;
                        str2 = readString;
                        filter = null;
                        aSN1OctetString2 = null;
                        aSN1OctetString = null;
                        str = null;
                        aSN1OctetString3 = aSN1OctetString4;
                        aSN1OctetStringArr = NO_SUB_ANY;
                        z = false;
                        filterArr = filterArr4;
                        break;
                    case -92:
                        aSN1StreamReader.beginSequence();
                        String readString2 = aSN1StreamReader.readString();
                        ArrayList arrayList2 = new ArrayList(1);
                        ASN1StreamReaderSequence beginSequence = aSN1StreamReader.beginSequence();
                        ASN1OctetString aSN1OctetString5 = null;
                        ASN1OctetString aSN1OctetString6 = null;
                        while (beginSequence.hasMoreElements()) {
                            byte peek2 = (byte) aSN1StreamReader.peek();
                            ASN1OctetString aSN1OctetString7 = new ASN1OctetString(peek2, aSN1StreamReader.readBytes());
                            switch (peek2) {
                                case Byte.MIN_VALUE:
                                    aSN1OctetString5 = aSN1OctetString7;
                                    break;
                                case -127:
                                    arrayList2.add(aSN1OctetString7);
                                    break;
                                case -126:
                                    aSN1OctetString6 = aSN1OctetString7;
                                    break;
                                default:
                                    throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_FILTER_INVALID_SUBSTR_TYPE.get(StaticUtils.toHex(peek2)));
                            }
                        }
                        ASN1OctetString[] aSN1OctetStringArr3 = new ASN1OctetString[arrayList2.size()];
                        arrayList2.toArray(aSN1OctetStringArr3);
                        aSN1OctetStringArr = aSN1OctetStringArr3;
                        aSN1OctetString3 = null;
                        str = null;
                        filterArr = NO_FILTERS;
                        aSN1OctetString2 = aSN1OctetString5;
                        aSN1OctetString = aSN1OctetString6;
                        z = false;
                        str2 = readString2;
                        filter = null;
                        break;
                    default:
                        switch (peek) {
                            case -88:
                                break;
                            case -87:
                                ASN1StreamReaderSequence beginSequence2 = aSN1StreamReader.beginSequence();
                                String str3 = null;
                                String str4 = null;
                                ASN1OctetString aSN1OctetString8 = null;
                                boolean z2 = false;
                                while (beginSequence2.hasMoreElements()) {
                                    byte peek3 = (byte) aSN1StreamReader.peek();
                                    switch (peek3) {
                                        case -127:
                                            str4 = aSN1StreamReader.readString();
                                            break;
                                        case -126:
                                            str3 = aSN1StreamReader.readString();
                                            break;
                                        case -125:
                                            aSN1OctetString8 = new ASN1OctetString(peek3, aSN1StreamReader.readBytes());
                                            break;
                                        case -124:
                                            z2 = aSN1StreamReader.readBoolean().booleanValue();
                                            break;
                                        default:
                                            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_FILTER_EXTMATCH_INVALID_TYPE.get(StaticUtils.toHex(peek3)));
                                    }
                                }
                                if (str3 == null) {
                                    if (str4 == null) {
                                        throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_FILTER_EXTMATCH_NO_ATTR_OR_MRID.get());
                                    }
                                }
                                if (aSN1OctetString8 != null) {
                                    Filter[] filterArr5 = NO_FILTERS;
                                    aSN1OctetStringArr = NO_SUB_ANY;
                                    aSN1OctetString2 = null;
                                    aSN1OctetString = null;
                                    str = str4;
                                    aSN1OctetString3 = aSN1OctetString8;
                                    z = z2;
                                    filterArr = filterArr5;
                                    filter = null;
                                    str2 = str3;
                                    break;
                                } else {
                                    throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_FILTER_EXTMATCH_NO_VALUE.get());
                                }
                            default:
                                throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_FILTER_ELEMENT_INVALID_TYPE.get(StaticUtils.toHex(peek)));
                        }
                        aSN1StreamReader.beginSequence();
                        String readString3 = aSN1StreamReader.readString();
                        ASN1OctetString aSN1OctetString42 = new ASN1OctetString(aSN1StreamReader.readBytes());
                        Filter[] filterArr42 = NO_FILTERS;
                        str2 = readString3;
                        filter = null;
                        aSN1OctetString2 = null;
                        aSN1OctetString = null;
                        str = null;
                        aSN1OctetString3 = aSN1OctetString42;
                        aSN1OctetStringArr = NO_SUB_ANY;
                        z = false;
                        filterArr = filterArr42;
                        break;
                }
            } else {
                String readString4 = aSN1StreamReader.readString();
                Filter[] filterArr6 = NO_FILTERS;
                aSN1OctetStringArr2 = NO_SUB_ANY;
                str2 = readString4;
                filterArr = filterArr6;
                filter = null;
                aSN1OctetString3 = null;
            }
            aSN1OctetString2 = aSN1OctetString3;
            aSN1OctetString = aSN1OctetString2;
            str = aSN1OctetString;
            aSN1OctetStringArr = aSN1OctetStringArr2;
            z = false;
            return new Filter((String) null, peek, filterArr, filter, str2, aSN1OctetString3, aSN1OctetString2, aSN1OctetStringArr, aSN1OctetString, str, z);
        } catch (ASN1Exception e) {
            Debug.debugException(e);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_FILTER_CANNOT_DECODE_NOT_COMP.get(StaticUtils.getExceptionMessage(e)), e);
        } catch (LDAPException e2) {
            Debug.debugException(e2);
            throw e2;
        } catch (Exception e3) {
            Debug.debugException(e3);
            throw new LDAPException(ResultCode.DECODING_ERROR, LDAPMessages.ERR_FILTER_CANNOT_DECODE.get(StaticUtils.getExceptionMessage(e3)), e3);
        }
    }

    public ASN1Element encode() {
        byte b = this.filterType;
        if (b == -121) {
            return new ASN1OctetString(b, this.attrName);
        }
        int i = 0;
        switch (b) {
            case -96:
            case -95:
                ASN1Element[] aSN1ElementArr = new ASN1Element[this.filterComps.length];
                while (true) {
                    Filter[] filterArr = this.filterComps;
                    if (i >= filterArr.length) {
                        return new ASN1Set(this.filterType, aSN1ElementArr);
                    }
                    aSN1ElementArr[i] = filterArr[i].encode();
                    i++;
                }
            case -94:
                return new ASN1Element(b, this.notComp.encode().encode());
            case -93:
            case -91:
            case -90:
                break;
            case -92:
                ArrayList arrayList = new ArrayList(this.subAny.length + 2);
                ASN1OctetString aSN1OctetString = this.subInitial;
                if (aSN1OctetString != null) {
                    arrayList.add(new ASN1OctetString(Byte.MIN_VALUE, aSN1OctetString.getValue()));
                }
                for (ASN1OctetString value : this.subAny) {
                    arrayList.add(new ASN1OctetString((byte) -127, value.getValue()));
                }
                ASN1OctetString aSN1OctetString2 = this.subFinal;
                if (aSN1OctetString2 != null) {
                    arrayList.add(new ASN1OctetString((byte) MatchingRule.SUBSTRING_TYPE_SUBFINAL, aSN1OctetString2.getValue()));
                }
                return new ASN1Sequence(this.filterType, new ASN1OctetString(this.attrName), new ASN1Sequence((Collection<? extends ASN1Element>) arrayList));
            default:
                switch (b) {
                    case -88:
                        break;
                    case -87:
                        ArrayList arrayList2 = new ArrayList(4);
                        String str = this.matchingRuleID;
                        if (str != null) {
                            arrayList2.add(new ASN1OctetString((byte) -127, str));
                        }
                        String str2 = this.attrName;
                        if (str2 != null) {
                            arrayList2.add(new ASN1OctetString((byte) MatchingRule.SUBSTRING_TYPE_SUBFINAL, str2));
                        }
                        arrayList2.add(new ASN1OctetString((byte) EXTENSIBLE_TYPE_MATCH_VALUE, this.assertionValue.getValue()));
                        if (this.dnAttributes) {
                            arrayList2.add(new ASN1Boolean(EXTENSIBLE_TYPE_DN_ATTRIBUTES, true));
                        }
                        return new ASN1Sequence(this.filterType, (Collection<? extends ASN1Element>) arrayList2);
                    default:
                        throw new AssertionError(LDAPMessages.ERR_FILTER_INVALID_TYPE.get(StaticUtils.toHex(this.filterType)));
                }
        }
        return new ASN1Sequence(this.filterType, (ASN1Element[]) new ASN1OctetString[]{new ASN1OctetString(this.attrName), this.assertionValue});
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Filter)) {
            return false;
        }
        Filter filter = (Filter) obj;
        if (this.filterType != filter.filterType) {
            return false;
        }
        CaseIgnoreStringMatchingRule instance = CaseIgnoreStringMatchingRule.getInstance();
        byte b = this.filterType;
        if (b == -121) {
            return this.attrName.equalsIgnoreCase(filter.attrName);
        }
        switch (b) {
            case -96:
            case -95:
                if (this.filterComps.length != filter.filterComps.length) {
                    return false;
                }
                HashSet hashSet = new HashSet();
                hashSet.addAll(Arrays.asList(this.filterComps));
                for (Filter remove : filter.filterComps) {
                    if (!hashSet.remove(remove)) {
                        return false;
                    }
                }
                return true;
            case -94:
                return this.notComp.equals(filter.notComp);
            case -93:
            case -91:
            case -90:
                break;
            case -92:
                if (!this.attrName.equalsIgnoreCase(filter.attrName) || this.subAny.length != filter.subAny.length) {
                    return false;
                }
                ASN1OctetString aSN1OctetString = this.subInitial;
                if (aSN1OctetString == null) {
                    if (filter.subInitial != null) {
                        return false;
                    }
                } else if (filter.subInitial == null || !instance.normalizeSubstring(aSN1OctetString, Byte.MIN_VALUE).equals(instance.normalizeSubstring(filter.subInitial, Byte.MIN_VALUE))) {
                    return false;
                }
                int i = 0;
                while (true) {
                    ASN1OctetString[] aSN1OctetStringArr = this.subAny;
                    if (i >= aSN1OctetStringArr.length) {
                        ASN1OctetString aSN1OctetString2 = this.subFinal;
                        if (aSN1OctetString2 != null) {
                            return filter.subFinal != null && instance.normalizeSubstring(aSN1OctetString2, MatchingRule.SUBSTRING_TYPE_SUBFINAL).equals(instance.normalizeSubstring(filter.subFinal, MatchingRule.SUBSTRING_TYPE_SUBFINAL));
                        }
                        if (filter.subFinal != null) {
                            return false;
                        }
                    } else if (!instance.normalizeSubstring(aSN1OctetStringArr[i], (byte) -127).equals(instance.normalizeSubstring(filter.subAny[i], (byte) -127))) {
                        return false;
                    } else {
                        i++;
                    }
                }
                break;
            default:
                switch (b) {
                    case -88:
                        break;
                    case -87:
                        String str = this.attrName;
                        if (str != null) {
                            String str2 = filter.attrName;
                            if (str2 == null || !str.equalsIgnoreCase(str2)) {
                                return false;
                            }
                        } else if (filter.attrName != null) {
                            return false;
                        }
                        String str3 = this.matchingRuleID;
                        if (str3 != null) {
                            String str4 = filter.matchingRuleID;
                            if (str4 == null || !str3.equalsIgnoreCase(str4)) {
                                return false;
                            }
                        } else if (filter.matchingRuleID != null) {
                            return false;
                        }
                        if (this.dnAttributes != filter.dnAttributes) {
                            return false;
                        }
                        return instance.valuesMatch(this.assertionValue, filter.assertionValue);
                    default:
                        return false;
                }
        }
        return this.attrName.equalsIgnoreCase(filter.attrName) && instance.valuesMatch(this.assertionValue, filter.assertionValue);
    }

    public String getAssertionValue() {
        ASN1OctetString aSN1OctetString = this.assertionValue;
        if (aSN1OctetString == null) {
            return null;
        }
        return aSN1OctetString.stringValue();
    }

    public byte[] getAssertionValueBytes() {
        ASN1OctetString aSN1OctetString = this.assertionValue;
        if (aSN1OctetString == null) {
            return null;
        }
        return aSN1OctetString.getValue();
    }

    public String getAttributeName() {
        return this.attrName;
    }

    public Filter[] getComponents() {
        return this.filterComps;
    }

    public boolean getDNAttributes() {
        return this.dnAttributes;
    }

    public byte getFilterType() {
        return this.filterType;
    }

    public String getMatchingRuleID() {
        return this.matchingRuleID;
    }

    public Filter getNOTComponent() {
        return this.notComp;
    }

    public ASN1OctetString getRawAssertionValue() {
        return this.assertionValue;
    }

    public ASN1OctetString[] getRawSubAnyValues() {
        return this.subAny;
    }

    public ASN1OctetString getRawSubFinalValue() {
        return this.subFinal;
    }

    public ASN1OctetString getRawSubInitialValue() {
        return this.subInitial;
    }

    public byte[][] getSubAnyBytes() {
        byte[][] bArr = new byte[this.subAny.length][];
        int i = 0;
        while (true) {
            ASN1OctetString[] aSN1OctetStringArr = this.subAny;
            if (i >= aSN1OctetStringArr.length) {
                return bArr;
            }
            bArr[i] = aSN1OctetStringArr[i].getValue();
            i++;
        }
    }

    public String[] getSubAnyStrings() {
        String[] strArr = new String[this.subAny.length];
        int i = 0;
        while (true) {
            ASN1OctetString[] aSN1OctetStringArr = this.subAny;
            if (i >= aSN1OctetStringArr.length) {
                return strArr;
            }
            strArr[i] = aSN1OctetStringArr[i].stringValue();
            i++;
        }
    }

    public byte[] getSubFinalBytes() {
        ASN1OctetString aSN1OctetString = this.subFinal;
        if (aSN1OctetString == null) {
            return null;
        }
        return aSN1OctetString.getValue();
    }

    public String getSubFinalString() {
        ASN1OctetString aSN1OctetString = this.subFinal;
        if (aSN1OctetString == null) {
            return null;
        }
        return aSN1OctetString.stringValue();
    }

    public byte[] getSubInitialBytes() {
        ASN1OctetString aSN1OctetString = this.subInitial;
        if (aSN1OctetString == null) {
            return null;
        }
        return aSN1OctetString.getValue();
    }

    public String getSubInitialString() {
        ASN1OctetString aSN1OctetString = this.subInitial;
        if (aSN1OctetString == null) {
            return null;
        }
        return aSN1OctetString.stringValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0079, code lost:
        r0 = r0.normalize(r7.assertionValue);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x007f, code lost:
        r0 = r0.hashCode();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int hashCode() {
        /*
            r7 = this;
            com.unboundid.ldap.matchingrules.CaseIgnoreStringMatchingRule r0 = com.unboundid.ldap.matchingrules.CaseIgnoreStringMatchingRule.getInstance()
            byte r1 = r7.filterType
            r2 = -121(0xffffffffffffff87, float:NaN)
            if (r1 == r2) goto L_0x009a
            r2 = 0
            switch(r1) {
                case -96: goto L_0x008b;
                case -95: goto L_0x008b;
                case -94: goto L_0x0084;
                case -93: goto L_0x006e;
                case -92: goto L_0x0034;
                case -91: goto L_0x006e;
                case -90: goto L_0x006e;
                default: goto L_0x000e;
            }
        L_0x000e:
            switch(r1) {
                case -88: goto L_0x006e;
                case -87: goto L_0x0013;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x00a5
        L_0x0013:
            java.lang.String r2 = r7.attrName
            if (r2 == 0) goto L_0x0020
            java.lang.String r2 = com.unboundid.util.StaticUtils.toLowerCase(r2)
            int r2 = r2.hashCode()
            int r1 = r1 + r2
        L_0x0020:
            java.lang.String r2 = r7.matchingRuleID
            if (r2 == 0) goto L_0x002d
            java.lang.String r2 = com.unboundid.util.StaticUtils.toLowerCase(r2)
            int r2 = r2.hashCode()
            int r1 = r1 + r2
        L_0x002d:
            boolean r2 = r7.dnAttributes
            if (r2 == 0) goto L_0x0079
            int r1 = r1 + 1
            goto L_0x0079
        L_0x0034:
            java.lang.String r3 = r7.attrName
            java.lang.String r3 = com.unboundid.util.StaticUtils.toLowerCase(r3)
            int r3 = r3.hashCode()
            int r1 = r1 + r3
            com.unboundid.asn1.ASN1OctetString r3 = r7.subInitial
            if (r3 == 0) goto L_0x004e
            r4 = -128(0xffffffffffffff80, float:NaN)
            com.unboundid.asn1.ASN1OctetString r3 = r0.normalizeSubstring(r3, r4)
            int r3 = r3.hashCode()
            int r1 = r1 + r3
        L_0x004e:
            com.unboundid.asn1.ASN1OctetString[] r3 = r7.subAny
            int r4 = r3.length
        L_0x0051:
            if (r2 >= r4) goto L_0x0063
            r5 = r3[r2]
            r6 = -127(0xffffffffffffff81, float:NaN)
            com.unboundid.asn1.ASN1OctetString r5 = r0.normalizeSubstring(r5, r6)
            int r5 = r5.hashCode()
            int r1 = r1 + r5
            int r2 = r2 + 1
            goto L_0x0051
        L_0x0063:
            com.unboundid.asn1.ASN1OctetString r2 = r7.subFinal
            if (r2 == 0) goto L_0x00a5
            r3 = -126(0xffffffffffffff82, float:NaN)
            com.unboundid.asn1.ASN1OctetString r0 = r0.normalizeSubstring(r2, r3)
            goto L_0x007f
        L_0x006e:
            java.lang.String r2 = r7.attrName
            java.lang.String r2 = com.unboundid.util.StaticUtils.toLowerCase(r2)
            int r2 = r2.hashCode()
            int r1 = r1 + r2
        L_0x0079:
            com.unboundid.asn1.ASN1OctetString r2 = r7.assertionValue
            com.unboundid.asn1.ASN1OctetString r0 = r0.normalize(r2)
        L_0x007f:
            int r0 = r0.hashCode()
            goto L_0x00a4
        L_0x0084:
            com.unboundid.ldap.sdk.Filter r0 = r7.notComp
            int r0 = r0.hashCode()
            goto L_0x00a4
        L_0x008b:
            com.unboundid.ldap.sdk.Filter[] r0 = r7.filterComps
            int r3 = r0.length
        L_0x008e:
            if (r2 >= r3) goto L_0x00a5
            r4 = r0[r2]
            int r4 = r4.hashCode()
            int r1 = r1 + r4
            int r2 = r2 + 1
            goto L_0x008e
        L_0x009a:
            java.lang.String r0 = r7.attrName
            java.lang.String r0 = com.unboundid.util.StaticUtils.toLowerCase(r0)
            int r0 = r0.hashCode()
        L_0x00a4:
            int r1 = r1 + r0
        L_0x00a5:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.Filter.hashCode():int");
    }

    public boolean matchesEntry(Entry entry) {
        return matchesEntry(entry, entry.getSchema());
    }

    public boolean matchesEntry(Entry entry, Schema schema) {
        Validator.ensureNotNull(entry);
        byte b = this.filterType;
        if (b == -121) {
            return entry.hasAttribute(this.attrName);
        }
        switch (b) {
            case -96:
                for (Filter matchesEntry : this.filterComps) {
                    if (!matchesEntry.matchesEntry(entry, schema)) {
                        return false;
                    }
                }
                return true;
            case -95:
                for (Filter matchesEntry2 : this.filterComps) {
                    if (matchesEntry2.matchesEntry(entry, schema)) {
                        return true;
                    }
                }
                return false;
            case -94:
                return !this.notComp.matchesEntry(entry, schema);
            case -93:
                Attribute attribute = entry.getAttribute(this.attrName, schema);
                if (attribute == null) {
                    return false;
                }
                MatchingRule selectEqualityMatchingRule = MatchingRule.selectEqualityMatchingRule(this.attrName, schema);
                for (ASN1OctetString valuesMatch : attribute.getRawValues()) {
                    if (selectEqualityMatchingRule.valuesMatch(valuesMatch, this.assertionValue)) {
                        return true;
                    }
                }
                return false;
            case -92:
                Attribute attribute2 = entry.getAttribute(this.attrName, schema);
                if (attribute2 == null) {
                    return false;
                }
                MatchingRule selectSubstringMatchingRule = MatchingRule.selectSubstringMatchingRule(this.attrName, schema);
                for (ASN1OctetString matchesSubstring : attribute2.getRawValues()) {
                    if (selectSubstringMatchingRule.matchesSubstring(matchesSubstring, this.subInitial, this.subAny, this.subFinal)) {
                        return true;
                    }
                }
                return false;
            case -91:
                Attribute attribute3 = entry.getAttribute(this.attrName, schema);
                if (attribute3 == null) {
                    return false;
                }
                MatchingRule selectOrderingMatchingRule = MatchingRule.selectOrderingMatchingRule(this.attrName, schema);
                for (ASN1OctetString compareValues : attribute3.getRawValues()) {
                    if (selectOrderingMatchingRule.compareValues(compareValues, this.assertionValue) >= 0) {
                        return true;
                    }
                }
                return false;
            case -90:
                Attribute attribute4 = entry.getAttribute(this.attrName, schema);
                if (attribute4 == null) {
                    return false;
                }
                MatchingRule selectOrderingMatchingRule2 = MatchingRule.selectOrderingMatchingRule(this.attrName, schema);
                for (ASN1OctetString compareValues2 : attribute4.getRawValues()) {
                    if (selectOrderingMatchingRule2.compareValues(compareValues2, this.assertionValue) <= 0) {
                        return true;
                    }
                }
                return false;
            default:
                switch (b) {
                    case -88:
                        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_FILTER_APPROXIMATE_MATCHING_NOT_SUPPORTED.get());
                    case -87:
                        throw new LDAPException(ResultCode.NOT_SUPPORTED, LDAPMessages.ERR_FILTER_EXTENSIBLE_MATCHING_NOT_SUPPORTED.get());
                    default:
                        throw new LDAPException(ResultCode.PARAM_ERROR, LDAPMessages.ERR_FILTER_INVALID_TYPE.get());
                }
        }
    }

    public String toNormalizedString() {
        if (this.normalizedString == null) {
            StringBuilder sb = new StringBuilder();
            toNormalizedString(sb);
            this.normalizedString = sb.toString();
        }
        return this.normalizedString;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0071, code lost:
        r9.append(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x00c6, code lost:
        r0 = r0.normalize(r8.assertionValue);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x00cc, code lost:
        encodeValue(r0, r9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00da, code lost:
        r9.append(')');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:44:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void toNormalizedString(java.lang.StringBuilder r9) {
        /*
            r8 = this;
            com.unboundid.ldap.matchingrules.CaseIgnoreStringMatchingRule r0 = com.unboundid.ldap.matchingrules.CaseIgnoreStringMatchingRule.getInstance()
            byte r1 = r8.filterType
            r2 = -121(0xffffffffffffff87, float:NaN)
            r3 = 40
            if (r1 == r2) goto L_0x0102
            r2 = 61
            r4 = 0
            r5 = 41
            switch(r1) {
                case -96: goto L_0x00f0;
                case -95: goto L_0x00de;
                case -94: goto L_0x00d0;
                case -93: goto L_0x00b7;
                case -92: goto L_0x0075;
                case -91: goto L_0x0063;
                case -90: goto L_0x0054;
                default: goto L_0x0014;
            }
        L_0x0014:
            switch(r1) {
                case -88: goto L_0x0045;
                case -87: goto L_0x0019;
                default: goto L_0x0017;
            }
        L_0x0017:
            goto L_0x0113
        L_0x0019:
            r9.append(r3)
            java.lang.String r1 = r8.attrName
            if (r1 == 0) goto L_0x0027
            java.lang.String r1 = com.unboundid.util.StaticUtils.toLowerCase(r1)
            r9.append(r1)
        L_0x0027:
            boolean r1 = r8.dnAttributes
            if (r1 == 0) goto L_0x0030
            java.lang.String r1 = ":dn"
            r9.append(r1)
        L_0x0030:
            java.lang.String r1 = r8.matchingRuleID
            if (r1 == 0) goto L_0x0042
            r1 = 58
            r9.append(r1)
            java.lang.String r1 = r8.matchingRuleID
            java.lang.String r1 = com.unboundid.util.StaticUtils.toLowerCase(r1)
            r9.append(r1)
        L_0x0042:
            java.lang.String r1 = ":="
            goto L_0x0071
        L_0x0045:
            r9.append(r3)
            java.lang.String r1 = r8.attrName
            java.lang.String r1 = com.unboundid.util.StaticUtils.toLowerCase(r1)
            r9.append(r1)
            java.lang.String r1 = "~="
            goto L_0x0071
        L_0x0054:
            r9.append(r3)
            java.lang.String r1 = r8.attrName
            java.lang.String r1 = com.unboundid.util.StaticUtils.toLowerCase(r1)
            r9.append(r1)
            java.lang.String r1 = "<="
            goto L_0x0071
        L_0x0063:
            r9.append(r3)
            java.lang.String r1 = r8.attrName
            java.lang.String r1 = com.unboundid.util.StaticUtils.toLowerCase(r1)
            r9.append(r1)
            java.lang.String r1 = ">="
        L_0x0071:
            r9.append(r1)
            goto L_0x00c6
        L_0x0075:
            r9.append(r3)
            java.lang.String r1 = r8.attrName
            java.lang.String r1 = com.unboundid.util.StaticUtils.toLowerCase(r1)
            r9.append(r1)
            r9.append(r2)
            com.unboundid.asn1.ASN1OctetString r1 = r8.subInitial
            if (r1 == 0) goto L_0x0091
            r2 = -128(0xffffffffffffff80, float:NaN)
            com.unboundid.asn1.ASN1OctetString r1 = r0.normalizeSubstring(r1, r2)
            encodeValue(r1, r9)
        L_0x0091:
            r1 = 42
            r9.append(r1)
            com.unboundid.asn1.ASN1OctetString[] r2 = r8.subAny
            int r3 = r2.length
        L_0x0099:
            if (r4 >= r3) goto L_0x00ac
            r6 = r2[r4]
            r7 = -127(0xffffffffffffff81, float:NaN)
            com.unboundid.asn1.ASN1OctetString r6 = r0.normalizeSubstring(r6, r7)
            encodeValue(r6, r9)
            r9.append(r1)
            int r4 = r4 + 1
            goto L_0x0099
        L_0x00ac:
            com.unboundid.asn1.ASN1OctetString r1 = r8.subFinal
            if (r1 == 0) goto L_0x00da
            r2 = -126(0xffffffffffffff82, float:NaN)
            com.unboundid.asn1.ASN1OctetString r0 = r0.normalizeSubstring(r1, r2)
            goto L_0x00cc
        L_0x00b7:
            r9.append(r3)
            java.lang.String r1 = r8.attrName
            java.lang.String r1 = com.unboundid.util.StaticUtils.toLowerCase(r1)
            r9.append(r1)
            r9.append(r2)
        L_0x00c6:
            com.unboundid.asn1.ASN1OctetString r1 = r8.assertionValue
            com.unboundid.asn1.ASN1OctetString r0 = r0.normalize(r1)
        L_0x00cc:
            encodeValue(r0, r9)
            goto L_0x00da
        L_0x00d0:
            java.lang.String r0 = "(!"
            r9.append(r0)
            com.unboundid.ldap.sdk.Filter r0 = r8.notComp
            r0.toNormalizedString(r9)
        L_0x00da:
            r9.append(r5)
            goto L_0x0113
        L_0x00de:
            java.lang.String r0 = "(|"
            r9.append(r0)
            com.unboundid.ldap.sdk.Filter[] r0 = r8.filterComps
            int r1 = r0.length
        L_0x00e6:
            if (r4 >= r1) goto L_0x00da
            r2 = r0[r4]
            r2.toNormalizedString(r9)
            int r4 = r4 + 1
            goto L_0x00e6
        L_0x00f0:
            java.lang.String r0 = "(&"
            r9.append(r0)
            com.unboundid.ldap.sdk.Filter[] r0 = r8.filterComps
            int r1 = r0.length
        L_0x00f8:
            if (r4 >= r1) goto L_0x00da
            r2 = r0[r4]
            r2.toNormalizedString(r9)
            int r4 = r4 + 1
            goto L_0x00f8
        L_0x0102:
            r9.append(r3)
            java.lang.String r0 = r8.attrName
            java.lang.String r0 = com.unboundid.util.StaticUtils.toLowerCase(r0)
            r9.append(r0)
            java.lang.String r0 = "=*)"
            r9.append(r0)
        L_0x0113:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.Filter.toNormalizedString(java.lang.StringBuilder):void");
    }

    public String toString() {
        if (this.filterString == null) {
            StringBuilder sb = new StringBuilder();
            toString(sb);
            this.filterString = sb.toString();
        }
        return this.filterString;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        r7.append(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0086, code lost:
        if (r0 != null) goto L_0x0096;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0094, code lost:
        r0 = r6.assertionValue;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0096, code lost:
        encodeValue(r0, r7);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x00a4, code lost:
        r7.append(')');
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:?, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void toString(java.lang.StringBuilder r7) {
        /*
            r6 = this;
            byte r0 = r6.filterType
            r1 = -121(0xffffffffffffff87, float:NaN)
            r2 = 40
            if (r0 == r1) goto L_0x00cc
            r1 = 61
            r3 = 0
            r4 = 41
            switch(r0) {
                case -96: goto L_0x00ba;
                case -95: goto L_0x00a8;
                case -94: goto L_0x009a;
                case -93: goto L_0x0089;
                case -92: goto L_0x005d;
                case -91: goto L_0x004f;
                case -90: goto L_0x0044;
                default: goto L_0x0010;
            }
        L_0x0010:
            switch(r0) {
                case -88: goto L_0x0039;
                case -87: goto L_0x0015;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x00d9
        L_0x0015:
            r7.append(r2)
            java.lang.String r0 = r6.attrName
            if (r0 == 0) goto L_0x001f
            r7.append(r0)
        L_0x001f:
            boolean r0 = r6.dnAttributes
            if (r0 == 0) goto L_0x0028
            java.lang.String r0 = ":dn"
            r7.append(r0)
        L_0x0028:
            java.lang.String r0 = r6.matchingRuleID
            if (r0 == 0) goto L_0x0036
            r0 = 58
            r7.append(r0)
            java.lang.String r0 = r6.matchingRuleID
            r7.append(r0)
        L_0x0036:
            java.lang.String r0 = ":="
            goto L_0x0059
        L_0x0039:
            r7.append(r2)
            java.lang.String r0 = r6.attrName
            r7.append(r0)
            java.lang.String r0 = "~="
            goto L_0x0059
        L_0x0044:
            r7.append(r2)
            java.lang.String r0 = r6.attrName
            r7.append(r0)
            java.lang.String r0 = "<="
            goto L_0x0059
        L_0x004f:
            r7.append(r2)
            java.lang.String r0 = r6.attrName
            r7.append(r0)
            java.lang.String r0 = ">="
        L_0x0059:
            r7.append(r0)
            goto L_0x0094
        L_0x005d:
            r7.append(r2)
            java.lang.String r0 = r6.attrName
            r7.append(r0)
            r7.append(r1)
            com.unboundid.asn1.ASN1OctetString r0 = r6.subInitial
            if (r0 == 0) goto L_0x006f
            encodeValue(r0, r7)
        L_0x006f:
            r0 = 42
            r7.append(r0)
            com.unboundid.asn1.ASN1OctetString[] r1 = r6.subAny
            int r2 = r1.length
        L_0x0077:
            if (r3 >= r2) goto L_0x0084
            r5 = r1[r3]
            encodeValue(r5, r7)
            r7.append(r0)
            int r3 = r3 + 1
            goto L_0x0077
        L_0x0084:
            com.unboundid.asn1.ASN1OctetString r0 = r6.subFinal
            if (r0 == 0) goto L_0x00a4
            goto L_0x0096
        L_0x0089:
            r7.append(r2)
            java.lang.String r0 = r6.attrName
            r7.append(r0)
            r7.append(r1)
        L_0x0094:
            com.unboundid.asn1.ASN1OctetString r0 = r6.assertionValue
        L_0x0096:
            encodeValue(r0, r7)
            goto L_0x00a4
        L_0x009a:
            java.lang.String r0 = "(!"
            r7.append(r0)
            com.unboundid.ldap.sdk.Filter r0 = r6.notComp
            r0.toString(r7)
        L_0x00a4:
            r7.append(r4)
            goto L_0x00d9
        L_0x00a8:
            java.lang.String r0 = "(|"
            r7.append(r0)
            com.unboundid.ldap.sdk.Filter[] r0 = r6.filterComps
            int r1 = r0.length
        L_0x00b0:
            if (r3 >= r1) goto L_0x00a4
            r2 = r0[r3]
            r2.toString(r7)
            int r3 = r3 + 1
            goto L_0x00b0
        L_0x00ba:
            java.lang.String r0 = "(&"
            r7.append(r0)
            com.unboundid.ldap.sdk.Filter[] r0 = r6.filterComps
            int r1 = r0.length
        L_0x00c2:
            if (r3 >= r1) goto L_0x00a4
            r2 = r0[r3]
            r2.toString(r7)
            int r3 = r3 + 1
            goto L_0x00c2
        L_0x00cc:
            r7.append(r2)
            java.lang.String r0 = r6.attrName
            r7.append(r0)
            java.lang.String r0 = "=*)"
            r7.append(r0)
        L_0x00d9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.Filter.toString(java.lang.StringBuilder):void");
    }

    public void writeTo(ASN1Buffer aSN1Buffer) {
        ASN1BufferSequence aSN1BufferSequence;
        byte b = this.filterType;
        if (b != -121) {
            int i = 0;
            switch (b) {
                case -96:
                case -95:
                    ASN1BufferSet beginSet = aSN1Buffer.beginSet(b);
                    Filter[] filterArr = this.filterComps;
                    int length = filterArr.length;
                    while (i < length) {
                        filterArr[i].writeTo(aSN1Buffer);
                        i++;
                    }
                    beginSet.end();
                    return;
                case -94:
                    aSN1Buffer.addElement(new ASN1Element(b, this.notComp.encode().encode()));
                    return;
                case -93:
                case -91:
                case -90:
                    aSN1BufferSequence = aSN1Buffer.beginSequence(this.filterType);
                    aSN1Buffer.addOctetString(this.attrName);
                    aSN1Buffer.addElement(this.assertionValue);
                    break;
                case -92:
                    aSN1BufferSequence = aSN1Buffer.beginSequence(b);
                    aSN1Buffer.addOctetString(this.attrName);
                    ASN1BufferSequence beginSequence = aSN1Buffer.beginSequence();
                    ASN1OctetString aSN1OctetString = this.subInitial;
                    if (aSN1OctetString != null) {
                        aSN1Buffer.addOctetString(Byte.MIN_VALUE, aSN1OctetString.getValue());
                    }
                    ASN1OctetString[] aSN1OctetStringArr = this.subAny;
                    int length2 = aSN1OctetStringArr.length;
                    while (i < length2) {
                        aSN1Buffer.addOctetString((byte) -127, aSN1OctetStringArr[i].getValue());
                        i++;
                    }
                    ASN1OctetString aSN1OctetString2 = this.subFinal;
                    if (aSN1OctetString2 != null) {
                        aSN1Buffer.addOctetString((byte) MatchingRule.SUBSTRING_TYPE_SUBFINAL, aSN1OctetString2.getValue());
                    }
                    beginSequence.end();
                    break;
                default:
                    switch (b) {
                        case -88:
                            break;
                        case -87:
                            aSN1BufferSequence = aSN1Buffer.beginSequence(b);
                            String str = this.matchingRuleID;
                            if (str != null) {
                                aSN1Buffer.addOctetString((byte) -127, str);
                            }
                            String str2 = this.attrName;
                            if (str2 != null) {
                                aSN1Buffer.addOctetString((byte) MatchingRule.SUBSTRING_TYPE_SUBFINAL, str2);
                            }
                            aSN1Buffer.addOctetString((byte) EXTENSIBLE_TYPE_MATCH_VALUE, this.assertionValue.getValue());
                            if (this.dnAttributes) {
                                aSN1Buffer.addBoolean(EXTENSIBLE_TYPE_DN_ATTRIBUTES, true);
                                break;
                            }
                            break;
                        default:
                            return;
                    }
                    aSN1BufferSequence = aSN1Buffer.beginSequence(this.filterType);
                    aSN1Buffer.addOctetString(this.attrName);
                    aSN1Buffer.addElement(this.assertionValue);
                    break;
            }
            aSN1BufferSequence.end();
            return;
        }
        aSN1Buffer.addOctetString(b, this.attrName);
    }
}
