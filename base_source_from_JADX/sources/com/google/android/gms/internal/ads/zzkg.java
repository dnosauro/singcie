package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzkg {
    public final int zzaox = 1;
    public final byte[] zzaoy;

    public zzkg(int i, byte[] bArr) {
        this.zzaoy = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzkg zzkg = (zzkg) obj;
            return this.zzaox == zzkg.zzaox && Arrays.equals(this.zzaoy, zzkg.zzaoy);
        }
    }

    public final int hashCode() {
        return (this.zzaox * 31) + Arrays.hashCode(this.zzaoy);
    }
}
