package com.google.android.gms.internal.ads;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

final class zzenl {
    private static final Logger logger = Logger.getLogger(zzenl.class.getName());
    private static final Unsafe zzhwj = zzbkl();
    private static final Class<?> zziiq = zzeir.zzbfo();
    private static final boolean zzikb = zzbkm();
    private static final boolean zzise = zzm(Long.TYPE);
    private static final boolean zzisf = zzm(Integer.TYPE);
    private static final zzd zzisg;
    private static final boolean zzish = zzbkn();
    private static final long zzisi = ((long) zzk(byte[].class));
    private static final long zzisj = ((long) zzk(boolean[].class));
    private static final long zzisk = ((long) zzl(boolean[].class));
    private static final long zzisl = ((long) zzk(int[].class));
    private static final long zzism = ((long) zzl(int[].class));
    private static final long zzisn = ((long) zzk(long[].class));
    private static final long zziso = ((long) zzl(long[].class));
    private static final long zzisp = ((long) zzk(float[].class));
    private static final long zzisq = ((long) zzl(float[].class));
    private static final long zzisr = ((long) zzk(double[].class));
    private static final long zziss = ((long) zzl(double[].class));
    private static final long zzist = ((long) zzk(Object[].class));
    private static final long zzisu = ((long) zzl(Object[].class));
    private static final long zzisv;
    private static final int zzisw = ((int) (zzisi & 7));
    static final boolean zzisx = (ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN);

