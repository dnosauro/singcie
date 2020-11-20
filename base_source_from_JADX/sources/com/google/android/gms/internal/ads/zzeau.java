package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeap;
import java.security.GeneralSecurityException;
import java.util.Set;

final class zzeau implements zzeap.zza {
    private final /* synthetic */ zzeaq zzhzh;
    private final /* synthetic */ zzeae zzhzi;

    zzeau(zzeaq zzeaq, zzeae zzeae) {
        this.zzhzh = zzeaq;
        this.zzhzi = zzeae;
    }

    public final Set<Class<?>> zzazw() {
        return this.zzhzh.zzazw();
    }

    public final <Q> zzdzz<Q> zzb(Class<Q> cls) {
        try {
            return new zzean(this.zzhzh, this.zzhzi, cls);
        } catch (IllegalArgumentException e) {
            throw new GeneralSecurityException("Primitive type not supported", e);
        }
    }

    public final zzdzz<?> zzbaf() {
        zzeaq zzeaq = this.zzhzh;
        return new zzean(zzeaq, this.zzhzi, zzeaq.zzazx());
    }

    public final Class<?> zzbag() {
        return this.zzhzh.getClass();
    }

    public final Class<?> zzbah() {
        return this.zzhzi.getClass();
    }
}
