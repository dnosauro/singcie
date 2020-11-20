package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import java.util.List;

public final class zzefr extends zzekh<zzefr, zzb> implements zzelu {
    private static volatile zzemb<zzefr> zzei;
    /* access modifiers changed from: private */
    public static final zzefr zzies;
    private int zzieq;
    private zzekp<zza> zzier = zzbic();

    public static final class zza extends zzekh<zza, C3707zza> implements zzelu {
        private static volatile zzemb<zza> zzei;
        /* access modifiers changed from: private */
        public static final zza zziew;
        private int zziej;
        private zzefh zziet;
        private int zzieu;
        private int zziev;

        /* renamed from: com.google.android.gms.internal.ads.zzefr$zza$zza  reason: collision with other inner class name */
        public static final class C3707zza extends zzekh.zza<zza, C3707zza> implements zzelu {
            private C3707zza() {
                super(zza.zziew);
            }

            /* synthetic */ C3707zza(zzefq zzefq) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zziew = zza;
            zzekh.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzefq.zzds[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3707zza((zzefq) null);
                case 3:
                    return zza((zzels) zziew, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\f\u0003\u000b\u0004\f", new Object[]{"zziet", "zzieu", "zziev", "zziej"});
                case 4:
                    return zziew;
                case 5:
                    zzemb<zza> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zza.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zziew);
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

        public final zzefl zzbab() {
            zzefl zzfj = zzefl.zzfj(this.zzieu);
            return zzfj == null ? zzefl.UNRECOGNIZED : zzfj;
        }

        public final zzegd zzbac() {
            zzegd zzfq = zzegd.zzfq(this.zziej);
            return zzfq == null ? zzegd.UNRECOGNIZED : zzfq;
        }

        public final boolean zzbdw() {
            return this.zziet != null;
        }

        public final zzefh zzbdx() {
            zzefh zzefh = this.zziet;
            return zzefh == null ? zzefh.zzbdj() : zzefh;
        }

        public final int zzbdy() {
            return this.zziev;
        }
    }

    public static final class zzb extends zzekh.zza<zzefr, zzb> implements zzelu {
        private zzb() {
            super(zzefr.zzies);
        }

        /* synthetic */ zzb(zzefq zzefq) {
            this();
        }
    }

    static {
        zzefr zzefr = new zzefr();
        zzies = zzefr;
        zzekh.zza(zzefr.class, zzefr);
    }

    private zzefr() {
    }

    public static zzefr zzc(byte[] bArr, zzeju zzeju) {
        return (zzefr) zzekh.zza(zzies, bArr, zzeju);
    }

    /* access modifiers changed from: protected */
    public final Object zza(int i, Object obj, Object obj2) {
        switch (zzefq.zzds[i - 1]) {
            case 1:
                return new zzefr();
            case 2:
                return new zzb((zzefq) null);
            case 3:
                return zza((zzels) zzies, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u000b\u0002\u001b", new Object[]{"zzieq", "zzier", zza.class});
            case 4:
                return zzies;
            case 5:
                zzemb<zzefr> zzemb = zzei;
                if (zzemb == null) {
                    synchronized (zzefr.class) {
                        zzemb = zzei;
                        if (zzemb == null) {
                            zzemb = new zzekh.zzc<>(zzies);
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

    public final int zzbds() {
        return this.zzieq;
    }

    public final List<zza> zzbdt() {
        return this.zzier;
    }

    public final int zzbdu() {
        return this.zzier.size();
    }
}
