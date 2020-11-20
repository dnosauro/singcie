package com.google.android.gms.internal.ads;

import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.ads.internal.zzp;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcff {
    private final Executor zzfqx;
    private final zzdnn zzfvl;
    private final zzchp zzgey;

    public zzcff(zzdnn zzdnn, Executor executor, zzchp zzchp) {
        this.zzfvl = zzdnn;
        this.zzfqx = executor;
        this.zzgey = zzchp;
    }

    private final void zzk(zzbdv zzbdv) {
        zzbdv.zza("/video", (zzahv<? super zzbdv>) zzahc.zzdgf);
        zzbdv.zza("/videoMeta", (zzahv<? super zzbdv>) zzahc.zzdgg);
        zzbdv.zza("/precache", (zzahv<? super zzbdv>) new zzbdc());
        zzbdv.zza("/delayPageLoaded", (zzahv<? super zzbdv>) zzahc.zzdgj);
        zzbdv.zza("/instrument", (zzahv<? super zzbdv>) zzahc.zzdgh);
        zzbdv.zza("/log", (zzahv<? super zzbdv>) zzahc.zzdga);
        zzbdv.zza("/videoClicked", (zzahv<? super zzbdv>) zzahc.zzdgb);
        zzbdv.zzacs().zzax(true);
        zzbdv.zza("/click", (zzahv<? super zzbdv>) zzahc.zzdfw);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcry)).booleanValue()) {
            zzbdv.zza("/getNativeAdViewSignals", (zzahv<? super zzbdv>) zzahc.zzdgm);
        }
        if (this.zzfvl.zzdui != null) {
            zzbdv.zzacs().zzay(true);
            zzbdv.zza("/open", (zzahv<? super zzbdv>) new zzahz((zza) null, (zzaqk) null, (zzcqo) null, (zzckq) null));
        } else {
            zzbdv.zzacs().zzay(false);
        }
        if (zzp.zzlo().zzz(zzbdv.getContext())) {
            zzbdv.zza("/logScionEvent", (zzahv<? super zzbdv>) new zzahx(zzbdv.getContext()));
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(String str, String str2, Object obj) {
        zzbdv zzd = this.zzgey.zzd(zzvn.zzpo());
        zzazr zzl = zzazr.zzl(zzd);
        zzk(zzd);
        zzd.zza(this.zzfvl.zzdui != null ? zzbfn.zzadx() : zzbfn.zzadw());
        zzd.zzacs().zza((zzbfj) new zzcfm(this, zzd, zzl));
        zzd.zzb(str, str2, (String) null);
        return zzl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zza(JSONObject jSONObject, zzbdv zzbdv) {
        zzazr zzl = zzazr.zzl(zzbdv);
        zzbdv.zza(this.zzfvl.zzdui != null ? zzbfn.zzadx() : zzbfn.zzadw());
        zzbdv.zzacs().zza((zzbfj) new zzcfl(this, zzbdv, zzl));
        zzbdv.zza("google.afma.nativeAds.renderVideo", jSONObject);
        return zzl;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbdv zzbdv, zzazr zzazr, boolean z) {
        if (z) {
            if (!(this.zzfvl.zzhin == null || zzbdv.zzaah() == null)) {
                zzbdv.zzaah().zzb(this.zzfvl.zzhin);
            }
            zzazr.zzzj();
            return;
        }
        zzazr.setException(new zzcuq(zzdok.INTERNAL_ERROR, "Instream video Web View failed to load."));
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbdv zzbdv, zzazr zzazr, boolean z) {
        if (!(this.zzfvl.zzhin == null || zzbdv.zzaah() == null)) {
            zzbdv.zzaah().zzb(this.zzfvl.zzhin);
        }
        zzazr.zzzj();
    }

    public final zzdyz<zzbdv> zzn(JSONObject jSONObject) {
        return zzdyr.zzb(zzdyr.zzb(zzdyr.zzag(null), new zzcfk(this), this.zzfqx), new zzcfi(this, jSONObject), this.zzfqx);
    }

    public final zzdyz<zzbdv> zzo(String str, String str2) {
        return zzdyr.zzb(zzdyr.zzag(null), new zzcfh(this, str, str2), this.zzfqx);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ zzdyz zzr(Object obj) {
        zzbdv zzd = this.zzgey.zzd(zzvn.zzpo());
        zzazr zzl = zzazr.zzl(zzd);
        zzk(zzd);
        zzd.zzacs().zza((zzbfi) new zzcfj(zzl));
        zzd.loadUrl((String) zzwq.zzqe().zzd(zzabf.zzcrx));
        return zzl;
    }
}
