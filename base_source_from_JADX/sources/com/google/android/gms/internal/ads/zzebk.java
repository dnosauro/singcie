package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;
import java.security.NoSuchAlgorithmException;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;

public final class zzebk extends zzeae<zzeec> {
    zzebk() {
        super(zzeec.class, new zzebn(zzdzt.class));
    }

    private static boolean zzbaj() {
        try {
            Cipher.getInstance("AES/GCM-SIV/NoPadding");
            return true;
        } catch (NoSuchAlgorithmException | NoSuchPaddingException unused) {
            return false;
        }
    }

    public static void zzbr(boolean z) {
        if (zzbaj()) {
            zzeap.zza(new zzebk(), true);
        }
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesGcmSivKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzeed, zzeec> zzazy() {
        return new zzebm(this, zzeed.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zzeec zzeec = (zzeec) zzels;
        zzeic.zzz(zzeec.getVersion(), 0);
        zzeic.zzft(zzeec.zzbam().size());
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzeec.zzm(zzeiu, zzeju.zzbhe());
    }
}
