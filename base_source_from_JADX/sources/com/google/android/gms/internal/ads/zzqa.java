package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Point;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.os.SystemClock;
import android.util.Log;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzqa extends zzlv {
    private static final int[] zzbla = {1920, 1600, 1440, 1280, 960, 854, 640, 540, 480};
    private final Context context;
    private int zzaid;
    private boolean zzalk;
    private final zzqe zzblb;
    private final zzqj zzblc;
    private final long zzbld;
    private final int zzble;
    private final boolean zzblf;
    private final long[] zzblg;
    private zzhp[] zzblh;
    private zzqc zzbli;
    private Surface zzblj;
    private Surface zzblk;
    private int zzbll;
    private boolean zzblm;
    private long zzbln;
    private long zzblo;
    private int zzblp;
    private int zzblq;
    private int zzblr;
    private float zzbls;
    private int zzblt;
    private int zzblu;
    private int zzblv;
    private float zzblw;
    private int zzblx;
    private int zzbly;
    private int zzblz;
    private float zzbma;
    zzqf zzbmb;
    private long zzbmc;
    private int zzbmd;

    public zzqa(Context context2, zzlx zzlx, long j, Handler handler, zzqg zzqg, int i) {
        this(context2, zzlx, 0, (zzjt<zzjv>) null, false, handler, zzqg, -1);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    private zzqa(Context context2, zzlx zzlx, long j, zzjt<zzjv> zzjt, boolean z, Handler handler, zzqg zzqg, int i) {
        super(2, zzlx, (zzjt<zzjv>) null, false);
        boolean z2 = false;
        this.zzbld = 0;
        this.zzble = -1;
        this.context = context2.getApplicationContext();
        this.zzblb = new zzqe(context2);
        this.zzblc = new zzqj(handler, zzqg);
        if (zzpt.SDK_INT <= 22 && "foster".equals(zzpt.DEVICE) && "NVIDIA".equals(zzpt.MANUFACTURER)) {
            z2 = true;
        }
        this.zzblf = z2;
        this.zzblg = new long[10];
        this.zzbmc = -9223372036854775807L;
        this.zzbln = -9223372036854775807L;
        this.zzblt = -1;
        this.zzblu = -1;
        this.zzblw = -1.0f;
        this.zzbls = -1.0f;
        this.zzbll = 1;
        zzjl();
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static int zza(java.lang.String r5, int r6, int r7) {
        /*
            r0 = -1
            if (r6 == r0) goto L_0x007b
            if (r7 != r0) goto L_0x0007
            goto L_0x007b
        L_0x0007:
            int r1 = r5.hashCode()
            r2 = 3
            r3 = 4
            r4 = 2
            switch(r1) {
                case -1664118616: goto L_0x0044;
                case -1662541442: goto L_0x003a;
                case 1187890754: goto L_0x0030;
                case 1331836730: goto L_0x0026;
                case 1599127256: goto L_0x001c;
                case 1599127257: goto L_0x0012;
                default: goto L_0x0011;
            }
        L_0x0011:
            goto L_0x004e
        L_0x0012:
            java.lang.String r1 = "video/x-vnd.on2.vp9"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 5
            goto L_0x004f
        L_0x001c:
            java.lang.String r1 = "video/x-vnd.on2.vp8"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 3
            goto L_0x004f
        L_0x0026:
            java.lang.String r1 = "video/avc"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 2
            goto L_0x004f
        L_0x0030:
            java.lang.String r1 = "video/mp4v-es"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 1
            goto L_0x004f
        L_0x003a:
            java.lang.String r1 = "video/hevc"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 4
            goto L_0x004f
        L_0x0044:
            java.lang.String r1 = "video/3gpp"
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x004e
            r5 = 0
            goto L_0x004f
        L_0x004e:
            r5 = -1
        L_0x004f:
            switch(r5) {
                case 0: goto L_0x0072;
                case 1: goto L_0x0072;
                case 2: goto L_0x0056;
                case 3: goto L_0x0072;
                case 4: goto L_0x0053;
                case 5: goto L_0x0053;
                default: goto L_0x0052;
            }
        L_0x0052:
            return r0
        L_0x0053:
            int r6 = r6 * r7
            goto L_0x0075
        L_0x0056:
            java.lang.String r5 = "BRAVIA 4K 2015"
            java.lang.String r1 = com.google.android.gms.internal.ads.zzpt.MODEL
            boolean r5 = r5.equals(r1)
            if (r5 == 0) goto L_0x0061
            return r0
        L_0x0061:
            r5 = 16
            int r6 = com.google.android.gms.internal.ads.zzpt.zzf(r6, r5)
            int r5 = com.google.android.gms.internal.ads.zzpt.zzf(r7, r5)
            int r6 = r6 * r5
            int r5 = r6 << 4
            int r6 = r5 << 4
            goto L_0x0074
        L_0x0072:
            int r6 = r6 * r7
        L_0x0074:
            r3 = 2
        L_0x0075:
            int r6 = r6 * 3
            int r3 = r3 * 2
            int r6 = r6 / r3
            return r6
        L_0x007b:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqa.zza(java.lang.String, int, int):int");
    }

    private final void zza(MediaCodec mediaCodec, int i, long j) {
        zzpq.beginSection("skipVideoBuffer");
        mediaCodec.releaseOutputBuffer(i, false);
        zzpq.endSection();
        this.zzbct.zzaof++;
    }

    @TargetApi(21)
    private final void zza(MediaCodec mediaCodec, int i, long j, long j2) {
        zzjm();
        zzpq.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, j2);
        zzpq.endSection();
        this.zzbct.zzaoe++;
        this.zzblq = 0;
        zzjk();
    }

    private static boolean zza(boolean z, zzhp zzhp, zzhp zzhp2) {
        if (!zzhp.zzaha.equals(zzhp2.zzaha) || zzj(zzhp) != zzj(zzhp2)) {
            return false;
        }
        if (!z) {
            return zzhp.width == zzhp2.width && zzhp.height == zzhp2.height;
        }
        return true;
    }

    private final void zzb(MediaCodec mediaCodec, int i, long j) {
        zzjm();
        zzpq.beginSection("releaseOutputBuffer");
        mediaCodec.releaseOutputBuffer(i, true);
        zzpq.endSection();
        this.zzbct.zzaoe++;
        this.zzblq = 0;
        zzjk();
    }

    private static boolean zzem(long j) {
        return j < -30000;
    }

    private static int zzi(zzhp zzhp) {
        return zzhp.zzahb != -1 ? zzhp.zzahb : zza(zzhp.zzaha, zzhp.width, zzhp.height);
    }

    private static int zzj(zzhp zzhp) {
        if (zzhp.zzahf == -1) {
            return 0;
        }
        return zzhp.zzahf;
    }

    private final void zzji() {
        this.zzbln = -9223372036854775807L;
    }

    private final void zzjj() {
        MediaCodec zzhe;
        this.zzblm = false;
        if (zzpt.SDK_INT >= 23 && this.zzalk && (zzhe = zzhe()) != null) {
            this.zzbmb = new zzqf(this, zzhe);
        }
    }

    private final void zzjl() {
        this.zzblx = -1;
        this.zzbly = -1;
        this.zzbma = -1.0f;
        this.zzblz = -1;
    }

    private final void zzjm() {
        if (this.zzblx != this.zzblt || this.zzbly != this.zzblu || this.zzblz != this.zzblv || this.zzbma != this.zzblw) {
            this.zzblc.zzb(this.zzblt, this.zzblu, this.zzblv, this.zzblw);
            this.zzblx = this.zzblt;
            this.zzbly = this.zzblu;
            this.zzblz = this.zzblv;
            this.zzbma = this.zzblw;
        }
    }

    private final void zzjn() {
        if (this.zzblx != -1 || this.zzbly != -1) {
            this.zzblc.zzb(this.zzblt, this.zzblu, this.zzblv, this.zzblw);
        }
    }

    private final void zzjo() {
        if (this.zzblp > 0) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            this.zzblc.zzg(this.zzblp, elapsedRealtime - this.zzblo);
            this.zzblp = 0;
            this.zzblo = elapsedRealtime;
        }
    }

    private final boolean zzn(boolean z) {
        if (zzpt.SDK_INT < 23 || this.zzalk) {
            return false;
        }
        return !z || zzpw.zzc(this.context);
    }

    public final boolean isReady() {
        Surface surface;
        if (super.isReady() && (this.zzblm || (((surface = this.zzblk) != null && this.zzblj == surface) || zzhe() == null))) {
            this.zzbln = -9223372036854775807L;
            return true;
        } else if (this.zzbln == -9223372036854775807L) {
            return false;
        } else {
            if (SystemClock.elapsedRealtime() < this.zzbln) {
                return true;
            }
            this.zzbln = -9223372036854775807L;
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        boolean z = mediaFormat.containsKey("crop-right") && mediaFormat.containsKey("crop-left") && mediaFormat.containsKey("crop-bottom") && mediaFormat.containsKey("crop-top");
        this.zzblt = z ? (mediaFormat.getInteger("crop-right") - mediaFormat.getInteger("crop-left")) + 1 : mediaFormat.getInteger("width");
        this.zzblu = z ? (mediaFormat.getInteger("crop-bottom") - mediaFormat.getInteger("crop-top")) + 1 : mediaFormat.getInteger("height");
        this.zzblw = this.zzbls;
        if (zzpt.SDK_INT >= 21) {
            int i = this.zzblr;
            if (i == 90 || i == 270) {
                int i2 = this.zzblt;
                this.zzblt = this.zzblu;
                this.zzblu = i2;
                this.zzblw = 1.0f / this.zzblw;
            }
        } else {
            this.zzblv = this.zzblr;
        }
        mediaCodec.setVideoScalingMode(this.zzbll);
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzblp = 0;
        this.zzblo = SystemClock.elapsedRealtime();
        this.zzbln = -9223372036854775807L;
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        zzjo();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzlx zzlx, zzhp zzhp) {
        boolean z;
        String str = zzhp.zzaha;
        int i = 0;
        if (!zzpj.zzbd(str)) {
            return 0;
        }
        zzjo zzjo = zzhp.zzahd;
        if (zzjo != null) {
            z = false;
            for (int i2 = 0; i2 < zzjo.zzaoj; i2++) {
                z |= zzjo.zzae(i2).zzaok;
            }
        } else {
            z = false;
        }
        zzls zzc = zzlx.zzc(str, z);
        if (zzc == null) {
            return 1;
        }
        boolean zzaz = zzc.zzaz(zzhp.zzagx);
        if (zzaz && zzhp.width > 0 && zzhp.height > 0) {
            if (zzpt.SDK_INT >= 21) {
                zzaz = zzc.zza(zzhp.width, zzhp.height, (double) zzhp.zzahe);
            } else {
                zzaz = zzhp.width * zzhp.height <= zzlz.zzhk();
                if (!zzaz) {
                    int i3 = zzhp.width;
                    int i4 = zzhp.height;
                    String str2 = zzpt.zzbkl;
                    StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                    sb.append("FalseCheck [legacyFrameSize, ");
                    sb.append(i3);
                    sb.append("x");
                    sb.append(i4);
                    sb.append("] [");
                    sb.append(str2);
                    sb.append("]");
                    Log.d("MediaCodecVideoRenderer", sb.toString());
                }
            }
        }
        int i5 = zzc.zzbbc ? 8 : 4;
        if (zzc.zzalk) {
            i = 16;
        }
        return (zzaz ? 3 : 2) | i5 | i;
    }

    public final void zza(int i, Object obj) {
        if (i == 1) {
            Surface surface = (Surface) obj;
            if (surface == null) {
                Surface surface2 = this.zzblk;
                if (surface2 != null) {
                    surface = surface2;
                } else {
                    zzls zzhf = zzhf();
                    if (zzhf != null && zzn(zzhf.zzbbd)) {
                        this.zzblk = zzpw.zzc(this.context, zzhf.zzbbd);
                        surface = this.zzblk;
                    }
                }
            }
            if (this.zzblj != surface) {
                this.zzblj = surface;
                int state = getState();
                if (state == 1 || state == 2) {
                    MediaCodec zzhe = zzhe();
                    if (zzpt.SDK_INT < 23 || zzhe == null || surface == null) {
                        zzhg();
                        zzhd();
                    } else {
                        zzhe.setOutputSurface(surface);
                    }
                }
                if (surface == null || surface == this.zzblk) {
                    zzjl();
                    zzjj();
                    return;
                }
                zzjn();
                zzjj();
                if (state == 2) {
                    zzji();
                }
            } else if (surface != null && surface != this.zzblk) {
                zzjn();
                if (this.zzblm) {
                    this.zzblc.zzb(this.zzblj);
                }
            }
        } else if (i == 4) {
            this.zzbll = ((Integer) obj).intValue();
            MediaCodec zzhe2 = zzhe();
            if (zzhe2 != null) {
                zzhe2.setVideoScalingMode(this.zzbll);
            }
        } else {
            super.zza(i, obj);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) {
        super.zza(j, z);
        zzjj();
        this.zzblq = 0;
        int i = this.zzbmd;
        if (i != 0) {
            this.zzbmc = this.zzblg[i - 1];
            this.zzbmd = 0;
        }
        if (z) {
            zzji();
        } else {
            this.zzbln = -9223372036854775807L;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzjl zzjl) {
        if (zzpt.SDK_INT < 23 && this.zzalk) {
            zzjk();
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzls zzls, MediaCodec mediaCodec, zzhp zzhp, MediaCrypto mediaCrypto) {
        zzqc zzqc;
        Point point;
        zzls zzls2 = zzls;
        MediaCodec mediaCodec2 = mediaCodec;
        zzhp zzhp2 = zzhp;
        zzhp[] zzhpArr = this.zzblh;
        int i = zzhp2.width;
        int i2 = zzhp2.height;
        int zzi = zzi(zzhp);
        if (zzhpArr.length == 1) {
            zzqc = new zzqc(i, i2, zzi);
        } else {
            int i3 = i2;
            int i4 = zzi;
            boolean z = false;
            int i5 = i;
            for (zzhp zzhp3 : zzhpArr) {
                if (zza(zzls2.zzbbc, zzhp2, zzhp3)) {
                    z |= zzhp3.width == -1 || zzhp3.height == -1;
                    i5 = Math.max(i5, zzhp3.width);
                    int max = Math.max(i3, zzhp3.height);
                    i4 = Math.max(i4, zzi(zzhp3));
                    i3 = max;
                }
            }
            if (z) {
                StringBuilder sb = new StringBuilder(66);
                sb.append("Resolutions unknown. Codec max resolution: ");
                sb.append(i5);
                sb.append("x");
                sb.append(i3);
                Log.w("MediaCodecVideoRenderer", sb.toString());
                boolean z2 = zzhp2.height > zzhp2.width;
                int i6 = z2 ? zzhp2.height : zzhp2.width;
                int i7 = z2 ? zzhp2.width : zzhp2.height;
                float f = ((float) i7) / ((float) i6);
                int[] iArr = zzbla;
                int length = iArr.length;
                int i8 = 0;
                while (true) {
                    if (i8 >= length) {
                        break;
                    }
                    int i9 = iArr[i8];
                    int i10 = (int) (((float) i9) * f);
                    if (i9 <= i6 || i10 <= i7) {
                        break;
                    }
                    int i11 = i6;
                    int i12 = i7;
                    if (zzpt.SDK_INT >= 21) {
                        int i13 = z2 ? i10 : i9;
                        if (!z2) {
                            i9 = i10;
                        }
                        Point zzd = zzls2.zzd(i13, i9);
                        Point point2 = zzd;
                        if (zzls2.zza(zzd.x, zzd.y, (double) zzhp2.zzahe)) {
                            point = point2;
                            break;
                        }
                    } else {
                        int zzf = zzpt.zzf(i9, 16) << 4;
                        int zzf2 = zzpt.zzf(i10, 16) << 4;
                        if (zzf * zzf2 <= zzlz.zzhk()) {
                            int i14 = z2 ? zzf2 : zzf;
                            if (z2) {
                                zzf2 = zzf;
                            }
                            point = new Point(i14, zzf2);
                        }
                    }
                    i8++;
                    i6 = i11;
                    i7 = i12;
                }
                point = null;
                if (point != null) {
                    i5 = Math.max(i5, point.x);
                    i3 = Math.max(i3, point.y);
                    i4 = Math.max(i4, zza(zzhp2.zzaha, i5, i3));
                    StringBuilder sb2 = new StringBuilder(57);
                    sb2.append("Codec max resolution adjusted to: ");
                    sb2.append(i5);
                    sb2.append("x");
                    sb2.append(i3);
                    Log.w("MediaCodecVideoRenderer", sb2.toString());
                }
            }
            zzqc = new zzqc(i5, i3, i4);
        }
        this.zzbli = zzqc;
        zzqc zzqc2 = this.zzbli;
        boolean z3 = this.zzblf;
        int i15 = this.zzaid;
        MediaFormat zzfa = zzhp.zzfa();
        zzfa.setInteger("max-width", zzqc2.width);
        zzfa.setInteger("max-height", zzqc2.height);
        if (zzqc2.zzbme != -1) {
            zzfa.setInteger("max-input-size", zzqc2.zzbme);
        }
        if (z3) {
            zzfa.setInteger("auto-frc", 0);
        }
        if (i15 != 0) {
            zzfa.setFeatureEnabled("tunneled-playback", true);
            zzfa.setInteger("audio-session-id", i15);
        }
        if (this.zzblj == null) {
            zzpc.checkState(zzn(zzls2.zzbbd));
            if (this.zzblk == null) {
                this.zzblk = zzpw.zzc(this.context, zzls2.zzbbd);
            }
            this.zzblj = this.zzblk;
        }
        mediaCodec2.configure(zzfa, this.zzblj, (MediaCrypto) null, 0);
        if (zzpt.SDK_INT >= 23 && this.zzalk) {
            this.zzbmb = new zzqf(this, mediaCodec2);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(zzhp[] zzhpArr, long j) {
        this.zzblh = zzhpArr;
        if (this.zzbmc == -9223372036854775807L) {
            this.zzbmc = j;
        } else {
            int i = this.zzbmd;
            long[] jArr = this.zzblg;
            if (i == jArr.length) {
                long j2 = jArr[i - 1];
                StringBuilder sb = new StringBuilder(65);
                sb.append("Too many stream changes, so dropping offset: ");
                sb.append(j2);
                Log.w("MediaCodecVideoRenderer", sb.toString());
            } else {
                this.zzbmd = i + 1;
            }
            this.zzblg[this.zzbmd - 1] = j;
        }
        super.zza(zzhpArr, j);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        MediaCodec mediaCodec2 = mediaCodec;
        int i3 = i;
        long j4 = j3;
        while (true) {
            int i4 = this.zzbmd;
            if (i4 == 0) {
                break;
            }
            long[] jArr = this.zzblg;
            if (j4 < jArr[0]) {
                break;
            }
            this.zzbmc = jArr[0];
            this.zzbmd = i4 - 1;
            System.arraycopy(jArr, 1, jArr, 0, this.zzbmd);
        }
        long j5 = j4 - this.zzbmc;
        if (z) {
            zza(mediaCodec2, i3, j5);
            return true;
        }
        long j6 = j4 - j;
        if (this.zzblj == this.zzblk) {
            if (!zzem(j6)) {
                return false;
            }
            zza(mediaCodec2, i3, j5);
            return true;
        } else if (!this.zzblm) {
            if (zzpt.SDK_INT >= 21) {
                zza(mediaCodec, i, j5, System.nanoTime());
            } else {
                zzb(mediaCodec2, i3, j5);
            }
            return true;
        } else if (getState() != 2) {
            return false;
        } else {
            long elapsedRealtime = j6 - ((SystemClock.elapsedRealtime() * 1000) - j2);
            long nanoTime = System.nanoTime();
            long zzf = this.zzblb.zzf(j4, (elapsedRealtime * 1000) + nanoTime);
            long j7 = (zzf - nanoTime) / 1000;
            if (zzem(j7)) {
                zzpq.beginSection("dropVideoBuffer");
                mediaCodec2.releaseOutputBuffer(i3, false);
                zzpq.endSection();
                this.zzbct.zzaog++;
                this.zzblp++;
                this.zzblq++;
                this.zzbct.zzaoh = Math.max(this.zzblq, this.zzbct.zzaoh);
                if (this.zzblp == this.zzble) {
                    zzjo();
                }
                return true;
            }
            if (zzpt.SDK_INT >= 21) {
                if (j7 < 50000) {
                    zza(mediaCodec, i, j5, zzf);
                    return true;
                }
            } else if (j7 < 30000) {
                if (j7 > 11000) {
                    try {
                        Thread.sleep((j7 - 10000) / 1000);
                    } catch (InterruptedException unused) {
                        Thread.currentThread().interrupt();
                    }
                }
                zzb(mediaCodec2, i3, j5);
                return true;
            }
            return false;
        }
    }

    /* access modifiers changed from: protected */
    public final boolean zza(MediaCodec mediaCodec, boolean z, zzhp zzhp, zzhp zzhp2) {
        return zza(z, zzhp, zzhp2) && zzhp2.width <= this.zzbli.width && zzhp2.height <= this.zzbli.height && zzhp2.zzahb <= this.zzbli.zzbme;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(zzls zzls) {
        return this.zzblj != null || zzn(zzls.zzbbd);
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.zzblc.zzb(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzhp zzhp) {
        super.zzd(zzhp);
        this.zzblc.zzc(zzhp);
        this.zzbls = zzhp.zzahg == -1.0f ? 1.0f : zzhp.zzahg;
        this.zzblr = zzj(zzhp);
    }

    /* access modifiers changed from: protected */
    public final void zze(boolean z) {
        super.zze(z);
        this.zzaid = zzei().zzaid;
        this.zzalk = this.zzaid != 0;
        this.zzblc.zzc(this.zzbct);
        this.zzblb.enable();
    }

    /* access modifiers changed from: protected */
    public final void zzeh() {
        this.zzblt = -1;
        this.zzblu = -1;
        this.zzblw = -1.0f;
        this.zzbls = -1.0f;
        this.zzbmc = -9223372036854775807L;
        this.zzbmd = 0;
        zzjl();
        zzjj();
        this.zzblb.disable();
        this.zzbmb = null;
        this.zzalk = false;
        try {
            super.zzeh();
        } finally {
            this.zzbct.zzgn();
            this.zzblc.zzd(this.zzbct);
        }
    }

    /* access modifiers changed from: protected */
    public final void zzhg() {
        try {
            super.zzhg();
        } finally {
            Surface surface = this.zzblk;
            if (surface != null) {
                if (this.zzblj == surface) {
                    this.zzblj = null;
                }
                this.zzblk.release();
                this.zzblk = null;
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzjk() {
        if (!this.zzblm) {
            this.zzblm = true;
            this.zzblc.zzb(this.zzblj);
        }
    }
}
