package com.google.android.gms.signin.internal;

import android.content.Intent;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.api.Result;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AuthAccountResultCreator")
public final class zaa extends AbstractSafeParcelable implements Result {
    public static final Parcelable.Creator<zaa> CREATOR = new zab();
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int zalf;
    @SafeParcelable.Field(getter = "getConnectionResultCode", mo11699id = 2)
    private int zarz;
    @SafeParcelable.Field(getter = "getRawAuthResolutionIntent", mo11699id = 3)
    private Intent zasa;

    public zaa() {
        this(0, (Intent) null);
    }

    @SafeParcelable.Constructor
    zaa(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) int i2, @SafeParcelable.Param(mo11702id = 3) Intent intent) {
        this.zalf = i;
        this.zarz = i2;
        this.zasa = intent;
    }

    private zaa(int i, Intent intent) {
        this(2, 0, (Intent) null);
    }

    public final Status getStatus() {
        return this.zarz == 0 ? Status.RESULT_SUCCESS : Status.RESULT_CANCELED;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zalf);
        SafeParcelWriter.writeInt(parcel, 2, this.zarz);
        SafeParcelWriter.writeParcelable(parcel, 3, this.zasa, i, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
