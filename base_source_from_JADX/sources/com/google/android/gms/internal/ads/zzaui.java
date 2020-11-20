package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzaui extends IInterface {
    void destroy();

    Bundle getAdMetadata();

    String getMediationAdapterClassName();

    boolean isLoaded();

    void pause();

    void resume();

    void setAppPackageName(String str);

    void setCustomData(String str);

    void setImmersiveMode(boolean z);

    void setUserId(String str);

    void show();

    void zza(zzaug zzaug);

    void zza(zzaup zzaup);

    void zza(zzauv zzauv);

    void zza(zzxj zzxj);

    void zzi(IObjectWrapper iObjectWrapper);

    void zzj(IObjectWrapper iObjectWrapper);

    void zzk(IObjectWrapper iObjectWrapper);

    zzyn zzkh();

    void zzl(IObjectWrapper iObjectWrapper);

    boolean zzrf();
}
