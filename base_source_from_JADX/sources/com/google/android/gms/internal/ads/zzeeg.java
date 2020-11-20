package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzeeg extends zzekh<zzeeg, zza> implements zzelu {
    private static volatile zzemb<zzeeg> zzei;
    /* access modifiers changed from: private */
    public static final zzeeg zzica;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;

    public static final class zza extends zzekh.zza<zzeeg, zza> implements zzelu {
        private zza() {
            super(zzeeg.zzica);
        }

        /* synthetic */ zza(zzeef zzeef) {
            this();
        }

        public final zza zzfb(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeg) this.zzinm).setVersion(0);
            return this;
        }

        public final zza zzy(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeg) this.zzinm).zzs(zzeiu);
            return this;
        }
    }

    static {
        zzeeg zzeeg = new zzeeg();
        zzica = zzeeg;
        zzekh.zza(zzeeg.class, zzeeg);
    }

    private zzeeg() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zziaz = i;
    }

    public static zza zzbbw() {
        return (zza) zzica.zzbhx();
    }

    public static zzeeg zzo(zzeiu zzeiu, zzeju zzeju) {
        return (zzeeg) zzekh.zza(zzica, zzeiu, zzeju);
    }

    /* access modifiers changed from: private */
    public final void zzs(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zziba = zzeiu;
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeef.zzds[i - 1]) {
            case 1:
                return new zzeeg();
            case 2:
                return new zza((zzeef) null);
            case 3:
                return zza((zzels) zzica, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u000b\u0002\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zzica;
            case 5:
                zzemb<zzeeg> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeeg.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzica);
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

    public final zzeiu zzbam() {
        return this.zziba;
    }
}
