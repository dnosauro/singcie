package com.google.android.gms.internal.ads;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import com.google.android.gms.ads.internal.util.zzbq;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzf;
import java.lang.ref.WeakReference;
import java.util.Map;
import java.util.concurrent.Executor;

public final class zzcda {
    private final Executor executor;
    private final zzadz zzdnh;
    private final zzf zzebt;
    private final Executor zzfqx;
    private final zzdnn zzfvl;
    private final zzcce zzgaq;
    private final zzcci zzgbv;
    private final zzcbz zzgce;
    private final zzcdi zzgej;
    private final zzcdq zzgek;

    public zzcda(zzf zzf, zzdnn zzdnn, zzcci zzcci, zzcce zzcce, zzcdi zzcdi, zzcdq zzcdq, Executor executor2, Executor executor3, zzcbz zzcbz) {
        this.zzebt = zzf;
        this.zzfvl = zzdnn;
        this.zzdnh = zzdnn.zzdnh;
        this.zzgbv = zzcci;
        this.zzgaq = zzcce;
        this.zzgej = zzcdi;
        this.zzgek = zzcdq;
        this.zzfqx = executor2;
        this.executor = executor3;
        this.zzgce = zzcbz;
    }

    private static void zza(RelativeLayout.LayoutParams layoutParams, int i) {
        if (i != 0) {
            switch (i) {
                case 2:
                    layoutParams.addRule(12);
                    layoutParams.addRule(11);
                    return;
                case 3:
                    layoutParams.addRule(12);
                    layoutParams.addRule(9);
                    return;
                default:
                    layoutParams.addRule(10);
                    layoutParams.addRule(11);
                    return;
            }
        } else {
            layoutParams.addRule(10);
            layoutParams.addRule(9);
        }
    }

    /* access modifiers changed from: private */
    public static boolean zza(zzcdy zzcdy, String[] strArr) {
        Map<String, WeakReference<View>> zzaof = zzcdy.zzaof();
        if (zzaof == null) {
            return false;
        }
        for (String str : strArr) {
            if (zzaof.get(str) != null) {
                return true;
            }
        }
        return false;
    }

    public final void zza(zzcdy zzcdy) {
        this.zzfqx.execute(new zzccz(this, zzcdy));
    }

