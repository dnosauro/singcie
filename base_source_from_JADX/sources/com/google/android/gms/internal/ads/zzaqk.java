package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import com.google.android.gms.common.util.CollectionUtils;
import java.util.Set;

public final class zzaqk extends zzaqu {
    private static final Set<String> zzdol = CollectionUtils.setOf("top-left", "top-right", "top-center", "center", "bottom-left", "bottom-right", "bottom-center");
    private int height = -1;
    private final Object lock = new Object();
    private int width = -1;
    private zzaqx zzdgq;
    private final zzbdv zzdii;
    private final Activity zzdob;
    private String zzdom = "top-right";
    private boolean zzdon = true;
    private int zzdoo = 0;
    private int zzdop = 0;
    private int zzdoq = 0;
    private int zzdor = 0;
    private zzbfn zzdos;
    private ImageView zzdot;
    private LinearLayout zzdou;
    private PopupWindow zzdov;
    private RelativeLayout zzdow;
    private ViewGroup zzdox;

    public zzaqk(zzbdv zzbdv, zzaqx zzaqx) {
        super(zzbdv, "resize");
        this.zzdii = zzbdv;
        this.zzdob = zzbdv.zzaaj();
        this.zzdgq = zzaqx;
    }

    public final void zza(int i, int i2, boolean z) {
        synchronized (this.lock) {
            this.zzdoo = i;
            this.zzdop = i2;
            PopupWindow popupWindow = this.zzdov;
        }
    }

