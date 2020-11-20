package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.FrameLayout;
import com.google.android.gms.ads.formats.NativeAppInstallAd;
import com.google.android.gms.ads.formats.NativeContentAd;
import com.google.android.gms.ads.formats.UnifiedNativeAdAssetNames;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzccy extends zzaem implements ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener, zzcdy {
    public static final String[] zzgeb = {NativeAppInstallAd.ASSET_MEDIA_VIDEO, NativeContentAd.ASSET_MEDIA_VIDEO, UnifiedNativeAdAssetNames.ASSET_MEDIA_VIDEO};
    private FrameLayout zzbnv;
    private zzaee zzckp;
    @GuardedBy("this")
    private Map<String, WeakReference<View>> zzdse = new HashMap();
    private final int zzegm;
    private boolean zzerq = false;
    @GuardedBy("this")
    private zzcbt zzgdx;
    private zzqq zzgdy;
    private final String zzgea;
    private FrameLayout zzgec;
    private zzdzc zzged;
    private View zzgee;
    private IObjectWrapper zzgef = null;
    private boolean zzgeg;

    public zzccy(FrameLayout frameLayout, FrameLayout frameLayout2, int i) {
        String str;
        this.zzgec = frameLayout;
        this.zzbnv = frameLayout2;
        this.zzegm = 203404000;
        String canonicalName = frameLayout.getClass().getCanonicalName();
        if ("com.google.android.gms.ads.formats.NativeContentAdView".equals(canonicalName)) {
            str = NativeContentAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else if ("com.google.android.gms.ads.formats.NativeAppInstallAdView".equals(canonicalName)) {
            str = NativeAppInstallAd.ASSET_ATTRIBUTION_ICON_IMAGE;
        } else {
            "com.google.android.gms.ads.formats.UnifiedNativeAdView".equals(canonicalName);
            str = "3012";
        }
        this.zzgea = str;
        zzp.zzln();
        zzazy.zza((View) frameLayout, (ViewTreeObserver.OnGlobalLayoutListener) this);
        zzp.zzln();
        zzazy.zza((View) frameLayout, (ViewTreeObserver.OnScrollChangedListener) this);
        this.zzged = zzazj.zzegt;
        this.zzgdy = new zzqq(this.zzgec.getContext(), this.zzgec);
        frameLayout.setOnTouchListener(this);
        frameLayout.setOnClickListener(this);
    }

    private final synchronized void zzaoj() {
        this.zzged.execute(new zzccx(this));
    }

    public final synchronized void destroy() {
        if (!this.zzerq) {
            if (this.zzgdx != null) {
                this.zzgdx.zzb(this);
                this.zzgdx = null;
            }
            this.zzdse.clear();
            this.zzgec.removeAllViews();
            this.zzbnv.removeAllViews();
            this.zzdse = null;
            this.zzgec = null;
            this.zzbnv = null;
            this.zzgee = null;
            this.zzgdy = null;
            this.zzerq = true;
        }
    }

    public final synchronized void onClick(View view) {
        if (this.zzgdx != null) {
            this.zzgdx.cancelUnconfirmedClick();
            this.zzgdx.zza(view, this.zzgec, zzaoe(), zzaof(), false);
        }
    }

    public final synchronized void onGlobalLayout() {
        if (this.zzgdx != null) {
            this.zzgdx.zzb(this.zzgec, zzaoe(), zzaof(), zzcbt.zzz(this.zzgec));
        }
    }

    public final synchronized void onScrollChanged() {
        if (this.zzgdx != null) {
            this.zzgdx.zzb(this.zzgec, zzaoe(), zzaof(), zzcbt.zzz(this.zzgec));
        }
    }

    public final synchronized boolean onTouch(View view, MotionEvent motionEvent) {
        if (this.zzgdx != null) {
            this.zzgdx.zza(view, motionEvent, (View) this.zzgec);
        }
        return false;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0049, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.dynamic.IObjectWrapper r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzerq     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)     // Catch:{ all -> 0x004a }
            boolean r0 = r2 instanceof com.google.android.gms.internal.ads.zzcbt     // Catch:{ all -> 0x004a }
            if (r0 != 0) goto L_0x0016
            java.lang.String r2 = "Not an instance of native engine. This is most likely a transient error"
            com.google.android.gms.ads.internal.util.zzd.zzfa(r2)     // Catch:{ all -> 0x004a }
            monitor-exit(r1)
            return
        L_0x0016:
            com.google.android.gms.internal.ads.zzcbt r0 = r1.zzgdx     // Catch:{ all -> 0x004a }
            if (r0 == 0) goto L_0x001f
            com.google.android.gms.internal.ads.zzcbt r0 = r1.zzgdx     // Catch:{ all -> 0x004a }
            r0.zzb(r1)     // Catch:{ all -> 0x004a }
        L_0x001f:
            r1.zzaoj()     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzcbt r2 = (com.google.android.gms.internal.ads.zzcbt) r2     // Catch:{ all -> 0x004a }
            r1.zzgdx = r2     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzcbt r2 = r1.zzgdx     // Catch:{ all -> 0x004a }
            r2.zza((com.google.android.gms.internal.ads.zzcdy) r1)     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzcbt r2 = r1.zzgdx     // Catch:{ all -> 0x004a }
            android.widget.FrameLayout r0 = r1.zzgec     // Catch:{ all -> 0x004a }
            r2.zzaa(r0)     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzcbt r2 = r1.zzgdx     // Catch:{ all -> 0x004a }
            android.widget.FrameLayout r0 = r1.zzbnv     // Catch:{ all -> 0x004a }
            r2.zzab(r0)     // Catch:{ all -> 0x004a }
            boolean r2 = r1.zzgeg     // Catch:{ all -> 0x004a }
            if (r2 == 0) goto L_0x0048
            com.google.android.gms.internal.ads.zzcbt r2 = r1.zzgdx     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzcbz r2 = r2.zzamz()     // Catch:{ all -> 0x004a }
            com.google.android.gms.internal.ads.zzaee r0 = r1.zzckp     // Catch:{ all -> 0x004a }
            r2.zza(r0)     // Catch:{ all -> 0x004a }
        L_0x0048:
            monitor-exit(r1)
            return
        L_0x004a:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccy.zza(com.google.android.gms.dynamic.IObjectWrapper):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001a, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(com.google.android.gms.internal.ads.zzaee r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.zzerq     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            r0 = 1
            r1.zzgeg = r0     // Catch:{ all -> 0x001b }
            r1.zzckp = r2     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzcbt r0 = r1.zzgdx     // Catch:{ all -> 0x001b }
            if (r0 == 0) goto L_0x0019
            com.google.android.gms.internal.ads.zzcbt r0 = r1.zzgdx     // Catch:{ all -> 0x001b }
            com.google.android.gms.internal.ads.zzcbz r0 = r0.zzamz()     // Catch:{ all -> 0x001b }
            r0.zza(r2)     // Catch:{ all -> 0x001b }
        L_0x0019:
            monitor-exit(r1)
            return
        L_0x001b:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccy.zza(com.google.android.gms.internal.ads.zzaee):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:24:0x0040, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(java.lang.String r2, android.view.View r3, boolean r4) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r4 = r1.zzerq     // Catch:{ all -> 0x0041 }
            if (r4 == 0) goto L_0x0007
            monitor-exit(r1)
            return
        L_0x0007:
            if (r3 != 0) goto L_0x0010
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r3 = r1.zzdse     // Catch:{ all -> 0x0041 }
            r3.remove(r2)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x0010:
            java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4 = r1.zzdse     // Catch:{ all -> 0x0041 }
            java.lang.ref.WeakReference r0 = new java.lang.ref.WeakReference     // Catch:{ all -> 0x0041 }
            r0.<init>(r3)     // Catch:{ all -> 0x0041 }
            r4.put(r2, r0)     // Catch:{ all -> 0x0041 }
            java.lang.String r4 = "1098"
            boolean r4 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r4 != 0) goto L_0x003f
            java.lang.String r4 = "3011"
            boolean r2 = r4.equals(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x002b
            goto L_0x003f
        L_0x002b:
            int r2 = r1.zzegm     // Catch:{ all -> 0x0041 }
            boolean r2 = com.google.android.gms.ads.internal.util.zzbq.zzdi(r2)     // Catch:{ all -> 0x0041 }
            if (r2 == 0) goto L_0x0036
            r3.setOnTouchListener(r1)     // Catch:{ all -> 0x0041 }
        L_0x0036:
            r2 = 1
            r3.setClickable(r2)     // Catch:{ all -> 0x0041 }
            r3.setOnClickListener(r1)     // Catch:{ all -> 0x0041 }
            monitor-exit(r1)
            return
        L_0x003f:
            monitor-exit(r1)
            return
        L_0x0041:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzccy.zza(java.lang.String, android.view.View, boolean):void");
    }

    public final /* synthetic */ View zzaiz() {
        return this.zzgec;
    }

    public final FrameLayout zzaoc() {
        return this.zzbnv;
    }

    public final zzqq zzaod() {
        return this.zzgdy;
    }

    public final synchronized Map<String, WeakReference<View>> zzaoe() {
        return this.zzdse;
    }

    public final synchronized Map<String, WeakReference<View>> zzaof() {
        return this.zzdse;
    }

    public final synchronized Map<String, WeakReference<View>> zzaog() {
        return null;
    }

    public final synchronized String zzaoh() {
        return this.zzgea;
    }

    public final IObjectWrapper zzaoi() {
        return this.zzgef;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaok() {
        if (this.zzgee == null) {
            this.zzgee = new View(this.zzgec.getContext());
            this.zzgee.setLayoutParams(new FrameLayout.LayoutParams(-1, 0));
        }
        if (this.zzgec != this.zzgee.getParent()) {
            this.zzgec.addView(this.zzgee);
        }
    }

    public final synchronized void zzb(String str, IObjectWrapper iObjectWrapper) {
        zza(str, (View) ObjectWrapper.unwrap(iObjectWrapper), true);
    }

    public final synchronized void zzc(IObjectWrapper iObjectWrapper, int i) {
    }

    public final synchronized IObjectWrapper zzco(String str) {
        return ObjectWrapper.wrap(zzgc(str));
    }

    public final synchronized void zze(IObjectWrapper iObjectWrapper) {
        this.zzgdx.setClickConfirmingView((View) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzf(IObjectWrapper iObjectWrapper) {
        onTouch(this.zzgec, (MotionEvent) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final synchronized void zzg(IObjectWrapper iObjectWrapper) {
        if (!this.zzerq) {
            this.zzgef = iObjectWrapper;
        }
    }

    public final synchronized View zzgc(String str) {
        if (this.zzerq) {
            return null;
        }
        WeakReference weakReference = this.zzdse.get(str);
        if (weakReference == null) {
            return null;
        }
        return (View) weakReference.get();
    }

    public final synchronized JSONObject zzst() {
        if (this.zzgdx == null) {
            return null;
        }
        return this.zzgdx.zza((View) this.zzgec, zzaoe(), zzaof());
    }
}
