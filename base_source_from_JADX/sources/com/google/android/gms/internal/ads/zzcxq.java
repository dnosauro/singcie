package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.concurrent.atomic.AtomicReference;

public final class zzcxq implements AppEventListener, zzbru, zzbrz, zzbsm, zzbtj, zzbub, zzva {
    private final AtomicReference<zzwt> zzgwc = new AtomicReference<>();
    private final AtomicReference<zzxo> zzgwd = new AtomicReference<>();
    private final AtomicReference<zzym> zzgwe = new AtomicReference<>();

    public final void onAdClicked() {
        zzdkb.zza(this.zzgwc, zzcxv.zzgwb);
    }

    public final void onAdClosed() {
        zzdkb.zza(this.zzgwc, zzcxp.zzgwb);
    }

    public final void onAdImpression() {
        zzdkb.zza(this.zzgwc, zzcxy.zzgwb);
    }

    public final void onAdLeftApplication() {
        zzdkb.zza(this.zzgwc, zzcxu.zzgwb);
    }

    public final void onAdLoaded() {
        zzdkb.zza(this.zzgwc, zzcxt.zzgwb);
    }

    public final void onAdOpened() {
        zzdkb.zza(this.zzgwc, zzcxw.zzgwb);
    }

    public final void onAppEvent(String str, String str2) {
        zzdkb.zza(this.zzgwd, new zzcya(str, str2));
    }

    public final void onRewardedVideoCompleted() {
    }

    public final void onRewardedVideoStarted() {
    }

    public final synchronized zzwt zzart() {
        return this.zzgwc.get();
    }

    public final synchronized zzxo zzaru() {
        return this.zzgwd.get();
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
    }

    public final void zzb(zzvp zzvp) {
        zzdkb.zza(this.zzgwe, new zzcxx(zzvp));
    }

    public final void zzb(zzxo zzxo) {
        this.zzgwd.set(zzxo);
    }

    public final void zzb(zzym zzym) {
        this.zzgwe.set(zzym);
    }

    public final void zzc(zzwt zzwt) {
        this.zzgwc.set(zzwt);
    }

    public final void zzk(zzve zzve) {
        zzdkb.zza(this.zzgwc, new zzcxs(zzve));
        zzdkb.zza(this.zzgwc, new zzcxr(zzve));
    }
}
