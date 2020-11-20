package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzew extends zzcu<Integer, Object> {
    public Long zzyn;
    public Boolean zzyo;
    public Boolean zzyp;

    public zzew() {
    }

    public zzew(String str) {
        zzam(str);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzyn = (Long) zzan.get(0);
            this.zzyo = (Boolean) zzan.get(1);
            this.zzyp = (Boolean) zzan.get(2);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzbn() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyn);
        hashMap.put(1, this.zzyo);
        hashMap.put(2, this.zzyp);
        return hashMap;
    }
}
