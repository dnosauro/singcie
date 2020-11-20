package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;

public final class zzbw {

    public static final class zza extends zzekh<zza, C3701zza> implements zzelu {
        /* access modifiers changed from: private */
        public static final zza zzeh;
        private static volatile zzemb<zza> zzei;
        private int zzdt;
        private String zzdu = "";
        private long zzdv;
        private String zzdw = "";
        private String zzdx = "";
        private String zzdy = "";
        private long zzdz;
        private long zzea;
        private String zzeb = "";
        private long zzec;
        private String zzed = "";
        private String zzee = "";
        private zzekp<zzb> zzef = zzbic();
        private int zzeg;

        /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zza  reason: collision with other inner class name */
        public static final class C3701zza extends zzekh.zza<zza, C3701zza> implements zzelu {
            private C3701zza() {
                super(zza.zzeh);
            }

            /* synthetic */ C3701zza(zzbv zzbv) {
                this();
            }

            public final C3701zza zza(zzc zzc) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).zzb(zzc);
                return this;
            }

            public final C3701zza zzc(long j) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).zzd(j);
                return this;
            }

            public final C3701zza zzj(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).zzo(str);
                return this;
            }

            public final C3701zza zzk(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).zzp(str);
                return this;
            }

            public final C3701zza zzl(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).zzq(str);
                return this;
            }

            public final C3701zza zzm(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).zzr(str);
                return this;
            }

            public final C3701zza zzn(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zza) this.zzinm).zzs(str);
                return this;
            }
        }

        public static final class zzb extends zzekh<zzb, C3702zza> implements zzelu {
            private static volatile zzemb<zzb> zzei;
            /* access modifiers changed from: private */
            public static final zzb zzel;
            private int zzdt;
            private String zzej = "";
            private String zzek = "";

            /* renamed from: com.google.android.gms.internal.ads.zzbw$zza$zzb$zza  reason: collision with other inner class name */
            public static final class C3702zza extends zzekh.zza<zzb, C3702zza> implements zzelu {
                private C3702zza() {
                    super(zzb.zzel);
                }

                /* synthetic */ C3702zza(zzbv zzbv) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zzel = zzb;
                zzekh.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzbv.zzds[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C3702zza((zzbv) null);
                    case 3:
                        return zza((zzels) zzel, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzdt", "zzej", "zzek"});
                    case 4:
                        return zzel;
                    case 5:
                        zzemb<zzb> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzb.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzel);
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

        public enum zzc implements zzekj {
            UNKNOWN(0),
            ENABLED(1),
            DISABLED(2);
            
            private static final zzekm<zzc> zzep = null;
            private final int value;

            static {
                zzep = new zzbx();
            }

            private zzc(int i) {
                this.value = i;
            }

            public static zzc zzh(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return ENABLED;
                    case 2:
                        return DISABLED;
                    default:
                        return null;
                }
            }

            public static zzekl zzw() {
                return zzbz.zzer;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.value;
            }
        }

        static {
            zza zza = new zza();
            zzeh = zza;
            zzekh.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: private */
        public final void zzb(zzc zzc2) {
            this.zzeg = zzc2.zzv();
            this.zzdt |= 2048;
        }

        /* access modifiers changed from: private */
        public final void zzd(long j) {
            this.zzdt |= 2;
            this.zzdv = j;
        }

        /* access modifiers changed from: private */
        public final void zzo(String str) {
            str.getClass();
            this.zzdt |= 1;
            this.zzdu = str;
        }

        /* access modifiers changed from: private */
        public final void zzp(String str) {
            str.getClass();
            this.zzdt |= 4;
            this.zzdw = str;
        }

        /* access modifiers changed from: private */
        public final void zzq(String str) {
            str.getClass();
            this.zzdt |= 8;
            this.zzdx = str;
        }

        /* access modifiers changed from: private */
        public final void zzr(String str) {
            str.getClass();
            this.zzdt |= 16;
            this.zzdy = str;
        }

        public static C3701zza zzs() {
            return (C3701zza) zzeh.zzbhx();
        }

        /* access modifiers changed from: private */
        public final void zzs(String str) {
            str.getClass();
            this.zzdt |= 1024;
            this.zzee = str;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzbv.zzds[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3701zza((zzbv) null);
                case 3:
                    return zza((zzels) zzeh, "\u0001\r\u0000\u0001\u0001\r\r\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004\u0006ဂ\u0005\u0007ဂ\u0006\bဈ\u0007\tဂ\b\nဈ\t\u000bဈ\n\f\u001b\rဌ\u000b", new Object[]{"zzdt", "zzdu", "zzdv", "zzdw", "zzdx", "zzdy", "zzdz", "zzea", "zzeb", "zzec", "zzed", "zzee", "zzef", zzb.class, "zzeg", zzc.zzw()});
                case 4:
                    return zzeh;
                case 5:
                    zzemb<zza> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zza.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzeh);
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
}
