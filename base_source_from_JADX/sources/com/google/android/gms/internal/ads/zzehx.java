package com.google.android.gms.internal.ads;

import java.security.SecureRandom;

public final class zzehx {
    private static final ThreadLocal<SecureRandom> zzihx = new zzeia();

    /* access modifiers changed from: private */
    public static SecureRandom zzbfc() {
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextLong();
        return secureRandom;
    }

    public static byte[] zzfs(int i) {
        byte[] bArr = new byte[i];
        zzihx.get().nextBytes(bArr);
        return bArr;
    }
}
