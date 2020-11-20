package com.google.android.gms.measurement.internal;

import android.content.Context;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zznq;
import com.google.android.gms.internal.measurement.zzpg;
import java.util.List;

public final class zzeq extends zzg {
    private String zza;
    private String zzb;
    private int zzc;
    private String zzd;
    private String zze;
    private long zzf;
    private long zzg;
    private List<String> zzh;
    private int zzi;
    private String zzj;
    private String zzk;
    private String zzl;

    zzeq(zzgb zzgb, long j) {
        super(zzgb);
        this.zzg = j;
    }

    @VisibleForTesting
    private final String zzah() {
        zzez zzi2;
        String str;
        if (!zzpg.zzb() || !zzs().zza(zzat.zzbm)) {
            try {
                Class<?> loadClass = zzm().getClassLoader().loadClass("com.google.firebase.analytics.FirebaseAnalytics");
                if (loadClass == null) {
                    return null;
                }
                try {
                    Object invoke = loadClass.getDeclaredMethod("getInstance", new Class[]{Context.class}).invoke((Object) null, new Object[]{zzm()});
                    if (invoke == null) {
                        return null;
                    }
                    try {
                        return (String) loadClass.getDeclaredMethod("getFirebaseInstanceId", new Class[0]).invoke(invoke, new Object[0]);
                    } catch (Exception unused) {
                        zzi2 = zzq().zzj();
                        str = "Failed to retrieve Firebase Instance Id";
                    }
                } catch (Exception unused2) {
                    zzi2 = zzq().zzi();
                    str = "Failed to obtain Firebase Analytics instance";
                }
            } catch (ClassNotFoundException unused3) {
                return null;
            }
        } else {
            zzi2 = zzq().zzw();
            str = "Disabled IID for tests.";
            zzi2.zza(str);
            return null;
        }
    }

