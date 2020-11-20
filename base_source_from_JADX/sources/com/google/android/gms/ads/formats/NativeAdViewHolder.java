package com.google.android.gms.ads.formats;

import android.os.RemoteException;
import android.view.View;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaeq;
import com.google.android.gms.internal.ads.zzaza;
import com.google.android.gms.internal.ads.zzwq;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

public final class NativeAdViewHolder {
    public static WeakHashMap<View, NativeAdViewHolder> zzbnt = new WeakHashMap<>();
    private zzaeq zzbns;
    private WeakReference<View> zzbnu;

    public NativeAdViewHolder(View view, Map<String, View> map, Map<String, View> map2) {
        Preconditions.checkNotNull(view, "ContainerView must not be null");
        if ((view instanceof NativeAdView) || (view instanceof UnifiedNativeAdView)) {
            zzaza.zzey("The provided containerView is of type of NativeAdView, which cannot be usedwith NativeAdViewHolder.");
        } else if (zzbnt.get(view) != null) {
            zzaza.zzey("The provided containerView is already in use with another NativeAdViewHolder.");
        } else {
            zzbnt.put(view, this);
            this.zzbnu = new WeakReference<>(view);
            this.zzbns = zzwq.zzqb().zza(view, zzb(map), zzb(map2));
        }
    }

    private final void zza(IObjectWrapper iObjectWrapper) {
        WeakReference<View> weakReference = this.zzbnu;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view == null) {
            zzaza.zzfa("NativeAdViewHolder.setNativeAd containerView doesn't exist, returning");
            return;
        }
        if (!zzbnt.containsKey(view)) {
            zzbnt.put(view, this);
        }
        zzaeq zzaeq = this.zzbns;
        if (zzaeq != null) {
            try {
                zzaeq.zza(iObjectWrapper);
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call setNativeAd on delegate", e);
            }
        }
    }

    private static HashMap<String, View> zzb(Map<String, View> map) {
        return map == null ? new HashMap<>() : new HashMap<>(map);
    }

    public final void setClickConfirmingView(View view) {
        try {
            this.zzbns.zze(ObjectWrapper.wrap(view));
        } catch (RemoteException e) {
            zzaza.zzc("Unable to call setClickConfirmingView on delegate", e);
        }
    }

    public final void setNativeAd(NativeAd nativeAd) {
        zza((IObjectWrapper) nativeAd.zzjr());
    }

    public final void setNativeAd(UnifiedNativeAd unifiedNativeAd) {
        zza((IObjectWrapper) unifiedNativeAd.zzjr());
    }

    public final void unregisterNativeAd() {
        zzaeq zzaeq = this.zzbns;
        if (zzaeq != null) {
            try {
                zzaeq.unregisterNativeAd();
            } catch (RemoteException e) {
                zzaza.zzc("Unable to call unregisterNativeAd on delegate", e);
            }
        }
        WeakReference<View> weakReference = this.zzbnu;
        View view = weakReference != null ? (View) weakReference.get() : null;
        if (view != null) {
            zzbnt.remove(view);
        }
    }
}
