package com.google.android.gms.internal.ads;

import com.google.android.gms.tasks.OnFailureListener;

final /* synthetic */ class zzdta implements OnFailureListener {
    private final zzdsv zzhqk;

    zzdta(zzdsv zzdsv) {
        this.zzhqk = zzdsv;
    }

    public final void onFailure(Exception exc) {
        this.zzhqk.zzc(exc);
    }
}
