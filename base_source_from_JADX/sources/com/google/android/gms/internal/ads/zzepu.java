package com.google.android.gms.internal.ads;

import android.content.ComponentName;
import androidx.browser.p017a.C0388b;
import androidx.browser.p017a.C0397d;
import java.lang.ref.WeakReference;

public final class zzepu extends C0397d {
    private WeakReference<zzept> zzizf;

    public zzepu(zzept zzept) {
        this.zzizf = new WeakReference<>(zzept);
    }

    public final void onCustomTabsServiceConnected(ComponentName componentName, C0388b bVar) {
        zzept zzept = (zzept) this.zzizf.get();
        if (zzept != null) {
            zzept.zza(bVar);
        }
    }

    public final void onServiceDisconnected(ComponentName componentName) {
        zzept zzept = (zzept) this.zzizf.get();
        if (zzept != null) {
            zzept.zzsf();
        }
    }
}
