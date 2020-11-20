package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IInterface;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.List;

public interface zzann extends IInterface {
    void destroy();

    Bundle getInterstitialAdapterInfo();

    zzys getVideoController();

    boolean isInitialized();

    void pause();

    void resume();

    void setImmersiveMode(boolean z);

    void showInterstitial();

    void showVideo();

    void zza(IObjectWrapper iObjectWrapper, zzajb zzajb, List<zzajj> list);

    void zza(IObjectWrapper iObjectWrapper, zzauw zzauw, List<String> list);

    void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano);

    void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzauw zzauw, String str2);

    void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, String str2, zzano zzano);

    void zza(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, String str2, zzano zzano, zzadz zzadz, List<String> list);

    void zza(IObjectWrapper iObjectWrapper, zzvn zzvn, zzvk zzvk, String str, zzano zzano);

    void zza(IObjectWrapper iObjectWrapper, zzvn zzvn, zzvk zzvk, String str, String str2, zzano zzano);

    void zza(zzvk zzvk, String str);

    void zza(zzvk zzvk, String str, String str2);

    void zzb(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano);

    void zzc(IObjectWrapper iObjectWrapper, zzvk zzvk, String str, zzano zzano);

    void zzs(IObjectWrapper iObjectWrapper);

    void zzt(IObjectWrapper iObjectWrapper);

    IObjectWrapper zzud();

    zzanv zzue();

    zzanw zzuf();

    Bundle zzug();

    Bundle zzuh();

    boolean zzui();

    zzaff zzuj();

    zzaob zzuk();

    zzaqc zzul();

    zzaqc zzum();
}
