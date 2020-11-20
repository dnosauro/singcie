package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.dynamic.ObjectWrapper;

final class zzwd extends zzwn<zzaqw> {
    private final /* synthetic */ Context val$context;
    private final /* synthetic */ zzani zzcim;

    zzwd(zzvx zzvx, Context context, zzani zzani) {
        this.val$context = context;
        this.zzcim = zzani;
    }

    /* access modifiers changed from: private */
    /* renamed from: zzpw */
    public final zzaqw zzpu() {
        try {
            return ((zzarb) zzazd.zza(this.val$context, "com.google.android.gms.ads.DynamiteOfflineUtilsCreatorImpl", zzwg.zzbxv)).zzc(ObjectWrapper.wrap(this.val$context), this.zzcim, 203404000);
        } catch (RemoteException | zzazf | NullPointerException unused) {
            return null;
        }
    }

    public final /* synthetic */ Object zza(zzxp zzxp) {
        return zzxp.zzc(ObjectWrapper.wrap(this.val$context), this.zzcim, 203404000);
    }

    /* access modifiers changed from: protected */
    public final /* bridge */ /* synthetic */ Object zzpt() {
        return null;
    }
}
