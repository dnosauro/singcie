package com.google.android.gms.internal.ads;

import android.content.Context;
import android.view.View;
import com.google.android.gms.internal.ads.zzue;

public final class zzcao implements zzepf<zzcal> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzawx> zzfpf;
    private final zzeps<View> zzfqk;
    private final zzeps<zzue.zza.C3719zza> zzfrr;
    private final zzeps<zzawu> zzfuq;

    private zzcao(zzeps<zzawu> zzeps, zzeps<Context> zzeps2, zzeps<zzawx> zzeps3, zzeps<View> zzeps4, zzeps<zzue.zza.C3719zza> zzeps5) {
        this.zzfuq = zzeps;
        this.zzevi = zzeps2;
        this.zzfpf = zzeps3;
        this.zzfqk = zzeps4;
        this.zzfrr = zzeps5;
    }

    public static zzcao zzd(zzeps<zzawu> zzeps, zzeps<Context> zzeps2, zzeps<zzawx> zzeps3, zzeps<View> zzeps4, zzeps<zzue.zza.C3719zza> zzeps5) {
        return new zzcao(zzeps, zzeps2, zzeps3, zzeps4, zzeps5);
    }

    public final /* synthetic */ Object get() {
        return new zzcal(this.zzfuq.get(), this.zzevi.get(), this.zzfpf.get(), this.zzfqk.get(), this.zzfrr.get());
    }
}
