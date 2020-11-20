package com.google.android.gms.internal.ads;

public final class zzoj {
    public final zznq zzbhu;
    public final zzoe zzbhv;
    public final Object zzbhw;
    public final zzia[] zzbhx;

    public zzoj(zznq zznq, zzoe zzoe, Object obj, zzia[] zziaArr) {
        this.zzbhu = zznq;
        this.zzbhv = zzoe;
        this.zzbhw = obj;
        this.zzbhx = zziaArr;
    }

    public final boolean zza(zzoj zzoj, int i) {
        return zzoj != null && zzpt.zza(this.zzbhv.zzbe(i), zzoj.zzbhv.zzbe(i)) && zzpt.zza(this.zzbhx[i], zzoj.zzbhx[i]);
    }
}
