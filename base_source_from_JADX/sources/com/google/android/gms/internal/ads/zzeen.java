package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzeen extends zzekh<zzeen, zza> implements zzelu {
    private static volatile zzemb<zzeen> zzei;
    /* access modifiers changed from: private */
    public static final zzeen zzicl;
    private zzeeq zzick;

    public static final class zza extends zzekh.zza<zzeen, zza> implements zzelu {
        private zza() {
            super(zzeen.zzicl);
        }

        /* synthetic */ zza(zzeeo zzeeo) {
            this();
        }
    }

    static {
        zzeen zzeen = new zzeen();
        zzicl = zzeen;
        zzekh.zza(zzeen.class, zzeen);
    }

    private zzeen() {
    }

    public static zzeen zzq(zzeiu zzeiu, zzeju zzeju) {
        return (zzeen) zzekh.zza(zzicl, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeeo.zzds[i - 1]) {
            case 1:
                return new zzeen();
            case 2:
                return new zza((zzeeo) null);
            case 3:
                return zza((zzels) zzicl, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\t", new Object[]{"zzick"});
            case 4:
                return zzicl;
            case 5:
                zzemb<zzeen> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeen.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicl);
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

    public final zzeeq zzbcc() {
        zzeeq zzeeq = this.zzick;
        return zzeeq == null ? zzeeq.zzbch() : zzeeq;
    }
}
