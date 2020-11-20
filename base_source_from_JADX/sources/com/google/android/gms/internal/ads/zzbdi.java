package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.Arrays;
import java.util.List;

@TargetApi(16)
public final class zzbdi extends zzbcx implements zzbck {
    private String zzeiv;
    private boolean zzeor;
    private zzbca zzeou;
    private Exception zzeov;
    private boolean zzeow;

    public zzbdi(zzbbe zzbbe, zzbbf zzbbf) {
        super(zzbbe);
        this.zzeou = new zzbca(zzbbe.getContext(), zzbbf, (zzbbe) this.zzeog.get());
        this.zzeou.zza((zzbck) this);
    }

    private static String zzb(String str, Exception exc) {
        String canonicalName = exc.getClass().getCanonicalName();
        String message = exc.getMessage();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 2 + String.valueOf(canonicalName).length() + String.valueOf(message).length());
        sb.append(str);
        sb.append("/");
        sb.append(canonicalName);
        sb.append(":");
        sb.append(message);
        return sb.toString();
    }

    private final void zzfm(String str) {
        synchronized (this) {
            this.zzeor = true;
            notify();
            release();
        }
        String str2 = this.zzeiv;
        if (str2 != null) {
            String zzfk = zzfk(str2);
            Exception exc = this.zzeov;
            if (exc != null) {
                zza(this.zzeiv, zzfk, "badUrl", zzb(str, exc));
            } else {
                zza(this.zzeiv, zzfk, "externalAbort", "Programmatic precache abort.");
            }
        }
    }

    public final void abort() {
        zzfm((String) null);
    }

    public final void release() {
        zzbca zzbca = this.zzeou;
        if (zzbca != null) {
            zzbca.zza((zzbck) null);
            this.zzeou.release();
        }
        super.release();
    }

    public final void zza(String str, Exception exc) {
        String str2 = (String) zzwq.zzqe().zzd(zzabf.zzcmc);
        if (str2 != null) {
            List asList = Arrays.asList(str2.split(","));
            if (asList.contains("all") || asList.contains(exc.getClass().getCanonicalName())) {
                return;
            }
        }
        this.zzeov = exc;
        zzd.zzd("Precache error", exc);
        zzfm(str);
    }

    public final zzbca zzabu() {
        synchronized (this) {
            this.zzeow = true;
            notify();
        }
        this.zzeou.zza((zzbck) null);
        zzbca zzbca = this.zzeou;
        this.zzeou = null;
        return zzbca;
    }

    public final void zzb(boolean z, long j) {
        zzbbe zzbbe = (zzbbe) this.zzeog.get();
        if (zzbbe != null) {
            zzazj.zzegt.execute(new zzbdl(zzbbe, z, j));
        }
    }

    public final void zzdl(int i) {
        this.zzeou.zzabs().zzdt(i);
    }

    public final void zzdm(int i) {
        this.zzeou.zzabs().zzdu(i);
    }

    public final void zzdn(int i) {
        this.zzeou.zzabs().zzdn(i);
    }

    public final void zzdo(int i) {
        this.zzeou.zzabs().zzdo(i);
    }

    public final void zzdr(int i) {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:17:0x0098, code lost:
        if (r15.zzeov == null) goto L_0x009f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x009e, code lost:
        throw r15.zzeov;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a8, code lost:
        throw new java.io.IOException("Abort requested before buffering finished. ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x00a9, code lost:
        r0 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x00aa, code lost:
        r17 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:32:0x00b5, code lost:
        r5 = r15;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:67:0x014a, code lost:
        r7 = r44;
        r5 = r47;
        r6 = r48;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:69:?, code lost:
        r5.zzc(r6, r7, r1);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zze(java.lang.String r48, java.lang.String[] r49) {
        /*
            r47 = this;
            r15 = r47
            r13 = r48
            r0 = r49
            r15.zzeiv = r13
            java.lang.String r14 = r47.zzfk(r48)
            java.lang.String r17 = "error"
            r18 = 0
            int r1 = r0.length     // Catch:{ Exception -> 0x01d2 }
            android.net.Uri[] r1 = new android.net.Uri[r1]     // Catch:{ Exception -> 0x01d2 }
            r2 = 0
        L_0x0014:
            int r3 = r0.length     // Catch:{ Exception -> 0x01d2 }
            if (r2 >= r3) goto L_0x0022
            r3 = r0[r2]     // Catch:{ Exception -> 0x01d2 }
            android.net.Uri r3 = android.net.Uri.parse(r3)     // Catch:{ Exception -> 0x01d2 }
            r1[r2] = r3     // Catch:{ Exception -> 0x01d2 }
            int r2 = r2 + 1
            goto L_0x0014
        L_0x0022:
            com.google.android.gms.internal.ads.zzbca r0 = r15.zzeou     // Catch:{ Exception -> 0x01d2 }
            java.lang.String r2 = r15.zzefk     // Catch:{ Exception -> 0x01d2 }
            r0.zza((android.net.Uri[]) r1, (java.lang.String) r2)     // Catch:{ Exception -> 0x01d2 }
            java.lang.ref.WeakReference r0 = r15.zzeog     // Catch:{ Exception -> 0x01d2 }
            java.lang.Object r0 = r0.get()     // Catch:{ Exception -> 0x01d2 }
            com.google.android.gms.internal.ads.zzbbe r0 = (com.google.android.gms.internal.ads.zzbbe) r0     // Catch:{ Exception -> 0x01d2 }
            if (r0 == 0) goto L_0x0036
            r0.zza((java.lang.String) r14, (com.google.android.gms.internal.ads.zzbcx) r15)     // Catch:{ Exception -> 0x01d2 }
        L_0x0036:
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ Exception -> 0x01d2 }
            long r19 = r0.currentTimeMillis()     // Catch:{ Exception -> 0x01d2 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabf.zzcmj     // Catch:{ Exception -> 0x01d2 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x01d2 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d2 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d2 }
            long r11 = r1.longValue()     // Catch:{ Exception -> 0x01d2 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabf.zzcmi     // Catch:{ Exception -> 0x01d2 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x01d2 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d2 }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ Exception -> 0x01d2 }
            long r1 = r1.longValue()     // Catch:{ Exception -> 0x01d2 }
            r3 = 1000(0x3e8, double:4.94E-321)
            long r9 = r1 * r3
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabf.zzcmh     // Catch:{ Exception -> 0x01d2 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x01d2 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d2 }
            java.lang.Integer r1 = (java.lang.Integer) r1     // Catch:{ Exception -> 0x01d2 }
            int r1 = r1.intValue()     // Catch:{ Exception -> 0x01d2 }
            long r6 = (long) r1     // Catch:{ Exception -> 0x01d2 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabf.zzcqn     // Catch:{ Exception -> 0x01d2 }
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x01d2 }
            java.lang.Object r1 = r2.zzd(r1)     // Catch:{ Exception -> 0x01d2 }
            java.lang.Boolean r1 = (java.lang.Boolean) r1     // Catch:{ Exception -> 0x01d2 }
            boolean r21 = r1.booleanValue()     // Catch:{ Exception -> 0x01d2 }
            r22 = -1
            r1 = r22
        L_0x0087:
            monitor-enter(r47)     // Catch:{ Exception -> 0x01d2 }
            long r3 = r0.currentTimeMillis()     // Catch:{ all -> 0x01c8 }
            long r3 = r3 - r19
            int r5 = (r3 > r9 ? 1 : (r3 == r9 ? 0 : -1))
            if (r5 > 0) goto L_0x019d
            boolean r3 = r15.zzeor     // Catch:{ all -> 0x01c8 }
            if (r3 == 0) goto L_0x00ae
            java.lang.Exception r0 = r15.zzeov     // Catch:{ all -> 0x01c8 }
            if (r0 == 0) goto L_0x009f
            java.lang.String r1 = "badUrl"
            java.lang.Exception r0 = r15.zzeov     // Catch:{ all -> 0x00a9 }
            throw r0     // Catch:{ all -> 0x00a9 }
        L_0x009f:
            java.lang.String r1 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x00a9 }
            java.lang.String r2 = "Abort requested before buffering finished. "
            r0.<init>(r2)     // Catch:{ all -> 0x00a9 }
            throw r0     // Catch:{ all -> 0x00a9 }
        L_0x00a9:
            r0 = move-exception
            r17 = r1
            goto L_0x01c9
        L_0x00ae:
            boolean r3 = r15.zzeow     // Catch:{ all -> 0x01c8 }
            r24 = 1
            if (r3 == 0) goto L_0x00b8
            monitor-exit(r47)     // Catch:{ all -> 0x01c8 }
            r5 = r15
            goto L_0x016a
        L_0x00b8:
            com.google.android.gms.internal.ads.zzbca r3 = r15.zzeou     // Catch:{ all -> 0x01c8 }
            com.google.android.gms.internal.ads.zzhd r3 = r3.zzabp()     // Catch:{ all -> 0x01c8 }
            if (r3 == 0) goto L_0x0190
            long r4 = r3.getDuration()     // Catch:{ all -> 0x01c8 }
            r25 = 0
            int r8 = (r4 > r25 ? 1 : (r4 == r25 ? 0 : -1))
            if (r8 <= 0) goto L_0x016e
            long r27 = r3.getBufferedPosition()     // Catch:{ all -> 0x01c8 }
            int r3 = (r27 > r1 ? 1 : (r27 == r1 ? 0 : -1))
            if (r3 == 0) goto L_0x0139
            int r1 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r1 <= 0) goto L_0x00d8
            r8 = 1
            goto L_0x00d9
        L_0x00d8:
            r8 = 0
        L_0x00d9:
            if (r21 == 0) goto L_0x00e4
            com.google.android.gms.internal.ads.zzbca r1 = r15.zzeou     // Catch:{ all -> 0x01c8 }
            long r1 = r1.zzzo()     // Catch:{ all -> 0x01c8 }
            r29 = r1
            goto L_0x00e6
        L_0x00e4:
            r29 = r22
        L_0x00e6:
            if (r21 == 0) goto L_0x00f1
            com.google.android.gms.internal.ads.zzbca r1 = r15.zzeou     // Catch:{ all -> 0x01c8 }
            long r1 = r1.zzna()     // Catch:{ all -> 0x01c8 }
            r31 = r1
            goto L_0x00f3
        L_0x00f1:
            r31 = r22
        L_0x00f3:
            if (r21 == 0) goto L_0x00fe
            com.google.android.gms.internal.ads.zzbca r1 = r15.zzeou     // Catch:{ all -> 0x01c8 }
            long r1 = r1.getTotalBytes()     // Catch:{ all -> 0x01c8 }
            r33 = r1
            goto L_0x0100
        L_0x00fe:
            r33 = r22
        L_0x0100:
            int r16 = com.google.android.gms.internal.ads.zzbca.zzabq()     // Catch:{ all -> 0x0131 }
            int r35 = com.google.android.gms.internal.ads.zzbca.zzabr()     // Catch:{ all -> 0x0131 }
            r1 = r47
            r2 = r48
            r3 = r14
            r36 = r4
            r4 = r27
            r38 = r6
            r6 = r36
            r40 = r9
            r9 = r29
            r42 = r11
            r11 = r31
            r44 = r14
            r13 = r33
            r15 = r16
            r16 = r35
            r1.zza(r2, r3, r4, r6, r8, r9, r11, r13, r15, r16)     // Catch:{ all -> 0x012d }
            r3 = r27
            r1 = r36
            goto L_0x0146
        L_0x012d:
            r0 = move-exception
            r7 = r44
            goto L_0x0133
        L_0x0131:
            r0 = move-exception
            r7 = r14
        L_0x0133:
            r5 = r47
            r6 = r48
            goto L_0x01cc
        L_0x0139:
            r38 = r6
            r40 = r9
            r42 = r11
            r44 = r14
            r45 = r1
            r1 = r4
            r3 = r45
        L_0x0146:
            int r5 = (r27 > r1 ? 1 : (r27 == r1 ? 0 : -1))
            if (r5 < 0) goto L_0x0155
            r7 = r44
            r5 = r47
            r6 = r48
            r5.zzc(r6, r7, r1)     // Catch:{ all -> 0x01d0 }
        L_0x0153:
            monitor-exit(r47)     // Catch:{ all -> 0x01d0 }
            goto L_0x016a
        L_0x0155:
            r7 = r44
            r5 = r47
            r6 = r48
            com.google.android.gms.internal.ads.zzbca r1 = r5.zzeou     // Catch:{ all -> 0x01d0 }
            long r1 = r1.getBytesTransferred()     // Catch:{ all -> 0x01d0 }
            int r8 = (r1 > r38 ? 1 : (r1 == r38 ? 0 : -1))
            if (r8 < 0) goto L_0x016b
            int r1 = (r27 > r25 ? 1 : (r27 == r25 ? 0 : -1))
            if (r1 <= 0) goto L_0x016b
            goto L_0x0153
        L_0x016a:
            return r24
        L_0x016b:
            r1 = r42
            goto L_0x0177
        L_0x016e:
            r38 = r6
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            r3 = r1
            r1 = r11
        L_0x0177:
            r5.wait(r1)     // Catch:{ InterruptedException -> 0x0186 }
            monitor-exit(r47)     // Catch:{ all -> 0x01d0 }
            r11 = r1
            r1 = r3
            r15 = r5
            r13 = r6
            r14 = r7
            r6 = r38
            r9 = r40
            goto L_0x0087
        L_0x0186:
            java.lang.String r1 = "interrupted"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c4 }
            java.lang.String r2 = "Wait interrupted."
            r0.<init>(r2)     // Catch:{ all -> 0x01c4 }
            throw r0     // Catch:{ all -> 0x01c4 }
        L_0x0190:
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "exoPlayerReleased"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c4 }
            java.lang.String r2 = "ExoPlayer was released during preloading."
            r0.<init>(r2)     // Catch:{ all -> 0x01c4 }
            throw r0     // Catch:{ all -> 0x01c4 }
        L_0x019d:
            r40 = r9
            r6 = r13
            r7 = r14
            r5 = r15
            java.lang.String r1 = "downloadTimeout"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x01c4 }
            r2 = 47
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ all -> 0x01c4 }
            r3.<init>(r2)     // Catch:{ all -> 0x01c4 }
            java.lang.String r2 = "Timeout reached. Limit: "
            r3.append(r2)     // Catch:{ all -> 0x01c4 }
            r8 = r40
            r3.append(r8)     // Catch:{ all -> 0x01c4 }
            java.lang.String r2 = " ms"
            r3.append(r2)     // Catch:{ all -> 0x01c4 }
            java.lang.String r2 = r3.toString()     // Catch:{ all -> 0x01c4 }
            r0.<init>(r2)     // Catch:{ all -> 0x01c4 }
            throw r0     // Catch:{ all -> 0x01c4 }
        L_0x01c4:
            r0 = move-exception
            r17 = r1
            goto L_0x01cc
        L_0x01c8:
            r0 = move-exception
        L_0x01c9:
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01cc:
            monitor-exit(r47)     // Catch:{ all -> 0x01d0 }
            throw r0     // Catch:{ Exception -> 0x01ce }
        L_0x01ce:
            r0 = move-exception
            goto L_0x01d6
        L_0x01d0:
            r0 = move-exception
            goto L_0x01cc
        L_0x01d2:
            r0 = move-exception
            r6 = r13
            r7 = r14
            r5 = r15
        L_0x01d6:
            r1 = r17
            java.lang.String r2 = r0.getMessage()
            java.lang.String r3 = java.lang.String.valueOf(r48)
            int r3 = r3.length()
            int r3 = r3 + 34
            java.lang.String r4 = java.lang.String.valueOf(r2)
            int r4 = r4.length()
            int r3 = r3 + r4
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>(r3)
            java.lang.String r3 = "Failed to preload url "
            r4.append(r3)
            r4.append(r6)
            java.lang.String r3 = " Exception: "
            r4.append(r3)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            com.google.android.gms.ads.internal.util.zzd.zzfa(r2)
            r47.release()
            java.lang.String r0 = zzb((java.lang.String) r1, (java.lang.Exception) r0)
            r5.zza(r6, r7, r1, r0)
            return r18
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdi.zze(java.lang.String, java.lang.String[]):boolean");
    }

    public final boolean zzfj(String str) {
        return zze(str, new String[]{str});
    }

    /* access modifiers changed from: protected */
    public final String zzfk(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.zzfk(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }

    public final void zzn(int i, int i2) {
    }
}
