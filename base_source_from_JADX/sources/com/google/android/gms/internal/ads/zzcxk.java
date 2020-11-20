package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.formats.PublisherAdViewOptions;
import com.google.android.gms.common.util.VisibleForTesting;

public final class zzcxk extends zzxc {
    private zzwt zzbpi;
    private final zzbgm zzgss;
    private final Context zzgvn;
    @VisibleForTesting
    private final zzdnp zzgvo = new zzdnp();
    @VisibleForTesting
    private final zzccn zzgvp = new zzccn();

    public zzcxk(zzbgm zzbgm, Context context, String str) {
        this.zzgss = zzbgm;
        this.zzgvo.zzgq(str);
        this.zzgvn = context;
    }

    public final void zza(PublisherAdViewOptions publisherAdViewOptions) {
        this.zzgvo.zzb(publisherAdViewOptions);
    }

    public final void zza(zzadz zzadz) {
        this.zzgvo.zzb(zzadz);
    }

    public final void zza(zzafj zzafj) {
        this.zzgvp.zzb(zzafj);
    }

    public final void zza(zzafk zzafk) {
        this.zzgvp.zzb(zzafk);
    }

    public final void zza(zzafx zzafx, zzvn zzvn) {
        this.zzgvp.zza(zzafx);
        this.zzgvo.zzf(zzvn);
    }

    public final void zza(zzafy zzafy) {
        this.zzgvp.zzb(zzafy);
    }

    public final void zza(zzajl zzajl) {
        this.zzgvo.zzb(zzajl);
    }

    public final void zza(zzajt zzajt) {
        this.zzgvp.zzb(zzajt);
    }

    public final void zza(String str, zzafq zzafq, zzafp zzafp) {
        this.zzgvp.zzb(str, zzafq, zzafp);
    }

    public final void zzb(zzwt zzwt) {
        this.zzbpi = zzwt;
    }

    public final void zzb(zzxu zzxu) {
        this.zzgvo.zzc(zzxu);
    }

    public final zzwy zzqj() {
        zzccl zzany = this.zzgvp.zzany();
        this.zzgvo.zzc(zzany.zzanw());
        this.zzgvo.zzd(zzany.zzanx());
        zzdnp zzdnp = this.zzgvo;
        if (zzdnp.zzkf() == null) {
            zzdnp.zzf(zzvn.zzpo());
        }
        return new zzcxj(this.zzgvn, this.zzgss, this.zzgvo, zzany, this.zzbpi);
    }
}
