package com.google.android.gms.internal.ads;

import android.provider.Settings;
import com.google.android.gms.internal.ads.zzcf;
import java.lang.reflect.InvocationTargetException;

public final class zzfl extends zzgl {
    public zzfl(zzfa zzfa, String str, String str2, zzcf.zza.C3704zza zza, int i, int i2) {
        super(zzfa, str, str2, zza, i, 49);
    }

    /* access modifiers changed from: protected */
    public final void zzcw() {
        this.zzaay.zzb(zzcn.ENUM_FAILURE);
        try {
            this.zzaay.zzb(((Boolean) this.zzabi.invoke((Object) null, new Object[]{this.zzwb.getContext()})).booleanValue() ? zzcn.ENUM_TRUE : zzcn.ENUM_FALSE);
        } catch (InvocationTargetException e) {
            if (!(e.getTargetException() instanceof Settings.SettingNotFoundException)) {
                throw e;
            }
        }
    }
}
