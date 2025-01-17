package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final /* synthetic */ class zzaki {
    public static void zza(zzakj zzakj, String str, String str2) {
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(str2).length());
        sb.append(str);
        sb.append("(");
        sb.append(str2);
        sb.append(");");
        zzakj.zzcy(sb.toString());
    }

    public static void zza(zzakj zzakj, String str, Map map) {
        try {
            zzakj.zzb(str, zzp.zzkq().zzj((Map<String, ?>) map));
        } catch (JSONException unused) {
            zzd.zzfa("Could not convert parameters to JSON.");
        }
    }

    public static void zza(zzakj zzakj, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        zzakj.zzj(str, jSONObject.toString());
    }

    public static void zzb(zzakj zzakj, String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzd.zzeb(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzakj.zzcy(sb.toString());
    }
}
