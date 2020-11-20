package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.internal.ads.zzblm;
import com.google.android.gms.internal.ads.zzboc;
import com.google.android.gms.internal.ads.zzbrd;
import com.google.android.gms.internal.ads.zzbrg;
import com.google.android.gms.internal.ads.zzbwp;
import java.util.concurrent.Executor;
import javax.annotation.Nullable;
import javax.annotation.concurrent.GuardedBy;

public abstract class zzdil<AppOpenAd extends zzboc, AppOpenRequestComponent extends zzblm<AppOpenAd>, AppOpenRequestComponentBuilder extends zzbrd<AppOpenRequestComponent>> implements zzcyl<AppOpenAd> {
    /* access modifiers changed from: private */
    public final Executor zzfqx;
    private final ViewGroup zzfsx;
    @GuardedBy("this")
    private final zzdnp zzgvo;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    @Nullable
    public zzdyz<AppOpenAd> zzgvx;
    protected final zzbgm zzgxj;
    private final Context zzhdm;
    /* access modifiers changed from: private */
    public final zzdir zzhdn;
    /* access modifiers changed from: private */
    public final zzdkl<AppOpenRequestComponent, AppOpenAd> zzhdo;

    protected zzdil(Context context, Executor executor, zzbgm zzbgm, zzdkl<AppOpenRequestComponent, AppOpenAd> zzdkl, zzdir zzdir, zzdnp zzdnp) {
        this.zzhdm = context;
        this.zzfqx = executor;
        this.zzgxj = zzbgm;
        this.zzhdo = zzdkl;
        this.zzhdn = zzdir;
        this.zzgvo = zzdnp;
        this.zzfsx = new FrameLayout(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: zza */
    public final synchronized AppOpenRequestComponentBuilder zzb(zzdkk zzdkk) {
        zzdio zzdio = (zzdio) zzdkk;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyr)).booleanValue()) {
            return zza(new zzblz(this.zzfsx), new zzbrg.zza().zzcg(this.zzhdm).zza(zzdio.zzfvl).zzakx(), new zzbwp.zza().zzalt());
        }
        zzdir zzb = zzdir.zzb(this.zzhdn);
        zzbwp.zza zza = new zzbwp.zza();
        zza.zza((zzbrz) zzb, this.zzfqx);
        zza.zza((zzbto) zzb, this.zzfqx);
        zza.zza((zzp) zzb, this.zzfqx);
        zza.zza((zzdki) zzb);
        return zza(new zzblz(this.zzfsx), new zzbrg.zza().zzcg(this.zzhdm).zza(zzdio.zzfvl).zzakx(), zza.zzalt());
    }

    public final boolean isLoading() {
        zzdyz<AppOpenAd> zzdyz = this.zzgvx;
        return zzdyz != null && !zzdyz.isDone();
    }

    /* access modifiers changed from: protected */
    public abstract AppOpenRequestComponentBuilder zza(zzblz zzblz, zzbrg zzbrg, zzbwp zzbwp);

    public final void zza(zzvw zzvw) {
        this.zzgvo.zzb(zzvw);
    }

    public final synchronized boolean zza(zzvk zzvk, String str, zzcyo zzcyo, zzcyn<? super AppOpenAd> zzcyn) {
        Preconditions.checkMainThread("loadAd must be called on the main UI thread.");
        if (str == null) {
            zzd.zzey("Ad unit ID should not be null for app open ad.");
            this.zzfqx.execute(new zzdik(this));
            return false;
        } else if (this.zzgvx != null) {
            return false;
        } else {
            zzdob.zze(this.zzhdm, zzvk.zzchb);
            zzdnn zzaus = this.zzgvo.zzgq(str).zzf(zzvn.zzpq()).zzh(zzvk).zzaus();
            zzdio zzdio = new zzdio((zzdim) null);
            zzdio.zzfvl = zzaus;
            this.zzgvx = this.zzhdo.zza(new zzdkm(zzdio), new zzdin(this));
            zzdyr.zza(this.zzgvx, new zzdim(this, zzcyn, zzdio), this.zzfqx);
            return true;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzatv() {
        this.zzhdn.zzk(zzdoi.zza(zzdok.INVALID_AD_UNIT_ID, (String) null, (zzve) null));
    }
}
