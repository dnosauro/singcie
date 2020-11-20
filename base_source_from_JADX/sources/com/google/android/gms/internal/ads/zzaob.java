package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzaob extends IInterface {
    String getAdvertiser();

    String getBody();

    String getCallToAction();

    Bundle getExtras();

    String getHeadline();

    List getImages();

    float getMediaContentAspectRatio();

    boolean getOverrideClickHandling();

    boolean getOverrideImpressionRecording();

    String getPrice();

    double getStarRating();

    String getStore();

    zzys getVideoController();

    float getVideoCurrentTime();

    float getVideoDuration();

    void recordImpression();

    void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    zzaej zzsw();

    zzaeb zzsx();

    IObjectWrapper zzsy();

    void zzu(IObjectWrapper iObjectWrapper);

    IObjectWrapper zzup();

    IObjectWrapper zzuq();

    void zzw(IObjectWrapper iObjectWrapper);
}
