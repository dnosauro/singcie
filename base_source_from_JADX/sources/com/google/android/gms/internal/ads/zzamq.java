package com.google.android.gms.internal.ads;

import java.util.concurrent.Executor;

public final class zzamq {
    private zzalb zzdkj;
    private zzdyz<zzalz> zzdkk;

    zzamq(zzalb zzalb) {
        this.zzdkj = zzalb;
    }

    private final void zzub() {
        if (this.zzdkk == null) {
            zzazq zzazq = new zzazq();
            this.zzdkk = zzazq;
            this.zzdkj.zzb((zzef) null).zza(new zzamt(zzazq), new zzams(zzazq));
        }
    }

    public final <I, O> zzamx<I, O> zzb(String str, zzame<I> zzame, zzamf<O> zzamf) {
        zzub();
        return new zzamx<>(this.zzdkk, str, zzame, zzamf);
    }

    public final void zzc(String str, zzahv<? super zzalz> zzahv) {
        zzub();
        this.zzdkk = zzdyr.zzb(this.zzdkk, new zzamv(str, zzahv), (Executor) zzazj.zzegu);
    }

    public final void zzd(String str, zzahv<? super zzalz> zzahv) {
        this.zzdkk = zzdyr.zzb(this.zzdkk, new zzamu(str, zzahv), (Executor) zzazj.zzegu);
    }
}
