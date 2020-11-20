package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import java.util.Set;

public final class zzddd implements zzepf<zzddb> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdzc> zzgyf;
    private final zzeps<Set<String>> zzgyp;
    private final zzeps<ViewGroup> zzhad;

    private zzddd(zzeps<zzdzc> zzeps, zzeps<ViewGroup> zzeps2, zzeps<Context> zzeps3, zzeps<Set<String>> zzeps4) {
        this.zzgyf = zzeps;
        this.zzhad = zzeps2;
        this.zzevi = zzeps3;
        this.zzgyp = zzeps4;
    }

    public static zzddd zzi(zzeps<zzdzc> zzeps, zzeps<ViewGroup> zzeps2, zzeps<Context> zzeps3, zzeps<Set<String>> zzeps4) {
        return new zzddd(zzeps, zzeps2, zzeps3, zzeps4);
    }

    public final /* synthetic */ Object get() {
        return new zzddb(this.zzgyf.get(), this.zzhad.get(), this.zzevi.get(), this.zzgyp.get());
    }
}
