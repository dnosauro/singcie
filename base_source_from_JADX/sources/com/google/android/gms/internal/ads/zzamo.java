package com.google.android.gms.internal.ads;

final class zzamo implements zzazs {
    private final /* synthetic */ zzazq zzdhe;
    private final /* synthetic */ zzalo zzdkh;

    zzamo(zzamm zzamm, zzazq zzazq, zzalo zzalo) {
        this.zzdhe = zzazq;
        this.zzdkh = zzalo;
    }

    public final void run() {
        this.zzdhe.setException(new zzama("Unable to obtain a JavascriptEngine."));
        this.zzdkh.release();
    }
}
