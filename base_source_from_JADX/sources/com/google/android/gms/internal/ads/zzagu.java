package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.PublisherAdView;

final class zzagu implements Runnable {
    private final /* synthetic */ PublisherAdView zzdfl;
    private final /* synthetic */ zzxg zzdfm;
    private final /* synthetic */ zzagv zzdfn;

    zzagu(zzagv zzagv, PublisherAdView publisherAdView, zzxg zzxg) {
        this.zzdfn = zzagv;
        this.zzdfl = publisherAdView;
        this.zzdfm = zzxg;
    }

    public final void run() {
        if (this.zzdfl.zza(this.zzdfm)) {
            this.zzdfn.zzdfo.onPublisherAdViewLoaded(this.zzdfl);
        } else {
            zzaza.zzfa("Could not bind.");
        }
    }
}
