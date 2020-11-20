package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdeb implements zzdfj<Bundle> {
    private final Bundle zzfxi;

    public zzdeb(Bundle bundle) {
        this.zzfxi = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Bundle bundle2 = this.zzfxi;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
    }
}
