package com.unboundid.ldap.sdk;

import com.unboundid.ldap.sdk.schema.Schema;
import com.unboundid.util.Validator;
import java.io.Serializable;
import java.util.Comparator;
import java.util.List;

/* renamed from: com.unboundid.ldap.sdk.DN */
public final class C3122DN implements Serializable, Comparable<C3122DN>, Comparator<C3122DN> {
    private static final RDN[] NO_RDNS = new RDN[0];
    public static final C3122DN NULL_DN = new C3122DN(new RDN[0]);
    private static final long serialVersionUID = -5272968942085729346L;
    private final String dnString;
    private volatile String normalizedString;
    private final RDN[] rdns;
    private final Schema schema;

    public C3122DN(RDN rdn, C3122DN dn) {
        Validator.ensureNotNull(rdn, dn);
        this.rdns = new RDN[(dn.rdns.length + 1)];
        RDN[] rdnArr = this.rdns;
        rdnArr[0] = rdn;
        RDN[] rdnArr2 = dn.rdns;
        System.arraycopy(rdnArr2, 0, rdnArr, 1, rdnArr2.length);
        StringBuilder sb = new StringBuilder();
        Schema schema2 = null;
        for (RDN rdn2 : this.rdns) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            rdn2.toString(sb, false);
            if (schema2 == null) {
                schema2 = rdn2.getSchema();
            }
        }
        this.dnString = sb.toString();
        this.schema = schema2;
    }

    public C3122DN(String str) {
        this(str, (Schema) null);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:119:0x029c, code lost:
        throw new com.unboundid.ldap.sdk.LDAPException(com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX, com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_NO_EQUAL_SIGN.get(r11));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:132:0x0306, code lost:
        throw new com.unboundid.ldap.sdk.LDAPException(com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX, com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_NO_EQUAL_SIGN.get(r15));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:135:0x0315, code lost:
        r6 = r9;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x007e, code lost:
        throw new com.unboundid.ldap.sdk.LDAPException(r2, r3.get(r4));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:78:0x0172, code lost:
        throw new com.unboundid.ldap.sdk.LDAPException(r2, r3.get(r4));
     */
    /* JADX WARNING: Removed duplicated region for block: B:152:0x029d A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:158:0x0275 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:159:0x02df A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:41:0x00ab  */
    /* JADX WARNING: Removed duplicated region for block: B:81:0x017f A[LOOP:9: B:81:0x017f->B:84:0x0187, LOOP_START, PHI: r14 
      PHI: (r14v5 int) = (r14v4 int), (r14v14 int) binds: [B:80:0x017d, B:84:0x0187] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x01a1  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public C3122DN(java.lang.String r19, com.unboundid.ldap.sdk.schema.Schema r20) {
        /*
            r18 = this;
            r0 = r18
            r1 = r19
            r2 = r20
            r18.<init>()
            com.unboundid.util.Validator.ensureNotNull(r19)
            r0.dnString = r1
            r0.schema = r2
            java.util.ArrayList r3 = new java.util.ArrayList
            r4 = 5
            r3.<init>(r4)
            int r5 = r19.length()
            if (r5 != 0) goto L_0x0025
            com.unboundid.ldap.sdk.RDN[] r1 = NO_RDNS
            r0.rdns = r1
            java.lang.String r1 = ""
            r0.normalizedString = r1
            return
        L_0x0025:
            r6 = 0
            r7 = 1
            r8 = 0
            r9 = 0
        L_0x0029:
            if (r8 >= r5) goto L_0x0315
        L_0x002b:
            r10 = 32
            if (r8 >= r5) goto L_0x0038
            char r11 = r1.charAt(r8)
            if (r11 != r10) goto L_0x0038
            int r8 = r8 + 1
            goto L_0x002b
        L_0x0038:
            if (r8 < r5) goto L_0x0050
            boolean r1 = r3.isEmpty()
            if (r1 == 0) goto L_0x0042
            goto L_0x0315
        L_0x0042:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_ENDS_WITH_COMMA
            java.lang.String r3 = r3.get()
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0050:
            r11 = r8
        L_0x0051:
            r12 = 44
            r13 = 59
            r14 = 61
            if (r11 >= r5) goto L_0x007f
            char r15 = r1.charAt(r11)
            if (r15 == r10) goto L_0x007f
            if (r15 != r14) goto L_0x0062
            goto L_0x007f
        L_0x0062:
            if (r15 == r12) goto L_0x0069
            if (r15 == r13) goto L_0x0069
            int r11 = r11 + 1
            goto L_0x0051
        L_0x0069:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_UNEXPECTED_COMMA
            java.lang.Object[] r4 = new java.lang.Object[r7]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r11)
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x007f:
            java.lang.String r15 = r1.substring(r8, r11)
            int r16 = r15.length()
            if (r16 == 0) goto L_0x0307
        L_0x0089:
            if (r11 >= r5) goto L_0x0096
            char r12 = r1.charAt(r11)
            if (r12 != r10) goto L_0x0096
            int r11 = r11 + 1
            r12 = 44
            goto L_0x0089
        L_0x0096:
            if (r11 >= r5) goto L_0x02f3
            char r12 = r1.charAt(r11)
            if (r12 != r14) goto L_0x02f3
        L_0x009e:
            int r11 = r11 + 1
            if (r11 >= r5) goto L_0x00a9
            char r12 = r1.charAt(r11)
            if (r12 != r10) goto L_0x00a9
            goto L_0x009e
        L_0x00a9:
            if (r11 >= r5) goto L_0x02df
            char r12 = r1.charAt(r11)
            r14 = 35
            r4 = 2
            if (r12 != r14) goto L_0x00c4
            int r11 = r11 + 1
            byte[] r12 = com.unboundid.ldap.sdk.RDN.readHexString(r1, r11)
            com.unboundid.asn1.ASN1OctetString r14 = new com.unboundid.asn1.ASN1OctetString
            r14.<init>((byte[]) r12)
            int r12 = r12.length
            int r12 = r12 * 2
            int r11 = r11 + r12
            goto L_0x00d6
        L_0x00c4:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            int r11 = com.unboundid.ldap.sdk.RDN.readValueString(r1, r11, r12)
            com.unboundid.asn1.ASN1OctetString r14 = new com.unboundid.asn1.ASN1OctetString
            java.lang.String r12 = r12.toString()
            r14.<init>((java.lang.String) r12)
        L_0x00d6:
            r12 = r11
        L_0x00d7:
            if (r11 >= r5) goto L_0x00e3
            char r7 = r1.charAt(r11)
            if (r7 != r10) goto L_0x00e3
            int r11 = r11 + 1
            r7 = 1
            goto L_0x00d7
        L_0x00e3:
            if (r11 < r5) goto L_0x00f3
            com.unboundid.ldap.sdk.RDN r4 = new com.unboundid.ldap.sdk.RDN
            java.lang.String r1 = getTrimmedRDN(r1, r8, r12)
            r4.<init>((java.lang.String) r15, (com.unboundid.asn1.ASN1OctetString) r14, (com.unboundid.ldap.sdk.schema.Schema) r2, (java.lang.String) r1)
            r3.add(r4)
            goto L_0x0316
        L_0x00f3:
            char r7 = r1.charAt(r11)
            if (r7 == r13) goto L_0x011d
            switch(r7) {
                case 43: goto L_0x0120;
                case 44: goto L_0x011d;
                default: goto L_0x00fc;
            }
        L_0x00fc:
            com.unboundid.ldap.sdk.LDAPException r2 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r5 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_UNEXPECTED_CHAR
            java.lang.Object[] r4 = new java.lang.Object[r4]
            char r1 = r1.charAt(r11)
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r4[r6] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r11)
            r6 = 1
            r4[r6] = r1
            java.lang.String r1 = r5.get(r4)
            r2.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r1)
            throw r2
        L_0x011d:
            r4 = 5
            goto L_0x02cc
        L_0x0120:
            int r11 = r11 + 1
            if (r11 >= r5) goto L_0x02be
            java.util.ArrayList r7 = new java.util.ArrayList
            r12 = 5
            r7.<init>(r12)
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r12)
            r7.add(r15)
            r4.add(r14)
        L_0x0135:
            if (r11 >= r5) goto L_0x02b9
        L_0x0137:
            if (r11 >= r5) goto L_0x0142
            char r14 = r1.charAt(r11)
            if (r14 != r10) goto L_0x0142
            int r11 = r11 + 1
            goto L_0x0137
        L_0x0142:
            if (r11 >= r5) goto L_0x02ab
            r14 = r11
        L_0x0145:
            if (r14 >= r5) goto L_0x0173
            char r15 = r1.charAt(r14)
            if (r15 == r10) goto L_0x0173
            r12 = 61
            if (r15 != r12) goto L_0x0152
            goto L_0x0173
        L_0x0152:
            r12 = 44
            if (r15 == r12) goto L_0x015c
            if (r15 == r13) goto L_0x015c
            int r14 = r14 + 1
            r12 = 5
            goto L_0x0145
        L_0x015c:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_UNEXPECTED_COMMA
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            java.lang.Integer r5 = java.lang.Integer.valueOf(r14)
            r4[r6] = r5
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0173:
            r12 = 44
            java.lang.String r11 = r1.substring(r11, r14)
            int r15 = r11.length()
            if (r15 == 0) goto L_0x029d
        L_0x017f:
            if (r14 >= r5) goto L_0x018a
            char r15 = r1.charAt(r14)
            if (r15 != r10) goto L_0x018a
            int r14 = r14 + 1
            goto L_0x017f
        L_0x018a:
            if (r14 >= r5) goto L_0x0289
            char r15 = r1.charAt(r14)
            r12 = 61
            if (r15 != r12) goto L_0x0289
        L_0x0194:
            int r14 = r14 + 1
            if (r14 >= r5) goto L_0x019f
            char r15 = r1.charAt(r14)
            if (r15 != r10) goto L_0x019f
            goto L_0x0194
        L_0x019f:
            if (r14 >= r5) goto L_0x0275
            char r15 = r1.charAt(r14)
            r12 = 35
            if (r15 != r12) goto L_0x01bc
            int r14 = r14 + 1
            byte[] r15 = com.unboundid.ldap.sdk.RDN.readHexString(r1, r14)
            com.unboundid.asn1.ASN1OctetString r12 = new com.unboundid.asn1.ASN1OctetString
            r12.<init>((byte[]) r15)
            int r15 = r15.length
            r17 = 2
            int r15 = r15 * 2
            int r14 = r14 + r15
            r15 = r12
            goto L_0x01ce
        L_0x01bc:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder
            r12.<init>()
            int r14 = com.unboundid.ldap.sdk.RDN.readValueString(r1, r14, r12)
            com.unboundid.asn1.ASN1OctetString r15 = new com.unboundid.asn1.ASN1OctetString
            java.lang.String r12 = r12.toString()
            r15.<init>((java.lang.String) r12)
        L_0x01ce:
            r12 = r14
        L_0x01cf:
            if (r14 >= r5) goto L_0x01db
            char r6 = r1.charAt(r14)
            if (r6 != r10) goto L_0x01db
            int r14 = r14 + 1
            r6 = 0
            goto L_0x01cf
        L_0x01db:
            r7.add(r11)
            r4.add(r15)
            if (r14 < r5) goto L_0x020a
            int r5 = r7.size()
            java.lang.String[] r5 = new java.lang.String[r5]
            java.lang.Object[] r5 = r7.toArray(r5)
            java.lang.String[] r5 = (java.lang.String[]) r5
            int r6 = r4.size()
            com.unboundid.asn1.ASN1OctetString[] r6 = new com.unboundid.asn1.ASN1OctetString[r6]
            java.lang.Object[] r4 = r4.toArray(r6)
            com.unboundid.asn1.ASN1OctetString[] r4 = (com.unboundid.asn1.ASN1OctetString[]) r4
            com.unboundid.ldap.sdk.RDN r6 = new com.unboundid.ldap.sdk.RDN
            java.lang.String r1 = getTrimmedRDN(r1, r8, r12)
            r6.<init>((java.lang.String[]) r5, (com.unboundid.asn1.ASN1OctetString[]) r4, (com.unboundid.ldap.sdk.schema.Schema) r2, (java.lang.String) r1)
            r3.add(r6)
            r6 = 0
            goto L_0x0316
        L_0x020a:
            char r6 = r1.charAt(r14)
            if (r6 == r13) goto L_0x024d
            switch(r6) {
                case 43: goto L_0x0236;
                case 44: goto L_0x024d;
                default: goto L_0x0213;
            }
        L_0x0213:
            com.unboundid.ldap.sdk.LDAPException r2 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r3 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r4 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_UNEXPECTED_CHAR
            r6 = 2
            java.lang.Object[] r5 = new java.lang.Object[r6]
            char r1 = r1.charAt(r14)
            java.lang.Character r1 = java.lang.Character.valueOf(r1)
            r6 = 0
            r5[r6] = r1
            java.lang.Integer r1 = java.lang.Integer.valueOf(r14)
            r6 = 1
            r5[r6] = r1
            java.lang.String r1 = r4.get(r5)
            r2.<init>((com.unboundid.ldap.sdk.ResultCode) r3, (java.lang.String) r1)
            throw r2
        L_0x0236:
            r6 = 2
            int r11 = r14 + 1
            if (r11 >= r5) goto L_0x023f
            r6 = 0
            r12 = 5
            goto L_0x0135
        L_0x023f:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_ENDS_WITH_PLUS
            java.lang.String r3 = r3.get()
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x024d:
            int r6 = r7.size()
            java.lang.String[] r6 = new java.lang.String[r6]
            java.lang.Object[] r6 = r7.toArray(r6)
            java.lang.String[] r6 = (java.lang.String[]) r6
            int r7 = r4.size()
            com.unboundid.asn1.ASN1OctetString[] r7 = new com.unboundid.asn1.ASN1OctetString[r7]
            java.lang.Object[] r4 = r4.toArray(r7)
            com.unboundid.asn1.ASN1OctetString[] r4 = (com.unboundid.asn1.ASN1OctetString[]) r4
            com.unboundid.ldap.sdk.RDN r7 = new com.unboundid.ldap.sdk.RDN
            java.lang.String r8 = getTrimmedRDN(r1, r8, r12)
            r7.<init>((java.lang.String[]) r6, (com.unboundid.asn1.ASN1OctetString[]) r4, (com.unboundid.ldap.sdk.schema.Schema) r2, (java.lang.String) r8)
            r3.add(r7)
            int r8 = r14 + 1
            r4 = 5
            goto L_0x02da
        L_0x0275:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_NO_VALUE_FOR_ATTR
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r11
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0289:
            r4 = 1
            r5 = 0
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_NO_EQUAL_SIGN
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r5] = r11
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x029d:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_NO_ATTR_IN_RDN
            java.lang.String r3 = r3.get()
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x02ab:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_ENDS_WITH_PLUS
            java.lang.String r3 = r3.get()
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x02b9:
            r8 = r11
            r4 = 5
            r7 = 1
            goto L_0x0029
        L_0x02be:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_ENDS_WITH_PLUS
            java.lang.String r3 = r3.get()
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x02cc:
            com.unboundid.ldap.sdk.RDN r6 = new com.unboundid.ldap.sdk.RDN
            java.lang.String r7 = getTrimmedRDN(r1, r8, r12)
            r6.<init>((java.lang.String) r15, (com.unboundid.asn1.ASN1OctetString) r14, (com.unboundid.ldap.sdk.schema.Schema) r2, (java.lang.String) r7)
            r3.add(r6)
            int r8 = r11 + 1
        L_0x02da:
            r6 = 0
            r7 = 1
            r9 = 1
            goto L_0x0029
        L_0x02df:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_NO_VALUE_FOR_ATTR
            r4 = 1
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r5 = 0
            r4[r5] = r15
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x02f3:
            r4 = 1
            r5 = 0
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_NO_EQUAL_SIGN
            java.lang.Object[] r4 = new java.lang.Object[r4]
            r4[r5] = r15
            java.lang.String r3 = r3.get(r4)
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0307:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_NO_ATTR_IN_RDN
            java.lang.String r3 = r3.get()
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        L_0x0315:
            r6 = r9
        L_0x0316:
            if (r6 != 0) goto L_0x0326
            int r1 = r3.size()
            com.unboundid.ldap.sdk.RDN[] r1 = new com.unboundid.ldap.sdk.RDN[r1]
            r0.rdns = r1
            com.unboundid.ldap.sdk.RDN[] r1 = r0.rdns
            r3.toArray(r1)
            return
        L_0x0326:
            com.unboundid.ldap.sdk.LDAPException r1 = new com.unboundid.ldap.sdk.LDAPException
            com.unboundid.ldap.sdk.ResultCode r2 = com.unboundid.ldap.sdk.ResultCode.INVALID_DN_SYNTAX
            com.unboundid.ldap.sdk.LDAPMessages r3 = com.unboundid.ldap.sdk.LDAPMessages.ERR_DN_ENDS_WITH_COMMA
            java.lang.String r3 = r3.get()
            r1.<init>((com.unboundid.ldap.sdk.ResultCode) r2, (java.lang.String) r3)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.ldap.sdk.C3122DN.<init>(java.lang.String, com.unboundid.ldap.sdk.schema.Schema):void");
    }

    public C3122DN(List<RDN> list) {
        Validator.ensureNotNull(list);
        if (list.isEmpty()) {
            this.rdns = NO_RDNS;
            this.dnString = "";
            this.normalizedString = "";
            this.schema = null;
            return;
        }
        this.rdns = (RDN[]) list.toArray(new RDN[list.size()]);
        StringBuilder sb = new StringBuilder();
        Schema schema2 = null;
        for (RDN rdn : this.rdns) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            rdn.toString(sb, false);
            if (schema2 == null) {
                schema2 = rdn.getSchema();
            }
        }
        this.dnString = sb.toString();
        this.schema = schema2;
    }

    public C3122DN(RDN... rdnArr) {
        Validator.ensureNotNull(rdnArr);
        this.rdns = rdnArr;
        if (rdnArr.length == 0) {
            this.dnString = "";
            this.normalizedString = "";
            this.schema = null;
            return;
        }
        StringBuilder sb = new StringBuilder();
        Schema schema2 = null;
        for (RDN rdn : rdnArr) {
            if (sb.length() > 0) {
                sb.append(',');
            }
            rdn.toString(sb, false);
            if (schema2 == null) {
                schema2 = rdn.getSchema();
            }
        }
        this.dnString = sb.toString();
        this.schema = schema2;
    }

    public static int compare(String str, String str2) {
        return compare(str, str2, (Schema) null);
    }

    public static int compare(String str, String str2, Schema schema2) {
        return new C3122DN(str, schema2).compareTo(new C3122DN(str2, schema2));
    }

    public static boolean equals(String str, String str2) {
        return new C3122DN(str).equals((Object) new C3122DN(str2));
    }

    public static C3122DN getParent(String str) {
        return new C3122DN(str).getParent();
    }

    public static String getParentString(String str) {
        return new C3122DN(str).getParentString();
    }

    public static String getRDNString(String str) {
        return new C3122DN(str).getRDNString();
    }

    public static String[] getRDNStrings(String str) {
        return new C3122DN(str).getRDNStrings();
    }

    public static RDN[] getRDNs(String str) {
        return new C3122DN(str).getRDNs();
    }

    private static String getTrimmedRDN(String str, int i, int i2) {
        String substring = str.substring(i, i2);
        if (!substring.endsWith(" ")) {
            return substring;
        }
        StringBuilder sb = new StringBuilder(substring);
        while (sb.charAt(sb.length() - 1) == ' ' && sb.charAt(sb.length() - 2) != '\\') {
            sb.setLength(sb.length() - 1);
        }
        return sb.toString();
    }

    public static boolean isAncestorOf(String str, String str2, boolean z) {
        return new C3122DN(str).isAncestorOf(new C3122DN(str2), z);
    }

    public static boolean isDescendantOf(String str, String str2, boolean z) {
        return new C3122DN(str).isDescendantOf(new C3122DN(str2), z);
    }

    public static boolean isValidDN(String str) {
        try {
            new C3122DN(str);
            return true;
        } catch (LDAPException unused) {
            return false;
        }
    }

    public static String normalize(String str) {
        return normalize(str, (Schema) null);
    }

    public static String normalize(String str, Schema schema2) {
        return new C3122DN(str, schema2).toNormalizedString();
    }

    public int compare(C3122DN dn, C3122DN dn2) {
        Validator.ensureNotNull(dn, dn2);
        int length = dn.rdns.length - 1;
        int length2 = dn2.rdns.length - 1;
        if (length < 0) {
            return length2 < 0 ? 0 : -1;
        }
        if (length2 < 0) {
            return 1;
        }
        while (length >= 0 && length2 >= 0) {
            int compareTo = dn.rdns[length].compareTo(dn2.rdns[length2]);
            if (compareTo != 0) {
                return compareTo;
            }
            length--;
            length2--;
        }
        if (length < 0) {
            return length2 < 0 ? 0 : -1;
        }
        return 1;
    }

    public int compareTo(C3122DN dn) {
        return compare(this, dn);
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C3122DN)) {
            return false;
        }
        return toNormalizedString().equals(((C3122DN) obj).toNormalizedString());
    }

    public boolean equals(String str) {
        if (str == null) {
            return false;
        }
        return equals((Object) new C3122DN(str));
    }

    public C3122DN getParent() {
        RDN[] rdnArr = this.rdns;
        switch (rdnArr.length) {
            case 0:
            case 1:
                return null;
            case 2:
                return new C3122DN(rdnArr[1]);
            case 3:
                return new C3122DN(rdnArr[1], rdnArr[2]);
            case 4:
                return new C3122DN(rdnArr[1], rdnArr[2], rdnArr[3]);
            case 5:
                return new C3122DN(rdnArr[1], rdnArr[2], rdnArr[3], rdnArr[4]);
            default:
                RDN[] rdnArr2 = new RDN[(rdnArr.length - 1)];
                System.arraycopy(rdnArr, 1, rdnArr2, 0, rdnArr2.length);
                return new C3122DN(rdnArr2);
        }
    }

    public String getParentString() {
        C3122DN parent = getParent();
        if (parent == null) {
            return null;
        }
        return parent.toString();
    }

    public RDN getRDN() {
        RDN[] rdnArr = this.rdns;
        if (rdnArr.length == 0) {
            return null;
        }
        return rdnArr[0];
    }

    public String getRDNString() {
        RDN[] rdnArr = this.rdns;
        if (rdnArr.length == 0) {
            return null;
        }
        return rdnArr[0].toString();
    }

    public String[] getRDNStrings() {
        String[] strArr = new String[this.rdns.length];
        int i = 0;
        while (true) {
            RDN[] rdnArr = this.rdns;
            if (i >= rdnArr.length) {
                return strArr;
            }
            strArr[i] = rdnArr[i].toString();
            i++;
        }
    }

    public RDN[] getRDNs() {
        return this.rdns;
    }

    public int hashCode() {
        return toNormalizedString().hashCode();
    }

    public boolean isAncestorOf(C3122DN dn, boolean z) {
        int length = this.rdns.length - 1;
        int length2 = dn.rdns.length - 1;
        if (length < 0) {
            return z || length2 >= 0;
        }
        if (length > length2 || (length == length2 && !z)) {
            return false;
        }
        while (length >= 0) {
            int i = length - 1;
            int i2 = length2 - 1;
            if (!this.rdns[length].equals((Object) dn.rdns[length2])) {
                return false;
            }
            length = i;
            length2 = i2;
        }
        return true;
    }

    public boolean isAncestorOf(String str, boolean z) {
        return isAncestorOf(new C3122DN(str), z);
    }

    public boolean isDescendantOf(C3122DN dn, boolean z) {
        int length = this.rdns.length - 1;
        int length2 = dn.rdns.length - 1;
        if (length2 < 0) {
            return z || length >= 0;
        }
        if (length < length2 || (length == length2 && !z)) {
            return false;
        }
        while (length2 >= 0) {
            int i = length - 1;
            int i2 = length2 - 1;
            if (!this.rdns[length].equals((Object) dn.rdns[length2])) {
                return false;
            }
            length = i;
            length2 = i2;
        }
        return true;
    }

    public boolean isDescendantOf(String str, boolean z) {
        return isDescendantOf(new C3122DN(str), z);
    }

    public boolean isNullDN() {
        return this.rdns.length == 0;
    }

    public boolean matchesBaseAndScope(C3122DN dn, SearchScope searchScope) {
        Validator.ensureNotNull(dn, searchScope);
        switch (searchScope.intValue()) {
            case 0:
                return equals((Object) dn);
            case 1:
                return dn.equals((Object) getParent());
            case 2:
                return isDescendantOf(dn, true);
            case 3:
                return isDescendantOf(dn, false);
            default:
                throw new LDAPException(ResultCode.PARAM_ERROR, LDAPMessages.ERR_DN_MATCHES_UNSUPPORTED_SCOPE.get(this.dnString, String.valueOf(searchScope)));
        }
    }

    public boolean matchesBaseAndScope(String str, SearchScope searchScope) {
        return matchesBaseAndScope(new C3122DN(str), searchScope);
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
        for (int i = 0; i < this.rdns.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            sb.append(this.rdns[i].toNormalizedString());
        }
    }

    public String toString() {
        return this.dnString;
    }

    public void toString(StringBuilder sb) {
        toString(sb, false);
    }

    public void toString(StringBuilder sb, boolean z) {
        for (int i = 0; i < this.rdns.length; i++) {
            if (i > 0) {
                sb.append(',');
            }
            this.rdns[i].toString(sb, z);
        }
    }
}
