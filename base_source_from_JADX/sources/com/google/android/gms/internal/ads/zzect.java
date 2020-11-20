package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.spec.SecretKeySpec;

final class zzect extends zzeag<zzeak, zzefc> {
    zzect(Class cls) {
        super(cls);
    }

    public final /* synthetic */ Object zzah(Object obj) {
        zzefc zzefc = (zzefc) obj;
        zzefa zzbdc = zzefc.zzbcw().zzbdc();
        SecretKeySpec secretKeySpec = new SecretKeySpec(zzefc.zzbam().toByteArray(), "HMAC");
        int zzbar = zzefc.zzbcw().zzbar();
        switch (zzecv.zziao[zzbdc.ordinal()]) {
            case 1:
                return new zzehy(new zzehw("HMACSHA1", secretKeySpec), zzbar);
            case 2:
                return new zzehy(new zzehw("HMACSHA256", secretKeySpec), zzbar);
            case 3:
                return new zzehy(new zzehw("HMACSHA512", secretKeySpec), zzbar);
            default:
                throw new GeneralSecurityException("unknown hash");
        }
    }
}
