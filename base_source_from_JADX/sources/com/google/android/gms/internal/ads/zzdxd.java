package com.google.android.gms.internal.ads;

final class zzdxd extends zzdwm<Object> {
    private final transient int offset;
    private final transient int size;
    private final transient Object[] zzhvj;

    zzdxd(Object[] objArr, int i, int i2) {
        this.zzhvj = objArr;
        this.offset = i;
        this.size = i2;
    }

    public final Object get(int i) {
        zzdvv.zzt(i, this.size);
        return this.zzhvj[(i * 2) + this.offset];
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzayu() {
        return true;
    }
}
