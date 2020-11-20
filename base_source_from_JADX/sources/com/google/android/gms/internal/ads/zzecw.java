package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;

final class zzecw extends zzead<zzefd, zzefc> {
    private final /* synthetic */ zzecu zziaw;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzecw(zzecu zzecu, Class cls) {
        super(cls);
        this.zziaw = zzecu;
    }

    public final /* synthetic */ void zzc(zzels zzels) {
        zzefd zzefd = (zzefd) zzels;
        if (zzefd.getKeySize() >= 16) {
            zzecu.zza(zzefd.zzbcw());
            return;
        }
        throw new GeneralSecurityException("key too short");
    }

    public final /* synthetic */ Object zzd(zzels zzels) {
        zzefd zzefd = (zzefd) zzels;
        return (zzefc) ((zzekh) zzefc.zzbcx().zzfh(0).zzd(zzefd.zzbcw()).zzae(zzeiu.zzt(zzehx.zzfs(zzefd.getKeySize()))).zzbhv());
    }

    public final /* synthetic */ zzels zzq(zzeiu zzeiu) {
        return zzefd.zzu(zzeiu, zzeju.zzbhe());
    }
}
