package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzex extends zzcu<Integer, Long> {
    public Long zzyq;
    public Long zzyr;

    public zzex() {
    }

    public zzex(String str) {
        zzam(str);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzyq = (Long) zzan.get(0);
            this.zzyr = (Long) zzan.get(1);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzyq);
        hashMap.put(1, this.zzyr);
        return hashMap;
    }
}
