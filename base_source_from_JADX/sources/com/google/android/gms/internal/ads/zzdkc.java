package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbre;
import javax.annotation.concurrent.GuardedBy;

public final class zzdkc<RequestComponentT extends zzbre<AdT>, AdT> implements zzdkl<RequestComponentT, AdT> {
    @GuardedBy("this")
    private RequestComponentT zzhes;
    private final zzdkl<RequestComponentT, AdT> zzhff;

    public zzdkc(zzdkl<RequestComponentT, AdT> zzdkl) {
        this.zzhff = zzdkl;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzatz */
    public final synchronized RequestComponentT zzaty() {
        return this.zzhes;
    }

    public final synchronized zzdyz<AdT> zza(zzdkm zzdkm, zzdkn<RequestComponentT> zzdkn) {
        if (zzdkm.zzhfj != null) {
            this.zzhes = (zzbre) zzdkn.zzc(zzdkm.zzhfk).zzafp();
            return this.zzhes.zzagh().zzb(zzdkm.zzhfj);
        }
        zzdyz<AdT> zza = this.zzhff.zza(zzdkm, zzdkn);
        this.zzhes = (zzbre) this.zzhff.zzaty();
        return zza;
    }
}
