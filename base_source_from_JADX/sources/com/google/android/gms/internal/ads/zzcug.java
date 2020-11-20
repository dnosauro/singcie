package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.view.ViewGroup;
import com.google.android.gms.internal.ads.zzbrg;

public final class zzcug extends zzcud<zzbme> {
    private final zzbwp zzexp;
    private final zzcap zzexr;
    private final zzcwq zzflx;
    private final ViewGroup zzfsx;
    private final zzbua zzful;
    private final zzbgm zzgss;
    private final zzbrg.zza zzgst;

    public zzcug(zzbgm zzbgm, zzbrg.zza zza, zzcwq zzcwq, zzbwp zzbwp, zzcap zzcap, zzbua zzbua, ViewGroup viewGroup) {
        this.zzgss = zzbgm;
        this.zzgst = zza;
        this.zzflx = zzcwq;
        this.zzexp = zzbwp;
        this.zzexr = zzcap;
        this.zzful = zzbua;
        this.zzfsx = viewGroup;
    }

    /* access modifiers changed from: protected */
    public final zzdyz<zzbme> zza(zzdnn zzdnn, Bundle bundle) {
        return this.zzgss.zzaer().zzd(this.zzgst.zza(zzdnn).zze(bundle).zzakx()).zzd(this.zzexp).zza(this.zzflx).zzb(this.zzexr).zza(new zzbnv(this.zzful)).zzd(new zzblz(this.zzfsx)).zzagz().zzagh().zzakj();
    }
}
