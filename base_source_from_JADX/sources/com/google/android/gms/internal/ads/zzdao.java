package com.google.android.gms.internal.ads;

import java.util.Set;

public final class zzdao implements zzepf<zzdam> {
    private final zzeps<Set<String>> zzgyp;

    private zzdao(zzeps<Set<String>> zzeps) {
        this.zzgyp = zzeps;
    }

    public static zzdao zzak(zzeps<Set<String>> zzeps) {
        return new zzdao(zzeps);
    }

    public static zzdam zzd(Set<String> set) {
        return new zzdam(set);
    }

    public final /* synthetic */ Object get() {
        return zzd(this.zzgyp.get());
    }
}
