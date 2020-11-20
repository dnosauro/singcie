package com.google.android.gms.internal.ads;

import java.security.cert.X509Certificate;

final class zzg extends zzj {
    private byte[] zzj;

    public zzg(X509Certificate x509Certificate, byte[] bArr) {
        super(x509Certificate);
        this.zzj = bArr;
    }

    public final byte[] getEncoded() {
        return this.zzj;
    }
}
