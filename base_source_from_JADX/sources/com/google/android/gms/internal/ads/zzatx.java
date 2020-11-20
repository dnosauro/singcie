package com.google.android.gms.internal.ads;

import android.content.Context;
import android.content.SharedPreferences;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.GooglePlayServicesUtilLight;
import com.google.android.gms.dynamite.DynamiteModule;
import com.google.android.gms.dynamite.descriptors.com.google.android.gms.ads.dynamite.ModuleDescriptor;
import java.util.concurrent.Executor;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzatx extends zzatz {
    private final Object lock = new Object();
    private final Context zzaaa;
    private SharedPreferences zzdxp;
    private final zzamd<JSONObject, JSONObject> zzdxq;

    public zzatx(Context context, zzamd<JSONObject, JSONObject> zzamd) {
        this.zzaaa = context.getApplicationContext();
        this.zzdxq = zzamd;
    }

    public static JSONObject zzw(Context context) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("js", zzazh.zzzi().zzbrf);
            jSONObject.put("mf", zzadb.zzdct.get());
            jSONObject.put("cl", "334274230");
            jSONObject.put("rapid_rc", "dev");
            jSONObject.put("rapid_rollup", "HEAD");
            jSONObject.put("admob_module_version", GooglePlayServicesUtilLight.GOOGLE_PLAY_SERVICES_VERSION_CODE);
            jSONObject.put("dynamite_local_version", ModuleDescriptor.MODULE_VERSION);
            jSONObject.put("dynamite_version", DynamiteModule.getRemoteVersion(context, ModuleDescriptor.MODULE_ID));
            jSONObject.put("container_version", 12451009);
        } catch (JSONException unused) {
        }
        return jSONObject;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ Void zzf(JSONObject jSONObject) {
        zzabf.zza(this.zzaaa, 1, jSONObject);
        this.zzdxp.edit().putLong("js_last_update", zzp.zzkx().currentTimeMillis()).apply();
        return null;
    }

    public final zzdyz<Void> zzwa() {
        synchronized (this.lock) {
            if (this.zzdxp == null) {
                this.zzdxp = this.zzaaa.getSharedPreferences("google_ads_flags_meta", 0);
            }
        }
        if (zzp.zzkx().currentTimeMillis() - this.zzdxp.getLong("js_last_update", 0) < zzadb.zzdcu.get().longValue()) {
            return zzdyr.zzag(null);
        }
        return zzdyr.zzb(this.zzdxq.zzi(zzw(this.zzaaa)), new zzatw(this), (Executor) zzazj.zzegu);
    }
}
