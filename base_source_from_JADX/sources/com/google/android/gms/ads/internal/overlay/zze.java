package com.google.android.gms.ads.internal.overlay;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.webkit.WebChromeClient;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.util.zzu;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import com.google.android.gms.dynamic.IObjectWrapper;
import com.google.android.gms.dynamic.ObjectWrapper;
import com.google.android.gms.internal.ads.zzabf;
import com.google.android.gms.internal.ads.zzari;
import com.google.android.gms.internal.ads.zzbdv;
import com.google.android.gms.internal.ads.zzwq;
import com.parse.ParseQuery;
import java.util.Collections;

public class zze extends zzari implements zzz {
    @VisibleForTesting
    private static final int zzdqh = Color.argb(0, 0, 0, 0);
    protected final Activity zzaap;
    @VisibleForTesting
    private boolean zzbou = false;
    @VisibleForTesting
    zzbdv zzdii;
    @VisibleForTesting
    AdOverlayInfoParcel zzdqi;
    @VisibleForTesting
    private zzk zzdqj;
    @VisibleForTesting
    private zzr zzdqk;
    @VisibleForTesting
    private boolean zzdql = false;
    @VisibleForTesting
    private FrameLayout zzdqm;
    @VisibleForTesting
    private WebChromeClient.CustomViewCallback zzdqn;
    @VisibleForTesting
    private boolean zzdqo = false;
    @VisibleForTesting
    private zzh zzdqp;
    @VisibleForTesting
    private boolean zzdqq = false;
    @VisibleForTesting
    zzl zzdqr = zzl.BACK_BUTTON;
    private final Object zzdqs = new Object();
    private Runnable zzdqt;
    private boolean zzdqu;
    private boolean zzdqv;
    private boolean zzdqw = false;
    private boolean zzdqx = false;
    private boolean zzdqy = true;

    public zze(Activity activity) {
        this.zzaap = activity;
    }

