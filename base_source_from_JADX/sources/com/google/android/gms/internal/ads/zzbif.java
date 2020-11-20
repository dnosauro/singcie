package com.google.android.gms.internal.ads;

import android.content.Context;

final class zzbif implements zzdlc {
    private final /* synthetic */ zzbhg zzexw;
    private Context zzflf;
    private String zzflg;
    private zzvn zzfno;

    private zzbif(zzbhg zzbhg) {
        this.zzexw = zzbhg;
    }

    public final zzdld zzahk() {
        zzepl.zza(this.zzflf, Context.class);
        zzepl.zza(this.zzflg, String.class);
        zzepl.zza(this.zzfno, zzvn.class);
        return new zzbie(this.zzexw, this.zzflf, this.zzflg, this.zzfno);
    }

    public final /* synthetic */ zzdlc zzc(zzvn zzvn) {
        this.zzfno = (zzvn) zzepl.checkNotNull(zzvn);
        return this;
    }

    public final /* synthetic */ zzdlc zzca(Context context) {
        this.zzflf = (Context) zzepl.checkNotNull(context);
        return this;
    }

    public final /* synthetic */ zzdlc zzfs(String str) {
        this.zzflg = (String) zzepl.checkNotNull(str);
        return this;
    }
}
