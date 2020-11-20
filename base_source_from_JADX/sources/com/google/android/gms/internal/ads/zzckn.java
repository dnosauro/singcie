package com.google.android.gms.internal.ads;

public final class zzckn implements zzepf<zzcko> {
    private final zzeps<zzckv> zzewc;
    private final zzeps<zzayq> zzfca;

    private zzckn(zzeps<zzckv> zzeps, zzeps<zzayq> zzeps2) {
        this.zzewc = zzeps;
        this.zzfca = zzeps2;
    }

    public static zzckn zzao(zzeps<zzckv> zzeps, zzeps<zzayq> zzeps2) {
        return new zzckn(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return new zzcko(this.zzewc.get(), this.zzfca.get());
    }
}
