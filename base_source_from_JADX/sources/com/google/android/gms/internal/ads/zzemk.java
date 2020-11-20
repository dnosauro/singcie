package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;
import java.util.Iterator;
import org.spongycastle.crypto.tls.CipherSuite;

final class zzemk extends zzeiu {
    static final int[] zziqt = {1, 1, 2, 3, 5, 8, 13, 21, 34, 55, 89, CipherSuite.TLS_DHE_PSK_WITH_AES_128_CBC_SHA, 233, 377, 610, 987, 1597, 2584, 4181, 6765, 10946, 17711, 28657, 46368, 75025, 121393, 196418, 317811, 514229, 832040, 1346269, 2178309, 3524578, 5702887, 9227465, 14930352, 24157817, 39088169, 63245986, 102334155, 165580141, 267914296, 433494437, 701408733, 1134903170, 1836311903, Integer.MAX_VALUE};
    private final int zziqu;
    /* access modifiers changed from: private */
    public final zzeiu zziqv;
    /* access modifiers changed from: private */
    public final zzeiu zziqw;
    private final int zziqx;
    private final int zziqy;

    private zzemk(zzeiu zzeiu, zzeiu zzeiu2) {
        this.zziqv = zzeiu;
        this.zziqw = zzeiu2;
        this.zziqx = zzeiu.size();
        this.zziqu = this.zziqx + zzeiu2.size();
        this.zziqy = Math.max(zzeiu.zzbfu(), zzeiu2.zzbfu()) + 1;
    }

    /* synthetic */ zzemk(zzeiu zzeiu, zzeiu zzeiu2, zzemj zzemj) {
        this(zzeiu, zzeiu2);
    }

    static zzeiu zza(zzeiu zzeiu, zzeiu zzeiu2) {
        if (zzeiu2.size() == 0) {
            return zzeiu;
        }
        if (zzeiu.size() == 0) {
            return zzeiu2;
        }
        int size = zzeiu.size() + zzeiu2.size();
        if (size < 128) {
            return zzb(zzeiu, zzeiu2);
        }
        if (zzeiu instanceof zzemk) {
            zzemk zzemk = (zzemk) zzeiu;
            if (zzemk.zziqw.size() + zzeiu2.size() < 128) {
                return new zzemk(zzemk.zziqv, zzb(zzemk.zziqw, zzeiu2));
            } else if (zzemk.zziqv.zzbfu() > zzemk.zziqw.zzbfu() && zzemk.zzbfu() > zzeiu2.zzbfu()) {
                return new zzemk(zzemk.zziqv, new zzemk(zzemk.zziqw, zzeiu2));
            }
        }
        return size >= zzhq(Math.max(zzeiu.zzbfu(), zzeiu2.zzbfu()) + 1) ? new zzemk(zzeiu, zzeiu2) : new zzemm((zzemj) null).zzc(zzeiu, zzeiu2);
    }

    private static zzeiu zzb(zzeiu zzeiu, zzeiu zzeiu2) {
        int size = zzeiu.size();
        int size2 = zzeiu2.size();
        byte[] bArr = new byte[(size + size2)];
        zzeiu.zza(bArr, 0, 0, size);
        zzeiu2.zza(bArr, 0, size, size2);
        return zzeiu.zzu(bArr);
    }

