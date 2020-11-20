package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.formats.NativeCustomTemplateAd;
import com.google.android.gms.ads.mediation.Adapter;
import com.google.android.gms.ads.mediation.MediationAdLoadCallback;
import com.google.android.gms.ads.mediation.MediationAdapter;
import com.google.android.gms.ads.mediation.MediationBannerAdapter;
import com.google.android.gms.ads.mediation.MediationConfiguration;
import com.google.android.gms.ads.mediation.MediationInterstitialAdapter;
import com.google.android.gms.ads.mediation.MediationNativeAdapter;
import com.google.android.gms.ads.mediation.MediationRewardedAd;
import com.google.android.gms.ads.mediation.MediationRewardedAdCallback;
import com.google.android.gms.ads.mediation.MediationRewardedAdConfiguration;
import com.google.android.gms.ads.mediation.NativeAdMapper;
import com.google.android.gms.ads.mediation.NativeAppInstallAdMapper;
import com.google.android.gms.ads.mediation.NativeContentAdMapper;
import com.google.android.gms.ads.mediation.OnContextChangedListener;
import com.google.android.gms.ads.mediation.OnImmersiveModeUpdatedListener;
import com.google.android.gms.ads.mediation.UnifiedNativeAdMapper;
import com.google.android.gms.ads.mediation.zza;
import com.google.android.gms.ads.reward.mediation.InitializableMediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.reward.mediation.MediationRewardedVideoAdAdapter;
import com.google.android.gms.ads.zzb;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzaoe extends zzanm {
    /* access modifiers changed from: private */
    public final Object zzdmo;
    private zzaoj zzdmp;
    private zzauw zzdmq;
    private IObjectWrapper zzdmr;
    /* access modifiers changed from: private */
    public MediationRewardedAd zzdms;

    public zzaoe(Adapter adapter) {
        this.zzdmo = adapter;
    }

    public zzaoe(MediationAdapter mediationAdapter) {
        this.zzdmo = mediationAdapter;
    }

    private final Bundle zza(String str, zzvk zzvk, String str2) {
        Bundle bundle;
        String valueOf = String.valueOf(str);
        zzaza.zzeb(valueOf.length() != 0 ? "Server parameters: ".concat(valueOf) : new String("Server parameters: "));
        try {
            Bundle bundle2 = new Bundle();
            if (str != null) {
                JSONObject jSONObject = new JSONObject(str);
                bundle = new Bundle();
                Iterator<String> keys = jSONObject.keys();
                while (keys.hasNext()) {
                    String next = keys.next();
                    bundle.putString(next, jSONObject.getString(next));
                }
            } else {
                bundle = bundle2;
            }
            if (this.zzdmo instanceof AdMobAdapter) {
                bundle.putString("adJson", str2);
                if (zzvk != null) {
                    bundle.putInt("tagForChildDirectedTreatment", zzvk.zzadl);
                }
            }
            bundle.remove("max_ad_content_rating");
            return bundle;
        } catch (Throwable th) {
            zzaza.zzc("", th);
            throw new RemoteException();
        }
    }

    private final MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza(zzano zzano) {
        return new zzaog(this, zzano);
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
        r2 = r2.zzchf.getBundle(r1.zzdmo.getClass().getName());
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final android.os.Bundle zzd(com.google.android.gms.internal.ads.zzvk r2) {
        /*
            r1 = this;
            android.os.Bundle r0 = r2.zzchf
            if (r0 == 0) goto L_0x0017
            android.os.Bundle r2 = r2.zzchf
            java.lang.Object r0 = r1.zzdmo
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
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaoe.zzd(com.google.android.gms.internal.ads.zzvk):android.os.Bundle");
    }

    public final void destroy() {
        Object obj = this.zzdmo;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onDestroy();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final Bundle getInterstitialAdapterInfo() {
        Object obj = this.zzdmo;
        if (obj instanceof zzbgj) {
            return ((zzbgj) obj).getInterstitialAdapterInfo();
        }
        String canonicalName = zzbgj.class.getCanonicalName();
        String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzaza.zzfa(sb.toString());
        return new Bundle();
    }

    public final zzys getVideoController() {
        Object obj = this.zzdmo;
        if (!(obj instanceof zza)) {
            return null;
        }
        try {
            return ((zza) obj).getVideoController();
        } catch (Throwable th) {
            zzaza.zzc("", th);
            return null;
        }
    }

    public final boolean isInitialized() {
        Object obj = this.zzdmo;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaza.zzeb("Check if adapter is initialized.");
            try {
                return ((MediationRewardedVideoAdAdapter) this.zzdmo).isInitialized();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            return this.zzdmq != null;
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void pause() {
        Object obj = this.zzdmo;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onPause();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void resume() {
        Object obj = this.zzdmo;
        if (obj instanceof MediationAdapter) {
            try {
                ((MediationAdapter) obj).onResume();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        }
    }

    public final void setImmersiveMode(boolean z) {
        Object obj = this.zzdmo;
        if (!(obj instanceof OnImmersiveModeUpdatedListener)) {
            String canonicalName = OnImmersiveModeUpdatedListener.class.getCanonicalName();
            String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzeb(sb.toString());
            return;
        }
        try {
            ((OnImmersiveModeUpdatedListener) obj).onImmersiveModeUpdated(z);
        } catch (Throwable th) {
            zzaza.zzc("", th);
        }
    }

    public final void showInterstitial() {
        if (this.zzdmo instanceof MediationInterstitialAdapter) {
            zzaza.zzeb("Showing interstitial from adapter.");
            try {
                ((MediationInterstitialAdapter) this.zzdmo).showInterstitial();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void showVideo() {
        Object obj = this.zzdmo;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaza.zzeb("Show rewarded video ad from adapter.");
            try {
                ((MediationRewardedVideoAdAdapter) this.zzdmo).showVideo();
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            MediationRewardedAd mediationRewardedAd = this.zzdms;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(this.zzdmr));
            } else {
                zzaza.zzey("Can not show null mediated rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzajb zzajb, List<zzajj> list) {
        AdFormat adFormat;
        if (this.zzdmo instanceof Adapter) {
            zzaoh zzaoh = new zzaoh(this, zzajb);
            ArrayList arrayList = new ArrayList();
            for (zzajj next : list) {
                String str = next.zzdhs;
                char c = 65535;
                int hashCode = str.hashCode();
                if (hashCode != -1396342996) {
                    if (hashCode != -1052618729) {
                        if (hashCode != -239580146) {
                            if (hashCode == 604727084 && str.equals("interstitial")) {
                                c = 1;
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
                        throw new RemoteException();
                }
                arrayList.add(new MediationConfiguration(adFormat, next.extras));
            }
            ((Adapter) this.zzdmo).initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzaoh, arrayList);
            return;
        }
        throw new RemoteException();
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzauw zzauw, List<String> list) {
        if (this.zzdmo instanceof InitializableMediationRewardedVideoAdAdapter) {
            zzaza.zzeb("Initialize rewarded video adapter.");
            try {
                InitializableMediationRewardedVideoAdAdapter initializableMediationRewardedVideoAdAdapter = (InitializableMediationRewardedVideoAdAdapter) this.zzdmo;
                ArrayList arrayList = new ArrayList();
                for (String zza : list) {
                    arrayList.add(zza(zza, (zzvk) null, (String) null));
                }
                initializableMediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzavb(zzauw), arrayList);
            } catch (Throwable th) {
                zzaza.zzd("Could not initialize rewarded video adapter.", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = InitializableMediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
        zza(iObjectWrapper, zzvk, str, (String) null, zzano);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzauw zzauw, String str2) {
        Bundle bundle;
        zzaof zzaof;
        zzvk zzvk2 = zzvk;
        zzauw zzauw2 = zzauw;
        String str3 = str2;
        Object obj = this.zzdmo;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaza.zzeb("Initialize rewarded video adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdmo;
                Bundle zza = zza(str3, zzvk2, (String) null);
                if (zzvk2 != null) {
                    zzaof zzaof2 = new zzaof(zzvk2.zzcgy == -1 ? null : new Date(zzvk2.zzcgy), zzvk2.zzcgz, zzvk2.zzcha != null ? new HashSet(zzvk2.zzcha) : null, zzvk2.zzmy, zzc(zzvk), zzvk2.zzadl, zzvk2.zzchk, zzvk2.zzadm, zza(str3, zzvk2));
                    bundle = zzvk2.zzchf != null ? zzvk2.zzchf.getBundle(mediationRewardedVideoAdAdapter.getClass().getName()) : null;
                    zzaof = zzaof2;
                } else {
                    zzaof = null;
                    bundle = null;
                }
                mediationRewardedVideoAdAdapter.initialize((Context) ObjectWrapper.unwrap(iObjectWrapper), zzaof, str, new zzavb(zzauw2), zza, bundle);
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            this.zzdmr = iObjectWrapper;
            this.zzdmq = zzauw2;
            zzauw2.zzaf(ObjectWrapper.wrap(obj));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, String str2, zzano zzano) {
        zzvk zzvk2 = zzvk;
        String str3 = str;
        if (this.zzdmo instanceof MediationInterstitialAdapter) {
            zzaza.zzeb("Requesting interstitial ad from adapter.");
            try {
                MediationInterstitialAdapter mediationInterstitialAdapter = (MediationInterstitialAdapter) this.zzdmo;
                Bundle bundle = null;
                zzaof zzaof = new zzaof(zzvk2.zzcgy == -1 ? null : new Date(zzvk2.zzcgy), zzvk2.zzcgz, zzvk2.zzcha != null ? new HashSet(zzvk2.zzcha) : null, zzvk2.zzmy, zzc(zzvk), zzvk2.zzadl, zzvk2.zzchk, zzvk2.zzadm, zza(str3, zzvk2));
                if (zzvk2.zzchf != null) {
                    bundle = zzvk2.zzchf.getBundle(mediationInterstitialAdapter.getClass().getName());
                }
                mediationInterstitialAdapter.requestInterstitialAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaoj(zzano), zza(str3, zzvk2, str2), zzaof, bundle);
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationInterstitialAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, String str2, zzano zzano, zzadz zzadz, List<String> list) {
        zzvk zzvk2 = zzvk;
        String str3 = str;
        Object obj = this.zzdmo;
        if (obj instanceof MediationNativeAdapter) {
            try {
                MediationNativeAdapter mediationNativeAdapter = (MediationNativeAdapter) obj;
                Bundle bundle = null;
                HashSet hashSet = zzvk2.zzcha != null ? new HashSet(zzvk2.zzcha) : null;
                zzaon zzaon = new zzaon(zzvk2.zzcgy == -1 ? null : new Date(zzvk2.zzcgy), zzvk2.zzcgz, hashSet, zzvk2.zzmy, zzc(zzvk), zzvk2.zzadl, zzadz, list, zzvk2.zzchk, zzvk2.zzadm, zza(str3, zzvk2));
                if (zzvk2.zzchf != null) {
                    bundle = zzvk2.zzchf.getBundle(mediationNativeAdapter.getClass().getName());
                }
                this.zzdmp = new zzaoj(zzano);
                mediationNativeAdapter.requestNativeAd((Context) ObjectWrapper.unwrap(iObjectWrapper), this.zzdmp, zza(str3, zzvk2, str2), zzaon, bundle);
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationNativeAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvn, zzvk zzvk, String str, zzano zzano) {
        zza(iObjectWrapper, zzvn, zzvk, str, (String) null, zzano);
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzvn zzvn, zzvk zzvk, String str, String str2, zzano zzano) {
        zzvn zzvn2 = zzvn;
        zzvk zzvk2 = zzvk;
        String str3 = str;
        if (this.zzdmo instanceof MediationBannerAdapter) {
            zzaza.zzeb("Requesting banner ad from adapter.");
            try {
                MediationBannerAdapter mediationBannerAdapter = (MediationBannerAdapter) this.zzdmo;
                Bundle bundle = null;
                zzaof zzaof = new zzaof(zzvk2.zzcgy == -1 ? null : new Date(zzvk2.zzcgy), zzvk2.zzcgz, zzvk2.zzcha != null ? new HashSet(zzvk2.zzcha) : null, zzvk2.zzmy, zzc(zzvk), zzvk2.zzadl, zzvk2.zzchk, zzvk2.zzadm, zza(str3, zzvk2));
                if (zzvk2.zzchf != null) {
                    bundle = zzvk2.zzchf.getBundle(mediationBannerAdapter.getClass().getName());
                }
                mediationBannerAdapter.requestBannerAd((Context) ObjectWrapper.unwrap(iObjectWrapper), new zzaoj(zzano), zza(str3, zzvk2, str2), zzvn2.zzchw ? zzb.zza(zzvn2.width, zzvn2.height) : zzb.zza(zzvn2.width, zzvn2.height, zzvn2.zzacv), zzaof, bundle);
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zza(zzvk zzvk, String str) {
        zza(zzvk, str, (String) null);
    }

    public final void zza(zzvk zzvk, String str, String str2) {
        zzvk zzvk2 = zzvk;
        String str3 = str;
        Object obj = this.zzdmo;
        if (obj instanceof MediationRewardedVideoAdAdapter) {
            zzaza.zzeb("Requesting rewarded video ad from adapter.");
            try {
                MediationRewardedVideoAdAdapter mediationRewardedVideoAdAdapter = (MediationRewardedVideoAdAdapter) this.zzdmo;
                Bundle bundle = null;
                zzaof zzaof = new zzaof(zzvk2.zzcgy == -1 ? null : new Date(zzvk2.zzcgy), zzvk2.zzcgz, zzvk2.zzcha != null ? new HashSet(zzvk2.zzcha) : null, zzvk2.zzmy, zzc(zzvk), zzvk2.zzadl, zzvk2.zzchk, zzvk2.zzadm, zza(str3, zzvk2));
                if (zzvk2.zzchf != null) {
                    bundle = zzvk2.zzchf.getBundle(mediationRewardedVideoAdAdapter.getClass().getName());
                }
                mediationRewardedVideoAdAdapter.loadAd(zzaof, zza(str3, zzvk2, str2), bundle);
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else if (obj instanceof Adapter) {
            zzb(this.zzdmr, zzvk2, str3, new zzaoi((Adapter) obj, this.zzdmq));
        } else {
            String canonicalName = MediationRewardedVideoAdAdapter.class.getCanonicalName();
            String canonicalName2 = Adapter.class.getCanonicalName();
            String canonicalName3 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 26 + String.valueOf(canonicalName2).length() + String.valueOf(canonicalName3).length());
            sb.append(canonicalName);
            sb.append(" or ");
            sb.append(canonicalName2);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName3);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
        zzvk zzvk2 = zzvk;
        String str2 = str;
        if (this.zzdmo instanceof Adapter) {
            zzaza.zzeb("Requesting rewarded ad from adapter.");
            try {
                MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza = zza(zzano);
                Bundle zza2 = zza(str2, zzvk2, (String) null);
                Bundle zzd = zzd(zzvk2);
                boolean zzc = zzc(zzvk);
                Location location = zzvk2.zzmy;
                int i = zzvk2.zzadl;
                int i2 = zzvk2.zzadm;
                String zza3 = zza(str2, zzvk2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza2, zzd, zzc, location, i, i2, zza3, "");
                ((Adapter) this.zzdmo).loadRewardedAd(mediationRewardedAdConfiguration, zza);
            } catch (Exception e) {
                zzaza.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzc(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano) {
        zzvk zzvk2 = zzvk;
        String str2 = str;
        if (this.zzdmo instanceof Adapter) {
            zzaza.zzeb("Requesting rewarded interstitial ad from adapter.");
            try {
                MediationAdLoadCallback<MediationRewardedAd, MediationRewardedAdCallback> zza = zza(zzano);
                Bundle zza2 = zza(str2, zzvk2, (String) null);
                Bundle zzd = zzd(zzvk2);
                boolean zzc = zzc(zzvk);
                Location location = zzvk2.zzmy;
                int i = zzvk2.zzadl;
                int i2 = zzvk2.zzadm;
                String zza3 = zza(str2, zzvk2);
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration = r5;
                MediationRewardedAdConfiguration mediationRewardedAdConfiguration2 = new MediationRewardedAdConfiguration((Context) ObjectWrapper.unwrap(iObjectWrapper), "", zza2, zzd, zzc, location, i, i2, zza3, "");
                ((Adapter) this.zzdmo).loadRewardedInterstitialAd(mediationRewardedAdConfiguration, zza);
            } catch (Exception e) {
                zzaza.zzc("", e);
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final void zzs(IObjectWrapper iObjectWrapper) {
        Context context = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        Object obj = this.zzdmo;
        if (obj instanceof OnContextChangedListener) {
            ((OnContextChangedListener) obj).onContextChanged(context);
        }
    }

    public final void zzt(IObjectWrapper iObjectWrapper) {
        if (this.zzdmo instanceof Adapter) {
            zzaza.zzeb("Show rewarded ad from adapter.");
            MediationRewardedAd mediationRewardedAd = this.zzdms;
            if (mediationRewardedAd != null) {
                mediationRewardedAd.showAd((Context) ObjectWrapper.unwrap(iObjectWrapper));
            } else {
                zzaza.zzey("Can not show null mediation rewarded ad.");
                throw new RemoteException();
            }
        } else {
            String canonicalName = Adapter.class.getCanonicalName();
            String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final IObjectWrapper zzud() {
        Object obj = this.zzdmo;
        if (obj instanceof MediationBannerAdapter) {
            try {
                return ObjectWrapper.wrap(((MediationBannerAdapter) obj).getBannerView());
            } catch (Throwable th) {
                zzaza.zzc("", th);
                throw new RemoteException();
            }
        } else {
            String canonicalName = MediationBannerAdapter.class.getCanonicalName();
            String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
            StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
            sb.append(canonicalName);
            sb.append(" #009 Class mismatch: ");
            sb.append(canonicalName2);
            zzaza.zzfa(sb.toString());
            throw new RemoteException();
        }
    }

    public final zzanv zzue() {
        NativeAdMapper zzur = this.zzdmp.zzur();
        if (zzur instanceof NativeAppInstallAdMapper) {
            return new zzaol((NativeAppInstallAdMapper) zzur);
        }
        return null;
    }

    public final zzanw zzuf() {
        NativeAdMapper zzur = this.zzdmp.zzur();
        if (zzur instanceof NativeContentAdMapper) {
            return new zzaok((NativeContentAdMapper) zzur);
        }
        return null;
    }

    public final Bundle zzug() {
        Object obj = this.zzdmo;
        if (obj instanceof zzbgk) {
            return ((zzbgk) obj).zzug();
        }
        String canonicalName = zzbgk.class.getCanonicalName();
        String canonicalName2 = this.zzdmo.getClass().getCanonicalName();
        StringBuilder sb = new StringBuilder(String.valueOf(canonicalName).length() + 22 + String.valueOf(canonicalName2).length());
        sb.append(canonicalName);
        sb.append(" #009 Class mismatch: ");
        sb.append(canonicalName2);
        zzaza.zzfa(sb.toString());
        return new Bundle();
    }

    public final Bundle zzuh() {
        return new Bundle();
    }

    public final boolean zzui() {
        return this.zzdmo instanceof InitializableMediationRewardedVideoAdAdapter;
    }

    public final zzaff zzuj() {
        NativeCustomTemplateAd zzut = this.zzdmp.zzut();
        if (zzut instanceof zzafg) {
            return ((zzafg) zzut).zzte();
        }
        return null;
    }

    public final zzaob zzuk() {
        UnifiedNativeAdMapper zzus = this.zzdmp.zzus();
        if (zzus != null) {
            return new zzapd(zzus);
        }
        return null;
    }

    public final zzaqc zzul() {
        Object obj = this.zzdmo;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzaqc.zza(((Adapter) obj).getVersionInfo());
    }

    public final zzaqc zzum() {
        Object obj = this.zzdmo;
        if (!(obj instanceof Adapter)) {
            return null;
        }
        return zzaqc.zza(((Adapter) obj).getSDKVersionInfo());
    }
}
