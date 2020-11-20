package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.util.JsonReader;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.zzp;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;

public final class zzczx {
    public final String zzgxz;
    public String zzgya;
    public Bundle zzgyb = new Bundle();

    public zzczx(JsonReader jsonReader) {
        String str = "";
        Map<String, String> hashMap = new HashMap<>();
        jsonReader.beginObject();
        while (jsonReader.hasNext()) {
            String nextName = jsonReader.nextName();
            nextName = nextName == null ? "" : nextName;
            char c = 65535;
            int hashCode = nextName.hashCode();
            if (hashCode != -995427962) {
                if (hashCode == -271442291 && nextName.equals("signal_dictionary")) {
                    c = 1;
                }
            } else if (nextName.equals("params")) {
                c = 0;
            }
            switch (c) {
                case 0:
                    str = jsonReader.nextString();
                    break;
                case 1:
                    hashMap = zzbk.zzb(jsonReader);
                    break;
                default:
                    jsonReader.skipValue();
                    break;
            }
        }
        this.zzgxz = str;
        jsonReader.endObject();
        for (Map.Entry next : hashMap.entrySet()) {
            if (!(next.getKey() == null || next.getValue() == null)) {
                this.zzgyb.putString((String) next.getKey(), (String) next.getValue());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final zzczx zzn(Bundle bundle) {
        try {
            this.zzgya = zzp.zzkq().zzc(bundle).toString();
        } catch (JSONException unused) {
            this.zzgya = "{}";
        }
        return this;
    }
}
