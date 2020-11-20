package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;

public final class zzchc extends zzboc {
    private final Context context;
    private final zzavc zzdyd;
    private final WeakReference<zzbdv> zzfzq;
    private final zzbxm zzfzr;
    private final zzbov zzfzs;
    private final zzdst zzfzt;
    private final zzbsb zzfzu;
    private final zzcaf zzfzw;
    private boolean zzghc = false;
    private final zzbti zzght;

    zzchc(zzbob zzbob, Context context2, zzbdv zzbdv, zzcaf zzcaf, zzbxm zzbxm, zzbsb zzbsb, zzbti zzbti, zzbov zzbov, zzdmu zzdmu, zzdst zzdst) {
        super(zzbob);
        this.context = context2;
        this.zzfzw = zzcaf;
        this.zzfzq = new WeakReference<>(zzbdv);
        this.zzfzr = zzbxm;
        this.zzfzu = zzbsb;
        this.zzght = zzbti;
        this.zzfzs = zzbov;
        this.zzfzt = zzdst;
        this.zzdyd = new zzawd(zzdmu.zzdvb);
    }

    public final void finalize() {
        try {
            zzbdv zzbdv = (zzbdv) this.zzfzq.get();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxt)).booleanValue()) {
                if (!this.zzghc && zzbdv != null) {
                    zzdzc zzdzc = zzazj.zzegt;
                    zzbdv.getClass();
                    zzdzc.execute(zzchb.zzh(zzbdv));
                }
            } else if (zzbdv != null) {
                zzbdv.destroy();
            }
        } finally {
            super.finalize();
        }
    }

    public final Bundle getAdMetadata() {
        return this.zzght.getAdMetadata();
    }

    public final boolean isClosed() {
        return this.zzfzs.isClosed();
    }

    public final boolean isUsed() {
        return this.zzghc;
    }

    public final boolean zzb(boolean z, Activity activity) {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcnz)).booleanValue()) {
            zzp.zzkq();
            if (zzm.zzas(this.context)) {
                zzd.zzfa("Rewarded ads that show when your app is in the background are a violation of AdMob policies and may lead to blocked ad serving. To learn more, visit https://googlemobileadssdk.page.link/admob-interstitial-policies");
                this.zzfzu.zzaky();
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcoa)).booleanValue()) {
                    this.zzfzt.zzgz(this.zzfpr.zzhik.zzerj.zzbvf);
                }
                return false;
            }
        }
        if (this.zzghc) {
            zzd.zzfa("The rewarded ad have been showed.");
            this.zzfzu.zzl(zzdoi.zza(zzdok.AD_REUSED, (String) null, (zzve) null));
            return false;
        }
        this.zzghc = true;
        this.zzfzr.zzakn();
        Context context2 = activity;
        if (activity == null) {
            context2 = this.context;
        }
        try {
            this.zzfzw.zza(z, context2);
            this.zzfzr.zzakl();
            return true;
        } catch (zzcai e) {
            this.zzfzu.zza(e);
            return false;
        }
    }

    public final zzavc zzre() {
        return this.zzdyd;
    }

    public final boolean zzrf() {
        zzbdv zzbdv = (zzbdv) this.zzfzq.get();
        return zzbdv != null && !zzbdv.zzadh();
    }
}
