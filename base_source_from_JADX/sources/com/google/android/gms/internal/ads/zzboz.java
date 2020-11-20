package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

public final class zzboz<T> {
    private final Executor executor;
    private final zzcne zzfvj;
    private final zzcno zzfvk;
    private final zzdnn zzfvl;
    private final zzdro zzfvm;
    private final zzbjo zzfvn;
    private final zzcup<T> zzfvo;
    /* access modifiers changed from: private */
    public final zzbwd zzfvp;
    private final zzdnj zzfvq;
    private final zzcok zzfvr;
    private final zzbqz zzfvs;
    private final zzcod zzfvt;
    private final zzcrg zzfvu;

    zzboz(zzcne zzcne, zzcno zzcno, zzdnn zzdnn, zzdro zzdro, zzbjo zzbjo, zzcup<T> zzcup, zzbwd zzbwd, zzdnj zzdnj, zzcok zzcok, zzbqz zzbqz, Executor executor2, zzcod zzcod, zzcrg zzcrg) {
        this.zzfvj = zzcne;
        this.zzfvk = zzcno;
        this.zzfvl = zzdnn;
        this.zzfvm = zzdro;
        this.zzfvn = zzbjo;
        this.zzfvo = zzcup;
        this.zzfvp = zzbwd;
        this.zzfvq = zzdnj;
        this.zzfvr = zzcok;
        this.zzfvs = zzbqz;
        this.executor = executor2;
        this.zzfvt = zzcod;
        this.zzfvu = zzcrg;
    }

    private final zzdyz<zzdnj> zza(zzdyz<zzatl> zzdyz) {
        zzdrg<I> zza;
        zzdyb zzdyb;
        zzdrg<O2> zza2;
        zzdre zzu;
        zzdyz zzaqz;
        if (this.zzfvq != null) {
            zzu = this.zzfvm.zzu(zzdrl.SERVER_TRANSACTION);
            zzaqz = zzdyr.zzag(this.zzfvq);
        } else {
            zzp.zzkw().zzmu();
            if (this.zzfvl.zzhio.zzchn != null) {
                zzu = this.zzfvm.zzu(zzdrl.SERVER_TRANSACTION);
                zzaqz = this.zzfvk.zzaqz();
            } else {
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcyu)).booleanValue()) {
                    zza = this.zzfvm.zza(zzdrl.SERVER_TRANSACTION, zzdyz);
                    zzcod zzcod = this.zzfvt;
                    zzcod.getClass();
                    zzdyb = zzbpc.zza(zzcod);
                } else {
                    zza = this.zzfvm.zza(zzdrl.SERVER_TRANSACTION, zzdyz);
                    zzdyb = this.zzfvj;
                }
                zza2 = zza.zza(zzdyb);
                return zza2.zzaww();
            }
        }
        zza2 = zzu.zze(zzaqz);
        return zza2.zzaww();
    }

    public final zzdyz<zzdnj> zza(zzatl zzatl) {
        return zza((zzdyz<zzatl>) zzdyr.zzag(zzatl));
    }

    public final zzdyz<zzatl> zza(zzdpk zzdpk) {
        zzdqx<E, O2> zzaww = this.zzfvm.zza(zzdrl.GET_CACHE_KEY, this.zzfvs.zzakr()).zza(new zzbpb(this, zzdpk)).zzaww();
        zzdyr.zza(zzaww, new zzbpe(this), this.executor);
        return zzaww;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzdpk zzdpk, zzatl zzatl) {
        zzatl.zzdwa = zzdpk;
        return this.zzfvr.zzl(zzatl);
    }

    public final zzdyz<zzdnj> zzaki() {
        return zza(this.zzfvs.zzakr());
    }

    public final zzdyz<T> zzakj() {
        return zzb(zzaki());
    }

    public final zzbwd zzakk() {
        return this.zzfvp;
    }

    public final zzdyz<T> zzb(zzatl zzatl) {
        return zzb(zza(zzatl));
    }

    public final zzdyz<T> zzb(zzdyz<zzdnj> zzdyz) {
        zzdrg<O2> zza;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvi)).booleanValue()) {
            zza = this.zzfvm.zza(zzdrl.RENDERER, zzdyz).zza(this.zzfvn).zza(this.zzfvo);
        } else {
            zza = this.zzfvm.zza(zzdrl.RENDERER, zzdyz).zza(this.zzfvn).zza(this.zzfvo).zza((long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcvj)).intValue(), TimeUnit.SECONDS);
        }
        return zza.zzaww();
    }

    public final zzdyz<Void> zzc(zzatl zzatl) {
        zzdqx<E, I> zzaww = this.zzfvm.zza(zzdrl.NOTIFY_CACHE_HIT, this.zzfvr.zzm(zzatl)).zzaww();
        zzdyr.zza(zzaww, new zzbpd(this), this.executor);
        return zzaww;
    }

    public final zzve zze(Throwable th) {
        return zzdoi.zza(th, this.zzfvu);
    }
}
