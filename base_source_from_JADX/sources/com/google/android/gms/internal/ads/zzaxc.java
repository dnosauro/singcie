package com.google.android.gms.internal.ads;

final /* synthetic */ class zzaxc implements zzaxk {
    static final zzaxk zzeaa = new zzaxc();

    private zzaxc() {
    }

    public final Object zzb(zzbgf zzbgf) {
        String currentScreenName = zzbgf.getCurrentScreenName();
        if (currentScreenName != null) {
            return currentScreenName;
        }
        String currentScreenClass = zzbgf.getCurrentScreenClass();
        return currentScreenClass != null ? currentScreenClass : "";
    }
}
