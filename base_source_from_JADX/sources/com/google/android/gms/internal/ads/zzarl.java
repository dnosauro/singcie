package com.google.android.gms.internal.ads;

import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.dynamic.IObjectWrapper;

public final class zzarl extends zzgu implements zzarj {
    zzarl(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.ads.internal.overlay.client.IAdOverlay");
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
        Parcel zzdo = zzdo();
        zzdo.writeInt(i);
        zzdo.writeInt(i2);
        zzgv.zza(zzdo, (Parcelable) intent);
        zzb(12, zzdo);
    }

    public final void onBackPressed() {
        zzb(10, zzdo());
    }

    public final void onCreate(Bundle bundle) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) bundle);
        zzb(1, zzdo);
    }

    public final void onDestroy() {
        zzb(8, zzdo());
    }

    public final void onPause() {
        zzb(5, zzdo());
    }

    public final void onRestart() {
        zzb(2, zzdo());
    }

    public final void onResume() {
        zzb(4, zzdo());
    }

    public final void onSaveInstanceState(Bundle bundle) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (Parcelable) bundle);
        Parcel zza = zza(6, zzdo);
        if (zza.readInt() != 0) {
            bundle.readFromParcel(zza);
        }
        zza.recycle();
    }

    public final void onStart() {
        zzb(3, zzdo());
    }

    public final void onStop() {
        zzb(7, zzdo());
    }

    public final void onUserLeaveHint() {
        zzb(14, zzdo());
    }

    public final void zzad(IObjectWrapper iObjectWrapper) {
        Parcel zzdo = zzdo();
        zzgv.zza(zzdo, (IInterface) iObjectWrapper);
        zzb(13, zzdo);
    }

    public final void zzdp() {
        zzb(9, zzdo());
    }

    public final boolean zzve() {
        Parcel zza = zza(11, zzdo());
        boolean zza2 = zzgv.zza(zza);
        zza.recycle();
        return zza2;
    }
}
