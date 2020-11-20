package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;

final class zzeab<KeyFormatProtoT extends zzels, KeyProtoT extends zzels> {
    private final zzead<KeyFormatProtoT, KeyProtoT> zzhyh;

    zzeab(zzead<KeyFormatProtoT, KeyProtoT> zzead) {
        this.zzhyh = zzead;
    }

    /* access modifiers changed from: package-private */
    public final KeyProtoT zzp(zzeiu zzeiu) {
        KeyFormatProtoT zzq = this.zzhyh.zzq(zzeiu);
        this.zzhyh.zzc(zzq);
        return (zzels) this.zzhyh.zzd(zzq);
    }
}
