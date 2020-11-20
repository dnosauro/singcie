package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.ads.internal.util.zzm;
import java.util.ArrayList;

public final class zzdnn {
    public final zzvn zzbpe;
    public final zzadz zzdnh;
    public final zzajl zzdui;
    public final int zzgwz;
    public final boolean zzgyj;
    public final zzxu zzhim;
    public final zzaak zzhin;
    public final zzvk zzhio;
    public final String zzhip;
    public final ArrayList<String> zzhiq;
    public final ArrayList<String> zzhir;
    public final zzvw zzhis;
    public final PublisherAdViewOptions zzhit;
    public final zzxo zzhiu;
    public final zzdna zzhiv;

    private zzdnn(zzdnp zzdnp) {
        this.zzbpe = zzdnp.zzbpe;
        this.zzhip = zzdnp.zzhip;
        this.zzhim = zzdnp.zzhim;
        this.zzhio = new zzvk(zzdnp.zzhio.versionCode, zzdnp.zzhio.zzcgy, zzdnp.zzhio.extras, zzdnp.zzhio.zzcgz, zzdnp.zzhio.zzcha, zzdnp.zzhio.zzchb, zzdnp.zzhio.zzadl, zzdnp.zzhio.zzbnx || zzdnp.zzbnx, zzdnp.zzhio.zzchc, zzdnp.zzhio.zzchd, zzdnp.zzhio.zzmy, zzdnp.zzhio.zzche, zzdnp.zzhio.zzchf, zzdnp.zzhio.zzchg, zzdnp.zzhio.zzchh, zzdnp.zzhio.zzchi, zzdnp.zzhio.zzchj, zzdnp.zzhio.zzchk, zzdnp.zzhio.zzchn, zzdnp.zzhio.zzadm, zzdnp.zzhio.zzadn, zzdnp.zzhio.zzchl, zzm.zzdg(zzdnp.zzhio.zzchm));
        this.zzhin = zzdnp.zzhin != null ? zzdnp.zzhin : zzdnp.zzdnh != null ? zzdnp.zzdnh.zzdep : null;
        this.zzhiq = zzdnp.zzhiq;
        this.zzhir = zzdnp.zzhir;
        this.zzdnh = zzdnp.zzhiq == null ? null : zzdnp.zzdnh == null ? new zzadz(new NativeAdOptions.Builder().build()) : zzdnp.zzdnh;
        this.zzhis = zzdnp.zzhis;
        this.zzgwz = zzdnp.zzgwz;
        this.zzhit = zzdnp.zzhit;
        this.zzhiu = zzdnp.zzhiu;
        this.zzdui = zzdnp.zzdui;
        this.zzhiv = new zzdna(zzdnp.zzhiw);
        this.zzgyj = zzdnp.zzgyj;
    }

    public final zzagd zzaun() {
        PublisherAdViewOptions publisherAdViewOptions = this.zzhit;
        if (publisherAdViewOptions == null) {
            return null;
        }
        return publisherAdViewOptions.zzjv();
    }
}
