package com.google.android.gms.internal.ads;

public final class zzdov implements zzepf<zzdor> {
    private final zzeps<zzdop> zzfrc;
    private final zzdot zzhkd;
    private final zzeps<String> zzhke;

    private zzdov(zzdot zzdot, zzeps<zzdop> zzeps, zzeps<String> zzeps2) {
        this.zzhkd = zzdot;
        this.zzfrc = zzeps;
        this.zzhke = zzeps2;
    }

    public static zzdov zza(zzdot zzdot, zzeps<zzdop> zzeps, zzeps<String> zzeps2) {
        return new zzdov(zzdot, zzeps, zzeps2);
    }

    public final /* synthetic */ Object get() {
        return (zzdor) zzepl.zza(this.zzfrc.get().zzgs(this.zzhke.get()), "Cannot return null from a non-@Nullable @Provides method");
    }
}
