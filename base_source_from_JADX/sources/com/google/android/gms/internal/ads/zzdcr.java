package com.google.android.gms.internal.ads;

import android.content.Context;

public final class zzdcr implements zzepf<zzdcn> {
    private final zzeps<zzdzc> zzevg;
    private final zzeps<Context> zzfwi;

    private zzdcr(zzeps<Context> zzeps, zzeps<zzdzc> zzeps2) {
        this.zzfwi = zzeps;
        this.zzevg = zzeps2;
    }

    public static zzdcn zza(Context context, zzdzc zzdzc) {
        return new zzdcn(context, zzdzc);
    }

    public static zzdcr zzbb(zzeps<Context> zzeps, zzeps<zzdzc> zzeps2) {
        return new zzdcr(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return zza(this.zzfwi.get(), this.zzevg.get());
    }
}
