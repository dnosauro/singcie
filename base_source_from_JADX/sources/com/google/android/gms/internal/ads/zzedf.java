package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzedf extends zzekh<zzedf, zza> implements zzelu {
    private static volatile zzemb<zzedf> zzei;
    /* access modifiers changed from: private */
    public static final zzedf zzibg;
    private int zzibf;

    public static final class zza extends zzekh.zza<zzedf, zza> implements zzelu {
        private zza() {
            super(zzedf.zzibg);
        }

        /* synthetic */ zza(zzedg zzedg) {
            this();
        }
    }

    static {
        zzedf zzedf = new zzedf();
        zzibg = zzedf;
        zzekh.zza(zzedf.class, zzedf);
    }

    private zzedf() {
    }

    public static zzedf zzbas() {
        return zzibg;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzedg.zzds[i - 1]) {
            case 1:
                return new zzedf();
            case 2:
                return new zza((zzedg) null);
            case 3:
                return zza((zzels) zzibg, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\u000b", new Object[]{"zzibf"});
            case 4:
                return zzibg;
            case 5:
                zzemb<zzedf> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedf.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibg);
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

    public final int zzbar() {
        return this.zzibf;
    }
}
