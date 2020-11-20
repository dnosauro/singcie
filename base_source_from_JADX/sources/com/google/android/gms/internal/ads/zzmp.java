package com.google.android.gms.internal.ads;

public final class zzmp implements zznm {
    private final zznm[] zzbeh;

    public zzmp(zznm[] zznmArr) {
        this.zzbeh = zznmArr;
    }

    public final boolean zzef(long j) {
        boolean z;
        boolean z2 = false;
        do {
            long zzhp = zzhp();
            if (zzhp == Long.MIN_VALUE) {
                break;
            }
            z = false;
            for (zznm zznm : this.zzbeh) {
                if (zznm.zzhp() == zzhp) {
                    z |= zznm.zzef(j);
                }
            }
            z2 |= z;
        } while (z);
        return z2;
    }

    public final long zzhp() {
        long j = Long.MAX_VALUE;
        for (zznm zzhp : this.zzbeh) {
            long zzhp2 = zzhp.zzhp();
            if (zzhp2 != Long.MIN_VALUE) {
                j = Math.min(j, zzhp2);
            }
        }
        if (j == Long.MAX_VALUE) {
            return Long.MIN_VALUE;
        }
        return j;
    }
}
