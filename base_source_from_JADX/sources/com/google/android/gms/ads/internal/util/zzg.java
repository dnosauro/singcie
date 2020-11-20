package com.google.android.gms.ads.internal.util;

import android.os.Looper;
import android.os.Message;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.internal.ads.zzduw;

public final class zzg extends zzduw {
    public zzg(Looper looper) {
        super(looper);
    }

    public final void handleMessage(Message message) {
        try {
            super.handleMessage(message);
        } catch (Exception e) {
            zzp.zzku().zza(e, "AdMobHandler.handleMessage");
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb(Message message) {
        try {
            super.zzb(message);
        } catch (Throwable th) {
            zzp.zzkq();
            zzm.zza(zzp.zzku().getApplicationContext(), th);
            throw th;
        }
    }
}