    /* access modifiers changed from: package-private */
    public final zzn zza(String str) {
        zzc();
        String zzaa = zzaa();
        String zzab = zzab();
        zzv();
        String str2 = this.zzb;
        long zzae = (long) zzae();
        zzv();
        String str3 = this.zzd;
        zzv();
        zzc();
        if (this.zzf == 0) {
            this.zzf = this.zzy.zzh().zza(zzm(), zzm().getPackageName());
        }
        long j = this.zzf;
        boolean zzaa2 = this.zzy.zzaa();
        boolean z = !zzr().zzq;
        zzc();
        String zzah = !this.zzy.zzaa() ? null : zzah();
        zzgb zzgb = this.zzy;
        Long valueOf = Long.valueOf(zzgb.zzb().zzh.zza());
        long min = valueOf.longValue() == 0 ? zzgb.zza : Math.min(zzgb.zza, valueOf.longValue());
        int zzaf = zzaf();
        boolean booleanValue = zzs().zzg().booleanValue();
        Boolean zzf2 = zzs().zzf("google_analytics_ssaid_collection_enabled");
        boolean booleanValue2 = Boolean.valueOf(zzf2 == null || zzf2.booleanValue()).booleanValue();
        zzfj zzr = zzr();
        zzr.zzc();
        boolean z2 = zzr.zzf().getBoolean("deferred_analytics_collection", false);
        String zzac = zzac();
        Boolean zzf3 = zzs().zzf("google_analytics_default_allow_ad_personalization_signals");
        return new zzn(zzaa, zzab, str2, zzae, str3, 31049, j, str, zzaa2, z, zzah, 0, min, zzaf, booleanValue, booleanValue2, z2, zzac, zzf3 == null ? null : Boolean.valueOf(true ^ zzf3.booleanValue()), this.zzg, this.zzh, (!zznq.zzb() || !zzs().zza(zzat.zzbj)) ? null : zzad(), (!zzmb.zzb() || !zzs().zza(zzat.zzco)) ? "" : zzr().zzw().zza());
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: package-private */
    public final String zzaa() {
        zzv();
        return this.zza;
    }

    /* access modifiers changed from: package-private */
    public final String zzab() {
        zzv();
        return this.zzj;
    }

    /* access modifiers changed from: package-private */
    public final String zzac() {
        zzv();
        return this.zzk;
    }

    /* access modifiers changed from: package-private */
    public final String zzad() {
        zzv();
        return this.zzl;
    }

    /* access modifiers changed from: package-private */
    public final int zzae() {
        zzv();
        return this.zzc;
    }

    /* access modifiers changed from: package-private */
    public final int zzaf() {
        zzv();
        return this.zzi;
    }

    /* access modifiers changed from: package-private */
    public final List<String> zzag() {
        return this.zzh;
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final /* bridge */ /* synthetic */ zza zzd() {
        return super.zzd();
    }

    public final /* bridge */ /* synthetic */ zzhe zze() {
        return super.zze();
    }

    public final /* bridge */ /* synthetic */ zzeq zzf() {
        return super.zzf();
    }

    public final /* bridge */ /* synthetic */ zziv zzg() {
        return super.zzg();
    }

    public final /* bridge */ /* synthetic */ zzim zzh() {
        return super.zzh();
    }

    public final /* bridge */ /* synthetic */ zzet zzi() {
        return super.zzi();
    }

    public final /* bridge */ /* synthetic */ zzkb zzj() {
        return super.zzj();
    }

    public final /* bridge */ /* synthetic */ zzal zzk() {
        return super.zzk();
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

    /* access modifiers changed from: protected */
    public final boolean zzy() {
        return true;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:106:0x028e  */
    /* JADX WARNING: Removed duplicated region for block: B:109:0x0296  */
    /* JADX WARNING: Removed duplicated region for block: B:114:0x02a6  */
    /* JADX WARNING: Removed duplicated region for block: B:57:0x018d  */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x01a7 A[Catch:{ IllegalStateException -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x01b2 A[Catch:{ IllegalStateException -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x01bc A[Catch:{ IllegalStateException -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:68:0x01bf A[Catch:{ IllegalStateException -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x01d4 A[Catch:{ IllegalStateException -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:83:0x0204 A[Catch:{ IllegalStateException -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:87:0x021c A[Catch:{ IllegalStateException -> 0x0239 }] */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x025a  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzz() {
        /*
            r10 = this;
            java.lang.String r0 = "unknown"
            java.lang.String r1 = "Unknown"
            java.lang.String r2 = "Unknown"
            android.content.Context r3 = r10.zzm()
            java.lang.String r3 = r3.getPackageName()
            android.content.Context r4 = r10.zzm()
            android.content.pm.PackageManager r4 = r4.getPackageManager()
            r5 = 0
            r6 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r4 != 0) goto L_0x002d
            com.google.android.gms.measurement.internal.zzex r7 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r7 = r7.zze()
            java.lang.String r8 = "PackageManager is null, app identity information might be inaccurate. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r3)
            r7.zza(r8, r9)
            goto L_0x0086
        L_0x002d:
            java.lang.String r0 = r4.getInstallerPackageName(r3)     // Catch:{ IllegalArgumentException -> 0x0032 }
            goto L_0x0043
        L_0x0032:
            com.google.android.gms.measurement.internal.zzex r7 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r7 = r7.zze()
            java.lang.String r8 = "Error retrieving app installer package name. appId"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r3)
            r7.zza(r8, r9)
        L_0x0043:
            if (r0 != 0) goto L_0x0048
            java.lang.String r0 = "manual_install"
            goto L_0x0052
        L_0x0048:
            java.lang.String r7 = "com.android.vending"
            boolean r7 = r7.equals(r0)
            if (r7 == 0) goto L_0x0052
            java.lang.String r0 = ""
        L_0x0052:
            android.content.Context r7 = r10.zzm()     // Catch:{ NameNotFoundException -> 0x0075 }
            java.lang.String r7 = r7.getPackageName()     // Catch:{ NameNotFoundException -> 0x0075 }
            android.content.pm.PackageInfo r7 = r4.getPackageInfo(r7, r5)     // Catch:{ NameNotFoundException -> 0x0075 }
            if (r7 == 0) goto L_0x0086
            android.content.pm.ApplicationInfo r8 = r7.applicationInfo     // Catch:{ NameNotFoundException -> 0x0075 }
            java.lang.CharSequence r8 = r4.getApplicationLabel(r8)     // Catch:{ NameNotFoundException -> 0x0075 }
            boolean r9 = android.text.TextUtils.isEmpty(r8)     // Catch:{ NameNotFoundException -> 0x0075 }
            if (r9 != 0) goto L_0x0070
            java.lang.String r2 = r8.toString()     // Catch:{ NameNotFoundException -> 0x0075 }
        L_0x0070:
            java.lang.String r1 = r7.versionName     // Catch:{ NameNotFoundException -> 0x0075 }
            int r6 = r7.versionCode     // Catch:{ NameNotFoundException -> 0x0075 }
            goto L_0x0086
        L_0x0075:
            com.google.android.gms.measurement.internal.zzex r7 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r7 = r7.zze()
            java.lang.String r8 = "Error retrieving package info. appId, appName"
            java.lang.Object r9 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r3)
            r7.zza(r8, r9, r2)
        L_0x0086:
            r10.zza = r3
            r10.zzd = r0
            r10.zzb = r1
            r10.zzc = r6
            r10.zze = r2
            r0 = 0
            r10.zzf = r0
            android.content.Context r0 = r10.zzm()
            com.google.android.gms.common.api.Status r0 = com.google.android.gms.common.api.internal.GoogleServices.initialize(r0)
            r1 = 1
            if (r0 == 0) goto L_0x00a7
            boolean r2 = r0.isSuccess()
            if (r2 == 0) goto L_0x00a7
            r2 = 1
            goto L_0x00a8
        L_0x00a7:
            r2 = 0
        L_0x00a8:
            com.google.android.gms.measurement.internal.zzgb r6 = r10.zzy
            java.lang.String r6 = r6.zzn()
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            if (r6 != 0) goto L_0x00c4
            java.lang.String r6 = "am"
            com.google.android.gms.measurement.internal.zzgb r7 = r10.zzy
            java.lang.String r7 = r7.zzo()
            boolean r6 = r6.equals(r7)
            if (r6 == 0) goto L_0x00c4
            r6 = 1
            goto L_0x00c5
        L_0x00c4:
            r6 = 0
        L_0x00c5:
            r2 = r2 | r6
            if (r2 != 0) goto L_0x00f1
            if (r0 != 0) goto L_0x00d8
            com.google.android.gms.measurement.internal.zzex r0 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzf()
            java.lang.String r7 = "GoogleService failed to initialize (no status)"
            r0.zza(r7)
            goto L_0x00f1
        L_0x00d8:
            com.google.android.gms.measurement.internal.zzex r7 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r7 = r7.zzf()
            java.lang.String r8 = "GoogleService failed to initialize, status"
            int r9 = r0.getStatusCode()
            java.lang.Integer r9 = java.lang.Integer.valueOf(r9)
            java.lang.String r0 = r0.getStatusMessage()
            r7.zza(r8, r9, r0)
        L_0x00f1:
            if (r2 == 0) goto L_0x017e
            com.google.android.gms.measurement.internal.zzgb r0 = r10.zzy
            int r0 = r0.zzab()
            switch(r0) {
                case 0: goto L_0x016f;
                case 1: goto L_0x0164;
                case 2: goto L_0x0159;
                case 3: goto L_0x014e;
                case 4: goto L_0x0143;
                case 5: goto L_0x0138;
                case 6: goto L_0x012d;
                case 7: goto L_0x0122;
                case 8: goto L_0x0117;
                default: goto L_0x00fc;
            }
        L_0x00fc:
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzu()
            java.lang.String r7 = "App measurement disabled"
            r2.zza(r7)
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzf()
            java.lang.String r7 = "Invalid scion state in identity"
        L_0x0113:
            r2.zza(r7)
            goto L_0x017a
        L_0x0117:
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzu()
            java.lang.String r7 = "App measurement disabled due to denied storage consent"
            goto L_0x0113
        L_0x0122:
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzu()
            java.lang.String r7 = "App measurement disabled via the global data collection setting"
            goto L_0x0113
        L_0x012d:
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzj()
            java.lang.String r7 = "App measurement deactivated via resources. This method is being deprecated. Please refer to https://firebase.google.com/support/guides/disable-analytics"
            goto L_0x0113
        L_0x0138:
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzw()
            java.lang.String r7 = "App measurement disabled via the init parameters"
            goto L_0x0113
        L_0x0143:
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzu()
            java.lang.String r7 = "App measurement disabled via the manifest"
            goto L_0x0113
        L_0x014e:
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzu()
            java.lang.String r7 = "App measurement disabled by setAnalyticsCollectionEnabled(false)"
            goto L_0x0113
        L_0x0159:
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzw()
            java.lang.String r7 = "App measurement deactivated via the init parameters"
            goto L_0x0113
        L_0x0164:
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzu()
            java.lang.String r7 = "App measurement deactivated via the manifest"
            goto L_0x0113
        L_0x016f:
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzw()
            java.lang.String r7 = "App measurement collection enabled"
            goto L_0x0113
        L_0x017a:
            if (r0 != 0) goto L_0x017e
            r0 = 1
            goto L_0x017f
        L_0x017e:
            r0 = 0
        L_0x017f:
            java.lang.String r2 = ""
            r10.zzj = r2
            java.lang.String r2 = ""
            r10.zzk = r2
            java.lang.String r2 = ""
            r10.zzl = r2
            if (r6 == 0) goto L_0x0195
            com.google.android.gms.measurement.internal.zzgb r2 = r10.zzy
            java.lang.String r2 = r2.zzn()
            r10.zzk = r2
        L_0x0195:
            boolean r2 = com.google.android.gms.internal.measurement.zzpa.zzb()     // Catch:{ IllegalStateException -> 0x0239 }
            if (r2 == 0) goto L_0x01b2
            com.google.android.gms.measurement.internal.zzy r2 = r10.zzs()     // Catch:{ IllegalStateException -> 0x0239 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r6 = com.google.android.gms.measurement.internal.zzat.zzcj     // Catch:{ IllegalStateException -> 0x0239 }
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r6)     // Catch:{ IllegalStateException -> 0x0239 }
            if (r2 == 0) goto L_0x01b2
            android.content.Context r2 = r10.zzm()     // Catch:{ IllegalStateException -> 0x0239 }
            java.lang.String r6 = "google_app_id"
            java.lang.String r2 = com.google.android.gms.measurement.internal.zzik.zza(r2, r6)     // Catch:{ IllegalStateException -> 0x0239 }
            goto L_0x01b6
        L_0x01b2:
            java.lang.String r2 = com.google.android.gms.common.api.internal.GoogleServices.getGoogleAppId()     // Catch:{ IllegalStateException -> 0x0239 }
        L_0x01b6:
            boolean r6 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x0239 }
            if (r6 == 0) goto L_0x01bf
            java.lang.String r6 = ""
            goto L_0x01c0
        L_0x01bf:
            r6 = r2
        L_0x01c0:
            r10.zzj = r6     // Catch:{ IllegalStateException -> 0x0239 }
            boolean r6 = com.google.android.gms.internal.measurement.zznq.zzb()     // Catch:{ IllegalStateException -> 0x0239 }
            if (r6 == 0) goto L_0x0204
            com.google.android.gms.measurement.internal.zzy r6 = r10.zzs()     // Catch:{ IllegalStateException -> 0x0239 }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r7 = com.google.android.gms.measurement.internal.zzat.zzbj     // Catch:{ IllegalStateException -> 0x0239 }
            boolean r6 = r6.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r7)     // Catch:{ IllegalStateException -> 0x0239 }
            if (r6 == 0) goto L_0x0204
            com.google.android.gms.common.internal.StringResourceValueReader r6 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x0239 }
            android.content.Context r7 = r10.zzm()     // Catch:{ IllegalStateException -> 0x0239 }
            r6.<init>(r7)     // Catch:{ IllegalStateException -> 0x0239 }
            java.lang.String r7 = "ga_app_id"
            java.lang.String r7 = r6.getString(r7)     // Catch:{ IllegalStateException -> 0x0239 }
            boolean r8 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0239 }
            if (r8 == 0) goto L_0x01ec
            java.lang.String r8 = ""
            goto L_0x01ed
        L_0x01ec:
            r8 = r7
        L_0x01ed:
            r10.zzl = r8     // Catch:{ IllegalStateException -> 0x0239 }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x0239 }
            if (r2 == 0) goto L_0x01fb
            boolean r2 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0239 }
            if (r2 != 0) goto L_0x021a
        L_0x01fb:
            java.lang.String r2 = "admob_app_id"
            java.lang.String r2 = r6.getString(r2)     // Catch:{ IllegalStateException -> 0x0239 }
        L_0x0201:
            r10.zzk = r2     // Catch:{ IllegalStateException -> 0x0239 }
            goto L_0x021a
        L_0x0204:
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ IllegalStateException -> 0x0239 }
            if (r2 != 0) goto L_0x021a
            com.google.android.gms.common.internal.StringResourceValueReader r2 = new com.google.android.gms.common.internal.StringResourceValueReader     // Catch:{ IllegalStateException -> 0x0239 }
            android.content.Context r6 = r10.zzm()     // Catch:{ IllegalStateException -> 0x0239 }
            r2.<init>(r6)     // Catch:{ IllegalStateException -> 0x0239 }
            java.lang.String r6 = "admob_app_id"
            java.lang.String r2 = r2.getString(r6)     // Catch:{ IllegalStateException -> 0x0239 }
            goto L_0x0201
        L_0x021a:
            if (r0 == 0) goto L_0x024b
            com.google.android.gms.measurement.internal.zzex r0 = r10.zzq()     // Catch:{ IllegalStateException -> 0x0239 }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzw()     // Catch:{ IllegalStateException -> 0x0239 }
            java.lang.String r2 = "App measurement enabled for app package, google app id"
            java.lang.String r6 = r10.zza     // Catch:{ IllegalStateException -> 0x0239 }
            java.lang.String r7 = r10.zzj     // Catch:{ IllegalStateException -> 0x0239 }
            boolean r7 = android.text.TextUtils.isEmpty(r7)     // Catch:{ IllegalStateException -> 0x0239 }
            if (r7 == 0) goto L_0x0233
            java.lang.String r7 = r10.zzk     // Catch:{ IllegalStateException -> 0x0239 }
            goto L_0x0235
        L_0x0233:
            java.lang.String r7 = r10.zzj     // Catch:{ IllegalStateException -> 0x0239 }
        L_0x0235:
            r0.zza(r2, r6, r7)     // Catch:{ IllegalStateException -> 0x0239 }
            goto L_0x024b
        L_0x0239:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzex r2 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zze()
            java.lang.String r6 = "Fetching Google App Id failed with exception. appId"
            java.lang.Object r3 = com.google.android.gms.measurement.internal.zzex.zza((java.lang.String) r3)
            r2.zza(r6, r3, r0)
        L_0x024b:
            r0 = 0
            r10.zzh = r0
            com.google.android.gms.measurement.internal.zzy r0 = r10.zzs()
            java.lang.String r2 = "analytics.safelisted_events"
            java.util.List r0 = r0.zzg(r2)
            if (r0 == 0) goto L_0x028c
            int r2 = r0.size()
            if (r2 != 0) goto L_0x026f
            com.google.android.gms.measurement.internal.zzex r1 = r10.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzj()
            java.lang.String r2 = "Safelisted event list is empty. Ignoring"
            r1.zza(r2)
        L_0x026d:
            r1 = 0
            goto L_0x028c
        L_0x026f:
            java.util.Iterator r2 = r0.iterator()
        L_0x0273:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x028c
            java.lang.Object r3 = r2.next()
            java.lang.String r3 = (java.lang.String) r3
            com.google.android.gms.measurement.internal.zzkx r6 = r10.zzo()
            java.lang.String r7 = "safelisted event"
            boolean r3 = r6.zzb((java.lang.String) r7, (java.lang.String) r3)
            if (r3 != 0) goto L_0x0273
            goto L_0x026d
        L_0x028c:
            if (r1 == 0) goto L_0x0290
            r10.zzh = r0
        L_0x0290:
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 16
            if (r0 < r1) goto L_0x02a6
            if (r4 == 0) goto L_0x02a3
            android.content.Context r0 = r10.zzm()
            boolean r0 = com.google.android.gms.common.wrappers.InstantApps.isInstantApp(r0)
            r10.zzi = r0
            return
        L_0x02a3:
            r10.zzi = r5
            return
        L_0x02a6:
            r10.zzi = r5
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzeq.zzz():void");
    }
}
