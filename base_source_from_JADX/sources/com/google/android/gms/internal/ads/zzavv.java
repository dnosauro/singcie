package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.rewarded.RewardItem;

public final class zzavv implements RewardItem {
    private final zzavc zzdyd;

    public zzavv(zzavc zzavc) {
        this.zzdyd = zzavc;
    }

    public final int getAmount() {
        zzavc zzavc = this.zzdyd;
        if (zzavc == null) {
            return 0;
        }
        try {
            return zzavc.getAmount();
        } catch (RemoteException e) {
            zzaza.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public final String getType() {
        zzavc zzavc = this.zzdyd;
        if (zzavc == null) {
            return null;
        }
        try {
            return zzavc.getType();
        } catch (RemoteException e) {
            zzaza.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
