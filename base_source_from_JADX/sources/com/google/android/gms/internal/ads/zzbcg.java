package com.google.android.gms.internal.ads;

final /* synthetic */ class zzbcg implements zzom {
    private final byte[] zzdvw;
    private final zzom zzenp;

    zzbcg(zzom zzom, byte[] bArr) {
        this.zzenp = zzom;
        this.zzdvw = bArr;
    }

    public final zzon zzip() {
        zzom zzom = this.zzenp;
        byte[] bArr = this.zzdvw;
        return new zzbcn(new zzok(bArr), bArr.length, zzom.zzip());
    }
}
