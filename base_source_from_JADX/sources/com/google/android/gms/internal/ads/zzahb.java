package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.Map;

public final class zzahb implements zzahv<Object> {
    private final zzaha zzdfs;

    public zzahb(zzaha zzaha) {
        this.zzdfs = zzaha;
    }

    public final void zza(Object obj, Map<String, String> map) {
        String str = map.get(AppMeasurementSdk.ConditionalUserProperty.NAME);
        if (str == null) {
            zzd.zzfa("App event with no name parameter.");
        } else {
            this.zzdfs.onAppEvent(str, map.get("info"));
        }
    }
}
