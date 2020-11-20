package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.ads.query.QueryInfo;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzzn {
    private final String zzbqr;
    private final Bundle zzckq;

    public zzzn(String str, Bundle bundle) {
        this.zzbqr = str;
        this.zzckq = bundle;
    }

    public static String zza(QueryInfo queryInfo) {
        String str = zzwq.zzqi().get(queryInfo);
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            return "";
        }
    }

    public final String getQuery() {
        return this.zzbqr;
    }

    public final Bundle getQueryBundle() {
        return this.zzckq;
    }
}
