package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzeec extends zzekh<zzeec, zza> implements zzelu {
    private static volatile zzemb<zzeec> zzei;
    /* access modifiers changed from: private */
    public static final zzeec zziby;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;

    public static final class zza extends zzekh.zza<zzeec, zza> implements zzelu {
        private zza() {
            super(zzeec.zziby);
        }

        /* synthetic */ zza(zzeeb zzeeb) {
            this();
        }

        public final zza zzfa(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeec) this.zzinm).setVersion(0);
            return this;
        }

        public final zza zzx(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeec) this.zzinm).zzs(zzeiu);
            return this;
        }
    }

    static {
        zzeec zzeec = new zzeec();
        zziby = zzeec;
        zzekh.zza(zzeec.class, zzeec);
    }

    private zzeec() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zziaz = i;
    }

    public static zza zzbbt() {
        return (zza) zziby.zzbhx();
    }

    public static zzeec zzm(zzeiu zzeiu, zzeju zzeju) {
        return (zzeec) zzekh.zza(zziby, zzeiu, zzeju);
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
        switch (zzeeb.zzds[i - 1]) {
            case 1:
                return new zzeec();
            case 2:
                return new zza((zzeeb) null);
            case 3:
                return zza((zzels) zziby, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zziby;
            case 5:
                zzemb<zzeec> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeec.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zziby);
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
