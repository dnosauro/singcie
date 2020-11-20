package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzedy extends zzekh<zzedy, zza> implements zzelu {
    private static volatile zzemb<zzedy> zzei;
    /* access modifiers changed from: private */
    public static final zzedy zzibw;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;

    public static final class zza extends zzekh.zza<zzedy, zza> implements zzelu {
        private zza() {
            super(zzedy.zzibw);
        }

        /* synthetic */ zza(zzedx zzedx) {
            this();
        }

        public final zza zzez(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedy) this.zzinm).setVersion(0);
            return this;
        }

        public final zza zzw(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedy) this.zzinm).zzs(zzeiu);
            return this;
        }
    }

    static {
        zzedy zzedy = new zzedy();
        zzibw = zzedy;
        zzekh.zza(zzedy.class, zzedy);
    }

    private zzedy() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zziaz = i;
    }

    public static zza zzbbq() {
        return (zza) zzibw.zzbhx();
    }

    public static zzedy zzk(zzeiu zzeiu, zzeju zzeju) {
        return (zzedy) zzekh.zza(zzibw, zzeiu, zzeju);
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
        switch (zzedx.zzds[i - 1]) {
            case 1:
                return new zzedy();
            case 2:
                return new zza((zzedx) null);
            case 3:
                return zza((zzels) zzibw, "\u0000\u0002\u0000\u0000\u0001\u0003\u0002\u0000\u0000\u0000\u0001\u000b\u0003\n", new Object[]{"zziaz", "zziba"});
            case 4:
                return zzibw;
            case 5:
                zzemb<zzedy> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedy.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibw);
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
