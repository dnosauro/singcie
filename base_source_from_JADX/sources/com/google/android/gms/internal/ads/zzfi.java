package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzfi extends zzcu<Integer, Long> {
    public Long zzaak;
    public Long zzaal;
    public Long zzaam;
    public Long zzaan;

    public zzfi() {
    }

    public zzfi(String str) {
        zzam(str);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzaak = (Long) zzan.get(0);
            this.zzaal = (Long) zzan.get(1);
            this.zzaam = (Long) zzan.get(2);
            this.zzaan = (Long) zzan.get(3);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzaak);
        hashMap.put(1, this.zzaal);
        hashMap.put(2, this.zzaam);
        hashMap.put(3, this.zzaan);
        return hashMap;
    }
}
