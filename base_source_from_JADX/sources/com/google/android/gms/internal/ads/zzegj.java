package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzegj extends zzekh<zzegj, zza> implements zzelu {
    private static volatile zzemb<zzegj> zzei;
    /* access modifiers changed from: private */
    public static final zzegj zzifu;

    public static final class zza extends zzekh.zza<zzegj, zza> implements zzelu {
        private zza() {
            super(zzegj.zzifu);
        }

        /* synthetic */ zza(zzegi zzegi) {
            this();
        }
    }

    static {
        zzegj zzegj = new zzegj();
        zzifu = zzegj;
        zzekh.zza(zzegj.class, zzegj);
    }

    private zzegj() {
    }

    public static zzegj zzaa(zzeiu zzeiu, zzeju zzeju) {
        return (zzegj) zzekh.zza(zzifu, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegi.zzds[i - 1]) {
            case 1:
                return new zzegj();
            case 2:
                return new zza((zzegi) null);
            case 3:
                return zza((zzels) zzifu, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzifu;
            case 5:
                zzemb<zzegj> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzegj.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzifu);
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
