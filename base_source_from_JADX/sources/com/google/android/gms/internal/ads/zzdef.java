package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdef implements zzdfj<Bundle> {
    private String zzdtb;

    public zzdef(String str) {
        this.zzdtb = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        ((Bundle) obj).putString("request_id", this.zzdtb);
    }
}
