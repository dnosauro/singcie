package com.google.android.gms.internal.ads;

public class zzji {
    private int flags;

    public void clear() {
        this.flags = 0;
    }

    public final void setFlags(int i) {
        this.flags = i;
    }

    public final void zzaa(int i) {
        this.flags |= Integer.MIN_VALUE;
    }

    /* access modifiers changed from: protected */
    public final boolean zzab(int i) {
        return (this.flags & i) == i;
    }

    public final boolean zzgk() {
        return zzab(Integer.MIN_VALUE);
    }

    public final boolean zzgl() {
        return zzab(4);
    }

    public final boolean zzgm() {
        return zzab(1);
    }
}
