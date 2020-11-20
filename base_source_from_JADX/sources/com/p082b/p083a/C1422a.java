package com.p082b.p083a;

import android.app.Activity;
import android.content.res.Resources;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.view.DisplayCutout;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewTreeObserver;
import android.view.Window;
import android.view.WindowInsets;
import android.view.WindowManager;
import android.widget.PopupWindow;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.p082b.p083a.C1427c;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import p157d.p161d.p163b.C3250h;
import p167e.p168a.C3292a;

/* renamed from: com.b.a.a */
public final class C1422a extends PopupWindow {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f4257a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public View f4258b;

    /* renamed from: c */
    private int f4259c = -1;

    /* renamed from: d */
    private ArrayList<C1423a> f4260d = new ArrayList<>();

    /* renamed from: e */
    private final Activity f4261e;

    /* renamed from: com.b.a.a$a */
    public interface C1423a {
        /* renamed from: a */
        void mo6888a(int i);
    }

    /* renamed from: com.b.a.a$b */
    static final class C1424b implements ViewTreeObserver.OnGlobalLayoutListener {

        /* renamed from: a */
        final /* synthetic */ C1422a f4262a;

        C1424b(C1422a aVar) {
            this.f4262a = aVar;
        }

        public final void onGlobalLayout() {
            this.f4262a.m5407c();
        }
    }

    /* renamed from: com.b.a.a$c */
    static final class C1425c implements Runnable {

        /* renamed from: a */
        final /* synthetic */ C1422a f4263a;

        C1425c(C1422a aVar) {
            this.f4263a = aVar;
        }

        public final void run() {
            this.f4263a.f4257a.getViewTreeObserver().addOnGlobalLayoutListener(this.f4263a.m5404b());
            if (!this.f4263a.isShowing()) {
                View c = this.f4263a.f4258b;
                if ((c != null ? c.getWindowToken() : null) != null) {
                    C1422a aVar = this.f4263a;
                    aVar.showAtLocation(aVar.f4258b, 0, 0, 0);
                }
            }
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C1422a(@NotNull Activity activity) {
        super(activity);
        C3250h.m9056b(activity, "activity");
        this.f4261e = activity;
        setContentView(View.inflate(this.f4261e, C1427c.C1429b.keyboard_popup, (ViewGroup) null));
        View findViewById = getContentView().findViewById(C1427c.C1428a.keyResizeContainer);
        C3250h.m9053a((Object) findViewById, "contentView.findViewById(R.id.keyResizeContainer)");
        this.f4257a = findViewById;
        setSoftInputMode(21);
        setInputMethodMode(1);
        setWidth(0);
        setHeight(-1);
    }

    /* renamed from: a */
    private final void m5403a(int i, int i2) {
        for (C1423a a : this.f4260d) {
            a.mo6888a(i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final ViewTreeObserver.OnGlobalLayoutListener m5404b() {
        return new C1424b(this);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m5407c() {
        Point point = new Point();
        WindowManager windowManager = this.f4261e.getWindowManager();
        C3250h.m9053a((Object) windowManager, "activity.windowManager");
        windowManager.getDefaultDisplay().getSize(point);
        Rect rect = new Rect();
        this.f4257a.getWindowVisibleDisplayFrame(rect);
        Resources resources = this.f4261e.getResources();
        C3250h.m9053a((Object) resources, "activity.resources");
        int i = resources.getConfiguration().orientation;
        int d = (point.y + m5408d()) - rect.bottom;
        C1426b.f4264a.mo6892b(d > 0 ? 1 : 0);
        if (d > 0) {
            C1426b.f4264a.mo6891a(d);
        }
        if (d != this.f4259c) {
            m5403a(d, i);
        }
        this.f4259c = d;
    }

    /* renamed from: d */
    private final int m5408d() {
        Window window = this.f4261e.getWindow();
        C3250h.m9053a((Object) window, "activity.window");
        View decorView = window.getDecorView();
        int i = 0;
        if (decorView != null && Build.VERSION.SDK_INT >= 23) {
            WindowInsets rootWindowInsets = decorView.getRootWindowInsets();
            if (Build.VERSION.SDK_INT >= 28) {
                C3250h.m9053a((Object) rootWindowInsets, "windowInsets");
                DisplayCutout displayCutout = rootWindowInsets.getDisplayCutout();
                if (displayCutout != null) {
                    for (Rect next : displayCutout.getBoundingRects()) {
                        if (next.top == 0) {
                            i += next.bottom - next.top;
                        }
                    }
                }
            }
        }
        return i;
    }

    /* renamed from: a */
    public final void mo6886a() {
        C3292a.m9103a("onResume", new Object[0]);
        this.f4258b = this.f4261e.findViewById(16908290);
        View view = this.f4258b;
        if (view != null) {
            view.post(new C1425c(this));
        }
    }

    /* renamed from: a */
    public final void mo6887a(@NotNull C1423a aVar) {
        C3250h.m9056b(aVar, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER);
        this.f4260d.add(aVar);
    }
}
