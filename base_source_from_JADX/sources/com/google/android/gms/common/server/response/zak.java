package com.google.android.gms.common.server.response;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.internal.ShowFirstParty;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import com.google.android.gms.common.server.response.FastJsonResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@ShowFirstParty
@SafeParcelable.Class(creator = "FieldMappingDictionaryCreator")
public final class zak extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zak> CREATOR = new zan();
    @SafeParcelable.VersionField(mo11705id = 1)
    private final int zalf;
    private final HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> zaqv;
    @SafeParcelable.Field(getter = "getSerializedDictionary", mo11699id = 2)
    private final ArrayList<zal> zaqw;
    @SafeParcelable.Field(getter = "getRootClassName", mo11699id = 3)
    private final String zaqx;

    @SafeParcelable.Constructor
    zak(@SafeParcelable.Param(mo11702id = 1) int i, @SafeParcelable.Param(mo11702id = 2) ArrayList<zal> arrayList, @SafeParcelable.Param(mo11702id = 3) String str) {
        this.zalf = i;
        this.zaqw = null;
        HashMap<String, Map<String, FastJsonResponse.Field<?, ?>>> hashMap = new HashMap<>();
        int size = arrayList.size();
        for (int i2 = 0; i2 < size; i2++) {
            zal zal = arrayList.get(i2);
            String str2 = zal.className;
            HashMap hashMap2 = new HashMap();
            int size2 = zal.zaqy.size();
            for (int i3 = 0; i3 < size2; i3++) {
                zam zam = zal.zaqy.get(i3);
                hashMap2.put(zam.zaqz, zam.zara);
            }
            hashMap.put(str2, hashMap2);
        }
        this.zaqv = hashMap;
        this.zaqx = (String) Preconditions.checkNotNull(str);
        zacr();
    }

    public zak(Class<? extends FastJsonResponse> cls) {
        this.zalf = 1;
        this.zaqw = null;
        this.zaqv = new HashMap<>();
        this.zaqx = cls.getCanonicalName();
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        for (String next : this.zaqv.keySet()) {
            sb.append(next);
            sb.append(":\n");
            Map map = this.zaqv.get(next);
            for (String str : map.keySet()) {
                sb.append("  ");
                sb.append(str);
                sb.append(": ");
                sb.append(map.get(str));
            }
        }
        return sb.toString();
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 1, this.zalf);
        ArrayList arrayList = new ArrayList();
        for (String next : this.zaqv.keySet()) {
            arrayList.add(new zal(next, this.zaqv.get(next)));
        }
        SafeParcelWriter.writeTypedList(parcel, 2, arrayList, false);
        SafeParcelWriter.writeString(parcel, 3, this.zaqx, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }

    public final void zaa(Class<? extends FastJsonResponse> cls, Map<String, FastJsonResponse.Field<?, ?>> map) {
        this.zaqv.put(cls.getCanonicalName(), map);
    }

    public final boolean zaa(Class<? extends FastJsonResponse> cls) {
        return this.zaqv.containsKey(cls.getCanonicalName());
    }

    public final void zacr() {
        for (String str : this.zaqv.keySet()) {
            Map map = this.zaqv.get(str);
            for (String str2 : map.keySet()) {
                ((FastJsonResponse.Field) map.get(str2)).zaa(this);
            }
        }
    }

    public final void zacs() {
        for (String next : this.zaqv.keySet()) {
            Map map = this.zaqv.get(next);
            HashMap hashMap = new HashMap();
            for (String str : map.keySet()) {
                hashMap.put(str, ((FastJsonResponse.Field) map.get(str)).zacl());
            }
            this.zaqv.put(next, hashMap);
        }
    }

    public final String zact() {
        return this.zaqx;
    }

    public final Map<String, FastJsonResponse.Field<?, ?>> zai(String str) {
        return this.zaqv.get(str);
    }
}
