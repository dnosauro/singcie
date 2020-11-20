package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import com.github.appintro.AppIntroBaseFragmentKt;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.internal.ImagesContract;
import com.parse.ParseQuery;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.i18n.TextBundle;

public final class zzces {
    private final Context context;
    private final Executor executor;
    private final zzazh zzbpd;
    private final zzadz zzdnh;
    private final zzts zzeph;
    private final zzef zzerb;
    private final ScheduledExecutorService zzfpq;
    private final zzcej zzggn;
    private final zzb zzggo;
    private final zzcff zzggp;

    public zzces(Context context2, zzcej zzcej, zzef zzef, zzazh zzazh, zzb zzb, zzts zzts, Executor executor2, zzdnn zzdnn, zzcff zzcff, ScheduledExecutorService scheduledExecutorService) {
        this.context = context2;
        this.zzggn = zzcej;
        this.zzerb = zzef;
        this.zzbpd = zzazh;
        this.zzggo = zzb;
        this.zzeph = zzts;
        this.executor = executor2;
        this.zzdnh = zzdnn.zzdnh;
        this.zzggp = zzcff;
        this.zzfpq = scheduledExecutorService;
    }

    private static <T> zzdyz<T> zza(zzdyz<T> zzdyz, T t) {
        return zzdyr.zzb(zzdyz, Exception.class, new zzcey((Object) null), zzazj.zzegu);
    }

    private final zzdyz<List<zzadv>> zza(JSONArray jSONArray, boolean z, boolean z2) {
        if (jSONArray == null || jSONArray.length() <= 0) {
            return zzdyr.zzag(Collections.emptyList());
        }
        ArrayList arrayList = new ArrayList();
        int length = z2 ? jSONArray.length() : 1;
        for (int i = 0; i < length; i++) {
            arrayList.add(zza(jSONArray.optJSONObject(i), z));
        }
        return zzdyr.zzb(zzdyr.zzi(arrayList), zzcer.zzdza, this.executor);
    }

    private final zzdyz<zzadv> zza(JSONObject jSONObject, boolean z) {
        if (jSONObject == null) {
            return zzdyr.zzag(null);
        }
        String optString = jSONObject.optString(ImagesContract.URL);
        if (TextUtils.isEmpty(optString)) {
            return zzdyr.zzag(null);
        }
        double optDouble = jSONObject.optDouble("scale", 1.0d);
        boolean optBoolean = jSONObject.optBoolean("is_transparent", true);
        int optInt = jSONObject.optInt("width", -1);
        int optInt2 = jSONObject.optInt("height", -1);
        if (z) {
            return zzdyr.zzag(new zzadv((Drawable) null, Uri.parse(optString), optDouble, optInt, optInt2));
        }
        return zza(jSONObject.optBoolean("require"), zzdyr.zzb(this.zzggn.zza(optString, optDouble, optBoolean), new zzceu(optString, optDouble, optInt, optInt2), this.executor), (Object) null);
    }

    private static <T> zzdyz<T> zza(boolean z, zzdyz<T> zzdyz, T t) {
        return z ? zzdyr.zzb(zzdyz, new zzcex(zzdyz), (Executor) zzazj.zzegu) : zza(zzdyz, (Object) null);
    }

    private static Integer zzf(JSONObject jSONObject, String str) {
        try {
            JSONObject jSONObject2 = jSONObject.getJSONObject(str);
            return Integer.valueOf(Color.rgb(jSONObject2.getInt("r"), jSONObject2.getInt("g"), jSONObject2.getInt("b")));
        } catch (JSONException unused) {
            return null;
        }
    }

