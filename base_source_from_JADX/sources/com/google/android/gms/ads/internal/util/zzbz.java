package com.google.android.gms.ads.internal.util;

import android.app.Activity;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.Window;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzazy;

public final class zzbz {
    private final View view;
    private boolean zzbrl;
    private boolean zzbvu;
    private Activity zzefq;
    private boolean zzefr;
    private ViewTreeObserver.OnGlobalLayoutListener zzefs;
    private ViewTreeObserver.OnScrollChangedListener zzeft = null;

    public zzbz(Activity activity, View view2, ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener onScrollChangedListener) {
        this.zzefq = activity;
        this.view = view2;
        this.zzefs = onGlobalLayoutListener;
    }

    private static ViewTreeObserver zzk(Activity activity) {
        Window window;
        View decorView;
        if (activity == null || (window = activity.getWindow()) == null || (decorView = window.getDecorView()) == null) {
            return null;
        }
        return decorView.getViewTreeObserver();
    }

    private final void zzzb() {
        ViewTreeObserver zzk;
        if (!this.zzefr) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzefs;
            if (onGlobalLayoutListener != null) {
                Activity activity = this.zzefq;
                if (!(activity == null || (zzk = zzk(activity)) == null)) {
                    zzk.addOnGlobalLayoutListener(onGlobalLayoutListener);
                }
                zzp.zzln();
                zzazy.zza(this.view, this.zzefs);
            }
            this.zzefr = true;
        }
    }

    private final void zzzc() {
        ViewTreeObserver zzk;
        Activity activity = this.zzefq;
        if (activity != null && this.zzefr) {
            ViewTreeObserver.OnGlobalLayoutListener onGlobalLayoutListener = this.zzefs;
            if (!(onGlobalLayoutListener == null || (zzk = zzk(activity)) == null)) {
                zzp.zzks();
                zzk.removeOnGlobalLayoutListener(onGlobalLayoutListener);
            }
            this.zzefr = false;
        }
    }

    public final void onAttachedToWindow() {
        this.zzbrl = true;
        if (this.zzbvu) {
            zzzb();
        }
    }

    public final void onDetachedFromWindow() {
        this.zzbrl = false;
        zzzc();
    }

    public final void zzj(Activity activity) {
        this.zzefq = activity;
    }

    public final void zzyz() {
        this.zzbvu = true;
        if (this.zzbrl) {
            zzzb();
        }
    }

    public final void zzza() {
        this.zzbvu = false;
        zzzc();
    }
}
