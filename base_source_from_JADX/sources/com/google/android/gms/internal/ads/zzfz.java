package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;

public final class zzfz extends zzgl {
    public zzfz(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 3);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        boolean booleanValue = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcrc)).booleanValue();
        zzej zzej = new zzej((String) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext(), Boolean.valueOf(booleanValue)}));
        synchronized (this.zzaay) {
            this.zzaay.zze(zzej.zzye);
            this.zzaay.zzag(zzej.zzyf);
        }
    }
}
