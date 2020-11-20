package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzbk;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Executor;
import org.json.JSONArray;
import org.json.JSONObject;

public final class zzctn implements zzcto<zzcbt> {
    private final zzdzc zzggb;
    private final zzcat zzgsh;
    private final zzceo zzgsi;
    private final zzdod<zzcgh> zzgsj;

    public zzctn(zzcat zzcat, zzdzc zzdzc, zzceo zzceo, zzdod<zzcgh> zzdod) {
        this.zzgsh = zzcat;
        this.zzggb = zzdzc;
        this.zzgsi = zzceo;
        this.zzgsj = zzdod;
    }

    private final zzdyz<zzcbt> zzb(zzdnj zzdnj, zzdmu zzdmu, JSONObject jSONObject) {
        zzdyz<zzcgh> zzaux = this.zzgsj.zzaux();
        zzdyz<zzcce> zza = this.zzgsi.zza(zzdnj, zzdmu, jSONObject);
        return zzdyr.zzb((zzdyz<? extends V>[]) new zzdyz[]{zzaux, zza}).zza(new zzctu(this, zza, zzaux, zzdnj, zzdmu, jSONObject), this.zzggb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzcbt zza(zzdyz zzdyz, zzdyz zzdyz2, zzdnj zzdnj, zzdmu zzdmu, JSONObject jSONObject) {
        zzcce zzcce = (zzcce) zzdyz.get();
        zzcgh zzcgh = (zzcgh) zzdyz2.get();
        zzccg zza = this.zzgsh.zza(new zzbos(zzdnj, zzdmu, (String) null), new zzccq(zzcce), new zzcbh(jSONObject, zzcgh));
        zza.zzafy().zzaov();
        zza.zzafz().zzb(zzcgh);
        zza.zzaga().zzl(zzcce.zzanh());
        return zza.zzafx();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzcgh zzcgh, JSONObject jSONObject) {
        this.zzgsj.zzd(zzdyr.zzag(zzcgh));
        if (jSONObject.optBoolean(FirebaseAnalytics.Param.SUCCESS)) {
            return zzdyr.zzag(jSONObject.getJSONObject("json").getJSONArray("ads"));
        }
        throw new zzama("process json failed");
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzdmu zzdmu, zzcgh zzcgh) {
        JSONObject zza = zzbk.zza("isNonagon", (Object) true);
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("response", zzdmu.zzhgx.zzgao);
        jSONObject.put("sdk_params", zza);
        return zzdyr.zzb(zzcgh.zzc("google.afma.nativeAds.preProcessJson", jSONObject), new zzcts(this, zzcgh), (Executor) this.zzggb);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(zzdnj zzdnj, zzdmu zzdmu, JSONArray jSONArray) {
        if (jSONArray.length() == 0) {
            return zzdyr.immediateFailedFuture(new zzcme(zzdok.NO_FILL));
        }
        int i = 0;
        if (zzdnj.zzhij.zzfvl.zzgwz <= 1) {
            return zzdyr.zzb(zzb(zzdnj, zzdmu, jSONArray.getJSONObject(0)), zzctr.zzdza, (Executor) this.zzggb);
        }
        int length = jSONArray.length();
        this.zzgsj.ensureSize(Math.min(length, zzdnj.zzhij.zzfvl.zzgwz));
        ArrayList arrayList = new ArrayList(zzdnj.zzhij.zzfvl.zzgwz);
        while (i < zzdnj.zzhij.zzfvl.zzgwz) {
            arrayList.add(i < length ? zzb(zzdnj, zzdmu, jSONArray.getJSONObject(i)) : zzdyr.immediateFailedFuture(new zzcme(zzdok.NO_FILL)));
            i++;
        }
        return zzdyr.zzag(arrayList);
    }

    public final boolean zza(zzdnj zzdnj, zzdmu zzdmu) {
        return (zzdmu.zzhgx == null || zzdmu.zzhgx.zzgao == null) ? false : true;
    }

    public final zzdyz<List<zzdyz<zzcbt>>> zzb(zzdnj zzdnj, zzdmu zzdmu) {
        return zzdyr.zzb(zzdyr.zzb(this.zzgsj.zzaux(), new zzctq(this, zzdmu), (Executor) this.zzggb), new zzctp(this, zzdnj, zzdmu), (Executor) this.zzggb);
    }
}
