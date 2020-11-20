package com.google.android.gms.internal.ads;

import android.net.Uri;
import android.os.Handler;

public final class zzmw implements zzna, zznd {
    private final Uri uri;
    private final Handler zzaer;
    private final zzib zzaev;
    private zzhz zzafc;
    private final int zzbdh;
    private final zzmz zzbdi;
    private zznd zzbdj;
    private final String zzbdl = null;
    private final zzom zzber;
    private final zzkb zzbes;
    private final int zzbet;
    private boolean zzbeu;

    public zzmw(Uri uri2, zzom zzom, zzkb zzkb, int i, Handler handler, zzmz zzmz, String str, int i2) {
        this.uri = uri2;
        this.zzber = zzom;
        this.zzbes = zzkb;
        this.zzbdh = i;
        this.zzaer = handler;
        this.zzbdi = zzmz;
        this.zzbet = i2;
        this.zzaev = new zzib();
    }

    public final zzmy zza(int i, zzol zzol) {
        zzpc.checkArgument(i == 0);
        return new zzmo(this.uri, this.zzber.zzip(), this.zzbes.zzgt(), this.zzbdh, this.zzaer, this.zzbdi, this, zzol, (String) null, this.zzbet);
    }

    public final void zza(zzhd zzhd, boolean z, zznd zznd) {
        this.zzbdj = zznd;
        this.zzafc = new zzno(-9223372036854775807L, false);
        zznd.zzb(this.zzafc, (Object) null);
    }

    public final void zzb(zzhz zzhz, Object obj) {
        boolean z = false;
        if (zzhz.zza(0, this.zzaev, false).zzaif != -9223372036854775807L) {
            z = true;
        }
        if (!this.zzbeu || z) {
            this.zzafc = zzhz;
            this.zzbeu = z;
            this.zzbdj.zzb(this.zzafc, (Object) null);
        }
    }

    public final void zzb(zzmy zzmy) {
        ((zzmo) zzmy).release();
    }

    public final void zzhz() {
    }

    public final void zzia() {
        this.zzbdj = null;
    }
}
