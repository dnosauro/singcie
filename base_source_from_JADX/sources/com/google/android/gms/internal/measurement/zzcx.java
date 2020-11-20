package com.google.android.gms.internal.measurement;

import android.content.Context;
import android.database.ContentObserver;
import android.os.Handler;
import android.util.Log;
import androidx.core.content.C0545b;
import javax.annotation.Nullable;

final class zzcx implements zzcs {
    private static zzcx zza;
    @Nullable
    private final Context zzb;
    @Nullable
    private final ContentObserver zzc;

    private zzcx() {
        this.zzb = null;
        this.zzc = null;
    }

    private zzcx(Context context) {
        this.zzb = context;
        this.zzc = new zzcz(this, (Handler) null);
        context.getContentResolver().registerContentObserver(zzck.zza, true, this.zzc);
    }

    static zzcx zza(Context context) {
        zzcx zzcx;
        synchronized (zzcx.class) {
            if (zza == null) {
                zza = C0545b.m2165a(context, "com.google.android.providers.gsf.permission.READ_GSERVICES") == 0 ? new zzcx(context) : new zzcx();
            }
            zzcx = zza;
        }
        return zzcx;
    }

    static synchronized void zza() {
        synchronized (zzcx.class) {
            if (!(zza == null || zza.zzb == null || zza.zzc == null)) {
                zza.zzb.getContentResolver().unregisterContentObserver(zza.zzc);
            }
            zza = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: zzc */
    public final String zza(String str) {
        if (this.zzb == null) {
            return null;
        }
        try {
            return (String) zzcv.zza(new zzcw(this, str));
        } catch (IllegalStateException | SecurityException e) {
            String valueOf = String.valueOf(str);
            Log.e("GservicesLoader", valueOf.length() != 0 ? "Unable to read GServices for: ".concat(valueOf) : new String("Unable to read GServices for: "), e);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzb(String str) {
        return zzck.zza(this.zzb.getContentResolver(), str, (String) null);
    }
}
