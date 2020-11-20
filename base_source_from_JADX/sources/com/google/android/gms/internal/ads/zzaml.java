package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.common.util.VisibleForTesting;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzaml {
    @VisibleForTesting
    private static final zzau<zzako> zzdkb = new zzamk();
    @VisibleForTesting
    private static final zzau<zzako> zzdkc = new zzamn();
    private final zzalb zzdkd;

    public zzaml(Context context, zzazh zzazh, String str) {
        this.zzdkd = new zzalb(context, zzazh, str, zzdkb, zzdkc);
    }

    public final <I, O> zzamd<I, O> zza(String str, zzame<I> zzame, zzamf<O> zzamf) {
        return new zzamm(this.zzdkd, str, zzame, zzamf);
    }

    public final zzamq zzua() {
        return new zzamq(this.zzdkd);
    }
}
