package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzega extends zzekh<zzega, zza> implements zzelu {
    private static volatile zzemb<zzega> zzei;
    /* access modifiers changed from: private */
    public static final zzega zzifi;
    private String zzifg = "";
    private zzefn zzifh;

    public static final class zza extends zzekh.zza<zzega, zza> implements zzelu {
        private zza() {
            super(zzega.zzifi);
        }

        /* synthetic */ zza(zzegb zzegb) {
            this();
        }
    }

    static {
        zzega zzega = new zzega();
        zzifi = zzega;
        zzekh.zza(zzega.class, zzega);
    }

    private zzega() {
    }

    public static zzega zzbep() {
        return zzifi;
    }

    public static zzega zzy(zzeiu zzeiu, zzeju zzeju) {
        return (zzega) zzekh.zza(zzifi, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzegb.zzds[i - 1]) {
            case 1:
                return new zzega();
            case 2:
                return new zza((zzegb) null);
            case 3:
                return zza((zzels) zzifi, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002\t", new Object[]{"zzifg", "zzifh"});
            case 4:
                return zzifi;
            case 5:
                zzemb<zzega> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzega.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzifi);
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

    public final String zzben() {
        return this.zzifg;
    }

    public final zzefn zzbeo() {
        zzefn zzefn = this.zzifh;
        return zzefn == null ? zzefn.zzbdl() : zzefn;
    }
}
