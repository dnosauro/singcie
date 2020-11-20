package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;

public final class zzcav implements zzepf<Set<String>> {
    private final zzeps<zzccl> zzftk;

    public zzcav(zzeps<zzccl> zzeps) {
        this.zzftk = zzeps;
    }

    public static Set<String> zza(zzccl zzccl) {
        return (Set) zzepl.zza(zzccl.zzanu() != null ? Collections.singleton("banner") : Collections.emptySet(), "Cannot return null from a non-@Nullable @Provides method");
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzftk.get());
    }
}
