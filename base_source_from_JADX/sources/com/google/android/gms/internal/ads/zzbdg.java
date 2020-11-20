package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

final class zzbdg {
    private final ArrayList<zzoq> zzeos = new ArrayList<>();
    private long zzeot;

    zzbdg() {
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzoq zzoq) {
        this.zzeos.add(zzoq);
    }

    /* access modifiers changed from: package-private */
    public final long zzabt() {
        Iterator<zzoq> it = this.zzeos.iterator();
        while (it.hasNext()) {
            Map<String, List<String>> responseHeaders = it.next().getResponseHeaders();
            if (responseHeaders != null) {
                for (Map.Entry next : responseHeaders.entrySet()) {
                    try {
                        if ("content-length".equalsIgnoreCase((String) next.getKey())) {
                            this.zzeot = Math.max(this.zzeot, Long.parseLong((String) ((List) next.getValue()).get(0)));
                        }
                    } catch (RuntimeException unused) {
                    }
                }
                it.remove();
            }
        }
        return this.zzeot;
    }
}
