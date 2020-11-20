package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzeer extends zzekh<zzeer, zza> implements zzelu {
    private static volatile zzemb<zzeer> zzei;
    /* access modifiers changed from: private */
    public static final zzeer zzicr;
    private int zziaz;
    private zzeiu zziba = zzeiu.zziiy;
    private zzeeu zzicq;

    public static final class zza extends zzekh.zza<zzeer, zza> implements zzelu {
        private zza() {
            super(zzeer.zzicr);
        }

        /* synthetic */ zza(zzees zzees) {
            this();
        }

        public final zza zzb(zzeeu zzeeu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeer) this.zzinm).zza(zzeeu);
            return this;
        }

        public final zza zzfd(int i) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeer) this.zzinm).setVersion(0);
            return this;
        }

        public final zza zzz(zzeiu zzeiu) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            ((zzeer) this.zzinm).zzs(zzeiu);
            return this;
        }
    }

    static {
        zzeer zzeer = new zzeer();
        zzicr = zzeer;
        zzekh.zza(zzeer.class, zzeer);
    }

    private zzeer() {
    }

    /* access modifiers changed from: private */
    public final void setVersion(int i) {
        this.zziaz = i;
    }

    /* access modifiers changed from: private */
    public final void zza(zzeeu zzeeu) {
        zzeeu.getClass();
        this.zzicq = zzeeu;
    }

    public static zza zzbck() {
        return (zza) zzicr.zzbhx();
    }

    public static zzeer zzr(zzeiu zzeiu, zzeju zzeju) {
        return (zzeer) zzekh.zza(zzicr, zzeiu, zzeju);
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
        switch (zzees.zzds[i - 1]) {
            case 1:
                return new zzeer();
            case 2:
                return new zza((zzees) null);
            case 3:
                return zza((zzels) zzicr, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001\u000b\u0002\t\u0003\n", new Object[]{"zziaz", "zzicq", "zziba"});
            case 4:
                return zzicr;
            case 5:
                zzemb<zzeer> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzeer.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzicr);
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

    public final zzeeu zzbcj() {
        zzeeu zzeeu = this.zzicq;
        return zzeeu == null ? zzeeu.zzbcp() : zzeeu;
    }
}
