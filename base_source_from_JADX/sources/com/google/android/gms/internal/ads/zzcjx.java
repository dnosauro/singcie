package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.Collections;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;

public final class zzcjx implements zzepf<Set<zzbxy<zzdru>>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<Context> zzevi;
    private final zzeps<String> zzgjr;
    private final zzeps<Map<zzdrl, zzckc>> zzgjs;

    public zzcjx(zzeps<String> zzeps, zzeps<Context> zzeps2, zzeps<Executor> zzeps3, zzeps<Map<zzdrl, zzckc>> zzeps4) {
        this.zzgjr = zzeps;
        this.zzevi = zzeps2;
        this.zzevg = zzeps3;
        this.zzgjs = zzeps4;
    }

    public final /* synthetic */ Object get() {
        Set set;
        String str = this.zzgjr.get();
        Context context = this.zzevi.get();
        Executor executor = this.zzevg.get();
        Map map = this.zzgjs.get();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcuc)).booleanValue()) {
            zzts zzts = new zzts(new zztx(context));
            zzts.zza((zztv) new zzcjz(str));
            set = Collections.singleton(new zzbxy(new zzcka(zzts, map), executor));
        } else {
            set = Collections.emptySet();
        }
        return (Set) zzepl.zza(set, "Cannot return null from a non-@Nullable @Provides method");
    }
}
