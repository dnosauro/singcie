package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.net.Uri;
import android.os.Build;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.WindowManager;
import android.webkit.DownloadListener;
import android.webkit.ValueCallback;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import com.google.android.gms.ads.internal.overlay.zze;
import com.google.android.gms.ads.internal.util.zzad;
import com.google.android.gms.ads.internal.util.zzbz;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzb;
import com.google.android.gms.ads.internal.zzk;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.Predicate;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.internal.ads.zztu;
import com.google.android.gms.internal.ads.zzue;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.ParametersAreNonnullByDefault;
import javax.annotation.concurrent.GuardedBy;
import org.json.JSONException;
import org.json.JSONObject;

@ParametersAreNonnullByDefault
@VisibleForTesting
final class zzbel extends WebView implements ViewTreeObserver.OnGlobalLayoutListener, DownloadListener, zzbdv {
    private int maxHeight = -1;
    private int maxWidth = -1;
    @GuardedBy("this")
    private String zzacv;
    private final zzazh zzbpd;
    private final WindowManager zzbqu;
    private int zzbvg;
    private int zzdpl = -1;
    private int zzdpm = -1;
    @GuardedBy("this")
    private boolean zzdro;
    @GuardedBy("this")
    private String zzdtb = "";
    @GuardedBy("this")
    private Boolean zzeat;
    private zzabq zzelc;
    private final zzts zzeph;
    private final zzbfk zzera;
    private final zzef zzerb;
    private final zzacg zzerc;
    private final zzk zzerd;
    private final zzb zzere;
    private final float zzerf;
    private final zzsu zzerg;
    private final boolean zzerh;
    private zzdmu zzeri;
    private zzdmz zzerj;
    private boolean zzerk = false;
    private boolean zzerl = false;
    private zzbdu zzerm;
    @GuardedBy("this")
    private zze zzern;
    @GuardedBy("this")
    private IObjectWrapper zzero;
    @GuardedBy("this")
    private zzbfn zzerp;
    @GuardedBy("this")
    private boolean zzerq;
    @GuardedBy("this")
    private boolean zzerr;
    @GuardedBy("this")
    private boolean zzers;
    @GuardedBy("this")
    private int zzert;
    @GuardedBy("this")
    private boolean zzeru = true;
    @GuardedBy("this")
    private boolean zzerv = false;
    @GuardedBy("this")
    private zzbep zzerw;
    @GuardedBy("this")
    private boolean zzerx;
    @GuardedBy("this")
    private boolean zzery;
    @GuardedBy("this")
    private zzadx zzerz;
    @GuardedBy("this")
    private zzads zzesa;
    @GuardedBy("this")
    private zzsc zzesb;
    @GuardedBy("this")
    private int zzesc;
    /* access modifiers changed from: private */
    @GuardedBy("this")
    public int zzesd;
    private zzabq zzese;
    private zzabq zzesf;
    private zzabt zzesg;
    private WeakReference<View.OnClickListener> zzesh;
    @GuardedBy("this")
    private zze zzesi;
    @GuardedBy("this")
    private boolean zzesj;
    private zzbz zzesk;
    private Map<String, zzbcx> zzesl;
    private final DisplayMetrics zzxl;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    @VisibleForTesting
    private zzbel(zzbfk zzbfk, zzbfn zzbfn, String str, boolean z, boolean z2, zzef zzef, zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
        super(zzbfk);
        zzdmz zzdmz2;
        zzazh zzazh2 = zzazh;
        this.zzera = zzbfk;
        this.zzerp = zzbfn;
        this.zzacv = str;
        this.zzerr = z;
        this.zzert = -1;
        this.zzerb = zzef;
        this.zzerc = zzacg;
        this.zzbpd = zzazh2;
        this.zzerd = zzk;
        this.zzere = zzb;
        this.zzbqu = (WindowManager) getContext().getSystemService("window");
        zzp.zzkq();
        this.zzxl = zzm.zza(this.zzbqu);
        this.zzerf = this.zzxl.density;
        this.zzeph = zzts;
        this.zzerg = zzsu;
        this.zzerh = z3;
        this.zzeri = zzdmu;
        this.zzerj = zzdmz;
        setBackgroundColor(0);
        WebSettings settings = getSettings();
        settings.setAllowFileAccess(false);
        try {
            settings.setJavaScriptEnabled(true);
        } catch (NullPointerException e) {
            zzd.zzc("Unable to enable Javascript.", e);
        }
        settings.setSavePassword(false);
        settings.setSupportMultipleWindows(true);
        settings.setJavaScriptCanOpenWindowsAutomatically(true);
        if (Build.VERSION.SDK_INT >= 21) {
            settings.setMixedContentMode(2);
        }
        zzp.zzkq().zza((Context) zzbfk, zzazh2.zzbrf, settings);
        zzp.zzks().zza(getContext(), settings);
        setDownloadListener(this);
        zzado();
        if (PlatformVersion.isAtLeastJellyBeanMR1()) {
            addJavascriptInterface(zzbet.zzc(this), "googleAdsJsInterface");
        }
        removeJavascriptInterface("accessibility");
        removeJavascriptInterface("accessibilityTraversal");
        this.zzesk = new zzbz(this.zzera.zzaaj(), this, this, (ViewTreeObserver.OnScrollChangedListener) null);
        zzads();
        this.zzesg = new zzabt(new zzabs(true, "make_wv", this.zzacv));
        this.zzesg.zzry().zzc(zzabs);
        if (!(!((Boolean) zzwq.zzqe().zzd(zzabf.zzcqn)).booleanValue() || (zzdmz2 = this.zzerj) == null || zzdmz2.zzbvf == null)) {
            this.zzesg.zzry().zzh("gqi", this.zzerj.zzbvf);
        }
        this.zzelc = zzabn.zzb(this.zzesg.zzry());
        this.zzesg.zza("native:view_create", this.zzelc);
        this.zzesf = null;
        this.zzese = null;
        zzp.zzks().zzbg(zzbfk);
        zzp.zzku().zzww();
    }

