package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.dynamic.IObjectWrapper;

final class zzcvs extends zzauz {
    private final /* synthetic */ zzbtr zzgtt;
    private final /* synthetic */ zzbrt zzgtu;
    private final /* synthetic */ zzbsu zzgtv;
    private final /* synthetic */ zzbyi zzgtw;

    zzcvs(zzcvo zzcvo, zzbtr zzbtr, zzbrt zzbrt, zzbsu zzbsu, zzbyi zzbyi) {
        this.zzgtt = zzbtr;
        this.zzgtu = zzbrt;
        this.zzgtv = zzbsu;
        this.zzgtw = zzbyi;
    }

    public final void zza(IObjectWrapper iObjectWrapper, zzava zzava) {
        this.zzgtw.zza(zzava);
    }

    public final void zzaf(IObjectWrapper iObjectWrapper) {
    }

    public final void zzag(IObjectWrapper iObjectWrapper) {
    }

    public final void zzah(IObjectWrapper iObjectWrapper) {
        this.zzgtt.zzux();
    }

    public final void zzai(IObjectWrapper iObjectWrapper) {
        this.zzgtw.zztl();
    }

    public final void zzaj(IObjectWrapper iObjectWrapper) {
        this.zzgtt.zza(zzl.OTHER);
    }

    public final void zzak(IObjectWrapper iObjectWrapper) {
        this.zzgtu.onAdClicked();
    }

    public final void zzal(IObjectWrapper iObjectWrapper) {
        this.zzgtv.onAdLeftApplication();
    }

    public final void zzam(IObjectWrapper iObjectWrapper) {
        this.zzgtv.onRewardedVideoCompleted();
    }

    public final void zzb(Bundle bundle) {
    }

    public final void zzd(IObjectWrapper iObjectWrapper, int i) {
    }

    public final void zze(IObjectWrapper iObjectWrapper, int i) {
    }
}
