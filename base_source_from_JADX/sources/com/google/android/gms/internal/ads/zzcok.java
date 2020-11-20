package com.google.android.gms.internal.ads;

import android.os.Binder;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import java.io.InputStream;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;

public final class zzcok {
    private final zzdzc zzggb;
    private final zzeoz<zzcou> zzgmb;
    private final zzcnx zzgnv;

    public zzcok(zzdzc zzdzc, zzcnx zzcnx, zzeoz<zzcou> zzeoz) {
        this.zzggb = zzdzc;
        this.zzgnv = zzcnx;
        this.zzgmb = zzeoz;
    }

    private final <RetT> zzdyz<RetT> zza(zzatl zzatl, zzcor<InputStream> zzcor, zzcor<InputStream> zzcor2, zzdyb<InputStream, RetT> zzdyb) {
        String str = zzatl.packageName;
        zzp.zzkq();
        return zzdyi.zzg(zzm.zzen(str) ? zzdyr.immediateFailedFuture(new zzcoh(zzdok.INTERNAL_ERROR)) : zzdyr.zzb(zzcor.zzq(zzatl), ExecutionException.class, zzcoj.zzbon, this.zzggb)).zzb(zzdyb, this.zzggb).zza(zzcoh.class, new zzcom(this, zzcor2, zzatl, zzdyb), (Executor) this.zzggb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzcor zzcor, zzatl zzatl, zzdyb zzdyb, zzcoh zzcoh) {
        return zzdyr.zzb(zzcor.zzq(zzatl), zzdyb, (Executor) this.zzggb);
    }

    public final zzdyz<zzatl> zzl(zzatl zzatl) {
        zzcol zzcol = new zzcol(zzatl);
        zzcnx zzcnx = this.zzgnv;
        zzcnx.getClass();
        return zza(zzatl, (zzcor<InputStream>) zzcoo.zza(zzcnx), (zzcor<InputStream>) new zzcon(this), zzcol);
    }

    public final zzdyz<Void> zzm(zzatl zzatl) {
        if (zzff.zzar(zzatl.zzdwb)) {
            return zzdyr.immediateFailedFuture(new zzcme(zzdok.INVALID_REQUEST, "Pool key missing from removeUrl call."));
        }
        return zza(zzatl, (zzcor<InputStream>) new zzcop(this), (zzcor<InputStream>) new zzcos(this), zzcoq.zzbon);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzn(zzatl zzatl) {
        return this.zzgmb.get().zzgj(zzatl.zzdwb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzo(zzatl zzatl) {
        return this.zzgnv.zzgi(zzatl.zzdwb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzp(zzatl zzatl) {
        return this.zzgmb.get().zzc(zzatl, Binder.getCallingUid());
    }
}
