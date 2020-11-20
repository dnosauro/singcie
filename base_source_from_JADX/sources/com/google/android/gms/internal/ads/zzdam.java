package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Set;

final class zzdam implements zzdfi<zzdfj<Bundle>> {
    private final Set<String> zzgyn;

    zzdam(Set<String> set) {
        this.zzgyn = set;
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        ArrayList arrayList = new ArrayList();
        for (String add : this.zzgyn) {
            arrayList.add(add);
        }
        return zzdyr.zzag(new zzdap(arrayList));
    }
}
