package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcuv implements zzcrh<zzchc, zzapo, zzcst> {
    private final Context context;
    private final zzchf zzgth;

    public zzcuv(Context context2, zzchf zzchf) {
        this.context = context2;
        this.zzgth = zzchf;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzapo, zzcst> zzcrb) {
        try {
            ((zzapo) zzcrb.zzdmo).zzdn(zzdmu.zzdnt);
            if (zzdnj.zzhij.zzfvl.zzhiv.zzhia == zzdnf.zzhie) {
                ((zzapo) zzcrb.zzdmo).zzb(zzdmu.zzetp, zzdmu.zzhha.toString(), zzdnj.zzhij.zzfvl.zzhio, ObjectWrapper.wrap(this.context), new zzcux(this, zzcrb), (zzano) zzcrb.zzgqp);
            } else {
                ((zzapo) zzcrb.zzdmo).zza(zzdmu.zzetp, zzdmu.zzhha.toString(), zzdnj.zzhij.zzfvl.zzhio, ObjectWrapper.wrap(this.context), (zzapn) new zzcux(this, zzcrb), (zzano) zzcrb.zzgqp);
            }
        } catch (RemoteException e) {
            zzd.zza("Remote exception loading a rewarded RTB ad", e);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzctd zzctd = new zzctd(zzdmu, (zzapo) zzcrb.zzdmo, true);
        zzche zza = this.zzgth.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzchd(zzctd));
        zzctd.zza(zza.zzaft());
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzaht());
        return zza.zzahq();
    }
}
