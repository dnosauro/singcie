package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzbvw implements zzepf<zzbvv> {
    private final zzeps<Set<zzbxy<zzbvz>>> zzftr;

    private zzbvw(zzeps<Set<zzbxy<zzbvz>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbvw zzq(zzeps<Set<zzbxy<zzbvz>>> zzeps) {
        return new zzbvw(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbvv(this.zzftr.get());
    }
}
