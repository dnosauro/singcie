package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.mediation.MediationAdRequest;
import java.util.Date;
import java.util.Set;

public final class zzaof implements MediationAdRequest {
    private final String zzadn;
    private final int zzcgz;
    private final boolean zzchk;
    private final int zzdmt;
    private final int zzdmu;
    private final Date zzmu;
    private final Set<String> zzmw;
    private final boolean zzmx;
    private final Location zzmy;

    public zzaof(Date date, int i, Set<String> set, Location location, boolean z, int i2, boolean z2, int i3, String str) {
        this.zzmu = date;
        this.zzcgz = i;
        this.zzmw = set;
        this.zzmy = location;
        this.zzmx = z;
        this.zzdmt = i2;
        this.zzchk = z2;
        this.zzdmu = i3;
        this.zzadn = str;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzmu;
    }

    @Deprecated
    public final int getGender() {
        return this.zzcgz;
    }

    public final Set<String> getKeywords() {
        return this.zzmw;
    }

    public final Location getLocation() {
        return this.zzmy;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzchk;
    }

    public final boolean isTesting() {
        return this.zzmx;
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzdmt;
    }
}
