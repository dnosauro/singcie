package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdel implements zzdfj<Bundle> {
    private final String zzhap;

    public zzdel(String str) {
        this.zzhap = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        ((Bundle) obj).putString("rtb", this.zzhap);
    }
}
