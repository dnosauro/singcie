package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

public final class zzcwe implements zzcqz<zzbme> {
    private final zzdro zzfvm;
    private final zzbna zzgrj;
    private final zzdzc zzguc;
    private final Context zzguj;
    private final zzacb zzguk;

    public zzcwe(Context context, zzbna zzbna, zzdro zzdro, zzdzc zzdzc, zzacb zzacb) {
        this.zzguj = context;
        this.zzgrj = zzbna;
        this.zzfvm = zzdro;
        this.zzguc = zzdzc;
        this.zzguk = zzacb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzabu zzabu) {
        this.zzguk.zza(zzabu);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return (this.zzguk == null || zzdmu.zzhgx == null || zzdmu.zzhgx.zzdrp == null) ? false : true;
    }

    public final zzdyz<zzbme> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        zzbmd zza = this.zzgrj.zza(new zzbos(zzdnj, zzdmu, (String) null), (zzbmh) new zzcwf(this, new View(this.zzguj), (zzbdv) null, zzcwd.zzgui, zzdmu.zzhgz.get(0)));
        return this.zzfvm.zzu(zzdrl.CUSTOM_RENDER_SYN).zza((zzdqy) new zzcwg(this, new zzabu(zza.zzahe(), zzdmu.zzhgx.zzdrn, zzdmu.zzhgx.zzdrp)), this.zzguc).zzw(zzdrl.CUSTOM_RENDER_ACK).zze(zzdyr.zzag(zza.zzahc())).zzaww();
    }
}
