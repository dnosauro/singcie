package com.google.android.gms.internal.ads;

final class zzelf implements zzemq {
    private static final zzelp zzipf = new zzeli();
    private final zzelp zzipe;

    public zzelf() {
        this(new zzelh(zzekf.zzbhp(), zzbiy()));
    }

    private zzelf(zzelp zzelp) {
        this.zzipe = (zzelp) zzekk.zza(zzelp, "messageInfoFactory");
    }

    private static boolean zza(zzelq zzelq) {
        return zzelq.zzbjg() == zzemd.zziqj;
    }

    private static zzelp zzbiy() {
        try {
            return (zzelp) Class.forName("com.google.protobuf.DescriptorMessageInfoFactory").getDeclaredMethod("getInstance", new Class[0]).invoke((Object) null, new Object[0]);
        } catch (Exception unused) {
            return zzipf;
        }
    }

    public final <T> zzemn<T> zzg(Class<T> cls) {
        zzemp.zzi(cls);
        zzelq zzd = this.zzipe.zzd(cls);
        if (zzd.zzbjh()) {
            return zzekh.class.isAssignableFrom(cls) ? zzely.zza(zzemp.zzbju(), zzejy.zzbhj(), zzd.zzbji()) : zzely.zza(zzemp.zzbjs(), zzejy.zzbhk(), zzd.zzbji());
        }
        if (zzekh.class.isAssignableFrom(cls)) {
            if (zza(zzd)) {
                return zzelw.zza(cls, zzd, zzemc.zzbjk(), zzelc.zzbix(), zzemp.zzbju(), zzejy.zzbhj(), zzeln.zzbje());
            }
            return zzelw.zza(cls, zzd, zzemc.zzbjk(), zzelc.zzbix(), zzemp.zzbju(), (zzejw<?>) null, zzeln.zzbje());
        } else if (zza(zzd)) {
            return zzelw.zza(cls, zzd, zzemc.zzbjj(), zzelc.zzbiw(), zzemp.zzbjs(), zzejy.zzbhk(), zzeln.zzbjd());
        } else {
            return zzelw.zza(cls, zzd, zzemc.zzbjj(), zzelc.zzbiw(), zzemp.zzbjt(), (zzejw<?>) null, zzeln.zzbjd());
        }
    }
}
