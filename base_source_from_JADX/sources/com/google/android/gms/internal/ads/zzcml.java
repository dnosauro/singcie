package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcml implements Callable {
    private final Context zzckm;
    private final zzef zzgmj;

    zzcml(zzef zzef, Context context) {
        this.zzgmj = zzef;
        this.zzckm = context;
    }

    public final Object call() {
        zzef zzef = this.zzgmj;
        return zzef.zzca().zzb(this.zzckm);
    }
}
