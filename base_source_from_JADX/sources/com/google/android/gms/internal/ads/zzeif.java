package com.google.android.gms.internal.ads;

import java.lang.ref.Reference;
import java.lang.ref.ReferenceQueue;
import java.util.List;
import java.util.Vector;
import java.util.concurrent.ConcurrentHashMap;

final class zzeif {
    private final ConcurrentHashMap<zzeii, List<Throwable>> zziie = new ConcurrentHashMap<>(16, 0.75f, 10);
    private final ReferenceQueue<Throwable> zziif = new ReferenceQueue<>();

    zzeif() {
    }

    public final List<Throwable> zza(Throwable th, boolean z) {
        while (true) {
            Reference<? extends Throwable> poll = this.zziif.poll();
            if (poll == null) {
                break;
            }
            this.zziie.remove(poll);
        }
        List<Throwable> list = this.zziie.get(new zzeii(th, (ReferenceQueue<Throwable>) null));
        if (!z || list != null) {
            return list;
        }
        Vector vector = new Vector(2);
        List<Throwable> putIfAbsent = this.zziie.putIfAbsent(new zzeii(th, this.zziif), vector);
        return putIfAbsent == null ? vector : putIfAbsent;
    }
}
