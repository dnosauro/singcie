package com.google.android.gms.internal.ads;

import java.util.List;

final class zzdwr extends zzdwm<E> {
    private final transient int length;
    private final transient int offset;
    private final /* synthetic */ zzdwm zzhvb;

    zzdwr(zzdwm zzdwm, int i, int i2) {
        this.zzhvb = zzdwm;
        this.offset = i;
        this.length = i2;
    }

    public final E get(int i) {
        zzdvv.zzt(i, this.length);
        return this.zzhvb.get(i + this.offset);
    }

    public final int size() {
        return this.length;
    }

    public final /* synthetic */ List subList(int i, int i2) {
        return subList(i, i2);
    }

    /* access modifiers changed from: package-private */
    public final Object[] zzayq() {
        return this.zzhvb.zzayq();
    }

    /* access modifiers changed from: package-private */
    public final int zzayr() {
        return this.zzhvb.zzayr() + this.offset;
    }

    /* access modifiers changed from: package-private */
    public final int zzays() {
        return this.zzhvb.zzayr() + this.offset + this.length;
    }

    /* access modifiers changed from: package-private */
    public final boolean zzayu() {
        return true;
    }

    public final zzdwm<E> zzv(int i, int i2) {
        zzdvv.zzf(i, i2, this.length);
        zzdwm zzdwm = this.zzhvb;
        int i3 = this.offset;
        return (zzdwm) zzdwm.subList(i + i3, i2 + i3);
    }
}
