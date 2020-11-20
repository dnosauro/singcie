package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

public final class zzcvo implements zzcrh<zzchc, zzdoe, zzcsw> {
    private final Context context;
    /* access modifiers changed from: private */
    public final Executor zzfqx;
    private final zzchf zzgth;

    public zzcvo(Context context2, Executor executor, zzchf zzchf) {
        this.context = context2;
        this.zzfqx = executor;
        this.zzgth = zzchf;
    }

    /* access modifiers changed from: private */
    public static void zzc(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcsw> zzcrb) {
        try {
            ((zzdoe) zzcrb.zzdmo).zza(zzdnj.zzhij.zzfvl.zzhio, zzdmu.zzhha.toString());
        } catch (Exception e) {
            String valueOf = String.valueOf(zzcrb.zzchy);
            zzd.zzd(valueOf.length() != 0 ? "Fail to load ad from adapter ".concat(valueOf) : new String("Fail to load ad from adapter "), e);
        }
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzdoe, zzcsw> zzcrb) {
        if (!((zzdoe) zzcrb.zzdmo).isInitialized()) {
            ((zzcsw) zzcrb.zzgqp).zza((zzbyl) new zzcvq(this, zzdnj, zzdmu, zzcrb));
            ((zzdoe) zzcrb.zzdmo).zza(this.context, zzdnj.zzhij.zzfvl.zzhio, (String) null, (zzauw) zzcrb.zzgqp, zzdmu.zzhha.toString());
            return;
        }
        zzc(zzdnj, zzdmu, zzcrb);
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzche zza = this.zzgth.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzchd(new zzcvn(zzcrb)));
        zza.zzafq().zza(new zzbjt((zzdoe) zzcrb.zzdmo), this.zzfqx);
        zzbsu zzafr = zza.zzafr();
        zzbrt zzafs = zza.zzafs();
        ((zzcsw) zzcrb.zzgqp).zza((zzauw) new zzcvs(this, zza.zzahi(), zzafs, zzafr, zza.zzahr()));
        return zza.zzahq();
    }
}
