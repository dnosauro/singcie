package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.internal.ads.zzbw;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzdsi {
    private static volatile zzbw.zza.zzc zzhps = zzbw.zza.zzc.UNKNOWN;
    private final Context context;
    private final Executor executor;
    private final Task<zztx> zzhpr;

    private zzdsi(Context context2, Executor executor2, Task<zztx> task) {
        this.context = context2;
        this.executor = executor2;
        this.zzhpr = task;
    }

    public static zzdsi zza(Context context2, Executor executor2) {
        return new zzdsi(context2, executor2, Tasks.call(executor2, new zzdsh(context2)));
    }

    private final Task<Boolean> zza(int i, long j, Exception exc, String str, Map<String, String> map, String str2) {
        zzbw.zza.C3701zza zzc = zzbw.zza.zzs().zzj(this.context.getPackageName()).zzc(j);
        zzc.zza(zzhps);
        if (exc != null) {
            zzc.zzk(zzdwe.zza(exc)).zzl(exc.getClass().getName());
        }
        if (str2 != null) {
            zzc.zzm(str2);
        }
        if (str != null) {
            zzc.zzn(str);
        }
        return this.zzhpr.continueWith(this.executor, new zzdsk(zzc, i));
    }

    static final /* synthetic */ Boolean zza(zzbw.zza.C3701zza zza, int i, Task task) {
        boolean z;
        if (task.isSuccessful()) {
            zzub zzf = ((zztx) task.getResult()).zzf(((zzbw.zza) ((zzekh) zza.zzbhv())).toByteArray());
            zzf.zzbv(i);
            zzf.log();
            z = true;
        } else {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    static void zzb(zzbw.zza.zzc zzc) {
        zzhps = zzc;
    }

    static final /* synthetic */ zztx zzcl(Context context2) {
        return new zztx(context2, "GLAS", (String) null);
    }

    public final Task<Boolean> zza(int i, long j, Exception exc) {
        return zza(i, j, exc, (String) null, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zza(int i, long j, String str, Map<String, String> map) {
        return zza(i, j, (Exception) null, str, (Map<String, String>) null, (String) null);
    }

    public final Task<Boolean> zzb(int i, long j, String str) {
        return zza(i, j, (Exception) null, (String) null, (Map<String, String>) null, str);
    }

    public final Task<Boolean> zzg(int i, String str) {
        return zza(i, 0, (Exception) null, (String) null, (Map<String, String>) null, str);
    }

    public final Task<Boolean> zzh(int i, long j) {
        return zza(i, j, (Exception) null, (String) null, (Map<String, String>) null, (String) null);
    }
}
