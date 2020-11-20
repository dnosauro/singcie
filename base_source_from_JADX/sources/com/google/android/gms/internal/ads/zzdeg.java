package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;

public final class zzdeg implements zzdfi<zzdfj<Bundle>> {
    private final Context context;
    private final String zzfxj;

    zzdeg(Context context2, String str) {
        this.context = context2;
        this.zzfxj = str;
    }

    public final zzdyz<zzdfj<Bundle>> zzasm() {
        return zzdyr.zzag(this.zzfxj == null ? null : new zzdej(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(Bundle bundle) {
        bundle.putString("rewarded_sku_package", this.context.getPackageName());
    }
}
