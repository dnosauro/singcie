package com.google.android.gms.internal.ads;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.nio.charset.Charset;
import org.json.JSONObject;

public final class zzamg {
    private static final Charset UTF_8 = Charset.forName("UTF-8");
    public static final zzamh<JSONObject> zzdjy = new zzami();
    public static final zzamf<InputStream> zzdjz = zzamj.zzdka;

    static final /* synthetic */ InputStream zze(JSONObject jSONObject) {
        return new ByteArrayInputStream(jSONObject.toString().getBytes(UTF_8));
    }
}
