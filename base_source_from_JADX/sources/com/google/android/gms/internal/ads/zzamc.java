package com.google.android.gms.internal.ads;

import android.content.Context;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
public final class zzamc {
    private final Object zzdju = new Object();
    private final Object zzdjv = new Object();
    @GuardedBy("lockClient")
    private zzaml zzdjw;
    @GuardedBy("lockService")
    private zzaml zzdjx;

    private static Context zzl(Context context) {
        Context applicationContext = context.getApplicationContext();
        return applicationContext == null ? context : applicationContext;
    }

    public final zzaml zza(Context context, zzazh zzazh) {
        zzaml zzaml;
        synchronized (this.zzdjv) {
            if (this.zzdjx == null) {
                this.zzdjx = new zzaml(zzl(context), zzazh, zzadj.zzddo.get());
            }
            zzaml = this.zzdjx;
        }
        return zzaml;
    }

    public final zzaml zzb(Context context, zzazh zzazh) {
        zzaml zzaml;
        synchronized (this.zzdju) {
            if (this.zzdjw == null) {
                this.zzdjw = new zzaml(zzl(context), zzazh, (String) zzwq.zzqe().zzd(zzabf.zzclr));
            }
            zzaml = this.zzdjw;
        }
        return zzaml;
    }
}
