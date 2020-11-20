package com.google.android.gms.internal.ads;

import android.content.Context;
import java.lang.ref.WeakReference;

public final class zzbgr implements zzepf<WeakReference<Context>> {
    private final zzbgl zzevc;

    public zzbgr(zzbgl zzbgl) {
        this.zzevc = zzbgl;
    }

    public final /* synthetic */ Object get() {
        return (WeakReference) zzepl.zza(this.zzevc.zzaeg(), "Cannot return null from a non-@Nullable @Provides method");
    }
}
