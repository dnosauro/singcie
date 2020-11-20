package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Executor;

public final class zzcrp implements zzcqz<zzbll> {
    private final Context context;
    private final Executor zzfqx;
    private final zzchp zzgey;
    private final zzblg zzgrd;

    public zzcrp(zzblg zzblg, Context context2, Executor executor, zzchp zzchp) {
        this.context = context2;
        this.zzgrd = zzblg;
        this.zzfqx = executor;
        this.zzgey = zzchp;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzdnj zzdnj, zzdmu zzdmu, Object obj) {
        zzvn zzb = zzdns.zzb(this.context, zzdmu.zzhgz);
        zzbdv zza = this.zzgey.zza(zzb, zzdmu, zzdnj.zzhik.zzerj, zzdmu.zzerh);
        zzbky zza2 = this.zzgrd.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzbkx(zza.getView(), zza, zzdns.zzg(zzb), zzdmu.zzfsa, zzdmu.zzfsb, zzdmu.zzfsc));
        zza2.zzagr().zzb(zza, false);
        zza2.zzaft().zza(new zzcrr(zza), zzazj.zzegu);
        zza2.zzagr();
        return zzdyr.zzb(zzchr.zza(zza, zzdmu.zzhgx.zzdrn, zzdmu.zzhgx.zzdrp), new zzcru(zza2), (Executor) zzazj.zzegu);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return (zzdmu.zzhgx == null || zzdmu.zzhgx.zzdrp == null) ? false : true;
    }

    public final zzdyz<zzbll> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        return zzdyr.zzb(zzdyr.zzag(null), new zzcrs(this, zzdnj, zzdmu), this.zzfqx);
    }
}
