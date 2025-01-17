package com.google.android.gms.measurement.internal;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.ProcessUtils;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.measurement.zzma;
import com.google.android.gms.internal.measurement.zzod;
import java.lang.reflect.InvocationTargetException;

public final class zzy extends zzgu {
    private Boolean zza;
    private zzaa zzb = zzab.zza;
    private Boolean zzc;

    zzy(zzgb zzgb) {
        super(zzgb);
    }

    private final int zza(String str, zzem<Integer> zzem, int i, int i2) {
        return Math.max(Math.min(zzb(str, zzem), i2), i);
    }

    private final String zza(String str, String str2) {
        String str3;
        zzez zzez;
        try {
            return (String) Class.forName("android.os.SystemProperties").getMethod("get", new Class[]{String.class, String.class}).invoke((Object) null, new Object[]{str, str2});
        } catch (ClassNotFoundException e) {
            e = e;
            zzez = zzq().zze();
            str3 = "Could not find SystemProperties class";
            zzez.zza(str3, e);
            return str2;
        } catch (NoSuchMethodException e2) {
            e = e2;
            zzez = zzq().zze();
            str3 = "Could not find SystemProperties.get() method";
            zzez.zza(str3, e);
            return str2;
        } catch (IllegalAccessException e3) {
            e = e3;
            zzez = zzq().zze();
            str3 = "Could not access SystemProperties.get()";
            zzez.zza(str3, e);
            return str2;
        } catch (InvocationTargetException e4) {
            e = e4;
            zzez = zzq().zze();
            str3 = "SystemProperties.get() threw an exception";
            zzez.zza(str3, e);
            return str2;
        }
    }

    public static long zzi() {
        return zzat.zzac.zza(null).longValue();
    }

    public static long zzj() {
        return zzat.zzc.zza(null).longValue();
    }

    @VisibleForTesting
    private final Bundle zzx() {
        try {
            if (zzm().getPackageManager() == null) {
                zzq().zze().zza("Failed to load metadata: PackageManager is null");
                return null;
            }
            ApplicationInfo applicationInfo = Wrappers.packageManager(zzm()).getApplicationInfo(zzm().getPackageName(), 128);
            if (applicationInfo != null) {
                return applicationInfo.metaData;
            }
            zzq().zze().zza("Failed to load metadata: ApplicationInfo is null");
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            zzq().zze().zza("Failed to load metadata: Package name not found", e);
            return null;
        }
    }

    public final int zza(String str) {
        return zza(str, zzat.zzah, 25, 100);
    }

