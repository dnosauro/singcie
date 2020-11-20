package com.google.android.gms.ads.query;

import android.content.Context;
import android.os.Bundle;
import com.google.android.gms.ads.AdFormat;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.internal.ads.zzasf;
import com.google.android.gms.internal.ads.zzzn;

@KeepForSdk
public class QueryInfo {
    private final zzzn zzhpg;

    public QueryInfo(zzzn zzzn) {
        this.zzhpg = zzzn;
    }

    @KeepForSdk
    public static void generate(Context context, AdFormat adFormat, AdRequest adRequest, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        new zzasf(context, adFormat, adRequest == null ? null : adRequest.zzds()).zza(queryInfoGenerationCallback);
    }

    @KeepForSdk
    public String getQuery() {
        return this.zzhpg.getQuery();
    }

    @KeepForSdk
    public Bundle getQueryBundle() {
        return this.zzhpg.getQueryBundle();
    }

    @KeepForSdk
    public String getRequestId() {
        return zzzn.zza(this);
    }
}
