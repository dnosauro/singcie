package com.google.android.gms.ads.mediation.rtb;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import java.util.List;

public class RtbSignalData {
    private final Context context;
    private final Bundle zzchf;
    private final AdSize zzdq;
    private final List<MediationConfiguration> zzeuz;

    public RtbSignalData(Context context2, List<MediationConfiguration> list, Bundle bundle, AdSize adSize) {
        this.context = context2;
        this.zzeuz = list;
        this.zzchf = bundle;
        this.zzdq = adSize;
    }

    public AdSize getAdSize() {
        return this.zzdq;
    }

    @Deprecated
    public MediationConfiguration getConfiguration() {
        List<MediationConfiguration> list = this.zzeuz;
        if (list == null || list.size() <= 0) {
            return null;
        }
        return this.zzeuz.get(0);
    }

    public List<MediationConfiguration> getConfigurations() {
        return this.zzeuz;
    }

    public Context getContext() {
        return this.context;
    }

    public Bundle getNetworkExtras() {
        return this.zzchf;
    }
}
