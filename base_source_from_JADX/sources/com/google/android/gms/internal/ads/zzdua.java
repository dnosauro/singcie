package com.google.android.gms.internal.ads;

import java.io.File;
import java.util.Arrays;

public final class zzdua {
    private final zzgt zzhrn;
    private final File zzhro;
    private final File zzhrp;
    private final File zzhrq;
    private byte[] zzhrr;

    public zzdua(zzgt zzgt, File file, File file2, File file3) {
        this.zzhrn = zzgt;
        this.zzhro = file;
        this.zzhrp = file3;
        this.zzhrq = file2;
    }

    public final boolean zza() {
        return System.currentTimeMillis() / 1000 > this.zzhrn.zzdi();
    }

    public final zzgt zzaxz() {
        return this.zzhrn;
    }

    public final File zzaya() {
        return this.zzhro;
    }

    public final File zzayb() {
        return this.zzhrp;
    }

    public final byte[] zzayc() {
        if (this.zzhrr == null) {
            this.zzhrr = zzduc.zzf(this.zzhrq);
        }
        byte[] bArr = this.zzhrr;
        if (bArr == null) {
            return null;
        }
        return Arrays.copyOf(bArr, bArr.length);
    }

    public final boolean zzff(long j) {
        return this.zzhrn.zzdi() - (System.currentTimeMillis() / 1000) < 3600;
    }
}
