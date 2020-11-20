package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import org.checkerframework.checker.nullness.compatqual.NullableDecl;

final class zzdkh implements zzdvm<zzcoh, zzdkj> {
    private final /* synthetic */ zzdkf zzhfi;

    zzdkh(zzdkf zzdkf) {
        this.zzhfi = zzdkf;
    }

    @NullableDecl
    public final /* synthetic */ Object apply(@NullableDecl Object obj) {
        zzaza.zzc("", (zzcoh) obj);
        zzd.zzee("Failed to get a cache key, reverting to legacy flow.");
        zzdkf zzdkf = this.zzhfi;
        zzdkj unused = zzdkf.zzhfh = new zzdkj((zzatl) null, zzdkf.zzaue(), (zzdkh) null);
        return this.zzhfi.zzhfh;
    }
}
