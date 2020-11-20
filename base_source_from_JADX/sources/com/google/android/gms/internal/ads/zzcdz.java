package com.google.android.gms.internal.ads;

import android.content.Context;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzbk;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzcdz implements zzccm {
    private final Context context;
    private final zzazh zzbpd;
    private final zzdmu zzeri;
    private final zzdnn zzfvl;
    private final zzbsl zzgar;
    private final zzbrt zzgas;
    private boolean zzgaw = false;
    private boolean zzgaz = false;
    private final zzanv zzgfn;
    private final zzanw zzgfo;
    private final zzaob zzgfp;
    private boolean zzgfq = true;

    public zzcdz(zzanv zzanv, zzanw zzanw, zzaob zzaob, zzbsl zzbsl, zzbrt zzbrt, Context context2, zzdmu zzdmu, zzazh zzazh, zzdnn zzdnn) {
        this.zzgfn = zzanv;
        this.zzgfo = zzanw;
        this.zzgfp = zzaob;
        this.zzgar = zzbsl;
        this.zzgas = zzbrt;
        this.context = context2;
        this.zzeri = zzdmu;
        this.zzbpd = zzazh;
        this.zzfvl = zzdnn;
    }

    private final void zzad(View view) {
        try {
            if (this.zzgfp != null && !this.zzgfp.getOverrideClickHandling()) {
                this.zzgfp.zzu(ObjectWrapper.wrap(view));
                this.zzgas.onAdClicked();
            } else if (this.zzgfn != null && !this.zzgfn.getOverrideClickHandling()) {
                this.zzgfn.zzu(ObjectWrapper.wrap(view));
                this.zzgas.onAdClicked();
            } else if (this.zzgfo != null && !this.zzgfo.getOverrideClickHandling()) {
                this.zzgfo.zzu(ObjectWrapper.wrap(view));
                this.zzgas.onAdClicked();
            }
        } catch (RemoteException e) {
            zzd.zzd("Failed to call handleClick", e);
        }
    }

    private static HashMap<String, View> zzb(Map<String, WeakReference<View>> map) {
        HashMap<String, View> hashMap = new HashMap<>();
        if (map == null) {
            return hashMap;
        }
        synchronized (map) {
            for (Map.Entry next : map.entrySet()) {
                View view = (View) ((WeakReference) next.getValue()).get();
                if (view != null) {
                    hashMap.put((String) next.getKey(), view);
                }
            }
        }
        return hashMap;
    }

    private final boolean zzb(Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        View view;
        JSONObject jSONObject = this.zzeri.zzhhr;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqi)).booleanValue() && jSONObject.length() != 0) {
            if (map == null) {
                map = new HashMap<>();
            }
            if (map2 == null) {
                map2 = new HashMap<>();
            }
            HashMap hashMap = new HashMap();
            hashMap.putAll(map);
            hashMap.putAll(map2);
            Iterator<String> keys = jSONObject.keys();
            while (keys.hasNext()) {
                String next = keys.next();
                JSONArray optJSONArray = jSONObject.optJSONArray(next);
                if (optJSONArray != null) {
                    WeakReference weakReference = (WeakReference) hashMap.get(next);
                    if (weakReference == null || (view = (View) weakReference.get()) == null) {
                        return false;
                    }
                    Class<?> cls = view.getClass();
                    try {
                        ArrayList arrayList = new ArrayList();
                        zzbk.zza(optJSONArray, (List<String>) arrayList);
                        zzp.zzkq();
                        if (!zzm.zza(this.context.getClassLoader(), cls, (List<String>) arrayList)) {
                            return false;
                        }
                    } catch (JSONException unused) {
                        continue;
                    }
                }
            }
        }
        return true;
    }

    public final void cancelUnconfirmedClick() {
    }

    public final void destroy() {
    }

    public final boolean isCustomClickGestureEnabled() {
        return this.zzeri.zzdmh;
    }

    public final void setClickConfirmingView(View view) {
    }

    public final JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return null;
    }

    public final void zza(View view, MotionEvent motionEvent, View view2) {
    }

    public final void zza(View view, View view2, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        if (!this.zzgaz || !this.zzeri.zzdmh) {
            zzad(view);
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            if (this.zzgfp != null) {
                this.zzgfp.zzw(wrap);
            } else if (this.zzgfn != null) {
                this.zzgfn.zzw(wrap);
            } else if (this.zzgfo != null) {
                this.zzgfo.zzw(wrap);
            }
        } catch (RemoteException e) {
            zzd.zzd("Failed to call untrackView", e);
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, View.OnTouchListener onTouchListener, View.OnClickListener onClickListener) {
        try {
            IObjectWrapper wrap = ObjectWrapper.wrap(view);
            this.zzgfq = zzb(map, map2);
            HashMap<String, View> zzb = zzb(map);
            HashMap<String, View> zzb2 = zzb(map2);
            if (this.zzgfp != null) {
                this.zzgfp.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
            } else if (this.zzgfn != null) {
                this.zzgfn.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzgfn.zzv(wrap);
            } else if (this.zzgfo != null) {
                this.zzgfo.zzc(wrap, ObjectWrapper.wrap(zzb), ObjectWrapper.wrap(zzb2));
                this.zzgfo.zzv(wrap);
            }
        } catch (RemoteException e) {
            zzd.zzd("Failed to call trackView", e);
        }
    }

    public final void zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2, boolean z) {
        String str;
        if (!this.zzgaz) {
            str = "Custom click reporting for 3p ads failed. enableCustomClickGesture is not set.";
        } else if (!this.zzeri.zzdmh) {
            str = "Custom click reporting for 3p ads failed. Ad unit id not whitelisted.";
        } else {
            zzad(view);
            return;
        }
        zzd.zzfa(str);
    }

    public final void zza(zzage zzage) {
    }

    public final void zza(zzxz zzxz) {
        zzd.zzfa("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zza(zzyd zzyd) {
        zzd.zzfa("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzamr() {
    }

    public final void zzams() {
        zzd.zzfa("Mute This Ad is not supported for 3rd party ads");
    }

    public final void zzamt() {
    }

    public final void zzb(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        try {
            if (!this.zzgaw && this.zzeri.zzhhc != null) {
                this.zzgaw |= zzp.zzla().zzb(this.context, this.zzbpd.zzbrf, this.zzeri.zzhhc.toString(), this.zzfvl.zzhip);
            }
            if (this.zzgfq) {
                if (this.zzgfp != null && !this.zzgfp.getOverrideImpressionRecording()) {
                    this.zzgfp.recordImpression();
                    this.zzgar.onAdImpression();
                } else if (this.zzgfn != null && !this.zzgfn.getOverrideImpressionRecording()) {
                    this.zzgfn.recordImpression();
                    this.zzgar.onAdImpression();
                } else if (this.zzgfo != null && !this.zzgfo.getOverrideImpressionRecording()) {
                    this.zzgfo.recordImpression();
                    this.zzgar.onAdImpression();
                }
            }
        } catch (RemoteException e) {
            zzd.zzd("Failed to call recordImpression", e);
        }
    }

    public final void zzf(Bundle bundle) {
    }

    public final void zzfw(String str) {
    }

    public final void zzg(Bundle bundle) {
    }

    public final boolean zzh(Bundle bundle) {
        return false;
    }

    public final void zztg() {
        this.zzgaz = true;
    }
}
