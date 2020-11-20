package com.google.android.gms.internal.ads;

import android.content.Context;
import java.io.File;

final class zzbj implements zzaz {
    private final /* synthetic */ Context val$appContext;
    private File zzcw = null;

    zzbj(Context context) {
        this.val$appContext = context;
    }

    public final File zzo() {
        if (this.zzcw == null) {
            this.zzcw = new File(this.val$appContext.getCacheDir(), "volley");
        }
        return this.zzcw;
    }
}