    public final void zzac(boolean z) {
        synchronized (this.lock) {
            if (this.zzdov != null) {
                this.zzdov.dismiss();
                this.zzdow.removeView(this.zzdii.getView());
                if (this.zzdox != null) {
                    this.zzdox.removeView(this.zzdot);
                    this.zzdox.addView(this.zzdii.getView());
                    this.zzdii.zza(this.zzdos);
                }
                if (z) {
                    zzdv("default");
                    if (this.zzdgq != null) {
                        this.zzdgq.zzva();
                    }
                }
                this.zzdov = null;
                this.zzdow = null;
                this.zzdox = null;
                this.zzdou = null;
            }
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* JADX WARNING: Code restructure failed: missing block: B:100:0x01bf, code lost:
        r5 = r1.zzdoo + r1.zzdoq;
        r8 = r1.zzdop;
        r15 = r1.zzdor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:101:0x01c9, code lost:
        r8 = ((r8 + r15) + r1.height) - 50;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:102:0x01cc, code lost:
        r5 = ((r1.zzdoo + r1.zzdoq) + (r1.width / 2)) - 25;
        r8 = ((r1.zzdop + r1.zzdor) + (r1.height / 2)) - 25;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:103:0x01e3, code lost:
        r5 = ((r1.zzdoo + r1.zzdoq) + (r1.width / 2)) - 25;
        r8 = r1.zzdop;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:104:0x01f1, code lost:
        r5 = r1.zzdoo + r1.zzdoq;
        r8 = r1.zzdop;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:105:0x01f8, code lost:
        r8 = r8 + r1.zzdor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:106:0x01fc, code lost:
        r5 = ((r1.zzdoo + r1.zzdoq) + r1.width) - 50;
        r8 = r1.zzdop;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:107:0x0206, code lost:
        if (r5 < 0) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:109:0x0209, code lost:
        if ((r5 + 50) > r7) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:111:0x020d, code lost:
        if (r8 < r6[0]) goto L_0x021f;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:113:0x0212, code lost:
        if ((r8 + 50) <= r6[1]) goto L_0x0215;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:181:0x03b1, code lost:
        r8.addRule(11);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:183:0x03b8, code lost:
        r8.addRule(14);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:185:0x03bf, code lost:
        r8.addRule(9);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:189:0x03d1, code lost:
        r1.zzdou.setOnClickListener(new com.google.android.gms.internal.ads.zzaqn(r1));
        r1.zzdou.setContentDescription("Close button");
        r1.zzdow.addView(r1.zzdou, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:191:?, code lost:
        r8 = r1.zzdov;
        r0 = r0.getDecorView();
        com.google.android.gms.internal.ads.zzwq.zzqa();
        r9 = com.google.android.gms.internal.ads.zzayr.zzc(r1.zzdob, r5[0]);
        com.google.android.gms.internal.ads.zzwq.zzqa();
        r8.showAtLocation(r0, 0, r9, com.google.android.gms.internal.ads.zzayr.zzc(r1.zzdob, r5[1]));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:193:?, code lost:
        r0 = r5[0];
        r8 = r5[1];
     */
    /* JADX WARNING: Code restructure failed: missing block: B:194:0x040e, code lost:
        if (r1.zzdgq == null) goto L_0x0419;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:195:0x0410, code lost:
        r1.zzdgq.zzc(r0, r8, r1.width, r1.height);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:196:0x0419, code lost:
        r1.zzdii.zza(com.google.android.gms.internal.ads.zzbfn.zzq(r6, r7));
        r0 = r5[0];
        r3 = r5[1];
        com.google.android.gms.ads.internal.zzp.zzkq();
        zza(r0, r3 - com.google.android.gms.ads.internal.util.zzm.zzh(r1.zzdob)[0], r1.width, r1.height);
        zzdv("resized");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:198:0x043f, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:199:0x0440, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:200:0x0441, code lost:
        r0 = java.lang.String.valueOf(r0.getMessage());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:201:0x044f, code lost:
        if (r0.length() != 0) goto L_0x0451;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:202:0x0451, code lost:
        r0 = "Cannot show popup window: ".concat(r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:203:0x0456, code lost:
        r0 = new java.lang.String("Cannot show popup window: ");
     */
    /* JADX WARNING: Code restructure failed: missing block: B:204:0x045b, code lost:
        zzdt(r0);
        r1.zzdow.removeView(r1.zzdii.getView());
     */
    /* JADX WARNING: Code restructure failed: missing block: B:205:0x046b, code lost:
        if (r1.zzdox != null) goto L_0x046d;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:206:0x046d, code lost:
        r1.zzdox.removeView(r1.zzdot);
        r1.zzdox.addView(r1.zzdii.getView());
        r1.zzdii.zza(r1.zzdos);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:208:0x0487, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:94:0x0197, code lost:
        r5 = 65535;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:95:0x0198, code lost:
        switch(r5) {
            case 0: goto L_0x01f1;
            case 1: goto L_0x01e3;
            case 2: goto L_0x01cc;
            case 3: goto L_0x01bf;
            case 4: goto L_0x01ac;
            case 5: goto L_0x019e;
            default: goto L_0x019b;
        };
     */
    /* JADX WARNING: Code restructure failed: missing block: B:97:0x019e, code lost:
        r5 = ((r1.zzdoo + r1.zzdoq) + r1.width) - 50;
        r8 = r1.zzdop;
        r15 = r1.zzdor;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:98:0x01ac, code lost:
        r5 = ((r1.zzdoo + r1.zzdoq) + (r1.width / 2)) - 25;
        r8 = r1.zzdop;
        r15 = r1.zzdor;
     */
    /* JADX WARNING: Removed duplicated region for block: B:121:0x0222 A[Catch:{ RuntimeException -> 0x0440 }] */
    /* JADX WARNING: Removed duplicated region for block: B:122:0x0224 A[Catch:{ RuntimeException -> 0x0440 }] */
    /* JADX WARNING: Removed duplicated region for block: B:140:0x0282 A[Catch:{ RuntimeException -> 0x0440 }] */
    /* JADX WARNING: Removed duplicated region for block: B:143:0x0289 A[Catch:{ RuntimeException -> 0x0440 }] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzg(java.util.Map<java.lang.String, java.lang.String> r17) {
        /*
            r16 = this;
            r1 = r16
            r0 = r17
            java.lang.Object r2 = r1.lock
            monitor-enter(r2)
            android.app.Activity r3 = r1.zzdob     // Catch:{ all -> 0x0496 }
            if (r3 != 0) goto L_0x0012
            java.lang.String r0 = "Not an activity context. Cannot resize."
            r1.zzdt(r0)     // Catch:{ all -> 0x0496 }
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            return
        L_0x0012:
            com.google.android.gms.internal.ads.zzbdv r3 = r1.zzdii     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbfn r3 = r3.zzacq()     // Catch:{ all -> 0x0496 }
            if (r3 != 0) goto L_0x0021
            java.lang.String r0 = "Webview is not yet available, size is not set."
            r1.zzdt(r0)     // Catch:{ all -> 0x0496 }
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            return
        L_0x0021:
            com.google.android.gms.internal.ads.zzbdv r3 = r1.zzdii     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbfn r3 = r3.zzacq()     // Catch:{ all -> 0x0496 }
            boolean r3 = r3.zzady()     // Catch:{ all -> 0x0496 }
            if (r3 == 0) goto L_0x0034
            java.lang.String r0 = "Is interstitial. Cannot resize an interstitial."
            r1.zzdt(r0)     // Catch:{ all -> 0x0496 }
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            return
        L_0x0034:
            com.google.android.gms.internal.ads.zzbdv r3 = r1.zzdii     // Catch:{ all -> 0x0496 }
            boolean r3 = r3.zzacx()     // Catch:{ all -> 0x0496 }
            if (r3 == 0) goto L_0x0043
            java.lang.String r0 = "Cannot resize an expanded banner."
            r1.zzdt(r0)     // Catch:{ all -> 0x0496 }
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            return
        L_0x0043:
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0496 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0496 }
            if (r3 != 0) goto L_0x0062
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            java.lang.String r3 = "width"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0496 }
            int r3 = com.google.android.gms.ads.internal.util.zzm.zzej(r3)     // Catch:{ all -> 0x0496 }
            r1.width = r3     // Catch:{ all -> 0x0496 }
        L_0x0062:
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0496 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0496 }
            if (r3 != 0) goto L_0x0081
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            java.lang.String r3 = "height"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0496 }
            int r3 = com.google.android.gms.ads.internal.util.zzm.zzej(r3)     // Catch:{ all -> 0x0496 }
            r1.height = r3     // Catch:{ all -> 0x0496 }
        L_0x0081:
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0496 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0496 }
            if (r3 != 0) goto L_0x00a0
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            java.lang.String r3 = "offsetX"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0496 }
            int r3 = com.google.android.gms.ads.internal.util.zzm.zzej(r3)     // Catch:{ all -> 0x0496 }
            r1.zzdoq = r3     // Catch:{ all -> 0x0496 }
        L_0x00a0:
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0496 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0496 }
            if (r3 != 0) goto L_0x00bf
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            java.lang.String r3 = "offsetY"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0496 }
            int r3 = com.google.android.gms.ads.internal.util.zzm.zzej(r3)     // Catch:{ all -> 0x0496 }
            r1.zzdor = r3     // Catch:{ all -> 0x0496 }
        L_0x00bf:
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.CharSequence r3 = (java.lang.CharSequence) r3     // Catch:{ all -> 0x0496 }
            boolean r3 = android.text.TextUtils.isEmpty(r3)     // Catch:{ all -> 0x0496 }
            if (r3 != 0) goto L_0x00db
            java.lang.String r3 = "allowOffscreen"
            java.lang.Object r3 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0496 }
            boolean r3 = java.lang.Boolean.parseBoolean(r3)     // Catch:{ all -> 0x0496 }
            r1.zzdon = r3     // Catch:{ all -> 0x0496 }
        L_0x00db:
            java.lang.String r3 = "customClosePosition"
            java.lang.Object r0 = r0.get(r3)     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0496 }
            boolean r3 = android.text.TextUtils.isEmpty(r0)     // Catch:{ all -> 0x0496 }
            if (r3 != 0) goto L_0x00eb
            r1.zzdom = r0     // Catch:{ all -> 0x0496 }
        L_0x00eb:
            int r0 = r1.width     // Catch:{ all -> 0x0496 }
            r3 = 1
            r4 = 0
            if (r0 < 0) goto L_0x00f7
            int r0 = r1.height     // Catch:{ all -> 0x0496 }
            if (r0 < 0) goto L_0x00f7
            r0 = 1
            goto L_0x00f8
        L_0x00f7:
            r0 = 0
        L_0x00f8:
            if (r0 != 0) goto L_0x0101
            java.lang.String r0 = "Invalid width and height options. Cannot resize."
            r1.zzdt(r0)     // Catch:{ all -> 0x0496 }
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            return
        L_0x0101:
            android.app.Activity r0 = r1.zzdob     // Catch:{ all -> 0x0496 }
            android.view.Window r0 = r0.getWindow()     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x048f
            android.view.View r5 = r0.getDecorView()     // Catch:{ all -> 0x0496 }
            if (r5 != 0) goto L_0x0111
            goto L_0x048f
        L_0x0111:
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            android.app.Activity r5 = r1.zzdob     // Catch:{ all -> 0x0496 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzm.zzg(r5)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            android.app.Activity r6 = r1.zzdob     // Catch:{ all -> 0x0496 }
            int[] r6 = com.google.android.gms.ads.internal.util.zzm.zzh(r6)     // Catch:{ all -> 0x0496 }
            r7 = r5[r4]     // Catch:{ all -> 0x0496 }
            r5 = r5[r3]     // Catch:{ all -> 0x0496 }
            int r8 = r1.width     // Catch:{ all -> 0x0496 }
            r10 = 5
            r11 = 3
            r12 = -1
            r13 = 2
            r14 = 50
            if (r8 < r14) goto L_0x021a
            int r8 = r1.width     // Catch:{ all -> 0x0496 }
            if (r8 <= r7) goto L_0x0137
            goto L_0x021a
        L_0x0137:
            int r8 = r1.height     // Catch:{ all -> 0x0496 }
            if (r8 < r14) goto L_0x0217
            int r8 = r1.height     // Catch:{ all -> 0x0496 }
            if (r8 <= r5) goto L_0x0141
            goto L_0x0217
        L_0x0141:
            int r8 = r1.height     // Catch:{ all -> 0x0496 }
            if (r8 != r5) goto L_0x014d
            int r5 = r1.width     // Catch:{ all -> 0x0496 }
            if (r5 != r7) goto L_0x014d
            java.lang.String r5 = "Cannot resize to a full-screen ad."
            goto L_0x021c
        L_0x014d:
            boolean r5 = r1.zzdon     // Catch:{ all -> 0x0496 }
            if (r5 == 0) goto L_0x0215
            java.lang.String r5 = r1.zzdom     // Catch:{ all -> 0x0496 }
            int r8 = r5.hashCode()     // Catch:{ all -> 0x0496 }
            switch(r8) {
                case -1364013995: goto L_0x018d;
                case -1012429441: goto L_0x0183;
                case -655373719: goto L_0x0179;
                case 1163912186: goto L_0x016f;
                case 1288627767: goto L_0x0165;
                case 1755462605: goto L_0x015b;
                default: goto L_0x015a;
            }     // Catch:{ all -> 0x0496 }
        L_0x015a:
            goto L_0x0197
        L_0x015b:
            java.lang.String r8 = "top-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0496 }
            if (r5 == 0) goto L_0x0197
            r5 = 1
            goto L_0x0198
        L_0x0165:
            java.lang.String r8 = "bottom-center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0496 }
            if (r5 == 0) goto L_0x0197
            r5 = 4
            goto L_0x0198
        L_0x016f:
            java.lang.String r8 = "bottom-right"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0496 }
            if (r5 == 0) goto L_0x0197
            r5 = 5
            goto L_0x0198
        L_0x0179:
            java.lang.String r8 = "bottom-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0496 }
            if (r5 == 0) goto L_0x0197
            r5 = 3
            goto L_0x0198
        L_0x0183:
            java.lang.String r8 = "top-left"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0496 }
            if (r5 == 0) goto L_0x0197
            r5 = 0
            goto L_0x0198
        L_0x018d:
            java.lang.String r8 = "center"
            boolean r5 = r5.equals(r8)     // Catch:{ all -> 0x0496 }
            if (r5 == 0) goto L_0x0197
            r5 = 2
            goto L_0x0198
        L_0x0197:
            r5 = -1
        L_0x0198:
            switch(r5) {
                case 0: goto L_0x01f1;
                case 1: goto L_0x01e3;
                case 2: goto L_0x01cc;
                case 3: goto L_0x01bf;
                case 4: goto L_0x01ac;
                case 5: goto L_0x019e;
                default: goto L_0x019b;
            }     // Catch:{ all -> 0x0496 }
        L_0x019b:
            int r5 = r1.zzdoo     // Catch:{ all -> 0x0496 }
            goto L_0x01fc
        L_0x019e:
            int r5 = r1.zzdoo     // Catch:{ all -> 0x0496 }
            int r8 = r1.zzdoq     // Catch:{ all -> 0x0496 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x0496 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdop     // Catch:{ all -> 0x0496 }
            int r15 = r1.zzdor     // Catch:{ all -> 0x0496 }
            goto L_0x01bb
        L_0x01ac:
            int r5 = r1.zzdoo     // Catch:{ all -> 0x0496 }
            int r8 = r1.zzdoq     // Catch:{ all -> 0x0496 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x0496 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdop     // Catch:{ all -> 0x0496 }
            int r15 = r1.zzdor     // Catch:{ all -> 0x0496 }
        L_0x01bb:
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x0496 }
            goto L_0x01c9
        L_0x01bf:
            int r5 = r1.zzdoo     // Catch:{ all -> 0x0496 }
            int r8 = r1.zzdoq     // Catch:{ all -> 0x0496 }
            int r5 = r5 + r8
            int r8 = r1.zzdop     // Catch:{ all -> 0x0496 }
            int r15 = r1.zzdor     // Catch:{ all -> 0x0496 }
            goto L_0x01bb
        L_0x01c9:
            int r8 = r8 + r15
            int r8 = r8 - r14
            goto L_0x0206
        L_0x01cc:
            int r5 = r1.zzdoo     // Catch:{ all -> 0x0496 }
            int r8 = r1.zzdoq     // Catch:{ all -> 0x0496 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x0496 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdop     // Catch:{ all -> 0x0496 }
            int r15 = r1.zzdor     // Catch:{ all -> 0x0496 }
            int r8 = r8 + r15
            int r15 = r1.height     // Catch:{ all -> 0x0496 }
            int r15 = r15 / r13
            int r8 = r8 + r15
            int r8 = r8 + -25
            goto L_0x0206
        L_0x01e3:
            int r5 = r1.zzdoo     // Catch:{ all -> 0x0496 }
            int r8 = r1.zzdoq     // Catch:{ all -> 0x0496 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x0496 }
            int r8 = r8 / r13
            int r5 = r5 + r8
            int r5 = r5 + -25
            int r8 = r1.zzdop     // Catch:{ all -> 0x0496 }
            goto L_0x01f8
        L_0x01f1:
            int r5 = r1.zzdoo     // Catch:{ all -> 0x0496 }
            int r8 = r1.zzdoq     // Catch:{ all -> 0x0496 }
            int r5 = r5 + r8
            int r8 = r1.zzdop     // Catch:{ all -> 0x0496 }
        L_0x01f8:
            int r15 = r1.zzdor     // Catch:{ all -> 0x0496 }
            int r8 = r8 + r15
            goto L_0x0206
        L_0x01fc:
            int r8 = r1.zzdoq     // Catch:{ all -> 0x0496 }
            int r5 = r5 + r8
            int r8 = r1.width     // Catch:{ all -> 0x0496 }
            int r5 = r5 + r8
            int r5 = r5 - r14
            int r8 = r1.zzdop     // Catch:{ all -> 0x0496 }
            goto L_0x01f8
        L_0x0206:
            if (r5 < 0) goto L_0x021f
            int r5 = r5 + r14
            if (r5 > r7) goto L_0x021f
            r5 = r6[r4]     // Catch:{ all -> 0x0496 }
            if (r8 < r5) goto L_0x021f
            int r8 = r8 + r14
            r5 = r6[r3]     // Catch:{ all -> 0x0496 }
            if (r8 <= r5) goto L_0x0215
            goto L_0x021f
        L_0x0215:
            r5 = 1
            goto L_0x0220
        L_0x0217:
            java.lang.String r5 = "Height is too small or too large."
            goto L_0x021c
        L_0x021a:
            java.lang.String r5 = "Width is too small or too large."
        L_0x021c:
            com.google.android.gms.ads.internal.util.zzd.zzfa(r5)     // Catch:{ all -> 0x0496 }
        L_0x021f:
            r5 = 0
        L_0x0220:
            if (r5 != 0) goto L_0x0224
            r5 = 0
            goto L_0x0280
        L_0x0224:
            boolean r5 = r1.zzdon     // Catch:{ all -> 0x0496 }
            if (r5 == 0) goto L_0x0239
            int[] r5 = new int[r13]     // Catch:{ all -> 0x0496 }
            int r6 = r1.zzdoo     // Catch:{ all -> 0x0496 }
            int r7 = r1.zzdoq     // Catch:{ all -> 0x0496 }
            int r6 = r6 + r7
            r5[r4] = r6     // Catch:{ all -> 0x0496 }
            int r6 = r1.zzdop     // Catch:{ all -> 0x0496 }
            int r7 = r1.zzdor     // Catch:{ all -> 0x0496 }
            int r6 = r6 + r7
            r5[r3] = r6     // Catch:{ all -> 0x0496 }
            goto L_0x0280
        L_0x0239:
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            android.app.Activity r5 = r1.zzdob     // Catch:{ all -> 0x0496 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzm.zzg(r5)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            android.app.Activity r6 = r1.zzdob     // Catch:{ all -> 0x0496 }
            int[] r6 = com.google.android.gms.ads.internal.util.zzm.zzh(r6)     // Catch:{ all -> 0x0496 }
            r5 = r5[r4]     // Catch:{ all -> 0x0496 }
            int r7 = r1.zzdoo     // Catch:{ all -> 0x0496 }
            int r8 = r1.zzdoq     // Catch:{ all -> 0x0496 }
            int r7 = r7 + r8
            int r8 = r1.zzdop     // Catch:{ all -> 0x0496 }
            int r15 = r1.zzdor     // Catch:{ all -> 0x0496 }
            int r8 = r8 + r15
            if (r7 >= 0) goto L_0x025b
            r5 = 0
            goto L_0x0265
        L_0x025b:
            int r15 = r1.width     // Catch:{ all -> 0x0496 }
            int r15 = r15 + r7
            if (r15 <= r5) goto L_0x0264
            int r7 = r1.width     // Catch:{ all -> 0x0496 }
            int r5 = r5 - r7
            goto L_0x0265
        L_0x0264:
            r5 = r7
        L_0x0265:
            r7 = r6[r4]     // Catch:{ all -> 0x0496 }
            if (r8 >= r7) goto L_0x026c
            r8 = r6[r4]     // Catch:{ all -> 0x0496 }
            goto L_0x0279
        L_0x026c:
            int r7 = r1.height     // Catch:{ all -> 0x0496 }
            int r7 = r7 + r8
            r15 = r6[r3]     // Catch:{ all -> 0x0496 }
            if (r7 <= r15) goto L_0x0279
            r6 = r6[r3]     // Catch:{ all -> 0x0496 }
            int r7 = r1.height     // Catch:{ all -> 0x0496 }
            int r8 = r6 - r7
        L_0x0279:
            int[] r6 = new int[r13]     // Catch:{ all -> 0x0496 }
            r6[r4] = r5     // Catch:{ all -> 0x0496 }
            r6[r3] = r8     // Catch:{ all -> 0x0496 }
            r5 = r6
        L_0x0280:
            if (r5 != 0) goto L_0x0289
            java.lang.String r0 = "Resize location out of screen or close button is not visible."
            r1.zzdt(r0)     // Catch:{ all -> 0x0496 }
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            return
        L_0x0289:
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ all -> 0x0496 }
            android.app.Activity r6 = r1.zzdob     // Catch:{ all -> 0x0496 }
            int r7 = r1.width     // Catch:{ all -> 0x0496 }
            int r6 = com.google.android.gms.internal.ads.zzayr.zzc(r6, r7)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ all -> 0x0496 }
            android.app.Activity r7 = r1.zzdob     // Catch:{ all -> 0x0496 }
            int r8 = r1.height     // Catch:{ all -> 0x0496 }
            int r7 = com.google.android.gms.internal.ads.zzayr.zzc(r7, r8)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbdv r8 = r1.zzdii     // Catch:{ all -> 0x0496 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x0496 }
            android.view.ViewParent r8 = r8.getParent()     // Catch:{ all -> 0x0496 }
            if (r8 == 0) goto L_0x0488
            boolean r15 = r8 instanceof android.view.ViewGroup     // Catch:{ all -> 0x0496 }
            if (r15 == 0) goto L_0x0488
            r15 = r8
            android.view.ViewGroup r15 = (android.view.ViewGroup) r15     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbdv r9 = r1.zzdii     // Catch:{ all -> 0x0496 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x0496 }
            r15.removeView(r9)     // Catch:{ all -> 0x0496 }
            android.widget.PopupWindow r9 = r1.zzdov     // Catch:{ all -> 0x0496 }
            if (r9 != 0) goto L_0x02ee
            android.view.ViewGroup r8 = (android.view.ViewGroup) r8     // Catch:{ all -> 0x0496 }
            r1.zzdox = r8     // Catch:{ all -> 0x0496 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbdv r8 = r1.zzdii     // Catch:{ all -> 0x0496 }
            android.view.View r8 = r8.getView()     // Catch:{ all -> 0x0496 }
            android.graphics.Bitmap r8 = com.google.android.gms.ads.internal.util.zzm.zzm(r8)     // Catch:{ all -> 0x0496 }
            android.widget.ImageView r9 = new android.widget.ImageView     // Catch:{ all -> 0x0496 }
            android.app.Activity r15 = r1.zzdob     // Catch:{ all -> 0x0496 }
            r9.<init>(r15)     // Catch:{ all -> 0x0496 }
            r1.zzdot = r9     // Catch:{ all -> 0x0496 }
            android.widget.ImageView r9 = r1.zzdot     // Catch:{ all -> 0x0496 }
            r9.setImageBitmap(r8)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbdv r8 = r1.zzdii     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbfn r8 = r8.zzacq()     // Catch:{ all -> 0x0496 }
            r1.zzdos = r8     // Catch:{ all -> 0x0496 }
            android.view.ViewGroup r8 = r1.zzdox     // Catch:{ all -> 0x0496 }
            android.widget.ImageView r9 = r1.zzdot     // Catch:{ all -> 0x0496 }
            r8.addView(r9)     // Catch:{ all -> 0x0496 }
            goto L_0x02f3
        L_0x02ee:
            android.widget.PopupWindow r8 = r1.zzdov     // Catch:{ all -> 0x0496 }
            r8.dismiss()     // Catch:{ all -> 0x0496 }
        L_0x02f3:
            android.widget.RelativeLayout r8 = new android.widget.RelativeLayout     // Catch:{ all -> 0x0496 }
            android.app.Activity r9 = r1.zzdob     // Catch:{ all -> 0x0496 }
            r8.<init>(r9)     // Catch:{ all -> 0x0496 }
            r1.zzdow = r8     // Catch:{ all -> 0x0496 }
            android.widget.RelativeLayout r8 = r1.zzdow     // Catch:{ all -> 0x0496 }
            r8.setBackgroundColor(r4)     // Catch:{ all -> 0x0496 }
            android.widget.RelativeLayout r8 = r1.zzdow     // Catch:{ all -> 0x0496 }
            android.view.ViewGroup$LayoutParams r9 = new android.view.ViewGroup$LayoutParams     // Catch:{ all -> 0x0496 }
            r9.<init>(r6, r7)     // Catch:{ all -> 0x0496 }
            r8.setLayoutParams(r9)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            android.widget.RelativeLayout r8 = r1.zzdow     // Catch:{ all -> 0x0496 }
            android.widget.PopupWindow r8 = com.google.android.gms.ads.internal.util.zzm.zza((android.view.View) r8, (int) r6, (int) r7, (boolean) r4)     // Catch:{ all -> 0x0496 }
            r1.zzdov = r8     // Catch:{ all -> 0x0496 }
            android.widget.PopupWindow r8 = r1.zzdov     // Catch:{ all -> 0x0496 }
            r8.setOutsideTouchable(r3)     // Catch:{ all -> 0x0496 }
            android.widget.PopupWindow r8 = r1.zzdov     // Catch:{ all -> 0x0496 }
            r8.setTouchable(r3)     // Catch:{ all -> 0x0496 }
            android.widget.PopupWindow r8 = r1.zzdov     // Catch:{ all -> 0x0496 }
            boolean r9 = r1.zzdon     // Catch:{ all -> 0x0496 }
            if (r9 != 0) goto L_0x0328
            r9 = 1
            goto L_0x0329
        L_0x0328:
            r9 = 0
        L_0x0329:
            r8.setClippingEnabled(r9)     // Catch:{ all -> 0x0496 }
            android.widget.RelativeLayout r8 = r1.zzdow     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbdv r9 = r1.zzdii     // Catch:{ all -> 0x0496 }
            android.view.View r9 = r9.getView()     // Catch:{ all -> 0x0496 }
            r8.addView(r9, r12, r12)     // Catch:{ all -> 0x0496 }
            android.widget.LinearLayout r8 = new android.widget.LinearLayout     // Catch:{ all -> 0x0496 }
            android.app.Activity r9 = r1.zzdob     // Catch:{ all -> 0x0496 }
            r8.<init>(r9)     // Catch:{ all -> 0x0496 }
            r1.zzdou = r8     // Catch:{ all -> 0x0496 }
            android.widget.RelativeLayout$LayoutParams r8 = new android.widget.RelativeLayout$LayoutParams     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ all -> 0x0496 }
            android.app.Activity r9 = r1.zzdob     // Catch:{ all -> 0x0496 }
            int r9 = com.google.android.gms.internal.ads.zzayr.zzc(r9, r14)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ all -> 0x0496 }
            android.app.Activity r15 = r1.zzdob     // Catch:{ all -> 0x0496 }
            int r14 = com.google.android.gms.internal.ads.zzayr.zzc(r15, r14)     // Catch:{ all -> 0x0496 }
            r8.<init>(r9, r14)     // Catch:{ all -> 0x0496 }
            java.lang.String r9 = r1.zzdom     // Catch:{ all -> 0x0496 }
            int r14 = r9.hashCode()     // Catch:{ all -> 0x0496 }
            switch(r14) {
                case -1364013995: goto L_0x0392;
                case -1012429441: goto L_0x0388;
                case -655373719: goto L_0x037e;
                case 1163912186: goto L_0x0375;
                case 1288627767: goto L_0x036b;
                case 1755462605: goto L_0x0361;
                default: goto L_0x0360;
            }     // Catch:{ all -> 0x0496 }
        L_0x0360:
            goto L_0x039c
        L_0x0361:
            java.lang.String r10 = "top-center"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0496 }
            if (r9 == 0) goto L_0x039c
            r10 = 1
            goto L_0x039d
        L_0x036b:
            java.lang.String r10 = "bottom-center"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0496 }
            if (r9 == 0) goto L_0x039c
            r10 = 4
            goto L_0x039d
        L_0x0375:
            java.lang.String r11 = "bottom-right"
            boolean r9 = r9.equals(r11)     // Catch:{ all -> 0x0496 }
            if (r9 == 0) goto L_0x039c
            goto L_0x039d
        L_0x037e:
            java.lang.String r10 = "bottom-left"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0496 }
            if (r9 == 0) goto L_0x039c
            r10 = 3
            goto L_0x039d
        L_0x0388:
            java.lang.String r10 = "top-left"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0496 }
            if (r9 == 0) goto L_0x039c
            r10 = 0
            goto L_0x039d
        L_0x0392:
            java.lang.String r10 = "center"
            boolean r9 = r9.equals(r10)     // Catch:{ all -> 0x0496 }
            if (r9 == 0) goto L_0x039c
            r10 = 2
            goto L_0x039d
        L_0x039c:
            r10 = -1
        L_0x039d:
            r9 = 14
            r11 = 9
            r12 = 11
            r13 = 12
            r14 = 10
            switch(r10) {
                case 0: goto L_0x03cd;
                case 1: goto L_0x03c9;
                case 2: goto L_0x03c3;
                case 3: goto L_0x03bc;
                case 4: goto L_0x03b5;
                case 5: goto L_0x03ae;
                default: goto L_0x03aa;
            }     // Catch:{ all -> 0x0496 }
        L_0x03aa:
            r8.addRule(r14)     // Catch:{ all -> 0x0496 }
            goto L_0x03b1
        L_0x03ae:
            r8.addRule(r13)     // Catch:{ all -> 0x0496 }
        L_0x03b1:
            r8.addRule(r12)     // Catch:{ all -> 0x0496 }
            goto L_0x03d1
        L_0x03b5:
            r8.addRule(r13)     // Catch:{ all -> 0x0496 }
        L_0x03b8:
            r8.addRule(r9)     // Catch:{ all -> 0x0496 }
            goto L_0x03d1
        L_0x03bc:
            r8.addRule(r13)     // Catch:{ all -> 0x0496 }
        L_0x03bf:
            r8.addRule(r11)     // Catch:{ all -> 0x0496 }
            goto L_0x03d1
        L_0x03c3:
            r9 = 13
            r8.addRule(r9)     // Catch:{ all -> 0x0496 }
            goto L_0x03d1
        L_0x03c9:
            r8.addRule(r14)     // Catch:{ all -> 0x0496 }
            goto L_0x03b8
        L_0x03cd:
            r8.addRule(r14)     // Catch:{ all -> 0x0496 }
            goto L_0x03bf
        L_0x03d1:
            android.widget.LinearLayout r9 = r1.zzdou     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzaqn r10 = new com.google.android.gms.internal.ads.zzaqn     // Catch:{ all -> 0x0496 }
            r10.<init>(r1)     // Catch:{ all -> 0x0496 }
            r9.setOnClickListener(r10)     // Catch:{ all -> 0x0496 }
            android.widget.LinearLayout r9 = r1.zzdou     // Catch:{ all -> 0x0496 }
            java.lang.String r10 = "Close button"
            r9.setContentDescription(r10)     // Catch:{ all -> 0x0496 }
            android.widget.RelativeLayout r9 = r1.zzdow     // Catch:{ all -> 0x0496 }
            android.widget.LinearLayout r10 = r1.zzdou     // Catch:{ all -> 0x0496 }
            r9.addView(r10, r8)     // Catch:{ all -> 0x0496 }
            android.widget.PopupWindow r8 = r1.zzdov     // Catch:{ RuntimeException -> 0x0440 }
            android.view.View r0 = r0.getDecorView()     // Catch:{ RuntimeException -> 0x0440 }
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ RuntimeException -> 0x0440 }
            android.app.Activity r9 = r1.zzdob     // Catch:{ RuntimeException -> 0x0440 }
            r10 = r5[r4]     // Catch:{ RuntimeException -> 0x0440 }
            int r9 = com.google.android.gms.internal.ads.zzayr.zzc(r9, r10)     // Catch:{ RuntimeException -> 0x0440 }
            com.google.android.gms.internal.ads.zzwq.zzqa()     // Catch:{ RuntimeException -> 0x0440 }
            android.app.Activity r10 = r1.zzdob     // Catch:{ RuntimeException -> 0x0440 }
            r11 = r5[r3]     // Catch:{ RuntimeException -> 0x0440 }
            int r10 = com.google.android.gms.internal.ads.zzayr.zzc(r10, r11)     // Catch:{ RuntimeException -> 0x0440 }
            r8.showAtLocation(r0, r4, r9, r10)     // Catch:{ RuntimeException -> 0x0440 }
            r0 = r5[r4]     // Catch:{ all -> 0x0496 }
            r8 = r5[r3]     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzaqx r9 = r1.zzdgq     // Catch:{ all -> 0x0496 }
            if (r9 == 0) goto L_0x0419
            com.google.android.gms.internal.ads.zzaqx r9 = r1.zzdgq     // Catch:{ all -> 0x0496 }
            int r10 = r1.width     // Catch:{ all -> 0x0496 }
            int r11 = r1.height     // Catch:{ all -> 0x0496 }
            r9.zzc(r0, r8, r10, r11)     // Catch:{ all -> 0x0496 }
        L_0x0419:
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbfn r6 = com.google.android.gms.internal.ads.zzbfn.zzq(r6, r7)     // Catch:{ all -> 0x0496 }
            r0.zza((com.google.android.gms.internal.ads.zzbfn) r6)     // Catch:{ all -> 0x0496 }
            r0 = r5[r4]     // Catch:{ all -> 0x0496 }
            r3 = r5[r3]     // Catch:{ all -> 0x0496 }
            com.google.android.gms.ads.internal.zzp.zzkq()     // Catch:{ all -> 0x0496 }
            android.app.Activity r5 = r1.zzdob     // Catch:{ all -> 0x0496 }
            int[] r5 = com.google.android.gms.ads.internal.util.zzm.zzh(r5)     // Catch:{ all -> 0x0496 }
            r4 = r5[r4]     // Catch:{ all -> 0x0496 }
            int r3 = r3 - r4
            int r4 = r1.width     // Catch:{ all -> 0x0496 }
            int r5 = r1.height     // Catch:{ all -> 0x0496 }
            r1.zza(r0, r3, r4, r5)     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = "resized"
            r1.zzdv(r0)     // Catch:{ all -> 0x0496 }
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            return
        L_0x0440:
            r0 = move-exception
            java.lang.String r3 = "Cannot show popup window: "
            java.lang.String r0 = r0.getMessage()     // Catch:{ all -> 0x0496 }
            java.lang.String r0 = java.lang.String.valueOf(r0)     // Catch:{ all -> 0x0496 }
            int r4 = r0.length()     // Catch:{ all -> 0x0496 }
            if (r4 == 0) goto L_0x0456
            java.lang.String r0 = r3.concat(r0)     // Catch:{ all -> 0x0496 }
            goto L_0x045b
        L_0x0456:
            java.lang.String r0 = new java.lang.String     // Catch:{ all -> 0x0496 }
            r0.<init>(r3)     // Catch:{ all -> 0x0496 }
        L_0x045b:
            r1.zzdt(r0)     // Catch:{ all -> 0x0496 }
            android.widget.RelativeLayout r0 = r1.zzdow     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbdv r3 = r1.zzdii     // Catch:{ all -> 0x0496 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x0496 }
            r0.removeView(r3)     // Catch:{ all -> 0x0496 }
            android.view.ViewGroup r0 = r1.zzdox     // Catch:{ all -> 0x0496 }
            if (r0 == 0) goto L_0x0486
            android.view.ViewGroup r0 = r1.zzdox     // Catch:{ all -> 0x0496 }
            android.widget.ImageView r3 = r1.zzdot     // Catch:{ all -> 0x0496 }
            r0.removeView(r3)     // Catch:{ all -> 0x0496 }
            android.view.ViewGroup r0 = r1.zzdox     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbdv r3 = r1.zzdii     // Catch:{ all -> 0x0496 }
            android.view.View r3 = r3.getView()     // Catch:{ all -> 0x0496 }
            r0.addView(r3)     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbdv r0 = r1.zzdii     // Catch:{ all -> 0x0496 }
            com.google.android.gms.internal.ads.zzbfn r3 = r1.zzdos     // Catch:{ all -> 0x0496 }
            r0.zza((com.google.android.gms.internal.ads.zzbfn) r3)     // Catch:{ all -> 0x0496 }
        L_0x0486:
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            return
        L_0x0488:
            java.lang.String r0 = "Webview is detached, probably in the middle of a resize or expand."
            r1.zzdt(r0)     // Catch:{ all -> 0x0496 }
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            return
        L_0x048f:
            java.lang.String r0 = "Activity context is not ready, cannot get window or decor view."
            r1.zzdt(r0)     // Catch:{ all -> 0x0496 }
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            return
        L_0x0496:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x0496 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzaqk.zzg(java.util.Map):void");
    }

    public final void zzi(int i, int i2) {
        this.zzdoo = i;
        this.zzdop = i2;
    }

    public final boolean zzuy() {
        boolean z;
        synchronized (this.lock) {
            z = this.zzdov != null;
        }
        return z;
    }
}
