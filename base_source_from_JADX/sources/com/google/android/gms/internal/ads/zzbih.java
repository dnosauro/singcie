package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzbih implements zzdmp {
    private final /* synthetic */ zzbhg zzexw;
    private Context zzflf;
    private String zzflg;

    private zzbih(zzbhg zzbhg) {
        this.zzexw = zzbhg;
    }

    public final zzdmm zzahn() {
        zzepl.zza(this.zzflf, Context.class);
        return new zzbig(this.zzexw, this.zzflf, this.zzflg);
    }

    public final /* synthetic */ zzdmp zzcb(Context context) {
        this.zzflf = (Context) zzepl.checkNotNull(context);
        return this;
    }

    public final /* synthetic */ zzdmp zzft(String str) {
        this.zzflg = str;
        return this;
    }
}
