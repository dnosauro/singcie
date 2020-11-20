package com.google.android.gms.internal.ads;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.util.Log;
import android.util.Pair;

final class zzhm implements Handler.Callback, zznb, zznd, zzog {
    private final Handler handler;
    private int repeatMode = 0;
    private int state;
    private final zzhy[] zzaeo;
    private final zzoh zzaep;
    private final Handler zzaer;
    private final zzie zzaeu;
    private final zzib zzaev;
    private boolean zzaex;
    private boolean zzafb;
    private zzhz zzafc;
    private zzhv zzafg;
    private zzho zzafh;
    private final zzhx[] zzafx;
    private final zzht zzafy;
    private zzna zzafz;
    private final zzpo zzagb;
    private final HandlerThread zzagc;
    private final zzhd zzagd;
    private zzhy zzage;
    private zzpg zzagf;
    private zzhy[] zzagg;
    private boolean zzagh;
    private boolean zzagi;
    private int zzagj;
    private int zzagk;
    private long zzagl;
    private int zzagm;
    private zzhn zzagn;
    private long zzago;
    private zzhl zzagp;
    private zzhl zzagq;
    private zzhl zzagr;

    public zzhm(zzhy[] zzhyArr, zzoh zzoh, zzht zzht, boolean z, int i, Handler handler2, zzho zzho, zzhd zzhd) {
        this.zzaeo = zzhyArr;
        this.zzaep = zzoh;
        this.zzafy = zzht;
        this.zzaex = z;
        this.zzaer = handler2;
        this.state = 1;
        this.zzafh = zzho;
        this.zzagd = zzhd;
        this.zzafx = new zzhx[zzhyArr.length];
        for (int i2 = 0; i2 < zzhyArr.length; i2++) {
            zzhyArr[i2].setIndex(i2);
            this.zzafx[i2] = zzhyArr[i2].zzdz();
        }
        this.zzagb = new zzpo();
        this.zzagg = new zzhy[0];
        this.zzaeu = new zzie();
        this.zzaev = new zzib();
        zzoh.zza(this);
        this.zzafg = zzhv.zzahx;
        this.zzagc = new HandlerThread("ExoPlayerImplInternal:Handler", -16);
        this.zzagc.start();
        this.handler = new Handler(this.zzagc.getLooper(), this);
    }

    private final void setState(int i) {
        if (this.state != i) {
            this.state = i;
            this.zzaer.obtainMessage(1, i, 0).sendToTarget();
        }
    }

    private final int zza(int i, zzhz zzhz, zzhz zzhz2) {
        int zzfg = zzhz.zzfg();
        int i2 = i;
        int i3 = -1;
        for (int i4 = 0; i4 < zzfg && i3 == -1; i4++) {
            i2 = zzhz.zza(i2, this.zzaev, this.zzaeu, this.repeatMode);
            i3 = zzhz2.zzc(zzhz.zza(i2, this.zzaev, true).zzafm);
        }
        return i3;
    }

    private final Pair<Integer, Long> zza(zzhn zzhn) {
        zzhz zzhz = zzhn.zzafc;
        if (zzhz.isEmpty()) {
            zzhz = this.zzafc;
        }
        try {
            Pair<Integer, Long> zzb = zzb(zzhz, zzhn.zzags, zzhn.zzagt);
            zzhz zzhz2 = this.zzafc;
            if (zzhz2 == zzhz) {
                return zzb;
            }
            int zzc = zzhz2.zzc(zzhz.zza(((Integer) zzb.first).intValue(), this.zzaev, true).zzafm);
            if (zzc != -1) {
                return Pair.create(Integer.valueOf(zzc), (Long) zzb.second);
            }
            int zza = zza(((Integer) zzb.first).intValue(), zzhz, this.zzafc);
            if (zza == -1) {
                return null;
            }
            this.zzafc.zza(zza, this.zzaev, false);
            return zzc(0, -9223372036854775807L);
        } catch (IndexOutOfBoundsException unused) {
            throw new zzhu(this.zzafc, zzhn.zzags, zzhn.zzagt);
        }
    }

    private final Pair<Integer, Long> zza(zzhz zzhz, int i, long j, long j2) {
        zzpc.zzc(i, 0, zzhz.zzff());
        zzhz.zza(i, this.zzaeu, false, j2);
        if (j == -9223372036854775807L) {
            j = 0;
        }
        long j3 = j + 0;
        long j4 = zzhz.zza(0, this.zzaev, false).zzaif;
        if (j4 != -9223372036854775807L) {
            int i2 = (j3 > j4 ? 1 : (j3 == j4 ? 0 : -1));
        }
        return Pair.create(0, Long.valueOf(j3));
    }

    private final void zza(long j, long j2) {
        this.handler.removeMessages(2);
        long elapsedRealtime = (j + j2) - SystemClock.elapsedRealtime();
        if (elapsedRealtime <= 0) {
            this.handler.sendEmptyMessage(2);
        } else {
            this.handler.sendEmptyMessageDelayed(2, elapsedRealtime);
        }
    }

    private static void zza(zzhl zzhl) {
        while (zzhl != null) {
            zzhl.release();
            zzhl = zzhl.zzafv;
        }
    }

    private static void zza(zzhy zzhy) {
        if (zzhy.getState() == 2) {
            zzhy.stop();
        }
    }

    private final void zza(Object obj, int i) {
        this.zzafh = new zzho(0, 0);
        zzb(obj, i);
        this.zzafh = new zzho(0, -9223372036854775807L);
        setState(4);
        zzi(false);
    }

    private final void zza(boolean[] zArr, int i) {
        this.zzagg = new zzhy[i];
        int i2 = 0;
        int i3 = 0;
        while (true) {
            zzhy[] zzhyArr = this.zzaeo;
            if (i2 < zzhyArr.length) {
                zzhy zzhy = zzhyArr[i2];
                zzoc zzbe = this.zzagr.zzafw.zzbhv.zzbe(i2);
                if (zzbe != null) {
                    int i4 = i3 + 1;
                    this.zzagg[i3] = zzhy;
                    if (zzhy.getState() == 0) {
                        zzia zzia = this.zzagr.zzafw.zzbhx[i2];
                        boolean z = this.zzaex && this.state == 3;
                        boolean z2 = !zArr[i2] && z;
                        zzhp[] zzhpArr = new zzhp[zzbe.length()];
                        for (int i5 = 0; i5 < zzhpArr.length; i5++) {
                            zzhpArr[i5] = zzbe.zzbc(i5);
                        }
                        zzhy.zza(zzia, zzhpArr, this.zzagr.zzafn[i2], this.zzago, z2, this.zzagr.zzep());
                        zzpg zzea = zzhy.zzea();
                        if (zzea != null) {
                            if (this.zzagf == null) {
                                this.zzagf = zzea;
                                this.zzage = zzhy;
                                this.zzagf.zzb(this.zzafg);
                            } else {
                                throw zzhe.zza((RuntimeException) new IllegalStateException("Multiple renderer media clocks enabled."));
                            }
                        }
                        if (z) {
                            zzhy.start();
                        }
                    }
                    i3 = i4;
                }
                i2++;
            } else {
                return;
            }
        }
    }

