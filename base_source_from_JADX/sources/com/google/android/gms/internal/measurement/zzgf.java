package com.google.android.gms.internal.measurement;

import com.google.android.gms.internal.measurement.zzgd;
import com.google.android.gms.internal.measurement.zzgf;
import java.io.IOException;

public abstract class zzgf<MessageType extends zzgd<MessageType, BuilderType>, BuilderType extends zzgf<MessageType, BuilderType>> implements zzjf {
    private final String zza(String str) {
        String name = getClass().getName();
        StringBuilder sb = new StringBuilder(String.valueOf(name).length() + 60 + String.valueOf(str).length());
        sb.append("Reading ");
        sb.append(name);
        sb.append(" from a ");
        sb.append(str);
        sb.append(" threw an IOException (should never happen).");
        return sb.toString();
    }

    /* access modifiers changed from: protected */
    public abstract BuilderType zza(MessageType messagetype);

    public abstract BuilderType zza(zzgy zzgy, zzhi zzhi);

    public BuilderType zza(byte[] bArr, int i, int i2) {
        try {
            zzgy zza = zzgy.zza(bArr, 0, i2, false);
            zza(zza, zzhi.zza());
            zza.zza(0);
            return this;
        } catch (zzig e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public BuilderType zza(byte[] bArr, int i, int i2, zzhi zzhi) {
        try {
            zzgy zza = zzgy.zza(bArr, 0, i2, false);
            zza(zza, zzhi);
            zza.zza(0);
            return this;
        } catch (zzig e) {
            throw e;
        } catch (IOException e2) {
            throw new RuntimeException(zza("byte array"), e2);
        }
    }

    public final /* synthetic */ zzjf zza(zzjg zzjg) {
        if (zzbv().getClass().isInstance(zzjg)) {
            return zza((zzgd) zzjg);
        }
        throw new IllegalArgumentException("mergeFrom(MessageLite) can only merge messages of the same type.");
    }

    public final /* synthetic */ zzjf zza(byte[] bArr) {
        return zza(bArr, 0, bArr.length);
    }

    public final /* synthetic */ zzjf zza(byte[] bArr, zzhi zzhi) {
        return zza(bArr, 0, bArr.length, zzhi);
    }

    /* renamed from: zzt */
    public abstract BuilderType clone();
}
