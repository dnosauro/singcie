package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zzb;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

public final class zzcgu implements Callable<zzcgh> {
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final zzbed zzbpq;
    /* access modifiers changed from: private */
    public final zzckq zzdgx;
    /* access modifiers changed from: private */
    public final zzcqo zzdgz;
    /* access modifiers changed from: private */
    public final zzazh zzdsm;
    /* access modifiers changed from: private */
    public final zzef zzerb;
    /* access modifiers changed from: private */
    public final zzdrz zzfqa;
    /* access modifiers changed from: private */
    public final Executor zzfqx;
    /* access modifiers changed from: private */
    public final zzb zzggo;

    public zzcgu(Context context2, Executor executor, zzef zzef, zzazh zzazh, zzb zzb, zzbed zzbed, zzcqo zzcqo, zzdrz zzdrz, zzckq zzckq) {
        this.context = context2;
        this.zzfqx = executor;
        this.zzerb = zzef;
        this.zzdsm = zzazh;
        this.zzggo = zzb;
        this.zzbpq = zzbed;
        this.zzdgz = zzcqo;
        this.zzfqa = zzdrz;
        this.zzdgx = zzckq;
    }

    public final /* synthetic */ Object call() {
        zzcgh zzcgh = new zzcgh(this);
        zzcgh.zzaou();
        return zzcgh;
    }
}
