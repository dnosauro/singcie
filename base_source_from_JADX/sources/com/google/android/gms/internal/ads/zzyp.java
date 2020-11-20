package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.Parcel;
import java.util.ArrayList;
import java.util.List;

public final class zzyp extends zzgu implements zzyn {
    zzyp(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.client.IResponseInfo");
    }

    public final List<zzvr> getAdapterResponses() {
        Parcel zza = zza(3, zzdo());
        ArrayList<zzvr> createTypedArrayList = zza.createTypedArrayList(zzvr.CREATOR);
        zza.recycle();
        return createTypedArrayList;
    }

    public final String getMediationAdapterClassName() {
        Parcel zza = zza(1, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }

    public final String getResponseId() {
        Parcel zza = zza(2, zzdo());
        String readString = zza.readString();
        zza.recycle();
        return readString;
    }
}
