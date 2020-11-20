package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;

public final class zzchp {
    private final Context context;
    private final zzazh zzbpd;
    private final zzbed zzbpq;
    private final zzts zzeph;
    private final zzef zzerb;
    private final zzacg zzerc;
    private final zzb zzere;
    private final zzsu zzerg;
    /* access modifiers changed from: private */
    public final zzbua zzgij;

    public zzchp(zzbed zzbed, Context context2, zzef zzef, zzacg zzacg, zzazh zzazh, zzb zzb, zzts zzts, zzbua zzbua, zzbyw zzbyw) {
        this.zzbpq = zzbed;
        this.context = context2;
        this.zzerb = zzef;
        this.zzerc = zzacg;
        this.zzbpd = zzazh;
        this.zzere = zzb;
        this.zzeph = zzts;
        this.zzgij = zzbua;
        this.zzerg = zzbyw;
    }

    public final zzbdv zza(zzvn zzvn, zzdmu zzdmu, zzdmz zzdmz, boolean z) {
        return zzbed.zza(this.context, zzbfn.zzb(zzvn), zzvn.zzacv, false, false, this.zzerb, this.zzerc, this.zzbpd, (zzabs) null, new zzchs(this), this.zzere, this.zzeph, this.zzerg, z, zzdmu, zzdmz);
    }

    public final zzbdv zzd(zzvn zzvn) {
        return zza(zzvn, (zzdmu) null, (zzdmz) null, false);
    }
}
