package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzgg extends zzgl {
    public zzgg(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 51);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        synchronized (this.zzaay) {
            zzex zzex = new zzex((String) this.zzabi.invoke((Object) null, new Object[0]));
            this.zzaay.zzac(zzex.zzyq.longValue());
            this.zzaay.zzad(zzex.zzyr.longValue());
        }
    }
}
