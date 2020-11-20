package androidx.viewpager2.p058a;

import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.p058a.C1166f;
import java.util.Locale;

/* renamed from: androidx.viewpager2.a.e */
final class C1164e extends RecyclerView.C1031n {

    /* renamed from: a */
    private C1166f.C1168b f3644a;

    /* renamed from: b */
    private final C1166f f3645b;

    /* renamed from: c */
    private final RecyclerView f3646c;

    /* renamed from: d */
    private final LinearLayoutManager f3647d;

    /* renamed from: e */
    private int f3648e;

    /* renamed from: f */
    private int f3649f;

    /* renamed from: g */
    private C1165a f3650g;

    /* renamed from: h */
    private int f3651h;

    /* renamed from: i */
    private int f3652i;

    /* renamed from: j */
    private boolean f3653j;

    /* renamed from: k */
    private boolean f3654k;

    /* renamed from: l */
    private boolean f3655l;

    /* renamed from: m */
    private boolean f3656m;

    /* renamed from: androidx.viewpager2.a.e$a */
    private static final class C1165a {

        /* renamed from: a */
        int f3657a;

        /* renamed from: b */
        float f3658b;

        /* renamed from: c */
        int f3659c;

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo6265a() {
            this.f3657a = -1;
            this.f3658b = 0.0f;
            this.f3659c = 0;
        }
    }

    /* renamed from: a */
    private void m4608a(int i) {
        if ((this.f3648e != 3 || this.f3649f != 0) && this.f3649f != i) {
            this.f3649f = i;
            C1166f.C1168b bVar = this.f3644a;
            if (bVar != null) {
                bVar.onPageScrollStateChanged(i);
            }
        }
    }

    /* renamed from: a */
    private void m4609a(int i, float f, int i2) {
        C1166f.C1168b bVar = this.f3644a;
        if (bVar != null) {
            bVar.onPageScrolled(i, f, i2);
        }
    }

    /* renamed from: a */
    private void m4610a(boolean z) {
        this.f3656m = z;
        this.f3648e = z ? 4 : 1;
        int i = this.f3652i;
        if (i != -1) {
            this.f3651h = i;
            this.f3652i = -1;
        } else if (this.f3651h == -1) {
            this.f3651h = m4615h();
        }
        m4608a(1);
    }

    /* renamed from: b */
    private void m4611b(int i) {
        C1166f.C1168b bVar = this.f3644a;
        if (bVar != null) {
            bVar.onPageSelected(i);
        }
    }

    /* renamed from: e */
    private void m4612e() {
        this.f3648e = 0;
        this.f3649f = 0;
        this.f3650g.mo6265a();
        this.f3651h = -1;
        this.f3652i = -1;
        this.f3653j = false;
        this.f3654k = false;
        this.f3656m = false;
        this.f3655l = false;
    }

