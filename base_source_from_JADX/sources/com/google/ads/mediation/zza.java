package com.google.ads.mediation;

import com.google.android.gms.ads.reward.AdMetadataListener;

final class zza extends AdMetadataListener {
    private final /* synthetic */ AbstractAdViewAdapter zzmm;

    zza(AbstractAdViewAdapter abstractAdViewAdapter) {
        this.zzmm = abstractAdViewAdapter;
    }

    public final void onAdMetadataChanged() {
        if (this.zzmm.zzmj != null && this.zzmm.zzmk != null) {
            this.zzmm.zzmk.zzb(this.zzmm.zzmj.getAdMetadata());
        }
    }
}
