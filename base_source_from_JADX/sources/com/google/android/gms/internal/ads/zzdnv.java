package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;

public final class zzdnv {
    private final zzcqo zzdgz;
    private final zzdmu zzeri;
    private final zzdmz zzerj;
    private final zzdrz zzfqa;

    @VisibleForTesting
    public zzdnv(zzcqo zzcqo, zzdrz zzdrz, zzdmu zzdmu, zzdmz zzdmz) {
        this.zzeri = zzdmu;
        this.zzerj = zzdmz;
        this.zzdgz = zzcqo;
        this.zzfqa = zzdrz;
    }

    private final void zzb(String str, int i) {
        if (!this.zzeri.zzhhq) {
            this.zzfqa.zzeo(str);
            return;
        }
        this.zzdgz.zza(new zzcqv(zzp.zzkx().currentTimeMillis(), this.zzerj.zzbvf, str, i));
    }

    /* JADX WARNING: type inference failed for: r3v0, types: [int, java.lang.Integer] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.util.List<java.lang.String> r2, java.lang.Integer r3) {
        /*
            r1 = this;
            java.util.Iterator r2 = r2.iterator()
        L_0x0004:
            boolean r0 = r2.hasNext()
            if (r0 == 0) goto L_0x0014
            java.lang.Object r0 = r2.next()
            java.lang.String r0 = (java.lang.String) r0
            r1.zzb(r0, r3)
            goto L_0x0004
        L_0x0014:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdnv.zza(java.util.List, int):void");
    }

    public final void zzi(List<String> list) {
        for (String zzb : list) {
            zzb(zzb, zzcql.zzgqc);
        }
    }
}
