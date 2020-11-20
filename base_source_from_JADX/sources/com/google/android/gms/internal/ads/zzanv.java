package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzanv extends IInterface {
    String getBody();

    String getCallToAction();

    Bundle getExtras();

    String getHeadline();

    List getImages();

    boolean getOverrideClickHandling();

    boolean getOverrideImpressionRecording();

    String getPrice();

    double getStarRating();

    String getStore();

    zzys getVideoController();

    void recordImpression();

    void zzc(IObjectWrapper iObjectWrapper, IObjectWrapper iObjectWrapper2, IObjectWrapper iObjectWrapper3);

    zzaej zzsw();

    zzaeb zzsx();

    IObjectWrapper zzsy();

    void zzu(IObjectWrapper iObjectWrapper);

    IObjectWrapper zzup();

    IObjectWrapper zzuq();

    void zzv(IObjectWrapper iObjectWrapper);

    void zzw(IObjectWrapper iObjectWrapper);
}
