package com.google.android.gms.internal.ads;

import android.annotation.SuppressLint;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.util.Log;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

final class zzhk implements zzhd {
    private int repeatMode;
    private final zzhy[] zzaeo;
    private final zzoh zzaep;
    private final zzoe zzaeq;
    private final Handler zzaer;
    private final zzhm zzaes;
    private final CopyOnWriteArraySet<zzhg> zzaet;
    private final zzie zzaeu;
    private final zzib zzaev;
    private boolean zzaew;
    private boolean zzaex;
    private int zzaey;
    private int zzaez;
    private int zzafa;
    private boolean zzafb;
    private zzhz zzafc;
    private Object zzafd;
    private zznq zzafe;
    private zzoe zzaff;
    private zzhv zzafg;
    private zzho zzafh;
    private int zzafi;
    private int zzafj;
    private long zzafk;

    @SuppressLint({"HandlerLeak"})
    public zzhk(zzhy[] zzhyArr, zzoh zzoh, zzht zzht) {
        String str = zzpt.zzbkl;
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 26);
        sb.append("Init ExoPlayerLib/2.4.2 [");
        sb.append(str);
        sb.append("]");
        Log.i("ExoPlayerImpl", sb.toString());
        zzpc.checkState(zzhyArr.length > 0);
        this.zzaeo = (zzhy[]) zzpc.checkNotNull(zzhyArr);
        this.zzaep = (zzoh) zzpc.checkNotNull(zzoh);
        this.zzaex = false;
        this.repeatMode = 0;
        this.zzaey = 1;
        this.zzaet = new CopyOnWriteArraySet<>();
        this.zzaeq = new zzoe(new zzoc[zzhyArr.length]);
        this.zzafc = zzhz.zzaib;
        this.zzaeu = new zzie();
        this.zzaev = new zzib();
        this.zzafe = zznq.zzbgs;
        this.zzaff = this.zzaeq;
        this.zzafg = zzhv.zzahx;
        this.zzaer = new zzhj(this, Looper.myLooper() != null ? Looper.myLooper() : Looper.getMainLooper());
        this.zzafh = new zzho(0, 0);
        this.zzaes = new zzhm(zzhyArr, zzoh, zzht, this.zzaex, 0, this.zzaer, this.zzafh, this);
    }

    private final int zzeo() {
        if (this.zzafc.isEmpty() || this.zzaez > 0) {
            return this.zzafi;
        }
        this.zzafc.zza(this.zzafh.zzafq, this.zzaev, false);
        return 0;
    }

    public final long getBufferedPosition() {
        if (this.zzafc.isEmpty() || this.zzaez > 0) {
            return this.zzafk;
        }
        this.zzafc.zza(this.zzafh.zzafq, this.zzaev, false);
        return this.zzaev.zzfh() + zzhb.zzdm(this.zzafh.zzagv);
    }

    public final long getDuration() {
        if (this.zzafc.isEmpty()) {
            return -9223372036854775807L;
        }
        return zzhb.zzdm(this.zzafc.zza(zzeo(), this.zzaeu, false).zzaif);
    }

    public final int getPlaybackState() {
        return this.zzaey;
    }

    public final void release() {
        this.zzaes.release();
        this.zzaer.removeCallbacksAndMessages((Object) null);
    }

    public final void seekTo(long j) {
        int zzeo = zzeo();
        if (zzeo < 0 || (!this.zzafc.isEmpty() && zzeo >= this.zzafc.zzff())) {
            throw new zzhu(this.zzafc, zzeo, j);
        }
        this.zzaez++;
        this.zzafi = zzeo;
        if (!this.zzafc.isEmpty()) {
            this.zzafc.zza(zzeo, this.zzaeu, false);
            long zzdn = (j == -9223372036854775807L ? 0 : zzhb.zzdn(j)) + 0;
            long j2 = this.zzafc.zza(0, this.zzaev, false).zzaif;
            if (j2 != -9223372036854775807L) {
                int i = (zzdn > j2 ? 1 : (zzdn == j2 ? 0 : -1));
            }
        }
        this.zzafj = 0;
        if (j == -9223372036854775807L) {
            this.zzafk = 0;
            this.zzaes.zza(this.zzafc, zzeo, -9223372036854775807L);
            return;
        }
        this.zzafk = j;
        this.zzaes.zza(this.zzafc, zzeo, zzhb.zzdn(j));
        Iterator<zzhg> it = this.zzaet.iterator();
        while (it.hasNext()) {
            it.next().zzen();
        }
    }

    public final void stop() {
        this.zzaes.stop();
    }

    /* access modifiers changed from: package-private */
    public final void zza(Message message) {
        boolean z = true;
        switch (message.what) {
            case 0:
                this.zzafa--;
                return;
            case 1:
                this.zzaey = message.arg1;
                Iterator<zzhg> it = this.zzaet.iterator();
                while (it.hasNext()) {
                    it.next().zza(this.zzaex, this.zzaey);
                }
                return;
            case 2:
                if (message.arg1 == 0) {
                    z = false;
                }
                this.zzafb = z;
                Iterator<zzhg> it2 = this.zzaet.iterator();
                while (it2.hasNext()) {
                    it2.next().zzg(this.zzafb);
                }
                return;
            case 3:
                if (this.zzafa == 0) {
                    zzoj zzoj = (zzoj) message.obj;
                    this.zzaew = true;
                    this.zzafe = zzoj.zzbhu;
                    this.zzaff = zzoj.zzbhv;
                    this.zzaep.zzd(zzoj.zzbhw);
                    Iterator<zzhg> it3 = this.zzaet.iterator();
                    while (it3.hasNext()) {
                        it3.next().zza(this.zzafe, this.zzaff);
                    }
                    return;
                }
                return;
            case 4:
                int i = this.zzaez - 1;
                this.zzaez = i;
                if (i == 0) {
                    this.zzafh = (zzho) message.obj;
                    if (message.arg1 != 0) {
                        Iterator<zzhg> it4 = this.zzaet.iterator();
                        while (it4.hasNext()) {
                            it4.next().zzen();
                        }
                        return;
                    }
                    return;
                }
                return;
            case 5:
                if (this.zzaez == 0) {
                    this.zzafh = (zzho) message.obj;
                    Iterator<zzhg> it5 = this.zzaet.iterator();
                    while (it5.hasNext()) {
                        it5.next().zzen();
                    }
                    return;
                }
                return;
            case 6:
                zzhq zzhq = (zzhq) message.obj;
                this.zzaez -= zzhq.zzahu;
                if (this.zzafa == 0) {
                    this.zzafc = zzhq.zzafc;
                    this.zzafd = zzhq.zzafd;
                    this.zzafh = zzhq.zzafh;
                    Iterator<zzhg> it6 = this.zzaet.iterator();
                    while (it6.hasNext()) {
                        it6.next().zza(this.zzafc, this.zzafd);
                    }
                    return;
                }
                return;
            case 7:
                zzhv zzhv = (zzhv) message.obj;
                if (!this.zzafg.equals(zzhv)) {
                    this.zzafg = zzhv;
                    Iterator<zzhg> it7 = this.zzaet.iterator();
                    while (it7.hasNext()) {
                        it7.next().zza(zzhv);
                    }
                    return;
                }
                return;
            case 8:
                zzhe zzhe = (zzhe) message.obj;
                Iterator<zzhg> it8 = this.zzaet.iterator();
                while (it8.hasNext()) {
                    it8.next().zza(zzhe);
                }
                return;
            default:
                throw new IllegalStateException();
        }
    }

    public final void zza(zzhg zzhg) {
        this.zzaet.add(zzhg);
    }

    public final void zza(zzna zzna) {
        if (!this.zzafc.isEmpty() || this.zzafd != null) {
            this.zzafc = zzhz.zzaib;
            this.zzafd = null;
            Iterator<zzhg> it = this.zzaet.iterator();
            while (it.hasNext()) {
                it.next().zza(this.zzafc, this.zzafd);
            }
        }
        if (this.zzaew) {
            this.zzaew = false;
            this.zzafe = zznq.zzbgs;
            this.zzaff = this.zzaeq;
            this.zzaep.zzd((Object) null);
            Iterator<zzhg> it2 = this.zzaet.iterator();
            while (it2.hasNext()) {
                it2.next().zza(this.zzafe, this.zzaff);
            }
        }
        this.zzafa++;
        this.zzaes.zza(zzna, true);
    }

    public final void zza(zzhi... zzhiArr) {
        this.zzaes.zza(zzhiArr);
    }

    public final void zzb(zzhg zzhg) {
        this.zzaet.remove(zzhg);
    }

    public final void zzb(zzhi... zzhiArr) {
        this.zzaes.zzb(zzhiArr);
    }

    public final boolean zzek() {
        return this.zzaex;
    }

    public final int zzel() {
        return this.zzaeo.length;
    }

    public final long zzem() {
        if (this.zzafc.isEmpty() || this.zzaez > 0) {
            return this.zzafk;
        }
        this.zzafc.zza(this.zzafh.zzafq, this.zzaev, false);
        return this.zzaev.zzfh() + zzhb.zzdm(this.zzafh.zzagu);
    }

    public final void zzf(boolean z) {
        if (this.zzaex != z) {
            this.zzaex = z;
            this.zzaes.zzf(z);
            Iterator<zzhg> it = this.zzaet.iterator();
            while (it.hasNext()) {
                it.next().zza(z, this.zzaey);
            }
        }
    }
}