    @VisibleForTesting
    private final void zza(Boolean bool) {
        synchronized (this) {
            this.zzeat = bool;
        }
        zzp.zzku().zza(bool);
    }

    @TargetApi(19)
    private final synchronized void zza(String str, ValueCallback<String> valueCallback) {
        if (!isDestroyed()) {
            evaluateJavascript(str, (ValueCallback<String>) null);
        } else {
            zzd.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    static final /* synthetic */ void zza(boolean z, int i, zzue.zzi.zza zza) {
        zzue.zzae.zza zzpj = zzue.zzae.zzpj();
        if (zzpj.zzpi() != z) {
            zzpj.zzw(z);
        }
        zza.zzb((zzue.zzae) ((zzekh) zzpj.zzcu(i).zzbhv()));
    }

    private final boolean zzadl() {
        int i;
        int i2;
        boolean z = false;
        if (!this.zzerm.zzaby() && !this.zzerm.zzabz()) {
            return false;
        }
        zzwq.zzqa();
        DisplayMetrics displayMetrics = this.zzxl;
        int zzb = zzayr.zzb(displayMetrics, displayMetrics.widthPixels);
        zzwq.zzqa();
        DisplayMetrics displayMetrics2 = this.zzxl;
        int zzb2 = zzayr.zzb(displayMetrics2, displayMetrics2.heightPixels);
        Activity zzaaj = this.zzera.zzaaj();
        if (zzaaj == null || zzaaj.getWindow() == null) {
            i2 = zzb;
            i = zzb2;
        } else {
            zzp.zzkq();
            int[] zzf = zzm.zzf(zzaaj);
            zzwq.zzqa();
            int zzb3 = zzayr.zzb(this.zzxl, zzf[0]);
            zzwq.zzqa();
            i = zzayr.zzb(this.zzxl, zzf[1]);
            i2 = zzb3;
        }
        if (this.zzdpl == zzb && this.zzdpm == zzb2 && this.maxWidth == i2 && this.maxHeight == i) {
            return false;
        }
        if (!(this.zzdpl == zzb && this.zzdpm == zzb2)) {
            z = true;
        }
        this.zzdpl = zzb;
        this.zzdpm = zzb2;
        this.maxWidth = i2;
        this.maxHeight = i;
        new zzaqu(this).zza(zzb, zzb2, i2, i, this.zzxl.density, this.zzbqu.getDefaultDisplay().getRotation());
        return z;
    }

    private final synchronized void zzadm() {
        this.zzeat = zzp.zzku().zzwu();
        if (this.zzeat == null) {
            try {
                evaluateJavascript("(function(){})()", (ValueCallback<String>) null);
                zza((Boolean) true);
            } catch (IllegalStateException unused) {
                zza((Boolean) false);
            }
        }
    }

    private final void zzadn() {
        zzabn.zza(this.zzesg.zzry(), this.zzelc, "aeh2");
    }

    private final synchronized void zzado() {
        if (!this.zzerr) {
            if (!this.zzerp.zzady()) {
                if (Build.VERSION.SDK_INT < 18) {
                    zzd.zzeb("Disabling hardware acceleration on an AdView.");
                    zzadp();
                    return;
                }
                zzd.zzeb("Enabling hardware acceleration on an AdView.");
                zzadq();
                return;
            }
        }
        zzd.zzeb("Enabling hardware acceleration on an overlay.");
        zzadq();
    }

    private final synchronized void zzadp() {
        if (!this.zzers) {
            zzp.zzks();
            setLayerType(1, (Paint) null);
        }
        this.zzers = true;
    }

    private final synchronized void zzadq() {
        if (this.zzers) {
            zzp.zzks();
            setLayerType(0, (Paint) null);
        }
        this.zzers = false;
    }

    private final synchronized void zzadr() {
        if (this.zzesl != null) {
            for (zzbcx release : this.zzesl.values()) {
                release.release();
            }
        }
        this.zzesl = null;
    }

    private final void zzads() {
        zzabs zzry;
        zzabt zzabt = this.zzesg;
        if (zzabt != null && (zzry = zzabt.zzry()) != null && zzp.zzku().zzwt() != null) {
            zzp.zzku().zzwt().zza(zzry);
        }
    }

    static zzbel zzb(Context context, zzbfn zzbfn, String str, boolean z, boolean z2, zzef zzef, zzacg zzacg, zzazh zzazh, zzabs zzabs, zzk zzk, zzb zzb, zzts zzts, zzsu zzsu, boolean z3, zzdmu zzdmu, zzdmz zzdmz) {
        zzbfk zzbfk = r0;
        zzbfk zzbfk2 = new zzbfk(context);
        return new zzbel(zzbfk, zzbfn, str, z, z2, zzef, zzacg, zzazh, zzabs, zzk, zzb, zzts, zzsu, z3, zzdmu, zzdmz);
    }

    private final void zzbc(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("isVisible", z ? "1" : "0");
        zza("onAdVisibilityChanged", (Map<String, ?>) hashMap);
    }

    private final synchronized void zzfn(String str) {
        if (!isDestroyed()) {
            loadUrl(str);
        } else {
            zzd.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    private final synchronized void zzfo(String str) {
        try {
            super.loadUrl(str);
        } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError | UnsatisfiedLinkError e) {
            zzp.zzku().zza(e, "AdWebViewImpl.loadUrlUnsafe");
            zzd.zzd("Could not call loadUrl. ", e);
        }
    }

    private final void zzfp(String str) {
        if (PlatformVersion.isAtLeastKitKat()) {
            if (zzwu() == null) {
                zzadm();
            }
            if (zzwu().booleanValue()) {
                zza(str, (ValueCallback<String>) null);
                return;
            }
            String valueOf = String.valueOf(str);
            zzfn(valueOf.length() != 0 ? "javascript:".concat(valueOf) : new String("javascript:"));
            return;
        }
        String valueOf2 = String.valueOf(str);
        zzfn(valueOf2.length() != 0 ? "javascript:".concat(valueOf2) : new String("javascript:"));
    }

    @VisibleForTesting
    private final synchronized Boolean zzwu() {
        return this.zzeat;
    }

    private final synchronized void zzwx() {
        if (!this.zzesj) {
            this.zzesj = true;
            zzp.zzku().zzwx();
        }
    }

    public final synchronized void destroy() {
        zzads();
        this.zzesk.zzza();
        if (this.zzern != null) {
            this.zzern.close();
            this.zzern.onDestroy();
            this.zzern = null;
        }
        this.zzero = null;
        this.zzerm.reset();
        if (!this.zzerq) {
            zzp.zzlm();
            zzbcu.zzc(this);
            zzadr();
            this.zzerq = true;
            zzd.zzee("Initiating WebView self destruct sequence in 3...");
            zzd.zzee("Loading blank page in WebView, 2...");
            zzfo("about:blank");
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x0013, code lost:
        return;
     */
    @android.annotation.TargetApi(19)
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void evaluateJavascript(java.lang.String r2, android.webkit.ValueCallback<java.lang.String> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.isDestroyed()     // Catch:{ all -> 0x0019 }
            if (r0 == 0) goto L_0x0014
            java.lang.String r2 = "#004 The webview is destroyed. Ignoring action."
            com.google.android.gms.ads.internal.util.zzd.zzfc(r2)     // Catch:{ all -> 0x0019 }
            if (r3 == 0) goto L_0x0012
            r2 = 0
            r3.onReceiveValue(r2)     // Catch:{ all -> 0x0019 }
        L_0x0012:
            monitor-exit(r1)
            return
        L_0x0014:
            super.evaluateJavascript(r2, r3)     // Catch:{ all -> 0x0019 }
            monitor-exit(r1)
            return
        L_0x0019:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbel.evaluateJavascript(java.lang.String, android.webkit.ValueCallback):void");
    }

    /* access modifiers changed from: protected */
    public final void finalize() {
        try {
            synchronized (this) {
                if (!this.zzerq) {
                    this.zzerm.reset();
                    zzp.zzlm();
                    zzbcu.zzc(this);
                    zzadr();
                    zzwx();
                }
            }
            super.finalize();
        } catch (Throwable th) {
            super.finalize();
            throw th;
        }
    }

    public final synchronized String getRequestId() {
        return this.zzdtb;
    }

    public final View getView() {
        return this;
    }

    public final WebView getWebView() {
        return this;
    }

    public final synchronized boolean isDestroyed() {
        return this.zzerq;
    }

    public final synchronized void loadData(String str, String str2, String str3) {
        if (!isDestroyed()) {
            super.loadData(str, str2, str3);
        } else {
            zzd.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadDataWithBaseURL(String str, String str2, String str3, String str4, String str5) {
        if (!isDestroyed()) {
            super.loadDataWithBaseURL(str, str2, str3, str4, str5);
        } else {
            zzd.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final synchronized void loadUrl(String str) {
        if (!isDestroyed()) {
            try {
                super.loadUrl(str);
            } catch (Exception | IncompatibleClassChangeError | NoClassDefFoundError e) {
                zzp.zzku().zza(e, "AdWebViewImpl.loadUrl");
                zzd.zzd("Could not call loadUrl. ", e);
            }
        } else {
            zzd.zzfa("#004 The webview is destroyed. Ignoring action.");
        }
    }

    public final void onAdClicked() {
        zzbdu zzbdu = this.zzerm;
        if (zzbdu != null) {
            zzbdu.onAdClicked();
        }
    }

    /* access modifiers changed from: protected */
    public final synchronized void onAttachedToWindow() {
        super.onAttachedToWindow();
        if (!isDestroyed()) {
            this.zzesk.onAttachedToWindow();
        }
        boolean z = this.zzerx;
        if (this.zzerm != null && this.zzerm.zzabz()) {
            if (!this.zzery) {
                this.zzerm.zzacb();
                this.zzerm.zzacc();
                this.zzery = true;
            }
            zzadl();
            z = true;
        }
        zzbc(z);
    }

    /* access modifiers changed from: protected */
    public final void onDetachedFromWindow() {
        synchronized (this) {
            if (!isDestroyed()) {
                this.zzesk.onDetachedFromWindow();
            }
            super.onDetachedFromWindow();
            if (this.zzery && this.zzerm != null && this.zzerm.zzabz() && getViewTreeObserver() != null && getViewTreeObserver().isAlive()) {
                this.zzerm.zzacb();
                this.zzerm.zzacc();
                this.zzery = false;
            }
        }
        zzbc(false);
    }

    public final void onDownloadStart(String str, String str2, String str3, String str4, long j) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setDataAndType(Uri.parse(str), str4);
            zzp.zzkq();
            zzm.zza(getContext(), intent);
        } catch (ActivityNotFoundException unused) {
            StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 51 + String.valueOf(str4).length());
            sb.append("Couldn't find an Activity to view url/mimetype: ");
            sb.append(str);
            sb.append(" / ");
            sb.append(str4);
            zzd.zzeb(sb.toString());
        }
    }

    /* access modifiers changed from: protected */
    @TargetApi(21)
    public final void onDraw(Canvas canvas) {
        if (!isDestroyed()) {
            if (Build.VERSION.SDK_INT != 21 || !canvas.isHardwareAccelerated() || isAttachedToWindow()) {
                super.onDraw(canvas);
            }
        }
    }

    public final boolean onGenericMotionEvent(MotionEvent motionEvent) {
        float axisValue = motionEvent.getAxisValue(9);
        float axisValue2 = motionEvent.getAxisValue(10);
        if (motionEvent.getActionMasked() == 8) {
            if (axisValue > 0.0f && !canScrollVertically(-1)) {
                return false;
            }
            if (axisValue < 0.0f && !canScrollVertically(1)) {
                return false;
            }
            if (axisValue2 > 0.0f && !canScrollHorizontally(-1)) {
                return false;
            }
            if (axisValue2 < 0.0f && !canScrollHorizontally(1)) {
                return false;
            }
        }
        return super.onGenericMotionEvent(motionEvent);
    }

    public final void onGlobalLayout() {
        boolean zzadl = zzadl();
        zze zzaco = zzaco();
        if (zzaco != null && zzadl) {
            zzaco.zzvi();
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:121:0x01f9, code lost:
        return;
     */
    /* JADX WARNING: Removed duplicated region for block: B:104:0x016c  */
    /* JADX WARNING: Removed duplicated region for block: B:112:0x01d7 A[SYNTHETIC, Splitter:B:112:0x01d7] */
    /* JADX WARNING: Removed duplicated region for block: B:86:0x0125  */
    /* JADX WARNING: Removed duplicated region for block: B:93:0x0141  */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:122:0x01fa=Splitter:B:122:0x01fa, B:64:0x00de=Splitter:B:64:0x00de} */
    @android.annotation.SuppressLint({"DrawAllocation"})
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void onMeasure(int r8, int r9) {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.isDestroyed()     // Catch:{ all -> 0x01ff }
            r1 = 0
            if (r0 == 0) goto L_0x000d
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x000d:
            boolean r0 = r7.isInEditMode()     // Catch:{ all -> 0x01ff }
            if (r0 != 0) goto L_0x01fa
            boolean r0 = r7.zzerr     // Catch:{ all -> 0x01ff }
            if (r0 != 0) goto L_0x01fa
            com.google.android.gms.internal.ads.zzbfn r0 = r7.zzerp     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.zzadz()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x0021
            goto L_0x01fa
        L_0x0021:
            com.google.android.gms.internal.ads.zzbfn r0 = r7.zzerp     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.zzaeb()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x002e
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x002e:
            com.google.android.gms.internal.ads.zzbfn r0 = r7.zzerp     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.zzaea()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x0091
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcsh     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x01ff }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01ff }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x004d
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x004d:
            com.google.android.gms.internal.ads.zzbep r0 = r7.zzaah()     // Catch:{ all -> 0x01ff }
            r1 = 0
            if (r0 == 0) goto L_0x0059
            float r0 = r0.getAspectRatio()     // Catch:{ all -> 0x01ff }
            goto L_0x005a
        L_0x0059:
            r0 = 0
        L_0x005a:
            int r1 = (r0 > r1 ? 1 : (r0 == r1 ? 0 : -1))
            if (r1 != 0) goto L_0x0063
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x0063:
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01ff }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01ff }
            float r1 = (float) r9     // Catch:{ all -> 0x01ff }
            float r1 = r1 * r0
            int r1 = (int) r1     // Catch:{ all -> 0x01ff }
            float r2 = (float) r8     // Catch:{ all -> 0x01ff }
            float r2 = r2 / r0
            int r2 = (int) r2     // Catch:{ all -> 0x01ff }
            if (r9 != 0) goto L_0x007c
            if (r2 == 0) goto L_0x007c
            float r9 = (float) r2     // Catch:{ all -> 0x01ff }
            float r9 = r9 * r0
            int r1 = (int) r9     // Catch:{ all -> 0x01ff }
            r9 = r2
            goto L_0x0084
        L_0x007c:
            if (r8 != 0) goto L_0x0084
            if (r1 == 0) goto L_0x0084
            float r8 = (float) r1     // Catch:{ all -> 0x01ff }
            float r8 = r8 / r0
            int r2 = (int) r8     // Catch:{ all -> 0x01ff }
            r8 = r1
        L_0x0084:
            int r8 = java.lang.Math.min(r1, r8)     // Catch:{ all -> 0x01ff }
            int r9 = java.lang.Math.min(r2, r9)     // Catch:{ all -> 0x01ff }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x0091:
            com.google.android.gms.internal.ads.zzbfn r0 = r7.zzerp     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.isFluid()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x00e3
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcsk     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x01ff }
            java.lang.Object r0 = r1.zzd(r0)     // Catch:{ all -> 0x01ff }
            java.lang.Boolean r0 = (java.lang.Boolean) r0     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.booleanValue()     // Catch:{ all -> 0x01ff }
            if (r0 != 0) goto L_0x00de
            boolean r0 = com.google.android.gms.common.util.PlatformVersion.isAtLeastJellyBeanMR1()     // Catch:{ all -> 0x01ff }
            if (r0 != 0) goto L_0x00b2
            goto L_0x00de
        L_0x00b2:
            java.lang.String r0 = "/contentHeight"
            com.google.android.gms.internal.ads.zzben r1 = new com.google.android.gms.internal.ads.zzben     // Catch:{ all -> 0x01ff }
            r1.<init>(r7)     // Catch:{ all -> 0x01ff }
            r7.zza((java.lang.String) r0, (com.google.android.gms.internal.ads.zzahv<? super com.google.android.gms.internal.ads.zzbdv>) r1)     // Catch:{ all -> 0x01ff }
            java.lang.String r0 = "(function() {  var height = -1;  if (document.body) {    height = document.body.offsetHeight;  } else if (document.documentElement) {    height = document.documentElement.offsetHeight;  }  var url = 'gmsg://mobileads.google.com/contentHeight?';  url += 'height=' + height;  try {    window.googleAdsJsInterface.notify(url);  } catch (e) {    var frame = document.getElementById('afma-notify-fluid');    if (!frame) {      frame = document.createElement('IFRAME');      frame.id = 'afma-notify-fluid';      frame.style.display = 'none';      var body = document.body || document.documentElement;      body.appendChild(frame);    }    frame.src = url;  }})();"
            r7.zzfp(r0)     // Catch:{ all -> 0x01ff }
            android.util.DisplayMetrics r0 = r7.zzxl     // Catch:{ all -> 0x01ff }
            float r0 = r0.density     // Catch:{ all -> 0x01ff }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01ff }
            int r1 = r7.zzesd     // Catch:{ all -> 0x01ff }
            r2 = -1
            if (r1 == r2) goto L_0x00d5
            int r9 = r7.zzesd     // Catch:{ all -> 0x01ff }
            float r9 = (float) r9     // Catch:{ all -> 0x01ff }
            float r9 = r9 * r0
            int r9 = (int) r9     // Catch:{ all -> 0x01ff }
            goto L_0x00d9
        L_0x00d5:
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01ff }
        L_0x00d9:
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x00de:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x00e3:
            com.google.android.gms.internal.ads.zzbfn r0 = r7.zzerp     // Catch:{ all -> 0x01ff }
            boolean r0 = r0.zzady()     // Catch:{ all -> 0x01ff }
            if (r0 == 0) goto L_0x00f8
            android.util.DisplayMetrics r8 = r7.zzxl     // Catch:{ all -> 0x01ff }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01ff }
            android.util.DisplayMetrics r9 = r7.zzxl     // Catch:{ all -> 0x01ff }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01ff }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x00f8:
            int r0 = android.view.View.MeasureSpec.getMode(r8)     // Catch:{ all -> 0x01ff }
            int r8 = android.view.View.MeasureSpec.getSize(r8)     // Catch:{ all -> 0x01ff }
            int r2 = android.view.View.MeasureSpec.getMode(r9)     // Catch:{ all -> 0x01ff }
            int r9 = android.view.View.MeasureSpec.getSize(r9)     // Catch:{ all -> 0x01ff }
            r3 = 1073741824(0x40000000, float:2.0)
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r5 = 2147483647(0x7fffffff, float:NaN)
            if (r0 == r4) goto L_0x0118
            if (r0 != r3) goto L_0x0114
            goto L_0x0118
        L_0x0114:
            r0 = 2147483647(0x7fffffff, float:NaN)
            goto L_0x0119
        L_0x0118:
            r0 = r8
        L_0x0119:
            if (r2 == r4) goto L_0x011d
            if (r2 != r3) goto L_0x011e
        L_0x011d:
            r5 = r9
        L_0x011e:
            com.google.android.gms.internal.ads.zzbfn r2 = r7.zzerp     // Catch:{ all -> 0x01ff }
            int r2 = r2.widthPixels     // Catch:{ all -> 0x01ff }
            r3 = 1
            if (r2 > r0) goto L_0x012e
            com.google.android.gms.internal.ads.zzbfn r2 = r7.zzerp     // Catch:{ all -> 0x01ff }
            int r2 = r2.heightPixels     // Catch:{ all -> 0x01ff }
            if (r2 <= r5) goto L_0x012c
            goto L_0x012e
        L_0x012c:
            r2 = 0
            goto L_0x012f
        L_0x012e:
            r2 = 1
        L_0x012f:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r4 = com.google.android.gms.internal.ads.zzabf.zzcvc     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzabb r6 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x01ff }
            java.lang.Object r4 = r6.zzd(r4)     // Catch:{ all -> 0x01ff }
            java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x01ff }
            boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x01ff }
            if (r4 == 0) goto L_0x0167
            com.google.android.gms.internal.ads.zzbfn r4 = r7.zzerp     // Catch:{ all -> 0x01ff }
            int r4 = r4.widthPixels     // Catch:{ all -> 0x01ff }
            float r4 = (float) r4     // Catch:{ all -> 0x01ff }
            float r6 = r7.zzerf     // Catch:{ all -> 0x01ff }
            float r4 = r4 / r6
            float r0 = (float) r0     // Catch:{ all -> 0x01ff }
            float r6 = r7.zzerf     // Catch:{ all -> 0x01ff }
            float r0 = r0 / r6
            int r0 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r0 > 0) goto L_0x0163
            com.google.android.gms.internal.ads.zzbfn r0 = r7.zzerp     // Catch:{ all -> 0x01ff }
            int r0 = r0.heightPixels     // Catch:{ all -> 0x01ff }
            float r0 = (float) r0     // Catch:{ all -> 0x01ff }
            float r4 = r7.zzerf     // Catch:{ all -> 0x01ff }
            float r0 = r0 / r4
            float r4 = (float) r5     // Catch:{ all -> 0x01ff }
            float r5 = r7.zzerf     // Catch:{ all -> 0x01ff }
            float r4 = r4 / r5
            int r0 = (r0 > r4 ? 1 : (r0 == r4 ? 0 : -1))
            if (r0 > 0) goto L_0x0163
            r0 = 1
            goto L_0x0164
        L_0x0163:
            r0 = 0
        L_0x0164:
            if (r2 == 0) goto L_0x0167
            goto L_0x0168
        L_0x0167:
            r0 = r2
        L_0x0168:
            r2 = 8
            if (r0 == 0) goto L_0x01d7
            com.google.android.gms.internal.ads.zzbfn r0 = r7.zzerp     // Catch:{ all -> 0x01ff }
            int r0 = r0.widthPixels     // Catch:{ all -> 0x01ff }
            float r0 = (float) r0     // Catch:{ all -> 0x01ff }
            float r4 = r7.zzerf     // Catch:{ all -> 0x01ff }
            float r0 = r0 / r4
            int r0 = (int) r0     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzbfn r4 = r7.zzerp     // Catch:{ all -> 0x01ff }
            int r4 = r4.heightPixels     // Catch:{ all -> 0x01ff }
            float r4 = (float) r4     // Catch:{ all -> 0x01ff }
            float r5 = r7.zzerf     // Catch:{ all -> 0x01ff }
            float r4 = r4 / r5
            int r4 = (int) r4     // Catch:{ all -> 0x01ff }
            float r8 = (float) r8     // Catch:{ all -> 0x01ff }
            float r5 = r7.zzerf     // Catch:{ all -> 0x01ff }
            float r8 = r8 / r5
            int r8 = (int) r8     // Catch:{ all -> 0x01ff }
            float r9 = (float) r9     // Catch:{ all -> 0x01ff }
            float r5 = r7.zzerf     // Catch:{ all -> 0x01ff }
            float r9 = r9 / r5
            int r9 = (int) r9     // Catch:{ all -> 0x01ff }
            r5 = 103(0x67, float:1.44E-43)
            java.lang.StringBuilder r6 = new java.lang.StringBuilder     // Catch:{ all -> 0x01ff }
            r6.<init>(r5)     // Catch:{ all -> 0x01ff }
            java.lang.String r5 = "Not enough space to show ad. Needs "
            r6.append(r5)     // Catch:{ all -> 0x01ff }
            r6.append(r0)     // Catch:{ all -> 0x01ff }
            java.lang.String r0 = "x"
            r6.append(r0)     // Catch:{ all -> 0x01ff }
            r6.append(r4)     // Catch:{ all -> 0x01ff }
            java.lang.String r0 = " dp, but only has "
            r6.append(r0)     // Catch:{ all -> 0x01ff }
            r6.append(r8)     // Catch:{ all -> 0x01ff }
            java.lang.String r8 = "x"
            r6.append(r8)     // Catch:{ all -> 0x01ff }
            r6.append(r9)     // Catch:{ all -> 0x01ff }
            java.lang.String r8 = " dp."
            r6.append(r8)     // Catch:{ all -> 0x01ff }
            java.lang.String r8 = r6.toString()     // Catch:{ all -> 0x01ff }
            com.google.android.gms.ads.internal.util.zzd.zzfa(r8)     // Catch:{ all -> 0x01ff }
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01ff }
            if (r8 == r2) goto L_0x01c5
            r8 = 4
            r7.setVisibility(r8)     // Catch:{ all -> 0x01ff }
        L_0x01c5:
            r7.setMeasuredDimension(r1, r1)     // Catch:{ all -> 0x01ff }
            boolean r8 = r7.zzerk     // Catch:{ all -> 0x01ff }
            if (r8 != 0) goto L_0x01f8
            com.google.android.gms.internal.ads.zzts r8 = r7.zzeph     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zztu$zza$zza r9 = com.google.android.gms.internal.ads.zztu.zza.C3718zza.BANNER_SIZE_INVALID     // Catch:{ all -> 0x01ff }
            r8.zza((com.google.android.gms.internal.ads.zztu.zza.C3718zza) r9)     // Catch:{ all -> 0x01ff }
            r7.zzerk = r3     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x01d7:
            int r8 = r7.getVisibility()     // Catch:{ all -> 0x01ff }
            if (r8 == r2) goto L_0x01e0
            r7.setVisibility(r1)     // Catch:{ all -> 0x01ff }
        L_0x01e0:
            boolean r8 = r7.zzerl     // Catch:{ all -> 0x01ff }
            if (r8 != 0) goto L_0x01ed
            com.google.android.gms.internal.ads.zzts r8 = r7.zzeph     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zztu$zza$zza r9 = com.google.android.gms.internal.ads.zztu.zza.C3718zza.BANNER_SIZE_VALID     // Catch:{ all -> 0x01ff }
            r8.zza((com.google.android.gms.internal.ads.zztu.zza.C3718zza) r9)     // Catch:{ all -> 0x01ff }
            r7.zzerl = r3     // Catch:{ all -> 0x01ff }
        L_0x01ed:
            com.google.android.gms.internal.ads.zzbfn r8 = r7.zzerp     // Catch:{ all -> 0x01ff }
            int r8 = r8.widthPixels     // Catch:{ all -> 0x01ff }
            com.google.android.gms.internal.ads.zzbfn r9 = r7.zzerp     // Catch:{ all -> 0x01ff }
            int r9 = r9.heightPixels     // Catch:{ all -> 0x01ff }
            r7.setMeasuredDimension(r8, r9)     // Catch:{ all -> 0x01ff }
        L_0x01f8:
            monitor-exit(r7)
            return
        L_0x01fa:
            super.onMeasure(r8, r9)     // Catch:{ all -> 0x01ff }
            monitor-exit(r7)
            return
        L_0x01ff:
            r8 = move-exception
            monitor-exit(r7)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzbel.onMeasure(int, int):void");
    }

    public final void onPause() {
        if (!isDestroyed()) {
            try {
                super.onPause();
            } catch (Exception e) {
                zzd.zzc("Could not pause webview.", e);
            }
        }
    }

    public final void onResume() {
        if (!isDestroyed()) {
            try {
                super.onResume();
            } catch (Exception e) {
                zzd.zzc("Could not resume webview.", e);
            }
        }
    }

    public final boolean onTouchEvent(MotionEvent motionEvent) {
        if (!this.zzerm.zzabz() || this.zzerm.zzaca()) {
            zzef zzef = this.zzerb;
            if (zzef != null) {
                zzef.zza(motionEvent);
            }
            zzacg zzacg = this.zzerc;
            if (zzacg != null) {
                zzacg.zza(motionEvent);
            }
        } else {
            synchronized (this) {
                if (this.zzerz != null) {
                    this.zzerz.zzc(motionEvent);
                }
            }
        }
        if (isDestroyed()) {
            return false;
        }
        return super.onTouchEvent(motionEvent);
    }

    public final void setOnClickListener(View.OnClickListener onClickListener) {
        this.zzesh = new WeakReference<>(onClickListener);
        super.setOnClickListener(onClickListener);
    }

    public final synchronized void setRequestedOrientation(int i) {
        this.zzert = i;
        if (this.zzern != null) {
            this.zzern.setRequestedOrientation(this.zzert);
        }
    }

    public final void setWebViewClient(WebViewClient webViewClient) {
        super.setWebViewClient(webViewClient);
        if (webViewClient instanceof zzbdu) {
            this.zzerm = (zzbdu) webViewClient;
        }
    }

    public final void stopLoading() {
        if (!isDestroyed()) {
            try {
                super.stopLoading();
            } catch (Exception e) {
                zzd.zzc("Could not stop loading webview.", e);
            }
        }
    }

    public final void zza(ViewGroup viewGroup, Activity activity, String str, String str2) {
        if (!zzadj()) {
            zzd.zzee("AR ad is not enabled or the ad from the server is not an AR ad.");
            return;
        }
        if (getParent() instanceof ViewGroup) {
            ((ViewGroup) getParent()).removeView(this);
        }
        zzd.zzee("Initializing ArWebView object.");
        this.zzerg.zza(activity, this);
        this.zzerg.zzc(str, str2);
        if (viewGroup != null) {
            viewGroup.addView(this.zzerg.getView());
        } else {
            zzd.zzey("The FrameLayout object cannot be null.");
        }
    }

    public final void zza(com.google.android.gms.ads.internal.overlay.zzb zzb) {
        this.zzerm.zza(zzb);
    }

    public final synchronized void zza(zze zze) {
        this.zzern = zze;
    }

    public final synchronized void zza(zzads zzads) {
        this.zzesa = zzads;
    }

    public final synchronized void zza(zzadx zzadx) {
        this.zzerz = zzadx;
    }

    public final synchronized void zza(zzbep zzbep) {
        if (this.zzerw != null) {
            zzd.zzey("Attempt to create multiple AdWebViewVideoControllers.");
        } else {
            this.zzerw = zzbep;
        }
    }

    public final synchronized void zza(zzbfn zzbfn) {
        this.zzerp = zzbfn;
        requestLayout();
    }

    public final void zza(zzdmu zzdmu, zzdmz zzdmz) {
        this.zzeri = zzdmu;
        this.zzerj = zzdmz;
    }

    public final void zza(zzqv zzqv) {
        synchronized (this) {
            this.zzerx = zzqv.zzbqz;
        }
        zzbc(zzqv.zzbqz);
    }

    public final synchronized void zza(zzsc zzsc) {
        this.zzesb = zzsc;
    }

    public final void zza(String str, Predicate<zzahv<? super zzbdv>> predicate) {
        zzbdu zzbdu = this.zzerm;
        if (zzbdu != null) {
            zzbdu.zza(str, predicate);
        }
    }

    public final void zza(String str, zzahv<? super zzbdv> zzahv) {
        zzbdu zzbdu = this.zzerm;
        if (zzbdu != null) {
            zzbdu.zza(str, zzahv);
        }
    }

    public final synchronized void zza(String str, zzbcx zzbcx) {
        if (this.zzesl == null) {
            this.zzesl = new HashMap();
        }
        this.zzesl.put(str, zzbcx);
    }

    public final void zza(String str, Map<String, ?> map) {
        try {
            zzb(str, zzp.zzkq().zzj(map));
        } catch (JSONException unused) {
            zzd.zzfa("Could not convert parameters to JSON.");
        }
    }

    public final void zza(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder(String.valueOf(str).length() + 3 + String.valueOf(jSONObject2).length());
        sb.append(str);
        sb.append("(");
        sb.append(jSONObject2);
        sb.append(");");
        zzfp(sb.toString());
    }

    public final void zza(boolean z, int i, String str) {
        this.zzerm.zza(z, i, str);
    }

    public final void zza(boolean z, int i, String str, String str2) {
        this.zzerm.zza(z, i, str, str2);
    }

    public final void zza(boolean z, long j) {
        HashMap hashMap = new HashMap(2);
        hashMap.put(FirebaseAnalytics.Param.SUCCESS, z ? "1" : "0");
        hashMap.put("duration", Long.toString(j));
        zza("onCacheAccessComplete", (Map<String, ?>) hashMap);
    }

    public final zzbax zzaag() {
        return null;
    }

    public final synchronized zzbep zzaah() {
        return this.zzerw;
    }

    public final zzabq zzaai() {
        return this.zzelc;
    }

    public final Activity zzaaj() {
        return this.zzera.zzaaj();
    }

    public final zzb zzaak() {
        return this.zzere;
    }

    public final synchronized String zzaal() {
        if (this.zzerj == null) {
            return null;
        }
        return this.zzerj.zzbvf;
    }

    public final synchronized int zzaam() {
        return this.zzbvg;
    }

    public final zzabt zzaan() {
        return this.zzesg;
    }

    public final zzazh zzaao() {
        return this.zzbpd;
    }

    public final int zzaap() {
        return getMeasuredHeight();
    }

    public final int zzaaq() {
        return getMeasuredWidth();
    }

    public final synchronized void zzaar() {
        if (this.zzesa != null) {
            this.zzesa.zzsq();
        }
    }

    public final zzdmu zzabw() {
        return this.zzeri;
    }

    public final void zzacl() {
        zzadn();
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbpd.zzbrf);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    public final void zzacm() {
        HashMap hashMap = new HashMap(3);
        hashMap.put("app_muted", String.valueOf(zzp.zzkv().zzql()));
        hashMap.put("app_volume", String.valueOf(zzp.zzkv().zzqk()));
        hashMap.put("device_volume", String.valueOf(zzad.zzbi(getContext())));
        zza("volume", (Map<String, ?>) hashMap);
    }

    public final Context zzacn() {
        return this.zzera.zzacn();
    }

    public final synchronized zze zzaco() {
        return this.zzern;
    }

    public final synchronized zze zzacp() {
        return this.zzesi;
    }

    public final synchronized zzbfn zzacq() {
        return this.zzerp;
    }

    public final synchronized String zzacr() {
        return this.zzacv;
    }

    public final /* synthetic */ zzbfg zzacs() {
        return this.zzerm;
    }

    public final WebViewClient zzact() {
        return this.zzerm;
    }

    public final synchronized boolean zzacu() {
        return this.zzdro;
    }

    public final zzef zzacv() {
        return this.zzerb;
    }

    public final synchronized IObjectWrapper zzacw() {
        return this.zzero;
    }

    public final synchronized boolean zzacx() {
        return this.zzerr;
    }

    public final synchronized void zzacy() {
        zzd.zzee("Destroying WebView!");
        zzwx();
        zzm.zzedd.post(new zzbem(this));
    }

    public final synchronized boolean zzacz() {
        return this.zzeru;
    }

    public final synchronized boolean zzada() {
        return this.zzesc > 0;
    }

    public final void zzadb() {
        this.zzesk.zzyz();
    }

    public final void zzadc() {
        if (this.zzesf == null) {
            this.zzesf = zzabn.zzb(this.zzesg.zzry());
            this.zzesg.zza("native:view_load", this.zzesf);
        }
    }

    public final synchronized zzadx zzadd() {
        return this.zzerz;
    }

    public final void zzade() {
        setBackgroundColor(0);
    }

    public final void zzadf() {
        zzd.zzee("Cannot add text view to inner AdWebView");
    }

    public final synchronized zzsc zzadg() {
        return this.zzesb;
    }

    public final boolean zzadh() {
        return false;
    }

    public final zzsu zzadi() {
        return this.zzerg;
    }

    public final boolean zzadj() {
        return ((Boolean) zzwq.zzqe().zzd(zzabf.zzcwz)).booleanValue() && this.zzerg != null && this.zzerh;
    }

    public final zzdmz zzadk() {
        return this.zzerj;
    }

    public final synchronized void zzal(boolean z) {
        if (this.zzern != null) {
            this.zzern.zza(this.zzerm.zzaby(), z);
        } else {
            this.zzdro = z;
        }
    }

    public final synchronized void zzaq(IObjectWrapper iObjectWrapper) {
        this.zzero = iObjectWrapper;
    }

    public final void zzau(boolean z) {
        this.zzerm.zzau(z);
    }

    public final void zzaw(boolean z) {
        this.zzerm.zzaw(z);
    }

    public final synchronized void zzaz(boolean z) {
        boolean z2 = z != this.zzerr;
        this.zzerr = z;
        zzado();
        if (z2) {
            if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzcnb)).booleanValue() || !this.zzerp.zzady()) {
                new zzaqu(this).zzdv(z ? "expanded" : "default");
            }
        }
    }

    public final synchronized void zzb(zze zze) {
        this.zzesi = zze;
    }

    public final void zzb(String str, zzahv<? super zzbdv> zzahv) {
        zzbdu zzbdu = this.zzerm;
        if (zzbdu != null) {
            zzbdu.zzb(str, zzahv);
        }
    }

    public final synchronized void zzb(String str, String str2, String str3) {
        if (!isDestroyed()) {
            String str4 = str;
            super.loadDataWithBaseURL(str4, zzbfd.zzf(str2, zzbfd.zzadu()), "text/html", "UTF-8", str3);
            return;
        }
        zzd.zzfa("#004 The webview is destroyed. Ignoring action.");
    }

    public final void zzb(String str, JSONObject jSONObject) {
        if (jSONObject == null) {
            jSONObject = new JSONObject();
        }
        String jSONObject2 = jSONObject.toString();
        StringBuilder sb = new StringBuilder();
        sb.append("(window.AFMA_ReceiveMessage || function() {})('");
        sb.append(str);
        sb.append("'");
        sb.append(",");
        sb.append(jSONObject2);
        sb.append(");");
        String valueOf = String.valueOf(sb.toString());
        zzd.zzeb(valueOf.length() != 0 ? "Dispatching AFMA event: ".concat(valueOf) : new String("Dispatching AFMA event: "));
        zzfp(sb.toString());
    }

    public final void zzb(boolean z, int i) {
        this.zzerm.zzb(z, i);
    }

    public final synchronized void zzba(boolean z) {
        this.zzeru = z;
    }

    public final synchronized void zzbb(boolean z) {
        this.zzesc += z ? 1 : -1;
        if (this.zzesc <= 0 && this.zzern != null) {
            this.zzern.zzvl();
        }
    }

    public final void zzbx(Context context) {
        this.zzera.setBaseContext(context);
        this.zzesk.zzj(this.zzera.zzaaj());
    }

    public final boolean zzc(boolean z, int i) {
        destroy();
        this.zzeph.zza((zztv) new zzbek(z, i));
        this.zzeph.zza(zztu.zza.C3718zza.ANDROID_WEBVIEW_CRASH);
        return true;
    }

    public final void zzcy(String str) {
        zzfp(str);
    }

    public final synchronized void zzdq(int i) {
        this.zzbvg = i;
    }

    public final void zzdv(int i) {
        if (i == 0) {
            zzabn.zza(this.zzesg.zzry(), this.zzelc, "aebb2");
        }
        zzadn();
        if (this.zzesg.zzry() != null) {
            this.zzesg.zzry().zzh("close_type", String.valueOf(i));
        }
        HashMap hashMap = new HashMap(2);
        hashMap.put("closetype", String.valueOf(i));
        hashMap.put("version", this.zzbpd.zzbrf);
        zza("onhide", (Map<String, ?>) hashMap);
    }

    public final synchronized zzbcx zzff(String str) {
        if (this.zzesl == null) {
            return null;
        }
        return this.zzesl.get(str);
    }

    public final synchronized void zzkm() {
        this.zzerv = true;
        if (this.zzerd != null) {
            this.zzerd.zzkm();
        }
    }

    public final synchronized void zzkn() {
        this.zzerv = false;
        if (this.zzerd != null) {
            this.zzerd.zzkn();
        }
    }

    public final void zzvj() {
        if (this.zzese == null) {
            zzabn.zza(this.zzesg.zzry(), this.zzelc, "aes2");
            this.zzese = zzabn.zzb(this.zzesg.zzry());
            this.zzesg.zza("native:view_show", this.zzese);
        }
        HashMap hashMap = new HashMap(1);
        hashMap.put("version", this.zzbpd.zzbrf);
        zza("onshow", (Map<String, ?>) hashMap);
    }

    public final void zzvk() {
        zze zzaco = zzaco();
        if (zzaco != null) {
            zzaco.zzvk();
        }
    }
}
