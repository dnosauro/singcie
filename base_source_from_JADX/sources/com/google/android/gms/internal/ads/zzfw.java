package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzfw extends zzgl {
    private static final Object zzaax = new Object();
    private static volatile Long zzaaz;

    public zzfw(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 22);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (zzaaz == null) {
            synchronized (zzaax) {
                if (zzaaz == null) {
                    zzaaz = (Long) this.zzabi.invoke((Object) null, new Object[0]);
                }
            }
        }
        synchronized (this.zzaay) {
            this.zzaay.zzo(zzaaz.longValue());
        }
    }
}
