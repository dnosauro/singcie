package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.zzg;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzabu extends zzabz {
    private final zzg zzdaa;
    private final String zzdab;
    private final String zzdac;

    public zzabu(zzg zzg, String str, String str2) {
        this.zzdaa = zzg;
        this.zzdab = str;
        this.zzdac = str2;
    }

    public final String getContent() {
        return this.zzdac;
    }

    public final void recordClick() {
        this.zzdaa.zzkb();
    }

    public final void recordImpression() {
        this.zzdaa.zzkc();
    }

    public final void zzn(IObjectWrapper iObjectWrapper) {
        if (iObjectWrapper != null) {
            this.zzdaa.zzh((View) ObjectWrapper.unwrap(iObjectWrapper));
        }
    }

    public final String zzrz() {
        return this.zzdab;
    }
}
