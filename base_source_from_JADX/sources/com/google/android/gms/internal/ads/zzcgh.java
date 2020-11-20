package com.google.android.gms.internal.ads;

import android.content.Context;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzb;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcgh {
    private final Context context;
    private final zzbed zzbpq;
    private final zzckq zzdgx;
    private final zzcqo zzdgz;
    private final zzazh zzdsm;
    private final zzef zzerb;
    private final zzdrz zzfqa;
    private final Executor zzfqx;
    private final zzb zzggo;
    /* access modifiers changed from: private */
    public final zzcgp zzghh = new zzcgp((zzcgm) null);
    private final zzaif zzghi;
    private zzdyz<zzbdv> zzghj;

    zzcgh(zzcgu zzcgu) {
        this.context = zzcgu.context;
        this.zzfqx = zzcgu.zzfqx;
        this.zzerb = zzcgu.zzerb;
        this.zzdsm = zzcgu.zzdsm;
        this.zzggo = zzcgu.zzggo;
        this.zzbpq = zzcgu.zzbpq;
        this.zzghi = new zzaif();
        this.zzdgz = zzcgu.zzdgz;
        this.zzfqa = zzcgu.zzfqa;
        this.zzdgx = zzcgu.zzdgx;
    }

    public final synchronized void destroy() {
        if (this.zzghj != null) {
            zzdyr.zza(this.zzghj, new zzcgm(this), this.zzfqx);
            this.zzghj = null;
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(String str, JSONObject jSONObject, zzbdv zzbdv) {
        return this.zzghi.zza(zzbdv, str, jSONObject);
    }

    public final synchronized void zza(zzdmu zzdmu, zzdmz zzdmz) {
        if (this.zzghj != null) {
            zzdyr.zza(this.zzghj, new zzcgq(this, zzdmu, zzdmz), this.zzfqx);
        }
    }

    public final synchronized void zza(String str, zzahv<Object> zzahv) {
        if (this.zzghj != null) {
            zzdyr.zza(this.zzghj, new zzcgl(this, str, zzahv), this.zzfqx);
        }
    }

    public final synchronized void zza(String str, Map<String, ?> map) {
        if (this.zzghj != null) {
            zzdyr.zza(this.zzghj, new zzcgn(this, str, map), this.zzfqx);
        }
    }

    public final <T> void zza(WeakReference<T> weakReference, String str, zzahv<T> zzahv) {
        zza(str, (zzahv<Object>) new zzcgt(this, weakReference, str, zzahv, (zzcgm) null));
    }

    public final synchronized void zzaou() {
        this.zzghj = zzdyr.zzb(zzbed.zza(this.context, this.zzdsm, (String) zzwq.zzqe().zzd(zzabf.zzcrv), this.zzerb, this.zzggo), new zzcgk(this), this.zzfqx);
        zzazm.zza(this.zzghj, "NativeJavascriptExecutor.initializeEngine");
    }

    public final synchronized void zzb(String str, zzahv<Object> zzahv) {
        if (this.zzghj != null) {
            zzdyr.zza(this.zzghj, new zzcgo(this, str, zzahv), this.zzfqx);
        }
    }

    public final synchronized zzdyz<JSONObject> zzc(String str, JSONObject jSONObject) {
        if (this.zzghj == null) {
            return zzdyr.zzag(null);
        }
        return zzdyr.zzb(this.zzghj, new zzcgj(this, str, jSONObject), this.zzfqx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzbdv zzm(zzbdv zzbdv) {
        zzbdv zzbdv2 = zzbdv;
        zzbdv2.zza("/result", (zzahv<? super zzbdv>) this.zzghi);
        zzbfg zzacs = zzbdv.zzacs();
        zzcgp zzcgp = this.zzghh;
        zzacs.zza((zzva) null, zzcgp, zzcgp, zzcgp, zzcgp, false, (zzahu) null, new zza(this.context, (zzawq) null, (zzasw) null), (zzaqx) null, (zzawq) null, this.zzdgz, this.zzfqa, this.zzdgx);
        return zzbdv2;
    }
}
