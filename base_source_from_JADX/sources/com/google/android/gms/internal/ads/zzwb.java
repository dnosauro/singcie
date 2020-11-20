package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzwb extends zzwn<zzaxq> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzani zzcim;

    zzwb(zzvx zzvx, Context context, zzani zzani) {
        this.val$context = context;
        this.zzcim = zzani;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzpv */
    public final zzaxq zzpu() {
        try {
            return ((zzaxv) zzazd.zza(this.val$context, "com.google.android.gms.ads.DynamiteSignalGeneratorCreatorImpl", zzwe.zzbxv)).zze(ObjectWrapper.wrap(this.val$context), this.zzcim, 203404000);
        } catch (RemoteException | zzazf | NullPointerException unused) {
            return null;
        }
    }

    public final /* synthetic */ Object zza(zzxp zzxp) {
        return zzxp.zzb(ObjectWrapper.wrap(this.val$context), this.zzcim, 203404000);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zzpt() {
        return null;
    }
}
