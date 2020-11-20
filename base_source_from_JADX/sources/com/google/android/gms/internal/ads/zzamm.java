package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import javax.annotation.ParametersAreNonnullByDefault;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
public final class zzamm<I, O> implements zzamd<I, O> {
    private final zzalb zzdkd;
    /* access modifiers changed from: private */
    public final zzamf<O> zzdke;
    private final zzame<I> zzdkf;
    private final String zzdkg;

    zzamm(zzalb zzalb, String str, zzame<I> zzame, zzamf<O> zzamf) {
        this.zzdkd = zzalb;
        this.zzdkg = str;
        this.zzdkf = zzame;
        this.zzdke = zzamf;
    }

    /* access modifiers changed from: private */
    public final void zza(zzalo zzalo, zzalz zzalz, I i, zzazq<O> zzazq) {
        try {
            zzp.zzkq();
            String zzyf = zzm.zzyf();
            zzahc.zzdgi.zza(zzyf, (zzaih) new zzamr(this, zzalo, zzazq));
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", zzyf);
            jSONObject.put("args", this.zzdkf.zzj(i));
            zzalz.zza(this.zzdkg, jSONObject);
        } catch (Exception e) {
            zzazq.setException(e);
            zzd.zzc("Unable to invokeJavascript", e);
            zzalo.release();
        } catch (Throwable th) {
            zzalo.release();
            throw th;
        }
    }

    public final zzdyz<O> zzf(I i) {
        return zzi(i);
    }

    public final zzdyz<O> zzi(I i) {
        zzazq zzazq = new zzazq();
        zzalo zzb = this.zzdkd.zzb((zzef) null);
        zzb.zza(new zzamp(this, zzb, i, zzazq), new zzamo(this, zzazq, zzb));
        return zzazq;
    }
}
