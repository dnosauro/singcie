package com.google.android.gms.internal.ads;

import android.os.Bundle;

public final class zzdcy implements zzdfj<Bundle> {
    private final Boolean zzhaa;

    public zzdcy(Boolean bool) {
        this.zzhaa = bool;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        Boolean bool = this.zzhaa;
        if (bool != null) {
            bundle.putBoolean("hw_accel", bool.booleanValue());
        }
    }
}
