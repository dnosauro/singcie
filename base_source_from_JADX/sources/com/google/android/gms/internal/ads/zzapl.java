package com.google.android.gms.internal.ads;

import android.os.Parcel;

public abstract class zzapl extends zzgw implements zzapi {
    public zzapl() {
        super("com.google.android.gms.ads.internal.mediation.client.rtb.INativeCallback");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                zza(zzaoa.zzae(parcel.readStrongBinder()));
                break;
            case 2:
                zzdm(parcel.readString());
                break;
            case 3:
                zzf((zzve) zzgv.zza(parcel, zzve.CREATOR));
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}