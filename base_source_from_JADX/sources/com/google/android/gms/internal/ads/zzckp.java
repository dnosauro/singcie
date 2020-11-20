package com.google.android.gms.internal.ads;

import com.google.android.gms.common.util.VisibleForTesting;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class zzckp {
    private final Map<String, String> zzczw = new ConcurrentHashMap();
    private final /* synthetic */ zzckq zzgkh;

    @VisibleForTesting
    zzckp(zzckq zzckq) {
        this.zzgkh = zzckq;
    }

    /* access modifiers changed from: private */
    public final zzckp zzaqc() {
        this.zzczw.putAll(this.zzgkh.zzgki);
        return this;
    }

    public final zzckp zza(zzdmz zzdmz) {
        this.zzczw.put("gqi", zzdmz.zzbvf);
        return this;
    }

    public final void zzaqd() {
        this.zzgkh.executor.execute(new zzcks(this));
    }

    public final String zzaqe() {
        return this.zzgkh.zzgke.zzp(this.zzczw);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqf() {
        this.zzgkh.zzgke.zzo(this.zzczw);
    }

    public final zzckp zzc(zzdmu zzdmu) {
        this.zzczw.put("aai", zzdmu.zzdkx);
        return this;
    }

    public final zzckp zzr(String str, String str2) {
        this.zzczw.put(str, str2);
        return this;
    }
}
