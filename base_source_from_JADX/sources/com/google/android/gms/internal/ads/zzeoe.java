package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import java.util.Collections;
import java.util.List;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

public final class zzeoe {

    public static final class zza extends zzekh<zza, C3708zza> implements zzelu {
        private static volatile zzemb<zza> zzei;
        /* access modifiers changed from: private */
        public static final zza zziuq;
        private int zzdt;
        private int zziuj;
        private zzb zziuk;
        private zzeiu zziul = zzeiu.zziiy;
        private zzeiu zzium = zzeiu.zziiy;
        private boolean zziun;
        private boolean zziuo;
        private byte zziup = 2;

        /* renamed from: com.google.android.gms.internal.ads.zzeoe$zza$zza  reason: collision with other inner class name */
        public static final class C3708zza extends zzekh.zza<zza, C3708zza> implements zzelu {
            private C3708zza() {
                super(zza.zziuq);
            }

            /* synthetic */ C3708zza(zzeod zzeod) {
                this();
            }
        }

        public static final class zzb extends zzekh<zzb, C3709zza> implements zzelu {
            private static volatile zzemb<zzb> zzei;
            /* access modifiers changed from: private */
            public static final zzb zziuv;
            private int zzdt;
            private String zziur = "";
            private String zzius = "";
            private String zziut = "";
            private int zziuu;

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zza$zzb$zza  reason: collision with other inner class name */
            public static final class C3709zza extends zzekh.zza<zzb, C3709zza> implements zzelu {
                private C3709zza() {
                    super(zzb.zziuv);
                }

                /* synthetic */ C3709zza(zzeod zzeod) {
                    this();
                }
            }

            static {
                zzb zzb = new zzb();
                zziuv = zzb;
                zzekh.zza(zzb.class, zzb);
            }

            private zzb() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeod.zzds[i - 1]) {
                    case 1:
                        return new zzb();
                    case 2:
                        return new C3709zza((zzeod) null);
                    case 3:
                        return zza((zzels) zziuv, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004င\u0003", new Object[]{"zzdt", "zziur", "zzius", "zziut", "zziuu"});
                    case 4:
                        return zziuv;
                    case 5:
                        zzemb<zzb> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzb.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zziuv);
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
            SAFE(0),
            DANGEROUS(1),
            UNKNOWN(2),
            POTENTIALLY_UNWANTED(3),
            DANGEROUS_HOST(4);
            
            private static final zzekm<zzc> zzep = null;
            private final int value;

            static {
                zzep = new zzeof();
            }

            private zzc(int i) {
                this.value = i;
            }

            public static zzc zzhx(int i) {
                switch (i) {
                    case 0:
                        return SAFE;
                    case 1:
                        return DANGEROUS;
                    case 2:
                        return UNKNOWN;
                    case 3:
                        return POTENTIALLY_UNWANTED;
                    case 4:
                        return DANGEROUS_HOST;
                    default:
                        return null;
                }
            }

            public static zzekl zzw() {
                return zzeog.zzer;
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
            zziuq = zza;
            zzekh.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzeod.zzds[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3708zza((zzeod) null);
                case 3:
                    return zza((zzels) zziuq, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0001\u0001ᔌ\u0000\u0002ဉ\u0001\u0003ည\u0002\u0004ည\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zzdt", "zziuj", zzc.zzw(), "zziuk", "zziul", "zzium", "zziun", "zziuo"});
                case 4:
                    return zziuq;
                case 5:
                    zzemb<zza> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zza.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zziuq);
                                zzei = zzemb;
                            }
                        }
                    }
                    return zzemb;
                case 6:
                    return Byte.valueOf(this.zziup);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zziup = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzb extends zzekh<zzb, C3711zzb> implements zzelu {
        private static volatile zzemb<zzb> zzei;
        /* access modifiers changed from: private */
        public static final zzb zzivr;
        private int zzbzz;
        private int zzdt;
        private zzeiu zziul = zzeiu.zziiy;
        private byte zziup = 2;
        private String zzius = "";
        private int zzivc;
        private String zzivd = "";
        private String zzive = "";
        private zza zzivf;
        private zzekp<zzh> zzivg = zzbic();
        private String zzivh = "";
        private zzf zzivi;
        private boolean zzivj;
        private zzekp<String> zzivk = zzekh.zzbic();
        private String zzivl = "";
        private boolean zzivm;
        private boolean zzivn;
        private zzi zzivo;
        private zzekp<String> zzivp = zzekh.zzbic();
        private zzekp<String> zzivq = zzekh.zzbic();

        public static final class zza extends zzekh<zza, C3710zza> implements zzelu {
            private static volatile zzemb<zza> zzei;
            /* access modifiers changed from: private */
            public static final zza zzivt;
            private int zzdt;
            private String zzivs = "";

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zza$zza  reason: collision with other inner class name */
            public static final class C3710zza extends zzekh.zza<zza, C3710zza> implements zzelu {
                private C3710zza() {
                    super(zza.zzivt);
                }

                /* synthetic */ C3710zza(zzeod zzeod) {
                    this();
                }

                public final C3710zza zzib(String str) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zza) this.zzinm).zzhx(str);
                    return this;
                }
            }

