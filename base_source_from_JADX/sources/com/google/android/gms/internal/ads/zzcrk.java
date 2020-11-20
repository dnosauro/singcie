package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcrk implements zzcqz<zzblv> {
    private final Context context;
    private final zzazh zzbos;
    private final Executor zzfqx;
    private final zzdnn zzfvl;
    private final zzchp zzgey;
    private final zzblp zzgqz;

    public zzcrk(zzblp zzblp, Context context2, Executor executor, zzchp zzchp, zzdnn zzdnn, zzazh zzazh) {
        this.context = context2;
        this.zzgqz = zzblp;
        this.zzfqx = executor;
        this.zzgey = zzchp;
        this.zzfvl = zzdnn;
        this.zzbos = zzazh;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzdmu zzdmu, zzdnj zzdnj, zzcif zzcif, Object obj) {
        zzdyz<?> zzdyz;
        zzbdv zza = this.zzgey.zza(this.zzfvl.zzbpe, zzdmu, zzdnj.zzhik.zzerj, zzdmu.zzerh);
        zza.zzaw(zzdmu.zzdvo);
        zzcif.zzc(this.context, zza.getView());
        zzazq zzazq = new zzazq();
        zzbln zza2 = this.zzgqz.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzbzc(new zzcrq(this.context, this.zzbos, zzazq, zzdmu, zza, this.zzfvl), zza), new zzblq(zzdmu.zzfsa));
        zza2.zzagr().zzb(zza, false);
        zzazq.set(zza2);
        zza2.zzaft().zza(new zzcrl(zza), zzazj.zzegu);
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue() || !zzdmu.zzerh) {
            zza2.zzagr();
            zzdyz = zzchr.zza(zza, zzdmu.zzhgx.zzdrn, zzdmu.zzhgx.zzdrp);
        } else {
            zzdyz = zzdyr.zzag(null);
        }
        return zzdyr.zzb(zzdyz, new zzcro(this, zza, zzdmu, zza2), this.zzfqx);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return (zzdmu.zzhgx == null || zzdmu.zzhgx.zzdrp == null) ? false : true;
    }

    public final zzdyz<zzblv> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzcif zzcif = new zzcif();
        zzdyz<zzblv> zzb = zzdyr.zzb(zzdyr.zzag(null), new zzcrj(this, zzdmu, zzdnj, zzcif), this.zzfqx);
        zzcif.getClass();
        zzb.addListener(zzcrm.zza(zzcif), this.zzfqx);
        return zzb;
    }
}
