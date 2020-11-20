package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.ArrayList;

final /* synthetic */ class zzdba implements zzdfj {
    private final ArrayList zzgyq;

    zzdba(ArrayList arrayList) {
        this.zzgyq = arrayList;
    }

    public final void zzs(Object obj) {
        ((Bundle) obj).putStringArrayList("android_permissions", this.zzgyq);
    }
}
