package com.google.android.gms.internal.ads;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.RemoteException;
import android.view.MotionEvent;
import android.view.View;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.dynamic.IObjectWrapper;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;
import org.json.JSONObject;

public final class zzcbt extends zzboc {
    private final Context context;
    private final zzazh zzbpd;
    private final zzef zzerb;
    private final Executor zzfqx;
    private final zzccl zzftd;
    private final zzawu zzfuo;
    private final zzcce zzgaq;
    private final zzccm zzgbt;
    private final zzcda zzgbu;
    private final zzcci zzgbv;
    private final zzeoz<zzcfz> zzgbw;
    private final zzeoz<zzcfx> zzgbx;
    private final zzeoz<zzcgg> zzgby;
    private final zzeoz<zzcft> zzgbz;
    private final zzeoz<zzcgb> zzgca;
    private zzcdy zzgcb;
    private boolean zzgcc;
    private boolean zzgcd = false;
    private final zzcbz zzgce;
    private final zzcyb zzgcf;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public zzcbt(zzbob zzbob, Executor executor, zzcce zzcce, zzccm zzccm, zzcda zzcda, zzcci zzcci, zzccl zzccl, zzeoz<zzcfz> zzeoz, zzeoz<zzcfx> zzeoz2, zzeoz<zzcgg> zzeoz3, zzeoz<zzcft> zzeoz4, zzeoz<zzcgb> zzeoz5, zzawu zzawu, zzef zzef, zzazh zzazh, Context context2, zzcbz zzcbz, zzcyb zzcyb) {
        super(zzbob);
        this.zzfqx = executor;
        this.zzgaq = zzcce;
        this.zzgbt = zzccm;
        this.zzgbu = zzcda;
        this.zzgbv = zzcci;
        this.zzftd = zzccl;
        this.zzgbw = zzeoz;
        this.zzgbx = zzeoz2;
        this.zzgby = zzeoz3;
        this.zzgbz = zzeoz4;
        this.zzgca = zzeoz5;
        this.zzfuo = zzawu;
        this.zzerb = zzef;
        this.zzbpd = zzazh;
        this.context = context2;
        this.zzgce = zzcbz;
        this.zzgcf = zzcyb;
    }

    public static boolean zzz(View view) {
        return view.isShown() && view.getGlobalVisibleRect(new Rect(), (Point) null);
    }

    public final synchronized void cancelUnconfirmedClick() {
        this.zzgbt.cancelUnconfirmedClick();
    }

    public final synchronized void destroy() {
        this.zzfqx.execute(new zzcby(this));
        super.destroy();
    }

    public final synchronized boolean isCustomClickGestureEnabled() {
        return this.zzgbt.isCustomClickGestureEnabled();
    }

    public final synchronized void recordCustomClickGesture() {
        if (this.zzgcb == null) {
            zzd.zzeb("Ad should be associated with an ad view before calling recordCustomClickGesture()");
        } else {
            this.zzfqx.execute(new zzcbx(this, this.zzgcb instanceof zzccv));
        }
    }

    public final synchronized void setClickConfirmingView(View view) {
        this.zzgbt.setClickConfirmingView(view);
    }

    public final synchronized JSONObject zza(View view, Map<String, WeakReference<View>> map, Map<String, WeakReference<View>> map2) {
        return this.zzgbt.zza(view, map, map2);
    }

