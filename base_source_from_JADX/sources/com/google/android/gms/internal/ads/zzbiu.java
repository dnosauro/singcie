package com.google.android.gms.internal.ads;

import android.content.Context;
import android.text.TextUtils;
import com.google.android.gms.ads.internal.util.zzag;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONObject;

public final class zzbiu extends zzxv {
    private final Context context;
    private final zzazh zzbpd;
    private final zzawx zzbql;
    private final zzciq zzfox;
    private final zzcre<zzdoe, zzcsw> zzfoy;
    private final zzcwz zzfoz;
    private final zzclp zzfpa;
    private final zzcis zzfpb;
    @GuardedBy("this")
    private boolean zzzi = false;

    zzbiu(Context context2, zzazh zzazh, zzciq zzciq, zzcre<zzdoe, zzcsw> zzcre, zzcwz zzcwz, zzclp zzclp, zzawx zzawx, zzcis zzcis) {
        this.context = context2;
        this.zzbpd = zzazh;
        this.zzfox = zzciq;
        this.zzfoy = zzcre;
        this.zzfoz = zzcwz;
        this.zzfpa = zzclp;
        this.zzbql = zzawx;
        this.zzfpb = zzcis;
    }

    public final String getVersionString() {
        return this.zzbpd.zzbrf;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:15:0x005c, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void initialize() {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.zzzi     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x000c
            java.lang.String r0 = "Mobile ads is initialized already."
            com.google.android.gms.ads.internal.util.zzd.zzfa(r0)     // Catch:{ all -> 0x005d }
            monitor-exit(r3)
            return
        L_0x000c:
            android.content.Context r0 = r3.context     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzabf.initialize(r0)     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzayg r0 = com.google.android.gms.ads.internal.zzp.zzku()     // Catch:{ all -> 0x005d }
            android.content.Context r1 = r3.context     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzazh r2 = r3.zzbpd     // Catch:{ all -> 0x005d }
            r0.zzd(r1, r2)     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzsx r0 = com.google.android.gms.ads.internal.zzp.zzkw()     // Catch:{ all -> 0x005d }
            android.content.Context r1 = r3.context     // Catch:{ all -> 0x005d }
            r0.initialize(r1)     // Catch:{ all -> 0x005d }
            r0 = 1
            r3.zzzi = r0     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzclp r0 = r3.zzfpa     // Catch:{ all -> 0x005d }
            r0.zzaqm()     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcqd     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x0044
            com.google.android.gms.internal.ads.zzcwz r0 = r3.zzfoz     // Catch:{ all -> 0x005d }
            r0.zzapi()     // Catch:{ all -> 0x005d }
        L_0x0044:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcss     // Catch:{ all -> 0x005d }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x005d }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x005d }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x005d }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x005d }
            if (r0 == 0) goto L_0x005b
            com.google.android.gms.internal.ads.zzcis r0 = r3.zzfpb     // Catch:{ all -> 0x005d }
            r0.zzapi()     // Catch:{ all -> 0x005d }
        L_0x005b:
            monitor-exit(r3)
            return
        L_0x005d:
            r0 = move-exception
            monitor-exit(r3)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbiu.initialize():void");
    }

    public final synchronized void setAppMuted(boolean z) {
        zzp.zzkv().setAppMuted(z);
    }

    public final synchronized void setAppVolume(float f) {
        zzp.zzkv().setAppVolume(f);
    }

    public final void zza(zzaae zzaae) {
        this.zzbql.zza(this.context, zzaae);
    }

    public final void zza(zzajc zzajc) {
        this.zzfpa.zzb(zzajc);
    }

    public final void zza(zzani zzani) {
        this.zzfox.zzb(zzani);
    }

    public final void zza(String str, IObjectWrapper iObjectWrapper) {
        zzabf.initialize(this.context);
        String str2 = "";
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcst)).booleanValue()) {
            zzp.zzkq();
            str2 = zzm.zzba(this.context);
        }
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (!TextUtils.isEmpty(str)) {
            boolean booleanValue = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcsr)).booleanValue() | ((Boolean) zzwq.zzqe().zzd(zzabf.zzcok)).booleanValue();
            zzbit zzbit = null;
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcok)).booleanValue()) {
                booleanValue = true;
                zzbit = new zzbit(this, (Runnable) ObjectWrapper.unwrap(iObjectWrapper));
            }
            if (booleanValue) {
                zzp.zzky().zza(this.context, this.zzbpd, str, (Runnable) zzbit);
            }
        }
    }

    public final void zzb(IObjectWrapper iObjectWrapper, String str) {
        if (iObjectWrapper == null) {
            zzd.zzey("Wrapped context is null. Failed to open debug menu.");
            return;
        }
        Context context2 = (Context) ObjectWrapper.unwrap(iObjectWrapper);
        if (context2 == null) {
            zzd.zzey("Context is null. Failed to open debug menu.");
            return;
        }
        zzag zzag = new zzag(context2);
        zzag.setAdUnitId(str);
        zzag.zzad(this.zzbpd.zzbrf);
        zzag.showDialog();
    }

    public final synchronized void zzcd(String str) {
        zzabf.initialize(this.context);
        if (!TextUtils.isEmpty(str)) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcsr)).booleanValue()) {
                zzp.zzky().zza(this.context, this.zzbpd, str, (Runnable) null);
            }
        }
    }

    public final void zzce(String str) {
        this.zzfoz.zzgn(str);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(Runnable runnable) {
        Preconditions.checkMainThread("Adapters must be initialized on the main thread.");
        Map<String, zzanh> zzxh = zzp.zzku().zzwz().zzxv().zzxh();
        if (zzxh != null && !zzxh.isEmpty()) {
            if (runnable != null) {
                try {
                    runnable.run();
                } catch (Throwable th) {
                    zzd.zzd("Could not initialize rewarded ads.", th);
                    return;
                }
            }
            if (this.zzfox.zzapg()) {
                HashMap hashMap = new HashMap();
                for (zzanh zzanh : zzxh.values()) {
                    for (zzane next : zzanh.zzdlr) {
                        String str = next.zzdle;
                        for (String next2 : next.zzdkw) {
                            if (!hashMap.containsKey(next2)) {
                                hashMap.put(next2, new ArrayList());
                            }
                            if (str != null) {
                                ((Collection) hashMap.get(next2)).add(str);
                            }
                        }
                    }
                }
                JSONObject jSONObject = new JSONObject();
                for (Map.Entry entry : hashMap.entrySet()) {
                    String str2 = (String) entry.getKey();
                    try {
                        zzcrb<zzdoe, zzcsw> zzf = this.zzfoy.zzf(str2, jSONObject);
                        if (zzf != null) {
                            zzdoe zzdoe = (zzdoe) zzf.zzdmo;
                            if (!zzdoe.isInitialized()) {
                                if (zzdoe.zzui()) {
                                    zzdoe.zza(this.context, (zzauw) (zzcsw) zzf.zzgqp, (List<String>) (List) entry.getValue());
                                    String valueOf = String.valueOf(str2);
                                    zzd.zzeb(valueOf.length() != 0 ? "Initialized rewarded video mediation adapter ".concat(valueOf) : new String("Initialized rewarded video mediation adapter "));
                                }
                            }
                        }
                    } catch (zzdnr e) {
                        StringBuilder sb = new StringBuilder(String.valueOf(str2).length() + 56);
                        sb.append("Failed to initialize rewarded video mediation adapter \"");
                        sb.append(str2);
                        sb.append("\"");
                        zzd.zzd(sb.toString(), e);
                    }
                }
            }
        }
    }

    public final synchronized float zzqk() {
        return zzp.zzkv().zzqk();
    }

    public final synchronized boolean zzql() {
        return zzp.zzkv().zzql();
    }

    public final List<zzaiz> zzqm() {
        return this.zzfpa.zzaqn();
    }

    public final void zzqn() {
        this.zzfpa.disable();
    }
}
