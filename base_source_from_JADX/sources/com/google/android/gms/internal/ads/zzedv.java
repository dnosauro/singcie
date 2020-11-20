package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzedv extends zzekh<zzedv, zza> implements zzelu {
    private static volatile zzemb<zzedv> zzei;
    /* access modifiers changed from: private */
    public static final zzedv zzibv;
    private int zzibq;

    public static final class zza extends zzekh.zza<zzedv, zza> implements zzelu {
        private zza() {
            super(zzedv.zzibv);
        }

        /* synthetic */ zza(zzedw zzedw) {
            this();
        }
    }

    static {
        zzedv zzedv = new zzedv();
        zzibv = zzedv;
        zzekh.zza(zzedv.class, zzedv);
    }

    private zzedv() {
    }

    public static zzedv zzbbo() {
        return zzibv;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzedw.zzds[i - 1]) {
            case 1:
                return new zzedv();
            case 2:
                return new zza((zzedw) null);
            case 3:
                return zza((zzels) zzibv, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzibq"});
            case 4:
                return zzibv;
            case 5:
                zzemb<zzedv> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedv.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibv);
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

    public final int zzbbh() {
        return this.zzibq;
    }
}
