package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.view.View;
import androidx.p018c.C0413g;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Collections;
import java.util.List;

public final class zzcce {
    private Bundle extras;
    private zzaeb zzdeq;
    private List<zzzk> zzdfe = Collections.emptyList();
    private List<?> zzety;
    private double zzeud;
    private float zzeuo;
    private IObjectWrapper zzfue;
    private int zzgcs;
    private zzys zzgct;
    private View zzgcu;
    private zzzk zzgcv;
    private zzbdv zzgcw;
    private zzbdv zzgcx;
    private View zzgcy;
    private IObjectWrapper zzgcz;
    private zzaej zzgda;
    private zzaej zzgdb;
    private String zzgdc;
    private C0413g<String, zzadv> zzgdd = new C0413g<>();
    private C0413g<String, String> zzgde = new C0413g<>();
    private String zzgdf;

    private final synchronized void setMediaContentAspectRatio(float f) {
        this.zzeuo = f;
    }

    private static zzccb zza(zzys zzys, zzaob zzaob) {
        if (zzys == null) {
            return null;
        }
        return new zzccb(zzys, zzaob);
    }

    public static zzcce zza(zzanv zzanv) {
        try {
            zzccb zza = zza(zzanv.getVideoController(), (zzaob) null);
            zzaeb zzsx = zzanv.zzsx();
            String headline = zzanv.getHeadline();
            List<?> images = zzanv.getImages();
            String body = zzanv.getBody();
            Bundle extras2 = zzanv.getExtras();
            String callToAction = zzanv.getCallToAction();
            IObjectWrapper zzsy = zzanv.zzsy();
            String store = zzanv.getStore();
            String price = zzanv.getPrice();
            double starRating = zzanv.getStarRating();
            zzaej zzsw = zzanv.zzsw();
            zzcce zzcce = new zzcce();
            zzcce.zzgcs = 2;
            zzcce.zzgct = zza;
            zzcce.zzdeq = zzsx;
            zzcce.zzgcu = (View) zzau(zzanv.zzup());
            zzcce.zzn("headline", headline);
            zzcce.zzety = images;
            zzcce.zzn("body", body);
            zzcce.extras = extras2;
            zzcce.zzn("call_to_action", callToAction);
            zzcce.zzgcy = (View) zzau(zzanv.zzuq());
            zzcce.zzgcz = zzsy;
            zzcce.zzn("store", store);
            zzcce.zzn(FirebaseAnalytics.Param.PRICE, price);
            zzcce.zzeud = starRating;
            zzcce.zzgda = zzsw;
            return zzcce;
        } catch (RemoteException e) {
            zzd.zzd("Failed to get native ad from app install ad mapper", e);
            return null;
        }
    }

    public static zzcce zza(zzanw zzanw) {
        try {
            zzccb zza = zza(zzanw.getVideoController(), (zzaob) null);
            zzaeb zzsx = zzanw.zzsx();
            String headline = zzanw.getHeadline();
            List<?> images = zzanw.getImages();
            String body = zzanw.getBody();
            Bundle extras2 = zzanw.getExtras();
            String callToAction = zzanw.getCallToAction();
            IObjectWrapper zzsy = zzanw.zzsy();
            String advertiser = zzanw.getAdvertiser();
            zzaej zzsz = zzanw.zzsz();
            zzcce zzcce = new zzcce();
            zzcce.zzgcs = 1;
            zzcce.zzgct = zza;
            zzcce.zzdeq = zzsx;
            zzcce.zzgcu = (View) zzau(zzanw.zzup());
            zzcce.zzn("headline", headline);
            zzcce.zzety = images;
            zzcce.zzn("body", body);
            zzcce.extras = extras2;
            zzcce.zzn("call_to_action", callToAction);
            zzcce.zzgcy = (View) zzau(zzanw.zzuq());
            zzcce.zzgcz = zzsy;
            zzcce.zzn("advertiser", advertiser);
            zzcce.zzgdb = zzsz;
            return zzcce;
        } catch (RemoteException e) {
            zzd.zzd("Failed to get native ad from content ad mapper", e);
            return null;
        }
    }

