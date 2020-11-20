package com.google.android.gms.internal.ads;

import android.view.ViewGroup;
import android.view.ViewParent;
import com.google.android.gms.ads.internal.util.zzd;
import java.util.concurrent.Executor;

final class zzcxl implements zzdyo<zzbme> {
    private final /* synthetic */ zzbna zzgvq;
    final /* synthetic */ zzcxm zzgvr;

    zzcxl(zzcxm zzcxm, zzbna zzbna) {
        this.zzgvr = zzcxm;
        this.zzgvq = zzbna;
    }

    public final /* synthetic */ void onSuccess(Object obj) {
        zzbme zzbme = (zzbme) obj;
        synchronized (this.zzgvr) {
            zzdyz unused = this.zzgvr.zzgvx = null;
            if (this.zzgvr.zzgvl != null) {
                this.zzgvr.zzgvl.destroy();
            }
            zzbme unused2 = this.zzgvr.zzgvl = zzbme;
            this.zzgvr.zzfsx.removeAllViews();
            if (zzbme.zzaiz() != null) {
                ViewParent parent = zzbme.zzaiz().getParent();
                if (parent instanceof ViewGroup) {
                    String mediationAdapterClassName = this.zzgvr.getMediationAdapterClassName();
                    StringBuilder sb = new StringBuilder(String.valueOf(mediationAdapterClassName).length() + 78);
                    sb.append("Banner view provided from ");
                    sb.append(mediationAdapterClassName);
                    sb.append(" already has a parent view. Removing its old parent.");
                    zzd.zzfa(sb.toString());
                    ((ViewGroup) parent).removeView(zzbme.zzaiz());
                }
            }
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyp)).booleanValue()) {
                zzbme.zzakb().zza(this.zzgvr.zzgvs).zza(this.zzgvr.zzgvt);
            }
            this.zzgvr.zzfsx.addView(zzbme.zzaiz());
            zzbme.zzajj();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyp)).booleanValue()) {
                Executor zzaek = this.zzgvr.zzgss.zzaek();
                zzcxq zzd = this.zzgvr.zzgvs;
                zzd.getClass();
                zzaek.execute(zzcxo.zzb(zzd));
            }
            this.zzgvr.zzgvu.zzdx(zzbme.zzaji());
        }
    }

    public final void zzb(Throwable th) {
        zzve zze = this.zzgvq.zzagh().zze(th);
        synchronized (this.zzgvr) {
            zzdyz unused = this.zzgvr.zzgvx = null;
            this.zzgvq.zzagi().zzk(zze);
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyp)).booleanValue()) {
                this.zzgvr.zzgss.zzaek().execute(new zzcxn(this, zze));
            }
            this.zzgvr.zzgvu.zzdx(60);
            zzdob.zza(zze.errorCode, th, "BannerAdManagerShim.onFailure");
        }
    }
}
