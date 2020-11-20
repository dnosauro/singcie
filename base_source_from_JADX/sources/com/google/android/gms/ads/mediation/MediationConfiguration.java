package com.google.android.gms.ads.mediation;

import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;

public class MediationConfiguration {
    private final Bundle zzetq;
    private final AdFormat zzetu;

    public MediationConfiguration(AdFormat adFormat, Bundle bundle) {
        this.zzetu = adFormat;
        this.zzetq = bundle;
    }

    public AdFormat getFormat() {
        return this.zzetu;
    }

    public Bundle getServerParameters() {
        return this.zzetq;
    }
}
