package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzefn extends zzekh<zzefn, zza> implements zzelu {
    private static volatile zzemb<zzefn> zzei;
    /* access modifiers changed from: private */
    public static final zzefn zziek;
    private String zzids = "";
    private zzeiu zzidt = zzeiu.zziiy;
    private int zziej;

    public static final class zza extends zzekh.zza<zzefn, zza> implements zzelu {
        private zza() {
            super(zzefn.zziek);
        }

        /* synthetic */ zza(zzefm zzefm) {
            this();
        }
    }

    static {
        zzefn zzefn = new zzefn();
        zziek = zzefn;
        zzekh.zza(zzefn.class, zzefn);
    }

    private zzefn() {
    }

    public static zzefn zzbdl() {
        return zziek;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzefm.zzds[i - 1]) {
            case 1:
                return new zzefn();
            case 2:
                return new zza((zzefm) null);
            case 3:
                return zza((zzels) zziek, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002\n\u0003\f", new Object[]{"zzids", "zzidt", "zziej"});
            case 4:
                return zziek;
            case 5:
                zzemb<zzefn> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefn.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zziek);
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

    public final String zzbdf() {
        return this.zzids;
    }

    public final zzeiu zzbdg() {
        return this.zzidt;
    }
}
