package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhv;

public final class zzci {

    public static final class zza extends zzhv<zza, C3726zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zza zzd;
        private static volatile zzjp<zza> zze;
        private zzid<zzb> zzc = zzbs();

        /* renamed from: com.google.android.gms.internal.measurement.zzci$zza$zza  reason: collision with other inner class name */
        public static final class C3726zza extends zzhv.zzb<zza, C3726zza> implements zzji {
            private C3726zza() {
                super(zza.zzd);
            }

            /* synthetic */ C3726zza(zzch zzch) {
                this();
            }
        }

        static {
            zza zza = new zza();
            zzd = zza;
            zzhv.zza(zza.class, zza);
        }

        private zza() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzch.zza[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C3726zza((zzch) null);
                case 3:
                    return zza((zzjg) zzd, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzc", zzb.class});
                case 4:
                    return zzd;
                case 5:
                    zzjp<zza> zzjp = zze;
                    if (zzjp == null) {
                        synchronized (zza.class) {
                            zzjp = zze;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzd);
                                zze = zzjp;
                            }
                        }
                    }
                    return zzjp;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }
    }

    public static final class zzb extends zzhv<zzb, zza> implements zzji {
        /* access modifiers changed from: private */
        public static final zzb zzk;
        private static volatile zzjp<zzb> zzl;
        private int zzc;
        private int zzd;
        private String zze = "";
        private boolean zzf;
        private long zzg;
        private double zzh;
        private zzid<zzb> zzi = zzbs();
        private String zzj = "";

        public static final class zza extends zzhv.zzb<zzb, zza> implements zzji {
            private zza() {
                super(zzb.zzk);
            }

            /* synthetic */ zza(zzch zzch) {
                this();
            }
        }

        /* renamed from: com.google.android.gms.internal.measurement.zzci$zzb$zzb  reason: collision with other inner class name */
        public enum C3727zzb implements zzia {
            UNDEFINED(0),
            NULL(1),
            STRING(2),
            NUMBER(3),
            BOOLEAN(4),
            LIST(5),
            MAP(6),
            STATEMENT(7);
            
            private static final zzhz<C3727zzb> zzi = null;
            private final int zzj;

            static {
                zzi = new zzcj();
            }

            private C3727zzb(int i) {
                this.zzj = i;
            }

            public static C3727zzb zza(int i) {
                switch (i) {
                    case 0:
                        return UNDEFINED;
                    case 1:
                        return NULL;
                    case 2:
                        return STRING;
                    case 3:
                        return NUMBER;
                    case 4:
                        return BOOLEAN;
                    case 5:
                        return LIST;
                    case 6:
                        return MAP;
                    case 7:
                        return STATEMENT;
                    default:
                        return null;
                }
            }

            public static zzic zzb() {
                return zzcl.zza;
            }

            public final String toString() {
                return "<" + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.zzj + " name=" + name() + '>';
            }

            public final int zza() {
                return this.zzj;
            }
        }

        static {
            zzb zzb = new zzb();
            zzk = zzb;
            zzhv.zza(zzb.class, zzb);
        }

        private zzb() {
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzch.zza[i - 1]) {
                case 1:
                    return new zzb();
                case 2:
                    return new zza((zzch) null);
                case 3:
                    return zza((zzjg) zzk, "\u0001\u0007\u0000\u0001\u0001\u0007\u0007\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004ဂ\u0003\u0005က\u0004\u0006\u001b\u0007ဈ\u0005", new Object[]{"zzc", "zzd", C3727zzb.zzb(), "zze", "zzf", "zzg", "zzh", "zzi", zzb.class, "zzj"});
                case 4:
                    return zzk;
                case 5:
                    zzjp<zzb> zzjp = zzl;
                    if (zzjp == null) {
                        synchronized (zzb.class) {
                            zzjp = zzl;
                            if (zzjp == null) {
                                zzjp = new zzhv.zza<>(zzk);
                                zzl = zzjp;
                            }
                        }
                    }
                    return zzjp;
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
