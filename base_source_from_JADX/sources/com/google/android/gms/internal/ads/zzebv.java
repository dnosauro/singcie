package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;

public final class zzebv implements zzdzt {
    private static final byte[] zziac = new byte[0];
    private final zzefn zziad;
    private final zzdzt zziae;

    public zzebv(zzefn zzefn, zzdzt zzdzt) {
        this.zziad = zzefn;
        this.zziae = zzdzt;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] byteArray = zzeap.zzb(this.zziad).toByteArray();
        byte[] zzc = this.zziae.zzc(byteArray, zziac);
        byte[] zzc2 = ((zzdzt) zzeap.zza(this.zziad.zzbdf(), byteArray, zzdzt.class)).zzc(bArr, bArr2);
        return ByteBuffer.allocate(zzc.length + 4 + zzc2.length).putInt(zzc.length).put(zzc).put(zzc2).array();
    }
}
