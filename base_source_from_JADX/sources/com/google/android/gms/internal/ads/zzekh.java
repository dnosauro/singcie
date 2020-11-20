package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzekh;
import com.google.android.gms.internal.ads.zzekh.zza;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public abstract class zzekh<MessageType extends zzekh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzeik<MessageType, BuilderType> {
    private static Map<Object, zzekh<?, ?>> zzinq = new ConcurrentHashMap();
    protected zzeni zzino = zzeni.zzbkg();
    private int zzinp = -1;

    public static abstract class zza<MessageType extends zzekh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> extends zzein<MessageType, BuilderType> {
        private final MessageType zzinl;
        protected MessageType zzinm;
        protected boolean zzinn = false;

        protected zza(MessageType messagetype) {
            this.zzinl = messagetype;
            this.zzinm = (zzekh) messagetype.zza(zzf.zzinx, (Object) null, (Object) null);
        }

        private static void zza(MessageType messagetype, MessageType messagetype2) {
            zzemg.zzbjn().zzax(messagetype).zzg(messagetype, messagetype2);
        }

        /* access modifiers changed from: private */
        /* renamed from: zzb */
        public final BuilderType zza(zzejj zzejj, zzeju zzeju) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            try {
                zzemg.zzbjn().zzax(this.zzinm).zza(this.zzinm, zzejm.zza(zzejj), zzeju);
                return this;
            } catch (RuntimeException e) {
                if (e.getCause() instanceof IOException) {
                    throw ((IOException) e.getCause());
                }
                throw e;
            }
        }

        private final BuilderType zzb(byte[] bArr, int i, int i2, zzeju zzeju) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            try {
                zzemg.zzbjn().zzax(this.zzinm).zza(this.zzinm, bArr, 0, i2, new zzeit(zzeju));
                return this;
            } catch (zzeks e) {
                throw e;
            } catch (IndexOutOfBoundsException unused) {
                throw zzeks.zzbii();
            } catch (IOException e2) {
                throw new RuntimeException("Reading from byte array should not throw IOException.", e2);
            }
        }

        public /* synthetic */ Object clone() {
            zza zza = (zza) ((zzekh) this.zzinl).zza(zzf.zziny, (Object) null, (Object) null);
            zza.zza((zzekh) zzbhu());
            return zza;
        }

        public final boolean isInitialized() {
            return zzekh.zza(this.zzinm, false);
        }

        public final /* synthetic */ zzein zza(byte[] bArr, int i, int i2, zzeju zzeju) {
            return zzb(bArr, 0, i2, zzeju);
        }

        public final BuilderType zza(MessageType messagetype) {
            if (this.zzinn) {
                zzbhr();
                this.zzinn = false;
            }
            zza(this.zzinm, messagetype);
            return this;
        }

        public final /* synthetic */ zzein zzbfj() {
            return (zza) clone();
        }

        /* access modifiers changed from: protected */
        public void zzbhr() {
            MessageType messagetype = (zzekh) this.zzinm.zza(zzf.zzinx, (Object) null, (Object) null);
            zza(messagetype, this.zzinm);
            this.zzinm = messagetype;
        }

        /* renamed from: zzbhs */
        public MessageType zzbhu() {
            if (this.zzinn) {
                return this.zzinm;
            }
            MessageType messagetype = this.zzinm;
            zzemg.zzbjn().zzax(messagetype).zzak(messagetype);
            this.zzinn = true;
            return this.zzinm;
        }

        /* renamed from: zzbht */
        public final MessageType zzbhv() {
            MessageType messagetype = (zzekh) zzbhu();
            if (messagetype.isInitialized()) {
                return messagetype;
            }
            throw new zzeng(messagetype);
        }

        public final /* synthetic */ zzels zzbhw() {
            return this.zzinl;
        }
    }

    public static abstract class zzb<MessageType extends zzb<MessageType, BuilderType>, BuilderType> extends zzekh<MessageType, BuilderType> implements zzelu {
        protected zzejx<zze> zzinr = zzejx.zzbhg();

        /* access modifiers changed from: package-private */
        public final zzejx<zze> zzbif() {
            if (this.zzinr.isImmutable()) {
                this.zzinr = (zzejx) this.zzinr.clone();
            }
            return this.zzinr;
        }
    }

    public static class zzc<T extends zzekh<T, ?>> extends zzeip<T> {
        private final T zzinl;

        public zzc(T t) {
            this.zzinl = t;
        }
    }

    public static class zzd<ContainingType extends zzels, Type> extends zzejs<ContainingType, Type> {
    }

    static final class zze implements zzejz<zze> {
        public final /* synthetic */ int compareTo(Object obj) {
            throw new NoSuchMethodError();
        }

        public final zzelr zza(zzelr zzelr, zzels zzels) {
            throw new NoSuchMethodError();
        }

        public final zzelx zza(zzelx zzelx, zzelx zzelx2) {
            throw new NoSuchMethodError();
        }

        public final zzenw zzbhl() {
            throw new NoSuchMethodError();
        }

        public final zzenz zzbhm() {
            throw new NoSuchMethodError();
        }

        public final boolean zzbhn() {
            throw new NoSuchMethodError();
        }

        public final boolean zzbho() {
            throw new NoSuchMethodError();
        }

        public final int zzv() {
            throw new NoSuchMethodError();
        }
    }

    /* 'enum' modifier removed */
    public static final class zzf {
        public static final int zzinu = 1;
        public static final int zzinv = 2;
        public static final int zzinw = 3;
        public static final int zzinx = 4;
        public static final int zziny = 5;
        public static final int zzinz = 6;
        public static final int zzioa = 7;
        private static final /* synthetic */ int[] zziob = {zzinu, zzinv, zzinw, zzinx, zziny, zzinz, zzioa};

        public static int[] zzbih() {
            return (int[]) zziob.clone();
        }
    }

    protected static <T extends zzekh<T, ?>> T zza(T t, zzeiu zzeiu) {
        return zzb(zzb(zzb(t, zzeiu, zzeju.zzbhe())));
    }

    protected static <T extends zzekh<T, ?>> T zza(T t, zzeiu zzeiu, zzeju zzeju) {
        return zzb(zzb(t, zzeiu, zzeju));
    }

    private static <T extends zzekh<T, ?>> T zza(T t, zzejj zzejj, zzeju zzeju) {
        T t2 = (zzekh) t.zza(zzf.zzinx, (Object) null, (Object) null);
        try {
            zzemn zzax = zzemg.zzbjn().zzax(t2);
            zzax.zza(t2, zzejm.zza(zzejj), zzeju);
            zzax.zzak(t2);
            return t2;
        } catch (IOException e) {
            if (e.getCause() instanceof zzeks) {
                throw ((zzeks) e.getCause());
            }
            throw new zzeks(e.getMessage()).zzl(t2);
        } catch (RuntimeException e2) {
            if (e2.getCause() instanceof zzeks) {
                throw ((zzeks) e2.getCause());
            }
            throw e2;
        }
    }

    protected static <T extends zzekh<T, ?>> T zza(T t, byte[] bArr) {
        return zzb(zza(t, bArr, 0, bArr.length, zzeju.zzbhe()));
    }

    private static <T extends zzekh<T, ?>> T zza(T t, byte[] bArr, int i, int i2, zzeju zzeju) {
        T t2 = (zzekh) t.zza(zzf.zzinx, (Object) null, (Object) null);
        try {
            zzemn zzax = zzemg.zzbjn().zzax(t2);
            zzax.zza(t2, bArr, 0, i2, new zzeit(zzeju));
            zzax.zzak(t2);
            if (t2.zziij == 0) {
                return t2;
            }
            throw new RuntimeException();
        } catch (IOException e) {
            if (e.getCause() instanceof zzeks) {
                throw ((zzeks) e.getCause());
            }
            throw new zzeks(e.getMessage()).zzl(t2);
        } catch (IndexOutOfBoundsException unused) {
            throw zzeks.zzbii().zzl(t2);
        }
    }

    protected static <T extends zzekh<T, ?>> T zza(T t, byte[] bArr, zzeju zzeju) {
        return zzb(zza(t, bArr, 0, bArr.length, zzeju));
    }

    protected static zzeko zza(zzeko zzeko) {
        int size = zzeko.size();
        return zzeko.zzhf(size == 0 ? 10 : size << 1);
    }

    protected static <E> zzekp<E> zza(zzekp<E> zzekp) {
        int size = zzekp.size();
        return zzekp.zzfx(size == 0 ? 10 : size << 1);
    }

    protected static Object zza(zzels zzels, String str, Object[] objArr) {
        return new zzemi(zzels, str, objArr);
    }

    static Object zza(Method method, Object obj, Object... objArr) {
        try {
            return method.invoke(obj, objArr);
        } catch (IllegalAccessException e) {
            throw new RuntimeException("Couldn't use Java reflection to implement protocol message reflection.", e);
        } catch (InvocationTargetException e2) {
            Throwable cause = e2.getCause();
            if (cause instanceof RuntimeException) {
                throw ((RuntimeException) cause);
            } else if (cause instanceof Error) {
                throw ((Error) cause);
            } else {
                throw new RuntimeException("Unexpected exception thrown by generated accessor method.", cause);
            }
        }
    }

    protected static <T extends zzekh<?, ?>> void zza(Class<T> cls, T t) {
        zzinq.put(cls, t);
    }

    protected static final <T extends zzekh<T, ?>> boolean zza(T t, boolean z) {
        byte byteValue = ((Byte) t.zza(zzf.zzinu, (Object) null, (Object) null)).byteValue();
        if (byteValue == 1) {
            return true;
        }
        if (byteValue == 0) {
            return false;
        }
        boolean zzaw = zzemg.zzbjn().zzax(t).zzaw(t);
        if (z) {
            t.zza(zzf.zzinv, (Object) zzaw ? t : null, (Object) null);
        }
        return zzaw;
    }

    private static <T extends zzekh<T, ?>> T zzb(T t) {
        if (t == null || t.isInitialized()) {
            return t;
        }
        throw new zzeks(new zzeng(t).getMessage()).zzl(t);
    }

    private static <T extends zzekh<T, ?>> T zzb(T t, zzeiu zzeiu, zzeju zzeju) {
        T zza2;
        try {
            zzejj zzbfs = zzeiu.zzbfs();
            zza2 = zza(t, zzbfs, zzeju);
            zzbfs.zzgc(0);
            return zza2;
        } catch (zzeks e) {
            throw e.zzl(zza2);
        } catch (zzeks e2) {
            throw e2;
        }
    }

    protected static zzeko zzbia() {
        return zzeki.zzbig();
    }

    protected static zzekq zzbib() {
        return zzelg.zzbiz();
    }

    protected static <E> zzekp<E> zzbic() {
        return zzemf.zzbjm();
    }

    static <T extends zzekh<?, ?>> T zzf(Class<T> cls) {
        T t = (zzekh) zzinq.get(cls);
        if (t == null) {
            try {
                Class.forName(cls.getName(), true, cls.getClassLoader());
                t = (zzekh) zzinq.get(cls);
            } catch (ClassNotFoundException e) {
                throw new IllegalStateException("Class initialization cannot fail.", e);
            }
        }
        if (t == null) {
            t = (zzekh) ((zzekh) zzenl.zzj(cls)).zza(zzf.zzinz, (Object) null, (Object) null);
            if (t != null) {
                zzinq.put(cls, t);
            } else {
                throw new IllegalStateException();
            }
        }
        return t;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            return zzemg.zzbjn().zzax(this).equals(this, (zzekh) obj);
        }
        return false;
    }

    public int hashCode() {
        if (this.zziij != 0) {
            return this.zziij;
        }
        this.zziij = zzemg.zzbjn().zzax(this).hashCode(this);
        return this.zziij;
    }

    public final boolean isInitialized() {
        return zza(this, Boolean.TRUE.booleanValue());
    }

    public String toString() {
        return zzelt.zza(this, super.toString());
    }

    /* access modifiers changed from: protected */
    public abstract Object zza(int i, Object obj, Object obj2);

    public final void zzb(zzejo zzejo) {
        zzemg.zzbjn().zzax(this).zza(this, zzejr.zza(zzejo));
    }

    /* access modifiers changed from: package-private */
    public final int zzbfh() {
        return this.zzinp;
    }

    public final /* synthetic */ zzels zzbhw() {
        return (zzekh) zza(zzf.zzinz, (Object) null, (Object) null);
    }

    /* access modifiers changed from: protected */
    public final <MessageType extends zzekh<MessageType, BuilderType>, BuilderType extends zza<MessageType, BuilderType>> BuilderType zzbhx() {
        return (zza) zza(zzf.zziny, (Object) null, (Object) null);
    }

    public final BuilderType zzbhy() {
        BuilderType buildertype = (zza) zza(zzf.zziny, (Object) null, (Object) null);
        buildertype.zza(this);
        return buildertype;
    }

    public final int zzbhz() {
        if (this.zzinp == -1) {
            this.zzinp = zzemg.zzbjn().zzax(this).zzau(this);
        }
        return this.zzinp;
    }

    public final /* synthetic */ zzelr zzbid() {
        zza zza2 = (zza) zza(zzf.zziny, (Object) null, (Object) null);
        zza2.zza(this);
        return zza2;
    }

    public final /* synthetic */ zzelr zzbie() {
        return (zza) zza(zzf.zziny, (Object) null, (Object) null);
    }

    /* access modifiers changed from: package-private */
    public final void zzfu(int i) {
        this.zzinp = i;
    }
}
