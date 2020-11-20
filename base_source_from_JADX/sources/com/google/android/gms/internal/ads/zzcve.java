package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcve implements zzcqz<zzchc> {
    private final Context context;
    private final zzazh zzbos;
    private final Executor zzfqx;
    private final zzdnn zzfvl;
    private final zzchp zzgey;
    private final zzchf zzgth;

    public zzcve(Context context2, zzazh zzazh, zzdnn zzdnn, Executor executor, zzchf zzchf, zzchp zzchp) {
        this.context = context2;
        this.zzfvl = zzdnn;
        this.zzgth = zzchf;
        this.zzfqx = executor;
        this.zzbos = zzazh;
        this.zzgey = zzchp;
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return (zzdmu.zzhgx == null || zzdmu.zzhgx.zzdrp == null) ? false : true;
    }

    public final zzdyz<zzchc> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzcif zzcif = new zzcif();
        zzdyz<zzchc> zzb = zzdyr.zzb(zzdyr.zzag(null), new zzcvd(this, zzdmu, zzdnj, zzcif), this.zzfqx);
        zzcif.getClass();
        zzb.addListener(zzcvg.zza(zzcif), this.zzfqx);
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzc(zzdmu zzdmu, zzdnj zzdnj, zzcif zzcif, Object obj) {
        zzdyz<?> zzdyz;
        zzdmu zzdmu2 = zzdmu;
        zzdnj zzdnj2 = zzdnj;
        zzbdv zza = this.zzgey.zza(this.zzfvl.zzbpe, zzdmu2, zzdnj2.zzhik.zzerj, zzdmu2.zzerh);
        zza.zzaw(zzdmu2.zzdvo);
        zzcif.zzc(this.context, zza.getView());
        zzazq zzazq = new zzazq();
        zzchf zzchf = this.zzgth;
        zzbos zzbos2 = new zzbos(zzdnj2, zzdmu2, (String) null);
        zzcvk zzcvk = r1;
        zzcvk zzcvk2 = new zzcvk(this.context, this.zzgey, this.zzfvl, this.zzbos, zzdmu, zzazq, zza);
        zzche zza2 = zzchf.zza(zzbos2, new zzchd(zzcvk, zza));
        zzazq.set(zza2);
        zzaig.zza(zza, (zzaij) zza2.zzahr());
        zza2.zzaft().zza(new zzcvf(zza), zzazj.zzegu);
        zza2.zzagr().zzb(zza, true);
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue() || !zzdmu2.zzerh) {
            zza2.zzagr();
            zzdyz = zzchr.zza(zza, zzdmu2.zzhgx.zzdrn, zzdmu2.zzhgx.zzdrp);
        } else {
            zzdyz = zzdyr.zzag(null);
        }
        return zzdyr.zzb(zzdyz, new zzcvi(this, zza, zzdmu2, zza2), this.zzfqx);
    }
}
