package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzboc;
import java.util.LinkedList;
import javax.annotation.concurrent.GuardedBy;

public final class zzdpv<AdT extends zzboc> {
    /* access modifiers changed from: private */
    public final zzdpd zzhez;
    private final zzdpa zzhmh;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzdqb zzhmi;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzdzh<zzdpn<AdT>> zzhmj;
    @GuardedBy("this")
    private zzdyz<zzdpn<AdT>> zzhmk;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public int zzhml = zzdqe.zzhmz;
    /* access modifiers changed from: private */
    public final zzdqc<AdT> zzhmm;
    private final LinkedList<zzdqb> zzhmn;
    private final zzdyo<zzdpn<AdT>> zzhmo = new zzdqa(this);

    public zzdpv(zzdpd zzdpd, zzdpa zzdpa, zzdqc<AdT> zzdqc) {
        this.zzhez = zzdpd;
        this.zzhmh = zzdpa;
        this.zzhmm = zzdqc;
        this.zzhmn = new LinkedList<>();
        this.zzhmh.zza(new zzdpx(this));
    }

    private final boolean zzavv() {
        zzdyz<zzdpn<AdT>> zzdyz = this.zzhmk;
        return zzdyz == null || zzdyz.isDone();
    }

    /* access modifiers changed from: private */
    public final void zzd(zzdqb zzdqb) {
        while (zzavv()) {
            if (zzdqb != null || !this.zzhmn.isEmpty()) {
                if (zzdqb == null) {
                    zzdqb = this.zzhmn.remove();
                }
                if (zzdqb.zzaua() == null || !this.zzhez.zzb(zzdqb.zzaua())) {
                    zzdqb = null;
                } else {
                    this.zzhmi = zzdqb.zzaub();
                    this.zzhmj = zzdzh.zzazp();
                    this.zzhmk = this.zzhmm.zza(this.zzhmi);
                    zzdyr.zza(this.zzhmk, this.zzhmo, zzdqb.getExecutor());
                    return;
                }
            } else {
                return;
            }
        }
        if (zzdqb != null) {
            this.zzhmn.add(zzdqb);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzavw() {
        synchronized (this) {
            zzd(this.zzhmi);
        }
    }

    public final void zzb(zzdqb zzdqb) {
        this.zzhmn.add(zzdqb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzc(zzdpn zzdpn) {
        zzdyz zzag;
        synchronized (this) {
            zzag = zzdyr.zzag(new zzdpz(zzdpn, this.zzhmi));
        }
        return zzag;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0043, code lost:
        return null;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized com.google.android.gms.internal.ads.zzdyz<com.google.android.gms.internal.ads.zzdpz<AdT>> zzc(com.google.android.gms.internal.ads.zzdqb r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzavv()     // Catch:{ all -> 0x0044 }
            r1 = 0
            if (r0 == 0) goto L_0x000a
            monitor-exit(r3)
            return r1
        L_0x000a:
            int r0 = com.google.android.gms.internal.ads.zzdqe.zzhnb     // Catch:{ all -> 0x0044 }
            r3.zzhml = r0     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdqb r0 = r3.zzhmi     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdpq r0 = r0.zzaua()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzdpq r0 = r4.zzaua()     // Catch:{ all -> 0x0044 }
            if (r0 == 0) goto L_0x0042
            com.google.android.gms.internal.ads.zzdqb r0 = r3.zzhmi     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdpq r0 = r0.zzaua()     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdpq r2 = r4.zzaua()     // Catch:{ all -> 0x0044 }
            boolean r0 = r0.equals(r2)     // Catch:{ all -> 0x0044 }
            if (r0 != 0) goto L_0x002d
            goto L_0x0042
        L_0x002d:
            int r0 = com.google.android.gms.internal.ads.zzdqe.zzhna     // Catch:{ all -> 0x0044 }
            r3.zzhml = r0     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdzh<com.google.android.gms.internal.ads.zzdpn<AdT>> r0 = r3.zzhmj     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdpy r1 = new com.google.android.gms.internal.ads.zzdpy     // Catch:{ all -> 0x0044 }
            r1.<init>(r3)     // Catch:{ all -> 0x0044 }
            java.util.concurrent.Executor r4 = r4.getExecutor()     // Catch:{ all -> 0x0044 }
            com.google.android.gms.internal.ads.zzdyz r4 = com.google.android.gms.internal.ads.zzdyr.zzb(r0, r1, (java.util.concurrent.Executor) r4)     // Catch:{ all -> 0x0044 }
            monitor-exit(r3)
            return r4
        L_0x0042:
            monitor-exit(r3)
            return r1
        L_0x0044:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdpv.zzc(com.google.android.gms.internal.ads.zzdqb):com.google.android.gms.internal.ads.zzdyz");
    }
}
