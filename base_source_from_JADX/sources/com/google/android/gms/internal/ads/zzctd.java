package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzctd implements zzcaf {
    private zzbsl zzfwm = null;
    private final zzdmu zzfwn;
    private final zzapo zzgsf;
    private final boolean zzgsg;

    zzctd(zzdmu zzdmu, zzapo zzapo, boolean z) {
        this.zzfwn = zzdmu;
        this.zzgsf = zzapo;
        this.zzgsg = z;
    }

    public final void zza(zzbsl zzbsl) {
        this.zzfwm = zzbsl;
    }

    public final void zza(boolean z, Context context) {
        try {
            if (!(this.zzgsg ? this.zzgsf.zzaa(ObjectWrapper.wrap(context)) : this.zzgsf.zzz(ObjectWrapper.wrap(context)))) {
                throw new zzcai("Adapter failed to show.");
            } else if (this.zzfwm != null) {
                if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcqh)).booleanValue() && this.zzfwn.zzhhj == 2) {
                    this.zzfwm.onAdImpression();
                }
            }
        } catch (Throwable th) {
            throw new zzcai(th);
        }
    }
}
