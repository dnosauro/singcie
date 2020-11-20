package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateImpressionUrlsCallback;
import java.util.List;

final class zzasg extends zzasd {
    private final /* synthetic */ UpdateImpressionUrlsCallback zzdsd;

    zzasg(zzash zzash, UpdateImpressionUrlsCallback updateImpressionUrlsCallback) {
        this.zzdsd = updateImpressionUrlsCallback;
    }

    public final void onError(String str) {
        this.zzdsd.onFailure(str);
    }

    public final void onSuccess(List<Uri> list) {
        this.zzdsd.onSuccess(list);
    }
}
