package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbxv implements zzepf<zzbxu> {
    private final zzeps<Set<zzbxy<zzbxr>>> zzftr;

    private zzbxv(zzeps<Set<zzbxy<zzbxr>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbxv zzt(zzeps<Set<zzbxy<zzbxr>>> zzeps) {
        return new zzbxv(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbxu(this.zzftr.get());
    }
}
