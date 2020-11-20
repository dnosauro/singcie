package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdei implements zzepf<zzdeg> {
    private final zzeps<Context> zzevi;
    private final zzeps<String> zzfby;

    private zzdei(zzeps<Context> zzeps, zzeps<String> zzeps2) {
        this.zzevi = zzeps;
        this.zzfby = zzeps2;
    }

    public static zzdei zzbg(zzeps<Context> zzeps, zzeps<String> zzeps2) {
        return new zzdei(zzeps, zzeps2);
    }

    public static zzdeg zzs(Context context, String str) {
        return new zzdeg(context, str);
    }

    public final /* synthetic */ Object get() {
        return zzs(this.zzevi.get(), this.zzfby.get());
    }
}