    static final class zza extends zzd {
        zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzenl.zzisx) {
                zzenl.zzb(obj, j, z);
            } else {
                zzenl.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzenl.zzisx) {
                zzenl.zza(obj, j, b);
            } else {
                zzenl.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            return zzenl.zzisx ? zzenl.zzs(obj, j) : zzenl.zzt(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final byte zzy(Object obj, long j) {
            return zzenl.zzisx ? zzenl.zzq(obj, j) : zzenl.zzr(obj, j);
        }
    }

    static final class zzb extends zzd {
        zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            this.zzita.putDouble(obj, j, d);
        }

        public final void zza(Object obj, long j, float f) {
            this.zzita.putFloat(obj, j, f);
        }

        public final void zza(Object obj, long j, boolean z) {
            this.zzita.putBoolean(obj, j, z);
        }

        public final void zze(Object obj, long j, byte b) {
            this.zzita.putByte(obj, j, b);
        }

        public final boolean zzm(Object obj, long j) {
            return this.zzita.getBoolean(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return this.zzita.getFloat(obj, j);
        }

        public final double zzo(Object obj, long j) {
            return this.zzita.getDouble(obj, j);
        }

        public final byte zzy(Object obj, long j) {
            return this.zzita.getByte(obj, j);
        }
    }

    static final class zzc extends zzd {
        zzc(Unsafe unsafe) {
            super(unsafe);
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zzb(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzenl.zzisx) {
                zzenl.zzb(obj, j, z);
            } else {
                zzenl.zzc(obj, j, z);
            }
        }

        public final void zze(Object obj, long j, byte b) {
            if (zzenl.zzisx) {
                zzenl.zza(obj, j, b);
            } else {
                zzenl.zzb(obj, j, b);
            }
        }

        public final boolean zzm(Object obj, long j) {
            return zzenl.zzisx ? zzenl.zzs(obj, j) : zzenl.zzt(obj, j);
        }

        public final float zzn(Object obj, long j) {
            return Float.intBitsToFloat(zzk(obj, j));
        }

        public final double zzo(Object obj, long j) {
            return Double.longBitsToDouble(zzl(obj, j));
        }

        public final byte zzy(Object obj, long j) {
            return zzenl.zzisx ? zzenl.zzq(obj, j) : zzenl.zzr(obj, j);
        }
    }

    static abstract class zzd {
        Unsafe zzita;

        zzd(Unsafe unsafe) {
            this.zzita = unsafe;
        }

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, long j2) {
            this.zzita.putLong(obj, j, j2);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public final void zzb(Object obj, long j, int i) {
            this.zzita.putInt(obj, j, i);
        }

        public abstract void zze(Object obj, long j, byte b);

        public final int zzk(Object obj, long j) {
            return this.zzita.getInt(obj, j);
        }

        public final long zzl(Object obj, long j) {
            return this.zzita.getLong(obj, j);
        }

        public abstract boolean zzm(Object obj, long j);

        public abstract float zzn(Object obj, long j);

        public abstract double zzo(Object obj, long j);

        public abstract byte zzy(Object obj, long j);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x00dc, code lost:
        r1 = zzisg;
     */
    static {
        /*
            java.lang.Class<com.google.android.gms.internal.ads.zzenl> r0 = com.google.android.gms.internal.ads.zzenl.class
            java.lang.String r0 = r0.getName()
            java.util.logging.Logger r0 = java.util.logging.Logger.getLogger(r0)
            logger = r0
            sun.misc.Unsafe r0 = zzbkl()
            zzhwj = r0
            java.lang.Class r0 = com.google.android.gms.internal.ads.zzeir.zzbfo()
            zziiq = r0
            java.lang.Class r0 = java.lang.Long.TYPE
            boolean r0 = zzm(r0)
            zzise = r0
            java.lang.Class r0 = java.lang.Integer.TYPE
            boolean r0 = zzm(r0)
            zzisf = r0
            sun.misc.Unsafe r0 = zzhwj
            r1 = 0
            if (r0 != 0) goto L_0x002e
            goto L_0x0053
        L_0x002e:
            boolean r0 = com.google.android.gms.internal.ads.zzeir.zzbfn()
            if (r0 == 0) goto L_0x004c
            boolean r0 = zzise
            if (r0 == 0) goto L_0x0040
            com.google.android.gms.internal.ads.zzenl$zzc r1 = new com.google.android.gms.internal.ads.zzenl$zzc
            sun.misc.Unsafe r0 = zzhwj
            r1.<init>(r0)
            goto L_0x0053
        L_0x0040:
            boolean r0 = zzisf
            if (r0 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzenl$zza r1 = new com.google.android.gms.internal.ads.zzenl$zza
            sun.misc.Unsafe r0 = zzhwj
            r1.<init>(r0)
            goto L_0x0053
        L_0x004c:
            com.google.android.gms.internal.ads.zzenl$zzb r1 = new com.google.android.gms.internal.ads.zzenl$zzb
            sun.misc.Unsafe r0 = zzhwj
            r1.<init>(r0)
        L_0x0053:
            zzisg = r1
            boolean r0 = zzbkn()
            zzish = r0
            boolean r0 = zzbkm()
            zzikb = r0
            java.lang.Class<byte[]> r0 = byte[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzisi = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzisj = r0
            java.lang.Class<boolean[]> r0 = boolean[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzisk = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzisl = r0
            java.lang.Class<int[]> r0 = int[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzism = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzisn = r0
            java.lang.Class<long[]> r0 = long[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zziso = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzisp = r0
            java.lang.Class<float[]> r0 = float[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzisq = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzisr = r0
            java.lang.Class<double[]> r0 = double[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zziss = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzk(r0)
            long r0 = (long) r0
            zzist = r0
            java.lang.Class<java.lang.Object[]> r0 = java.lang.Object[].class
            int r0 = zzl(r0)
            long r0 = (long) r0
            zzisu = r0
            java.lang.reflect.Field r0 = zzbko()
            if (r0 == 0) goto L_0x00e8
            com.google.android.gms.internal.ads.zzenl$zzd r1 = zzisg
            if (r1 != 0) goto L_0x00e1
            goto L_0x00e8
        L_0x00e1:
            sun.misc.Unsafe r1 = r1.zzita
            long r0 = r1.objectFieldOffset(r0)
            goto L_0x00ea
        L_0x00e8:
            r0 = -1
        L_0x00ea:
            zzisv = r0
            long r0 = zzisi
            r2 = 7
            long r0 = r0 & r2
            int r1 = (int) r0
            zzisw = r1
            java.nio.ByteOrder r0 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r1 = java.nio.ByteOrder.BIG_ENDIAN
            if (r0 != r1) goto L_0x00fe
            r0 = 1
            goto L_0x00ff
        L_0x00fe:
            r0 = 0
        L_0x00ff:
            zzisx = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzenl.<clinit>():void");
    }

    private zzenl() {
    }

    static byte zza(byte[] bArr, long j) {
        return zzisg.zzy(bArr, zzisi + j);
    }

    /* access modifiers changed from: private */
    public static void zza(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int zzk = zzk(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk & (~(255 << i))));
    }

    static void zza(Object obj, long j, double d) {
        zzisg.zza(obj, j, d);
    }

    static void zza(Object obj, long j, float f) {
        zzisg.zza(obj, j, f);
    }

    static void zza(Object obj, long j, long j2) {
        zzisg.zza(obj, j, j2);
    }

    static void zza(Object obj, long j, Object obj2) {
        zzisg.zzita.putObject(obj, j, obj2);
    }

    static void zza(Object obj, long j, boolean z) {
        zzisg.zza(obj, j, z);
    }

    static void zza(byte[] bArr, long j, byte b) {
        zzisg.zze(bArr, zzisi + j, b);
    }

    private static Field zzb(Class<?> cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, byte b) {
        long j2 = -4 & j;
        int i = (((int) j) & 3) << 3;
        zzb(obj, j2, ((255 & b) << i) | (zzk(obj, j2) & (~(255 << i))));
    }

    static void zzb(Object obj, long j, int i) {
        zzisg.zzb(obj, j, i);
    }

    /* access modifiers changed from: private */
    public static void zzb(Object obj, long j, boolean z) {
        zza(obj, j, z ? (byte) 1 : 0);
    }

    static boolean zzbkj() {
        return zzikb;
    }

    static boolean zzbkk() {
        return zzish;
    }

    static Unsafe zzbkl() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzenn());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static boolean zzbkm() {
        Unsafe unsafe = zzhwj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
            cls.getMethod("arrayIndexScale", new Class[]{Class.class});
            cls.getMethod("getInt", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putInt", new Class[]{Object.class, Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putLong", new Class[]{Object.class, Long.TYPE, Long.TYPE});
            cls.getMethod("getObject", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putObject", new Class[]{Object.class, Long.TYPE, Object.class});
            if (zzeir.zzbfn()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putByte", new Class[]{Object.class, Long.TYPE, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putBoolean", new Class[]{Object.class, Long.TYPE, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putFloat", new Class[]{Object.class, Long.TYPE, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, Long.TYPE});
            cls.getMethod("putDouble", new Class[]{Object.class, Long.TYPE, Double.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeArrayOperations", sb.toString());
            return false;
        }
    }

    private static boolean zzbkn() {
        Unsafe unsafe = zzhwj;
        if (unsafe == null) {
            return false;
        }
        try {
            Class<?> cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
            if (zzbko() == null) {
                return false;
            }
            if (zzeir.zzbfn()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Long.TYPE});
            cls.getMethod("putByte", new Class[]{Long.TYPE, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{Long.TYPE});
            cls.getMethod("putInt", new Class[]{Long.TYPE, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{Long.TYPE});
            cls.getMethod("putLong", new Class[]{Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Long.TYPE, Long.TYPE, Long.TYPE});
            cls.getMethod("copyMemory", new Class[]{Object.class, Long.TYPE, Object.class, Long.TYPE, Long.TYPE});
            return true;
        } catch (Throwable th) {
            Logger logger2 = logger;
            Level level = Level.WARNING;
            String valueOf = String.valueOf(th);
            StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 71);
            sb.append("platform method missing - proto runtime falling back to safer methods: ");
            sb.append(valueOf);
            logger2.logp(level, "com.google.protobuf.UnsafeUtil", "supportsUnsafeByteBufferOperations", sb.toString());
            return false;
        }
    }

    private static Field zzbko() {
        Field zzb2;
        if (zzeir.zzbfn() && (zzb2 = zzb(Buffer.class, "effectiveDirectAddress")) != null) {
            return zzb2;
        }
        Field zzb3 = zzb(Buffer.class, "address");
        if (zzb3 == null || zzb3.getType() != Long.TYPE) {
            return null;
        }
        return zzb3;
    }

    /* access modifiers changed from: private */
    public static void zzc(Object obj, long j, boolean z) {
        zzb(obj, j, z ? (byte) 1 : 0);
    }

    static <T> T zzj(Class<T> cls) {
        try {
            return zzhwj.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzk(Class<?> cls) {
        if (zzikb) {
            return zzisg.zzita.arrayBaseOffset(cls);
        }
        return -1;
    }

    static int zzk(Object obj, long j) {
        return zzisg.zzk(obj, j);
    }

    private static int zzl(Class<?> cls) {
        if (zzikb) {
            return zzisg.zzita.arrayIndexScale(cls);
        }
        return -1;
    }

    static long zzl(Object obj, long j) {
        return zzisg.zzl(obj, j);
    }

    private static boolean zzm(Class<?> cls) {
        if (!zzeir.zzbfn()) {
            return false;
        }
        try {
            Class<?> cls2 = zziiq;
            cls2.getMethod("peekLong", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, Boolean.TYPE});
            cls2.getMethod("pokeInt", new Class[]{cls, Integer.TYPE, Boolean.TYPE});
            cls2.getMethod("peekInt", new Class[]{cls, Boolean.TYPE});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, Integer.TYPE, Integer.TYPE});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    static boolean zzm(Object obj, long j) {
        return zzisg.zzm(obj, j);
    }

    static float zzn(Object obj, long j) {
        return zzisg.zzn(obj, j);
    }

    static double zzo(Object obj, long j) {
        return zzisg.zzo(obj, j);
    }

    static Object zzp(Object obj, long j) {
        return zzisg.zzita.getObject(obj, j);
    }

    /* access modifiers changed from: private */
    public static byte zzq(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) (((~j) & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static byte zzr(Object obj, long j) {
        return (byte) (zzk(obj, -4 & j) >>> ((int) ((j & 3) << 3)));
    }

    /* access modifiers changed from: private */
    public static boolean zzs(Object obj, long j) {
        return zzq(obj, j) != 0;
    }

    /* access modifiers changed from: private */
    public static boolean zzt(Object obj, long j) {
        return zzr(obj, j) != 0;
    }
}
