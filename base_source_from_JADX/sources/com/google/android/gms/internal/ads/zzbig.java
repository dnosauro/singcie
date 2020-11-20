package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzbig implements zzdmm {
    private final /* synthetic */ zzbhg zzexw;
    private zzeps<Context> zzfkw;
    private zzeps<String> zzfkx;
    private zzeps<zzdlf> zzfnl;
    private zzeps<zzdkl<zzchf, zzchc>> zzfnp;
    private zzeps<zzdni> zzfnq;
    private zzeps<zzdma> zzfnr;
    private zzeps<zzdmo> zzfns;
    private zzeps<zzdmi> zzfnt;

    private zzbig(zzbhg zzbhg, Context context, String str) {
        this.zzexw = zzbhg;
        this.zzfkw = zzepi.zzbb(context);
        this.zzfnp = new zzdkq(this.zzfkw, this.zzexw.zzexm, this.zzexw.zzexn);
        this.zzfnl = zzepg.zzas(zzdly.zzaq(this.zzexw.zzexm));
        this.zzfnq = zzepg.zzas(zzdnl.zzaum());
        this.zzfnr = zzepg.zzas(new zzdmj(this.zzfkw, this.zzexw.zzevn, this.zzexw.zzeve, this.zzfnp, this.zzfnl, zzdno.zzauo(), this.zzfnq));
        this.zzfns = zzepg.zzas(new zzdmt(this.zzfnr, this.zzfnl, this.zzfnq));
        this.zzfkx = zzepi.zzbc(str);
        this.zzfnt = zzepg.zzas(new zzdmn(this.zzfkx, this.zzfnr, this.zzfkw, this.zzfnl, this.zzfnq));
    }

    public final zzdmo zzahl() {
        return this.zzfns.get();
    }

    public final zzdmi zzahm() {
        return this.zzfnt.get();
    }
}
