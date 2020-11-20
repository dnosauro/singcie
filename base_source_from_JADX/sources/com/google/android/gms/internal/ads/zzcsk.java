package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzcsk extends zzapf {
    private zzcrb<zzapo, zzcst> zzgrp;
    private final /* synthetic */ zzcsf zzgrq;

    private zzcsk(zzcsf zzcsf, zzcrb<zzapo, zzcst> zzcrb) {
        this.zzgrq = zzcsf;
        this.zzgrp = zzcrb;
    }

    public final void zzdm(String str) {
        ((zzcst) this.zzgrp.zzgqp).zzc(0, str);
    }

    public final void zzf(zzve zzve) {
        ((zzcst) this.zzgrp.zzgqp).zzc(zzve);
    }

    public final void zzx(IObjectWrapper iObjectWrapper) {
        View unused = this.zzgrq.view = (View) ObjectWrapper.unwrap(iObjectWrapper);
        ((zzcst) this.zzgrp.zzgqp).onAdLoaded();
    }
}
