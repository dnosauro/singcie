package com.google.android.gms.internal.ads;

import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public abstract class zzxv extends zzgw implements zzxw {
    public zzxv() {
        super("com.google.android.gms.ads.internal.client.IMobileAdsSettingManager");
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                initialize();
                break;
            case 2:
                setAppVolume(parcel.readFloat());
                break;
            case 3:
                zzcd(parcel.readString());
                break;
            case 4:
                setAppMuted(zzgv.zza(parcel));
                break;
            case 5:
                zzb(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()), parcel.readString());
                break;
            case 6:
                zza(parcel.readString(), IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 7:
                float zzqk = zzqk();
                parcel2.writeNoException();
                parcel2.writeFloat(zzqk);
                return true;
            case 8:
                boolean zzql = zzql();
                parcel2.writeNoException();
                zzgv.writeBoolean(parcel2, zzql);
                return true;
            case 9:
                String versionString = getVersionString();
                parcel2.writeNoException();
                parcel2.writeString(versionString);
                return true;
            case 10:
                zzce(parcel.readString());
                break;
            case 11:
                zza(zzanl.zzac(parcel.readStrongBinder()));
                break;
            case 12:
                zza(zzajf.zzaa(parcel.readStrongBinder()));
                break;
            case 13:
                List<zzaiz> zzqm = zzqm();
                parcel2.writeNoException();
                parcel2.writeTypedList(zzqm);
                return true;
            case 14:
                zza((zzaae) zzgv.zza(parcel, zzaae.CREATOR));
                break;
            case 15:
                zzqn();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
