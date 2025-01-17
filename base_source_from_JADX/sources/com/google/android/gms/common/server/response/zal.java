package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.Map;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryEntryCreator")
public final class zal extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zal> CREATOR = new zao();
    @SafeParcelable.Field(mo11699id = 2)
    final String className;
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int versionCode;
    @SafeParcelable.Field(mo11699id = 3)
    final ArrayList<zam> zaqy;

    @SafeParcelable.Constructor
    zal(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) ArrayList<zam> arrayList) {
        this.versionCode = i;
        this.className = str;
        this.zaqy = arrayList;
    }

    zal(String str, Map<String, FastJsonResponse.Field<?, ?>> map) {
        ArrayList<zam> arrayList;
        this.versionCode = 1;
        this.className = str;
        if (map == null) {
            arrayList = null;
        } else {
            arrayList = new ArrayList<>();
            for (String next : map.keySet()) {
                arrayList.add(new zam(next, map.get(next)));
            }
        }
        this.zaqy = arrayList;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
        SafeParcelWriter.writeString(parcel, 2, this.className, false);
        SafeParcelWriter.writeTypedList(parcel, 3, this.zaqy, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
