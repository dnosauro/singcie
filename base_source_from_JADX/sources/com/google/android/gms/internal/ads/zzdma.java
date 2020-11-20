package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.reward.AdMetadataListener;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.concurrent.Executor;
import javax.annotation.concurrent.GuardedBy;

public final class zzdma implements zzcyl<zzchc> {
    /* access modifiers changed from: private */
    public final Executor zzfqx;
    private final zzdni zzfxk;
    @GuardedBy("this")
    private final zzdnp zzgvo;
    private final zzbgm zzgxj;
    private final Context zzhdm;
    /* access modifiers changed from: private */
    public final zzdkl<zzchf, zzchc> zzhdo;
    @GuardedBy("this")
    private zzdyz<zzchc> zzhfn;
    /* access modifiers changed from: private */
    public final zzdlf zzhga;

    public zzdma(Context context, Executor executor, zzbgm zzbgm, zzdkl<zzchf, zzchc> zzdkl, zzdlf zzdlf, zzdnp zzdnp, zzdni zzdni) {
        this.zzhdm = context;
        this.zzfqx = executor;
        this.zzgxj = zzbgm;
        this.zzhdo = zzdkl;
        this.zzhga = zzdlf;
        this.zzgvo = zzdnp;
        this.zzfxk = zzdni;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzd */
    public final zzchi zze(zzdkk zzdkk) {
        zzchi zzf;
        zzbwp.zza zza;
        zzdmg zzdmg = (zzdmg) zzdkk;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyq)).booleanValue()) {
            zzf = this.zzgxj.zzaey().zzf(new zzbrg.zza().zzcg(this.zzhdm).zza(zzdmg.zzfvl).zzfu(zzdmg.zzhgb).zza(this.zzfxk).zzakx());
            zza = new zzbwp.zza();
        } else {
            zzdlf zzb = zzdlf.zzb(this.zzhga);
            zzf = this.zzgxj.zzaey().zzf(new zzbrg.zza().zzcg(this.zzhdm).zza(zzdmg.zzfvl).zzfu(zzdmg.zzhgb).zza(this.zzfxk).zzakx());
            zza = new zzbwp.zza().zza((zzbru) zzb, this.zzfqx).zza((zzbtj) zzb, this.zzfqx).zza((zzbrz) zzb, this.zzfqx).zza((AdMetadataListener) zzb, this.zzfqx).zza((zzbsi) zzb, this.zzfqx).zza((zzbub) zzb, this.zzfqx).zza((zzdki) zzb);
        }
        return zzf.zzf(zza.zzalt());
    }

    public final boolean isLoading() {
        zzdyz<zzchc> zzdyz = this.zzhfn;
        return zzdyz != null && !zzdyz.isDone();
    }

    public final boolean zza(zzvk zzvk, String str, zzcyo zzcyo, zzcyn<? super zzchc> zzcyn) {
        zzauv zzauv = new zzauv(zzvk, str);
        String str2 = zzcyo instanceof zzdmb ? ((zzdmb) zzcyo).zzhgb : null;
        if (zzauv.zzbum == null) {
            zzd.zzey("Ad unit ID should not be null for rewarded video ad.");
            this.zzfqx.execute(new zzdmd(this));
            return false;
        }
        zzdyz<zzchc> zzdyz = this.zzhfn;
        if (zzdyz != null && !zzdyz.isDone()) {
            return false;
        }
        zzdob.zze(this.zzhdm, zzauv.zzdsr.zzchb);
        zzdnn zzaus = this.zzgvo.zzgq(zzauv.zzbum).zzf(zzvn.zzpp()).zzh(zzauv.zzdsr).zzaus();
        zzdmg zzdmg = new zzdmg((zzdmf) null);
        zzdmg.zzfvl = zzaus;
        zzdmg.zzhgb = str2;
        this.zzhfn = this.zzhdo.zza(new zzdkm(zzdmg), new zzdmc(this));
        zzdyr.zza(this.zzhfn, new zzdmf(this, zzcyn, zzdmg), this.zzfqx);
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaug() {
        this.zzhga.zzk(zzdoi.zza(zzdok.INVALID_AD_UNIT_ID, (String) null, (zzve) null));
    }

    /* access modifiers changed from: package-private */
    public final void zzec(int i) {
        this.zzgvo.zzaur().zzed(i);
    }
}
