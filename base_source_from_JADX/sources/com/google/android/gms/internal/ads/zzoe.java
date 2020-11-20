package com.google.android.gms.internal.ads;

import java.util.Arrays;

public final class zzoe {
    public final int length;
    private int zzaht;
    private final zzoc[] zzbhs;

    public zzoe(zzoc... zzocArr) {
        this.zzbhs = zzocArr;
        this.length = zzocArr.length;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbhs, ((zzoe) obj).zzbhs);
    }

    public final int hashCode() {
        if (this.zzaht == 0) {
            this.zzaht = Arrays.hashCode(this.zzbhs) + 527;
        }
        return this.zzaht;
    }

    public final zzoc zzbe(int i) {
        return this.zzbhs[i];
    }

    public final zzoc[] zzim() {
        return (zzoc[]) this.zzbhs.clone();
    }
}
