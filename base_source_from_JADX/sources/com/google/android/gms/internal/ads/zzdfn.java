package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Callable;

final /* synthetic */ class zzdfn implements Callable {
    private final Object zzdko;
    private final List zzhat;

    zzdfn(List list, Object obj) {
        this.zzhat = list;
        this.zzdko = obj;
    }

    public final Object call() {
        List<zzdyz> list = this.zzhat;
        Object obj = this.zzdko;
        for (zzdyz zzdyz : list) {
            zzdfj zzdfj = (zzdfj) zzdyz.get();
            if (zzdfj != null) {
                zzdfj.zzs(obj);
            }
        }
        return obj;
    }
}
