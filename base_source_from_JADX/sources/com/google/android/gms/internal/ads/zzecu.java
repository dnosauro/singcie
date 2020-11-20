package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

public final class zzecu extends zzeae<zzefc> {
    public zzecu() {
        super(zzefc.class, new zzect(zzeak.class));
    }

    public static void zza(zzefc zzefc) {
        zzeic.zzz(zzefc.getVersion(), 0);
        if (zzefc.zzbam().size() >= 16) {
            zza(zzefc.zzbcw());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    /* access modifiers changed from: private */
    public static void zza(zzefg zzefg) {
        if (zzefg.zzbar() >= 10) {
            switch (zzecv.zziao[zzefg.zzbdc().ordinal()]) {
                case 1:
                    if (zzefg.zzbar() > 20) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                case 2:
                    if (zzefg.zzbar() > 32) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                case 3:
                    if (zzefg.zzbar() > 64) {
                        throw new GeneralSecurityException("tag size too big");
                    }
                    return;
                default:
                    throw new GeneralSecurityException("unknown hash type");
            }
        } else {
            throw new GeneralSecurityException("tag size too small");
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.HmacKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzefd, zzefc> zzazy() {
        return new zzecw(this, zzefd.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zza((zzefc) zzels);
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzefc.zzt(zzeiu, zzeju.zzbhe());
    }
}
