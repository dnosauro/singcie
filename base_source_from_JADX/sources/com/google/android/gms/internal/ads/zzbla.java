package com.google.android.gms.internal.ads;

import android.view.View;

public final class zzbla implements zzepf<View> {
    private final zzbkx zzfsd;

    public zzbla(zzbkx zzbkx) {
        this.zzfsd = zzbkx;
    }

    public static View zza(zzbkx zzbkx) {
        return (View) zzepl.zza(zzbkx.zzain(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfsd);
    }
}
