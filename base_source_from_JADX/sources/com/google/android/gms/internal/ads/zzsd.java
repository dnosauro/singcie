package com.google.android.gms.internal.ads;

import java.util.Comparator;

public final class zzsd implements Comparator<zzrr> {
    public zzsd(zzsa zzsa) {
    }

    public final /* synthetic */ int compare(Object obj, Object obj2) {
        zzrr zzrr = (zzrr) obj;
        zzrr zzrr2 = (zzrr) obj2;
        if (zzrr.zzmo() < zzrr2.zzmo()) {
            return -1;
        }
        if (zzrr.zzmo() > zzrr2.zzmo()) {
            return 1;
        }
        if (zzrr.zzmn() < zzrr2.zzmn()) {
            return -1;
        }
        if (zzrr.zzmn() > zzrr2.zzmn()) {
            return 1;
        }
        float zzmq = (zzrr.zzmq() - zzrr.zzmo()) * (zzrr.zzmp() - zzrr.zzmn());
        float zzmq2 = (zzrr2.zzmq() - zzrr2.zzmo()) * (zzrr2.zzmp() - zzrr2.zzmn());
        if (zzmq > zzmq2) {
            return -1;
        }
        return zzmq < zzmq2 ? 1 : 0;
    }
}
