package com.google.android.gms.internal.ads;

import android.content.Context;
import android.location.Location;
import android.os.Bundle;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.search.SearchAdRequest;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Set;

public final class zzvl {
    public static final zzvl zzcho = new zzvl();

    @VisibleForTesting
    protected zzvl() {
    }

    public static zzauv zza(Context context, zzza zzza, String str) {
        return new zzauv(zza(context, zzza), str);
    }

    public static zzvk zza(Context context, zzza zzza) {
        List list;
        Context context2;
        zzvc zzvc;
        String str;
        zzza zzza2 = zzza;
        Date birthday = zzza.getBirthday();
        long time = birthday != null ? birthday.getTime() : -1;
        String contentUrl = zzza.getContentUrl();
        int gender = zzza.getGender();
        Set<String> keywords = zzza.getKeywords();
        if (!keywords.isEmpty()) {
            list = Collections.unmodifiableList(new ArrayList(keywords));
            context2 = context;
        } else {
            context2 = context;
            list = null;
        }
        boolean isTestDevice = zzza2.isTestDevice(context2);
        Location location = zzza.getLocation();
        Bundle networkExtrasBundle = zzza2.getNetworkExtrasBundle(AdMobAdapter.class);
        if (zzza.zzqy() != null) {
            String str2 = "";
            if (zzwq.zzqi().containsKey(zzza.zzqy().getQueryInfo())) {
                str2 = zzwq.zzqi().get(zzza.zzqy().getQueryInfo());
            }
            zzvc = new zzvc(zzza.zzqy().getAdString(), str2);
        } else {
            zzvc = null;
        }
        boolean manualImpressionsEnabled = zzza.getManualImpressionsEnabled();
        String publisherProvidedId = zzza.getPublisherProvidedId();
        SearchAdRequest zzqt = zzza.zzqt();
        zzaag zzaag = zzqt != null ? new zzaag(zzqt) : null;
        Context applicationContext = context.getApplicationContext();
        if (applicationContext != null) {
            String packageName = applicationContext.getPackageName();
            zzwq.zzqa();
            str = zzayr.zza(Thread.currentThread().getStackTrace(), packageName);
        } else {
            str = null;
        }
        boolean isDesignedForFamilies = zzza.isDesignedForFamilies();
        RequestConfiguration requestConfiguration = zzzd.zzrb().getRequestConfiguration();
        return new zzvk(8, time, networkExtrasBundle, gender, list, isTestDevice, Math.max(zzza.zzqw(), requestConfiguration.getTagForChildDirectedTreatment()), manualImpressionsEnabled, publisherProvidedId, zzaag, location, contentUrl, zzza.zzqv(), zzza.getCustomTargeting(), Collections.unmodifiableList(new ArrayList(zzza.zzqx())), zzza.zzqs(), str, isDesignedForFamilies, zzvc, Math.max(zzza.zzqz(), requestConfiguration.getTagForUnderAgeOfConsent()), (String) Collections.max(Arrays.asList(new String[]{zzza.getMaxAdContentRating(), requestConfiguration.getMaxAdContentRating()}), zzvo.zzchx), zzza.zzqr(), zzza.zzra());
    }

    static final /* synthetic */ int zzd(String str, String str2) {
        return RequestConfiguration.zzadp.indexOf(str) - RequestConfiguration.zzadp.indexOf(str2);
    }
}
