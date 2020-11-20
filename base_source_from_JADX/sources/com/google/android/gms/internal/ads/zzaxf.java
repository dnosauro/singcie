package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.dynamic.ObjectWrapper;

final /* synthetic */ class zzaxf implements zzaxn {
    private final Context zzclq;
    private final String zzdha;

    zzaxf(Context context, String str) {
        this.zzclq = context;
        this.zzdha = str;
    }

    public final void zza(zzbgf zzbgf) {
        Context context = this.zzclq;
        zzbgf.zzb(ObjectWrapper.wrap(context), this.zzdha, context.getPackageName());
    }
}
