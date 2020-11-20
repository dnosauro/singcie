package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.WindowManager;
import java.util.Map;

final /* synthetic */ class zzcdr implements zzahv {
    private final zzcdq zzgfc;
    private final View zzgfe;
    private final WindowManager zzgff;

    zzcdr(zzcdq zzcdq, View view, WindowManager windowManager) {
        this.zzgfc = zzcdq;
        this.zzgfe = view;
        this.zzgff = windowManager;
    }

    public final void zza(Object obj, Map map) {
        this.zzgfc.zza(this.zzgfe, this.zzgff, (zzbdv) obj, map);
    }
}
