package com.google.android.gms.internal.ads;

import java.nio.charset.Charset;

class zzeje extends zzejf {
    protected final byte[] zzijf;

    zzeje(byte[] bArr) {
        if (bArr != null) {
            this.zzijf = bArr;
            return;
        }
        throw new NullPointerException();
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof zzeiu) || size() != ((zzeiu) obj).size()) {
            return false;
        }
        if (size() == 0) {
            return true;
        }
        if (!(obj instanceof zzeje)) {
            return obj.equals(this);
        }
        zzeje zzeje = (zzeje) obj;
        int zzbfw = zzbfw();
        int zzbfw2 = zzeje.zzbfw();
        if (zzbfw == 0 || zzbfw2 == 0 || zzbfw == zzbfw2) {
            return zza(zzeje, 0, size());
        }
        return false;
    }

    public int size() {
        return this.zzijf.length;
    }

    /* access modifiers changed from: protected */
    public final String zza(Charset charset) {
        return new String(this.zzijf, zzbfx(), size(), charset);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzeiv zzeiv) {
        zzeiv.zzi(this.zzijf, zzbfx(), size());
    }

    /* access modifiers changed from: package-private */
    public final boolean zza(zzeiu zzeiu, int i, int i2) {
        if (i2 <= zzeiu.size()) {
            int i3 = i + i2;
            if (i3 > zzeiu.size()) {
                int size = zzeiu.size();
                StringBuilder sb = new StringBuilder(59);
                sb.append("Ran off end of other: ");
                sb.append(i);
                sb.append(", ");
                sb.append(i2);
                sb.append(", ");
                sb.append(size);
                throw new IllegalArgumentException(sb.toString());
            } else if (!(zzeiu instanceof zzeje)) {
                return zzeiu.zzaa(i, i3).equals(zzaa(0, i2));
            } else {
                zzeje zzeje = (zzeje) zzeiu;
                byte[] bArr = this.zzijf;
                byte[] bArr2 = zzeje.zzijf;
                int zzbfx = zzbfx() + i2;
                int zzbfx2 = zzbfx();
                int zzbfx3 = zzeje.zzbfx() + i;
                while (zzbfx2 < zzbfx) {
                    if (bArr[zzbfx2] != bArr2[zzbfx3]) {
                        return false;
                    }
                    zzbfx2++;
                    zzbfx3++;
                }
                return true;
            }
        } else {
            int size2 = size();
            StringBuilder sb2 = new StringBuilder(40);
            sb2.append("Length too large: ");
            sb2.append(i2);
            sb2.append(size2);
            throw new IllegalArgumentException(sb2.toString());
        }
    }

    public final zzeiu zzaa(int i, int i2) {
        int zzi = zzi(i, i2, size());
        return zzi == 0 ? zzeiu.zziiy : new zzejb(this.zzijf, zzbfx() + i, zzi);
    }

    /* access modifiers changed from: protected */
    public void zzb(byte[] bArr, int i, int i2, int i3) {
        System.arraycopy(this.zzijf, i, bArr, i2, i3);
    }

    public final boolean zzbfr() {
        int zzbfx = zzbfx();
        return zzeno.zzm(this.zzijf, zzbfx, size() + zzbfx);
    }

    public final zzejj zzbfs() {
        return zzejj.zzb(this.zzijf, zzbfx(), size(), true);
    }

    /* access modifiers changed from: protected */
    public int zzbfx() {
        return 0;
    }

    public byte zzfy(int i) {
        return this.zzijf[i];
    }

    /* access modifiers changed from: package-private */
    public byte zzfz(int i) {
        return this.zzijf[i];
    }

    /* access modifiers changed from: protected */
    public final int zzg(int i, int i2, int i3) {
        int zzbfx = zzbfx() + i2;
        return zzeno.zzb(i, this.zzijf, zzbfx, i3 + zzbfx);
    }

    /* access modifiers changed from: protected */
    public final int zzh(int i, int i2, int i3) {
        return zzekk.zza(i, this.zzijf, zzbfx() + i2, i3);
    }
}
