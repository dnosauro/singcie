package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.formats.NativeCustomTemplateAd;

public final class zzagp {
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener zzdff;
    /* access modifiers changed from: private */
    public final NativeCustomTemplateAd.OnCustomClickListener zzdfg;
    private NativeCustomTemplateAd zzdfh;

    public zzagp(NativeCustomTemplateAd.OnCustomTemplateAdLoadedListener onCustomTemplateAdLoadedListener, NativeCustomTemplateAd.OnCustomClickListener onCustomClickListener) {
        this.zzdff = onCustomTemplateAdLoadedListener;
        this.zzdfg = onCustomClickListener;
    }

    /* access modifiers changed from: private */
    public final synchronized NativeCustomTemplateAd zzb(zzaff zzaff) {
        if (this.zzdfh != null) {
            return this.zzdfh;
        }
        zzafg zzafg = new zzafg(zzaff);
        this.zzdfh = zzafg;
        return zzafg;
    }

    public final zzafq zzti() {
        return new zzagq(this);
    }

    public final zzafp zztj() {
        if (this.zzdfg == null) {
            return null;
        }
        return new zzagr(this);
    }
}
