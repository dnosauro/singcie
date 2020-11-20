package androidx.appcompat.view.menu;

import android.content.Context;
import android.graphics.Rect;
import android.view.View;
import android.widget.PopupWindow;
import androidx.appcompat.view.menu.C0198m;
import androidx.core.p030h.C0637c;
import androidx.core.p030h.C0656u;

/* renamed from: androidx.appcompat.view.menu.l */
public class C0196l {

    /* renamed from: a */
    private final Context f670a;

    /* renamed from: b */
    private final C0183g f671b;

    /* renamed from: c */
    private final boolean f672c;

    /* renamed from: d */
    private final int f673d;

    /* renamed from: e */
    private final int f674e;

    /* renamed from: f */
    private View f675f;

    /* renamed from: g */
    private int f676g;

    /* renamed from: h */
    private boolean f677h;

    /* renamed from: i */
    private C0198m.C0199a f678i;

    /* renamed from: j */
    private C0195k f679j;

    /* renamed from: k */
    private PopupWindow.OnDismissListener f680k;

    /* renamed from: l */
    private final PopupWindow.OnDismissListener f681l;

    public C0196l(Context context, C0183g gVar, View view, boolean z, int i) {
        this(context, gVar, view, z, i, 0);
    }

    public C0196l(Context context, C0183g gVar, View view, boolean z, int i, int i2) {
        this.f676g = 8388611;
        this.f681l = new PopupWindow.OnDismissListener() {
            public void onDismiss() {
                C0196l.this.mo1593e();
            }
        };
        this.f670a = context;
        this.f671b = gVar;
        this.f675f = view;
        this.f672c = z;
        this.f673d = i;
        this.f674e = i2;
    }

    /* renamed from: a */
    private void m657a(int i, int i2, boolean z, boolean z2) {
        C0195k b = mo1590b();
        b.mo1327b(z2);
        if (z) {
            if ((C0637c.m2519a(this.f676g, C0656u.m2621g(this.f675f)) & 7) == 5) {
                i -= this.f675f.getWidth();
            }
            b.mo1326b(i);
            b.mo1328c(i2);
            int i3 = (int) ((this.f670a.getResources().getDisplayMetrics().density * 48.0f) / 2.0f);
            b.mo1580a(new Rect(i - i3, i2 - i3, i + i3, i2 + i3));
        }
        b.mo1331j_();
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [androidx.appcompat.view.menu.k] */
    /* JADX WARNING: type inference failed for: r7v1, types: [androidx.appcompat.view.menu.q] */
    /* JADX WARNING: type inference failed for: r1v13, types: [androidx.appcompat.view.menu.d] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private androidx.appcompat.view.menu.C0195k m658g() {
        /*
            r14 = this;
            android.content.Context r0 = r14.f670a
            java.lang.String r1 = "window"
            java.lang.Object r0 = r0.getSystemService(r1)
            android.view.WindowManager r0 = (android.view.WindowManager) r0
            android.view.Display r0 = r0.getDefaultDisplay()
            android.graphics.Point r1 = new android.graphics.Point
            r1.<init>()
            int r2 = android.os.Build.VERSION.SDK_INT
            r3 = 17
            if (r2 < r3) goto L_0x001d
            r0.getRealSize(r1)
            goto L_0x0020
        L_0x001d:
            r0.getSize(r1)
        L_0x0020:
            int r0 = r1.x
            int r1 = r1.y
            int r0 = java.lang.Math.min(r0, r1)
            android.content.Context r1 = r14.f670a
            android.content.res.Resources r1 = r1.getResources()
            int r2 = androidx.appcompat.C0059a.C0063d.abc_cascading_menus_min_smallest_width
            int r1 = r1.getDimensionPixelSize(r2)
            if (r0 < r1) goto L_0x0038
            r0 = 1
            goto L_0x0039
        L_0x0038:
            r0 = 0
        L_0x0039:
            if (r0 == 0) goto L_0x004c
            androidx.appcompat.view.menu.d r0 = new androidx.appcompat.view.menu.d
            android.content.Context r2 = r14.f670a
            android.view.View r3 = r14.f675f
            int r4 = r14.f673d
            int r5 = r14.f674e
            boolean r6 = r14.f672c
            r1 = r0
            r1.<init>(r2, r3, r4, r5, r6)
            goto L_0x005e
        L_0x004c:
            androidx.appcompat.view.menu.q r0 = new androidx.appcompat.view.menu.q
            android.content.Context r8 = r14.f670a
            androidx.appcompat.view.menu.g r9 = r14.f671b
            android.view.View r10 = r14.f675f
            int r11 = r14.f673d
            int r12 = r14.f674e
            boolean r13 = r14.f672c
            r7 = r0
            r7.<init>(r8, r9, r10, r11, r12, r13)
        L_0x005e:
            androidx.appcompat.view.menu.g r1 = r14.f671b
            r0.mo1323a((androidx.appcompat.view.menu.C0183g) r1)
            android.widget.PopupWindow$OnDismissListener r1 = r14.f681l
            r0.mo1322a((android.widget.PopupWindow.OnDismissListener) r1)
            android.view.View r1 = r14.f675f
            r0.mo1321a((android.view.View) r1)
            androidx.appcompat.view.menu.m$a r1 = r14.f678i
            r0.setCallback(r1)
            boolean r1 = r14.f677h
            r0.mo1324a((boolean) r1)
            int r1 = r14.f676g
            r0.mo1320a((int) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.C0196l.m658g():androidx.appcompat.view.menu.k");
    }

    /* renamed from: a */
    public void mo1583a() {
        if (!mo1591c()) {
            throw new IllegalStateException("MenuPopupHelper cannot be used without an anchor");
        }
    }

    /* renamed from: a */
    public void mo1584a(int i) {
        this.f676g = i;
    }

    /* renamed from: a */
    public void mo1585a(View view) {
        this.f675f = view;
    }

    /* renamed from: a */
    public void mo1586a(PopupWindow.OnDismissListener onDismissListener) {
        this.f680k = onDismissListener;
    }

    /* renamed from: a */
    public void mo1587a(C0198m.C0199a aVar) {
        this.f678i = aVar;
        C0195k kVar = this.f679j;
        if (kVar != null) {
            kVar.setCallback(aVar);
        }
    }

    /* renamed from: a */
    public void mo1588a(boolean z) {
        this.f677h = z;
        C0195k kVar = this.f679j;
        if (kVar != null) {
            kVar.mo1324a(z);
        }
    }

    /* renamed from: a */
    public boolean mo1589a(int i, int i2) {
        if (mo1594f()) {
            return true;
        }
        if (this.f675f == null) {
            return false;
        }
        m657a(i, i2, true, true);
        return true;
    }

    /* renamed from: b */
    public C0195k mo1590b() {
        if (this.f679j == null) {
            this.f679j = m658g();
        }
        return this.f679j;
    }

    /* renamed from: c */
    public boolean mo1591c() {
        if (mo1594f()) {
            return true;
        }
        if (this.f675f == null) {
            return false;
        }
        m657a(0, 0, false, false);
        return true;
    }

    /* renamed from: d */
    public void mo1592d() {
        if (mo1594f()) {
            this.f679j.mo1325b();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public void mo1593e() {
        this.f679j = null;
        PopupWindow.OnDismissListener onDismissListener = this.f680k;
        if (onDismissListener != null) {
            onDismissListener.onDismiss();
        }
    }

    /* renamed from: f */
    public boolean mo1594f() {
        C0195k kVar = this.f679j;
        return kVar != null && kVar.mo1329c();
    }
}
