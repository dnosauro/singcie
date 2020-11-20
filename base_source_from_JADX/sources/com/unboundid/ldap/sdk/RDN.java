package com.unboundid.ldap.sdk;

import com.unboundid.asn1.ASN1OctetString;
import com.unboundid.ldap.matchingrules.MatchingRule;
import com.unboundid.ldap.sdk.schema.AttributeTypeDefinition;
import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.Debug;
import com.unboundid.util.StaticUtils;
import com.unboundid.util.Validator;
import java.io.Serializable;
import java.util.Comparator;
import java.util.Map;
import java.util.TreeMap;
import org.apache.commons.p172io.IOUtils;

public final class RDN implements Serializable, Comparable<RDN>, Comparator<RDN> {
    private static final long serialVersionUID = 2923419812807188487L;
    private final String[] attributeNames;
    private final ASN1OctetString[] attributeValues;
    private volatile String normalizedString;
    private volatile String rdnString;
    private final Schema schema;

    public RDN(String str) {
        this(str, (Schema) null);
    }

    RDN(String str, ASN1OctetString aSN1OctetString, Schema schema2, String str2) {
        this.rdnString = str2;
        this.schema = schema2;
        this.attributeNames = new String[]{str};
        this.attributeValues = new ASN1OctetString[]{aSN1OctetString};
    }

