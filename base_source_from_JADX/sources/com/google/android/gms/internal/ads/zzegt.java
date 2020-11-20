package com.google.android.gms.internal.ads;

import com.unboundid.ldap.protocol.LDAPMessage;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.security.GeneralSecurityException;
import java.security.InvalidKeyException;

abstract class zzegt implements zzehr {
    private static final int[] zzigd = zzq(new byte[]{LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, LDAPMessage.PROTOCOL_OP_TYPE_EXTENDED_RESPONSE, 112, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, 32, 51, 50, 45, 98, LDAPMessage.PROTOCOL_OP_TYPE_INTERMEDIATE_RESPONSE, 116, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, 32, LDAPMessage.PROTOCOL_OP_TYPE_DELETE_RESPONSE});
    int[] zzige;
    private final int zzigf;

    zzegt(byte[] bArr, int i) {
        if (bArr.length == 32) {
            this.zzige = zzq(bArr);
            this.zzigf = i;
            return;
        }
        throw new InvalidKeyException("The key length in bytes must be 32.");
    }

    private static int rotateLeft(int i, int i2) {
        return (i >>> (-i2)) | (i << i2);
    }

    private static void zza(int[] iArr, int i, int i2, int i3, int i4) {
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = rotateLeft(iArr[i4] ^ iArr[i], 16);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = rotateLeft(iArr[i2] ^ iArr[i3], 12);
        iArr[i] = iArr[i] + iArr[i2];
        iArr[i4] = rotateLeft(iArr[i] ^ iArr[i4], 8);
        iArr[i3] = iArr[i3] + iArr[i4];
        iArr[i2] = rotateLeft(iArr[i2] ^ iArr[i3], 7);
    }

    static void zza(int[] iArr, int[] iArr2) {
        int[] iArr3 = zzigd;
        System.arraycopy(iArr3, 0, iArr, 0, iArr3.length);
        System.arraycopy(iArr2, 0, iArr, zzigd.length, 8);
    }

    static void zzc(int[] iArr) {
        int[] iArr2 = iArr;
        for (int i = 0; i < 10; i++) {
            zza(iArr2, 0, 4, 8, 12);
            zza(iArr2, 1, 5, 9, 13);
            zza(iArr2, 2, 6, 10, 14);
            zza(iArr2, 3, 7, 11, 15);
            zza(iArr2, 0, 5, 10, 15);
            zza(iArr2, 1, 6, 11, 12);
            zza(iArr2, 2, 7, 8, 13);
            zza(iArr2, 3, 4, 9, 14);
        }
    }

    private static int[] zzq(byte[] bArr) {
        IntBuffer asIntBuffer = ByteBuffer.wrap(bArr).order(ByteOrder.LITTLE_ENDIAN).asIntBuffer();
        int[] iArr = new int[asIntBuffer.remaining()];
        asIntBuffer.get(iArr);
        return iArr;
    }

    /* access modifiers changed from: package-private */
    public final void zza(ByteBuffer byteBuffer, byte[] bArr) {
        if (byteBuffer.remaining() - zzbex() >= bArr.length) {
            byte[] zzfs = zzehx.zzfs(zzbex());
            byteBuffer.put(zzfs);
            ByteBuffer wrap = ByteBuffer.wrap(bArr);
            int remaining = wrap.remaining();
            int i = (remaining / 64) + 1;
            for (int i2 = 0; i2 < i; i2++) {
                ByteBuffer zze = zze(zzfs, this.zzigf + i2);
                if (i2 == i - 1) {
                    zzegr.zza(byteBuffer, wrap, zze, remaining % 64);
                } else {
                    zzegr.zza(byteBuffer, wrap, zze, 64);
                }
            }
            return;
        }
        throw new IllegalArgumentException("Given ByteBuffer output is too small");
    }

    /* access modifiers changed from: package-private */
    public abstract int[] zzb(int[] iArr, int i);

    /* access modifiers changed from: package-private */
    public abstract int zzbex();

    /* access modifiers changed from: package-private */
    public final ByteBuffer zze(byte[] bArr, int i) {
        int[] zzb = zzb(zzq(bArr), i);
        int[] iArr = (int[]) zzb.clone();
        zzc(iArr);
        for (int i2 = 0; i2 < zzb.length; i2++) {
            zzb[i2] = zzb[i2] + iArr[i2];
        }
        ByteBuffer order = ByteBuffer.allocate(64).order(ByteOrder.LITTLE_ENDIAN);
        order.asIntBuffer().put(zzb, 0, 16);
        return order;
    }

    public final byte[] zzn(byte[] bArr) {
        if (bArr.length <= Integer.MAX_VALUE - zzbex()) {
            ByteBuffer allocate = ByteBuffer.allocate(zzbex() + bArr.length);
            zza(allocate, bArr);
            return allocate.array();
        }
        throw new GeneralSecurityException("plaintext too long");
    }
}
