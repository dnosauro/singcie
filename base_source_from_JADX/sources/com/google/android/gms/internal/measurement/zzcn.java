package com.google.android.gms.internal.measurement;

import android.database.ContentObserver;
import android.os.Handler;

final class zzcn extends ContentObserver {
    zzcn(Handler handler) {
        super((Handler) null);
    }

    public final void onChange(boolean z) {
        zzck.zze.set(true);
    }
}
