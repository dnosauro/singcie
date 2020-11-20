package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.lang.reflect.Method;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
public final class zzawx {
    private final AtomicReference<ExecutorService> zzdzn = new AtomicReference<>((Object) null);
    private final Object zzdzo = new Object();
    @GuardedBy("gmpAppIdLock")
    private String zzdzp = null;
    @GuardedBy("gmpAppIdLock")
    private String zzdzq = null;
    @VisibleForTesting
    private final AtomicBoolean zzdzr = new AtomicBoolean(false);
    private final AtomicInteger zzdzs = new AtomicInteger(-1);
    private final AtomicReference<Object> zzdzt = new AtomicReference<>((Object) null);
    private final AtomicReference<Object> zzdzu = new AtomicReference<>((Object) null);
    private final ConcurrentMap<String, Method> zzdzv = new ConcurrentHashMap(9);
    private final AtomicReference<zzbgf> zzdzw = new AtomicReference<>((Object) null);
    @GuardedBy("proxyReference")
    private final BlockingQueue<FutureTask<?>> zzdzx = new ArrayBlockingQueue(20);
    private final Object zzdzy = new Object();

    private final Object zza(String str, Context context) {
        if (!zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdzt, true)) {
            return null;
        }
        try {
            return zzl(context, str).invoke(this.zzdzt.get(), new Object[0]);
        } catch (Exception unused) {
            zzh(str, true);
            return null;
        }
    }

    private final <T> T zza(String str, T t, zzaxk<T> zzaxk) {
        synchronized (this.zzdzw) {
            if (this.zzdzw.get() != null) {
                try {
                    T zzb = zzaxk.zzb(this.zzdzw.get());
                    return zzb;
                } catch (Exception unused) {
                    zzh(str, false);
                    return t;
                }
            }
        }
    }

    private final void zza(Context context, String str, String str2) {
        if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdzt, true)) {
            Method zzk = zzk(context, str2);
            try {
                zzk.invoke(this.zzdzt.get(), new Object[]{str});
                StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 37 + String.valueOf(str).length());
                sb.append("Invoke Firebase method ");
                sb.append(str2);
                sb.append(", Ad Unit Id: ");
                sb.append(str);
                zzd.zzee(sb.toString());
            } catch (Exception unused) {
                zzh(str2, false);
            }
        }
    }

    private final void zza(Context context, String str, String str2, Bundle bundle) {
        if (zzz(context)) {
            Bundle zzl = zzl(str2, str);
            if (bundle != null) {
                zzl.putAll(bundle);
            }
            if (zzaa(context)) {
                zza("logEventInternal", (zzaxn) new zzawy(str, zzl));
            } else if (zza(context, "com.google.android.gms.measurement.AppMeasurement", this.zzdzt, true)) {
                Method zzag = zzag(context);
                try {
                    zzag.invoke(this.zzdzt.get(), new Object[]{"am", str, zzl});
                } catch (Exception unused) {
                    zzh("logEventInternal", true);
                }
            }
        }
    }

    private final void zza(String str, zzaxn zzaxn) {
        synchronized (this.zzdzw) {
            FutureTask futureTask = new FutureTask(new zzaxb(this, zzaxn, str), (Object) null);
            if (this.zzdzw.get() != null) {
                futureTask.run();
            } else {
                this.zzdzx.offer(futureTask);
            }
        }
    }

    private final boolean zza(Context context, String str, AtomicReference<Object> atomicReference, boolean z) {
        if (atomicReference.get() == null) {
            try {
                atomicReference.compareAndSet((Object) null, context.getClassLoader().loadClass(str).getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{context}));
            } catch (Exception unused) {
                zzh("getInstance", z);
                return false;
            }
        }
        return true;
    }

    @VisibleForTesting
    private static boolean zzaa(Context context) {
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcns)).booleanValue()) {
            return false;
        }
        if (DynamiteModule.getLocalVersion(context, ModuleDescriptor.MODULE_ID) < ((Integer) zzwq.zzqe().zzd(zzabf.zzcnt)).intValue()) {
            return false;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnu)).booleanValue()) {
            try {
                context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                return false;
            } catch (ClassNotFoundException unused) {
            }
        }
        return true;
    }

    private final Method zzag(Context context) {
        Method method = (Method) this.zzdzv.get("logEventInternal");
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod("logEventInternal", new Class[]{String.class, String.class, Bundle.class});
            this.zzdzv.put("logEventInternal", declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh("logEventInternal", true);
            return null;
        }
    }

    private final void zzh(String str, boolean z) {
        if (!this.zzdzr.get()) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 30);
            sb.append("Invoke Firebase method ");
            sb.append(str);
            sb.append(" error.");
            zzd.zzfa(sb.toString());
            if (z) {
                zzd.zzfa("The Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires the latest Firebase SDK jar, but Firebase SDK is either missing or out of date");
                this.zzdzr.set(true);
            }
        }
    }

    private final Method zzk(Context context, String str) {
        Method method = (Method) this.zzdzv.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[]{String.class});
            this.zzdzv.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private static Bundle zzl(String str, String str2) {
        Bundle bundle = new Bundle();
        try {
            bundle.putLong("_aeid", Long.parseLong(str));
        } catch (NullPointerException | NumberFormatException e) {
            String valueOf = String.valueOf(str);
            zzd.zzc(valueOf.length() != 0 ? "Invalid event ID: ".concat(valueOf) : new String("Invalid event ID: "), e);
        }
        if ("_ac".equals(str2)) {
            bundle.putInt("_r", 1);
        }
        return bundle;
    }

    private final Method zzl(Context context, String str) {
        Method method = (Method) this.zzdzv.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.android.gms.measurement.AppMeasurement").getDeclaredMethod(str, new Class[0]);
            this.zzdzv.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    private final Method zzm(Context context, String str) {
        Method method = (Method) this.zzdzv.get(str);
        if (method != null) {
            return method;
        }
        try {
            Method declaredMethod = context.getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics").getDeclaredMethod(str, new Class[]{Activity.class, String.class, String.class});
            this.zzdzv.put(str, declaredMethod);
            return declaredMethod;
        } catch (Exception unused) {
            zzh(str, false);
            return null;
        }
    }

    /* JADX WARNING: type inference failed for: r0v9, types: [java.util.concurrent.ExecutorService] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final java.util.concurrent.ExecutorService zzwj() {
        /*
            r9 = this;
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r0 = r9.zzdzn
            java.lang.Object r0 = r0.get()
            if (r0 != 0) goto L_0x0066
            boolean r0 = com.google.android.gms.common.util.ClientLibraryUtils.isPackageSide()
            if (r0 == 0) goto L_0x002d
            com.google.android.gms.internal.ads.zzdul r0 = com.google.android.gms.internal.ads.zzduo.zzayg()
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabf.zzcnr
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r1 = r1.intValue()
            java.util.concurrent.ThreadFactory r2 = r9.zzwk()
            int r3 = com.google.android.gms.internal.ads.zzdut.zzhsl
            java.util.concurrent.ExecutorService r0 = r0.zza(r1, r2, r3)
            goto L_0x0060
        L_0x002d:
            java.util.concurrent.ThreadPoolExecutor r0 = new java.util.concurrent.ThreadPoolExecutor
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabf.zzcnr
            com.google.android.gms.internal.ads.zzabb r2 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r1 = r2.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r2 = r1.intValue()
            com.google.android.gms.internal.ads.zzaaq<java.lang.Integer> r1 = com.google.android.gms.internal.ads.zzabf.zzcnr
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r1 = r3.zzd(r1)
            java.lang.Integer r1 = (java.lang.Integer) r1
            int r3 = r1.intValue()
            r4 = 1
            java.util.concurrent.TimeUnit r6 = java.util.concurrent.TimeUnit.MINUTES
            java.util.concurrent.LinkedBlockingQueue r7 = new java.util.concurrent.LinkedBlockingQueue
            r7.<init>()
            java.util.concurrent.ThreadFactory r8 = r9.zzwk()
            r1 = r0
            r1.<init>(r2, r3, r4, r6, r7, r8)
        L_0x0060:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r1 = r9.zzdzn
            r2 = 0
            r1.compareAndSet(r2, r0)
        L_0x0066:
            java.util.concurrent.atomic.AtomicReference<java.util.concurrent.ExecutorService> r0 = r9.zzdzn
            java.lang.Object r0 = r0.get()
            java.util.concurrent.ExecutorService r0 = (java.util.concurrent.ExecutorService) r0
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawx.zzwj():java.util.concurrent.ExecutorService");
    }

    private final ThreadFactory zzwk() {
        return new zzaxl(this);
    }

    public final void zza(Context context, zzaae zzaae) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnx)).booleanValue() && zzz(context) && zzaa(context)) {
            synchronized (this.zzdzy) {
            }
        }
    }

    public final void zza(Context context, zzvk zzvk) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnx)).booleanValue() && zzz(context) && zzaa(context)) {
            synchronized (this.zzdzy) {
            }
        }
    }

    public final void zza(Context context, String str, String str2, String str3, int i) {
        if (zzz(context)) {
            Bundle bundle = new Bundle();
            bundle.putString("_ai", str2);
            bundle.putString("reward_type", str3);
            bundle.putInt("reward_value", i);
            zza(context, "_ar", str, bundle);
            StringBuilder sb = new StringBuilder(String.valueOf(str3).length() + 75);
            sb.append("Log a Firebase reward video event, reward type: ");
            sb.append(str3);
            sb.append(", reward value: ");
            sb.append(i);
            zzd.zzee(sb.toString());
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzaxn zzaxn, String str) {
        if (this.zzdzw.get() != null) {
            try {
                zzaxn.zza(this.zzdzw.get());
            } catch (Exception unused) {
                zzh(str, false);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v9, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zzab(android.content.Context r5) {
        /*
            r4 = this;
            boolean r0 = r4.zzz(r5)
            if (r0 != 0) goto L_0x0009
            java.lang.String r5 = ""
            return r5
        L_0x0009:
            boolean r0 = zzaa(r5)
            if (r0 == 0) goto L_0x001c
            java.lang.String r5 = "getCurrentScreenNameOrScreenClass"
            java.lang.String r0 = ""
            com.google.android.gms.internal.ads.zzaxk r1 = com.google.android.gms.internal.ads.zzaxc.zzeaa
            java.lang.Object r5 = r4.zza((java.lang.String) r5, r0, r1)
            java.lang.String r5 = (java.lang.String) r5
            return r5
        L_0x001c:
            java.lang.String r0 = "com.google.android.gms.measurement.AppMeasurement"
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r4.zzdzt
            r2 = 1
            boolean r0 = r4.zza((android.content.Context) r5, (java.lang.String) r0, (java.util.concurrent.atomic.AtomicReference<java.lang.Object>) r1, (boolean) r2)
            if (r0 != 0) goto L_0x002a
            java.lang.String r5 = ""
            return r5
        L_0x002a:
            r0 = 0
            java.lang.String r1 = "getCurrentScreenName"
            java.lang.reflect.Method r1 = r4.zzl((android.content.Context) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x005c }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r2 = r4.zzdzt     // Catch:{ Exception -> 0x005c }
            java.lang.Object r2 = r2.get()     // Catch:{ Exception -> 0x005c }
            java.lang.Object[] r3 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x005c }
            java.lang.Object r1 = r1.invoke(r2, r3)     // Catch:{ Exception -> 0x005c }
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x005c }
            if (r1 != 0) goto L_0x0056
            java.lang.String r1 = "getCurrentScreenClass"
            java.lang.reflect.Method r5 = r4.zzl((android.content.Context) r5, (java.lang.String) r1)     // Catch:{ Exception -> 0x005c }
            java.util.concurrent.atomic.AtomicReference<java.lang.Object> r1 = r4.zzdzt     // Catch:{ Exception -> 0x005c }
            java.lang.Object r1 = r1.get()     // Catch:{ Exception -> 0x005c }
            java.lang.Object[] r2 = new java.lang.Object[r0]     // Catch:{ Exception -> 0x005c }
            java.lang.Object r5 = r5.invoke(r1, r2)     // Catch:{ Exception -> 0x005c }
            r1 = r5
            java.lang.String r1 = (java.lang.String) r1     // Catch:{ Exception -> 0x005c }
        L_0x0056:
            if (r1 == 0) goto L_0x0059
            return r1
        L_0x0059:
            java.lang.String r5 = ""
            return r5
        L_0x005c:
            java.lang.String r5 = "getCurrentScreenName"
            r4.zzh((java.lang.String) r5, (boolean) r0)
            java.lang.String r5 = ""
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawx.zzab(android.content.Context):java.lang.String");
    }

    public final String zzac(Context context) {
        if (!zzz(context)) {
            return null;
        }
        synchronized (this.zzdzo) {
            if (this.zzdzp != null) {
                String str = this.zzdzp;
                return str;
            }
            this.zzdzp = zzaa(context) ? (String) zza("getGmpAppId", this.zzdzp, zzaxe.zzeaa) : (String) zza("getGmpAppId", context);
            String str2 = this.zzdzp;
            return str2;
        }
    }

    public final String zzad(Context context) {
        if (!zzz(context)) {
            return null;
        }
        long longValue = ((Long) zzwq.zzqe().zzd(zzabf.zzcnq)).longValue();
        if (zzaa(context)) {
            if (longValue >= 0) {
                return (String) zzwj().submit(new zzaxg(this)).get(longValue, TimeUnit.MILLISECONDS);
            }
            try {
                return (String) zza("getAppInstanceId", (Object) null, zzaxh.zzeaa);
            } catch (TimeoutException unused) {
                return "TIME_OUT";
            } catch (Exception unused2) {
                return null;
            }
        } else if (longValue < 0) {
            return (String) zza("getAppInstanceId", context);
        } else {
            try {
                return (String) zzwj().submit(new zzaxj(this, context)).get(longValue, TimeUnit.MILLISECONDS);
            } catch (TimeoutException unused3) {
                return "TIME_OUT";
            } catch (Exception unused4) {
                return null;
            }
        }
    }

    public final String zzae(Context context) {
        if (!zzz(context)) {
            return null;
        }
        if (zzaa(context)) {
            Long l = (Long) zza("getAdEventId", (Object) null, zzaxi.zzeaa);
            if (l != null) {
                return Long.toString(l.longValue());
            }
            return null;
        }
        Object zza = zza("generateEventId", context);
        if (zza != null) {
            return zza.toString();
        }
        return null;
    }

    public final String zzaf(Context context) {
        if (!zzz(context)) {
            return null;
        }
        synchronized (this.zzdzo) {
            if (this.zzdzq != null) {
                String str = this.zzdzq;
                return str;
            }
            this.zzdzq = zzaa(context) ? (String) zza("getAppIdOrigin", this.zzdzq, zzawz.zzeaa) : "fa";
            String str2 = this.zzdzq;
            return str2;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzah(Context context) {
        return (String) zza("getAppInstanceId", context);
    }

    public final void zzd(Context context, String str) {
        if (zzz(context)) {
            if (zzaa(context)) {
                zza("beginAdUnitExposure", (zzaxn) new zzaww(str));
            } else {
                zza(context, str, "beginAdUnitExposure");
            }
        }
    }

    public final void zze(Context context, String str) {
        if (zzz(context)) {
            if (zzaa(context)) {
                zza("endAdUnitExposure", (zzaxn) new zzaxd(str));
            } else {
                zza(context, str, "endAdUnitExposure");
            }
        }
    }

    @Deprecated
    public final void zzf(Context context, String str) {
        if (!zzz(context) || !(context instanceof Activity)) {
            return;
        }
        if (zzaa(context)) {
            zza("setScreenName", (zzaxn) new zzaxf(context, str));
        } else if (zza(context, "com.google.firebase.analytics.FirebaseAnalytics", this.zzdzu, false)) {
            Method zzm = zzm(context, "setCurrentScreen");
            try {
                zzm.invoke(this.zzdzu.get(), new Object[]{(Activity) context, str, context.getPackageName()});
            } catch (Exception unused) {
                zzh("setCurrentScreen", false);
            }
        }
    }

    public final void zzg(Context context, String str) {
        zza(context, "_ac", str, (Bundle) null);
    }

    public final void zzh(Context context, String str) {
        zza(context, "_ai", str, (Bundle) null);
    }

    public final void zzi(Context context, String str) {
        zza(context, "_aq", str, (Bundle) null);
    }

    public final void zzj(Context context, String str) {
        zza(context, "_aa", str, (Bundle) null);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ String zzwl() {
        return (String) zza("getAppInstanceId", (Object) null, zzaxa.zzeaa);
    }

    public final boolean zzz(Context context) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnl)).booleanValue() && !this.zzdzr.get()) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnv)).booleanValue()) {
                return true;
            }
            if (this.zzdzs.get() == -1) {
                zzwq.zzqa();
                if (!zzayr.zzd(context, GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE)) {
                    zzwq.zzqa();
                    if (zzayr.zzbp(context)) {
                        zzd.zzfa("Google Play Service is out of date, the Google Mobile Ads SDK will not integrate with Firebase. Admob/Firebase integration requires updated Google Play Service.");
                        this.zzdzs.set(0);
                    }
                }
                this.zzdzs.set(1);
            }
            if (this.zzdzs.get() == 1) {
                return true;
            }
        }
        return false;
    }
}
