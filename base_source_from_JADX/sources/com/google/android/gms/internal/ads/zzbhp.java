package com.google.android.gms.internal.ads;

final class zzbhp implements zzbls {
    private zzbwp zzexp;
    private zzbrg zzexq;
    private zzdnj zzext;
    private zzdkt zzexu;
    private zzdjv zzexv;
    private final /* synthetic */ zzbhg zzexw;

    private zzbhp(zzbhg zzbhg) {
        this.zzexw = zzbhg;
    }

    public final /* synthetic */ zzbrd zza(zzdjv zzdjv) {
        this.zzexv = zzdjv;
        return this;
    }

    public final /* synthetic */ zzbrd zza(zzdkt zzdkt) {
        this.zzexu = zzdkt;
        return this;
    }

    public final /* synthetic */ zzbrd zza(zzdnj zzdnj) {
        this.zzext = zzdnj;
        return this;
    }

    public final /* synthetic */ Object zzafp() {
        zzepl.zza(this.zzexp, zzbwp.class);
        zzepl.zza(this.zzexq, zzbrg.class);
        return new zzbho(this.zzexw, new zzbpf(), new zzdol(), new zzbqq(), new zzcld(), this.zzexp, this.zzexq, new zzdot(), this.zzext, this.zzexu, this.zzexv);
    }

    @Deprecated
    public final /* synthetic */ zzbls zzb(zzblz zzblz) {
        zzepl.checkNotNull(zzblz);
        return this;
    }

    public final /* synthetic */ zzbls zzb(zzbrg zzbrg) {
        this.zzexq = (zzbrg) zzepl.checkNotNull(zzbrg);
        return this;
    }

    public final /* synthetic */ zzbls zzb(zzbwp zzbwp) {
        this.zzexp = (zzbwp) zzepl.checkNotNull(zzbwp);
        return this;
    }
}
