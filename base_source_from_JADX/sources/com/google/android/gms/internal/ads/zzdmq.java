package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.reward.AdMetadataListener;

final class zzdmq extends AdMetadataListener {
    private final /* synthetic */ zzxj zzhgl;
    private final /* synthetic */ zzdmo zzhgm;

    zzdmq(zzdmo zzdmo, zzxj zzxj) {
        this.zzhgm = zzdmo;
        this.zzhgl = zzxj;
    }

    public final void onAdMetadataChanged() {
        if (this.zzhgm.zzhgi != null) {
            try {
                this.zzhgl.onAdMetadataChanged();
            } catch (RemoteException e) {
                zzd.zze("#007 Could not call remote method.", e);
            }
        }
    }
}
