package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbrg;

public final class zzbrm implements zzepf<zzbrg.zza> {
    private final zzbrg zzfxl;

    private zzbrm(zzbrg zzbrg) {
        this.zzfxl = zzbrg;
    }

    public static zzbrm zzm(zzbrg zzbrg) {
        return new zzbrm(zzbrg);
    }

    public final /* synthetic */ Object get() {
        return (zzbrg.zza) zzepl.zza(this.zzfxl.zzaks(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
