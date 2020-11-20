package com.google.android.gms.internal.ads;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.NoSuchElementException;

final class zzeml implements Iterator<zzejf> {
    private final ArrayDeque<zzemk> zziqz;
    private zzejf zzira;

    private zzeml(zzeiu zzeiu) {
        zzejf zzejf;
        if (zzeiu instanceof zzemk) {
            zzemk zzemk = (zzemk) zzeiu;
            this.zziqz = new ArrayDeque<>(zzemk.zzbfu());
            this.zziqz.push(zzemk);
            zzejf = zzal(zzemk.zziqv);
        } else {
            this.zziqz = null;
            zzejf = (zzejf) zzeiu;
        }
        this.zzira = zzejf;
    }

    /* synthetic */ zzeml(zzeiu zzeiu, zzemj zzemj) {
        this(zzeiu);
    }

    private final zzejf zzal(zzeiu zzeiu) {
        while (zzeiu instanceof zzemk) {
            zzemk zzemk = (zzemk) zzeiu;
            this.zziqz.push(zzemk);
            zzeiu = zzemk.zziqv;
        }
        return (zzejf) zzeiu;
    }

    public final boolean hasNext() {
        return this.zzira != null;
    }

    public final /* synthetic */ Object next() {
        zzejf zzejf;
        zzejf zzejf2 = this.zzira;
        if (zzejf2 != null) {
            while (true) {
                ArrayDeque<zzemk> arrayDeque = this.zziqz;
                if (arrayDeque != null && !arrayDeque.isEmpty()) {
                    zzejf = zzal(this.zziqz.pop().zziqw);
                    if (!zzejf.isEmpty()) {
                        break;
                    }
                } else {
                    zzejf = null;
                }
            }
            zzejf = null;
            this.zzira = zzejf;
            return zzejf2;
        }
        throw new NoSuchElementException();
    }

    public final void remove() {
        throw new UnsupportedOperationException();
    }
}
