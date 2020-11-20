package com.google.android.gms.internal.ads;

import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

public final class zzgc extends zzgl {
    public zzgc(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 73);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        try {
            this.zzaay.zzd(((Boolean) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext()})).booleanValue() ? zzcn.ENUM_TRUE : zzcn.ENUM_FALSE);
        } catch (InvocationTargetException unused) {
            this.zzaay.zzd(zzcn.ENUM_FAILURE);
        }
    }
}
