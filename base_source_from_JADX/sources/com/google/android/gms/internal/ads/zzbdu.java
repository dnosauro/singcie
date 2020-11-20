package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.WebResourceResponse;
import android.webkit.WebView;
import android.webkit.WebViewClient;
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
import com.google.android.gms.internal.ads.zztu;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.spongycastle.asn1.eac.CertificateBody;

@ParametersAreNonnullByDefault
@VisibleForTesting
public class zzbdu extends WebViewClient implements zzbfg {
    private final Object lock;
    @GuardedBy("lock")
    private boolean zzbrg;
    private zzva zzcgp;
    private zzagy zzdfr;
    private zzaha zzdfs;
    private zza zzdgo;
    private zzaqk zzdgp;
    private zzp zzdrm;
    private zzu zzdrq;
    private boolean zzdvo;
    protected zzbdv zzepg;
    private final zzts zzeph;
    private final HashMap<String, List<zzahv<? super zzbdv>>> zzepi;
    private zzbfj zzepj;
    private zzbfi zzepk;
    private zzbfl zzepl;
    private boolean zzepm;
    @GuardedBy("lock")
    private boolean zzepn;
    @GuardedBy("lock")
    private boolean zzepo;
    @GuardedBy("lock")
    private boolean zzepp;
    private final zzaqv zzepq;
    protected zzawq zzepr;
    private boolean zzeps;
    private boolean zzept;
    private int zzepu;
    private View.OnAttachStateChangeListener zzepv;

    public zzbdu(zzbdv zzbdv, zzts zzts, boolean z) {
        this(zzbdv, zzts, z, new zzaqv(zzbdv, zzbdv.zzacn(), new zzaam(zzbdv.getContext())), (zzaqk) null);
    }

    @VisibleForTesting
    private zzbdu(zzbdv zzbdv, zzts zzts, boolean z, zzaqv zzaqv, zzaqk zzaqk) {
        this.zzepi = new HashMap<>();
        this.lock = new Object();
        this.zzepm = false;
        this.zzeph = zzts;
        this.zzepg = zzbdv;
        this.zzbrg = z;
        this.zzepq = zzaqv;
        this.zzdgp = null;
    }

