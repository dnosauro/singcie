package com.google.android.gms.internal.ads;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.GeneralSecurityException;

abstract class zzegv implements zzdzt {
    private final zzegt zzigg;
    private final zzegt zzigh;

    public zzegv(byte[] bArr) {
        this.zzigg = zzf(bArr, 1);
        this.zzigh = zzf(bArr, 0);
    }

    public byte[] zzc(byte[] bArr, byte[] bArr2) {
        if (bArr.length <= (Integer.MAX_VALUE - this.zzigg.zzbex()) - 16) {
            ByteBuffer allocate = ByteBuffer.allocate(bArr.length + this.zzigg.zzbex() + 16);
            if (allocate.remaining() >= bArr.length + this.zzigg.zzbex() + 16) {
                int position = allocate.position();
                this.zzigg.zza(allocate, bArr);
                allocate.position(position);
                byte[] bArr3 = new byte[this.zzigg.zzbex()];
                allocate.get(bArr3);
                allocate.limit(allocate.limit() - 16);
                if (bArr2 == null) {
                    bArr2 = new byte[0];
                }
                byte[] bArr4 = new byte[32];
                this.zzigh.zze(bArr3, 0).get(bArr4);
                int length = bArr2.length % 16 == 0 ? bArr2.length : (bArr2.length + 16) - (bArr2.length % 16);
                int remaining = allocate.remaining();
                int i = remaining % 16;
                int i2 = (i == 0 ? remaining : (remaining + 16) - i) + length;
                ByteBuffer order = ByteBuffer.allocate(i2 + 16).order(ByteOrder.LITTLE_ENDIAN);
                order.put(bArr2);
                order.position(length);
                order.put(allocate);
                order.position(i2);
                order.putLong((long) bArr2.length);
                order.putLong((long) remaining);
                byte[] zze = zzehu.zze(bArr4, order.array());
                allocate.limit(allocate.limit() + 16);
                allocate.put(zze);
                return allocate.array();
            }
            throw new IllegalArgumentException("Given ByteBuffer output is too small");
        }
        throw new GeneralSecurityException("plaintext too long");
    }

    /* access modifiers changed from: package-private */
    public abstract zzegt zzf(byte[] bArr, int i);
}
