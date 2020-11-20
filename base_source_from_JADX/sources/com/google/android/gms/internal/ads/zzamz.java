package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

final class zzamz implements zzaih {
    private final zzazq<O> zzdkm;
    private final /* synthetic */ zzamx zzdkp;

    public zzamz(zzamx zzamx, zzazq<O> zzazq) {
        this.zzdkp = zzamx;
        this.zzdkm = zzazq;
    }

    public final void onFailure(String str) {
        if (str == null) {
            try {
                this.zzdkm.setException(new zzama());
            } catch (IllegalStateException unused) {
            }
        } else {
            this.zzdkm.setException(new zzama(str));
        }
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdkm.set(this.zzdkp.zzdke.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdkm.setException(e);
        }
    }
}
