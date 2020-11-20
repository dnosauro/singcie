package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

public final class zzbwa implements zzepf<zzbvy> {
    private final zzeps<Set<zzbxy<AppEventListener>>> zzftr;

    private zzbwa(zzeps<Set<zzbxy<AppEventListener>>> zzeps) {
        this.zzftr = zzeps;
    }

    public static zzbwa zzr(zzeps<Set<zzbxy<AppEventListener>>> zzeps) {
        return new zzbwa(zzeps);
    }

    public final /* synthetic */ Object get() {
        return new zzbvy(this.zzftr.get());
    }
}
