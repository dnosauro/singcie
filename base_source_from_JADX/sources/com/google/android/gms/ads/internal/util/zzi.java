package com.google.android.gms.ads.internal.util;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Looper;
import android.security.NetworkSecurityPolicy;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.internal.ads.zzacv;
import com.google.android.gms.internal.ads.zzayh;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzdyz;
import com.google.android.gms.internal.ads.zzrk;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzi implements zzf {
    private final Object lock = new Object();
    @GuardedBy("lock")
    private SharedPreferences zzclm;
    @GuardedBy("lock")
    private boolean zzdsy = true;
    @GuardedBy("lock")
    private boolean zzdtl = false;
    @GuardedBy("lock")
    private String zzdto = "";
    @GuardedBy("lock")
    private boolean zzdux = true;
    @GuardedBy("lock")
    private boolean zzdvi = true;
    private boolean zzecg;
    private final List<Runnable> zzech = new ArrayList();
    private zzdyz<?> zzeci;
    @GuardedBy("lock")
    private zzrk zzecj = null;
    @GuardedBy("lock")
    private SharedPreferences.Editor zzeck;
    @GuardedBy("lock")
    private boolean zzecl = false;
    @GuardedBy("lock")
    private String zzecm;
    @GuardedBy("lock")
    private String zzecn;
    @GuardedBy("lock")
    private long zzeco = 0;
    @GuardedBy("lock")
    private long zzecp = 0;
    @GuardedBy("lock")
    private long zzecq = 0;
    @GuardedBy("lock")
    private int zzecr = -1;
    @GuardedBy("lock")
    private int zzecs = 0;
    @GuardedBy("lock")
    private Set<String> zzect = Collections.emptySet();
    @GuardedBy("lock")
    private JSONObject zzecu = new JSONObject();
    @GuardedBy("lock")
    private String zzecv = null;
    @GuardedBy("lock")
    private int zzecw = -1;

    private final void zzyc() {
        zzdyz<?> zzdyz = this.zzeci;
        if (zzdyz != null && !zzdyz.isDone()) {
            try {
                this.zzeci.get(1, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                zzd.zzd("Interrupted while waiting for preferences loaded.", e);
            } catch (CancellationException | ExecutionException | TimeoutException e2) {
                zzd.zzc("Fail to initialize AdSharedPreferenceManager.", e2);
            }
        }
    }

    private final void zzyd() {
        zzazj.zzegp.execute(new zzk(this));
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x000f, code lost:
        r0 = java.lang.String.valueOf("admob__");
        r4 = java.lang.String.valueOf(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001d, code lost:
        if (r4.length() == 0) goto L_0x0024;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x001f, code lost:
        r4 = r0.concat(r4);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0024, code lost:
        r4 = new java.lang.String(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        r2.zzeci = com.google.android.gms.internal.ads.zzazj.zzegp.zzg(new com.google.android.gms.ads.internal.util.zzh(r2, r3, r4));
        r2.zzecg = r5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0038, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:0x000a, code lost:
        if (r4 != null) goto L_0x000f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x000c, code lost:
        r4 = "admob";
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(android.content.Context r3, java.lang.String r4, boolean r5) {
        /*
            r2 = this;
            java.lang.Object r0 = r2.lock
            monitor-enter(r0)
            android.content.SharedPreferences r1 = r2.zzclm     // Catch:{ all -> 0x0039 }
            if (r1 == 0) goto L_0x0009
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            return
        L_0x0009:
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            if (r4 != 0) goto L_0x000f
            java.lang.String r4 = "admob"
            goto L_0x0029
        L_0x000f:
            java.lang.String r0 = "admob__"
            java.lang.String r0 = java.lang.String.valueOf(r0)
            java.lang.String r4 = java.lang.String.valueOf(r4)
            int r1 = r4.length()
            if (r1 == 0) goto L_0x0024
            java.lang.String r4 = r0.concat(r4)
            goto L_0x0029
        L_0x0024:
            java.lang.String r4 = new java.lang.String
            r4.<init>(r0)
        L_0x0029:
            com.google.android.gms.internal.ads.zzdzc r0 = com.google.android.gms.internal.ads.zzazj.zzegp
            com.google.android.gms.ads.internal.util.zzh r1 = new com.google.android.gms.ads.internal.util.zzh
            r1.<init>(r2, r3, r4)
            com.google.android.gms.internal.ads.zzdyz r3 = r0.zzg(r1)
            r2.zzeci = r3
            r2.zzecg = r5
            return
        L_0x0039:
            r3 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0039 }
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzi.zza(android.content.Context, java.lang.String, boolean):void");
    }

    public final void zza(String str, String str2, boolean z) {
        zzyc();
        synchronized (this.lock) {
            JSONArray optJSONArray = this.zzecu.optJSONArray(str);
            if (optJSONArray == null) {
                optJSONArray = new JSONArray();
            }
            int length = optJSONArray.length();
            int i = 0;
            while (true) {
                if (i < optJSONArray.length()) {
                    JSONObject optJSONObject = optJSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        if (!str2.equals(optJSONObject.optString("template_id"))) {
                            i++;
                        } else if (!z || !optJSONObject.optBoolean("uses_media_view", false)) {
                            length = i;
                        } else {
                            return;
                        }
                    } else {
                        return;
                    }
                }
            }
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("template_id", str2);
                jSONObject.put("uses_media_view", z);
                jSONObject.put("timestamp_ms", zzp.zzkx().currentTimeMillis());
                optJSONArray.put(length, jSONObject);
                this.zzecu.put(str, optJSONArray);
            } catch (JSONException e) {
                zzd.zzd("Could not update native advanced settings", e);
            }
            if (this.zzeck != null) {
                this.zzeck.putString("native_advanced_settings", this.zzecu.toString());
                this.zzeck.apply();
            }
            zzyd();
        }
    }

    public final void zzao(boolean z) {
        zzyc();
        synchronized (this.lock) {
            if (this.zzdux != z) {
                this.zzdux = z;
                if (this.zzeck != null) {
                    this.zzeck.putBoolean("content_url_opted_out", z);
                    this.zzeck.apply();
                }
                zzyd();
            }
        }
    }

    public final void zzap(boolean z) {
        zzyc();
        synchronized (this.lock) {
            if (this.zzdvi != z) {
                this.zzdvi = z;
                if (this.zzeck != null) {
                    this.zzeck.putBoolean("content_vertical_opted_out", z);
                    this.zzeck.apply();
                }
                zzyd();
            }
        }
    }

    public final void zzb(Runnable runnable) {
        this.zzech.add(runnable);
    }

    public final void zzde(int i) {
        zzyc();
        synchronized (this.lock) {
            if (this.zzecs != i) {
                this.zzecs = i;
                if (this.zzeck != null) {
                    this.zzeck.putInt("version_code", i);
                    this.zzeck.apply();
                }
                zzyd();
            }
        }
    }

    public final void zzdf(int i) {
        zzyc();
        synchronized (this.lock) {
            if (this.zzecr != i) {
                this.zzecr = i;
                if (this.zzeck != null) {
                    this.zzeck.putInt("request_in_session_count", i);
                    this.zzeck.apply();
                }
                zzyd();
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzef(java.lang.String r4) {
        /*
            r3 = this;
            r3.zzyc()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0028
            java.lang.String r1 = r3.zzecm     // Catch:{ all -> 0x002a }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0011
            goto L_0x0028
        L_0x0011:
            r3.zzecm = r4     // Catch:{ all -> 0x002a }
            android.content.SharedPreferences$Editor r1 = r3.zzeck     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzeck     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "content_url_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x002a }
            android.content.SharedPreferences$Editor r4 = r3.zzeck     // Catch:{ all -> 0x002a }
            r4.apply()     // Catch:{ all -> 0x002a }
        L_0x0023:
            r3.zzyd()     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzi.zzef(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0029, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzeg(java.lang.String r4) {
        /*
            r3 = this;
            r3.zzyc()
            java.lang.Object r0 = r3.lock
            monitor-enter(r0)
            if (r4 == 0) goto L_0x0028
            java.lang.String r1 = r3.zzecn     // Catch:{ all -> 0x002a }
            boolean r1 = r4.equals(r1)     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0011
            goto L_0x0028
        L_0x0011:
            r3.zzecn = r4     // Catch:{ all -> 0x002a }
            android.content.SharedPreferences$Editor r1 = r3.zzeck     // Catch:{ all -> 0x002a }
            if (r1 == 0) goto L_0x0023
            android.content.SharedPreferences$Editor r1 = r3.zzeck     // Catch:{ all -> 0x002a }
            java.lang.String r2 = "content_vertical_hashes"
            r1.putString(r2, r4)     // Catch:{ all -> 0x002a }
            android.content.SharedPreferences$Editor r4 = r3.zzeck     // Catch:{ all -> 0x002a }
            r4.apply()     // Catch:{ all -> 0x002a }
        L_0x0023:
            r3.zzyd()     // Catch:{ all -> 0x002a }
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x0028:
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            return
        L_0x002a:
            r4 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x002a }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzi.zzeg(java.lang.String):void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x0050, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzeh(java.lang.String r6) {
        /*
            r5 = this;
            r5.zzyc()
            java.lang.Object r0 = r5.lock
            monitor-enter(r0)
            com.google.android.gms.common.util.Clock r1 = com.google.android.gms.ads.internal.zzp.zzkx()     // Catch:{ all -> 0x0051 }
            long r1 = r1.currentTimeMillis()     // Catch:{ all -> 0x0051 }
            r5.zzeco = r1     // Catch:{ all -> 0x0051 }
            if (r6 == 0) goto L_0x004f
            java.lang.String r3 = r5.zzdto     // Catch:{ all -> 0x0051 }
            boolean r3 = r6.equals(r3)     // Catch:{ all -> 0x0051 }
            if (r3 == 0) goto L_0x001b
            goto L_0x004f
        L_0x001b:
            r5.zzdto = r6     // Catch:{ all -> 0x0051 }
            android.content.SharedPreferences$Editor r3 = r5.zzeck     // Catch:{ all -> 0x0051 }
            if (r3 == 0) goto L_0x0034
            android.content.SharedPreferences$Editor r3 = r5.zzeck     // Catch:{ all -> 0x0051 }
            java.lang.String r4 = "app_settings_json"
            r3.putString(r4, r6)     // Catch:{ all -> 0x0051 }
            android.content.SharedPreferences$Editor r6 = r5.zzeck     // Catch:{ all -> 0x0051 }
            java.lang.String r3 = "app_settings_last_update_ms"
            r6.putLong(r3, r1)     // Catch:{ all -> 0x0051 }
            android.content.SharedPreferences$Editor r6 = r5.zzeck     // Catch:{ all -> 0x0051 }
            r6.apply()     // Catch:{ all -> 0x0051 }
        L_0x0034:
            r5.zzyd()     // Catch:{ all -> 0x0051 }
            java.util.List<java.lang.Runnable> r6 = r5.zzech     // Catch:{ all -> 0x0051 }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x0051 }
        L_0x003d:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x0051 }
            if (r1 == 0) goto L_0x004d
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x0051 }
            java.lang.Runnable r1 = (java.lang.Runnable) r1     // Catch:{ all -> 0x0051 }
            r1.run()     // Catch:{ all -> 0x0051 }
            goto L_0x003d
        L_0x004d:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x004f:
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            return
        L_0x0051:
            r6 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0051 }
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.util.zzi.zzeh(java.lang.String):void");
    }

    public final void zzei(String str) {
        zzyc();
        synchronized (this.lock) {
            if (!TextUtils.equals(this.zzecv, str)) {
                this.zzecv = str;
                if (this.zzeck != null) {
                    this.zzeck.putString("display_cutout", str);
                    this.zzeck.apply();
                }
                zzyd();
            }
        }
    }

    public final void zzez(long j) {
        zzyc();
        synchronized (this.lock) {
            if (this.zzecp != j) {
                this.zzecp = j;
                if (this.zzeck != null) {
                    this.zzeck.putLong("app_last_background_time_ms", j);
                    this.zzeck.apply();
                }
                zzyd();
            }
        }
    }

    public final void zzfa(long j) {
        zzyc();
        synchronized (this.lock) {
            if (this.zzecq != j) {
                this.zzecq = j;
                if (this.zzeck != null) {
                    this.zzeck.putLong("first_ad_req_time_ms", j);
                    this.zzeck.apply();
                }
                zzyd();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzo(Context context, String str) {
        boolean z = false;
        SharedPreferences sharedPreferences = context.getSharedPreferences(str, 0);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        synchronized (this.lock) {
            this.zzclm = sharedPreferences;
            this.zzeck = edit;
            if (PlatformVersion.isAtLeastM() && !NetworkSecurityPolicy.getInstance().isCleartextTrafficPermitted()) {
                z = true;
            }
            this.zzecl = z;
            this.zzdsy = this.zzclm.getBoolean("use_https", this.zzdsy);
            this.zzdux = this.zzclm.getBoolean("content_url_opted_out", this.zzdux);
            this.zzecm = this.zzclm.getString("content_url_hashes", this.zzecm);
            this.zzdtl = this.zzclm.getBoolean("auto_collect_location", this.zzdtl);
            this.zzdvi = this.zzclm.getBoolean("content_vertical_opted_out", this.zzdvi);
            this.zzecn = this.zzclm.getString("content_vertical_hashes", this.zzecn);
            this.zzecs = this.zzclm.getInt("version_code", this.zzecs);
            this.zzdto = this.zzclm.getString("app_settings_json", this.zzdto);
            this.zzeco = this.zzclm.getLong("app_settings_last_update_ms", this.zzeco);
            this.zzecp = this.zzclm.getLong("app_last_background_time_ms", this.zzecp);
            this.zzecr = this.zzclm.getInt("request_in_session_count", this.zzecr);
            this.zzecq = this.zzclm.getLong("first_ad_req_time_ms", this.zzecq);
            this.zzect = this.zzclm.getStringSet("never_pool_slots", this.zzect);
            this.zzecv = this.zzclm.getString("display_cutout", this.zzecv);
            this.zzecw = this.zzclm.getInt("app_measurement_npa", this.zzecw);
            try {
                this.zzecu = new JSONObject(this.zzclm.getString("native_advanced_settings", "{}"));
            } catch (JSONException e) {
                zzd.zzd("Could not convert native advanced settings to json object", e);
            }
            zzyd();
        }
    }

    public final zzrk zzxo() {
        if (!this.zzecg) {
            return null;
        }
        if ((zzxp() && zzxr()) || !zzacv.zzdbt.get().booleanValue()) {
            return null;
        }
        synchronized (this.lock) {
            if (Looper.getMainLooper() == null) {
                return null;
            }
            if (this.zzecj == null) {
                this.zzecj = new zzrk();
            }
            this.zzecj.zzmh();
            zzd.zzez("start fetching content...");
            zzrk zzrk = this.zzecj;
            return zzrk;
        }
    }

    public final boolean zzxp() {
        boolean z;
        zzyc();
        synchronized (this.lock) {
            z = this.zzdux;
        }
        return z;
    }

    public final String zzxq() {
        String str;
        zzyc();
        synchronized (this.lock) {
            str = this.zzecm;
        }
        return str;
    }

    public final boolean zzxr() {
        boolean z;
        zzyc();
        synchronized (this.lock) {
            z = this.zzdvi;
        }
        return z;
    }

    public final String zzxs() {
        String str;
        zzyc();
        synchronized (this.lock) {
            str = this.zzecn;
        }
        return str;
    }

    public final boolean zzxt() {
        boolean z;
        zzyc();
        synchronized (this.lock) {
            z = this.zzdtl;
        }
        return z;
    }

    public final int zzxu() {
        int i;
        zzyc();
        synchronized (this.lock) {
            i = this.zzecs;
        }
        return i;
    }

    public final zzayh zzxv() {
        zzayh zzayh;
        zzyc();
        synchronized (this.lock) {
            zzayh = new zzayh(this.zzdto, this.zzeco);
        }
        return zzayh;
    }

    public final long zzxw() {
        long j;
        zzyc();
        synchronized (this.lock) {
            j = this.zzecp;
        }
        return j;
    }

    public final int zzxx() {
        int i;
        zzyc();
        synchronized (this.lock) {
            i = this.zzecr;
        }
        return i;
    }

    public final long zzxy() {
        long j;
        zzyc();
        synchronized (this.lock) {
            j = this.zzecq;
        }
        return j;
    }

    public final JSONObject zzxz() {
        JSONObject jSONObject;
        zzyc();
        synchronized (this.lock) {
            jSONObject = this.zzecu;
        }
        return jSONObject;
    }

    public final void zzya() {
        zzyc();
        synchronized (this.lock) {
            this.zzecu = new JSONObject();
            if (this.zzeck != null) {
                this.zzeck.remove("native_advanced_settings");
                this.zzeck.apply();
            }
            zzyd();
        }
    }

    public final String zzyb() {
        String str;
        zzyc();
        synchronized (this.lock) {
            str = this.zzecv;
        }
        return str;
    }
}
