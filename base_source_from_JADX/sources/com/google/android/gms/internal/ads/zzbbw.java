package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.IOUtils;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.atomic.AtomicLong;

public final class zzbbw implements zzon {
    private final Context context;
    private boolean isOpen;
    private Uri uri;
    private boolean zzbuu = false;
    private long zzbuw = 0;
    private boolean zzbux = false;
    private final String zzbvf;
    private final int zzbvg;
    private final zzpd<zzon> zzemf;
    private final zzon zzemg;
    private final zzbby zzemh;
    private final boolean zzemi = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue();
    private InputStream zzemj;
    private volatile zztf zzemk;
    private boolean zzeml = false;
    private boolean zzemm = false;
    private zzdyz<Long> zzemn = null;
    private final AtomicLong zzemo = new AtomicLong(-1);

    public zzbbw(Context context2, zzon zzon, String str, int i, zzpd<zzon> zzpd, zzbby zzbby) {
        this.context = context2;
        this.zzemg = zzon;
        this.zzemf = zzpd;
        this.zzemh = zzbby;
        this.zzbvf = str;
        this.zzbvg = i;
    }

    private final boolean zzabn() {
        if (!this.zzemi) {
            return false;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcti)).booleanValue() && !this.zzbux) {
            return true;
        }
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzctj)).booleanValue() && !this.zzemm;
    }

    private final void zzb(zzoo zzoo) {
        zzpd<zzon> zzpd = this.zzemf;
        if (zzpd != null) {
            zzpd.zza(this, zzoo);
        }
    }

    public final void close() {
        zzpd<zzon> zzpd;
        if (this.isOpen) {
            boolean z = false;
            this.isOpen = false;
            this.uri = null;
            if (!this.zzemi || this.zzemj != null) {
                z = true;
            }
            InputStream inputStream = this.zzemj;
            if (inputStream != null) {
                IOUtils.closeQuietly((Closeable) inputStream);
                this.zzemj = null;
            } else {
                this.zzemg.close();
            }
            if (z && (zzpd = this.zzemf) != null) {
                zzpd.zze(this);
                return;
            }
            return;
        }
        throw new IOException("Attempt to close an already closed CacheDataSource.");
    }

    public final long getContentLength() {
        if (this.zzemk == null) {
            return -1;
        }
        if (this.zzemo.get() == -1) {
            synchronized (this) {
                if (this.zzemn == null) {
                    this.zzemn = zzazj.zzegp.zze(new zzbbz(this));
                }
            }
            if (!this.zzemn.isDone()) {
                return -1;
            }
            try {
                this.zzemo.compareAndSet(-1, ((Long) this.zzemn.get()).longValue());
            } catch (InterruptedException | ExecutionException unused) {
                return -1;
            }
        }
        return this.zzemo.get();
    }

    public final Uri getUri() {
        return this.uri;
    }

    public final int read(byte[] bArr, int i, int i2) {
        zzpd<zzon> zzpd;
        if (this.isOpen) {
            InputStream inputStream = this.zzemj;
            int read = inputStream != null ? inputStream.read(bArr, i, i2) : this.zzemg.read(bArr, i, i2);
            if ((!this.zzemi || this.zzemj != null) && (zzpd = this.zzemf) != null) {
                zzpd.zzc(this, read);
            }
            return read;
        }
        throw new IOException("Attempt to read closed CacheDataSource.");
    }

    /* JADX WARNING: Removed duplicated region for block: B:62:0x01e1  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:34:0x0105=Splitter:B:34:0x0105, B:39:0x0126=Splitter:B:39:0x0126} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final long zza(com.google.android.gms.internal.ads.zzoo r13) {
        /*
            r12 = this;
            boolean r0 = r12.isOpen
            if (r0 != 0) goto L_0x0203
            r0 = 1
            r12.isOpen = r0
            android.net.Uri r1 = r13.uri
            r12.uri = r1
            boolean r1 = r12.zzemi
            if (r1 != 0) goto L_0x0012
            r12.zzb(r13)
        L_0x0012:
            android.net.Uri r1 = r13.uri
            com.google.android.gms.internal.ads.zztf r1 = com.google.android.gms.internal.ads.zztf.zzd(r1)
            r12.zzemk = r1
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r1 = com.google.android.gms.internal.ads.zzabf.zzctf
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Boolean r1 = (java.lang.Boolean) r1
            boolean r1 = r1.booleanValue()
            r2 = -1
            r4 = 0
            if (r1 == 0) goto L_0x0180
            com.google.android.gms.internal.ads.zztf r1 = r12.zzemk
            if (r1 == 0) goto L_0x01db
            com.google.android.gms.internal.ads.zztf r1 = r12.zzemk
            long r5 = r13.position
            r1.zzbve = r5
            com.google.android.gms.internal.ads.zztf r1 = r12.zzemk
            java.lang.String r5 = r12.zzbvf
            java.lang.String r5 = com.google.android.gms.internal.ads.zzdwc.zzhg(r5)
            r1.zzbvf = r5
            com.google.android.gms.internal.ads.zztf r1 = r12.zzemk
            int r5 = r12.zzbvg
            r1.zzbvg = r5
            com.google.android.gms.internal.ads.zztf r1 = r12.zzemk
            boolean r1 = r1.zzbvd
            if (r1 == 0) goto L_0x0052
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabf.zzcth
            goto L_0x0054
        L_0x0052:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Long> r1 = com.google.android.gms.internal.ads.zzabf.zzctg
        L_0x0054:
            com.google.android.gms.internal.ads.zzabb r5 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r1 = r5.zzd(r1)
            java.lang.Long r1 = (java.lang.Long) r1
            long r5 = r1.longValue()
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r7 = r1.elapsedRealtime()
            com.google.android.gms.ads.internal.zzp.zzlk()
            android.content.Context r1 = r12.context
            com.google.android.gms.internal.ads.zztf r9 = r12.zzemk
            java.util.concurrent.Future r1 = com.google.android.gms.internal.ads.zztq.zza(r1, r9)
            r9 = 44
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ ExecutionException | TimeoutException -> 0x0125, InterruptedException -> 0x0104, all -> 0x0101 }
            java.lang.Object r5 = r1.get(r5, r10)     // Catch:{ ExecutionException | TimeoutException -> 0x0125, InterruptedException -> 0x0104, all -> 0x0101 }
            com.google.android.gms.internal.ads.zztt r5 = (com.google.android.gms.internal.ads.zztt) r5     // Catch:{ ExecutionException | TimeoutException -> 0x0125, InterruptedException -> 0x0104, all -> 0x0101 }
            boolean r6 = r5.zzmy()     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            r12.zzbuu = r6     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            boolean r6 = r5.zznb()     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            r12.zzbux = r6     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            boolean r6 = r5.zzmz()     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            r12.zzemm = r6     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            long r10 = r5.zzna()     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            r12.zzbuw = r10     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            boolean r6 = r12.zzabn()     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            if (r6 != 0) goto L_0x00d4
            java.io.InputStream r5 = r5.getInputStream()     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            r12.zzemj = r5     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            boolean r5 = r12.zzemi     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
            if (r5 == 0) goto L_0x00aa
            r12.zzb(r13)     // Catch:{ ExecutionException | TimeoutException -> 0x00ff, InterruptedException -> 0x00fd, all -> 0x00fb }
        L_0x00aa:
            com.google.android.gms.common.util.Clock r13 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r4 = r13.elapsedRealtime()
            long r4 = r4 - r7
            com.google.android.gms.internal.ads.zzbby r13 = r12.zzemh
            r13.zzb(r0, r4)
            r12.zzeml = r0
            java.lang.StringBuilder r13 = new java.lang.StringBuilder
            r13.<init>(r9)
            java.lang.String r0 = "Cache connection took "
            r13.append(r0)
            r13.append(r4)
            java.lang.String r0 = "ms"
            r13.append(r0)
            java.lang.String r13 = r13.toString()
            com.google.android.gms.ads.internal.util.zzd.zzee(r13)
            return r2
        L_0x00d4:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r1 = r1.elapsedRealtime()
            long r1 = r1 - r7
            com.google.android.gms.internal.ads.zzbby r3 = r12.zzemh
            r3.zzb(r0, r1)
            r12.zzeml = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r9)
            java.lang.String r3 = "Cache connection took "
            r0.append(r3)
            r0.append(r1)
            java.lang.String r1 = "ms"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            goto L_0x014f
        L_0x00fb:
            r13 = move-exception
            goto L_0x0156
        L_0x00fd:
            r2 = 1
            goto L_0x0105
        L_0x00ff:
            r2 = 1
            goto L_0x0126
        L_0x0101:
            r13 = move-exception
            r0 = 0
            goto L_0x0156
        L_0x0104:
            r2 = 0
        L_0x0105:
            r1.cancel(r0)     // Catch:{ all -> 0x0154 }
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0154 }
            r0.interrupt()     // Catch:{ all -> 0x0154 }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r0 = r0.elapsedRealtime()
            long r0 = r0 - r7
            com.google.android.gms.internal.ads.zzbby r3 = r12.zzemh
            r3.zzb(r2, r0)
            r12.zzeml = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
            goto L_0x013e
        L_0x0125:
            r2 = 0
        L_0x0126:
            r1.cancel(r0)     // Catch:{ all -> 0x0154 }
            com.google.android.gms.common.util.Clock r0 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r0 = r0.elapsedRealtime()
            long r0 = r0 - r7
            com.google.android.gms.internal.ads.zzbby r3 = r12.zzemh
            r3.zzb(r2, r0)
            r12.zzeml = r2
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>(r9)
        L_0x013e:
            java.lang.String r3 = "Cache connection took "
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "ms"
            r2.append(r0)
            java.lang.String r0 = r2.toString()
        L_0x014f:
            com.google.android.gms.ads.internal.util.zzd.zzee(r0)
            goto L_0x01db
        L_0x0154:
            r13 = move-exception
            r0 = r2
        L_0x0156:
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r1 = r1.elapsedRealtime()
            long r1 = r1 - r7
            com.google.android.gms.internal.ads.zzbby r3 = r12.zzemh
            r3.zzb(r0, r1)
            r12.zzeml = r0
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>(r9)
            java.lang.String r3 = "Cache connection took "
            r0.append(r3)
            r0.append(r1)
            java.lang.String r1 = "ms"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            com.google.android.gms.ads.internal.util.zzd.zzee(r0)
            throw r13
        L_0x0180:
            r1 = 0
            com.google.android.gms.internal.ads.zztf r5 = r12.zzemk
            if (r5 == 0) goto L_0x01a5
            com.google.android.gms.internal.ads.zztf r1 = r12.zzemk
            long r5 = r13.position
            r1.zzbve = r5
            com.google.android.gms.internal.ads.zztf r1 = r12.zzemk
            java.lang.String r5 = r12.zzbvf
            java.lang.String r5 = com.google.android.gms.internal.ads.zzdwc.zzhg(r5)
            r1.zzbvf = r5
            com.google.android.gms.internal.ads.zztf r1 = r12.zzemk
            int r5 = r12.zzbvg
            r1.zzbvg = r5
            com.google.android.gms.internal.ads.zzsx r1 = com.google.android.gms.ads.internal.zzp.zzkw()
            com.google.android.gms.internal.ads.zztf r5 = r12.zzemk
            com.google.android.gms.internal.ads.zzta r1 = r1.zza((com.google.android.gms.internal.ads.zztf) r5)
        L_0x01a5:
            if (r1 == 0) goto L_0x01db
            boolean r5 = r1.zzmv()
            if (r5 == 0) goto L_0x01db
            boolean r5 = r1.zzmy()
            r12.zzbuu = r5
            boolean r5 = r1.zznb()
            r12.zzbux = r5
            boolean r5 = r1.zzmz()
            r12.zzemm = r5
            long r5 = r1.zzna()
            r12.zzbuw = r5
            r12.zzeml = r0
            boolean r0 = r12.zzabn()
            if (r0 != 0) goto L_0x01db
            java.io.InputStream r0 = r1.zzmw()
            r12.zzemj = r0
            boolean r0 = r12.zzemi
            if (r0 == 0) goto L_0x01da
            r12.zzb(r13)
        L_0x01da:
            return r2
        L_0x01db:
            r12.zzeml = r4
            com.google.android.gms.internal.ads.zztf r0 = r12.zzemk
            if (r0 == 0) goto L_0x01fc
            com.google.android.gms.internal.ads.zzoo r0 = new com.google.android.gms.internal.ads.zzoo
            com.google.android.gms.internal.ads.zztf r1 = r12.zzemk
            java.lang.String r1 = r1.url
            android.net.Uri r2 = android.net.Uri.parse(r1)
            byte[] r3 = r13.zzbia
            long r4 = r13.zzbib
            long r6 = r13.position
            long r8 = r13.zzcm
            java.lang.String r10 = r13.zzck
            int r11 = r13.flags
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r8, r10, r11)
            r13 = r0
        L_0x01fc:
            com.google.android.gms.internal.ads.zzon r0 = r12.zzemg
            long r0 = r0.zza(r13)
            return r0
        L_0x0203:
            java.io.IOException r13 = new java.io.IOException
            java.lang.String r0 = "Attempt to open an already open CacheDataSource."
            r13.<init>(r0)
            throw r13
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbbw.zza(com.google.android.gms.internal.ads.zzoo):long");
    }

    public final boolean zzabl() {
        return this.zzeml;
    }

    public final boolean zzabm() {
        return this.zzemm;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Long zzabo() {
        return Long.valueOf(zzp.zzkw().zzb(this.zzemk));
    }

    public final boolean zzmy() {
        return this.zzbuu;
    }

    public final long zzna() {
        return this.zzbuw;
    }

    public final boolean zznb() {
        return this.zzbux;
    }
}
