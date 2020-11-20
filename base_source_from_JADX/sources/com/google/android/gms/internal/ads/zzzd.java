package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.RemoteException;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.initialization.AdapterStatus;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.mediation.rtb.RtbAdapter;
import com.google.android.gms.ads.reward.RewardedVideoAd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import javax.annotation.concurrent.GuardedBy;

public class zzzd {
    @GuardedBy("InternalMobileAds.class")
    private static zzzd zzckc;
    private final Object lock = new Object();
    /* access modifiers changed from: private */
    public ArrayList<OnInitializationCompleteListener> zzckb = new ArrayList<>();
    @GuardedBy("lock")
    private zzxw zzckd;
    /* access modifiers changed from: private */
    public boolean zzcke = false;
    private RewardedVideoAd zzckf;
    private RequestConfiguration zzckg = new RequestConfiguration.Builder().build();
    private InitializationStatus zzckh;
    /* access modifiers changed from: private */
    public boolean zzzi = false;

    class zza extends zzajf {
        private zza() {
        }

        /* synthetic */ zza(zzzd zzzd, zzzh zzzh) {
            this();
        }

        public final void zze(List<zzaiz> list) {
            int i = 0;
            boolean unused = zzzd.this.zzcke = false;
            boolean unused2 = zzzd.this.zzzi = true;
            InitializationStatus zza = zzzd.zzd(list);
            ArrayList zza2 = zzzd.zzrb().zzckb;
            int size = zza2.size();
            while (i < size) {
                Object obj = zza2.get(i);
                i++;
                ((OnInitializationCompleteListener) obj).onInitializationComplete(zza);
            }
            zzzd.zzrb().zzckb.clear();
        }
    }

    private zzzd() {
    }

    @GuardedBy("lock")
    private final void zza(RequestConfiguration requestConfiguration) {
        try {
            this.zzckd.zza(new zzaae(requestConfiguration));
        } catch (RemoteException e) {
            zzaza.zzc("Unable to set request configuration parcel.", e);
        }
    }

    /* access modifiers changed from: private */
    public static InitializationStatus zzd(List<zzaiz> list) {
        HashMap hashMap = new HashMap();
        for (zzaiz next : list) {
            hashMap.put(next.zzdhn, new zzajh(next.zzdho ? AdapterStatus.State.READY : AdapterStatus.State.NOT_READY, next.description, next.zzdhp));
        }
        return new zzajg(hashMap);
    }

    @GuardedBy("lock")
    private final void zzg(Context context) {
        if (this.zzckd == null) {
            this.zzckd = (zzxw) new zzwj(zzwq.zzqb(), context).zzd(context, false);
        }
    }

    public static zzzd zzrb() {
        zzzd zzzd;
        synchronized (zzzd.class) {
            if (zzckc == null) {
                zzckc = new zzzd();
            }
            zzzd = zzckc;
        }
        return zzzd;
    }

    public final void disableMediationAdapterInitialization(Context context) {
        synchronized (this.lock) {
            zzg(context);
            try {
                this.zzckd.zzqn();
            } catch (RemoteException unused) {
                zzaza.zzey("Unable to disable mediation adapter initialization.");
            }
        }
    }

