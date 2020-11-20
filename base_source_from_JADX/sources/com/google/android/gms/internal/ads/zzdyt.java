package com.google.android.gms.internal.ads;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

final class zzdyt<V> implements Runnable {
    private final Future<V> zzhxn;
    private final zzdyo<? super V> zzhxo;

    zzdyt(Future<V> future, zzdyo<? super V> zzdyo) {
        this.zzhxn = future;
        this.zzhxo = zzdyo;
    }

    public final void run() {
        Throwable zza;
        Future<V> future = this.zzhxn;
        if (!(future instanceof zzdzr) || (zza = zzdzu.zza((zzdzr) future)) == null) {
            try {
                this.zzhxo.onSuccess(zzdyr.zza(this.zzhxn));
            } catch (ExecutionException e) {
                this.zzhxo.zzb(e.getCause());
            } catch (Error | RuntimeException e2) {
                this.zzhxo.zzb(e2);
            }
        } else {
            this.zzhxo.zzb(zza);
        }
    }

    public final String toString() {
        return zzdvo.zzy(this).zzz(this.zzhxo).toString();
    }
}
