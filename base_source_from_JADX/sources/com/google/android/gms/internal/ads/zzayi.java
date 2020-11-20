package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zza;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;

final class zzayi extends zza {
    private final /* synthetic */ zzayg zzebf;

    zzayi(zzayg zzayg) {
        this.zzebf = zzayg;
    }

    public final void zzvm() {
        zzabj zzabj = new zzabj(this.zzebf.context, this.zzebf.zzbpd.zzbrf);
        synchronized (this.zzebf.lock) {
            try {
                zzp.zzkz();
                zzabk.zza(this.zzebf.zzeas, zzabj);
            } catch (IllegalArgumentException e) {
                zzd.zzd("Cannot config CSI reporter.", e);
            }
        }
    }
}