    public final long zza(String str, zzem<Long> zzem) {
        if (str != null) {
            String zza2 = this.zzb.zza(str, zzem.zza());
            if (!TextUtils.isEmpty(zza2)) {
                try {
                    return zzem.zza(Long.valueOf(Long.parseLong(zza2))).longValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzem.zza(null).longValue();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:7:0x002d, code lost:
        if (android.text.TextUtils.isEmpty(r1) != false) goto L_0x002f;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.String zza(com.google.android.gms.measurement.internal.zzf r6) {
        /*
            r5 = this;
            android.net.Uri$Builder r0 = new android.net.Uri$Builder
            r0.<init>()
            java.lang.String r1 = r6.zze()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0033
            boolean r1 = com.google.android.gms.internal.measurement.zznq.zzb()
            if (r1 == 0) goto L_0x002f
            com.google.android.gms.measurement.internal.zzy r1 = r5.zzs()
            java.lang.String r2 = r6.zzc()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbj
            boolean r1 = r1.zzd(r2, r3)
            if (r1 == 0) goto L_0x002f
            java.lang.String r1 = r6.zzg()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 == 0) goto L_0x0033
        L_0x002f:
            java.lang.String r1 = r6.zzf()
        L_0x0033:
            com.google.android.gms.measurement.internal.zzem<java.lang.String> r2 = com.google.android.gms.measurement.internal.zzat.zzd
            r3 = 0
            java.lang.Object r2 = r2.zza(r3)
            java.lang.String r2 = (java.lang.String) r2
            android.net.Uri$Builder r2 = r0.scheme(r2)
            com.google.android.gms.measurement.internal.zzem<java.lang.String> r4 = com.google.android.gms.measurement.internal.zzat.zze
            java.lang.Object r3 = r4.zza(r3)
            java.lang.String r3 = (java.lang.String) r3
            android.net.Uri$Builder r2 = r2.encodedAuthority(r3)
            java.lang.String r3 = "config/app/"
            java.lang.String r1 = java.lang.String.valueOf(r1)
            int r4 = r1.length()
            if (r4 == 0) goto L_0x005d
            java.lang.String r1 = r3.concat(r1)
            goto L_0x0062
        L_0x005d:
            java.lang.String r1 = new java.lang.String
            r1.<init>(r3)
        L_0x0062:
            android.net.Uri$Builder r1 = r2.path(r1)
            java.lang.String r2 = "app_instance_id"
            java.lang.String r6 = r6.zzd()
            android.net.Uri$Builder r6 = r1.appendQueryParameter(r2, r6)
            java.lang.String r1 = "platform"
            java.lang.String r2 = "android"
            android.net.Uri$Builder r6 = r6.appendQueryParameter(r1, r2)
            java.lang.String r1 = "gmp_version"
            java.lang.String r2 = "31049"
            r6.appendQueryParameter(r1, r2)
            android.net.Uri r6 = r0.build()
            java.lang.String r6 = r6.toString()
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zza(com.google.android.gms.measurement.internal.zzf):java.lang.String");
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzaa zzaa) {
        this.zzb = zzaa;
    }

    public final boolean zza(zzem<Boolean> zzem) {
        return zzd((String) null, zzem);
    }

    /* access modifiers changed from: package-private */
    public final int zzb(String str) {
        if (!zzma.zzb() || !zzd((String) null, zzat.zzcd)) {
            return 500;
        }
        return zza(str, zzat.zzag, 500, 2000);
    }

    public final int zzb(String str, zzem<Integer> zzem) {
        if (str != null) {
            String zza2 = this.zzb.zza(str, zzem.zza());
            if (!TextUtils.isEmpty(zza2)) {
                try {
                    return zzem.zza(Integer.valueOf(Integer.parseInt(zza2))).intValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzem.zza(null).intValue();
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final double zzc(String str, zzem<Double> zzem) {
        if (str != null) {
            String zza2 = this.zzb.zza(str, zzem.zza());
            if (!TextUtils.isEmpty(zza2)) {
                try {
                    return zzem.zza(Double.valueOf(Double.parseDouble(zza2))).doubleValue();
                } catch (NumberFormatException unused) {
                }
            }
        }
        return zzem.zza(null).doubleValue();
    }

    public final int zzc(String str) {
        return zzb(str, zzat.zzn);
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final int zzd() {
        if (zzma.zzb() && zzs().zzd((String) null, zzat.zzce)) {
            zzkx zzo = zzo();
            Boolean zzaf = zzo.zzy.zzv().zzaf();
            if (zzo.zzi() >= 201500 || (zzaf != null && !zzaf.booleanValue())) {
                return 100;
            }
        }
        return 25;
    }

    /* access modifiers changed from: package-private */
    public final int zzd(String str) {
        if (!zzma.zzb() || !zzd((String) null, zzat.zzcd)) {
            return 25;
        }
        return zza(str, zzat.zzaf, 25, 100);
    }

    /* JADX WARNING: type inference failed for: r5v0, types: [com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>, com.google.android.gms.measurement.internal.zzem] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean zzd(java.lang.String r4, com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r5) {
        /*
            r3 = this;
            r0 = 0
            if (r4 != 0) goto L_0x000e
        L_0x0003:
            java.lang.Object r4 = r5.zza(r0)
        L_0x0007:
            java.lang.Boolean r4 = (java.lang.Boolean) r4
            boolean r4 = r4.booleanValue()
            return r4
        L_0x000e:
            com.google.android.gms.measurement.internal.zzaa r1 = r3.zzb
            java.lang.String r2 = r5.zza()
            java.lang.String r4 = r1.zza(r4, r2)
            boolean r1 = android.text.TextUtils.isEmpty(r4)
            if (r1 == 0) goto L_0x001f
            goto L_0x0003
        L_0x001f:
            boolean r4 = java.lang.Boolean.parseBoolean(r4)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r4)
            java.lang.Object r4 = r5.zza(r4)
            goto L_0x0007
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zzd(java.lang.String, com.google.android.gms.measurement.internal.zzem):boolean");
    }

    /* access modifiers changed from: package-private */
    public final long zze(String str) {
        return zza(str, zzat.zza);
    }

    public final boolean zze() {
        if (this.zzc == null) {
            synchronized (this) {
                if (this.zzc == null) {
                    ApplicationInfo applicationInfo = zzm().getApplicationInfo();
                    String myProcessName = ProcessUtils.getMyProcessName();
                    if (applicationInfo != null) {
                        String str = applicationInfo.processName;
                        this.zzc = Boolean.valueOf(str != null && str.equals(myProcessName));
                    }
                    if (this.zzc == null) {
                        this.zzc = Boolean.TRUE;
                        zzq().zze().zza("My process not in the list of running processes");
                    }
                }
            }
        }
        return this.zzc.booleanValue();
    }

    public final boolean zze(String str, zzem<Boolean> zzem) {
        return zzd(str, zzem);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final Boolean zzf(String str) {
        Preconditions.checkNotEmpty(str);
        Bundle zzx = zzx();
        if (zzx == null) {
            zzq().zze().zza("Failed to load metadata: Metadata bundle is null");
            return null;
        } else if (!zzx.containsKey(str)) {
            return null;
        } else {
            return Boolean.valueOf(zzx.getBoolean(str));
        }
    }

    public final boolean zzf() {
        Boolean zzf = zzf("firebase_analytics_collection_deactivated");
        return zzf != null && zzf.booleanValue();
    }

    public final Boolean zzg() {
        Boolean zzf = zzf("google_analytics_adid_collection_enabled");
        return Boolean.valueOf(zzf == null || zzf.booleanValue());
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:8:0x002a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002b A[SYNTHETIC, Splitter:B:9:0x002b] */
    @com.google.android.gms.common.util.VisibleForTesting
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.util.List<java.lang.String> zzg(java.lang.String r4) {
        /*
            r3 = this;
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r4)
            android.os.Bundle r0 = r3.zzx()
            r1 = 0
            if (r0 != 0) goto L_0x0019
            com.google.android.gms.measurement.internal.zzex r4 = r3.zzq()
            com.google.android.gms.measurement.internal.zzez r4 = r4.zze()
            java.lang.String r0 = "Failed to load metadata: Metadata bundle is null"
            r4.zza(r0)
        L_0x0017:
            r4 = r1
            goto L_0x0028
        L_0x0019:
            boolean r2 = r0.containsKey(r4)
            if (r2 != 0) goto L_0x0020
            goto L_0x0017
        L_0x0020:
            int r4 = r0.getInt(r4)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0028:
            if (r4 != 0) goto L_0x002b
            return r1
        L_0x002b:
            android.content.Context r0 = r3.zzm()     // Catch:{ NotFoundException -> 0x0043 }
            android.content.res.Resources r0 = r0.getResources()     // Catch:{ NotFoundException -> 0x0043 }
            int r4 = r4.intValue()     // Catch:{ NotFoundException -> 0x0043 }
            java.lang.String[] r4 = r0.getStringArray(r4)     // Catch:{ NotFoundException -> 0x0043 }
            if (r4 != 0) goto L_0x003e
            return r1
        L_0x003e:
            java.util.List r4 = java.util.Arrays.asList(r4)     // Catch:{ NotFoundException -> 0x0043 }
            return r4
        L_0x0043:
            r4 = move-exception
            com.google.android.gms.measurement.internal.zzex r0 = r3.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()
            java.lang.String r2 = "Failed to load string array from metadata: resource not found"
            r0.zza(r2, r4)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzy.zzg(java.lang.String):java.util.List");
    }

    public final Boolean zzh() {
        boolean z = true;
        if (!zzod.zzb() || !zza(zzat.zzbv)) {
            return true;
        }
        Boolean zzf = zzf("google_analytics_automatic_screen_reporting_enabled");
        if (zzf != null && !zzf.booleanValue()) {
            z = false;
        }
        return Boolean.valueOf(z);
    }

    public final boolean zzh(String str) {
        return "1".equals(this.zzb.zza(str, "gaia_collection_enabled"));
    }

    public final boolean zzi(String str) {
        return "1".equals(this.zzb.zza(str, "measurement.event_sampling_enabled"));
    }

    /* access modifiers changed from: package-private */
    public final boolean zzj(String str) {
        return zzd(str, zzat.zzaj);
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
    }

    /* access modifiers changed from: package-private */
    public final String zzk(String str) {
        zzem<String> zzem = zzat.zzak;
        return zzem.zza(str == null ? null : this.zzb.zza(str, zzem.zza()));
    }

    public final /* bridge */ /* synthetic */ Clock zzl() {
        return super.zzl();
    }

    public final /* bridge */ /* synthetic */ Context zzm() {
        return super.zzm();
    }

    public final /* bridge */ /* synthetic */ zzev zzn() {
        return super.zzn();
    }

    public final /* bridge */ /* synthetic */ zzkx zzo() {
        return super.zzo();
    }

    public final /* bridge */ /* synthetic */ zzfu zzp() {
        return super.zzp();
    }

    public final /* bridge */ /* synthetic */ zzex zzq() {
        return super.zzq();
    }

    public final /* bridge */ /* synthetic */ zzfj zzr() {
        return super.zzr();
    }

    public final /* bridge */ /* synthetic */ zzy zzs() {
        return super.zzs();
    }

    public final /* bridge */ /* synthetic */ zzx zzt() {
        return super.zzt();
    }

    public final String zzu() {
        return zza("debug.firebase.analytics.app", "");
    }

    public final String zzv() {
        return zza("debug.deferred.deeplink", "");
    }

    /* access modifiers changed from: package-private */
    public final boolean zzw() {
        if (this.zza == null) {
            this.zza = zzf("app_measurement_lite");
            if (this.zza == null) {
                this.zza = false;
            }
        }
        return this.zza.booleanValue() || !this.zzy.zzs();
    }
}
