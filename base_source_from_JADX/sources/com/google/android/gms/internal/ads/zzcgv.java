package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Executor;

public final class zzcgv implements zzepf<zzcgu> {
    private final zzeps<Context> zzevi;
    private final zzeps<zzdrz> zzewl;
    private final zzeps<zzckq> zzewm;
    private final zzeps<Executor> zzftl;
    private final zzeps<zzazh> zzfxq;
    private final zzeps<zzef> zzgbn;
    private final zzeps<zzb> zzggu;
    private final zzeps<zzbed> zzghz;
    private final zzeps<zzcqo> zzgia;

    public zzcgv(zzeps<Context> zzeps, zzeps<Executor> zzeps2, zzeps<zzef> zzeps3, zzeps<zzazh> zzeps4, zzeps<zzb> zzeps5, zzeps<zzbed> zzeps6, zzeps<zzcqo> zzeps7, zzeps<zzdrz> zzeps8, zzeps<zzckq> zzeps9) {
        this.zzevi = zzeps;
        this.zzftl = zzeps2;
        this.zzgbn = zzeps3;
        this.zzfxq = zzeps4;
        this.zzggu = zzeps5;
        this.zzghz = zzeps6;
        this.zzgia = zzeps7;
        this.zzewl = zzeps8;
        this.zzewm = zzeps9;
    }

    public final /* synthetic */ Object get() {
        return new zzcgu(this.zzevi.get(), this.zzftl.get(), this.zzgbn.get(), this.zzfxq.get(), this.zzggu.get(), this.zzghz.get(), this.zzgia.get(), this.zzewl.get(), this.zzewm.get());
    }
}
