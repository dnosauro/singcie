package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzdkv implements zzcyl<zzbyx> {
    /* access modifiers changed from: private */
    public final Executor zzfqx;
    @GuardedBy("this")
    private final zzdnp zzgvo;
    /* access modifiers changed from: private */
    public final zzcxq zzgvs;
    private zzacb zzgvw;
    private final zzbgm zzgxj;
    private final Context zzhdm;
    /* access modifiers changed from: private */
    public final zzdlf zzhfm;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public zzdyz<zzbyx> zzhfn;

    public zzdkv(Context context, Executor executor, zzbgm zzbgm, zzcxq zzcxq, zzdlf zzdlf, zzdnp zzdnp) {
        this.zzhdm = context;
        this.zzfqx = executor;
        this.zzgxj = zzbgm;
        this.zzgvs = zzcxq;
        this.zzgvo = zzdnp;
        this.zzhfm = zzdlf;
    }

    public final boolean isLoading() {
        zzdyz<zzbyx> zzdyz = this.zzhfn;
        return zzdyz != null && !zzdyz.isDone();
    }

    public final void zza(zzacb zzacb) {
        this.zzgvw = zzacb;
    }

    public final boolean zza(zzvk zzvk, String str, zzcyo zzcyo, zzcyn<? super zzbyx> zzcyn) {
        zzcaa zze;
        zzcwq zzcwq;
        if (str == null) {
            zzd.zzey("Ad unit ID should not be null for interstitial ad.");
            this.zzfqx.execute(new zzdku(this));
            return false;
        } else if (isLoading()) {
            return false;
        } else {
            zzdnn zzaus = this.zzgvo.zzgq(str).zzf(zzcyo instanceof zzdks ? ((zzdks) zzcyo).zzead : new zzvn()).zzh(zzvk).zzaus();
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcys)).booleanValue()) {
                zze = this.zzgxj.zzaev().zze(new zzbrg.zza().zzcg(this.zzhdm).zza(zzaus).zzakx()).zze(new zzbwp.zza().zzalt());
                zzcwq = new zzcwq(this.zzgvw);
            } else {
                zzbwp.zza zza = new zzbwp.zza();
                zzdlf zzdlf = this.zzhfm;
                if (zzdlf != null) {
                    zza.zza((zzbru) zzdlf, this.zzfqx).zza((zzbtj) this.zzhfm, this.zzfqx).zza((zzbrz) this.zzhfm, this.zzfqx);
                }
                zze = this.zzgxj.zzaev().zze(new zzbrg.zza().zzcg(this.zzhdm).zza(zzaus).zzakx()).zze(zza.zza((zzbru) this.zzgvs, this.zzfqx).zza((zzbtj) this.zzgvs, this.zzfqx).zza((zzbrz) this.zzgvs, this.zzfqx).zza((zzva) this.zzgvs, this.zzfqx).zza((AppEventListener) this.zzgvs, this.zzfqx).zza((zzbub) this.zzgvs, this.zzfqx).zzalt());
                zzcwq = new zzcwq(this.zzgvw);
            }
            zzbzx zzahf = zze.zzb(zzcwq).zzahf();
            this.zzhfn = zzahf.zzagh().zzakj();
            zzdyr.zza(this.zzhfn, new zzdkx(this, zzcyn, zzahf), this.zzfqx);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzauf() {
        this.zzgvs.zzk(zzdoi.zza(zzdok.INVALID_AD_UNIT_ID, (String) null, (zzve) null));
    }
}
