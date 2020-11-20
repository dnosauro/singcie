package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzedn extends zzekh<zzedn, zza> implements zzelu {
    private static volatile zzemb<zzedn> zzei;
    /* access modifiers changed from: private */
    public static final zzedn zzibp;
    private int zzibd;
    private zzedq zzibn;

    public static final class zza extends zzekh.zza<zzedn, zza> implements zzelu {
        private zza() {
            super(zzedn.zzibp);
        }

        /* synthetic */ zza(zzedo zzedo) {
            this();
        }
    }

    static {
        zzedn zzedn = new zzedn();
        zzibp = zzedn;
        zzekh.zza(zzedn.class, zzedn);
    }

    private zzedn() {
    }

    public static zzedn zzbbf() {
        return zzibp;
    }

    public static zzedn zzh(zzeiu zzeiu, zzeju zzeju) {
        return (zzedn) zzekh.zza(zzibp, zzeiu, zzeju);
    }

    public final int getKeySize() {
        return this.zzibd;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzedo.zzds[i - 1]) {
            case 1:
                return new zzedn();
            case 2:
                return new zza((zzedo) null);
            case 3:
                return zza((zzels) zzibp, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\t\u0002\u000b", new Object[]{"zzibn", "zzibd"});
            case 4:
                return zzibp;
            case 5:
                zzemb<zzedn> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedn.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibp);
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

    public final zzedq zzbbb() {
        zzedq zzedq = this.zzibn;
        return zzedq == null ? zzedq.zzbbi() : zzedq;
    }
}
