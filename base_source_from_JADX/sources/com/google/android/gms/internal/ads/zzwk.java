package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzwk extends zzwn<zzwz> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcil;
    private final /* synthetic */ zzani zzcim;
    private final /* synthetic */ zzvx zzcin;

    zzwk(zzvx zzvx, Context context, String str, zzani zzani) {
        this.zzcin = zzvx;
        this.val$context = context;
        this.zzcil = str;
        this.zzcim = zzani;
    }

    public final /* synthetic */ Object zza(zzxp zzxp) {
        return zzxp.zza(ObjectWrapper.wrap(this.val$context), this.zzcil, this.zzcim, 203404000);
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object zzpt() {
        zzvx.zza(this.val$context, "native_ad");
        return new zzzo();
    }

    public final /* synthetic */ Object zzpu() {
        return this.zzcin.zzcid.zza(this.val$context, this.zzcil, this.zzcim);
    }
}
