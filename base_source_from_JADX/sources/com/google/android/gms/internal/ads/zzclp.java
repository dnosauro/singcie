package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzclp {
    private boolean enabled = true;
    /* access modifiers changed from: private */
    public final Executor executor;
    private final zzazh zzbos;
    private final Context zzcln;
    private final Executor zzfqx;
    private final ScheduledExecutorService zzfru;
    private boolean zzglb = false;
    /* access modifiers changed from: private */
    public boolean zzglc = false;
    /* access modifiers changed from: private */
    public final long zzgld;
    /* access modifiers changed from: private */
    public final zzazq<Boolean> zzgle = new zzazq<>();
    private final WeakReference<Context> zzglf;
    private final zzciq zzglg;
    /* access modifiers changed from: private */
    public final zzckz zzglh;
    private Map<String, zzaiz> zzgli = new ConcurrentHashMap();

    public zzclp(Executor executor2, Context context, WeakReference<Context> weakReference, Executor executor3, zzciq zzciq, ScheduledExecutorService scheduledExecutorService, zzckz zzckz, zzazh zzazh) {
        this.zzglg = zzciq;
        this.zzcln = context;
        this.zzglf = weakReference;
        this.executor = executor3;
        this.zzfru = scheduledExecutorService;
        this.zzfqx = executor2;
        this.zzglh = zzckz;
        this.zzbos = zzazh;
        this.zzgld = zzp.zzkx().elapsedRealtime();
        zza("com.google.android.gms.ads.MobileAds", false, "", 0);
    }

    /* access modifiers changed from: private */
    public final void zza(String str, boolean z, String str2, int i) {
        this.zzgli.put(str, new zzaiz(str, z, i, str2));
    }

    private final synchronized zzdyz<String> zzaqo() {
        String zzxf = zzp.zzku().zzwz().zzxv().zzxf();
        if (!TextUtils.isEmpty(zzxf)) {
            return zzdyr.zzag(zzxf);
        }
        zzazq zzazq = new zzazq();
        zzp.zzku().zzwz().zzb(new zzclu(this, zzazq));
        return zzazq;
    }

    /* access modifiers changed from: private */
    public final void zzgh(String str) {
        try {
            ArrayList arrayList = new ArrayList();
            JSONObject jSONObject = new JSONObject(str).getJSONObject("initializer_settings").getJSONObject("config");
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                Object obj = new Object();
                zzazq zzazq = new zzazq();
                zzdyz zza = zzdyr.zza(zzazq, ((Long) zzwq.zzqe().zzd(zzabf.zzcql)).longValue(), TimeUnit.SECONDS, this.zzfru);
                this.zzglh.zzgf(next);
                long elapsedRealtime = zzp.zzkx().elapsedRealtime();
                Iterator<String> it = keys;
                zzclw zzclw = r1;
                zzclw zzclw2 = new zzclw(this, obj, zzazq, next, elapsedRealtime);
                zza.addListener(zzclw, this.executor);
                arrayList.add(zza);
                zzcmc zzcmc = new zzcmc(this, obj, next, elapsedRealtime, zzazq);
                JSONObject optJSONObject = jSONObject.optJSONObject(next);
                ArrayList arrayList2 = new ArrayList();
                if (optJSONObject != null) {
                    try {
                        JSONArray jSONArray = optJSONObject.getJSONArray("data");
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject2 = jSONArray.getJSONObject(i);
                            String optString = jSONObject2.optString("format", "");
                            JSONObject optJSONObject2 = jSONObject2.optJSONObject("data");
                            Bundle bundle = new Bundle();
                            if (optJSONObject2 != null) {
                                Iterator<String> keys2 = optJSONObject2.keys();
                                while (keys2.hasNext()) {
                                    String next2 = keys2.next();
                                    bundle.putString(next2, optJSONObject2.optString(next2, ""));
                                }
                            }
                            arrayList2.add(new zzajj(optString, bundle));
                        }
                    } catch (JSONException unused) {
                    }
                }
                zza(next, false, "", 0);
                try {
                    this.zzfqx.execute(new zzcly(this, this.zzglg.zzd(next, new JSONObject()), zzcmc, arrayList2, next));
                } catch (zzdnr unused2) {
                    try {
                        zzcmc.onInitializationFailed("Failed to create Adapter.");
                    } catch (RemoteException e) {
                        zzaza.zzc("", e);
                    }
                }
                keys = it;
            }
            zzdyr.zzj(arrayList).zza(new zzclv(this), this.executor);
        } catch (JSONException e2) {
            zzd.zza("Malformed CLD response", e2);
        }
    }

    public final void disable() {
        this.enabled = false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzazq zzazq) {
        this.executor.execute(new zzclx(this, zzazq));
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(3:7|8|9) */
    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0035, code lost:
        r2 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x0036, code lost:
        com.google.android.gms.internal.ads.zzaza.zzc("", r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x003b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:8:?, code lost:
        r4 = new java.lang.StringBuilder(java.lang.String.valueOf(r5).length() + 74);
        r4.append("Failed to initialize adapter. ");
        r4.append(r5);
        r4.append(" does not implement the initialize() method.");
        r3.onInitializationFailed(r4.toString());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0034, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0011 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zza(com.google.android.gms.internal.ads.zzdoe r2, com.google.android.gms.internal.ads.zzajb r3, java.util.List r4, java.lang.String r5) {
        /*
            r1 = this;
            java.lang.ref.WeakReference<android.content.Context> r0 = r1.zzglf     // Catch:{ zzdnr -> 0x0011 }
            java.lang.Object r0 = r0.get()     // Catch:{ zzdnr -> 0x0011 }
            android.content.Context r0 = (android.content.Context) r0     // Catch:{ zzdnr -> 0x0011 }
            if (r0 == 0) goto L_0x000b
            goto L_0x000d
        L_0x000b:
            android.content.Context r0 = r1.zzcln     // Catch:{ zzdnr -> 0x0011 }
        L_0x000d:
            r2.zza((android.content.Context) r0, (com.google.android.gms.internal.ads.zzajb) r3, (java.util.List<com.google.android.gms.internal.ads.zzajj>) r4)     // Catch:{ zzdnr -> 0x0011 }
            return
        L_0x0011:
            java.lang.String r2 = java.lang.String.valueOf(r5)     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2.length()     // Catch:{ RemoteException -> 0x0035 }
            int r2 = r2 + 74
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ RemoteException -> 0x0035 }
            r4.<init>(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = "Failed to initialize adapter. "
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            r4.append(r5)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = " does not implement the initialize() method."
            r4.append(r2)     // Catch:{ RemoteException -> 0x0035 }
            java.lang.String r2 = r4.toString()     // Catch:{ RemoteException -> 0x0035 }
            r3.onInitializationFailed(r2)     // Catch:{ RemoteException -> 0x0035 }
            return
        L_0x0035:
            r2 = move-exception
            java.lang.String r3 = ""
            com.google.android.gms.internal.ads.zzaza.zzc(r3, r2)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzclp.zza(com.google.android.gms.internal.ads.zzdoe, com.google.android.gms.internal.ads.zzajb, java.util.List, java.lang.String):void");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Object obj, zzazq zzazq, String str, long j) {
        synchronized (obj) {
            if (!zzazq.isDone()) {
                zza(str, false, "Timeout.", (int) (zzp.zzkx().elapsedRealtime() - j));
                this.zzglh.zzs(str, "timeout");
                zzazq.set(false);
            }
        }
    }

    public final void zzaqm() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqj)).booleanValue() && !zzadc.zzdcv.get().booleanValue()) {
            if (this.zzbos.zzegm >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcqk)).intValue() && this.enabled) {
                if (!this.zzglb) {
                    synchronized (this) {
                        if (!this.zzglb) {
                            this.zzglh.zzaqj();
                            this.zzgle.addListener(new zzclr(this), this.executor);
                            this.zzglb = true;
                            zzdyz<String> zzaqo = zzaqo();
                            this.zzfru.schedule(new zzclt(this), ((Long) zzwq.zzqe().zzd(zzabf.zzcqm)).longValue(), TimeUnit.SECONDS);
                            zzdyr.zza(zzaqo, new zzcma(this), this.executor);
                            return;
                        }
                        return;
                    }
                }
                return;
            }
        }
        if (!this.zzglb) {
            zza("com.google.android.gms.ads.MobileAds", true, "", 0);
            this.zzgle.set(false);
            this.zzglb = true;
        }
    }

    public final List<zzaiz> zzaqn() {
        ArrayList arrayList = new ArrayList();
        for (String next : this.zzgli.keySet()) {
            zzaiz zzaiz = this.zzgli.get(next);
            arrayList.add(new zzaiz(next, zzaiz.zzdho, zzaiz.zzdhp, zzaiz.description));
        }
        return arrayList;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Object zzaqp() {
        this.zzgle.set(true);
        return null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqq() {
        synchronized (this) {
            if (!this.zzglc) {
                zza("com.google.android.gms.ads.MobileAds", false, "Timeout.", (int) (zzp.zzkx().elapsedRealtime() - this.zzgld));
                this.zzgle.setException(new Exception());
            }
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzaqr() {
        this.zzglh.zzaqk();
    }

    public final void zzb(zzajc zzajc) {
        this.zzgle.addListener(new zzcls(this, zzajc), this.zzfqx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzajc zzajc) {
        try {
            zzajc.zze(zzaqn());
        } catch (RemoteException e) {
            zzaza.zzc("", e);
        }
    }
}
