package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzeev extends zzekh<zzeev, zza> implements zzelu {
    private static volatile zzemb<zzeev> zzei;
    /* access modifiers changed from: private */
    public static final zzeev zzicy;
    private int zzicv;
    private int zzicw;
    private zzeiu zzicx = zzeiu.zziiy;

    public static final class zza extends zzekh.zza<zzeev, zza> implements zzelu {
        private zza() {
            super(zzeev.zzicy);
        }

        /* synthetic */ zza(zzeew zzeew) {
            this();
        }
    }

    static {
        zzeev zzeev = new zzeev();
        zzicy = zzeev;
        zzekh.zza(zzeev.class, zzeev);
    }

    private zzeev() {
    }

    public static zzeev zzbcu() {
        return zzicy;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeew.zzds[i - 1]) {
            case 1:
                return new zzeev();
            case 2:
                return new zza((zzeew) null);
            case 3:
                return zza((zzels) zzicy, "\u0000\u0003\u0000\u0000\u0001\u000b\u0003\u0000\u0000\u0000\u0001\f\u0002\f\u000b\n", new Object[]{"zzicv", "zzicw", "zzicx"});
            case 4:
                return zzicy;
            case 5:
                zzemb<zzeev> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeev.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicy);
                            zzei = zzemb;
                        }
                    }
                }
                return zzemb;
            case 6:
                return (byte) 1;
            case 7:
                return null;
            default:
                throw new UnsupportedOperationException();
        }
    }

    public final zzeey zzbcr() {
        zzeey zzff = zzeey.zzff(this.zzicv);
        return zzff == null ? zzeey.UNRECOGNIZED : zzff;
    }

    public final zzefa zzbcs() {
        zzefa zzfg = zzefa.zzfg(this.zzicw);
        return zzfg == null ? zzefa.UNRECOGNIZED : zzfg;
    }

    public final zzeiu zzbct() {
        return this.zzicx;
    }
}
