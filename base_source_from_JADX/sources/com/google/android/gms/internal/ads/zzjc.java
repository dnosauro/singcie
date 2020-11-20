package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.media.MediaCodec;
import android.media.MediaCrypto;
import android.media.MediaFormat;
import android.os.Handler;
import android.view.Surface;
import java.nio.ByteBuffer;

@TargetApi(16)
public final class zzjc extends zzlv implements zzpg {
    private int zzahk;
    private int zzahm;
    /* access modifiers changed from: private */
    public final zzik zzamm;
    private final zzip zzamn;
    private boolean zzamo;
    private boolean zzamp;
    private MediaFormat zzamq;
    private long zzamr;
    /* access modifiers changed from: private */
    public boolean zzams;

    public zzjc(zzlx zzlx, Handler handler, zzih zzih) {
        this(zzlx, (zzjt<zzjv>) null, true, handler, zzih);
    }

    private zzjc(zzlx zzlx, zzjt<zzjv> zzjt, boolean z, Handler handler, zzih zzih) {
        this(zzlx, (zzjt<zzjv>) null, true, handler, zzih, (zzig) null, new zzif[0]);
    }

    private zzjc(zzlx zzlx, zzjt<zzjv> zzjt, boolean z, Handler handler, zzih zzih, zzig zzig, zzif... zzifArr) {
        super(1, zzlx, (zzjt<zzjv>) null, true);
        this.zzamn = new zzip((zzig) null, zzifArr, new zzje(this));
        this.zzamm = new zzik(handler, zzih);
    }

    protected static void zza(int i, long j, long j2) {
    }

    private final boolean zzax(String str) {
        zzip zzip = this.zzamn;
        return false;
    }

    protected static void zzgd() {
    }

    protected static void zzw(int i) {
    }

    public final boolean isReady() {
        return this.zzamn.zzfr() || super.isReady();
    }

    /* access modifiers changed from: protected */
    public final void onOutputFormatChanged(MediaCodec mediaCodec, MediaFormat mediaFormat) {
        int[] iArr;
        int i;
        boolean z = this.zzamq != null;
        String string = z ? this.zzamq.getString("mime") : "audio/raw";
        if (z) {
            mediaFormat = this.zzamq;
        }
        int integer = mediaFormat.getInteger("channel-count");
        int integer2 = mediaFormat.getInteger("sample-rate");
        if (!this.zzamp || integer != 6 || (i = this.zzahk) >= 6) {
            iArr = null;
        } else {
            iArr = new int[i];
            for (int i2 = 0; i2 < this.zzahk; i2++) {
                iArr[i2] = i2;
            }
        }
        try {
            this.zzamn.zza(string, integer, integer2, this.zzahm, 0, iArr);
        } catch (zzit e) {
            throw zzhe.zza(e, getIndex());
        }
    }

    /* access modifiers changed from: protected */
    public final void onStarted() {
        super.onStarted();
        this.zzamn.play();
    }

    /* access modifiers changed from: protected */
    public final void onStopped() {
        this.zzamn.pause();
        super.onStopped();
    }

    /* access modifiers changed from: protected */
    public final int zza(zzlx zzlx, zzhp zzhp) {
        String str = zzhp.zzaha;
        if (!zzpj.zzbc(str)) {
            return 0;
        }
        int i = zzpt.SDK_INT >= 21 ? 16 : 0;
        int i2 = 3;
        if (zzax(str) && zzlx.zzhj() != null) {
            return i | 4 | 3;
        }
        zzls zzc = zzlx.zzc(str, false);
        boolean z = true;
        if (zzc == null) {
            return 1;
        }
        if (zzpt.SDK_INT >= 21 && ((zzhp.zzahl != -1 && !zzc.zzaw(zzhp.zzahl)) || (zzhp.zzahk != -1 && !zzc.zzax(zzhp.zzahk)))) {
            z = false;
        }
        if (!z) {
            i2 = 2;
        }
        return i | 4 | i2;
    }

    /* access modifiers changed from: protected */
    public final zzls zza(zzlx zzlx, zzhp zzhp, boolean z) {
        zzls zzhj;
        if (!zzax(zzhp.zzaha) || (zzhj = zzlx.zzhj()) == null) {
            this.zzamo = false;
            return super.zza(zzlx, zzhp, z);
        }
        this.zzamo = true;
        return zzhj;
    }

