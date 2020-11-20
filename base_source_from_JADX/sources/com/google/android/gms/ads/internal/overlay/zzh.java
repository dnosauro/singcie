package com.google.android.gms.ads.internal.overlay;

import android.content.Context;
import android.view.MotionEvent;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzag;
import com.google.android.gms.common.util.VisibleForTesting;

@VisibleForTesting
final class zzh extends RelativeLayout {
    @VisibleForTesting
    private zzag zzdqz;
    @VisibleForTesting
    boolean zzdra;

    public zzh(Context context, String str, String str2) {
        super(context);
        this.zzdqz = new zzag(context, str);
        this.zzdqz.zzad(str2);
    }

    public final boolean onInterceptTouchEvent(MotionEvent motionEvent) {
        if (this.zzdra) {
            return false;
        }
        this.zzdqz.zzd(motionEvent);
        return false;
    }
}
