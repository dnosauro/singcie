package com.google.android.gms.ads.internal.util;

import java.util.ArrayList;
import java.util.List;

public final class zzay {
    /* access modifiers changed from: private */
    public final List<String> zzeep = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzeeq = new ArrayList();
    /* access modifiers changed from: private */
    public final List<Double> zzeer = new ArrayList();

    public final zzay zza(String str, double d, double d2) {
        int i = 0;
        while (i < this.zzeep.size()) {
            double doubleValue = this.zzeer.get(i).doubleValue();
            double doubleValue2 = this.zzeeq.get(i).doubleValue();
            if (d < doubleValue || (doubleValue == d && d2 < doubleValue2)) {
                break;
            }
            i++;
        }
        this.zzeep.add(i, str);
        this.zzeer.add(i, Double.valueOf(d));
        this.zzeeq.add(i, Double.valueOf(d2));
        return this;
    }

    public final zzat zzyv() {
        return new zzat(this);
    }
}
