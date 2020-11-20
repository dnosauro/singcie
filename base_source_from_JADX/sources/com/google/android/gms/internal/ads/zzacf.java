package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import androidx.browser.p017a.C0387a;
import androidx.browser.p017a.C0388b;
import androidx.browser.p017a.C0397d;
import androidx.browser.p017a.C0399e;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

@ParametersAreNonnullByDefault
public final class zzacf implements zzept {
    private C0399e zzdag;
    private C0388b zzdah;
    private C0397d zzdai;
    private zzace zzdaj;

    public static boolean zzj(Context context) {
        PackageManager packageManager = context.getPackageManager();
        if (packageManager == null) {
            return false;
        }
        Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("http://www.example.com"));
        ResolveInfo resolveActivity = packageManager.resolveActivity(intent, 0);
        List<ResolveInfo> queryIntentActivities = packageManager.queryIntentActivities(intent, PKIFailureInfo.notAuthorized);
        if (!(queryIntentActivities == null || resolveActivity == null)) {
            for (int i = 0; i < queryIntentActivities.size(); i++) {
                if (resolveActivity.activityInfo.name.equals(queryIntentActivities.get(i).activityInfo.name)) {
                    return resolveActivity.activityInfo.packageName.equals(zzepr.zzcn(context));
                }
            }
        }
        return false;
    }

    public final void zza(C0388b bVar) {
        this.zzdah = bVar;
        this.zzdah.mo2798a(0);
        zzace zzace = this.zzdaj;
        if (zzace != null) {
            zzace.zzsc();
        }
    }

    public final void zza(zzace zzace) {
        this.zzdaj = zzace;
    }

    public final void zzc(Activity activity) {
        C0397d dVar = this.zzdai;
        if (dVar != null) {
            activity.unbindService(dVar);
            this.zzdah = null;
            this.zzdag = null;
            this.zzdai = null;
        }
    }

    public final void zzd(Activity activity) {
        String zzcn;
        if (this.zzdah == null && (zzcn = zzepr.zzcn(activity)) != null) {
            this.zzdai = new zzepu(this);
            C0388b.m1457a(activity, zzcn, this.zzdai);
        }
    }

    public final C0399e zzse() {
        C0388b bVar = this.zzdah;
        if (bVar == null) {
            this.zzdag = null;
        } else if (this.zzdag == null) {
            this.zzdag = bVar.mo2797a((C0387a) null);
        }
        return this.zzdag;
    }

    public final void zzsf() {
        this.zzdah = null;
        this.zzdag = null;
        zzace zzace = this.zzdaj;
        if (zzace != null) {
            zzace.zzsd();
        }
    }
}
