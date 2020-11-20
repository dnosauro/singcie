package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.ShouldDelayBannerRenderingListener;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;

public final class zzaai extends zzagc {
    private final ShouldDelayBannerRenderingListener zzclb;

    public zzaai(ShouldDelayBannerRenderingListener shouldDelayBannerRenderingListener) {
        this.zzclb = shouldDelayBannerRenderingListener;
    }

    public final boolean zzm(IObjectWrapper iObjectWrapper) {
        return this.zzclb.shouldDelayBannerRendering((Runnable) ObjectWrapper.unwrap(iObjectWrapper));
    }
}
