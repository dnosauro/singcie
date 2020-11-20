package com.google.android.gms.internal.ads;

import com.google.android.gms.common.internal.ImagesContract;
import java.util.Arrays;
import java.util.List;
import org.json.JSONObject;

public final class zzatr {
    private final int errorCode;
    private final String type;
    private String url;
    private final String zzdtb;
    private final String zzdvn;
    private final boolean zzdvo;
    private final String zzdwb;
    private final List<String> zzdxd;
    private final String zzdxe;
    private final String zzdxf;
    private final boolean zzdxg;
    private final String zzdxh;
    private final boolean zzdxi;
    private final JSONObject zzdxj;

    public zzatr(JSONObject jSONObject) {
        this.url = jSONObject.optString(ImagesContract.URL);
        this.zzdxe = jSONObject.optString("base_uri");
        this.zzdxf = jSONObject.optString("post_parameters");
        String optString = jSONObject.optString("drt_include");
        int i = 1;
        this.zzdxg = optString != null && (optString.equals("1") || optString.equals("true"));
        this.zzdtb = jSONObject.optString("request_id");
        this.type = jSONObject.optString("type");
        String optString2 = jSONObject.optString("errors");
        this.zzdxd = optString2 == null ? null : Arrays.asList(optString2.split(","));
        this.errorCode = jSONObject.optInt("valid", 0) == 1 ? -2 : i;
        this.zzdxh = jSONObject.optString("fetched_ad");
        this.zzdxi = jSONObject.optBoolean("render_test_ad_label");
        JSONObject optJSONObject = jSONObject.optJSONObject("preprocessor_flags");
        this.zzdxj = optJSONObject == null ? new JSONObject() : optJSONObject;
        this.zzdvn = jSONObject.optString("analytics_query_ad_event_id");
        this.zzdvo = jSONObject.optBoolean("is_analytics_logging_enabled");
        this.zzdwb = jSONObject.optString("pool_key");
    }

    public final int getErrorCode() {
        return this.errorCode;
    }

    public final String getUrl() {
        return this.url;
    }

    public final List<String> zzvt() {
        return this.zzdxd;
    }

    public final String zzvu() {
        return this.zzdxe;
    }

    public final String zzvv() {
        return this.zzdxf;
    }

    public final boolean zzvw() {
        return this.zzdxg;
    }

    public final JSONObject zzvx() {
        return this.zzdxj;
    }

    public final String zzvy() {
        return this.zzdwb;
    }
}
