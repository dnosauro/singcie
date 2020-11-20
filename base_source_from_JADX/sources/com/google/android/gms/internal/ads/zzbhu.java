package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzbhu implements zzdij {
    private final /* synthetic */ zzbhg zzexw;
    private zzeps<Context> zzfkw;
    private zzeps<String> zzfkx;
    private zzeps<zzdkl<zzblg, zzbll>> zzfky;
    private zzeps<zzdir> zzfkz;
    private zzeps<zzdib> zzfla;
    private zzeps<zzdid> zzflb;
    private zzeps<zzdkl<zzblp, zzblv>> zzflc;
    private zzeps<zzdjd> zzfld;
    private zzeps<zzdjf> zzfle;

    private zzbhu(zzbhg zzbhg, Context context, String str) {
        this.zzexw = zzbhg;
        this.zzfkw = zzepi.zzbb(context);
        this.zzfkx = zzepi.zzbb(str);
        this.zzfky = new zzdkr(this.zzfkw, this.zzexw.zzexm, this.zzexw.zzexn);
        this.zzfkz = zzepg.zzas(new zzdja(this.zzexw.zzexm));
        this.zzfla = zzepg.zzas(new zzdia(this.zzfkw, this.zzexw.zzevn, this.zzexw.zzeve, this.zzfky, this.zzfkz, zzdno.zzauo()));
        this.zzflb = zzepg.zzas(new zzdig(this.zzexw.zzeve, this.zzfkw, this.zzfkx, this.zzfla, this.zzfkz, this.zzexw.zzevv));
        this.zzflc = new zzdko(this.zzfkw, this.zzexw.zzexm, this.zzexw.zzexn);
        this.zzfld = zzepg.zzas(new zzdjc(this.zzfkw, this.zzexw.zzevn, this.zzexw.zzeve, this.zzflc, this.zzfkz, zzdno.zzauo()));
        this.zzfle = zzepg.zzas(new zzdjl(this.zzexw.zzeve, this.zzfkw, this.zzfkx, this.zzfld, this.zzfkz));
    }

    public final zzdid zzagu() {
        return this.zzflb.get();
    }

    public final zzdjf zzagv() {
        return this.zzfle.get();
    }
}