    private static zzcce zza(zzys zzys, zzaeb zzaeb, View view, String str, List list, String str2, Bundle bundle, String str3, View view2, IObjectWrapper iObjectWrapper, String str4, String str5, double d, zzaej zzaej, String str6, float f) {
        zzcce zzcce = new zzcce();
        zzcce.zzgcs = 6;
        zzcce.zzgct = zzys;
        zzcce.zzdeq = zzaeb;
        zzcce.zzgcu = view;
        String str7 = str;
        zzcce.zzn("headline", str);
        zzcce.zzety = list;
        String str8 = str2;
        zzcce.zzn("body", str2);
        zzcce.extras = bundle;
        String str9 = str3;
        zzcce.zzn("call_to_action", str3);
        zzcce.zzgcy = view2;
        zzcce.zzgcz = iObjectWrapper;
        String str10 = str4;
        zzcce.zzn("store", str4);
        String str11 = str5;
        zzcce.zzn(FirebaseAnalytics.Param.PRICE, str5);
        zzcce.zzeud = d;
        zzcce.zzgda = zzaej;
        zzcce.zzn("advertiser", str6);
        zzcce.setMediaContentAspectRatio(f);
        return zzcce;
    }

    private static <T> T zzau(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper == null) {
            return null;
        }
        return ObjectWrapper.unwrap(iObjectWrapper);
    }

    public static zzcce zzb(zzanv zzanv) {
        try {
            return zza(zza(zzanv.getVideoController(), (zzaob) null), zzanv.zzsx(), (View) zzau(zzanv.zzup()), zzanv.getHeadline(), zzanv.getImages(), zzanv.getBody(), zzanv.getExtras(), zzanv.getCallToAction(), (View) zzau(zzanv.zzuq()), zzanv.zzsy(), zzanv.getStore(), zzanv.getPrice(), zzanv.getStarRating(), zzanv.zzsw(), (String) null, 0.0f);
        } catch (RemoteException e) {
            zzd.zzd("Failed to get native ad assets from app install ad mapper", e);
            return null;
        }
    }

    public static zzcce zzb(zzanw zzanw) {
        try {
            return zza(zza(zzanw.getVideoController(), (zzaob) null), zzanw.zzsx(), (View) zzau(zzanw.zzup()), zzanw.getHeadline(), zzanw.getImages(), zzanw.getBody(), zzanw.getExtras(), zzanw.getCallToAction(), (View) zzau(zzanw.zzuq()), zzanw.zzsy(), (String) null, (String) null, -1.0d, zzanw.zzsz(), zzanw.getAdvertiser(), 0.0f);
        } catch (RemoteException e) {
            zzd.zzd("Failed to get native ad assets from content ad mapper", e);
            return null;
        }
    }

    public static zzcce zzb(zzaob zzaob) {
        try {
            return zza(zza(zzaob.getVideoController(), zzaob), zzaob.zzsx(), (View) zzau(zzaob.zzup()), zzaob.getHeadline(), zzaob.getImages(), zzaob.getBody(), zzaob.getExtras(), zzaob.getCallToAction(), (View) zzau(zzaob.zzuq()), zzaob.zzsy(), zzaob.getStore(), zzaob.getPrice(), zzaob.getStarRating(), zzaob.zzsw(), zzaob.getAdvertiser(), zzaob.getMediaContentAspectRatio());
        } catch (RemoteException e) {
            zzd.zzd("Failed to get native ad assets from unified ad mapper", e);
            return null;
        }
    }

    private final synchronized String zzfz(String str) {
        return this.zzgde.get(str);
    }

    public final synchronized void destroy() {
        if (this.zzgcw != null) {
            this.zzgcw.destroy();
            this.zzgcw = null;
        }
        if (this.zzgcx != null) {
            this.zzgcx.destroy();
            this.zzgcx = null;
        }
        this.zzfue = null;
        this.zzgdd.clear();
        this.zzgde.clear();
        this.zzgct = null;
        this.zzdeq = null;
        this.zzgcu = null;
        this.zzety = null;
        this.extras = null;
        this.zzgcy = null;
        this.zzgcz = null;
        this.zzgda = null;
        this.zzgdb = null;
        this.zzgdc = null;
    }

    public final synchronized String getAdvertiser() {
        return zzfz("advertiser");
    }

    public final synchronized String getBody() {
        return zzfz("body");
    }

    public final synchronized String getCallToAction() {
        return zzfz("call_to_action");
    }

    public final synchronized String getCustomTemplateId() {
        return this.zzgdc;
    }

    public final synchronized Bundle getExtras() {
        if (this.extras == null) {
            this.extras = new Bundle();
        }
        return this.extras;
    }

    public final synchronized String getHeadline() {
        return zzfz("headline");
    }

    public final synchronized List<?> getImages() {
        return this.zzety;
    }

    public final synchronized float getMediaContentAspectRatio() {
        return this.zzeuo;
    }

    public final synchronized List<zzzk> getMuteThisAdReasons() {
        return this.zzdfe;
    }

    public final synchronized String getPrice() {
        return zzfz(FirebaseAnalytics.Param.PRICE);
    }

    public final synchronized double getStarRating() {
        return this.zzeud;
    }

    public final synchronized String getStore() {
        return zzfz("store");
    }

    public final synchronized zzys getVideoController() {
        return this.zzgct;
    }

    public final synchronized void setImages(List<zzadv> list) {
        this.zzety = list;
    }

    public final synchronized void setStarRating(double d) {
        this.zzeud = d;
    }

    public final synchronized void zza(zzaeb zzaeb) {
        this.zzdeq = zzaeb;
    }

    public final synchronized void zza(zzaej zzaej) {
        this.zzgda = zzaej;
    }

    public final synchronized void zza(zzzk zzzk) {
        this.zzgcv = zzzk;
    }

    public final synchronized void zza(String str, zzadv zzadv) {
        if (zzadv == null) {
            this.zzgdd.remove(str);
        } else {
            this.zzgdd.put(str, zzadv);
        }
    }

    public final synchronized void zzac(View view) {
        this.zzgcy = view;
    }

    public final synchronized int zzanc() {
        return this.zzgcs;
    }

    public final synchronized View zzand() {
        return this.zzgcu;
    }

    public final zzaej zzane() {
        List<?> list = this.zzety;
        if (!(list == null || list.size() == 0)) {
            Object obj = this.zzety.get(0);
            if (obj instanceof IBinder) {
                return zzaei.zzo((IBinder) obj);
            }
        }
        return null;
    }

    public final synchronized zzzk zzanf() {
        return this.zzgcv;
    }

    public final synchronized View zzang() {
        return this.zzgcy;
    }

    public final synchronized zzbdv zzanh() {
        return this.zzgcw;
    }

    public final synchronized zzbdv zzani() {
        return this.zzgcx;
    }

    public final synchronized IObjectWrapper zzanj() {
        return this.zzfue;
    }

    public final synchronized C0413g<String, zzadv> zzank() {
        return this.zzgdd;
    }

    public final synchronized String zzanl() {
        return this.zzgdf;
    }

    public final synchronized C0413g<String, String> zzanm() {
        return this.zzgde;
    }

    public final synchronized void zzat(IObjectWrapper iObjectWrapper) {
        this.zzfue = iObjectWrapper;
    }

    public final synchronized void zzb(zzaej zzaej) {
        this.zzgdb = zzaej;
    }

    public final synchronized void zzb(zzys zzys) {
        this.zzgct = zzys;
    }

    public final synchronized void zzdz(int i) {
        this.zzgcs = i;
    }

    public final synchronized void zzfx(String str) {
        this.zzgdc = str;
    }

    public final synchronized void zzfy(String str) {
        this.zzgdf = str;
    }

    public final synchronized void zzh(List<zzzk> list) {
        this.zzdfe = list;
    }

    public final synchronized void zzi(zzbdv zzbdv) {
        this.zzgcw = zzbdv;
    }

    public final synchronized void zzj(zzbdv zzbdv) {
        this.zzgcx = zzbdv;
    }

    public final synchronized void zzn(String str, String str2) {
        if (str2 == null) {
            this.zzgde.remove(str);
        } else {
            this.zzgde.put(str, str2);
        }
    }

    public final synchronized zzaej zzsw() {
        return this.zzgda;
    }

    public final synchronized zzaeb zzsx() {
        return this.zzdeq;
    }

    public final synchronized IObjectWrapper zzsy() {
        return this.zzgcz;
    }

    public final synchronized zzaej zzsz() {
        return this.zzgdb;
    }
}
