package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.common.internal.BaseGmsClient;

final class zztn implements BaseGmsClient.BaseConnectionCallbacks {
    final /* synthetic */ zztl zzbvh;
    private final /* synthetic */ zztf zzbvn;
    private final /* synthetic */ zzazq zzbvo;

    zztn(zztl zztl, zztf zztf, zzazq zzazq) {
        this.zzbvh = zztl;
        this.zzbvn = zztf;
        this.zzbvo = zzazq;
    }

    public final void onConnected(Bundle bundle) {
        synchronized (this.zzbvh.lock) {
            if (!this.zzbvh.zzbvi) {
                boolean unused = this.zzbvh.zzbvi = true;
                zztc zzd = this.zzbvh.zzbur;
                if (zzd != null) {
                    this.zzbvo.addListener(new zztp(this.zzbvo, zzazj.zzegp.zzg(new zztm(this, zzd, this.zzbvn, this.zzbvo))), zzazj.zzegu);
                }
            }
        }
    }

    public final void onConnectionSuspended(int i) {
    }
}
