package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

public final class zzcuu implements zzcrh<zzchc, zzdoe, zzcst> {
    private final Context context;
    private final Executor zzfqx;
    private final zzchf zzgth;

    public zzcuu(Context context2, Executor executor, zzchf zzchf) {
        this.context = context2;
        this.zzfqx = executor;
        this.zzgth = zzchf;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcst> zzcrb) {
        try {
            zzdnn zzdnn = zzdnj.zzhij.zzfvl;
            if (zzdnn.zzhiv.zzhia == zzdnf.zzhie) {
                ((zzdoe) zzcrb.zzdmo).zzc(this.context, zzdnn.zzhio, zzdmu.zzhha.toString(), (zzano) zzcrb.zzgqp);
            } else {
                ((zzdoe) zzcrb.zzdmo).zzb(this.context, zzdnn.zzhio, zzdmu.zzhha.toString(), (zzano) zzcrb.zzgqp);
            }
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcrb.zzchy);
            zzd.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzche zza = this.zzgth.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzchd(new zzcut(zzcrb)));
        zza.zzafq().zza(new zzbjt((zzdoe) zzcrb.zzdmo), this.zzfqx);
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzahs());
        return zza.zzahq();
    }
}
