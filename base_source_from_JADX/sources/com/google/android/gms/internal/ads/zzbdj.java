package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzbdj extends zzbcx implements zzpd<zzon> {
    private String url;
    private ByteBuffer zzamk;
    private final String zzbvf;
    private final int zzbvg;
    private final zzbbf zzelt;
    private boolean zzeor;
    private final zzbdg zzeox = new zzbdg();
    private final zzbcp zzeoy = new zzbcp();
    private boolean zzeoz;
    private final Object zzepa = new Object();
    private boolean zzepb;

    public zzbdj(zzbbe zzbbe, zzbbf zzbbf) {
        super(zzbbe);
        this.zzelt = zzbbf;
        this.zzbvf = zzbbe != null ? zzbbe.zzaal() : "";
        this.zzbvg = zzbbe != null ? zzbbe.zzaam() : 0;
    }

    private final void zzzz() {
        int zzabt = (int) this.zzeox.zzabt();
        int zzq = (int) this.zzeoy.zzq(this.zzamk);
        int position = this.zzamk.position();
        int round = Math.round(((float) zzq) * (((float) position) / ((float) zzabt)));
        boolean z = round > 0;
        int zzabq = zzbca.zzabq();
        int zzabr = zzbca.zzabr();
        String str = this.url;
        zza(str, zzfk(str), position, zzabt, (long) round, (long) zzq, z, zzabq, zzabr);
    }

    public final void abort() {
        this.zzeor = true;
    }

    public final ByteBuffer getByteBuffer() {
        synchronized (this.zzepa) {
            if (this.zzamk != null && !this.zzeoz) {
                this.zzamk.flip();
                this.zzeoz = true;
            }
            this.zzeor = true;
        }
        return this.zzamk;
    }

    public final String getUrl() {
        return this.url;
    }

    public final /* synthetic */ void zza(Object obj, zzoo zzoo) {
        zzon zzon = (zzon) obj;
        if (zzon instanceof zzoq) {
            this.zzeox.zza((zzoq) zzon);
        }
    }

    public final boolean zzabv() {
        return this.zzepb;
    }

    public final /* bridge */ /* synthetic */ void zzc(Object obj, int i) {
    }

    public final /* bridge */ /* synthetic */ void zze(Object obj) {
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v13, resolved type: com.google.android.gms.internal.ads.zzoq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v5, resolved type: com.google.android.gms.internal.ads.zzoq} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v31, resolved type: com.google.android.gms.internal.ads.zzbbw} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r0v19, resolved type: com.google.android.gms.internal.ads.zzoq} */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x00c9, code lost:
        if (r9.zzamk.remaining() > 0) goto L_0x00d0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:36:0x00cb, code lost:
        zzzz();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00d2, code lost:
        if (r9.zzeor != false) goto L_0x0112;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00d4, code lost:
        r12 = r1.currentTimeMillis();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x00dc, code lost:
        if ((r12 - r16) < r4) goto L_0x00e3;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00de, code lost:
        zzzz();
        r16 = r12;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00ea, code lost:
        if ((r12 - r2) > (1000 * r6)) goto L_0x00f2;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:?, code lost:
        r1 = new java.lang.StringBuilder(49);
        r1.append("Timeout exceeded. Limit: ");
        r1.append(r6);
        r1.append(" sec");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:49:0x0111, code lost:
        throw new java.io.IOException(r1.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:50:0x0112, code lost:
        r12 = "externalAbort";
     */
    /* JADX WARNING: Code restructure failed: missing block: B:52:?, code lost:
        r1 = r9.zzamk.limit();
        r3 = new java.lang.StringBuilder(35);
        r3.append("Precache abort at ");
        r3.append(r1);
        r3.append(" bytes");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:53:0x0137, code lost:
        throw new java.io.IOException(r3.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:60:0x013d, code lost:
        r0 = e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:61:0x013e, code lost:
        r12 = r18;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:72:?, code lost:
        return true;
     */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzfj(java.lang.String r22) {
        /*
            r21 = this;
            r9 = r21
            r10 = r22
            r9.url = r10
            java.lang.String r11 = r21.zzfk(r22)
            java.lang.String r12 = "error"
            r13 = 0
            com.google.android.gms.internal.ads.zzoq r0 = new com.google.android.gms.internal.ads.zzoq     // Catch:{ Exception -> 0x0143 }
            java.lang.String r2 = r9.zzefk     // Catch:{ Exception -> 0x0143 }
            r3 = 0
            com.google.android.gms.internal.ads.zzbbf r1 = r9.zzelt     // Catch:{ Exception -> 0x0143 }
            int r5 = r1.zzeku     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzbbf r1 = r9.zzelt     // Catch:{ Exception -> 0x0143 }
            int r6 = r1.zzekw     // Catch:{ Exception -> 0x0143 }
            r7 = 1
            r8 = 0
            r1 = r0
            r4 = r21
            r1.<init>(r2, r3, r4, r5, r6, r7, r8)     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzbbf r1 = r9.zzelt     // Catch:{ Exception -> 0x0143 }
            boolean r1 = r1.zzela     // Catch:{ Exception -> 0x0143 }
            if (r1 == 0) goto L_0x003c
            com.google.android.gms.internal.ads.zzbbw r8 = new com.google.android.gms.internal.ads.zzbbw     // Catch:{ Exception -> 0x0039 }
            android.content.Context r2 = r9.mContext     // Catch:{ Exception -> 0x0039 }
            java.lang.String r4 = r9.zzbvf     // Catch:{ Exception -> 0x0039 }
            int r5 = r9.zzbvg     // Catch:{ Exception -> 0x0039 }
            r6 = 0
            r7 = 0
            r1 = r8
            r3 = r0
            r1.<init>(r2, r3, r4, r5, r6, r7)     // Catch:{ Exception -> 0x0039 }
            r0 = r8
            goto L_0x003c
        L_0x0039:
            r0 = move-exception
            goto L_0x0146
        L_0x003c:
            android.net.Uri r1 = android.net.Uri.parse(r22)     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzoo r2 = new com.google.android.gms.internal.ads.zzoo     // Catch:{ Exception -> 0x0143 }
            r2.<init>(r1)     // Catch:{ Exception -> 0x0143 }
            r0.zza(r2)     // Catch:{ Exception -> 0x0143 }
            java.lang.ref.WeakReference r1 = r9.zzeog     // Catch:{ Exception -> 0x0143 }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzbbe r1 = (com.google.android.gms.internal.ads.zzbbe) r1     // Catch:{ Exception -> 0x0143 }
            if (r1 == 0) goto L_0x0055
            r1.zza((java.lang.String) r11, (com.google.android.gms.internal.ads.zzbcx) r9)     // Catch:{ Exception -> 0x0039 }
        L_0x0055:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ Exception -> 0x0143 }
            long r2 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r4 = com.google.android.gms.internal.ads.zzabf.zzcmj     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzabb r5 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x0143 }
            java.lang.Object r4 = r5.zzd(r4)     // Catch:{ Exception -> 0x0143 }
            java.lang.Long r4 = (java.lang.Long) r4     // Catch:{ Exception -> 0x0143 }
            long r4 = r4.longValue()     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r6 = com.google.android.gms.internal.ads.zzabf.zzcmi     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzabb r7 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ Exception -> 0x0143 }
            java.lang.Object r6 = r7.zzd(r6)     // Catch:{ Exception -> 0x0143 }
            java.lang.Long r6 = (java.lang.Long) r6     // Catch:{ Exception -> 0x0143 }
            long r6 = r6.longValue()     // Catch:{ Exception -> 0x0143 }
            com.google.android.gms.internal.ads.zzbbf r8 = r9.zzelt     // Catch:{ Exception -> 0x0143 }
            int r8 = r8.zzekt     // Catch:{ Exception -> 0x0143 }
            java.nio.ByteBuffer r8 = java.nio.ByteBuffer.allocate(r8)     // Catch:{ Exception -> 0x0143 }
            r9.zzamk = r8     // Catch:{ Exception -> 0x0143 }
            r8 = 8192(0x2000, float:1.14794E-41)
            byte[] r15 = new byte[r8]     // Catch:{ Exception -> 0x0143 }
            r16 = r2
        L_0x008d:
            java.nio.ByteBuffer r14 = r9.zzamk     // Catch:{ Exception -> 0x0143 }
            int r14 = r14.remaining()     // Catch:{ Exception -> 0x0143 }
            int r14 = java.lang.Math.min(r14, r8)     // Catch:{ Exception -> 0x0143 }
            int r14 = r0.read(r15, r13, r14)     // Catch:{ Exception -> 0x0143 }
            r8 = -1
            if (r14 != r8) goto L_0x00b0
            r8 = 1
            r9.zzepb = r8     // Catch:{ Exception -> 0x0039 }
            com.google.android.gms.internal.ads.zzbcp r0 = r9.zzeoy     // Catch:{ Exception -> 0x0039 }
            java.nio.ByteBuffer r1 = r9.zzamk     // Catch:{ Exception -> 0x0039 }
            long r0 = r0.zzq(r1)     // Catch:{ Exception -> 0x0039 }
            int r1 = (int) r0     // Catch:{ Exception -> 0x0039 }
            long r0 = (long) r1     // Catch:{ Exception -> 0x0039 }
            r9.zzc(r10, r11, r0)     // Catch:{ Exception -> 0x0039 }
        L_0x00ae:
            r1 = 1
            goto L_0x00cf
        L_0x00b0:
            java.lang.Object r8 = r9.zzepa     // Catch:{ Exception -> 0x0143 }
            monitor-enter(r8)     // Catch:{ Exception -> 0x0143 }
            boolean r13 = r9.zzeor     // Catch:{ all -> 0x0138 }
            if (r13 != 0) goto L_0x00c0
            java.nio.ByteBuffer r13 = r9.zzamk     // Catch:{ all -> 0x0138 }
            r18 = r12
            r12 = 0
            r13.put(r15, r12, r14)     // Catch:{ all -> 0x0141 }
            goto L_0x00c2
        L_0x00c0:
            r18 = r12
        L_0x00c2:
            monitor-exit(r8)     // Catch:{ all -> 0x0141 }
            java.nio.ByteBuffer r8 = r9.zzamk     // Catch:{ Exception -> 0x013d }
            int r8 = r8.remaining()     // Catch:{ Exception -> 0x013d }
            if (r8 > 0) goto L_0x00d0
            r21.zzzz()     // Catch:{ Exception -> 0x013d }
            goto L_0x00ae
        L_0x00cf:
            return r1
        L_0x00d0:
            boolean r8 = r9.zzeor     // Catch:{ Exception -> 0x013d }
            if (r8 != 0) goto L_0x0112
            long r12 = r1.currentTimeMillis()     // Catch:{ Exception -> 0x013d }
            long r19 = r12 - r16
            int r8 = (r19 > r4 ? 1 : (r19 == r4 ? 0 : -1))
            if (r8 < 0) goto L_0x00e3
            r21.zzzz()     // Catch:{ Exception -> 0x013d }
            r16 = r12
        L_0x00e3:
            long r12 = r12 - r2
            r19 = 1000(0x3e8, double:4.94E-321)
            long r19 = r19 * r6
            int r8 = (r12 > r19 ? 1 : (r12 == r19 ? 0 : -1))
            if (r8 > 0) goto L_0x00f2
            r12 = r18
            r8 = 8192(0x2000, float:1.14794E-41)
            r13 = 0
            goto L_0x008d
        L_0x00f2:
            java.lang.String r12 = "downloadTimeout"
            r0 = 49
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r0 = "Timeout exceeded. Limit: "
            r1.append(r0)     // Catch:{ Exception -> 0x0039 }
            r1.append(r6)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r0 = " sec"
            r1.append(r0)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r0 = r1.toString()     // Catch:{ Exception -> 0x0039 }
            java.io.IOException r1 = new java.io.IOException     // Catch:{ Exception -> 0x0039 }
            r1.<init>(r0)     // Catch:{ Exception -> 0x0039 }
            throw r1     // Catch:{ Exception -> 0x0039 }
        L_0x0112:
            java.lang.String r12 = "externalAbort"
            java.io.IOException r0 = new java.io.IOException     // Catch:{ Exception -> 0x0039 }
            java.nio.ByteBuffer r1 = r9.zzamk     // Catch:{ Exception -> 0x0039 }
            int r1 = r1.limit()     // Catch:{ Exception -> 0x0039 }
            r2 = 35
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ Exception -> 0x0039 }
            r3.<init>(r2)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r2 = "Precache abort at "
            r3.append(r2)     // Catch:{ Exception -> 0x0039 }
            r3.append(r1)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = " bytes"
            r3.append(r1)     // Catch:{ Exception -> 0x0039 }
            java.lang.String r1 = r3.toString()     // Catch:{ Exception -> 0x0039 }
            r0.<init>(r1)     // Catch:{ Exception -> 0x0039 }
            throw r0     // Catch:{ Exception -> 0x0039 }
        L_0x0138:
            r0 = move-exception
            r18 = r12
        L_0x013b:
            monitor-exit(r8)     // Catch:{ all -> 0x0141 }
            throw r0     // Catch:{ Exception -> 0x013d }
        L_0x013d:
            r0 = move-exception
            r12 = r18
            goto L_0x0146
        L_0x0141:
            r0 = move-exception
            goto L_0x013b
        L_0x0143:
            r0 = move-exception
            r18 = r12
        L_0x0146:
            java.lang.Class r1 = r0.getClass()
            java.lang.String r1 = r1.getCanonicalName()
            java.lang.String r0 = r0.getMessage()
            java.lang.String r2 = java.lang.String.valueOf(r1)
            int r2 = r2.length()
            r3 = 1
            int r2 = r2 + r3
            java.lang.String r3 = java.lang.String.valueOf(r0)
            int r3 = r3.length()
            int r2 = r2 + r3
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>(r2)
            r3.append(r1)
            java.lang.String r1 = ":"
            r3.append(r1)
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            java.lang.String r1 = java.lang.String.valueOf(r22)
            int r1 = r1.length()
            int r1 = r1 + 34
            java.lang.String r2 = java.lang.String.valueOf(r0)
            int r2 = r2.length()
            int r1 = r1 + r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r1)
            java.lang.String r1 = "Failed to preload url "
            r2.append(r1)
            r2.append(r10)
            java.lang.String r1 = " Exception: "
            r2.append(r1)
            r2.append(r0)
            java.lang.String r1 = r2.toString()
            com.google.android.gms.ads.internal.util.zzd.zzfa(r1)
            r9.zza(r10, r11, r12, r0)
            r1 = 0
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdj.zzfj(java.lang.String):boolean");
    }

    /* access modifiers changed from: protected */
    public final String zzfk(String str) {
        String valueOf = String.valueOf("cache:");
        String valueOf2 = String.valueOf(super.zzfk(str));
        return valueOf2.length() != 0 ? valueOf.concat(valueOf2) : new String(valueOf);
    }
}
