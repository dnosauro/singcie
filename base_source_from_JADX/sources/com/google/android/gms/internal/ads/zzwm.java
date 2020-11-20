package com.google.android.gms.internal.ads;

import android.content.Context;
import android.widget.FrameLayout;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzwm extends zzwn<zzaen> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzvx zzcin;
    private final /* synthetic */ FrameLayout zzcis;
    private final /* synthetic */ FrameLayout zzcit;

    zzwm(zzvx zzvx, FrameLayout frameLayout, FrameLayout frameLayout2, Context context) {
        this.zzcin = zzvx;
        this.zzcis = frameLayout;
        this.zzcit = frameLayout2;
        this.val$context = context;
    }

    public final /* synthetic */ Object zza(zzxp zzxp) {
        return zzxp.zza(ObjectWrapper.wrap(this.zzcis), ObjectWrapper.wrap(this.zzcit));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpt() {
        zzvx.zza(this.val$context, "native_ad_view_delegate");
        return new zzzw();
    }

    public final /* synthetic */ Object zzpu() {
        return this.zzcin.zzcif.zzb(this.val$context, this.zzcis, this.zzcit);
    }
}
