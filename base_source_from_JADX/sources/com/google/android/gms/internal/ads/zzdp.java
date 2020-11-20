package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.MotionEvent;
import android.view.View;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public final class zzdp implements zzdv {
    private static zzdp zzvn;
    private final Context context;
    private final zzdtz zzvo;
    private final zzdui zzvp;
    private final zzduj zzvq;
    private final zzev zzvr;
    /* access modifiers changed from: private */
    public final zzdsi zzvs;
    private final Executor zzvt;
    private final zzgn zzvu;
    private final zzduf zzvv;
    private volatile long zzvw = 0;
    /* access modifiers changed from: private */
    public final Object zzvx = new Object();
    /* access modifiers changed from: private */
    public volatile boolean zzvy;

    private zzdp(Context context2, zzdsi zzdsi, zzdtz zzdtz, zzdui zzdui, zzduj zzduj, zzev zzev, Executor executor, zzdsg zzdsg, zzgn zzgn) {
        this.context = context2;
        this.zzvs = zzdsi;
        this.zzvo = zzdtz;
        this.zzvp = zzdui;
        this.zzvq = zzduj;
        this.zzvr = zzev;
        this.zzvt = executor;
        this.zzvu = zzgn;
        this.zzvv = new zzdr(this, zzdsg);
    }

    static zzdp zza(Context context2, zzdsi zzdsi, zzdsj zzdsj) {
        return zza(context2, zzdsi, zzdsj, (Executor) Executors.newCachedThreadPool());
    }

    private static zzdp zza(Context context2, zzdsi zzdsi, zzdsj zzdsj, Executor executor) {
        zzdsv zza = zzdsv.zza(context2, executor, zzdsi, zzdsj);
        zzey zzey = new zzey(context2);
        zzev zzev = new zzev(zzdsj, zza, new zzfh(context2, zzey), zzey);
        zzgn zzaxp = new zzdtl(context2, zzdsi).zzaxp();
        zzdsg zzdsg = new zzdsg();
        return new zzdp(context2, zzdsi, new zzdtz(context2, zzaxp), new zzdui(context2, zzaxp, new zzds(zzdsi)), new zzduj(context2, zzev, zzdsi, zzdsg), zzev, executor, zzdsg, zzaxp);
    }

    public static synchronized zzdp zza(String str, Context context2, boolean z) {
        zzdp zzdp;
        synchronized (zzdp.class) {
            if (zzvn == null) {
                zzdsj zzaxa = zzdsj.zzawz().zzgy(str).zzbp(z).zzaxa();
                ExecutorService newCachedThreadPool = Executors.newCachedThreadPool();
                zzdp zza = zza(context2, zzdsi.zza(context2, newCachedThreadPool), zzaxa, (Executor) newCachedThreadPool);
                zzvn = zza;
                zza.zzbq();
                zzvn.zzbt();
            }
            zzdp = zzvn;
        }
        return zzdp;
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x00aa A[Catch:{ zzeks -> 0x011a }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00b7 A[Catch:{ zzeks -> 0x011a }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzbs() {
        /*
            r11 = this;
            long r0 = java.lang.System.currentTimeMillis()
            int r2 = com.google.android.gms.internal.ads.zzduh.zzhru
            com.google.android.gms.internal.ads.zzdua r2 = r11.zzp(r2)
            r3 = 0
            if (r2 == 0) goto L_0x0020
            com.google.android.gms.internal.ads.zzgt r3 = r2.zzaxz()
            java.lang.String r3 = r3.zzdg()
            com.google.android.gms.internal.ads.zzgt r2 = r2.zzaxz()
            java.lang.String r2 = r2.zzdh()
            r8 = r2
            r7 = r3
            goto L_0x0022
        L_0x0020:
            r7 = r3
            r8 = r7
        L_0x0022:
            android.content.Context r4 = r11.context     // Catch:{ zzeks -> 0x011a }
            r5 = 1
            com.google.android.gms.internal.ads.zzgn r6 = r11.zzvu     // Catch:{ zzeks -> 0x011a }
            java.lang.String r9 = "1"
            com.google.android.gms.internal.ads.zzdsi r10 = r11.zzvs     // Catch:{ zzeks -> 0x011a }
            com.google.android.gms.internal.ads.zzdud r2 = com.google.android.gms.internal.ads.zzdsr.zza(r4, r5, r6, r7, r8, r9, r10)     // Catch:{ zzeks -> 0x011a }
            byte[] r3 = r2.zzhrt     // Catch:{ zzeks -> 0x011a }
            if (r3 == 0) goto L_0x010d
            byte[] r3 = r2.zzhrt     // Catch:{ zzeks -> 0x011a }
            int r3 = r3.length     // Catch:{ zzeks -> 0x011a }
            if (r3 != 0) goto L_0x003a
            goto L_0x010d
        L_0x003a:
            byte[] r3 = r2.zzhrt     // Catch:{ zzeks -> 0x011a }
            com.google.android.gms.internal.ads.zzeiu r3 = com.google.android.gms.internal.ads.zzeiu.zzt(r3)     // Catch:{ zzeks -> 0x011a }
            com.google.android.gms.internal.ads.zzeju r4 = com.google.android.gms.internal.ads.zzeju.zzbhf()     // Catch:{ zzeks -> 0x011a }
            com.google.android.gms.internal.ads.zzgp r3 = com.google.android.gms.internal.ads.zzgp.zza(r3, r4)     // Catch:{ zzeks -> 0x011a }
            com.google.android.gms.internal.ads.zzgt r4 = r3.zzdc()     // Catch:{ zzeks -> 0x011a }
            java.lang.String r4 = r4.zzdg()     // Catch:{ zzeks -> 0x011a }
            boolean r4 = r4.isEmpty()     // Catch:{ zzeks -> 0x011a }
            r5 = 1
            r6 = 0
            if (r4 != 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzgt r4 = r3.zzdc()     // Catch:{ zzeks -> 0x011a }
            java.lang.String r4 = r4.zzdh()     // Catch:{ zzeks -> 0x011a }
            boolean r4 = r4.isEmpty()     // Catch:{ zzeks -> 0x011a }
            if (r4 != 0) goto L_0x00a7
            com.google.android.gms.internal.ads.zzeiu r4 = r3.zzde()     // Catch:{ zzeks -> 0x011a }
            byte[] r4 = r4.toByteArray()     // Catch:{ zzeks -> 0x011a }
            int r4 = r4.length     // Catch:{ zzeks -> 0x011a }
            if (r4 != 0) goto L_0x0072
            goto L_0x00a7
        L_0x0072:
            int r4 = com.google.android.gms.internal.ads.zzduh.zzhru     // Catch:{ zzeks -> 0x011a }
            com.google.android.gms.internal.ads.zzdua r4 = r11.zzp(r4)     // Catch:{ zzeks -> 0x011a }
            if (r4 != 0) goto L_0x007b
            goto L_0x00a8
        L_0x007b:
            com.google.android.gms.internal.ads.zzgt r4 = r4.zzaxz()     // Catch:{ zzeks -> 0x011a }
            if (r4 != 0) goto L_0x0082
            goto L_0x00a8
        L_0x0082:
            com.google.android.gms.internal.ads.zzgt r7 = r3.zzdc()     // Catch:{ zzeks -> 0x011a }
            java.lang.String r7 = r7.zzdg()     // Catch:{ zzeks -> 0x011a }
            java.lang.String r8 = r4.zzdg()     // Catch:{ zzeks -> 0x011a }
            boolean r7 = r7.equals(r8)     // Catch:{ zzeks -> 0x011a }
            if (r7 == 0) goto L_0x00a8
            com.google.android.gms.internal.ads.zzgt r7 = r3.zzdc()     // Catch:{ zzeks -> 0x011a }
            java.lang.String r7 = r7.zzdh()     // Catch:{ zzeks -> 0x011a }
            java.lang.String r4 = r4.zzdh()     // Catch:{ zzeks -> 0x011a }
            boolean r4 = r7.equals(r4)     // Catch:{ zzeks -> 0x011a }
            if (r4 != 0) goto L_0x00a7
            goto L_0x00a8
        L_0x00a7:
            r5 = 0
        L_0x00a8:
            if (r5 != 0) goto L_0x00b7
            com.google.android.gms.internal.ads.zzdsi r2 = r11.zzvs     // Catch:{ zzeks -> 0x011a }
            r3 = 5010(0x1392, float:7.02E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzeks -> 0x011a }
            long r4 = r4 - r0
            r2.zzh(r3, r4)     // Catch:{ zzeks -> 0x011a }
            return
        L_0x00b7:
            com.google.android.gms.internal.ads.zzduf r4 = r11.zzvv     // Catch:{ zzeks -> 0x011a }
            int r2 = r2.status     // Catch:{ zzeks -> 0x011a }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzabf.zzcqs     // Catch:{ zzeks -> 0x011a }
            com.google.android.gms.internal.ads.zzabb r7 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ zzeks -> 0x011a }
            java.lang.Object r5 = r7.zzd(r5)     // Catch:{ zzeks -> 0x011a }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ zzeks -> 0x011a }
            boolean r5 = r5.booleanValue()     // Catch:{ zzeks -> 0x011a }
            if (r5 == 0) goto L_0x00e1
            r5 = 3
            if (r2 != r5) goto L_0x00d7
            com.google.android.gms.internal.ads.zzdui r2 = r11.zzvp     // Catch:{ zzeks -> 0x011a }
            boolean r6 = r2.zza(r3)     // Catch:{ zzeks -> 0x011a }
            goto L_0x00e7
        L_0x00d7:
            r5 = 4
            if (r2 != r5) goto L_0x00e7
            com.google.android.gms.internal.ads.zzdui r2 = r11.zzvp     // Catch:{ zzeks -> 0x011a }
            boolean r6 = r2.zza((com.google.android.gms.internal.ads.zzgp) r3, (com.google.android.gms.internal.ads.zzduf) r4)     // Catch:{ zzeks -> 0x011a }
            goto L_0x00e7
        L_0x00e1:
            com.google.android.gms.internal.ads.zzdtz r2 = r11.zzvo     // Catch:{ zzeks -> 0x011a }
            boolean r6 = r2.zza(r3, r4)     // Catch:{ zzeks -> 0x011a }
        L_0x00e7:
            if (r6 != 0) goto L_0x00f6
            com.google.android.gms.internal.ads.zzdsi r2 = r11.zzvs     // Catch:{ zzeks -> 0x011a }
            r3 = 4009(0xfa9, float:5.618E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzeks -> 0x011a }
            long r4 = r4 - r0
            r2.zzh(r3, r4)     // Catch:{ zzeks -> 0x011a }
            return
        L_0x00f6:
            int r2 = com.google.android.gms.internal.ads.zzduh.zzhru     // Catch:{ zzeks -> 0x011a }
            com.google.android.gms.internal.ads.zzdua r2 = r11.zzp(r2)     // Catch:{ zzeks -> 0x011a }
            if (r2 == 0) goto L_0x010c
            com.google.android.gms.internal.ads.zzduj r3 = r11.zzvq     // Catch:{ zzeks -> 0x011a }
            r3.zzb(r2)     // Catch:{ zzeks -> 0x011a }
            long r2 = java.lang.System.currentTimeMillis()     // Catch:{ zzeks -> 0x011a }
            r4 = 1000(0x3e8, double:4.94E-321)
            long r2 = r2 / r4
            r11.zzvw = r2     // Catch:{ zzeks -> 0x011a }
        L_0x010c:
            return
        L_0x010d:
            com.google.android.gms.internal.ads.zzdsi r2 = r11.zzvs     // Catch:{ zzeks -> 0x011a }
            r3 = 5009(0x1391, float:7.019E-42)
            long r4 = java.lang.System.currentTimeMillis()     // Catch:{ zzeks -> 0x011a }
            long r4 = r4 - r0
            r2.zzh(r3, r4)     // Catch:{ zzeks -> 0x011a }
            return
        L_0x011a:
            r2 = move-exception
            com.google.android.gms.internal.ads.zzdsi r3 = r11.zzvs
            r4 = 4002(0xfa2, float:5.608E-42)
            long r5 = java.lang.System.currentTimeMillis()
            long r5 = r5 - r0
            r3.zza((int) r4, (long) r5, (java.lang.Exception) r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdp.zzbs():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzbt() {
        /*
            r6 = this;
            boolean r0 = r6.zzvy
            if (r0 != 0) goto L_0x0033
            java.lang.Object r0 = r6.zzvx
            monitor-enter(r0)
            boolean r1 = r6.zzvy     // Catch:{ all -> 0x0030 }
            if (r1 != 0) goto L_0x002e
            long r1 = java.lang.System.currentTimeMillis()     // Catch:{ all -> 0x0030 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r1 = r1 / r3
            long r3 = r6.zzvw     // Catch:{ all -> 0x0030 }
            long r1 = r1 - r3
            r3 = 3600(0xe10, double:1.7786E-320)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 >= 0) goto L_0x001d
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x001d:
            com.google.android.gms.internal.ads.zzduj r1 = r6.zzvq     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzdua r1 = r1.zzaye()     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002b
            boolean r1 = r1.zzff(r3)     // Catch:{ all -> 0x0030 }
            if (r1 == 0) goto L_0x002e
        L_0x002b:
            r6.zzbr()     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r1
        L_0x0033:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzdp.zzbt():void");
    }

    private final zzdua zzp(int i) {
        if (!zzdtl.zza(this.zzvu)) {
            return null;
        }
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqs)).booleanValue() ? this.zzvp.zzp(i) : this.zzvo.zzp(i);
    }

    public final String zza(Context context2, View view, Activity activity) {
        zzbt();
        zzdsl zzayd = this.zzvq.zzayd();
        if (zzayd == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzb = zzayd.zzb(context2, (String) null, view, activity);
        this.zzvs.zza(5002, System.currentTimeMillis() - currentTimeMillis, zzb, (Map<String, String>) null);
        return zzb;
    }

    public final String zza(Context context2, String str, View view) {
        return zza(context2, str, view, (Activity) null);
    }

    public final String zza(Context context2, String str, View view, Activity activity) {
        zzbt();
        zzdsl zzayd = this.zzvq.zzayd();
        if (zzayd == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zza = zzayd.zza(context2, (String) null, str, view, activity);
        this.zzvs.zza(5000, System.currentTimeMillis() - currentTimeMillis, zza, (Map<String, String>) null);
        return zza;
    }

    public final void zza(int i, int i2, int i3) {
    }

    public final void zza(MotionEvent motionEvent) {
        zzdsl zzayd = this.zzvq.zzayd();
        if (zzayd != null) {
            try {
                zzayd.zza((String) null, motionEvent);
            } catch (zzduk e) {
                this.zzvs.zza(e.zzayf(), -1, (Exception) e);
            }
        }
    }

    public final String zzb(Context context2) {
        zzbt();
        zzdsl zzayd = this.zzvq.zzayd();
        if (zzayd == null) {
            return "";
        }
        long currentTimeMillis = System.currentTimeMillis();
        String zzt = zzayd.zzt(context2, (String) null);
        this.zzvs.zza(5001, System.currentTimeMillis() - currentTimeMillis, zzt, (Map<String, String>) null);
        return zzt;
    }

    public final void zzb(View view) {
        this.zzvr.zzc(view);
    }

    /* access modifiers changed from: package-private */
    public final synchronized void zzbq() {
        long currentTimeMillis = System.currentTimeMillis();
        zzdua zzp = zzp(zzduh.zzhru);
        if (zzp == null || zzp.zza()) {
            this.zzvs.zzh(4013, System.currentTimeMillis() - currentTimeMillis);
        } else {
            this.zzvq.zzb(zzp);
        }
    }

    public final void zzbr() {
        if (zzdtl.zza(this.zzvu)) {
            this.zzvt.execute(new zzdu(this));
        }
    }
}
