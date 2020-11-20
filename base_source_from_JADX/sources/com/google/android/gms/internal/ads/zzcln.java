package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.util.Collections;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;

public final class zzcln implements AppEventListener, zzbru, zzbrz, zzbsm, zzbsp, zzbtj, zzbui, zzdru, zzva {
    private long startTime;
    private final List<Object> zzegg;
    private final zzclb zzgla;

    public zzcln(zzclb zzclb, zzbgm zzbgm) {
        this.zzgla = zzclb;
        this.zzegg = Collections.singletonList(zzbgm);
    }

    private final void zza(Class<?> cls, String str, Object... objArr) {
        zzclb zzclb = this.zzgla;
        List<Object> list = this.zzegg;
        String valueOf = String.valueOf(cls.getSimpleName());
        zzclb.zza(list, valueOf.length() != 0 ? "Event-".concat(valueOf) : new String("Event-"), str, objArr);
    }

    public final void onAdClicked() {
        zza((Class<?>) zzva.class, "onAdClicked", new Object[0]);
    }

    public final void onAdClosed() {
        zza((Class<?>) zzbru.class, "onAdClosed", new Object[0]);
    }

    public final void onAdImpression() {
        zza((Class<?>) zzbsm.class, "onAdImpression", new Object[0]);
    }

    public final void onAdLeftApplication() {
        zza((Class<?>) zzbru.class, "onAdLeftApplication", new Object[0]);
    }

    public final void onAdLoaded() {
        long elapsedRealtime = zzp.zzkx().elapsedRealtime() - this.startTime;
        StringBuilder sb = new StringBuilder(41);
        sb.append("Ad Request Latency : ");
        sb.append(elapsedRealtime);
        zzd.zzee(sb.toString());
        zza((Class<?>) zzbtj.class, "onAdLoaded", new Object[0]);
    }

    public final void onAdOpened() {
        zza((Class<?>) zzbru.class, "onAdOpened", new Object[0]);
    }

    public final void onAppEvent(String str, String str2) {
        zza((Class<?>) AppEventListener.class, "onAppEvent", str, str2);
    }

    public final void onRewardedVideoCompleted() {
        zza((Class<?>) zzbru.class, "onRewardedVideoCompleted", new Object[0]);
    }

    public final void onRewardedVideoStarted() {
        zza((Class<?>) zzbru.class, "onRewardedVideoStarted", new Object[0]);
    }

    public final void zza(zzdrl zzdrl, String str) {
        zza((Class<?>) zzdrm.class, "onTaskCreated", str);
    }

    public final void zza(zzdrl zzdrl, String str, Throwable th) {
        zza((Class<?>) zzdrm.class, "onTaskFailed", str, th.getClass().getSimpleName());
    }

    @ParametersAreNonnullByDefault
    public final void zzb(zzauf zzauf, String str, String str2) {
        zza((Class<?>) zzbru.class, "onRewarded", zzauf, str, str2);
    }

    public final void zzb(zzdnj zzdnj) {
    }

    public final void zzb(zzdrl zzdrl, String str) {
        zza((Class<?>) zzdrm.class, "onTaskStarted", str);
    }

    public final void zzc(zzdrl zzdrl, String str) {
        zza((Class<?>) zzdrm.class, "onTaskSucceeded", str);
    }

    public final void zzcc(Context context) {
        zza((Class<?>) zzbsp.class, "onPause", context);
    }

    public final void zzcd(Context context) {
        zza((Class<?>) zzbsp.class, "onResume", context);
    }

    public final void zzce(Context context) {
        zza((Class<?>) zzbsp.class, "onDestroy", context);
    }

    public final void zzd(zzatl zzatl) {
        this.startTime = zzp.zzkx().elapsedRealtime();
        zza((Class<?>) zzbui.class, "onAdRequest", new Object[0]);
    }

    public final void zzk(zzve zzve) {
        zza((Class<?>) zzbrz.class, "onAdFailedToLoad", Integer.valueOf(zzve.errorCode), zzve.zzcgs, zzve.zzcgt);
    }
}
