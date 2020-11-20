package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzbl;
import com.google.android.gms.ads.zzb;
import java.util.concurrent.Executor;

public final class zzcse implements zzcrh<zzbme, zzdoe, zzcst> {
    private final Context context;
    private final zzazh zzbos;
    private final Executor zzfqx;
    private final zzbna zzgrj;

    public zzcse(Context context2, zzazh zzazh, zzbna zzbna, Executor executor) {
        this.context = context2;
        this.zzbos = zzazh;
        this.zzgrj = zzbna;
        this.zzfqx = executor;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcst> zzcrb) {
        zzvn zzvn = zzdnj.zzhij.zzfvl.zzbpe;
        zzvn zzvn2 = zzvn.zzchw ? new zzvn(this.context, zzb.zza(zzvn.width, zzvn.height)) : zzdns.zzb(this.context, zzdmu.zzhgz);
        if (this.zzbos.zzegm < 4100000) {
            ((zzdoe) zzcrb.zzdmo).zza(this.context, zzvn2, zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString(), (zzano) zzcrb.zzgqp);
        } else {
            ((zzdoe) zzcrb.zzdmo).zza(this.context, zzvn2, zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString(), zzbk.zza((zzbl) zzdmu.zzhgx), (zzano) zzcrb.zzgqp);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzbna zzbna = this.zzgrj;
        zzbos zzbos2 = new zzbos(zzdnj, zzdmu, zzcrb.zzchy);
        View view = ((zzdoe) zzcrb.zzdmo).getView();
        zzdoe zzdoe = (zzdoe) zzcrb.zzdmo;
        zzdoe.getClass();
        zzbmd zza = zzbna.zza(zzbos2, new zzbmh(view, (zzbdv) null, zzcsd.zza(zzdoe), zzdmu.zzhgz.get(0)));
        zza.zzahd().zzv(((zzdoe) zzcrb.zzdmo).getView());
        zza.zzafq().zza(new zzbjt((zzdoe) zzcrb.zzdmo), this.zzfqx);
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafv());
        return zza.zzahc();
    }
}
