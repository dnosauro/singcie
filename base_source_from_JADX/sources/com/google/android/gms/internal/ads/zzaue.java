package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class zzaue extends zzgw implements zzauf {
    public zzaue() {
        super("com.google.android.gms.ads.internal.reward.client.IRewardItem");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                String type = getType();
                parcel2.writeNoException();
                parcel2.writeString(type);
                return true;
            case 2:
                int amount = getAmount();
                parcel2.writeNoException();
                parcel2.writeInt(amount);
                return true;
            default:
                return false;
        }
    }
}
