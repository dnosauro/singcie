package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

final /* synthetic */ class zzcer implements zzdvm {
    static final zzdvm zzdza = new zzcer();

    private zzcer() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzadv zzadv : (List) obj) {
            if (zzadv != null) {
                arrayList.add(zzadv);
            }
        }
        return arrayList;
    }
}
