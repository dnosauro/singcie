package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzgf extends zzgl {
    private long zzaaj;
    private final zzfh zzwr;

    public zzgf(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2, zzfh zzfh) {
        super(zzfa, str, str2, zza, i, 53);
        this.zzwr = zzfh;
        if (zzfh != null) {
            this.zzaaj = zzfh.zzcu();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (this.zzwr != null) {
            this.zzaay.zzae(((Long) this.zzabi.invoke((Object) null, new Object[]{Long.valueOf(this.zzaaj)})).longValue());
        }
    }
}
