package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.google.android.gms.ads.impl.C2228R;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import org.json.JSONObject;

public final class zzbeg extends FrameLayout implements zzbdv {
    /* access modifiers changed from: private */
    public final zzbdv zzequ;
    private final zzbax zzeqv;
    private final AtomicBoolean zzeqw = new AtomicBoolean();

    public zzbeg(zzbdv zzbdv) {
        super(zzbdv.getContext());
        this.zzequ = zzbdv;
        this.zzeqv = new zzbax(zzbdv.zzacn(), this, this);
        if (!zzadj()) {
            addView(this.zzequ.getView());
        }
    }

    public final void destroy() {
        IObjectWrapper zzacw = zzacw();
        if (zzacw != null) {
            zzm.zzedd.post(new zzbej(zzacw));
            zzm.zzedd.postDelayed(new zzbei(this), (long) ((Integer) zzwq.zzqe().zzd(zzabf.zzcuj)).intValue());
            return;
        }
        this.zzequ.destroy();
    }

    public final String getRequestId() {
        return this.zzequ.getRequestId();
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this.zzequ.getWebView();
    }

    public final boolean isDestroyed() {
        return this.zzequ.isDestroyed();
    }

    public final void loadData(String str, String str2, String str3) {
        this.zzequ.loadData(str, str2, str3);
    }

