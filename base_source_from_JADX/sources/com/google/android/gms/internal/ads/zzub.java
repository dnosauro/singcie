package com.google.android.gms.internal.ads;

import android.os.RemoteException;

public final class zzub {
    private final byte[] zzbxw;
    private int zzbxx;
    private int zzbxy;
    private final /* synthetic */ zztx zzbxz;

    private zzub(zztx zztx, byte[] bArr) {
        this.zzbxz = zztx;
        this.zzbxw = bArr;
    }

    public final synchronized void log() {
        try {
            if (this.zzbxz.zzbxu) {
                this.zzbxz.zzbxt.zzc(this.zzbxw);
                this.zzbxz.zzbxt.zzs(this.zzbxx);
                this.zzbxz.zzbxt.zzt(this.zzbxy);
                this.zzbxz.zzbxt.zza((int[]) null);
                this.zzbxz.zzbxt.log();
            }
        } catch (RemoteException e) {
            zzaza.zzb("Clearcut log failed", e);
        }
    }

    public final zzub zzbu(int i) {
        this.zzbxx = i;
        return this;
    }

    public final zzub zzbv(int i) {
        this.zzbxy = i;
        return this;
    }
}
