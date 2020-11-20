package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Arrays;

final class zzemm {
    private final ArrayDeque<zzeiu> zzirb;

    private zzemm() {
        this.zzirb = new ArrayDeque<>();
    }

    /* synthetic */ zzemm(zzemj zzemj) {
        this();
    }

    private final void zzam(zzeiu zzeiu) {
        while (!zzeiu.zzbfv()) {
            if (zzeiu instanceof zzemk) {
                zzemk zzemk = (zzemk) zzeiu;
                zzam(zzemk.zziqv);
                zzeiu = zzemk.zziqw;
            } else {
                String valueOf = String.valueOf(zzeiu.getClass());
                StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 49);
                sb.append("Has a new type of ByteString been created? Found ");
                sb.append(valueOf);
                throw new IllegalArgumentException(sb.toString());
            }
        }
        int zzhr = zzhr(zzeiu.size());
        int zzhq = zzemk.zzhq(zzhr + 1);
        if (this.zzirb.isEmpty() || this.zzirb.peek().size() >= zzhq) {
            this.zzirb.push(zzeiu);
            return;
        }
        int zzhq2 = zzemk.zzhq(zzhr);
        zzeiu pop = this.zzirb.pop();
        while (!this.zzirb.isEmpty() && this.zzirb.peek().size() < zzhq2) {
            pop = new zzemk(this.zzirb.pop(), pop, (zzemj) null);
        }
        zzemk zzemk2 = new zzemk(pop, zzeiu, (zzemj) null);
        while (!this.zzirb.isEmpty() && this.zzirb.peek().size() < zzemk.zzhq(zzhr(zzemk2.size()) + 1)) {
            zzemk2 = new zzemk(this.zzirb.pop(), zzemk2, (zzemj) null);
        }
        this.zzirb.push(zzemk2);
    }

    /* access modifiers changed from: private */
    public final zzeiu zzc(zzeiu zzeiu, zzeiu zzeiu2) {
        zzam(zzeiu);
        zzam(zzeiu2);
        zzeiu pop = this.zzirb.pop();
        while (!this.zzirb.isEmpty()) {
            pop = new zzemk(this.zzirb.pop(), pop, (zzemj) null);
        }
        return pop;
    }

    private static int zzhr(int i) {
        int binarySearch = Arrays.binarySearch(zzemk.zziqt, i);
        return binarySearch < 0 ? (-(binarySearch + 1)) - 1 : binarySearch;
    }
}
