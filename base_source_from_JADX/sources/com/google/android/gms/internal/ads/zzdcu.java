package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdcu implements zzdfj<Bundle> {
    private final String zzdtr;
    private final boolean zzdtt;

    public zzdcu(String str, boolean z) {
        this.zzdtr = str;
        this.zzdtt = z;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putString("gct", this.zzdtr);
        if (this.zzdtt) {
            bundle.putString("de", "1");
        }
    }
}