    private final void zza(Configuration configuration) {
        AdOverlayInfoParcel adOverlayInfoParcel;
        AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdqi;
        boolean z = true;
        boolean z2 = false;
        boolean z3 = (adOverlayInfoParcel2 == null || adOverlayInfoParcel2.zzdrt == null || !this.zzdqi.zzdrt.zzbov) ? false : true;
        boolean zza = zzp.zzks().zza(this.zzaap, configuration);
        if ((this.zzbou && !z3) || zza) {
            z = false;
        } else if (Build.VERSION.SDK_INT >= 19 && (adOverlayInfoParcel = this.zzdqi) != null && adOverlayInfoParcel.zzdrt != null && this.zzdqi.zzdrt.zzbpa) {
            z2 = true;
        }
        Window window = this.zzaap.getWindow();
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcow)).booleanValue() && Build.VERSION.SDK_INT >= 19) {
            View decorView = window.getDecorView();
            int i = 256;
            if (z) {
                i = 5380;
                if (z2) {
                    i = 5894;
                }
            }
            decorView.setSystemUiVisibility(i);
        } else if (z) {
            window.addFlags(1024);
            window.clearFlags(2048);
            if (Build.VERSION.SDK_INT >= 19 && z2) {
                window.getDecorView().setSystemUiVisibility(4098);
            }
        } else {
            window.addFlags(2048);
            window.clearFlags(1024);
        }
    }

    private final void zzaj(boolean z) {
        int intValue = ((Integer) zzwq.zzqe().zzd(zzabf.zzcub)).intValue();
        zzq zzq = new zzq();
        zzq.size = 50;
        zzq.paddingLeft = z ? intValue : 0;
        zzq.paddingRight = z ? 0 : intValue;
        zzq.paddingTop = 0;
        zzq.paddingBottom = intValue;
        this.zzdqk = new zzr(this.zzaap, zzq, this);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(10);
        layoutParams.addRule(z ? 11 : 9);
        zza(z, this.zzdqi.zzdro);
        this.zzdqp.addView(this.zzdqk, layoutParams);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:20:0x004b, code lost:
        if (r1.zzaap.getResources().getConfiguration().orientation == 1) goto L_0x004d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0068, code lost:
        if (r1.zzaap.getResources().getConfiguration().orientation == 2) goto L_0x004d;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void zzak(boolean r23) {
        /*
            r22 = this;
            r1 = r22
            boolean r0 = r1.zzdqv
            r2 = 1
            if (r0 != 0) goto L_0x000c
            android.app.Activity r0 = r1.zzaap
            r0.requestWindowFeature(r2)
        L_0x000c:
            android.app.Activity r0 = r1.zzaap
            android.view.Window r0 = r0.getWindow()
            if (r0 == 0) goto L_0x0210
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzdqi
            com.google.android.gms.internal.ads.zzbdv r3 = r3.zzdii
            r4 = 0
            if (r3 == 0) goto L_0x0024
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r1.zzdqi
            com.google.android.gms.internal.ads.zzbdv r3 = r3.zzdii
            com.google.android.gms.internal.ads.zzbfg r3 = r3.zzacs()
            goto L_0x0025
        L_0x0024:
            r3 = r4
        L_0x0025:
            r5 = 0
            if (r3 == 0) goto L_0x0030
            boolean r3 = r3.zzaby()
            if (r3 == 0) goto L_0x0030
            r3 = 1
            goto L_0x0031
        L_0x0030:
            r3 = 0
        L_0x0031:
            r1.zzdqq = r5
            if (r3 == 0) goto L_0x006b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzdqi
            int r6 = r6.orientation
            com.google.android.gms.ads.internal.zzp.zzks()
            r7 = 6
            if (r6 != r7) goto L_0x0051
            android.app.Activity r6 = r1.zzaap
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            if (r6 != r2) goto L_0x004e
        L_0x004d:
            r5 = 1
        L_0x004e:
            r1.zzdqq = r5
            goto L_0x006b
        L_0x0051:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzdqi
            int r6 = r6.orientation
            com.google.android.gms.ads.internal.zzp.zzks()
            r7 = 7
            if (r6 != r7) goto L_0x006b
            android.app.Activity r6 = r1.zzaap
            android.content.res.Resources r6 = r6.getResources()
            android.content.res.Configuration r6 = r6.getConfiguration()
            int r6 = r6.orientation
            r7 = 2
            if (r6 != r7) goto L_0x004e
            goto L_0x004d
        L_0x006b:
            boolean r5 = r1.zzdqq
            r6 = 46
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>(r6)
            java.lang.String r6 = "Delay onShow to next orientation change: "
            r7.append(r6)
            r7.append(r5)
            java.lang.String r5 = r7.toString()
            com.google.android.gms.ads.internal.util.zzd.zzeb(r5)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r5 = r1.zzdqi
            int r5 = r5.orientation
            r1.setRequestedOrientation(r5)
            com.google.android.gms.ads.internal.zzp.zzks()
            r5 = 16777216(0x1000000, float:2.3509887E-38)
            r0.setFlags(r5, r5)
            java.lang.String r0 = "Hardware acceleration on the AdActivity window enabled."
            com.google.android.gms.ads.internal.util.zzd.zzeb(r0)
            boolean r0 = r1.zzbou
            if (r0 != 0) goto L_0x00a0
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzdqp
            r5 = -16777216(0xffffffffff000000, float:-1.7014118E38)
            goto L_0x00a4
        L_0x00a0:
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzdqp
            int r5 = zzdqh
        L_0x00a4:
            r0.setBackgroundColor(r5)
            android.app.Activity r0 = r1.zzaap
            com.google.android.gms.ads.internal.overlay.zzh r5 = r1.zzdqp
            r0.setContentView(r5)
            r1.zzdqv = r2
            if (r23 == 0) goto L_0x0198
            com.google.android.gms.ads.internal.zzp.zzkr()     // Catch:{ Exception -> 0x018a }
            android.app.Activity r6 = r1.zzaap     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii     // Catch:{ Exception -> 0x018a }
            if (r0 == 0) goto L_0x00c7
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.internal.ads.zzbfn r0 = r0.zzacq()     // Catch:{ Exception -> 0x018a }
            r7 = r0
            goto L_0x00c8
        L_0x00c7:
            r7 = r4
        L_0x00c8:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii     // Catch:{ Exception -> 0x018a }
            if (r0 == 0) goto L_0x00d8
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii     // Catch:{ Exception -> 0x018a }
            java.lang.String r0 = r0.zzacr()     // Catch:{ Exception -> 0x018a }
            r8 = r0
            goto L_0x00d9
        L_0x00d8:
            r8 = r4
        L_0x00d9:
            r9 = 1
            r11 = 0
            r12 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.internal.ads.zzazh r13 = r0.zzbpd     // Catch:{ Exception -> 0x018a }
            r14 = 0
            r15 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii     // Catch:{ Exception -> 0x018a }
            if (r0 == 0) goto L_0x00f3
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.ads.internal.zzb r0 = r0.zzaak()     // Catch:{ Exception -> 0x018a }
            r16 = r0
            goto L_0x00f5
        L_0x00f3:
            r16 = r4
        L_0x00f5:
            com.google.android.gms.internal.ads.zzts r17 = com.google.android.gms.internal.ads.zzts.zzne()     // Catch:{ Exception -> 0x018a }
            r18 = 0
            r19 = 0
            r20 = 0
            r21 = 0
            r10 = r3
            com.google.android.gms.internal.ads.zzbdv r0 = com.google.android.gms.internal.ads.zzbed.zza(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18, r19, r20, r21)     // Catch:{ Exception -> 0x018a }
            r1.zzdii = r0     // Catch:{ Exception -> 0x018a }
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii
            com.google.android.gms.internal.ads.zzbfg r5 = r0.zzacs()
            r6 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            com.google.android.gms.internal.ads.zzagy r7 = r0.zzdfr
            r8 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            com.google.android.gms.internal.ads.zzaha r9 = r0.zzdfs
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            com.google.android.gms.ads.internal.overlay.zzu r10 = r0.zzdrq
            r11 = 1
            r12 = 0
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii
            if (r0 == 0) goto L_0x0132
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii
            com.google.android.gms.internal.ads.zzbfg r0 = r0.zzacs()
            com.google.android.gms.ads.internal.zza r0 = r0.zzabx()
            r13 = r0
            goto L_0x0133
        L_0x0132:
            r13 = r4
        L_0x0133:
            r14 = 0
            r15 = 0
            r16 = 0
            r17 = 0
            r18 = 0
            r5.zza(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17, r18)
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii
            com.google.android.gms.internal.ads.zzbfg r0 = r0.zzacs()
            com.google.android.gms.ads.internal.overlay.zzd r5 = new com.google.android.gms.ads.internal.overlay.zzd
            r5.<init>(r1)
            r0.zza((com.google.android.gms.internal.ads.zzbfj) r5)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            java.lang.String r0 = r0.url
            if (r0 == 0) goto L_0x015c
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r5 = r1.zzdqi
            java.lang.String r5 = r5.url
            r0.loadUrl(r5)
            goto L_0x0174
        L_0x015c:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            java.lang.String r0 = r0.zzdrp
            if (r0 == 0) goto L_0x0182
            com.google.android.gms.internal.ads.zzbdv r5 = r1.zzdii
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            java.lang.String r6 = r0.zzdrn
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            java.lang.String r7 = r0.zzdrp
            java.lang.String r8 = "text/html"
            java.lang.String r9 = "UTF-8"
            r10 = 0
            r5.loadDataWithBaseURL(r6, r7, r8, r9, r10)
        L_0x0174:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii
            if (r0 == 0) goto L_0x01a5
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii
            r0.zzb(r1)
            goto L_0x01a5
        L_0x0182:
            com.google.android.gms.ads.internal.overlay.zzi r0 = new com.google.android.gms.ads.internal.overlay.zzi
            java.lang.String r2 = "No URL or HTML to display in ad overlay."
            r0.<init>(r2)
            throw r0
        L_0x018a:
            r0 = move-exception
            java.lang.String r2 = "Error obtaining webview."
            com.google.android.gms.ads.internal.util.zzd.zzc(r2, r0)
            com.google.android.gms.ads.internal.overlay.zzi r0 = new com.google.android.gms.ads.internal.overlay.zzi
            java.lang.String r2 = "Could not obtain webview for the overlay."
            r0.<init>(r2)
            throw r0
        L_0x0198:
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii
            r1.zzdii = r0
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii
            android.app.Activity r5 = r1.zzaap
            r0.zzbx(r5)
        L_0x01a5:
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii
            r0.zza((com.google.android.gms.ads.internal.overlay.zze) r1)
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii
            if (r0 == 0) goto L_0x01bd
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r1.zzdqi
            com.google.android.gms.internal.ads.zzbdv r0 = r0.zzdii
            com.google.android.gms.dynamic.IObjectWrapper r0 = r0.zzacw()
            com.google.android.gms.ads.internal.overlay.zzh r5 = r1.zzdqp
            zzc(r0, r5)
        L_0x01bd:
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii
            android.view.ViewParent r0 = r0.getParent()
            if (r0 == 0) goto L_0x01d4
            boolean r5 = r0 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x01d4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            com.google.android.gms.internal.ads.zzbdv r5 = r1.zzdii
            android.view.View r5 = r5.getView()
            r0.removeView(r5)
        L_0x01d4:
            boolean r0 = r1.zzbou
            if (r0 == 0) goto L_0x01dd
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii
            r0.zzade()
        L_0x01dd:
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii
            android.app.Activity r5 = r1.zzaap
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r6 = r1.zzdqi
            java.lang.String r6 = r6.zzdrn
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r7 = r1.zzdqi
            java.lang.String r7 = r7.zzdrp
            r0.zza(r4, r5, r6, r7)
            com.google.android.gms.ads.internal.overlay.zzh r0 = r1.zzdqp
            com.google.android.gms.internal.ads.zzbdv r4 = r1.zzdii
            android.view.View r4 = r4.getView()
            r5 = -1
            r0.addView(r4, r5, r5)
            if (r23 != 0) goto L_0x0201
            boolean r0 = r1.zzdqq
            if (r0 != 0) goto L_0x0201
            r22.zzvj()
        L_0x0201:
            r1.zzaj(r3)
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii
            boolean r0 = r0.zzacu()
            if (r0 == 0) goto L_0x020f
            r1.zza((boolean) r3, (boolean) r2)
        L_0x020f:
            return
        L_0x0210:
            com.google.android.gms.ads.internal.overlay.zzi r0 = new com.google.android.gms.ads.internal.overlay.zzi
            java.lang.String r2 = "Invalid activity, no window available."
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zze.zzak(boolean):void");
    }

    private static void zzc(IObjectWrapper iObjectWrapper, View view) {
        if (iObjectWrapper != null && view != null) {
            zzp.zzlf().zza(iObjectWrapper, view);
        }
    }

    private final void zzvg() {
        if (this.zzaap.isFinishing() && !this.zzdqw) {
            this.zzdqw = true;
            if (this.zzdii != null) {
                this.zzdii.zzdv(this.zzdqr.zzvn());
                synchronized (this.zzdqs) {
                    if (!this.zzdqu && this.zzdii.zzada()) {
                        this.zzdqt = new zzg(this);
                        zzm.zzedd.postDelayed(this.zzdqt, ((Long) zzwq.zzqe().zzd(zzabf.zzcot)).longValue());
                        return;
                    }
                }
            }
            zzvh();
        }
    }

    private final void zzvj() {
        this.zzdii.zzvj();
    }

    public final void close() {
        this.zzdqr = zzl.CUSTOM_CLOSE;
        this.zzaap.finish();
    }

    public final void onActivityResult(int i, int i2, Intent intent) {
    }

    public final void onBackPressed() {
        this.zzdqr = zzl.BACK_BUTTON;
    }

    public void onCreate(Bundle bundle) {
        this.zzaap.requestWindowFeature(1);
        this.zzdqo = bundle != null && bundle.getBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", false);
        try {
            this.zzdqi = AdOverlayInfoParcel.zzd(this.zzaap.getIntent());
            if (this.zzdqi != null) {
                if (this.zzdqi.zzbpd.zzegm > 7500000) {
                    this.zzdqr = zzl.OTHER;
                }
                if (this.zzaap.getIntent() != null) {
                    this.zzdqy = this.zzaap.getIntent().getBooleanExtra("shouldCallOnOverlayOpened", true);
                }
                if (this.zzdqi.zzdrt != null) {
                    this.zzbou = this.zzdqi.zzdrt.zzbou;
                } else {
                    this.zzbou = false;
                }
                if (this.zzbou && this.zzdqi.zzdrt.zzboz != -1) {
                    new zzj(this).zzxl();
                }
                if (bundle == null) {
                    if (this.zzdqi.zzdrm != null && this.zzdqy) {
                        this.zzdqi.zzdrm.zzux();
                    }
                    if (!(this.zzdqi.zzdrr == 1 || this.zzdqi.zzcgp == null)) {
                        this.zzdqi.zzcgp.onAdClicked();
                    }
                }
                this.zzdqp = new zzh(this.zzaap, this.zzdqi.zzdrs, this.zzdqi.zzbpd.zzbrf);
                this.zzdqp.setId(ParseQuery.MAX_LIMIT);
                zzp.zzks().zzi(this.zzaap);
                switch (this.zzdqi.zzdrr) {
                    case 1:
                        zzak(false);
                        return;
                    case 2:
                        this.zzdqj = new zzk(this.zzdqi.zzdii);
                        zzak(false);
                        return;
                    case 3:
                        zzak(true);
                        return;
                    default:
                        throw new zzi("Could not determine ad overlay type.");
                }
            } else {
                throw new zzi("Could not get info for ad overlay.");
            }
        } catch (zzi e) {
            zzd.zzfa(e.getMessage());
            this.zzdqr = zzl.OTHER;
            this.zzaap.finish();
        }
    }

    public final void onDestroy() {
        zzbdv zzbdv = this.zzdii;
        if (zzbdv != null) {
            try {
                this.zzdqp.removeView(zzbdv.getView());
            } catch (NullPointerException unused) {
            }
        }
        zzvg();
    }

    public final void onPause() {
        zzvc();
        if (this.zzdqi.zzdrm != null) {
            this.zzdqi.zzdrm.onPause();
        }
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzctz)).booleanValue() && this.zzdii != null && (!this.zzaap.isFinishing() || this.zzdqj == null)) {
            zzp.zzks();
            zzu.zza(this.zzdii);
        }
        zzvg();
    }

    public final void onRestart() {
    }

    public final void onResume() {
        if (this.zzdqi.zzdrm != null) {
            this.zzdqi.zzdrm.onResume();
        }
        zza(this.zzaap.getResources().getConfiguration());
        if (!((Boolean) zzwq.zzqe().zzd(zzabf.zzctz)).booleanValue()) {
            zzbdv zzbdv = this.zzdii;
            if (zzbdv == null || zzbdv.isDestroyed()) {
                zzd.zzfa("The webview does not exist. Ignoring action.");
                return;
            }
            zzp.zzks();
            zzu.zzb(this.zzdii);
        }
    }

    public final void onSaveInstanceState(Bundle bundle) {
        bundle.putBoolean("com.google.android.gms.ads.internal.overlay.hasResumed", this.zzdqo);
    }

    public final void onStart() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctz)).booleanValue()) {
            zzbdv zzbdv = this.zzdii;
            if (zzbdv == null || zzbdv.isDestroyed()) {
                zzd.zzfa("The webview does not exist. Ignoring action.");
                return;
            }
            zzp.zzks();
            zzu.zzb(this.zzdii);
        }
    }

    public final void onStop() {
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzctz)).booleanValue() && this.zzdii != null && (!this.zzaap.isFinishing() || this.zzdqj == null)) {
            zzp.zzks();
            zzu.zza(this.zzdii);
        }
        zzvg();
    }

    public final void onUserLeaveHint() {
        if (this.zzdqi.zzdrm != null) {
            this.zzdqi.zzdrm.onUserLeaveHint();
        }
    }

    public final void setRequestedOrientation(int i) {
        if (this.zzaap.getApplicationInfo().targetSdkVersion >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcwi)).intValue()) {
            if (this.zzaap.getApplicationInfo().targetSdkVersion <= ((Integer) zzwq.zzqe().zzd(zzabf.zzcwj)).intValue()) {
                if (Build.VERSION.SDK_INT >= ((Integer) zzwq.zzqe().zzd(zzabf.zzcwk)).intValue()) {
                    if (Build.VERSION.SDK_INT <= ((Integer) zzwq.zzqe().zzd(zzabf.zzcwl)).intValue()) {
                        return;
                    }
                }
            }
        }
        try {
            this.zzaap.setRequestedOrientation(i);
        } catch (Throwable th) {
            zzp.zzku().zzb(th, "AdOverlay.setRequestedOrientation");
        }
    }

    public final void zza(View view, WebChromeClient.CustomViewCallback customViewCallback) {
        this.zzdqm = new FrameLayout(this.zzaap);
        this.zzdqm.setBackgroundColor(-16777216);
        this.zzdqm.addView(view, -1, -1);
        this.zzaap.setContentView(this.zzdqm);
        this.zzdqv = true;
        this.zzdqn = customViewCallback;
        this.zzdql = true;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0014, code lost:
        r0 = r6.zzdqi;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zza(boolean r7, boolean r8) {
        /*
            r6 = this;
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcou
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r1.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            r1 = 1
            r2 = 0
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzdqi
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.zzi r0 = r0.zzdrt
            if (r0 == 0) goto L_0x0026
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r0 = r6.zzdqi
            com.google.android.gms.ads.internal.zzi r0 = r0.zzdrt
            boolean r0 = r0.zzbpb
            if (r0 == 0) goto L_0x0026
            r0 = 1
            goto L_0x0027
        L_0x0026:
            r0 = 0
        L_0x0027:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r3 = com.google.android.gms.internal.ads.zzabf.zzcov
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r3 = r4.zzd(r3)
            java.lang.Boolean r3 = (java.lang.Boolean) r3
            boolean r3 = r3.booleanValue()
            if (r3 == 0) goto L_0x004b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzdqi
            if (r3 == 0) goto L_0x004b
            com.google.android.gms.ads.internal.zzi r3 = r3.zzdrt
            if (r3 == 0) goto L_0x004b
            com.google.android.gms.ads.internal.overlay.AdOverlayInfoParcel r3 = r6.zzdqi
            com.google.android.gms.ads.internal.zzi r3 = r3.zzdrt
            boolean r3 = r3.zzbpc
            if (r3 == 0) goto L_0x004b
            r3 = 1
            goto L_0x004c
        L_0x004b:
            r3 = 0
        L_0x004c:
            if (r7 == 0) goto L_0x0062
            if (r8 == 0) goto L_0x0062
            if (r0 == 0) goto L_0x0062
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.internal.ads.zzaqu r7 = new com.google.android.gms.internal.ads.zzaqu
            com.google.android.gms.internal.ads.zzbdv r4 = r6.zzdii
            java.lang.String r5 = "useCustomClose"
            r7.<init>(r4, r5)
            java.lang.String r4 = "Custom close has been disabled for interstitial ads in this ad slot."
            r7.zzdt(r4)
        L_0x0062:
            com.google.android.gms.ads.internal.overlay.zzr r7 = r6.zzdqk
            if (r7 == 0) goto L_0x0071
            if (r3 != 0) goto L_0x006e
            if (r8 == 0) goto L_0x006d
            if (r0 != 0) goto L_0x006d
            goto L_0x006e
        L_0x006d:
            r1 = 0
        L_0x006e:
            r7.zzal(r1)
        L_0x0071:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.ads.internal.overlay.zze.zza(boolean, boolean):void");
    }

    public final void zzad(IObjectWrapper iObjectWrapper) {
        zza((Configuration) ObjectWrapper.unwrap(iObjectWrapper));
    }

    public final void zzdp() {
        this.zzdqv = true;
    }

    public final void zzvc() {
        AdOverlayInfoParcel adOverlayInfoParcel = this.zzdqi;
        if (adOverlayInfoParcel != null && this.zzdql) {
            setRequestedOrientation(adOverlayInfoParcel.orientation);
        }
        if (this.zzdqm != null) {
            this.zzaap.setContentView(this.zzdqp);
            this.zzdqv = true;
            this.zzdqm.removeAllViews();
            this.zzdqm = null;
        }
        WebChromeClient.CustomViewCallback customViewCallback = this.zzdqn;
        if (customViewCallback != null) {
            customViewCallback.onCustomViewHidden();
            this.zzdqn = null;
        }
        this.zzdql = false;
    }

    public final void zzvd() {
        this.zzdqr = zzl.CLOSE_BUTTON;
        this.zzaap.finish();
    }

    public final boolean zzve() {
        this.zzdqr = zzl.BACK_BUTTON;
        zzbdv zzbdv = this.zzdii;
        if (zzbdv == null) {
            return true;
        }
        boolean zzacz = zzbdv.zzacz();
        if (!zzacz) {
            this.zzdii.zza("onbackblocked", Collections.emptyMap());
        }
        return zzacz;
    }

    public final void zzvf() {
        this.zzdqp.removeView(this.zzdqk);
        zzaj(true);
    }

    /* access modifiers changed from: package-private */
    @VisibleForTesting
    public final void zzvh() {
        if (!this.zzdqx) {
            this.zzdqx = true;
            zzbdv zzbdv = this.zzdii;
            if (zzbdv != null) {
                this.zzdqp.removeView(zzbdv.getView());
                zzk zzk = this.zzdqj;
                if (zzk != null) {
                    this.zzdii.zzbx(zzk.context);
                    this.zzdii.zzaz(false);
                    this.zzdqj.parent.addView(this.zzdii.getView(), this.zzdqj.index, this.zzdqj.zzdrc);
                    this.zzdqj = null;
                } else if (this.zzaap.getApplicationContext() != null) {
                    this.zzdii.zzbx(this.zzaap.getApplicationContext());
                }
                this.zzdii = null;
            }
            AdOverlayInfoParcel adOverlayInfoParcel = this.zzdqi;
            if (!(adOverlayInfoParcel == null || adOverlayInfoParcel.zzdrm == null)) {
                this.zzdqi.zzdrm.zza(this.zzdqr);
            }
            AdOverlayInfoParcel adOverlayInfoParcel2 = this.zzdqi;
            if (adOverlayInfoParcel2 != null && adOverlayInfoParcel2.zzdii != null) {
                zzc(this.zzdqi.zzdii.zzacw(), this.zzdqi.zzdii.getView());
            }
        }
    }

    public final void zzvi() {
        if (this.zzdqq) {
            this.zzdqq = false;
            zzvj();
        }
    }

    public final void zzvk() {
        this.zzdqp.zzdra = true;
    }

    public final void zzvl() {
        synchronized (this.zzdqs) {
            this.zzdqu = true;
            if (this.zzdqt != null) {
                zzm.zzedd.removeCallbacks(this.zzdqt);
                zzm.zzedd.post(this.zzdqt);
            }
        }
    }
}
