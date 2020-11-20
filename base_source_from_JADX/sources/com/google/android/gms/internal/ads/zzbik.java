package com.google.android.gms.internal.ads;

final class zzbik implements zzcyy {
    private zzbrg zzexq;
    private final /* synthetic */ zzbhg zzexw;
    private zzczo zzfod;

    private zzbik(zzbhg zzbhg) {
        this.zzexw = zzbhg;
    }

    public final /* synthetic */ zzcyy zza(zzczo zzczo) {
        this.zzfod = (zzczo) zzepl.checkNotNull(zzczo);
        return this;
    }

    public final zzcyv zzahp() {
        zzepl.zza(this.zzexq, zzbrg.class);
        zzepl.zza(this.zzfod, zzczo.class);
        return new zzbin(this.zzexw, this.zzfod, new zzbpf(), new zzcld(), this.zzexq, new zzdot(), (zzdkt) null, (zzdjv) null, (zzbhj) null);
    }

    public final /* synthetic */ zzcyy zzg(zzbrg zzbrg) {
        this.zzexq = (zzbrg) zzepl.checkNotNull(zzbrg);
        return this;
    }

    @Deprecated
    public final /* synthetic */ zzcyy zzg(zzbwp zzbwp) {
        zzepl.checkNotNull(zzbwp);
        return this;
    }
}
