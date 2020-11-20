package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzeeu extends zzekh<zzeeu, zza> implements zzelu {
    private static volatile zzemb<zzeeu> zzei;
    /* access modifiers changed from: private */
    public static final zzeeu zzicu;
    private int zziaz;
    private zzeeq zzick;
    private zzeiu zzics = zzeiu.zziiy;
    private zzeiu zzict = zzeiu.zziiy;

    public static final class zza extends zzekh.zza<zzeeu, zza> implements zzelu {
        private zza() {
            super(zzeeu.zzicu);
        }

        /* synthetic */ zza(zzeet zzeet) {
            this();
        }

        public final zza zzac(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeu) this.zzinm).zzaa(zzeiu);
            return this;
        }

        public final zza zzad(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeu) this.zzinm).zzab(zzeiu);
            return this;
        }

        public final zza zzc(zzeeq zzeeq) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeu) this.zzinm).zzb(zzeeq);
            return this;
        }

        public final zza zzfe(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeeu) this.zzinm).setVersion(0);
            return this;
        }
    }

    static {
        zzeeu zzeeu = new zzeeu();
        zzicu = zzeeu;
        zzekh.zza(zzeeu.class, zzeeu);
    }

    private zzeeu() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    public final void zzaa(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zzics = zzeiu;
    }

    /* access modifiers changed from: private */
    public final void zzab(zzeiu zzeiu) {
        zzeiu.getClass();
        this.zzict = zzeiu;
    }

    /* access modifiers changed from: private */
    public final void zzb(zzeeq zzeeq) {
        zzeeq.getClass();
        this.zzick = zzeeq;
    }

    public static zza zzbco() {
        return (zza) zzicu.zzbhx();
    }

    public static zzeeu zzbcp() {
        return zzicu;
    }

    public static zzeeu zzs(zzeiu zzeiu, zzeju zzeju) {
        return (zzeeu) zzekh.zza(zzicu, zzeiu, zzeju);
    }

    public final int getVersion() {
        return this.zziaz;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzeet.zzds[i - 1]) {
            case 1:
                return new zzeeu();
            case 2:
                return new zza((zzeet) null);
            case 3:
                return zza((zzels) zzicu, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n\u0004\n", new Object[]{"zziaz", "zzick", "zzics", "zzict"});
            case 4:
                return zzicu;
            case 5:
                zzemb<zzeeu> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeeu.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicu);
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

    public final zzeeq zzbcc() {
        zzeeq zzeeq = this.zzick;
        return zzeeq == null ? zzeeq.zzbch() : zzeeq;
    }

    public final zzeiu zzbcm() {
        return this.zzics;
    }

    public final zzeiu zzbcn() {
        return this.zzict;
    }
}
