package com.google.android.gms.internal.ads;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

final class zzcz implements Runnable {
    private zzcz() {
    }

    public final void run() {
        try {
            MessageDigest unused = zzcx.zznp = MessageDigest.getInstance("MD5");
        } catch (NoSuchAlgorithmException unused2) {
        } catch (Throwable th) {
            zzcx.zzns.countDown();
            throw th;
        }
        zzcx.zzns.countDown();
    }
}
