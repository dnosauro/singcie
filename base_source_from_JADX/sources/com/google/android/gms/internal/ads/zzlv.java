package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Looper;
import android.os.SystemClock;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.List;

@TargetApi(19)
public abstract class zzlv extends zzhc {
    private static final byte[] zzbbj = zzpt.zzbi("0000016742C00BDA259000000168CE0F13200000016588840DCE7118A0002FBF1C31C3275D78");
    private zzhp zzahv;
    private ByteBuffer[] zzalb;
    private final zzlx zzbbk;
    private final zzjt<zzjv> zzbbl;
    private final boolean zzbbm;
    private final zzjl zzbbn;
    private final zzjl zzbbo;
    private final zzhr zzbbp;
    private final List<Long> zzbbq;
    private final MediaCodec.BufferInfo zzbbr;
    private zzjr<zzjv> zzbbs;
    private zzjr<zzjv> zzbbt;
    private MediaCodec zzbbu;
    private zzls zzbbv;
    private boolean zzbbw;
    private boolean zzbbx;
    private boolean zzbby;
    private boolean zzbbz;
    private boolean zzbca;
    private boolean zzbcb;
    private boolean zzbcc;
    private boolean zzbcd;
    private boolean zzbce;
    private ByteBuffer[] zzbcf;
    private long zzbcg;
    private int zzbch;
    private int zzbci;
    private boolean zzbcj;
    private boolean zzbck;
    private int zzbcl;
    private int zzbcm;
    private boolean zzbcn;
    private boolean zzbco;
    private boolean zzbcp;
    private boolean zzbcq;
    private boolean zzbcr;
    private boolean zzbcs;
    protected zzjm zzbct;

    public zzlv(int i, zzlx zzlx, zzjt<zzjv> zzjt, boolean z) {
        super(i);
        zzpc.checkState(zzpt.SDK_INT >= 16);
        this.zzbbk = (zzlx) zzpc.checkNotNull(zzlx);
        this.zzbbl = null;
        this.zzbbm = z;
        this.zzbbn = new zzjl(0);
        this.zzbbo = new zzjl(0);
        this.zzbbp = new zzhr();
        this.zzbbq = new ArrayList();
        this.zzbbr = new MediaCodec.BufferInfo();
        this.zzbcl = 0;
        this.zzbcm = 0;
    }

    private final void zza(zzlu zzlu) {
        throw zzhe.zza(zzlu, getIndex());
    }

