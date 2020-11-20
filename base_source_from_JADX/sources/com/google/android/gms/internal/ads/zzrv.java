package com.google.android.gms.internal.ads;

import android.util.Base64OutputStream;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

@VisibleForTesting
final class zzrv {
    @VisibleForTesting
    private ByteArrayOutputStream zzbtw = new ByteArrayOutputStream(4096);
    @VisibleForTesting
    private Base64OutputStream zzbtx = new Base64OutputStream(this.zzbtw, 10);

    public final String toString() {
        String str;
        try {
            this.zzbtx.close();
        } catch (IOException e) {
            zzd.zzc("HashManager: Unable to convert to Base64.", e);
        }
        try {
            this.zzbtw.close();
            str = this.zzbtw.toString();
        } catch (IOException e2) {
            zzd.zzc("HashManager: Unable to convert to Base64.", e2);
            str = "";
        } catch (Throwable th) {
            this.zzbtw = null;
            this.zzbtx = null;
            throw th;
        }
        this.zzbtw = null;
        this.zzbtx = null;
        return str;
    }

    public final void write(byte[] bArr) {
        this.zzbtx.write(bArr);
    }
}
