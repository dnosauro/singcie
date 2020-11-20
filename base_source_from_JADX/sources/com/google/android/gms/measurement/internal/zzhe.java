package com.google.android.gms.measurement.internal;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.p018c.C0400a;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzlj;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzmt;
import com.google.android.gms.internal.measurement.zzne;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.AtomicReference;

public final class zzhe extends zzg {
    @VisibleForTesting
    protected zzic zza;
    final zzp zzb;
    private zzhd zzc;
    private final Set<zzhc> zzd = new CopyOnWriteArraySet();
    private boolean zze;
    private final AtomicReference<String> zzf = new AtomicReference<>();
    private final Object zzg = new Object();
    private zzad zzh = new zzad((Boolean) null, (Boolean) null);
    private int zzi = 100;
    private final AtomicLong zzj = new AtomicLong(0);
    private long zzk = -1;
    private int zzl = 100;
    @VisibleForTesting
    private boolean zzm = true;

    protected zzhe(zzgb zzgb) {
        super(zzgb);
        this.zzb = new zzp(zzgb);
    }

    /* access modifiers changed from: private */
    public final void zza(zzad zzad, int i, long j, boolean z, boolean z2) {
        zzc();
        zzv();
        if (j <= this.zzk && zzad.zza(this.zzl, i)) {
            zzq().zzu().zza("Dropped out-of-date consent setting, proposed settings", zzad);
        } else if (zzr().zza(zzad, i)) {
            this.zzk = j;
            this.zzl = i;
            zzg().zza(z);
            if (z2) {
                zzg().zza((AtomicReference<String>) new AtomicReference());
            }
        } else {
            zzq().zzu().zza("Lower precedence consent source ignored, proposed source", Integer.valueOf(i));
        }
    }

    /* access modifiers changed from: private */
    public final void zza(Boolean bool, boolean z) {
        zzc();
        zzv();
        zzq().zzv().zza("Setting app measurement enabled (FE)", bool);
        zzr().zza(bool);
        if (zzmb.zzb() && zzs().zza(zzat.zzco) && z) {
            zzr().zzb(bool);
        }
        if (!zzmb.zzb() || !zzs().zza(zzat.zzco) || this.zzy.zzac() || !bool.booleanValue()) {
            zzal();
        }
    }

    private final void zza(String str, String str2, long j, Object obj) {
        zzp().zza((Runnable) new zzhm(this, str, str2, obj, j));
    }

    /* access modifiers changed from: private */
    public final void zzal() {
        String str;
        String str2;
        Long valueOf;
        zzc();
        String zza2 = zzr().zzn.zza();
        if (zza2 != null) {
            if ("unset".equals(zza2)) {
                str = "app";
                str2 = "_npa";
                valueOf = null;
            } else {
                str = "app";
                str2 = "_npa";
                valueOf = Long.valueOf("true".equals(zza2) ? 1 : 0);
            }
            zza(str, str2, (Object) valueOf, zzl().currentTimeMillis());
        }
        if (!this.zzy.zzaa() || !this.zzm) {
            zzq().zzv().zza("Updating Scion state (FE)");
            zzg().zzab();
            return;
        }
        zzq().zzv().zza("Recording app launch after enabling measurement for the first time (FE)");
        zzah();
        if (zzne.zzb() && zzs().zza(zzat.zzbr)) {
            zzj().zza.zza();
        }
        if (zzmt.zzb() && zzs().zza(zzat.zzbu)) {
            if (!(this.zzy.zze().zza.zzb().zzi.zza() > 0)) {
                zzfo zze2 = this.zzy.zze();
                zze2.zza(zze2.zza.zzm().getPackageName());
            }
        }
        if (zzs().zza(zzat.zzck)) {
            zzp().zza((Runnable) new zzhi(this));
        }
    }

    @VisibleForTesting
    private final ArrayList<Bundle> zzb(String str, String str2, String str3) {
        if (zzp().zzf()) {
            zzq().zze().zza("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList<>(0);
        } else if (zzx.zza()) {
            zzq().zze().zza("Cannot get conditional user properties from main thread");
            return new ArrayList<>(0);
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, 5000, "get conditional user properties", new zzhv(this, atomicReference, str, str2, str3));
            List list = (List) atomicReference.get();
            if (list != null) {
                return zzkx.zzb((List<zzw>) list);
            }
            zzq().zze().zza("Timed out waiting for get conditional user properties", str);
            return new ArrayList<>();
        }
    }

    @VisibleForTesting
    private final Map<String, Object> zzb(String str, String str2, String str3, boolean z) {
        zzez zze2;
        String str4;
        if (zzp().zzf()) {
            zze2 = zzq().zze();
            str4 = "Cannot get user properties from analytics worker thread";
        } else if (zzx.zza()) {
            zze2 = zzq().zze();
            str4 = "Cannot get user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, 5000, "get user properties", new zzhu(this, atomicReference, str, str2, str3, z));
            List<zzkw> list = (List) atomicReference.get();
            if (list == null) {
                zzq().zze().zza("Timed out waiting for handle get user properties, includeInternal", Boolean.valueOf(z));
                return Collections.emptyMap();
            }
            C0400a aVar = new C0400a(list.size());
            for (zzkw zzkw : list) {
                aVar.put(zzkw.zza, zzkw.zza());
            }
            return aVar;
        }
        zze2.zza(str4);
        return Collections.emptyMap();
    }

