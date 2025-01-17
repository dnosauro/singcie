package com.google.firebase.analytics.connector.internal;

import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.connector.AnalyticsConnector;
import java.util.HashSet;
import java.util.Set;

public final class zzc implements zza {
    Set<String> zza;
    /* access modifiers changed from: private */
    public AnalyticsConnector.AnalyticsConnectorListener zzb;
    private AppMeasurementSdk zzc;
    private zzf zzd = new zzf(this);

    public zzc(AppMeasurementSdk appMeasurementSdk, AnalyticsConnector.AnalyticsConnectorListener analyticsConnectorListener) {
        this.zzb = analyticsConnectorListener;
        this.zzc = appMeasurementSdk;
        this.zzc.registerOnMeasurementEventListener(this.zzd);
        this.zza = new HashSet();
    }

    public final AnalyticsConnector.AnalyticsConnectorListener zza() {
        return this.zzb;
    }

    public final void zza(Set<String> set) {
        this.zza.clear();
        Set<String> set2 = this.zza;
        HashSet hashSet = new HashSet();
        for (String next : set) {
            if (hashSet.size() >= 50) {
                break;
            } else if (zzd.zzd(next) && zzd.zzc(next)) {
                hashSet.add(zzd.zzf(next));
            }
        }
        set2.addAll(hashSet);
    }

    public final void zzb() {
        this.zza.clear();
    }
}
