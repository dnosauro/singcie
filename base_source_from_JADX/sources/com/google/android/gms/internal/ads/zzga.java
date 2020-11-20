package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzga extends zzgl {
    private static final Object zzaax = new Object();
    private static volatile String zzabb;

    public zzga(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 1);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        this.zzaay.zzt("E");
        if (zzabb == null) {
            synchronized (zzaax) {
                if (zzabb == null) {
                    zzabb = (String) this.zzabi.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaay) {
            this.zzaay.zzt(zzabb);
        }
    }
}
