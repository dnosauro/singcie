package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.os.Build;
import android.os.LocaleList;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

final class zzdfo implements zzdfi<zzdfp> {
    private final Context context;
    private final zzdzc zzggb;

    public zzdfo(zzdzc zzdzc, Context context2) {
        this.zzggb = zzdzc;
        this.context = context2;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), PKIFailureInfo.notAuthorized);
    }

    private static String zza(Context context2, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context2).getPackageInfo(activityInfo.packageName, 0);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = activityInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return null;
    }

    private static String zzv(Context context2) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context2).getPackageInfo("com.android.vending", 128);
            if (packageInfo != null) {
                int i = packageInfo.versionCode;
                String str = packageInfo.packageName;
                StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 12);
                sb.append(i);
                sb.append(".");
                sb.append(str);
                return sb.toString();
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public final zzdyz<zzdfp> zzasm() {
        return this.zzggb.zze(new zzdfr(this));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdfp zzatf() {
        boolean z;
        PackageManager packageManager = this.context.getPackageManager();
        Locale locale = Locale.getDefault();
        boolean z2 = zza(packageManager, "geo:0,0?q=donuts") != null;
        boolean z3 = zza(packageManager, "http://www.google.com") != null;
        String country = locale.getCountry();
        boolean startsWith = Build.DEVICE.startsWith("generic");
        boolean isLatchsky = DeviceProperties.isLatchsky(this.context);
        boolean isSidewinder = DeviceProperties.isSidewinder(this.context);
        String language = locale.getLanguage();
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 24) {
            LocaleList localeList = LocaleList.getDefault();
            for (int i = 0; i < localeList.size(); i++) {
                arrayList.add(localeList.get(i).getLanguage());
            }
        }
        String zza = zza(this.context, packageManager);
        String zzv = zzv(this.context);
        String str = Build.FINGERPRINT;
        Context context2 = this.context;
        if (packageManager != null) {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
            ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
            List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, PKIFailureInfo.notAuthorized);
            if (queryIntentActivities != null && resolveActivity != null) {
                int i2 = 0;
                while (true) {
                    if (i2 >= queryIntentActivities.size()) {
                        break;
                    } else if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i2).activityInfo.name)) {
                        z = resolveActivity.activityInfo.packageName.equals(zzepr.zzcn(context2));
                        break;
                    } else {
                        i2++;
                    }
                }
                return new zzdfp(z2, z3, country, startsWith, isLatchsky, isSidewinder, language, arrayList, zza, zzv, str, z, Build.MODEL, zzp.zzks().zzyn());
            }
        }
        z = false;
        return new zzdfp(z2, z3, country, startsWith, isLatchsky, isSidewinder, language, arrayList, zza, zzv, str, z, Build.MODEL, zzp.zzks().zzyn());
    }
}
