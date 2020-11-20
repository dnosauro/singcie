package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzedm extends zzekh<zzedm, zza> implements zzelu {
    private static volatile zzemb<zzedm> zzei;
    /* access modifiers changed from: private */
    public static final zzedm zzibo;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;
    private zzedq zzibn;

    public static final class zza extends zzekh.zza<zzedm, zza> implements zzelu {
        private zza() {
            super(zzedm.zzibo);
        }

        /* synthetic */ zza(zzedl zzedl) {
            this();
        }

        public final zza zzc(zzedq zzedq) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedm) this.zzinm).zzb(zzedq);
            return this;
        }

        public final zza zzex(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedm) this.zzinm).setVersion(0);
            return this;
        }

        public final zza zzu(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzedm) this.zzinm).zzs(zzeiu);
            return this;
        }
    }

    static {
        zzedm zzedm = new zzedm();
        zzibo = zzedm;
        zzekh.zza(zzedm.class, zzedm);
    }

    private zzedm() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzedq zzedq) {
        zzedq.getClass();
        this.zzibn = zzedq;
    }

    public static zza zzbbc() {
        return (zza) zzibo.zzbhx();
    }

    public static zzedm zzbbd() {
        return zzibo;
    }

    public static zzedm zzg(zzeiu zzeiu, zzeju zzeju) {
        return (zzedm) zzekh.zza(zzibo, zzeiu, zzeju);
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
        switch (zzedl.zzds[i - 1]) {
            case 1:
                return new zzedm();
            case 2:
                return new zza((zzedl) null);
            case 3:
                return zza((zzels) zzibo, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zziaz", "zzibn", "zziba"});
            case 4:
                return zzibo;
            case 5:
                zzemb<zzedm> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzedm.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzibo);
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

    public final zzedq zzbbb() {
        zzedq zzedq = this.zzibn;
        return zzedq == null ? zzedq.zzbbi() : zzedq;
    }
}
