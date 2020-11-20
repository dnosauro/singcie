package androidx.databinding;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Handler;
import android.view.Choreographer;
import android.view.View;
import androidx.databinding.C0708b;
import androidx.databinding.p034a.C0706a;
import androidx.lifecycle.C0947e;
import androidx.lifecycle.C0951g;
import androidx.lifecycle.C0952h;
import androidx.lifecycle.C0962p;
import java.lang.ref.ReferenceQueue;

public abstract class ViewDataBinding extends C0705a {

    /* renamed from: a */
    static int f2436a = Build.VERSION.SDK_INT;

    /* renamed from: b */
    private static final int f2437b = 8;

    /* renamed from: c */
    private static final boolean f2438c = (f2436a >= 16);

    /* renamed from: d */
    private static final C0704a f2439d = new C0704a() {
    };

    /* renamed from: e */
    private static final C0704a f2440e = new C0704a() {
    };

    /* renamed from: f */
    private static final C0704a f2441f = new C0704a() {
    };

    /* renamed from: g */
    private static final C0704a f2442g = new C0704a() {
    };

    /* renamed from: h */
    private static final C0708b.C0709a<C0710c, ViewDataBinding, Void> f2443h = new C0708b.C0709a<C0710c, ViewDataBinding, Void>() {
        /* renamed from: a */
        public void mo3979a(C0710c cVar, ViewDataBinding viewDataBinding, int i, Void voidR) {
            switch (i) {
                case 1:
                    if (!cVar.mo3986a(viewDataBinding)) {
                        boolean unused = viewDataBinding.f2448m = true;
                        return;
                    }
                    return;
                case 2:
                    cVar.mo3987b(viewDataBinding);
                    return;
                case 3:
                    cVar.mo3988c(viewDataBinding);
                    return;
                default:
                    return;
            }
        }
    };

    /* renamed from: i */
    private static final ReferenceQueue<ViewDataBinding> f2444i = new ReferenceQueue<>();

    /* renamed from: j */
    private static final View.OnAttachStateChangeListener f2445j = (Build.VERSION.SDK_INT < 19 ? null : new View.OnAttachStateChangeListener() {
        @TargetApi(19)
        public void onViewAttachedToWindow(View view) {
            ViewDataBinding.m2842a(view).f2446k.run();
            view.removeOnAttachStateChangeListener(this);
        }

        public void onViewDetachedFromWindow(View view) {
        }
    });
    /* access modifiers changed from: private */

    /* renamed from: k */
    public final Runnable f2446k;

    /* renamed from: l */
    private boolean f2447l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f2448m;

    /* renamed from: n */
    private C0708b<C0710c, ViewDataBinding, Void> f2449n;

    /* renamed from: o */
    private boolean f2450o;

    /* renamed from: p */
    private Choreographer f2451p;

    /* renamed from: q */
    private final Choreographer.FrameCallback f2452q;

    /* renamed from: r */
    private Handler f2453r;

    /* renamed from: s */
    private ViewDataBinding f2454s;

    /* renamed from: t */
    private C0952h f2455t;

    public class OnStartListener implements C0951g {

        /* renamed from: a */
        final /* synthetic */ ViewDataBinding f2456a;

        @C0962p(mo5125a = C0947e.C0948a.ON_START)
        public void onStart() {
            this.f2456a.mo3974a();
        }
    }

    /* renamed from: androidx.databinding.ViewDataBinding$a */
    private interface C0704a {
    }

    /* renamed from: a */
    static ViewDataBinding m2842a(View view) {
        if (view != null) {
            return (ViewDataBinding) view.getTag(C0706a.C0707a.dataBinding);
        }
        return null;
    }

    /* renamed from: e */
    private void m2845e() {
        if (this.f2450o) {
            mo3977d();
        } else if (mo3976c()) {
            this.f2450o = true;
            this.f2448m = false;
            C0708b<C0710c, ViewDataBinding, Void> bVar = this.f2449n;
            if (bVar != null) {
                bVar.mo3984a(this, 1, null);
                if (this.f2448m) {
                    this.f2449n.mo3984a(this, 2, null);
                }
            }
            if (!this.f2448m) {
                mo3975b();
                C0708b<C0710c, ViewDataBinding, Void> bVar2 = this.f2449n;
                if (bVar2 != null) {
                    bVar2.mo3984a(this, 3, null);
                }
            }
            this.f2450o = false;
        }
    }

    /* renamed from: a */
    public void mo3974a() {
        ViewDataBinding viewDataBinding = this.f2454s;
        if (viewDataBinding == null) {
            m2845e();
        } else {
            viewDataBinding.mo3974a();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public abstract void mo3975b();

    /* renamed from: c */
    public abstract boolean mo3976c();

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002a, code lost:
        if (f2438c == false) goto L_0x0034;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        r2.f2451p.postFrameCallback(r2.f2452q);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0034, code lost:
        r2.f2453r.post(r2.f2446k);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        return;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo3977d() {
        /*
            r2 = this;
            androidx.databinding.ViewDataBinding r0 = r2.f2454s
            if (r0 == 0) goto L_0x0008
            r0.mo3977d()
            goto L_0x003b
        L_0x0008:
            androidx.lifecycle.h r0 = r2.f2455t
            if (r0 == 0) goto L_0x001d
            androidx.lifecycle.e r0 = r0.getLifecycle()
            androidx.lifecycle.e$b r0 = r0.mo5111a()
            androidx.lifecycle.e$b r1 = androidx.lifecycle.C0947e.C0949b.STARTED
            boolean r0 = r0.mo5114a(r1)
            if (r0 != 0) goto L_0x001d
            return
        L_0x001d:
            monitor-enter(r2)
            boolean r0 = r2.f2447l     // Catch:{ all -> 0x003c }
            if (r0 == 0) goto L_0x0024
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            return
        L_0x0024:
            r0 = 1
            r2.f2447l = r0     // Catch:{ all -> 0x003c }
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            boolean r0 = f2438c
            if (r0 == 0) goto L_0x0034
            android.view.Choreographer r0 = r2.f2451p
            android.view.Choreographer$FrameCallback r1 = r2.f2452q
            r0.postFrameCallback(r1)
            goto L_0x003b
        L_0x0034:
            android.os.Handler r0 = r2.f2453r
            java.lang.Runnable r1 = r2.f2446k
            r0.post(r1)
        L_0x003b:
            return
        L_0x003c:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x003c }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.databinding.ViewDataBinding.mo3977d():void");
    }
}