    /* JADX WARNING: Removed duplicated region for block: B:127:0x0166 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:70:0x0100  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public RDN(java.lang.String r14, com.unboundid.ldap.sdk.schema.Schema r15) {
        /*
            r13 = this;
            r13.<init>()
            com.unboundid.util.Validator.ensureNotNull(r14)
            r13.rdnString = r14
            r13.schema = r15
            int r15 = r14.length()
            r0 = 0
            r1 = 0
        L_0x0010:
            r2 = 32
            if (r1 >= r15) goto L_0x001d
            char r3 = r14.charAt(r1)
            if (r3 != r2) goto L_0x001d
            int r1 = r1 + 1
            goto L_0x0010
        L_0x001d:
            r3 = r1
        L_0x001e:
            r4 = 61
            if (r3 >= r15) goto L_0x002e
            char r5 = r14.charAt(r3)
            if (r5 == r2) goto L_0x002e
            if (r5 != r4) goto L_0x002b
            goto L_0x002e
        L_0x002b:
            int r3 = r3 + 1
            goto L_0x001e
        L_0x002e:
            java.lang.String r1 = r14.substring(r1, r3)
            int r5 = r1.length()
            if (r5 == 0) goto L_0x01fa
        L_0x0038:
            if (r3 >= r15) goto L_0x0043
            char r5 = r14.charAt(r3)
            if (r5 != r2) goto L_0x0043
            int r3 = r3 + 1
            goto L_0x0038
        L_0x0043:
            r5 = 1
            if (r3 >= r15) goto L_0x01e8
            char r6 = r14.charAt(r3)
            if (r6 != r4) goto L_0x01e8
            int r3 = r3 + r5
        L_0x004d:
            if (r3 >= r15) goto L_0x0058
            char r6 = r14.charAt(r3)
            if (r6 != r2) goto L_0x0058
            int r3 = r3 + 1
            goto L_0x004d
        L_0x0058:
            if (r3 >= r15) goto L_0x01d6
            char r6 = r14.charAt(r3)
            r7 = 35
            if (r6 != r7) goto L_0x0071
            int r3 = r3 + r5
            byte[] r6 = readHexString(r14, r3)
            com.unboundid.asn1.ASN1OctetString r8 = new com.unboundid.asn1.ASN1OctetString
            r8.<init>((byte[]) r6)
            int r6 = r6.length
            int r6 = r6 * 2
            int r3 = r3 + r6
            goto L_0x0083
        L_0x0071:
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            int r3 = readValueString(r14, r3, r6)
            com.unboundid.asn1.ASN1OctetString r8 = new com.unboundid.asn1.ASN1OctetString
            java.lang.String r6 = r6.toString()
            r8.<init>((java.lang.String) r6)
        L_0x0083:
            if (r3 >= r15) goto L_0x008e
            char r6 = r14.charAt(r3)
            if (r6 != r2) goto L_0x008e
            int r3 = r3 + 1
            goto L_0x0083
        L_0x008e:
            if (r3 < r15) goto L_0x009d
            java.lang.String[] r14 = new java.lang.String[r5]
            r14[r0] = r1
            r13.attributeNames = r14
            com.unboundid.asn1.ASN1OctetString[] r14 = new com.unboundid.asn1.ASN1OctetString[r5]
            r14[r0] = r8
            r13.attributeValues = r14
            return
        L_0x009d:
            java.util.ArrayList r6 = new java.util.ArrayList
            r9 = 5
            r6.<init>(r9)
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>(r9)
            r6.add(r1)
            r10.add(r8)
            char r1 = r14.charAt(r3)
            r8 = 43
            if (r1 != r8) goto L_0x01c8
            int r3 = r3 + r5
            if (r3 >= r15) goto L_0x01ba
            r1 = 1
        L_0x00ba:
            if (r3 >= r15) goto L_0x0198
        L_0x00bc:
            if (r3 >= r15) goto L_0x00c7
            char r9 = r14.charAt(r3)
            if (r9 != r2) goto L_0x00c7
            int r3 = r3 + 1
            goto L_0x00bc
        L_0x00c7:
            r9 = r3
        L_0x00c8:
            if (r9 >= r15) goto L_0x00d6
            char r11 = r14.charAt(r9)
            if (r11 == r2) goto L_0x00d6
            if (r11 != r4) goto L_0x00d3
            goto L_0x00d6
        L_0x00d3:
            int r9 = r9 + 1
            goto L_0x00c8
        L_0x00d6:
            java.lang.String r3 = r14.substring(r3, r9)
            int r11 = r3.length()
            if (r11 == 0) goto L_0x018a
        L_0x00e0:
            if (r9 >= r15) goto L_0x00eb
            char r11 = r14.charAt(r9)
            if (r11 != r2) goto L_0x00eb
            int r9 = r9 + 1
            goto L_0x00e0
        L_0x00eb:
            if (r9 >= r15) goto L_0x0178
            char r11 = r14.charAt(r9)
            if (r11 != r4) goto L_0x0178
        L_0x00f3:
            int r9 = r9 + 1
            if (r9 >= r15) goto L_0x00fe
            char r11 = r14.charAt(r9)
            if (r11 != r2) goto L_0x00fe
            goto L_0x00f3
        L_0x00fe:
            if (r9 >= r15) goto L_0x0166
            char r11 = r14.charAt(r9)
            if (r11 != r7) goto L_0x0116
            int r9 = r9 + 1
            byte[] r11 = readHexString(r14, r9)
            com.unboundid.asn1.ASN1OctetString r12 = new com.unboundid.asn1.ASN1OctetString
            r12.<init>((byte[]) r11)
            int r11 = r11.length
            int r11 = r11 * 2
            int r9 = r9 + r11
            goto L_0x0128
        L_0x0116:
            java.lang.StringBuilder r11 = new java.lang.StringBuilder
            r11.<init>()
            int r9 = readValueString(r14, r9, r11)
            com.unboundid.asn1.ASN1OctetString r12 = new com.unboundid.asn1.ASN1OctetString
            java.lang.String r11 = r11.toString()
            r12.<init>((java.lang.String) r11)
        L_0x0128:
            if (r9 >= r15) goto L_0x0133
            char r11 = r14.charAt(r9)
            if (r11 != r2) goto L_0x0133
            int r9 = r9 + 1
            goto L_0x0128
        L_0x0133:
            r6.add(r3)
            r10.add(r12)
            int r1 = r1 + 1
            if (r9 < r15) goto L_0x013e
            goto L_0x0198
        L_0x013e:
            char r3 = r14.charAt(r9)
            if (r3 != r8) goto L_0x0158
            int r3 = r9 + 1
            if (r3 >= r15) goto L_0x014a
            goto L_0x00ba
        L_0x014a:
            com.unboundid.ldap.sdk.LDAPException r14 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r15 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_PLUS_NOT_FOLLOWED_BY_AVP
            java.lang.String r0 = r0.get()
            r14.<init>((com.unboundid.ldap.sdk.ResultCode) r15, (java.lang.String) r0)
            throw r14
        L_0x0158:
            com.unboundid.ldap.sdk.LDAPException r14 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r15 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_VALUE_NOT_FOLLOWED_BY_PLUS
            java.lang.String r0 = r0.get()
            r14.<init>((com.unboundid.ldap.sdk.ResultCode) r15, (java.lang.String) r0)
            throw r14
        L_0x0166:
            com.unboundid.ldap.sdk.LDAPException r14 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r15 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_NO_ATTR_VALUE
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r2[r0] = r3
            java.lang.String r0 = r1.get(r2)
            r14.<init>((com.unboundid.ldap.sdk.ResultCode) r15, (java.lang.String) r0)
            throw r14
        L_0x0178:
            com.unboundid.ldap.sdk.LDAPException r14 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r15 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_NO_EQUAL_SIGN
            java.lang.Object[] r2 = new java.lang.Object[r5]
            r2[r0] = r3
            java.lang.String r0 = r1.get(r2)
            r14.<init>((com.unboundid.ldap.sdk.ResultCode) r15, (java.lang.String) r0)
            throw r14
        L_0x018a:
            com.unboundid.ldap.sdk.LDAPException r14 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r15 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_NO_ATTR_NAME
            java.lang.String r0 = r0.get()
            r14.<init>((com.unboundid.ldap.sdk.ResultCode) r15, (java.lang.String) r0)
            throw r14
        L_0x0198:
            java.lang.String[] r14 = new java.lang.String[r1]
            r13.attributeNames = r14
            com.unboundid.asn1.ASN1OctetString[] r14 = new com.unboundid.asn1.ASN1OctetString[r1]
            r13.attributeValues = r14
        L_0x01a0:
            if (r0 >= r1) goto L_0x01b9
            java.lang.String[] r14 = r13.attributeNames
            java.lang.Object r15 = r6.get(r0)
            java.lang.String r15 = (java.lang.String) r15
            r14[r0] = r15
            com.unboundid.asn1.ASN1OctetString[] r14 = r13.attributeValues
            java.lang.Object r15 = r10.get(r0)
            com.unboundid.asn1.ASN1OctetString r15 = (com.unboundid.asn1.ASN1OctetString) r15
            r14[r0] = r15
            int r0 = r0 + 1
            goto L_0x01a0
        L_0x01b9:
            return
        L_0x01ba:
            com.unboundid.ldap.sdk.LDAPException r14 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r15 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_PLUS_NOT_FOLLOWED_BY_AVP
            java.lang.String r0 = r0.get()
            r14.<init>((com.unboundid.ldap.sdk.ResultCode) r15, (java.lang.String) r0)
            throw r14
        L_0x01c8:
            com.unboundid.ldap.sdk.LDAPException r14 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r15 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_VALUE_NOT_FOLLOWED_BY_PLUS
            java.lang.String r0 = r0.get()
            r14.<init>((com.unboundid.ldap.sdk.ResultCode) r15, (java.lang.String) r0)
            throw r14
        L_0x01d6:
            com.unboundid.ldap.sdk.LDAPException r14 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r15 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_NO_ATTR_VALUE
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r3[r0] = r1
            java.lang.String r0 = r2.get(r3)
            r14.<init>((com.unboundid.ldap.sdk.ResultCode) r15, (java.lang.String) r0)
            throw r14
        L_0x01e8:
            com.unboundid.ldap.sdk.LDAPException r14 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r15 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_NO_EQUAL_SIGN
            java.lang.Object[] r3 = new java.lang.Object[r5]
            r3[r0] = r1
            java.lang.String r0 = r2.get(r3)
            r14.<init>((com.unboundid.ldap.sdk.ResultCode) r15, (java.lang.String) r0)
            throw r14
        L_0x01fa:
            com.unboundid.ldap.sdk.LDAPException r14 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r15 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_NO_ATTR_NAME
            java.lang.String r0 = r0.get()
            r14.<init>((com.unboundid.ldap.sdk.ResultCode) r15, (java.lang.String) r0)
            throw r14
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.RDN.<init>(java.lang.String, com.unboundid.ldap.sdk.schema.Schema):void");
    }

    public RDN(String str, String str2) {
        this(str, str2, (Schema) null);
    }

    public RDN(String str, String str2, Schema schema2) {
        Validator.ensureNotNull(str, str2);
        this.schema = schema2;
        this.attributeNames = new String[]{str};
        this.attributeValues = new ASN1OctetString[]{new ASN1OctetString(str2)};
    }

    public RDN(String str, byte[] bArr) {
        this(str, bArr, (Schema) null);
    }

    public RDN(String str, byte[] bArr, Schema schema2) {
        Validator.ensureNotNull(str, bArr);
        this.schema = schema2;
        this.attributeNames = new String[]{str};
        this.attributeValues = new ASN1OctetString[]{new ASN1OctetString(bArr)};
    }

    RDN(String[] strArr, ASN1OctetString[] aSN1OctetStringArr, Schema schema2, String str) {
        this.rdnString = str;
        this.schema = schema2;
        this.attributeNames = strArr;
        this.attributeValues = aSN1OctetStringArr;
    }

    public RDN(String[] strArr, String[] strArr2) {
        this(strArr, strArr2, (Schema) null);
    }

    public RDN(String[] strArr, String[] strArr2, Schema schema2) {
        Validator.ensureNotNull(strArr, strArr2);
        boolean z = true;
        Validator.ensureTrue(strArr.length == strArr2.length, "RDN.attributeNames and attributeValues must be the same size.");
        Validator.ensureTrue(strArr.length <= 0 ? false : z, "RDN.attributeNames must not be empty.");
        this.attributeNames = strArr;
        this.schema = schema2;
        this.attributeValues = new ASN1OctetString[strArr2.length];
        for (int i = 0; i < strArr2.length; i++) {
            this.attributeValues[i] = new ASN1OctetString(strArr2[i]);
        }
    }

    public RDN(String[] strArr, byte[][] bArr) {
        this(strArr, bArr, (Schema) null);
    }

    public RDN(String[] strArr, byte[][] bArr, Schema schema2) {
        Validator.ensureNotNull(strArr, bArr);
        boolean z = true;
        Validator.ensureTrue(strArr.length == bArr.length, "RDN.attributeNames and attributeValues must be the same size.");
        Validator.ensureTrue(strArr.length <= 0 ? false : z, "RDN.attributeNames must not be empty.");
        this.attributeNames = strArr;
        this.schema = schema2;
        this.attributeValues = new ASN1OctetString[bArr.length];
        for (int i = 0; i < bArr.length; i++) {
            this.attributeValues[i] = new ASN1OctetString(bArr[i]);
        }
    }

    public static int compare(String str, String str2) {
        return compare(str, str2, (Schema) null);
    }

    public static int compare(String str, String str2, Schema schema2) {
        return new RDN(str, schema2).compareTo(new RDN(str2, schema2));
    }

    public static boolean equals(String str, String str2) {
        return new RDN(str).equals((Object) new RDN(str2));
    }

    public static boolean isValidRDN(String str) {
        try {
            new RDN(str);
            return true;
        } catch (LDAPException unused) {
            return false;
        }
    }

    public static String normalize(String str) {
        return normalize(str, (Schema) null);
    }

    public static String normalize(String str, Schema schema2) {
        return new RDN(str, schema2).toNormalizedString();
    }

    private String normalizeAttrName(String str) {
        AttributeTypeDefinition attributeType;
        Schema schema2 = this.schema;
        if (!(schema2 == null || (attributeType = schema2.getAttributeType(str)) == null)) {
            str = attributeType.getNameOrOID();
        }
        return StaticUtils.toLowerCase(str);
    }

    private StringBuilder normalizeValue(String str, ASN1OctetString aSN1OctetString) {
        ASN1OctetString aSN1OctetString2;
        int i;
        try {
            aSN1OctetString2 = MatchingRule.selectEqualityMatchingRule(str, this.schema).normalize(aSN1OctetString);
        } catch (Exception e) {
            Debug.debugException(e);
            aSN1OctetString2 = new ASN1OctetString(StaticUtils.toLowerCase(aSN1OctetString.stringValue()));
        }
        String stringValue = aSN1OctetString2.stringValue();
        int length = stringValue.length();
        StringBuilder sb = new StringBuilder(length);
        for (int i2 = 0; i2 < length; i2++) {
            char charAt = stringValue.charAt(i2);
            switch (charAt) {
                case ' ':
                    if (i2 == 0 || (i = i2 + 1) == length || (i < length && stringValue.charAt(i) == ' ')) {
                        sb.append("\\ ");
                        break;
                    } else {
                        sb.append(' ');
                        continue;
                    }
                case '\"':
                case '#':
                case '+':
                case ',':
                case ';':
                case '<':
                case '=':
                case '>':
                case '\\':
                    sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                    break;
                default:
                    if (charAt < ' ' || charAt > '~') {
                        StaticUtils.hexEncode(charAt, sb);
                        continue;
                    }
            }
            sb.append(charAt);
        }
        return sb;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0045, code lost:
        r8 = -48;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0048, code lost:
        r8 = -64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x004b, code lost:
        r8 = -80;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004e, code lost:
        r8 = -96;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:31:0x009f, code lost:
        r8 = r8 | 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00a2, code lost:
        r8 = r8 | 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x00a5, code lost:
        r8 = r8 | 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:34:0x00a8, code lost:
        r8 = r8 | 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00ab, code lost:
        r8 = r8 | 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00ae, code lost:
        r8 = r8 | 10;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00cb, code lost:
        r8 = (byte) r8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x003f, code lost:
        r8 = -16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0042, code lost:
        r8 = -32;
     */
    /* JADX WARNING: Removed duplicated region for block: B:2:0x000c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x00f7 A[SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int readEscapedHexString(java.lang.String r7, int r8, java.lang.StringBuilder r9) {
        /*
            int r0 = r7.length()
            int r1 = r0 - r8
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
        L_0x000a:
            if (r8 >= r0) goto L_0x00f7
            int r2 = r8 + 1
            char r8 = r7.charAt(r8)
            r3 = 0
            r4 = 2
            r5 = 1
            switch(r8) {
                case 48: goto L_0x006c;
                case 49: goto L_0x0069;
                case 50: goto L_0x0066;
                case 51: goto L_0x0063;
                case 52: goto L_0x0060;
                case 53: goto L_0x005d;
                case 54: goto L_0x005a;
                case 55: goto L_0x0057;
                case 56: goto L_0x0054;
                case 57: goto L_0x0051;
                default: goto L_0x0018;
            }
        L_0x0018:
            switch(r8) {
                case 65: goto L_0x004e;
                case 66: goto L_0x004b;
                case 67: goto L_0x0048;
                case 68: goto L_0x0045;
                case 69: goto L_0x0042;
                case 70: goto L_0x003f;
                default: goto L_0x001b;
            }
        L_0x001b:
            switch(r8) {
                case 97: goto L_0x004e;
                case 98: goto L_0x004b;
                case 99: goto L_0x0048;
                case 100: goto L_0x0045;
                case 101: goto L_0x0042;
                case 102: goto L_0x003f;
                default: goto L_0x001e;
            }
        L_0x001e:
            com.unboundid.ldap.sdk.LDAPException r8 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r9 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_INVALID_HEX_CHAR
            java.lang.Object[] r1 = new java.lang.Object[r4]
            int r2 = r2 - r5
            char r7 = r7.charAt(r2)
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            r1[r3] = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            r1[r5] = r7
            java.lang.String r7 = r0.get(r1)
            r8.<init>((com.unboundid.ldap.sdk.ResultCode) r9, (java.lang.String) r7)
            throw r8
        L_0x003f:
            r8 = -16
            goto L_0x006d
        L_0x0042:
            r8 = -32
            goto L_0x006d
        L_0x0045:
            r8 = -48
            goto L_0x006d
        L_0x0048:
            r8 = -64
            goto L_0x006d
        L_0x004b:
            r8 = -80
            goto L_0x006d
        L_0x004e:
            r8 = -96
            goto L_0x006d
        L_0x0051:
            r8 = -112(0xffffffffffffff90, float:NaN)
            goto L_0x006d
        L_0x0054:
            r8 = -128(0xffffffffffffff80, float:NaN)
            goto L_0x006d
        L_0x0057:
            r8 = 112(0x70, float:1.57E-43)
            goto L_0x006d
        L_0x005a:
            r8 = 96
            goto L_0x006d
        L_0x005d:
            r8 = 80
            goto L_0x006d
        L_0x0060:
            r8 = 64
            goto L_0x006d
        L_0x0063:
            r8 = 48
            goto L_0x006d
        L_0x0066:
            r8 = 32
            goto L_0x006d
        L_0x0069:
            r8 = 16
            goto L_0x006d
        L_0x006c:
            r8 = 0
        L_0x006d:
            if (r2 >= r0) goto L_0x00e9
            int r6 = r2 + 1
            char r2 = r7.charAt(r2)
            switch(r2) {
                case 48: goto L_0x00cc;
                case 49: goto L_0x00c9;
                case 50: goto L_0x00c6;
                case 51: goto L_0x00c3;
                case 52: goto L_0x00c0;
                case 53: goto L_0x00bd;
                case 54: goto L_0x00ba;
                case 55: goto L_0x00b7;
                case 56: goto L_0x00b4;
                case 57: goto L_0x00b1;
                default: goto L_0x0078;
            }
        L_0x0078:
            switch(r2) {
                case 65: goto L_0x00ae;
                case 66: goto L_0x00ab;
                case 67: goto L_0x00a8;
                case 68: goto L_0x00a5;
                case 69: goto L_0x00a2;
                case 70: goto L_0x009f;
                default: goto L_0x007b;
            }
        L_0x007b:
            switch(r2) {
                case 97: goto L_0x00ae;
                case 98: goto L_0x00ab;
                case 99: goto L_0x00a8;
                case 100: goto L_0x00a5;
                case 101: goto L_0x00a2;
                case 102: goto L_0x009f;
                default: goto L_0x007e;
            }
        L_0x007e:
            com.unboundid.ldap.sdk.LDAPException r8 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r9 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_INVALID_HEX_CHAR
            java.lang.Object[] r1 = new java.lang.Object[r4]
            int r6 = r6 - r5
            char r7 = r7.charAt(r6)
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            r1[r3] = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r6)
            r1[r5] = r7
            java.lang.String r7 = r0.get(r1)
            r8.<init>((com.unboundid.ldap.sdk.ResultCode) r9, (java.lang.String) r7)
            throw r8
        L_0x009f:
            r8 = r8 | 15
            goto L_0x00cb
        L_0x00a2:
            r8 = r8 | 14
            goto L_0x00cb
        L_0x00a5:
            r8 = r8 | 13
            goto L_0x00cb
        L_0x00a8:
            r8 = r8 | 12
            goto L_0x00cb
        L_0x00ab:
            r8 = r8 | 11
            goto L_0x00cb
        L_0x00ae:
            r8 = r8 | 10
            goto L_0x00cb
        L_0x00b1:
            r8 = r8 | 9
            goto L_0x00cb
        L_0x00b4:
            r8 = r8 | 8
            goto L_0x00cb
        L_0x00b7:
            r8 = r8 | 7
            goto L_0x00cb
        L_0x00ba:
            r8 = r8 | 6
            goto L_0x00cb
        L_0x00bd:
            r8 = r8 | 5
            goto L_0x00cb
        L_0x00c0:
            r8 = r8 | 4
            goto L_0x00cb
        L_0x00c3:
            r8 = r8 | 3
            goto L_0x00cb
        L_0x00c6:
            r8 = r8 | 2
            goto L_0x00cb
        L_0x00c9:
            r8 = r8 | 1
        L_0x00cb:
            byte r8 = (byte) r8
        L_0x00cc:
            r1.put(r8)
            int r8 = r6 + 1
            if (r8 >= r0) goto L_0x00e7
            char r2 = r7.charAt(r6)
            r3 = 92
            if (r2 != r3) goto L_0x00e7
            char r2 = r7.charAt(r8)
            boolean r2 = com.unboundid.util.StaticUtils.isHex(r2)
            if (r2 == 0) goto L_0x00e7
            goto L_0x000a
        L_0x00e7:
            r8 = r6
            goto L_0x00f7
        L_0x00e9:
            com.unboundid.ldap.sdk.LDAPException r7 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r8 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r9 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_MISSING_HEX_CHAR
            java.lang.String r9 = r9.get()
            r7.<init>((com.unboundid.ldap.sdk.ResultCode) r8, (java.lang.String) r9)
            throw r7
        L_0x00f7:
            r1.flip()
            int r7 = r1.limit()
            byte[] r7 = new byte[r7]
            r1.get(r7)
            java.lang.String r0 = com.unboundid.util.StaticUtils.toUTF8String(r7)     // Catch:{ Exception -> 0x010b }
            r9.append(r0)     // Catch:{ Exception -> 0x010b }
            goto L_0x0117
        L_0x010b:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)
            java.lang.String r0 = new java.lang.String
            r0.<init>(r7)
            r9.append(r0)
        L_0x0117:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.RDN.readEscapedHexString(java.lang.String, int, java.lang.StringBuilder):int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x004a, code lost:
        r3 = -16;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004d, code lost:
        r3 = -32;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0050, code lost:
        r3 = -48;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0053, code lost:
        r3 = -64;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0056, code lost:
        r3 = -80;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0059, code lost:
        r3 = -96;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00a7, code lost:
        r2 = r3 | 15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00aa, code lost:
        r2 = r3 | 14;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x00ad, code lost:
        r2 = r3 | 13;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00b0, code lost:
        r2 = r3 | 12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00b3, code lost:
        r2 = r3 | 11;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00b6, code lost:
        r2 = r3 | 10;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static byte[] readHexString(java.lang.String r7, int r8) {
        /*
            int r0 = r7.length()
            int r1 = r0 - r8
            java.nio.ByteBuffer r1 = java.nio.ByteBuffer.allocate(r1)
        L_0x000a:
            if (r8 >= r0) goto L_0x00e7
            int r2 = r8 + 1
            char r8 = r7.charAt(r8)
            r3 = 32
            if (r8 == r3) goto L_0x00e7
            r4 = 59
            if (r8 == r4) goto L_0x00e7
            switch(r8) {
                case 43: goto L_0x00e7;
                case 44: goto L_0x00e7;
                default: goto L_0x001d;
            }
        L_0x001d:
            r4 = 0
            r5 = 2
            r6 = 1
            switch(r8) {
                case 48: goto L_0x0074;
                case 49: goto L_0x0071;
                case 50: goto L_0x0075;
                case 51: goto L_0x006e;
                case 52: goto L_0x006b;
                case 53: goto L_0x0068;
                case 54: goto L_0x0065;
                case 55: goto L_0x0062;
                case 56: goto L_0x005f;
                case 57: goto L_0x005c;
                default: goto L_0x0023;
            }
        L_0x0023:
            switch(r8) {
                case 65: goto L_0x0059;
                case 66: goto L_0x0056;
                case 67: goto L_0x0053;
                case 68: goto L_0x0050;
                case 69: goto L_0x004d;
                case 70: goto L_0x004a;
                default: goto L_0x0026;
            }
        L_0x0026:
            switch(r8) {
                case 97: goto L_0x0059;
                case 98: goto L_0x0056;
                case 99: goto L_0x0053;
                case 100: goto L_0x0050;
                case 101: goto L_0x004d;
                case 102: goto L_0x004a;
                default: goto L_0x0029;
            }
        L_0x0029:
            com.unboundid.ldap.sdk.LDAPException r8 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r0 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r1 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_INVALID_HEX_CHAR
            java.lang.Object[] r3 = new java.lang.Object[r5]
            int r2 = r2 - r6
            char r7 = r7.charAt(r2)
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            r3[r4] = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r2)
            r3[r6] = r7
            java.lang.String r7 = r1.get(r3)
            r8.<init>((com.unboundid.ldap.sdk.ResultCode) r0, (java.lang.String) r7)
            throw r8
        L_0x004a:
            r3 = -16
            goto L_0x0075
        L_0x004d:
            r3 = -32
            goto L_0x0075
        L_0x0050:
            r3 = -48
            goto L_0x0075
        L_0x0053:
            r3 = -64
            goto L_0x0075
        L_0x0056:
            r3 = -80
            goto L_0x0075
        L_0x0059:
            r3 = -96
            goto L_0x0075
        L_0x005c:
            r3 = -112(0xffffffffffffff90, float:NaN)
            goto L_0x0075
        L_0x005f:
            r3 = -128(0xffffffffffffff80, float:NaN)
            goto L_0x0075
        L_0x0062:
            r3 = 112(0x70, float:1.57E-43)
            goto L_0x0075
        L_0x0065:
            r3 = 96
            goto L_0x0075
        L_0x0068:
            r3 = 80
            goto L_0x0075
        L_0x006b:
            r3 = 64
            goto L_0x0075
        L_0x006e:
            r3 = 48
            goto L_0x0075
        L_0x0071:
            r3 = 16
            goto L_0x0075
        L_0x0074:
            r3 = 0
        L_0x0075:
            if (r2 >= r0) goto L_0x00d9
            int r8 = r2 + 1
            char r2 = r7.charAt(r2)
            switch(r2) {
                case 48: goto L_0x00d4;
                case 49: goto L_0x00d1;
                case 50: goto L_0x00ce;
                case 51: goto L_0x00cb;
                case 52: goto L_0x00c8;
                case 53: goto L_0x00c5;
                case 54: goto L_0x00c2;
                case 55: goto L_0x00bf;
                case 56: goto L_0x00bc;
                case 57: goto L_0x00b9;
                default: goto L_0x0080;
            }
        L_0x0080:
            switch(r2) {
                case 65: goto L_0x00b6;
                case 66: goto L_0x00b3;
                case 67: goto L_0x00b0;
                case 68: goto L_0x00ad;
                case 69: goto L_0x00aa;
                case 70: goto L_0x00a7;
                default: goto L_0x0083;
            }
        L_0x0083:
            switch(r2) {
                case 97: goto L_0x00b6;
                case 98: goto L_0x00b3;
                case 99: goto L_0x00b0;
                case 100: goto L_0x00ad;
                case 101: goto L_0x00aa;
                case 102: goto L_0x00a7;
                default: goto L_0x0086;
            }
        L_0x0086:
            com.unboundid.ldap.sdk.LDAPException r0 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r1 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r2 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_INVALID_HEX_CHAR
            java.lang.Object[] r3 = new java.lang.Object[r5]
            int r8 = r8 - r6
            char r7 = r7.charAt(r8)
            java.lang.Character r7 = java.lang.Character.valueOf(r7)
            r3[r4] = r7
            java.lang.Integer r7 = java.lang.Integer.valueOf(r8)
            r3[r6] = r7
            java.lang.String r7 = r2.get(r3)
            r0.<init>((com.unboundid.ldap.sdk.ResultCode) r1, (java.lang.String) r7)
            throw r0
        L_0x00a7:
            r2 = r3 | 15
            goto L_0x00d3
        L_0x00aa:
            r2 = r3 | 14
            goto L_0x00d3
        L_0x00ad:
            r2 = r3 | 13
            goto L_0x00d3
        L_0x00b0:
            r2 = r3 | 12
            goto L_0x00d3
        L_0x00b3:
            r2 = r3 | 11
            goto L_0x00d3
        L_0x00b6:
            r2 = r3 | 10
            goto L_0x00d3
        L_0x00b9:
            r2 = r3 | 9
            goto L_0x00d3
        L_0x00bc:
            r2 = r3 | 8
            goto L_0x00d3
        L_0x00bf:
            r2 = r3 | 7
            goto L_0x00d3
        L_0x00c2:
            r2 = r3 | 6
            goto L_0x00d3
        L_0x00c5:
            r2 = r3 | 5
            goto L_0x00d3
        L_0x00c8:
            r2 = r3 | 4
            goto L_0x00d3
        L_0x00cb:
            r2 = r3 | 3
            goto L_0x00d3
        L_0x00ce:
            r2 = r3 | 2
            goto L_0x00d3
        L_0x00d1:
            r2 = r3 | 1
        L_0x00d3:
            byte r3 = (byte) r2
        L_0x00d4:
            r1.put(r3)
            goto L_0x000a
        L_0x00d9:
            com.unboundid.ldap.sdk.LDAPException r7 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r8 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_MISSING_HEX_CHAR
            java.lang.String r0 = r0.get()
            r7.<init>((com.unboundid.ldap.sdk.ResultCode) r8, (java.lang.String) r0)
            throw r7
        L_0x00e7:
            r1.flip()
            int r7 = r1.limit()
            byte[] r7 = new byte[r7]
            r1.get(r7)
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.RDN.readHexString(java.lang.String, int):byte[]");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00b7, code lost:
        r2 = r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    static int readValueString(java.lang.String r11, int r12, java.lang.StringBuilder r13) {
        /*
            int r0 = r13.length()
            int r1 = r11.length()
            r2 = 0
            r3 = r12
            r4 = 0
        L_0x000b:
            r5 = 92
            r6 = 32
            r7 = 1
            if (r3 >= r1) goto L_0x00b7
            char r8 = r11.charAt(r3)
            if (r8 == r6) goto L_0x00a5
            r9 = 34
            r10 = 59
            if (r8 == r9) goto L_0x0055
            if (r8 == r10) goto L_0x0052
            if (r8 == r5) goto L_0x002a
            switch(r8) {
                case 43: goto L_0x0052;
                case 44: goto L_0x0052;
                default: goto L_0x0025;
            }
        L_0x0025:
            r13.append(r8)
            goto L_0x00b4
        L_0x002a:
            int r3 = r3 + 1
            if (r3 >= r1) goto L_0x0044
            char r5 = r11.charAt(r3)
            boolean r6 = com.unboundid.util.StaticUtils.isHex(r5)
            if (r6 == 0) goto L_0x003f
            int r3 = readEscapedHexString(r11, r3, r13)
            int r3 = r3 - r7
            goto L_0x00b4
        L_0x003f:
            r13.append(r5)
            goto L_0x00b4
        L_0x0044:
            com.unboundid.ldap.sdk.LDAPException r11 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r12 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r13 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_ENDS_WITH_BACKSLASH
            java.lang.String r13 = r13.get()
            r11.<init>((com.unboundid.ldap.sdk.ResultCode) r12, (java.lang.String) r13)
            throw r11
        L_0x0052:
            if (r4 == 0) goto L_0x00b7
            goto L_0x0025
        L_0x0055:
            if (r4 == 0) goto L_0x008b
        L_0x0057:
            int r3 = r3 + 1
            if (r3 >= r1) goto L_0x00b8
            char r12 = r11.charAt(r3)
            r4 = 43
            if (r12 == r4) goto L_0x00b8
            r4 = 44
            if (r12 == r4) goto L_0x00b8
            if (r12 != r10) goto L_0x006a
            goto L_0x00b8
        L_0x006a:
            if (r12 != r6) goto L_0x006d
            goto L_0x0057
        L_0x006d:
            com.unboundid.ldap.sdk.LDAPException r11 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r13 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r0 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_CHAR_OUTSIDE_QUOTES
            r1 = 2
            java.lang.Object[] r1 = new java.lang.Object[r1]
            java.lang.Character r12 = java.lang.Character.valueOf(r12)
            r1[r2] = r12
            int r3 = r3 - r7
            java.lang.Integer r12 = java.lang.Integer.valueOf(r3)
            r1[r7] = r12
            java.lang.String r12 = r0.get(r1)
            r11.<init>((com.unboundid.ldap.sdk.ResultCode) r13, (java.lang.String) r12)
            throw r11
        L_0x008b:
            if (r3 != r12) goto L_0x008f
            r4 = 1
            goto L_0x00b4
        L_0x008f:
            com.unboundid.ldap.sdk.LDAPException r11 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r12 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r13 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_UNEXPECTED_DOUBLE_QUOTE
            java.lang.Object[] r0 = new java.lang.Object[r7]
            java.lang.Integer r1 = java.lang.Integer.valueOf(r3)
            r0[r2] = r1
            java.lang.String r13 = r13.get(r0)
            r11.<init>((com.unboundid.ldap.sdk.ResultCode) r12, (java.lang.String) r13)
            throw r11
        L_0x00a5:
            if (r4 != 0) goto L_0x00b1
            int r5 = r3 + 1
            if (r5 >= r1) goto L_0x00b4
            char r5 = r11.charAt(r5)
            if (r5 == r6) goto L_0x00b4
        L_0x00b1:
            r13.append(r6)
        L_0x00b4:
            int r3 = r3 + r7
            goto L_0x000b
        L_0x00b7:
            r2 = r4
        L_0x00b8:
            if (r2 != 0) goto L_0x00ee
            int r12 = r13.length()
            int r12 = r12 - r7
            int r1 = r3 + -2
        L_0x00c1:
            if (r12 <= 0) goto L_0x00d9
            char r2 = r13.charAt(r12)
            if (r2 != r6) goto L_0x00d9
            char r2 = r11.charAt(r1)
            if (r2 != r5) goto L_0x00d0
            goto L_0x00d9
        L_0x00d0:
            int r2 = r12 + -1
            r13.deleteCharAt(r12)
            int r1 = r1 + -1
            r12 = r2
            goto L_0x00c1
        L_0x00d9:
            int r11 = r13.length()
            if (r11 == r0) goto L_0x00e0
            return r3
        L_0x00e0:
            com.unboundid.ldap.sdk.LDAPException r11 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r12 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r13 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_EMPTY_VALUE
            java.lang.String r13 = r13.get()
            r11.<init>((com.unboundid.ldap.sdk.ResultCode) r12, (java.lang.String) r13)
            throw r11
        L_0x00ee:
            com.unboundid.ldap.sdk.LDAPException r11 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r12 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r13 = com.unboundid.ldap.sdk.LDAPMessages.ERR_RDN_UNCLOSED_DOUBLE_QUOTE
            java.lang.String r13 = r13.get()
            r11.<init>((com.unboundid.ldap.sdk.ResultCode) r12, (java.lang.String) r13)
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.RDN.readValueString(java.lang.String, int, java.lang.StringBuilder):int");
    }

    public int compare(RDN rdn, RDN rdn2) {
        Validator.ensureNotNull(rdn, rdn2);
        return rdn.toNormalizedString().compareTo(rdn2.toNormalizedString());
    }

    public int compareTo(RDN rdn) {
        return compare(this, rdn);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof RDN)) {
            return false;
        }
        return toNormalizedString().equals(((RDN) obj).toNormalizedString());
    }

    public boolean equals(String str) {
        if (str == null) {
            return false;
        }
        return equals((Object) new RDN(str, this.schema));
    }

    public String[] getAttributeNames() {
        return this.attributeNames;
    }

    public String[] getAttributeValues() {
        String[] strArr = new String[this.attributeValues.length];
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = this.attributeValues[i].stringValue();
        }
        return strArr;
    }

    public byte[][] getByteArrayAttributeValues() {
        byte[][] bArr = new byte[this.attributeValues.length][];
        for (int i = 0; i < bArr.length; i++) {
            bArr[i] = this.attributeValues[i].getValue();
        }
        return bArr;
    }

    /* access modifiers changed from: package-private */
    public Schema getSchema() {
        return this.schema;
    }

