package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.ContextThemeWrapper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewDebug;
import android.view.ViewGroup;
import android.view.accessibility.AccessibilityEvent;
import androidx.appcompat.view.menu.ActionMenuItemView;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.view.menu.C0187i;
import androidx.appcompat.view.menu.C0198m;
import androidx.appcompat.view.menu.C0200n;
import androidx.appcompat.widget.C0266aj;

public class ActionMenuView extends C0266aj implements C0183g.C0185b, C0200n {

    /* renamed from: a */
    C0183g.C0184a f762a;

    /* renamed from: b */
    C0219e f763b;

    /* renamed from: c */
    private C0183g f764c;

    /* renamed from: d */
    private Context f765d;

    /* renamed from: e */
    private int f766e;

    /* renamed from: f */
    private boolean f767f;

    /* renamed from: g */
    private C0315c f768g;

    /* renamed from: h */
    private C0198m.C0199a f769h;

    /* renamed from: i */
    private boolean f770i;

    /* renamed from: j */
    private int f771j;

    /* renamed from: k */
    private int f772k;

    /* renamed from: l */
    private int f773l;

    /* renamed from: androidx.appcompat.widget.ActionMenuView$a */
    public interface C0215a {
        /* renamed from: b */
        boolean mo1200b();

        /* renamed from: c */
        boolean mo1201c();
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$b */
    private static class C0216b implements C0198m.C0199a {
        C0216b() {
        }

        /* renamed from: a */
        public void mo914a(C0183g gVar, boolean z) {
        }

