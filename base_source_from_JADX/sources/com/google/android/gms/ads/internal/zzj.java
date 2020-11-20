package com.google.android.gms.ads.internal;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import com.google.android.gms.actions.SearchIntents;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzaak;
import com.google.android.gms.internal.ads.zzacb;
import com.google.android.gms.internal.ads.zzacr;
import com.google.android.gms.internal.ads.zzart;
import com.google.android.gms.internal.ads.zzarz;
import com.google.android.gms.internal.ads.zzaup;
import com.google.android.gms.internal.ads.zzayr;
import com.google.android.gms.internal.ads.zzazh;
import com.google.android.gms.internal.ads.zzazj;
import com.google.android.gms.internal.ads.zzef;
import com.google.android.gms.internal.ads.zzei;
import com.google.android.gms.internal.ads.zzsl;
import com.google.android.gms.internal.ads.zzvk;
import com.google.android.gms.internal.ads.zzvn;
import com.google.android.gms.internal.ads.zzvw;
import com.google.android.gms.internal.ads.zzwq;
import com.google.android.gms.internal.ads.zzws;
import com.google.android.gms.internal.ads.zzwt;
import com.google.android.gms.internal.ads.zzxf;
import com.google.android.gms.internal.ads.zzxj;
import com.google.android.gms.internal.ads.zzxo;
import com.google.android.gms.internal.ads.zzxu;
import com.google.android.gms.internal.ads.zzym;
import com.google.android.gms.internal.ads.zzyn;
import com.google.android.gms.internal.ads.zzys;
import com.google.android.gms.internal.ads.zzyy;
import java.util.Map;
import java.util.concurrent.Future;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
public final class zzj extends zzxf {
    /* access modifiers changed from: private */
    public final Context context;
    /* access modifiers changed from: private */
    public final zzazh zzbpd;
    private final zzvn zzbpe;
    /* access modifiers changed from: private */
    public final Future<zzef> zzbpf = zzazj.zzegp.zze(new zzo(this));
    private final zzq zzbpg;
    /* access modifiers changed from: private */
    public WebView zzbph = new WebView(this.context);
    /* access modifiers changed from: private */
    public zzwt zzbpi;
    /* access modifiers changed from: private */
    public zzef zzbpj;
    private AsyncTask<Void, Void, String> zzbpk;

    public zzj(Context context2, zzvn zzvn, String str, zzazh zzazh) {
        this.context = context2;
        this.zzbpd = zzazh;
        this.zzbpe = zzvn;
        this.zzbpg = new zzq(context2, str);
        zzbq(0);
        this.zzbph.setVerticalScrollBarEnabled(false);
        this.zzbph.getSettings().setJavaScriptEnabled(true);
        this.zzbph.setWebViewClient(new zzm(this));
        this.zzbph.setOnTouchListener(new zzl(this));
    }

    /* access modifiers changed from: private */
    public final String zzbn(String str) {
        if (this.zzbpj == null) {
            return str;
        }
        Uri parse = Uri.parse(str);
        try {
            parse = this.zzbpj.zza(parse, this.context, (View) null, (Activity) null);
        } catch (zzei e) {
            zzd.zzd("Unable to process ad data", e);
        }
        return parse.toString();
    }

