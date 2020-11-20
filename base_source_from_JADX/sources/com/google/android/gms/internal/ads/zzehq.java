package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.Provider;

public final class zzehq implements zzehk<MessageDigest> {
    public final /* synthetic */ Object zza(String str, Provider provider) {
        return provider == null ? MessageDigest.getInstance(str) : MessageDigest.getInstance(str, provider);
    }
}
