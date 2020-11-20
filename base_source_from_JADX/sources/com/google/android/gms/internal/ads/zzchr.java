package com.google.android.gms.internal.ads;

import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.zza;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzchr {
    private final zzawq zzbof;
    private final zzckq zzdgx;
    private final zzcqo zzdgz;
    private final zzef zzerb;
    private final zzdrz zzfqa;
    private final Executor zzfqx;
    /* access modifiers changed from: private */
    public final zzbsu zzfvh;
    private final zzbtr zzfzy;
    private final zzbrt zzgas;
    private final zzbki zzgat;
    private final zzbxx zzgav;
    private final zzbti zzght;
    private final zzbvy zzghu;
    private final zza zzgik;
    private final zzbso zzgil;
    /* access modifiers changed from: private */
    public final zzbvr zzgim;

    public zzchr(zzbrt zzbrt, zzbsu zzbsu, zzbti zzbti, zzbtr zzbtr, zzbvy zzbvy, Executor executor, zzbxx zzbxx, zzbki zzbki, zza zza, zzbso zzbso, zzawq zzawq, zzef zzef, zzbvr zzbvr, zzcqo zzcqo, zzdrz zzdrz, zzckq zzckq) {
        this.zzgas = zzbrt;
        this.zzfvh = zzbsu;
        this.zzght = zzbti;
        this.zzfzy = zzbtr;
        this.zzghu = zzbvy;
        this.zzfqx = executor;
        this.zzgav = zzbxx;
        this.zzgat = zzbki;
        this.zzgik = zza;
        this.zzgil = zzbso;
        this.zzbof = zzawq;
        this.zzerb = zzef;
        this.zzgim = zzbvr;
        this.zzdgz = zzcqo;
        this.zzfqa = zzdrz;
        this.zzdgx = zzckq;
    }

    public static zzdyz<?> zza(zzbdv zzbdv, String str, String str2) {
        zzazq zzazq = new zzazq();
        zzbdv.zzacs().zza((zzbfj) new zzcic(zzazq));
        zzbdv.zzb(str, str2, (String) null);
        return zzazq;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zza(zzbdv zzbdv, zzbdv zzbdv2, Map map) {
        this.zzgat.zzf(zzbdv);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ boolean zza(View view, MotionEvent motionEvent) {
        this.zzgik.recordClick();
        zzawq zzawq = this.zzbof;
        if (zzawq == null) {
            return false;
        }
        zzawq.zzwe();
        return false;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzae(View view) {
        this.zzgik.recordClick();
        zzawq zzawq = this.zzbof;
        if (zzawq != null) {
            zzawq.zzwe();
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzapb() {
        this.zzfvh.onAdLeftApplication();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzapc() {
        this.zzgas.onAdClicked();
    }

    public final void zzb(zzbdv zzbdv, boolean z) {
        zzdv zzca;
        zzbdv zzbdv2 = zzbdv;
        zzbdv.zzacs().zza(new zzchu(this), this.zzght, this.zzfzy, new zzcht(this), new zzchw(this), z, (zzahu) null, this.zzgik, new zzcib(this), this.zzbof, this.zzdgz, this.zzfqa, this.zzdgx);
        zzbdv2.setOnTouchListener(new zzchv(this));
        zzbdv2.setOnClickListener(new zzchy(this));
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcra)).booleanValue() && (zzca = this.zzerb.zzca()) != null) {
            zzca.zzb(zzbdv.getView());
        }
        this.zzgav.zza(zzbdv2, this.zzfqx);
        this.zzgav.zza(new zzchx(zzbdv2), this.zzfqx);
        this.zzgav.zzv(zzbdv.getView());
        zzbdv2.zza("/trackActiveViewUnit", (zzahv<? super zzbdv>) new zzcia(this, zzbdv2));
        this.zzgat.zzo(zzbdv2);
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcoh)).booleanValue()) {
            zzbso zzbso = this.zzgil;
            zzbdv.getClass();
            zzbso.zza(zzchz.zzn(zzbdv), this.zzfqx);
        }
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzp(String str, String str2) {
        this.zzghu.onAppEvent(str, str2);
    }
}
