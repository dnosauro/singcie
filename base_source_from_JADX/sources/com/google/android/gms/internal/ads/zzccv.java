package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzccv extends zzaet implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcdy {
    private final WeakReference<View> zzgdt;
    private final Map<String, WeakReference<View>> zzgdu = new HashMap();
    private final Map<String, WeakReference<View>> zzgdv = new HashMap();
    private final Map<String, WeakReference<View>> zzgdw = new HashMap();
    @GuardedBy("this")
    private zzcbt zzgdx;
    private zzqq zzgdy;

    public zzccv(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        view.setOnTouchListener(this);
        view.setOnClickListener(this);
        zzp.zzln();
        zzazy.zza(view, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzp.zzln();
        zzazy.zza(view, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzgdt = new WeakReference<>(view);
        for (Map.Entry next : hashMap.entrySet()) {
            String str = (String) next.getKey();
            View view2 = (View) next.getValue();
            if (view2 != null) {
                this.zzgdu.put(str, new WeakReference(view2));
                if (!NativeAd.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str) && !UnifiedNativeAdAssetNames.ASSET_ADCHOICES_CONTAINER_VIEW.equals(str)) {
                    view2.setOnTouchListener(this);
                    view2.setClickable(true);
                    view2.setOnClickListener(this);
                }
            }
        }
        this.zzgdw.putAll(this.zzgdu);
        for (Map.Entry next2 : hashMap2.entrySet()) {
            View view3 = (View) next2.getValue();
            if (view3 != null) {
                this.zzgdv.put((String) next2.getKey(), new WeakReference(view3));
                view3.setOnTouchListener(this);
                view3.setClickable(false);
            }
        }
        this.zzgdw.putAll(this.zzgdv);
        this.zzgdy = new zzqq(view.getContext(), view);
    }

    public final synchronized void onClick(View view) {
        if (this.zzgdx != null) {
            this.zzgdx.zza(view, zzaiz(), zzaoe(), zzaof(), true);
        }
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzgdx != null) {
            this.zzgdx.zzb(zzaiz(), zzaoe(), zzaof(), zzcbt.zzz(zzaiz()));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzgdx != null) {
            this.zzgdx.zzb(zzaiz(), zzaoe(), zzaof(), zzcbt.zzz(zzaiz()));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzgdx != null) {
            this.zzgdx.zza(view, motionEvent, zzaiz());
        }
        return false;
    }

    public final synchronized void unregisterNativeAd() {
        if (this.zzgdx != null) {
            this.zzgdx.zzb(this);
            this.zzgdx = null;
        }
    }

    public final synchronized void zza(IObjectWrapper iObjectWrapper) {
        Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
        if (!(unwrap instanceof zzcbt)) {
            zzd.zzfa("Not an instance of InternalNativeAd. This is most likely a transient error");
            return;
        }
        if (this.zzgdx != null) {
            this.zzgdx.zzb(this);
        }
        if (((zzcbt) unwrap).zzamx()) {
            this.zzgdx = (zzcbt) unwrap;
            this.zzgdx.zza((zzcdy) this);
            this.zzgdx.zzaa(zzaiz());
            return;
        }
        zzd.zzey("Your account must be enabled to use this feature. Talk to your account manager to request this feature for your account.");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0046, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r3 != 0) goto L_0x0014
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzgdw     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzgdu     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzgdv     // Catch:{ all -> 0x0047 }
            r3.remove(r2)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0014:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzgdw     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 != 0) goto L_0x0045
            java.lang.String r4 = "3011"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0047 }
            if (r4 == 0) goto L_0x002f
            goto L_0x0045
        L_0x002f:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzgdu     // Catch:{ all -> 0x0047 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0047 }
            r0.<init>(r3)     // Catch:{ all -> 0x0047 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0047 }
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0047 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0047 }
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0047 }
            monitor-exit(r1)
            return
        L_0x0045:
            monitor-exit(r1)
            return
        L_0x0047:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccv.zza(java.lang.String, android.view.View, boolean):void");
    }

    public final View zzaiz() {
        return (View) this.zzgdt.get();
    }

    public final FrameLayout zzaoc() {
        return null;
    }

    public final zzqq zzaod() {
        return this.zzgdy;
    }

    public final synchronized Map<String, WeakReference<View>> zzaoe() {
        return this.zzgdw;
    }

    public final synchronized Map<String, WeakReference<View>> zzaof() {
        return this.zzgdu;
    }

    public final synchronized Map<String, WeakReference<View>> zzaog() {
        return this.zzgdv;
    }

    public final synchronized String zzaoh() {
        return NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
    }

    public final synchronized IObjectWrapper zzaoi() {
        return null;
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        if (this.zzgdx != null) {
            Object unwrap = ObjectWrapper.unwrap(iObjectWrapper);
            if (!(unwrap instanceof View)) {
                zzd.zzfa("Calling NativeAdViewHolderNonagonDelegate.setClickConfirmingView with wrong wrapped object");
            }
            this.zzgdx.setClickConfirmingView((View) unwrap);
        }
    }

    public final synchronized View zzgc(String str) {
        WeakReference weakReference = this.zzgdw.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final synchronized JSONObject zzst() {
        return null;
    }
}
