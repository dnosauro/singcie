package com.google.android.gms.internal.ads;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.Application;
import android.app.KeyguardManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.IntentFilter;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.PowerManager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowManager;
import com.google.android.gms.ads.internal.util.zzbs;
import com.google.android.gms.ads.internal.util.zzd;
import com.google.android.gms.ads.internal.util.zzm;
import com.google.android.gms.ads.internal.zzp;
import com.google.android.gms.common.util.VisibleForTesting;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@TargetApi(14)
public final class zzqq implements Application.ActivityLifecycleCallbacks, View.OnAttachStateChangeListener, ViewTreeObserver.OnGlobalLayoutListener, ViewTreeObserver.OnScrollChangedListener {
    private static final long zzbqt = ((Long) zzwq.zzqe().zzd(zzabf.zzcpu)).longValue();
    private final Context zzaaa;
    private final PowerManager zzaab;
    private final KeyguardManager zzaac;
    private WeakReference<ViewTreeObserver> zzaae;
    private int zzaai = -1;
    private final WindowManager zzbqu;
    @VisibleForTesting
    private BroadcastReceiver zzbqv;
    private WeakReference<View> zzbqw;
    private zzqx zzbqx;
    private zzbs zzbqy = new zzbs(zzbqt);
    private boolean zzbqz = false;
    private final HashSet<zzqu> zzbra = new HashSet<>();
    private final Rect zzbrb;
    private final DisplayMetrics zzxl;
    private Application zzyh;

    public zzqq(Context context, View view) {
        this.zzaaa = context.getApplicationContext();
        this.zzbqu = (WindowManager) context.getSystemService("window");
        this.zzaab = (PowerManager) this.zzaaa.getSystemService("power");
        this.zzaac = (KeyguardManager) context.getSystemService("keyguard");
        Context context2 = this.zzaaa;
        if (context2 instanceof Application) {
            this.zzyh = (Application) context2;
            this.zzbqx = new zzqx((Application) context2, this);
        }
        this.zzxl = context.getResources().getDisplayMetrics();
        this.zzbrb = new Rect();
        this.zzbrb.right = this.zzbqu.getDefaultDisplay().getWidth();
        this.zzbrb.bottom = this.zzbqu.getDefaultDisplay().getHeight();
        WeakReference<View> weakReference = this.zzbqw;
        View view2 = weakReference != null ? (View) weakReference.get() : null;
        if (view2 != null) {
            view2.removeOnAttachStateChangeListener(this);
            zzg(view2);
        }
        this.zzbqw = new WeakReference<>(view);
        if (view != null) {
            if (zzp.zzks().isAttachedToWindow(view)) {
                zzf(view);
            }
            view.addOnAttachStateChangeListener(this);
        }
    }

    private final Rect zza(Rect rect) {
        return new Rect(zzbs(rect.left), zzbs(rect.top), zzbs(rect.right), zzbs(rect.bottom));
    }

