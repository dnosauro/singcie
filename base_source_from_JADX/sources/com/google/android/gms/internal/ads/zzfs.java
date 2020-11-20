package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzfs extends zzgl {
    private static volatile Long zzaaw;
    private static final Object zzaax = new Object();

    public zzfs(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 44);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (zzaaw == null) {
            synchronized (zzaax) {
                if (zzaaw == null) {
                    zzaaw = (Long) this.zzabi.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaay) {
            this.zzaay.zzaa(zzaaw.longValue());
        }
    }
}
