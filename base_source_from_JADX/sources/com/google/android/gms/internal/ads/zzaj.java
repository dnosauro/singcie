package com.google.android.gms.internal.ads;

public final class zzaj<T> {
    public final T result;
    public final zzn zzbq;
    public final zzao zzbr;
    public boolean zzbs;

    private zzaj(zzao zzao) {
        this.zzbs = false;
        this.result = null;
        this.zzbq = null;
        this.zzbr = zzao;
    }

    private zzaj(T t, zzn zzn) {
        this.zzbs = false;
        this.result = t;
        this.zzbq = zzn;
        this.zzbr = null;
    }

    public static <T> zzaj<T> zza(T t, zzn zzn) {
        return new zzaj<>(t, zzn);
    }

    public static <T> zzaj<T> zzd(zzao zzao) {
        return new zzaj<>(zzao);
    }

    public final boolean isSuccess() {
        return this.zzbr == null;
    }
}
