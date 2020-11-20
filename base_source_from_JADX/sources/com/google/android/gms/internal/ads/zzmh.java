package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class zzmh extends zzmk {
    public static final Parcelable.Creator<zzmh> CREATOR = new zzmg();
    private final String description;
    private final String mimeType;
    private final int zzbdf;
    private final byte[] zzbdg;

    zzmh(Parcel parcel) {
        super("APIC");
        this.mimeType = parcel.readString();
        this.description = parcel.readString();
        this.zzbdf = parcel.readInt();
        this.zzbdg = parcel.createByteArray();
    }

    public zzmh(String str, String str2, int i, byte[] bArr) {
        super("APIC");
        this.mimeType = str;
        this.description = null;
        this.zzbdf = 3;
        this.zzbdg = bArr;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            zzmh zzmh = (zzmh) obj;
            return this.zzbdf == zzmh.zzbdf && zzpt.zza(this.mimeType, zzmh.mimeType) && zzpt.zza(this.description, zzmh.description) && Arrays.equals(this.zzbdg, zzmh.zzbdg);
        }
    }

    public final int hashCode() {
        int i = (this.zzbdf + 527) * 31;
        String str = this.mimeType;
        int i2 = 0;
        int hashCode = (i + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.description;
        if (str2 != null) {
            i2 = str2.hashCode();
        }
        return ((hashCode + i2) * 31) + Arrays.hashCode(this.zzbdg);
    }

    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mimeType);
        parcel.writeString(this.description);
        parcel.writeInt(this.zzbdf);
        parcel.writeByteArray(this.zzbdg);
    }
}
