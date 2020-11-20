package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
import java.util.HashMap;

public class zzvx {
    /* access modifiers changed from: private */
    public final zzvi zzcic;
    /* access modifiers changed from: private */
    public final zzvf zzcid;
    /* access modifiers changed from: private */
    public final zzzp zzcie;
    /* access modifiers changed from: private */
    public final zzagn zzcif;
    /* access modifiers changed from: private */
    public final zzaut zzcig;
    private final zzavx zzcih;
    /* access modifiers changed from: private */
    public final zzarh zzcii;
    /* access modifiers changed from: private */
    public final zzagm zzcij;

    public zzvx(zzvi zzvi, zzvf zzvf, zzzp zzzp, zzagn zzagn, zzaut zzaut, zzavx zzavx, zzarh zzarh, zzagm zzagm) {
        this.zzcic = zzvi;
        this.zzcid = zzvf;
        this.zzcie = zzzp;
        this.zzcif = zzagn;
        this.zzcig = zzaut;
        this.zzcih = zzavx;
        this.zzcii = zzarh;
        this.zzcij = zzagm;
    }

    /* access modifiers changed from: private */
    public static void zza(Context context, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("action", "no_ads_fallback");
        bundle.putString("flow", str);
        zzwq.zzqa().zza(context, zzwq.zzqg().zzbrf, "gmob-apps", bundle, true);
    }

    public final zzaen zza(Context context, FrameLayout frameLayout, FrameLayout frameLayout2) {
        return (zzaen) new zzwm(this, frameLayout, frameLayout2, context).zzd(context, false);
    }

    public final zzaeq zza(View view, HashMap<String, View> hashMap, HashMap<String, View> hashMap2) {
        return (zzaeq) new zzwl(this, view, hashMap, hashMap2).zzd(view.getContext(), false);
    }

    public final zzaxq zza(Context context, zzani zzani) {
        return (zzaxq) new zzwb(this, context, zzani).zzd(context, false);
    }

    public final zzxg zza(Context context, zzvn zzvn, String str, zzani zzani) {
        return (zzxg) new zzwf(this, context, zzvn, str, zzani).zzd(context, false);
    }

    public final zzaqw zzb(Context context, zzani zzani) {
        return (zzaqw) new zzwd(this, context, zzani).zzd(context, false);
    }

    public final zzarj zzb(Activity activity) {
        zzwc zzwc = new zzwc(this, activity);
        Intent intent = activity.getIntent();
        boolean z = false;
        if (!intent.hasExtra("com.google.android.gms.ads.internal.overlay.useClientJar")) {
            zzaza.zzey("useClientJar flag not found in activity intent extras.");
        } else {
            z = intent.getBooleanExtra("com.google.android.gms.ads.internal.overlay.useClientJar", false);
        }
        return (zzarj) zzwc.zzd(activity, z);
    }

    public final zzwz zzb(Context context, String str, zzani zzani) {
        return (zzwz) new zzwk(this, context, str, zzani).zzd(context, false);
    }

    public final zzavh zzc(Context context, String str, zzani zzani) {
        return (zzavh) new zzvz(this, context, str, zzani).zzd(context, false);
    }
}
