package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzbu;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import java.util.concurrent.Executor;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzbed {
    public static zzbdv zza(Context context, zzbfn zzbfn, String str, boolean z, boolean z2, zzef zzef, zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
        zzabf.initialize(context);
        if (zzadm.zzddv.get().booleanValue()) {
            return zzbft.zza(context, zzbfn, str, z, z2, zzef, zzacg, zzazh, (zzabs) null, zzk, zzb, zzts, zzsu, z3, zzdmu, zzdmz);
        }
        try {
            return (zzbdv) zzbu.zza(new zzbef(context, zzbfn, str, z, z2, zzef, zzacg, zzazh, (zzabs) null, zzk, zzb, zzts, zzsu, z3, zzdmu, zzdmz));
        } catch (Throwable th) {
            throw new zzbeh("Webview initialization failed.", th);
        }
    }

    public static zzdyz<zzbdv> zza(Context context, zzazh zzazh, String str, zzef zzef, zzb zzb) {
        return zzdyr.zzb(zzdyr.zzag(null), new zzbec(context, zzef, zzazh, zzb, str), (Executor) zzazj.zzegt);
    }
}
