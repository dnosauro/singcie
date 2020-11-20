package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzbhc implements zzepf<zzatz> {
    private final zzeps<Context> zzevi;

    public zzbhc(zzeps<Context> zzeps) {
        this.zzevi = zzeps;
    }

    public final /* synthetic */ Object get() {
        Context context = this.zzevi.get();
        return (zzatz) zzepl.zza(new zzatx(context, new zzaua(context).zzvs()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
