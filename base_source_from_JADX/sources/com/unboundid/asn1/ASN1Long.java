package com.unboundid.asn1;

public final class ASN1Long extends ASN1Element {
    private static final long serialVersionUID = -3445506299288414013L;
    private final long longValue;

    public ASN1Long(byte b, long j) {
        super(b, encodeLongValue(j));
        this.longValue = j;
    }

    private ASN1Long(byte b, long j, byte[] bArr) {
        super(b, bArr);
        this.longValue = j;
    }

    public ASN1Long(long j) {
        super((byte) 2, encodeLongValue(j));
        this.longValue = j;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.unboundid.asn1.ASN1Long decodeAsLong(com.unboundid.asn1.ASN1Element r18) {
        /*
            byte[] r0 = r18.getValue()
            int r1 = r0.length
            r2 = 48
            r3 = 5
            r4 = 40
            r5 = 4
            r6 = 32
            r7 = 3
            r8 = 24
            r9 = 2
            r10 = 16
            r12 = 1
            r13 = 0
            r16 = 255(0xff, double:1.26E-321)
            switch(r1) {
                case 1: goto L_0x0195;
                case 2: goto L_0x0176;
                case 3: goto L_0x0150;
                case 4: goto L_0x0121;
                case 5: goto L_0x00eb;
                case 6: goto L_0x00b1;
                case 7: goto L_0x006f;
                case 8: goto L_0x002f;
                default: goto L_0x001a;
            }
        L_0x001a:
            com.unboundid.asn1.ASN1Exception r1 = new com.unboundid.asn1.ASN1Exception
            com.unboundid.asn1.ASN1Messages r2 = com.unboundid.asn1.ASN1Messages.ERR_LONG_INVALID_LENGTH
            java.lang.Object[] r3 = new java.lang.Object[r12]
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r3[r13] = r0
            java.lang.String r0 = r2.get(r3)
            r1.<init>(r0)
            throw r1
        L_0x002f:
            byte r1 = r0[r13]
            long r13 = (long) r1
            long r13 = r13 & r16
            r1 = 56
            long r13 = r13 << r1
            byte r1 = r0[r12]
            long r11 = (long) r1
            long r11 = r11 & r16
            long r1 = r11 << r2
            long r1 = r1 | r13
            byte r9 = r0[r9]
            long r11 = (long) r9
            long r11 = r11 & r16
            long r11 = r11 << r4
            long r1 = r1 | r11
            byte r4 = r0[r7]
            long r11 = (long) r4
            long r11 = r11 & r16
            long r6 = r11 << r6
            long r1 = r1 | r6
            byte r4 = r0[r5]
            long r4 = (long) r4
            long r4 = r4 & r16
            long r4 = r4 << r8
            long r1 = r1 | r4
            byte r3 = r0[r3]
            long r3 = (long) r3
            long r3 = r3 & r16
            long r3 = r3 << r10
            long r1 = r1 | r3
            r3 = 6
            byte r3 = r0[r3]
            long r3 = (long) r3
            long r3 = r3 & r16
            r5 = 8
            long r3 = r3 << r5
            long r1 = r1 | r3
            r3 = 7
            byte r3 = r0[r3]
            long r3 = (long) r3
            long r3 = r3 & r16
        L_0x006c:
            long r1 = r1 | r3
            goto L_0x01aa
        L_0x006f:
            byte r1 = r0[r13]
            long r14 = (long) r1
            long r14 = r14 & r16
            long r1 = r14 << r2
            byte r11 = r0[r12]
            long r11 = (long) r11
            long r11 = r11 & r16
            long r11 = r11 << r4
            long r1 = r1 | r11
            byte r4 = r0[r9]
            long r11 = (long) r4
            long r11 = r11 & r16
            long r11 = r11 << r6
            long r1 = r1 | r11
            byte r4 = r0[r7]
            long r6 = (long) r4
            long r6 = r6 & r16
            long r6 = r6 << r8
            long r1 = r1 | r6
            byte r4 = r0[r5]
            long r4 = (long) r4
            long r4 = r4 & r16
            long r4 = r4 << r10
            long r1 = r1 | r4
            byte r3 = r0[r3]
            long r3 = (long) r3
            long r3 = r3 & r16
            r5 = 8
            long r3 = r3 << r5
            long r1 = r1 | r3
            r3 = 6
            byte r3 = r0[r3]
            long r3 = (long) r3
            long r3 = r3 & r16
            long r1 = r1 | r3
            byte r3 = r0[r13]
            long r3 = (long) r3
            r5 = 128(0x80, double:6.32E-322)
            long r3 = r3 & r5
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x01aa
            r3 = -72057594037927936(0xff00000000000000, double:-5.4861240687936887E303)
            goto L_0x006c
        L_0x00b1:
            byte r1 = r0[r13]
            long r1 = (long) r1
            long r1 = r1 & r16
            long r1 = r1 << r4
            byte r4 = r0[r12]
            long r11 = (long) r4
            long r11 = r11 & r16
            long r11 = r11 << r6
            long r1 = r1 | r11
            byte r4 = r0[r9]
            long r11 = (long) r4
            long r11 = r11 & r16
            long r8 = r11 << r8
            long r1 = r1 | r8
            byte r4 = r0[r7]
            long r6 = (long) r4
            long r6 = r6 & r16
            long r6 = r6 << r10
            long r1 = r1 | r6
            byte r4 = r0[r5]
            long r4 = (long) r4
            long r4 = r4 & r16
            r6 = 8
            long r4 = r4 << r6
            long r1 = r1 | r4
            byte r3 = r0[r3]
            long r3 = (long) r3
            long r3 = r3 & r16
            long r1 = r1 | r3
            byte r3 = r0[r13]
            long r3 = (long) r3
            r5 = 128(0x80, double:6.32E-322)
            long r3 = r3 & r5
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x01aa
            r3 = -281474976710656(0xffff000000000000, double:NaN)
            goto L_0x006c
        L_0x00eb:
            byte r1 = r0[r13]
            long r1 = (long) r1
            long r1 = r1 & r16
            long r1 = r1 << r6
            byte r3 = r0[r12]
            long r3 = (long) r3
            long r3 = r3 & r16
            long r3 = r3 << r8
            long r1 = r1 | r3
            byte r3 = r0[r9]
            long r3 = (long) r3
            long r3 = r3 & r16
            long r3 = r3 << r10
            long r1 = r1 | r3
            byte r3 = r0[r7]
            long r3 = (long) r3
            long r3 = r3 & r16
            r6 = 8
            long r3 = r3 << r6
            long r1 = r1 | r3
            byte r3 = r0[r5]
            long r3 = (long) r3
            long r3 = r3 & r16
            long r1 = r1 | r3
            byte r3 = r0[r13]
            long r3 = (long) r3
            r5 = 128(0x80, double:6.32E-322)
            long r3 = r3 & r5
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x01aa
            r3 = -1099511627776(0xffffff0000000000, double:NaN)
            goto L_0x006c
        L_0x0121:
            byte r1 = r0[r13]
            long r1 = (long) r1
            long r1 = r1 & r16
            long r1 = r1 << r8
            byte r3 = r0[r12]
            long r3 = (long) r3
            long r3 = r3 & r16
            long r3 = r3 << r10
            long r1 = r1 | r3
            byte r3 = r0[r9]
            long r3 = (long) r3
            long r3 = r3 & r16
            r5 = 8
            long r3 = r3 << r5
            long r1 = r1 | r3
            byte r3 = r0[r7]
            long r3 = (long) r3
            long r3 = r3 & r16
            long r1 = r1 | r3
            byte r3 = r0[r13]
            long r3 = (long) r3
            r5 = 128(0x80, double:6.32E-322)
            long r3 = r3 & r5
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x01aa
            r3 = -4294967296(0xffffffff00000000, double:NaN)
            goto L_0x006c
        L_0x0150:
            byte r1 = r0[r13]
            long r1 = (long) r1
            long r1 = r1 & r16
            long r1 = r1 << r10
            byte r3 = r0[r12]
            long r3 = (long) r3
            long r3 = r3 & r16
            r5 = 8
            long r3 = r3 << r5
            long r1 = r1 | r3
            byte r3 = r0[r9]
            long r3 = (long) r3
            long r3 = r3 & r16
            long r1 = r1 | r3
            byte r3 = r0[r13]
            long r3 = (long) r3
            r5 = 128(0x80, double:6.32E-322)
            long r3 = r3 & r5
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x01aa
            r3 = -16777216(0xffffffffff000000, double:NaN)
            goto L_0x006c
        L_0x0176:
            byte r1 = r0[r13]
            long r1 = (long) r1
            long r1 = r1 & r16
            r3 = 8
            long r1 = r1 << r3
            byte r3 = r0[r12]
            long r3 = (long) r3
            long r3 = r3 & r16
            long r1 = r1 | r3
            byte r3 = r0[r13]
            long r3 = (long) r3
            r5 = 128(0x80, double:6.32E-322)
            long r3 = r3 & r5
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x01aa
            r3 = -65536(0xffffffffffff0000, double:NaN)
            goto L_0x006c
        L_0x0195:
            byte r1 = r0[r13]
            long r1 = (long) r1
            long r1 = r1 & r16
            byte r3 = r0[r13]
            long r3 = (long) r3
            r5 = 128(0x80, double:6.32E-322)
            long r3 = r3 & r5
            r5 = 0
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x01aa
            r3 = -256(0xffffffffffffff00, double:NaN)
            goto L_0x006c
        L_0x01aa:
            com.unboundid.asn1.ASN1Long r3 = new com.unboundid.asn1.ASN1Long
            byte r4 = r18.getType()
            r3.<init>(r4, r1, r0)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.asn1.ASN1Long.decodeAsLong(com.unboundid.asn1.ASN1Element):com.unboundid.asn1.ASN1Long");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x01bd, code lost:
        r1 = r2 | r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x01c0, code lost:
        r1 = r2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x01c9, code lost:
        return new com.unboundid.asn1.ASN1Long(r0[0], r1, r4);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.unboundid.asn1.ASN1Long decodeAsLong(byte[] r21) {
        /*
            r0 = r21
            r1 = 1
            r2 = 0
            byte r3 = r0[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r3 = r3 & 127(0x7f, float:1.78E-43)
            byte r4 = r0[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r5 = 2
            if (r3 == r4) goto L_0x0021
            r4 = 0
            r6 = 2
            r7 = 0
        L_0x0010:
            if (r4 >= r3) goto L_0x001f
            int r7 = r7 << 8
            int r8 = r6 + 1
            byte r6 = r0[r6]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r6 = r6 & 255(0xff, float:3.57E-43)
            r7 = r7 | r6
            int r4 = r4 + 1
            r6 = r8
            goto L_0x0010
        L_0x001f:
            r3 = r7
            goto L_0x0022
        L_0x0021:
            r6 = 2
        L_0x0022:
            int r4 = r0.length     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            int r4 = r4 - r6
            if (r4 != r3) goto L_0x01df
            byte[] r4 = new byte[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            java.lang.System.arraycopy(r0, r6, r4, r2, r3)     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            int r3 = r4.length     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r6 = 48
            r7 = 5
            r8 = 40
            r9 = 4
            r10 = 32
            r11 = 3
            r12 = 24
            r13 = 16
            r16 = 128(0x80, double:6.32E-322)
            r18 = 8
            r19 = 255(0xff, double:1.26E-321)
            switch(r3) {
                case 1: goto L_0x01aa;
                case 2: goto L_0x018c;
                case 3: goto L_0x0165;
                case 4: goto L_0x0136;
                case 5: goto L_0x0100;
                case 6: goto L_0x00c5;
                case 7: goto L_0x0082;
                case 8: goto L_0x0046;
                default: goto L_0x0042;
            }     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
        L_0x0042:
            com.unboundid.asn1.ASN1Exception r0 = new com.unboundid.asn1.ASN1Exception     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            goto L_0x01ca
        L_0x0046:
            byte r3 = r4[r2]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r14 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r14 = r14 & r19
            r3 = 56
            long r14 = r14 << r3
            byte r3 = r4[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = r1 & r19
            long r1 = r1 << r6
            long r1 = r1 | r14
            byte r3 = r4[r5]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r8
            long r1 = r1 | r5
            byte r3 = r4[r11]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r10
            long r1 = r1 | r5
            byte r3 = r4[r9]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r12
            long r1 = r1 | r5
            byte r3 = r4[r7]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r13
            long r1 = r1 | r5
            r3 = 6
            byte r3 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r18
            long r1 = r1 | r5
            r3 = 7
            byte r3 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            goto L_0x018a
        L_0x0082:
            r1 = 0
            byte r2 = r4[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = (long) r2     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = r1 & r19
            long r1 = r1 << r6
            r3 = 1
            byte r6 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r14 = (long) r6     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r14 = r14 & r19
            long r14 = r14 << r8
            long r1 = r1 | r14
            byte r3 = r4[r5]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r10
            long r1 = r1 | r5
            byte r3 = r4[r11]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r12
            long r1 = r1 | r5
            byte r3 = r4[r9]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r13
            long r1 = r1 | r5
            byte r3 = r4[r7]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r18
            long r1 = r1 | r5
            r3 = 6
            byte r3 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r1 = r1 | r5
            r3 = 0
            byte r5 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r5     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r16
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x01c1
            r5 = -72057594037927936(0xff00000000000000, double:-5.4861240687936887E303)
            goto L_0x018a
        L_0x00c5:
            r1 = 0
            byte r2 = r4[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = (long) r2     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = r1 & r19
            long r1 = r1 << r8
            r3 = 1
            byte r6 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r14 = (long) r6     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r14 = r14 & r19
            long r14 = r14 << r10
            long r1 = r1 | r14
            byte r3 = r4[r5]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r12
            long r1 = r1 | r5
            byte r3 = r4[r11]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r13
            long r1 = r1 | r5
            byte r3 = r4[r9]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r18
            long r1 = r1 | r5
            byte r3 = r4[r7]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r1 = r1 | r5
            r3 = 0
            byte r5 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r5     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r16
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x01c1
            r5 = -281474976710656(0xffff000000000000, double:NaN)
            goto L_0x018a
        L_0x0100:
            r1 = 0
            byte r2 = r4[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = (long) r2     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = r1 & r19
            long r1 = r1 << r10
            r3 = 1
            byte r6 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r6 = (long) r6     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r6 = r6 & r19
            long r6 = r6 << r12
            long r1 = r1 | r6
            byte r3 = r4[r5]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r13
            long r1 = r1 | r5
            byte r3 = r4[r11]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r18
            long r1 = r1 | r5
            byte r3 = r4[r9]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r1 = r1 | r5
            r3 = 0
            byte r5 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r5     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r16
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x01c1
            r5 = -1099511627776(0xffffff0000000000, double:NaN)
            goto L_0x018a
        L_0x0136:
            r1 = 0
            byte r2 = r4[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = (long) r2     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = r1 & r19
            long r1 = r1 << r12
            r3 = 1
            byte r6 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r6 = (long) r6     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r6 = r6 & r19
            long r6 = r6 << r13
            long r1 = r1 | r6
            byte r3 = r4[r5]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r5 = r5 << r18
            long r1 = r1 | r5
            byte r3 = r4[r11]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r1 = r1 | r5
            r3 = 0
            byte r5 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r5     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r16
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x01c1
            r5 = -4294967296(0xffffffff00000000, double:NaN)
            goto L_0x018a
        L_0x0165:
            r1 = 0
            byte r2 = r4[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = (long) r2     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r1 = r1 & r19
            long r1 = r1 << r13
            r3 = 1
            byte r6 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r6 = (long) r6     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r6 = r6 & r19
            long r6 = r6 << r18
            long r1 = r1 | r6
            byte r3 = r4[r5]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r1 = r1 | r5
            r3 = 0
            byte r5 = r4[r3]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r5     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r16
            r7 = 0
            int r3 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r3 == 0) goto L_0x01c1
            r5 = -16777216(0xffffffffff000000, double:NaN)
        L_0x018a:
            long r1 = r1 | r5
            goto L_0x01c1
        L_0x018c:
            r1 = 0
            byte r2 = r4[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r2 = (long) r2     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r2 = r2 & r19
            long r2 = r2 << r18
            r5 = 1
            byte r6 = r4[r5]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r6     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r19
            long r2 = r2 | r5
            byte r5 = r4[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r5     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r16
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x01c0
            r5 = -65536(0xffffffffffff0000, double:NaN)
            goto L_0x01bd
        L_0x01aa:
            r1 = 0
            byte r2 = r4[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r2 = (long) r2     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r2 = r2 & r19
            byte r5 = r4[r1]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = (long) r5     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            long r5 = r5 & r16
            r7 = 0
            int r1 = (r5 > r7 ? 1 : (r5 == r7 ? 0 : -1))
            if (r1 == 0) goto L_0x01c0
            r5 = -256(0xffffffffffffff00, double:NaN)
        L_0x01bd:
            long r1 = r2 | r5
            goto L_0x01c1
        L_0x01c0:
            r1 = r2
        L_0x01c1:
            com.unboundid.asn1.ASN1Long r3 = new com.unboundid.asn1.ASN1Long     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r5 = 0
            byte r0 = r0[r5]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r3.<init>(r0, r1, r4)     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            return r3
        L_0x01ca:
            com.unboundid.asn1.ASN1Messages r1 = com.unboundid.asn1.ASN1Messages.ERR_LONG_INVALID_LENGTH     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r2 = 1
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            int r2 = r4.length     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r4 = 0
            r3[r4] = r2     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            java.lang.String r1 = r1.get(r3)     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r0.<init>(r1)     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            throw r0     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
        L_0x01df:
            com.unboundid.asn1.ASN1Exception r1 = new com.unboundid.asn1.ASN1Exception     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            com.unboundid.asn1.ASN1Messages r2 = com.unboundid.asn1.ASN1Messages.ERR_ELEMENT_LENGTH_MISMATCH     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            java.lang.Object[] r4 = new java.lang.Object[r5]     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r5 = 0
            r4[r5] = r3     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            int r0 = r0.length     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            int r0 = r0 - r6
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r3 = 1
            r4[r3] = r0     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            java.lang.String r0 = r2.get(r4)     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            r1.<init>(r0)     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
            throw r1     // Catch:{ ASN1Exception -> 0x0213, Exception -> 0x01fd }
        L_0x01fd:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)
            com.unboundid.asn1.ASN1Exception r1 = new com.unboundid.asn1.ASN1Exception
            com.unboundid.asn1.ASN1Messages r2 = com.unboundid.asn1.ASN1Messages.ERR_ELEMENT_DECODE_EXCEPTION
            r3 = 1
            java.lang.Object[] r3 = new java.lang.Object[r3]
            r4 = 0
            r3[r4] = r0
            java.lang.String r2 = r2.get(r3)
            r1.<init>(r2, r0)
            throw r1
        L_0x0213:
            r0 = move-exception
            com.unboundid.util.Debug.debugException(r0)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.asn1.ASN1Long.decodeAsLong(byte[]):com.unboundid.asn1.ASN1Long");
    }

    static byte[] encodeLongValue(long j) {
        if (j >= 0) {
            long j2 = j & 127;
            if (j2 == j) {
                return new byte[]{(byte) ((int) j2)};
            } else if ((j & 32767) == j) {
                return new byte[]{(byte) ((int) ((j >> 8) & 127)), (byte) ((int) (j & 255))};
            } else if ((j & 8388607) == j) {
                return new byte[]{(byte) ((int) ((j >> 16) & 127)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
            } else if ((j & 2147483647L) == j) {
                return new byte[]{(byte) ((int) ((j >> 24) & 127)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
            } else if ((j & 549755813887L) == j) {
                return new byte[]{(byte) ((int) ((j >> 32) & 127)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
            } else if ((j & 140737488355327L) == j) {
                return new byte[]{(byte) ((int) ((j >> 40) & 127)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
            } else if ((j & 36028797018963967L) == j) {
                return new byte[]{(byte) ((int) ((j >> 48) & 127)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
            } else {
                return new byte[]{(byte) ((int) ((j >> 56) & 127)), (byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
            }
        } else if ((j & -128) == -128) {
            return new byte[]{(byte) ((int) (j & 255))};
        } else if ((j & -32768) == -32768) {
            return new byte[]{(byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
        } else if ((j & -8388608) == -8388608) {
            return new byte[]{(byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
        } else if ((j & -2147483648L) == -2147483648L) {
            return new byte[]{(byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
        } else if ((j & -549755813888L) == -549755813888L) {
            return new byte[]{(byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
        } else if ((j & -140737488355328L) == -140737488355328L) {
            return new byte[]{(byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
        } else if ((j & -36028797018963968L) == -36028797018963968L) {
            return new byte[]{(byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
        } else {
            return new byte[]{(byte) ((int) ((j >> 56) & 255)), (byte) ((int) ((j >> 48) & 255)), (byte) ((int) ((j >> 40) & 255)), (byte) ((int) ((j >> 32) & 255)), (byte) ((int) ((j >> 24) & 255)), (byte) ((int) ((j >> 16) & 255)), (byte) ((int) ((j >> 8) & 255)), (byte) ((int) (j & 255))};
        }
    }

    public long longValue() {
        return this.longValue;
    }

    public void toString(StringBuilder sb) {
        sb.append(this.longValue);
    }
}
