package com.google.android.gms.ads.mediation;

import com.google.android.gms.ads.formats.NativeAdOptions;
import java.util.Map;

public interface NativeMediationAdRequest extends MediationAdRequest {
    float getAdVolume();

    NativeAdOptions getNativeAdOptions();

    boolean isAdMuted();

    boolean isAppInstallAdRequested();

    boolean isContentAdRequested();

    boolean isUnifiedNativeAdRequested();

    boolean zzuu();

    Map<String, Boolean> zzuv();
}
