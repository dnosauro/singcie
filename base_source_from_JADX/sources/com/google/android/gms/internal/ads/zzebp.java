package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

public final class zzebp extends zzeae<zzeeg> {
    zzebp() {
        super(zzeeg.class, new zzebo(zzdzt.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.ChaCha20Poly1305Key";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzeeh, zzeeg> zzazy() {
        return new zzebr(this, zzeeh.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zzeeg zzeeg = (zzeeg) zzels;
        zzeic.zzz(zzeeg.getVersion(), 0);
        if (zzeeg.zzbam().size() != 32) {
            throw new GeneralSecurityException("invalid ChaCha20Poly1305Key: incorrect key length");
        }
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzeeg.zzo(zzeiu, zzeju.zzbhe());
    }
}
