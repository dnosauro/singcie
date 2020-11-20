package com.google.android.gms.internal.ads;

import java.util.AbstractMap;
import java.util.Map;

final class zzdxb extends zzdwm<Map.Entry<K, V>> {
    private final /* synthetic */ zzdwy zzhvn;

    zzdxb(zzdwy zzdwy) {
        this.zzhvn = zzdwy;
    }

    public final /* synthetic */ Object get(int i) {
        zzdvv.zzt(i, this.zzhvn.size);
        int i2 = i * 2;
        return new AbstractMap.SimpleImmutableEntry(this.zzhvn.zzhvj[i2], this.zzhvn.zzhvj[i2 + 1]);
    }

    public final int size() {
        return this.zzhvn.size;
    }

    public final boolean zzayu() {
        return true;
    }
}
