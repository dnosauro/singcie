package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzwj extends zzwn<zzxw> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvx zzcin;

    zzwj(zzvx zzvx, Context context) {
        this.zzcin = zzvx;
        this.val$context = context;
    }

    public final /* synthetic */ Object zza(zzxp zzxp) {
        return zzxp.zza(ObjectWrapper.wrap(this.val$context), 203404000);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpt() {
        zzvx.zza(this.val$context, "mobile_ads_settings");
        return new zzzu();
    }

    public final /* synthetic */ Object zzpu() {
        return this.zzcin.zzcie.zzh(this.val$context);
    }
}
