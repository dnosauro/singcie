package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzbre;
import javax.annotation.concurrent.GuardedBy;

public final class zzdkd<RequestComponentT extends zzbre<AdT>, AdT> implements zzdkl<RequestComponentT, AdT> {
    @GuardedBy("this")
    private RequestComponentT zzhes;

    /* access modifiers changed from: private */
    /* renamed from: zzatz */
    public final synchronized RequestComponentT zzaty() {
        return this.zzhes;
    }

    public final synchronized zzdyz<AdT> zza(zzdkm zzdkm, zzdkn<RequestComponentT> zzdkn) {
        this.zzhes = (zzbre) zzdkn.zzc(zzdkm.zzhfk).zzafp();
        return this.zzhes.zzagh().zzakj();
    }
}
