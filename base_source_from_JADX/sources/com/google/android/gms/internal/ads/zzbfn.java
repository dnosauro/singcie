package com.google.android.gms.internal.ads;

public final class zzbfn {
    public final int heightPixels;
    private final int type;
    public final int widthPixels;

    private zzbfn(int i, int i2, int i3) {
        this.type = i;
        this.widthPixels = i2;
        this.heightPixels = i3;
    }

    public static zzbfn zzadv() {
        return new zzbfn(0, 0, 0);
    }

    public static zzbfn zzadw() {
        return new zzbfn(4, 0, 0);
    }

    public static zzbfn zzadx() {
        return new zzbfn(5, 0, 0);
    }

    public static zzbfn zzb(zzvn zzvn) {
        return zzvn.zzchp ? new zzbfn(3, 0, 0) : zzvn.zzchr ? new zzbfn(2, 0, 0) : zzvn.zzbrh ? zzadv() : zzq(zzvn.widthPixels, zzvn.heightPixels);
    }

    public static zzbfn zzq(int i, int i2) {
        return new zzbfn(1, i, i2);
    }

    public final boolean isFluid() {
        return this.type == 2;
    }

    public final boolean zzady() {
        return this.type == 3;
    }

    public final boolean zzadz() {
        return this.type == 0;
    }

    public final boolean zzaea() {
        return this.type == 4;
    }

    public final boolean zzaeb() {
        return this.type == 5;
    }
}
