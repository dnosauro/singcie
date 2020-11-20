package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzaoi extends zzanr {
    private final zzauw zzdmq;
    private final Adapter zzdmy;

    zzaoi(Adapter adapter, zzauw zzauw) {
        this.zzdmy = adapter;
        this.zzdmq = zzauw;
    }

    public final void onAdClicked() {
        zzauw zzauw = this.zzdmq;
        if (zzauw != null) {
            zzauw.zzak(ObjectWrapper.wrap(this.zzdmy));
        }
    }

    public final void onAdClosed() {
        zzauw zzauw = this.zzdmq;
        if (zzauw != null) {
            zzauw.zzaj(ObjectWrapper.wrap(this.zzdmy));
        }
    }

    public final void onAdFailedToLoad(int i) {
        zzauw zzauw = this.zzdmq;
        if (zzauw != null) {
            zzauw.zze(ObjectWrapper.wrap(this.zzdmy), i);
        }
    }

    public final void onAdImpression() {
    }

    public final void onAdLeftApplication() {
    }

    public final void onAdLoaded() {
        zzauw zzauw = this.zzdmq;
        if (zzauw != null) {
            zzauw.zzag(ObjectWrapper.wrap(this.zzdmy));
        }
    }

    public final void onAdOpened() {
        zzauw zzauw = this.zzdmq;
        if (zzauw != null) {
            zzauw.zzah(ObjectWrapper.wrap(this.zzdmy));
        }
    }

    public final void onAppEvent(String str, String str2) {
    }

    public final void onVideoEnd() {
    }

    public final void onVideoPause() {
    }

    public final void onVideoPlay() {
    }

    public final void zza(zzaff zzaff, String str) {
    }

    public final void zza(zzant zzant) {
    }

    public final void zza(zzavc zzavc) {
        zzauw zzauw = this.zzdmq;
        if (zzauw != null) {
            zzauw.zza(ObjectWrapper.wrap(this.zzdmy), new zzava(zzavc.getType(), zzavc.getAmount()));
        }
    }

    public final void zzb(Bundle bundle) {
    }

    public final void zzb(zzava zzava) {
    }

    public final void zzc(int i, String str) {
    }

    public final void zzc(zzve zzve) {
    }

    public final void zzdc(int i) {
    }

    public final void zzdj(String str) {
    }

    public final void zzdk(String str) {
    }

    public final void zze(zzve zzve) {
    }

    public final void zzun() {
        zzauw zzauw = this.zzdmq;
        if (zzauw != null) {
            zzauw.zzai(ObjectWrapper.wrap(this.zzdmy));
        }
    }

    public final void zzuo() {
        zzauw zzauw = this.zzdmq;
        if (zzauw != null) {
            zzauw.zzam(ObjectWrapper.wrap(this.zzdmy));
        }
    }
}
