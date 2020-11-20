package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import androidx.core.p030h.C0656u;
import com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel;
import com.google.android.gms.ads.internal.overlay.zzb;
import com.google.android.gms.ads.internal.overlay.zzo;
import com.google.android.gms.ads.internal.overlay.zzp;
import com.google.android.gms.ads.internal.overlay.zzu;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zza;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;

@ParametersAreNonnullByDefault
@VisibleForTesting
public final class zzbfm extends zzbfz implements zzbfg {
    private final Object lock = new Object();
    private volatile boolean zzbrg;
    private zzva zzcgp;
    private zzagy zzdfr;
    private zzaha zzdfs;
    private zza zzdgo;
    private zzaqk zzdgp;
    private zzp zzdrm;
    private zzu zzdrq;
    private boolean zzdvo;
    protected zzbdv zzepg;
    private zzbfj zzepj;
    private zzbfi zzepk;
    private zzbfl zzepl;
    private boolean zzepm = false;
    @GuardedBy("lock")
    private boolean zzepn;
    @GuardedBy("lock")
    private boolean zzepo;
    @GuardedBy("lock")
    private boolean zzepp;
    private zzaqv zzepq;
    private zzawq zzepr;
    private boolean zzeps;
    private boolean zzept;
    private int zzepu;
    private View.OnAttachStateChangeListener zzepv;
    private final zzakn<zzbdv> zzetd = new zzakn<>();

    /* access modifiers changed from: private */
    public final void zza(View view, zzawq zzawq, int i) {
        if (zzawq.zzwd() && i > 0) {
            zzawq.zzl(view);
            if (zzawq.zzwd()) {
                zzm.zzedd.postDelayed(new zzbfo(this, view, zzawq, i), 100);
            }
        }
    }

    private final void zza(AdOverlayInfoParcel adOverlayInfoParcel) {
        zzaqk zzaqk = this.zzdgp;
        boolean z = false;
        boolean zzuy = zzaqk != null ? zzaqk.zzuy() : false;
        com.google.android.gms.ads.internal.zzp.zzkp();
        Context context = this.zzepg.getContext();
        if (!zzuy) {
            z = true;
        }
        zzo.zza(context, adOverlayInfoParcel, z);
        if (this.zzepr != null) {
            String str = adOverlayInfoParcel.url;
            if (str == null && adOverlayInfoParcel.zzdrl != null) {
                str = adOverlayInfoParcel.zzdrl.url;
            }
            this.zzepr.zzdw(str);
        }
    }

    private final void zzacd() {
        if (this.zzepv != null) {
            this.zzepg.getView().removeOnAttachStateChangeListener(this.zzepv);
        }
    }

