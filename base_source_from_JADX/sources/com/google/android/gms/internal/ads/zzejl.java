package com.google.android.gms.internal.ads;

import java.util.Arrays;

final class zzejl extends zzejj {
    private final byte[] buffer;
    private int limit;
    private int pos;
    private int zzijr;
    private int zzijs;
    private int zziju;
    private final boolean zzijw;
    private int zzijx;

    private zzejl(byte[] bArr, int i, int i2, boolean z) {
        super();
        this.zziju = Integer.MAX_VALUE;
        this.buffer = bArr;
        this.limit = i2 + i;
        this.pos = i;
        this.zzijx = this.pos;
        this.zzijw = z;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzbgs() {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.limit
            if (r1 == r0) goto L_0x006b
            byte[] r2 = r5.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0011
            r5.pos = r3
            return r0
        L_0x0011:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x006b
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0022
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
            goto L_0x0068
        L_0x0022:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x002f
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
        L_0x002d:
            r1 = r3
            goto L_0x0068
        L_0x002f:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x003d
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0068
        L_0x003d:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r4 = r1 << 28
            r0 = r0 ^ r4
            r4 = 266354560(0xfe03f80, float:2.2112565E-29)
            r0 = r0 ^ r4
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r3 = r2[r3]
            if (r3 >= 0) goto L_0x0068
            int r3 = r1 + 1
            byte r1 = r2[r1]
            if (r1 >= 0) goto L_0x002d
            int r1 = r3 + 1
            byte r2 = r2[r3]
            if (r2 < 0) goto L_0x006b
        L_0x0068:
            r5.pos = r1
            return r0
        L_0x006b:
            long r0 = r5.zzbgp()
            int r1 = (int) r0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejl.zzbgs():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzbgt() {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.limit
            if (r1 == r0) goto L_0x00b8
            byte[] r2 = r11.buffer
            int r3 = r0 + 1
            byte r0 = r2[r0]
            if (r0 < 0) goto L_0x0012
            r11.pos = r3
            long r0 = (long) r0
            return r0
        L_0x0012:
            int r1 = r1 - r3
            r4 = 9
            if (r1 < r4) goto L_0x00b8
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 7
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0025
            r0 = r0 ^ -128(0xffffffffffffff80, float:NaN)
        L_0x0022:
            long r2 = (long) r0
            goto L_0x00b5
        L_0x0025:
            int r3 = r1 + 1
            byte r1 = r2[r1]
            int r1 = r1 << 14
            r0 = r0 ^ r1
            if (r0 < 0) goto L_0x0036
            r0 = r0 ^ 16256(0x3f80, float:2.278E-41)
            long r0 = (long) r0
            r9 = r0
            r1 = r3
            r2 = r9
            goto L_0x00b5
        L_0x0036:
            int r1 = r3 + 1
            byte r3 = r2[r3]
            int r3 = r3 << 21
            r0 = r0 ^ r3
            if (r0 >= 0) goto L_0x0044
            r2 = -2080896(0xffffffffffe03f80, float:NaN)
            r0 = r0 ^ r2
            goto L_0x0022
        L_0x0044:
            long r3 = (long) r0
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r5 = (long) r1
            r1 = 28
            long r5 = r5 << r1
            long r3 = r3 ^ r5
            r5 = 0
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x005b
            r1 = 266354560(0xfe03f80, double:1.315966377E-315)
        L_0x0057:
            long r2 = r3 ^ r1
            r1 = r0
            goto L_0x00b5
        L_0x005b:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 35
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0070
            r5 = -34093383808(0xfffffff80fe03f80, double:NaN)
        L_0x006d:
            long r2 = r3 ^ r5
            goto L_0x00b5
        L_0x0070:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 42
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 < 0) goto L_0x0083
            r1 = 4363953127296(0x3f80fe03f80, double:2.1560793202584E-311)
            goto L_0x0057
        L_0x0083:
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            r0 = 49
            long r7 = r7 << r0
            long r3 = r3 ^ r7
            int r0 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r0 >= 0) goto L_0x0096
            r5 = -558586000294016(0xfffe03f80fe03f80, double:NaN)
            goto L_0x006d
        L_0x0096:
            int r0 = r1 + 1
            byte r1 = r2[r1]
            long r7 = (long) r1
            r1 = 56
            long r7 = r7 << r1
            long r3 = r3 ^ r7
            r7 = 71499008037633920(0xfe03f80fe03f80, double:6.838959413692434E-304)
            long r3 = r3 ^ r7
            int r1 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r1 >= 0) goto L_0x00b3
            int r1 = r0 + 1
            byte r0 = r2[r0]
            long r7 = (long) r0
            int r0 = (r7 > r5 ? 1 : (r7 == r5 ? 0 : -1))
            if (r0 < 0) goto L_0x00b8
            goto L_0x00b4
        L_0x00b3:
            r1 = r0
        L_0x00b4:
            r2 = r3
        L_0x00b5:
            r11.pos = r1
            return r2
        L_0x00b8:
            long r0 = r11.zzbgp()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejl.zzbgt():long");
    }

    private final int zzbgu() {
        int i = this.pos;
        if (this.limit - i >= 4) {
            byte[] bArr = this.buffer;
            this.pos = i + 4;
            return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Tnaf.POW_2_WIDTH);
        }
        throw zzeks.zzbii();
    }

    private final long zzbgv() {
        int i = this.pos;
        if (this.limit - i >= 8) {
            byte[] bArr = this.buffer;
            this.pos = i + 8;
            return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
        }
        throw zzeks.zzbii();
    }

    private final void zzbgw() {
        this.limit += this.zzijr;
        int i = this.limit;
        int i2 = i - this.zzijx;
        int i3 = this.zziju;
        if (i2 > i3) {
            this.zzijr = i2 - i3;
            this.limit = i - this.zzijr;
            return;
        }
        this.zzijr = 0;
    }

    private final byte zzbgx() {
        int i = this.pos;
        if (i != this.limit) {
            byte[] bArr = this.buffer;
            this.pos = i + 1;
            return bArr[i];
        }
        throw zzeks.zzbii();
    }

    private final void zzgl(int i) {
        if (i >= 0) {
            int i2 = this.limit;
            int i3 = this.pos;
            if (i <= i2 - i3) {
                this.pos = i3 + i;
                return;
            }
        }
        if (i < 0) {
            throw zzeks.zzbij();
        }
        throw zzeks.zzbii();
    }

    public final double readDouble() {
        return Double.longBitsToDouble(zzbgv());
    }

    public final float readFloat() {
        return Float.intBitsToFloat(zzbgu());
    }

    public final String readString() {
        int zzbgs = zzbgs();
        if (zzbgs > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzbgs <= i - i2) {
                String str = new String(this.buffer, i2, zzbgs, zzekk.UTF_8);
                this.pos += zzbgs;
                return str;
            }
        }
        if (zzbgs == 0) {
            return "";
        }
        if (zzbgs < 0) {
            throw zzeks.zzbij();
        }
        throw zzeks.zzbii();
    }

    public final int zzbga() {
        if (zzbgq()) {
            this.zzijs = 0;
            return 0;
        }
        this.zzijs = zzbgs();
        int i = this.zzijs;
        if ((i >>> 3) != 0) {
            return i;
        }
        throw zzeks.zzbil();
    }

    public final long zzbgb() {
        return zzbgt();
    }

    public final long zzbgc() {
        return zzbgt();
    }

    public final int zzbgd() {
        return zzbgs();
    }

    public final long zzbge() {
        return zzbgv();
    }

    public final int zzbgf() {
        return zzbgu();
    }

    public final boolean zzbgg() {
        return zzbgt() != 0;
    }

    public final String zzbgh() {
        int zzbgs = zzbgs();
        if (zzbgs > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzbgs <= i - i2) {
                String zzo = zzeno.zzo(this.buffer, i2, zzbgs);
                this.pos += zzbgs;
                return zzo;
            }
        }
        if (zzbgs == 0) {
            return "";
        }
        if (zzbgs <= 0) {
            throw zzeks.zzbij();
        }
        throw zzeks.zzbii();
    }

    public final zzeiu zzbgi() {
        byte[] bArr;
        int zzbgs = zzbgs();
        if (zzbgs > 0) {
            int i = this.limit;
            int i2 = this.pos;
            if (zzbgs <= i - i2) {
                zzeiu zzh = zzeiu.zzh(this.buffer, i2, zzbgs);
                this.pos += zzbgs;
                return zzh;
            }
        }
        if (zzbgs == 0) {
            return zzeiu.zziiy;
        }
        if (zzbgs > 0) {
            int i3 = this.limit;
            int i4 = this.pos;
            if (zzbgs <= i3 - i4) {
                this.pos = zzbgs + i4;
                bArr = Arrays.copyOfRange(this.buffer, i4, this.pos);
                return zzeiu.zzu(bArr);
            }
        }
        if (zzbgs > 0) {
            throw zzeks.zzbii();
        } else if (zzbgs == 0) {
            bArr = zzekk.zzijg;
            return zzeiu.zzu(bArr);
        } else {
            throw zzeks.zzbij();
        }
    }

    public final int zzbgj() {
        return zzbgs();
    }

    public final int zzbgk() {
        return zzbgs();
    }

    public final int zzbgl() {
        return zzbgu();
    }

    public final long zzbgm() {
        return zzbgv();
    }

    public final int zzbgn() {
        return zzgg(zzbgs());
    }

    public final long zzbgo() {
        return zzfg(zzbgt());
    }

    /* access modifiers changed from: package-private */
    public final long zzbgp() {
        long j = 0;
        for (int i = 0; i < 64; i += 7) {
            byte zzbgx = zzbgx();
            j |= ((long) (zzbgx & Byte.MAX_VALUE)) << i;
            if ((zzbgx & 128) == 0) {
                return j;
            }
        }
        throw zzeks.zzbik();
    }

    public final boolean zzbgq() {
        return this.pos == this.limit;
    }

    public final int zzbgr() {
        return this.pos - this.zzijx;
    }

    public final void zzgc(int i) {
        if (this.zzijs != i) {
            throw zzeks.zzbim();
        }
    }

    public final boolean zzgd(int i) {
        int zzbga;
        int i2 = 0;
        switch (i & 7) {
            case 0:
                if (this.limit - this.pos >= 10) {
                    while (i2 < 10) {
                        byte[] bArr = this.buffer;
                        int i3 = this.pos;
                        this.pos = i3 + 1;
                        if (bArr[i3] < 0) {
                            i2++;
                        }
                    }
                    throw zzeks.zzbik();
                }
                while (i2 < 10) {
                    if (zzbgx() < 0) {
                        i2++;
                    }
                }
                throw zzeks.zzbik();
                return true;
            case 1:
                zzgl(8);
                return true;
            case 2:
                zzgl(zzbgs());
                return true;
            case 3:
                break;
            case 4:
                return false;
            case 5:
                zzgl(4);
                return true;
            default:
                throw zzeks.zzbin();
        }
        do {
            zzbga = zzbga();
            if (zzbga == 0 || !zzgd(zzbga)) {
                zzgc(((i >>> 3) << 3) | 4);
                return true;
            }
            zzbga = zzbga();
            zzgc(((i >>> 3) << 3) | 4);
            return true;
        } while (!zzgd(zzbga));
        zzgc(((i >>> 3) << 3) | 4);
        return true;
    }

    public final int zzge(int i) {
        if (i >= 0) {
            int zzbgr = i + zzbgr();
            int i2 = this.zziju;
            if (zzbgr <= i2) {
                this.zziju = zzbgr;
                zzbgw();
                return i2;
            }
            throw zzeks.zzbii();
        }
        throw zzeks.zzbij();
    }

    public final void zzgf(int i) {
        this.zziju = i;
        zzbgw();
    }
}
