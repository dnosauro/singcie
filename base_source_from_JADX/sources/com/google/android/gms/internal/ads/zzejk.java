package com.google.android.gms.internal.ads;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

final class zzejk extends zzejj {
    private final byte[] buffer;
    private int pos;
    private int zzakb;
    private final InputStream zzijq;
    private int zzijr;
    private int zzijs;
    private int zzijt;
    private int zziju;
    private zzejn zzijv;

    private zzejk(InputStream inputStream, int i) {
        super();
        this.zziju = Integer.MAX_VALUE;
        this.zzijv = null;
        zzekk.zza(inputStream, "input");
        this.zzijq = inputStream;
        this.buffer = new byte[4096];
        this.zzakb = 0;
        this.pos = 0;
        this.zzijt = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:29:0x0066, code lost:
        if (r2[r3] >= 0) goto L_0x0068;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final int zzbgs() {
        /*
            r5 = this;
            int r0 = r5.pos
            int r1 = r5.zzakb
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejk.zzbgs():int");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00b0, code lost:
        if (((long) r2[r0]) >= 0) goto L_0x00b4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final long zzbgt() {
        /*
            r11 = this;
            int r0 = r11.pos
            int r1 = r11.zzakb
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzejk.zzbgt():long");
    }

    private final int zzbgu() {
        int i = this.pos;
        if (this.zzakb - i < 4) {
            zzgh(4);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 4;
        return ((bArr[i + 3] & 255) << 24) | (bArr[i] & 255) | ((bArr[i + 1] & 255) << 8) | ((bArr[i + 2] & 255) << Tnaf.POW_2_WIDTH);
    }

    private final long zzbgv() {
        int i = this.pos;
        if (this.zzakb - i < 8) {
            zzgh(8);
            i = this.pos;
        }
        byte[] bArr = this.buffer;
        this.pos = i + 8;
        return ((((long) bArr[i + 7]) & 255) << 56) | (((long) bArr[i]) & 255) | ((((long) bArr[i + 1]) & 255) << 8) | ((((long) bArr[i + 2]) & 255) << 16) | ((((long) bArr[i + 3]) & 255) << 24) | ((((long) bArr[i + 4]) & 255) << 32) | ((((long) bArr[i + 5]) & 255) << 40) | ((((long) bArr[i + 6]) & 255) << 48);
    }

    private final void zzbgw() {
        this.zzakb += this.zzijr;
        int i = this.zzijt;
        int i2 = this.zzakb;
        int i3 = i + i2;
        int i4 = this.zziju;
        if (i3 > i4) {
            this.zzijr = i3 - i4;
            this.zzakb = i2 - this.zzijr;
            return;
        }
        this.zzijr = 0;
    }

    private final byte zzbgx() {
        if (this.pos == this.zzakb) {
            zzgh(1);
        }
        byte[] bArr = this.buffer;
        int i = this.pos;
        this.pos = i + 1;
        return bArr[i];
    }

    private final byte[] zzg(int i, boolean z) {
        byte[] zzgj = zzgj(i);
        if (zzgj != null) {
            return zzgj;
        }
        int i2 = this.pos;
        int i3 = this.zzakb;
        int i4 = i3 - i2;
        this.zzijt += i3;
        this.pos = 0;
        this.zzakb = 0;
        List<byte[]> zzgk = zzgk(i - i4);
        byte[] bArr = new byte[i];
        System.arraycopy(this.buffer, i2, bArr, 0, i4);
        for (byte[] next : zzgk) {
            System.arraycopy(next, 0, bArr, i4, next.length);
            i4 += next.length;
        }
        return bArr;
    }

    private final void zzgh(int i) {
        if (zzgi(i)) {
            return;
        }
        if (i > (this.zzijn - this.zzijt) - this.pos) {
            throw zzeks.zzbio();
        }
        throw zzeks.zzbii();
    }

    private final boolean zzgi(int i) {
        while (this.pos + i > this.zzakb) {
            int i2 = this.zzijn;
            int i3 = this.zzijt;
            int i4 = this.pos;
            if (i > (i2 - i3) - i4 || i3 + i4 + i > this.zziju) {
                return false;
            }
            if (i4 > 0) {
                int i5 = this.zzakb;
                if (i5 > i4) {
                    byte[] bArr = this.buffer;
                    System.arraycopy(bArr, i4, bArr, 0, i5 - i4);
                }
                this.zzijt += i4;
                this.zzakb -= i4;
                this.pos = 0;
            }
            InputStream inputStream = this.zzijq;
            byte[] bArr2 = this.buffer;
            int i6 = this.zzakb;
            int read = inputStream.read(bArr2, i6, Math.min(bArr2.length - i6, (this.zzijn - this.zzijt) - this.zzakb));
            if (read == 0 || read < -1 || read > this.buffer.length) {
                String valueOf = String.valueOf(this.zzijq.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 91);
                sb.append(valueOf);
                sb.append("#read(byte[]) returned invalid result: ");
                sb.append(read);
                sb.append("\nThe InputStream implementation is buggy.");
                throw new IllegalStateException(sb.toString());
            } else if (read <= 0) {
                return false;
            } else {
                this.zzakb += read;
                zzbgw();
                if (this.zzakb >= i) {
                    return true;
                }
            }
        }
        StringBuilder sb2 = new StringBuilder(77);
        sb2.append("refillBuffer() called when ");
        sb2.append(i);
        sb2.append(" bytes were already available in buffer");
        throw new IllegalStateException(sb2.toString());
    }

    private final byte[] zzgj(int i) {
        if (i == 0) {
            return zzekk.zzijg;
        }
        if (i >= 0) {
            int i2 = this.zzijt + this.pos + i;
            if (i2 - this.zzijn <= 0) {
                int i3 = this.zziju;
                if (i2 <= i3) {
                    int i4 = this.zzakb - this.pos;
                    int i5 = i - i4;
                    if (i5 >= 4096 && i5 > this.zzijq.available()) {
                        return null;
                    }
                    byte[] bArr = new byte[i];
                    System.arraycopy(this.buffer, this.pos, bArr, 0, i4);
                    this.zzijt += this.zzakb;
                    this.pos = 0;
                    this.zzakb = 0;
                    while (i4 < bArr.length) {
                        int read = this.zzijq.read(bArr, i4, i - i4);
                        if (read != -1) {
                            this.zzijt += read;
                            i4 += read;
                        } else {
                            throw zzeks.zzbii();
                        }
                    }
                    return bArr;
                }
                zzgl((i3 - this.zzijt) - this.pos);
                throw zzeks.zzbii();
            }
            throw zzeks.zzbio();
        }
        throw zzeks.zzbij();
    }

    private final List<byte[]> zzgk(int i) {
        ArrayList arrayList = new ArrayList();
        while (i > 0) {
            byte[] bArr = new byte[Math.min(i, 4096)];
            int i2 = 0;
            while (i2 < bArr.length) {
                int read = this.zzijq.read(bArr, i2, bArr.length - i2);
                if (read != -1) {
                    this.zzijt += read;
                    i2 += read;
                } else {
                    throw zzeks.zzbii();
                }
            }
            i -= bArr.length;
            arrayList.add(bArr);
        }
        return arrayList;
    }

    private final void zzgl(int i) {
        int i2 = this.zzakb;
        int i3 = this.pos;
        if (i <= i2 - i3 && i >= 0) {
            this.pos = i3 + i;
        } else if (i >= 0) {
            int i4 = this.zzijt;
            int i5 = this.pos;
            int i6 = i4 + i5 + i;
            int i7 = this.zziju;
            if (i6 <= i7) {
                this.zzijt = i4 + i5;
                int i8 = this.zzakb - i5;
                this.zzakb = 0;
                this.pos = 0;
                while (i8 < i) {
                    try {
                        long j = (long) (i - i8);
                        long skip = this.zzijq.skip(j);
                        int i9 = (skip > 0 ? 1 : (skip == 0 ? 0 : -1));
                        if (i9 >= 0 && skip <= j) {
                            if (i9 == 0) {
                                break;
                            }
                            i8 += (int) skip;
                        } else {
                            String valueOf = String.valueOf(this.zzijq.getClass());
                            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 92);
                            sb.append(valueOf);
                            sb.append("#skip returned invalid result: ");
                            sb.append(skip);
                            sb.append("\nThe InputStream implementation is buggy.");
                            throw new IllegalStateException(sb.toString());
                        }
                    } catch (Throwable th) {
                        this.zzijt += i8;
                        zzbgw();
                        throw th;
                    }
                }
                this.zzijt += i8;
                zzbgw();
                if (i8 < i) {
                    int i10 = this.zzakb;
                    int i11 = i10 - this.pos;
                    this.pos = i10;
                    while (true) {
                        zzgh(1);
                        int i12 = i - i11;
                        int i13 = this.zzakb;
                        if (i12 > i13) {
                            i11 += i13;
                            this.pos = i13;
                        } else {
                            this.pos = i12;
                            return;
                        }
                    }
                }
            } else {
                zzgl((i7 - i4) - i5);
                throw zzeks.zzbii();
            }
        } else {
            throw zzeks.zzbij();
        }
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
            int i = this.zzakb;
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
        if (zzbgs > this.zzakb) {
            return new String(zzg(zzbgs, false), zzekk.UTF_8);
        }
        zzgh(zzbgs);
        String str2 = new String(this.buffer, this.pos, zzbgs, zzekk.UTF_8);
        this.pos += zzbgs;
        return str2;
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
        byte[] bArr;
        int zzbgs = zzbgs();
        int i = this.pos;
        int i2 = 0;
        if (zzbgs <= this.zzakb - i && zzbgs > 0) {
            bArr = this.buffer;
            this.pos = i + zzbgs;
            i2 = i;
        } else if (zzbgs == 0) {
            return "";
        } else {
            if (zzbgs <= this.zzakb) {
                zzgh(zzbgs);
                bArr = this.buffer;
                this.pos = zzbgs;
            } else {
                bArr = zzg(zzbgs, false);
            }
        }
        return zzeno.zzo(bArr, i2, zzbgs);
    }

    public final zzeiu zzbgi() {
        int zzbgs = zzbgs();
        int i = this.zzakb;
        int i2 = this.pos;
        if (zzbgs <= i - i2 && zzbgs > 0) {
            zzeiu zzh = zzeiu.zzh(this.buffer, i2, zzbgs);
            this.pos += zzbgs;
            return zzh;
        } else if (zzbgs == 0) {
            return zzeiu.zziiy;
        } else {
            byte[] zzgj = zzgj(zzbgs);
            if (zzgj != null) {
                return zzeiu.zzt(zzgj);
            }
            int i3 = this.pos;
            int i4 = this.zzakb;
            int i5 = i4 - i3;
            this.zzijt += i4;
            this.pos = 0;
            this.zzakb = 0;
            List<byte[]> zzgk = zzgk(zzbgs - i5);
            byte[] bArr = new byte[zzbgs];
            System.arraycopy(this.buffer, i3, bArr, 0, i5);
            for (byte[] next : zzgk) {
                System.arraycopy(next, 0, bArr, i5, next.length);
                i5 += next.length;
            }
            return zzeiu.zzu(bArr);
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
        return this.pos == this.zzakb && !zzgi(1);
    }

    public final int zzbgr() {
        return this.zzijt + this.pos;
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
                if (this.zzakb - this.pos >= 10) {
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
            int i2 = i + this.zzijt + this.pos;
            int i3 = this.zziju;
            if (i2 <= i3) {
                this.zziju = i2;
                zzbgw();
                return i3;
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
