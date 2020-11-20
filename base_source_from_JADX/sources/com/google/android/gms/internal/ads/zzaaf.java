package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.OnPaidEventListener;

public final class zzaaf extends zzyl {
    private final OnPaidEventListener zzcla;

    public zzaaf(OnPaidEventListener onPaidEventListener) {
        this.zzcla = onPaidEventListener;
    }

    public final void zza(zzvp zzvp) {
        if (this.zzcla != null) {
            this.zzcla.onPaidEvent(AdValue.zza(zzvp.zzacz, zzvp.zzada, zzvp.zzadb));
        }
    }
}