    private final boolean zzd(long j, long j2) {
        boolean z;
        boolean z2;
        if (this.zzbci < 0) {
            if (!this.zzbcb || !this.zzbco) {
                this.zzbci = this.zzbbu.dequeueOutputBuffer(this.zzbbr, 0);
            } else {
                try {
                    this.zzbci = this.zzbbu.dequeueOutputBuffer(this.zzbbr, 0);
                } catch (IllegalStateException unused) {
                    zzhi();
                    if (this.zzbcq) {
                        zzhg();
                    }
                    return false;
                }
            }
            int i = this.zzbci;
            if (i >= 0) {
                if (this.zzbce) {
                    this.zzbce = false;
                    this.zzbbu.releaseOutputBuffer(i, false);
                    this.zzbci = -1;
                    return true;
                } else if ((this.zzbbr.flags & 4) != 0) {
                    zzhi();
                    this.zzbci = -1;
                    return false;
                } else {
                    ByteBuffer byteBuffer = this.zzalb[this.zzbci];
                    if (byteBuffer != null) {
                        byteBuffer.position(this.zzbbr.offset);
                        byteBuffer.limit(this.zzbbr.offset + this.zzbbr.size);
                    }
                    long j3 = this.zzbbr.presentationTimeUs;
                    int size = this.zzbbq.size();
                    int i2 = 0;
                    while (true) {
                        if (i2 >= size) {
                            z2 = false;
                            break;
                        } else if (this.zzbbq.get(i2).longValue() == j3) {
                            this.zzbbq.remove(i2);
                            z2 = true;
                            break;
                        } else {
                            i2++;
                        }
                    }
                    this.zzbcj = z2;
                }
            } else if (i == -2) {
                MediaFormat outputFormat = this.zzbbu.getOutputFormat();
                if (this.zzbby && outputFormat.getInteger("width") == 32 && outputFormat.getInteger("height") == 32) {
                    this.zzbce = true;
                } else {
                    if (this.zzbcc) {
                        outputFormat.setInteger("channel-count", 1);
                    }
                    onOutputFormatChanged(this.zzbbu, outputFormat);
                }
                return true;
            } else if (i == -3) {
                this.zzalb = this.zzbbu.getOutputBuffers();
                return true;
            } else {
                if (this.zzbbz && (this.zzbcp || this.zzbcm == 2)) {
                    zzhi();
                }
                return false;
            }
        }
        if (!this.zzbcb || !this.zzbco) {
            MediaCodec mediaCodec = this.zzbbu;
            ByteBuffer[] byteBufferArr = this.zzalb;
            int i3 = this.zzbci;
            z = zza(j, j2, mediaCodec, byteBufferArr[i3], i3, this.zzbbr.flags, this.zzbbr.presentationTimeUs, this.zzbcj);
        } else {
            try {
                z = zza(j, j2, this.zzbbu, this.zzalb[this.zzbci], this.zzbci, this.zzbbr.flags, this.zzbbr.presentationTimeUs, this.zzbcj);
            } catch (IllegalStateException unused2) {
                zzhi();
                if (this.zzbcq) {
                    zzhg();
                }
                return false;
            }
        }
        if (!z) {
            return false;
        }
        long j4 = this.zzbbr.presentationTimeUs;
        this.zzbci = -1;
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:84:0x014b A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:85:0x014c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzhh() {
        /*
            r14 = this;
            android.media.MediaCodec r0 = r14.zzbbu
            r1 = 0
            if (r0 == 0) goto L_0x01d6
            int r2 = r14.zzbcm
            r3 = 2
            if (r2 == r3) goto L_0x01d6
            boolean r2 = r14.zzbcp
            if (r2 == 0) goto L_0x0010
            goto L_0x01d6
        L_0x0010:
            int r2 = r14.zzbch
            if (r2 >= 0) goto L_0x002c
            r4 = 0
            int r0 = r0.dequeueInputBuffer(r4)
            r14.zzbch = r0
            int r0 = r14.zzbch
            if (r0 >= 0) goto L_0x0021
            return r1
        L_0x0021:
            com.google.android.gms.internal.ads.zzjl r2 = r14.zzbbn
            java.nio.ByteBuffer[] r4 = r14.zzbcf
            r0 = r4[r0]
            r2.zzda = r0
            r2.clear()
        L_0x002c:
            int r0 = r14.zzbcm
            r2 = -1
            r4 = 1
            if (r0 != r4) goto L_0x0049
            boolean r0 = r14.zzbbz
            if (r0 != 0) goto L_0x0046
            r14.zzbco = r4
            android.media.MediaCodec r5 = r14.zzbbu
            int r6 = r14.zzbch
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzbch = r2
        L_0x0046:
            r14.zzbcm = r3
            return r1
        L_0x0049:
            boolean r0 = r14.zzbcd
            if (r0 == 0) goto L_0x006b
            r14.zzbcd = r1
            com.google.android.gms.internal.ads.zzjl r0 = r14.zzbbn
            java.nio.ByteBuffer r0 = r0.zzda
            byte[] r1 = zzbbj
            r0.put(r1)
            android.media.MediaCodec r5 = r14.zzbbu
            int r6 = r14.zzbch
            r7 = 0
            byte[] r0 = zzbbj
            int r8 = r0.length
            r9 = 0
            r11 = 0
            r5.queueInputBuffer(r6, r7, r8, r9, r11)
            r14.zzbch = r2
            r14.zzbcn = r4
            return r4
        L_0x006b:
            boolean r0 = r14.zzbcr
            if (r0 == 0) goto L_0x0072
            r0 = -4
            r5 = 0
            goto L_0x00aa
        L_0x0072:
            int r0 = r14.zzbcl
            if (r0 != r4) goto L_0x0097
            r0 = 0
        L_0x0077:
            com.google.android.gms.internal.ads.zzhp r5 = r14.zzahv
            java.util.List<byte[]> r5 = r5.zzahc
            int r5 = r5.size()
            if (r0 >= r5) goto L_0x0095
            com.google.android.gms.internal.ads.zzhp r5 = r14.zzahv
            java.util.List<byte[]> r5 = r5.zzahc
            java.lang.Object r5 = r5.get(r0)
            byte[] r5 = (byte[]) r5
            com.google.android.gms.internal.ads.zzjl r6 = r14.zzbbn
            java.nio.ByteBuffer r6 = r6.zzda
            r6.put(r5)
            int r0 = r0 + 1
            goto L_0x0077
        L_0x0095:
            r14.zzbcl = r3
        L_0x0097:
            com.google.android.gms.internal.ads.zzjl r0 = r14.zzbbn
            java.nio.ByteBuffer r0 = r0.zzda
            int r0 = r0.position()
            com.google.android.gms.internal.ads.zzhr r5 = r14.zzbbp
            com.google.android.gms.internal.ads.zzjl r6 = r14.zzbbn
            int r5 = r14.zza((com.google.android.gms.internal.ads.zzhr) r5, (com.google.android.gms.internal.ads.zzjl) r6, (boolean) r1)
            r13 = r5
            r5 = r0
            r0 = r13
        L_0x00aa:
            r6 = -3
            if (r0 != r6) goto L_0x00ae
            return r1
        L_0x00ae:
            r6 = -5
            if (r0 != r6) goto L_0x00c4
            int r0 = r14.zzbcl
            if (r0 != r3) goto L_0x00bc
            com.google.android.gms.internal.ads.zzjl r0 = r14.zzbbn
            r0.clear()
            r14.zzbcl = r4
        L_0x00bc:
            com.google.android.gms.internal.ads.zzhr r0 = r14.zzbbp
            com.google.android.gms.internal.ads.zzhp r0 = r0.zzahv
            r14.zzd(r0)
            return r4
        L_0x00c4:
            com.google.android.gms.internal.ads.zzjl r0 = r14.zzbbn
            boolean r0 = r0.zzgl()
            if (r0 == 0) goto L_0x0100
            int r0 = r14.zzbcl
            if (r0 != r3) goto L_0x00d7
            com.google.android.gms.internal.ads.zzjl r0 = r14.zzbbn
            r0.clear()
            r14.zzbcl = r4
        L_0x00d7:
            r14.zzbcp = r4
            boolean r0 = r14.zzbcn
            if (r0 != 0) goto L_0x00e1
            r14.zzhi()
            return r1
        L_0x00e1:
            boolean r0 = r14.zzbbz     // Catch:{ CryptoException -> 0x00f6 }
            if (r0 != 0) goto L_0x00f5
            r14.zzbco = r4     // Catch:{ CryptoException -> 0x00f6 }
            android.media.MediaCodec r5 = r14.zzbbu     // Catch:{ CryptoException -> 0x00f6 }
            int r6 = r14.zzbch     // Catch:{ CryptoException -> 0x00f6 }
            r7 = 0
            r8 = 0
            r9 = 0
            r11 = 4
            r5.queueInputBuffer(r6, r7, r8, r9, r11)     // Catch:{ CryptoException -> 0x00f6 }
            r14.zzbch = r2     // Catch:{ CryptoException -> 0x00f6 }
        L_0x00f5:
            return r1
        L_0x00f6:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhe r0 = com.google.android.gms.internal.ads.zzhe.zza(r0, r1)
            throw r0
        L_0x0100:
            boolean r0 = r14.zzbcs
            if (r0 == 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzjl r0 = r14.zzbbn
            boolean r0 = r0.zzgm()
            if (r0 != 0) goto L_0x0118
            com.google.android.gms.internal.ads.zzjl r0 = r14.zzbbn
            r0.clear()
            int r0 = r14.zzbcl
            if (r0 != r3) goto L_0x0117
            r14.zzbcl = r4
        L_0x0117:
            return r4
        L_0x0118:
            r14.zzbcs = r1
            com.google.android.gms.internal.ads.zzjl r0 = r14.zzbbn
            boolean r0 = r0.isEncrypted()
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r3 = r14.zzbbs
            if (r3 == 0) goto L_0x0144
            int r3 = r3.getState()
            if (r3 == 0) goto L_0x0135
            r6 = 4
            if (r3 == r6) goto L_0x0144
            if (r0 != 0) goto L_0x0133
            boolean r3 = r14.zzbbm
            if (r3 != 0) goto L_0x0144
        L_0x0133:
            r3 = 1
            goto L_0x0145
        L_0x0135:
            com.google.android.gms.internal.ads.zzjr<com.google.android.gms.internal.ads.zzjv> r0 = r14.zzbbs
            com.google.android.gms.internal.ads.zzjq r0 = r0.zzgp()
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhe r0 = com.google.android.gms.internal.ads.zzhe.zza(r0, r1)
            throw r0
        L_0x0144:
            r3 = 0
        L_0x0145:
            r14.zzbcr = r3
            boolean r3 = r14.zzbcr
            if (r3 == 0) goto L_0x014c
            return r1
        L_0x014c:
            boolean r3 = r14.zzbbw
            if (r3 == 0) goto L_0x0166
            if (r0 != 0) goto L_0x0166
            com.google.android.gms.internal.ads.zzjl r3 = r14.zzbbn
            java.nio.ByteBuffer r3 = r3.zzda
            com.google.android.gms.internal.ads.zzpi.zzp(r3)
            com.google.android.gms.internal.ads.zzjl r3 = r14.zzbbn
            java.nio.ByteBuffer r3 = r3.zzda
            int r3 = r3.position()
            if (r3 != 0) goto L_0x0164
            return r4
        L_0x0164:
            r14.zzbbw = r1
        L_0x0166:
            com.google.android.gms.internal.ads.zzjl r3 = r14.zzbbn     // Catch:{ CryptoException -> 0x01cc }
            long r10 = r3.zzanz     // Catch:{ CryptoException -> 0x01cc }
            com.google.android.gms.internal.ads.zzjl r3 = r14.zzbbn     // Catch:{ CryptoException -> 0x01cc }
            boolean r3 = r3.zzgk()     // Catch:{ CryptoException -> 0x01cc }
            if (r3 == 0) goto L_0x017b
            java.util.List<java.lang.Long> r3 = r14.zzbbq     // Catch:{ CryptoException -> 0x01cc }
            java.lang.Long r6 = java.lang.Long.valueOf(r10)     // Catch:{ CryptoException -> 0x01cc }
            r3.add(r6)     // Catch:{ CryptoException -> 0x01cc }
        L_0x017b:
            com.google.android.gms.internal.ads.zzjl r3 = r14.zzbbn     // Catch:{ CryptoException -> 0x01cc }
            java.nio.ByteBuffer r3 = r3.zzda     // Catch:{ CryptoException -> 0x01cc }
            r3.flip()     // Catch:{ CryptoException -> 0x01cc }
            com.google.android.gms.internal.ads.zzjl r3 = r14.zzbbn     // Catch:{ CryptoException -> 0x01cc }
            r14.zza((com.google.android.gms.internal.ads.zzjl) r3)     // Catch:{ CryptoException -> 0x01cc }
            if (r0 == 0) goto L_0x01ad
            com.google.android.gms.internal.ads.zzjl r0 = r14.zzbbn     // Catch:{ CryptoException -> 0x01cc }
            com.google.android.gms.internal.ads.zzjh r0 = r0.zzany     // Catch:{ CryptoException -> 0x01cc }
            android.media.MediaCodec$CryptoInfo r9 = r0.zzgj()     // Catch:{ CryptoException -> 0x01cc }
            if (r5 != 0) goto L_0x0194
            goto L_0x01a3
        L_0x0194:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01cc }
            if (r0 != 0) goto L_0x019c
            int[] r0 = new int[r4]     // Catch:{ CryptoException -> 0x01cc }
            r9.numBytesOfClearData = r0     // Catch:{ CryptoException -> 0x01cc }
        L_0x019c:
            int[] r0 = r9.numBytesOfClearData     // Catch:{ CryptoException -> 0x01cc }
            r3 = r0[r1]     // Catch:{ CryptoException -> 0x01cc }
            int r3 = r3 + r5
            r0[r1] = r3     // Catch:{ CryptoException -> 0x01cc }
        L_0x01a3:
            android.media.MediaCodec r6 = r14.zzbbu     // Catch:{ CryptoException -> 0x01cc }
            int r7 = r14.zzbch     // Catch:{ CryptoException -> 0x01cc }
            r8 = 0
            r12 = 0
            r6.queueSecureInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01cc }
            goto L_0x01be
        L_0x01ad:
            android.media.MediaCodec r6 = r14.zzbbu     // Catch:{ CryptoException -> 0x01cc }
            int r7 = r14.zzbch     // Catch:{ CryptoException -> 0x01cc }
            r8 = 0
            com.google.android.gms.internal.ads.zzjl r0 = r14.zzbbn     // Catch:{ CryptoException -> 0x01cc }
            java.nio.ByteBuffer r0 = r0.zzda     // Catch:{ CryptoException -> 0x01cc }
            int r9 = r0.limit()     // Catch:{ CryptoException -> 0x01cc }
            r12 = 0
            r6.queueInputBuffer(r7, r8, r9, r10, r12)     // Catch:{ CryptoException -> 0x01cc }
        L_0x01be:
            r14.zzbch = r2     // Catch:{ CryptoException -> 0x01cc }
            r14.zzbcn = r4     // Catch:{ CryptoException -> 0x01cc }
            r14.zzbcl = r1     // Catch:{ CryptoException -> 0x01cc }
            com.google.android.gms.internal.ads.zzjm r0 = r14.zzbct     // Catch:{ CryptoException -> 0x01cc }
            int r1 = r0.zzaod     // Catch:{ CryptoException -> 0x01cc }
            int r1 = r1 + r4
            r0.zzaod = r1     // Catch:{ CryptoException -> 0x01cc }
            return r4
        L_0x01cc:
            r0 = move-exception
            int r1 = r14.getIndex()
            com.google.android.gms.internal.ads.zzhe r0 = com.google.android.gms.internal.ads.zzhe.zza(r0, r1)
            throw r0
        L_0x01d6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzlv.zzhh():boolean");
    }

    private final void zzhi() {
        if (this.zzbcm == 2) {
            zzhg();
            zzhd();
            return;
        }
        this.zzbcq = true;
        zzge();
    }

    public boolean isReady() {
        if (this.zzahv == null || this.zzbcr) {
            return false;
        }
        if (zzej() || this.zzbci >= 0) {
            return true;
        }
        return this.zzbcg != -9223372036854775807L && SystemClock.elapsedRealtime() < this.zzbcg;
    }

    /* access modifiers changed from: protected */
    public void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
    }

    /* access modifiers changed from: protected */
    public void onStarted() {
    }

    /* access modifiers changed from: protected */
    public void onStopped() {
    }

    public final int zza(zzhp zzhp) {
        try {
            return zza(this.zzbbk, zzhp);
        } catch (zzma e) {
            throw zzhe.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public abstract int zza(zzlx zzlx, zzhp zzhp);

    /* access modifiers changed from: protected */
    public zzls zza(zzlx zzlx, zzhp zzhp, boolean z) {
        return zzlx.zzc(zzhp.zzaha, z);
    }

    /* access modifiers changed from: protected */
    public void zza(long j, boolean z) {
        this.zzbcp = false;
        this.zzbcq = false;
        if (this.zzbbu != null) {
            this.zzbcg = -9223372036854775807L;
            this.zzbch = -1;
            this.zzbci = -1;
            this.zzbcs = true;
            this.zzbcr = false;
            this.zzbcj = false;
            this.zzbbq.clear();
            this.zzbcd = false;
            this.zzbce = false;
            if (this.zzbbx || ((this.zzbca && this.zzbco) || this.zzbcm != 0)) {
                zzhg();
                zzhd();
            } else {
                this.zzbbu.flush();
                this.zzbcn = false;
            }
            if (this.zzbck && this.zzahv != null) {
                this.zzbcl = 1;
            }
        }
    }

    /* access modifiers changed from: protected */
    public void zza(zzjl zzjl) {
    }

    /* access modifiers changed from: protected */
    public abstract void zza(zzls zzls, MediaCodec mediaCodec, zzhp zzhp, MediaCrypto mediaCrypto);

    /* access modifiers changed from: protected */
    public abstract boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z);

    /* access modifiers changed from: protected */
    public boolean zza(MediaCodec mediaCodec, boolean z, zzhp zzhp, zzhp zzhp2) {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean zza(zzls zzls) {
        return true;
    }

    public final void zzb(long j, long j2) {
        if (this.zzbcq) {
            zzge();
            return;
        }
        if (this.zzahv == null) {
            this.zzbbo.clear();
            int zza = zza(this.zzbbp, this.zzbbo, true);
            if (zza == -5) {
                zzd(this.zzbbp.zzahv);
            } else if (zza == -4) {
                zzpc.checkState(this.zzbbo.zzgl());
                this.zzbcp = true;
                zzhi();
                return;
            } else {
                return;
            }
        }
        zzhd();
        if (this.zzbbu != null) {
            zzpq.beginSection("drainAndFeed");
            do {
            } while (zzd(j, j2));
            do {
            } while (zzhh());
            zzpq.endSection();
        } else {
            zzdp(j);
            this.zzbbo.clear();
            int zza2 = zza(this.zzbbp, this.zzbbo, false);
            if (zza2 == -5) {
                zzd(this.zzbbp.zzahv);
            } else if (zza2 == -4) {
                zzpc.checkState(this.zzbbo.zzgl());
                this.zzbcp = true;
                zzhi();
            }
        }
        this.zzbct.zzgn();
    }

    /* access modifiers changed from: protected */
    public void zzc(String str, long j, long j2) {
    }

    /* access modifiers changed from: protected */
    public void zzd(zzhp zzhp) {
        MediaCodec mediaCodec;
        zzhp zzhp2 = this.zzahv;
        this.zzahv = zzhp;
        boolean z = true;
        if (!zzpt.zza(this.zzahv.zzahd, zzhp2 == null ? null : zzhp2.zzahd)) {
            if (this.zzahv.zzahd != null) {
                zzjt<zzjv> zzjt = this.zzbbl;
                if (zzjt != null) {
                    this.zzbbt = zzjt.zza(Looper.myLooper(), this.zzahv.zzahd);
                    zzjr<zzjv> zzjr = this.zzbbt;
                    if (zzjr == this.zzbbs) {
                        this.zzbbl.zza(zzjr);
                    }
                } else {
                    throw zzhe.zza(new IllegalStateException("Media requires a DrmSessionManager"), getIndex());
                }
            } else {
                this.zzbbt = null;
            }
        }
        if (this.zzbbt == this.zzbbs && (mediaCodec = this.zzbbu) != null && zza(mediaCodec, this.zzbbv.zzbbc, zzhp2, this.zzahv)) {
            this.zzbck = true;
            this.zzbcl = 1;
            if (!(this.zzbby && this.zzahv.width == zzhp2.width && this.zzahv.height == zzhp2.height)) {
                z = false;
            }
            this.zzbcd = z;
        } else if (this.zzbcn) {
            this.zzbcm = 1;
        } else {
            zzhg();
            zzhd();
        }
    }

    /* access modifiers changed from: protected */
    public void zze(boolean z) {
        this.zzbct = new zzjm();
    }

    public final int zzeg() {
        return 4;
    }

    /* access modifiers changed from: protected */
    public void zzeh() {
        this.zzahv = null;
        try {
            zzhg();
            try {
                if (this.zzbbs != null) {
                    this.zzbbl.zza(this.zzbbs);
                }
                try {
                    if (!(this.zzbbt == null || this.zzbbt == this.zzbbs)) {
                        this.zzbbl.zza(this.zzbbt);
                    }
                } finally {
                    this.zzbbs = null;
                    this.zzbbt = null;
                }
            } catch (Throwable th) {
                if (!(this.zzbbt == null || this.zzbbt == this.zzbbs)) {
                    this.zzbbl.zza(this.zzbbt);
                }
                throw th;
            } finally {
                this.zzbbs = null;
                this.zzbbt = null;
            }
        } catch (Throwable th2) {
            try {
                if (!(this.zzbbt == null || this.zzbbt == this.zzbbs)) {
                    this.zzbbl.zza(this.zzbbt);
                }
                throw th2;
            } finally {
                this.zzbbs = null;
                this.zzbbt = null;
            }
        } finally {
        }
    }

    public boolean zzfe() {
        return this.zzbcq;
    }

    /* access modifiers changed from: protected */
    public void zzge() {
    }

    /* access modifiers changed from: protected */
    public final void zzhd() {
        zzhp zzhp;
        if (this.zzbbu == null && (zzhp = this.zzahv) != null) {
            this.zzbbs = this.zzbbt;
            String str = zzhp.zzaha;
            zzjr<zzjv> zzjr = this.zzbbs;
            if (zzjr != null) {
                int state = zzjr.getState();
                if (state == 0) {
                    throw zzhe.zza(this.zzbbs.zzgp(), getIndex());
                } else if (state == 3 || state == 4) {
                    zzjv zzgo = this.zzbbs.zzgo();
                    throw new NoSuchMethodError();
                }
            } else {
                if (this.zzbbv == null) {
                    try {
                        this.zzbbv = zza(this.zzbbk, this.zzahv, false);
                        zzls zzls = this.zzbbv;
                    } catch (zzma e) {
                        zza(new zzlu(this.zzahv, (Throwable) e, false, -49998));
                    }
                    if (this.zzbbv == null) {
                        zza(new zzlu(this.zzahv, (Throwable) null, false, -49999));
                    }
                }
                if (zza(this.zzbbv)) {
                    String str2 = this.zzbbv.name;
                    this.zzbbw = zzpt.SDK_INT < 21 && this.zzahv.zzahc.isEmpty() && "OMX.MTK.VIDEO.DECODER.AVC".equals(str2);
                    this.zzbbx = zzpt.SDK_INT < 18 || (zzpt.SDK_INT == 18 && ("OMX.SEC.avc.dec".equals(str2) || "OMX.SEC.avc.dec.secure".equals(str2))) || (zzpt.SDK_INT == 19 && zzpt.MODEL.startsWith("SM-G800") && ("OMX.Exynos.avc.dec".equals(str2) || "OMX.Exynos.avc.dec.secure".equals(str2)));
                    this.zzbby = zzpt.SDK_INT < 24 && ("OMX.Nvidia.h264.decode".equals(str2) || "OMX.Nvidia.h264.decode.secure".equals(str2)) && ("flounder".equals(zzpt.DEVICE) || "flounder_lte".equals(zzpt.DEVICE) || "grouper".equals(zzpt.DEVICE) || "tilapia".equals(zzpt.DEVICE));
                    this.zzbbz = zzpt.SDK_INT <= 17 && ("OMX.rk.video_decoder.avc".equals(str2) || "OMX.allwinner.video.decoder.avc".equals(str2));
                    this.zzbca = (zzpt.SDK_INT <= 23 && "OMX.google.vorbis.decoder".equals(str2)) || (zzpt.SDK_INT <= 19 && "hb2000".equals(zzpt.DEVICE) && ("OMX.amlogic.avc.decoder.awesome".equals(str2) || "OMX.amlogic.avc.decoder.awesome.secure".equals(str2)));
                    this.zzbcb = zzpt.SDK_INT == 21 && "OMX.google.aac.decoder".equals(str2);
                    this.zzbcc = zzpt.SDK_INT <= 18 && this.zzahv.zzahk == 1 && "OMX.MTK.AUDIO.DECODER.MP3".equals(str2);
                    try {
                        long elapsedRealtime = SystemClock.elapsedRealtime();
                        String valueOf = String.valueOf(str2);
                        zzpq.beginSection(valueOf.length() != 0 ? "createCodec:".concat(valueOf) : new String("createCodec:"));
                        this.zzbbu = MediaCodec.createByCodecName(str2);
                        zzpq.endSection();
                        zzpq.beginSection("configureCodec");
                        zza(this.zzbbv, this.zzbbu, this.zzahv, (MediaCrypto) null);
                        zzpq.endSection();
                        zzpq.beginSection("startCodec");
                        this.zzbbu.start();
                        zzpq.endSection();
                        long elapsedRealtime2 = SystemClock.elapsedRealtime();
                        zzc(str2, elapsedRealtime2, elapsedRealtime2 - elapsedRealtime);
                        this.zzbcf = this.zzbbu.getInputBuffers();
                        this.zzalb = this.zzbbu.getOutputBuffers();
                    } catch (Exception e2) {
                        zza(new zzlu(this.zzahv, (Throwable) e2, false, str2));
                    }
                    this.zzbcg = getState() == 2 ? SystemClock.elapsedRealtime() + 1000 : -9223372036854775807L;
                    this.zzbch = -1;
                    this.zzbci = -1;
                    this.zzbcs = true;
                    this.zzbct.zzaob++;
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public final MediaCodec zzhe() {
        return this.zzbbu;
    }

    /* access modifiers changed from: protected */
    public final zzls zzhf() {
        return this.zzbbv;
    }

    /* access modifiers changed from: protected */
    public void zzhg() {
        this.zzbcg = -9223372036854775807L;
        this.zzbch = -1;
        this.zzbci = -1;
        this.zzbcr = false;
        this.zzbcj = false;
        this.zzbbq.clear();
        this.zzbcf = null;
        this.zzalb = null;
        this.zzbbv = null;
        this.zzbck = false;
        this.zzbcn = false;
        this.zzbbw = false;
        this.zzbbx = false;
        this.zzbby = false;
        this.zzbbz = false;
        this.zzbca = false;
        this.zzbcc = false;
        this.zzbcd = false;
        this.zzbce = false;
        this.zzbco = false;
        this.zzbcl = 0;
        this.zzbcm = 0;
        this.zzbbn.zzda = null;
        if (this.zzbbu != null) {
            this.zzbct.zzaoc++;
            try {
                this.zzbbu.stop();
                try {
                    this.zzbbu.release();
                    this.zzbbu = null;
                    zzjr<zzjv> zzjr = this.zzbbs;
                    if (zzjr != null && this.zzbbt != zzjr) {
                        try {
                            this.zzbbl.zza(zzjr);
                        } finally {
                            this.zzbbs = null;
                        }
                    }
                } catch (Throwable th) {
                    this.zzbbu = null;
                    zzjr<zzjv> zzjr2 = this.zzbbs;
                    if (!(zzjr2 == null || this.zzbbt == zzjr2)) {
                        this.zzbbl.zza(zzjr2);
                    }
                    throw th;
                } finally {
                    this.zzbbs = null;
                }
            } catch (Throwable th2) {
                this.zzbbu = null;
                zzjr<zzjv> zzjr3 = this.zzbbs;
                if (!(zzjr3 == null || this.zzbbt == zzjr3)) {
                    try {
                        this.zzbbl.zza(zzjr3);
                    } finally {
                        this.zzbbs = null;
                    }
                }
                throw th2;
            } finally {
            }
        }
    }
}
