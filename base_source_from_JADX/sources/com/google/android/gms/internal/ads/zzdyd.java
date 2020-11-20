package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

final class zzdyd<V> extends zzdya<V, List<V>> {
    zzdyd(zzdwl<? extends zzdyz<? extends V>> zzdwl, boolean z) {
        super(zzdwl, true);
        zzazf();
    }

    public final /* synthetic */ Object zzk(List list) {
        ArrayList zzes = zzdwu.zzes(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            zzdyc zzdyc = (zzdyc) it.next();
            zzes.add(zzdyc != null ? zzdyc.value : null);
        }
        return Collections.unmodifiableList(zzes);
    }
}
