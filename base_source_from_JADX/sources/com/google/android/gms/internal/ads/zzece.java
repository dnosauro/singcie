package com.google.android.gms.internal.ads;

import java.security.KeyPair;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.ECPoint;

final class zzece extends zzead<zzeen, zzeer> {
    private final /* synthetic */ zzecc zziak;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzece(zzecc zzecc, Class cls) {
        super(cls);
        this.zziak = zzecc;
    }

    public final /* synthetic */ void zzc(zzels zzels) {
        zzeco.zza(((zzeen) zzels).zzbcc());
    }

    public final /* synthetic */ Object zzd(zzels zzels) {
        zzeen zzeen = (zzeen) zzels;
        KeyPair zza = zzehe.zza(zzehe.zza(zzeco.zza(zzeen.zzbcc().zzbce().zzbcr())));
        ECPoint w = ((ECPublicKey) zza.getPublic()).getW();
        return (zzeer) ((zzekh) zzeer.zzbck().zzfd(0).zzb((zzeeu) ((zzekh) zzeeu.zzbco().zzfe(0).zzc(zzeen.zzbcc()).zzac(zzeiu.zzt(w.getAffineX().toByteArray())).zzad(zzeiu.zzt(w.getAffineY().toByteArray())).zzbhv())).zzz(zzeiu.zzt(((ECPrivateKey) zza.getPrivate()).getS().toByteArray())).zzbhv());
    }

    public final /* synthetic */ zzels zzq(zzeiu zzeiu) {
        return zzeen.zzq(zzeiu, zzeju.zzbhe());
    }
}
