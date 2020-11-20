package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzrs implements Comparator<zzry> {
    zzrs(zzrt zzrt) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzry zzry = (zzry) obj;
        zzry zzry2 = (zzry) obj2;
        int i = zzry.zzbts - zzry2.zzbts;
        return i != 0 ? i : (int) (zzry.value - zzry2.value);
    }
}
