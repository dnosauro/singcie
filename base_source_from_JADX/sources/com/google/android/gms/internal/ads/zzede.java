package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzede extends zzekh<zzede, zza> implements zzelu {
    private static volatile zzemb<zzede> zzei;
    /* access modifiers changed from: private */
    public static final zzede zzibe;
    private zzedf zzibb;
    private int zzibd;

    public static final class zza extends zzekh.zza<zzede, zza> implements zzelu {
        private zza() {
            super(zzede.zzibe);
        }

        /* synthetic */ zza(zzedd zzedd) {
            this();
        }
    }

    static {
        zzede zzede = new zzede();
        zzibe = zzede;
        zzekh.zza(zzede.class, zzede);
    }

    private zzede() {
    }

    public static zzede zzd(zzeiu zzeiu, zzeju zzeju) {
        return (zzede) zzekh.zza(zzibe, zzeiu, zzeju);
    }

    public final int getKeySize() {
        return this.zzibd;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzedd.zzds[i - 1]) {
            case 1:
                return new zzede();
            case 2:
                return new zza((zzedd) null);
            case 3:
                return zza((zzels) zzibe, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\t", new Object[]{"zzibd", "zzibb"});
            case 4:
                return zzibe;
            case 5:
                zzemb<zzede> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzede.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibe);
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

    public final zzedf zzban() {
        zzedf zzedf = this.zzibb;
        return zzedf == null ? zzedf.zzbas() : zzedf;
    }
}
