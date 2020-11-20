package com.google.android.gms.internal.ads;

import java.util.HashMap;

public final class zzcy extends zzcu<Integer, Object> {
    public String zznt;
    public long zznu;
    public String zznv;
    public String zznw;
    public String zznx;

    public zzcy() {
        this.zznt = "E";
        this.zznu = -1;
        this.zznv = "E";
        this.zznw = "E";
        this.zznx = "E";
    }

    public zzcy(String str) {
        this();
        zzam(str);
    }

    /* access modifiers changed from: protected */
    public final void zzam(String str) {
        HashMap zzan = zzan(str);
        if (zzan != null) {
            this.zznt = zzan.get(0) == null ? "E" : (String) zzan.get(0);
            this.zznu = zzan.get(1) == null ? -1 : ((Long) zzan.get(1)).longValue();
            this.zznv = zzan.get(2) == null ? "E" : (String) zzan.get(2);
            this.zznw = zzan.get(3) == null ? "E" : (String) zzan.get(3);
            this.zznx = zzan.get(4) == null ? "E" : (String) zzan.get(4);
        }
    }

    /* access modifiers changed from: protected */
    public final HashMap<Integer, Object> zzbn() {
        HashMap<Integer, Object> hashMap = new HashMap<>();
        hashMap.put(0, this.zznt);
        hashMap.put(4, this.zznx);
        hashMap.put(3, this.zznw);
        hashMap.put(2, this.zznv);
        hashMap.put(1, Long.valueOf(this.zznu));
        return hashMap;
    }
}
