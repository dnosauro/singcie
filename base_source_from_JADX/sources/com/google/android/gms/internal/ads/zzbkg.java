package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.os.PowerManager;
import android.text.TextUtils;
import android.view.Display;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.zzp;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public final class zzbkg implements zzame<zzbkk> {
    private final Context context;
    private final PowerManager zzaab;
    private final zzqr zzfqr;

    public zzbkg(Context context2, zzqr zzqr) {
        this.context = context2;
        this.zzfqr = zzqr;
        this.zzaab = (PowerManager) context2.getSystemService("power");
    }

    /* renamed from: zza */
    public final JSONObject zzj(zzbkk zzbkk) {
        JSONObject jSONObject;
        JSONArray jSONArray = new JSONArray();
        JSONObject jSONObject2 = new JSONObject();
        if (zzbkk.zzfrj == null) {
            jSONObject = new JSONObject();
        } else {
            zzqv zzqv = zzbkk.zzfrj;
            if (this.zzfqr.zzlw() != null) {
                boolean z = zzqv.zzbrl;
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("afmaVersion", this.zzfqr.zzlv()).put("activeViewJSON", this.zzfqr.zzlw()).put("timestamp", zzbkk.timestamp).put("adFormat", this.zzfqr.zzlu()).put("hashCode", this.zzfqr.getUniqueId()).put("isMraid", false).put("isStopped", false).put("isPaused", zzbkk.zzfrg).put("isNative", this.zzfqr.isNative()).put("isScreenOn", Build.VERSION.SDK_INT >= 20 ? this.zzaab.isInteractive() : this.zzaab.isScreenOn()).put("appMuted", zzp.zzkv().zzql()).put("appVolume", (double) zzp.zzkv().zzqk()).put("deviceVolume", (double) zzad.zzbi(this.context.getApplicationContext()));
                Rect rect = new Rect();
                Display defaultDisplay = ((WindowManager) this.context.getSystemService("window")).getDefaultDisplay();
                rect.right = defaultDisplay.getWidth();
                rect.bottom = defaultDisplay.getHeight();
                jSONObject3.put("windowVisibility", zzqv.zzaai).put("isAttachedToWindow", z).put("viewBox", new JSONObject().put("top", zzqv.zzbrm.top).put("bottom", zzqv.zzbrm.bottom).put("left", zzqv.zzbrm.left).put("right", zzqv.zzbrm.right)).put("adBox", new JSONObject().put("top", zzqv.zzbrn.top).put("bottom", zzqv.zzbrn.bottom).put("left", zzqv.zzbrn.left).put("right", zzqv.zzbrn.right)).put("globalVisibleBox", new JSONObject().put("top", zzqv.zzbro.top).put("bottom", zzqv.zzbro.bottom).put("left", zzqv.zzbro.left).put("right", zzqv.zzbro.right)).put("globalVisibleBoxVisible", zzqv.zzbrp).put("localVisibleBox", new JSONObject().put("top", zzqv.zzbrq.top).put("bottom", zzqv.zzbrq.bottom).put("left", zzqv.zzbrq.left).put("right", zzqv.zzbrq.right)).put("localVisibleBoxVisible", zzqv.zzbrr).put("hitBox", new JSONObject().put("top", zzqv.zzbrs.top).put("bottom", zzqv.zzbrs.bottom).put("left", zzqv.zzbrs.left).put("right", zzqv.zzbrs.right)).put("screenDensity", (double) this.context.getResources().getDisplayMetrics().density);
                jSONObject3.put("isVisible", zzbkk.zzbqz);
                if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcpx)).booleanValue()) {
                    JSONArray jSONArray2 = new JSONArray();
                    if (zzqv.zzbru != null) {
                        for (Rect next : zzqv.zzbru) {
                            jSONArray2.put(new JSONObject().put("top", next.top).put("bottom", next.bottom).put("left", next.left).put("right", next.right));
                        }
                    }
                    jSONObject3.put("scrollableContainerBoxes", jSONArray2);
                }
                if (!TextUtils.isEmpty(zzbkk.zzfri)) {
                    jSONObject3.put("doneReasonCode", "u");
                }
                jSONObject = jSONObject3;
            } else {
                throw new JSONException("Active view Info cannot be null.");
            }
        }
        jSONArray.put(jSONObject);
        jSONObject2.put("units", jSONArray);
        return jSONObject2;
    }
}