    private final long zzb(int i, long j) {
        zzhl zzhl;
        zzeu();
        this.zzagi = false;
        setState(2);
        zzhl zzhl2 = this.zzagr;
        if (zzhl2 == null) {
            zzhl zzhl3 = this.zzagp;
            if (zzhl3 != null) {
                zzhl3.release();
            }
            zzhl = null;
        } else {
            zzhl = null;
            while (zzhl2 != null) {
                if (zzhl2.zzafq != i || !zzhl2.zzaft) {
                    zzhl2.release();
                } else {
                    zzhl = zzhl2;
                }
                zzhl2 = zzhl2.zzafv;
            }
        }
        zzhl zzhl4 = this.zzagr;
        if (!(zzhl4 == zzhl && zzhl4 == this.zzagq)) {
            for (zzhy disable : this.zzagg) {
                disable.disable();
            }
            this.zzagg = new zzhy[0];
            this.zzagf = null;
            this.zzage = null;
            this.zzagr = null;
        }
        if (zzhl != null) {
            zzhl.zzafv = null;
            this.zzagp = zzhl;
            this.zzagq = zzhl;
            zzb(zzhl);
            if (this.zzagr.zzafu) {
                j = this.zzagr.zzafl.zzeg(j);
            }
            zzdq(j);
            zzey();
        } else {
            this.zzagp = null;
            this.zzagq = null;
            this.zzagr = null;
            zzdq(j);
        }
        this.handler.sendEmptyMessage(2);
        return j;
    }

    private final Pair<Integer, Long> zzb(zzhz zzhz, int i, long j) {
        return zza(zzhz, i, j, 0);
    }

    private final void zzb(zzhl zzhl) {
        if (this.zzagr != zzhl) {
            boolean[] zArr = new boolean[this.zzaeo.length];
            int i = 0;
            int i2 = 0;
            while (true) {
                zzhy[] zzhyArr = this.zzaeo;
                if (i < zzhyArr.length) {
                    zzhy zzhy = zzhyArr[i];
                    zArr[i] = zzhy.getState() != 0;
                    zzoc zzbe = zzhl.zzafw.zzbhv.zzbe(i);
                    if (zzbe != null) {
                        i2++;
                    }
                    if (zArr[i] && (zzbe == null || (zzhy.zzee() && zzhy.zzeb() == this.zzagr.zzafn[i]))) {
                        if (zzhy == this.zzage) {
                            this.zzagb.zza(this.zzagf);
                            this.zzagf = null;
                            this.zzage = null;
                        }
                        zza(zzhy);
                        zzhy.disable();
                    }
                    i++;
                } else {
                    this.zzagr = zzhl;
                    this.zzaer.obtainMessage(3, zzhl.zzafw).sendToTarget();
                    zza(zArr, i2);
                    return;
                }
            }
        }
    }

    private final void zzb(Object obj, int i) {
        this.zzaer.obtainMessage(6, new zzhq(this.zzafc, obj, this.zzafh, i)).sendToTarget();
    }

    private final Pair<Integer, Long> zzc(int i, long j) {
        return zzb(this.zzafc, 0, -9223372036854775807L);
    }

    private final void zzdq(long j) {
        zzhl zzhl = this.zzagr;
        this.zzago = j + (zzhl == null ? 60000000 : zzhl.zzep());
        this.zzagb.zzel(this.zzago);
        for (zzhy zzdo : this.zzagg) {
            zzdo.zzdo(this.zzago);
        }
    }

    private final boolean zzdr(long j) {
        if (j == -9223372036854775807L || this.zzafh.zzagu < j) {
            return true;
        }
        return this.zzagr.zzafv != null && this.zzagr.zzafv.zzaft;
    }

    private final void zzet() {
        this.zzagi = false;
        this.zzagb.start();
        for (zzhy start : this.zzagg) {
            start.start();
        }
    }

    private final void zzeu() {
        this.zzagb.stop();
        for (zzhy zza : this.zzagg) {
            zza(zza);
        }
    }

    private final void zzev() {
        zzhl zzhl = this.zzagr;
        if (zzhl != null) {
            long zzhq = zzhl.zzafl.zzhq();
            if (zzhq != -9223372036854775807L) {
                zzdq(zzhq);
            } else {
                zzhy zzhy = this.zzage;
                if (zzhy == null || zzhy.zzfe()) {
                    this.zzago = this.zzagb.zzfz();
                } else {
                    this.zzago = this.zzagf.zzfz();
                    this.zzagb.zzel(this.zzago);
                }
                zzhq = this.zzago - this.zzagr.zzep();
            }
            this.zzafh.zzagu = zzhq;
            this.zzagl = SystemClock.elapsedRealtime() * 1000;
            long zzhr = this.zzagg.length == 0 ? Long.MIN_VALUE : this.zzagr.zzafl.zzhr();
            zzho zzho = this.zzafh;
            if (zzhr == Long.MIN_VALUE) {
                zzhr = this.zzafc.zza(this.zzagr.zzafq, this.zzaev, false).zzaif;
            }
            zzho.zzagv = zzhr;
        }
    }

    private final void zzew() {
        zzi(true);
        this.zzafy.onStopped();
        setState(1);
    }

    private final void zzex() {
        zzhl zzhl = this.zzagp;
        if (zzhl != null && !zzhl.zzaft) {
            zzhl zzhl2 = this.zzagq;
            if (zzhl2 == null || zzhl2.zzafv == this.zzagp) {
                zzhy[] zzhyArr = this.zzagg;
                int length = zzhyArr.length;
                int i = 0;
                while (i < length) {
                    if (zzhyArr[i].zzec()) {
                        i++;
                    } else {
                        return;
                    }
                }
                this.zzagp.zzafl.zzhn();
            }
        }
    }

    private final void zzey() {
        long zzhp = !this.zzagp.zzaft ? 0 : this.zzagp.zzafl.zzhp();
        if (zzhp == Long.MIN_VALUE) {
            zzh(false);
            return;
        }
        long zzep = this.zzago - this.zzagp.zzep();
        boolean zzdt = this.zzafy.zzdt(zzhp - zzep);
        zzh(zzdt);
        if (zzdt) {
            this.zzagp.zzafl.zzef(zzep);
        }
    }

    private final void zzh(boolean z) {
        if (this.zzafb != z) {
            this.zzafb = z;
            this.zzaer.obtainMessage(2, z ? 1 : 0, 0).sendToTarget();
        }
    }

    private final void zzi(boolean z) {
        this.handler.removeMessages(2);
        this.zzagi = false;
        this.zzagb.stop();
        this.zzagf = null;
        this.zzage = null;
        this.zzago = 60000000;
        for (zzhy zzhy : this.zzagg) {
            try {
                zza(zzhy);
                zzhy.disable();
            } catch (zzhe | RuntimeException e) {
                Log.e("ExoPlayerImplInternal", "Stop failed.", e);
            }
        }
        this.zzagg = new zzhy[0];
        zzhl zzhl = this.zzagr;
        if (zzhl == null) {
            zzhl = this.zzagp;
        }
        zza(zzhl);
        this.zzagp = null;
        this.zzagq = null;
        this.zzagr = null;
        zzh(false);
        if (z) {
            zzna zzna = this.zzafz;
            if (zzna != null) {
                zzna.zzia();
                this.zzafz = null;
            }
            this.zzafc = null;
        }
    }

