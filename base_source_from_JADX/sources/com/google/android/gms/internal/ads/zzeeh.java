package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzeeh extends zzekh<zzeeh, zza> implements zzelu {
    private static volatile zzemb<zzeeh> zzei;
    /* access modifiers changed from: private */
    public static final zzeeh zzicb;

    public static final class zza extends zzekh.zza<zzeeh, zza> implements zzelu {
        private zza() {
            super(zzeeh.zzicb);
        }

        /* synthetic */ zza(zzeei zzeei) {
            this();
        }
    }

    static {
        zzeeh zzeeh = new zzeeh();
        zzicb = zzeeh;
        zzekh.zza(zzeeh.class, zzeeh);
    }

    private zzeeh() {
    }

    public static zzeeh zzp(zzeiu zzeiu, zzeju zzeju) {
        return (zzeeh) zzekh.zza(zzicb, zzeiu, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeei.zzds[i - 1]) {
            case 1:
                return new zzeeh();
            case 2:
                return new zza((zzeei) null);
            case 3:
                return zza((zzels) zzicb, "\u0000\u0000", (Object[]) null);
            case 4:
                return zzicb;
            case 5:
                zzemb<zzeeh> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeeh.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicb);
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
