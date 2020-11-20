package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzfp extends zzgl {
    public zzfp(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 5);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        this.zzaay.zzf(-1);
        this.zzaay.zzg(-1);
        int[] iArr = (int[]) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext()});
        synchronized (this.zzaay) {
            this.zzaay.zzf((long) iArr[0]);
            this.zzaay.zzg((long) iArr[1]);
            if (iArr[2] != Integer.MIN_VALUE) {
                this.zzaay.zzaf((long) iArr[2]);
            }
        }
    }
}
