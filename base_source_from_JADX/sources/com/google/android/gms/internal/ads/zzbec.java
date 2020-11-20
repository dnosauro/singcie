package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;

final /* synthetic */ class zzbec implements zzdyb {
    private final Context zzclq;
    private final String zzdgv;
    private final zzef zzdir;
    private final zzazh zzeqd;
    private final zzb zzeqe;

    zzbec(Context context, zzef zzef, zzazh zzazh, zzb zzb, String str) {
        this.zzclq = context;
        this.zzdir = zzef;
        this.zzeqd = zzazh;
        this.zzeqe = zzb;
        this.zzdgv = str;
    }

    public final zzdyz zzf(Object obj) {
        Context context = this.zzclq;
        zzef zzef = this.zzdir;
        zzazh zzazh = this.zzeqd;
        zzb zzb = this.zzeqe;
        String str = this.zzdgv;
        zzp.zzkr();
        zzbdv zza = zzbed.zza(context, zzbfn.zzadv(), "", false, false, zzef, (zzacg) null, zzazh, (zzabs) null, (zzk) null, zzb, zzts.zzne(), (zzsu) null, false, (zzdmu) null, (zzdmz) null);
        zzazr zzl = zzazr.zzl(zza);
        zza.zzacs().zza((zzbfj) new zzbee(zzl));
        zza.loadUrl(str);
        return zzl;
    }
}
