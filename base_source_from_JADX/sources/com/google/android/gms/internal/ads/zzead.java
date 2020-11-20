package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;

public abstract class zzead<KeyFormatProtoT extends zzels, KeyT> {
    private final Class<KeyFormatProtoT> zzhyk;

    public zzead(Class<KeyFormatProtoT> cls) {
        this.zzhyk = cls;
    }

    public final Class<KeyFormatProtoT> zzazt() {
        return this.zzhyk;
    }

    public abstract void zzc(KeyFormatProtoT keyformatprotot);

    public abstract KeyT zzd(KeyFormatProtoT keyformatprotot);

    public abstract KeyFormatProtoT zzq(zzeiu zzeiu);
}
