package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public final class zzcil {
    @GuardedBy("this")
    private final Map<String, zzcim> zzgiw = new HashMap();

    zzcil() {
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzapo zzapo) {
        if (!this.zzgiw.containsKey(str)) {
            try {
                this.zzgiw.put(str, new zzcim(str, zzapo.zzul(), zzapo.zzum()));
            } catch (Throwable unused) {
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zza(String str, zzdoe zzdoe) {
        if (!this.zzgiw.containsKey(str)) {
            try {
                this.zzgiw.put(str, new zzcim(str, zzdoe.zzul(), zzdoe.zzum()));
            } catch (zzdnr unused) {
            }
        }
    }

    @Nullable
    public final synchronized zzcim zzgd(String str) {
        return this.zzgiw.get(str);
    }
}
