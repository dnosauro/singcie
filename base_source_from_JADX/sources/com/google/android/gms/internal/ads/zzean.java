package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;

public final class zzean<PrimitiveT, KeyProtoT extends zzels, PublicKeyProtoT extends zzels> extends zzeac<PrimitiveT, KeyProtoT> implements zzdzz<PrimitiveT> {
    private final zzeaq<KeyProtoT, PublicKeyProtoT> zzhyw;
    private final zzeae<PublicKeyProtoT> zzhyx;

    public zzean(zzeaq<KeyProtoT, PublicKeyProtoT> zzeaq, zzeae<PublicKeyProtoT> zzeae, Class<PrimitiveT> cls) {
        super(zzeaq, cls);
        this.zzhyw = zzeaq;
        this.zzhyx = zzeae;
    }
}
