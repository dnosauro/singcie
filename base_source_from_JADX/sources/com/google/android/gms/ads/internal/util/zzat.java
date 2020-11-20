package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

public final class zzat {
    private final String[] zzeee;
    private final double[] zzeef;
    private final double[] zzeeg;
    private final int[] zzeeh;
    private int zzeei;

    private zzat(zzay zzay) {
        int size = zzay.zzeeq.size();
        this.zzeee = (String[]) zzay.zzeep.toArray(new String[size]);
        this.zzeef = zzg(zzay.zzeeq);
        this.zzeeg = zzg(zzay.zzeer);
        this.zzeeh = new int[size];
        this.zzeei = 0;
    }

    private static double[] zzg(List<Double> list) {
        double[] dArr = new double[list.size()];
        for (int i = 0; i < dArr.length; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        return dArr;
    }

    public final void zza(double d) {
        this.zzeei++;
        int i = 0;
        while (true) {
            double[] dArr = this.zzeeg;
            if (i < dArr.length) {
                if (dArr[i] <= d && d < this.zzeef[i]) {
                    int[] iArr = this.zzeeh;
                    iArr[i] = iArr[i] + 1;
                }
                if (d >= this.zzeeg[i]) {
                    i++;
                } else {
                    return;
                }
            } else {
                return;
            }
        }
    }

    public final List<zzav> zzyu() {
        ArrayList arrayList = new ArrayList(this.zzeee.length);
        int i = 0;
        while (true) {
            String[] strArr = this.zzeee;
            if (i >= strArr.length) {
                return arrayList;
            }
            String str = strArr[i];
            double d = this.zzeeg[i];
            double d2 = this.zzeef[i];
            int[] iArr = this.zzeeh;
            arrayList.add(new zzav(str, d, d2, ((double) iArr[i]) / ((double) this.zzeei), iArr[i]));
            i++;
        }
    }
}