    private final boolean zzu(int i) {
        this.zzafc.zza(i, this.zzaev, false);
        this.zzafc.zza(0, this.zzaeu, false);
        return this.zzafc.zza(i, this.zzaev, this.zzaeu, this.repeatMode) == -1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:507:0x08af, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:508:0x08b0, code lost:
        r1 = r0;
        android.util.Log.e("ExoPlayerImplInternal", "Internal runtime error.", r1);
        r2 = r8.zzaer;
        r1 = com.google.android.gms.internal.ads.zzhe.zza(r1);
        r3 = 8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:511:0x08cb, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:512:0x08cc, code lost:
        r3 = 8;
        r1 = r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:514:0x08dd, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:515:0x08de, code lost:
        r3 = 8;
        r1 = r0;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Removed duplicated region for block: B:171:0x028d A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:172:0x0290 A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:174:0x0294 A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:207:0x0352 A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:208:0x0366 A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:309:0x0530 A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:311:0x0537 A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:314:0x0551 A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:315:0x0554 A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:318:0x058f A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:322:0x05a3 A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:333:0x05bf A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }, LOOP:8: B:333:0x05bf->B:337:0x05d1, LOOP_START] */
    /* JADX WARNING: Removed duplicated region for block: B:407:0x0721 A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:446:0x07da A[Catch:{ all -> 0x044c, all -> 0x0386, all -> 0x00cc, all -> 0x00d9, all -> 0x00c8, zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }] */
    /* JADX WARNING: Removed duplicated region for block: B:507:0x08af A[ExcHandler: RuntimeException (r0v2 'e' java.lang.RuntimeException A[CUSTOM_DECLARE]), Splitter:B:1:0x0005] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean handleMessage(android.os.Message r35) {
        /*
            r34 = this;
            r8 = r34
            r1 = r35
            r10 = 1
            int r2 = r1.what     // Catch:{ zzhe -> 0x08dd, IOException -> 0x08cb, RuntimeException -> 0x08af }
            r11 = 7
            r3 = 0
            r14 = 3
            r5 = -1
            r6 = 0
            r15 = 4
            r12 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r7 = 2
            r9 = 0
            switch(r2) {
                case 0: goto L_0x086e;
                case 1: goto L_0x0843;
                case 2: goto L_0x0466;
                case 3: goto L_0x03af;
                case 4: goto L_0x038e;
                case 5: goto L_0x038a;
                case 6: goto L_0x0373;
                case 7: goto L_0x0219;
                case 8: goto L_0x01e3;
                case 9: goto L_0x01d0;
                case 10: goto L_0x00dd;
                case 11: goto L_0x009f;
                case 12: goto L_0x0019;
                default: goto L_0x0018;
            }
        L_0x0018:
            return r9
        L_0x0019:
            int r1 = r1.arg1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.repeatMode = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == 0) goto L_0x0024
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x0026
        L_0x0024:
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0026:
            if (r2 == 0) goto L_0x009e
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != r3) goto L_0x002e
            r3 = 1
            goto L_0x002f
        L_0x002e:
            r3 = 0
        L_0x002f:
            com.google.android.gms.internal.ads.zzhl r4 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != r4) goto L_0x0037
            r4 = r3
            r3 = r2
            r2 = 1
            goto L_0x003a
        L_0x0037:
            r4 = r3
            r3 = r2
            r2 = 0
        L_0x003a:
            com.google.android.gms.internal.ads.zzhz r11 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r12 = r3.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r13 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzie r14 = r8.zzaeu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r11 = r11.zza((int) r12, (com.google.android.gms.internal.ads.zzib) r13, (com.google.android.gms.internal.ads.zzie) r14, (int) r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r12 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r12 == 0) goto L_0x0065
            if (r11 == r5) goto L_0x0065
            com.google.android.gms.internal.ads.zzhl r12 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r12 = r12.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r12 != r11) goto L_0x0065
            com.google.android.gms.internal.ads.zzhl r3 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r11 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 != r11) goto L_0x005a
            r11 = 1
            goto L_0x005b
        L_0x005a:
            r11 = 0
        L_0x005b:
            r4 = r4 | r11
            com.google.android.gms.internal.ads.zzhl r11 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 != r11) goto L_0x0062
            r11 = 1
            goto L_0x0063
        L_0x0062:
            r11 = 0
        L_0x0063:
            r2 = r2 | r11
            goto L_0x003a
        L_0x0065:
            com.google.android.gms.internal.ads.zzhl r5 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r5 == 0) goto L_0x0070
            com.google.android.gms.internal.ads.zzhl r5 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            zza((com.google.android.gms.internal.ads.zzhl) r5)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3.zzafv = r6     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0070:
            int r5 = r3.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r5 = r8.zzu(r5)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3.zzafs = r5     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x007c
            r8.zzagp = r3     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x007c:
            if (r4 != 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == 0) goto L_0x0095
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r3 = r3.zzagu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r3 = r8.zzb((int) r2, (long) r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r5 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r5.<init>(r2, r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r5     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0095:
            int r2 = r8.state     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != r15) goto L_0x009e
            if (r1 == 0) goto L_0x009e
            r8.setState(r7)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x009e:
            return r10
        L_0x009f:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhi[] r1 = (com.google.android.gms.internal.ads.zzhi[]) r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r1.length     // Catch:{ all -> 0x00cc }
        L_0x00a4:
            if (r9 >= r2) goto L_0x00b4
            r3 = r1[r9]     // Catch:{ all -> 0x00cc }
            com.google.android.gms.internal.ads.zzhf r4 = r3.zzaek     // Catch:{ all -> 0x00cc }
            int r5 = r3.zzael     // Catch:{ all -> 0x00cc }
            java.lang.Object r3 = r3.zzaem     // Catch:{ all -> 0x00cc }
            r4.zza(r5, r3)     // Catch:{ all -> 0x00cc }
            int r9 = r9 + 1
            goto L_0x00a4
        L_0x00b4:
            com.google.android.gms.internal.ads.zzna r1 = r8.zzafz     // Catch:{ all -> 0x00cc }
            if (r1 == 0) goto L_0x00bd
            android.os.Handler r1 = r8.handler     // Catch:{ all -> 0x00cc }
            r1.sendEmptyMessage(r7)     // Catch:{ all -> 0x00cc }
        L_0x00bd:
            monitor-enter(r34)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r1 = r8.zzagk     // Catch:{ all -> 0x00c8 }
            int r1 = r1 + r10
            r8.zzagk = r1     // Catch:{ all -> 0x00c8 }
            r34.notifyAll()     // Catch:{ all -> 0x00c8 }
            monitor-exit(r34)     // Catch:{ all -> 0x00c8 }
            return r10
        L_0x00c8:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00c8 }
            throw r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x00cc:
            r0 = move-exception
            r1 = r0
            monitor-enter(r34)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r8.zzagk     // Catch:{ all -> 0x00d9 }
            int r2 = r2 + r10
            r8.zzagk = r2     // Catch:{ all -> 0x00d9 }
            r34.notifyAll()     // Catch:{ all -> 0x00d9 }
            monitor-exit(r34)     // Catch:{ all -> 0x00d9 }
            throw r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x00d9:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x00d9 }
            throw r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x00dd:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x01cf
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2 = 1
        L_0x00e4:
            if (r1 == 0) goto L_0x01cf
            boolean r3 = r1.zzaft     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 != 0) goto L_0x00ec
            goto L_0x01cf
        L_0x00ec:
            boolean r3 = r1.zzer()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 != 0) goto L_0x00fa
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 != r3) goto L_0x00f7
            r2 = 0
        L_0x00f7:
            com.google.android.gms.internal.ads.zzhl r1 = r1.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x00e4
        L_0x00fa:
            if (r2 == 0) goto L_0x0198
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == r3) goto L_0x0104
            r2 = 1
            goto L_0x0105
        L_0x0104:
            r2 = 0
        L_0x0105:
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            zza((com.google.android.gms.internal.ads.zzhl) r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3.zzafv = r6     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzagp = r3     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzagq = r3     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhy[] r3 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r3 = r3.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean[] r3 = new boolean[r3]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r4 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r5 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r11 = r5.zzagu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r4 = r4.zza(r11, r2, r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r11 = r2.zzagu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = (r4 > r11 ? 1 : (r4 == r11 ? 0 : -1))
            if (r2 == 0) goto L_0x0136
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2.zzagu = r4     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzdq(r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0136:
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean[] r2 = new boolean[r2]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r4 = 0
            r5 = 0
        L_0x013d:
            com.google.android.gms.internal.ads.zzhy[] r11 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r11 = r11.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r4 >= r11) goto L_0x0189
            com.google.android.gms.internal.ads.zzhy[] r11 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r11 = r11[r4]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r12 = r11.getState()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r12 == 0) goto L_0x014e
            r12 = 1
            goto L_0x014f
        L_0x014e:
            r12 = 0
        L_0x014f:
            r2[r4] = r12     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r12 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zznn[] r12 = r12.zzafn     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r12 = r12[r4]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r12 == 0) goto L_0x015b
            int r5 = r5 + 1
        L_0x015b:
            boolean r13 = r2[r4]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r13 == 0) goto L_0x0186
            com.google.android.gms.internal.ads.zznn r13 = r11.zzeb()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r12 == r13) goto L_0x017d
            com.google.android.gms.internal.ads.zzhy r13 = r8.zzage     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r11 != r13) goto L_0x0176
            if (r12 != 0) goto L_0x0172
            com.google.android.gms.internal.ads.zzpo r12 = r8.zzagb     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzpg r13 = r8.zzagf     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r12.zza(r13)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0172:
            r8.zzagf = r6     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzage = r6     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0176:
            zza((com.google.android.gms.internal.ads.zzhy) r11)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r11.disable()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x0186
        L_0x017d:
            boolean r12 = r3[r4]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r12 == 0) goto L_0x0186
            long r12 = r8.zzago     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r11.zzdo(r12)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0186:
            int r4 = r4 + 1
            goto L_0x013d
        L_0x0189:
            android.os.Handler r3 = r8.zzaer     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzoj r1 = r1.zzafw     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Message r1 = r3.obtainMessage(r14, r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zza((boolean[]) r2, (int) r5)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x01c4
        L_0x0198:
            r8.zzagp = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x019c:
            com.google.android.gms.internal.ads.zzhl r1 = r1.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x01a4
            r1.release()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x019c
        L_0x01a4:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.zzafv = r6     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r1 = r1.zzaft     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x01c4
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r1 = r1.zzafr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r4 = r8.zzago     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r11 = r3.zzep()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r4 = r4 - r11
            long r1 = java.lang.Math.max(r1, r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3.zzb(r1, r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x01c4:
            r34.zzey()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r34.zzev()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Handler r1 = r8.handler     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.sendEmptyMessage(r7)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x01cf:
            return r10
        L_0x01d0:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzmy r1 = (com.google.android.gms.internal.ads.zzmy) r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == 0) goto L_0x01e2
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzmy r2 = r2.zzafl     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == r1) goto L_0x01df
            goto L_0x01e2
        L_0x01df:
            r34.zzey()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x01e2:
            return r10
        L_0x01e3:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzmy r1 = (com.google.android.gms.internal.ads.zzmy) r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == 0) goto L_0x0218
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzmy r2 = r2.zzafl     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == r1) goto L_0x01f2
            goto L_0x0218
        L_0x01f2:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.zzaft = r10     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.zzer()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r2 = r1.zzafr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r2 = r1.zzb(r2, r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.zzafr = r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 != 0) goto L_0x0215
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzagq = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r1 = r1.zzafr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzdq(r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzb((com.google.android.gms.internal.ads.zzhl) r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0215:
            r34.zzey()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0218:
            return r10
        L_0x0219:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.util.Pair r1 = (android.util.Pair) r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r3 = r1.first     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r3 = (com.google.android.gms.internal.ads.zzhz) r3     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafc = r3     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r1 = r1.second     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x0288
            int r3 = r8.zzagm     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 <= 0) goto L_0x0258
            com.google.android.gms.internal.ads.zzhn r3 = r8.zzagn     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.util.Pair r3 = r8.zza((com.google.android.gms.internal.ads.zzhn) r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r4 = r8.zzagm     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzagm = r9     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzagn = r6     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 != 0) goto L_0x0240
        L_0x023b:
            r8.zza((java.lang.Object) r1, (int) r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x0372
        L_0x0240:
            com.google.android.gms.internal.ads.zzho r7 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r11 = r3.first     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Integer r11 = (java.lang.Integer) r11     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r11 = r11.intValue()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r3 = r3.second     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r14 = r3.longValue()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r7.<init>(r11, r14)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r7     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x0289
        L_0x0258:
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r3 = r3.zzafr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r7 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r7 != 0) goto L_0x0288
            com.google.android.gms.internal.ads.zzhz r3 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r3 = r3.isEmpty()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 == 0) goto L_0x026d
            r8.zza((java.lang.Object) r1, (int) r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x0372
        L_0x026d:
            android.util.Pair r3 = r8.zzc(r9, r12)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r4 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r7 = r3.first     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Integer r7 = (java.lang.Integer) r7     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r7 = r7.intValue()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r3 = r3.second     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Long r3 = (java.lang.Long) r3     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r14 = r3.longValue()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r4.<init>(r7, r14)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r4     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0288:
            r4 = 0
        L_0x0289:
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 == 0) goto L_0x0290
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x0292
        L_0x0290:
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0292:
            if (r3 == 0) goto L_0x036f
            com.google.android.gms.internal.ads.zzhz r7 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r11 = r3.zzafm     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r7 = r7.zzc(r11)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r7 != r5) goto L_0x02f2
            int r6 = r3.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r7 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r8.zza((int) r6, (com.google.android.gms.internal.ads.zzhz) r2, (com.google.android.gms.internal.ads.zzhz) r7)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != r5) goto L_0x02a9
            goto L_0x023b
        L_0x02a9:
            com.google.android.gms.internal.ads.zzhz r6 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r7 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r6.zza((int) r2, (com.google.android.gms.internal.ads.zzib) r7, (boolean) r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.util.Pair r2 = r8.zzc(r9, r12)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r6 = r2.first     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Integer r6 = (java.lang.Integer) r6     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r6 = r6.intValue()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r2 = r2.second     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r11 = r2.longValue()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r7 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2.zza((int) r6, (com.google.android.gms.internal.ads.zzib) r7, (boolean) r10)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r2 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r2 = r2.zzafm     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3.zzafq = r5     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x02d1:
            com.google.android.gms.internal.ads.zzhl r7 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r7 == 0) goto L_0x02e5
            com.google.android.gms.internal.ads.zzhl r3 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r7 = r3.zzafm     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r7 = r7.equals(r2)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r7 == 0) goto L_0x02e1
            r7 = r6
            goto L_0x02e2
        L_0x02e1:
            r7 = -1
        L_0x02e2:
            r3.zzafq = r7     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x02d1
        L_0x02e5:
            long r2 = r8.zzb((int) r6, (long) r11)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r5 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r5.<init>(r6, r2)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r5     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x036f
        L_0x02f2:
            boolean r2 = r8.zzu(r7)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3.zzc(r7, r2)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 != r2) goto L_0x02ff
            r2 = 1
            goto L_0x0300
        L_0x02ff:
            r2 = 0
        L_0x0300:
            com.google.android.gms.internal.ads.zzho r11 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r11 = r11.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r7 == r11) goto L_0x0319
            com.google.android.gms.internal.ads.zzho r11 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r12 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r13 = r11.zzafr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r12.<init>(r7, r13)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r13 = r11.zzagu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r12.zzagu = r13     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r13 = r11.zzagv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r12.zzagv = r13     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r12     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0319:
            com.google.android.gms.internal.ads.zzhl r11 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r11 == 0) goto L_0x036f
            com.google.android.gms.internal.ads.zzhl r11 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r12 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r13 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzie r14 = r8.zzaeu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r15 = r8.repeatMode     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r7 = r12.zza((int) r7, (com.google.android.gms.internal.ads.zzib) r13, (com.google.android.gms.internal.ads.zzie) r14, (int) r15)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r7 == r5) goto L_0x0350
            java.lang.Object r12 = r11.zzafm     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r13 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r14 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r13 = r13.zza((int) r7, (com.google.android.gms.internal.ads.zzib) r14, (boolean) r10)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r13 = r13.zzafm     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r12 = r12.equals(r13)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r12 == 0) goto L_0x0350
            boolean r3 = r8.zzu(r7)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r11.zzc(r7, r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r11 != r3) goto L_0x034c
            r3 = 1
            goto L_0x034d
        L_0x034c:
            r3 = 0
        L_0x034d:
            r2 = r2 | r3
            r3 = r11
            goto L_0x0319
        L_0x0350:
            if (r2 != 0) goto L_0x0366
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r5 = r3.zzagu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r5 = r8.zzb((int) r2, (long) r5)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r3 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3.<init>(r2, r5)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r3     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x036f
        L_0x0366:
            r8.zzagp = r3     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2.zzafv = r6     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            zza((com.google.android.gms.internal.ads.zzhl) r11)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x036f:
            r8.zzb((java.lang.Object) r1, (int) r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0372:
            return r10
        L_0x0373:
            r8.zzi(r10)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzht r1 = r8.zzafy     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.zzfc()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.setState(r10)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            monitor-enter(r34)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzagh = r10     // Catch:{ all -> 0x0386 }
            r34.notifyAll()     // Catch:{ all -> 0x0386 }
            monitor-exit(r34)     // Catch:{ all -> 0x0386 }
            return r10
        L_0x0386:
            r0 = move-exception
            r1 = r0
            monitor-exit(r34)     // Catch:{ all -> 0x0386 }
            throw r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x038a:
            r34.zzew()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            return r10
        L_0x038e:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhv r1 = (com.google.android.gms.internal.ads.zzhv) r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzpg r2 = r8.zzagf     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == 0) goto L_0x039d
            com.google.android.gms.internal.ads.zzpg r2 = r8.zzagf     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhv r1 = r2.zzb(r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x03a3
        L_0x039d:
            com.google.android.gms.internal.ads.zzpo r2 = r8.zzagb     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhv r1 = r2.zzb(r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x03a3:
            r8.zzafg = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Handler r2 = r8.zzaer     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Message r1 = r2.obtainMessage(r11, r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            return r10
        L_0x03af:
            java.lang.Object r1 = r1.obj     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhn r1 = (com.google.android.gms.internal.ads.zzhn) r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x03c0
            int r2 = r8.zzagm     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2 + r10
            r8.zzagm = r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzagn = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x044b
        L_0x03c0:
            android.util.Pair r2 = r8.zza((com.google.android.gms.internal.ads.zzhn) r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x03e6
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.<init>(r9, r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Handler r1 = r8.zzaer     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Message r1 = r1.obtainMessage(r15, r10, r9, r2)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.<init>(r9, r12)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.setState(r15)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzi(r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x044b
        L_0x03e6:
            long r3 = r1.zzagt     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r1 = (r3 > r12 ? 1 : (r3 == r12 ? 0 : -1))
            if (r1 != 0) goto L_0x03ee
            r1 = 1
            goto L_0x03ef
        L_0x03ee:
            r1 = 0
        L_0x03ef:
            java.lang.Object r3 = r2.first     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Integer r3 = (java.lang.Integer) r3     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r3 = r3.intValue()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r2 = r2.second     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Long r2 = (java.lang.Long) r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r4 = r2.longValue()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafh     // Catch:{ all -> 0x044c }
            int r2 = r2.zzafq     // Catch:{ all -> 0x044c }
            if (r3 != r2) goto L_0x042a
            r6 = 1000(0x3e8, double:4.94E-321)
            long r11 = r4 / r6
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafh     // Catch:{ all -> 0x044c }
            long r13 = r2.zzagu     // Catch:{ all -> 0x044c }
            long r13 = r13 / r6
            int r2 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r2 != 0) goto L_0x042a
            com.google.android.gms.internal.ads.zzho r2 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2.<init>(r3, r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Handler r2 = r8.zzaer     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x041f
            r1 = 1
            goto L_0x0420
        L_0x041f:
            r1 = 0
        L_0x0420:
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0426:
            r1.sendToTarget()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x044b
        L_0x042a:
            long r6 = r8.zzb((int) r3, (long) r4)     // Catch:{ all -> 0x044c }
            int r2 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
            if (r2 == 0) goto L_0x0434
            r2 = 1
            goto L_0x0435
        L_0x0434:
            r2 = 0
        L_0x0435:
            r1 = r1 | r2
            com.google.android.gms.internal.ads.zzho r2 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2.<init>(r3, r6)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Handler r2 = r8.zzaer     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x0443
            r1 = 1
            goto L_0x0444
        L_0x0443:
            r1 = 0
        L_0x0444:
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Message r1 = r2.obtainMessage(r15, r1, r9, r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x0426
        L_0x044b:
            return r10
        L_0x044c:
            r0 = move-exception
            r2 = r0
            com.google.android.gms.internal.ads.zzho r6 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r6.<init>(r3, r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r6     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Handler r3 = r8.zzaer     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x045b
            r1 = 1
            goto L_0x045c
        L_0x045b:
            r1 = 0
        L_0x045c:
            com.google.android.gms.internal.ads.zzho r4 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Message r1 = r3.obtainMessage(r15, r1, r9, r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            throw r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0466:
            long r5 = android.os.SystemClock.elapsedRealtime()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r1 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 != 0) goto L_0x0476
            com.google.android.gms.internal.ads.zzna r1 = r8.zzafz     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.zzhz()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r14 = r5
            goto L_0x06d2
        L_0x0476:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 != 0) goto L_0x047f
            com.google.android.gms.internal.ads.zzho r1 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r1 = r1.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x04bd
        L_0x047f:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r1 = r1.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r2 = r2.zzafs     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x04ca
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r2 = r2.zzeq()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == 0) goto L_0x04ca
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r7 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r2 = r2.zza((int) r1, (com.google.android.gms.internal.ads.zzib) r7, (boolean) r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r14 = r2.zzaif     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = (r14 > r12 ? 1 : (r14 == r12 ? 0 : -1))
            if (r2 != 0) goto L_0x04a0
            goto L_0x04ca
        L_0x04a0:
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == 0) goto L_0x04b1
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.index     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r7 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r7 = r7.index     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2 - r7
            r7 = 100
            if (r2 == r7) goto L_0x04ca
        L_0x04b1:
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r7 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzie r14 = r8.zzaeu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r15 = r8.repeatMode     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r1 = r2.zza((int) r1, (com.google.android.gms.internal.ads.zzib) r7, (com.google.android.gms.internal.ads.zzie) r14, (int) r15)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x04bd:
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.zzfg()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 < r2) goto L_0x04cd
            com.google.android.gms.internal.ads.zzna r1 = r8.zzafz     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.zzhz()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x04ca:
            r14 = r5
            goto L_0x059f
        L_0x04cd:
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x04d7
            com.google.android.gms.internal.ads.zzho r2 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r3 = r2.zzagu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x04d5:
            r14 = r5
            goto L_0x052c
        L_0x04d7:
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r7 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2.zza((int) r1, (com.google.android.gms.internal.ads.zzib) r7, (boolean) r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzie r7 = r8.zzaeu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2.zza((int) r9, (com.google.android.gms.internal.ads.zzie) r7, (boolean) r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x04e8
            goto L_0x04d5
        L_0x04e8:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r1 = r1.zzep()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r7 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r14 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r14 = r14.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r15 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r7 = r7.zza((int) r14, (com.google.android.gms.internal.ads.zzib) r15, (boolean) r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r14 = r7.zzaif     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r1 = r1 + r14
            long r14 = r8.zzago     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r1 = r1 - r14
            com.google.android.gms.internal.ads.zzhz r7 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r14 = 0
            r16 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            long r18 = java.lang.Math.max(r3, r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1 = r34
            r2 = r7
            r3 = r14
            r14 = r5
            r4 = r16
            r6 = r18
            android.util.Pair r1 = r1.zza(r2, r3, r4, r6)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x059f
            java.lang.Object r2 = r1.first     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Integer r2 = (java.lang.Integer) r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.intValue()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r1 = r1.second     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Long r1 = (java.lang.Long) r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r3 = r1.longValue()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1 = r2
        L_0x052c:
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x0537
            r5 = 60000000(0x3938700, double:2.96439388E-316)
            long r5 = r5 + r3
        L_0x0534:
            r23 = r5
            goto L_0x054d
        L_0x0537:
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r5 = r2.zzep()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r7 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r7 = r7.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r11 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r2 = r2.zza((int) r7, (com.google.android.gms.internal.ads.zzib) r11, (boolean) r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r12 = r2.zzaif     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r5 = r5 + r12
            goto L_0x0534
        L_0x054d:
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x0554
            r29 = 0
            goto L_0x055b
        L_0x0554:
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.index     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2 + r10
            r29 = r2
        L_0x055b:
            boolean r31 = r8.zzu(r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r5 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2.zza((int) r1, (com.google.android.gms.internal.ads.zzib) r5, (boolean) r10)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = new com.google.android.gms.internal.ads.zzhl     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhy[] r5 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhx[] r6 = r8.zzafx     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzoh r7 = r8.zzaep     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzht r11 = r8.zzafy     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzna r12 = r8.zzafz     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r13 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            java.lang.Object r13 = r13.zzafm     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r20 = r2
            r21 = r5
            r22 = r6
            r25 = r7
            r26 = r11
            r27 = r12
            r28 = r13
            r30 = r1
            r32 = r3
            r20.<init>(r21, r22, r23, r25, r26, r27, r28, r29, r30, r31, r32)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x0593
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.zzafv = r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0593:
            r8.zzagp = r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzmy r1 = r1.zzafl     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.zza(r8, r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzh(r10)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x059f:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x05b8
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r1 = r1.zzeq()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x05ac
            goto L_0x05b8
        L_0x05ac:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x05bb
            boolean r1 = r8.zzafb     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 != 0) goto L_0x05bb
            r34.zzey()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x05bb
        L_0x05b8:
            r8.zzh(r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x05bb:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x06d2
        L_0x05bf:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == r2) goto L_0x05fc
            long r1 = r8.zzago     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r3.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r3 = r3.zzafp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 < 0) goto L_0x05fc
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.release()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r1.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzb((com.google.android.gms.internal.ads.zzhl) r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r3 = r3.zzafr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.<init>(r2, r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r34.zzev()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Handler r1 = r8.zzaer     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2 = 5
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Message r1 = r1.obtainMessage(r2, r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x05bf
        L_0x05fc:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r1 = r1.zzafs     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x0626
            r1 = 0
        L_0x0603:
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 >= r2) goto L_0x06d2
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2 = r2[r1]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zznn[] r3 = r3.zzafn     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3 = r3[r1]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 == 0) goto L_0x0623
            com.google.android.gms.internal.ads.zznn r4 = r2.zzeb()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r4 != r3) goto L_0x0623
            boolean r3 = r2.zzec()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 == 0) goto L_0x0623
            r2.zzed()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0623:
            int r1 = r1 + 1
            goto L_0x0603
        L_0x0626:
            r1 = 0
        L_0x0627:
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 >= r2) goto L_0x0649
            com.google.android.gms.internal.ads.zzhy[] r2 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2 = r2[r1]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zznn[] r3 = r3.zzafn     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3 = r3[r1]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zznn r4 = r2.zzeb()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r4 != r3) goto L_0x06d2
            if (r3 == 0) goto L_0x0646
            boolean r2 = r2.zzec()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x0646
            goto L_0x06d2
        L_0x0646:
            int r1 = r1 + 1
            goto L_0x0627
        L_0x0649:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r1.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x06d2
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r1.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r1 = r1.zzaft     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x06d2
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzoj r1 = r1.zzafw     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r2.zzafv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzagq = r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzoj r2 = r2.zzafw     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzmy r3 = r3.zzafl     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r3 = r3.zzhq()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 == 0) goto L_0x0678
            r3 = 1
            goto L_0x0679
        L_0x0678:
            r3 = 0
        L_0x0679:
            r4 = 0
        L_0x067a:
            com.google.android.gms.internal.ads.zzhy[] r5 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r5 = r5.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r4 >= r5) goto L_0x06d2
            com.google.android.gms.internal.ads.zzhy[] r5 = r8.zzaeo     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r5 = r5[r4]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzoe r6 = r1.zzbhv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzoc r6 = r6.zzbe(r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r6 == 0) goto L_0x06cf
            if (r3 != 0) goto L_0x06cc
            boolean r6 = r5.zzee()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r6 != 0) goto L_0x06cf
            com.google.android.gms.internal.ads.zzoe r6 = r2.zzbhv     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzoc r6 = r6.zzbe(r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzia[] r7 = r1.zzbhx     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r7 = r7[r4]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzia[] r11 = r2.zzbhx     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r11 = r11[r4]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r6 == 0) goto L_0x06cc
            boolean r7 = r11.equals(r7)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r7 == 0) goto L_0x06cc
            int r7 = r6.length()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhp[] r7 = new com.google.android.gms.internal.ads.zzhp[r7]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r11 = 0
        L_0x06b0:
            int r12 = r7.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r11 >= r12) goto L_0x06bc
            com.google.android.gms.internal.ads.zzhp r12 = r6.zzbc(r11)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r7[r11] = r12     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r11 = r11 + 1
            goto L_0x06b0
        L_0x06bc:
            com.google.android.gms.internal.ads.zzhl r6 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zznn[] r6 = r6.zzafn     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r6 = r6[r4]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r11 = r8.zzagq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r11 = r11.zzep()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r5.zza(r7, r6, r11)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x06cf
        L_0x06cc:
            r5.zzed()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x06cf:
            int r4 = r4 + 1
            goto L_0x067a
        L_0x06d2:
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2 = 10
            if (r1 != 0) goto L_0x06e0
            r34.zzex()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zza((long) r14, (long) r2)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x0842
        L_0x06e0:
            java.lang.String r1 = "doSomeWork"
            com.google.android.gms.internal.ads.zzpq.beginSection(r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r34.zzev()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r1 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzmy r1 = r1.zzafl     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzho r4 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r4 = r4.zzagu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.zzee(r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhy[] r1 = r8.zzagg     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r4 = r1.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r5 = 0
            r6 = 1
            r7 = 1
        L_0x06f9:
            if (r5 >= r4) goto L_0x0730
            r11 = r1[r5]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r12 = r8.zzago     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r2 = r8.zzagl     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r11.zzb(r12, r2)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r7 == 0) goto L_0x070e
            boolean r2 = r11.zzfe()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == 0) goto L_0x070e
            r7 = 1
            goto L_0x070f
        L_0x070e:
            r7 = 0
        L_0x070f:
            boolean r2 = r11.isReady()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x071e
            boolean r2 = r11.zzfe()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == 0) goto L_0x071c
            goto L_0x071e
        L_0x071c:
            r2 = 0
            goto L_0x071f
        L_0x071e:
            r2 = 1
        L_0x071f:
            if (r2 != 0) goto L_0x0724
            r11.zzef()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0724:
            if (r6 == 0) goto L_0x072a
            if (r2 == 0) goto L_0x072a
            r6 = 1
            goto L_0x072b
        L_0x072a:
            r6 = 0
        L_0x072b:
            int r5 = r5 + 1
            r2 = 10
            goto L_0x06f9
        L_0x0730:
            if (r6 != 0) goto L_0x0735
            r34.zzex()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0735:
            com.google.android.gms.internal.ads.zzpg r1 = r8.zzagf     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x075a
            com.google.android.gms.internal.ads.zzpg r1 = r8.zzagf     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhv r1 = r1.zzfs()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhv r2 = r8.zzafg     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r2 = r1.equals(r2)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x075a
            r8.zzafg = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzpo r2 = r8.zzagb     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzpg r3 = r8.zzagf     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2.zza(r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Handler r2 = r8.zzaer     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3 = 7
            android.os.Message r1 = r2.obtainMessage(r3, r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.sendToTarget()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x075a:
            com.google.android.gms.internal.ads.zzhz r1 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r2.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r3 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r1 = r1.zza((int) r2, (com.google.android.gms.internal.ads.zzib) r3, (boolean) r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r1 = r1.zzaif     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r7 == 0) goto L_0x078b
            r3 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 == 0) goto L_0x077b
            com.google.android.gms.internal.ads.zzho r3 = r8.zzafh     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r3 = r3.zzagu     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x078b
        L_0x077b:
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r3 = r3.zzafs     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 == 0) goto L_0x078b
            r3 = 4
            r8.setState(r3)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r34.zzeu()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r4 = 2
            goto L_0x080b
        L_0x078b:
            int r3 = r8.state     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r4 = 2
            if (r3 != r4) goto L_0x07f0
            com.google.android.gms.internal.ads.zzhy[] r3 = r8.zzagg     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r3 = r3.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 <= 0) goto L_0x07de
            if (r6 == 0) goto L_0x07dc
            boolean r1 = r8.zzagi     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r2 = r2.zzaft     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 != 0) goto L_0x07a4
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r2 = r2.zzafr     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x07ac
        L_0x07a4:
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzmy r2 = r2.zzafl     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r2 = r2.zzhr()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x07ac:
            r5 = -9223372036854775808
            int r7 = (r2 > r5 ? 1 : (r2 == r5 ? 0 : -1))
            if (r7 != 0) goto L_0x07c8
            com.google.android.gms.internal.ads.zzhl r2 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r2 = r2.zzafs     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r2 == 0) goto L_0x07ba
            r1 = 1
            goto L_0x07d8
        L_0x07ba:
            com.google.android.gms.internal.ads.zzhz r2 = r8.zzafc     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r3 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r3 = r3.zzafq     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r5 = r8.zzaev     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzib r2 = r2.zza((int) r3, (com.google.android.gms.internal.ads.zzib) r5, (boolean) r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r2 = r2.zzaif     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x07c8:
            com.google.android.gms.internal.ads.zzht r5 = r8.zzafy     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhl r6 = r8.zzagp     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r11 = r8.zzago     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r6 = r6.zzep()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            long r11 = r11 - r6
            long r2 = r2 - r11
            boolean r1 = r5.zzc(r2, r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x07d8:
            if (r1 == 0) goto L_0x07dc
            r1 = 1
            goto L_0x07e2
        L_0x07dc:
            r1 = 0
            goto L_0x07e2
        L_0x07de:
            boolean r1 = r8.zzdr(r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x07e2:
            if (r1 == 0) goto L_0x080b
            r1 = 3
            r8.setState(r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            boolean r1 = r8.zzaex     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x080b
            r34.zzet()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x080b
        L_0x07f0:
            int r3 = r8.state     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r5 = 3
            if (r3 != r5) goto L_0x080b
            com.google.android.gms.internal.ads.zzhy[] r3 = r8.zzagg     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r3 = r3.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r3 <= 0) goto L_0x07fb
            goto L_0x07ff
        L_0x07fb:
            boolean r6 = r8.zzdr(r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x07ff:
            if (r6 != 0) goto L_0x080b
            boolean r1 = r8.zzaex     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzagi = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.setState(r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r34.zzeu()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x080b:
            int r1 = r8.state     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 != r4) goto L_0x081c
            com.google.android.gms.internal.ads.zzhy[] r1 = r8.zzagg     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r2 = r1.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0812:
            if (r9 >= r2) goto L_0x081c
            r3 = r1[r9]     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3.zzef()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r9 = r9 + 1
            goto L_0x0812
        L_0x081c:
            boolean r1 = r8.zzaex     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x0825
            int r1 = r8.state     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2 = 3
            if (r1 == r2) goto L_0x0829
        L_0x0825:
            int r1 = r8.state     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 != r4) goto L_0x082f
        L_0x0829:
            r1 = 10
            r8.zza((long) r14, (long) r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x083f
        L_0x082f:
            com.google.android.gms.internal.ads.zzhy[] r1 = r8.zzagg     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r1 = r1.length     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x083a
            r1 = 1000(0x3e8, double:4.94E-321)
            r8.zza((long) r14, (long) r1)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x083f
        L_0x083a:
            android.os.Handler r1 = r8.handler     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.removeMessages(r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x083f:
            com.google.android.gms.internal.ads.zzpq.endSection()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0842:
            return r10
        L_0x0843:
            r4 = 2
            int r1 = r1.arg1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x084a
            r1 = 1
            goto L_0x084b
        L_0x084a:
            r1 = 0
        L_0x084b:
            r8.zzagi = r9     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzaex = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 != 0) goto L_0x0858
            r34.zzeu()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r34.zzev()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x086d
        L_0x0858:
            int r1 = r8.state     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2 = 3
            if (r1 != r2) goto L_0x0866
            r34.zzet()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Handler r1 = r8.handler     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0862:
            r1.sendEmptyMessage(r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x086d
        L_0x0866:
            int r1 = r8.state     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 != r4) goto L_0x086d
            android.os.Handler r1 = r8.handler     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            goto L_0x0862
        L_0x086d:
            return r10
        L_0x086e:
            r4 = 2
            java.lang.Object r2 = r1.obj     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzna r2 = (com.google.android.gms.internal.ads.zzna) r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            int r1 = r1.arg1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x0879
            r1 = 1
            goto L_0x087a
        L_0x0879:
            r1 = 0
        L_0x087a:
            android.os.Handler r3 = r8.zzaer     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3.sendEmptyMessage(r9)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzi(r10)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzht r3 = r8.zzafy     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r3.zzfb()     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            if (r1 == 0) goto L_0x0895
            com.google.android.gms.internal.ads.zzho r1 = new com.google.android.gms.internal.ads.zzho     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r5 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            r1.<init>(r9, r5)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.zzafh = r1     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
        L_0x0895:
            r8.zzafz = r2     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            com.google.android.gms.internal.ads.zzhd r1 = r8.zzagd     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r2.zza(r1, r10, r8)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r8.setState(r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            android.os.Handler r1 = r8.handler     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            r1.sendEmptyMessage(r4)     // Catch:{ zzhe -> 0x08aa, IOException -> 0x08a5, RuntimeException -> 0x08af }
            return r10
        L_0x08a5:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x08cf
        L_0x08aa:
            r0 = move-exception
            r1 = r0
            r3 = 8
            goto L_0x08e1
        L_0x08af:
            r0 = move-exception
            r1 = r0
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r3 = "Internal runtime error."
            android.util.Log.e(r2, r3, r1)
            android.os.Handler r2 = r8.zzaer
            com.google.android.gms.internal.ads.zzhe r1 = com.google.android.gms.internal.ads.zzhe.zza((java.lang.RuntimeException) r1)
            r3 = 8
        L_0x08c0:
            android.os.Message r1 = r2.obtainMessage(r3, r1)
            r1.sendToTarget()
            r34.zzew()
            return r10
        L_0x08cb:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x08cf:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Source error."
            android.util.Log.e(r2, r4, r1)
            android.os.Handler r2 = r8.zzaer
            com.google.android.gms.internal.ads.zzhe r1 = com.google.android.gms.internal.ads.zzhe.zza((java.io.IOException) r1)
            goto L_0x08c0
        L_0x08dd:
            r0 = move-exception
            r3 = 8
            r1 = r0
        L_0x08e1:
            java.lang.String r2 = "ExoPlayerImplInternal"
            java.lang.String r4 = "Renderer error."
            android.util.Log.e(r2, r4, r1)
            android.os.Handler r2 = r8.zzaer
            goto L_0x08c0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.handleMessage(android.os.Message):boolean");
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:10|11|12|13|23|20|8) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x000d, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0015 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void release() {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzagh     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            android.os.Handler r0 = r2.handler     // Catch:{ all -> 0x0024 }
            r1 = 6
            r0.sendEmptyMessage(r1)     // Catch:{ all -> 0x0024 }
        L_0x000d:
            boolean r0 = r2.zzagh     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x001d
            r2.wait()     // Catch:{ InterruptedException -> 0x0015 }
            goto L_0x000d
        L_0x0015:
            java.lang.Thread r0 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0024 }
            r0.interrupt()     // Catch:{ all -> 0x0024 }
            goto L_0x000d
        L_0x001d:
            android.os.HandlerThread r0 = r2.zzagc     // Catch:{ all -> 0x0024 }
            r0.quit()     // Catch:{ all -> 0x0024 }
            monitor-exit(r2)
            return
        L_0x0024:
            r0 = move-exception
            monitor-exit(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.release():void");
    }

    public final void stop() {
        this.handler.sendEmptyMessage(5);
    }

    public final void zza(zzhz zzhz, int i, long j) {
        this.handler.obtainMessage(3, new zzhn(zzhz, i, j)).sendToTarget();
    }

    public final void zza(zzmy zzmy) {
        this.handler.obtainMessage(8, zzmy).sendToTarget();
    }

    public final void zza(zzna zzna, boolean z) {
        this.handler.obtainMessage(0, 1, 0, zzna).sendToTarget();
    }

    public final /* synthetic */ void zza(zznm zznm) {
        this.handler.obtainMessage(9, (zzmy) zznm).sendToTarget();
    }

    public final void zza(zzhi... zzhiArr) {
        if (this.zzagh) {
            Log.w("ExoPlayerImplInternal", "Ignoring messages sent after release.");
            return;
        }
        this.zzagj++;
        this.handler.obtainMessage(11, zzhiArr).sendToTarget();
    }

    public final void zzb(zzhz zzhz, Object obj) {
        this.handler.obtainMessage(7, Pair.create(zzhz, obj)).sendToTarget();
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(7:11|12|13|14|23|20|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x001f, code lost:
        continue;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0027 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(com.google.android.gms.internal.ads.zzhi... r4) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzagh     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x000e
            java.lang.String r4 = "ExoPlayerImplInternal"
            java.lang.String r0 = "Ignoring messages sent after release."
            android.util.Log.w(r4, r0)     // Catch:{ all -> 0x0031 }
            monitor-exit(r3)
            return
        L_0x000e:
            int r0 = r3.zzagj     // Catch:{ all -> 0x0031 }
            int r1 = r0 + 1
            r3.zzagj = r1     // Catch:{ all -> 0x0031 }
            android.os.Handler r1 = r3.handler     // Catch:{ all -> 0x0031 }
            r2 = 11
            android.os.Message r4 = r1.obtainMessage(r2, r4)     // Catch:{ all -> 0x0031 }
            r4.sendToTarget()     // Catch:{ all -> 0x0031 }
        L_0x001f:
            int r4 = r3.zzagk     // Catch:{ all -> 0x0031 }
            if (r4 > r0) goto L_0x002f
            r3.wait()     // Catch:{ InterruptedException -> 0x0027 }
            goto L_0x001f
        L_0x0027:
            java.lang.Thread r4 = java.lang.Thread.currentThread()     // Catch:{ all -> 0x0031 }
            r4.interrupt()     // Catch:{ all -> 0x0031 }
            goto L_0x001f
        L_0x002f:
            monitor-exit(r3)
            return
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzhm.zzb(com.google.android.gms.internal.ads.zzhi[]):void");
    }

    public final void zzes() {
        this.handler.sendEmptyMessage(10);
    }

    public final void zzf(boolean z) {
        this.handler.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
    }
}
