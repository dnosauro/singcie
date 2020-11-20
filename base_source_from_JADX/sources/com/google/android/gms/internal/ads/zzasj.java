package com.google.android.gms.internal.ads;

import android.net.Uri;
import com.google.android.gms.ads.query.UpdateClickUrlCallback;
import java.util.List;

final class zzasj extends zzasd {
    private final /* synthetic */ UpdateClickUrlCallback zzdsg;

    zzasj(zzash zzash, UpdateClickUrlCallback updateClickUrlCallback) {
        this.zzdsg = updateClickUrlCallback;
    }

    public final void onError(String str) {
        this.zzdsg.onFailure(str);
    }

    public final void onSuccess(List<Uri> list) {
        this.zzdsg.onSuccess(list.get(0));
    }
}
