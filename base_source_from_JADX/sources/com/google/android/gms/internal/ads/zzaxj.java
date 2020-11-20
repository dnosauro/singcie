package com.google.android.gms.internal.ads;

import android.content.Context;
import java.util.concurrent.Callable;

final /* synthetic */ class zzaxj implements Callable {
    private final Context zzckm;
    private final zzawx zzeab;

    zzaxj(zzawx zzawx, Context context) {
        this.zzeab = zzawx;
        this.zzckm = context;
    }

    public final Object call() {
        return this.zzeab.zzah(this.zzckm);
    }
}