    /* access modifiers changed from: private */
    public final void zza(View view, zzawq zzawq, int i) {
        if (zzawq.zzwd() && i > 0) {
            zzawq.zzl(view);
            if (zzawq.zzwd()) {
                zzm.zzedd.postDelayed(new zzbdz(this, view, zzawq, i), 100);
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

    /* access modifiers changed from: private */
    public final void zza(Map<String, String> map, List<zzahv<? super zzbdv>> list, String str) {
        if (zzd.isLoggable(2)) {
            String valueOf = String.valueOf(str);
            zzd.zzee(valueOf.length() != 0 ? "Received GMSG: ".concat(valueOf) : new String("Received GMSG: "));
            for (String next : map.keySet()) {
                String str2 = map.get(next);
                StringBuilder sb = new StringBuilder(String.valueOf(next).length() + 4 + String.valueOf(str2).length());
                sb.append("  ");
                sb.append(next);
                sb.append(": ");
                sb.append(str2);
                zzd.zzee(sb.toString());
            }
        }
        for (zzahv<? super zzbdv> zza : list) {
            zza.zza(this.zzepg, map);
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

    private final WebResourceResponse zze(String str, Map<String, String> map) {
        HttpURLConnection httpURLConnection;
        URL url = new URL(str);
        int i = 0;
        while (true) {
            i++;
            if (i <= 20) {
                URLConnection openConnection = url.openConnection();
                openConnection.setConnectTimeout(10000);
                openConnection.setReadTimeout(10000);
                for (Map.Entry next : map.entrySet()) {
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

    public void onAdClicked() {
        zzva zzva = this.zzcgp;
        if (zzva != null) {
            zzva.onAdClicked();
        }
    }

    public final void onLoadResource(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzd.zzee(valueOf.length() != 0 ? "Loading resource: ".concat(valueOf) : new String("Loading resource: "));
        Uri parse = Uri.parse(str);
        if ("gmsg".equalsIgnoreCase(parse.getScheme()) && "mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            zzh(parse);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x001d, code lost:
        if (r1 == null) goto L_0x0025;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:11:0x001f, code lost:
        r1.zztu();
        r0.zzepk = null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0025, code lost:
        zzaci();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0028, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0018, code lost:
        r0.zzeps = true;
        r1 = r0.zzepk;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void onPageFinished(android.webkit.WebView r1, java.lang.String r2) {
        /*
            r0 = this;
            java.lang.Object r1 = r0.lock
            monitor-enter(r1)
            com.google.android.gms.internal.ads.zzbdv r2 = r0.zzepg     // Catch:{ all -> 0x0029 }
            boolean r2 = r2.isDestroyed()     // Catch:{ all -> 0x0029 }
            if (r2 == 0) goto L_0x0017
            java.lang.String r2 = "Blank page loaded, 1..."
            com.google.android.gms.ads.internal.util.zzd.zzee(r2)     // Catch:{ all -> 0x0029 }
            com.google.android.gms.internal.ads.zzbdv r2 = r0.zzepg     // Catch:{ all -> 0x0029 }
            r2.zzacy()     // Catch:{ all -> 0x0029 }
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            return
        L_0x0017:
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            r1 = 1
            r0.zzeps = r1
            com.google.android.gms.internal.ads.zzbfi r1 = r0.zzepk
            if (r1 == 0) goto L_0x0025
            r1.zztu()
            r1 = 0
            r0.zzepk = r1
        L_0x0025:
            r0.zzaci()
            return
        L_0x0029:
            r2 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x0029 }
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbdu.onPageFinished(android.webkit.WebView, java.lang.String):void");
    }

    public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        zzsu zzadi = this.zzepg.zzadi();
        if (zzadi != null && webView == zzadi.getWebView()) {
            zzadi.onPageStarted(webView, str, bitmap);
        }
        super.onPageStarted(webView, str, bitmap);
    }

    @TargetApi(26)
    public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
        return this.zzepg.zzc(renderProcessGoneDetail.didCrash(), renderProcessGoneDetail.rendererPriorityAtExit());
    }

    public final void reset() {
        zzawq zzawq = this.zzepr;
        if (zzawq != null) {
            zzawq.zzwf();
            this.zzepr = null;
        }
        zzacd();
        synchronized (this.lock) {
            this.zzepi.clear();
            this.zzcgp = null;
            this.zzdrm = null;
            this.zzepj = null;
            this.zzepk = null;
            this.zzdfr = null;
            this.zzdfs = null;
            this.zzepm = false;
            this.zzbrg = false;
            this.zzepn = false;
            this.zzepp = false;
            this.zzdrq = null;
            this.zzepl = null;
            if (this.zzdgp != null) {
                this.zzdgp.zzac(true);
                this.zzdgp = null;
            }
        }
    }

    @TargetApi(11)
    public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
        return zzd(str, Collections.emptyMap());
    }

    public boolean shouldOverrideKeyEvent(WebView webView, KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 79 || keyCode == 222) {
            return true;
        }
        switch (keyCode) {
            case 85:
            case 86:
            case 87:
            case 88:
            case 89:
            case 90:
            case 91:
                return true;
            default:
                switch (keyCode) {
                    case 126:
                    case CertificateBody.profileType /*127*/:
                    case 128:
                    case 129:
                    case 130:
                        return true;
                    default:
                        return false;
                }
        }
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        String valueOf = String.valueOf(str);
        zzd.zzee(valueOf.length() != 0 ? "AdWebView shouldOverrideUrlLoading: ".concat(valueOf) : new String("AdWebView shouldOverrideUrlLoading: "));
        Uri parse = Uri.parse(str);
        if (!"gmsg".equalsIgnoreCase(parse.getScheme()) || !"mobileads.google.com".equalsIgnoreCase(parse.getHost())) {
            if (this.zzepm && webView == this.zzepg.getWebView()) {
                String scheme = parse.getScheme();
                if ("http".equalsIgnoreCase(scheme) || "https".equalsIgnoreCase(scheme)) {
                    zzva zzva = this.zzcgp;
                    if (zzva != null) {
                        zzva.onAdClicked();
                        zzawq zzawq = this.zzepr;
                        if (zzawq != null) {
                            zzawq.zzdw(str);
                        }
                        this.zzcgp = null;
                    }
                    return super.shouldOverrideUrlLoading(webView, str);
                }
            }
            if (!this.zzepg.getWebView().willNotDraw()) {
                try {
                    zzef zzacv = this.zzepg.zzacv();
                    if (zzacv != null && zzacv.zzb(parse)) {
                        parse = zzacv.zza(parse, this.zzepg.getContext(), this.zzepg.getView(), this.zzepg.zzaaj());
                    }
                } catch (zzei unused) {
                    String valueOf2 = String.valueOf(str);
                    zzd.zzfa(valueOf2.length() != 0 ? "Unable to append parameter to URL: ".concat(valueOf2) : new String("Unable to append parameter to URL: "));
                }
                zza zza = this.zzdgo;
                if (zza == null || zza.zzjy()) {
                    zza(new zzb("android.intent.action.VIEW", parse.toString(), (String) null, (String) null, (String) null, (String) null, (String) null));
                } else {
                    this.zzdgo.zzbk(str);
                }
            } else {
                String valueOf3 = String.valueOf(str);
                zzd.zzfa(valueOf3.length() != 0 ? "AdWebView unable to handle URL: ".concat(valueOf3) : new String("AdWebView unable to handle URL: "));
            }
        } else {
            zzh(parse);
        }
        return true;
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

    public final void zza(zzbfi zzbfi) {
        this.zzepk = zzbfi;
    }

    public final void zza(zzbfj zzbfj) {
        this.zzepj = zzbfj;
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
        synchronized (this.lock) {
            List<zzahv> list = this.zzepi.get(str);
            if (list != null) {
                ArrayList arrayList = new ArrayList();
                for (zzahv zzahv : list) {
                    if (predicate.apply(zzahv)) {
                        arrayList.add(zzahv);
                    }
                }
                list.removeAll(arrayList);
            }
        }
    }

    public final void zza(String str, zzahv<? super zzbdv> zzahv) {
        synchronized (this.lock) {
            List list = this.zzepi.get(str);
            if (list == null) {
                list = new CopyOnWriteArrayList();
                this.zzepi.put(str, list);
            }
            list.add(zzahv);
        }
    }

    public final void zza(boolean z, int i, String str) {
        boolean zzacx = this.zzepg.zzacx();
        zzva zzva = (!zzacx || this.zzepg.zzacq().zzady()) ? this.zzcgp : null;
        zzbea zzbea = zzacx ? null : new zzbea(this.zzepg, this.zzdrm);
        zzagy zzagy = this.zzdfr;
        zzaha zzaha = this.zzdfs;
        zzu zzu = this.zzdrq;
        zzbdv zzbdv = this.zzepg;
        zza(new AdOverlayInfoParcel(zzva, (zzp) zzbea, zzagy, zzaha, zzu, zzbdv, z, i, str, zzbdv.zzaao()));
    }

    public final void zza(boolean z, int i, String str, String str2) {
        boolean zzacx = this.zzepg.zzacx();
        zzva zzva = (!zzacx || this.zzepg.zzacq().zzady()) ? this.zzcgp : null;
        zzbea zzbea = zzacx ? null : new zzbea(this.zzepg, this.zzdrm);
        zzagy zzagy = this.zzdfr;
        zzaha zzaha = this.zzdfs;
        zzu zzu = this.zzdrq;
        zzbdv zzbdv = this.zzepg;
        zza(new AdOverlayInfoParcel(zzva, zzbea, zzagy, zzaha, zzu, zzbdv, z, i, str, str2, zzbdv.zzaao()));
    }

    public final zza zzabx() {
        return this.zzdgo;
    }

    public final boolean zzaby() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzbrg;
        }
        return z;
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
            this.zzepv = new zzbdy(this, zzawq);
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
        zzts zzts = this.zzeph;
        if (zzts != null) {
            zzts.zza(zztu.zza.C3718zza.DELAY_PAGE_LOAD_CANCELLED_AD);
        }
        this.zzept = true;
        zzaci();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcvr)).booleanValue()) {
            this.zzepg.destroy();
        }
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

    public final void zzb(String str, zzahv<? super zzbdv> zzahv) {
        synchronized (this.lock) {
            List list = this.zzepi.get(str);
            if (list != null) {
                list.remove(zzahv);
            }
        }
    }

    public final void zzb(boolean z, int i) {
        zzva zzva = (!this.zzepg.zzacx() || this.zzepg.zzacq().zzady()) ? this.zzcgp : null;
        zzp zzp = this.zzdrm;
        zzu zzu = this.zzdrq;
        zzbdv zzbdv = this.zzepg;
        zza(new AdOverlayInfoParcel(zzva, zzp, zzu, zzbdv, z, i, zzbdv.zzaao()));
    }

    /* access modifiers changed from: protected */
    public final WebResourceResponse zzd(String str, Map<String, String> map) {
        zzta zza;
        try {
            String zzc = zzaxm.zzc(str, this.zzepg.getContext(), this.zzdvo);
            if (!zzc.equals(str)) {
                return zze(zzc, map);
            }
            zztf zzbs = zztf.zzbs(str);
            if (zzbs != null && (zza = com.google.android.gms.ads.internal.zzp.zzkw().zza(zzbs)) != null && zza.zzmv()) {
                return new WebResourceResponse("", "", zza.zzmw());
            }
            if (!zzayu.isEnabled() || !zzacw.zzdbz.get().booleanValue()) {
                return null;
            }
            return zze(str, map);
        } catch (Exception | NoClassDefFoundError e) {
            com.google.android.gms.ads.internal.zzp.zzku().zza(e, "AdWebViewClient.interceptRequest");
            return zzacj();
        }
    }

    public final void zzh(Uri uri) {
        String path = uri.getPath();
        List list = this.zzepi.get(path);
        if (list != null) {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcvn)).booleanValue()) {
                com.google.android.gms.ads.internal.zzp.zzkq();
                zza(zzm.zzj(uri), (List<zzahv<? super zzbdv>>) list, path);
                return;
            }
            zzdyr.zza(com.google.android.gms.ads.internal.zzp.zzkq().zzi(uri), new zzbeb(this, list, path), zzazj.zzegu);
            return;
        }
        String valueOf = String.valueOf(uri);
        StringBuilder sb = new StringBuilder(String.valueOf(valueOf).length() + 32);
        sb.append("No GMSG handler found for GMSG: ");
        sb.append(valueOf);
        zzd.zzee(sb.toString());
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcxu)).booleanValue() && com.google.android.gms.ads.internal.zzp.zzku().zzwt() != null) {
            zzazj.zzegp.execute(new zzbdw(path));
        }
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
            zzazj.zzegt.execute(new zzbdx(this));
        }
    }
}
