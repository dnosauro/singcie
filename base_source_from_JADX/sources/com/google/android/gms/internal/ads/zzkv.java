package com.google.android.gms.internal.ads;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

final class zzkv extends zzks {
    public final long zzawh;
    public final List<zzku> zzawi = new ArrayList();
    public final List<zzkv> zzawj = new ArrayList();

    public zzkv(int i, long j) {
        super(i);
        this.zzawh = j;
    }

    public final String toString() {
        String zzaq = zzaq(this.type);
        String arrays = Arrays.toString(this.zzawi.toArray());
        String arrays2 = Arrays.toString(this.zzawj.toArray());
        StringBuilder sb = new StringBuilder(String.valueOf(zzaq).length() + 22 + String.valueOf(arrays).length() + String.valueOf(arrays2).length());
        sb.append(zzaq);
        sb.append(" leaves: ");
        sb.append(arrays);
        sb.append(" containers: ");
        sb.append(arrays2);
        return sb.toString();
    }

    public final void zza(zzku zzku) {
        this.zzawi.add(zzku);
    }

    public final void zza(zzkv zzkv) {
        this.zzawj.add(zzkv);
    }

    public final zzku zzas(int i) {
        int size = this.zzawi.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzku zzku = this.zzawi.get(i2);
            if (zzku.type == i) {
                return zzku;
            }
        }
        return null;
    }

    public final zzkv zzat(int i) {
        int size = this.zzawj.size();
        for (int i2 = 0; i2 < size; i2++) {
            zzkv zzkv = this.zzawj.get(i2);
            if (zzkv.type == i) {
                return zzkv;
            }
        }
        return null;
    }
}
