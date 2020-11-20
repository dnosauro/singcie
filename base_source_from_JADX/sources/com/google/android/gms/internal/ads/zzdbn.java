package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdbn implements zzdfj<Bundle> {
    private final float zzdth;
    private final int zzdwd;
    private final boolean zzdwl;
    private final boolean zzdwm;
    private final int zzdwq;
    private final int zzdwu;
    private final int zzdwv;
    private final boolean zzgze;

    public zzdbn(int i, boolean z, boolean z2, int i2, int i3, int i4, float f, boolean z3) {
        this.zzdwd = i;
        this.zzdwl = z;
        this.zzdwm = z2;
        this.zzdwq = i2;
        this.zzdwu = i3;
        this.zzdwv = i4;
        this.zzdth = f;
        this.zzgze = z3;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        bundle.putInt("am", this.zzdwd);
        bundle.putBoolean("ma", this.zzdwl);
        bundle.putBoolean("sp", this.zzdwm);
        bundle.putInt("muv", this.zzdwq);
        bundle.putInt("rm", this.zzdwu);
        bundle.putInt("riv", this.zzdwv);
        bundle.putFloat("android_app_volume", this.zzdth);
        bundle.putBoolean("android_app_muted", this.zzgze);
    }
}
