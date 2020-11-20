package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;

public final class zzcwu implements zzcwo<zzbyx> {
    private final Context context;
    private final zzbzx zzgrt;

    public zzcwu(Context context2, zzbzx zzbzx) {
        this.context = context2;
        this.zzgrt = zzbzx;
    }

    public final /* synthetic */ Object zza(zzdnj zzdnj, zzdmu zzdmu, View view, zzcwr zzcwr) {
        zzbyz zza = this.zzgrt.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzcww(this, zzcwt.zzguz));
        zzcwr.zza(new zzcwv(this, zza));
        return zza.zzahh();
    }
}
