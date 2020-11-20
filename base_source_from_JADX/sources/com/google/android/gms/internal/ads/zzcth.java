package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcth implements zzcrh<zzbyx, zzapo, zzcst> {
    private final Context context;
    private final zzbzx zzgrt;

    public zzcth(Context context2, zzbzx zzbzx) {
        this.context = context2;
        this.zzgrt = zzbzx;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzapo, zzcst> zzcrb) {
        try {
            ((zzapo) zzcrb.zzdmo).zzdn(zzdmu.zzdnt);
            ((zzapo) zzcrb.zzdmo).zza(zzdmu.zzetp, zzdmu.zzhha.toString(), zzdnj.zzhij.zzfvl.zzhio, ObjectWrapper.wrap(this.context), (zzaph) new zzctj(this, zzcrb), (zzano) zzcrb.zzgqp);
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzctd zzctd = new zzctd(zzdmu, (zzapo) zzcrb.zzdmo, false);
        zzbyz zza = this.zzgrt.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzbzc(zzctd));
        zzctd.zza(zza.zzaft());
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafw());
        return zza.zzahh();
    }
}
