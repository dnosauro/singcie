package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzbie implements zzdld {
    private final /* synthetic */ zzbhg zzexw;
    private zzeps<Context> zzfkw;
    private zzeps<String> zzfkx;
    private zzeps<zzvn> zzfnj;
    private zzeps<zzcxq> zzfnk;
    private zzeps<zzdlf> zzfnl;
    private zzeps<zzdkv> zzfnm;
    private zzeps<zzcyg> zzfnn;

    private zzbie(zzbhg zzbhg, Context context, String str, zzvn zzvn) {
        this.zzexw = zzbhg;
        this.zzfkw = zzepi.zzbb(context);
        this.zzfnj = zzepi.zzbb(zzvn);
        this.zzfkx = zzepi.zzbb(str);
        this.zzfnk = zzepg.zzas(zzcxz.zzarv());
        this.zzfnl = zzepg.zzas(zzdly.zzaq(this.zzexw.zzexm));
        this.zzfnm = zzepg.zzas(new zzdla(this.zzfkw, this.zzexw.zzevn, this.zzexw.zzeve, this.zzfnk, this.zzfnl, zzdno.zzauo()));
        this.zzfnn = zzepg.zzas(new zzcyi(this.zzfkw, this.zzfnj, this.zzfkx, this.zzfnm, this.zzfnk, this.zzfnl));
    }

    public final zzcyg zzahj() {
        return this.zzfnn.get();
    }
}
