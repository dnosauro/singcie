package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public abstract class zzrq {
    private static MessageDigest zzbtq;
    protected Object mLock = new Object();

    /* access modifiers changed from: package-private */
    public abstract byte[] zzbp(String str);

    /* access modifiers changed from: protected */
    public final MessageDigest zzmm() {
        synchronized (this.mLock) {
            if (zzbtq != null) {
                MessageDigest messageDigest = zzbtq;
                return messageDigest;
            }
            for (int i = 0; i < 2; i++) {
                try {
                    zzbtq = MessageDigest.getInstance("MD5");
                } catch (NoSuchAlgorithmException unused) {
                }
            }
            MessageDigest messageDigest2 = zzbtq;
            return messageDigest2;
        }
    }
}
