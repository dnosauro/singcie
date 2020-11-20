package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzcmo implements zzepf<zzdyz<String>> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzef> zzfql;
    private final zzeps<zzdzc> zzfwt;

    private zzcmo(zzeps<zzef> zzeps, zzeps<Context> zzeps2, zzeps<zzdzc> zzeps3) {
        this.zzfql = zzeps;
        this.zzevi = zzeps2;
        this.zzfwt = zzeps3;
    }

    public static zzcmo zzp(zzeps<zzef> zzeps, zzeps<Context> zzeps2, zzeps<zzdzc> zzeps3) {
        return new zzcmo(zzeps, zzeps2, zzeps3);
    }

    public final /* synthetic */ Object get() {
        return (zzdyz) zzepl.zza(this.zzfwt.get().zze(new zzcml(this.zzfql.get(), this.zzevi.get())), "Cannot return null from a non-@Nullable @Provides method");
    }
}
