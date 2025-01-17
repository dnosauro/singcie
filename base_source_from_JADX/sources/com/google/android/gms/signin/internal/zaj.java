package com.google.android.gms.signin.internal;

import android.app.PendingIntent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.ResolveAccountResponse;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "SignInResponseCreator")
public final class zaj extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zaj> CREATOR = new zak();
    @SafeParcelable.Field(getter = "getConnectionResult", mo11699id = 2)
    private final ConnectionResult zadi;
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int zalf;
    @SafeParcelable.Field(getter = "getResolveAccountResponse", mo11699id = 3)
    private final ResolveAccountResponse zase;

    public zaj(int i) {
        this(new ConnectionResult(8, (PendingIntent) null), (ResolveAccountResponse) null);
    }

    @SafeParcelable.Constructor
    zaj(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) ConnectionResult connectionResult, @SafeParcelable.Param(mo11702id = 3) ResolveAccountResponse resolveAccountResponse) {
        this.zalf = i;
        this.zadi = connectionResult;
        this.zase = resolveAccountResponse;
    }

    private zaj(ConnectionResult connectionResult, ResolveAccountResponse resolveAccountResponse) {
        this(1, connectionResult, (ResolveAccountResponse) null);
    }

    public final ConnectionResult getConnectionResult() {
        return this.zadi;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zalf);
        SafeParcelWriter.writeParcelable(parcel, 2, this.zadi, i, false);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zase, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final ResolveAccountResponse zacx() {
        return this.zase;
    }
}
