package com.google.android.gms.internal.ads;

import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

public final class zzcdi {
    private final zzccm zzgbt;
    private final zzcgh zzgep;
    private final zzchp zzgey;
    private final zzbkr zzgez;

    public zzcdi(zzchp zzchp, zzcgh zzcgh, zzbkr zzbkr, zzccm zzccm) {
        this.zzgey = zzchp;
        this.zzgep = zzcgh;
        this.zzgez = zzbkr;
        this.zzgbt = zzccm;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbdv zzbdv, Map map) {
        zzd.zzez("Hiding native ads overlay.");
        zzbdv.getView().setVisibility(8);
        this.zzgez.zzbe(false);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(Map map, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("messageType", "htmlLoaded");
        hashMap.put("id", (String) map.get("id"));
        this.zzgep.zza("sendMessageToNativeJs", (Map<String, ?>) hashMap);
    }

    public final View zzaon() {
        zzbdv zzd = this.zzgey.zzd(zzvn.zzpo());
        zzd.getView().setVisibility(8);
        zzd.zza("/sendMessageToSdk", (zzahv<? super zzbdv>) new zzcdh(this));
        zzd.zza("/adMuted", (zzahv<? super zzbdv>) new zzcdk(this));
        this.zzgep.zza(new WeakReference(zzd), "/loadHtml", new zzcdj(this));
        this.zzgep.zza(new WeakReference(zzd), "/showOverlay", new zzcdm(this));
        this.zzgep.zza(new WeakReference(zzd), "/hideOverlay", new zzcdl(this));
        return zzd.getView();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(zzbdv zzbdv, Map map) {
        zzd.zzez("Showing native ads overlay.");
        zzbdv.getView().setVisibility(0);
        this.zzgez.zzbe(true);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzc(zzbdv zzbdv, Map map) {
        this.zzgbt.zzams();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzd(zzbdv zzbdv, Map map) {
        this.zzgep.zza("sendMessageToNativeJs", (Map<String, ?>) map);
    }
}