    static int zzhq(int i) {
        int[] iArr = zziqt;
        if (i >= iArr.length) {
            return Integer.MAX_VALUE;
        }
        return iArr[i];
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeiu)) {
            return false;
        }
        zzeiu zzeiu = (zzeiu) obj;
        if (this.zziqu != zzeiu.size()) {
            return false;
        }
        if (this.zziqu == 0) {
            return true;
        }
        int zzbfw = zzbfw();
        int zzbfw2 = zzeiu.zzbfw();
        if (zzbfw != 0 && zzbfw2 != 0 && zzbfw != zzbfw2) {
            return false;
        }
        zzeml zzeml = new zzeml(this, (zzemj) null);
        zzejf zzejf = (zzejf) zzeml.next();
        zzeml zzeml2 = new zzeml(zzeiu, (zzemj) null);
        zzejf zzejf2 = (zzejf) zzeml2.next();
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (true) {
            int size = zzejf.size() - i;
            int size2 = zzejf2.size() - i2;
            int min = Math.min(size, size2);
            if (!(i == 0 ? zzejf.zza(zzejf2, i2, min) : zzejf2.zza(zzejf, i, min))) {
                return false;
            }
            i3 += min;
            int i4 = this.zziqu;
            if (i3 < i4) {
                if (min == size) {
                    zzejf = (zzejf) zzeml.next();
                    i = 0;
                } else {
                    i += min;
                }
                if (min == size2) {
                    zzejf2 = (zzejf) zzeml2.next();
                    i2 = 0;
                } else {
                    i2 += min;
                }
            } else if (i3 == i4) {
                return true;
            } else {
                throw new IllegalStateException();
            }
        }
    }

    public final /* synthetic */ Iterator iterator() {
        return iterator();
    }

    public final int size() {
        return this.zziqu;
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(toByteArray(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeiv zzeiv) {
        this.zziqv.zza(zzeiv);
        this.zziqw.zza(zzeiv);
    }

    public final zzeiu zzaa(int i, int i2) {
        int zzi = zzi(i, i2, this.zziqu);
        if (zzi == 0) {
            return zzeiu.zziiy;
        }
        if (zzi == this.zziqu) {
            return this;
        }
        int i3 = this.zziqx;
        if (i2 <= i3) {
            return this.zziqv.zzaa(i, i2);
        }
        if (i >= i3) {
            return this.zziqw.zzaa(i - i3, i2 - i3);
        }
        zzeiu zzeiu = this.zziqv;
        return new zzemk(zzeiu.zzaa(i, zzeiu.size()), this.zziqw.zzaa(0, i2 - this.zziqx));
    }

    /* access modifiers changed from: protected */
    public final void zzb(byte[] bArr, int i, int i2, int i3) {
        int i4 = i + i3;
        int i5 = this.zziqx;
        if (i4 <= i5) {
            this.zziqv.zzb(bArr, i, i2, i3);
        } else if (i >= i5) {
            this.zziqw.zzb(bArr, i - i5, i2, i3);
        } else {
            int i6 = i5 - i;
            this.zziqv.zzb(bArr, i, i2, i6);
            this.zziqw.zzb(bArr, 0, i2 + i6, i3 - i6);
        }
    }

    public final zzejd zzbfp() {
        return new zzemj(this);
    }

    public final boolean zzbfr() {
        int zzg = this.zziqv.zzg(0, 0, this.zziqx);
        zzeiu zzeiu = this.zziqw;
        return zzeiu.zzg(zzg, 0, zzeiu.size()) == 0;
    }

    public final zzejj zzbfs() {
        return new zzejk(new zzemo(this));
    }

    /* access modifiers changed from: protected */
    public final int zzbfu() {
        return this.zziqy;
    }

    /* access modifiers changed from: protected */
    public final boolean zzbfv() {
        return this.zziqu >= zzhq(this.zziqy);
    }

    public final byte zzfy(int i) {
        zzab(i, this.zziqu);
        return zzfz(i);
    }

    /* access modifiers changed from: package-private */
    public final byte zzfz(int i) {
        int i2 = this.zziqx;
        return i < i2 ? this.zziqv.zzfz(i) : this.zziqw.zzfz(i - i2);
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zziqx;
        if (i4 <= i5) {
            return this.zziqv.zzg(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zziqw.zzg(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zziqw.zzg(this.zziqv.zzg(i, i2, i6), 0, i3 - i6);
    }

    /* access modifiers changed from: protected */
    public final int zzh(int i, int i2, int i3) {
        int i4 = i2 + i3;
        int i5 = this.zziqx;
        if (i4 <= i5) {
            return this.zziqv.zzh(i, i2, i3);
        }
        if (i2 >= i5) {
            return this.zziqw.zzh(i, i2 - i5, i3);
        }
        int i6 = i5 - i2;
        return this.zziqw.zzh(this.zziqv.zzh(i, i2, i6), 0, i3 - i6);
    }
}
