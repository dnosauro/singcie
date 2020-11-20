package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

public final class zzebd extends zzeae<zzedm> {
    zzebd() {
        super(zzedm.class, new zzebc(zzehr.class));
    }

    public static void zza(zzedm zzedm) {
        zzeic.zzz(zzedm.getVersion(), 0);
        zzeic.zzft(zzedm.zzbam().size());
        zza(zzedm.zzbbb());
    }

    /* access modifiers changed from: private */
    public static void zza(zzedq zzedq) {
        if (zzedq.zzbbh() < 12 || zzedq.zzbbh() > 16) {
            throw new GeneralSecurityException("invalid IV size");
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzedn, zzedm> zzazy() {
        return new zzebf(this, zzedn.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zza((zzedm) zzels);
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzedm.zzg(zzeiu, zzeju.zzbhe());
    }
}
