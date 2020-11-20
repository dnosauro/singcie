package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzdte extends zzekh<zzdte, zzb> implements zzelu {
    private static volatile zzemb<zzdte> zzei;
    private static final zzekn<Integer, zza> zzhqn = new zzdtd();
    /* access modifiers changed from: private */
    public static final zzdte zzhqr;
    private int zzdt;
    private zzeko zzhqm = zzbia();
    private String zzhqo = "";
    private String zzhqp = "";
    private String zzhqq = "";

    public enum zza implements zzekj {
        BLOCKED_REASON_UNKNOWN(1),
        BLOCKED_REASON_BACKGROUND(2);
        
        private static final zzekm<zza> zzep = null;
        private final int value;

        static {
            zzep = new zzdth();
        }

        private zza(int i) {
            this.value = i;
        }

        public static zza zzeh(int i) {
            switch (i) {
                case 1:
                    return BLOCKED_REASON_UNKNOWN;
                case 2:
                    return BLOCKED_REASON_BACKGROUND;
                default:
                    return null;
            }
        }

        public static zzekl zzw() {
            return zzdtg.zzer;
        }

        public final String toString() {
            return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
        }

        public final int zzv() {
            return this.value;
        }
    }

    public static final class zzb extends zzekh.zza<zzdte, zzb> implements zzelu {
        private zzb() {
            super(zzdte.zzhqr);
        }

        /* synthetic */ zzb(zzdtd zzdtd) {
            this();
        }

        public final zzb zzb(zza zza) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzdte) this.zzinm).zza(zza);
            return this;
        }

        public final zzb zzhb(String str) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzdte) this.zzinm).zzha(str);
            return this;
        }
    }

    static {
        zzdte zzdte = new zzdte();
        zzhqr = zzdte;
        zzekh.zza(zzdte.class, zzdte);
    }

    private zzdte() {
    }

    /* access modifiers changed from: private */
    public final void zza(zza zza2) {
        zza2.getClass();
        zzeko zzeko = this.zzhqm;
        if (!zzeko.zzbfk()) {
            this.zzhqm = zzekh.zza(zzeko);
        }
        this.zzhqm.zzhg(zza2.zzv());
    }

    public static zzb zzaxj() {
        return (zzb) zzhqr.zzbhx();
    }

    /* access modifiers changed from: private */
    public final void zzha(String str) {
        str.getClass();
        this.zzdt |= 1;
        this.zzhqo = str;
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzdtf.zzds[i - 1]) {
            case 1:
                return new zzdte();
            case 2:
                return new zzb((zzdtd) null);
            case 3:
                return zza((zzels) zzhqr, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001\u001e\u0002ဈ\u0000\u0003ဈ\u0001\u0004ဈ\u0002", new Object[]{"zzdt", "zzhqm", zza.zzw(), "zzhqo", "zzhqp", "zzhqq"});
            case 4:
                return zzhqr;
            case 5:
                zzemb<zzdte> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzdte.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzhqr);
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
