package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.MuteThisAdReason;

public final class zzyi implements MuteThisAdReason {
    private final String description;
    private zzyd zzcjh;

    public zzyi(zzyd zzyd) {
        String str;
        this.zzcjh = zzyd;
        try {
            str = zzyd.getDescription();
        } catch (RemoteException e) {
            zzaza.zzc("", e);
            str = null;
        }
        this.description = str;
    }

    public final String getDescription() {
        return this.description;
    }

    public final String toString() {
        return this.description;
    }

    public final zzyd zzqp() {
        return this.zzcjh;
    }
}
