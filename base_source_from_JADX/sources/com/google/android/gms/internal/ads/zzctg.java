package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzbl;
import java.util.concurrent.Executor;

public final class zzctg implements zzcrh<zzbyx, zzdoe, zzcst> {
    private final Context context;
    private final zzazh zzbos;
    private final Executor zzfqx;
    private final zzbzx zzgrt;

    public zzctg(Context context2, zzazh zzazh, zzbzx zzbzx, Executor executor) {
        this.context = context2;
        this.zzbos = zzazh;
        this.zzgrt = zzbzx;
        this.zzfqx = executor;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcst> zzcrb) {
        if (this.zzbos.zzegm < 4100000) {
            ((zzdoe) zzcrb.zzdmo).zza(this.context, zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString(), (zzano) zzcrb.zzgqp);
        } else {
            ((zzdoe) zzcrb.zzdmo).zza(this.context, zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString(), zzbk.zza((zzbl) zzdmu.zzhgx), (zzano) zzcrb.zzgqp);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzbyz zza = this.zzgrt.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzbzc(new zzctf(zzcrb)));
        zza.zzafq().zza(new zzbjt((zzdoe) zzcrb.zzdmo), this.zzfqx);
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafv());
        return zza.zzahh();
    }
}
