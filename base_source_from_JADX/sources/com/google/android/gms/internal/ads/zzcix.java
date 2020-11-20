package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzue;

public final class zzcix implements zzepf<zzts> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzue.zza.C3719zza> zzfrr;
    private final zzeps<String> zzfxb;
    private final zzeps<zzazh> zzfxq;
    private final zzeps<String> zzgjf;

    private zzcix(zzeps<Context> zzeps, zzeps<String> zzeps2, zzeps<zzazh> zzeps3, zzeps<zzue.zza.C3719zza> zzeps4, zzeps<String> zzeps5) {
        this.zzevi = zzeps;
        this.zzfxb = zzeps2;
        this.zzfxq = zzeps3;
        this.zzfrr = zzeps4;
        this.zzgjf = zzeps5;
    }

    public static zzcix zze(zzeps<Context> zzeps, zzeps<String> zzeps2, zzeps<zzazh> zzeps3, zzeps<zzue.zza.C3719zza> zzeps4, zzeps<String> zzeps5) {
        return new zzcix(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        String str = this.zzfxb.get();
        zzazh zzazh = this.zzfxq.get();
        zzue.zza.C3719zza zza = this.zzfrr.get();
        String str2 = this.zzgjf.get();
        zzts zzts = new zzts(new zztx(this.zzevi.get()));
        zzts.zza((zztv) new zzciy(zza, str, (zzue.zzu) ((zzekh) zzue.zzu.zzox().zzcq(zzazh.zzegl).zzcr(zzazh.zzegm).zzcs(zzazh.zzegn ? 0 : 2).zzbhv()), str2));
        return (zzts) zzepl.zza(zzts, "Cannot return null from a non-@Nullable @Provides method");
    }
}