    /* access modifiers changed from: private */
    public final void zzbo(String str) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(str));
        this.context.startActivity(intent);
    }

    public final void destroy() {
        Preconditions.checkMainThread("destroy must be called on the main UI thread.");
        this.zzbpk.cancel(true);
        this.zzbpf.cancel(true);
        this.zzbph.destroy();
        this.zzbph = null;
    }

    public final Bundle getAdMetadata() {
        throw new IllegalStateException("Unused method");
    }

    public final String getAdUnitId() {
        throw new IllegalStateException("getAdUnitId not implemented");
    }

    public final String getMediationAdapterClassName() {
        return null;
    }

    public final zzys getVideoController() {
        return null;
    }

    public final boolean isLoading() {
        return false;
    }

    public final boolean isReady() {
        return false;
    }

    public final void pause() {
        Preconditions.checkMainThread("pause must be called on the main UI thread.");
    }

    public final void resume() {
        Preconditions.checkMainThread("resume must be called on the main UI thread.");
    }

    public final void setImmersiveMode(boolean z) {
        throw new IllegalStateException("Unused method");
    }

    public final void setManualImpressionsEnabled(boolean z) {
    }

    public final void setUserId(String str) {
        throw new IllegalStateException("Unused method");
    }

    public final void showInterstitial() {
        throw new IllegalStateException("Unused method");
    }

    public final void stopLoading() {
    }

    public final void zza(zzaak zzaak) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzacb zzacb) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzart zzart) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzarz zzarz, String str) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzaup zzaup) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzsl zzsl) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzvn zzvn) {
        throw new IllegalStateException("AdSize must be set before initialization");
    }

    public final void zza(zzvw zzvw) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzws zzws) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzwt zzwt) {
        this.zzbpi = zzwt;
    }

    public final void zza(zzxj zzxj) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzxo zzxo) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzxu zzxu) {
        throw new IllegalStateException("Unused method");
    }

    public final void zza(zzym zzym) {
    }

    public final void zza(zzyy zzyy) {
        throw new IllegalStateException("Unused method");
    }

    public final boolean zza(zzvk zzvk) {
        Preconditions.checkNotNull(this.zzbph, "This Search Ad has already been torn down");
        this.zzbpg.zza(zzvk, this.zzbpd);
        this.zzbpk = new zzn(this, (zzm) null).execute(new Void[0]);
        return true;
    }

    public final void zzbl(String str) {
        throw new IllegalStateException("Unused method");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final int zzbm(String str) {
        String queryParameter = Uri.parse(str).getQueryParameter("height");
        if (TextUtils.isEmpty(queryParameter)) {
            return 0;
        }
        try {
            zzwq.zzqa();
            return zzayr.zzc(this.context, Integer.parseInt(queryParameter));
        } catch (NumberFormatException unused) {
            return 0;
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzbq(int i) {
        if (this.zzbph != null) {
            this.zzbph.setLayoutParams(new ViewGroup.LayoutParams(-1, i));
        }
    }

    public final IObjectWrapper zzkd() {
        Preconditions.checkMainThread("getAdFrame must be called on the main UI thread.");
        return ObjectWrapper.wrap(this.zzbph);
    }

    public final void zzke() {
        throw new IllegalStateException("Unused method");
    }

    public final zzvn zzkf() {
        return this.zzbpe;
    }

    public final String zzkg() {
        return null;
    }

    public final zzyn zzkh() {
        return null;
    }

    public final zzxo zzki() {
        throw new IllegalStateException("getIAppEventListener not implemented");
    }

    public final zzwt zzkj() {
        throw new IllegalStateException("getIAdListener not implemented");
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final String zzkk() {
        Uri.Builder builder = new Uri.Builder();
        builder.scheme("https://").appendEncodedPath(zzacr.zzdbi.get());
        builder.appendQueryParameter(SearchIntents.EXTRA_QUERY, this.zzbpg.getQuery());
        builder.appendQueryParameter("pubId", this.zzbpg.zzlq());
        Map<String, String> zzlr = this.zzbpg.zzlr();
        for (String next : zzlr.keySet()) {
            builder.appendQueryParameter(next, zzlr.get(next));
        }
        Uri build = builder.build();
        zzef zzef = this.zzbpj;
        if (zzef != null) {
            try {
                build = zzef.zza(build, this.context);
            } catch (zzei e) {
                zzd.zzd("Unable to process ad data", e);
            }
        }
        String zzkl = zzkl();
        String encodedQuery = build.getEncodedQuery();
        StringBuilder sb = new StringBuilder(String.valueOf(zzkl).length() + 1 + String.valueOf(encodedQuery).length());
        sb.append(zzkl);
        sb.append("#");
        sb.append(encodedQuery);
        return sb.toString();
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final String zzkl() {
        String zzlp = this.zzbpg.zzlp();
        if (TextUtils.isEmpty(zzlp)) {
            zzlp = "www.google.com";
        }
        String str = zzacr.zzdbi.get();
        StringBuilder sb = new StringBuilder(String.valueOf(zzlp).length() + 8 + String.valueOf(str).length());
        sb.append("https://");
        sb.append(zzlp);
        sb.append(str);
        return sb.toString();
    }
}
