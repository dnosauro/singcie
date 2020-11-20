package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzbhv implements zzdii {
    private final /* synthetic */ zzbhg zzexw;
    private Context zzflf;
    private String zzflg;

    private zzbhv(zzbhg zzbhg) {
        this.zzexw = zzbhg;
    }

    public final zzdij zzagw() {
        zzepl.zza(this.zzflf, Context.class);
        zzepl.zza(this.zzflg, String.class);
        return new zzbhu(this.zzexw, this.zzflf, this.zzflg);
    }

    public final /* synthetic */ zzdii zzbz(Context context) {
        this.zzflf = (Context) zzepl.checkNotNull(context);
        return this;
    }

    public final /* synthetic */ zzdii zzfr(String str) {
        this.zzflg = (String) zzepl.checkNotNull(str);
        return this;
    }
}
