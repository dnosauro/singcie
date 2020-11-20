package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;
import java.util.List;

public final class zzmd implements Parcelable {
    public static final Parcelable.Creator<zzmd> CREATOR = new zzmf();
    private final zza[] zzbdc;

    public interface zza extends Parcelable {
    }

    zzmd(Parcel parcel) {
        this.zzbdc = new zza[parcel.readInt()];
        int i = 0;
        while (true) {
            zza[] zzaArr = this.zzbdc;
            if (i < zzaArr.length) {
                zzaArr[i] = (zza) parcel.readParcelable(zza.class.getClassLoader());
                i++;
            } else {
                return;
            }
        }
    }

    public zzmd(List<? extends zza> list) {
        this.zzbdc = new zza[list.size()];
        list.toArray(this.zzbdc);
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return Arrays.equals(this.zzbdc, ((zzmd) obj).zzbdc);
    }

    public final int hashCode() {
        return Arrays.hashCode(this.zzbdc);
    }

    public final int length() {
        return this.zzbdc.length;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzbdc.length);
        for (zza writeParcelable : this.zzbdc) {
            parcel.writeParcelable(writeParcelable, 0);
        }
    }

    public final zza zzay(int i) {
        return this.zzbdc[i];
    }
}
