package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import javax.annotation.ParametersAreNonnullByDefault;

@ParametersAreNonnullByDefault
@VisibleForTesting
public interface zzbdv extends zzk, zzakb, zzaky, zzbbe, zzbdk, zzbeq, zzbew, zzbex, zzbfa, zzbfe, zzbff, zzbfh, zzqu, zzva {
    void destroy();

    Context getContext();

    int getHeight();

    ViewGroup.LayoutParams getLayoutParams();

    void getLocationOnScreen(int[] iArr);

    ViewParent getParent();

    View getView();

    WebView getWebView();

    int getWidth();

    boolean isDestroyed();

    void loadData(String str, String str2, String str3);

    void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5);

    void loadUrl(String str);

    void measure(int i, int i2);

    void onPause();

    void onResume();

    void setBackgroundColor(int i);

    void setOnClickListener(View.OnClickListener onClickListener);

    void setOnTouchListener(View.OnTouchListener onTouchListener);

    void setRequestedOrientation(int i);

    void setWebChromeClient(WebChromeClient webChromeClient);

    void setWebViewClient(WebViewClient webViewClient);

    void zza(ViewGroup viewGroup, Activity activity, String str, String str2);

    void zza(zze zze);

    void zza(zzads zzads);

    void zza(zzadx zzadx);

    void zza(zzbep zzbep);

    void zza(zzbfn zzbfn);

    void zza(zzdmu zzdmu, zzdmz zzdmz);

    void zza(zzsc zzsc);

    void zza(String str, Predicate<zzahv<? super zzbdv>> predicate);

    void zza(String str, zzahv<? super zzbdv> zzahv);

    void zza(String str, zzbcx zzbcx);

    zzbep zzaah();

    Activity zzaaj();

    zzb zzaak();

    zzabt zzaan();

    zzazh zzaao();

    zzdmu zzabw();

    void zzacl();

    void zzacm();

    Context zzacn();

    zze zzaco();

    zze zzacp();

    zzbfn zzacq();

    String zzacr();

    zzbfg zzacs();

    WebViewClient zzact();

    boolean zzacu();

    zzef zzacv();

    IObjectWrapper zzacw();

    boolean zzacx();

    void zzacy();

    boolean zzacz();

    boolean zzada();

    void zzadb();

    void zzadc();

    zzadx zzadd();

    void zzade();

    void zzadf();

    zzsc zzadg();

    boolean zzadh();

    zzsu zzadi();

    boolean zzadj();

    zzdmz zzadk();

    void zzal(boolean z);

    void zzaq(IObjectWrapper iObjectWrapper);

    void zzaw(boolean z);

    void zzaz(boolean z);

    void zzb(zze zze);

    void zzb(String str, zzahv<? super zzbdv> zzahv);

    void zzb(String str, String str2, String str3);

    void zzba(boolean z);

    void zzbb(boolean z);

    void zzbx(Context context);

    boolean zzc(boolean z, int i);

    void zzdv(int i);

    void zzvj();
}