    public final boolean zza(ViewGroup viewGroup) {
        View zzang = this.zzgaq.zzang();
        if (zzang == null) {
            return false;
        }
        viewGroup.removeAllViews();
        if (zzang.getParent() instanceof ViewGroup) {
            ((ViewGroup) zzang.getParent()).removeView(zzang);
        }
        viewGroup.addView(zzang, ((Boolean) zzwq.zzqe().zzd(zzabf.zzcsh)).booleanValue() ? new FrameLayout.LayoutParams(-1, -1, 17) : new FrameLayout.LayoutParams(-2, -2, 17));
        return true;
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzb(ViewGroup viewGroup) {
        boolean z = viewGroup != null;
        if (this.zzgaq.zzang() == null) {
            return;
        }
        if (2 == this.zzgaq.zzanc() || 1 == this.zzgaq.zzanc()) {
            this.zzebt.zza(this.zzfvl.zzhip, String.valueOf(this.zzgaq.zzanc()), z);
        } else if (6 == this.zzgaq.zzanc()) {
            this.zzebt.zza(this.zzfvl.zzhip, "2", z);
            this.zzebt.zza(this.zzfvl.zzhip, "1", z);
        }
    }

    public final void zzc(zzcdy zzcdy) {
        if (zzcdy != null && this.zzgej != null && zzcdy.zzaoc() != null && this.zzgbv.zzano()) {
            try {
                zzcdy.zzaoc().addView(this.zzgej.zzaon());
            } catch (zzbeh e) {
                zzd.zza("web view can not be obtained", e);
            }
        }
    }

    public final void zzd(zzcdy zzcdy) {
        if (zzcdy != null) {
            Context context = zzcdy.zzaiz().getContext();
            if (zzbq.zza(context, this.zzgbv.zzgdi)) {
                if (!(context instanceof Activity)) {
                    zzd.zzeb("Activity context is needed for policy validator.");
                } else if (this.zzgek != null && zzcdy.zzaoc() != null) {
                    try {
                        WindowManager windowManager = (WindowManager) context.getSystemService("window");
                        windowManager.addView(this.zzgek.zza(zzcdy.zzaoc(), windowManager), zzbq.zzyx());
                    } catch (zzbeh e) {
                        zzd.zza("web view can not be obtained", e);
                    }
                }
            }
        }
    }

    /* JADX WARNING: type inference failed for: r4v6, types: [android.view.View] */
    /* access modifiers changed from: package-private */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003a  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x0053  */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:36:0x009e  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00e5  */
    /* JADX WARNING: Removed duplicated region for block: B:54:0x0103  */
    /* JADX WARNING: Removed duplicated region for block: B:96:0x00f6 A[SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:99:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final /* synthetic */ void zze(com.google.android.gms.internal.ads.zzcdy r10) {
        /*
            r9 = this;
            com.google.android.gms.internal.ads.zzcci r0 = r9.zzgbv
            boolean r0 = r0.zzanq()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x0015
            com.google.android.gms.internal.ads.zzcci r0 = r9.zzgbv
            boolean r0 = r0.zzanp()
            if (r0 == 0) goto L_0x0013
            goto L_0x0015
        L_0x0013:
            r0 = 0
            goto L_0x0016
        L_0x0015:
            r0 = 1
        L_0x0016:
            r3 = 0
            if (r0 == 0) goto L_0x0037
            java.lang.String r0 = "1098"
            java.lang.String r4 = "3011"
            java.lang.String[] r0 = new java.lang.String[]{r0, r4}
            r4 = 0
        L_0x0022:
            r5 = 2
            if (r4 >= r5) goto L_0x0037
            r5 = r0[r4]
            android.view.View r5 = r10.zzgc(r5)
            if (r5 == 0) goto L_0x0034
            boolean r6 = r5 instanceof android.view.ViewGroup
            if (r6 == 0) goto L_0x0034
            android.view.ViewGroup r5 = (android.view.ViewGroup) r5
            goto L_0x0038
        L_0x0034:
            int r4 = r4 + 1
            goto L_0x0022
        L_0x0037:
            r5 = r3
        L_0x0038:
            if (r5 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = 0
        L_0x003d:
            android.view.View r4 = r10.zzaiz()
            android.content.Context r4 = r4.getContext()
            android.widget.RelativeLayout$LayoutParams r6 = new android.widget.RelativeLayout$LayoutParams
            r7 = -2
            r6.<init>(r7, r7)
            com.google.android.gms.internal.ads.zzcce r7 = r9.zzgaq
            android.view.View r7 = r7.zzand()
            if (r7 == 0) goto L_0x0069
            com.google.android.gms.internal.ads.zzcce r4 = r9.zzgaq
            android.view.View r4 = r4.zzand()
            com.google.android.gms.internal.ads.zzadz r7 = r9.zzdnh
            if (r7 != 0) goto L_0x005e
            goto L_0x009b
        L_0x005e:
            if (r0 != 0) goto L_0x009b
            int r7 = r7.zzbnp
            zza((android.widget.RelativeLayout.LayoutParams) r6, (int) r7)
            r4.setLayoutParams(r6)
            goto L_0x009b
        L_0x0069:
            com.google.android.gms.internal.ads.zzcce r7 = r9.zzgaq
            com.google.android.gms.internal.ads.zzaeb r7 = r7.zzsx()
            boolean r7 = r7 instanceof com.google.android.gms.internal.ads.zzadq
            if (r7 != 0) goto L_0x0075
            r4 = r3
            goto L_0x009b
        L_0x0075:
            com.google.android.gms.internal.ads.zzcce r7 = r9.zzgaq
            com.google.android.gms.internal.ads.zzaeb r7 = r7.zzsx()
            com.google.android.gms.internal.ads.zzadq r7 = (com.google.android.gms.internal.ads.zzadq) r7
            if (r0 != 0) goto L_0x0086
            int r8 = r7.zzsp()
            zza((android.widget.RelativeLayout.LayoutParams) r6, (int) r8)
        L_0x0086:
            com.google.android.gms.internal.ads.zzadt r8 = new com.google.android.gms.internal.ads.zzadt
            r8.<init>(r4, r7, r6)
            com.google.android.gms.internal.ads.zzaaq<java.lang.String> r4 = com.google.android.gms.internal.ads.zzabf.zzcse
            com.google.android.gms.internal.ads.zzabb r6 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r4 = r6.zzd(r4)
            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
            r8.setContentDescription(r4)
            r4 = r8
        L_0x009b:
            r6 = -1
            if (r4 == 0) goto L_0x00e0
            android.view.ViewParent r7 = r4.getParent()
            boolean r7 = r7 instanceof android.view.ViewGroup
            if (r7 == 0) goto L_0x00af
            android.view.ViewParent r7 = r4.getParent()
            android.view.ViewGroup r7 = (android.view.ViewGroup) r7
            r7.removeView(r4)
        L_0x00af:
            if (r0 == 0) goto L_0x00b8
            r5.removeAllViews()
            r5.addView(r4)
            goto L_0x00d9
        L_0x00b8:
            com.google.android.gms.ads.formats.AdChoicesView r0 = new com.google.android.gms.ads.formats.AdChoicesView
            android.view.View r5 = r10.zzaiz()
            android.content.Context r5 = r5.getContext()
            r0.<init>(r5)
            android.widget.FrameLayout$LayoutParams r5 = new android.widget.FrameLayout$LayoutParams
            r5.<init>(r6, r6)
            r0.setLayoutParams(r5)
            r0.addView(r4)
            android.widget.FrameLayout r5 = r10.zzaoc()
            if (r5 == 0) goto L_0x00d9
            r5.addView(r0)
        L_0x00d9:
            java.lang.String r0 = r10.zzaoh()
            r10.zza(r0, r4, r2)
        L_0x00e0:
            java.lang.String[] r0 = com.google.android.gms.internal.ads.zzccy.zzgeb
            int r2 = r0.length
        L_0x00e3:
            if (r1 >= r2) goto L_0x00f6
            r4 = r0[r1]
            android.view.View r4 = r10.zzgc(r4)
            boolean r5 = r4 instanceof android.view.ViewGroup
            if (r5 == 0) goto L_0x00f3
            r0 = r4
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            goto L_0x00f7
        L_0x00f3:
            int r1 = r1 + 1
            goto L_0x00e3
        L_0x00f6:
            r0 = r3
        L_0x00f7:
            java.util.concurrent.Executor r1 = r9.executor
            com.google.android.gms.internal.ads.zzcdc r2 = new com.google.android.gms.internal.ads.zzcdc
            r2.<init>(r9, r0)
            r1.execute(r2)
            if (r0 == 0) goto L_0x01ac
            boolean r1 = r9.zza((android.view.ViewGroup) r0)
            if (r1 == 0) goto L_0x0120
            com.google.android.gms.internal.ads.zzcce r1 = r9.zzgaq
            com.google.android.gms.internal.ads.zzbdv r1 = r1.zzanh()
            if (r1 == 0) goto L_0x01ac
            com.google.android.gms.internal.ads.zzcce r1 = r9.zzgaq
            com.google.android.gms.internal.ads.zzbdv r1 = r1.zzanh()
            com.google.android.gms.internal.ads.zzcdb r2 = new com.google.android.gms.internal.ads.zzcdb
            r2.<init>(r9, r10, r0)
            r1.zza((com.google.android.gms.internal.ads.zzadx) r2)
            return
        L_0x0120:
            r0.removeAllViews()
            android.view.View r1 = r10.zzaiz()
            if (r1 == 0) goto L_0x012e
            android.content.Context r1 = r1.getContext()
            goto L_0x012f
        L_0x012e:
            r1 = r3
        L_0x012f:
            if (r1 == 0) goto L_0x01ac
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r2 = com.google.android.gms.internal.ads.zzabf.zzcsd
            com.google.android.gms.internal.ads.zzabb r4 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r2 = r4.zzd(r2)
            java.lang.Boolean r2 = (java.lang.Boolean) r2
            boolean r2 = r2.booleanValue()
            if (r2 == 0) goto L_0x0156
            com.google.android.gms.internal.ads.zzcbz r2 = r9.zzgce
            com.google.android.gms.internal.ads.zzaee r2 = r2.zzth()
            if (r2 == 0) goto L_0x01ac
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzsu()     // Catch:{ RemoteException -> 0x0150 }
            goto L_0x0162
        L_0x0150:
            java.lang.String r10 = "Could not get main image drawable"
            com.google.android.gms.ads.internal.util.zzd.zzfa(r10)
            return
        L_0x0156:
            com.google.android.gms.internal.ads.zzcce r2 = r9.zzgaq
            com.google.android.gms.internal.ads.zzaej r2 = r2.zzane()
            if (r2 == 0) goto L_0x01ac
            com.google.android.gms.dynamic.IObjectWrapper r2 = r2.zzsr()     // Catch:{ RemoteException -> 0x01a7 }
        L_0x0162:
            if (r2 == 0) goto L_0x01ac
            java.lang.Object r2 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r2)
            android.graphics.drawable.Drawable r2 = (android.graphics.drawable.Drawable) r2
            if (r2 == 0) goto L_0x01ac
            android.widget.ImageView r4 = new android.widget.ImageView
            r4.<init>(r1)
            r4.setImageDrawable(r2)
            if (r10 == 0) goto L_0x017a
            com.google.android.gms.dynamic.IObjectWrapper r3 = r10.zzaoi()
        L_0x017a:
            if (r3 == 0) goto L_0x0196
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r10 = com.google.android.gms.internal.ads.zzabf.zzcwt
            com.google.android.gms.internal.ads.zzabb r1 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r10 = r1.zzd(r10)
            java.lang.Boolean r10 = (java.lang.Boolean) r10
            boolean r10 = r10.booleanValue()
            if (r10 != 0) goto L_0x018f
            goto L_0x0196
        L_0x018f:
            java.lang.Object r10 = com.google.android.gms.dynamic.ObjectWrapper.unwrap(r3)
            android.widget.ImageView$ScaleType r10 = (android.widget.ImageView.ScaleType) r10
            goto L_0x0198
        L_0x0196:
            android.widget.ImageView$ScaleType r10 = android.widget.ImageView.ScaleType.CENTER_INSIDE
        L_0x0198:
            r4.setScaleType(r10)
            android.widget.FrameLayout$LayoutParams r10 = new android.widget.FrameLayout$LayoutParams
            r10.<init>(r6, r6)
            r4.setLayoutParams(r10)
            r0.addView(r4)
            goto L_0x01ac
        L_0x01a7:
            java.lang.String r10 = "Could not get drawable from image"
            com.google.android.gms.ads.internal.util.zzd.zzfa(r10)
        L_0x01ac:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzcda.zze(com.google.android.gms.internal.ads.zzcdy):void");
    }
}
