package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.concurrent.Callable;

final /* synthetic */ class zzczc implements Callable {
    private final Uri zzeda;
    private final zzcyx zzgxl;
    private final IObjectWrapper zzgxn;

    zzczc(zzcyx zzcyx, Uri uri, IObjectWrapper iObjectWrapper) {
        this.zzgxl = zzcyx;
        this.zzeda = uri;
        this.zzgxn = iObjectWrapper;
    }

    public final Object call() {
        return this.zzgxl.zzb(this.zzeda, this.zzgxn);
    }
}
