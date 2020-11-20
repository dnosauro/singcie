package com.google.android.gms.tasks;

import java.util.concurrent.Executor;

public final class zzv {
    private static final zzw zza;
    private static zzw zzb;

    static {
        zzw zzw = zzx.zza;
        zza = zzw;
        zzb = zzw;
    }

    public static Executor zza(Executor executor) {
        return zzb.zza(executor);
    }

    static final /* synthetic */ Executor zzb(Executor executor) {
        return executor;
    }
}