    public final void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        this.zzequ.loadDataWithBaseURL(str, str2, str3, str4, str5);
    }

    public final void loadUrl(String str) {
        this.zzequ.loadUrl(str);
    }

    public final void onAdClicked() {
        zzbdv zzbdv = this.zzequ;
        if (zzbdv != null) {
            zzbdv.onAdClicked();
        }
    }

    public final void onPause() {
        this.zzeqv.onPause();
        this.zzequ.onPause();
    }

    public final void onResume() {
        this.zzequ.onResume();
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzequ.setOnClickListener(onClickListener);
    }

    public final void setOnTouchListener(View.OnTouchListener onTouchListener) {
        this.zzequ.setOnTouchListener(onTouchListener);
    }

    public final void setRequestedOrientation(int i) {
        this.zzequ.setRequestedOrientation(i);
    }

    public final void setWebChromeClient(WebChromeClient webChromeClient) {
        this.zzequ.setWebChromeClient(webChromeClient);
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        this.zzequ.setWebViewClient(webViewClient);
    }

    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        this.zzequ.zza(this, activity, str, str2);
    }

    public final void zza(zzb zzb) {
        this.zzequ.zza(zzb);
    }

    public final void zza(zze zze) {
        this.zzequ.zza(zze);
    }

    public final void zza(zzads zzads) {
        this.zzequ.zza(zzads);
    }

    public final void zza(zzadx zzadx) {
        this.zzequ.zza(zzadx);
    }

    public final void zza(zzbep zzbep) {
        this.zzequ.zza(zzbep);
    }

    public final void zza(zzbfn zzbfn) {
        this.zzequ.zza(zzbfn);
    }

    public final void zza(zzdmu zzdmu, zzdmz zzdmz) {
        this.zzequ.zza(zzdmu, zzdmz);
    }

    public final void zza(zzqv zzqv) {
        this.zzequ.zza(zzqv);
    }

    public final void zza(zzsc zzsc) {
        this.zzequ.zza(zzsc);
    }

    public final void zza(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        this.zzequ.zza(str, predicate);
    }

    public final void zza(String str, zzahv<? super zzbdv> zzahv) {
        this.zzequ.zza(str, zzahv);
    }

    public final void zza(String str, zzbcx zzbcx) {
        this.zzequ.zza(str, zzbcx);
    }

    public final void zza(String str, Map<String, ?> map) {
        this.zzequ.zza(str, map);
    }

    public final void zza(String str, JSONObject jSONObject) {
        this.zzequ.zza(str, jSONObject);
    }

    public final void zza(boolean z, int i, String str) {
        this.zzequ.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzequ.zza(z, i, str, str2);
    }

    public final void zza(boolean z, long j) {
        this.zzequ.zza(z, j);
    }

    public final zzbax zzaag() {
        return this.zzeqv;
    }

    public final zzbep zzaah() {
        return this.zzequ.zzaah();
    }

    public final zzabq zzaai() {
        return this.zzequ.zzaai();
    }

    public final Activity zzaaj() {
        return this.zzequ.zzaaj();
    }

    public final com.google.android.gms.ads.internal.zzb zzaak() {
        return this.zzequ.zzaak();
    }

    public final String zzaal() {
        return this.zzequ.zzaal();
    }

    public final int zzaam() {
        return this.zzequ.zzaam();
    }

    public final zzabt zzaan() {
        return this.zzequ.zzaan();
    }

    public final zzazh zzaao() {
        return this.zzequ.zzaao();
    }

    public final int zzaap() {
        return getMeasuredHeight();
    }

    public final int zzaaq() {
        return getMeasuredWidth();
    }

    public final void zzaar() {
        this.zzequ.zzaar();
    }

    public final zzdmu zzabw() {
        return this.zzequ.zzabw();
    }

    public final void zzacl() {
        this.zzequ.zzacl();
    }

    public final void zzacm() {
        this.zzequ.zzacm();
    }

    public final Context zzacn() {
        return this.zzequ.zzacn();
    }

    public final zze zzaco() {
        return this.zzequ.zzaco();
    }

    public final zze zzacp() {
        return this.zzequ.zzacp();
    }

    public final zzbfn zzacq() {
        return this.zzequ.zzacq();
    }

    public final String zzacr() {
        return this.zzequ.zzacr();
    }

    public final zzbfg zzacs() {
        return this.zzequ.zzacs();
    }

    public final WebViewClient zzact() {
        return this.zzequ.zzact();
    }

    public final boolean zzacu() {
        return this.zzequ.zzacu();
    }

    public final zzef zzacv() {
        return this.zzequ.zzacv();
    }

    public final IObjectWrapper zzacw() {
        return this.zzequ.zzacw();
    }

    public final boolean zzacx() {
        return this.zzequ.zzacx();
    }

    public final void zzacy() {
        this.zzeqv.onDestroy();
        this.zzequ.zzacy();
    }

    public final boolean zzacz() {
        return this.zzequ.zzacz();
    }

    public final boolean zzada() {
        return this.zzequ.zzada();
    }

    public final void zzadb() {
        this.zzequ.zzadb();
    }

    public final void zzadc() {
        this.zzequ.zzadc();
    }

    public final zzadx zzadd() {
        return this.zzequ.zzadd();
    }

    public final void zzade() {
        setBackgroundColor(0);
        this.zzequ.setBackgroundColor(0);
    }

    public final void zzadf() {
        TextView textView = new TextView(getContext());
        Resources resources = zzp.zzku().getResources();
        textView.setText(resources != null ? resources.getString(C2228R.string.f6897s7) : "Test Ad");
        textView.setTextSize(15.0f);
        textView.setTextColor(-1);
        textView.setPadding(5, 0, 5, 0);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setColor(-12303292);
        gradientDrawable.setCornerRadius(8.0f);
        textView.setBackground(gradientDrawable);
        addView(textView, new FrameLayout.LayoutParams(-2, -2, 49));
        bringChildToFront(textView);
    }

    public final zzsc zzadg() {
        return this.zzequ.zzadg();
    }

    public final boolean zzadh() {
        return this.zzeqw.get();
    }

    public final zzsu zzadi() {
        return this.zzequ.zzadi();
    }

    public final boolean zzadj() {
        return this.zzequ.zzadj();
    }

    public final zzdmz zzadk() {
        return this.zzequ.zzadk();
    }

    public final void zzal(boolean z) {
        this.zzequ.zzal(z);
    }

    public final void zzaq(IObjectWrapper iObjectWrapper) {
        this.zzequ.zzaq(iObjectWrapper);
    }

    public final void zzau(boolean z) {
        this.zzequ.zzau(z);
    }

    public final void zzaw(boolean z) {
        this.zzequ.zzaw(z);
    }

    public final void zzaz(boolean z) {
        this.zzequ.zzaz(z);
    }

    public final void zzb(zze zze) {
        this.zzequ.zzb(zze);
    }

    public final void zzb(String str, zzahv<? super zzbdv> zzahv) {
        this.zzequ.zzb(str, zzahv);
    }

    public final void zzb(String str, String str2, String str3) {
        this.zzequ.zzb(str, str2, str3);
    }

    public final void zzb(String str, JSONObject jSONObject) {
        this.zzequ.zzb(str, jSONObject);
    }

    public final void zzb(boolean z, int i) {
        this.zzequ.zzb(z, i);
    }

    public final void zzba(boolean z) {
        this.zzequ.zzba(z);
    }

    public final void zzbb(boolean z) {
        this.zzequ.zzbb(z);
    }

    public final void zzbx(Context context) {
        this.zzequ.zzbx(context);
    }

    public final boolean zzc(boolean z, int i) {
        if (!this.zzeqw.compareAndSet(false, true)) {
            return true;
        }
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcoe)).booleanValue()) {
            return false;
        }
        if (this.zzequ.getParent() instanceof ViewGroup) {
            ((ViewGroup) this.zzequ.getParent()).removeView(this.zzequ.getView());
        }
        return this.zzequ.zzc(z, i);
    }

    public final void zzcy(String str) {
        this.zzequ.zzcy(str);
    }

    public final void zzdq(int i) {
        this.zzequ.zzdq(i);
    }

    public final void zzdv(int i) {
        this.zzequ.zzdv(i);
    }

    public final zzbcx zzff(String str) {
        return this.zzequ.zzff(str);
    }

    public final void zzkm() {
        this.zzequ.zzkm();
    }

    public final void zzkn() {
        this.zzequ.zzkn();
    }

    public final void zzvj() {
        this.zzequ.zzvj();
    }

    public final void zzvk() {
        this.zzequ.zzvk();
    }
}
