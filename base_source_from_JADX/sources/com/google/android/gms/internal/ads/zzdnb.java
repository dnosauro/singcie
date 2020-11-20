package com.google.android.gms.internal.ads;

import android.util.JsonReader;
import android.util.JsonWriter;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzbl;
import org.json.JSONObject;

public final class zzdnb implements zzbl {
    public final String zzdrn = this.zzhib.optString("ad_base_url", (String) null);
    public final String zzdrp = this.zzhib.optString("ad_html", (String) null);
    public final JSONObject zzgao = this.zzhib.optJSONObject("ad_json");
    private final JSONObject zzhib;

    zzdnb(JsonReader jsonReader) {
        this.zzhib = zzbk.zzc(jsonReader);
    }

    public final void zza(JsonWriter jsonWriter) {
        zzbk.zza(jsonWriter, this.zzhib);
    }
}
