package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.util.Arrays;

public final class zzehi implements zzdzt {
    private final zzehr zzihn;
    private final zzeak zziho;
    private final int zzihp;

    public zzehi(zzehr zzehr, zzeak zzeak, int i) {
        this.zzihn = zzehr;
        this.zziho = zzeak;
        this.zzihp = i;
    }

    public final byte[] zzc(byte[] bArr, byte[] bArr2) {
        byte[] zzn = this.zzihn.zzn(bArr);
        if (bArr2 == null) {
            bArr2 = new byte[0];
        }
        byte[] copyOf = Arrays.copyOf(ByteBuffer.allocate(8).putLong(((long) bArr2.length) * 8).array(), 8);
        return zzegr.zza(zzn, this.zziho.zzl(zzegr.zza(bArr2, zzn, copyOf)));
    }
}
