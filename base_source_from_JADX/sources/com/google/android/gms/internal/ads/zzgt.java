package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzgt extends zzekh<zzgt, zza> implements zzelu {
    /* access modifiers changed from: private */
    public static final zzgt zzacf;
    private static volatile zzemb<zzgt> zzei;
    private String zzaca = "";
    private String zzacb = "";
    private long zzacc;
    private long zzacd;
    private long zzace;
    private int zzdt;

    public static final class zza extends zzekh.zza<zzgt, zza> implements zzelu {
        private zza() {
            super(zzgt.zzacf);
        }

        /* synthetic */ zza(zzgs zzgs) {
            this();
        }

        public final zza zzav(String str) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzgt) this.zzinm).zzat(str);
            return this;
        }

        public final zza zzaw(String str) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzgt) this.zzinm).zzau(str);
            return this;
        }

        public final zza zzdj(long j) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzgt) this.zzinm).zzdg(j);
            return this;
        }

        public final zza zzdk(long j) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzgt) this.zzinm).zzdh(j);
            return this;
        }

        public final zza zzdl(long j) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzgt) this.zzinm).zzdi(j);
            return this;
        }
    }

    static {
        zzgt zzgt = new zzgt();
        zzacf = zzgt;
        zzekh.zza(zzgt.class, zzgt);
    }

    private zzgt() {
    }

    /* access modifiers changed from: private */
    public final void zzat(String str) {
        str.getClass();
        this.zzdt |= 1;
        this.zzaca = str;
    }

    /* access modifiers changed from: private */
    public final void zzau(String str) {
        str.getClass();
        this.zzdt |= 2;
        this.zzacb = str;
    }

    public static zzgt zzb(zzeiu zzeiu, zzeju zzeju) {
        return (zzgt) zzekh.zza(zzacf, zzeiu, zzeju);
    }

    /* access modifiers changed from: private */
    public final void zzdg(long j) {
        this.zzdt |= 4;
        this.zzacc = j;
    }

    /* access modifiers changed from: private */
    public final void zzdh(long j) {
        this.zzdt |= 8;
        this.zzacd = j;
    }

    /* access modifiers changed from: private */
    public final void zzdi(long j) {
        this.zzdt |= 16;
        this.zzace = j;
    }

    public static zza zzdl() {
        return (zza) zzacf.zzbhx();
    }

    public static zzgt zzdm() {
        return zzacf;
    }

    public static zzgt zzl(zzeiu zzeiu) {
        return (zzgt) zzekh.zza(zzacf, zzeiu);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzgs.zzds[i - 1]) {
            case 1:
                return new zzgt();
            case 2:
                return new zza((zzgs) null);
            case 3:
                return zza((zzels) zzacf, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဃ\u0002\u0004ဃ\u0003\u0005ဃ\u0004", new Object[]{"zzdt", "zzaca", "zzacb", "zzacc", "zzacd", "zzace"});
            case 4:
                return zzacf;
            case 5:
                zzemb<zzgt> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzgt.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzacf);
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

    public final String zzdg() {
        return this.zzaca;
    }

    public final String zzdh() {
        return this.zzacb;
    }

    public final long zzdi() {
        return this.zzacc;
    }

    public final long zzdj() {
        return this.zzacd;
    }

    public final long zzdk() {
        return this.zzace;
    }
}
