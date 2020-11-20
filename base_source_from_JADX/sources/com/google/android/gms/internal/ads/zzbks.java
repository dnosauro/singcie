package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.overlay.zzp;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzbks implements zzepf<Set<zzbxy<zzp>>> {
    private final zzeps<Executor> zzevg;
    private final zzeps<zzbki> zzfrk;
    private final zzeps<JSONObject> zzfrl;

    private zzbks(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        this.zzfrk = zzeps;
        this.zzevg = zzeps2;
        this.zzfrl = zzeps3;
    }

    public static zzbks zze(zzeps<zzbki> zzeps, zzeps<Executor> zzeps2, zzeps<JSONObject> zzeps3) {
        return new zzbks(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return (Set) zzepl.zza(this.zzfrl.get() == null ? Collections.emptySet() : Collections.singleton(new zzbxy(this.zzfrk.get(), this.zzevg.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
