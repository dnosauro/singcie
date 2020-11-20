package com.google.android.gms.internal.ads;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.ResponseInfo;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;

@SafeParcelable.Class(creator = "AdErrorParcelCreator")
public final class zzve extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzve> CREATOR = new zzvd();
    @SafeParcelable.Field(mo11699id = 1)
    public final int errorCode;
    @SafeParcelable.Field(mo11699id = 2)
    public final String zzcgs;
    @SafeParcelable.Field(mo11699id = 3)
    public final String zzcgt;
    @SafeParcelable.Field(mo11699id = 4)
    public zzve zzcgu;
    @SafeParcelable.Field(mo11699id = 5, type = "android.os.IBinder")
    public IBinder zzcgv;

    @SafeParcelable.Constructor
    public zzve(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) String str2, @SafeParcelable.Param(mo11702id = 4) zzve zzve, @SafeParcelable.Param(mo11702id = 5) IBinder iBinder) {
        this.errorCode = i;
        this.zzcgs = str;
        this.zzcgt = str2;
        this.zzcgu = zzve;
        this.zzcgv = iBinder;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.errorCode);
        SafeParcelWriter.writeString(parcel, 2, this.zzcgs, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzcgt, false);
        SafeParcelWriter.writeParcelable(parcel, 4, this.zzcgu, i, false);
        SafeParcelWriter.writeIBinder(parcel, 5, this.zzcgv, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final AdError zzpl() {
        zzve zzve = this.zzcgu;
        return new AdError(this.errorCode, this.zzcgs, this.zzcgt, zzve == null ? null : new AdError(zzve.errorCode, zzve.zzcgs, zzve.zzcgt));
    }

    public final LoadAdError zzpm() {
        zzve zzve = this.zzcgu;
        zzyn zzyn = null;
        AdError adError = zzve == null ? null : new AdError(zzve.errorCode, zzve.zzcgs, zzve.zzcgt);
        int i = this.errorCode;
        String str = this.zzcgs;
        String str2 = this.zzcgt;
        IBinder iBinder = this.zzcgv;
        if (iBinder != null) {
            IInterface queryLocalInterface = iBinder.queryLocalInterface("com.google.android.gms.ads.internal.client.IResponseInfo");
            zzyn = queryLocalInterface instanceof zzyn ? (zzyn) queryLocalInterface : new zzyp(iBinder);
        }
        return new LoadAdError(i, str, str2, adError, ResponseInfo.zza(zzyn));
    }
}
