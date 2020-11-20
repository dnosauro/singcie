package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import com.google.android.gms.ads.search.SearchAdRequest;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

public final class zzza {
    private final int zzadl;
    private final int zzadm;
    private final String zzadn;
    private final boolean zzbnx;
    private final int zzcgz;
    private final String zzchc;
    private final String zzche;
    private final Bundle zzchg;
    private final String zzchi;
    private final boolean zzchk;
    private final List<String> zzchl;
    private final int zzchm;
    private final Bundle zzcjk;
    private final AdInfo zzcjo;
    private final Map<Class<? extends NetworkExtras>, NetworkExtras> zzcjp;
    private final SearchAdRequest zzcjq;
    private final Set<String> zzcjr;
    private final Set<String> zzcjs;
    private final Date zzmu;
    private final Set<String> zzmw;
    private final Location zzmy;

    public zzza(zzyz zzyz) {
        this(zzyz, (SearchAdRequest) null);
    }

    public zzza(zzyz zzyz, SearchAdRequest searchAdRequest) {
        this.zzmu = zzyz.zzmu;
        this.zzche = zzyz.zzche;
        this.zzchl = zzyz.zzchl;
        this.zzcgz = zzyz.zzcgz;
        this.zzmw = Collections.unmodifiableSet(zzyz.zzcjj);
        this.zzmy = zzyz.zzmy;
        this.zzbnx = zzyz.zzbnx;
        this.zzcjk = zzyz.zzcjk;
        this.zzcjp = Collections.unmodifiableMap(zzyz.zzcjl);
        this.zzchc = zzyz.zzchc;
        this.zzchi = zzyz.zzchi;
        this.zzcjq = searchAdRequest;
        this.zzadl = zzyz.zzadl;
        this.zzcjr = Collections.unmodifiableSet(zzyz.zzcjm);
        this.zzchg = zzyz.zzchg;
        this.zzcjs = Collections.unmodifiableSet(zzyz.zzcjn);
        this.zzchk = zzyz.zzchk;
        this.zzcjo = zzyz.zzcjo;
        this.zzadm = zzyz.zzadm;
        this.zzadn = zzyz.zzadn;
        this.zzchm = zzyz.zzchm;
    }

    @Deprecated
    public final Date getBirthday() {
        return this.zzmu;
    }

    public final String getContentUrl() {
        return this.zzche;
    }

    public final Bundle getCustomEventExtrasBundle(Class<? extends CustomEvent> cls) {
        Bundle bundle = this.zzcjk.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter");
        if (bundle != null) {
            return bundle.getBundle(cls.getName());
        }
        return null;
    }

    public final Bundle getCustomTargeting() {
        return this.zzchg;
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

    public final boolean getManualImpressionsEnabled() {
        return this.zzbnx;
    }

    public final String getMaxAdContentRating() {
        return this.zzadn;
    }

    @Deprecated
    public final <T extends NetworkExtras> T getNetworkExtras(Class<T> cls) {
        return (NetworkExtras) this.zzcjp.get(cls);
    }

    public final Bundle getNetworkExtrasBundle(Class<? extends MediationExtrasReceiver> cls) {
        return this.zzcjk.getBundle(cls.getName());
    }

    public final String getPublisherProvidedId() {
        return this.zzchc;
    }

    @Deprecated
    public final boolean isDesignedForFamilies() {
        return this.zzchk;
    }

    public final boolean isTestDevice(Context context) {
        RequestConfiguration requestConfiguration = zzzd.zzrb().getRequestConfiguration();
        zzwq.zzqa();
        String zzbn = zzayr.zzbn(context);
        return this.zzcjr.contains(zzbn) || requestConfiguration.getTestDeviceIds().contains(zzbn);
    }

    public final List<String> zzqr() {
        return new ArrayList(this.zzchl);
    }

    public final String zzqs() {
        return this.zzchi;
    }

    public final SearchAdRequest zzqt() {
        return this.zzcjq;
    }

    public final Map<Class<? extends NetworkExtras>, NetworkExtras> zzqu() {
        return this.zzcjp;
    }

    public final Bundle zzqv() {
        return this.zzcjk;
    }

    public final int zzqw() {
        return this.zzadl;
    }

    public final Set<String> zzqx() {
        return this.zzcjs;
    }

    public final AdInfo zzqy() {
        return this.zzcjo;
    }

    public final int zzqz() {
        return this.zzadm;
    }

    public final int zzra() {
        return this.zzchm;
    }
}
