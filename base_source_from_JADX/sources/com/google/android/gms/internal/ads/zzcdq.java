package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zza;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzcdq {
    private final zzcgh zzgep;
    private final zzchp zzgey;
    private ViewTreeObserver.OnScrollChangedListener zzgfd = null;

    public zzcdq(zzchp zzchp, zzcgh zzcgh) {
        this.zzgey = zzchp;
        this.zzgep = zzcgh;
    }

    private static int zza(Context context, String str, int i) {
        try {
            i = Integer.parseInt(str);
        } catch (NumberFormatException unused) {
        }
        zzwq.zzqa();
        return zzayr.zzc(context, i);
    }

    public final View zza(View view, WindowManager windowManager) {
        zzbdv zzd = this.zzgey.zzd(zzvn.zzpo());
        zzd.getView().setVisibility(4);
        zzd.getView().setContentDescription("policy_validator");
        zzd.zza("/sendMessageToSdk", (zzahv<? super zzbdv>) new zzcdp(this));
        zzd.zza("/hideValidatorOverlay", (zzahv<? super zzbdv>) new zzcds(this, windowManager, view));
        zzd.zza("/open", (zzahv<? super zzbdv>) new zzahz((zza) null, (zzaqk) null, (zzcqo) null, (zzckq) null));
        this.zzgep.zza(new WeakReference(zzd), "/loadNativeAdPolicyViolations", new zzcdr(this, view, windowManager));
        this.zzgep.zza(new WeakReference(zzd), "/showValidatorOverlay", zzcdu.zzdgn);
        return zzd.getView();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(View view, WindowManager windowManager, zzbdv zzbdv, Map map) {
        zzbdv.zzacs().zza((zzbfj) new zzcdw(this, map));
        if (map != null) {
            Context context = view.getContext();
            int zza = zza(context, (String) map.get("validator_width"), ((Integer) zzwq.zzqe().zzd(zzabf.zzcyl)).intValue());
            int zza2 = zza(context, (String) map.get("validator_height"), ((Integer) zzwq.zzqe().zzd(zzabf.zzcym)).intValue());
            int zza3 = zza(context, (String) map.get("validator_x"), 0);
            int zza4 = zza(context, (String) map.get("validator_y"), 0);
            zzbdv.zza(zzbfn.zzq(zza, zza2));
            try {
                zzbdv.getWebView().getSettings().setUseWideViewPort(((Boolean) zzwq.zzqe().zzd(zzabf.zzcyn)).booleanValue());
                zzbdv.getWebView().getSettings().setLoadWithOverviewMode(((Boolean) zzwq.zzqe().zzd(zzabf.zzcyo)).booleanValue());
            } catch (NullPointerException unused) {
            }
            WindowManager.LayoutParams zzyx = zzbq.zzyx();
            zzyx.x = zza3;
            zzyx.y = zza4;
            windowManager.updateViewLayout(zzbdv.getView(), zzyx);
            String str = (String) map.get("orientation");
            Rect rect = new Rect();
            if (view.getGlobalVisibleRect(rect)) {
                this.zzgfd = new zzcdt(view, zzbdv, str, zzyx, (("1".equals(str) || "2".equals(str)) ? rect.bottom : rect.top) - zza4, windowManager);
                ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.addOnScrollChangedListener(this.zzgfd);
                }
            }
            String str2 = (String) map.get("overlay_url");
            if (!TextUtils.isEmpty(str2)) {
                zzbdv.loadUrl(str2);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(WindowManager windowManager, View view, zzbdv zzbdv, Map map) {
        zzd.zzeb("Hide native ad policy validator overlay.");
        zzbdv.getView().setVisibility(8);
        if (zzbdv.getView().getWindowToken() != null) {
            windowManager.removeView(zzbdv.getView());
        }
        zzbdv.destroy();
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (this.zzgfd != null && viewTreeObserver != null && viewTreeObserver.isAlive()) {
            viewTreeObserver.removeOnScrollChangedListener(this.zzgfd);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "validatorHtmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzgep.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zze(zzbdv zzbdv, Map map) {
        this.zzgep.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }
}
