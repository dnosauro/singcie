package com.google.android.gms.ads.formats;

import android.annotation.TargetApi;
import android.content.Context;
import android.os.RemoteException;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzaen;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzwq;

@Deprecated
public class NativeAdView extends FrameLayout {
    private final FrameLayout zzbnv;
    private final zzaen zzbnw = zzjt();

    public NativeAdView(Context context) {
        super(context);
        this.zzbnv = zzd(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.zzbnv = zzd(context);
    }

    public NativeAdView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.zzbnv = zzd(context);
    }

    @TargetApi(21)
    public NativeAdView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        this.zzbnv = zzd(context);
    }

    private final FrameLayout zzd(Context context) {
        FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        addView(frameLayout);
        return frameLayout;
    }

    private final zzaen zzjt() {
        Preconditions.checkNotNull(this.zzbnv, "createDelegate must be called after mOverlayFrame has been created");
        if (isInEditMode()) {
            return null;
        }
        return zzwq.zzqb().zza(this.zzbnv.getContext(), (FrameLayout) this, this.zzbnv);
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        super.addView(view, i, layoutParams);
        super.bringChildToFront(this.zzbnv);
    }

    public void bringChildToFront(View view) {
        super.bringChildToFront(view);
        FrameLayout frameLayout = this.zzbnv;
        if (frameLayout != view) {
            super.bringChildToFront(frameLayout);
        }
    }

    public void destroy() {
        try {
            this.zzbnw.destroy();
        } catch (RemoteException e) {
            zzaza.zzc("Unable to destroy native ad view", e);
        }
    }

    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        zzaen zzaen;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcrn)).booleanValue() && (zzaen = this.zzbnw) != null) {
            try {
                zzaen.zzf(ObjectWrapper.wrap(motionEvent));
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call handleTouchEvent on delegate", e);
            }
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public AdChoicesView getAdChoicesView() {
        View zzbj = zzbj(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW);
        if (zzbj instanceof AdChoicesView) {
            return (AdChoicesView) zzbj;
        }
        return null;
    }

    public void onVisibilityChanged(View view, int i) {
        super.onVisibilityChanged(view, i);
        zzaen zzaen = this.zzbnw;
        if (zzaen != null) {
            try {
                zzaen.zzc(ObjectWrapper.wrap(view), i);
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call onVisibilityChanged on delegate", e);
            }
        }
    }

    public void removeAllViews() {
        super.removeAllViews();
        super.addView(this.zzbnv);
    }

    public void removeView(View view) {
        if (this.zzbnv != view) {
            super.removeView(view);
        }
    }

    public void setAdChoicesView(AdChoicesView adChoicesView) {
        zza(NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW, adChoicesView);
    }

    public void setNativeAd(NativeAd nativeAd) {
        try {
            this.zzbnw.zza((IObjectWrapper) nativeAd.zzjr());
        } catch (RemoteException e) {
            zzaza.zzc("Unable to call setNativeAd on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public final void zza(String str, View view) {
        try {
            this.zzbnw.zzb(str, ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzaza.zzc("Unable to call setAssetView on delegate", e);
        }
    }

    /* access modifiers changed from: protected */
    public final View zzbj(String str) {
        try {
            IObjectWrapper zzco = this.zzbnw.zzco(str);
            if (zzco != null) {
                return (View) ObjectWrapper.unwrap(zzco);
            }
            return null;
        } catch (RemoteException e) {
            zzaza.zzc("Unable to call getAssetView on delegate", e);
            return null;
        }
    }
}
