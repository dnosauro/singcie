package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.HashMap;
import java.util.concurrent.Executor;

public final class zzcpk implements zzepf<zzcou> {
    private final zzeps<Context> zzevi;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzaty> zzgoo;
    private final zzeps<zzbjl> zzgop;
    private final zzeps<zzatz> zzgoq;
    private final zzeps<HashMap<String, zzcpf>> zzgor;

    private zzcpk(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzaty> zzeps3, zzeps<zzbjl> zzeps4, zzeps<zzatz> zzeps5, zzeps<HashMap<String, zzcpf>> zzeps6) {
        this.zzevi = zzeps;
        this.zzftl = zzeps2;
        this.zzgoo = zzeps3;
        this.zzgop = zzeps4;
        this.zzgoq = zzeps5;
        this.zzgor = zzeps6;
    }

    public static zzcpk zzb(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzaty> zzeps3, zzeps<zzbjl> zzeps4, zzeps<zzatz> zzeps5, zzeps<HashMap<String, zzcpf>> zzeps6) {
        return new zzcpk(zzeps, zzeps2, zzeps3, zzeps4, zzeps5, zzeps6);
    }

    public final /* synthetic */ Object get() {
        return new zzcou(this.zzevi.get(), this.zzftl.get(), this.zzgoo.get(), this.zzgop.get(), this.zzgoq.get(), this.zzgor.get());
    }
}
