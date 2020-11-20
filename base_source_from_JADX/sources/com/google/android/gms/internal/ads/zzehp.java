package com.google.android.gms.internal.ads;

import java.security.Provider;
import java.security.Signature;

public final class zzehp implements zzehk<Signature> {
    public final /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? Signature.getInstance(str) : Signature.getInstance(str, provider);
    }
}
