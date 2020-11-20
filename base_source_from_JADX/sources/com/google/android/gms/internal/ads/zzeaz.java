package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzefh;

public final class zzeaz extends zzeae<zzedi> {
    zzeaz() {
        super(zzedi.class, new zzebb(zzdzt.class));
    }

    public final String getKeyType() {
        return "type.googleapis.com/google.crypto.tink.AesCtrHmacAeadKey";
    }

    public final zzefh.zzb zzazv() {
        return zzefh.zzb.SYMMETRIC;
    }

    public final zzead<zzedj, zzedi> zzazy() {
        return new zzeba(this, zzedj.class);
    }

    public final /* synthetic */ void zze(zzels zzels) {
        zzedi zzedi = (zzedi) zzels;
        zzeic.zzz(zzedi.getVersion(), 0);
        new zzebd();
        zzebd.zza(zzedi.zzbau());
        new zzecu();
        zzecu.zza(zzedi.zzbav());
    }

    public final /* synthetic */ zzels zzr(zzeiu zzeiu) {
        return zzedi.zze(zzeiu, zzeju.zzbhe());
    }
}
