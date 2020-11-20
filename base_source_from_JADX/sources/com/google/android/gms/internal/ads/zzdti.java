package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzdte;
import com.google.android.gms.internal.ads.zzekh;

public final class zzdti extends zzekh<zzdti, zza> implements zzelu {
    private static volatile zzemb<zzdti> zzei;
    /* access modifiers changed from: private */
    public static final zzdti zzhqy;
    private int zzdt;
    private String zzdu = "";
    private int zzhqv;
    private String zzhqw = "";
    private zzdte zzhqx;

    public static final class zza extends zzekh.zza<zzdti, zza> implements zzelu {
        private zza() {
            super(zzdti.zzhqy);
        }

        /* synthetic */ zza(zzdtj zzdtj) {
            this();
        }

        public final zza zza(zzdte.zzb zzb) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzdti) this.zzinm).zza((zzdte) ((zzekh) zzb.zzbhv()));
            return this;
        }

        public final zza zzb(zzb zzb) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzdti) this.zzinm).zza(zzb);
            return this;
        }

        public final zza zzhc(String str) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzdti) this.zzinm).zzo(str);
            return this;
        }
    }

    public enum zzb implements zzekj {
        EVENT_TYPE_UNKNOWN(0),
        BLOCKED_IMPRESSION(1);
        
        private static final zzekm<zzb> zzep = null;
        private final int value;

        static {
            zzep = new zzdtk();
        }

        private zzb(int i) {
            this.value = i;
        }

        public static zzb zzei(int i) {
            switch (i) {
                case 0:
                    return EVENT_TYPE_UNKNOWN;
                case 1:
                    return BLOCKED_IMPRESSION;
                default:
                    return null;
            }
        }

        public static zzekl zzw() {
            return zzdtm.zzer;
        }

        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
        }

        public final int zzv() {
            return this.value;
        }
    }

    static {
        zzdti zzdti = new zzdti();
        zzhqy = zzdti;
        zzekh.zza(zzdti.class, zzdti);
    }

    private zzdti() {
    }

    /* access modifiers changed from: private */
    public final void zza(zzdte zzdte) {
        zzdte.getClass();
        this.zzhqx = zzdte;
        this.zzdt |= 8;
    }

    /* access modifiers changed from: private */
    public final void zza(zzb zzb2) {
        this.zzhqv = zzb2.zzv();
        this.zzdt |= 1;
    }

    public static zza zzaxl() {
        return (zza) zzhqy.zzbhx();
    }

    /* access modifiers changed from: private */
    public final void zzo(String str) {
        str.getClass();
        this.zzdt |= 2;
        this.zzdu = str;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdtj.zzds[i - 1]) {
            case 1:
                return new zzdti();
            case 2:
                return new zza((zzdtj) null);
            case 3:
                return zza((zzels) zzhqy, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဉ\u0003", new Object[]{"zzdt", "zzhqv", zzb.zzw(), "zzdu", "zzhqw", "zzhqx"});
            case 4:
                return zzhqy;
            case 5:
                zzemb<zzdti> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzdti.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzhqy);
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
