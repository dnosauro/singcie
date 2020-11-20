package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.dynamic.IObjectWrapper;

public abstract class zzari extends zzgw implements zzarj {
    public zzari() {
        super("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public static zzarj zzai(IBinder iBinder) {
        if (iBinder == null) {
            return null;
        }
        IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
        return queryLocalInterface instanceof zzarj ? (zzarj) queryLocalInterface : new zzarl(iBinder);
    }

    /* access modifiers changed from: protected */
    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 1:
                onCreate((Bundle) zzgv.zza(parcel, Bundle.CREATOR));
                break;
            case 2:
                onRestart();
                break;
            case 3:
                onStart();
                break;
            case 4:
                onResume();
                break;
            case 5:
                onPause();
                break;
            case 6:
                Bundle bundle = (Bundle) zzgv.zza(parcel, Bundle.CREATOR);
                onSaveInstanceState(bundle);
                parcel2.writeNoException();
                zzgv.zzb(parcel2, bundle);
                return true;
            case 7:
                onStop();
                break;
            case 8:
                onDestroy();
                break;
            case 9:
                zzdp();
                break;
            case 10:
                onBackPressed();
                break;
            case 11:
                boolean zzve = zzve();
                parcel2.writeNoException();
                zzgv.writeBoolean(parcel2, zzve);
                return true;
            case 12:
                onActivityResult(parcel.readInt(), parcel.readInt(), (Intent) zzgv.zza(parcel, Intent.CREATOR));
                break;
            case 13:
                zzad(IObjectWrapper.Stub.asInterface(parcel.readStrongBinder()));
                break;
            case 14:
                onUserLeaveHint();
                break;
            default:
                return false;
        }
        parcel2.writeNoException();
        return true;
    }
}
