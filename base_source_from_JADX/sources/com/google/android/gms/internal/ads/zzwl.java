package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.HashMap;

final class zzwl extends zzwn<zzaeq> {
    private final /* synthetic */ zzvx zzcin;
    private final /* synthetic */ View zzcip;
    private final /* synthetic */ HashMap zzciq;
    private final /* synthetic */ HashMap zzcir;

    zzwl(zzvx zzvx, View view, HashMap hashMap, HashMap hashMap2) {
        this.zzcin = zzvx;
        this.zzcip = view;
        this.zzciq = hashMap;
        this.zzcir = hashMap2;
    }

    public final /* synthetic */ Object zza(zzxp zzxp) {
        return zzxp.zza(ObjectWrapper.wrap(this.zzcip), ObjectWrapper.wrap(this.zzciq), ObjectWrapper.wrap(this.zzcir));
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpt() {
        zzvx.zza(this.zzcip.getContext(), "native_ad_view_holder_delegate");
        return new zzzz();
    }

    public final /* synthetic */ Object zzpu() {
        return this.zzcin.zzcij.zzb(this.zzcip, this.zzciq, this.zzcir);
    }
}
