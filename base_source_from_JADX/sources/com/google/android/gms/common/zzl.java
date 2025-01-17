package com.google.android.gms.common;

import android.util.Log;
import com.google.android.gms.common.util.AndroidUtilsLight;
import com.google.android.gms.common.util.Hex;
import java.util.concurrent.Callable;
import javax.annotation.CheckReturnValue;
import javax.annotation.Nullable;
import org.spongycastle.pqc.jcajce.spec.McElieceCCA2KeyGenParameterSpec;

@CheckReturnValue
class zzl {
    private static final zzl zzb = new zzl(true, (String) null, (Throwable) null);
    final boolean zza;
    @Nullable
    private final String zzc;
    @Nullable
    private final Throwable zzd;

    zzl(boolean z, @Nullable String str, @Nullable Throwable th) {
        this.zza = z;
        this.zzc = str;
        this.zzd = th;
    }

    static zzl zza() {
        return zzb;
    }

    static zzl zza(String str) {
        return new zzl(false, str, (Throwable) null);
    }

    static zzl zza(String str, Throwable th) {
        return new zzl(false, str, th);
    }

    static zzl zza(Callable<String> callable) {
        return new zzn(callable);
    }

    static String zza(String str, zzd zzd2, boolean z, boolean z2) {
        return String.format("%s: pkg=%s, sha1=%s, atk=%s, ver=%s", new Object[]{z2 ? "debug cert rejected" : "not whitelisted", str, Hex.bytesToStringLowercase(AndroidUtilsLight.zza(McElieceCCA2KeyGenParameterSpec.SHA1).digest(zzd2.zza())), Boolean.valueOf(z), "12451009.false"});
    }

    /* access modifiers changed from: package-private */
    @Nullable
    public String zzb() {
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final void zzc() {
        if (!this.zza && Log.isLoggable("GoogleCertificatesRslt", 3)) {
            if (this.zzd != null) {
                Log.d("GoogleCertificatesRslt", zzb(), this.zzd);
            } else {
                Log.d("GoogleCertificatesRslt", zzb());
            }
        }
    }
}
