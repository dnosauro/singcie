package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class zzapg extends zzgw implements zzaph {
    public zzapg() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.IInterstitialCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 2:
                zzuw();
                break;
            case 3:
                zzdm(parcel.readString());
                break;
            case 4:
                zzf((zzve) zzgv.zza(parcel, zzve.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