    private final void zzb(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        zzgz.zza(bundle, "app_id", String.class, null);
        zzgz.zza(bundle, "origin", String.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.NAME, String.class, null);
        zzgz.zza(bundle, "value", Object.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME, String.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT, Long.class, 0L);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME, String.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS, Bundle.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME, String.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS, Bundle.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE, Long.class, 0L);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, String.class, null);
        zzgz.zza(bundle, AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, Bundle.class, null);
        Preconditions.checkNotEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle.getString("origin"));
        Preconditions.checkNotNull(bundle.get("value"));
        bundle.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, j);
        String string = bundle.getString(AppMeasurementSdk.ConditionalUserProperty.NAME);
        Object obj = bundle.get("value");
        if (zzo().zzb(string) != 0) {
            zzq().zze().zza("Invalid conditional user property name", zzn().zzc(string));
        } else if (zzo().zzb(string, obj) != 0) {
            zzq().zze().zza("Invalid conditional user property value", zzn().zzc(string), obj);
        } else {
            Object zzc2 = zzo().zzc(string, obj);
            if (zzc2 == null) {
                zzq().zze().zza("Unable to normalize conditional user property value", zzn().zzc(string), obj);
                return;
            }
            zzgz.zza(bundle, zzc2);
            long j2 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            if (TextUtils.isEmpty(bundle.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME)) || (j2 <= 15552000000L && j2 >= 1)) {
                long j3 = bundle.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
                if (j3 > 15552000000L || j3 < 1) {
                    zzq().zze().zza("Invalid conditional user property time to live", zzn().zzc(string), Long.valueOf(j3));
                } else {
                    zzp().zza((Runnable) new zzhq(this, bundle));
                }
            } else {
                zzq().zze().zza("Invalid conditional user property timeout", zzn().zzc(string), Long.valueOf(j2));
            }
        }
    }

    private final void zzb(String str, String str2, String str3, Bundle bundle) {
        long currentTimeMillis = zzl().currentTimeMillis();
        Preconditions.checkNotEmpty(str2);
        Bundle bundle2 = new Bundle();
        if (str != null) {
            bundle2.putString("app_id", str);
        }
        bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.NAME, str2);
        bundle2.putLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP, currentTimeMillis);
        if (str3 != null) {
            bundle2.putString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME, str3);
            bundle2.putBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS, bundle);
        }
        zzp().zza((Runnable) new zzhs(this, bundle2));
    }

    /* access modifiers changed from: private */
    public final void zzc(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzc();
        zzv();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        Preconditions.checkNotEmpty(bundle2.getString("origin"));
        Preconditions.checkNotNull(bundle2.get("value"));
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("Conditional property not set since app measurement is disabled");
            return;
        }
        zzkw zzkw = new zzkw(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_TIMESTAMP), bundle2.get("value"), bundle2.getString("origin"));
        try {
            zzar zza2 = zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TRIGGERED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlj.zzb() && zzs().zza(zzat.zzcr));
            zzar zza3 = zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.TIMED_OUT_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlj.zzb() && zzs().zza(zzat.zzcr));
            zzar zza4 = zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), 0, true, false, zzlj.zzb() && zzs().zza(zzat.zzcr));
            String string = bundle2.getString("app_id");
            String string2 = bundle2.getString("origin");
            long j = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP);
            String string3 = bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
            zzw zzw = r3;
            zzw zzw2 = new zzw(string, string2, zzkw, j, false, string3, zza3, j2, zza2, j3, zza4);
            zzg().zza(zzw);
        } catch (IllegalArgumentException unused) {
        }
    }

    /* access modifiers changed from: private */
    public final void zzd(Bundle bundle) {
        Bundle bundle2 = bundle;
        zzc();
        zzv();
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME));
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("Conditional property not cleared since app measurement is disabled");
            return;
        }
        zzkw zzkw = new zzkw(bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.NAME), 0, (Object) null, (String) null);
        try {
            zzar zza2 = zzo().zza(bundle2.getString("app_id"), bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_NAME), bundle2.getBundle(AppMeasurementSdk.ConditionalUserProperty.EXPIRED_EVENT_PARAMS), bundle2.getString("origin"), bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP), true, false, zzlj.zzb() && zzs().zza(zzat.zzcr));
            String string = bundle2.getString("app_id");
            String string2 = bundle2.getString("origin");
            long j = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.CREATION_TIMESTAMP);
            boolean z = bundle2.getBoolean(AppMeasurementSdk.ConditionalUserProperty.ACTIVE);
            String string3 = bundle2.getString(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_EVENT_NAME);
            long j2 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TRIGGER_TIMEOUT);
            long j3 = bundle2.getLong(AppMeasurementSdk.ConditionalUserProperty.TIME_TO_LIVE);
            zzw zzw = r3;
            zzw zzw2 = new zzw(string, string2, zzkw, j, z, string3, (zzar) null, j2, (zzar) null, j3, zza2);
            zzg().zza(zzw);
        } catch (IllegalArgumentException unused) {
        }
    }

    public final ArrayList<Bundle> zza(String str, String str2) {
        return zzb((String) null, str, str2);
    }

    public final ArrayList<Bundle> zza(String str, String str2, String str3) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3);
    }

    public final List<zzkw> zza(boolean z) {
        zzez zze2;
        String str;
        zzv();
        zzq().zzw().zza("Getting user properties (FE)");
        if (zzp().zzf()) {
            zze2 = zzq().zze();
            str = "Cannot get all user properties from analytics worker thread";
        } else if (zzx.zza()) {
            zze2 = zzq().zze();
            str = "Cannot get all user properties from main thread";
        } else {
            AtomicReference atomicReference = new AtomicReference();
            this.zzy.zzp().zza(atomicReference, 5000, "get user properties", new zzhp(this, atomicReference, z));
            List<zzkw> list = (List) atomicReference.get();
            if (list != null) {
                return list;
            }
            zzq().zze().zza("Timed out waiting for get user properties, includeInternal", Boolean.valueOf(z));
            return Collections.emptyList();
        }
        zze2.zza(str);
        return Collections.emptyList();
    }

    public final Map<String, Object> zza(String str, String str2, String str3, boolean z) {
        Preconditions.checkNotEmpty(str);
        zza();
        return zzb(str, str2, str3, z);
    }

    public final Map<String, Object> zza(String str, String str2, boolean z) {
        return zzb((String) null, str, str2, z);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    /* access modifiers changed from: package-private */
    public final void zza(long j, boolean z) {
        zzc();
        zzv();
        zzq().zzv().zza("Resetting analytics data (FE)");
        zzkb zzj2 = zzj();
        zzj2.zzc();
        zzj2.zzb.zza();
        boolean zzaa = this.zzy.zzaa();
        zzfj zzr = zzr();
        zzr.zzh.zza(j);
        if (!TextUtils.isEmpty(zzr.zzr().zzu.zza())) {
            zzr.zzu.zza((String) null);
        }
        if (zzne.zzb() && zzr.zzs().zza(zzat.zzbr)) {
            zzr.zzp.zza(0);
        }
        if (!zzr.zzs().zzf()) {
            zzr.zzb(!zzaa);
        }
        zzr.zzv.zza((String) null);
        zzr.zzw.zza(0);
        zzr.zzx.zza((Bundle) null);
        if (z) {
            zzg().zzac();
        }
        if (zzne.zzb() && zzs().zza(zzat.zzbr)) {
            zzj().zza.zza();
        }
        this.zzm = !zzaa;
    }

    public final void zza(Bundle bundle) {
        zza(bundle, zzl().currentTimeMillis());
    }

    public final void zza(Bundle bundle, long j) {
        Preconditions.checkNotNull(bundle);
        Bundle bundle2 = new Bundle(bundle);
        if (!TextUtils.isEmpty(bundle2.getString("app_id"))) {
            zzq().zzh().zza("Package name should be null when calling setConditionalUserProperty");
        }
        bundle2.remove("app_id");
        zzb(bundle2, j);
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzad zzad) {
        zzc();
        boolean z = (zzad.zze() && zzad.zzc()) || zzg().zzai();
        if (z != this.zzy.zzac()) {
            this.zzy.zzb(z);
            Boolean zzv = zzr().zzv();
            if (!z || zzv == null || zzv.booleanValue()) {
                zza(Boolean.valueOf(z), false);
            }
        }
    }

    public final void zza(zzad zzad, int i, long j) {
        boolean z;
        zzad zzad2;
        boolean z2;
        boolean z3;
        zzad zzad3 = zzad;
        if (zzmb.zzb() && zzs().zza(zzat.zzco)) {
            zzv();
            if (zzad.zzb() == null && zzad.zzd() == null) {
                zzq().zzj().zza("Discarding empty consent settings");
                return;
            }
            synchronized (this.zzg) {
                z = true;
                boolean z4 = false;
                if (zzad.zza(i, this.zzi)) {
                    z2 = zzad.zza(this.zzh);
                    if (zzad.zze() && !this.zzh.zze()) {
                        z4 = true;
                    }
                    zzad zzc2 = zzad.zzc(this.zzh);
                    this.zzh = zzc2;
                    boolean z5 = z4;
                    zzad2 = zzc2;
                    z3 = z5;
                } else {
                    zzad2 = zzad3;
                    z3 = false;
                    z2 = false;
                    z = false;
                }
            }
            if (!z) {
                zzq().zzu().zza("Ignoring lower-priority consent settings, proposed settings", zzad2);
                return;
            }
            long andIncrement = this.zzj.getAndIncrement();
            if (z2) {
                zza((String) null);
                zzp().zzb((Runnable) new zzib(this, zzad2, j, i, andIncrement, z3));
                return;
            }
            zzp().zza((Runnable) new zzia(this, zzad2, i, andIncrement, z3));
        }
    }

    public final void zza(zzhc zzhc) {
        zzv();
        Preconditions.checkNotNull(zzhc);
        if (!this.zzd.add(zzhc)) {
            zzq().zzh().zza("OnEventListener already registered");
        }
    }

    public final void zza(zzhd zzhd) {
        zzhd zzhd2;
        zzc();
        zzv();
        if (!(zzhd == null || zzhd == (zzhd2 = this.zzc))) {
            Preconditions.checkState(zzhd2 == null, "EventInterceptor already set.");
        }
        this.zzc = zzhd;
    }

    public final void zza(Boolean bool) {
        zzv();
        zzp().zza((Runnable) new zzhy(this, bool));
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str) {
        this.zzf.set(str);
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, long j, Bundle bundle) {
        zzc();
        zza(str, str2, j, bundle, true, this.zzc == null || zzkx.zzd(str2), false, (String) null);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:63:0x015c  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r27, java.lang.String r28, long r29, android.os.Bundle r31, boolean r32, boolean r33, boolean r34, java.lang.String r35) {
        /*
            r26 = this;
            r7 = r26
            r8 = r27
            r15 = r28
            r13 = r29
            r12 = r31
            com.google.android.gms.common.internal.Preconditions.checkNotEmpty(r27)
            com.google.android.gms.common.internal.Preconditions.checkNotNull(r31)
            r26.zzc()
            r26.zzv()
            com.google.android.gms.measurement.internal.zzgb r0 = r7.zzy
            boolean r0 = r0.zzaa()
            if (r0 != 0) goto L_0x002c
            com.google.android.gms.measurement.internal.zzex r0 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzv()
            java.lang.String r1 = "Event not sent since app measurement is disabled"
            r0.zza(r1)
            return
        L_0x002c:
            com.google.android.gms.measurement.internal.zzeq r0 = r26.zzf()
            java.util.List r0 = r0.zzag()
            if (r0 == 0) goto L_0x004a
            boolean r0 = r0.contains(r15)
            if (r0 != 0) goto L_0x004a
            com.google.android.gms.measurement.internal.zzex r0 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzv()
            java.lang.String r1 = "Dropping non-safelisted event. event name, origin"
            r0.zza(r1, r15, r8)
            return
        L_0x004a:
            boolean r0 = r7.zze
            r11 = 0
            r10 = 0
            r9 = 1
            if (r0 != 0) goto L_0x00a4
            r7.zze = r9
            com.google.android.gms.measurement.internal.zzgb r0 = r7.zzy     // Catch:{ ClassNotFoundException -> 0x0097 }
            boolean r0 = r0.zzs()     // Catch:{ ClassNotFoundException -> 0x0097 }
            if (r0 != 0) goto L_0x006a
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            android.content.Context r1 = r26.zzm()     // Catch:{ ClassNotFoundException -> 0x0097 }
            java.lang.ClassLoader r1 = r1.getClassLoader()     // Catch:{ ClassNotFoundException -> 0x0097 }
            java.lang.Class r0 = java.lang.Class.forName(r0, r9, r1)     // Catch:{ ClassNotFoundException -> 0x0097 }
            goto L_0x0070
        L_0x006a:
            java.lang.String r0 = "com.google.android.gms.tagmanager.TagManagerService"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ ClassNotFoundException -> 0x0097 }
        L_0x0070:
            java.lang.String r1 = "initialize"
            java.lang.Class[] r2 = new java.lang.Class[r9]     // Catch:{ Exception -> 0x0088 }
            java.lang.Class<android.content.Context> r3 = android.content.Context.class
            r2[r10] = r3     // Catch:{ Exception -> 0x0088 }
            java.lang.reflect.Method r0 = r0.getDeclaredMethod(r1, r2)     // Catch:{ Exception -> 0x0088 }
            java.lang.Object[] r1 = new java.lang.Object[r9]     // Catch:{ Exception -> 0x0088 }
            android.content.Context r2 = r26.zzm()     // Catch:{ Exception -> 0x0088 }
            r1[r10] = r2     // Catch:{ Exception -> 0x0088 }
            r0.invoke(r11, r1)     // Catch:{ Exception -> 0x0088 }
            goto L_0x00a4
        L_0x0088:
            r0 = move-exception
            com.google.android.gms.measurement.internal.zzex r1 = r26.zzq()     // Catch:{ ClassNotFoundException -> 0x0097 }
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzh()     // Catch:{ ClassNotFoundException -> 0x0097 }
            java.lang.String r2 = "Failed to invoke Tag Manager's initialize() method"
            r1.zza(r2, r0)     // Catch:{ ClassNotFoundException -> 0x0097 }
            goto L_0x00a4
        L_0x0097:
            com.google.android.gms.measurement.internal.zzex r0 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzu()
            java.lang.String r1 = "Tag Manager is not found and thus will not be used"
            r0.zza(r1)
        L_0x00a4:
            com.google.android.gms.measurement.internal.zzy r0 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzbe
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x00d7
            java.lang.String r0 = "_cmp"
            boolean r0 = r0.equals(r15)
            if (r0 == 0) goto L_0x00d7
            java.lang.String r0 = "gclid"
            boolean r0 = r12.containsKey(r0)
            if (r0 == 0) goto L_0x00d7
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_lgclid"
            java.lang.String r0 = "gclid"
            java.lang.String r4 = r12.getString(r0)
            com.google.android.gms.common.util.Clock r0 = r26.zzl()
            long r5 = r0.currentTimeMillis()
            r1 = r26
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
        L_0x00d7:
            boolean r0 = com.google.android.gms.internal.measurement.zznr.zzb()
            if (r0 == 0) goto L_0x0102
            com.google.android.gms.measurement.internal.zzy r0 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r1 = com.google.android.gms.measurement.internal.zzat.zzcg
            boolean r0 = r0.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r1)
            if (r0 == 0) goto L_0x0102
            if (r32 == 0) goto L_0x0102
            boolean r0 = com.google.android.gms.measurement.internal.zzkx.zzf(r28)
            if (r0 == 0) goto L_0x0102
            com.google.android.gms.measurement.internal.zzkx r0 = r26.zzo()
            com.google.android.gms.measurement.internal.zzfj r1 = r26.zzr()
            com.google.android.gms.measurement.internal.zzfk r1 = r1.zzx
            android.os.Bundle r1 = r1.zza()
            r0.zza((android.os.Bundle) r12, (android.os.Bundle) r1)
        L_0x0102:
            r0 = 40
            if (r34 == 0) goto L_0x018c
            java.lang.String r1 = "_iap"
            boolean r1 = r1.equals(r15)
            if (r1 != 0) goto L_0x018c
            com.google.android.gms.measurement.internal.zzgb r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkx r1 = r1.zzh()
            boolean r2 = com.google.android.gms.internal.measurement.zzlj.zzb()
            if (r2 == 0) goto L_0x0128
            com.google.android.gms.measurement.internal.zzy r2 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzcr
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x0128
            r2 = 1
            goto L_0x0129
        L_0x0128:
            r2 = 0
        L_0x0129:
            java.lang.String r3 = "event"
            boolean r3 = r1.zza((java.lang.String) r3, (java.lang.String) r15)
            r4 = 13
            r5 = 2
            if (r3 != 0) goto L_0x0136
        L_0x0134:
            r4 = 2
            goto L_0x015a
        L_0x0136:
            if (r2 == 0) goto L_0x0145
            java.lang.String r2 = "event"
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzgy.zza
            java.lang.String[] r6 = com.google.android.gms.measurement.internal.zzgy.zzb
            boolean r2 = r1.zza((java.lang.String) r2, (java.lang.String[]) r3, (java.lang.String[]) r6, (java.lang.String) r15)
            if (r2 != 0) goto L_0x0150
            goto L_0x015a
        L_0x0145:
            java.lang.String r2 = "event"
            java.lang.String[] r3 = com.google.android.gms.measurement.internal.zzgy.zza
            boolean r2 = r1.zza((java.lang.String) r2, (java.lang.String[]) r3, (java.lang.String) r15)
            if (r2 != 0) goto L_0x0150
            goto L_0x015a
        L_0x0150:
            java.lang.String r2 = "event"
            boolean r1 = r1.zza((java.lang.String) r2, (int) r0, (java.lang.String) r15)
            if (r1 != 0) goto L_0x0159
            goto L_0x0134
        L_0x0159:
            r4 = 0
        L_0x015a:
            if (r4 == 0) goto L_0x018c
            com.google.android.gms.measurement.internal.zzex r1 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzg()
            java.lang.String r2 = "Invalid public event name. Event will not be logged (FE)"
            com.google.android.gms.measurement.internal.zzev r3 = r26.zzn()
            java.lang.String r3 = r3.zza((java.lang.String) r15)
            r1.zza(r2, r3)
            com.google.android.gms.measurement.internal.zzgb r1 = r7.zzy
            r1.zzh()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzkx.zza((java.lang.String) r15, (int) r0, (boolean) r9)
            if (r15 == 0) goto L_0x0180
            int r10 = r28.length()
        L_0x0180:
            com.google.android.gms.measurement.internal.zzgb r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkx r1 = r1.zzh()
            java.lang.String r2 = "_ev"
            r1.zza((int) r4, (java.lang.String) r2, (java.lang.String) r0, (int) r10)
            return
        L_0x018c:
            com.google.android.gms.measurement.internal.zzim r1 = r26.zzh()
            com.google.android.gms.measurement.internal.zzin r1 = r1.zza((boolean) r10)
            if (r1 == 0) goto L_0x01a0
            java.lang.String r2 = "_sc"
            boolean r2 = r12.containsKey(r2)
            if (r2 != 0) goto L_0x01a0
            r1.zzd = r9
        L_0x01a0:
            if (r32 == 0) goto L_0x01a6
            if (r34 == 0) goto L_0x01a6
            r2 = 1
            goto L_0x01a7
        L_0x01a6:
            r2 = 0
        L_0x01a7:
            com.google.android.gms.measurement.internal.zzim.zza((com.google.android.gms.measurement.internal.zzin) r1, (android.os.Bundle) r12, (boolean) r2)
            java.lang.String r2 = "am"
            boolean r16 = r2.equals(r8)
            boolean r2 = com.google.android.gms.measurement.internal.zzkx.zzd(r28)
            if (r32 == 0) goto L_0x01e9
            com.google.android.gms.measurement.internal.zzhd r3 = r7.zzc
            if (r3 == 0) goto L_0x01e9
            if (r2 != 0) goto L_0x01e9
            if (r16 != 0) goto L_0x01e9
            com.google.android.gms.measurement.internal.zzex r0 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzv()
            java.lang.String r1 = "Passing event to registered event handler (FE)"
            com.google.android.gms.measurement.internal.zzev r2 = r26.zzn()
            java.lang.String r2 = r2.zza((java.lang.String) r15)
            com.google.android.gms.measurement.internal.zzev r3 = r26.zzn()
            java.lang.String r3 = r3.zza((android.os.Bundle) r12)
            r0.zza(r1, r2, r3)
            com.google.android.gms.measurement.internal.zzhd r1 = r7.zzc
            r2 = r27
            r3 = r28
            r4 = r31
            r5 = r29
            r1.interceptEvent(r2, r3, r4, r5)
            return
        L_0x01e9:
            com.google.android.gms.measurement.internal.zzgb r2 = r7.zzy
            boolean r2 = r2.zzaf()
            if (r2 != 0) goto L_0x01f2
            return
        L_0x01f2:
            com.google.android.gms.measurement.internal.zzkx r2 = r26.zzo()
            boolean r3 = com.google.android.gms.internal.measurement.zzlj.zzb()
            if (r3 == 0) goto L_0x020a
            com.google.android.gms.measurement.internal.zzy r3 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r4 = com.google.android.gms.measurement.internal.zzat.zzcr
            boolean r3 = r3.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r4)
            if (r3 == 0) goto L_0x020a
            r3 = 1
            goto L_0x020b
        L_0x020a:
            r3 = 0
        L_0x020b:
            int r2 = r2.zza((java.lang.String) r15, (boolean) r3)
            if (r2 == 0) goto L_0x024b
            com.google.android.gms.measurement.internal.zzex r1 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzg()
            java.lang.String r3 = "Invalid event name. Event will not be logged (FE)"
            com.google.android.gms.measurement.internal.zzev r4 = r26.zzn()
            java.lang.String r4 = r4.zza((java.lang.String) r15)
            r1.zza(r3, r4)
            r26.zzo()
            java.lang.String r0 = com.google.android.gms.measurement.internal.zzkx.zza((java.lang.String) r15, (int) r0, (boolean) r9)
            if (r15 == 0) goto L_0x0233
            int r10 = r28.length()
        L_0x0233:
            com.google.android.gms.measurement.internal.zzgb r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkx r1 = r1.zzh()
            java.lang.String r3 = "_ev"
            r27 = r1
            r28 = r35
            r29 = r2
            r30 = r3
            r31 = r0
            r32 = r10
            r27.zza((java.lang.String) r28, (int) r29, (java.lang.String) r30, (java.lang.String) r31, (int) r32)
            return
        L_0x024b:
            java.lang.String r0 = "_o"
            java.lang.String r2 = "_sn"
            java.lang.String r3 = "_sc"
            java.lang.String r4 = "_si"
            java.lang.String[] r0 = new java.lang.String[]{r0, r2, r3, r4}
            java.util.List r0 = com.google.android.gms.common.util.CollectionUtils.listOf((T[]) r0)
            com.google.android.gms.measurement.internal.zzkx r2 = r26.zzo()
            r3 = 1
            r5 = 1
            r9 = r2
            r6 = 0
            r10 = r35
            r2 = r11
            r11 = r28
            r12 = r31
            r4 = r13
            r13 = r0
            r14 = r34
            r15 = r3
            android.os.Bundle r15 = r9.zza((java.lang.String) r10, (java.lang.String) r11, (android.os.Bundle) r12, (java.util.List<java.lang.String>) r13, (boolean) r14, (boolean) r15)
            if (r15 == 0) goto L_0x02a6
            java.lang.String r3 = "_sc"
            boolean r3 = r15.containsKey(r3)
            if (r3 == 0) goto L_0x02a6
            java.lang.String r3 = "_si"
            boolean r3 = r15.containsKey(r3)
            if (r3 != 0) goto L_0x0286
            goto L_0x02a6
        L_0x0286:
            java.lang.String r3 = "_sn"
            java.lang.String r3 = r15.getString(r3)
            java.lang.String r9 = "_sc"
            java.lang.String r9 = r15.getString(r9)
            java.lang.String r10 = "_si"
            long r10 = r15.getLong(r10)
            java.lang.Long r10 = java.lang.Long.valueOf(r10)
            com.google.android.gms.measurement.internal.zzin r11 = new com.google.android.gms.measurement.internal.zzin
            long r12 = r10.longValue()
            r11.<init>(r3, r9, r12)
            goto L_0x02a7
        L_0x02a6:
            r11 = r2
        L_0x02a7:
            if (r11 != 0) goto L_0x02ab
            r14 = r1
            goto L_0x02ac
        L_0x02ab:
            r14 = r11
        L_0x02ac:
            com.google.android.gms.measurement.internal.zzy r1 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzat
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            r9 = 0
            if (r1 == 0) goto L_0x02e4
            com.google.android.gms.measurement.internal.zzim r1 = r26.zzh()
            com.google.android.gms.measurement.internal.zzin r1 = r1.zza((boolean) r6)
            if (r1 == 0) goto L_0x02e4
            java.lang.String r1 = "_ae"
            r13 = r28
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x02e6
            com.google.android.gms.measurement.internal.zzkb r1 = r26.zzj()
            com.google.android.gms.measurement.internal.zzkh r1 = r1.zzb
            long r11 = r1.zzb()
            int r1 = (r11 > r9 ? 1 : (r11 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x02e6
            com.google.android.gms.measurement.internal.zzkx r1 = r26.zzo()
            r1.zza((android.os.Bundle) r15, (long) r11)
            goto L_0x02e6
        L_0x02e4:
            r13 = r28
        L_0x02e6:
            boolean r1 = com.google.android.gms.internal.measurement.zzmn.zzb()
            if (r1 == 0) goto L_0x036b
            com.google.android.gms.measurement.internal.zzy r1 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbq
            boolean r1 = r1.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r1 == 0) goto L_0x036b
            java.lang.String r1 = "auto"
            boolean r1 = r1.equals(r8)
            if (r1 != 0) goto L_0x034a
            java.lang.String r1 = "_ssr"
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x034a
            com.google.android.gms.measurement.internal.zzkx r1 = r26.zzo()
            java.lang.String r3 = "_ffr"
            java.lang.String r3 = r15.getString(r3)
            boolean r11 = com.google.android.gms.common.util.Strings.isEmptyOrWhitespace(r3)
            if (r11 == 0) goto L_0x031a
            r11 = r2
            goto L_0x031e
        L_0x031a:
            java.lang.String r11 = r3.trim()
        L_0x031e:
            com.google.android.gms.measurement.internal.zzfj r2 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfp r2 = r2.zzu
            java.lang.String r2 = r2.zza()
            boolean r2 = com.google.android.gms.measurement.internal.zzkx.zzc((java.lang.String) r11, (java.lang.String) r2)
            if (r2 == 0) goto L_0x033d
            com.google.android.gms.measurement.internal.zzex r1 = r1.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzv()
            java.lang.String r2 = "Not logging duplicate session_start_with_rollout event"
            r1.zza(r2)
            r1 = 0
            goto L_0x0347
        L_0x033d:
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfp r1 = r1.zzu
            r1.zza(r11)
            r1 = 1
        L_0x0347:
            if (r1 != 0) goto L_0x036b
            return
        L_0x034a:
            java.lang.String r1 = "_ae"
            boolean r1 = r1.equals(r13)
            if (r1 == 0) goto L_0x036b
            com.google.android.gms.measurement.internal.zzkx r1 = r26.zzo()
            com.google.android.gms.measurement.internal.zzfj r1 = r1.zzr()
            com.google.android.gms.measurement.internal.zzfp r1 = r1.zzu
            java.lang.String r1 = r1.zza()
            boolean r2 = android.text.TextUtils.isEmpty(r1)
            if (r2 != 0) goto L_0x036b
            java.lang.String r2 = "_ffr"
            r15.putString(r2, r1)
        L_0x036b:
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r12.add(r15)
            com.google.android.gms.measurement.internal.zzkx r1 = r26.zzo()
            java.security.SecureRandom r1 = r1.zzg()
            long r2 = r1.nextLong()
            com.google.android.gms.measurement.internal.zzfj r1 = r26.zzr()
            com.google.android.gms.measurement.internal.zzfn r1 = r1.zzp
            long r17 = r1.zza()
            int r1 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1))
            if (r1 <= 0) goto L_0x03f1
            com.google.android.gms.measurement.internal.zzfj r1 = r26.zzr()
            boolean r1 = r1.zza((long) r4)
            if (r1 == 0) goto L_0x03f1
            com.google.android.gms.measurement.internal.zzfj r1 = r26.zzr()
            com.google.android.gms.measurement.internal.zzfl r1 = r1.zzr
            boolean r1 = r1.zza()
            if (r1 == 0) goto L_0x03f1
            com.google.android.gms.measurement.internal.zzex r1 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            java.lang.String r11 = "Current session is expired, remove the session number, ID, and engagement time"
            r1.zza(r11)
            java.lang.String r11 = "auto"
            java.lang.String r17 = "_sid"
            r18 = 0
            com.google.android.gms.common.util.Clock r1 = r26.zzl()
            long r19 = r1.currentTimeMillis()
            r1 = r26
            r21 = r2
            r2 = r11
            r3 = r17
            r4 = r18
            r11 = 1
            r5 = r19
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_sno"
            r4 = 0
            com.google.android.gms.common.util.Clock r1 = r26.zzl()
            long r5 = r1.currentTimeMillis()
            r1 = r26
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            java.lang.String r2 = "auto"
            java.lang.String r3 = "_se"
            com.google.android.gms.common.util.Clock r1 = r26.zzl()
            long r5 = r1.currentTimeMillis()
            r1 = r26
            r1.zza((java.lang.String) r2, (java.lang.String) r3, (java.lang.Object) r4, (long) r5)
            goto L_0x03f4
        L_0x03f1:
            r21 = r2
            r11 = 1
        L_0x03f4:
            java.lang.String r1 = "extend_session"
            long r1 = r15.getLong(r1, r9)
            r3 = 1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x041b
            com.google.android.gms.measurement.internal.zzex r1 = r26.zzq()
            com.google.android.gms.measurement.internal.zzez r1 = r1.zzw()
            java.lang.String r2 = "EXTEND_SESSION param attached: initiate a new session or extend the current active session"
            r1.zza(r2)
            com.google.android.gms.measurement.internal.zzgb r1 = r7.zzy
            com.google.android.gms.measurement.internal.zzkb r1 = r1.zzd()
            com.google.android.gms.measurement.internal.zzkj r1 = r1.zza
            r5 = r29
            r1.zza(r5, r11)
            goto L_0x041d
        L_0x041b:
            r5 = r29
        L_0x041d:
            java.util.Set r1 = r15.keySet()
            int r2 = r15.size()
            java.lang.String[] r2 = new java.lang.String[r2]
            java.lang.Object[] r1 = r1.toArray(r2)
            java.lang.String[] r1 = (java.lang.String[]) r1
            java.util.Arrays.sort(r1)
            boolean r2 = com.google.android.gms.internal.measurement.zzmh.zzb()
            if (r2 == 0) goto L_0x046b
            com.google.android.gms.measurement.internal.zzy r2 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzca
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x046b
            com.google.android.gms.measurement.internal.zzy r2 = r26.zzs()
            com.google.android.gms.measurement.internal.zzem<java.lang.Boolean> r3 = com.google.android.gms.measurement.internal.zzat.zzbz
            boolean r2 = r2.zza((com.google.android.gms.measurement.internal.zzem<java.lang.Boolean>) r3)
            if (r2 == 0) goto L_0x046b
            int r0 = r1.length
            r2 = 0
        L_0x0450:
            if (r2 >= r0) goto L_0x0467
            r3 = r1[r2]
            r26.zzo()
            java.lang.Object r4 = r15.get(r3)
            android.os.Bundle[] r4 = com.google.android.gms.measurement.internal.zzkx.zzb((java.lang.Object) r4)
            if (r4 == 0) goto L_0x0464
            r15.putParcelableArray(r3, r4)
        L_0x0464:
            int r2 = r2 + 1
            goto L_0x0450
        L_0x0467:
            r10 = r12
            r1 = r13
            goto L_0x0529
        L_0x046b:
            int r2 = r1.length
            r3 = 0
            r4 = 0
        L_0x046e:
            if (r3 >= r2) goto L_0x0518
            r10 = r1[r3]
            java.lang.Object r9 = r15.get(r10)
            r26.zzo()
            android.os.Bundle[] r9 = com.google.android.gms.measurement.internal.zzkx.zzb((java.lang.Object) r9)
            if (r9 == 0) goto L_0x04f9
            int r11 = r9.length
            r15.putInt(r10, r11)
            r31 = r1
            r11 = 0
        L_0x0486:
            int r1 = r9.length
            if (r11 >= r1) goto L_0x04ea
            r1 = r9[r11]
            r17 = r2
            r2 = 1
            com.google.android.gms.measurement.internal.zzim.zza((com.google.android.gms.measurement.internal.zzin) r14, (android.os.Bundle) r1, (boolean) r2)
            com.google.android.gms.measurement.internal.zzkx r18 = r26.zzo()
            java.lang.String r19 = "_ep"
            r20 = 0
            r2 = r9
            r9 = r18
            r23 = r10
            r10 = r35
            r24 = r11
            r11 = r19
            r25 = r12
            r12 = r1
            r1 = r13
            r13 = r0
            r18 = r14
            r14 = r34
            r32 = r0
            r0 = r15
            r15 = r20
            android.os.Bundle r9 = r9.zza((java.lang.String) r10, (java.lang.String) r11, (android.os.Bundle) r12, (java.util.List<java.lang.String>) r13, (boolean) r14, (boolean) r15)
            java.lang.String r10 = "_en"
            r9.putString(r10, r1)
            java.lang.String r10 = "_eid"
            r11 = r21
            r9.putLong(r10, r11)
            java.lang.String r10 = "_gn"
            r13 = r23
            r9.putString(r10, r13)
            java.lang.String r10 = "_ll"
            int r14 = r2.length
            r9.putInt(r10, r14)
            java.lang.String r10 = "_i"
            r14 = r24
            r9.putInt(r10, r14)
            r10 = r25
            r10.add(r9)
            int r9 = r14 + 1
            r15 = r0
            r14 = r18
            r0 = r32
            r11 = r9
            r12 = r10
            r10 = r13
            r13 = r1
            r9 = r2
            r2 = r17
            goto L_0x0486
        L_0x04ea:
            r32 = r0
            r17 = r2
            r2 = r9
            r10 = r12
            r1 = r13
            r18 = r14
            r0 = r15
            r11 = r21
            int r2 = r2.length
            int r4 = r4 + r2
            goto L_0x0506
        L_0x04f9:
            r32 = r0
            r31 = r1
            r17 = r2
            r10 = r12
            r1 = r13
            r18 = r14
            r0 = r15
            r11 = r21
        L_0x0506:
            int r3 = r3 + 1
            r15 = r0
            r13 = r1
            r21 = r11
            r2 = r17
            r14 = r18
            r11 = 1
            r1 = r31
            r0 = r32
            r12 = r10
            goto L_0x046e
        L_0x0518:
            r10 = r12
            r1 = r13
            r0 = r15
            r11 = r21
            if (r4 == 0) goto L_0x0529
            java.lang.String r2 = "_eid"
            r0.putLong(r2, r11)
            java.lang.String r2 = "_epc"
            r0.putInt(r2, r4)
        L_0x0529:
            r0 = 0
        L_0x052a:
            int r2 = r10.size()
            if (r0 >= r2) goto L_0x0595
            java.lang.Object r2 = r10.get(r0)
            android.os.Bundle r2 = (android.os.Bundle) r2
            if (r0 == 0) goto L_0x053a
            r3 = 1
            goto L_0x053b
        L_0x053a:
            r3 = 0
        L_0x053b:
            if (r3 == 0) goto L_0x0540
            java.lang.String r3 = "_ep"
            goto L_0x0541
        L_0x0540:
            r3 = r1
        L_0x0541:
            java.lang.String r4 = "_o"
            r2.putString(r4, r8)
            if (r33 == 0) goto L_0x0550
            com.google.android.gms.measurement.internal.zzkx r4 = r26.zzo()
            android.os.Bundle r2 = r4.zza((android.os.Bundle) r2)
        L_0x0550:
            r9 = r2
            com.google.android.gms.measurement.internal.zzar r11 = new com.google.android.gms.measurement.internal.zzar
            com.google.android.gms.measurement.internal.zzam r4 = new com.google.android.gms.measurement.internal.zzam
            r4.<init>(r9)
            r12 = r1
            r1 = r11
            r2 = r3
            r3 = r4
            r4 = r27
            r5 = r29
            r1.<init>(r2, r3, r4, r5)
            com.google.android.gms.measurement.internal.zziv r1 = r26.zzg()
            r13 = r35
            r1.zza((com.google.android.gms.measurement.internal.zzar) r11, (java.lang.String) r13)
            if (r16 != 0) goto L_0x058f
            java.util.Set<com.google.android.gms.measurement.internal.zzhc> r1 = r7.zzd
            java.util.Iterator r11 = r1.iterator()
        L_0x0574:
            boolean r1 = r11.hasNext()
            if (r1 == 0) goto L_0x058f
            java.lang.Object r1 = r11.next()
            com.google.android.gms.measurement.internal.zzhc r1 = (com.google.android.gms.measurement.internal.zzhc) r1
            android.os.Bundle r4 = new android.os.Bundle
            r4.<init>(r9)
            r2 = r27
            r3 = r28
            r5 = r29
            r1.onEvent(r2, r3, r4, r5)
            goto L_0x0574
        L_0x058f:
            int r0 = r0 + 1
            r5 = r29
            r1 = r12
            goto L_0x052a
        L_0x0595:
            r12 = r1
            com.google.android.gms.measurement.internal.zzim r0 = r26.zzh()
            r1 = 0
            com.google.android.gms.measurement.internal.zzin r0 = r0.zza((boolean) r1)
            if (r0 == 0) goto L_0x05b9
            java.lang.String r0 = "_ae"
            boolean r0 = r0.equals(r12)
            if (r0 == 0) goto L_0x05b9
            com.google.android.gms.measurement.internal.zzkb r0 = r26.zzj()
            com.google.android.gms.common.util.Clock r1 = r26.zzl()
            long r1 = r1.elapsedRealtime()
            r3 = 1
            r0.zza(r3, r3, r1)
        L_0x05b9:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zzhe.zza(java.lang.String, java.lang.String, long, android.os.Bundle, boolean, boolean, boolean, java.lang.String):void");
    }

    public final void zza(String str, String str2, Bundle bundle) {
        zza(str, str2, bundle, true, true, zzl().currentTimeMillis());
    }

    public final void zza(String str, String str2, Bundle bundle, boolean z, boolean z2, long j) {
        boolean z3;
        String str3 = str == null ? "app" : str;
        Bundle bundle2 = bundle == null ? new Bundle() : bundle;
        if (!zzs().zza(zzat.zzbw)) {
            String str4 = str2;
        } else if (zzkx.zzc(str2, FirebaseAnalytics.Event.SCREEN_VIEW)) {
            zzh().zza(bundle2, j);
            return;
        }
        long j2 = j;
        if (z2) {
            if (this.zzc != null && !zzkx.zzd(str2)) {
                z3 = false;
                zzp().zza((Runnable) new zzhn(this, str3, str2, j, zzkx.zzb(bundle2), z2, z3, !z, (String) null));
            }
        }
        z3 = true;
        zzp().zza((Runnable) new zzhn(this, str3, str2, j, zzkx.zzb(bundle2), z2, z3, !z, (String) null));
    }

    /* access modifiers changed from: package-private */
    public final void zza(String str, String str2, Object obj, long j) {
        Preconditions.checkNotEmpty(str);
        Preconditions.checkNotEmpty(str2);
        zzc();
        zzv();
        if (FirebaseAnalytics.UserProperty.ALLOW_AD_PERSONALIZATION_SIGNALS.equals(str2)) {
            if (obj instanceof String) {
                String str3 = (String) obj;
                if (!TextUtils.isEmpty(str3)) {
                    obj = Long.valueOf("false".equals(str3.toLowerCase(Locale.ENGLISH)) ? 1 : 0);
                    str2 = "_npa";
                    zzr().zzn.zza(((Long) obj).longValue() == 1 ? "true" : "false");
                }
            }
            if (obj == null) {
                str2 = "_npa";
                zzr().zzn.zza("unset");
            }
        }
        String str4 = str2;
        Object obj2 = obj;
        if (!this.zzy.zzaa()) {
            zzq().zzw().zza("User property not set since app measurement is disabled");
        } else if (this.zzy.zzaf()) {
            zzg().zza(new zzkw(str4, j, obj2, str));
        }
    }

    public final void zza(String str, String str2, Object obj, boolean z) {
        zza(str, str2, obj, true, zzl().currentTimeMillis());
    }

    public final void zza(String str, String str2, Object obj, boolean z, long j) {
        if (str == null) {
            str = "app";
        }
        String str3 = str;
        int i = 6;
        int i2 = 0;
        if (z) {
            i = zzo().zzb(str2);
        } else {
            zzkx zzo = zzo();
            if (zzo.zza("user property", str2)) {
                if (!zzo.zza("user property", zzha.zza, str2)) {
                    i = 15;
                } else if (zzo.zza("user property", 24, str2)) {
                    i = 0;
                }
            }
        }
        if (i != 0) {
            zzo();
            String zza2 = zzkx.zza(str2, 24, true);
            if (str2 != null) {
                i2 = str2.length();
            }
            this.zzy.zzh().zza(i, "_ev", zza2, i2);
        } else if (obj != null) {
            int zzb2 = zzo().zzb(str2, obj);
            if (zzb2 != 0) {
                zzo();
                String zza3 = zzkx.zza(str2, 24, true);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    i2 = String.valueOf(obj).length();
                }
                this.zzy.zzh().zza(zzb2, "_ev", zza3, i2);
                return;
            }
            Object zzc2 = zzo().zzc(str2, obj);
            if (zzc2 != null) {
                zza(str3, str2, j, zzc2);
            }
        } else {
            zza(str3, str2, j, (Object) null);
        }
    }

    public final void zza(String str, String str2, String str3, Bundle bundle) {
        Preconditions.checkNotEmpty(str);
        zza();
        zzb(str, str2, str3, bundle);
    }

    public final void zzaa() {
        if (zzm().getApplicationContext() instanceof Application) {
            ((Application) zzm().getApplicationContext()).unregisterActivityLifecycleCallbacks(this.zza);
        }
    }

    public final Boolean zzab() {
        AtomicReference atomicReference = new AtomicReference();
        return (Boolean) zzp().zza(atomicReference, 15000, "boolean test flag value", new zzhj(this, atomicReference));
    }

    public final String zzac() {
        AtomicReference atomicReference = new AtomicReference();
        return (String) zzp().zza(atomicReference, 15000, "String test flag value", new zzht(this, atomicReference));
    }

    public final Long zzad() {
        AtomicReference atomicReference = new AtomicReference();
        return (Long) zzp().zza(atomicReference, 15000, "long test flag value", new zzhx(this, atomicReference));
    }

    public final Integer zzae() {
        AtomicReference atomicReference = new AtomicReference();
        return (Integer) zzp().zza(atomicReference, 15000, "int test flag value", new zzhw(this, atomicReference));
    }

    public final Double zzaf() {
        AtomicReference atomicReference = new AtomicReference();
        return (Double) zzp().zza(atomicReference, 15000, "double test flag value", new zzhz(this, atomicReference));
    }

    public final String zzag() {
        return this.zzf.get();
    }

    public final void zzah() {
        zzc();
        zzv();
        if (this.zzy.zzaf()) {
            if (zzs().zza(zzat.zzbd)) {
                Boolean zzf2 = zzs().zzf("google_analytics_deferred_deep_link_enabled");
                if (zzf2 != null && zzf2.booleanValue()) {
                    zzq().zzv().zza("Deferred Deep Link feature enabled.");
                    zzp().zza((Runnable) new zzhg(this));
                }
            }
            zzg().zzad();
            this.zzm = false;
            String zzx = zzr().zzx();
            if (!TextUtils.isEmpty(zzx)) {
                zzk().zzaa();
                if (!zzx.equals(Build.VERSION.RELEASE)) {
                    Bundle bundle = new Bundle();
                    bundle.putString("_po", zzx);
                    zza("auto", "_ou", bundle);
                }
            }
        }
    }

    public final String zzai() {
        zzin zzaa = this.zzy.zzu().zzaa();
        if (zzaa != null) {
            return zzaa.zza;
        }
        return null;
    }

    public final String zzaj() {
        zzin zzaa = this.zzy.zzu().zzaa();
        if (zzaa != null) {
            return zzaa.zzb;
        }
        return null;
    }

    public final String zzak() {
        if (this.zzy.zzn() != null) {
            return this.zzy.zzn();
        }
        try {
            return zzik.zza(zzm(), "google_app_id");
        } catch (IllegalStateException e) {
            this.zzy.zzq().zze().zza("getGoogleAppId failed with exception", e);
            return null;
        }
    }

    public final /* bridge */ /* synthetic */ void zzb() {
        super.zzb();
    }

    public final void zzb(Bundle bundle) {
        Preconditions.checkNotNull(bundle);
        Preconditions.checkNotEmpty(bundle.getString("app_id"));
        zza();
        zzb(new Bundle(bundle), zzl().currentTimeMillis());
    }

    public final void zzb(zzhc zzhc) {
        zzv();
        Preconditions.checkNotNull(zzhc);
        if (!this.zzd.remove(zzhc)) {
            zzq().zzh().zza("OnEventListener had not been registered");
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzb(String str, String str2, Bundle bundle) {
        zzc();
        zza(str, str2, zzl().currentTimeMillis(), bundle);
    }

    public final /* bridge */ /* synthetic */ void zzc() {
        super.zzc();
    }

    public final void zzc(String str, String str2, Bundle bundle) {
        zzb((String) null, str, str2, bundle);
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
        return false;
    }
}
