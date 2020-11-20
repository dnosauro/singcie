package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzag;
import java.util.concurrent.Executor;

public final class zzcrw implements zzcqz<zzbme> {
    private final Context context;
    private final Executor zzfqx;
    private final zzdnn zzfvl;
    private final zzchp zzgey;
    private final zzbna zzgrj;
    private final zzdvm<zzdmu, zzag> zzgrk;

    public zzcrw(zzbna zzbna, Context context2, Executor executor, zzchp zzchp, zzdnn zzdnn, zzdvm<zzdmu, zzag> zzdvm) {
        this.context = context2;
        this.zzgrj = zzbna;
        this.zzfqx = executor;
        this.zzgey = zzchp;
        this.zzfvl = zzdnn;
        this.zzgrk = zzdvm;
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return (zzdmu.zzhgx == null || zzdmu.zzhgx.zzdrp == null) ? false : true;
    }

    public final zzdyz<zzbme> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        return zzdyr.zzb(zzdyr.zzag(null), new zzcrv(this, zzdnj, zzdmu), this.zzfqx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzb(zzdnj zzdnj, zzdmu zzdmu, Object obj) {
        zzvn zzb = zzdns.zzb(this.context, zzdmu.zzhgz);
        zzbdv zza = this.zzgey.zza(zzb, zzdmu, zzdnj.zzhik.zzerj, zzdmu.zzerh);
        zza.zzaw(zzdmu.zzdvo);
        View zzcig = (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcye)).booleanValue() || !zzdmu.zzhho) ? new zzcig(this.context, zza.getView(), this.zzgrk.apply(zzdmu)) : zzbns.zza(this.context, zza.getView(), zzdmu);
        zzbna zzbna = this.zzgrj;
        zzbos zzbos = new zzbos(zzdnj, zzdmu, (String) null);
        zza.getClass();
        zzbmd zza2 = zzbna.zza(zzbos, new zzbmh(zzcig, zza, zzcry.zzp(zza), zzdns.zzg(zzb)));
        zza2.zzagr().zzb(zza, false);
        zza2.zzaft().zza(new zzcrx(zza), zzazj.zzegu);
        zza2.zzagr();
        zzdyz<?> zza3 = zzchr.zza(zza, zzdmu.zzhgx.zzdrn, zzdmu.zzhgx.zzdrp);
        if (zzdmu.zzdxi) {
            zza.getClass();
            zza3.addListener(zzcsa.zzh(zza), this.zzfqx);
        }
        zza3.addListener(new zzcrz(this, zza), this.zzfqx);
        return zzdyr.zzb(zza3, new zzcsc(zza2), (Executor) zzazj.zzegu);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(zzbdv zzbdv) {
        zzbdv.zzacm();
        zzbep zzaah = zzbdv.zzaah();
        if (this.zzfvl.zzhin != null && zzaah != null) {
            zzaah.zzb(this.zzfvl.zzhin);
        }
    }
}
