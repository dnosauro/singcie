package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

public final class zzae {
    private final zzx zzak;
    private final AtomicInteger zzbe;
    private final Set<zzaa<?>> zzbf;
    private final PriorityBlockingQueue<zzaa<?>> zzbg;
    private final PriorityBlockingQueue<zzaa<?>> zzbh;
    private final zzw[] zzbi;
    private final List<zzag> zzbj;
    private final List<zzah> zzbk;
    private final zzk zzn;
    private final zzak zzo;
    private zzm zzz;

    public zzae(zzk zzk, zzx zzx) {
        this(zzk, zzx, 4);
    }

    private zzae(zzk zzk, zzx zzx, int i) {
        this(zzk, zzx, 4, new zzt(new Handler(Looper.getMainLooper())));
    }

    private zzae(zzk zzk, zzx zzx, int i, zzak zzak2) {
        this.zzbe = new AtomicInteger();
        this.zzbf = new HashSet();
        this.zzbg = new PriorityBlockingQueue<>();
        this.zzbh = new PriorityBlockingQueue<>();
        this.zzbj = new ArrayList();
        this.zzbk = new ArrayList();
        this.zzn = zzk;
        this.zzak = zzx;
        this.zzbi = new zzw[4];
        this.zzo = zzak2;
    }

    public final void start() {
        zzm zzm = this.zzz;
        if (zzm != null) {
            zzm.quit();
        }
        for (zzw zzw : this.zzbi) {
            if (zzw != null) {
                zzw.quit();
            }
        }
        this.zzz = new zzm(this.zzbg, this.zzbh, this.zzn, this.zzo);
        this.zzz.start();
        for (int i = 0; i < this.zzbi.length; i++) {
            zzw zzw2 = new zzw(this.zzbh, this.zzak, this.zzn, this.zzo);
            this.zzbi[i] = zzw2;
            zzw2.start();
        }
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaa<?> zzaa, int i) {
        synchronized (this.zzbk) {
            for (zzah zzb : this.zzbk) {
                zzb.zzb(zzaa, i);
            }
        }
    }

    public final <T> zzaa<T> zze(zzaa<T> zzaa) {
        zzaa.zza(this);
        synchronized (this.zzbf) {
            this.zzbf.add(zzaa);
        }
        zzaa.zze(this.zzbe.incrementAndGet());
        zzaa.zzc("add-to-queue");
        zza(zzaa, 0);
        (!zzaa.zzh() ? this.zzbh : this.zzbg).add(zzaa);
        return zzaa;
    }

    /* access modifiers changed from: package-private */
    public final <T> void zzf(zzaa<T> zzaa) {
        synchronized (this.zzbf) {
            this.zzbf.remove(zzaa);
        }
        synchronized (this.zzbj) {
            for (zzag zzg : this.zzbj) {
                zzg.zzg(zzaa);
            }
        }
        zza(zzaa, 5);
    }
}
