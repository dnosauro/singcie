package com.google.android.gms.internal.ads;

import java.security.KeyFactory;
import java.security.Provider;

public final class zzehl implements zzehk<KeyFactory> {
    public final /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? KeyFactory.getInstance(str) : KeyFactory.getInstance(str, provider);
    }
}
