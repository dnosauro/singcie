package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Set;

public final class zzddu implements zzepf<zzdds> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdzc> zzgyf;
    private final zzeps<Set<String>> zzgyp;

    private zzddu(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2, zzeps<Set<String>> zzeps3) {
        this.zzgyf = zzeps;
        this.zzevi = zzeps2;
        this.zzgyp = zzeps3;
    }

    public static zzddu zzu(zzeps<zzdzc> zzeps, zzeps<Context> zzeps2, zzeps<Set<String>> zzeps3) {
        return new zzddu(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return new zzdds(this.zzgyf.get(), this.zzevi.get(), this.zzgyp.get());
    }
}
