package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

final /* synthetic */ class zzcds implements zzahv {
    private final zzcdq zzgfc;
    private final WindowManager zzgfg;
    private final View zzgfh;

    zzcds(zzcdq zzcdq, WindowManager windowManager, View view) {
        this.zzgfc = zzcdq;
        this.zzgfg = windowManager;
        this.zzgfh = view;
    }

    public final void zza(Object obj, Map map) {
        this.zzgfc.zza(this.zzgfg, this.zzgfh, (zzbdv) obj, map);
    }
}
