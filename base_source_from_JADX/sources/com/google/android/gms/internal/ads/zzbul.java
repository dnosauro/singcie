package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;
import com.google.android.gms.ads.internal.overlay.zzl;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.reward.AdMetadataListener;
import javax.annotation.Nullable;

public final class zzbul extends AdMetadataListener implements AppEventListener, zzp, zzbru, zzbsi, zzbsm, zzbto, zzbub, zzva {
    private final zzbvn zzfyh = new zzbvn(this);
    /* access modifiers changed from: private */
    @Nullable
    public zzcxq zzfyi;
    /* access modifiers changed from: private */
    @Nullable
    public zzcyd zzfyj;
    /* access modifiers changed from: private */
    @Nullable
    public zzdir zzfyk;
    /* access modifiers changed from: private */
    @Nullable
    public zzdlf zzfyl;

    private static <T> void zza(T t, zzbvm<T> zzbvm) {
        if (t != null) {
            zzbvm.zzq(t);
        }
    }

    public final void onAdClicked() {
        zza(this.zzfyi, zzbuo.zzfyg);
        zza(this.zzfyj, zzbur.zzfyg);
    }

    public final void onAdClosed() {
        zza(this.zzfyi, zzbuw.zzfyg);
        zza(this.zzfyl, zzbvf.zzfyg);
    }

    public final void onAdImpression() {
        zza(this.zzfyi, zzbuv.zzfyg);
    }

    public final void onAdLeftApplication() {
        zza(this.zzfyi, zzbve.zzfyg);
        zza(this.zzfyl, zzbvh.zzfyg);
    }

    public final void onAdMetadataChanged() {
        zza(this.zzfyl, zzbux.zzfyg);
    }

    public final void onAdOpened() {
        zza(this.zzfyi, zzbuk.zzfyg);
        zza(this.zzfyl, zzbun.zzfyg);
    }

    public final void onAppEvent(String str, String str2) {
        zza(this.zzfyi, new zzbuq(str, str2));
    }

    public final void onPause() {
        zza(this.zzfyk, zzbvd.zzfyg);
    }

    public final void onResume() {
        zza(this.zzfyk, zzbvc.zzfyg);
    }

    public final void onRewardedVideoCompleted() {
        zza(this.zzfyi, zzbum.zzfyg);
        zza(this.zzfyl, zzbup.zzfyg);
    }

    public final void onRewardedVideoStarted() {
        zza(this.zzfyi, zzbvg.zzfyg);
        zza(this.zzfyl, zzbvj.zzfyg);
    }

    public final void onUserLeaveHint() {
        zza(this.zzfyk, zzbva.zzfyg);
    }

    public final void zza(zzl zzl) {
        zza(this.zzfyk, new zzbvb(zzl));
    }

    public final zzbvn zzakb() {
        return this.zzfyh;
    }

    public final void zzakz() {
        zza(this.zzfyk, zzbuu.zzfyg);
    }

    public final void zzb(zzauf zzauf, String str, String str2) {
        zza(this.zzfyi, new zzbvi(zzauf, str, str2));
        zza(this.zzfyl, new zzbvl(zzauf, str, str2));
    }

    public final void zzb(zzvp zzvp) {
        zza(this.zzfyi, new zzbut(zzvp));
        zza(this.zzfyl, new zzbus(zzvp));
    }

    public final void zzj(zzve zzve) {
        zza(this.zzfyl, new zzbuz(zzve));
    }

    public final void zzux() {
        zza(this.zzfyk, zzbuy.zzfyg);
    }
}
