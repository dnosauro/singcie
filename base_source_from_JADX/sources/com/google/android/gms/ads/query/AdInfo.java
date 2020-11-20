package com.google.android.gms.ads.query;

import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzaza;
import org.json.JSONException;
import org.json.JSONObject;

@KeepForSdk
public class AdInfo {
    private final QueryInfo zzhpe;
    private final String zzhpf;

    @KeepForSdk
    public AdInfo(QueryInfo queryInfo, String str) {
        this.zzhpe = queryInfo;
        this.zzhpf = str;
    }

    @KeepForSdk
    public static String getRequestId(String str) {
        if (str == null) {
            zzaza.zzfa("adString passed to AdInfo.getRequestId() cannot be null. Returning empty string.");
            return "";
        }
        try {
            return new JSONObject(str).optString("request_id", "");
        } catch (JSONException unused) {
            zzaza.zzfa("Invalid adString passed to AdInfo.getRequestId(). Returning empty string.");
            return "";
        }
    }

    @KeepForSdk
    public String getAdString() {
        return this.zzhpf;
    }

    @KeepForSdk
    public QueryInfo getQueryInfo() {
        return this.zzhpe;
    }
}
