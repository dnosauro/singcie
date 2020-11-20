package com.google.android.gms.internal.ads;

import org.json.JSONException;
import org.json.JSONObject;

final class zzamr implements zzaih {
    private final /* synthetic */ zzamm zzdki;
    private final zzalo zzdkl;
    private final zzazq<O> zzdkm;

    public zzamr(zzamm zzamm, zzalo zzalo, zzazq<O> zzazq) {
        this.zzdki = zzamm;
        this.zzdkl = zzalo;
        this.zzdkm = zzazq;
    }

    public final void onFailure(String str) {
        if (str == null) {
            try {
                this.zzdkm.setException(new zzama());
            } catch (IllegalStateException unused) {
            } catch (Throwable th) {
                this.zzdkl.release();
                throw th;
            }
        } else {
            this.zzdkm.setException(new zzama(str));
        }
        this.zzdkl.release();
    }

    public final void zzc(JSONObject jSONObject) {
        try {
            this.zzdkm.set(this.zzdki.zzdke.zzd(jSONObject));
        } catch (IllegalStateException unused) {
        } catch (JSONException e) {
            this.zzdkm.setException(e);
        } catch (Throwable th) {
            this.zzdkl.release();
            throw th;
        }
        this.zzdkl.release();
    }
}
