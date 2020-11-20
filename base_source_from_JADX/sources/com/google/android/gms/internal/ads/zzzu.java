package com.google.android.gms.internal.ads;

import android.os.RemoteException;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Collections;
import java.util.List;

public final class zzzu extends zzxv {
    private zzajc zzckt;

    public final String getVersionString() {
        return "";
    }

    public final void initialize() {
        zzaza.zzey("The initialization is not processed because MobileAdsSettingsManager is not created successfully.");
        zzayr.zzzz.post(new zzzx(this));
    }

    public final void setAppMuted(boolean z) {
    }

    public final void setAppVolume(float f) {
    }

    public final void zza(zzaae zzaae) {
    }

    public final void zza(zzajc zzajc) {
        this.zzckt = zzajc;
    }

    public final void zza(zzani zzani) {
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) {
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
    }

    public final void zzcd(String str) {
    }

    public final void zzce(String str) {
    }

    public final float zzqk() {
        return 1.0f;
    }

    public final boolean zzql() {
        return false;
    }

    public final List<zzaiz> zzqm() {
        return Collections.emptyList();
    }

    public final void zzqn() {
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzrd() {
        zzajc zzajc = this.zzckt;
        if (zzajc != null) {
            try {
                zzajc.zze(Collections.emptyList());
            } catch (RemoteException e) {
                zzaza.zzd("Could not notify onComplete event.", e);
            }
        }
    }
}
