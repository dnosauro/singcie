package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationBannerAdConfiguration;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAd;
import com.google.android.gms.ads.mediation.MediationInterstitialAdConfiguration;
import com.google.android.gms.ads.mediation.MediationNativeAdConfiguration;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.mediation.rtb.RtbSignalData;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Iterator;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzapx extends zzapr {
    /* access modifiers changed from: private */
    public MediationRewardedAd zzdms;
    private final RtbAdapter zzdnr;
    /* access modifiers changed from: private */
    public MediationInterstitialAd zzdns;
    private String zzdnt = "";

    public zzapx(RtbAdapter rtbAdapter) {
        this.zzdnr = rtbAdapter;
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzapn zzapn, zzano zzano) {
        return new zzaqa(this, zzapn, zzano);
    }

    private static String zza(String str, zzvk zzvk) {
        try {
            return new JSONObject(str).getString("max_ad_content_rating");
        } catch (JSONException unused) {
            return zzvk.zzadn;
        }
    }

    private static boolean zzc(zzvk zzvk) {
        if (zzvk.zzchb) {
            return true;
        }
        zzwq.zzqa();
        return zzayr.zzzd();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r2 = r2.zzchf.getBundle(r1.zzdnr.getClass().getName());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Bundle zzd(com.google.android.gms.internal.ads.zzvk r2) {
        /*
            r1 = this;
            android.os.Bundle r0 = r2.zzchf
            if (r0 == 0) goto L_0x0017
            android.os.Bundle r2 = r2.zzchf
            com.google.android.gms.ads.mediation.rtb.RtbAdapter r0 = r1.zzdnr
            java.lang.Class r0 = r0.getClass()
            java.lang.String r0 = r0.getName()
            android.os.Bundle r2 = r2.getBundle(r0)
            if (r2 == 0) goto L_0x0017
            return r2
        L_0x0017:
            android.os.Bundle r2 = new android.os.Bundle
            r2.<init>()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzapx.zzd(com.google.android.gms.internal.ads.zzvk):android.os.Bundle");
    }

    private static Bundle zzdq(String str) {
        String valueOf = String.valueOf(str);
        zzaza.zzfa(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle = new Bundle();
            if (str == null) {
                return bundle;
            }
            JSONObject jSONObject = new JSONObject(str);
            Bundle bundle2 = new Bundle();
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                bundle2.putString(next, jSONObject.getString(next));
            }
            return bundle2;
        } catch (JSONException e) {
            zzaza.zzc("", e);
            throw new RemoteException();
        }
    }

    public final zzys getVideoController() {
        RtbAdapter rtbAdapter = this.zzdnr;
        if (!(rtbAdapter instanceof zza)) {
            return null;
        }
        try {
            return ((zza) rtbAdapter).getVideoController();
        } catch (Throwable th) {
            zzaza.zzc("", th);
            return null;
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, String str, Bundle bundle, Bundle bundle2, zzvn zzvn, zzapt zzapt) {
        AdFormat adFormat;
        try {
            zzaqb zzaqb = new zzaqb(this, zzapt);
            RtbAdapter rtbAdapter = this.zzdnr;
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1396342996) {
                if (hashCode != -1052618729) {
                    if (hashCode != -239580146) {
                        if (hashCode == 604727084) {
                            if (str.equals("interstitial")) {
                                c = 1;
                            }
                        }
                    } else if (str.equals("rewarded")) {
                        c = 2;
                    }
                } else if (str.equals("native")) {
                    c = 3;
                }
            } else if (str.equals("banner")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    adFormat = AdFormat.BANNER;
                    break;
                case 1:
                    adFormat = AdFormat.INTERSTITIAL;
                    break;
                case 2:
                    adFormat = AdFormat.REWARDED;
                    break;
                case 3:
                    adFormat = AdFormat.NATIVE;
                    break;
                default:
                    throw new IllegalArgumentException("Internal Error");
            }
            MediationConfiguration mediationConfiguration = new MediationConfiguration(adFormat, bundle2);
            ArrayList arrayList = new ArrayList();
            arrayList.add(mediationConfiguration);
            rtbAdapter.collectSignals(new RtbSignalData((Context) ObjectWrapper.unwrap(iObjectWrapper), arrayList, bundle, zzb.zza(zzvn.width, zzvn.height, zzvn.zzacv)), zzaqb);
        } catch (Throwable th) {
            zzaza.zzc("Error generating signals for RTB", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapc zzapc, zzano zzano, zzvn zzvn) {
        zzvk zzvk2 = zzvk;
        zzvn zzvn2 = zzvn;
        try {
            zzapw zzapw = new zzapw(this, zzapc, zzano);
            RtbAdapter rtbAdapter = this.zzdnr;
            Bundle zzdq = zzdq(str2);
            Bundle zzd = zzd(zzvk2);
            boolean zzc = zzc(zzvk);
            Location location = zzvk2.zzmy;
            int i = zzvk2.zzadl;
            int i2 = zzvk2.zzadm;
            String zza = zza(str2, zzvk);
            AdSize zza2 = zzb.zza(zzvn2.width, zzvn2.height, zzvn2.zzacv);
            String str3 = this.zzdnt;
            MediationBannerAdConfiguration mediationBannerAdConfiguration = r5;
            MediationBannerAdConfiguration mediationBannerAdConfiguration2 = new MediationBannerAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq, zzd, zzc, location, i, i2, zza, zza2, str3);
            rtbAdapter.loadBannerAd(mediationBannerAdConfiguration, zzapw);
        } catch (Throwable th) {
            zzaza.zzc("Adapter failed to render banner ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzaph zzaph, zzano zzano) {
        zzvk zzvk2 = zzvk;
        try {
            this.zzdnr.loadInterstitialAd(new MediationInterstitialAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvk2), zzc(zzvk), zzvk2.zzmy, zzvk2.zzadl, zzvk2.zzadm, zza(str2, zzvk), this.zzdnt), new zzapz(this, zzaph, zzano));
        } catch (Throwable th) {
            zzaza.zzc("Adapter failed to render interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapi zzapi, zzano zzano) {
        zzvk zzvk2 = zzvk;
        try {
            this.zzdnr.loadNativeAd(new MediationNativeAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvk2), zzc(zzvk), zzvk2.zzmy, zzvk2.zzadl, zzvk2.zzadm, zza(str2, zzvk), this.zzdnt), new zzapy(this, zzapi, zzano));
        } catch (Throwable th) {
            zzaza.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapn zzapn, zzano zzano) {
        zzvk zzvk2 = zzvk;
        try {
            this.zzdnr.loadRewardedAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvk2), zzc(zzvk), zzvk2.zzmy, zzvk2.zzadl, zzvk2.zzadm, zza(str2, zzvk), this.zzdnt), zza(zzapn, zzano));
        } catch (Throwable th) {
            zzaza.zzc("Adapter failed to render rewarded ad.", th);
            throw new RemoteException();
        }
    }

    public final void zza(String[] strArr, Bundle[] bundleArr) {
    }

    public final boolean zzaa(IObjectWrapper iObjectWrapper) {
        MediationRewardedAd mediationRewardedAd = this.zzdms;
        if (mediationRewardedAd == null) {
            return false;
        }
        try {
            mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzaza.zzc("", th);
            return true;
        }
    }

    public final void zzb(String str, String str2, zzvk zzvk, IObjectWrapper iObjectWrapper, zzapn zzapn, zzano zzano) {
        zzvk zzvk2 = zzvk;
        try {
            this.zzdnr.loadRewardedInterstitialAd(new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), str, zzdq(str2), zzd(zzvk2), zzc(zzvk), zzvk2.zzmy, zzvk2.zzadl, zzvk2.zzadm, zza(str2, zzvk), this.zzdnt), zza(zzapn, zzano));
        } catch (Throwable th) {
            zzaza.zzc("Adapter failed to render rewarded interstitial ad.", th);
            throw new RemoteException();
        }
    }

    public final void zzdn(String str) {
        this.zzdnt = str;
    }

    public final zzaqc zzul() {
        return zzaqc.zza(this.zzdnr.getVersionInfo());
    }

    public final zzaqc zzum() {
        return zzaqc.zza(this.zzdnr.getSDKVersionInfo());
    }

    public final void zzy(IObjectWrapper iObjectWrapper) {
    }

    public final boolean zzz(IObjectWrapper iObjectWrapper) {
        MediationInterstitialAd mediationInterstitialAd = this.zzdns;
        if (mediationInterstitialAd == null) {
            return false;
        }
        try {
            mediationInterstitialAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            return true;
        } catch (Throwable th) {
            zzaza.zzc("", th);
            return true;
        }
    }
}