    public final synchronized void zza(View view, MotionEvent motionEvent, View view2) {
        this.zzgbt.zza(view, motionEvent, view2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0044, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zza(android.view.View r9, android.view.View r10, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r11, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r12, boolean r13) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.android.gms.internal.ads.zzcda r0 = r8.zzgbu     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzcdy r1 = r8.zzgcb     // Catch:{ all -> 0x0045 }
            r0.zzc(r1)     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzccm r2 = r8.zzgbt     // Catch:{ all -> 0x0045 }
            r3 = r9
            r4 = r10
            r5 = r11
            r6 = r12
            r7 = r13
            r2.zza((android.view.View) r3, (android.view.View) r4, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r5, (java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>>) r6, (boolean) r7)     // Catch:{ all -> 0x0045 }
            boolean r9 = r8.zzgcd     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r9 = com.google.android.gms.internal.ads.zzabf.zzcsb     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzabb r10 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x0045 }
            java.lang.Object r9 = r10.zzd(r9)     // Catch:{ all -> 0x0045 }
            java.lang.Boolean r9 = (java.lang.Boolean) r9     // Catch:{ all -> 0x0045 }
            boolean r9 = r9.booleanValue()     // Catch:{ all -> 0x0045 }
            if (r9 == 0) goto L_0x0043
            com.google.android.gms.internal.ads.zzcce r9 = r8.zzgaq     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzbdv r9 = r9.zzanh()     // Catch:{ all -> 0x0045 }
            if (r9 != 0) goto L_0x0031
            goto L_0x0043
        L_0x0031:
            com.google.android.gms.internal.ads.zzcce r9 = r8.zzgaq     // Catch:{ all -> 0x0045 }
            com.google.android.gms.internal.ads.zzbdv r9 = r9.zzanh()     // Catch:{ all -> 0x0045 }
            java.lang.String r10 = "onSdkAdUserInteractionClick"
            androidx.c.a r11 = new androidx.c.a     // Catch:{ all -> 0x0045 }
            r11.<init>()     // Catch:{ all -> 0x0045 }
            r9.zza(r10, r11)     // Catch:{ all -> 0x0045 }
            monitor-exit(r8)
            return
        L_0x0043:
            monitor-exit(r8)
            return
        L_0x0045:
            r9 = move-exception
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbt.zza(android.view.View, android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zza(zzage zzage) {
        this.zzgbt.zza(zzage);
    }

    public final synchronized void zza(zzcdy zzcdy) {
        zzdv zzca;
        this.zzgcb = zzcdy;
        this.zzgbu.zza(zzcdy);
        this.zzgbt.zza(zzcdy.zzaiz(), zzcdy.zzaof(), zzcdy.zzaog(), (View.OnTouchListener) zzcdy, (View.OnClickListener) zzcdy);
        if (((Boolean) zzwq.zzqe().zzd(zzabf.zzcra)).booleanValue() && (zzca = this.zzerb.zzca()) != null) {
            zzca.zzb(zzcdy.zzaiz());
        }
        if (zzcdy.zzaod() != null) {
            zzcdy.zzaod().zza((zzqu) this.zzfuo);
        }
    }

    public final synchronized void zza(zzxz zzxz) {
        this.zzgbt.zza(zzxz);
    }

    public final synchronized void zza(zzyd zzyd) {
        this.zzgbt.zza(zzyd);
    }

    public final synchronized void zza(zzym zzym) {
        this.zzgcf.zzc(zzym);
    }

    public final void zzaa(View view) {
        IObjectWrapper zzanj = this.zzgaq.zzanj();
        boolean z = this.zzgaq.zzani() != null;
        if (this.zzgbv.zzamy() && zzanj != null && z && view != null) {
            zzp.zzlf().zza(zzanj, view);
        }
    }

    public final void zzab(View view) {
        IObjectWrapper zzanj = this.zzgaq.zzanj();
        if (this.zzgbv.zzamy() && zzanj != null && view != null) {
            zzp.zzlf().zzb(zzanj, view);
        }
    }

    public final void zzajj() {
        this.zzfqx.execute(new zzcbw(this));
        if (this.zzgaq.zzanc() != 7) {
            Executor executor = this.zzfqx;
            zzccm zzccm = this.zzgbt;
            zzccm.getClass();
            executor.execute(zzcbv.zza(zzccm));
        }
        super.zzajj();
    }

    public final synchronized void zzamr() {
        if (!this.zzgcc) {
            this.zzgbt.zzamr();
        }
    }

    public final boolean zzamx() {
        return this.zzgbv.zzanp();
    }

    public final boolean zzamy() {
        return this.zzgbv.zzamy();
    }

    public final zzcbz zzamz() {
        return this.zzgce;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzana() {
        this.zzgbt.destroy();
        this.zzgaq.destroy();
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzanb() {
        try {
            switch (this.zzgaq.zzanc()) {
                case 1:
                    if (this.zzftd.zzanr() != null) {
                        zzi("Google", true);
                        this.zzftd.zzanr().zza(this.zzgbw.get());
                        return;
                    }
                    return;
                case 2:
                    if (this.zzftd.zzans() != null) {
                        zzi("Google", true);
                        this.zzftd.zzans().zza(this.zzgbx.get());
                        return;
                    }
                    return;
                case 3:
                    if (this.zzftd.zzga(this.zzgaq.getCustomTemplateId()) != null) {
                        if (this.zzgaq.zzanh() != null) {
                            zzi("Google", true);
                        }
                        this.zzftd.zzga(this.zzgaq.getCustomTemplateId()).zza(this.zzgca.get());
                        return;
                    }
                    return;
                case 6:
                    if (this.zzftd.zzant() != null) {
                        zzi("Google", true);
                        this.zzftd.zzant().zza(this.zzgby.get());
                        return;
                    }
                    return;
                case 7:
                    if (this.zzftd.zzanv() != null) {
                        this.zzftd.zzanv().zza(this.zzgbz.get());
                        return;
                    }
                    return;
                default:
                    zzd.zzey("Wrong native template id!");
                    return;
            }
        } catch (RemoteException e) {
            zzd.zzc("RemoteException when notifyAdLoad is called", e);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:28:0x0069, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void zzb(android.view.View r3, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r4, java.util.Map<java.lang.String, java.lang.ref.WeakReference<android.view.View>> r5, boolean r6) {
        /*
            r2 = this;
            monitor-enter(r2)
            boolean r0 = r2.zzgcc     // Catch:{ all -> 0x006a }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r2)
            return
        L_0x0007:
            r0 = 1
            if (r6 == 0) goto L_0x001a
            com.google.android.gms.internal.ads.zzcda r6 = r2.zzgbu     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzcdy r1 = r2.zzgcb     // Catch:{ all -> 0x006a }
            r6.zzd(r1)     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzccm r6 = r2.zzgbt     // Catch:{ all -> 0x006a }
            r6.zzb(r3, r4, r5)     // Catch:{ all -> 0x006a }
            r2.zzgcc = r0     // Catch:{ all -> 0x006a }
            monitor-exit(r2)
            return
        L_0x001a:
            if (r6 != 0) goto L_0x0068
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r6 = com.google.android.gms.internal.ads.zzabf.zzcsi     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()     // Catch:{ all -> 0x006a }
            java.lang.Object r6 = r1.zzd(r6)     // Catch:{ all -> 0x006a }
            java.lang.Boolean r6 = (java.lang.Boolean) r6     // Catch:{ all -> 0x006a }
            boolean r6 = r6.booleanValue()     // Catch:{ all -> 0x006a }
            if (r6 == 0) goto L_0x0068
            if (r4 == 0) goto L_0x0068
            java.util.Set r6 = r4.entrySet()     // Catch:{ all -> 0x006a }
            java.util.Iterator r6 = r6.iterator()     // Catch:{ all -> 0x006a }
        L_0x0038:
            boolean r1 = r6.hasNext()     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0068
            java.lang.Object r1 = r6.next()     // Catch:{ all -> 0x006a }
            java.util.Map$Entry r1 = (java.util.Map.Entry) r1     // Catch:{ all -> 0x006a }
            java.lang.Object r1 = r1.getValue()     // Catch:{ all -> 0x006a }
            java.lang.ref.WeakReference r1 = (java.lang.ref.WeakReference) r1     // Catch:{ all -> 0x006a }
            java.lang.Object r1 = r1.get()     // Catch:{ all -> 0x006a }
            android.view.View r1 = (android.view.View) r1     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0038
            boolean r1 = zzz(r1)     // Catch:{ all -> 0x006a }
            if (r1 == 0) goto L_0x0038
            com.google.android.gms.internal.ads.zzcda r6 = r2.zzgbu     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzcdy r1 = r2.zzgcb     // Catch:{ all -> 0x006a }
            r6.zzd(r1)     // Catch:{ all -> 0x006a }
            com.google.android.gms.internal.ads.zzccm r6 = r2.zzgbt     // Catch:{ all -> 0x006a }
            r6.zzb(r3, r4, r5)     // Catch:{ all -> 0x006a }
            r2.zzgcc = r0     // Catch:{ all -> 0x006a }
            monitor-exit(r2)
            return
        L_0x0068:
            monitor-exit(r2)
            return
        L_0x006a:
            r3 = move-exception
            monitor-exit(r2)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbt.zzb(android.view.View, java.util.Map, java.util.Map, boolean):void");
    }

    public final synchronized void zzb(zzcdy zzcdy) {
        this.zzgbt.zza(zzcdy.zzaiz(), zzcdy.zzaoe());
        if (zzcdy.zzaoc() != null) {
            zzcdy.zzaoc().setClickable(false);
            zzcdy.zzaoc().removeAllViews();
        }
        if (zzcdy.zzaod() != null) {
            zzcdy.zzaod().zzb(this.zzfuo);
        }
        this.zzgcb = null;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzbi(boolean z) {
        this.zzgbt.zza(this.zzgcb.zzaiz(), this.zzgcb.zzaoe(), this.zzgcb.zzaof(), z);
    }

    public final synchronized void zzf(Bundle bundle) {
        this.zzgbt.zzf(bundle);
    }

    public final synchronized void zzfw(String str) {
        this.zzgbt.zzfw(str);
    }

    public final synchronized void zzg(Bundle bundle) {
        this.zzgbt.zzg(bundle);
    }

    public final synchronized boolean zzh(Bundle bundle) {
        if (this.zzgcc) {
            return true;
        }
        boolean zzh = this.zzgbt.zzh(bundle);
        this.zzgcc = zzh;
        return zzh;
    }

    /* JADX WARNING: Removed duplicated region for block: B:21:0x0038  */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x003e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzi(java.lang.String r16, boolean r17) {
        /*
            r15 = this;
            r0 = r15
            com.google.android.gms.internal.ads.zzcci r1 = r0.zzgbv
            boolean r1 = r1.zzamy()
            if (r1 != 0) goto L_0x000a
            return
        L_0x000a:
            com.google.android.gms.internal.ads.zzcce r1 = r0.zzgaq
            com.google.android.gms.internal.ads.zzbdv r1 = r1.zzani()
            com.google.android.gms.internal.ads.zzcce r2 = r0.zzgaq
            com.google.android.gms.internal.ads.zzbdv r2 = r2.zzanh()
            if (r1 != 0) goto L_0x001b
            if (r2 != 0) goto L_0x001b
            return
        L_0x001b:
            r3 = 0
            r4 = 1
            if (r1 == 0) goto L_0x0021
            r5 = 1
            goto L_0x0022
        L_0x0021:
            r5 = 0
        L_0x0022:
            if (r2 == 0) goto L_0x0025
            r3 = 1
        L_0x0025:
            r6 = 0
            if (r5 == 0) goto L_0x002a
        L_0x0028:
            r10 = r6
            goto L_0x0032
        L_0x002a:
            if (r3 == 0) goto L_0x0030
            java.lang.String r6 = "javascript"
            r1 = r2
            goto L_0x0028
        L_0x0030:
            r1 = r6
            r10 = r1
        L_0x0032:
            android.webkit.WebView r5 = r1.getWebView()
            if (r5 != 0) goto L_0x003e
            java.lang.String r1 = "Webview is null in InternalNativeAd"
        L_0x003a:
            com.google.android.gms.ads.internal.util.zzd.zzfa(r1)
            return
        L_0x003e:
            com.google.android.gms.internal.ads.zzard r5 = com.google.android.gms.ads.internal.zzp.zzlf()
            android.content.Context r6 = r0.context
            boolean r5 = r5.zzm(r6)
            if (r5 != 0) goto L_0x004d
            java.lang.String r1 = "Failed to initialize omid in InternalNativeAd"
            goto L_0x003a
        L_0x004d:
            com.google.android.gms.internal.ads.zzazh r5 = r0.zzbpd
            int r5 = r5.zzegl
            com.google.android.gms.internal.ads.zzazh r6 = r0.zzbpd
            int r6 = r6.zzegm
            r7 = 23
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>(r7)
            r8.append(r5)
            java.lang.String r5 = "."
            r8.append(r5)
            r8.append(r6)
            java.lang.String r6 = r8.toString()
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r5 = com.google.android.gms.internal.ads.zzabf.zzcum
            com.google.android.gms.internal.ads.zzabb r7 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r5 = r7.zzd(r5)
            java.lang.Boolean r5 = (java.lang.Boolean) r5
            boolean r5 = r5.booleanValue()
            if (r5 == 0) goto L_0x00ae
            if (r3 == 0) goto L_0x0086
            com.google.android.gms.internal.ads.zzare r5 = com.google.android.gms.internal.ads.zzare.VIDEO
            com.google.android.gms.internal.ads.zzarg r7 = com.google.android.gms.internal.ads.zzarg.DEFINED_BY_JAVASCRIPT
        L_0x0083:
            r13 = r5
            r12 = r7
            goto L_0x0097
        L_0x0086:
            com.google.android.gms.internal.ads.zzare r5 = com.google.android.gms.internal.ads.zzare.NATIVE_DISPLAY
            com.google.android.gms.internal.ads.zzcce r7 = r0.zzgaq
            int r7 = r7.zzanc()
            r8 = 3
            if (r7 != r8) goto L_0x0094
            com.google.android.gms.internal.ads.zzarg r7 = com.google.android.gms.internal.ads.zzarg.UNSPECIFIED
            goto L_0x0083
        L_0x0094:
            com.google.android.gms.internal.ads.zzarg r7 = com.google.android.gms.internal.ads.zzarg.ONE_PIXEL
            goto L_0x0083
        L_0x0097:
            com.google.android.gms.internal.ads.zzard r5 = com.google.android.gms.ads.internal.zzp.zzlf()
            android.webkit.WebView r7 = r1.getWebView()
            java.lang.String r8 = ""
            java.lang.String r9 = "javascript"
            com.google.android.gms.internal.ads.zzdmu r11 = r0.zzeri
            java.lang.String r14 = r11.zzche
            r11 = r16
            com.google.android.gms.dynamic.IObjectWrapper r5 = r5.zzb(r6, r7, r8, r9, r10, r11, r12, r13, r14)
            goto L_0x00c0
        L_0x00ae:
            com.google.android.gms.internal.ads.zzard r5 = com.google.android.gms.ads.internal.zzp.zzlf()
            android.webkit.WebView r7 = r1.getWebView()
            java.lang.String r8 = ""
            java.lang.String r9 = "javascript"
            r11 = r16
            com.google.android.gms.dynamic.IObjectWrapper r5 = r5.zza(r6, r7, r8, r9, r10, r11)
        L_0x00c0:
            if (r5 != 0) goto L_0x00c6
            java.lang.String r1 = "Failed to create omid session in InternalNativeAd"
            goto L_0x003a
        L_0x00c6:
            com.google.android.gms.internal.ads.zzcce r6 = r0.zzgaq
            r6.zzat(r5)
            r1.zzaq(r5)
            if (r3 == 0) goto L_0x00df
            android.view.View r2 = r2.getView()
            if (r2 == 0) goto L_0x00dd
            com.google.android.gms.internal.ads.zzard r3 = com.google.android.gms.ads.internal.zzp.zzlf()
            r3.zza(r5, r2)
        L_0x00dd:
            r0.zzgcd = r4
        L_0x00df:
            if (r17 == 0) goto L_0x0104
            com.google.android.gms.internal.ads.zzard r2 = com.google.android.gms.ads.internal.zzp.zzlf()
            r2.zzab(r5)
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabf.zzcuo
            com.google.android.gms.internal.ads.zzabb r3 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r2 = r3.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0104
            java.lang.String r2 = "onSdkLoaded"
            androidx.c.a r3 = new androidx.c.a
            r3.<init>()
            r1.zza(r2, r3)
        L_0x0104:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcbt.zzi(java.lang.String, boolean):void");
    }

    public final synchronized void zztg() {
        this.zzgbt.zztg();
    }
}
