package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.TimeUnit;

public final class zzcmn implements zzepf<zzdyz<String>> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdro> zzftw;

    private zzcmn(zzeps<zzdro> zzeps, zzeps<Context> zzeps2) {
        this.zzftw = zzeps;
        this.zzevi = zzeps2;
    }

    public static zzcmn zzaq(zzeps<zzdro> zzeps, zzeps<Context> zzeps2) {
        return new zzcmn(zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzdyz) zzepl.zza(this.zzftw.get().zzu(zzdrl.WEBVIEW_COOKIE).zzc(new zzcmj(zzp.zzks().zzbh(this.zzevi.get()))).zza(1, TimeUnit.SECONDS).zza(Exception.class, zzcmm.zzgmk).zzaww(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