    private final void zza(Activity activity, int i) {
        Window window;
        if (this.zzbqw != null && (window = activity.getWindow()) != null) {
            View peekDecorView = window.peekDecorView();
            View view = (View) this.zzbqw.get();
            if (view != null && peekDecorView != null && view.getRootView() == peekDecorView.getRootView()) {
                this.zzaai = i;
            }
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x00d1 A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00d2  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void zzbr(int r32) {
        /*
            r31 = this;
            r1 = r31
            r2 = r32
            java.util.HashSet<com.google.android.gms.internal.ads.zzqu> r0 = r1.zzbra
            int r0 = r0.size()
            if (r0 != 0) goto L_0x000d
            return
        L_0x000d:
            java.lang.ref.WeakReference<android.view.View> r0 = r1.zzbqw
            if (r0 != 0) goto L_0x0012
            return
        L_0x0012:
            java.lang.Object r0 = r0.get()
            r3 = r0
            android.view.View r3 = (android.view.View) r3
            r4 = 0
            r5 = 1
            if (r2 != r5) goto L_0x001f
            r6 = 1
            goto L_0x0020
        L_0x001f:
            r6 = 0
        L_0x0020:
            if (r3 != 0) goto L_0x0024
            r7 = 1
            goto L_0x0025
        L_0x0024:
            r7 = 0
        L_0x0025:
            android.graphics.Rect r8 = new android.graphics.Rect
            r8.<init>()
            android.graphics.Rect r9 = new android.graphics.Rect
            r9.<init>()
            android.graphics.Rect r10 = new android.graphics.Rect
            r10.<init>()
            android.graphics.Rect r11 = new android.graphics.Rect
            r11.<init>()
            r0 = 2
            int[] r12 = new int[r0]
            int[] r0 = new int[r0]
            if (r3 == 0) goto L_0x0077
            boolean r13 = r3.getGlobalVisibleRect(r9)
            boolean r14 = r3.getLocalVisibleRect(r10)
            r3.getHitRect(r11)
            r3.getLocationOnScreen(r12)     // Catch:{ Exception -> 0x0052 }
            r3.getLocationInWindow(r0)     // Catch:{ Exception -> 0x0052 }
            goto L_0x0058
        L_0x0052:
            r0 = move-exception
            java.lang.String r15 = "Failure getting view location."
            com.google.android.gms.ads.internal.util.zzd.zzc(r15, r0)
        L_0x0058:
            r0 = r12[r4]
            r8.left = r0
            r0 = r12[r5]
            r8.top = r0
            int r0 = r8.left
            int r12 = r3.getWidth()
            int r0 = r0 + r12
            r8.right = r0
            int r0 = r8.top
            int r12 = r3.getHeight()
            int r0 = r0 + r12
            r8.bottom = r0
            r24 = r13
            r26 = r14
            goto L_0x007b
        L_0x0077:
            r24 = 0
            r26 = 0
        L_0x007b:
            com.google.android.gms.internal.ads.zzaaq<java.lang.Boolean> r0 = com.google.android.gms.internal.ads.zzabf.zzcpx
            com.google.android.gms.internal.ads.zzabb r12 = com.google.android.gms.internal.ads.zzwq.zzqe()
            java.lang.Object r0 = r12.zzd(r0)
            java.lang.Boolean r0 = (java.lang.Boolean) r0
            boolean r0 = r0.booleanValue()
            if (r0 == 0) goto L_0x0094
            if (r3 == 0) goto L_0x0094
            java.util.List r0 = r1.zzi(r3)
            goto L_0x0098
        L_0x0094:
            java.util.List r0 = java.util.Collections.emptyList()
        L_0x0098:
            r30 = r0
            r0 = 8
            if (r3 == 0) goto L_0x00a3
            int r12 = r3.getWindowVisibility()
            goto L_0x00a5
        L_0x00a3:
            r12 = 8
        L_0x00a5:
            int r13 = r1.zzaai
            r14 = -1
            if (r13 == r14) goto L_0x00ab
            r12 = r13
        L_0x00ab:
            if (r7 != 0) goto L_0x00c2
            com.google.android.gms.ads.internal.zzp.zzkq()
            android.os.PowerManager r7 = r1.zzaab
            android.app.KeyguardManager r13 = r1.zzaac
            boolean r7 = com.google.android.gms.ads.internal.util.zzm.zza((android.view.View) r3, (android.os.PowerManager) r7, (android.app.KeyguardManager) r13)
            if (r7 == 0) goto L_0x00c2
            if (r24 == 0) goto L_0x00c2
            if (r26 == 0) goto L_0x00c2
            if (r12 != 0) goto L_0x00c2
            r7 = 1
            goto L_0x00c3
        L_0x00c2:
            r7 = 0
        L_0x00c3:
            if (r6 == 0) goto L_0x00d2
            com.google.android.gms.ads.internal.util.zzbs r6 = r1.zzbqy
            boolean r6 = r6.tryAcquire()
            if (r6 != 0) goto L_0x00d2
            boolean r6 = r1.zzbqz
            if (r7 != r6) goto L_0x00d2
            return
        L_0x00d2:
            if (r7 != 0) goto L_0x00db
            boolean r6 = r1.zzbqz
            if (r6 != 0) goto L_0x00db
            if (r2 != r5) goto L_0x00db
            return
        L_0x00db:
            com.google.android.gms.internal.ads.zzqv r2 = new com.google.android.gms.internal.ads.zzqv
            com.google.android.gms.common.util.Clock r6 = com.google.android.gms.ads.internal.zzp.zzkx()
            long r16 = r6.elapsedRealtime()
            android.os.PowerManager r6 = r1.zzaab
            boolean r18 = r6.isScreenOn()
            if (r3 == 0) goto L_0x00fa
            com.google.android.gms.ads.internal.util.zzu r6 = com.google.android.gms.ads.internal.zzp.zzks()
            boolean r6 = r6.isAttachedToWindow(r3)
            if (r6 == 0) goto L_0x00fa
            r19 = 1
            goto L_0x00fc
        L_0x00fa:
            r19 = 0
        L_0x00fc:
            if (r3 == 0) goto L_0x0105
            int r0 = r3.getWindowVisibility()
            r20 = r0
            goto L_0x0107
        L_0x0105:
            r20 = 8
        L_0x0107:
            android.graphics.Rect r0 = r1.zzbrb
            android.graphics.Rect r21 = r1.zza((android.graphics.Rect) r0)
            android.graphics.Rect r22 = r1.zza((android.graphics.Rect) r8)
            android.graphics.Rect r23 = r1.zza((android.graphics.Rect) r9)
            android.graphics.Rect r25 = r1.zza((android.graphics.Rect) r10)
            android.graphics.Rect r27 = r1.zza((android.graphics.Rect) r11)
            android.util.DisplayMetrics r0 = r1.zzxl
            float r0 = r0.density
            r15 = r2
            r28 = r0
            r29 = r7
            r15.<init>(r16, r18, r19, r20, r21, r22, r23, r24, r25, r26, r27, r28, r29, r30)
            java.util.HashSet<com.google.android.gms.internal.ads.zzqu> r0 = r1.zzbra
            java.util.Iterator r0 = r0.iterator()
        L_0x012f:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x013f
            java.lang.Object r3 = r0.next()
            com.google.android.gms.internal.ads.zzqu r3 = (com.google.android.gms.internal.ads.zzqu) r3
            r3.zza(r2)
            goto L_0x012f
        L_0x013f:
            r1.zzbqz = r7
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.ads.zzqq.zzbr(int):void");
    }

    private final int zzbs(int i) {
        return (int) (((float) i) / this.zzxl.density);
    }

    private final void zzct() {
        zzm.zzedd.post(new zzqt(this));
    }

    private final void zzf(View view) {
        ViewTreeObserver viewTreeObserver = view.getViewTreeObserver();
        if (viewTreeObserver.isAlive()) {
            this.zzaae = new WeakReference<>(viewTreeObserver);
            viewTreeObserver.addOnScrollChangedListener(this);
            viewTreeObserver.addOnGlobalLayoutListener(this);
        }
        if (this.zzbqv == null) {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.SCREEN_ON");
            intentFilter.addAction("android.intent.action.SCREEN_OFF");
            intentFilter.addAction("android.intent.action.USER_PRESENT");
            this.zzbqv = new zzqs(this);
            zzp.zzll().zza(this.zzaaa, this.zzbqv, intentFilter);
        }
        Application application = this.zzyh;
        if (application != null) {
            try {
                application.registerActivityLifecycleCallbacks(this.zzbqx);
            } catch (Exception e) {
                zzd.zzc("Error registering activity lifecycle callbacks.", e);
            }
        }
    }

    private final void zzg(View view) {
        try {
            if (this.zzaae != null) {
                ViewTreeObserver viewTreeObserver = (ViewTreeObserver) this.zzaae.get();
                if (viewTreeObserver != null && viewTreeObserver.isAlive()) {
                    viewTreeObserver.removeOnScrollChangedListener(this);
                    viewTreeObserver.removeGlobalOnLayoutListener(this);
                }
                this.zzaae = null;
            }
        } catch (Exception e) {
            zzd.zzc("Error while unregistering listeners from the last ViewTreeObserver.", e);
        }
        try {
            ViewTreeObserver viewTreeObserver2 = view.getViewTreeObserver();
            if (viewTreeObserver2.isAlive()) {
                viewTreeObserver2.removeOnScrollChangedListener(this);
                viewTreeObserver2.removeGlobalOnLayoutListener(this);
            }
        } catch (Exception e2) {
            zzd.zzc("Error while unregistering listeners from the ViewTreeObserver.", e2);
        }
        if (this.zzbqv != null) {
            try {
                zzp.zzll().zza(this.zzaaa, this.zzbqv);
            } catch (IllegalStateException e3) {
                zzd.zzc("Failed trying to unregister the receiver", e3);
            } catch (Exception e4) {
                zzp.zzku().zza(e4, "ActiveViewUnit.stopScreenStatusMonitoring");
            }
            this.zzbqv = null;
        }
        Application application = this.zzyh;
        if (application != null) {
            try {
                application.unregisterActivityLifecycleCallbacks(this.zzbqx);
            } catch (Exception e5) {
                zzd.zzc("Error registering activity lifecycle callbacks.", e5);
            }
        }
    }

    private final List<Rect> zzi(View view) {
        try {
            ArrayList arrayList = new ArrayList();
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                View view2 = (View) parent;
                Rect rect = new Rect();
                if (view2.isScrollContainer() && view2.getGlobalVisibleRect(rect)) {
                    arrayList.add(zza(rect));
                }
            }
            return arrayList;
        } catch (Exception e) {
            zzp.zzku().zza(e, "PositionWatcher.getParentScrollViewRects");
            return Collections.emptyList();
        }
    }

    public final void onActivityCreated(Activity activity, Bundle bundle) {
        zza(activity, 0);
        zzbr(3);
        zzct();
    }

    public final void onActivityDestroyed(Activity activity) {
        zzbr(3);
        zzct();
    }

    public final void onActivityPaused(Activity activity) {
        zza(activity, 4);
        zzbr(3);
        zzct();
    }

    public final void onActivityResumed(Activity activity) {
        zza(activity, 0);
        zzbr(3);
        zzct();
    }

    public final void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        zzbr(3);
        zzct();
    }

    public final void onActivityStarted(Activity activity) {
        zza(activity, 0);
        zzbr(3);
        zzct();
    }

    public final void onActivityStopped(Activity activity) {
        zzbr(3);
        zzct();
    }

    public final void onGlobalLayout() {
        zzbr(2);
        zzct();
    }

    public final void onScrollChanged() {
        zzbr(1);
    }

    public final void onViewAttachedToWindow(View view) {
        this.zzaai = -1;
        zzf(view);
        zzbr(3);
    }

    public final void onViewDetachedFromWindow(View view) {
        this.zzaai = -1;
        zzbr(3);
        zzct();
        zzg(view);
    }

    public final void zza(zzqu zzqu) {
        this.zzbra.add(zzqu);
        zzbr(3);
    }

    public final void zzb(zzqu zzqu) {
        this.zzbra.remove(zzqu);
    }

    public final void zzen(long j) {
        this.zzbqy.zzfb(j);
    }

    public final void zzls() {
        this.zzbqy.zzfb(zzbqt);
    }

    /* access modifiers changed from: package-private */
    public final /* synthetic */ void zzlt() {
        zzbr(3);
    }
}
