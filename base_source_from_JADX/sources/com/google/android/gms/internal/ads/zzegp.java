package com.google.android.gms.internal.ads;

import java.security.GeneralSecurityException;
import javax.crypto.Cipher;

final class zzegp extends ThreadLocal<Cipher> {
    zzegp() {
    }

    private static Cipher zzbak() {
        try {
            return zzehh.zzihd.zzhq("AES/GCM/NoPadding");
        } catch (GeneralSecurityException e) {
            throw new IllegalStateException(e);
        }
    }

    /* access modifiers changed from: protected */
    public final /* synthetic */ Object initialValue() {
        return zzbak();
    }
}
