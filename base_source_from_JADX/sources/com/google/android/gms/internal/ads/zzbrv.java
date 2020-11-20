package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbrv implements zzepf<zzbrt> {
    private final zzeps<Set<zzbxy<zzva>>> zzftr;

    private zzbrv(zzeps<Set<zzbxy<zzva>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbrv zzg(zzeps<Set<zzbxy<zzva>>> zzeps) {
        return new zzbrv(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbrt(this.zzftr.get());
    }
}
