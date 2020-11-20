package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzels;
import java.security.GeneralSecurityException;

public class zzeac<PrimitiveT, KeyProtoT extends zzels> implements zzdzz<PrimitiveT> {
    private final zzeae<KeyProtoT> zzhyi;
    private final Class<PrimitiveT> zzhyj;

    public zzeac(zzeae<KeyProtoT> zzeae, Class<PrimitiveT> cls) {
        if (zzeae.zzazw().contains(cls) || Void.class.equals(cls)) {
            this.zzhyi = zzeae;
            this.zzhyj = cls;
            return;
        }
        throw new IllegalArgumentException(String.format("Given internalKeyMananger %s does not support primitive class %s", new Object[]{zzeae.toString(), cls.getName()}));
    }

    private final zzeab<?, KeyProtoT> zzazs() {
        return new zzeab<>(this.zzhyi.zzazy());
    }

    private final PrimitiveT zzb(KeyProtoT keyprotot) {
        if (!Void.class.equals(this.zzhyj)) {
            this.zzhyi.zze(keyprotot);
            return this.zzhyi.zza(keyprotot, this.zzhyj);
        }
        throw new GeneralSecurityException("Cannot create a primitive for Void");
    }

    public final String getKeyType() {
        return this.zzhyi.getKeyType();
    }

    public final PrimitiveT zza(zzels zzels) {
        String valueOf = String.valueOf(this.zzhyi.zzazu().getName());
        String concat = valueOf.length() != 0 ? "Expected proto of type ".concat(valueOf) : new String("Expected proto of type ");
        if (this.zzhyi.zzazu().isInstance(zzels)) {
            return zzb(zzels);
        }
        throw new GeneralSecurityException(concat);
    }

    public final Class<PrimitiveT> zzazr() {
        return this.zzhyj;
    }

    public final PrimitiveT zzm(zzeiu zzeiu) {
        try {
            return zzb(this.zzhyi.zzr(zzeiu));
        } catch (zzeks e) {
            String valueOf = String.valueOf(this.zzhyi.zzazu().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final zzels zzn(zzeiu zzeiu) {
        try {
            return zzazs().zzp(zzeiu);
        } catch (zzeks e) {
            String valueOf = String.valueOf(this.zzhyi.zzazy().zzazt().getName());
            throw new GeneralSecurityException(valueOf.length() != 0 ? "Failures parsing proto of type ".concat(valueOf) : new String("Failures parsing proto of type "), e);
        }
    }

    public final zzefh zzo(zzeiu zzeiu) {
        try {
            return (zzefh) ((zzekh) zzefh.zzbdi().zzho(this.zzhyi.getKeyType()).zzag(zzazs().zzp(zzeiu).zzbfg()).zzb(this.zzhyi.zzazv()).zzbhv());
        } catch (zzeks e) {
            throw new GeneralSecurityException("Unexpected proto", e);
        }
    }
}
