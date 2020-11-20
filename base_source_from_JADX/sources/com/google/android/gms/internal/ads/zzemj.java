package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzemj extends zzeiz {
    private final zzeml zziqq = new zzeml(this.zziqs, (zzemj) null);
    private zzejd zziqr = zzbjq();
    private final /* synthetic */ zzemk zziqs;

    zzemj(zzemk zzemk) {
        this.zziqs = zzemk;
    }

    private final zzejd zzbjq() {
        if (this.zziqq.hasNext()) {
            return (zzejd) ((zzejf) this.zziqq.next()).iterator();
        }
        return null;
    }

    public final boolean hasNext() {
        return this.zziqr != null;
    }

    public final byte nextByte() {
        zzejd zzejd = this.zziqr;
        if (zzejd != null) {
            byte nextByte = zzejd.nextByte();
            if (!this.zziqr.hasNext()) {
                this.zziqr = zzbjq();
            }
            return nextByte;
        }
        throw new NoSuchElementException();
    }
}
