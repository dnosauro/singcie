package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;

public final class zzdrz {
    private final Executor executor;
    private final zzaze zzhpc;

    public zzdrz(Executor executor2, zzaze zzaze) {
        this.executor = executor2;
        this.zzhpc = zzaze;
    }

    public final void zzeo(String str) {
        this.executor.execute(new zzdsc(this, str));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzgw(String str) {
        this.zzhpc.zzeo(str);
    }

    public final void zzj(List<String> list) {
        for (String zzeo : list) {
            zzeo(zzeo);
        }
    }
}
