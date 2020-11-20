package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzcty implements zzcrh<zzcbt, zzapo, zzcst> {
    private final Context context;
    private final zzcat zzgsh;
    /* access modifiers changed from: private */
    public zzaob zzgsq;

    public zzcty(Context context2, zzcat zzcat) {
        this.context = context2;
        this.zzgsh = zzcat;
    }

    public final void zza(zzdnj zzdnj, zzdmu zzdmu, zzcrb<zzapo, zzcst> zzcrb) {
        try {
            ((zzapo) zzcrb.zzdmo).zzdn(zzdmu.zzdnt);
            ((zzapo) zzcrb.zzdmo).zza(zzdmu.zzetp, zzdmu.zzhha.toString(), zzdnj.zzhij.zzfvl.zzhio, ObjectWrapper.wrap(this.context), (zzapi) new zzcua(this, zzcrb), (zzano) zzcrb.zzgqp);
        } catch (RemoteException e) {
            throw new zzdnr(e);
        }
    }

    public final /* synthetic */ Object zzb(zzdnj zzdnj, zzdmu zzdmu, zzcrb zzcrb) {
        if (zzdnj.zzhij.zzfvl.zzhiq.contains(Integer.toString(6))) {
            zzcce zzb = zzcce.zzb(this.zzgsq);
            if (zzdnj.zzhij.zzfvl.zzhiq.contains(Integer.toString(zzb.zzanc()))) {
                zzccf zza = this.zzgsh.zza(new zzbos(zzdnj, zzdmu, zzcrb.zzchy), new zzccq(zzb), new zzceb((zzanw) null, (zzanv) null, this.zzgsq));
                ((zzcst) zzcrb.zzgqp).zzb((zzano) zza.zzafw());
                return zza.zzafx();
            }
            throw new zzcuq(zzdok.INTERNAL_ERROR, "No corresponding native ad listener");
        }
        throw new zzcuq(zzdok.INVALID_REQUEST, "Unified must be used for RTB.");
    }
}
