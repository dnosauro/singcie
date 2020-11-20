package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import java.util.Set;

public final class zzbvy extends zzbwk<AppEventListener> implements zzaha {
    public zzbvy(Set<zzbxy<AppEventListener>> set) {
        super(set);
    }

    public final synchronized void onAppEvent(String str, String str2) {
        zza(new zzbwb(str, str2));
    }
}
