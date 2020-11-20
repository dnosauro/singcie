package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.GeneralSecurityException;

public final class zzecp extends zzeae<zzeda> {
    zzecp() {
        super(zzeda.class, new zzecs(zzeak.class));
    }

    /* access modifiers changed from: private */
    public static void zza(zzedf zzedf) {
        if (zzedf.zzbar() < 10) {
            throw new GeneralSecurityException("tag size too short");
        } else if (zzedf.zzbar() > 16) {
            throw new GeneralSecurityException("tag size too long");
        }
    }

    /* access modifiers changed from: private */
    public static void zzet(int i) {
        if (i != 32) {
            throw new GeneralSecurityException("AesCmacKey size wrong, must be 32 bytes");
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCmacKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzede, zzeda> zzazy() {
        return new zzecr(this, zzede.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zzeda zzeda = (zzeda) zzels;
        zzeic.zzz(zzeda.getVersion(), 0);
        zzet(zzeda.zzbam().size());
        zza(zzeda.zzban());
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzeda.zzc(zzeiu, zzeju.zzbhe());
    }
}
