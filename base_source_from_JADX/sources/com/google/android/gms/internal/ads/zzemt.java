package com.google.android.gms.internal.ads;

import java.util.Iterator;
import java.util.Map;

final class zzemt extends zzemz {
    private final /* synthetic */ zzems zzirr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzemt(zzems zzems) {
        super(zzems, (zzemr) null);
        this.zzirr = zzems;
    }

    /* synthetic */ zzemt(zzems zzems, zzemr zzemr) {
        this(zzems);
    }

    public final Iterator<Map.Entry<K, V>> iterator() {
        return new zzemu(this.zzirr, (zzemr) null);
    }
}
