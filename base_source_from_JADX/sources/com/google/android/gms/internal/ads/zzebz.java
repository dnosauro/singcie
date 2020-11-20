package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

public final class zzebz extends zzeae<zzegg> {
    zzebz() {
        super(zzegg.class, new zzeby(zzdzt.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.XChaCha20Poly1305Key";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzegj, zzegg> zzazy() {
        return new zzecb(this, zzegj.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zzegg zzegg = (zzegg) zzels;
        zzeic.zzz(zzegg.getVersion(), 0);
        if (zzegg.zzbam().size() != 32) {
            throw new GeneralSecurityException("invalid XChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzegg.zzz(zzeiu, zzeju.zzbhe());
    }
}
