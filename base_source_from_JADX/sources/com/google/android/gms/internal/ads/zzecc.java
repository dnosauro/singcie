package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

public final class zzecc extends zzeaq<zzeer, zzeeu> {
    private static final byte[] zziaj = new byte[0];

    zzecc() {
        super(zzeer.class, zzeeu.class, new zzecf(zzdzx.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.EciesAeadHkdfPrivateKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.ASYMMETRIC_PRIVATE;
    }

    public final zzead<zzeen, zzeer> zzazy() {
        return new zzece(this, zzeen.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zzeer zzeer = (zzeer) zzels;
        if (!zzeer.zzbam().isEmpty()) {
            zzeic.zzz(zzeer.getVersion(), 0);
            zzeco.zza(zzeer.zzbcj().zzbcc());
            return;
        }
        throw new GeneralSecurityException("invalid ECIES private key");
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzeer.zzr(zzeiu, zzeju.zzbhe());
    }
}
