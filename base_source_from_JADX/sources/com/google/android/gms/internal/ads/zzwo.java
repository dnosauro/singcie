package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzwo extends zzwn<zzaui> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzani zzcim;
    private final /* synthetic */ zzvx zzcin;

    zzwo(zzvx zzvx, Context context, zzani zzani) {
        this.zzcin = zzvx;
        this.val$context = context;
        this.zzcim = zzani;
    }

    public final /* synthetic */ Object zza(zzxp zzxp) {
        return zzxp.zza(ObjectWrapper.wrap(this.val$context), this.zzcim, 203404000);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpt() {
        zzvx.zza(this.val$context, "rewarded_video");
        return new zzaaa();
    }

    public final /* synthetic */ Object zzpu() {
        return this.zzcin.zzcig.zzc(this.val$context, this.zzcim);
    }
}
