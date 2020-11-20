package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzcbb implements zzccm {
    private final Context context;
    private final zzazh zzbpd;
    private final Clock zzbpw;
    private final zzef zzerb;
    private final zzdmu zzeri;
    private final zzdrz zzfqa;
    private final zzccl zzftd;
    private final zzdnn zzfvl;
    private final JSONObject zzgao;
    private final zzcgh zzgap;
    private final zzcce zzgaq;
    /* access modifiers changed from: private */
    public final zzbsl zzgar;
    /* access modifiers changed from: private */
    public final zzbrt zzgas;
    private final zzbki zzgat;
    private final zzcdd zzgau;
    private final zzbxx zzgav;
    private boolean zzgaw = false;
    private boolean zzgax;
    private boolean zzgay = false;
    private boolean zzgaz = false;
    private Point zzgba = new Point();
    private Point zzgbb = new Point();
    private long zzgbc = 0;
    private long zzgbd = 0;
    private zzxz zzgbe;

    public zzcbb(Context context2, zzccl zzccl, JSONObject jSONObject, zzcgh zzcgh, zzcce zzcce, zzef zzef, zzbsl zzbsl, zzbrt zzbrt, zzdmu zzdmu, zzazh zzazh, zzdnn zzdnn, zzbki zzbki, zzcdd zzcdd, Clock clock, zzbxx zzbxx, zzdrz zzdrz) {
        this.context = context2;
        this.zzftd = zzccl;
        this.zzgao = jSONObject;
        this.zzgap = zzcgh;
        this.zzgaq = zzcce;
        this.zzerb = zzef;
        this.zzgar = zzbsl;
        this.zzgas = zzbrt;
        this.zzeri = zzdmu;
        this.zzbpd = zzazh;
        this.zzfvl = zzdnn;
        this.zzgat = zzbki;
        this.zzgau = zzcdd;
        this.zzbpw = clock;
        this.zzgav = zzbxx;
        this.zzfqa = zzdrz;
    }

    @VisibleForTesting
    private final void zza(View view, JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, JSONObject jSONObject6, boolean z, boolean z2) {
        Preconditions.checkMainThread("performClick must be called on the main UI thread.");
        try {
            JSONObject jSONObject7 = new JSONObject();
            jSONObject7.put("ad", this.zzgao);
            jSONObject7.put("asset_view_signal", jSONObject2);
            jSONObject7.put("ad_view_signal", jSONObject);
            jSONObject7.put("click_signal", jSONObject5);
            jSONObject7.put("scroll_view_signal", jSONObject3);
            jSONObject7.put("lock_screen_signal", jSONObject4);
            boolean z3 = false;
            jSONObject7.put("has_custom_click_handler", this.zzftd.zzgb(this.zzgaq.getCustomTemplateId()) != null);
            jSONObject7.put("provided_signals", jSONObject6);
            JSONObject jSONObject8 = new JSONObject();
            jSONObject8.put("asset_id", str);
            jSONObject8.put("template", this.zzgaq.zzanc());
            jSONObject8.put("view_aware_api_used", z);
            jSONObject8.put("custom_mute_requested", this.zzfvl.zzdnh != null && this.zzfvl.zzdnh.zzbnr);
            jSONObject8.put("custom_mute_enabled", !this.zzgaq.getMuteThisAdReasons().isEmpty() && this.zzgaq.zzanf() != null);
            if (this.zzgau.zzaol() != null && this.zzgao.optBoolean("custom_one_point_five_click_enabled", false)) {
                jSONObject8.put("custom_one_point_five_click_eligible", true);
            }
            jSONObject8.put("timestamp", this.zzbpw.currentTimeMillis());
            if (this.zzgaz && zzamq()) {
                jSONObject8.put("custom_click_gesture_eligible", true);
            }
            if (z2) {
                jSONObject8.put("is_custom_click_gesture", true);
            }
            if (this.zzftd.zzgb(this.zzgaq.getCustomTemplateId()) != null) {
                z3 = true;
            }
            jSONObject8.put("has_custom_click_handler", z3);
            jSONObject8.put("click_signals", zzx(view));
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctq)).booleanValue()) {
                jSONObject8.put("open_chrome_custom_tab", true);
            }
            jSONObject7.put("click", jSONObject8);
            JSONObject jSONObject9 = new JSONObject();
            long currentTimeMillis = this.zzbpw.currentTimeMillis();
            jSONObject9.put("time_from_last_touch_down", currentTimeMillis - this.zzgbc);
            jSONObject9.put("time_from_last_touch", currentTimeMillis - this.zzgbd);
            jSONObject7.put("touch_signal", jSONObject9);
            zzazm.zza(this.zzgap.zzc("google.afma.nativeAds.handleClick", jSONObject7), "Error during performing handleClick");
        } catch (JSONException e) {
            zzd.zzc("Unable to create click JSON.", e);
        }
    }

    private final boolean zza(JSONObject jSONObject, JSONObject jSONObject2, JSONObject jSONObject3, JSONObject jSONObject4, String str, JSONObject jSONObject5, boolean z) {
        zzcgh zzcgh;
        String str2;
        zzahv zzcbd;
        Preconditions.checkMainThread("recordImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject6 = new JSONObject();
            jSONObject6.put("ad", this.zzgao);
            jSONObject6.put("asset_view_signal", jSONObject2);
            jSONObject6.put("ad_view_signal", jSONObject);
            jSONObject6.put("scroll_view_signal", jSONObject3);
            jSONObject6.put("lock_screen_signal", jSONObject4);
            jSONObject6.put("provided_signals", jSONObject5);
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcrp)).booleanValue()) {
                jSONObject6.put("view_signals", str);
            }
            jSONObject6.put("policy_validator_enabled", z);
            jSONObject6.put("screen", zzbq.zzbm(this.context));
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzczf)).booleanValue()) {
                zzcgh = this.zzgap;
                str2 = "/clickRecorded";
                zzcbd = new zzcbg(this);
            } else {
                zzcgh = this.zzgap;
                str2 = "/logScionEvent";
                zzcbd = new zzcbd(this);
            }
            zzcgh.zza(str2, (zzahv<Object>) zzcbd);
            this.zzgap.zza("/nativeImpression", (zzahv<Object>) new zzcbf(this));
            zzazm.zza(this.zzgap.zzc("google.afma.nativeAds.handleImpression", jSONObject6), "Error during performing handleImpression");
            if (this.zzgaw || this.zzeri.zzhhc == null) {
                return true;
            }
            this.zzgaw |= zzp.zzla().zzb(this.context, this.zzbpd.zzbrf, this.zzeri.zzhhc.toString(), this.zzfvl.zzhip);
            return true;
        } catch (JSONException e) {
            zzd.zzc("Unable to create impression JSON.", e);
            return false;
        }
    }

    private final boolean zzamq() {
        return this.zzgao.optBoolean("allow_custom_click_gesture", false);
    }

    private final String zzb(View view, Map<String, WeakReference<View>> map) {
        if (!(map == null || view == null)) {
            for (Map.Entry next : map.entrySet()) {
                if (view.equals((View) ((WeakReference) next.getValue()).get())) {
                    return (String) next.getKey();
                }
            }
        }
        int zzanc = this.zzgaq.zzanc();
        if (zzanc == 6) {
            return "3099";
        }
        switch (zzanc) {
            case 1:
                return "1099";
            case 2:
                return "2099";
            default:
                return null;
        }
    }

    private final boolean zzfv(String str) {
        JSONObject optJSONObject = this.zzgao.optJSONObject("allow_pub_event_reporting");
        return optJSONObject != null && optJSONObject.optBoolean(str, false);
    }

    private final String zzx(View view) {
        try {
            JSONObject optJSONObject = this.zzgao.optJSONObject("tracking_urls_and_actions");
            if (optJSONObject == null) {
                optJSONObject = new JSONObject();
            }
            return this.zzerb.zzca().zza(this.context, optJSONObject.optString("click_string"), view);
        } catch (Exception e) {
            zzd.zzc("Exception obtaining click signals", e);
            return null;
        }
    }

    private final String zzy(View view) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcrp)).booleanValue()) {
            return null;
        }
        try {
            return this.zzerb.zzca().zza(this.context, view, (Activity) null);
        } catch (Exception unused) {
            zzd.zzey("Exception getting data.");
            return null;
        }
    }

    public final void cancelUnconfirmedClick() {
        if (this.zzgao.optBoolean("custom_one_point_five_click_enabled", false)) {
            this.zzgau.cancelUnconfirmedClick();
        }
    }

    public final void destroy() {
        this.zzgap.destroy();
    }

    public final boolean isCustomClickGestureEnabled() {
        return zzamq();
    }

    public final void setClickConfirmingView(View view) {
        if (!this.zzgao.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzd.zzfa("setClickConfirmingView: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
            return;
        }
        zzcdd zzcdd = this.zzgau;
        if (view != null) {
            view.setOnClickListener(zzcdd);
            view.setClickable(true);
            zzcdd.zzgeu = new WeakReference<>(view);
        }
    }

    public final JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        JSONObject zza = zzbq.zza(this.context, map, map2, view);
        JSONObject zza2 = zzbq.zza(this.context, view);
        JSONObject zzt = zzbq.zzt(view);
        JSONObject zzb = zzbq.zzb(this.context, view);
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("asset_view_signal", zza);
            jSONObject.put("ad_view_signal", zza2);
            jSONObject.put("scroll_view_signal", zzt);
            jSONObject.put("lock_screen_signal", zzb);
            return jSONObject;
        } catch (JSONException e) {
            zzd.zzc("Unable to create native ad view signals JSON.", e);
            return null;
        }
    }

    public final void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzgba = zzbq.zza(motionEvent, view2);
        long currentTimeMillis = this.zzbpw.currentTimeMillis();
        this.zzgbd = currentTimeMillis;
        if (motionEvent.getAction() == 0) {
            this.zzgbc = currentTimeMillis;
            this.zzgbb = this.zzgba;
        }
        MotionEvent obtain = MotionEvent.obtain(motionEvent);
        obtain.setLocation((float) this.zzgba.x, (float) this.zzgba.y);
        this.zzerb.zza(obtain);
        obtain.recycle();
    }

    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        View view3 = view2;
        Map<String, WeakReference<View>> map3 = map;
        JSONObject zza = zzbq.zza(this.context, map, map2, view2);
        JSONObject zza2 = zzbq.zza(this.context, view2);
        JSONObject zzt = zzbq.zzt(view2);
        JSONObject zzb = zzbq.zzb(this.context, view2);
        View view4 = view;
        String zzb2 = zzb(view, map);
        zza(((Boolean) zzwq.zzqe().zzd(zzabf.zzcrq)).booleanValue() ? view3 : view4, zza2, zza, zzt, zzb, zzb2, zzbq.zza(zzb2, this.context, this.zzgbb, this.zzgba), (JSONObject) null, z, false);
    }

    public final void zza(View view, Map<String, WeakReference<View>> map) {
        this.zzgba = new Point();
        this.zzgbb = new Point();
        this.zzgav.zzw(view);
        this.zzgax = false;
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        this.zzgba = new Point();
        this.zzgbb = new Point();
        if (!this.zzgax) {
            this.zzgav.zzv(view);
            this.zzgax = true;
        }
        view.setOnTouchListener(onTouchListener);
        view.setClickable(true);
        view.setOnClickListener(onClickListener);
        this.zzgat.zzo(this);
        boolean zzdi = zzbq.zzdi(this.zzbpd.zzegm);
        if (map != null) {
            for (Map.Entry<String, WeakReference<View>> value : map.entrySet()) {
                View view2 = (View) ((WeakReference) value.getValue()).get();
                if (view2 != null) {
                    if (zzdi) {
                        view2.setOnTouchListener(onTouchListener);
                    }
                    view2.setClickable(true);
                    view2.setOnClickListener(onClickListener);
                }
            }
        }
        if (map2 != null) {
            for (Map.Entry<String, WeakReference<View>> value2 : map2.entrySet()) {
                View view3 = (View) ((WeakReference) value2.getValue()).get();
                if (view3 != null) {
                    if (zzdi) {
                        view3.setOnTouchListener(onTouchListener);
                    }
                    view3.setClickable(false);
                }
            }
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        View view2 = view;
        Map<String, WeakReference<View>> map3 = map;
        if (!this.zzgaz) {
            zzd.zzeb("Custom click reporting failed. enableCustomClickGesture is not set.");
        } else if (!zzamq()) {
            zzd.zzeb("Custom click reporting failed. Ad unit id not whitelisted.");
        } else {
            Map<String, WeakReference<View>> map4 = map2;
            JSONObject zza = zzbq.zza(this.context, map, map2, view);
            JSONObject zza2 = zzbq.zza(this.context, view);
            JSONObject zzt = zzbq.zzt(view);
            JSONObject zzb = zzbq.zzb(this.context, view);
            String zzb2 = zzb((View) null, map);
            zza(view, zza2, zza, zzt, zzb, zzb2, zzbq.zza(zzb2, this.context, this.zzgbb, this.zzgba), (JSONObject) null, z, true);
        }
    }

    public final void zza(zzage zzage) {
        if (!this.zzgao.optBoolean("custom_one_point_five_click_enabled", false)) {
            zzd.zzfa("setUnconfirmedClickListener: Your account need to be whitelisted to use this feature.\nContact your account manager for more information.");
        } else {
            this.zzgau.zza(zzage);
        }
    }

    public final void zza(zzxz zzxz) {
        this.zzgbe = zzxz;
    }

    public final void zza(zzyd zzyd) {
        try {
            if (!this.zzgay) {
                if (zzyd != null || this.zzgaq.zzanf() == null) {
                    this.zzgay = true;
                    this.zzfqa.zzeo(zzyd.zzqo());
                    zzams();
                    return;
                }
                this.zzgay = true;
                this.zzfqa.zzeo(this.zzgaq.zzanf().zzqo());
                zzams();
            }
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzamr() {
        zza((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, (JSONObject) null, false);
    }

    public final void zzams() {
        try {
            if (this.zzgbe != null) {
                this.zzgbe.onAdMuted();
            }
        } catch (RemoteException e) {
            zzd.zze("#007 Could not call remote method.", e);
        }
    }

    public final void zzamt() {
        Preconditions.checkMainThread("recordDownloadedImpression must be called on the main UI thread.");
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("ad", this.zzgao);
            zzazm.zza(this.zzgap.zzc("google.afma.nativeAds.handleDownloadedImpression", jSONObject), "Error during performing handleDownloadedImpression");
        } catch (JSONException e) {
            zzaza.zzc("", e);
        }
    }

    public final void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        zza(zzbq.zza(this.context, view), zzbq.zza(this.context, map, map2, view), zzbq.zzt(view), zzbq.zzb(this.context, view), zzy(view), (JSONObject) null, zzbq.zza(this.context, this.zzeri));
    }

    public final void zzf(Bundle bundle) {
        if (bundle == null) {
            zzd.zzeb("Click data is null. No click is reported.");
        } else if (!zzfv("click_reporting")) {
            zzd.zzey("The ad slot cannot handle external click events. You must be whitelisted to be able to report your click events.");
        } else {
            Bundle bundle2 = bundle.getBundle("click_signal");
            zza((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, bundle2 != null ? bundle2.getString("asset_id") : null, (JSONObject) null, zzp.zzkq().zza(bundle, (JSONObject) null), false, false);
        }
    }

    public final void zzfw(String str) {
        zza((View) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, str, (JSONObject) null, (JSONObject) null, false, false);
    }

    public final void zzg(Bundle bundle) {
        if (bundle == null) {
            zzd.zzeb("Touch event data is null. No touch event is reported.");
        } else if (!zzfv("touch_reporting")) {
            zzd.zzey("The ad slot cannot handle external touch events. You must be whitelisted to be able to report your touch events.");
        } else {
            int i = bundle.getInt("duration_ms");
            this.zzerb.zzca().zza((int) bundle.getFloat("x"), (int) bundle.getFloat("y"), i);
        }
    }

    public final boolean zzh(Bundle bundle) {
        if (!zzfv("impression_reporting")) {
            zzd.zzey("The ad slot cannot handle external impression events. You must be whitelisted to whitelisted to be able to report your impression events.");
            return false;
        }
        return zza((JSONObject) null, (JSONObject) null, (JSONObject) null, (JSONObject) null, (String) null, zzp.zzkq().zza(bundle, (JSONObject) null), false);
    }

    public final void zztg() {
        this.zzgaz = true;
    }
}
