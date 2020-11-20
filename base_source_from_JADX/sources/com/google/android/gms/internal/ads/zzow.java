package com.google.android.gms.internal.ads;

import android.os.Looper;
import android.os.SystemClock;
import java.io.IOException;
import java.util.concurrent.ExecutorService;

public final class zzow {
    /* access modifiers changed from: private */
    public final ExecutorService zzbjd;
    /* access modifiers changed from: private */
    public zzoy<? extends zzpb> zzbje;
    /* access modifiers changed from: private */
    public IOException zzbjf;

    public zzow(String str) {
        this.zzbjd = zzpt.zzbf(str);
    }

    public final boolean isLoading() {
        return this.zzbje != null;
    }

    public final <T extends zzpb> long zza(T t, zzoz<T> zzoz, int i) {
        Looper myLooper = Looper.myLooper();
        zzpc.checkState(myLooper != null);
        long elapsedRealtime = SystemClock.elapsedRealtime();
        new zzoy(this, myLooper, t, zzoz, i, elapsedRealtime).zzek(0);
        return elapsedRealtime;
    }

    public final void zza(Runnable runnable) {
        zzoy<? extends zzpb> zzoy = this.zzbje;
        if (zzoy != null) {
            zzoy.zzl(true);
        }
        this.zzbjd.execute(runnable);
        this.zzbjd.shutdown();
    }

    public final void zzbg(int i) {
        IOException iOException = this.zzbjf;
        if (iOException == null) {
            zzoy<? extends zzpb> zzoy = this.zzbje;
            if (zzoy != null) {
                zzoy.zzbg(zzoy.zzbjk);
                return;
            }
            return;
        }
        throw iOException;
    }

    public final void zzis() {
        this.zzbje.zzl(false);
    }
}
