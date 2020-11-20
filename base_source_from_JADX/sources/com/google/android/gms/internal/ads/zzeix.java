package com.google.android.gms.internal.ads;

import java.util.NoSuchElementException;

final class zzeix extends zzeiz {
    private final int limit = this.zzijb.size();
    private int position = 0;
    private final /* synthetic */ zzeiu zzijb;

    zzeix(zzeiu zzeiu) {
        this.zzijb = zzeiu;
    }

    public final boolean hasNext() {
        return this.position < this.limit;
    }

    public final byte nextByte() {
        int i = this.position;
        if (i < this.limit) {
            this.position = i + 1;
            return this.zzijb.zzfz(i);
        }
        throw new NoSuchElementException();
    }
}
