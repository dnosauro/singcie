package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcps implements zzepf<zzcpp> {
    private final zzeps<Context> zzevi;

    private zzcps(zzeps<Context> zzeps) {
        this.zzevi = zzeps;
    }

    public static zzcps zzae(zzeps<Context> zzeps) {
        return new zzcps(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzcpp(this.zzevi.get());
    }
}