    public final void zza(int i, Object obj) {
        switch (i) {
            case 2:
                this.zzamn.setVolume(((Float) obj).floatValue());
                return;
            case 3:
                this.zzamn.setStreamType(((Integer) obj).intValue());
                return;
            default:
                super.zza(i, obj);
                return;
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(long j, boolean z) {
        super.zza(j, z);
        this.zzamn.reset();
        this.zzamr = j;
        this.zzams = true;
    }

    /* access modifiers changed from: protected */
    public final void zza(zzls zzls, MediaCodec mediaCodec, zzhp zzhp, MediaCrypto mediaCrypto) {
        this.zzamp = zzpt.SDK_INT < 24 && "OMX.SEC.aac.dec".equals(zzls.name) && "samsung".equals(zzpt.MANUFACTURER) && (zzpt.DEVICE.startsWith("zeroflte") || zzpt.DEVICE.startsWith("herolte") || zzpt.DEVICE.startsWith("heroqlte"));
        if (this.zzamo) {
            this.zzamq = zzhp.zzfa();
            this.zzamq.setString("mime", "audio/raw");
            mediaCodec.configure(this.zzamq, (Surface) null, (MediaCrypto) null, 0);
            this.zzamq.setString("mime", zzhp.zzaha);
            return;
        }
        mediaCodec.configure(zzhp.zzfa(), (Surface) null, (MediaCrypto) null, 0);
        this.zzamq = null;
    }

    /* access modifiers changed from: protected */
    public final boolean zza(long j, long j2, MediaCodec mediaCodec, ByteBuffer byteBuffer, int i, int i2, long j3, boolean z) {
        if (this.zzamo && (i2 & 2) != 0) {
            mediaCodec.releaseOutputBuffer(i, false);
            return true;
        } else if (z) {
            mediaCodec.releaseOutputBuffer(i, false);
            this.zzbct.zzaof++;
            this.zzamn.zzfo();
            return true;
        } else {
            try {
                if (!this.zzamn.zzb(byteBuffer, j3)) {
                    return false;
                }
                mediaCodec.releaseOutputBuffer(i, false);
                this.zzbct.zzaoe++;
                return true;
            } catch (zziw | zzix e) {
                throw zzhe.zza(e, getIndex());
            }
        }
    }

    public final zzhv zzb(zzhv zzhv) {
        return this.zzamn.zzb(zzhv);
    }

    /* access modifiers changed from: protected */
    public final void zzc(String str, long j, long j2) {
        this.zzamm.zzb(str, j, j2);
    }

    /* access modifiers changed from: protected */
    public final void zzd(zzhp zzhp) {
        super.zzd(zzhp);
        this.zzamm.zzc(zzhp);
        this.zzahm = "audio/raw".equals(zzhp.zzaha) ? zzhp.zzahm : 2;
        this.zzahk = zzhp.zzahk;
    }

    /* access modifiers changed from: protected */
    public final void zze(boolean z) {
        super.zze(z);
        this.zzamm.zzc(this.zzbct);
        int i = zzei().zzaid;
        this.zzamn.zzft();
    }

    public final zzpg zzea() {
        return this;
    }

    /* access modifiers changed from: protected */
    public final void zzeh() {
        try {
            this.zzamn.release();
            try {
                super.zzeh();
            } finally {
                this.zzbct.zzgn();
                this.zzamm.zzd(this.zzbct);
            }
        } catch (Throwable th) {
            super.zzeh();
            throw th;
        } finally {
            this.zzbct.zzgn();
            this.zzamm.zzd(this.zzbct);
        }
    }

    public final boolean zzfe() {
        return super.zzfe() && this.zzamn.zzfe();
    }

    public final zzhv zzfs() {
        return this.zzamn.zzfs();
    }

    public final long zzfz() {
        long zzj = this.zzamn.zzj(zzfe());
        if (zzj != Long.MIN_VALUE) {
            if (!this.zzams) {
                zzj = Math.max(this.zzamr, zzj);
            }
            this.zzamr = zzj;
            this.zzams = false;
        }
        return this.zzamr;
    }

    /* access modifiers changed from: protected */
    public final void zzge() {
        try {
            this.zzamn.zzfp();
        } catch (zzix e) {
            throw zzhe.zza(e, getIndex());
        }
    }
}
