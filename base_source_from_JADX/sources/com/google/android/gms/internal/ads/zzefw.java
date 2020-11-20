package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzefw extends zzekh<zzefw, zza> implements zzelu {
    private static volatile zzemb<zzefw> zzei;
    /* access modifiers changed from: private */
    public static final zzefw zzifd;
    private String zzifc = "";

    public static final class zza extends zzekh.zza<zzefw, zza> implements zzelu {
        private zza() {
            super(zzefw.zzifd);
        }

        /* synthetic */ zza(zzefx zzefx) {
            this();
        }
    }

    static {
        zzefw zzefw = new zzefw();
        zzifd = zzefw;
        zzekh.zza(zzefw.class, zzefw);
    }

    private zzefw() {
    }

    public static zzefw zzbei() {
        return zzifd;
    }

    public static zzefw zzw(zzeiu zzeiu, zzeju zzeju) {
        return (zzefw) zzekh.zza(zzifd, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzefx.zzds[i - 1]) {
            case 1:
                return new zzefw();
            case 2:
                return new zza((zzefx) null);
            case 3:
                return zza((zzels) zzifd, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001Ȉ", new Object[]{"zzifc"});
            case 4:
                return zzifd;
            case 5:
                zzemb<zzefw> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefw.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzifd);
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

    public final String zzbeh() {
        return this.zzifc;
    }
}
