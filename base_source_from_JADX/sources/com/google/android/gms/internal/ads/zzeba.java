package com.google.android.gms.internal.ads;

final class zzeba extends zzead<zzedj, zzedi> {
    private final /* synthetic */ zzeaz zzhzv;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zzeba(zzeaz zzeaz, Class cls) {
        super(cls);
        this.zzhzv = zzeaz;
    }

    public final /* synthetic */ void zzc(zzels zzels) {
        zzedj zzedj = (zzedj) zzels;
        new zzebd().zzazy().zzc(zzedj.zzbay());
        new zzecu().zzazy().zzc(zzedj.zzbaz());
        zzeic.zzft(zzedj.zzbay().getKeySize());
    }

    public final /* synthetic */ Object zzd(zzels zzels) {
        zzedj zzedj = (zzedj) zzels;
        return (zzedi) ((zzekh) zzedi.zzbaw().zzc((zzedm) new zzebd().zzazy().zzd(zzedj.zzbay())).zzc((zzefc) new zzecu().zzazy().zzd(zzedj.zzbaz())).zzew(0).zzbhv());
    }

    public final /* synthetic */ zzels zzq(zzeiu zzeiu) {
        return zzedj.zzf(zzeiu, zzeju.zzbhe());
    }
}
