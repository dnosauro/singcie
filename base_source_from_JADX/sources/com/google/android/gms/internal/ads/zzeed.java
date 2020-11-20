package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzeed extends zzekh<zzeed, zza> implements zzelu {
    private static volatile zzemb<zzeed> zzei;
    /* access modifiers changed from: private */
    public static final zzeed zzibz;
    private int zziaz;
    private int zzibd;

    public static final class zza extends zzekh.zza<zzeed, zza> implements zzelu {
        private zza() {
            super(zzeed.zzibz);
        }

        /* synthetic */ zza(zzeee zzeee) {
            this();
        }
    }

    static {
        zzeed zzeed = new zzeed();
        zzibz = zzeed;
        zzekh.zza(zzeed.class, zzeed);
    }

    private zzeed() {
    }

    public static zzeed zzn(zzeiu zzeiu, zzeju zzeju) {
        return (zzeed) zzekh.zza(zzibz, zzeiu, zzeju);
    }

    public final int getKeySize() {
        return this.zzibd;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeee.zzds[i - 1]) {
            case 1:
                return new zzeed();
            case 2:
                return new zza((zzeee) null);
            case 3:
                return zza((zzels) zzibz, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\u000b", new Object[]{"zziaz", "zzibd"});
            case 4:
                return zzibz;
            case 5:
                zzemb<zzeed> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeed.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibz);
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
