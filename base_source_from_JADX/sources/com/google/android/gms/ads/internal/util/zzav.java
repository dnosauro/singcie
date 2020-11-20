package com.google.android.gms.ads.internal.util;

import com.google.android.gms.common.internal.Objects;
import com.google.android.gms.measurement.api.AppMeasurementSdk;

public final class zzav {
    public final int count;
    public final String name;
    private final double zzeej;
    private final double zzeek;
    public final double zzeel;

    public zzav(String str, double d, double d2, double d3, int i) {
        this.name = str;
        this.zzeek = d;
        this.zzeej = d2;
        this.zzeel = d3;
        this.count = i;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof zzav)) {
            return false;
        }
        zzav zzav = (zzav) obj;
        return Objects.equal(this.name, zzav.name) && this.zzeej == zzav.zzeej && this.zzeek == zzav.zzeek && this.count == zzav.count && Double.compare(this.zzeel, zzav.zzeel) == 0;
    }

    public final int hashCode() {
        return Objects.hashCode(this.name, Double.valueOf(this.zzeej), Double.valueOf(this.zzeek), Double.valueOf(this.zzeel), Integer.valueOf(this.count));
    }

    public final String toString() {
        return Objects.toStringHelper(this).add(AppMeasurementSdk.ConditionalUserProperty.NAME, this.name).add("minBound", Double.valueOf(this.zzeek)).add("maxBound", Double.valueOf(this.zzeej)).add("percent", Double.valueOf(this.zzeel)).add("count", Integer.valueOf(this.count)).toString();
    }
}
