package com.google.android.gms.internal.ads;

import java.util.Comparator;

final class zzeiw implements Comparator<zzeiu> {
    zzeiw() {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzeiu zzeiu = (zzeiu) obj;
        zzeiu zzeiu2 = (zzeiu) obj2;
        zzejd zzejd = (zzejd) zzeiu.iterator();
        zzejd zzejd2 = (zzejd) zzeiu2.iterator();
        while (zzejd.hasNext() && zzejd2.hasNext()) {
            int compare = Integer.compare(zzeiu.zzb(zzejd.nextByte()), zzeiu.zzb(zzejd2.nextByte()));
            if (compare != 0) {
                return compare;
            }
        }
        return Integer.compare(zzeiu.size(), zzeiu2.size());
    }
}
