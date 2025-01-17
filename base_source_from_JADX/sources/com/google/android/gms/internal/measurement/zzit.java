package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzhv;

final class zzit implements zzjy {
    private static final zzjd zzb = new zziw();
    private final zzjd zza;

    public zzit() {
        this(new zziv(zzhw.zza(), zza()));
    }

    private zzit(zzjd zzjd) {
        this.zza = (zzjd) zzhx.zza(zzjd, "messageInfoFactory");
    }

    private static zzjd zza() {
        try {
            return (zzjd) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzb;
        }
    }

    private static boolean zza(zzje zzje) {
        return zzje.zza() == zzhv.zze.zzh;
    }

    public final <T> zzjv<T> zza(Class<T> cls) {
        zzjx.zza((Class<?>) cls);
        zzje zzb2 = this.zza.zzb(cls);
        if (zzb2.zzb()) {
            return zzhv.class.isAssignableFrom(cls) ? zzjm.zza(zzjx.zzc(), zzhl.zza(), zzb2.zzc()) : zzjm.zza(zzjx.zza(), zzhl.zzb(), zzb2.zzc());
        }
        if (zzhv.class.isAssignableFrom(cls)) {
            if (zza(zzb2)) {
                return zzjk.zza(cls, zzb2, zzjq.zzb(), zziq.zzb(), zzjx.zzc(), zzhl.zza(), zzjb.zzb());
            }
            return zzjk.zza(cls, zzb2, zzjq.zzb(), zziq.zzb(), zzjx.zzc(), (zzhk<?>) null, zzjb.zzb());
        } else if (zza(zzb2)) {
            return zzjk.zza(cls, zzb2, zzjq.zza(), zziq.zza(), zzjx.zza(), zzhl.zzb(), zzjb.zza());
        } else {
            return zzjk.zza(cls, zzb2, zzjq.zza(), zziq.zza(), zzjx.zzb(), (zzhk<?>) null, zzjb.zza());
        }
    }
}
