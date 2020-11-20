package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeap;
import java.security.GeneralSecurityException;
import java.util.Set;

final class zzear implements zzeap.zza {
    private final /* synthetic */ zzeae zzhze;

    zzear(zzeae zzeae) {
        this.zzhze = zzeae;
    }

    public final Set<Class<?>> zzazw() {
        return this.zzhze.zzazw();
    }

    public final <Q> zzdzz<Q> zzb(Class<Q> cls) {
        try {
            return new zzeac(this.zzhze, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzdzz<?> zzbaf() {
        zzeae zzeae = this.zzhze;
        return new zzeac(zzeae, zzeae.zzazx());
    }

    public final Class<?> zzbag() {
        return this.zzhze.getClass();
    }

    public final Class<?> zzbah() {
        return null;
    }
}
