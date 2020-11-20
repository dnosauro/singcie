package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.zzp;

public final class zzbqo implements zzbui {
    private final Context zzaaa;
    private final zzazh zzbos;
    private final zzf zzebt;
    private final zzclp zzfpa;
    private final zzdnn zzfvl;

    public zzbqo(Context context, zzdnn zzdnn, zzazh zzazh, zzf zzf, zzclp zzclp) {
        this.zzaaa = context;
        this.zzfvl = zzdnn;
        this.zzbos = zzazh;
        this.zzebt = zzf;
        this.zzfpa = zzclp;
    }

    public final void zzb(zzdnj zzdnj) {
    }

    public final void zzd(zzatl zzatl) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcsr)).booleanValue()) {
            zzp.zzky().zza(this.zzaaa, this.zzbos, this.zzfvl.zzhip, this.zzebt.zzxv());
        }
        this.zzfpa.zzaqm();
    }
}
