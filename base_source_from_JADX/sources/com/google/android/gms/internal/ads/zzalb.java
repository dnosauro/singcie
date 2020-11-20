package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzau;
import com.google.android.gms.ads.internal.util.zzbr;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzalb {
    private final Context context;
    /* access modifiers changed from: private */
    public final Object lock;
    /* access modifiers changed from: private */
    public int status;
    private final zzazh zzbpd;
    private final String zzdit;
    /* access modifiers changed from: private */
    public zzau<zzako> zzdiu;
    private zzau<zzako> zzdiv;
    /* access modifiers changed from: private */
    public zzals zzdiw;

    private zzalb(Context context2, zzazh zzazh, String str) {
        this.lock = new Object();
        this.status = 1;
        this.zzdit = str;
        this.context = context2.getApplicationContext();
        this.zzbpd = zzazh;
        this.zzdiu = new zzalp();
        this.zzdiv = new zzalp();
    }

    public zzalb(Context context2, zzazh zzazh, String str, zzau<zzako> zzau, zzau<zzako> zzau2) {
        this(context2, zzazh, str);
        this.zzdiu = zzau;
        this.zzdiv = zzau2;
    }

    /* access modifiers changed from: protected */
    public final zzals zza(zzef zzef) {
        zzals zzals = new zzals(this.zzdiv);
        zzazj.zzegt.execute(new zzala(this, zzef, zzals));
        zzals.zza(new zzalk(this, zzals), new zzaln(this, zzals));
        return zzals;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzako zzako) {
        if (zzako.isDestroyed()) {
            this.status = 1;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzals r4, com.google.android.gms.internal.ads.zzako r5) {
        /*
            r3 = this;
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = -1
            if (r1 == r2) goto L_0x0028
            int r1 = r4.getStatus()     // Catch:{ all -> 0x002a }
            r2 = 1
            if (r1 != r2) goto L_0x0012
            goto L_0x0028
        L_0x0012:
            r4.reject()     // Catch:{ all -> 0x002a }
            com.google.android.gms.internal.ads.zzdzc r4 = com.google.android.gms.internal.ads.zzazj.zzegt     // Catch:{ all -> 0x002a }
            r5.getClass()     // Catch:{ all -> 0x002a }
            java.lang.Runnable r5 = com.google.android.gms.internal.ads.zzalh.zzb(r5)     // Catch:{ all -> 0x002a }
            r4.execute(r5)     // Catch:{ all -> 0x002a }
            java.lang.String r4 = "Could not receive loaded message in a timely manner. Rejecting."
            com.google.android.gms.ads.internal.util.zzd.zzee(r4)     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzalb.zza(com.google.android.gms.internal.ads.zzals, com.google.android.gms.internal.ads.zzako):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzef zzef, zzals zzals) {
        try {
            Context context2 = this.context;
            zzazh zzazh = this.zzbpd;
            zzako zzaka = zzadm.zzddw.get().booleanValue() ? new zzaka(context2, zzazh) : new zzakq(context2, zzazh, zzef, (zzb) null);
            zzaka.zza(new zzalf(this, zzals, zzaka));
            zzaka.zza("/jsLoaded", new zzalg(this, zzals, zzaka));
            zzbr zzbr = new zzbr();
            zzalj zzalj = new zzalj(this, zzef, zzaka, zzbr);
            zzbr.set(zzalj);
            zzaka.zza("/requestReload", zzalj);
            if (this.zzdit.endsWith(".js")) {
                zzaka.zzcv(this.zzdit);
            } else if (this.zzdit.startsWith("<html>")) {
                zzaka.zzcw(this.zzdit);
            } else {
                zzaka.zzcx(this.zzdit);
            }
            zzm.zzedd.postDelayed(new zzali(this, zzals, zzaka), (long) zzalm.zzdjh);
        } catch (Throwable th) {
            zzd.zzc("Error creating webview.", th);
            zzp.zzku().zza(th, "SdkJavascriptFactory.loadJavascriptEngine");
            zzals.reject();
        }
    }

    public final zzalo zzb(zzef zzef) {
        synchronized (this.lock) {
            synchronized (this.lock) {
                if (this.zzdiw != null && this.status == 0) {
                    this.zzdiw.zza(new zzald(this), zzalc.zzdix);
                }
            }
            if (this.zzdiw != null) {
                if (this.zzdiw.getStatus() != -1) {
                    if (this.status == 0) {
                        zzalo zztv = this.zzdiw.zztv();
                        return zztv;
                    } else if (this.status == 1) {
                        this.status = 2;
                        zza((zzef) null);
                        zzalo zztv2 = this.zzdiw.zztv();
                        return zztv2;
                    } else if (this.status == 2) {
                        zzalo zztv3 = this.zzdiw.zztv();
                        return zztv3;
                    } else {
                        zzalo zztv4 = this.zzdiw.zztv();
                        return zztv4;
                    }
                }
            }
            this.status = 2;
            this.zzdiw = zza((zzef) null);
            zzalo zztv5 = this.zzdiw.zztv();
            return zztv5;
        }
    }
}
