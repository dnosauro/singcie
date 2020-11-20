package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzefc extends zzekh<zzefc, zza> implements zzelu {
    private static volatile zzemb<zzefc> zzei;
    /* access modifiers changed from: private */
    public static final zzefc zzido;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;
    private zzefg zzidn;

    public static final class zza extends zzekh.zza<zzefc, zza> implements zzelu {
        private zza() {
            super(zzefc.zzido);
        }

        /* synthetic */ zza(zzefb zzefb) {
            this();
        }

        public final zza zzae(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefc) this.zzinm).zzs(zzeiu);
            return this;
        }

        public final zza zzd(zzefg zzefg) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefc) this.zzinm).zzc(zzefg);
            return this;
        }

        public final zza zzfh(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzefc) this.zzinm).setVersion(0);
            return this;
        }
    }

    static {
        zzefc zzefc = new zzefc();
        zzido = zzefc;
        zzekh.zza(zzefc.class, zzefc);
    }

    private zzefc() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zziaz = i;
    }

    public static zza zzbcx() {
        return (zza) zzido.zzbhx();
    }

    public static zzefc zzbcy() {
        return zzido;
    }

    /* access modifiers changed from: private */
    public final void zzc(zzefg zzefg) {
        zzefg.getClass();
        this.zzidn = zzefg;
    }

    /* access modifiers changed from: private */
    public final void zzs(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zziba = zzeiu;
    }

    public static zzefc zzt(zzeiu zzeiu, zzeju zzeju) {
        return (zzefc) zzekh.zza(zzido, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzefb.zzds[i - 1]) {
            case 1:
                return new zzefc();
            case 2:
                return new zza((zzefb) null);
            case 3:
                return zza((zzels) zzido, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zziaz", "zzidn", "zziba"});
            case 4:
                return zzido;
            case 5:
                zzemb<zzefc> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefc.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzido);
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

    public final zzefg zzbcw() {
        zzefg zzefg = this.zzidn;
        return zzefg == null ? zzefg.zzbdd() : zzefg;
    }
}
