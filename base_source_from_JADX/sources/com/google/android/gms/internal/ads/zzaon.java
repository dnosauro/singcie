package com.google.android.gms.internal.ads;

import android.location.Location;
import com.google.android.gms.ads.VideoOptions;
import com.google.android.gms.ads.formats.NativeAdOptions;
import com.google.android.gms.ads.mediation.NativeMediationAdRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzaon implements NativeMediationAdRequest {
    private final String zzadn;
    private final int zzcgz;
    private final boolean zzchk;
    private final int zzdmt;
    private final int zzdmu;
    private final zzadz zzdnh;
    private final List<String> zzdni = new ArrayList();
    private final Map<String, Boolean> zzdnj = new HashMap();
    private final Date zzmu;
    private final Set<String> zzmw;
    private final boolean zzmx;
    private final Location zzmy;

    public zzaon(Date date, int i, Set<String> set, Location location, boolean z, int i2, zzadz zzadz, List<String> list, boolean z2, int i3, String str) {
        Map<String, Boolean> map;
        String str2;
        boolean z3;
        this.zzmu = date;
        this.zzcgz = i;
        this.zzmw = set;
        this.zzmy = location;
        this.zzmx = z;
        this.zzdmt = i2;
        this.zzdnh = zzadz;
        this.zzchk = z2;
        this.zzdmu = i3;
        this.zzadn = str;
        if (list != null) {
            for (String next : list) {
                if (next.startsWith("custom:")) {
                    String[] split = next.split(":", 3);
                    if (split.length == 3) {
                        if ("true".equals(split[2])) {
                            map = this.zzdnj;
                            str2 = split[1];
                            z3 = true;
                        } else if ("false".equals(split[2])) {
                            map = this.zzdnj;
                            str2 = split[1];
                            z3 = false;
                        }
                        map.put(str2, z3);
                    }
                } else {
                    this.zzdni.add(next);
                }
            }
        }
    }

    public final float getAdVolume() {
        return zzzd.zzrb().zzqk();
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

    public final NativeAdOptions getNativeAdOptions() {
        if (this.zzdnh == null) {
            return null;
        }
        NativeAdOptions.Builder requestMultipleImages = new NativeAdOptions.Builder().setReturnUrlsForImageAssets(this.zzdnh.zzdeo).setImageOrientation(this.zzdnh.zzbnm).setRequestMultipleImages(this.zzdnh.zzbno);
        if (this.zzdnh.versionCode >= 2) {
            requestMultipleImages.setAdChoicesPlacement(this.zzdnh.zzbnp);
        }
        if (this.zzdnh.versionCode >= 3 && this.zzdnh.zzdep != null) {
            requestMultipleImages.setVideoOptions(new VideoOptions(this.zzdnh.zzdep));
        }
        return requestMultipleImages.build();
    }

    public final boolean isAdMuted() {
        return zzzd.zzrb().zzql();
    }

    public final boolean isAppInstallAdRequested() {
        List<String> list = this.zzdni;
        if (list != null) {
            return list.contains("2") || this.zzdni.contains("6");
        }
        return false;
    }

    public final boolean isContentAdRequested() {
        List<String> list = this.zzdni;
        if (list != null) {
            return list.contains("1") || this.zzdni.contains("6");
        }
        return false;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzchk;
    }

    public final boolean isTesting() {
        return this.zzmx;
    }

    public final boolean isUnifiedNativeAdRequested() {
        List<String> list = this.zzdni;
        return list != null && list.contains("6");
    }

    public final int taggedForChildDirectedTreatment() {
        return this.zzdmt;
    }

    public final boolean zzuu() {
        List<String> list = this.zzdni;
        return list != null && list.contains("3");
    }

    public final Map<String, Boolean> zzuv() {
        return this.zzdnj;
    }
}
