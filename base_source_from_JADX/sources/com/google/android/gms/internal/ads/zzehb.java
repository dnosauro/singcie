package com.google.android.gms.internal.ads;

public final class zzehb {
    private final zzehs zzigp;
    private final zzehs zzigq;

    public zzehb(byte[] bArr, byte[] bArr2) {
        this.zzigp = zzehs.zzr(bArr);
        this.zzigq = zzehs.zzr(bArr2);
    }

    public final byte[] zzbey() {
        zzehs zzehs = this.zzigp;
        if (zzehs == null) {
            return null;
        }
        return zzehs.getBytes();
    }

    public final byte[] zzbez() {
        zzehs zzehs = this.zzigq;
        if (zzehs == null) {
            return null;
        }
        return zzehs.getBytes();
    }
}
