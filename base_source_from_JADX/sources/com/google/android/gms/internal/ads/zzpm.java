package com.google.android.gms.internal.ads;

public final class zzpm {
    private byte[] data;
    private int zzbjx;
    private int zzbjy = 0;
    private int zzbjz;

    public zzpm(byte[] bArr, int i, int i2) {
        this.data = bArr;
        this.zzbjx = i;
        this.zzbjz = i2;
        zziz();
    }

    private final boolean zzbj(int i) {
        if (2 > i || i >= this.zzbjz) {
            return false;
        }
        byte[] bArr = this.data;
        return bArr[i] == 3 && bArr[i + -2] == 0 && bArr[i - 1] == 0;
    }

    private final int zziy() {
        int i = 0;
        int i2 = 0;
        while (!zziv()) {
            i2++;
        }
        int i3 = (1 << i2) - 1;
        if (i2 > 0) {
            i = zzbh(i2);
        }
        return i3 + i;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r1 = r3.zzbjy;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000c, code lost:
        r2 = r3.zzbjz;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zziz() {
        /*
            r3 = this;
            int r0 = r3.zzbjx
            if (r0 < 0) goto L_0x0016
            int r1 = r3.zzbjy
            if (r1 < 0) goto L_0x0016
            r2 = 8
            if (r1 >= r2) goto L_0x0016
            int r2 = r3.zzbjz
            if (r0 < r2) goto L_0x0014
            if (r0 != r2) goto L_0x0016
            if (r1 != 0) goto L_0x0016
        L_0x0014:
            r0 = 1
            goto L_0x0017
        L_0x0016:
            r0 = 0
        L_0x0017:
            com.google.android.gms.internal.ads.zzpc.checkState(r0)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpm.zziz():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0085, code lost:
        if (r0 == 8) goto L_0x0076;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final int zzbh(int r10) {
        /*
            r9 = this;
            r0 = 0
            if (r10 != 0) goto L_0x0004
            return r0
        L_0x0004:
            int r1 = r10 / 8
            r2 = 0
        L_0x0007:
            r3 = 255(0xff, float:3.57E-43)
            r4 = 8
            if (r0 >= r1) goto L_0x0044
            int r5 = r9.zzbjx
            int r5 = r5 + 1
            boolean r5 = r9.zzbj(r5)
            if (r5 == 0) goto L_0x001c
            int r5 = r9.zzbjx
            int r5 = r5 + 2
            goto L_0x0020
        L_0x001c:
            int r5 = r9.zzbjx
            int r5 = r5 + 1
        L_0x0020:
            int r6 = r9.zzbjy
            if (r6 == 0) goto L_0x0034
            byte[] r7 = r9.data
            int r8 = r9.zzbjx
            byte r8 = r7[r8]
            r8 = r8 & r3
            int r8 = r8 << r6
            byte r7 = r7[r5]
            r7 = r7 & r3
            int r4 = r4 - r6
            int r4 = r7 >>> r4
            r4 = r4 | r8
            goto L_0x003a
        L_0x0034:
            byte[] r4 = r9.data
            int r6 = r9.zzbjx
            byte r4 = r4[r6]
        L_0x003a:
            int r10 = r10 + -8
            r3 = r3 & r4
            int r3 = r3 << r10
            r2 = r2 | r3
            r9.zzbjx = r5
            int r0 = r0 + 1
            goto L_0x0007
        L_0x0044:
            if (r10 <= 0) goto L_0x008c
            int r0 = r9.zzbjy
            int r0 = r0 + r10
            int r10 = 8 - r10
            int r10 = r3 >> r10
            byte r10 = (byte) r10
            int r1 = r9.zzbjx
            int r1 = r1 + 1
            boolean r1 = r9.zzbj(r1)
            if (r1 == 0) goto L_0x005d
            int r1 = r9.zzbjx
            int r1 = r1 + 2
            goto L_0x0061
        L_0x005d:
            int r1 = r9.zzbjx
            int r1 = r1 + 1
        L_0x0061:
            if (r0 <= r4) goto L_0x0079
            byte[] r5 = r9.data
            int r6 = r9.zzbjx
            byte r6 = r5[r6]
            r6 = r6 & r3
            int r7 = r0 + -8
            int r6 = r6 << r7
            byte r5 = r5[r1]
            r3 = r3 & r5
            int r5 = 16 - r0
            int r3 = r3 >> r5
            r3 = r3 | r6
            r10 = r10 & r3
            r10 = r10 | r2
        L_0x0076:
            r9.zzbjx = r1
            goto L_0x0088
        L_0x0079:
            byte[] r5 = r9.data
            int r6 = r9.zzbjx
            byte r5 = r5[r6]
            r3 = r3 & r5
            int r5 = 8 - r0
            int r3 = r3 >> r5
            r10 = r10 & r3
            r10 = r10 | r2
            if (r0 != r4) goto L_0x0088
            goto L_0x0076
        L_0x0088:
            r2 = r10
            int r0 = r0 % r4
            r9.zzbjy = r0
        L_0x008c:
            r9.zziz()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzpm.zzbh(int):int");
    }

    public final void zzbi(int i) {
        int i2 = this.zzbjx;
        this.zzbjx = (i / 8) + i2;
        this.zzbjy += i % 8;
        int i3 = this.zzbjy;
        if (i3 > 7) {
            this.zzbjx++;
            this.zzbjy = i3 - 8;
        }
        while (true) {
            i2++;
            if (i2 > this.zzbjx) {
                zziz();
                return;
            } else if (zzbj(i2)) {
                this.zzbjx++;
                i2 += 2;
            }
        }
    }

    public final boolean zziv() {
        return zzbh(1) == 1;
    }

    public final int zziw() {
        return zziy();
    }

    public final int zzix() {
        int zziy = zziy();
        return (zziy % 2 == 0 ? -1 : 1) * ((zziy + 1) / 2);
    }
}
