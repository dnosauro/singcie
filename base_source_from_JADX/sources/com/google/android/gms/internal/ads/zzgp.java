package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzgp extends zzekh<zzgp, zza> implements zzelu {
    /* access modifiers changed from: private */
    public static final zzgp zzabz;
    private static volatile zzemb<zzgp> zzei;
    private zzgt zzabw;
    private zzeiu zzabx = zzeiu.zziiy;
    private zzeiu zzaby = zzeiu.zziiy;
    private int zzdt;

    public static final class zza extends zzekh.zza<zzgp, zza> implements zzelu {
        private zza() {
            super(zzgp.zzabz);
        }

        /* synthetic */ zza(zzgr zzgr) {
            this();
        }
    }

    static {
        zzgp zzgp = new zzgp();
        zzabz = zzgp;
        zzekh.zza(zzgp.class, zzgp);
    }

    private zzgp() {
    }

    public static zzgp zza(zzeiu zzeiu, zzeju zzeju) {
        return (zzgp) zzekh.zza(zzabz, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzgr.zzds[i - 1]) {
            case 1:
                return new zzgp();
            case 2:
                return new zza((zzgr) null);
            case 3:
                return zza((zzels) zzabz, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဉ\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdt", "zzabw", "zzabx", "zzaby"});
            case 4:
                return zzabz;
            case 5:
                zzemb<zzgp> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzgp.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzabz);
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

    public final zzgt zzdc() {
        zzgt zzgt = this.zzabw;
        return zzgt == null ? zzgt.zzdm() : zzgt;
    }

    public final zzeiu zzdd() {
        return this.zzabx;
    }

    public final zzeiu zzde() {
        return this.zzaby;
    }
}
