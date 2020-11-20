package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzcyp implements zzcyl<zzboc> {
    /* access modifiers changed from: private */
    public final zzbgm zzgss;
    private final Context zzgvn;
    @GuardedBy("this")
    private final zzdnp zzgvo;
    /* access modifiers changed from: private */
    public final zzcyj zzgwx;
    @GuardedBy("this")
    private zzboj zzgwy;

    public zzcyp(zzbgm zzbgm, Context context, zzcyj zzcyj, zzdnp zzdnp) {
        this.zzgss = zzbgm;
        this.zzgvn = context;
        this.zzgwx = zzcyj;
        this.zzgvo = zzdnp;
    }

    public final boolean isLoading() {
        zzboj zzboj = this.zzgwy;
        return zzboj != null && zzboj.isLoading();
    }

    public final boolean zza(zzvk zzvk, String str, zzcyo zzcyo, zzcyn<? super zzboc> zzcyn) {
        zzblz zzblz;
        zzcaw zzcaw;
        Executor zzaek;
        Runnable zzcyr;
        zzp.zzkq();
        if (zzm.zzbb(this.zzgvn) && zzvk.zzchn == null) {
            zzd.zzey("Failed to load the ad because app ID is missing.");
            zzaek = this.zzgss.zzaek();
            zzcyr = new zzcys(this);
        } else if (str == null) {
            zzd.zzey("Ad unit ID should not be null for NativeAdLoader.");
            zzaek = this.zzgss.zzaek();
            zzcyr = new zzcyr(this);
        } else {
            zzdob.zze(this.zzgvn, zzvk.zzchb);
            zzdnn zzaus = this.zzgvo.zzh(zzvk).zzee(zzcyo instanceof zzcyq ? ((zzcyq) zzcyo).zzgwz : 1).zzaus();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyt)).booleanValue()) {
                zzcaw = this.zzgss.zzaex().zza(new zzbrg.zza().zzcg(this.zzgvn).zza(zzaus).zzakx()).zza(new zzbwp.zza().zzalt()).zza(this.zzgwx.zzarz());
                zzblz = new zzblz((ViewGroup) null);
            } else {
                zzcaw = this.zzgss.zzaex().zza(new zzbrg.zza().zzcg(this.zzgvn).zza(zzaus).zzakx()).zza(new zzbwp.zza().zza(this.zzgwx.zzasc(), this.zzgss.zzaek()).zza(this.zzgwx.zzasd(), this.zzgss.zzaek()).zza(this.zzgwx.zzase(), this.zzgss.zzaek()).zza(this.zzgwx.zzasf(), this.zzgss.zzaek()).zza(this.zzgwx.zzasb(), this.zzgss.zzaek()).zza(zzaus.zzhiu, this.zzgss.zzaek()).zzalt()).zza(this.zzgwx.zzarz());
                zzblz = new zzblz((ViewGroup) null);
            }
            zzcat zzafo = zzcaw.zza(zzblz).zzafo();
            this.zzgss.zzafd().ensureSize(1);
            this.zzgwy = new zzboj(this.zzgss.zzaem(), this.zzgss.zzael(), zzafo.zzagh().zzakj());
            this.zzgwy.zza((zzdyo<zzboc>) new zzcyu(this, zzcyn, zzafo));
            return true;
        }
        zzaek.execute(zzcyr);
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzasg() {
        this.zzgwx.zzasd().zzk(zzdoi.zza(zzdok.INVALID_AD_UNIT_ID, (String) null, (zzve) null));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzash() {
        this.zzgwx.zzasd().zzk(zzdoi.zza(zzdok.APP_ID_MISSING, (String) null, (zzve) null));
    }
}
