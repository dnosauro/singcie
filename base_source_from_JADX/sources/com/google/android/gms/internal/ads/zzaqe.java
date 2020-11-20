package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.browser.p017a.C0395c;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationInterstitialListener;
import com.google.android.gms.common.util.PlatformVersion;

public final class zzaqe implements MediationInterstitialAdapter {
    private Uri uri;
    /* access modifiers changed from: private */
    public Activity zzdob;
    /* access modifiers changed from: private */
    public MediationInterstitialListener zzdoc;

    public final void onDestroy() {
        zzaza.zzeb("Destroying AdMobCustomTabsAdapter adapter.");
    }

    public final void onPause() {
        zzaza.zzeb("Pausing AdMobCustomTabsAdapter adapter.");
    }

    public final void onResume() {
        zzaza.zzeb("Resuming AdMobCustomTabsAdapter adapter.");
    }

    public final void requestInterstitialAd(Context context, MediationInterstitialListener mediationInterstitialListener, Bundle bundle, MediationAdRequest mediationAdRequest, Bundle bundle2) {
        this.zzdoc = mediationInterstitialListener;
        if (this.zzdoc == null) {
            zzaza.zzfa("Listener not set for mediation. Returning.");
        } else if (!(context instanceof Activity)) {
            zzaza.zzfa("AdMobCustomTabs can only work with Activity context. Bailing out.");
            this.zzdoc.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
        } else {
            if (!(PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacf.zzj(context))) {
                zzaza.zzfa("Default browser does not support custom tabs. Bailing out.");
                this.zzdoc.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
                return;
            }
            String string = bundle.getString("tab_url");
            if (TextUtils.isEmpty(string)) {
                zzaza.zzfa("The tab_url retrieved from mediation metadata is empty. Bailing out.");
                this.zzdoc.onAdFailedToLoad((MediationInterstitialAdapter) this, 0);
                return;
            }
            this.zzdob = (Activity) context;
            this.uri = Uri.parse(string);
            this.zzdoc.onAdLoaded(this);
        }
    }

    public final void showInterstitial() {
        C0395c a = new C0395c.C0396a().mo2805a();
        a.f1348a.setData(this.uri);
        zzm.zzedd.post(new zzaqg(this, new AdOverlayInfoParcel(new zzb(a.f1348a), (zzva) null, new zzaqh(this), (zzu) null, new zzazh(0, 0, false))));
        zzp.zzku().zzwv();
    }
}