            static {
                zza zza = new zza();
                zzivt = zza;
                zzekh.zza(zza.class, zza);
            }

            private zza() {
            }

            public static C3710zza zzbky() {
                return (C3710zza) zzivt.zzbhx();
            }

            /* access modifiers changed from: private */
            public final void zzhx(String str) {
                str.getClass();
                this.zzdt |= 1;
                this.zzivs = str;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeod.zzds[i - 1]) {
                    case 1:
                        return new zza();
                    case 2:
                        return new C3710zza((zzeod) null);
                    case 3:
                        return zza((zzels) zzivt, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzdt", "zzivs"});
                    case 4:
                        return zzivt;
                    case 5:
                        zzemb<zza> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zza.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzivt);
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

        /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzb  reason: collision with other inner class name */
        public static final class C3711zzb extends zzekh.zza<zzb, C3711zzb> implements zzelu {
            private C3711zzb() {
                super(zzb.zzivr);
            }

            /* synthetic */ C3711zzb(zzeod zzeod) {
                this();
            }

            public final String getUrl() {
                return ((zzb) this.zzinm).getUrl();
            }

            public final C3711zzb zzb(zza zza) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).zza(zza);
                return this;
            }

            public final C3711zzb zzb(zzf zzf) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).zza(zzf);
                return this;
            }

            public final C3711zzb zzb(zzg zzg) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).zza(zzg);
                return this;
            }

            public final C3711zzb zzb(zzh zzh) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).zza(zzh);
                return this;
            }

            public final C3711zzb zzb(zzi zzi) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).zza(zzi);
                return this;
            }

            public final List<zzh> zzbkt() {
                return Collections.unmodifiableList(((zzb) this.zzinm).zzbkt());
            }

            public final String zzbku() {
                return ((zzb) this.zzinm).zzbku();
            }

            public final C3711zzb zzbla() {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).zzbkv();
                return this;
            }

            public final C3711zzb zzhy(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).setUrl(str);
                return this;
            }

            public final C3711zzb zzhz(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).zzhw(str);
                return this;
            }

            public final C3711zzb zzia(String str) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).zzdw(str);
                return this;
            }

            public final C3711zzb zzo(Iterable<String> iterable) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).zzm(iterable);
                return this;
            }

            public final C3711zzb zzp(Iterable<String> iterable) {
                if (this.zzinn) {
                    zzbhr();
                    this.zzinn = false;
                }
                ((zzb) this.zzinm).zzn(iterable);
                return this;
            }
        }

        public static final class zzc extends zzekh<zzc, zza> implements zzelu {
            private static volatile zzemb<zzc> zzei;
            /* access modifiers changed from: private */
            public static final zzc zzivv;
            private int zzdt;
            private zzeiu zzidt = zzeiu.zziiy;
            private byte zziup = 2;
            private zzeiu zzivu = zzeiu.zziiy;

            public static final class zza extends zzekh.zza<zzc, zza> implements zzelu {
                private zza() {
                    super(zzc.zzivv);
                }

                /* synthetic */ zza(zzeod zzeod) {
                    this();
                }

                public final zza zzap(zzeiu zzeiu) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzc) this.zzinm).zzao(zzeiu);
                    return this;
                }

                public final zza zzaq(zzeiu zzeiu) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzc) this.zzinm).zzaf(zzeiu);
                    return this;
                }
            }

            static {
                zzc zzc = new zzc();
                zzivv = zzc;
                zzekh.zza(zzc.class, zzc);
            }

            private zzc() {
            }

            /* access modifiers changed from: private */
            public final void zzaf(zzeiu zzeiu) {
                zzeiu.getClass();
                this.zzdt |= 2;
                this.zzidt = zzeiu;
            }

            /* access modifiers changed from: private */
            public final void zzao(zzeiu zzeiu) {
                zzeiu.getClass();
                this.zzdt |= 1;
                this.zzivu = zzeiu;
            }

            public static zza zzblb() {
                return (zza) zzivv.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzeod.zzds[i - 1]) {
                    case 1:
                        return new zzc();
                    case 2:
                        return new zza((zzeod) null);
                    case 3:
                        return zza((zzels) zzivv, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0001\u0001ᔊ\u0000\u0002ည\u0001", new Object[]{"zzdt", "zzivu", "zzidt"});
                    case 4:
                        return zzivv;
                    case 5:
                        zzemb<zzc> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzc.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzivv);
                                    zzei = zzemb;
                                }
                            }
                        }
                        return zzemb;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zziup = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zzd extends zzekh<zzd, C3713zzb> implements zzelu {
            private static volatile zzemb<zzd> zzei;
            /* access modifiers changed from: private */
            public static final zzd zziwb;
            private int zzdt;
            private byte zziup = 2;
            private zza zzivw;
            private zzekp<zzc> zzivx = zzbic();
            private zzeiu zzivy = zzeiu.zziiy;
            private zzeiu zzivz = zzeiu.zziiy;
            private int zziwa;

            public static final class zza extends zzekh<zza, C3712zza> implements zzelu {
                private static volatile zzemb<zza> zzei;
                /* access modifiers changed from: private */
                public static final zza zziwf;
                private int zzdt;
                private zzeiu zziwc = zzeiu.zziiy;
                private zzeiu zziwd = zzeiu.zziiy;
                private zzeiu zziwe = zzeiu.zziiy;

                /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzd$zza$zza  reason: collision with other inner class name */
                public static final class C3712zza extends zzekh.zza<zza, C3712zza> implements zzelu {
                    private C3712zza() {
                        super(zza.zziwf);
                    }

                    /* synthetic */ C3712zza(zzeod zzeod) {
                        this();
                    }
                }

                static {
                    zza zza = new zza();
                    zziwf = zza;
                    zzekh.zza(zza.class, zza);
                }

                private zza() {
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzeod.zzds[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C3712zza((zzeod) null);
                        case 3:
                            return zza((zzels) zziwf, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ည\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdt", "zziwc", "zziwd", "zziwe"});
                        case 4:
                            return zziwf;
                        case 5:
                            zzemb<zza> zzemb = zzei;
                            if (zzemb == null) {
                                synchronized (zza.class) {
                                    zzemb = zzei;
                                    if (zzemb == null) {
                                        zzemb = new zzekh.zzc<>(zziwf);
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

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzd$zzb  reason: collision with other inner class name */
            public static final class C3713zzb extends zzekh.zza<zzd, C3713zzb> implements zzelu {
                private C3713zzb() {
                    super(zzd.zziwb);
                }

                /* synthetic */ C3713zzb(zzeod zzeod) {
                    this();
                }

                public final C3713zzb zzb(zzc zzc) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzd) this.zzinm).zza(zzc);
                    return this;
                }
            }

            static {
                zzd zzd = new zzd();
                zziwb = zzd;
                zzekh.zza(zzd.class, zzd);
            }

            private zzd() {
            }

            /* access modifiers changed from: private */
            public final void zza(zzc zzc) {
                zzc.getClass();
                zzekp<zzc> zzekp = this.zzivx;
                if (!zzekp.zzbfk()) {
                    this.zzivx = zzekh.zza(zzekp);
                }
                this.zzivx.add(zzc);
            }

            public static C3713zzb zzbld() {
                return (C3713zzb) zziwb.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzeod.zzds[i - 1]) {
                    case 1:
                        return new zzd();
                    case 2:
                        return new C3713zzb((zzeod) null);
                    case 3:
                        return zza((zzels) zziwb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003", new Object[]{"zzdt", "zzivw", "zzivx", zzc.class, "zzivy", "zzivz", "zziwa"});
                    case 4:
                        return zziwb;
                    case 5:
                        zzemb<zzd> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzd.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zziwb);
                                    zzei = zzemb;
                                }
                            }
                        }
                        return zzemb;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zziup = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zze extends zzekh<zze, C3715zzb> implements zzelu {
            private static volatile zzemb<zze> zzei;
            /* access modifiers changed from: private */
            public static final zze zziwi;
            private int zzdt;
            private byte zziup = 2;
            private zzekp<zzc> zzivx = zzbic();
            private zzeiu zzivy = zzeiu.zziiy;
            private zzeiu zzivz = zzeiu.zziiy;
            private int zziwa;
            private zza zziwg;
            private zzeiu zziwh = zzeiu.zziiy;

            public static final class zza extends zzekh<zza, C3714zza> implements zzelu {
                private static volatile zzemb<zza> zzei;
                /* access modifiers changed from: private */
                public static final zza zziwl;
                private int zzdt;
                private zzeiu zziwe = zzeiu.zziiy;
                private int zziwj;
                private zzeiu zziwk = zzeiu.zziiy;

                /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zze$zza$zza  reason: collision with other inner class name */
                public static final class C3714zza extends zzekh.zza<zza, C3714zza> implements zzelu {
                    private C3714zza() {
                        super(zza.zziwl);
                    }

                    /* synthetic */ C3714zza(zzeod zzeod) {
                        this();
                    }
                }

                static {
                    zza zza = new zza();
                    zziwl = zza;
                    zzekh.zza(zza.class, zza);
                }

                private zza() {
                }

                /* access modifiers changed from: protected */
                public final Object zza(int i, Object obj, Object obj2) {
                    switch (zzeod.zzds[i - 1]) {
                        case 1:
                            return new zza();
                        case 2:
                            return new C3714zza((zzeod) null);
                        case 3:
                            return zza((zzels) zziwl, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001င\u0000\u0002ည\u0001\u0003ည\u0002", new Object[]{"zzdt", "zziwj", "zziwk", "zziwe"});
                        case 4:
                            return zziwl;
                        case 5:
                            zzemb<zza> zzemb = zzei;
                            if (zzemb == null) {
                                synchronized (zza.class) {
                                    zzemb = zzei;
                                    if (zzemb == null) {
                                        zzemb = new zzekh.zzc<>(zziwl);
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

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zze$zzb  reason: collision with other inner class name */
            public static final class C3715zzb extends zzekh.zza<zze, C3715zzb> implements zzelu {
                private C3715zzb() {
                    super(zze.zziwi);
                }

                /* synthetic */ C3715zzb(zzeod zzeod) {
                    this();
                }
            }

            static {
                zze zze = new zze();
                zziwi = zze;
                zzekh.zza(zze.class, zze);
            }

            private zze() {
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzeod.zzds[i - 1]) {
                    case 1:
                        return new zze();
                    case 2:
                        return new C3715zzb((zzeod) null);
                    case 3:
                        return zza((zzels) zziwi, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0001\u0001ဉ\u0000\u0002Л\u0003ည\u0001\u0004ည\u0002\u0005င\u0003\u0006ည\u0004", new Object[]{"zzdt", "zziwg", "zzivx", zzc.class, "zzivy", "zzivz", "zziwa", "zziwh"});
                    case 4:
                        return zziwi;
                    case 5:
                        zzemb<zze> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zze.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zziwi);
                                    zzei = zzemb;
                                }
                            }
                        }
                        return zzemb;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zziup = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }
        }

        public static final class zzf extends zzekh<zzf, C3716zzb> implements zzelu {
            private static volatile zzemb<zzf> zzei;
            /* access modifiers changed from: private */
            public static final zzf zziwo;
            private int zzbzz;
            private int zzdt;
            private String zziwm = "";
            private zzeiu zziwn = zzeiu.zziiy;

            public enum zza implements zzekj {
                TYPE_UNKNOWN(0),
                TYPE_CREATIVE(1);
                
                private static final zzekm<zza> zzep = null;
                private final int value;

                static {
                    zzep = new zzeoi();
                }

                private zza(int i) {
                    this.value = i;
                }

                public static zza zzhy(int i) {
                    switch (i) {
                        case 0:
                            return TYPE_UNKNOWN;
                        case 1:
                            return TYPE_CREATIVE;
                        default:
                            return null;
                    }
                }

                public static zzekl zzw() {
                    return zzeoh.zzer;
                }

                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
                }

                public final int zzv() {
                    return this.value;
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzf$zzb  reason: collision with other inner class name */
            public static final class C3716zzb extends zzekh.zza<zzf, C3716zzb> implements zzelu {
                private C3716zzb() {
                    super(zzf.zziwo);
                }

                /* synthetic */ C3716zzb(zzeod zzeod) {
                    this();
                }

                public final C3716zzb zzas(zzeiu zzeiu) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzf) this.zzinm).zzar(zzeiu);
                    return this;
                }

                public final C3716zzb zzb(zza zza) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzf) this.zzinm).zza(zza);
                    return this;
                }

                public final C3716zzb zzic(String str) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzf) this.zzinm).setMimeType(str);
                    return this;
                }
            }

            static {
                zzf zzf = new zzf();
                zziwo = zzf;
                zzekh.zza(zzf.class, zzf);
            }

            private zzf() {
            }

            /* access modifiers changed from: private */
            public final void setMimeType(String str) {
                str.getClass();
                this.zzdt |= 2;
                this.zziwm = str;
            }

            /* access modifiers changed from: private */
            public final void zza(zza zza2) {
                this.zzbzz = zza2.zzv();
                this.zzdt |= 1;
            }

            /* access modifiers changed from: private */
            public final void zzar(zzeiu zzeiu) {
                zzeiu.getClass();
                this.zzdt |= 4;
                this.zziwn = zzeiu;
            }

            public static C3716zzb zzbli() {
                return (C3716zzb) zziwo.zzbhx();
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeod.zzds[i - 1]) {
                    case 1:
                        return new zzf();
                    case 2:
                        return new C3716zzb((zzeod) null);
                    case 3:
                        return zza((zzels) zziwo, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ည\u0002", new Object[]{"zzdt", "zzbzz", zza.zzw(), "zziwm", "zziwn"});
                    case 4:
                        return zziwo;
                    case 5:
                        zzemb<zzf> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzf.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zziwo);
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

        public enum zzg implements zzekj {
            UNKNOWN(0),
            URL_PHISHING(1),
            URL_MALWARE(2),
            URL_UNWANTED(3),
            CLIENT_SIDE_PHISHING_URL(4),
            CLIENT_SIDE_MALWARE_URL(5),
            DANGEROUS_DOWNLOAD_RECOVERY(6),
            DANGEROUS_DOWNLOAD_WARNING(7),
            OCTAGON_AD(8),
            OCTAGON_AD_SB_MATCH(9);
            
            private static final zzekm<zzg> zzep = null;
            private final int value;

            static {
                zzep = new zzeoj();
            }

            private zzg(int i) {
                this.value = i;
            }

            public static zzg zzhz(int i) {
                switch (i) {
                    case 0:
                        return UNKNOWN;
                    case 1:
                        return URL_PHISHING;
                    case 2:
                        return URL_MALWARE;
                    case 3:
                        return URL_UNWANTED;
                    case 4:
                        return CLIENT_SIDE_PHISHING_URL;
                    case 5:
                        return CLIENT_SIDE_MALWARE_URL;
                    case 6:
                        return DANGEROUS_DOWNLOAD_RECOVERY;
                    case 7:
                        return DANGEROUS_DOWNLOAD_WARNING;
                    case 8:
                        return OCTAGON_AD;
                    case 9:
                        return OCTAGON_AD_SB_MATCH;
                    default:
                        return null;
                }
            }

            public static zzekl zzw() {
                return zzeok.zzer;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
            }

            public final int zzv() {
                return this.value;
            }
        }

        public static final class zzh extends zzekh<zzh, C3717zzb> implements zzelu {
            private static volatile zzemb<zzh> zzei;
            /* access modifiers changed from: private */
            public static final zzh zzixl;
            private int zzdt;
            private byte zziup = 2;
            private String zzius = "";
            private int zzixd;
            private zzd zzixe;
            private zze zzixf;
            private int zzixg;
            private zzeko zzixh = zzbia();
            private String zzixi = "";
            private int zzixj;
            private zzekp<String> zzixk = zzekh.zzbic();

            public enum zza implements zzekj {
                AD_RESOURCE_UNKNOWN(0),
                AD_RESOURCE_CREATIVE(1),
                AD_RESOURCE_POST_CLICK(2),
                AD_RESOURCE_AUTO_CLICK_DESTINATION(3);
                
                private static final zzekm<zza> zzep = null;
                private final int value;

                static {
                    zzep = new zzeol();
                }

                private zza(int i) {
                    this.value = i;
                }

                public static zza zzia(int i) {
                    switch (i) {
                        case 0:
                            return AD_RESOURCE_UNKNOWN;
                        case 1:
                            return AD_RESOURCE_CREATIVE;
                        case 2:
                            return AD_RESOURCE_POST_CLICK;
                        case 3:
                            return AD_RESOURCE_AUTO_CLICK_DESTINATION;
                        default:
                            return null;
                    }
                }

                public static zzekl zzw() {
                    return zzeom.zzer;
                }

                public final String toString() {
                    return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + '>';
                }

                public final int zzv() {
                    return this.value;
                }
            }

            /* renamed from: com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb  reason: collision with other inner class name */
            public static final class C3717zzb extends zzekh.zza<zzh, C3717zzb> implements zzelu {
                private C3717zzb() {
                    super(zzh.zzixl);
                }

                /* synthetic */ C3717zzb(zzeod zzeod) {
                    this();
                }

                public final C3717zzb zzb(zzd zzd) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzh) this.zzinm).zza(zzd);
                    return this;
                }

                public final C3717zzb zzb(zza zza) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzh) this.zzinm).zza(zza);
                    return this;
                }

                public final C3717zzb zzib(int i) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzh) this.zzinm).setId(i);
                    return this;
                }

                public final C3717zzb zzie(String str) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzh) this.zzinm).setUrl(str);
                    return this;
                }

                public final C3717zzb zzif(String str) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzh) this.zzinm).zzid(str);
                    return this;
                }
            }

            static {
                zzh zzh = new zzh();
                zzixl = zzh;
                zzekh.zza(zzh.class, zzh);
            }

            private zzh() {
            }

            /* access modifiers changed from: private */
            public final void setId(int i) {
                this.zzdt |= 1;
                this.zzixd = i;
            }

            /* access modifiers changed from: private */
            public final void setUrl(String str) {
                str.getClass();
                this.zzdt |= 2;
                this.zzius = str;
            }

            /* access modifiers changed from: private */
            public final void zza(zzd zzd) {
                zzd.getClass();
                this.zzixe = zzd;
                this.zzdt |= 4;
            }

            /* access modifiers changed from: private */
            public final void zza(zza zza2) {
                this.zzixj = zza2.zzv();
                this.zzdt |= 64;
            }

            public static C3717zzb zzbll() {
                return (C3717zzb) zzixl.zzbhx();
            }

            /* access modifiers changed from: private */
            public final void zzid(String str) {
                str.getClass();
                zzekp<String> zzekp = this.zzixk;
                if (!zzekp.zzbfk()) {
                    this.zzixk = zzekh.zza(zzekp);
                }
                this.zzixk.add(str);
            }

            public final String getUrl() {
                return this.zzius;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                int i2 = 0;
                switch (zzeod.zzds[i - 1]) {
                    case 1:
                        return new zzh();
                    case 2:
                        return new C3717zzb((zzeod) null);
                    case 3:
                        return zza((zzels) zzixl, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0002\u0003\u0001ᔄ\u0000\u0002ဈ\u0001\u0003ᐉ\u0002\u0004ᐉ\u0003\u0005င\u0004\u0006\u0016\u0007ဈ\u0005\bဌ\u0006\t\u001a", new Object[]{"zzdt", "zzixd", "zzius", "zzixe", "zzixf", "zzixg", "zzixh", "zzixi", "zzixj", zza.zzw(), "zzixk"});
                    case 4:
                        return zzixl;
                    case 5:
                        zzemb<zzh> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzh.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzixl);
                                    zzei = zzemb;
                                }
                            }
                        }
                        return zzemb;
                    case 6:
                        return Byte.valueOf(this.zziup);
                    case 7:
                        if (obj != null) {
                            i2 = 1;
                        }
                        this.zziup = (byte) i2;
                        return null;
                    default:
                        throw new UnsupportedOperationException();
                }
            }

            public final int zzblk() {
                return this.zzixk.size();
            }
        }

        public static final class zzi extends zzekh<zzi, zza> implements zzelu {
            private static volatile zzemb<zzi> zzei;
            /* access modifiers changed from: private */
            public static final zzi zzixu;
            private int zzdt;
            private String zzixr = "";
            private long zzixs;
            private boolean zzixt;

            public static final class zza extends zzekh.zza<zzi, zza> implements zzelu {
                private zza() {
                    super(zzi.zzixu);
                }

                /* synthetic */ zza(zzeod zzeod) {
                    this();
                }

                public final zza zzbw(boolean z) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzi) this.zzinm).zzbx(z);
                    return this;
                }

                public final zza zzfs(long j) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzi) this.zzinm).zzft(j);
                    return this;
                }

                public final zza zzig(String str) {
                    if (this.zzinn) {
                        zzbhr();
                        this.zzinn = false;
                    }
                    ((zzi) this.zzinm).zzih(str);
                    return this;
                }
            }

            static {
                zzi zzi = new zzi();
                zzixu = zzi;
                zzekh.zza(zzi.class, zzi);
            }

            private zzi() {
            }

            public static zza zzbln() {
                return (zza) zzixu.zzbhx();
            }

            /* access modifiers changed from: private */
            public final void zzbx(boolean z) {
                this.zzdt |= 4;
                this.zzixt = z;
            }

            /* access modifiers changed from: private */
            public final void zzft(long j) {
                this.zzdt |= 2;
                this.zzixs = j;
            }

            /* access modifiers changed from: private */
            public final void zzih(String str) {
                str.getClass();
                this.zzdt |= 1;
                this.zzixr = str;
            }

            /* access modifiers changed from: protected */
            public final Object zza(int i, Object obj, Object obj2) {
                switch (zzeod.zzds[i - 1]) {
                    case 1:
                        return new zzi();
                    case 2:
                        return new zza((zzeod) null);
                    case 3:
                        return zza((zzels) zzixu, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဇ\u0002", new Object[]{"zzdt", "zzixr", "zzixs", "zzixt"});
                    case 4:
                        return zzixu;
                    case 5:
                        zzemb<zzi> zzemb = zzei;
                        if (zzemb == null) {
                            synchronized (zzi.class) {
                                zzemb = zzei;
                                if (zzemb == null) {
                                    zzemb = new zzekh.zzc<>(zzixu);
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

        static {
            zzb zzb = new zzb();
            zzivr = zzb;
            zzekh.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: private */
        public final void setUrl(String str) {
            str.getClass();
            this.zzdt |= 4;
            this.zzius = str;
        }

        /* access modifiers changed from: private */
        public final void zza(zza zza2) {
            zza2.getClass();
            this.zzivf = zza2;
            this.zzdt |= 32;
        }

        /* access modifiers changed from: private */
        public final void zza(zzf zzf2) {
            zzf2.getClass();
            this.zzivi = zzf2;
            this.zzdt |= 128;
        }

        /* access modifiers changed from: private */
        public final void zza(zzg zzg2) {
            this.zzbzz = zzg2.zzv();
            this.zzdt |= 1;
        }

        /* access modifiers changed from: private */
        public final void zza(zzh zzh2) {
            zzh2.getClass();
            zzekp<zzh> zzekp = this.zzivg;
            if (!zzekp.zzbfk()) {
                this.zzivg = zzekh.zza(zzekp);
            }
            this.zzivg.add(zzh2);
        }

        /* access modifiers changed from: private */
        public final void zza(zzi zzi2) {
            zzi2.getClass();
            this.zzivo = zzi2;
            this.zzdt |= PKIFailureInfo.certRevoked;
        }

        /* access modifiers changed from: private */
        public final void zzbkv() {
            this.zzdt &= -65;
            this.zzivh = zzivr.zzivh;
        }

        public static C3711zzb zzbkw() {
            return (C3711zzb) zzivr.zzbhx();
        }

        /* access modifiers changed from: private */
        public final void zzdw(String str) {
            str.getClass();
            this.zzdt |= 64;
            this.zzivh = str;
        }

        /* access modifiers changed from: private */
        public final void zzhw(String str) {
            str.getClass();
            this.zzdt |= 8;
            this.zzivd = str;
        }

        /* access modifiers changed from: private */
        public final void zzm(Iterable<String> iterable) {
            zzekp<String> zzekp = this.zzivp;
            if (!zzekp.zzbfk()) {
                this.zzivp = zzekh.zza(zzekp);
            }
            zzeik.zza(iterable, this.zzivp);
        }

        /* access modifiers changed from: private */
        public final void zzn(Iterable<String> iterable) {
            zzekp<String> zzekp = this.zzivq;
            if (!zzekp.zzbfk()) {
                this.zzivq = zzekh.zza(zzekp);
            }
            zzeik.zza(iterable, this.zzivq);
        }

        public final String getUrl() {
            return this.zzius;
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            int i2 = 0;
            switch (zzeod.zzds[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new C3711zzb((zzeod) null);
                case 3:
                    return zza((zzels) zzivr, "\u0001\u0012\u0000\u0001\u0001\u0015\u0012\u0000\u0004\u0001\u0001ဈ\u0002\u0002ဈ\u0003\u0003ဈ\u0004\u0004Л\u0005ဇ\b\u0006\u001a\u0007ဈ\t\bဇ\n\tဇ\u000b\nဌ\u0000\u000bဌ\u0001\fဉ\u0005\rဈ\u0006\u000eဉ\u0007\u000fည\f\u0011ဉ\r\u0014\u001a\u0015\u001a", new Object[]{"zzdt", "zzius", "zzivd", "zzive", "zzivg", zzh.class, "zzivj", "zzivk", "zzivl", "zzivm", "zzivn", "zzbzz", zzg.zzw(), "zzivc", zza.zzc.zzw(), "zzivf", "zzivh", "zzivi", "zziul", "zzivo", "zzivp", "zzivq"});
                case 4:
                    return zzivr;
                case 5:
                    zzemb<zzb> zzemb = zzei;
                    if (zzemb == null) {
                        synchronized (zzb.class) {
                            zzemb = zzei;
                            if (zzemb == null) {
                                zzemb = new zzekh.zzc<>(zzivr);
                                zzei = zzemb;
                            }
                        }
                    }
                    return zzemb;
                case 6:
                    return Byte.valueOf(this.zziup);
                case 7:
                    if (obj != null) {
                        i2 = 1;
                    }
                    this.zziup = (byte) i2;
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        public final List<zzh> zzbkt() {
            return this.zzivg;
        }

        public final String zzbku() {
            return this.zzivh;
        }
    }
}
