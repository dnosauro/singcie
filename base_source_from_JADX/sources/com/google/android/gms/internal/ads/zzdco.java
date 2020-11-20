package com.google.android.gms.internal.ads;

import android.os.Bundle;

final class zzdco implements zzdfj<Bundle> {
    private final String zzduh;
    private final String zzgzv;
    private final Bundle zzgzw;

    private zzdco(String str, String str2, Bundle bundle) {
        this.zzduh = str;
        this.zzgzv = str2;
        this.zzgzw = bundle;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("consent_string", this.zzduh);
        bundle.putString("fc_consent", this.zzgzv);
        bundle.putBundle("iab_consent_info", this.zzgzw);
    }
}
