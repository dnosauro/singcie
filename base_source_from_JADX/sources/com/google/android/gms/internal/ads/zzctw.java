package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzbl;
import java.util.concurrent.Executor;

public final class zzctw implements zzcrh<zzcbt, zzdoe, zzcst> {
    private final Context context;
    private final Executor zzfqx;
    private final zzcat zzgsh;

    public zzctw(Context context2, zzcat zzcat, Executor executor) {
        this.context = context2;
        this.zzgsh = zzcat;
        this.zzfqx = executor;
    }

    private static boolean zza(zzdnj zzdnj, int i) {
        return zzdnj.zzhij.zzfvl.zzhiq.contains(Integer.toString(i));
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcst> zzcrb) {
        ((zzdoe) zzcrb.zzdmo).zza(this.context, zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString(), zzbk.zza((zzbl) zzdmu.zzhgx), (zzano) zzcrb.zzgqp, zzdnj.zzhij.zzfvl.zzdnh, zzdnj.zzhij.zzfvl.zzhiq);
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzcce zzcce;
        zzanv zzue = ((zzdoe) zzcrb.zzdmo).zzue();
        zzanw zzuf = ((zzdoe) zzcrb.zzdmo).zzuf();
        zzaob zzuk = ((zzdoe) zzcrb.zzdmo).zzuk();
        if (zzuk != null && zza(zzdnj, 6)) {
            zzcce = zzcce.zzb(zzuk);
        } else if (zzue != null && zza(zzdnj, 6)) {
            zzcce = zzcce.zzb(zzue);
        } else if (zzue != null && zza(zzdnj, 2)) {
            zzcce = zzcce.zza(zzue);
        } else if (zzuf != null && zza(zzdnj, 6)) {
            zzcce = zzcce.zzb(zzuf);
        } else if (zzuf == null || !zza(zzdnj, 1)) {
            throw new zzcuq(zzdok.INTERNAL_ERROR, "No native ad mappers");
        } else {
            zzcce = zzcce.zza(zzuf);
        }
        if (zzdnj.zzhij.zzfvl.zzhiq.contains(Integer.toString(zzcce.zzanc()))) {
            zzccf zza = this.zzgsh.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzccq(zzcce), new zzceb(zzuf, zzue, zzuk));
            ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafv());
            zza.zzafq().zza(new zzbjt((zzdoe) zzcrb.zzdmo), this.zzfqx);
            return zza.zzafx();
        }
        throw new zzcuq(zzdok.INTERNAL_ERROR, "No corresponding native ad listener");
    }
}
