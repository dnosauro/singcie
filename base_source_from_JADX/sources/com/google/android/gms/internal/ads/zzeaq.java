package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;

public abstract class zzeaq<KeyProtoT extends zzels, PublicKeyProtoT extends zzels> extends zzeae<KeyProtoT> {
    private final Class<PublicKeyProtoT> zzhzd;

    @SafeVarargs
    protected zzeaq(Class<KeyProtoT> cls, Class<PublicKeyProtoT> cls2, zzeag<?, KeyProtoT>... zzeagArr) {
        super(cls, zzeagArr);
        this.zzhzd = cls2;
    }
}
