package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdau implements zzdfj<Bundle> {
    private final zzazh zzdsm;
    private final zzvw zzgyt;

    public zzdau(zzvw zzvw, zzazh zzazh) {
        this.zzgyt = zzvw;
        this.zzdsm = zzazh;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        int intValue = ((Integer) zzwq.zzqe().zzd(zzabf.zzcut)).intValue();
        zzazh zzazh = this.zzdsm;
        if (zzazh != null && zzazh.zzegm >= intValue) {
            bundle.putString("app_open_version", "2");
        }
        zzvw zzvw = this.zzgyt;
        if (zzvw == null) {
            return;
        }
        if (zzvw.orientation == 1) {
            bundle.putString("avo", "p");
        } else if (this.zzgyt.orientation == 2) {
            bundle.putString("avo", "l");
        }
    }
}
