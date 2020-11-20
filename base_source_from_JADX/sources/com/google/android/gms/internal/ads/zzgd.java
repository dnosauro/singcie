package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzgd extends zzgl {
    private final StackTraceElement[] zzabd;

    public zzgd(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2, StackTraceElement[] stackTraceElementArr) {
        super(zzfa, str, str2, zza, i, 45);
        this.zzabd = stackTraceElementArr;
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        if (this.zzabd != null) {
            zzew zzew = new zzew((String) this.zzabi.invoke((Object) null, new Object[]{this.zzabd}));
            synchronized (this.zzaay) {
                this.zzaay.zzab(zzew.zzyn.longValue());
                if (zzew.zzyo.booleanValue()) {
                    this.zzaay.zzc(zzew.zzyp.booleanValue() ? zzcn.ENUM_FALSE : zzcn.ENUM_TRUE);
                } else {
                    this.zzaay.zzc(zzcn.ENUM_FAILURE);
                }
            }
        }
    }
}
