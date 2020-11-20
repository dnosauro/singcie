package com.google.android.gms.internal.ads;

public final class zzq implements zzan {
    private int zzac;
    private int zzad;
    private final int zzae;
    private final float zzaf;

    public zzq() {
        this(2500, 1, 1.0f);
    }

    private zzq(int i, int i2, float f) {
        this.zzac = 2500;
        this.zzae = 1;
        this.zzaf = 1.0f;
    }

    public final void zza(zzao zzao) {
        boolean z = true;
        this.zzad++;
        int i = this.zzac;
        this.zzac = i + ((int) (((float) i) * this.zzaf));
        if (this.zzad > this.zzae) {
            z = false;
        }
        if (!z) {
            throw zzao;
        }
    }

    public final int zzb() {
        return this.zzac;
    }

    public final int zzc() {
        return this.zzad;
    }
}
