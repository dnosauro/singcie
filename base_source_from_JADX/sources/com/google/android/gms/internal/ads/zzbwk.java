package com.google.android.gms.internal.ads;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public class zzbwk<ListenerT> {
    @GuardedBy("this")
    private final Map<ListenerT, Executor> zzfyq = new HashMap();

    protected zzbwk(Set<zzbxy<ListenerT>> set) {
        zzb(set);
    }

    private final synchronized void zzb(Set<zzbxy<ListenerT>> set) {
        for (zzbxy<ListenerT> zza : set) {
            zza(zza);
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void zza(zzbwm<ListenerT> zzbwm) {
        for (Map.Entry next : this.zzfyq.entrySet()) {
            ((Executor) next.getValue()).execute(new zzbwn(zzbwm, next.getKey()));
        }
    }

    public final synchronized void zza(zzbxy<ListenerT> zzbxy) {
        zza(zzbxy.zzfzl, zzbxy.executor);
    }

    public final synchronized void zza(ListenerT listenert, Executor executor) {
        this.zzfyq.put(listenert, executor);
    }
}
