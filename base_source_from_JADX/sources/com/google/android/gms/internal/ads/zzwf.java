package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;

final class zzwf extends zzwn<zzxg> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ String zzcil;
    private final /* synthetic */ zzani zzcim;
    private final /* synthetic */ zzvx zzcin;
    private final /* synthetic */ zzvn zzcio;

    zzwf(zzvx zzvx, Context context, zzvn zzvn, String str, zzani zzani) {
        this.zzcin = zzvx;
        this.val$context = context;
        this.zzcio = zzvn;
        this.zzcil = str;
        this.zzcim = zzani;
    }

    public final /* synthetic */ Object zza(zzxp zzxp) {
        return zzxp.zzc(ObjectWrapper.wrap(this.val$context), this.zzcio, this.zzcil, this.zzcim, 203404000);
    }

    public final /* synthetic */ Object zzpt() {
        zzvx.zza(this.val$context, FirebaseAnalytics.Event.APP_OPEN);
        return new zzzs();
    }

    public final /* synthetic */ Object zzpu() {
        return this.zzcin.zzcic.zza(this.val$context, this.zzcio, this.zzcil, this.zzcim, 4);
    }
}
