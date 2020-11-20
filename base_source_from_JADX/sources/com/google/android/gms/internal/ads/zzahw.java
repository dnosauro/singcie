package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Map;

public final class zzahw implements zzahv<zzbdv> {
    private static final Map<String, Integer> zzdgr = CollectionUtils.mapOfKeyValueArrays(new String[]{"resize", "playVideo", "storePicture", "createCalendarEvent", "setOrientationProperties", "closeResizedAd", "unload"}, new Integer[]{1, 2, 3, 4, 5, 6, 7});
    private final zza zzdgo;
    private final zzaqk zzdgp;
    private final zzaqx zzdgq;

    public zzahw(zza zza, zzaqk zzaqk, zzaqx zzaqx) {
        this.zzdgo = zza;
        this.zzdgp = zzaqk;
        this.zzdgq = zzaqx;
    }

    public final /* synthetic */ void zza(Object obj, Map map) {
        zza zza;
        zzbdv zzbdv = (zzbdv) obj;
        int intValue = zzdgr.get((String) map.get("a")).intValue();
        if (intValue != 5 && intValue != 7 && (zza = this.zzdgo) != null && !zza.zzjy()) {
            this.zzdgo.zzbk((String) null);
        } else if (intValue != 1) {
            switch (intValue) {
                case 3:
                    new zzaqp(zzbdv, map).execute();
                    return;
                case 4:
                    new zzaqj(zzbdv, map).execute();
                    return;
                case 5:
                    new zzaqm(zzbdv, map).execute();
                    return;
                case 6:
                    this.zzdgp.zzac(true);
                    return;
                case 7:
                    this.zzdgq.zzvb();
                    return;
                default:
                    zzd.zzez("Unknown MRAID command called.");
                    return;
            }
        } else {
            this.zzdgp.zzg(map);
        }
    }
}
