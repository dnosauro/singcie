package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import javax.annotation.Nullable;

public final class zzdch implements zzdfj<Bundle> {
    @Nullable
    private final Location zzmy;

    public zzdch(@Nullable Location location) {
        this.zzmy = location;
    }

    public final /* synthetic */ void zzs(Object obj) {
        Bundle bundle = (Bundle) obj;
        if (this.zzmy != null) {
            Bundle bundle2 = new Bundle();
            bundle2.putFloat("radius", this.zzmy.getAccuracy() * 1000.0f);
            bundle2.putLong("lat", (long) (this.zzmy.getLatitude() * 1.0E7d));
            bundle2.putLong("long", (long) (this.zzmy.getLongitude() * 1.0E7d));
            bundle2.putLong("time", this.zzmy.getTime() * 1000);
            bundle.putBundle("uule", bundle2);
        }
    }
}
