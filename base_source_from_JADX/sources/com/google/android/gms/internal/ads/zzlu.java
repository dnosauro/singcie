package com.google.android.gms.internal.ads;

public final class zzlu extends Exception {
    private final String mimeType;
    private final boolean zzbbg;
    private final String zzbbh;
    private final String zzbbi;

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzlu(com.google.android.gms.internal.ads.zzhp r3, java.lang.Throwable r4, boolean r5, int r6) {
        /*
            r2 = this;
            java.lang.String r5 = java.lang.String.valueOf(r3)
            java.lang.String r0 = java.lang.String.valueOf(r5)
            int r0 = r0.length()
            int r0 = r0 + 36
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Decoder init failed: ["
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = "], "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r2.<init>(r5, r4)
            java.lang.String r3 = r3.zzaha
            r2.mimeType = r3
            r3 = 0
            r2.zzbbg = r3
            r3 = 0
            r2.zzbbh = r3
            if (r6 >= 0) goto L_0x0039
            java.lang.String r3 = "neg_"
            goto L_0x003b
        L_0x0039:
            java.lang.String r3 = ""
        L_0x003b:
            int r4 = java.lang.Math.abs(r6)
            java.lang.String r5 = java.lang.String.valueOf(r3)
            int r5 = r5.length()
            int r5 = r5 + 64
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>(r5)
            java.lang.String r5 = "com.google.android.exoplayer.MediaCodecTrackRenderer_"
            r6.append(r5)
            r6.append(r3)
            r6.append(r4)
            java.lang.String r3 = r6.toString()
            r2.zzbbi = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.<init>(com.google.android.gms.internal.ads.zzhp, java.lang.Throwable, boolean, int):void");
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public zzlu(com.google.android.gms.internal.ads.zzhp r3, java.lang.Throwable r4, boolean r5, java.lang.String r6) {
        /*
            r2 = this;
            java.lang.String r5 = java.lang.String.valueOf(r3)
            java.lang.String r0 = java.lang.String.valueOf(r6)
            int r0 = r0.length()
            int r0 = r0 + 23
            java.lang.String r1 = java.lang.String.valueOf(r5)
            int r1 = r1.length()
            int r0 = r0 + r1
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>(r0)
            java.lang.String r0 = "Decoder init failed: "
            r1.append(r0)
            r1.append(r6)
            java.lang.String r0 = ", "
            r1.append(r0)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r2.<init>(r5, r4)
            java.lang.String r3 = r3.zzaha
            r2.mimeType = r3
            r3 = 0
            r2.zzbbg = r3
            r2.zzbbh = r6
            int r3 = com.google.android.gms.internal.ads.zzpt.SDK_INT
            r5 = 0
            r6 = 21
            if (r3 < r6) goto L_0x004d
            boolean r3 = r4 instanceof android.media.MediaCodec.CodecException
            if (r3 == 0) goto L_0x004d
            android.media.MediaCodec$CodecException r4 = (android.media.MediaCodec.CodecException) r4
            java.lang.String r5 = r4.getDiagnosticInfo()
        L_0x004d:
            r2.zzbbi = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlu.<init>(com.google.android.gms.internal.ads.zzhp, java.lang.Throwable, boolean, java.lang.String):void");
    }
}
