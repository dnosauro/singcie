package com.google.android.gms.internal.ads;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.ArrayList;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzasn implements zzasr {
    private static final Object lock = new Object();
    @VisibleForTesting
    private static zzasr zzdsi = null;
    @VisibleForTesting
    private static zzasr zzdsj = null;
    private final Context zzcln;
    private final Object zzdsk;
    private final WeakHashMap<Thread, Boolean> zzdsl;
    private final zzazh zzdsm;
    private final ExecutorService zzyv;

    private zzasn(Context context) {
        this(context, zzazh.zzzi());
    }

    private zzasn(Context context, zzazh zzazh) {
        this.zzdsk = new Object();
        this.zzdsl = new WeakHashMap<>();
        this.zzyv = zzduo.zzayg().zzek(zzdut.zzhsl);
        this.zzcln = context.getApplicationContext() != null ? context.getApplicationContext() : context;
        this.zzdsm = zzazh;
    }

    @VisibleForTesting
    private final Uri.Builder zza(String str, String str2, String str3, int i) {
        boolean z;
        try {
            z = Wrappers.packageManager(this.zzcln).isCallerInstantApp();
        } catch (Throwable th) {
            zzaza.zzc("Error fetching instant app info", th);
            z = false;
        }
        String str4 = "unknown";
        try {
            str4 = this.zzcln.getPackageName();
        } catch (Throwable unused) {
            zzaza.zzfa("Cannot obtain package name, proceeding.");
        }
        Uri.Builder appendQueryParameter = new Uri.Builder().scheme("https").path("//pagead2.googlesyndication.com/pagead/gen_204").appendQueryParameter("is_aia", Boolean.toString(z)).appendQueryParameter("id", "gmob-apps-report-exception").appendQueryParameter("os", Build.VERSION.RELEASE).appendQueryParameter("api", String.valueOf(Build.VERSION.SDK_INT));
        String str5 = Build.MANUFACTURER;
        String str6 = Build.MODEL;
        if (!str6.startsWith(str5)) {
            StringBuilder sb = new StringBuilder(String.valueOf(str5).length() + 1 + String.valueOf(str6).length());
            sb.append(str5);
            sb.append(" ");
            sb.append(str6);
            str6 = sb.toString();
        }
        Uri.Builder appendQueryParameter2 = appendQueryParameter.appendQueryParameter("device", str6).appendQueryParameter("js", this.zzdsm.zzbrf).appendQueryParameter("appid", str4).appendQueryParameter("exceptiontype", str).appendQueryParameter("stacktrace", str2).appendQueryParameter("eids", TextUtils.join(",", zzabf.zzrl())).appendQueryParameter("exceptionkey", str3).appendQueryParameter("cl", "334274230").appendQueryParameter("rc", "dev").appendQueryParameter("session_id", zzwq.zzqf()).appendQueryParameter("sampling_rate", Integer.toString(i)).appendQueryParameter("pb_tm", String.valueOf(zzadg.zzddf.get()));
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcpz)).booleanValue()) {
            appendQueryParameter2.appendQueryParameter("gmscv", String.valueOf(GoogleApiAvailabilityLight.getInstance().getApkVersion(this.zzcln))).appendQueryParameter("lite", this.zzdsm.zzego ? "1" : "0");
        }
        return appendQueryParameter2;
    }

    public static zzasr zzc(Context context, zzazh zzazh) {
        synchronized (lock) {
            if (zzdsj == null) {
                if (zzadg.zzddh.get().booleanValue()) {
                    if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcyc)).booleanValue()) {
                        zzasn zzasn = new zzasn(context, zzazh);
                        Thread thread = Looper.getMainLooper().getThread();
                        if (thread != null) {
                            synchronized (zzasn.zzdsk) {
                                zzasn.zzdsl.put(thread, true);
                            }
                            thread.setUncaughtExceptionHandler(new zzaso(zzasn, thread.getUncaughtExceptionHandler()));
                        }
                        Thread.setDefaultUncaughtExceptionHandler(new zzasp(zzasn, Thread.getDefaultUncaughtExceptionHandler()));
                        zzdsj = zzasn;
                    }
                }
                zzdsj = new zzasq();
            }
        }
        return zzdsj;
    }

    public static zzasr zzq(Context context) {
        synchronized (lock) {
            if (zzdsi == null) {
                if (zzadg.zzddh.get().booleanValue()) {
                    if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcyc)).booleanValue()) {
                        zzdsi = new zzasn(context);
                    }
                }
                zzdsi = new zzasq();
            }
        }
        return zzdsi;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003f, code lost:
        if (r3 == false) goto L_0x0043;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.Thread r10, java.lang.Throwable r11) {
        /*
            r9 = this;
            r10 = 1
            r0 = 0
            if (r11 == 0) goto L_0x0042
            r1 = r11
            r2 = 0
            r3 = 0
        L_0x0007:
            if (r1 == 0) goto L_0x003d
            java.lang.StackTraceElement[] r4 = r1.getStackTrace()
            int r5 = r4.length
            r6 = r3
            r3 = r2
            r2 = 0
        L_0x0011:
            if (r2 >= r5) goto L_0x0036
            r7 = r4[r2]
            java.lang.String r8 = r7.getClassName()
            boolean r8 = com.google.android.gms.internal.ads.zzayr.zzeu(r8)
            if (r8 == 0) goto L_0x0020
            r3 = 1
        L_0x0020:
            java.lang.Class r8 = r9.getClass()
            java.lang.String r8 = r8.getName()
            java.lang.String r7 = r7.getClassName()
            boolean r7 = r8.equals(r7)
            if (r7 == 0) goto L_0x0033
            r6 = 1
        L_0x0033:
            int r2 = r2 + 1
            goto L_0x0011
        L_0x0036:
            java.lang.Throwable r1 = r1.getCause()
            r2 = r3
            r3 = r6
            goto L_0x0007
        L_0x003d:
            if (r2 == 0) goto L_0x0042
            if (r3 != 0) goto L_0x0042
            goto L_0x0043
        L_0x0042:
            r10 = 0
        L_0x0043:
            if (r10 == 0) goto L_0x004c
            java.lang.String r10 = ""
            r0 = 1065353216(0x3f800000, float:1.0)
            r9.zza(r11, r10, r0)
        L_0x004c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzasn.zza(java.lang.Thread, java.lang.Throwable):void");
    }

    public final void zza(Throwable th, String str) {
        zza(th, str, 1.0f);
    }

    public final void zza(Throwable th, String str, float f) {
        if (zzayr.zzd(th) != null) {
            String name = th.getClass().getName();
            StringWriter stringWriter = new StringWriter();
            zzeid.zza(th, new PrintWriter(stringWriter));
            String stringWriter2 = stringWriter.toString();
            int i = 0;
            int i2 = 1;
            boolean z = Math.random() < ((double) f);
            if (f > 0.0f) {
                i2 = (int) (1.0f / f);
            }
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.add(zza(name, stringWriter2, str, i2).toString());
                ArrayList arrayList2 = arrayList;
                int size = arrayList2.size();
                while (i < size) {
                    Object obj = arrayList2.get(i);
                    i++;
                    this.zzyv.execute(new zzasm(new zzaze(), (String) obj));
                }
            }
        }
    }
}
