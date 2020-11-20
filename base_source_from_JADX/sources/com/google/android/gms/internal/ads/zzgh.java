package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzgh extends zzgl {
    public zzgh(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 48);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        zzcf.zza.C3704zza zza;
        zzcn zzcn;
        this.zzaay.zza(zzcn.ENUM_FAILURE);
        boolean booleanValue = ((Boolean) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext()})).booleanValue();
        synchronized (this.zzaay) {
            if (booleanValue) {
                zza = this.zzaay;
                zzcn = zzcn.ENUM_TRUE;
            } else {
                zza = this.zzaay;
                zzcn = zzcn.ENUM_FALSE;
            }
            zza.zza(zzcn);
        }
    }
}
