package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.os.Bundle;
import com.google.android.gms.ads.internal.util.zzd;

public final class zzs extends zze {
    public zzs(Activity activity) {
        super(activity);
    }

    public final void onCreate(Bundle bundle) {
        zzd.zzee("AdOverlayParcel is null or does not contain valid overlay type.");
        this.zzdqr = zzl.OTHER;
        this.zzaap.finish();
    }
}
