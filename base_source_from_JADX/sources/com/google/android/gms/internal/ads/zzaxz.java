package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;

public final class zzaxz implements Parcelable.Creator<zzaxw> {
    public final /* synthetic */ Object createFromParcel(Parcel parcel) {
        int validateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String str = null;
        String str2 = null;
        zzvn zzvn = null;
        zzvk zzvk = null;
        while (parcel.dataPosition() < validateObjectHeader) {
            int readHeader = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(readHeader)) {
                case 1:
                    str = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 2:
                    str2 = SafeParcelReader.createString(parcel, readHeader);
                    break;
                case 3:
                    zzvn = (zzvn) SafeParcelReader.createParcelable(parcel, readHeader, zzvn.CREATOR);
                    break;
                case 4:
                    zzvk = (zzvk) SafeParcelReader.createParcelable(parcel, readHeader, zzvk.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, readHeader);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, validateObjectHeader);
        return new zzaxw(str, str2, zzvn, zzvk);
    }

    public final /* synthetic */ Object[] newArray(int i) {
        return new zzaxw[i];
    }
}
