package com.google.android.gms.internal.ads;

import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;
import java.util.concurrent.Callable;

final /* synthetic */ class zzcza implements Callable {
    private final zzcyx zzgxl;
    private final List zzgxm;
    private final IObjectWrapper zzgxn;

    zzcza(zzcyx zzcyx, List list, IObjectWrapper iObjectWrapper) {
        this.zzgxl = zzcyx;
        this.zzgxm = list;
        this.zzgxn = iObjectWrapper;
    }

    public final Object call() {
        return this.zzgxl.zza(this.zzgxm, this.zzgxn);
    }
}
