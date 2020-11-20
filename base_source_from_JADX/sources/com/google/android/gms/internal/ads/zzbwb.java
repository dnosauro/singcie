package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.doubleclick.AppEventListener;

final /* synthetic */ class zzbwb implements zzbwm {
    private final String zzdha;
    private final String zzdih;

    zzbwb(String str, String str2) {
        this.zzdih = str;
        this.zzdha = str2;
    }

    public final void zzp(Object obj) {
        ((AppEventListener) obj).onAppEvent(this.zzdih, this.zzdha);
    }
}
