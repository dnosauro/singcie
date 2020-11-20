package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Set;

public final class zzbtx implements zzepf<zzbtr> {
    private final zzeps<Set<zzbxy<zzp>>> zzftr;

    private zzbtx(zzeps<Set<zzbxy<zzp>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbtx zzo(zzeps<Set<zzbxy<zzp>>> zzeps) {
        return new zzbtx(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbtr(this.zzftr.get());
    }
}
