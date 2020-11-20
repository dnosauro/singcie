package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzge extends zzgl {
    private final boolean zzabe;

    public zzge(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 61);
        this.zzabe = zzfa.zzcf();
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        long longValue = ((Long) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext(), Boolean.valueOf(this.zzabe)})).longValue();
        synchronized (this.zzaay) {
            this.zzaay.zzah(longValue);
        }
    }
}
