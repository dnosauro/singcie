package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

final /* synthetic */ class zzdap implements zzdfj {
    private final ArrayList zzgyq;

    zzdap(ArrayList arrayList) {
        this.zzgyq = arrayList;
    }

    public final void zzs(Object obj) {
        ((Bundle) obj).putStringArrayList("ad_types", this.zzgyq);
    }
}
