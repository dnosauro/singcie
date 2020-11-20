package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.ads.reward.RewardItem;

public final class zzauq implements RewardItem {
    private final zzauf zzdxv;

    public zzauq(zzauf zzauf) {
        this.zzdxv = zzauf;
    }

    public final int getAmount() {
        zzauf zzauf = this.zzdxv;
        if (zzauf == null) {
            return 0;
        }
        try {
            return zzauf.getAmount();
        } catch (RemoteException e) {
            zzaza.zzd("Could not forward getAmount to RewardItem", e);
            return 0;
        }
    }

    public final String getType() {
        zzauf zzauf = this.zzdxv;
        if (zzauf == null) {
            return null;
        }
        try {
            return zzauf.getType();
        } catch (RemoteException e) {
            zzaza.zzd("Could not forward getType to RewardItem", e);
            return null;
        }
    }
}
