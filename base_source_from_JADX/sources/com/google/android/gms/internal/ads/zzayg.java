package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import com.google.android.gms.ads.internal.util.zzi;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzayg {
    /* access modifiers changed from: private */
    public Context context;
    /* access modifiers changed from: private */
    public final Object lock = new Object();
    /* access modifiers changed from: private */
    public zzazh zzbpd;
    private final zzayq zzeaj = new zzayq(zzwq.zzqf(), this.zzear);
    private final zzi zzear = new zzi();
    /* access modifiers changed from: private */
    public zzabi zzeas = null;
    private Boolean zzeat = null;
    private final AtomicInteger zzeau = new AtomicInteger(0);
    private final zzayl zzeav = new zzayl((zzayi) null);
    private final Object zzeaw = new Object();
    private zzdyz<ArrayList<String>> zzeax;
    private boolean zzzi = false;

    @TargetApi(16)
    private static ArrayList<String> zzaj(Context context2) {
        ArrayList<String> arrayList = new ArrayList<>();
        try {
            PackageInfo packageInfo = Wrappers.packageManager(context2).getPackageInfo(context2.getApplicationInfo().packageName, 4096);
            if (!(packageInfo.requestedPermissions == null || packageInfo.requestedPermissionsFlags == null)) {
                for (int i = 0; i < packageInfo.requestedPermissions.length; i++) {
                    if ((packageInfo.requestedPermissionsFlags[i] & 2) != 0) {
                        arrayList.add(packageInfo.requestedPermissions[i]);
                    }
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return arrayList;
    }

    public final Context getApplicationContext() {
        return this.context;
    }

    public final Resources getResources() {
        if (this.zzbpd.zzegn) {
            return this.context.getResources();
        }
        try {
            zzazd.zzbv(this.context).getResources();
            return null;
        } catch (zzazf e) {
            zzd.zzd("Cannot load resource from dynamite apk or local jar", e);
            return null;
        }
    }

    public final void zza(Boolean bool) {
        synchronized (this.lock) {
            this.zzeat = bool;
        }
    }

    public final void zza(Throwable th, String str) {
        zzasn.zzc(this.context, this.zzbpd).zza(th, str);
    }

    public final void zzb(Throwable th, String str) {
        zzasn.zzc(this.context, this.zzbpd).zza(th, str, zzadg.zzddj.get().floatValue());
    }

    @TargetApi(23)
    public final void zzd(Context context2, zzazh zzazh) {
        synchronized (this.lock) {
            if (!this.zzzi) {
                this.context = context2.getApplicationContext();
                this.zzbpd = zzazh;
                zzp.zzkt().zza(this.zzeaj);
                zzabi zzabi = null;
                this.zzear.zza(this.context, (String) null, true);
                zzasn.zzc(this.context, this.zzbpd);
                zzp.zzkz();
                if (!zzacu.zzdbr.get().booleanValue()) {
                    zzd.zzee("CsiReporterFactory: CSI is not enabled. No CSI reporter created.");
                } else {
                    zzabi = new zzabi();
                }
                this.zzeas = zzabi;
                if (this.zzeas != null) {
                    zzazm.zza(new zzayi(this).zzxl(), "AppState.registerCsiReporter");
                }
                this.zzzi = true;
                zzxa();
            }
        }
        zzp.zzkq().zzq(context2, zzazh.zzbrf);
    }

    public final zzabi zzwt() {
        zzabi zzabi;
        synchronized (this.lock) {
            zzabi = this.zzeas;
        }
        return zzabi;
    }

    public final Boolean zzwu() {
        Boolean bool;
        synchronized (this.lock) {
            bool = this.zzeat;
        }
        return bool;
    }

    public final void zzwv() {
        this.zzeav.zzwv();
    }

    public final void zzww() {
        this.zzeau.incrementAndGet();
    }

    public final void zzwx() {
        this.zzeau.decrementAndGet();
    }

    public final int zzwy() {
        return this.zzeau.get();
    }

    public final zzf zzwz() {
        zzi zzi;
        synchronized (this.lock) {
            zzi = this.zzear;
        }
        return zzi;
    }

    public final zzdyz<ArrayList<String>> zzxa() {
        if (PlatformVersion.isAtLeastJellyBean() && this.context != null) {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcrd)).booleanValue()) {
                synchronized (this.zzeaw) {
                    if (this.zzeax != null) {
                        zzdyz<ArrayList<String>> zzdyz = this.zzeax;
                        return zzdyz;
                    }
                    zzdyz<ArrayList<String>> zze = zzazj.zzegp.zze(new zzayj(this));
                    this.zzeax = zze;
                    return zze;
                }
            }
        }
        return zzdyr.zzag(new ArrayList());
    }

    public final zzayq zzxb() {
        return this.zzeaj;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ ArrayList zzxc() {
        return zzaj(zzauc.zzy(this.context));
    }
}
