package com.google.ads.mediation;

import android.location.Location;
import com.google.ads.AdRequest;
import java.util.Calendar;
import java.util.Date;
import java.util.Set;

@Deprecated
public class MediationAdRequest {
    private final Date zzmu;
    private final AdRequest.Gender zzmv;
    private final Set<String> zzmw;
    private final boolean zzmx;
    private final Location zzmy;

    public MediationAdRequest(Date date, AdRequest.Gender gender, Set<String> set, boolean z, Location location) {
        this.zzmu = date;
        this.zzmv = gender;
        this.zzmw = set;
        this.zzmx = z;
        this.zzmy = location;
    }

    public Integer getAgeInYears() {
        if (this.zzmu == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        instance.setTime(this.zzmu);
        Integer valueOf = Integer.valueOf(instance2.get(1) - instance.get(1));
        return (instance2.get(2) < instance.get(2) || (instance2.get(2) == instance.get(2) && instance2.get(5) < instance.get(5))) ? Integer.valueOf(valueOf.intValue() - 1) : valueOf;
    }

    public Date getBirthday() {
        return this.zzmu;
    }

    public AdRequest.Gender getGender() {
        return this.zzmv;
    }

    public Set<String> getKeywords() {
        return this.zzmw;
    }

    public Location getLocation() {
        return this.zzmy;
    }

    public boolean isTesting() {
        return this.zzmx;
    }
}
