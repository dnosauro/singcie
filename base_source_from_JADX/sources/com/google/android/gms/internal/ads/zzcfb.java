package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.List;

final /* synthetic */ class zzcfb implements zzdvm {
    static final zzdvm zzdza = new zzcfb();

    private zzcfb() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = new ArrayList();
        for (zzcfd zzcfd : (List) obj) {
            if (zzcfd != null) {
                arrayList.add(zzcfd);
            }
        }
        return arrayList;
    }
}
