package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcmw implements zzepf<zzcns> {
    private final zzeps<Context> zzevi;

    private zzcmw(zzeps<Context> zzeps) {
        this.zzevi = zzeps;
    }

    public static zzcmw zzad(zzeps<Context> zzeps) {
        return new zzcmw(zzeps);
    }

    public static zzcns zzcj(Context context) {
        return (zzcns) zzepl.zza(new zzcns(context), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zzcj(this.zzevi.get());
    }
}
