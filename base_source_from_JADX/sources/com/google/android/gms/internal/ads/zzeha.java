package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.security.interfaces.ECPublicKey;

public final class zzeha implements zzeaa {
    private static final byte[] zziac = new byte[0];
    private final String zzigk;
    private final byte[] zzigl;
    private final zzehf zzigm;
    private final zzegy zzign;
    private final zzehc zzigo;

    public zzeha(ECPublicKey eCPublicKey, byte[] bArr, String str, zzehf zzehf, zzegy zzegy) {
        zzehe.zza(eCPublicKey.getW(), eCPublicKey.getParams().getCurve());
        this.zzigo = new zzehc(eCPublicKey);
        this.zzigl = bArr;
        this.zzigk = str;
        this.zzigm = zzehf;
        this.zzign = zzegy;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        zzehb zza = this.zzigo.zza(this.zzigk, this.zzigl, bArr2, this.zzign.zzbal(), this.zzigm);
        byte[] zzc = this.zzign.zzm(zza.zzbez()).zzc(bArr, zziac);
        byte[] zzbey = zza.zzbey();
        return ByteBuffer.allocate(zzbey.length + zzc.length).put(zzbey).put(zzc).array();
    }
}
