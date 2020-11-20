package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzgi extends zzgl {
    private static final Object zzaax = new Object();
    private static volatile Long zzabf;

    public zzgi(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 33);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (zzabf == null) {
            synchronized (zzaax) {
                if (zzabf == null) {
                    zzabf = (Long) this.zzabi.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaay) {
            this.zzaay.zzs(zzabf.longValue());
        }
    }
}
