package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzpu implements Parcelable {
    public static final Parcelable.Creator<zzpu> CREATOR = new zzpx();
    private int zzaht;
    public final int zzaru;
    public final int zzarv;
    public final int zzarw;
    public final byte[] zzbkq;

    public zzpu(int i, int i2, int i3, byte[] bArr) {
        this.zzaru = i;
        this.zzarw = i2;
        this.zzarv = i3;
        this.zzbkq = bArr;
    }

    zzpu(Parcel parcel) {
        this.zzaru = parcel.readInt();
        this.zzarw = parcel.readInt();
        this.zzarv = parcel.readInt();
        this.zzbkq = parcel.readInt() != 0 ? parcel.createByteArray() : null;
    }

    public final int describeContents() {
        return 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzpu zzpu = (zzpu) obj;
            return this.zzaru == zzpu.zzaru && this.zzarw == zzpu.zzarw && this.zzarv == zzpu.zzarv && Arrays.equals(this.zzbkq, zzpu.zzbkq);
        }
    }

    public final int hashCode() {
        if (this.zzaht == 0) {
            this.zzaht = ((((((this.zzaru + 527) * 31) + this.zzarw) * 31) + this.zzarv) * 31) + Arrays.hashCode(this.zzbkq);
        }
        return this.zzaht;
    }

    public final String toString() {
        int i = this.zzaru;
        int i2 = this.zzarw;
        int i3 = this.zzarv;
        boolean z = this.zzbkq != null;
        StringBuilder sb = new StringBuilder(55);
        sb.append("ColorInfo(");
        sb.append(i);
        sb.append(", ");
        sb.append(i2);
        sb.append(", ");
        sb.append(i3);
        sb.append(", ");
        sb.append(z);
        sb.append(")");
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.zzaru);
        parcel.writeInt(this.zzarw);
        parcel.writeInt(this.zzarv);
        parcel.writeInt(this.zzbkq != null ? 1 : 0);
        byte[] bArr = this.zzbkq;
        if (bArr != null) {
            parcel.writeByteArray(bArr);
        }
    }
}
