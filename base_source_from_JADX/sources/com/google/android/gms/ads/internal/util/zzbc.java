package com.google.android.gms.ads.internal.util;

import com.google.android.gms.internal.ads.zzai;
import com.google.android.gms.internal.ads.zzal;
import com.google.android.gms.internal.ads.zzayu;
import com.google.android.gms.internal.ads.zzbh;
import java.util.Map;

final class zzbc extends zzbh {
    private final /* synthetic */ byte[] zzeeu;
    private final /* synthetic */ Map zzeev;
    private final /* synthetic */ zzayu zzeew;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzbc(zzax zzax, int i, String str, zzal zzal, zzai zzai, byte[] bArr, Map map, zzayu zzayu) {
        super(i, str, zzal, zzai);
        this.zzeeu = bArr;
        this.zzeev = map;
        this.zzeew = zzayu;
    }

    public final Map<String, String> getHeaders() {
        Map<String, String> map = this.zzeev;
        return map == null ? super.getHeaders() : map;
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ void zza(Object obj) {
        zza((String) obj);
    }

    public final byte[] zzg() {
        byte[] bArr = this.zzeeu;
        return bArr == null ? super.zzg() : bArr;
    }

    /* access modifiers changed from: protected */
    public final void zzi(String str) {
        this.zzeew.zzev(str);
        super.zza(str);
    }
}
