package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzeeq extends zzekh<zzeeq, zza> implements zzelu {
    private static volatile zzemb<zzeeq> zzei;
    /* access modifiers changed from: private */
    public static final zzeeq zzicp;
    private zzeev zzicm;
    private zzeem zzicn;
    private int zzico;

    public static final class zza extends zzekh.zza<zzeeq, zza> implements zzelu {
        private zza() {
            super(zzeeq.zzicp);
        }

        /* synthetic */ zza(zzeep zzeep) {
            this();
        }
    }

    static {
        zzeeq zzeeq = new zzeeq();
        zzicp = zzeeq;
        zzekh.zza(zzeeq.class, zzeeq);
    }

    private zzeeq() {
    }

    public static zzeeq zzbch() {
        return zzicp;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeep.zzds[i - 1]) {
            case 1:
                return new zzeeq();
            case 2:
                return new zza((zzeep) null);
            case 3:
                return zza((zzels) zzicp, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\t\u0002\t\u0003\f", new Object[]{"zzicm", "zzicn", "zzico"});
            case 4:
                return zzicp;
            case 5:
                zzemb<zzeeq> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeeq.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicp);
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

    public final zzeev zzbce() {
        zzeev zzeev = this.zzicm;
        return zzeev == null ? zzeev.zzbcu() : zzeev;
    }

    public final zzeem zzbcf() {
        zzeem zzeem = this.zzicn;
        return zzeem == null ? zzeem.zzbca() : zzeem;
    }

    public final zzeek zzbcg() {
        zzeek zzfc = zzeek.zzfc(this.zzico);
        return zzfc == null ? zzeek.UNRECOGNIZED : zzfc;
    }
}