    private final void zzaci() {
        if (this.zzepj != null && ((this.zzeps && this.zzepu <= 0) || this.zzept)) {
            if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() && this.zzepg.zzaan() != null) {
                zzabn.zza(this.zzepg.zzaan().zzry(), this.zzepg.zzaai(), "awfllc");
            }
            this.zzepj.zzai(!this.zzept);
            this.zzepj = null;
        }
        this.zzepg.zzadc();
    }

    private static WebResourceResponse zzacj() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcob)).booleanValue()) {
            return new WebResourceResponse("", "", new ByteArrayInputStream(new byte[0]));
        }
        return null;
    }

    private final WebResourceResponse zze(zzbfy zzbfy) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(zzbfy.url);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry next : zzbfy.zzal.entrySet()) {
                    openConnection.addRequestProperty((String) next.getKey(), (String) next.getValue());
                }
                if (openConnection instanceof HttpURLConnection) {
                    httpURLConnection = (HttpURLConnection) openConnection;
                    com.google.android.gms.ads.internal.zzp.zzkq().zza(this.zzepg.getContext(), this.zzepg.zzaao().zzbrf, false, httpURLConnection);
                    zzayu zzayu = new zzayu();
                    zzayu.zza(httpURLConnection, (byte[]) null);
                    int responseCode = httpURLConnection.getResponseCode();
                    zzayu.zza(httpURLConnection, responseCode);
                    if (responseCode < 300 || responseCode >= 400) {
                        com.google.android.gms.ads.internal.zzp.zzkq();
                    } else {
                        String headerField = httpURLConnection.getHeaderField("Location");
                        if (headerField == null) {
                            throw new IOException("Missing Location header in redirect");
                        } else if (headerField.startsWith("tel:")) {
                            return null;
                        } else {
                            URL url2 = new URL(url, headerField);
                            String protocol = url2.getProtocol();
                            if (protocol == null) {
                                zzd.zzfa("Protocol is null");
                                return zzacj();
                            } else if (protocol.equals("http") || protocol.equals("https")) {
                                String valueOf = String.valueOf(headerField);
                                zzd.zzeb(valueOf.length() != 0 ? "Redirecting to ".concat(valueOf) : new String("Redirecting to "));
                                httpURLConnection.disconnect();
                                url = url2;
                            } else {
                                String valueOf2 = String.valueOf(protocol);
                                zzd.zzfa(valueOf2.length() != 0 ? "Unsupported scheme: ".concat(valueOf2) : new String("Unsupported scheme: "));
                                return zzacj();
                            }
                        }
                    }
                } else {
                    throw new IOException("Invalid protocol.");
                }
            } else {
                StringBuilder sb = new StringBuilder(32);
                sb.append("Too many redirects (20)");
                throw new IOException(sb.toString());
            }
        }
        com.google.android.gms.ads.internal.zzp.zzkq();
        return zzm.zzd(httpURLConnection);
    }

    public final void destroy() {
        zzawq zzawq = this.zzepr;
        if (zzawq != null) {
            zzawq.zzwf();
            this.zzepr = null;
        }
        zzacd();
        this.zzetd.reset();
        this.zzetd.zzg(null);
        synchronized (this.lock) {
            this.zzcgp = null;
            this.zzdrm = null;
            this.zzepj = null;
            this.zzepk = null;
            this.zzdfr = null;
            this.zzdfs = null;
            this.zzdrq = null;
            this.zzepl = null;
            if (this.zzdgp != null) {
                this.zzdgp.zzac(true);
                this.zzdgp = null;
            }
        }
    }

    public final void onAdClicked() {
        zzva zzva = this.zzcgp;
        if (zzva != null) {
            zzva.onAdClicked();
        }
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzsu zzadi = this.zzepg.zzadi();
        if (zzadi != null && webView == zzadi.getWebView()) {
            zzadi.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @TargetApi(26)
    public final boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzepg.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final void zza(int i, int i2, boolean z) {
        this.zzepq.zzj(i, i2);
        zzaqk zzaqk = this.zzdgp;
        if (zzaqk != null) {
            zzaqk.zza(i, i2, false);
        }
    }

    public final void zza(zzb zzb) {
        boolean zzacx = this.zzepg.zzacx();
        zza(new AdOverlayInfoParcel(zzb, (!zzacx || this.zzepg.zzacq().zzady()) ? this.zzcgp : null, zzacx ? null : this.zzdrm, this.zzdrq, this.zzepg.zzaao()));
    }

    /* access modifiers changed from: package-private */
    public final void zza(zzbdv zzbdv, boolean z) {
        zzaqv zzaqv = new zzaqv(zzbdv, zzbdv.zzacn(), new zzaam(zzbdv.getContext()));
        this.zzepg = zzbdv;
        this.zzbrg = z;
        this.zzepq = zzaqv;
        this.zzdgp = null;
        this.zzetd.zzg(zzbdv);
    }

    public final void zza(zzbfi zzbfi) {
        this.zzepk = zzbfi;
    }

    public final void zza(zzbfj zzbfj) {
        this.zzepj = zzbfj;
    }

    public final void zza(zzbfy zzbfy) {
        this.zzeps = true;
        zzbfi zzbfi = this.zzepk;
        if (zzbfi != null) {
            zzbfi.zztu();
            this.zzepk = null;
        }
        zzaci();
    }

    public final void zza(zzva zzva, zzagy zzagy, zzp zzp, zzaha zzaha, zzu zzu, boolean z, zzahu zzahu, zza zza, zzaqx zzaqx, zzawq zzawq, zzcqo zzcqo, zzdrz zzdrz, zzckq zzckq) {
        zzahv<zzbdv> zzahv;
        String str;
        if (zza == null) {
            zza = new zza(this.zzepg.getContext(), zzawq, (zzasw) null);
        }
        this.zzdgp = new zzaqk(this.zzepg, zzaqx);
        this.zzepr = zzawq;
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcom)).booleanValue()) {
            zza("/adMetadata", (zzahv<? super zzbdv>) new zzagz(zzagy));
        }
        zza("/appEvent", (zzahv<? super zzbdv>) new zzahb(zzaha));
        zza("/backButton", (zzahv<? super zzbdv>) zzahc.zzdgd);
        zza("/refresh", (zzahv<? super zzbdv>) zzahc.zzdge);
        zza("/canOpenApp", (zzahv<? super zzbdv>) zzahc.zzdfu);
        zza("/canOpenURLs", (zzahv<? super zzbdv>) zzahc.zzdft);
        zza("/canOpenIntents", (zzahv<? super zzbdv>) zzahc.zzdfv);
        zza("/close", (zzahv<? super zzbdv>) zzahc.zzdfx);
        zza("/customClose", (zzahv<? super zzbdv>) zzahc.zzdfy);
        zza("/instrument", (zzahv<? super zzbdv>) zzahc.zzdgh);
        zza("/delayPageLoaded", (zzahv<? super zzbdv>) zzahc.zzdgj);
        zza("/delayPageClosed", (zzahv<? super zzbdv>) zzahc.zzdgk);
        zza("/getLocationInfo", (zzahv<? super zzbdv>) zzahc.zzdgl);
        zza("/log", (zzahv<? super zzbdv>) zzahc.zzdga);
        zza("/mraid", (zzahv<? super zzbdv>) new zzahw(zza, this.zzdgp, zzaqx));
        zza("/mraidLoaded", (zzahv<? super zzbdv>) this.zzepq);
        zza("/open", (zzahv<? super zzbdv>) new zzahz(zza, this.zzdgp, zzcqo, zzckq));
        zza("/precache", (zzahv<? super zzbdv>) new zzbdc());
        zza("/touch", (zzahv<? super zzbdv>) zzahc.zzdgc);
        zza("/video", (zzahv<? super zzbdv>) zzahc.zzdgf);
        zza("/videoMeta", (zzahv<? super zzbdv>) zzahc.zzdgg);
        if (zzcqo == null || zzdrz == null) {
            zza("/click", (zzahv<? super zzbdv>) zzahc.zzdfw);
            str = "/httpTrack";
            zzahv = zzahc.zzdfz;
        } else {
            zza("/click", (zzahv<? super zzbdv>) zzdnu.zza(zzcqo, zzdrz));
            str = "/httpTrack";
            zzahv = zzdnu.zzb(zzcqo, zzdrz);
        }
        zza(str, (zzahv<? super zzbdv>) zzahv);
        if (com.google.android.gms.ads.internal.zzp.zzlo().zzz(this.zzepg.getContext())) {
            zza("/logScionEvent", (zzahv<? super zzbdv>) new zzahx(this.zzepg.getContext()));
        }
        this.zzcgp = zzva;
        this.zzdrm = zzp;
        this.zzdfr = zzagy;
        this.zzdfs = zzaha;
        this.zzdrq = zzu;
        this.zzdgo = zza;
        this.zzepm = z;
    }

    public final void zza(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        this.zzetd.zza(str, predicate);
    }

    public final void zza(String str, zzahv<? super zzbdv> zzahv) {
        this.zzetd.zza(str, zzahv);
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzacx = this.zzepg.zzacx();
        zzva zzva = (!zzacx || this.zzepg.zzacq().zzady()) ? this.zzcgp : null;
        zzbfq zzbfq = zzacx ? null : new zzbfq(this.zzepg, this.zzdrm);
        zzagy zzagy = this.zzdfr;
        zzaha zzaha = this.zzdfs;
        zzu zzu = this.zzdrq;
        zzbdv zzbdv = this.zzepg;
        zza(new AdOverlayInfoParcel(zzva, (zzp) zzbfq, zzagy, zzaha, zzu, zzbdv, z, i, str, zzbdv.zzaao()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzacx = this.zzepg.zzacx();
        zzva zzva = (!zzacx || this.zzepg.zzacq().zzady()) ? this.zzcgp : null;
        zzbfq zzbfq = zzacx ? null : new zzbfq(this.zzepg, this.zzdrm);
        zzagy zzagy = this.zzdfr;
        zzaha zzaha = this.zzdfs;
        zzu zzu = this.zzdrq;
        zzbdv zzbdv = this.zzepg;
        zza(new AdOverlayInfoParcel(zzva, zzbfq, zzagy, zzaha, zzu, zzbdv, z, i, str, str2, zzbdv.zzaao()));
    }

    public final zza zzabx() {
        return this.zzdgo;
    }

    public final boolean zzaby() {
        return this.zzbrg;
    }

    public final boolean zzabz() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzepn;
        }
        return z;
    }

    public final boolean zzaca() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzepo;
        }
        return z;
    }

    public final ViewTreeObserver.OnGlobalLayoutListener zzacb() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final ViewTreeObserver.OnScrollChangedListener zzacc() {
        synchronized (this.lock) {
        }
        return null;
    }

    public final void zzace() {
        zzawq zzawq = this.zzepr;
        if (zzawq != null) {
            WebView webView = this.zzepg.getWebView();
            if (C0656u.m2569B(webView)) {
                zza((View) webView, zzawq, 10);
                return;
            }
            zzacd();
            this.zzepv = new zzbfr(this, zzawq);
            this.zzepg.getView().addOnAttachStateChangeListener(this.zzepv);
        }
    }

    public final void zzacf() {
        synchronized (this.lock) {
            this.zzepp = true;
        }
        this.zzepu++;
        zzaci();
    }

    public final void zzacg() {
        this.zzepu--;
        zzaci();
    }

    public final void zzach() {
        this.zzept = true;
        zzaci();
    }

    public final zzawq zzack() {
        return this.zzepr;
    }

    public final void zzau(boolean z) {
        this.zzepm = z;
    }

    public final void zzaw(boolean z) {
        this.zzdvo = z;
    }

    public final void zzax(boolean z) {
        synchronized (this.lock) {
            this.zzepn = true;
        }
    }

    public final void zzay(boolean z) {
        synchronized (this.lock) {
            this.zzepo = z;
        }
    }

    public final void zzb(zzbfy zzbfy) {
        this.zzetd.zzg(zzbfy.uri);
    }

    public final void zzb(String str, zzahv<? super zzbdv> zzahv) {
        this.zzetd.zzb(str, zzahv);
    }

    public final void zzb(boolean z, int i) {
        zzva zzva = (!this.zzepg.zzacx() || this.zzepg.zzacq().zzady()) ? this.zzcgp : null;
        zzp zzp = this.zzdrm;
        zzu zzu = this.zzdrq;
        zzbdv zzbdv = this.zzepg;
        zza(new AdOverlayInfoParcel(zzva, zzp, zzu, zzbdv, z, i, zzbdv.zzaao()));
    }

    public final boolean zzc(zzbfy zzbfy) {
        String valueOf = String.valueOf(zzbfy.url);
        zzd.zzee(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri uri = zzbfy.uri;
        if (this.zzetd.zzg(uri)) {
            return true;
        }
        if (this.zzepm) {
            String scheme = uri.getScheme();
            if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                zzva zzva = this.zzcgp;
                if (zzva != null) {
                    zzva.onAdClicked();
                    zzawq zzawq = this.zzepr;
                    if (zzawq != null) {
                        zzawq.zzdw(zzbfy.url);
                    }
                    this.zzcgp = null;
                }
                return false;
            }
        }
        if (!this.zzepg.getWebView().willNotDraw()) {
            try {
                zzef zzacv = this.zzepg.zzacv();
                if (zzacv != null && zzacv.zzb(uri)) {
                    uri = zzacv.zza(uri, this.zzepg.getContext(), this.zzepg.getView(), this.zzepg.zzaaj());
                }
            } catch (zzei unused) {
                String valueOf2 = String.valueOf(zzbfy.url);
                zzd.zzfa(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
            }
            zza zza = this.zzdgo;
            if (zza == null || zza.zzjy()) {
                zza(new zzb("android.intent.action.VIEW", uri.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
            } else {
                this.zzdgo.zzbk(zzbfy.url);
            }
        } else {
            String valueOf3 = String.valueOf(zzbfy.url);
            zzd.zzfa(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
        }
        return true;
    }

    public final WebResourceResponse zzd(zzbfy zzbfy) {
        WebResourceResponse webResourceResponse;
        zzta zza;
        zzawq zzawq = this.zzepr;
        if (zzawq != null) {
            zzawq.zza(zzbfy.url, zzbfy.zzal, 1);
        }
        if (!"mraid.js".equalsIgnoreCase(new File(zzbfy.url).getName())) {
            webResourceResponse = null;
        } else {
            zzvf();
            String str = (String) zzwq.zzqe().zzd(this.zzepg.zzacq().zzady() ? zzabf.zzcmz : this.zzepg.zzacx() ? zzabf.zzcmy : zzabf.zzcmx);
            com.google.android.gms.ads.internal.zzp.zzkq();
            webResourceResponse = zzm.zzd(this.zzepg.getContext(), this.zzepg.zzaao().zzbrf, str);
        }
        if (webResourceResponse != null) {
            return webResourceResponse;
        }
        try {
            if (!zzaxm.zzc(zzbfy.url, this.zzepg.getContext(), this.zzdvo).equals(zzbfy.url)) {
                return zze(zzbfy);
            }
            zztf zzbs = zztf.zzbs(zzbfy.url);
            if (zzbs != null && (zza = com.google.android.gms.ads.internal.zzp.zzkw().zza(zzbs)) != null && zza.zzmv()) {
                return new WebResourceResponse("", "", zza.zzmw());
            }
            if (!zzayu.isEnabled() || !zzacw.zzdbz.get().booleanValue()) {
                return null;
            }
            return zze(zzbfy);
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.zzp.zzku().zza(e, "AdWebViewClient.interceptRequest");
            return zzacj();
        }
    }

    public final void zzh(Uri uri) {
        this.zzetd.zzh(uri);
    }

    public final void zzi(int i, int i2) {
        zzaqk zzaqk = this.zzdgp;
        if (zzaqk != null) {
            zzaqk.zzi(i, i2);
        }
    }

    public final void zzvf() {
        synchronized (this.lock) {
            this.zzepm = false;
            this.zzbrg = true;
            zzazj.zzegt.execute(new zzbfp(this));
        }
    }
}
