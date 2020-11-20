package com.google.android.gms.ads.mediation;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public class MediationAdConfiguration {
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_FALSE = 0;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_TRUE = 1;
    public static final int TAG_FOR_CHILD_DIRECTED_TREATMENT_UNSPECIFIED = -1;
    private final Context context;
    private final String zzadn;
    private final int zzdmt;
    private final String zzdnt;
    private final String zzetp;
    private final Bundle zzetq;
    private final Bundle zzetr;
    private final int zzets;
    private final boolean zzmx;
    private final Location zzmy;

    @Retention(RetentionPolicy.SOURCE)
    public @interface TagForChildDirectedTreatment {
    }

    public MediationAdConfiguration(Context context2, String str, Bundle bundle, Bundle bundle2, boolean z, Location location, int i, int i2, String str2, String str3) {
        this.zzetp = str;
        this.zzetq = bundle;
        this.zzetr = bundle2;
        this.context = context2;
        this.zzmx = z;
        this.zzmy = location;
        this.zzdmt = i;
        this.zzets = i2;
        this.zzadn = str2;
        this.zzdnt = str3;
    }

    public String getBidResponse() {
        return this.zzetp;
    }

    public Context getContext() {
        return this.context;
    }

    public Location getLocation() {
        return this.zzmy;
    }

    public String getMaxAdContentRating() {
        return this.zzadn;
    }

    public Bundle getMediationExtras() {
        return this.zzetr;
    }

    public Bundle getServerParameters() {
        return this.zzetq;
    }

    public String getWatermark() {
        return this.zzdnt;
    }

    public boolean isTestRequest() {
        return this.zzmx;
    }

    public int taggedForChildDirectedTreatment() {
        return this.zzdmt;
    }

    public int taggedForUnderAgeTreatment() {
        return this.zzets;
    }
}
