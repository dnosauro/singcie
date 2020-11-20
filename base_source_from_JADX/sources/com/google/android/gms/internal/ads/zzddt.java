package com.google.android.gms.internal.ads;

import android.os.Bundle;
import java.util.Set;

public final class zzddt implements zzdfj<Bundle> {
    private final String zzhai;

    public zzddt(String str) {
        this.zzhai = str;
    }

    /* access modifiers changed from: private */
    public static boolean zze(Set<String> set) {
        return set.contains("rewarded") || set.contains("interstitial") || set.contains("native") || set.contains("banner");
    }

    public final /* synthetic */ void zzs(Object obj) {
        zzdnx.zza((Bundle) obj, "omid_v", this.zzhai);
    }
}
