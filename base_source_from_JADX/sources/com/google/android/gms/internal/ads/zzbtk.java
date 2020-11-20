package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.reward.AdMetadataListener;
import java.util.Set;

public final class zzbtk implements zzepf<zzbti> {
    private final zzeps<Set<zzbxy<AdMetadataListener>>> zzftr;

    private zzbtk(zzeps<Set<zzbxy<AdMetadataListener>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbtk zzm(zzeps<Set<zzbxy<AdMetadataListener>>> zzeps) {
        return new zzbtk(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbti(this.zzftr.get());
    }
}
