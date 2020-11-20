package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzbef implements zzdwf {
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

    zzbef(Context context, zzbfn zzbfn, String str, boolean z, boolean z2, zzef zzef, zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
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
        zzk zzk = this.zzeqn;
        zzb zzb = this.zzeqo;
        zzts zzts = this.zzeqp;
        zzsu zzsu = this.zzeqq;
        boolean z3 = this.zzeqr;
        boolean z4 = z3;
        zzbeg zzbeg = new zzbeg(zzbel.zzb(context, zzbfn, str, z, z2, zzef, zzacg, zzazh, (zzabs) null, zzk, zzb, zzts, zzsu, z4, this.zzeqs, this.zzeqt));
        zzbeg.setWebViewClient(zzp.zzks().zza(zzbeg, zzts, z2));
        zzbeg.setWebChromeClient(new zzbdn(zzbeg));
        return zzbeg;
    }
}
