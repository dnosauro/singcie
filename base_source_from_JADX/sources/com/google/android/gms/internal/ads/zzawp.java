package com.google.android.gms.internal.ads;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONObject;

@SafeParcelable.Class(creator = "SafeBrowsingConfigParcelCreator")
@SafeParcelable.Reserved({1})
public final class zzawp extends AbstractSafeParcelable {
    public static final Parcelable.Creator<zzawp> CREATOR = new zzawo();
    @SafeParcelable.Field(mo11699id = 2)
    public final String zzdzb;
    @SafeParcelable.Field(mo11699id = 3)
    public final String zzdzc;
    @SafeParcelable.Field(mo11699id = 4)
    public final boolean zzdzd;
    @SafeParcelable.Field(mo11699id = 5)
    public final boolean zzdze;
    @SafeParcelable.Field(mo11699id = 6)
    public final List<String> zzdzf;
    @SafeParcelable.Field(mo11699id = 7)
    public final boolean zzdzg;
    @SafeParcelable.Field(mo11699id = 8)
    public final boolean zzdzh;
    @SafeParcelable.Field(mo11699id = 9)
    public final List<String> zzdzi;

    @SafeParcelable.Constructor
    public zzawp(@SafeParcelable.Param(mo11702id = 2) String str, @SafeParcelable.Param(mo11702id = 3) String str2, @SafeParcelable.Param(mo11702id = 4) boolean z, @SafeParcelable.Param(mo11702id = 5) boolean z2, @SafeParcelable.Param(mo11702id = 6) List<String> list, @SafeParcelable.Param(mo11702id = 7) boolean z3, @SafeParcelable.Param(mo11702id = 8) boolean z4, @SafeParcelable.Param(mo11702id = 9) List<String> list2) {
        this.zzdzb = str;
        this.zzdzc = str2;
        this.zzdzd = z;
        this.zzdze = z2;
        this.zzdzf = list;
        this.zzdzg = z3;
        this.zzdzh = z4;
        this.zzdzi = list2 == null ? new ArrayList<>() : list2;
    }

    public static zzawp zzg(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        return new zzawp(jSONObject.optString("click_string", ""), jSONObject.optString("report_url", ""), jSONObject.optBoolean("rendered_ad_enabled", false), jSONObject.optBoolean("non_malicious_reporting_enabled", false), zzbk.zza(jSONObject.optJSONArray("allowed_headers"), (List<String>) null), jSONObject.optBoolean("protection_enabled", false), jSONObject.optBoolean("malicious_reporting_enabled", false), zzbk.zza(jSONObject.optJSONArray("webview_permissions"), (List<String>) null));
    }

    public final void writeToParcel(Parcel parcel, int i) {
        int beginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeString(parcel, 2, this.zzdzb, false);
        SafeParcelWriter.writeString(parcel, 3, this.zzdzc, false);
        SafeParcelWriter.writeBoolean(parcel, 4, this.zzdzd);
        SafeParcelWriter.writeBoolean(parcel, 5, this.zzdze);
        SafeParcelWriter.writeStringList(parcel, 6, this.zzdzf, false);
        SafeParcelWriter.writeBoolean(parcel, 7, this.zzdzg);
        SafeParcelWriter.writeBoolean(parcel, 8, this.zzdzh);
        SafeParcelWriter.writeStringList(parcel, 9, this.zzdzi, false);
        SafeParcelWriter.finishObjectHeader(parcel, beginObjectHeader);
    }
}
