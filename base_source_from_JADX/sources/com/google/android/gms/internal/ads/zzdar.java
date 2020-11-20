package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdar implements zzdfj<Bundle> {
    private final Bundle zzgyr;

    private zzdar(Bundle bundle) {
        this.zzgyr = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!this.zzgyr.isEmpty()) {
            bundle.putBundle("installed_adapter_data", this.zzgyr);
        }
    }
}
