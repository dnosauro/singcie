package com.google.android.gms.measurement.internal;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.os.RemoteException;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.stats.ConnectionTracker;
import com.google.android.gms.common.util.Clock;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.internal.measurement.zzmb;
import com.google.android.gms.internal.measurement.zzw;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

@VisibleForTesting
public final class zziv extends zzg {
    /* access modifiers changed from: private */
    public final zzjp zza;
    /* access modifiers changed from: private */
    public zzep zzb;
    private volatile Boolean zzc;
    private final zzaj zzd;
    private final zzki zze;
    private final List<Runnable> zzf = new ArrayList();
    private final zzaj zzg;

    protected zziv(zzgb zzgb) {
        super(zzgb);
        this.zze = new zzki(zzgb.zzl());
        this.zza = new zzjp(this);
        this.zzd = new zziu(this, zzgb);
        this.zzg = new zzje(this, zzgb);
    }

    /* access modifiers changed from: private */
    public final void zza(ComponentName componentName) {
        zzc();
        if (this.zzb != null) {
            this.zzb = null;
            zzq().zzw().zza("Disconnected from device MeasurementService", componentName);
            zzc();
            zzae();
        }
    }

    private final void zza(Runnable runnable) {
        zzc();
        if (zzaa()) {
            runnable.run();
        } else if (((long) this.zzf.size()) >= 1000) {
            zzq().zze().zza("Discarding data. Max runnable queue size reached");
        } else {
            this.zzf.add(runnable);
            this.zzg.zza(60000);
            zzae();
        }
    }

