package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzedz extends zzekh<zzedz, zza> implements zzelu {
    private static volatile zzemb<zzedz> zzei;
    /* access modifiers changed from: private */
    public static final zzedz zzibx;
    private int zziaz;
    private int zzibd;

    public static final class zza extends zzekh.zza<zzedz, zza> implements zzelu {
        private zza() {
            super(zzedz.zzibx);
        }

        /* synthetic */ zza(zzeea zzeea) {
            this();
        }
    }

    static {
        zzedz zzedz = new zzedz();
        zzibx = zzedz;
        zzekh.zza(zzedz.class, zzedz);
    }

    private zzedz() {
    }

    public static zzedz zzl(zzeiu zzeiu, zzeju zzeju) {
        return (zzedz) zzekh.zza(zzibx, zzeiu, zzeju);
    }

    public final int getKeySize() {
        return this.zzibd;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeea.zzds[i - 1]) {
            case 1:
                return new zzedz();
            case 2:
                return new zza((zzeea) null);
            case 3:
                return zza((zzels) zzibx, "\u0000\u0002\u0000\u0000\u0002\u0003\u0002\u0000\u0000\u0000\u0002\u000b\u0003\u000b", new Object[]{"zzibd", "zziaz"});
            case 4:
                return zzibx;
            case 5:
                zzemb<zzedz> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedz.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibx);
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
}
