package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdbh implements zzdfj<Bundle> {
    private final boolean zzgza = false;
    private final boolean zzgzb = false;
    private final boolean zzgzc;

    public zzdbh(boolean z, boolean z2, boolean z3) {
        this.zzgzc = z3;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putBoolean("c_pcbg", false);
        bundle.putBoolean("c_phbg", false);
        bundle.putBoolean("ar_lr", this.zzgzc);
    }
}
