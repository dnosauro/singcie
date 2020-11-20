package com.google.android.gms.measurement.internal;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

@TargetApi(14)
final class zzic implements Application.ActivityLifecycleCallbacks {
    private final /* synthetic */ zzhe zza;

    private zzic(zzhe zzhe) {
        this.zza = zzhe;
    }

    /* synthetic */ zzic(zzhe zzhe, zzhj zzhj) {
        this(zzhe);
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x009a A[Catch:{ Exception -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00ff A[Catch:{ Exception -> 0x01ee }] */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x0145 A[Catch:{ Exception -> 0x01ee }, RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x0146 A[Catch:{ Exception -> 0x01ee }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r8, android.net.Uri r9, java.lang.String r10, java.lang.String r11) {
        /*
            r7 = this;
            com.google.android.gms.measurement.internal.zzhe r0 = r7.zza
            r0.zzc()
            com.google.android.gms.measurement.internal.zzhe r0 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzs()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzbe     // Catch:{ Exception -> 0x01ee }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r1)     // Catch:{ Exception -> 0x01ee }
            r1 = 0
            if (r0 != 0) goto L_0x0033
            com.google.android.gms.measurement.internal.zzhe r0 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzs()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzbg     // Catch:{ Exception -> 0x01ee }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)     // Catch:{ Exception -> 0x01ee }
            if (r0 != 0) goto L_0x0033
            com.google.android.gms.measurement.internal.zzhe r0 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzy r0 = r0.zzs()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r2 = com.google.android.gms.measurement.internal.zzat.zzbf     // Catch:{ Exception -> 0x01ee }
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r2)     // Catch:{ Exception -> 0x01ee }
            if (r0 == 0) goto L_0x0031
            goto L_0x0033
        L_0x0031:
            r0 = r1
            goto L_0x0096
        L_0x0033:
            com.google.android.gms.measurement.internal.zzhe r0 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzkx r0 = r0.zzo()     // Catch:{ Exception -> 0x01ee }
            boolean r2 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x01ee }
            if (r2 == 0) goto L_0x0040
            goto L_0x0031
        L_0x0040:
            java.lang.String r2 = "gclid"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x01ee }
            if (r2 != 0) goto L_0x006e
            java.lang.String r2 = "utm_campaign"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x01ee }
            if (r2 != 0) goto L_0x006e
            java.lang.String r2 = "utm_source"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x01ee }
            if (r2 != 0) goto L_0x006e
            java.lang.String r2 = "utm_medium"
            boolean r2 = r11.contains(r2)     // Catch:{ Exception -> 0x01ee }
            if (r2 != 0) goto L_0x006e
            com.google.android.gms.measurement.internal.zzex r0 = r0.zzq()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzv()     // Catch:{ Exception -> 0x01ee }
            java.lang.String r2 = "Activity created with data 'referrer' without required params"
            r0.zza(r2)     // Catch:{ Exception -> 0x01ee }
            goto L_0x0031
        L_0x006e:
            java.lang.String r2 = "https://google.com/search?"
            java.lang.String r3 = java.lang.String.valueOf(r11)     // Catch:{ Exception -> 0x01ee }
            int r4 = r3.length()     // Catch:{ Exception -> 0x01ee }
            if (r4 == 0) goto L_0x007f
            java.lang.String r2 = r2.concat(r3)     // Catch:{ Exception -> 0x01ee }
            goto L_0x0085
        L_0x007f:
            java.lang.String r3 = new java.lang.String     // Catch:{ Exception -> 0x01ee }
            r3.<init>(r2)     // Catch:{ Exception -> 0x01ee }
            r2 = r3
        L_0x0085:
            android.net.Uri r2 = android.net.Uri.parse(r2)     // Catch:{ Exception -> 0x01ee }
            android.os.Bundle r0 = r0.zza((android.net.Uri) r2)     // Catch:{ Exception -> 0x01ee }
            if (r0 == 0) goto L_0x0096
            java.lang.String r2 = "_cis"
            java.lang.String r3 = "referrer"
            r0.putString(r2, r3)     // Catch:{ Exception -> 0x01ee }
        L_0x0096:
            r2 = 0
            r3 = 1
            if (r8 == 0) goto L_0x00ff
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzkx r8 = r8.zzo()     // Catch:{ Exception -> 0x01ee }
            android.os.Bundle r8 = r8.zza((android.net.Uri) r9)     // Catch:{ Exception -> 0x01ee }
            if (r8 == 0) goto L_0x0100
            java.lang.String r9 = "_cis"
            java.lang.String r4 = "intent"
            r8.putString(r9, r4)     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzhe r9 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zzs()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzbe     // Catch:{ Exception -> 0x01ee }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r4)     // Catch:{ Exception -> 0x01ee }
            if (r9 == 0) goto L_0x00e2
            java.lang.String r9 = "gclid"
            boolean r9 = r8.containsKey(r9)     // Catch:{ Exception -> 0x01ee }
            if (r9 != 0) goto L_0x00e2
            if (r0 == 0) goto L_0x00e2
            java.lang.String r9 = "gclid"
            boolean r9 = r0.containsKey(r9)     // Catch:{ Exception -> 0x01ee }
            if (r9 == 0) goto L_0x00e2
            java.lang.String r9 = "_cer"
            java.lang.String r4 = "gclid=%s"
            java.lang.Object[] r5 = new java.lang.Object[r3]     // Catch:{ Exception -> 0x01ee }
            java.lang.String r6 = "gclid"
            java.lang.String r6 = r0.getString(r6)     // Catch:{ Exception -> 0x01ee }
            r5[r2] = r6     // Catch:{ Exception -> 0x01ee }
            java.lang.String r4 = java.lang.String.format(r4, r5)     // Catch:{ Exception -> 0x01ee }
            r8.putString(r9, r4)     // Catch:{ Exception -> 0x01ee }
        L_0x00e2:
            com.google.android.gms.measurement.internal.zzhe r9 = r7.zza     // Catch:{ Exception -> 0x01ee }
            java.lang.String r4 = "_cmp"
            r9.zza((java.lang.String) r10, (java.lang.String) r4, (android.os.Bundle) r8)     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzhe r9 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zzs()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzck     // Catch:{ Exception -> 0x01ee }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r4)     // Catch:{ Exception -> 0x01ee }
            if (r9 == 0) goto L_0x0100
            com.google.android.gms.measurement.internal.zzhe r9 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzp r9 = r9.zzb     // Catch:{ Exception -> 0x01ee }
            r9.zza(r10, r8)     // Catch:{ Exception -> 0x01ee }
            goto L_0x0100
        L_0x00ff:
            r8 = r1
        L_0x0100:
            com.google.android.gms.measurement.internal.zzhe r9 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zzs()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzbg     // Catch:{ Exception -> 0x01ee }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r4)     // Catch:{ Exception -> 0x01ee }
            if (r9 == 0) goto L_0x013f
            com.google.android.gms.measurement.internal.zzhe r9 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzy r9 = r9.zzs()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzbf     // Catch:{ Exception -> 0x01ee }
            boolean r9 = r9.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r4)     // Catch:{ Exception -> 0x01ee }
            if (r9 != 0) goto L_0x013f
            if (r0 == 0) goto L_0x013f
            java.lang.String r9 = "gclid"
            boolean r9 = r0.containsKey(r9)     // Catch:{ Exception -> 0x01ee }
            if (r9 == 0) goto L_0x013f
            if (r8 == 0) goto L_0x0130
            java.lang.String r9 = "gclid"
            boolean r8 = r8.containsKey(r9)     // Catch:{ Exception -> 0x01ee }
            if (r8 != 0) goto L_0x013f
        L_0x0130:
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            java.lang.String r9 = "auto"
            java.lang.String r4 = "_lgclid"
            java.lang.String r5 = "gclid"
            java.lang.String r5 = r0.getString(r5)     // Catch:{ Exception -> 0x01ee }
            r8.zza((java.lang.String) r9, (java.lang.String) r4, (java.lang.Object) r5, (boolean) r3)     // Catch:{ Exception -> 0x01ee }
        L_0x013f:
            boolean r8 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x01ee }
            if (r8 == 0) goto L_0x0146
            return
        L_0x0146:
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzex r8 = r8.zzq()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzv()     // Catch:{ Exception -> 0x01ee }
            java.lang.String r9 = "Activity created with referrer"
            r8.zza(r9, r11)     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzy r8 = r8.zzs()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzat.zzbf     // Catch:{ Exception -> 0x01ee }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r9)     // Catch:{ Exception -> 0x01ee }
            if (r8 == 0) goto L_0x019b
            if (r0 == 0) goto L_0x0182
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            java.lang.String r9 = "_cmp"
            r8.zza((java.lang.String) r10, (java.lang.String) r9, (android.os.Bundle) r0)     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzy r8 = r8.zzs()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r9 = com.google.android.gms.measurement.internal.zzat.zzck     // Catch:{ Exception -> 0x01ee }
            boolean r8 = r8.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r9)     // Catch:{ Exception -> 0x01ee }
            if (r8 == 0) goto L_0x0191
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzp r8 = r8.zzb     // Catch:{ Exception -> 0x01ee }
            r8.zza(r10, r0)     // Catch:{ Exception -> 0x01ee }
            goto L_0x0191
        L_0x0182:
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzex r8 = r8.zzq()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzv()     // Catch:{ Exception -> 0x01ee }
            java.lang.String r9 = "Referrer does not contain valid parameters"
            r8.zza(r9, r11)     // Catch:{ Exception -> 0x01ee }
        L_0x0191:
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            java.lang.String r9 = "auto"
            java.lang.String r10 = "_ldl"
            r8.zza((java.lang.String) r9, (java.lang.String) r10, (java.lang.Object) r1, (boolean) r3)     // Catch:{ Exception -> 0x01ee }
            return
        L_0x019b:
            java.lang.String r8 = "gclid"
            boolean r8 = r11.contains(r8)     // Catch:{ Exception -> 0x01ee }
            if (r8 == 0) goto L_0x01cc
            java.lang.String r8 = "utm_campaign"
            boolean r8 = r11.contains(r8)     // Catch:{ Exception -> 0x01ee }
            if (r8 != 0) goto L_0x01cb
            java.lang.String r8 = "utm_source"
            boolean r8 = r11.contains(r8)     // Catch:{ Exception -> 0x01ee }
            if (r8 != 0) goto L_0x01cb
            java.lang.String r8 = "utm_medium"
            boolean r8 = r11.contains(r8)     // Catch:{ Exception -> 0x01ee }
            if (r8 != 0) goto L_0x01cb
            java.lang.String r8 = "utm_term"
            boolean r8 = r11.contains(r8)     // Catch:{ Exception -> 0x01ee }
            if (r8 != 0) goto L_0x01cb
            java.lang.String r8 = "utm_content"
            boolean r8 = r11.contains(r8)     // Catch:{ Exception -> 0x01ee }
            if (r8 == 0) goto L_0x01cc
        L_0x01cb:
            r2 = 1
        L_0x01cc:
            if (r2 != 0) goto L_0x01de
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzex r8 = r8.zzq()     // Catch:{ Exception -> 0x01ee }
            com.google.android.gms.measurement.internal.zzez r8 = r8.zzv()     // Catch:{ Exception -> 0x01ee }
            java.lang.String r9 = "Activity created with data 'referrer' without required params"
            r8.zza(r9)     // Catch:{ Exception -> 0x01ee }
            return
        L_0x01de:
            boolean r8 = android.text.TextUtils.isEmpty(r11)     // Catch:{ Exception -> 0x01ee }
            if (r8 != 0) goto L_0x01ed
            com.google.android.gms.measurement.internal.zzhe r8 = r7.zza     // Catch:{ Exception -> 0x01ee }
            java.lang.String r9 = "auto"
            java.lang.String r10 = "_ldl"
            r8.zza((java.lang.String) r9, (java.lang.String) r10, (java.lang.Object) r11, (boolean) r3)     // Catch:{ Exception -> 0x01ee }
        L_0x01ed:
            return
        L_0x01ee:
            r8 = move-exception
            com.google.android.gms.measurement.internal.zzhe r9 = r7.zza
            com.google.android.gms.measurement.internal.zzex r9 = r9.zzq()
            com.google.android.gms.measurement.internal.zzez r9 = r9.zze()
            java.lang.String r10 = "Throwable caught in handleReferrerForOnActivityCreated"
            r9.zza(r10, r8)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzic.zza(boolean, android.net.Uri, java.lang.String, java.lang.String):void");
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        try {
            this.zza.zzq().zzw().zza("onActivityCreated");
            Intent intent = activity.getIntent();
            if (intent != null) {
                Uri data = intent.getData();
                if (data != null) {
                    if (data.isHierarchical()) {
                        this.zza.zzo();
                        this.zza.zzp().zza((Runnable) new zzif(this, bundle == null, data, zzkx.zza(intent) ? "gs" : "auto", data.getQueryParameter("referrer")));
                    }
                }
            }
        } catch (Exception e) {
            this.zza.zzq().zze().zza("Throwable caught in onActivityCreated", e);
        } catch (Throwable th) {
            this.zza.zzh().zza(activity, bundle);
            throw th;
        }
        this.zza.zzh().zza(activity, bundle);
    }

    public final void onActivityDestroyed(Activity activity) {
        this.zza.zzh().zzc(activity);
    }

    public final void onActivityPaused(Activity activity) {
        this.zza.zzh().zzb(activity);
        zzkb zzj = this.zza.zzj();
        zzj.zzp().zza((Runnable) new zzkd(zzj, zzj.zzl().elapsedRealtime()));
    }

    public final void onActivityResumed(Activity activity) {
        zzkb zzj = this.zza.zzj();
        zzj.zzp().zza((Runnable) new zzka(zzj, zzj.zzl().elapsedRealtime()));
        this.zza.zzh().zza(activity);
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        this.zza.zzh().zzb(activity, bundle);
    }

    public final void onActivityStarted(Activity activity) {
    }

    public final void onActivityStopped(Activity activity) {
    }
}
