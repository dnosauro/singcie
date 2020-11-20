package com.google.android.gms.internal.ads;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.media.AudioManager;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.DeviceProperties;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.Locale;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public final class zzatt {
    private float zzbrt;
    private int zzdpl;
    private int zzdpm;
    private int zzdwd;
    private boolean zzdwe;
    private boolean zzdwf;
    private String zzdwg;
    private String zzdwh;
    private boolean zzdwi;
    private final boolean zzdwj;
    private boolean zzdwk;
    private boolean zzdwl;
    private boolean zzdwm;
    private String zzdwn;
    private String zzdwo;
    private String zzdwp;
    private int zzdwq;
    private int zzdwr;
    private int zzdws;
    private int zzdwt;
    private int zzdwu;
    private int zzdwv;
    private double zzdww;
    private boolean zzdwx;
    private boolean zzdwy;
    private int zzdwz;
    private String zzdxa;
    private String zzdxb;
    private boolean zzdxc;

    public zzatt(Context context) {
        DisplayMetrics displayMetrics;
        PackageManager packageManager = context.getPackageManager();
        zzs(context);
        zzt(context);
        zzu(context);
        Locale locale = Locale.getDefault();
        boolean z = true;
        this.zzdwe = zza(packageManager, "geo:0,0?q=donuts") != null;
        this.zzdwf = zza(packageManager, "http://www.google.com") == null ? false : z;
        this.zzdwh = locale.getCountry();
        zzwq.zzqa();
        this.zzdwi = zzayr.zzzd();
        this.zzdwj = DeviceProperties.isLatchsky(context);
        this.zzdwk = DeviceProperties.isSidewinder(context);
        this.zzdwn = locale.getLanguage();
        this.zzdwo = zza(context, packageManager);
        this.zzdwp = zzv(context);
        Resources resources = context.getResources();
        if (resources != null && (displayMetrics = resources.getDisplayMetrics()) != null) {
            this.zzbrt = displayMetrics.density;
            this.zzdpl = displayMetrics.widthPixels;
            this.zzdpm = displayMetrics.heightPixels;
        }
    }

    public zzatt(Context context, zzatq zzatq) {
        zzs(context);
        zzt(context);
        zzu(context);
        this.zzdxa = Build.FINGERPRINT;
        this.zzdxb = Build.DEVICE;
        this.zzdxc = PlatformVersion.isAtLeastIceCreamSandwichMR1() && zzacf.zzj(context);
        this.zzdwe = zzatq.zzdwe;
        this.zzdwf = zzatq.zzdwf;
        this.zzdwh = zzatq.zzdwh;
        this.zzdwi = zzatq.zzdwi;
        this.zzdwj = zzatq.zzdwj;
        this.zzdwk = zzatq.zzdwk;
        this.zzdwn = zzatq.zzdwn;
        this.zzdwo = zzatq.zzdwo;
        this.zzdwp = zzatq.zzdwp;
        this.zzbrt = zzatq.zzbrt;
        this.zzdpl = zzatq.zzdpl;
        this.zzdpm = zzatq.zzdpm;
    }

    private static ResolveInfo zza(PackageManager packageManager, String str) {
        try {
            return packageManager.resolveActivity(new Intent("android.intent.action.VIEW", Uri.parse(str)), PKIFailureInfo.notAuthorized);
        } catch (Throwable th) {
            zzp.zzku().zza(th, "DeviceInfo.getResolveInfo");
            return null;
        }
    }

    private static String zza(Context context, PackageManager packageManager) {
        ActivityInfo activityInfo;
        ResolveInfo zza = zza(packageManager, "market://details?id=com.google.android.gms.ads");
        if (zza == null || (activityInfo = zza.activityInfo) == null) {
            return null;
        }
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo(activityInfo.packageName, 0);
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

    private final void zzs(Context context) {
        AudioManager audioManager = (AudioManager) context.getSystemService("audio");
        if (audioManager != null) {
            try {
                this.zzdwd = audioManager.getMode();
                this.zzdwl = audioManager.isMusicActive();
                this.zzdwm = audioManager.isSpeakerphoneOn();
                this.zzdwq = audioManager.getStreamVolume(3);
                this.zzdwu = audioManager.getRingerMode();
                this.zzdwv = audioManager.getStreamVolume(2);
                return;
            } catch (Throwable th) {
                zzp.zzku().zza(th, "DeviceInfo.gatherAudioInfo");
            }
        }
        this.zzdwd = -2;
        this.zzdwl = false;
        this.zzdwm = false;
        this.zzdwq = 0;
        this.zzdwu = 2;
        this.zzdwv = 0;
    }

    /* JADX WARNING: Removed duplicated region for block: B:14:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x0050  */
    @android.annotation.TargetApi(16)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzt(android.content.Context r6) {
        /*
            r5 = this;
            java.lang.String r0 = "phone"
            java.lang.Object r0 = r6.getSystemService(r0)
            android.telephony.TelephonyManager r0 = (android.telephony.TelephonyManager) r0
            java.lang.String r1 = "connectivity"
            java.lang.Object r1 = r6.getSystemService(r1)
            android.net.ConnectivityManager r1 = (android.net.ConnectivityManager) r1
            java.lang.String r2 = r0.getNetworkOperator()
            r5.zzdwg = r2
            boolean r2 = com.google.android.gms.common.util.PlatformVersion.isAtLeastR()
            r3 = 0
            if (r2 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabf.zzczg
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r2 = r4.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0031
            r2 = 0
            goto L_0x0035
        L_0x0031:
            int r2 = r0.getNetworkType()
        L_0x0035:
            r5.zzdws = r2
            int r0 = r0.getPhoneType()
            r5.zzdwt = r0
            r0 = -2
            r5.zzdwr = r0
            r5.zzdwy = r3
            r0 = -1
            r5.zzdwz = r0
            com.google.android.gms.ads.internal.zzp.zzkq()
            java.lang.String r2 = "android.permission.ACCESS_NETWORK_STATE"
            boolean r6 = com.google.android.gms.ads.internal.util.zzm.zzp(r6, r2)
            if (r6 == 0) goto L_0x006f
            android.net.NetworkInfo r6 = r1.getActiveNetworkInfo()
            if (r6 == 0) goto L_0x0067
            int r0 = r6.getType()
            r5.zzdwr = r0
            android.net.NetworkInfo$DetailedState r6 = r6.getDetailedState()
            int r6 = r6.ordinal()
            r5.zzdwz = r6
            goto L_0x0069
        L_0x0067:
            r5.zzdwr = r0
        L_0x0069:
            boolean r6 = r1.isActiveNetworkMetered()
            r5.zzdwy = r6
        L_0x006f:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzatt.zzt(android.content.Context):void");
    }

    private final void zzu(Context context) {
        Intent registerReceiver = context.registerReceiver((BroadcastReceiver) null, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        boolean z = false;
        if (registerReceiver != null) {
            int intExtra = registerReceiver.getIntExtra("status", -1);
            this.zzdww = (double) (((float) registerReceiver.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) / ((float) registerReceiver.getIntExtra("scale", -1)));
            if (intExtra == 2 || intExtra == 5) {
                z = true;
            }
            this.zzdwx = z;
            return;
        }
        this.zzdww = -1.0d;
        this.zzdwx = false;
    }

    private static String zzv(Context context) {
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context).getPackageInfo("com.android.vending", 128);
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

    public final zzatq zzvz() {
        return new zzatq(this.zzdwd, this.zzdwe, this.zzdwf, this.zzdwg, this.zzdwh, this.zzdwi, this.zzdwj, this.zzdwk, this.zzdwl, this.zzdwm, this.zzdwn, this.zzdwo, this.zzdwp, this.zzdwq, this.zzdwr, this.zzdws, this.zzdwt, this.zzdwu, this.zzdwv, this.zzbrt, this.zzdpl, this.zzdpm, this.zzdww, this.zzdwx, this.zzdwy, this.zzdwz, this.zzdxa, this.zzdxc, this.zzdxb);
    }
}
