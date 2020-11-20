package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;

public class zzgu implements IInterface {
    private final IBinder zzacg;
    private final String zzach;

    protected zzgu(IBinder iBinder, String str) {
        this.zzacg = iBinder;
        this.zzach = str;
    }

    public IBinder asBinder() {
        return this.zzacg;
    }

    /* access modifiers changed from: protected */
    public final Parcel zza(int i, Parcel parcel) {
        parcel = Parcel.obtain();
        try {
            this.zzacg.transact(i, parcel, parcel, 0);
            parcel.readException();
            return parcel;
        } catch (RuntimeException e) {
            throw e;
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzb(int i, Parcel parcel) {
        Parcel obtain = Parcel.obtain();
        try {
            this.zzacg.transact(i, parcel, obtain, 0);
            obtain.readException();
        } finally {
            parcel.recycle();
            obtain.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final void zzc(int i, Parcel parcel) {
        try {
            this.zzacg.transact(2, parcel, (Parcel) null, 1);
        } finally {
            parcel.recycle();
        }
    }

    /* access modifiers changed from: protected */
    public final Parcel zzdo() {
        Parcel obtain = Parcel.obtain();
        obtain.writeInterfaceToken(this.zzach);
        return obtain;
    }
}
