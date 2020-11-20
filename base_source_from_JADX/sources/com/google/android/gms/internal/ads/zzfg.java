package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzfg extends zzcu<Integer, Long> {
    public Long zzzo;
    public Long zzzp;
    public Long zzzq;
    public Long zzzr;
    public Long zzzs;
    public Long zzzt;
    public Long zzzu;
    public Long zzzv;
    public Long zzzw;
    public Long zzzx;
    public Long zzzy;

    public zzfg() {
    }

    public zzfg(String str) {
        zzam(str);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zzzo = (Long) zzan.get(0);
            this.zzzp = (Long) zzan.get(1);
            this.zzzq = (Long) zzan.get(2);
            this.zzzr = (Long) zzan.get(3);
            this.zzzs = (Long) zzan.get(4);
            this.zzzt = (Long) zzan.get(5);
            this.zzzu = (Long) zzan.get(6);
            this.zzzv = (Long) zzan.get(7);
            this.zzzw = (Long) zzan.get(8);
            this.zzzx = (Long) zzan.get(9);
            this.zzzy = (Long) zzan.get(10);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Long> zzbn() {
        HashMap<Integer, Long> hashMap = new HashMap<>();
        hashMap.put(0, this.zzzo);
        hashMap.put(1, this.zzzp);
        hashMap.put(2, this.zzzq);
        hashMap.put(3, this.zzzr);
        hashMap.put(4, this.zzzs);
        hashMap.put(5, this.zzzt);
        hashMap.put(6, this.zzzu);
        hashMap.put(7, this.zzzv);
        hashMap.put(8, this.zzzw);
        hashMap.put(9, this.zzzx);
        hashMap.put(10, this.zzzy);
        return hashMap;
    }
}
