package com.google.android.gms.internal.ads;

import android.view.View;
import android.view.ViewTreeObserver;
import java.lang.ref.WeakReference;

abstract class zzbad {
    private final WeakReference<View> zzehz;

    public zzbad(View view) {
        this.zzehz = new WeakReference<>(view);
    }

    private final ViewTreeObserver getViewTreeObserver() {
        ViewTreeObserver viewTreeObserver;
        View view = (View) this.zzehz.get();
        if (view == null || (viewTreeObserver = view.getViewTreeObserver()) == null || !viewTreeObserver.isAlive()) {
            return null;
        }
        return viewTreeObserver;
    }

    public final void attach() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            zza(viewTreeObserver);
        }
    }

    public final void detach() {
        ViewTreeObserver viewTreeObserver = getViewTreeObserver();
        if (viewTreeObserver != null) {
            zzb(viewTreeObserver);
        }
    }

    /* access modifiers changed from: protected */
    public abstract void zza(ViewTreeObserver viewTreeObserver);

    /* access modifiers changed from: protected */
    public abstract void zzb(ViewTreeObserver viewTreeObserver);
}
