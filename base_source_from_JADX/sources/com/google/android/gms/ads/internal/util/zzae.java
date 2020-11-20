package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.WindowInsets;

final /* synthetic */ class zzae implements View.OnApplyWindowInsetsListener {
    private final zzab zzedl;
    private final Activity zzedm;

    zzae(zzab zzab, Activity activity) {
        this.zzedl = zzab;
        this.zzedm = activity;
    }

    public final WindowInsets onApplyWindowInsets(View view, WindowInsets windowInsets) {
        return zzab.zza(this.zzedm, view, windowInsets);
    }
}
