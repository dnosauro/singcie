package com.google.android.gms.common.server.converter;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;

@KeepForSdk
@SafeParcelable.Class(creator = "StringToIntConverterCreator")
public final class StringToIntConverter extends AbstractSafeParcelable implements FastJsonResponse.FieldConverter<String, Integer> {
    public static final Parcelable.Creator<StringToIntConverter> CREATOR = new zac();
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int zalf;
    private final HashMap<String, Integer> zapm;
    private final SparseArray<String> zapn;
    @SafeParcelable.Field(getter = "getSerializedMap", mo11699id = 2)
    private final ArrayList<zaa> zapo;

    @SafeParcelable.Class(creator = "StringToIntConverterEntryCreator")
    public static final class zaa extends AbstractSafeParcelable {
        public static final Parcelable.Creator<zaa> CREATOR = new zad();
        @SafeParcelable.VersionField(mo11705id = 1)
        private final int versionCode;
        @SafeParcelable.Field(mo11699id = 2)
        final String zapp;
        @SafeParcelable.Field(mo11699id = 3)
        final int zapq;

        @SafeParcelable.Constructor
        zaa(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) int i2) {
            this.versionCode = i;
            this.zapp = str;
            this.zapq = i2;
        }

        zaa(String str, int i) {
            this.versionCode = 1;
            this.zapp = str;
            this.zapq = i;
        }

        public final void writeToParcel(Parcel parcel, int i) {
            int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 1, this.versionCode);
            SafeParcelWriter.writeString(parcel, 2, this.zapp, false);
            SafeParcelWriter.writeInt(parcel, 3, this.zapq);
            SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
        }
    }

    @KeepForSdk
    public StringToIntConverter() {
        this.zalf = 1;
        this.zapm = new HashMap<>();
        this.zapn = new SparseArray<>();
        this.zapo = null;
    }

    @SafeParcelable.Constructor
    StringToIntConverter(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) ArrayList<zaa> arrayList) {
        this.zalf = i;
        this.zapm = new HashMap<>();
        this.zapn = new SparseArray<>();
        this.zapo = null;
        ArrayList arrayList2 = arrayList;
        int size = arrayList2.size();
        int i2 = 0;
        while (i2 < size) {
            Object obj = arrayList2.get(i2);
            i2++;
            zaa zaa2 = (zaa) obj;
            add(zaa2.zapp, zaa2.zapq);
        }
    }

    @KeepForSdk
    public final StringToIntConverter add(String str, int i) {
        this.zapm.put(str, Integer.valueOf(i));
        this.zapn.put(i, str);
        return this;
    }

    public final /* synthetic */ Object convert(Object obj) {
        Integer num = this.zapm.get((String) obj);
        return num == null ? this.zapm.get("gms_unknown") : num;
    }

    public final /* synthetic */ Object convertBack(Object obj) {
        String str = this.zapn.get(((Integer) obj).intValue());
        return (str != null || !this.zapm.containsKey("gms_unknown")) ? str : "gms_unknown";
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zalf);
        ArrayList arrayList = new ArrayList();
        for (String next : this.zapm.keySet()) {
            arrayList.add(new zaa(next, this.zapm.get(next).intValue()));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final int zacj() {
        return 7;
    }

    public final int zack() {
        return 0;
    }
}
