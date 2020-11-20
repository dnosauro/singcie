package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzax;

public final class zzbja implements zzepf<zzax> {
    private final zzeps<Context> zzevi;

    public zzbja(zzeps<Context> zzeps) {
        this.zzevi = zzeps;
    }

    public final /* synthetic */ Object get() {
        return (zzax) zzepl.zza(new zzax(this.zzevi.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
