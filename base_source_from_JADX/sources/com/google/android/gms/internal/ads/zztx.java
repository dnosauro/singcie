package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zztx {
    @VisibleForTesting
    zzgy zzbxt;
    @VisibleForTesting
    boolean zzbxu;

    public zztx() {
    }

    public zztx(Context context) {
        zzabf.initialize(context);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcuc)).booleanValue()) {
            try {
                this.zzbxt = (zzgy) zzazd.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zztz.zzbxv);
                ObjectWrapper.wrap(context);
                this.zzbxt.zza(ObjectWrapper.wrap(context), "GMA_SDK");
                this.zzbxu = true;
            } catch (RemoteException | zzazf | NullPointerException unused) {
                zzaza.zzeb("Cannot dynamite load clearcut");
            }
        }
    }

    public zztx(Context context, String str, String str2) {
        zzabf.initialize(context);
        try {
            this.zzbxt = (zzgy) zzazd.zza(context, "com.google.android.gms.ads.clearcut.DynamiteClearcutLogger", zzua.zzbxv);
            ObjectWrapper.wrap(context);
            this.zzbxt.zza(ObjectWrapper.wrap(context), str, (String) null);
            this.zzbxu = true;
        } catch (RemoteException | zzazf | NullPointerException unused) {
            zzaza.zzeb("Cannot dynamite load clearcut");
        }
    }

    public final zzub zzf(byte[] bArr) {
        return new zzub(this, bArr);
    }
}
