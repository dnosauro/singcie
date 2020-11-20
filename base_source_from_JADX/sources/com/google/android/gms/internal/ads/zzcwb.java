package com.google.android.gms.internal.ads;

import android.os.Bundle;
import android.os.IBinder;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.internal.overlay.zzl;

public class zzcwb extends zzanr {
    private final zzbte zzfus;
    private final zzbsu zzfvh;
    private final zzbsb zzfzu;
    private final zzbtr zzfzy;
    private final zzbsl zzgar;
    private final zzbrt zzgas;
    private final zzbvy zzghu;
    private final zzbvv zzgtz;
    private final zzbyn zzgug;

    public zzcwb(zzbrt zzbrt, zzbsl zzbsl, zzbsu zzbsu, zzbte zzbte, zzbvy zzbvy, zzbtr zzbtr, zzbyn zzbyn, zzbvv zzbvv, zzbsb zzbsb) {
        this.zzgas = zzbrt;
        this.zzgar = zzbsl;
        this.zzfvh = zzbsu;
        this.zzfus = zzbte;
        this.zzghu = zzbvy;
        this.zzfzy = zzbtr;
        this.zzgug = zzbyn;
        this.zzgtz = zzbvv;
        this.zzfzu = zzbsb;
    }

    public final void onAdClicked() {
        this.zzgas.onAdClicked();
    }

    public final void onAdClosed() {
        this.zzfzy.zza(zzl.OTHER);
    }

    public final void onAdFailedToLoad(int i) {
    }

    public void onAdImpression() {
        this.zzgar.onAdImpression();
        this.zzgtz.zzakm();
    }

    public final void onAdLeftApplication() {
        this.zzfvh.onAdLeftApplication();
    }

    public final void onAdLoaded() {
        this.zzfus.onAdLoaded();
    }

    public final void onAdOpened() {
        this.zzfzy.zzux();
        this.zzgtz.zzako();
    }

    public final void onAppEvent(String str, String str2) {
        this.zzghu.onAppEvent(str, str2);
    }

    public void onVideoEnd() {
        this.zzgug.onVideoEnd();
    }

    public final void onVideoPause() {
        this.zzgug.onVideoPause();
    }

    public final void onVideoPlay() {
        this.zzgug.onVideoPlay();
    }

    public final void zza(zzaff zzaff, String str) {
    }

    public final void zza(zzant zzant) {
    }

    public void zza(zzavc zzavc) {
    }

    public final void zzb(Bundle bundle) {
    }

    public void zzb(zzava zzava) {
    }

    public final void zzc(int i, String str) {
    }

    public final void zzc(zzve zzve) {
    }

    @Deprecated
    public final void zzdc(int i) {
        zze(new zzve(i, "", AdError.UNDEFINED_DOMAIN, (zzve) null, (IBinder) null));
    }

    public final void zzdj(String str) {
    }

    public final void zzdk(String str) {
        zze(new zzve(0, str, AdError.UNDEFINED_DOMAIN, (zzve) null, (IBinder) null));
    }

    public final void zze(zzve zzve) {
        this.zzfzu.zzl(zzdoi.zza(zzdok.MEDIATION_SHOW_ERROR, zzve));
    }

    public void zzun() {
        this.zzgug.onVideoStart();
    }

    public void zzuo() {
    }
}
