package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

@SafeParcelable.Class(creator = "AutoClickProtectionConfigurationParcelCreator")
@SafeParcelable.Reserved({1})
@ParametersAreNonnullByDefault
public final class zzasw extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzasw> CREATOR = new zzasz();
    @SafeParcelable.Field(mo11699id = 2)
    public final boolean zzdvq;
    @SafeParcelable.Field(mo11699id = 3)
    public final List<String> zzdvr;

    public zzasw() {
        this(false, Collections.emptyList());
    }

    @SafeParcelable.Constructor
    public zzasw(@SafeParcelable.Param(mo11702id = 2) boolean z, @SafeParcelable.Param(mo11702id = 3) List<String> list) {
        this.zzdvq = z;
        this.zzdvr = list;
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeBoolean(parcel, 2, this.zzdvq);
        SafeParcelWriter.writeStringList(parcel, 3, this.zzdvr, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
