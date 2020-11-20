package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import javax.annotation.concurrent.GuardedBy;

public final class zzbxx extends zzbwk<zzqu> implements zzqu {
    private final Context context;
    private final zzdmu zzeri;
    @GuardedBy("this")
    private Map<View, zzqq> zzfzk = new WeakHashMap(1);

    public zzbxx(Context context2, Set<zzbxy<zzqu>> set, zzdmu zzdmu) {
        super(set);
        this.context = context2;
        this.zzeri = zzdmu;
    }

    public final synchronized void zza(zzqv zzqv) {
        zza(new zzbya(zzqv));
    }

    public final synchronized void zzv(View view) {
        zzqq zzqq = this.zzfzk.get(view);
        if (zzqq == null) {
            zzqq = new zzqq(this.context, view);
            zzqq.zza((zzqu) this);
            this.zzfzk.put(view, zzqq);
        }
        if (this.zzeri != null && this.zzeri.zzdvp) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcpw)).booleanValue()) {
                zzqq.zzen(((Long) zzwq.zzqe().zzd(zzabf.zzcpv)).longValue());
                return;
            }
        }
        zzqq.zzls();
    }

    public final synchronized void zzw(View view) {
        if (this.zzfzk.containsKey(view)) {
            this.zzfzk.get(view).zzb(this);
            this.zzfzk.remove(view);
        }
    }
}
