package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcsf implements zzcrh<zzbme, zzapo, zzcst> {
    private final Context context;
    /* access modifiers changed from: private */
    public View view;
    private final zzbna zzgrj;

    public zzcsf(Context context2, zzbna zzbna) {
        this.context = context2;
        this.zzgrj = zzbna;
    }

    static final /* synthetic */ zzys zza(zzcrb zzcrb) {
        try {
            return ((zzapo) zzcrb.zzdmo).getVideoController();
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzapo, zzcst> zzcrb) {
        try {
            ((zzapo) zzcrb.zzdmo).zzdn(zzdmu.zzdnt);
            ((zzapo) zzcrb.zzdmo).zza(zzdmu.zzetp, zzdmu.zzhha.toString(), zzdnj.zzhij.zzfvl.zzhio, ObjectWrapper.wrap(this.context), new zzcsk(this, zzcrb), (zzano) zzcrb.zzgqp, zzdnj.zzhij.zzfvl.zzbpe);
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        zzbmd zza = this.zzgrj.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzbmh(this.view, (zzbdv) null, new zzcsi(zzcrb), zzdmu.zzhgz.get(0)));
        zza.zzahd().zzv(this.view);
        ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafw());
        return zza.zzahc();
    }
}
