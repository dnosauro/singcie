package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeap;
import java.util.Collections;
import java.util.Set;

final class zzeas implements zzeap.zza {
    private final /* synthetic */ zzdzz zzhzf;

    zzeas(zzdzz zzdzz) {
        this.zzhzf = zzdzz;
    }

    public final Set<Class<?>> zzazw() {
        return Collections.singleton(this.zzhzf.zzazr());
    }

    public final <Q> zzdzz<Q> zzb(Class<Q> cls) {
        if (this.zzhzf.zzazr().equals(cls)) {
            return this.zzhzf;
        }
        throw new InternalError("This should never be called, as we always first check supportedPrimitives.");
    }

    public final zzdzz<?> zzbaf() {
        return this.zzhzf;
    }

    public final Class<?> zzbag() {
        return this.zzhzf.getClass();
    }

    public final Class<?> zzbah() {
        return null;
    }
}
