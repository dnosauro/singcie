package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import javax.annotation.Nullable;

public final class zzdby implements zzdfj<Bundle> {
    private final String zzgya;

    public zzdby(@Nullable String str) {
        this.zzgya = str;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (!TextUtils.isEmpty(this.zzgya)) {
            bundle.putString("fwd_cld", this.zzgya);
        }
    }
}
