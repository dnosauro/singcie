package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzeik;
import com.google.android.gms.internal.ads.zzein;
import java.io.IOException;

public abstract class zzein<MessageType extends zzeik<MessageType, BuilderType>, BuilderType extends zzein<MessageType, BuilderType>> implements zzelr {
    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzejj zzejj, zzeju zzeju);

    public BuilderType zza(byte[] bArr, int i, int i2, zzeju zzeju) {
        try {
            zzejj zzb = zzejj.zzb(bArr, 0, i2, false);
            zza(zzb, zzeju);
            zzb.zzgc(0);
            return this;
        } catch (zzeks e) {
            throw e;
        } catch (IOException e2) {
            String name = getClass().getName();
            StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf("byte array").length());
            sb.append("Reading ");
            sb.append(name);
            sb.append(" from a ");
            sb.append("byte array");
            sb.append(" threw an IOException (should never happen).");
            throw new RuntimeException(sb.toString(), e2);
        }
    }

    /* renamed from: zzbfj */
    public abstract BuilderType clone();

    public final /* synthetic */ zzelr zzf(zzels zzels) {
        if (zzbhw().getClass().isInstance(zzels)) {
            return zza((zzeik) zzels);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }
}