    public boolean hasAttribute(String str) {
        for (String equalsIgnoreCase : this.attributeNames) {
            if (equalsIgnoreCase.equalsIgnoreCase(str)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasAttributeValue(String str, String str2) {
        int i = 0;
        while (true) {
            String[] strArr = this.attributeNames;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equalsIgnoreCase(str)) {
                if (new Attribute(str, this.schema, str2).equals(new Attribute(str, this.schema, this.attributeValues[i].stringValue()))) {
                    return true;
                }
            }
            i++;
        }
    }

    public boolean hasAttributeValue(String str, byte[] bArr) {
        int i = 0;
        while (true) {
            String[] strArr = this.attributeNames;
            if (i >= strArr.length) {
                return false;
            }
            if (strArr[i].equalsIgnoreCase(str)) {
                if (new Attribute(str, this.schema, bArr).equals(new Attribute(str, this.schema, this.attributeValues[i].getValue()))) {
                    return true;
                }
            }
            i++;
        }
    }

    public int hashCode() {
        return toNormalizedString().hashCode();
    }

    public boolean isMultiValued() {
        return this.attributeNames.length != 1;
    }

    public String toMinimallyEncodedString() {
        StringBuilder sb = new StringBuilder();
        toString(sb, true);
        return sb.toString();
    }

    public String toNormalizedString() {
        if (this.normalizedString == null) {
            StringBuilder sb = new StringBuilder();
            toNormalizedString(sb);
            this.normalizedString = sb.toString();
        }
        return this.normalizedString;
    }

    public void toNormalizedString(StringBuilder sb) {
        String[] strArr = this.attributeNames;
        int i = 0;
        if (strArr.length == 1) {
            String normalizeAttrName = normalizeAttrName(strArr[0]);
            sb.append(normalizeAttrName);
            sb.append('=');
            sb.append(normalizeValue(normalizeAttrName, this.attributeValues[0]));
            return;
        }
        TreeMap treeMap = new TreeMap();
        int i2 = 0;
        while (true) {
            String[] strArr2 = this.attributeNames;
            if (i2 >= strArr2.length) {
                break;
            }
            treeMap.put(normalizeAttrName(strArr2[i2]), this.attributeValues[i2]);
            i2++;
        }
        for (Map.Entry entry : treeMap.entrySet()) {
            int i3 = i + 1;
            if (i > 0) {
                sb.append('+');
            }
            sb.append((String) entry.getKey());
            sb.append('=');
            sb.append(normalizeValue((String) entry.getKey(), (ASN1OctetString) entry.getValue()));
            i = i3;
        }
    }

    public String toString() {
        if (this.rdnString == null) {
            StringBuilder sb = new StringBuilder();
            toString(sb, false);
            this.rdnString = sb.toString();
        }
        return this.rdnString;
    }

    public void toString(StringBuilder sb) {
        toString(sb, false);
    }

    public void toString(StringBuilder sb, boolean z) {
        String str;
        int i;
        if (this.rdnString == null || z) {
            for (int i2 = 0; i2 < this.attributeNames.length; i2++) {
                if (i2 > 0) {
                    sb.append('+');
                }
                sb.append(this.attributeNames[i2]);
                sb.append('=');
                String stringValue = this.attributeValues[i2].stringValue();
                int length = stringValue.length();
                for (int i3 = 0; i3 < length; i3++) {
                    char charAt = stringValue.charAt(i3);
                    if (charAt != 0) {
                        if (charAt != ' ') {
                            if (charAt != '\\') {
                                switch (charAt) {
                                    case '\"':
                                    case '#':
                                        break;
                                    default:
                                        switch (charAt) {
                                            case '+':
                                            case ',':
                                                break;
                                            default:
                                                switch (charAt) {
                                                    case ';':
                                                    case '<':
                                                    case '=':
                                                    case '>':
                                                        break;
                                                    default:
                                                        if (!z && (charAt < ' ' || charAt > '~')) {
                                                            StaticUtils.hexEncode(charAt, sb);
                                                            break;
                                                        }
                                                }
                                                break;
                                        }
                                }
                            }
                            sb.append(IOUtils.DIR_SEPARATOR_WINDOWS);
                            sb.append(charAt);
                        } else if (i3 == 0 || (i = i3 + 1) == length || (i < length && stringValue.charAt(i) == ' ')) {
                            str = "\\ ";
                        } else {
                            sb.append(' ');
                        }
                    } else {
                        str = "\\00";
                    }
                    sb.append(str);
                }
            }
            return;
        }
        sb.append(this.rdnString);
    }
}
