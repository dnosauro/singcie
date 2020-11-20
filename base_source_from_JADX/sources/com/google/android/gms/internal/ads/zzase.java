package com.google.android.gms.internal.ads;

import android.os.Bundle;
import com.google.android.gms.ads.query.QueryInfo;
import com.google.android.gms.ads.query.QueryInfoGenerationCallback;

final class zzase extends zzaxo {
    private final /* synthetic */ QueryInfoGenerationCallback zzdsa;

    zzase(zzasf zzasf, QueryInfoGenerationCallback queryInfoGenerationCallback) {
        this.zzdsa = queryInfoGenerationCallback;
    }

    public final void onError(String str) {
        this.zzdsa.onFailure(str);
    }

    public final void zza(String str, String str2, Bundle bundle) {
        QueryInfo queryInfo = new QueryInfo(new zzzn(str, bundle));
        zzwq.zzqi().put(queryInfo, str2);
        this.zzdsa.onSuccess(queryInfo);
    }

    public final void zzk(String str, String str2) {
        QueryInfo queryInfo = new QueryInfo(new zzzn(str, (Bundle) null));
        zzwq.zzqi().put(queryInfo, str2);
        this.zzdsa.onSuccess(queryInfo);
    }
}
