package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;

final /* synthetic */ class zzbfs implements zzdwf {
    private final Context zzclq;
    private final String zzdgt;
    private final zzbfn zzeqg;
    private final boolean zzeqh;
    private final boolean zzeqi;
    private final zzef zzeqj;
    private final zzacg zzeqk;
    private final zzazh zzeql;
    private final zzabs zzeqm = null;
    private final zzk zzeqn;
    private final zzb zzeqo;
    private final zzts zzeqp;
    private final zzsu zzeqq;
    private final boolean zzeqr;
    private final zzdmu zzeqs;
    private final zzdmz zzeqt;

    zzbfs(Context context, zzbfn zzbfn, String str, boolean z, boolean z2, zzef zzef, zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
        this.zzclq = context;
        this.zzeqg = zzbfn;
        this.zzdgt = str;
        this.zzeqh = z;
        this.zzeqi = z2;
        this.zzeqj = zzef;
        this.zzeqk = zzacg;
        this.zzeql = zzazh;
        this.zzeqn = zzk;
        this.zzeqo = zzb;
        this.zzeqp = zzts;
        this.zzeqq = zzsu;
        this.zzeqr = z3;
        this.zzeqs = zzdmu;
        this.zzeqt = zzdmz;
    }

    public final Object get() {
        Context context = this.zzclq;
        zzbfn zzbfn = this.zzeqg;
        String str = this.zzdgt;
        boolean z = this.zzeqh;
        boolean z2 = this.zzeqi;
        zzef zzef = this.zzeqj;
        zzacg zzacg = this.zzeqk;
        zzazh zzazh = this.zzeql;
        zzabs zzabs = this.zzeqm;
        zzk zzk = this.zzeqn;
        zzb zzb = this.zzeqo;
        zzts zzts = this.zzeqp;
        zzsu zzsu = this.zzeqq;
        boolean z3 = this.zzeqr;
        zzdmu zzdmu = this.zzeqs;
        zzdmz zzdmz = this.zzeqt;
        zzbfm zzbfm = r3;
        zzbfm zzbfm2 = new zzbfm();
        zzbfm zzbfm3 = zzbfm2;
        zzbfk zzbfk = r0;
        zzbfk zzbfk2 = new zzbfk(context);
        boolean z4 = z2;
        zzbfv zzbfv = new zzbfv(zzbfk, zzbfm, zzbfn, str, z, z2, zzef, zzacg, zzazh, zzabs, zzk, zzb, zzts, zzsu, z3, zzdmu, zzdmz);
        zzbeg zzbeg = new zzbeg(zzbfv);
        zzbfv.setWebChromeClient(new zzbdn(zzbeg));
        zzbfm3.zza((zzbdv) zzbeg, z4);
        return zzbeg;
    }
}
