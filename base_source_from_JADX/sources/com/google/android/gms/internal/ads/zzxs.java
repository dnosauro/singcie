package com.google.android.gms.internal.ads;

import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzxs extends zzgw implements zzxp {
    public zzxs() {
        super("com.google.android.gms.ads.internal.client.IClientApi");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        IInterface iInterface;
        switch (i) {
            case 1:
                iInterface = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgv.zza(parcel, zzvn.CREATOR), parcel.readString(), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 2:
                iInterface = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgv.zza(parcel, zzvn.CREATOR), parcel.readString(), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 3:
                iInterface = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 4:
                iInterface = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 5:
                iInterface = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 6:
                iInterface = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 7:
                iInterface = zzd(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 8:
                iInterface = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 9:
                iInterface = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 10:
                iInterface = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgv.zza(parcel, zzvn.CREATOR), parcel.readString(), parcel.readInt());
                break;
            case 11:
                iInterface = zza(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 12:
                iInterface = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString(), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 13:
                iInterface = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), (zzvn) zzgv.zza(parcel, zzvn.CREATOR), parcel.readString(), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 14:
                iInterface = zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                break;
            case 15:
                iInterface = zzc(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), zzanl.zzac(parcel.readStrongBinder()), parcel.readInt());
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        zzgv.zza(parcel2, iInterface);
        return true;
    }
}
