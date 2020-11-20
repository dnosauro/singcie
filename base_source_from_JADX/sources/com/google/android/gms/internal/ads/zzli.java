package com.google.android.gms.internal.ads;

final class zzli {
    public final zzkh zzaso;
    public final zzlq zzayj = new zzlq();
    public zzlo zzayk;
    public zzlc zzayl;
    public int zzaym;
    public int zzayn;
    public int zzayo;
    public zzkg zzayp;
    public zzlr zzayq;

    public zzli(zzkh zzkh) {
        this.zzaso = zzkh;
    }

    public final void reset() {
        zzlq zzlq = this.zzayj;
        zzlq.zzbal = 0;
        zzlq.zzbay = 0;
        zzlq.zzbas = false;
        zzlq.zzbax = false;
        zzlq.zzbau = null;
        this.zzaym = 0;
        this.zzayo = 0;
        this.zzayn = 0;
        this.zzayp = null;
        this.zzayq = null;
    }

    public final void zza(zzlo zzlo, zzlc zzlc) {
        this.zzayk = (zzlo) zzpc.checkNotNull(zzlo);
        this.zzayl = (zzlc) zzpc.checkNotNull(zzlc);
        this.zzaso.zze(zzlo.zzahv);
        reset();
    }
}
