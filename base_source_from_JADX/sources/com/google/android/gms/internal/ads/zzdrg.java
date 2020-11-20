package com.google.android.gms.internal.ads;

import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzdrg<O> {
    private final E zzhnm;
    private final String zzhnn;
    private final List<zzdyz<?>> zzhnr;
    final /* synthetic */ zzdra zzhns;
    private final zzdyz<?> zzhnv;
    private final zzdyz<O> zzhnw;

    private zzdrg(zzdra zzdra, E e, String str, zzdyz<?> zzdyz, List<zzdyz<?>> list, zzdyz<O> zzdyz2) {
        this.zzhns = zzdra;
        this.zzhnm = e;
        this.zzhnn = str;
        this.zzhnv = zzdyz;
        this.zzhnr = list;
        this.zzhnw = zzdyz2;
    }

    /* synthetic */ zzdrg(zzdra zzdra, Object obj, String str, zzdyz zzdyz, List list, zzdyz zzdyz2, zzdqz zzdqz) {
        this(zzdra, obj, (String) null, zzdyz, list, zzdyz2);
    }

    private final <O2> zzdrg<O2> zza(zzdyb<O, O2> zzdyb, Executor executor) {
        return new zzdrg(this.zzhns, this.zzhnm, this.zzhnn, this.zzhnv, this.zzhnr, zzdyr.zzb(this.zzhnw, zzdyb, executor));
    }

    public final zzdrg<O> zza(long j, TimeUnit timeUnit) {
        zzdra zzdra = this.zzhns;
        return new zzdrg(zzdra, this.zzhnm, this.zzhnn, this.zzhnv, this.zzhnr, zzdyr.zza(this.zzhnw, j, timeUnit, zzdra.zzfru));
    }

    public final <O2> zzdrg<O2> zza(zzdyb<O, O2> zzdyb) {
        return zza(zzdyb, (Executor) this.zzhns.zzggb);
    }

    public final <T extends Throwable> zzdrg<O> zza(Class<T> cls, zzdqv<T, O> zzdqv) {
        return zza(cls, new zzdrh(zzdqv));
    }

    public final <T extends Throwable> zzdrg<O> zza(Class<T> cls, zzdyb<T, O> zzdyb) {
        zzdra zzdra = this.zzhns;
        return new zzdrg(zzdra, this.zzhnm, this.zzhnn, this.zzhnv, this.zzhnr, zzdyr.zzb(this.zzhnw, cls, zzdyb, zzdra.zzggb));
    }

    public final zzdqx<E, O> zzaww() {
        E e = this.zzhnm;
        String str = this.zzhnn;
        if (str == null) {
            str = this.zzhns.zzv(e);
        }
        zzdqx<E, O> zzdqx = new zzdqx<>(e, str, this.zzhnw);
        this.zzhns.zzhnq.zza(zzdqx);
        this.zzhnv.addListener(new zzdrk(this, zzdqx), zzazj.zzegu);
        zzdyr.zza(zzdqx, new zzdrj(this, zzdqx), zzazj.zzegu);
        return zzdqx;
    }

    public final <O2> zzdrg<O2> zzb(zzdqv<O, O2> zzdqv) {
        return zza(new zzdrf(zzdqv));
    }

    public final <O2> zzdrg<O2> zze(zzdyz<O2> zzdyz) {
        return zza(new zzdri(zzdyz), (Executor) zzazj.zzegu);
    }

    public final zzdrg<O> zzgu(String str) {
        return new zzdrg(this.zzhns, this.zzhnm, str, this.zzhnv, this.zzhnr, this.zzhnw);
    }

    public final zzdrg<O> zzw(E e) {
        return this.zzhns.zza(e, zzaww());
    }
}
