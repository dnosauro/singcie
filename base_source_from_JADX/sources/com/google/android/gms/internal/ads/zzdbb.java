package com.google.android.gms.internal.ads;

import java.util.ArrayList;

final /* synthetic */ class zzdbb implements zzdvm {
    static final zzdvm zzdza = new zzdbb();

    private zzdbb() {
    }

    public final Object apply(Object obj) {
        ArrayList arrayList = (ArrayList) obj;
        if (arrayList.isEmpty()) {
            return null;
        }
        return new zzdba(arrayList);
    }
}
