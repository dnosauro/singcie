package com.unboundid.asn1;

public final class ASN1Enumerated extends ASN1Element {
    private static final long serialVersionUID = -5915912036130847725L;
    private final int intValue;

    public ASN1Enumerated(byte b, int i) {
        super(b, ASN1Integer.encodeIntValue(i));
        this.intValue = i;
    }

    private ASN1Enumerated(byte b, int i, byte[] bArr) {
        super(b, bArr);
        this.intValue = i;
    }

    public ASN1Enumerated(int i) {
        super((byte) 10, ASN1Integer.encodeIntValue(i));
        this.intValue = i;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.unboundid.asn1.ASN1Enumerated decodeAsEnumerated(com.unboundid.asn1.ASN1Element r5) {
        /*
            byte[] r0 = r5.getValue()
            int r1 = r0.length
            r2 = 2
            r3 = 1
            r4 = 0
            switch(r1) {
                case 1: goto L_0x006a;
                case 2: goto L_0x0056;
                case 3: goto L_0x003b;
                case 4: goto L_0x0020;
                default: goto L_0x000b;
            }
        L_0x000b:
            com.unboundid.asn1.ASN1Exception r5 = new com.unboundid.asn1.ASN1Exception
            com.unboundid.asn1.ASN1Messages r1 = com.unboundid.asn1.ASN1Messages.ERR_ENUMERATED_INVALID_LENGTH
            java.lang.Object[] r2 = new java.lang.Object[r3]
            int r0 = r0.length
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            r2[r4] = r0
            java.lang.String r0 = r1.get(r2)
            r5.<init>(r0)
            throw r5
        L_0x0020:
            byte r1 = r0[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 24
            byte r3 = r0[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 16
            r1 = r1 | r3
            byte r2 = r0[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            r1 = r1 | r2
            r2 = 3
            byte r2 = r0[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
        L_0x0039:
            r1 = r1 | r2
            goto L_0x0076
        L_0x003b:
            byte r1 = r0[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 16
            byte r3 = r0[r3]
            r3 = r3 & 255(0xff, float:3.57E-43)
            int r3 = r3 << 8
            r1 = r1 | r3
            byte r2 = r0[r2]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r1 = r1 | r2
            byte r2 = r0[r4]
            r2 = r2 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0076
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x0039
        L_0x0056:
            byte r1 = r0[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            int r1 = r1 << 8
            byte r2 = r0[r3]
            r2 = r2 & 255(0xff, float:3.57E-43)
            r1 = r1 | r2
            byte r2 = r0[r4]
            r2 = r2 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0076
            r2 = -65536(0xffffffffffff0000, float:NaN)
            goto L_0x0039
        L_0x006a:
            byte r1 = r0[r4]
            r1 = r1 & 255(0xff, float:3.57E-43)
            byte r2 = r0[r4]
            r2 = r2 & 128(0x80, float:1.794E-43)
            if (r2 == 0) goto L_0x0076
            r1 = r1 | -256(0xffffffffffffff00, float:NaN)
        L_0x0076:
            com.unboundid.asn1.ASN1Enumerated r2 = new com.unboundid.asn1.ASN1Enumerated
            byte r5 = r5.getType()
            r2.<init>(r5, r1, r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.asn1.ASN1Enumerated.decodeAsEnumerated(com.unboundid.asn1.ASN1Element):com.unboundid.asn1.ASN1Enumerated");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static com.unboundid.asn1.ASN1Enumerated decodeAsEnumerated(byte[] r8) {
        /*
            r0 = 1
            r1 = 0
            byte r2 = r8[r0]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r2 = r2 & 127(0x7f, float:1.78E-43)
            byte r3 = r8[r0]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4 = 2
            if (r2 == r3) goto L_0x001f
            r3 = 0
            r5 = 2
            r6 = 0
        L_0x000e:
            if (r3 >= r2) goto L_0x001d
            int r6 = r6 << 8
            int r7 = r5 + 1
            byte r5 = r8[r5]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r5 = r5 & 255(0xff, float:3.57E-43)
            r6 = r6 | r5
            int r3 = r3 + 1
            r5 = r7
            goto L_0x000e
        L_0x001d:
            r2 = r6
            goto L_0x0020
        L_0x001f:
            r5 = 2
        L_0x0020:
            int r3 = r8.length     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            int r3 = r3 - r5
            if (r3 != r2) goto L_0x00a1
            byte[] r3 = new byte[r2]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            java.lang.System.arraycopy(r8, r5, r3, r1, r2)     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            int r2 = r3.length     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            switch(r2) {
                case 1: goto L_0x007a;
                case 2: goto L_0x0065;
                case 3: goto L_0x004a;
                case 4: goto L_0x0030;
                default: goto L_0x002d;
            }     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
        L_0x002d:
            com.unboundid.asn1.ASN1Exception r8 = new com.unboundid.asn1.ASN1Exception     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            goto L_0x008e
        L_0x0030:
            byte r2 = r3[r1]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 24
            byte r5 = r3[r0]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 16
            r2 = r2 | r5
            byte r4 = r3[r4]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4 = r4 & 255(0xff, float:3.57E-43)
            int r4 = r4 << 8
            r2 = r2 | r4
            r4 = 3
            byte r4 = r3[r4]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4 = r4 & 255(0xff, float:3.57E-43)
            goto L_0x0078
        L_0x004a:
            byte r2 = r3[r1]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 16
            byte r5 = r3[r0]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r5 = r5 & 255(0xff, float:3.57E-43)
            int r5 = r5 << 8
            r2 = r2 | r5
            byte r4 = r3[r4]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4 = r4 & 255(0xff, float:3.57E-43)
            r2 = r2 | r4
            byte r4 = r3[r1]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4 = r4 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0086
            r4 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x0078
        L_0x0065:
            byte r2 = r3[r1]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r2 = r2 & 255(0xff, float:3.57E-43)
            int r2 = r2 << 8
            byte r4 = r3[r0]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4 = r4 & 255(0xff, float:3.57E-43)
            r2 = r2 | r4
            byte r4 = r3[r1]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4 = r4 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0086
            r4 = -65536(0xffffffffffff0000, float:NaN)
        L_0x0078:
            r2 = r2 | r4
            goto L_0x0086
        L_0x007a:
            byte r2 = r3[r1]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r2 = r2 & 255(0xff, float:3.57E-43)
            byte r4 = r3[r1]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4 = r4 & 128(0x80, float:1.794E-43)
            if (r4 == 0) goto L_0x0086
            r2 = r2 | -256(0xffffffffffffff00, float:NaN)
        L_0x0086:
            com.unboundid.asn1.ASN1Enumerated r4 = new com.unboundid.asn1.ASN1Enumerated     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            byte r8 = r8[r1]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4.<init>(r8, r2, r3)     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            return r4
        L_0x008e:
            com.unboundid.asn1.ASN1Messages r2 = com.unboundid.asn1.ASN1Messages.ERR_ENUMERATED_INVALID_LENGTH     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            java.lang.Object[] r4 = new java.lang.Object[r0]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            int r3 = r3.length     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            java.lang.Integer r3 = java.lang.Integer.valueOf(r3)     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4[r1] = r3     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            java.lang.String r2 = r2.get(r4)     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r8.<init>(r2)     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            throw r8     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
        L_0x00a1:
            com.unboundid.asn1.ASN1Exception r3 = new com.unboundid.asn1.ASN1Exception     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            com.unboundid.asn1.ASN1Messages r6 = com.unboundid.asn1.ASN1Messages.ERR_ELEMENT_LENGTH_MISMATCH     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4[r1] = r2     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            int r8 = r8.length     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            int r8 = r8 - r5
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r4[r0] = r8     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            java.lang.String r8 = r6.get(r4)     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            r3.<init>(r8)     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
            throw r3     // Catch:{ ASN1Exception -> 0x00d1, Exception -> 0x00bd }
        L_0x00bd:
            r8 = move-exception
            com.unboundid.util.Debug.debugException(r8)
            com.unboundid.asn1.ASN1Exception r2 = new com.unboundid.asn1.ASN1Exception
            com.unboundid.asn1.ASN1Messages r3 = com.unboundid.asn1.ASN1Messages.ERR_ELEMENT_DECODE_EXCEPTION
            java.lang.Object[] r0 = new java.lang.Object[r0]
            r0[r1] = r8
            java.lang.String r0 = r3.get(r0)
            r2.<init>(r0, r8)
            throw r2
        L_0x00d1:
            r8 = move-exception
            com.unboundid.util.Debug.debugException(r8)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.unboundid.asn1.ASN1Enumerated.decodeAsEnumerated(byte[]):com.unboundid.asn1.ASN1Enumerated");
    }

    public int intValue() {
        return this.intValue;
    }

    public void toString(StringBuilder sb) {
        sb.append(this.intValue);
    }
}
