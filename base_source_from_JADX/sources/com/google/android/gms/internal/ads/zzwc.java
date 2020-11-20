package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzwc extends zzwn<zzarj> {
    private final /* synthetic */ Activity val$activity;
    private final /* synthetic */ zzvx zzcin;

    zzwc(zzvx zzvx, Activity activity) {
        this.zzcin = zzvx;
        this.val$activity = activity;
    }

    public final /* synthetic */ Object zza(zzxp zzxp) {
        return zzxp.zzb(ObjectWrapper.wrap(this.val$activity));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpt() {
        zzvx.zza((Context) this.val$activity, "ad_overlay");
        return null;
    }

    public final /* synthetic */ Object zzpu() {
        return this.zzcin.zzcii.zze(this.val$activity);
    }
}