    public final InitializationStatus getInitializationStatus() {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzckd != null, "MobileAds.initialize() must be called prior to getting initialization status.");
            try {
                if (this.zzckh != null) {
                    InitializationStatus initializationStatus = this.zzckh;
                    return initializationStatus;
                }
                InitializationStatus zzd = zzd(this.zzckd.zzqm());
                return zzd;
            } catch (RemoteException unused) {
                zzaza.zzey("Unable to get Initialization status.");
                return null;
            }
        }
    }

    public final RequestConfiguration getRequestConfiguration() {
        return this.zzckg;
    }

    public final RewardedVideoAd getRewardedVideoAdInstance(Context context) {
        synchronized (this.lock) {
            if (this.zzckf != null) {
                RewardedVideoAd rewardedVideoAd = this.zzckf;
                return rewardedVideoAd;
            }
            this.zzckf = new zzaux(context, (zzaui) new zzwo(zzwq.zzqb(), context, new zzanj()).zzd(context, false));
            RewardedVideoAd rewardedVideoAd2 = this.zzckf;
            return rewardedVideoAd2;
        }
    }

    public final String getVersionString() {
        String zzhg;
        synchronized (this.lock) {
            Preconditions.checkState(this.zzckd != null, "MobileAds.initialize() must be called prior to getting version string.");
            try {
                zzhg = zzdwc.zzhg(this.zzckd.getVersionString());
            } catch (RemoteException e) {
                zzaza.zzc("Unable to get version string.", e);
                return "";
            }
        }
        return zzhg;
    }

    public final void openDebugMenu(Context context, String str) {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzckd != null, "MobileAds.initialize() must be called prior to opening debug menu.");
            try {
                this.zzckd.zzb(ObjectWrapper.wrap(context), str);
            } catch (RemoteException e) {
                zzaza.zzc("Unable to open debug menu.", e);
            }
        }
    }

    public final void registerRtbAdapter(Class<? extends RtbAdapter> cls) {
        synchronized (this.lock) {
            try {
                this.zzckd.zzce(cls.getCanonicalName());
            } catch (RemoteException e) {
                zzaza.zzc("Unable to register RtbAdapter", e);
            }
        }
    }

    public final void setAppMuted(boolean z) {
        synchronized (this.lock) {
            Preconditions.checkState(this.zzckd != null, "MobileAds.initialize() must be called prior to setting app muted state.");
            try {
                this.zzckd.setAppMuted(z);
            } catch (RemoteException e) {
                zzaza.zzc("Unable to set app mute state.", e);
            }
        }
    }

    public final void setAppVolume(float f) {
        boolean z = true;
        Preconditions.checkArgument(0.0f <= f && f <= 1.0f, "The app volume must be a value between 0 and 1 inclusive.");
        synchronized (this.lock) {
            if (this.zzckd == null) {
                z = false;
            }
            Preconditions.checkState(z, "MobileAds.initialize() must be called prior to setting the app volume.");
            try {
                this.zzckd.setAppVolume(f);
            } catch (RemoteException e) {
                zzaza.zzc("Unable to set app volume.", e);
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002f, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void setRequestConfiguration(com.google.android.gms.ads.RequestConfiguration r5) {
        /*
            r4 = this;
            if (r5 == 0) goto L_0x0004
            r0 = 1
            goto L_0x0005
        L_0x0004:
            r0 = 0
        L_0x0005:
            java.lang.String r1 = "Null passed to setRequestConfiguration."
            com.google.android.gms.common.internal.Preconditions.checkArgument(r0, r1)
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            com.google.android.gms.ads.RequestConfiguration r1 = r4.zzckg     // Catch:{ all -> 0x0030 }
            r4.zzckg = r5     // Catch:{ all -> 0x0030 }
            com.google.android.gms.internal.ads.zzxw r2 = r4.zzckd     // Catch:{ all -> 0x0030 }
            if (r2 != 0) goto L_0x0017
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0017:
            int r2 = r1.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            int r3 = r5.getTagForChildDirectedTreatment()     // Catch:{ all -> 0x0030 }
            if (r2 != r3) goto L_0x002b
            int r1 = r1.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            int r2 = r5.getTagForUnderAgeOfConsent()     // Catch:{ all -> 0x0030 }
            if (r1 == r2) goto L_0x002e
        L_0x002b:
            r4.zza((com.google.android.gms.ads.RequestConfiguration) r5)     // Catch:{ all -> 0x0030 }
        L_0x002e:
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            return
        L_0x0030:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0030 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzd.setRequestConfiguration(com.google.android.gms.ads.RequestConfiguration):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0022, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r5, java.lang.String r6, com.google.android.gms.ads.initialization.OnInitializationCompleteListener r7) {
        /*
            r4 = this;
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
            boolean r1 = r4.zzcke     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x0014
            if (r7 == 0) goto L_0x0012
            com.google.android.gms.internal.ads.zzzd r5 = zzrb()     // Catch:{ all -> 0x00c7 }
            java.util.ArrayList<com.google.android.gms.ads.initialization.OnInitializationCompleteListener> r5 = r5.zzckb     // Catch:{ all -> 0x00c7 }
            r5.add(r7)     // Catch:{ all -> 0x00c7 }
        L_0x0012:
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return
        L_0x0014:
            boolean r1 = r4.zzzi     // Catch:{ all -> 0x00c7 }
            if (r1 == 0) goto L_0x0023
            if (r7 == 0) goto L_0x0021
            com.google.android.gms.ads.initialization.InitializationStatus r5 = r4.getInitializationStatus()     // Catch:{ all -> 0x00c7 }
            r7.onInitializationComplete(r5)     // Catch:{ all -> 0x00c7 }
        L_0x0021:
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return
        L_0x0023:
            r1 = 1
            r4.zzcke = r1     // Catch:{ all -> 0x00c7 }
            if (r7 == 0) goto L_0x0031
            com.google.android.gms.internal.ads.zzzd r1 = zzrb()     // Catch:{ all -> 0x00c7 }
            java.util.ArrayList<com.google.android.gms.ads.initialization.OnInitializationCompleteListener> r1 = r1.zzckb     // Catch:{ all -> 0x00c7 }
            r1.add(r7)     // Catch:{ all -> 0x00c7 }
        L_0x0031:
            if (r5 == 0) goto L_0x00bf
            com.google.android.gms.internal.ads.zzand r1 = com.google.android.gms.internal.ads.zzand.zzuc()     // Catch:{ RemoteException -> 0x00b7 }
            r1.zzc(r5, r6)     // Catch:{ RemoteException -> 0x00b7 }
            r4.zzg(r5)     // Catch:{ RemoteException -> 0x00b7 }
            if (r7 == 0) goto L_0x004a
            com.google.android.gms.internal.ads.zzxw r1 = r4.zzckd     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzzd$zza r2 = new com.google.android.gms.internal.ads.zzzd$zza     // Catch:{ RemoteException -> 0x00b7 }
            r3 = 0
            r2.<init>(r4, r3)     // Catch:{ RemoteException -> 0x00b7 }
            r1.zza((com.google.android.gms.internal.ads.zzajc) r2)     // Catch:{ RemoteException -> 0x00b7 }
        L_0x004a:
            com.google.android.gms.internal.ads.zzxw r1 = r4.zzckd     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzanj r2 = new com.google.android.gms.internal.ads.zzanj     // Catch:{ RemoteException -> 0x00b7 }
            r2.<init>()     // Catch:{ RemoteException -> 0x00b7 }
            r1.zza((com.google.android.gms.internal.ads.zzani) r2)     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzxw r1 = r4.zzckd     // Catch:{ RemoteException -> 0x00b7 }
            r1.initialize()     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzxw r1 = r4.zzckd     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzzg r2 = new com.google.android.gms.internal.ads.zzzg     // Catch:{ RemoteException -> 0x00b7 }
            r2.<init>(r4, r5)     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.dynamic.IObjectWrapper r2 = com.google.android.gms.dynamic.ObjectWrapper.wrap(r2)     // Catch:{ RemoteException -> 0x00b7 }
            r1.zza(r6, r2)     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.ads.RequestConfiguration r6 = r4.zzckg     // Catch:{ RemoteException -> 0x00b7 }
            int r6 = r6.getTagForChildDirectedTreatment()     // Catch:{ RemoteException -> 0x00b7 }
            r1 = -1
            if (r6 != r1) goto L_0x0078
            com.google.android.gms.ads.RequestConfiguration r6 = r4.zzckg     // Catch:{ RemoteException -> 0x00b7 }
            int r6 = r6.getTagForUnderAgeOfConsent()     // Catch:{ RemoteException -> 0x00b7 }
            if (r6 == r1) goto L_0x007d
        L_0x0078:
            com.google.android.gms.ads.RequestConfiguration r6 = r4.zzckg     // Catch:{ RemoteException -> 0x00b7 }
            r4.zza((com.google.android.gms.ads.RequestConfiguration) r6)     // Catch:{ RemoteException -> 0x00b7 }
        L_0x007d:
            com.google.android.gms.internal.ads.zzabf.initialize(r5)     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzabf.zzcuy     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzabb r6 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ RemoteException -> 0x00b7 }
            java.lang.Object r5 = r6.zzd(r5)     // Catch:{ RemoteException -> 0x00b7 }
            java.lang.Boolean r5 = (java.lang.Boolean) r5     // Catch:{ RemoteException -> 0x00b7 }
            boolean r5 = r5.booleanValue()     // Catch:{ RemoteException -> 0x00b7 }
            if (r5 != 0) goto L_0x00bd
            java.lang.String r5 = r4.getVersionString()     // Catch:{ RemoteException -> 0x00b7 }
            java.lang.String r6 = "0"
            boolean r5 = r5.endsWith(r6)     // Catch:{ RemoteException -> 0x00b7 }
            if (r5 != 0) goto L_0x00bd
            java.lang.String r5 = "Google Mobile Ads SDK initialization functionality unavailable for this session. Ad requests can be made at any time."
            com.google.android.gms.internal.ads.zzaza.zzey(r5)     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzzi r5 = new com.google.android.gms.internal.ads.zzzi     // Catch:{ RemoteException -> 0x00b7 }
            r5.<init>(r4)     // Catch:{ RemoteException -> 0x00b7 }
            r4.zzckh = r5     // Catch:{ RemoteException -> 0x00b7 }
            if (r7 == 0) goto L_0x00bd
            android.os.Handler r5 = com.google.android.gms.internal.ads.zzayr.zzzz     // Catch:{ RemoteException -> 0x00b7 }
            com.google.android.gms.internal.ads.zzzf r6 = new com.google.android.gms.internal.ads.zzzf     // Catch:{ RemoteException -> 0x00b7 }
            r6.<init>(r4, r7)     // Catch:{ RemoteException -> 0x00b7 }
            r5.post(r6)     // Catch:{ RemoteException -> 0x00b7 }
            goto L_0x00bd
        L_0x00b7:
            r5 = move-exception
            java.lang.String r6 = "MobileAdsSettingManager initialization failed"
            com.google.android.gms.internal.ads.zzaza.zzd(r6, r5)     // Catch:{ all -> 0x00c7 }
        L_0x00bd:
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            return
        L_0x00bf:
            java.lang.IllegalArgumentException r5 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x00c7 }
            java.lang.String r6 = "Context cannot be null."
            r5.<init>(r6)     // Catch:{ all -> 0x00c7 }
            throw r5     // Catch:{ all -> 0x00c7 }
        L_0x00c7:
            r5 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00c7 }
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzzd.zza(android.content.Context, java.lang.String, com.google.android.gms.ads.initialization.OnInitializationCompleteListener):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(OnInitializationCompleteListener onInitializationCompleteListener) {
        onInitializationCompleteListener.onInitializationComplete(this.zzckh);
    }

    public final float zzqk() {
        float f;
        synchronized (this.lock) {
            f = 1.0f;
            if (this.zzckd == null) {
                return 1.0f;
            }
            try {
                f = this.zzckd.zzqk();
            } catch (RemoteException e) {
                zzaza.zzc("Unable to get app volume.", e);
            }
        }
        return f;
    }

    public final boolean zzql() {
        boolean z;
        synchronized (this.lock) {
            z = false;
            if (this.zzckd == null) {
                return false;
            }
            try {
                z = this.zzckd.zzql();
            } catch (RemoteException e) {
                zzaza.zzc("Unable to get app mute state.", e);
            }
        }
        return z;
    }
}
