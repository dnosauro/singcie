package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzax;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GoogleApiAvailabilityLight;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.wrappers.Wrappers;
import com.google.android.gms.internal.ads.zzeoe;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzawh implements zzawq {
    /* access modifiers changed from: private */
    public static List<Future<Void>> zzdym = Collections.synchronizedList(new ArrayList());
    private final Context context;
    private final Object lock = new Object();
    private final zzawp zzdvg;
    @GuardedBy("lock")
    private final zzeoe.zzb.C3711zzb zzdyn;
    @GuardedBy("lock")
    private final LinkedHashMap<String, zzeoe.zzb.zzh.C3717zzb> zzdyo;
    @GuardedBy("lock")
    private final List<String> zzdyp = new ArrayList();
    @GuardedBy("lock")
    private final List<String> zzdyq = new ArrayList();
    private final zzaws zzdyr;
    private boolean zzdys;
    private final zzawv zzdyt;
    private HashSet<String> zzdyu = new HashSet<>();
    private boolean zzdyv = false;
    private boolean zzdyw = false;
    private boolean zzdyx = false;

    public zzawh(Context context2, zzazh zzazh, zzawp zzawp, String str, zzaws zzaws) {
        Preconditions.checkNotNull(zzawp, "SafeBrowsing config is not present.");
        this.context = context2.getApplicationContext() != null ? context2.getApplicationContext() : context2;
        this.zzdyo = new LinkedHashMap<>();
        this.zzdyr = zzaws;
        this.zzdvg = zzawp;
        for (String lowerCase : this.zzdvg.zzdzf) {
            this.zzdyu.add(lowerCase.toLowerCase(Locale.ENGLISH));
        }
        this.zzdyu.remove("cookie".toLowerCase(Locale.ENGLISH));
        zzeoe.zzb.C3711zzb zzbkw = zzeoe.zzb.zzbkw();
        zzbkw.zzb(zzeoe.zzb.zzg.OCTAGON_AD);
        zzbkw.zzhy(str);
        zzbkw.zzhz(str);
        zzeoe.zzb.zza.C3710zza zzbky = zzeoe.zzb.zza.zzbky();
        if (this.zzdvg.zzdzb != null) {
            zzbky.zzib(this.zzdvg.zzdzb);
        }
        zzbkw.zzb((zzeoe.zzb.zza) ((zzekh) zzbky.zzbhv()));
        zzeoe.zzb.zzi.zza zzbw = zzeoe.zzb.zzi.zzbln().zzbw(Wrappers.packageManager(this.context).isCallerInstantApp());
        if (zzazh.zzbrf != null) {
            zzbw.zzig(zzazh.zzbrf);
        }
        long apkVersion = (long) GoogleApiAvailabilityLight.getInstance().getApkVersion(this.context);
        if (apkVersion > 0) {
            zzbw.zzfs(apkVersion);
        }
        zzbkw.zzb((zzeoe.zzb.zzi) ((zzekh) zzbw.zzbhv()));
        this.zzdyn = zzbkw;
        this.zzdyt = new zzawv(this.context, this.zzdvg.zzdzi, this);
    }

    private final zzeoe.zzb.zzh.C3717zzb zzdz(String str) {
        zzeoe.zzb.zzh.C3717zzb zzb;
        synchronized (this.lock) {
            zzb = this.zzdyo.get(str);
        }
        return zzb;
    }

    static final /* synthetic */ Void zzea(String str) {
        return null;
    }

    private final zzdyz<Void> zzwg() {
        zzdyz<Void> zzb;
        if (!((this.zzdys && this.zzdvg.zzdzh) || (this.zzdyx && this.zzdvg.zzdzg) || (!this.zzdys && this.zzdvg.zzdze))) {
            return zzdyr.zzag(null);
        }
        synchronized (this.lock) {
            for (zzeoe.zzb.zzh.C3717zzb zzbhv : this.zzdyo.values()) {
                this.zzdyn.zzb((zzeoe.zzb.zzh) ((zzekh) zzbhv.zzbhv()));
            }
            this.zzdyn.zzo(this.zzdyp);
            this.zzdyn.zzp(this.zzdyq);
            if (zzawr.isEnabled()) {
                String url = this.zzdyn.getUrl();
                String zzbku = this.zzdyn.zzbku();
                StringBuilder sb = new StringBuilder(String.valueOf(url).length() + 53 + String.valueOf(zzbku).length());
                sb.append("Sending SB report\n  url: ");
                sb.append(url);
                sb.append("\n  clickUrl: ");
                sb.append(zzbku);
                sb.append("\n  resources: \n");
                StringBuilder sb2 = new StringBuilder(sb.toString());
                for (zzeoe.zzb.zzh next : this.zzdyn.zzbkt()) {
                    sb2.append("    [");
                    sb2.append(next.zzblk());
                    sb2.append("] ");
                    sb2.append(next.getUrl());
                }
                zzawr.zzeb(sb2.toString());
            }
            zzdyz<String> zza = new zzax(this.context).zza(1, this.zzdvg.zzdzc, (Map<String, String>) null, ((zzeoe.zzb) ((zzekh) this.zzdyn.zzbhv())).toByteArray());
            if (zzawr.isEnabled()) {
                zza.addListener(zzawi.zzdyy, zzazj.zzegp);
            }
            zzb = zzdyr.zzb(zza, zzawl.zzdza, (Executor) zzazj.zzegu);
        }
        return zzb;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Bitmap bitmap) {
        zzejh zzbft = zzeiu.zzbft();
        bitmap.compress(Bitmap.CompressFormat.PNG, 0, zzbft);
        synchronized (this.lock) {
            this.zzdyn.zzb((zzeoe.zzb.zzf) ((zzekh) zzeoe.zzb.zzf.zzbli().zzas(zzbft.zzbfg()).zzic("image/png").zzb(zzeoe.zzb.zzf.zza.TYPE_CREATIVE).zzbhv()));
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(java.lang.String r7, java.util.Map<java.lang.String, java.lang.String> r8, int r9) {
        /*
            r6 = this;
            java.lang.Object r0 = r6.lock
            monitor-enter(r0)
            r1 = 3
            if (r9 != r1) goto L_0x0009
            r2 = 1
            r6.zzdyx = r2     // Catch:{ all -> 0x00bd }
        L_0x0009:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb> r2 = r6.zzdyo     // Catch:{ all -> 0x00bd }
            boolean r2 = r2.containsKey(r7)     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x0024
            if (r9 != r1) goto L_0x0022
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb> r8 = r6.zzdyo     // Catch:{ all -> 0x00bd }
            java.lang.Object r7 = r8.get(r7)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb r7 = (com.google.android.gms.internal.ads.zzeoe.zzb.zzh.C3717zzb) r7     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zza r8 = com.google.android.gms.internal.ads.zzeoe.zzb.zzh.zza.zzia(r9)     // Catch:{ all -> 0x00bd }
            r7.zzb((com.google.android.gms.internal.ads.zzeoe.zzb.zzh.zza) r8)     // Catch:{ all -> 0x00bd }
        L_0x0022:
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x0024:
            com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb r1 = com.google.android.gms.internal.ads.zzeoe.zzb.zzh.zzbll()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zza r9 = com.google.android.gms.internal.ads.zzeoe.zzb.zzh.zza.zzia(r9)     // Catch:{ all -> 0x00bd }
            if (r9 == 0) goto L_0x0031
            r1.zzb((com.google.android.gms.internal.ads.zzeoe.zzb.zzh.zza) r9)     // Catch:{ all -> 0x00bd }
        L_0x0031:
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb> r9 = r6.zzdyo     // Catch:{ all -> 0x00bd }
            int r9 = r9.size()     // Catch:{ all -> 0x00bd }
            r1.zzib(r9)     // Catch:{ all -> 0x00bd }
            r1.zzie(r7)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzd$zzb r9 = com.google.android.gms.internal.ads.zzeoe.zzb.zzd.zzbld()     // Catch:{ all -> 0x00bd }
            java.util.HashSet<java.lang.String> r2 = r6.zzdyu     // Catch:{ all -> 0x00bd }
            int r2 = r2.size()     // Catch:{ all -> 0x00bd }
            if (r2 <= 0) goto L_0x00ab
            if (r8 == 0) goto L_0x00ab
            java.util.Set r8 = r8.entrySet()     // Catch:{ all -> 0x00bd }
            java.util.Iterator r8 = r8.iterator()     // Catch:{ all -> 0x00bd }
        L_0x0053:
            boolean r2 = r8.hasNext()     // Catch:{ all -> 0x00bd }
            if (r2 == 0) goto L_0x00ab
            java.lang.Object r2 = r8.next()     // Catch:{ all -> 0x00bd }
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2     // Catch:{ all -> 0x00bd }
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00bd }
            if (r3 == 0) goto L_0x006c
            java.lang.Object r3 = r2.getKey()     // Catch:{ all -> 0x00bd }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x00bd }
            goto L_0x006e
        L_0x006c:
            java.lang.String r3 = ""
        L_0x006e:
            java.lang.Object r4 = r2.getValue()     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x007b
            java.lang.Object r2 = r2.getValue()     // Catch:{ all -> 0x00bd }
            java.lang.String r2 = (java.lang.String) r2     // Catch:{ all -> 0x00bd }
            goto L_0x007d
        L_0x007b:
            java.lang.String r2 = ""
        L_0x007d:
            java.util.Locale r4 = java.util.Locale.ENGLISH     // Catch:{ all -> 0x00bd }
            java.lang.String r4 = r3.toLowerCase(r4)     // Catch:{ all -> 0x00bd }
            java.util.HashSet<java.lang.String> r5 = r6.zzdyu     // Catch:{ all -> 0x00bd }
            boolean r4 = r5.contains(r4)     // Catch:{ all -> 0x00bd }
            if (r4 == 0) goto L_0x0053
            com.google.android.gms.internal.ads.zzeoe$zzb$zzc$zza r4 = com.google.android.gms.internal.ads.zzeoe.zzb.zzc.zzblb()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeiu r3 = com.google.android.gms.internal.ads.zzeiu.zzhs(r3)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzc$zza r3 = r4.zzap(r3)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeiu r2 = com.google.android.gms.internal.ads.zzeiu.zzhs(r2)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzc$zza r2 = r3.zzaq(r2)     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzels r2 = r2.zzbhv()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzekh r2 = (com.google.android.gms.internal.ads.zzekh) r2     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzc r2 = (com.google.android.gms.internal.ads.zzeoe.zzb.zzc) r2     // Catch:{ all -> 0x00bd }
            r9.zzb(r2)     // Catch:{ all -> 0x00bd }
            goto L_0x0053
        L_0x00ab:
            com.google.android.gms.internal.ads.zzels r8 = r9.zzbhv()     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzekh r8 = (com.google.android.gms.internal.ads.zzekh) r8     // Catch:{ all -> 0x00bd }
            com.google.android.gms.internal.ads.zzeoe$zzb$zzd r8 = (com.google.android.gms.internal.ads.zzeoe.zzb.zzd) r8     // Catch:{ all -> 0x00bd }
            r1.zzb((com.google.android.gms.internal.ads.zzeoe.zzb.zzd) r8)     // Catch:{ all -> 0x00bd }
            java.util.LinkedHashMap<java.lang.String, com.google.android.gms.internal.ads.zzeoe$zzb$zzh$zzb> r8 = r6.zzdyo     // Catch:{ all -> 0x00bd }
            r8.put(r7, r1)     // Catch:{ all -> 0x00bd }
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            return
        L_0x00bd:
            r7 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x00bd }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzawh.zza(java.lang.String, java.util.Map, int):void");
    }

    public final String[] zza(String[] strArr) {
        return (String[]) this.zzdyt.zzb(strArr).toArray(new String[0]);
    }

    public final void zzdw(String str) {
        synchronized (this.lock) {
            if (str == null) {
                this.zzdyn.zzbla();
            } else {
                this.zzdyn.zzia(str);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzdx(String str) {
        synchronized (this.lock) {
            this.zzdyp.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final void zzdy(String str) {
        synchronized (this.lock) {
            this.zzdyq.add(str);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzi(Map map) {
        if (map != null) {
            try {
                for (String str : map.keySet()) {
                    JSONArray optJSONArray = new JSONObject((String) map.get(str)).optJSONArray("matches");
                    if (optJSONArray != null) {
                        synchronized (this.lock) {
                            int length = optJSONArray.length();
                            zzeoe.zzb.zzh.C3717zzb zzdz = zzdz(str);
                            if (zzdz == null) {
                                String valueOf = String.valueOf(str);
                                zzawr.zzeb(valueOf.length() != 0 ? "Cannot find the corresponding resource object for ".concat(valueOf) : new String("Cannot find the corresponding resource object for "));
                            } else {
                                boolean z = false;
                                for (int i = 0; i < length; i++) {
                                    zzdz.zzif(optJSONArray.getJSONObject(i).getString("threat_type"));
                                }
                                boolean z2 = this.zzdys;
                                if (length > 0) {
                                    z = true;
                                }
                                this.zzdys = z | z2;
                            }
                        }
                    }
                }
            } catch (JSONException e) {
                if (zzadh.zzddl.get().booleanValue()) {
                    zzd.zzb("Failed to get SafeBrowsing metadata", e);
                }
                return zzdyr.immediateFailedFuture(new Exception("Safebrowsing report transmission failed."));
            }
        }
        if (this.zzdys) {
            synchronized (this.lock) {
                this.zzdyn.zzb(zzeoe.zzb.zzg.OCTAGON_AD_SB_MATCH);
            }
        }
        return zzwg();
    }

    public final void zzl(View view) {
        if (this.zzdvg.zzdzd && !this.zzdyw) {
            zzp.zzkq();
            Bitmap zzn = zzm.zzn(view);
            if (zzn == null) {
                zzawr.zzeb("Failed to capture the webview bitmap.");
                return;
            }
            this.zzdyw = true;
            zzm.zzc((Runnable) new zzawg(this, zzn));
        }
    }

    public final zzawp zzwc() {
        return this.zzdvg;
    }

    public final boolean zzwd() {
        return PlatformVersion.isAtLeastKitKat() && this.zzdvg.zzdzd && !this.zzdyw;
    }

    public final void zzwe() {
        this.zzdyv = true;
    }

    public final void zzwf() {
        synchronized (this.lock) {
            zzdyz<O> zzb = zzdyr.zzb(this.zzdyr.zza(this.context, this.zzdyo.keySet()), new zzawj(this), (Executor) zzazj.zzegu);
            zzdyz<O> zza = zzdyr.zza(zzb, 10, TimeUnit.SECONDS, zzazj.zzegs);
            zzdyr.zza(zzb, new zzawk(this, zza), zzazj.zzegu);
            zzdym.add(zza);
        }
    }
}
