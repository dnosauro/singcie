package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.ActivityManager;
import android.app.KeyguardManager;
import android.content.Context;
import android.graphics.Rect;
import android.os.PowerManager;
import android.os.Process;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.PlatformVersion;
import com.google.android.gms.common.util.VisibleForTesting;
import java.util.List;
import javax.annotation.ParametersAreNonnullByDefault;
import org.apache.commons.p172io.IOUtils;
import org.json.JSONException;
import org.json.JSONObject;
import org.spongycastle.i18n.TextBundle;

@TargetApi(14)
@ParametersAreNonnullByDefault
public final class zzrk extends Thread {
    private final Object lock;
    private boolean started;
    private final int zzbrv;
    private final int zzbrx;
    private final boolean zzbry;
    private boolean zzbsv;
    private boolean zzbsw;
    private final zzrh zzbsx;
    private final int zzbsy;
    private final int zzbsz;
    private final int zzbta;
    private final int zzbtb;
    private final int zzbtc;
    private final int zzbtd;
    private final String zzbte;
    private final boolean zzbtf;
    private final boolean zzbtg;

    public zzrk() {
        this(new zzrh());
    }

    @VisibleForTesting
    private zzrk(zzrh zzrh) {
        this.started = false;
        this.zzbsv = false;
        this.zzbsw = false;
        this.zzbsx = zzrh;
        this.lock = new Object();
        this.zzbrv = zzacv.zzdbv.get().intValue();
        this.zzbsz = zzacv.zzdbs.get().intValue();
        this.zzbrx = zzacv.zzdbw.get().intValue();
        this.zzbta = zzacv.zzdbu.get().intValue();
        this.zzbtb = ((Integer) zzwq.zzqe().zzd(zzabf.zzcnd)).intValue();
        this.zzbtc = ((Integer) zzwq.zzqe().zzd(zzabf.zzcne)).intValue();
        this.zzbtd = ((Integer) zzwq.zzqe().zzd(zzabf.zzcnf)).intValue();
        this.zzbsy = zzacv.zzdbx.get().intValue();
        this.zzbte = (String) zzwq.zzqe().zzd(zzabf.zzcnh);
        this.zzbtf = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcni)).booleanValue();
        this.zzbry = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcnj)).booleanValue();
        this.zzbtg = ((Boolean) zzwq.zzqe().zzd(zzabf.zzcnk)).booleanValue();
        setName("ContentFetchTask");
    }

    @VisibleForTesting
    private final zzro zza(View view, zzre zzre) {
        boolean z;
        if (view == null) {
            return new zzro(this, 0, 0);
        }
        boolean globalVisibleRect = view.getGlobalVisibleRect(new Rect());
        if ((view instanceof TextView) && !(view instanceof EditText)) {
            CharSequence text = ((TextView) view).getText();
            if (TextUtils.isEmpty(text)) {
                return new zzro(this, 0, 0);
            }
            zzre.zzb(text.toString(), globalVisibleRect, view.getX(), view.getY(), (float) view.getWidth(), (float) view.getHeight());
            return new zzro(this, 1, 0);
        } else if ((view instanceof WebView) && !(view instanceof zzbdv)) {
            WebView webView = (WebView) view;
            if (!PlatformVersion.isAtLeastKitKat()) {
                z = false;
            } else {
                zzre.zzmd();
                webView.post(new zzrm(this, zzre, webView, globalVisibleRect));
                z = true;
            }
            return z ? new zzro(this, 0, 1) : new zzro(this, 0, 0);
        } else if (!(view instanceof ViewGroup)) {
            return new zzro(this, 0, 0);
        } else {
            ViewGroup viewGroup = (ViewGroup) view;
            int i = 0;
            int i2 = 0;
            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                zzro zza = zza(viewGroup.getChildAt(i3), zzre);
                i += zza.zzbtn;
                i2 += zza.zzbto;
            }
            return new zzro(this, i, i2);
        }
    }

    @VisibleForTesting
    private static boolean zzmi() {
        try {
            Context context = zzp.zzkt().getContext();
            if (context == null) {
                return false;
            }
            ActivityManager activityManager = (ActivityManager) context.getSystemService("activity");
            KeyguardManager keyguardManager = (KeyguardManager) context.getSystemService("keyguard");
            if (activityManager == null) {
                return false;
            }
            if (keyguardManager == null) {
                return false;
            }
            List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = activityManager.getRunningAppProcesses();
            if (runningAppProcesses == null) {
                return false;
            }
            for (ActivityManager.RunningAppProcessInfo next : runningAppProcesses) {
                if (Process.myPid() == next.pid) {
                    if (next.importance != 100 || keyguardManager.inKeyguardRestrictedInputMode()) {
                        return false;
                    }
                    PowerManager powerManager = (PowerManager) context.getSystemService("power");
                    return powerManager == null ? false : powerManager.isScreenOn();
                }
            }
            return false;
        } catch (Throwable th) {
            zzp.zzku().zza(th, "ContentFetchTask.isInForeground");
            return false;
        }
    }

    private final void zzmk() {
        synchronized (this.lock) {
            this.zzbsv = true;
            boolean z = this.zzbsv;
            StringBuilder sb = new StringBuilder(42);
            sb.append("ContentFetchThread: paused, mPause = ");
            sb.append(z);
            zzd.zzeb(sb.toString());
        }
    }

    /*  JADX ERROR: IndexOutOfBoundsException in pass: RegionMakerVisitor
        java.lang.IndexOutOfBoundsException: Index 0 out of bounds for length 0
        	at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        	at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        	at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        	at java.base/java.util.Objects.checkIndex(Objects.java:372)
        	at java.base/java.util.ArrayList.get(ArrayList.java:458)
        	at jadx.core.dex.nodes.InsnNode.getArg(InsnNode.java:101)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:611)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverseMonitorExits(RegionMaker.java:619)
        	at jadx.core.dex.visitors.regions.RegionMaker.processMonitorEnter(RegionMaker.java:561)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:133)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeEndlessLoop(RegionMaker.java:368)
        	at jadx.core.dex.visitors.regions.RegionMaker.processLoop(RegionMaker.java:172)
        	at jadx.core.dex.visitors.regions.RegionMaker.traverse(RegionMaker.java:106)
        	at jadx.core.dex.visitors.regions.RegionMaker.makeRegion(RegionMaker.java:86)
        	at jadx.core.dex.visitors.regions.RegionMakerVisitor.visit(RegionMakerVisitor.java:49)
        */
    public final void run() {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = zzmi()     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            if (r0 == 0) goto L_0x005a
            com.google.android.gms.internal.ads.zzrg r0 = com.google.android.gms.ads.internal.zzp.zzkt()     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            android.app.Activity r0 = r0.getActivity()     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            if (r0 != 0) goto L_0x0019
            java.lang.String r0 = "ContentFetchThread: no activity. Sleeping."
            com.google.android.gms.ads.internal.util.zzd.zzeb(r0)     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
        L_0x0015:
            r4.zzmk()     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            goto L_0x0060
        L_0x0019:
            if (r0 == 0) goto L_0x0060
            r1 = 0
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x0079 }
            if (r2 == 0) goto L_0x004c
            android.view.Window r2 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x0079 }
            android.view.View r2 = r2.getDecorView()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x0079 }
            if (r2 == 0) goto L_0x004c
            android.view.Window r0 = r0.getWindow()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x0079 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x0079 }
            r2 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r2)     // Catch:{ Exception -> 0x003d, InterruptedException -> 0x0079 }
            r1 = r0
            goto L_0x004c
        L_0x003d:
            r0 = move-exception
            com.google.android.gms.internal.ads.zzayg r2 = com.google.android.gms.ads.internal.zzp.zzku()     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            java.lang.String r3 = "ContentFetchTask.extractContent"
            r2.zza(r0, r3)     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            java.lang.String r0 = "Failed getting root view of activity. Content not extracted."
            com.google.android.gms.ads.internal.util.zzd.zzeb(r0)     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
        L_0x004c:
            if (r1 == 0) goto L_0x0060
            if (r1 != 0) goto L_0x0051
            goto L_0x0060
        L_0x0051:
            com.google.android.gms.internal.ads.zzrn r0 = new com.google.android.gms.internal.ads.zzrn     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            r0.<init>(r4, r1)     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            r1.post(r0)     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            goto L_0x0060
        L_0x005a:
            java.lang.String r0 = "ContentFetchTask: sleeping"
            com.google.android.gms.ads.internal.util.zzd.zzeb(r0)     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            goto L_0x0015
        L_0x0060:
            int r0 = r4.zzbsy     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            int r0 = r0 * 1000
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0079, Exception -> 0x0069 }
            goto L_0x007f
        L_0x0069:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.ads.internal.util.zzd.zzc(r1, r0)
            com.google.android.gms.internal.ads.zzayg r1 = com.google.android.gms.ads.internal.zzp.zzku()
            java.lang.String r2 = "ContentFetchTask.run"
            r1.zza(r0, r2)
            goto L_0x007f
        L_0x0079:
            r0 = move-exception
            java.lang.String r1 = "Error in ContentFetchTask"
            com.google.android.gms.ads.internal.util.zzd.zzc(r1, r0)
        L_0x007f:
            java.lang.Object r0 = r4.lock
            monitor-enter(r0)
        L_0x0082:
            boolean r1 = r4.zzbsv     // Catch:{ all -> 0x0094 }
            if (r1 == 0) goto L_0x0091
            java.lang.String r1 = "ContentFetchTask: waiting"
            com.google.android.gms.ads.internal.util.zzd.zzeb(r1)     // Catch:{ InterruptedException -> 0x0082 }
            java.lang.Object r1 = r4.lock     // Catch:{ InterruptedException -> 0x0082 }
            r1.wait()     // Catch:{ InterruptedException -> 0x0082 }
            goto L_0x0082
        L_0x0091:
            monitor-exit(r0)     // Catch:{ all -> 0x0094 }
            goto L_0x0000
        L_0x0094:
            r1 = move-exception
            monitor-exit(r0)     // Catch:{ all -> 0x0094 }
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzrk.run():void");
    }

    public final void wakeup() {
        synchronized (this.lock) {
            this.zzbsv = false;
            this.lock.notifyAll();
            zzd.zzeb("ContentFetchThread: wakeup");
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zza(zzre zzre, WebView webView, String str, boolean z) {
        zzre.zzmc();
        try {
            if (!TextUtils.isEmpty(str)) {
                String optString = new JSONObject(str).optString(TextBundle.TEXT_ENTRY);
                if (this.zzbtf || TextUtils.isEmpty(webView.getTitle())) {
                    zzre.zza(optString, z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                } else {
                    String title = webView.getTitle();
                    StringBuilder sb = new StringBuilder(String.valueOf(title).length() + 1 + String.valueOf(optString).length());
                    sb.append(title);
                    sb.append(IOUtils.LINE_SEPARATOR_UNIX);
                    sb.append(optString);
                    zzre.zza(sb.toString(), z, webView.getX(), webView.getY(), (float) webView.getWidth(), (float) webView.getHeight());
                }
            }
            if (zzre.zzlx()) {
                this.zzbsx.zzb(zzre);
            }
        } catch (JSONException unused) {
            zzd.zzeb("Json string may be malformed.");
        } catch (Throwable th) {
            zzd.zzb("Failed to get webview content.", th);
            zzp.zzku().zza(th, "ContentFetchTask.processWebViewContent");
        }
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzj(View view) {
        try {
            zzre zzre = new zzre(this.zzbrv, this.zzbsz, this.zzbrx, this.zzbta, this.zzbtb, this.zzbtc, this.zzbtd, this.zzbry);
            Context context = zzp.zzkt().getContext();
            if (context != null && !TextUtils.isEmpty(this.zzbte)) {
                String str = (String) view.getTag(context.getResources().getIdentifier((String) zzwq.zzqe().zzd(zzabf.zzcng), "id", context.getPackageName()));
                if (str != null && str.equals(this.zzbte)) {
                    return;
                }
            }
            zzro zza = zza(view, zzre);
            zzre.zzmf();
            if (zza.zzbtn != 0 || zza.zzbto != 0) {
                if (zza.zzbto != 0 || zzre.zzmg() != 0) {
                    if (zza.zzbto != 0 || !this.zzbsx.zza(zzre)) {
                        this.zzbsx.zzc(zzre);
                    }
                }
            }
        } catch (Exception e) {
            zzd.zzc("Exception in fetchContentOnUIThread", e);
            zzp.zzku().zza(e, "ContentFetchTask.fetchContent");
        }
    }

    public final void zzmh() {
        synchronized (this.lock) {
            if (this.started) {
                zzd.zzeb("Content hash thread already started, quiting...");
                return;
            }
            this.started = true;
            start();
        }
    }

    public final zzre zzmj() {
        return this.zzbsx.zzo(this.zzbtg);
    }

    public final boolean zzml() {
        return this.zzbsv;
    }
}
