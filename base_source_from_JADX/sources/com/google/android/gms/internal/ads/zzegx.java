package com.google.android.gms.internal.ads;

import java.security.interfaces.ECPrivateKey;

public final class zzegx implements zzdzx {
    private static final byte[] zziac = new byte[0];
    private final ECPrivateKey zzigi;
    private final zzegz zzigj;
    private final String zzigk;
    private final byte[] zzigl;
    private final zzehf zzigm;
    private final zzegy zzign;

    public zzegx(ECPrivateKey eCPrivateKey, byte[] bArr, String str, zzehf zzehf, zzegy zzegy) {
        this.zzigi = eCPrivateKey;
        this.zzigj = new zzegz(eCPrivateKey);
        this.zzigl = bArr;
        this.zzigk = str;
        this.zzigm = zzehf;
        this.zzign = zzegy;
    }
}
