package com.google.android.gms.internal.ads;

import java.util.concurrent.TimeUnit;

public final class zzczt implements zzepf<zzdyz<zzczx>> {
    private final zzeps<zzdro> zzftw;
    private final zzeps<zzczs> zzgxw;
    private final zzeps<zzbqz> zzgxx;

    public zzczt(zzeps<zzdro> zzeps, zzeps<zzczs> zzeps2, zzeps<zzbqz> zzeps3) {
        this.zzftw = zzeps;
        this.zzgxw = zzeps2;
        this.zzgxx = zzeps3;
    }

    public final /* synthetic */ Object get() {
        return (zzdyz) zzepl.zza(this.zzftw.get().zza(zzdrl.GENERATE_SIGNALS, this.zzgxx.get().zzakr()).zza(this.zzgxw.get()).zza((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS).zzaww(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