    /* renamed from: f */
    private void m4613f() {
        int i;
        C1165a aVar = this.f3650g;
        aVar.f3657a = this.f3647d.findFirstVisibleItemPosition();
        if (aVar.f3657a == -1) {
            aVar.mo6265a();
            return;
        }
        View findViewByPosition = this.f3647d.findViewByPosition(aVar.f3657a);
        if (findViewByPosition == null) {
            aVar.mo6265a();
            return;
        }
        int leftDecorationWidth = this.f3647d.getLeftDecorationWidth(findViewByPosition);
        int rightDecorationWidth = this.f3647d.getRightDecorationWidth(findViewByPosition);
        int topDecorationHeight = this.f3647d.getTopDecorationHeight(findViewByPosition);
        int bottomDecorationHeight = this.f3647d.getBottomDecorationHeight(findViewByPosition);
        ViewGroup.LayoutParams layoutParams = findViewByPosition.getLayoutParams();
        if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
            leftDecorationWidth += marginLayoutParams.leftMargin;
            rightDecorationWidth += marginLayoutParams.rightMargin;
            topDecorationHeight += marginLayoutParams.topMargin;
            bottomDecorationHeight += marginLayoutParams.bottomMargin;
        }
        int height = findViewByPosition.getHeight() + topDecorationHeight + bottomDecorationHeight;
        int width = rightDecorationWidth + findViewByPosition.getWidth() + leftDecorationWidth;
        if (this.f3647d.getOrientation() == 0) {
            i = (findViewByPosition.getLeft() - leftDecorationWidth) - this.f3646c.getPaddingLeft();
            if (this.f3645b.mo6271b()) {
                i = -i;
            }
        } else {
            i = (findViewByPosition.getTop() - topDecorationHeight) - this.f3646c.getPaddingTop();
            width = height;
        }
        aVar.f3659c = -i;
        if (aVar.f3659c >= 0) {
            aVar.f3658b = width == 0 ? 0.0f : ((float) aVar.f3659c) / ((float) width);
        } else if (new C1159a(this.f3647d).mo6249a()) {
            throw new IllegalStateException("Page(s) contain a ViewGroup with a LayoutTransition (or animateLayoutChanges=\"true\"), which interferes with the scrolling animation. Make sure to call getLayoutTransition().setAnimateParentHierarchy(false) on all ViewGroups with a LayoutTransition before an animation is started.");
        } else {
            throw new IllegalStateException(String.format(Locale.US, "Page can only be offset by a positive amount, not by %d", new Object[]{Integer.valueOf(aVar.f3659c)}));
        }
    }

    /* renamed from: g */
    private boolean m4614g() {
        int i = this.f3648e;
        return i == 1 || i == 4;
    }

    /* renamed from: h */
    private int m4615h() {
        return this.f3647d.findFirstVisibleItemPosition();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo6260a() {
        return this.f3649f;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6261a(int i, boolean z) {
        this.f3648e = z ? 2 : 3;
        boolean z2 = false;
        this.f3656m = false;
        if (this.f3652i != i) {
            z2 = true;
        }
        this.f3652i = i;
        m4608a(2);
        if (z2) {
            m4611b(i);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo6262b() {
        return this.f3649f == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo6263c() {
        return this.f3656m;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public double mo6264d() {
        m4613f();
        return ((double) this.f3650g.f3657a) + ((double) this.f3650g.f3658b);
    }

    public void onScrollStateChanged(RecyclerView recyclerView, int i) {
        boolean z = true;
        if (!(this.f3648e == 1 && this.f3649f == 1) && i == 1) {
            m4610a(false);
        } else if (!m4614g() || i != 2) {
            if (m4614g() && i == 0) {
                m4613f();
                if (!this.f3654k) {
                    if (this.f3650g.f3657a != -1) {
                        m4609a(this.f3650g.f3657a, 0.0f, 0);
                    }
                } else if (this.f3650g.f3659c != 0) {
                    z = false;
                } else if (this.f3651h != this.f3650g.f3657a) {
                    m4611b(this.f3650g.f3657a);
                }
                if (z) {
                    m4608a(0);
                    m4612e();
                }
            }
            if (this.f3648e == 2 && i == 0 && this.f3655l) {
                m4613f();
                if (this.f3650g.f3659c == 0) {
                    if (this.f3652i != this.f3650g.f3657a) {
                        m4611b(this.f3650g.f3657a == -1 ? 0 : this.f3650g.f3657a);
                    }
                    m4608a(0);
                    m4612e();
                }
            }
        } else if (this.f3654k) {
            m4608a(2);
            this.f3653j = true;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:9:0x001d, code lost:
        if ((r5 < 0) == r3.f3645b.mo6271b()) goto L_0x0022;
     */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x002b  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0031  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onScrolled(androidx.recyclerview.widget.RecyclerView r4, int r5, int r6) {
        /*
            r3 = this;
            r4 = 1
            r3.f3654k = r4
            r3.m4613f()
            boolean r0 = r3.f3653j
            r1 = -1
            r2 = 0
            if (r0 == 0) goto L_0x0041
            r3.f3653j = r2
            if (r6 > 0) goto L_0x0022
            if (r6 != 0) goto L_0x0020
            if (r5 >= 0) goto L_0x0016
            r5 = 1
            goto L_0x0017
        L_0x0016:
            r5 = 0
        L_0x0017:
            androidx.viewpager2.a.f r6 = r3.f3645b
            boolean r6 = r6.mo6271b()
            if (r5 != r6) goto L_0x0020
            goto L_0x0022
        L_0x0020:
            r5 = 0
            goto L_0x0023
        L_0x0022:
            r5 = 1
        L_0x0023:
            if (r5 == 0) goto L_0x0031
            androidx.viewpager2.a.e$a r5 = r3.f3650g
            int r5 = r5.f3659c
            if (r5 == 0) goto L_0x0031
            androidx.viewpager2.a.e$a r5 = r3.f3650g
            int r5 = r5.f3657a
            int r5 = r5 + r4
            goto L_0x0035
        L_0x0031:
            androidx.viewpager2.a.e$a r5 = r3.f3650g
            int r5 = r5.f3657a
        L_0x0035:
            r3.f3652i = r5
            int r5 = r3.f3651h
            int r6 = r3.f3652i
            if (r5 == r6) goto L_0x004f
            r3.m4611b(r6)
            goto L_0x004f
        L_0x0041:
            int r5 = r3.f3648e
            if (r5 != 0) goto L_0x004f
            androidx.viewpager2.a.e$a r5 = r3.f3650g
            int r5 = r5.f3657a
            if (r5 != r1) goto L_0x004c
            r5 = 0
        L_0x004c:
            r3.m4611b(r5)
        L_0x004f:
            androidx.viewpager2.a.e$a r5 = r3.f3650g
            int r5 = r5.f3657a
            if (r5 != r1) goto L_0x0057
            r5 = 0
            goto L_0x005b
        L_0x0057:
            androidx.viewpager2.a.e$a r5 = r3.f3650g
            int r5 = r5.f3657a
        L_0x005b:
            androidx.viewpager2.a.e$a r6 = r3.f3650g
            float r6 = r6.f3658b
            androidx.viewpager2.a.e$a r0 = r3.f3650g
            int r0 = r0.f3659c
            r3.m4609a(r5, r6, r0)
            androidx.viewpager2.a.e$a r5 = r3.f3650g
            int r5 = r5.f3657a
            int r6 = r3.f3652i
            if (r5 == r6) goto L_0x0070
            if (r6 != r1) goto L_0x0080
        L_0x0070:
            androidx.viewpager2.a.e$a r5 = r3.f3650g
            int r5 = r5.f3659c
            if (r5 != 0) goto L_0x0080
            int r5 = r3.f3649f
            if (r5 == r4) goto L_0x0080
            r3.m4608a((int) r2)
            r3.m4612e()
        L_0x0080:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.viewpager2.p058a.C1164e.onScrolled(androidx.recyclerview.widget.RecyclerView, int, int):void");
    }
}