    public static List<zzzk> zzj(JSONObject jSONObject) {
        JSONObject optJSONObject = jSONObject.optJSONObject("mute");
        if (optJSONObject == null) {
            return zzdwm.zzayv();
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("reasons");
        if (optJSONArray == null || optJSONArray.length() <= 0) {
            return zzdwm.zzayv();
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < optJSONArray.length(); i++) {
            zzzk zzl = zzl(optJSONArray.optJSONObject(i));
            if (zzl != null) {
                arrayList.add(zzl);
            }
        }
        return zzdwm.zzb(arrayList);
    }

    public static zzzk zzk(JSONObject jSONObject) {
        JSONObject optJSONObject;
        JSONObject optJSONObject2 = jSONObject.optJSONObject("mute");
        if (optJSONObject2 == null || (optJSONObject = optJSONObject2.optJSONObject("default_reason")) == null) {
            return null;
        }
        return zzl(optJSONObject);
    }

    private static zzzk zzl(JSONObject jSONObject) {
        if (jSONObject == null) {
            return null;
        }
        String optString = jSONObject.optString("reason");
        String optString2 = jSONObject.optString("ping_url");
        if (TextUtils.isEmpty(optString) || TextUtils.isEmpty(optString2)) {
            return null;
        }
        return new zzzk(optString, optString2);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzadq zza(JSONObject jSONObject, List list) {
        Integer num = null;
        if (list == null || list.isEmpty()) {
            return null;
        }
        String optString = jSONObject.optString(TextBundle.TEXT_ENTRY);
        Integer zzf = zzf(jSONObject, AppIntroBaseFragmentKt.ARG_BG_COLOR);
        Integer zzf2 = zzf(jSONObject, "text_color");
        int optInt = jSONObject.optInt("text_size", -1);
        boolean optBoolean = jSONObject.optBoolean("allow_pub_rendering");
        int optInt2 = jSONObject.optInt("animation_ms", ParseQuery.MAX_LIMIT);
        int optInt3 = jSONObject.optInt("presentation_ms", 4000);
        if (optInt > 0) {
            num = Integer.valueOf(optInt);
        }
        return new zzadq(optString, list, zzf, zzf2, num, optInt3 + optInt2, this.zzdnh.zzbnp, optBoolean);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzb(String str, Object obj) {
        zzp.zzkr();
        zzbdv zza = zzbed.zza(this.context, zzbfn.zzadv(), "native-omid", false, false, this.zzerb, (zzacg) null, this.zzbpd, (zzabs) null, (zzk) null, this.zzggo, this.zzeph, (zzsu) null, false, (zzdmu) null, (zzdmz) null);
        zzazr zzl = zzazr.zzl(zza);
        zza.zzacs().zza((zzbfj) new zzcfa(zzl));
        zza.loadData(str, "text/html", "UTF-8");
        return zzl;
    }

    public final zzdyz<zzadv> zzc(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONObject(str), this.zzdnh.zzdeo);
    }

    public final zzdyz<List<zzadv>> zzd(JSONObject jSONObject, String str) {
        return zza(jSONObject.optJSONArray(str), this.zzdnh.zzdeo, this.zzdnh.zzbno);
    }

    public final zzdyz<zzadq> zze(JSONObject jSONObject, String str) {
        JSONObject optJSONObject = jSONObject.optJSONObject(str);
        if (optJSONObject == null) {
            return zzdyr.zzag(null);
        }
        JSONArray optJSONArray = optJSONObject.optJSONArray("images");
        JSONObject optJSONObject2 = optJSONObject.optJSONObject("image");
        if (optJSONArray == null && optJSONObject2 != null) {
            optJSONArray = new JSONArray();
            optJSONArray.put(optJSONObject2);
        }
        return zza(optJSONObject.optBoolean("require"), zzdyr.zzb(zza(optJSONArray, false, true), new zzcet(this, optJSONObject), this.executor), (Object) null);
    }

    public final zzdyz<zzbdv> zzm(JSONObject jSONObject) {
        JSONObject zza = zzbk.zza(jSONObject, "html_containers", "instream");
        if (zza == null) {
            JSONObject optJSONObject = jSONObject.optJSONObject("video");
            if (optJSONObject == null) {
                return zzdyr.zzag(null);
            }
            if (TextUtils.isEmpty(optJSONObject.optString("vast_xml"))) {
                zzd.zzfa("Required field 'vast_xml' is missing");
                return zzdyr.zzag(null);
            }
            return zza(zzdyr.zza(this.zzggp.zzn(optJSONObject), (long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcrz)).intValue(), TimeUnit.SECONDS, this.zzfpq), (Object) null);
        }
        zzdyz<zzbdv> zzo = this.zzggp.zzo(zza.optString("base_url"), zza.optString("html"));
        return zzdyr.zzb(zzo, new zzcev(zzo), (Executor) zzazj.zzegu);
    }
}
