package com.google.android.gms.internal.ads;

import android.location.Location;
import android.os.Bundle;
import android.text.TextUtils;
import com.google.ads.mediation.admob.AdMobAdapter;
import com.google.android.gms.ads.mediation.MediationExtrasReceiver;
import com.google.android.gms.ads.mediation.NetworkExtras;
import com.google.android.gms.ads.mediation.admob.AdMobExtras;
import com.google.android.gms.ads.mediation.customevent.CustomEvent;
import com.google.android.gms.ads.query.AdInfo;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public final class zzyz {
    /* access modifiers changed from: private */
    public int zzadl = -1;
    /* access modifiers changed from: private */
    public int zzadm = -1;
    /* access modifiers changed from: private */
    public String zzadn;
    /* access modifiers changed from: private */
    public boolean zzbnx = false;
    /* access modifiers changed from: private */
    public int zzcgz = -1;
    /* access modifiers changed from: private */
    public String zzchc;
    /* access modifiers changed from: private */
    public String zzche;
    /* access modifiers changed from: private */
    public final Bundle zzchg = new Bundle();
    /* access modifiers changed from: private */
    public String zzchi;
    /* access modifiers changed from: private */
    public boolean zzchk;
    /* access modifiers changed from: private */
    public final List<String> zzchl = new ArrayList();
    /* access modifiers changed from: private */
    public int zzchm = 60000;
    /* access modifiers changed from: private */
    public final HashSet<String> zzcjj = new HashSet<>();
    /* access modifiers changed from: private */
    public final Bundle zzcjk = new Bundle();
    /* access modifiers changed from: private */
    public final HashMap<Class<? extends NetworkExtras>, NetworkExtras> zzcjl = new HashMap<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcjm = new HashSet<>();
    /* access modifiers changed from: private */
    public final HashSet<String> zzcjn = new HashSet<>();
    /* access modifiers changed from: private */
    public AdInfo zzcjo;
    /* access modifiers changed from: private */
    public Date zzmu;
    /* access modifiers changed from: private */
    public Location zzmy;

    public final void setManualImpressionsEnabled(boolean z) {
        this.zzbnx = z;
    }

    public final void zza(Location location) {
        this.zzmy = location;
    }

    @Deprecated
    public final void zza(NetworkExtras networkExtras) {
        if (networkExtras instanceof AdMobExtras) {
            zza(AdMobAdapter.class, ((AdMobExtras) networkExtras).getExtras());
        } else {
            this.zzcjl.put(networkExtras.getClass(), networkExtras);
        }
    }

    public final void zza(AdInfo adInfo) {
        this.zzcjo = adInfo;
    }

    public final void zza(Class<? extends MediationExtrasReceiver> cls, Bundle bundle) {
        this.zzcjk.putBundle(cls.getName(), bundle);
    }

    @Deprecated
    public final void zza(Date date) {
        this.zzmu = date;
    }

    @Deprecated
    public final void zzaa(boolean z) {
        this.zzchk = z;
    }

    public final void zzb(Class<? extends CustomEvent> cls, Bundle bundle) {
        if (this.zzcjk.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter") == null) {
            this.zzcjk.putBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter", new Bundle());
        }
        this.zzcjk.getBundle("com.google.android.gms.ads.mediation.customevent.CustomEventAdapter").putBundle(cls.getName(), bundle);
    }

    public final void zzc(List<String> list) {
        this.zzchl.clear();
        for (String next : list) {
            if (TextUtils.isEmpty(next)) {
                zzaza.zzfa("neighboring content URL should not be null or empty");
            } else {
                this.zzchl.add(next);
            }
        }
    }

    public final void zzcf(String str) {
        this.zzcjj.add(str);
    }

    public final void zzcg(String str) {
        this.zzcjm.add(str);
    }

    public final void zzch(String str) {
        this.zzcjm.remove(str);
    }

    public final void zzci(String str) {
        this.zzche = str;
    }

    public final void zzcj(String str) {
        this.zzchc = str;
    }

    public final void zzck(String str) {
        this.zzchi = str;
    }

    public final void zzcl(String str) {
        this.zzcjn.add(str);
    }

    @Deprecated
    public final void zzcm(String str) {
        if ("G".equals(str) || "PG".equals(str) || "T".equals(str) || "MA".equals(str)) {
            this.zzadn = str;
        }
    }

    @Deprecated
    public final void zzcw(int i) {
        this.zzcgz = i;
    }

    @Deprecated
    public final void zzcx(int i) {
        if (i == -1 || i == 0 || i == 1) {
            this.zzadm = i;
        }
    }

    public final void zzcy(int i) {
        this.zzchm = i;
    }

    public final void zze(String str, String str2) {
        this.zzchg.putString(str, str2);
    }

    @Deprecated
    public final void zzz(boolean z) {
        this.zzadl = z ? 1 : 0;
    }
}