        /* renamed from: a */
        public boolean mo915a(C0183g gVar) {
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$c */
    public static class C0217c extends C0266aj.C0267a {
        @ViewDebug.ExportedProperty

        /* renamed from: a */
        public boolean f774a;
        @ViewDebug.ExportedProperty

        /* renamed from: b */
        public int f775b;
        @ViewDebug.ExportedProperty

        /* renamed from: c */
        public int f776c;
        @ViewDebug.ExportedProperty

        /* renamed from: d */
        public boolean f777d;
        @ViewDebug.ExportedProperty

        /* renamed from: e */
        public boolean f778e;

        /* renamed from: f */
        boolean f779f;

        public C0217c(int i, int i2) {
            super(i, i2);
            this.f774a = false;
        }

        public C0217c(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public C0217c(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public C0217c(C0217c cVar) {
            super(cVar);
            this.f774a = cVar.f774a;
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$d */
    private class C0218d implements C0183g.C0184a {
        C0218d() {
        }

        public boolean onMenuItemSelected(C0183g gVar, MenuItem menuItem) {
            return ActionMenuView.this.f763b != null && ActionMenuView.this.f763b.mo1778a(menuItem);
        }

        public void onMenuModeChange(C0183g gVar) {
            if (ActionMenuView.this.f762a != null) {
                ActionMenuView.this.f762a.onMenuModeChange(gVar);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ActionMenuView$e */
    public interface C0219e {
        /* renamed from: a */
        boolean mo1778a(MenuItem menuItem);
    }

    public ActionMenuView(Context context) {
        this(context, (AttributeSet) null);
    }

    public ActionMenuView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        setBaselineAligned(false);
        float f = context.getResources().getDisplayMetrics().density;
        this.f772k = (int) (56.0f * f);
        this.f773l = (int) (f * 4.0f);
        this.f765d = context;
        this.f766e = 0;
    }

    /* renamed from: a */
    static int m727a(View view, int i, int i2, int i3, int i4) {
        C0217c cVar = (C0217c) view.getLayoutParams();
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(View.MeasureSpec.getSize(i3) - i4, View.MeasureSpec.getMode(i3));
        ActionMenuItemView actionMenuItemView = view instanceof ActionMenuItemView ? (ActionMenuItemView) view : null;
        boolean z = true;
        boolean z2 = actionMenuItemView != null && actionMenuItemView.mo1199a();
        int i5 = 2;
        if (i2 <= 0 || (z2 && i2 < 2)) {
            i5 = 0;
        } else {
            view.measure(View.MeasureSpec.makeMeasureSpec(i2 * i, Integer.MIN_VALUE), makeMeasureSpec);
            int measuredWidth = view.getMeasuredWidth();
            int i6 = measuredWidth / i;
            if (measuredWidth % i != 0) {
                i6++;
            }
            if (!z2 || i6 >= 2) {
                i5 = i6;
            }
        }
        if (cVar.f774a || !z2) {
            z = false;
        }
        cVar.f777d = z;
        cVar.f775b = i5;
        view.measure(View.MeasureSpec.makeMeasureSpec(i * i5, 1073741824), makeMeasureSpec);
        return i5;
    }

    /* JADX WARNING: Removed duplicated region for block: B:135:0x023e A[LOOP:5: B:135:0x023e->B:139:0x025d, LOOP_START, PHI: r13 
      PHI: (r13v3 int) = (r13v2 int), (r13v4 int) binds: [B:134:0x023c, B:139:0x025d] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARNING: Removed duplicated region for block: B:141:0x0262  */
    /* JADX WARNING: Removed duplicated region for block: B:142:0x0265  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m728a(int r30, int r31) {
        /*
            r29 = this;
            r0 = r29
            int r1 = android.view.View.MeasureSpec.getMode(r31)
            int r2 = android.view.View.MeasureSpec.getSize(r30)
            int r3 = android.view.View.MeasureSpec.getSize(r31)
            int r4 = r29.getPaddingLeft()
            int r5 = r29.getPaddingRight()
            int r4 = r4 + r5
            int r5 = r29.getPaddingTop()
            int r6 = r29.getPaddingBottom()
            int r5 = r5 + r6
            r6 = -2
            r7 = r31
            int r6 = getChildMeasureSpec(r7, r5, r6)
            int r2 = r2 - r4
            int r4 = r0.f772k
            int r7 = r2 / r4
            int r8 = r2 % r4
            r9 = 0
            if (r7 != 0) goto L_0x0035
            r0.setMeasuredDimension(r2, r9)
            return
        L_0x0035:
            int r8 = r8 / r7
            int r4 = r4 + r8
            int r8 = r29.getChildCount()
            r14 = r7
            r7 = 0
            r10 = 0
            r12 = 0
            r13 = 0
            r15 = 0
            r16 = 0
            r17 = 0
        L_0x0045:
            if (r7 >= r8) goto L_0x00c5
            android.view.View r11 = r0.getChildAt(r7)
            int r9 = r11.getVisibility()
            r19 = r3
            r3 = 8
            if (r9 != r3) goto L_0x0057
            goto L_0x00bf
        L_0x0057:
            boolean r3 = r11 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            int r13 = r13 + 1
            if (r3 == 0) goto L_0x0066
            int r9 = r0.f773l
            r20 = r13
            r13 = 0
            r11.setPadding(r9, r13, r9, r13)
            goto L_0x0069
        L_0x0066:
            r20 = r13
            r13 = 0
        L_0x0069:
            android.view.ViewGroup$LayoutParams r9 = r11.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r9 = (androidx.appcompat.widget.ActionMenuView.C0217c) r9
            r9.f779f = r13
            r9.f776c = r13
            r9.f775b = r13
            r9.f777d = r13
            r9.leftMargin = r13
            r9.rightMargin = r13
            if (r3 == 0) goto L_0x0088
            r3 = r11
            androidx.appcompat.view.menu.ActionMenuItemView r3 = (androidx.appcompat.view.menu.ActionMenuItemView) r3
            boolean r3 = r3.mo1199a()
            if (r3 == 0) goto L_0x0088
            r3 = 1
            goto L_0x0089
        L_0x0088:
            r3 = 0
        L_0x0089:
            r9.f778e = r3
            boolean r3 = r9.f774a
            if (r3 == 0) goto L_0x0091
            r3 = 1
            goto L_0x0092
        L_0x0091:
            r3 = r14
        L_0x0092:
            int r3 = m727a(r11, r4, r3, r6, r5)
            int r13 = java.lang.Math.max(r15, r3)
            boolean r15 = r9.f777d
            if (r15 == 0) goto L_0x00a0
            int r16 = r16 + 1
        L_0x00a0:
            boolean r9 = r9.f774a
            if (r9 == 0) goto L_0x00a5
            r12 = 1
        L_0x00a5:
            int r14 = r14 - r3
            int r9 = r11.getMeasuredHeight()
            int r10 = java.lang.Math.max(r10, r9)
            r9 = 1
            if (r3 != r9) goto L_0x00bb
            int r3 = r9 << r7
            r11 = r10
            long r9 = (long) r3
            long r9 = r17 | r9
            r17 = r9
            r10 = r11
            goto L_0x00bc
        L_0x00bb:
            r11 = r10
        L_0x00bc:
            r15 = r13
            r13 = r20
        L_0x00bf:
            int r7 = r7 + 1
            r3 = r19
            r9 = 0
            goto L_0x0045
        L_0x00c5:
            r19 = r3
            r3 = 2
            if (r12 == 0) goto L_0x00ce
            if (r13 != r3) goto L_0x00ce
            r5 = 1
            goto L_0x00cf
        L_0x00ce:
            r5 = 0
        L_0x00cf:
            r7 = 0
        L_0x00d0:
            r20 = 1
            if (r16 <= 0) goto L_0x0175
            if (r14 <= 0) goto L_0x0175
            r9 = 2147483647(0x7fffffff, float:NaN)
            r3 = 2147483647(0x7fffffff, float:NaN)
            r9 = 0
            r11 = 0
            r22 = 0
        L_0x00e0:
            if (r9 >= r8) goto L_0x0114
            android.view.View r24 = r0.getChildAt(r9)
            android.view.ViewGroup$LayoutParams r24 = r24.getLayoutParams()
            r25 = r7
            r7 = r24
            androidx.appcompat.widget.ActionMenuView$c r7 = (androidx.appcompat.widget.ActionMenuView.C0217c) r7
            r24 = r10
            boolean r10 = r7.f777d
            if (r10 != 0) goto L_0x00f7
            goto L_0x010d
        L_0x00f7:
            int r10 = r7.f775b
            if (r10 >= r3) goto L_0x0103
            int r3 = r7.f775b
            long r10 = r20 << r9
            r22 = r10
            r11 = 1
            goto L_0x010d
        L_0x0103:
            int r7 = r7.f775b
            if (r7 != r3) goto L_0x010d
            long r26 = r20 << r9
            long r22 = r22 | r26
            int r11 = r11 + 1
        L_0x010d:
            int r9 = r9 + 1
            r10 = r24
            r7 = r25
            goto L_0x00e0
        L_0x0114:
            r25 = r7
            r24 = r10
            long r17 = r17 | r22
            if (r11 <= r14) goto L_0x0120
            r11 = r1
            r26 = r2
            goto L_0x017c
        L_0x0120:
            int r3 = r3 + 1
            r7 = 0
        L_0x0123:
            if (r7 >= r8) goto L_0x016f
            android.view.View r9 = r0.getChildAt(r7)
            android.view.ViewGroup$LayoutParams r10 = r9.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r10 = (androidx.appcompat.widget.ActionMenuView.C0217c) r10
            r26 = r2
            r11 = 1
            int r2 = r11 << r7
            r11 = r1
            long r1 = (long) r2
            long r20 = r22 & r1
            r27 = 0
            int r25 = (r20 > r27 ? 1 : (r20 == r27 ? 0 : -1))
            if (r25 != 0) goto L_0x0147
            int r9 = r10.f775b
            if (r9 != r3) goto L_0x0144
            long r17 = r17 | r1
        L_0x0144:
            r20 = r3
            goto L_0x0167
        L_0x0147:
            if (r5 == 0) goto L_0x015b
            boolean r1 = r10.f778e
            if (r1 == 0) goto L_0x015b
            r1 = 1
            if (r14 != r1) goto L_0x015b
            int r2 = r0.f773l
            int r1 = r2 + r4
            r20 = r3
            r3 = 0
            r9.setPadding(r1, r3, r2, r3)
            goto L_0x015d
        L_0x015b:
            r20 = r3
        L_0x015d:
            int r1 = r10.f775b
            r2 = 1
            int r1 = r1 + r2
            r10.f775b = r1
            r10.f779f = r2
            int r14 = r14 + -1
        L_0x0167:
            int r7 = r7 + 1
            r1 = r11
            r3 = r20
            r2 = r26
            goto L_0x0123
        L_0x016f:
            r10 = r24
            r3 = 2
            r7 = 1
            goto L_0x00d0
        L_0x0175:
            r11 = r1
            r26 = r2
            r25 = r7
            r24 = r10
        L_0x017c:
            if (r12 != 0) goto L_0x0183
            r1 = 1
            if (r13 != r1) goto L_0x0184
            r2 = 1
            goto L_0x0185
        L_0x0183:
            r1 = 1
        L_0x0184:
            r2 = 0
        L_0x0185:
            if (r14 <= 0) goto L_0x0239
            r9 = 0
            int r3 = (r17 > r9 ? 1 : (r17 == r9 ? 0 : -1))
            if (r3 == 0) goto L_0x0239
            int r13 = r13 - r1
            if (r14 < r13) goto L_0x0194
            if (r2 != 0) goto L_0x0194
            if (r15 <= r1) goto L_0x0239
        L_0x0194:
            int r1 = java.lang.Long.bitCount(r17)
            float r1 = (float) r1
            if (r2 != 0) goto L_0x01d5
            long r2 = r17 & r20
            r5 = 1056964608(0x3f000000, float:0.5)
            r9 = 0
            int r7 = (r2 > r9 ? 1 : (r2 == r9 ? 0 : -1))
            if (r7 == 0) goto L_0x01b6
            r13 = 0
            android.view.View r2 = r0.getChildAt(r13)
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r2 = (androidx.appcompat.widget.ActionMenuView.C0217c) r2
            boolean r2 = r2.f778e
            if (r2 != 0) goto L_0x01b7
            float r1 = r1 - r5
            goto L_0x01b7
        L_0x01b6:
            r13 = 0
        L_0x01b7:
            int r2 = r8 + -1
            r3 = 1
            int r7 = r3 << r2
            long r9 = (long) r7
            long r9 = r17 & r9
            r15 = 0
            int r3 = (r9 > r15 ? 1 : (r9 == r15 ? 0 : -1))
            if (r3 == 0) goto L_0x01d6
            android.view.View r2 = r0.getChildAt(r2)
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r2 = (androidx.appcompat.widget.ActionMenuView.C0217c) r2
            boolean r2 = r2.f778e
            if (r2 != 0) goto L_0x01d6
            float r1 = r1 - r5
            goto L_0x01d6
        L_0x01d5:
            r13 = 0
        L_0x01d6:
            r2 = 0
            int r2 = (r1 > r2 ? 1 : (r1 == r2 ? 0 : -1))
            if (r2 <= 0) goto L_0x01e1
            int r14 = r14 * r4
            float r2 = (float) r14
            float r2 = r2 / r1
            int r9 = (int) r2
            goto L_0x01e2
        L_0x01e1:
            r9 = 0
        L_0x01e2:
            r1 = 0
        L_0x01e3:
            if (r1 >= r8) goto L_0x023a
            r2 = 1
            int r3 = r2 << r1
            long r2 = (long) r3
            long r2 = r17 & r2
            r14 = 0
            int r5 = (r2 > r14 ? 1 : (r2 == r14 ? 0 : -1))
            if (r5 != 0) goto L_0x01f4
            r2 = 1
            r5 = 2
            goto L_0x0236
        L_0x01f4:
            android.view.View r2 = r0.getChildAt(r1)
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r3 = (androidx.appcompat.widget.ActionMenuView.C0217c) r3
            boolean r2 = r2 instanceof androidx.appcompat.view.menu.ActionMenuItemView
            if (r2 == 0) goto L_0x0216
            r3.f776c = r9
            r2 = 1
            r3.f779f = r2
            if (r1 != 0) goto L_0x0213
            boolean r2 = r3.f778e
            if (r2 != 0) goto L_0x0213
            int r2 = -r9
            r5 = 2
            int r2 = r2 / r5
            r3.leftMargin = r2
            goto L_0x0214
        L_0x0213:
            r5 = 2
        L_0x0214:
            r2 = 1
            goto L_0x0224
        L_0x0216:
            r5 = 2
            boolean r2 = r3.f774a
            if (r2 == 0) goto L_0x0227
            r3.f776c = r9
            r2 = 1
            r3.f779f = r2
            int r7 = -r9
            int r7 = r7 / r5
            r3.rightMargin = r7
        L_0x0224:
            r25 = 1
            goto L_0x0236
        L_0x0227:
            r2 = 1
            if (r1 == 0) goto L_0x022e
            int r7 = r9 / 2
            r3.leftMargin = r7
        L_0x022e:
            int r7 = r8 + -1
            if (r1 == r7) goto L_0x0236
            int r7 = r9 / 2
            r3.rightMargin = r7
        L_0x0236:
            int r1 = r1 + 1
            goto L_0x01e3
        L_0x0239:
            r13 = 0
        L_0x023a:
            r1 = 1073741824(0x40000000, float:2.0)
            if (r25 == 0) goto L_0x0260
        L_0x023e:
            if (r13 >= r8) goto L_0x0260
            android.view.View r2 = r0.getChildAt(r13)
            android.view.ViewGroup$LayoutParams r3 = r2.getLayoutParams()
            androidx.appcompat.widget.ActionMenuView$c r3 = (androidx.appcompat.widget.ActionMenuView.C0217c) r3
            boolean r5 = r3.f779f
            if (r5 != 0) goto L_0x024f
            goto L_0x025d
        L_0x024f:
            int r5 = r3.f775b
            int r5 = r5 * r4
            int r3 = r3.f776c
            int r5 = r5 + r3
            int r3 = android.view.View.MeasureSpec.makeMeasureSpec(r5, r1)
            r2.measure(r3, r6)
        L_0x025d:
            int r13 = r13 + 1
            goto L_0x023e
        L_0x0260:
            if (r11 == r1) goto L_0x0265
            r1 = r24
            goto L_0x0267
        L_0x0265:
            r1 = r19
        L_0x0267:
            r2 = r26
            r0.setMeasuredDimension(r2, r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.ActionMenuView.m728a(int, int):void");
    }

    /* renamed from: a */
    public C0217c generateLayoutParams(AttributeSet attributeSet) {
        return new C0217c(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C0217c generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        if (layoutParams == null) {
            return generateDefaultLayoutParams();
        }
        C0217c cVar = layoutParams instanceof C0217c ? new C0217c((C0217c) layoutParams) : new C0217c(layoutParams);
        if (cVar.f965h <= 0) {
            cVar.f965h = 16;
        }
        return cVar;
    }

    /* renamed from: a */
    public void mo1748a(C0198m.C0199a aVar, C0183g.C0184a aVar2) {
        this.f769h = aVar;
        this.f762a = aVar2;
    }

    /* renamed from: a */
    public boolean mo1749a() {
        return this.f767f;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo1750a(int i) {
        boolean z = false;
        if (i == 0) {
            return false;
        }
        View childAt = getChildAt(i - 1);
        View childAt2 = getChildAt(i);
        if (i < getChildCount() && (childAt instanceof C0215a)) {
            z = false | ((C0215a) childAt).mo1201c();
        }
        return (i <= 0 || !(childAt2 instanceof C0215a)) ? z : z | ((C0215a) childAt2).mo1200b();
    }

    /* renamed from: a */
    public boolean mo1221a(C0187i iVar) {
        return this.f764c.performItemAction(iVar, 0);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C0217c generateDefaultLayoutParams() {
        C0217c cVar = new C0217c(-2, -2);
        cVar.f965h = 16;
        return cVar;
    }

    /* renamed from: c */
    public C0217c mo1752c() {
        C0217c b = generateDefaultLayoutParams();
        b.f774a = true;
        return b;
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof C0217c;
    }

    /* renamed from: d */
    public C0183g mo1754d() {
        return this.f764c;
    }

    public boolean dispatchPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        return false;
    }

    /* renamed from: e */
    public boolean mo1756e() {
        C0315c cVar = this.f768g;
        return cVar != null && cVar.mo2460c();
    }

    /* renamed from: f */
    public boolean mo1757f() {
        C0315c cVar = this.f768g;
        return cVar != null && cVar.mo2461d();
    }

    /* renamed from: g */
    public boolean mo1758g() {
        C0315c cVar = this.f768g;
        return cVar != null && cVar.mo2464g();
    }

    public Menu getMenu() {
        if (this.f764c == null) {
            Context context = getContext();
            this.f764c = new C0183g(context);
            this.f764c.setCallback(new C0218d());
            this.f768g = new C0315c(context);
            this.f768g.mo2456a(true);
            C0315c cVar = this.f768g;
            C0198m.C0199a aVar = this.f769h;
            if (aVar == null) {
                aVar = new C0216b();
            }
            cVar.setCallback(aVar);
            this.f764c.addMenuPresenter(this.f768g, this.f765d);
            this.f768g.mo2455a(this);
        }
        return this.f764c;
    }

    public Drawable getOverflowIcon() {
        getMenu();
        return this.f768g.mo2457b();
    }

    public int getPopupTheme() {
        return this.f766e;
    }

    public int getWindowAnimations() {
        return 0;
    }

    /* renamed from: h */
    public boolean mo1766h() {
        C0315c cVar = this.f768g;
        return cVar != null && cVar.mo2465h();
    }

    /* renamed from: i */
    public void mo1767i() {
        C0315c cVar = this.f768g;
        if (cVar != null) {
            cVar.mo2462e();
        }
    }

    public void initialize(C0183g gVar) {
        this.f764c = gVar;
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0315c cVar = this.f768g;
        if (cVar != null) {
            cVar.updateMenuView(false);
            if (this.f768g.mo2464g()) {
                this.f768g.mo2461d();
                this.f768g.mo2460c();
            }
        }
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        mo1767i();
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        if (!this.f770i) {
            super.onLayout(z, i, i2, i3, i4);
            return;
        }
        int childCount = getChildCount();
        int i9 = (i4 - i2) / 2;
        int dividerWidth = getDividerWidth();
        int i10 = i3 - i;
        int paddingRight = (i10 - getPaddingRight()) - getPaddingLeft();
        boolean a = C0313be.m1163a(this);
        int i11 = paddingRight;
        int i12 = 0;
        int i13 = 0;
        for (int i14 = 0; i14 < childCount; i14++) {
            View childAt = getChildAt(i14);
            if (childAt.getVisibility() != 8) {
                C0217c cVar = (C0217c) childAt.getLayoutParams();
                if (cVar.f774a) {
                    int measuredWidth = childAt.getMeasuredWidth();
                    if (mo1750a(i14)) {
                        measuredWidth += dividerWidth;
                    }
                    int measuredHeight = childAt.getMeasuredHeight();
                    if (a) {
                        i7 = getPaddingLeft() + cVar.leftMargin;
                        i8 = i7 + measuredWidth;
                    } else {
                        i8 = (getWidth() - getPaddingRight()) - cVar.rightMargin;
                        i7 = i8 - measuredWidth;
                    }
                    int i15 = i9 - (measuredHeight / 2);
                    childAt.layout(i7, i15, i8, measuredHeight + i15);
                    i11 -= measuredWidth;
                    i12 = 1;
                } else {
                    i11 -= (childAt.getMeasuredWidth() + cVar.leftMargin) + cVar.rightMargin;
                    boolean a2 = mo1750a(i14);
                    i13++;
                }
            }
        }
        if (childCount == 1 && i12 == 0) {
            View childAt2 = getChildAt(0);
            int measuredWidth2 = childAt2.getMeasuredWidth();
            int measuredHeight2 = childAt2.getMeasuredHeight();
            int i16 = (i10 / 2) - (measuredWidth2 / 2);
            int i17 = i9 - (measuredHeight2 / 2);
            childAt2.layout(i16, i17, measuredWidth2 + i16, measuredHeight2 + i17);
            return;
        }
        int i18 = i13 - (i12 ^ 1);
        if (i18 > 0) {
            i5 = i11 / i18;
            i6 = 0;
        } else {
            i6 = 0;
            i5 = 0;
        }
        int max = Math.max(i6, i5);
        if (a) {
            int width = getWidth() - getPaddingRight();
            while (i6 < childCount) {
                View childAt3 = getChildAt(i6);
                C0217c cVar2 = (C0217c) childAt3.getLayoutParams();
                if (childAt3.getVisibility() != 8 && !cVar2.f774a) {
                    int i19 = width - cVar2.rightMargin;
                    int measuredWidth3 = childAt3.getMeasuredWidth();
                    int measuredHeight3 = childAt3.getMeasuredHeight();
                    int i20 = i9 - (measuredHeight3 / 2);
                    childAt3.layout(i19 - measuredWidth3, i20, i19, measuredHeight3 + i20);
                    width = i19 - ((measuredWidth3 + cVar2.leftMargin) + max);
                }
                i6++;
            }
            return;
        }
        int paddingLeft = getPaddingLeft();
        while (i6 < childCount) {
            View childAt4 = getChildAt(i6);
            C0217c cVar3 = (C0217c) childAt4.getLayoutParams();
            if (childAt4.getVisibility() != 8 && !cVar3.f774a) {
                int i21 = paddingLeft + cVar3.leftMargin;
                int measuredWidth4 = childAt4.getMeasuredWidth();
                int measuredHeight4 = childAt4.getMeasuredHeight();
                int i22 = i9 - (measuredHeight4 / 2);
                childAt4.layout(i21, i22, i21 + measuredWidth4, measuredHeight4 + i22);
                paddingLeft = i21 + measuredWidth4 + cVar3.rightMargin + max;
            }
            i6++;
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        C0183g gVar;
        boolean z = this.f770i;
        this.f770i = View.MeasureSpec.getMode(i) == 1073741824;
        if (z != this.f770i) {
            this.f771j = 0;
        }
        int size = View.MeasureSpec.getSize(i);
        if (!(!this.f770i || (gVar = this.f764c) == null || size == this.f771j)) {
            this.f771j = size;
            gVar.onItemsChanged(true);
        }
        int childCount = getChildCount();
        if (!this.f770i || childCount <= 0) {
            for (int i3 = 0; i3 < childCount; i3++) {
                C0217c cVar = (C0217c) getChildAt(i3).getLayoutParams();
                cVar.rightMargin = 0;
                cVar.leftMargin = 0;
            }
            super.onMeasure(i, i2);
            return;
        }
        m728a(i, i2);
    }

    public void setExpandedActionViewsExclusive(boolean z) {
        this.f768g.mo2458b(z);
    }

    public void setOnMenuItemClickListener(C0219e eVar) {
        this.f763b = eVar;
    }

    public void setOverflowIcon(Drawable drawable) {
        getMenu();
        this.f768g.mo2454a(drawable);
    }

    public void setOverflowReserved(boolean z) {
        this.f767f = z;
    }

    public void setPopupTheme(int i) {
        if (this.f766e != i) {
            this.f766e = i;
            if (i == 0) {
                this.f765d = getContext();
            } else {
                this.f765d = new ContextThemeWrapper(getContext(), i);
            }
        }
    }

    public void setPresenter(C0315c cVar) {
        this.f768g = cVar;
        this.f768g.mo2455a(this);
    }
}
