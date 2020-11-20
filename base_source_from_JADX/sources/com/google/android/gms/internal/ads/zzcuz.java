package com.google.android.gms.internal.ads;

public class zzcuz extends zzcwb {
    private zzbyi zzgti;

    public zzcuz(zzbrt zzbrt, zzbsl zzbsl, zzbsu zzbsu, zzbte zzbte, zzbsb zzbsb, zzbvy zzbvy, zzbyn zzbyn, zzbtr zzbtr, zzbyi zzbyi, zzbvv zzbvv) {
        super(zzbrt, zzbsl, zzbsu, zzbte, zzbvy, zzbtr, zzbyn, zzbvv, zzbsb);
        this.zzgti = zzbyi;
    }

    public final void onVideoEnd() {
        this.zzgti.zztm();
    }

    public final void zza(zzavc zzavc) {
        super.zza(zzavc);
        this.zzgti.zza(new zzava(zzavc.getType(), zzavc.getAmount()));
    }

    public final void zzb(zzava zzava) {
        super.zzb(zzava);
        this.zzgti.zza(zzava);
    }

    public final void zzun() {
        this.zzgti.zztl();
    }

    public final void zzuo() {
        this.zzgti.zztm();
    }
}
