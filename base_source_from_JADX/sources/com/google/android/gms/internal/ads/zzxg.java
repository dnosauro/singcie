package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;

public interface zzxg extends IInterface {
    void destroy();

    Bundle getAdMetadata();

    String getAdUnitId();

    String getMediationAdapterClassName();

    zzys getVideoController();

    boolean isLoading();

    boolean isReady();

    void pause();

    void resume();

    void setImmersiveMode(boolean z);

    void setManualImpressionsEnabled(boolean z);

    void setUserId(String str);

    void showInterstitial();

    void stopLoading();

    void zza(zzaak zzaak);

    void zza(zzacb zzacb);

    void zza(zzart zzart);

    void zza(zzarz zzarz, String str);

    void zza(zzaup zzaup);

    void zza(zzsl zzsl);

    void zza(zzvn zzvn);

    void zza(zzvw zzvw);

    void zza(zzws zzws);

    void zza(zzwt zzwt);

    void zza(zzxj zzxj);

    void zza(zzxo zzxo);

    void zza(zzxu zzxu);

    void zza(zzym zzym);

    void zza(zzyy zzyy);

    boolean zza(zzvk zzvk);

    void zzbl(String str);

    IObjectWrapper zzkd();

    void zzke();

    zzvn zzkf();

    String zzkg();

    zzyn zzkh();

    zzxo zzki();

    zzwt zzkj();
}
