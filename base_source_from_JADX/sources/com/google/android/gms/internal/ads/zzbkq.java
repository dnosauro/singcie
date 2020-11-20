package com.google.android.gms.internal.ads;

import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzbkq implements zzepf<Set<zzbxy<zzbsp>>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbki> zzfrk;
    private final zzeps<JSONObject> zzfrl;

    private zzbkq(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
        this.zzfrl = zzeps3;
    }

    public static zzbkq zzd(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        return new zzbkq(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfrl.get() == null ? Collections.emptySet() : Collections.singleton(new zzbxy(this.zzfrk.get(), this.zzevg.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
