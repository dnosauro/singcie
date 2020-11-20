package com.google.android.gms.internal.ads;

final class zzdww<E> extends zzdwm<E> {
    static final zzdwm<Object> zzhvg = new zzdww(new Object[0], 0);
    private final transient int size;
    private final transient Object[] zzhvh;

    zzdww(Object[] objArr, int i) {
        this.zzhvh = objArr;
        this.size = i;
    }

    public final E get(int i) {
        zzdvv.zzt(i, this.size);
        return this.zzhvh[i];
    }

    public final int size() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzhvh, 0, objArr, i, this.size);
        return i + this.size;
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzayq() {
        return this.zzhvh;
    }

    /* access modifiers changed from: package-private */
    public final int zzayr() {
        return 0;
    }

    /* access modifiers changed from: package-private */
    public final int zzays() {
        return this.size;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzayu() {
        return false;
    }
}
