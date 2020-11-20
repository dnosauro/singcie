package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import com.google.android.gms.internal.ads.zzefr;
import com.google.android.gms.internal.ads.zzefs;
import java.nio.charset.Charset;
import java.security.GeneralSecurityException;

final class zzeaw {
    private static final Charset UTF_8 = Charset.forName("UTF-8");

    public static zzefs zzb(zzefr zzefr) {
        zzefs.zza zzfl = zzefs.zzbea().zzfl(zzefr.zzbds());
        for (zzefr.zza next : zzefr.zzbdt()) {
            zzfl.zzb((zzefs.zzb) ((zzekh) zzefs.zzb.zzbec().zzhp(next.zzbdx().zzbdf()).zza(next.zzbab()).zza(next.zzbac()).zzfm(next.zzbdy()).zzbhv()));
        }
        return (zzefs) ((zzekh) zzfl.zzbhv());
    }

    public static void zzc(zzefr zzefr) {
        int zzbds = zzefr.zzbds();
        int i = 0;
        boolean z = false;
        boolean z2 = true;
        for (zzefr.zza next : zzefr.zzbdt()) {
            if (next.zzbab() == zzefl.ENABLED) {
                if (!next.zzbdw()) {
                    throw new GeneralSecurityException(String.format("key %d has no key data", new Object[]{Integer.valueOf(next.zzbdy())}));
                } else if (next.zzbac() == zzegd.UNKNOWN_PREFIX) {
                    throw new GeneralSecurityException(String.format("key %d has unknown prefix", new Object[]{Integer.valueOf(next.zzbdy())}));
                } else if (next.zzbab() != zzefl.UNKNOWN_STATUS) {
                    if (next.zzbdy() == zzbds) {
                        if (!z) {
                            z = true;
                        } else {
                            throw new GeneralSecurityException("keyset contains multiple primary keys");
                        }
                    }
                    if (next.zzbdx().zzbdh() != zzefh.zzb.ASYMMETRIC_PUBLIC) {
                        z2 = false;
                    }
                    i++;
                } else {
                    throw new GeneralSecurityException(String.format("key %d has unknown status", new Object[]{Integer.valueOf(next.zzbdy())}));
                }
            }
        }
        if (i == 0) {
            throw new GeneralSecurityException("keyset must contain at least one ENABLED key");
        } else if (!z && !z2) {
            throw new GeneralSecurityException("keyset doesn't contain a valid primary key");
        }
    }
}
