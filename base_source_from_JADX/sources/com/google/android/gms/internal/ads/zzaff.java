package com.google.android.gms.internal.ads;

import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzaff extends IInterface {
    void destroy();

    List<String> getAvailableAssetNames();

    String getCustomTemplateId();

    zzys getVideoController();

    void performClick(String str);

    void recordImpression();

    String zzct(String str);

    zzaej zzcu(String str);

    boolean zzp(IObjectWrapper iObjectWrapper);

    void zzq(IObjectWrapper iObjectWrapper);

    IObjectWrapper zzsv();

    IObjectWrapper zzta();

    boolean zztb();

    boolean zztc();

    void zztd();
}
