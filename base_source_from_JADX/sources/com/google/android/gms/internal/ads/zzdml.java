package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.reward.AdMetadataListener;

final class zzdml extends AdMetadataListener {
    private final /* synthetic */ zzdmi zzhgj;
    private final /* synthetic */ zzyh zzhgk;

    zzdml(zzdmi zzdmi, zzyh zzyh) {
        this.zzhgj = zzdmi;
        this.zzhgk = zzyh;
    }

    public final void onAdMetadataChanged() {
        if (this.zzhgj.zzhgi != null) {
            try {
                this.zzhgk.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzd.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
