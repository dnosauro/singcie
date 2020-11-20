package androidx.recyclerview.widget;

import android.graphics.Rect;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

/* renamed from: androidx.recyclerview.widget.j */
public abstract class C1086j {

    /* renamed from: a */
    protected final RecyclerView.C1022i f3444a;

    /* renamed from: b */
    final Rect f3445b;

    /* renamed from: c */
    private int f3446c;

    private C1086j(RecyclerView.C1022i iVar) {
        this.f3446c = Integer.MIN_VALUE;
        this.f3445b = new Rect();
        this.f3444a = iVar;
    }

    /* renamed from: a */
    public static C1086j m4263a(RecyclerView.C1022i iVar) {
        return new C1086j(iVar) {
            /* renamed from: a */
            public int mo6035a(View view) {
                return this.f3444a.getDecoratedLeft(view) - ((RecyclerView.C1027j) view.getLayoutParams()).leftMargin;
            }

            /* renamed from: a */
            public void mo6037a(int i) {
                this.f3444a.offsetChildrenHorizontal(i);
            }

            /* renamed from: b */
            public int mo6039b(View view) {
                return this.f3444a.getDecoratedRight(view) + ((RecyclerView.C1027j) view.getLayoutParams()).rightMargin;
            }

            /* renamed from: c */
            public int mo6040c() {
                return this.f3444a.getPaddingLeft();
            }

            /* renamed from: c */
            public int mo6041c(View view) {
                this.f3444a.getTransformedBoundingBox(view, true, this.f3445b);
                return this.f3445b.right;
            }

            /* renamed from: d */
            public int mo6042d() {
                return this.f3444a.getWidth() - this.f3444a.getPaddingRight();
            }

            /* renamed from: d */
            public int mo6043d(View view) {
                this.f3444a.getTransformedBoundingBox(view, true, this.f3445b);
                return this.f3445b.left;
            }

            /* renamed from: e */
            public int mo6044e() {
                return this.f3444a.getWidth();
            }

            /* renamed from: e */
            public int mo6045e(View view) {
                RecyclerView.C1027j jVar = (RecyclerView.C1027j) view.getLayoutParams();
                return this.f3444a.getDecoratedMeasuredWidth(view) + jVar.leftMargin + jVar.rightMargin;
            }

            /* renamed from: f */
            public int mo6046f() {
                return (this.f3444a.getWidth() - this.f3444a.getPaddingLeft()) - this.f3444a.getPaddingRight();
            }

            /* renamed from: f */
            public int mo6047f(View view) {
                RecyclerView.C1027j jVar = (RecyclerView.C1027j) view.getLayoutParams();
                return this.f3444a.getDecoratedMeasuredHeight(view) + jVar.topMargin + jVar.bottomMargin;
            }

            /* renamed from: g */
            public int mo6048g() {
                return this.f3444a.getPaddingRight();
            }

            /* renamed from: h */
            public int mo6049h() {
                return this.f3444a.getWidthMode();
            }

            /* renamed from: i */
            public int mo6050i() {
                return this.f3444a.getHeightMode();
            }
        };
    }

    /* renamed from: a */
    public static C1086j m4264a(RecyclerView.C1022i iVar, int i) {
        switch (i) {
            case 0:
                return m4263a(iVar);
            case 1:
                return m4265b(iVar);
            default:
                throw new IllegalArgumentException("invalid orientation");
        }
    }

    /* renamed from: b */
    public static C1086j m4265b(RecyclerView.C1022i iVar) {
        return new C1086j(iVar) {
            /* renamed from: a */
            public int mo6035a(View view) {
                return this.f3444a.getDecoratedTop(view) - ((RecyclerView.C1027j) view.getLayoutParams()).topMargin;
            }

            /* renamed from: a */
            public void mo6037a(int i) {
                this.f3444a.offsetChildrenVertical(i);
            }

            /* renamed from: b */
            public int mo6039b(View view) {
                return this.f3444a.getDecoratedBottom(view) + ((RecyclerView.C1027j) view.getLayoutParams()).bottomMargin;
            }

            /* renamed from: c */
            public int mo6040c() {
                return this.f3444a.getPaddingTop();
            }

            /* renamed from: c */
            public int mo6041c(View view) {
                this.f3444a.getTransformedBoundingBox(view, true, this.f3445b);
                return this.f3445b.bottom;
            }

            /* renamed from: d */
            public int mo6042d() {
                return this.f3444a.getHeight() - this.f3444a.getPaddingBottom();
            }

            /* renamed from: d */
            public int mo6043d(View view) {
                this.f3444a.getTransformedBoundingBox(view, true, this.f3445b);
                return this.f3445b.top;
            }

            /* renamed from: e */
            public int mo6044e() {
                return this.f3444a.getHeight();
            }

            /* renamed from: e */
            public int mo6045e(View view) {
                RecyclerView.C1027j jVar = (RecyclerView.C1027j) view.getLayoutParams();
                return this.f3444a.getDecoratedMeasuredHeight(view) + jVar.topMargin + jVar.bottomMargin;
            }

            /* renamed from: f */
            public int mo6046f() {
                return (this.f3444a.getHeight() - this.f3444a.getPaddingTop()) - this.f3444a.getPaddingBottom();
            }

            /* renamed from: f */
            public int mo6047f(View view) {
                RecyclerView.C1027j jVar = (RecyclerView.C1027j) view.getLayoutParams();
                return this.f3444a.getDecoratedMeasuredWidth(view) + jVar.leftMargin + jVar.rightMargin;
            }

            /* renamed from: g */
            public int mo6048g() {
                return this.f3444a.getPaddingBottom();
            }

            /* renamed from: h */
            public int mo6049h() {
                return this.f3444a.getHeightMode();
            }

            /* renamed from: i */
            public int mo6050i() {
                return this.f3444a.getWidthMode();
            }
        };
    }

    /* renamed from: a */
    public abstract int mo6035a(View view);

    /* renamed from: a */
    public void mo6036a() {
        this.f3446c = mo6046f();
    }

    /* renamed from: a */
    public abstract void mo6037a(int i);

    /* renamed from: b */
    public int mo6038b() {
        if (Integer.MIN_VALUE == this.f3446c) {
            return 0;
        }
        return mo6046f() - this.f3446c;
    }

    /* renamed from: b */
    public abstract int mo6039b(View view);

    /* renamed from: c */
    public abstract int mo6040c();

    /* renamed from: c */
    public abstract int mo6041c(View view);

    /* renamed from: d */
    public abstract int mo6042d();

    /* renamed from: d */
    public abstract int mo6043d(View view);

    /* renamed from: e */
    public abstract int mo6044e();

    /* renamed from: e */
    public abstract int mo6045e(View view);

    /* renamed from: f */
    public abstract int mo6046f();

    /* renamed from: f */
    public abstract int mo6047f(View view);

    /* renamed from: g */
    public abstract int mo6048g();

    /* renamed from: h */
    public abstract int mo6049h();

    /* renamed from: i */
    public abstract int mo6050i();
}