    /* access modifiers changed from: private */
    public final void zzaj() {
        zzc();
        this.zze.zza();
        this.zzd.zza(zzat.zzai.zza(null).longValue());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:25:0x00a3, code lost:
        r0 = true;
     */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x00e6  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final boolean zzak() {
        /*
            r5 = this;
            r5.zzc()
            r5.zzv()
            java.lang.Boolean r0 = r5.zzc
            if (r0 != 0) goto L_0x00f3
            r5.zzc()
            r5.zzv()
            com.google.android.gms.measurement.internal.zzfj r0 = r5.zzr()
            java.lang.Boolean r0 = r0.zzi()
            r1 = 1
            if (r0 == 0) goto L_0x0023
            boolean r2 = r0.booleanValue()
            if (r2 == 0) goto L_0x0023
            goto L_0x00ed
        L_0x0023:
            com.google.android.gms.measurement.internal.zzeq r2 = r5.zzf()
            int r2 = r2.zzaf()
            r3 = 0
            if (r2 != r1) goto L_0x0031
        L_0x002e:
            r0 = 1
            goto L_0x00ca
        L_0x0031:
            com.google.android.gms.measurement.internal.zzex r2 = r5.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzw()
            java.lang.String r4 = "Checking service availability"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zzkx r2 = r5.zzo()
            r4 = 12451000(0xbdfcb8, float:1.7447567E-38)
            int r2 = r2.zza((int) r4)
            r4 = 9
            if (r2 == r4) goto L_0x00bf
            r4 = 18
            if (r2 == r4) goto L_0x00b4
            switch(r2) {
                case 0: goto L_0x00a5;
                case 1: goto L_0x0096;
                case 2: goto L_0x0076;
                case 3: goto L_0x0068;
                default: goto L_0x0054;
            }
        L_0x0054:
            com.google.android.gms.measurement.internal.zzex r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzh()
            java.lang.String r1 = "Unexpected service status"
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            r0.zza(r1, r2)
        L_0x0065:
            r0 = 0
        L_0x0066:
            r1 = 0
            goto L_0x00ca
        L_0x0068:
            com.google.android.gms.measurement.internal.zzex r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzh()
            java.lang.String r1 = "Service disabled"
        L_0x0072:
            r0.zza(r1)
            goto L_0x0065
        L_0x0076:
            com.google.android.gms.measurement.internal.zzex r2 = r5.zzq()
            com.google.android.gms.measurement.internal.zzez r2 = r2.zzv()
            java.lang.String r4 = "Service container out of date"
            r2.zza(r4)
            com.google.android.gms.measurement.internal.zzkx r2 = r5.zzo()
            int r2 = r2.zzi()
            r4 = 17443(0x4423, float:2.4443E-41)
            if (r2 >= r4) goto L_0x0090
            goto L_0x00a3
        L_0x0090:
            if (r0 != 0) goto L_0x0093
            goto L_0x0094
        L_0x0093:
            r1 = 0
        L_0x0094:
            r0 = 0
            goto L_0x00ca
        L_0x0096:
            com.google.android.gms.measurement.internal.zzex r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzw()
            java.lang.String r2 = "Service missing"
            r0.zza(r2)
        L_0x00a3:
            r0 = 1
            goto L_0x0066
        L_0x00a5:
            com.google.android.gms.measurement.internal.zzex r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzw()
            java.lang.String r2 = "Service available"
        L_0x00af:
            r0.zza(r2)
            goto L_0x002e
        L_0x00b4:
            com.google.android.gms.measurement.internal.zzex r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzh()
            java.lang.String r2 = "Service updating"
            goto L_0x00af
        L_0x00bf:
            com.google.android.gms.measurement.internal.zzex r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zzh()
            java.lang.String r1 = "Service invalid"
            goto L_0x0072
        L_0x00ca:
            if (r1 != 0) goto L_0x00e4
            com.google.android.gms.measurement.internal.zzy r2 = r5.zzs()
            boolean r2 = r2.zzw()
            if (r2 == 0) goto L_0x00e4
            com.google.android.gms.measurement.internal.zzex r0 = r5.zzq()
            com.google.android.gms.measurement.internal.zzez r0 = r0.zze()
            java.lang.String r2 = "No way to upload. Consider using the full version of Analytics"
            r0.zza(r2)
            r0 = 0
        L_0x00e4:
            if (r0 == 0) goto L_0x00ed
            com.google.android.gms.measurement.internal.zzfj r0 = r5.zzr()
            r0.zza((boolean) r1)
        L_0x00ed:
            java.lang.Boolean r0 = java.lang.Boolean.valueOf(r1)
            r5.zzc = r0
        L_0x00f3:
            java.lang.Boolean r0 = r5.zzc
            boolean r0 = r0.booleanValue()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.measurement.internal.zziv.zzak():boolean");
    }

    /* access modifiers changed from: private */
    public final void zzal() {
        zzc();
        if (zzaa()) {
            zzq().zzw().zza("Inactivity, disconnecting from the service");
            zzag();
        }
    }

    /* access modifiers changed from: private */
    public final void zzam() {
        zzc();
        zzq().zzw().zza("Processing queued up service tasks", Integer.valueOf(this.zzf.size()));
        for (Runnable run : this.zzf) {
            try {
                run.run();
            } catch (Exception e) {
                zzq().zze().zza("Task exception while flushing queue", e);
            }
        }
        this.zzf.clear();
        this.zzg.zzc();
    }

    private final zzn zzb(boolean z) {
        return zzf().zza(z ? zzq().zzx() : null);
    }

    public final /* bridge */ /* synthetic */ void zza() {
        super.zza();
    }

    public final void zza(Bundle bundle) {
        zzc();
        zzv();
        zza((Runnable) new zzjf(this, bundle, zzb(false)));
    }

    public final void zza(zzw zzw) {
        zzc();
        zzv();
        zza((Runnable) new zzja(this, zzb(false), zzw));
    }

    public final void zza(zzw zzw, zzar zzar, String str) {
        zzc();
        zzv();
        if (zzo().zza((int) GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE) != 0) {
            zzq().zzh().zza("Not bundling data. Service unavailable or out of date");
            zzo().zza(zzw, new byte[0]);
            return;
        }
        zza((Runnable) new zzjh(this, zzar, str, zzw));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw, String str, String str2) {
        zzc();
        zzv();
        zza((Runnable) new zzjn(this, str, str2, zzb(false), zzw));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw, String str, String str2, boolean z) {
        zzc();
        zzv();
        zza((Runnable) new zzix(this, str, str2, z, zzb(false), zzw));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzar zzar, String str) {
        Preconditions.checkNotNull(zzar);
        zzc();
        zzv();
        zza((Runnable) new zzji(this, true, zzi().zza(zzar), zzar, zzb(true), str));
    }

    /* access modifiers changed from: protected */
    @VisibleForTesting
    public final void zza(zzep zzep) {
        zzc();
        Preconditions.checkNotNull(zzep);
        this.zzb = zzep;
        zzaj();
        zzam();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(zzep zzep, AbstractSafeParcelable abstractSafeParcelable, zzn zzn) {
        int i;
        zzez zze2;
        String str;
        zzc();
        zzv();
        int i2 = 0;
        int i3 = 100;
        while (i2 < 1001 && i3 == 100) {
            ArrayList arrayList = new ArrayList();
            List<AbstractSafeParcelable> zza2 = zzi().zza(100);
            if (zza2 != null) {
                arrayList.addAll(zza2);
                i = zza2.size();
            } else {
                i = 0;
            }
            if (abstractSafeParcelable != null && i < 100) {
                arrayList.add(abstractSafeParcelable);
            }
            ArrayList arrayList2 = arrayList;
            int size = arrayList2.size();
            int i4 = 0;
            while (i4 < size) {
                Object obj = arrayList2.get(i4);
                i4++;
                AbstractSafeParcelable abstractSafeParcelable2 = (AbstractSafeParcelable) obj;
                if (abstractSafeParcelable2 instanceof zzar) {
                    try {
                        zzep.zza((zzar) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e) {
                        e = e;
                        zze2 = zzq().zze();
                        str = "Failed to send event to the service";
                    }
                } else if (abstractSafeParcelable2 instanceof zzkw) {
                    try {
                        zzep.zza((zzkw) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e2) {
                        e = e2;
                        zze2 = zzq().zze();
                        str = "Failed to send user property to the service";
                    }
                } else if (abstractSafeParcelable2 instanceof zzw) {
                    try {
                        zzep.zza((zzw) abstractSafeParcelable2, zzn);
                    } catch (RemoteException e3) {
                        e = e3;
                        zze2 = zzq().zze();
                        str = "Failed to send conditional user property to the service";
                    }
                } else {
                    zzq().zze().zza("Discarding data. Unrecognized parcel type.");
                }
            }
            i2++;
            i3 = i;
        }
        return;
        zze2.zza(str, e);
    }

    /* access modifiers changed from: protected */
    public final void zza(zzin zzin) {
        zzc();
        zzv();
        zza((Runnable) new zzjc(this, zzin));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzkw zzkw) {
        zzc();
        zzv();
        zza((Runnable) new zziw(this, zzi().zza(zzkw), zzkw, zzb(true)));
    }

    /* access modifiers changed from: protected */
    public final void zza(zzw zzw) {
        Preconditions.checkNotNull(zzw);
        zzc();
        zzv();
        zza((Runnable) new zzjl(this, true, zzi().zza(zzw), new zzw(zzw), zzb(true), zzw));
    }

    public final void zza(AtomicReference<String> atomicReference) {
        zzc();
        zzv();
        zza((Runnable) new zzjb(this, atomicReference, zzb(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzw>> atomicReference, String str, String str2, String str3) {
        zzc();
        zzv();
        zza((Runnable) new zzjk(this, atomicReference, str, str2, str3, zzb(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzkw>> atomicReference, String str, String str2, String str3, boolean z) {
        zzc();
        zzv();
        zza((Runnable) new zzjm(this, atomicReference, str, str2, str3, z, zzb(false)));
    }

    /* access modifiers changed from: protected */
    public final void zza(AtomicReference<List<zzkw>> atomicReference, boolean z) {
        zzc();
        zzv();
        zza((Runnable) new zziz(this, atomicReference, zzb(false), z));
    }

    /* access modifiers changed from: protected */
    public final void zza(boolean z) {
        if (zzmb.zzb() && zzs().zza(zzat.zzco)) {
            zzc();
            zzv();
            if (z) {
                zzi().zzaa();
            }
            if (zzai()) {
                zza((Runnable) new zzjj(this, zzb(false)));
            }
        }
    }

    public final boolean zzaa() {
        zzc();
        zzv();
        return this.zzb != null;
    }

    /* access modifiers changed from: protected */
    public final void zzab() {
        zzc();
        zzv();
        zza((Runnable) new zzjg(this, zzb(true)));
    }

    /* access modifiers changed from: protected */
    public final void zzac() {
        zzc();
        zzv();
        zzn zzb2 = zzb(false);
        zzi().zzaa();
        zza((Runnable) new zziy(this, zzb2));
    }

    /* access modifiers changed from: protected */
    public final void zzad() {
        zzc();
        zzv();
        zzn zzb2 = zzb(true);
        zzi().zzab();
        zza((Runnable) new zzjd(this, zzb2));
    }

    /* access modifiers changed from: package-private */
    public final void zzae() {
        zzc();
        zzv();
        if (!zzaa()) {
            if (zzak()) {
                this.zza.zzb();
            } else if (!zzs().zzw()) {
                List<ResolveInfo> queryIntentServices = zzm().getPackageManager().queryIntentServices(new Intent().setClassName(zzm(), "com.google.android.gms.measurement.AppMeasurementService"), PKIFailureInfo.notAuthorized);
                if (queryIntentServices != null && queryIntentServices.size() > 0) {
                    Intent intent = new Intent("com.google.android.gms.measurement.START");
                    intent.setComponent(new ComponentName(zzm(), "com.google.android.gms.measurement.AppMeasurementService"));
                    this.zza.zza(intent);
                    return;
                }
                zzq().zze().zza("Unable to use remote or local measurement implementation. Please register the AppMeasurementService service in the app manifest");
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final Boolean zzaf() {
        return this.zzc;
    }

    public final void zzag() {
        zzc();
        zzv();
        this.zza.zza();
        try {
            ConnectionTracker.getInstance().unbindService(zzm(), this.zza);
        } catch (IllegalArgumentException | IllegalStateException unused) {
        }
        this.zzb = null;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzah() {
        zzc();
        zzv();
        return !zzak() || zzo().zzi() >= 200900;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzai() {
        zzc();
        zzv();
        if (!zzs().zza(zzat.zzcp)) {
            return false;
        }
        return !zzak() || zzo().zzi() >= zzat.zzcq.zza(null).intValue();
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
        return false;
    }
}
