package com.google.android.gms.internal.ads;

final class zzzq extends zzwx {
    final /* synthetic */ zzzo zzckr;

    private zzzq(zzzo zzzo) {
        this.zzckr = zzzo;
    }

    public final String getMediationAdapterClassName() {
        return null;
    }

    public final boolean isLoading() {
        return false;
    }

    public final void zza(zzvk zzvk, int i) {
        zzaza.zzey("This app is using a lightweight version of the Google Mobile Ads SDK that requires the latest Google Play services to be installed, but Google Play services is either missing or out of date.");
        zzayr.zzzz.post(new zzzt(this));
    }

    public final void zzb(zzvk zzvk) {
        zza(zzvk, 1);
    }

    public final String zzkg() {
        return null;
    }
}
