package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.database.DataSetObserver;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.C0203p;
import androidx.core.p030h.C0656u;
import androidx.core.widget.C0686h;
import java.lang.reflect.Method;

/* renamed from: androidx.appcompat.widget.ak */
public class C0268ak implements C0203p {

    /* renamed from: a */
    private static Method f966a;

    /* renamed from: b */
    private static Method f967b;

    /* renamed from: h */
    private static Method f968h;

    /* renamed from: A */
    private Drawable f969A;

    /* renamed from: B */
    private AdapterView.OnItemClickListener f970B;

    /* renamed from: C */
    private AdapterView.OnItemSelectedListener f971C;

    /* renamed from: D */
    private final C0274d f972D;

    /* renamed from: E */
    private final C0273c f973E;

    /* renamed from: F */
    private final C0271a f974F;

    /* renamed from: G */
    private Runnable f975G;

    /* renamed from: H */
    private final Rect f976H;

    /* renamed from: I */
    private Rect f977I;

    /* renamed from: J */
    private boolean f978J;

    /* renamed from: c */
    C0258ag f979c;

    /* renamed from: d */
    int f980d;

    /* renamed from: e */
    final C0275e f981e;

    /* renamed from: f */
    final Handler f982f;

    /* renamed from: g */
    PopupWindow f983g;

    /* renamed from: i */
    private Context f984i;

    /* renamed from: j */
    private ListAdapter f985j;

    /* renamed from: k */
    private int f986k;

    /* renamed from: l */
    private int f987l;

    /* renamed from: m */
    private int f988m;

    /* renamed from: n */
    private int f989n;

    /* renamed from: o */
    private int f990o;

    /* renamed from: p */
    private boolean f991p;

    /* renamed from: q */
    private boolean f992q;

    /* renamed from: r */
    private boolean f993r;

    /* renamed from: s */
    private boolean f994s;

    /* renamed from: t */
    private int f995t;

    /* renamed from: u */
    private boolean f996u;

    /* renamed from: v */
    private boolean f997v;

    /* renamed from: w */
    private View f998w;

    /* renamed from: x */
    private int f999x;

    /* renamed from: y */
    private DataSetObserver f1000y;

    /* renamed from: z */
    private View f1001z;

    /* renamed from: androidx.appcompat.widget.ak$a */
    private class C0271a implements Runnable {
        C0271a() {
        }

        public void run() {
            C0268ak.this.mo2222l();
        }
    }

    /* renamed from: androidx.appcompat.widget.ak$b */
    private class C0272b extends DataSetObserver {
        C0272b() {
        }

        public void onChanged() {
            if (C0268ak.this.mo1329c()) {
                C0268ak.this.mo1331j_();
            }
        }

        public void onInvalidated() {
            C0268ak.this.mo1325b();
        }
    }

    /* renamed from: androidx.appcompat.widget.ak$c */
    private class C0273c implements AbsListView.OnScrollListener {
        C0273c() {
        }

        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
        }

        public void onScrollStateChanged(AbsListView absListView, int i) {
            if (i == 1 && !C0268ak.this.mo2223m() && C0268ak.this.f983g.getContentView() != null) {
                C0268ak.this.f982f.removeCallbacks(C0268ak.this.f981e);
                C0268ak.this.f981e.run();
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ak$d */
    private class C0274d implements View.OnTouchListener {
        C0274d() {
        }

        public boolean onTouch(View view, MotionEvent motionEvent) {
            int action = motionEvent.getAction();
            int x = (int) motionEvent.getX();
            int y = (int) motionEvent.getY();
            if (action == 0 && C0268ak.this.f983g != null && C0268ak.this.f983g.isShowing() && x >= 0 && x < C0268ak.this.f983g.getWidth() && y >= 0 && y < C0268ak.this.f983g.getHeight()) {
                C0268ak.this.f982f.postDelayed(C0268ak.this.f981e, 250);
                return false;
            } else if (action != 1) {
                return false;
            } else {
                C0268ak.this.f982f.removeCallbacks(C0268ak.this.f981e);
                return false;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.ak$e */
    private class C0275e implements Runnable {
        C0275e() {
        }

        public void run() {
            if (C0268ak.this.f979c != null && C0656u.m2569B(C0268ak.this.f979c) && C0268ak.this.f979c.getCount() > C0268ak.this.f979c.getChildCount() && C0268ak.this.f979c.getChildCount() <= C0268ak.this.f980d) {
                C0268ak.this.f983g.setInputMethodMode(2);
                C0268ak.this.mo1331j_();
            }
        }
    }

    static {
        if (Build.VERSION.SDK_INT <= 28) {
            Class<PopupWindow> cls = PopupWindow.class;
            try {
                f966a = cls.getDeclaredMethod("setClipToScreenEnabled", new Class[]{Boolean.TYPE});
            } catch (NoSuchMethodException unused) {
                Log.i("ListPopupWindow", "Could not find method setClipToScreenEnabled() on PopupWindow. Oh well.");
            }
            try {
                f968h = PopupWindow.class.getDeclaredMethod("setEpicenterBounds", new Class[]{Rect.class});
            } catch (NoSuchMethodException unused2) {
                Log.i("ListPopupWindow", "Could not find method setEpicenterBounds(Rect) on PopupWindow. Oh well.");
            }
        }
        if (Build.VERSION.SDK_INT <= 23) {
            Class<PopupWindow> cls2 = PopupWindow.class;
            try {
                f967b = cls2.getDeclaredMethod("getMaxAvailableHeight", new Class[]{View.class, Integer.TYPE, Boolean.TYPE});
            } catch (NoSuchMethodException unused3) {
                Log.i("ListPopupWindow", "Could not find method getMaxAvailableHeight(View, int, boolean) on PopupWindow. Oh well.");
            }
        }
    }

    public C0268ak(Context context) {
        this(context, (AttributeSet) null, C0059a.C0060a.listPopupWindowStyle);
    }

    public C0268ak(Context context, AttributeSet attributeSet, int i) {
        this(context, attributeSet, i, 0);
    }

    public C0268ak(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f986k = -2;
        this.f987l = -2;
        this.f990o = 1002;
        this.f992q = true;
        this.f995t = 0;
        this.f996u = false;
        this.f997v = false;
        this.f980d = Integer.MAX_VALUE;
        this.f999x = 0;
        this.f981e = new C0275e();
        this.f972D = new C0274d();
        this.f973E = new C0273c();
        this.f974F = new C0271a();
        this.f976H = new Rect();
        this.f984i = context;
        this.f982f = new Handler(context.getMainLooper());
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.C0069j.ListPopupWindow, i, i2);
        this.f988m = obtainStyledAttributes.getDimensionPixelOffset(C0059a.C0069j.ListPopupWindow_android_dropDownHorizontalOffset, 0);
        this.f989n = obtainStyledAttributes.getDimensionPixelOffset(C0059a.C0069j.ListPopupWindow_android_dropDownVerticalOffset, 0);
        if (this.f989n != 0) {
            this.f991p = true;
        }
        obtainStyledAttributes.recycle();
        this.f983g = new C0345r(context, attributeSet, i, i2);
        this.f983g.setInputMethodMode(1);
    }

    /* renamed from: a */
    private int m944a(View view, int i, boolean z) {
        if (Build.VERSION.SDK_INT > 23) {
            return this.f983g.getMaxAvailableHeight(view, i, z);
        }
        Method method = f967b;
        if (method != null) {
            try {
                return ((Integer) method.invoke(this.f983g, new Object[]{view, Integer.valueOf(i), Boolean.valueOf(z)})).intValue();
            } catch (Exception unused) {
                Log.i("ListPopupWindow", "Could not call getMaxAvailableHeightMethod(View, int, boolean) on PopupWindow. Using the public version.");
            }
        }
        return this.f983g.getMaxAvailableHeight(view, i);
    }

    /* renamed from: c */
    private void mo2237c(boolean z) {
        if (Build.VERSION.SDK_INT <= 28) {
            Method method = f966a;
            if (method != null) {
                try {
                    method.invoke(this.f983g, new Object[]{Boolean.valueOf(z)});
                } catch (Exception unused) {
                    Log.i("ListPopupWindow", "Could not call setClipToScreenEnabled() on PopupWindow. Oh well.");
                }
            }
        } else {
            this.f983g.setIsClippedToScreen(z);
        }
    }

    /* renamed from: g */
    private void mo2672g() {
        View view = this.f998w;
        if (view != null) {
            ViewParent parent = view.getParent();
            if (parent instanceof ViewGroup) {
                ((ViewGroup) parent).removeView(this.f998w);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v24, resolved type: androidx.appcompat.widget.ag} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v25, resolved type: androidx.appcompat.widget.ag} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r7v2, resolved type: android.widget.LinearLayout} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v30, resolved type: androidx.appcompat.widget.ag} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: h */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private int mo2673h() {
        /*
            r12 = this;
            androidx.appcompat.widget.ag r0 = r12.f979c
            r1 = -2147483648(0xffffffff80000000, float:-0.0)
            r2 = -1
            r3 = 1
            r4 = 0
            if (r0 != 0) goto L_0x00c0
            android.content.Context r0 = r12.f984i
            androidx.appcompat.widget.ak$1 r5 = new androidx.appcompat.widget.ak$1
            r5.<init>()
            r12.f975G = r5
            boolean r5 = r12.f978J
            r5 = r5 ^ r3
            androidx.appcompat.widget.ag r5 = r12.mo2198a(r0, r5)
            r12.f979c = r5
            android.graphics.drawable.Drawable r5 = r12.f969A
            if (r5 == 0) goto L_0x0024
            androidx.appcompat.widget.ag r6 = r12.f979c
            r6.setSelector(r5)
        L_0x0024:
            androidx.appcompat.widget.ag r5 = r12.f979c
            android.widget.ListAdapter r6 = r12.f985j
            r5.setAdapter(r6)
            androidx.appcompat.widget.ag r5 = r12.f979c
            android.widget.AdapterView$OnItemClickListener r6 = r12.f970B
            r5.setOnItemClickListener(r6)
            androidx.appcompat.widget.ag r5 = r12.f979c
            r5.setFocusable(r3)
            androidx.appcompat.widget.ag r5 = r12.f979c
            r5.setFocusableInTouchMode(r3)
            androidx.appcompat.widget.ag r5 = r12.f979c
            androidx.appcompat.widget.ak$2 r6 = new androidx.appcompat.widget.ak$2
            r6.<init>()
            r5.setOnItemSelectedListener(r6)
            androidx.appcompat.widget.ag r5 = r12.f979c
            androidx.appcompat.widget.ak$c r6 = r12.f973E
            r5.setOnScrollListener(r6)
            android.widget.AdapterView$OnItemSelectedListener r5 = r12.f971C
            if (r5 == 0) goto L_0x0056
            androidx.appcompat.widget.ag r6 = r12.f979c
            r6.setOnItemSelectedListener(r5)
        L_0x0056:
            androidx.appcompat.widget.ag r5 = r12.f979c
            android.view.View r6 = r12.f998w
            if (r6 == 0) goto L_0x00b9
            android.widget.LinearLayout r7 = new android.widget.LinearLayout
            r7.<init>(r0)
            r7.setOrientation(r3)
            android.widget.LinearLayout$LayoutParams r0 = new android.widget.LinearLayout$LayoutParams
            r8 = 1065353216(0x3f800000, float:1.0)
            r0.<init>(r2, r4, r8)
            int r8 = r12.f999x
            switch(r8) {
                case 0: goto L_0x0090;
                case 1: goto L_0x0089;
                default: goto L_0x0070;
            }
        L_0x0070:
            java.lang.String r0 = "ListPopupWindow"
            java.lang.StringBuilder r5 = new java.lang.StringBuilder
            r5.<init>()
            java.lang.String r8 = "Invalid hint position "
            r5.append(r8)
            int r8 = r12.f999x
            r5.append(r8)
            java.lang.String r5 = r5.toString()
            android.util.Log.e(r0, r5)
            goto L_0x0096
        L_0x0089:
            r7.addView(r5, r0)
            r7.addView(r6)
            goto L_0x0096
        L_0x0090:
            r7.addView(r6)
            r7.addView(r5, r0)
        L_0x0096:
            int r0 = r12.f987l
            if (r0 < 0) goto L_0x009d
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            goto L_0x009f
        L_0x009d:
            r0 = 0
            r5 = 0
        L_0x009f:
            int r0 = android.view.View.MeasureSpec.makeMeasureSpec(r0, r5)
            r6.measure(r0, r4)
            android.view.ViewGroup$LayoutParams r0 = r6.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r0 = (android.widget.LinearLayout.LayoutParams) r0
            int r5 = r6.getMeasuredHeight()
            int r6 = r0.topMargin
            int r5 = r5 + r6
            int r0 = r0.bottomMargin
            int r5 = r5 + r0
            r0 = r5
            r5 = r7
            goto L_0x00ba
        L_0x00b9:
            r0 = 0
        L_0x00ba:
            android.widget.PopupWindow r6 = r12.f983g
            r6.setContentView(r5)
            goto L_0x00de
        L_0x00c0:
            android.widget.PopupWindow r0 = r12.f983g
            android.view.View r0 = r0.getContentView()
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            android.view.View r0 = r12.f998w
            if (r0 == 0) goto L_0x00dd
            android.view.ViewGroup$LayoutParams r5 = r0.getLayoutParams()
            android.widget.LinearLayout$LayoutParams r5 = (android.widget.LinearLayout.LayoutParams) r5
            int r0 = r0.getMeasuredHeight()
            int r6 = r5.topMargin
            int r0 = r0 + r6
            int r5 = r5.bottomMargin
            int r0 = r0 + r5
            goto L_0x00de
        L_0x00dd:
            r0 = 0
        L_0x00de:
            android.widget.PopupWindow r5 = r12.f983g
            android.graphics.drawable.Drawable r5 = r5.getBackground()
            if (r5 == 0) goto L_0x0100
            android.graphics.Rect r6 = r12.f976H
            r5.getPadding(r6)
            android.graphics.Rect r5 = r12.f976H
            int r5 = r5.top
            android.graphics.Rect r6 = r12.f976H
            int r6 = r6.bottom
            int r5 = r5 + r6
            boolean r6 = r12.f991p
            if (r6 != 0) goto L_0x0106
            android.graphics.Rect r6 = r12.f976H
            int r6 = r6.top
            int r6 = -r6
            r12.f989n = r6
            goto L_0x0106
        L_0x0100:
            android.graphics.Rect r5 = r12.f976H
            r5.setEmpty()
            r5 = 0
        L_0x0106:
            android.widget.PopupWindow r6 = r12.f983g
            int r6 = r6.getInputMethodMode()
            r7 = 2
            if (r6 != r7) goto L_0x0110
            goto L_0x0111
        L_0x0110:
            r3 = 0
        L_0x0111:
            android.view.View r4 = r12.mo2219j()
            int r6 = r12.f989n
            int r3 = r12.m944a(r4, r6, r3)
            boolean r4 = r12.f996u
            if (r4 != 0) goto L_0x0185
            int r4 = r12.f986k
            if (r4 != r2) goto L_0x0124
            goto L_0x0185
        L_0x0124:
            int r2 = r12.f987l
            r4 = 1073741824(0x40000000, float:2.0)
            switch(r2) {
                case -2: goto L_0x014c;
                case -1: goto L_0x0131;
                default: goto L_0x012b;
            }
        L_0x012b:
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r4)
        L_0x012f:
            r7 = r1
            goto L_0x0167
        L_0x0131:
            android.content.Context r1 = r12.f984i
            android.content.res.Resources r1 = r1.getResources()
            android.util.DisplayMetrics r1 = r1.getDisplayMetrics()
            int r1 = r1.widthPixels
            android.graphics.Rect r2 = r12.f976H
            int r2 = r2.left
            android.graphics.Rect r6 = r12.f976H
            int r6 = r6.right
            int r2 = r2 + r6
            int r1 = r1 - r2
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r1, r4)
            goto L_0x012f
        L_0x014c:
            android.content.Context r2 = r12.f984i
            android.content.res.Resources r2 = r2.getResources()
            android.util.DisplayMetrics r2 = r2.getDisplayMetrics()
            int r2 = r2.widthPixels
            android.graphics.Rect r4 = r12.f976H
            int r4 = r4.left
            android.graphics.Rect r6 = r12.f976H
            int r6 = r6.right
            int r4 = r4 + r6
            int r2 = r2 - r4
            int r1 = android.view.View.MeasureSpec.makeMeasureSpec(r2, r1)
            goto L_0x012f
        L_0x0167:
            androidx.appcompat.widget.ag r6 = r12.f979c
            r8 = 0
            r9 = -1
            int r10 = r3 - r0
            r11 = -1
            int r1 = r6.mo2132a(r7, r8, r9, r10, r11)
            if (r1 <= 0) goto L_0x0183
            androidx.appcompat.widget.ag r2 = r12.f979c
            int r2 = r2.getPaddingTop()
            androidx.appcompat.widget.ag r3 = r12.f979c
            int r3 = r3.getPaddingBottom()
            int r2 = r2 + r3
            int r5 = r5 + r2
            int r0 = r0 + r5
        L_0x0183:
            int r1 = r1 + r0
            return r1
        L_0x0185:
            int r3 = r3 + r5
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0268ak.mo2673h():int");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0258ag mo2198a(Context context, boolean z) {
        return new C0258ag(context, z);
    }

    /* renamed from: a */
    public void mo2199a(int i) {
        this.f989n = i;
        this.f991p = true;
    }

    /* renamed from: a */
    public void mo2200a(Rect rect) {
        this.f977I = rect != null ? new Rect(rect) : null;
    }

    /* renamed from: a */
    public void mo2201a(Drawable drawable) {
        this.f983g.setBackgroundDrawable(drawable);
    }

    /* renamed from: a */
    public void mo2202a(AdapterView.OnItemClickListener onItemClickListener) {
        this.f970B = onItemClickListener;
    }

    /* renamed from: a */
    public void mo2203a(ListAdapter listAdapter) {
        DataSetObserver dataSetObserver = this.f1000y;
        if (dataSetObserver == null) {
            this.f1000y = new C0272b();
        } else {
            ListAdapter listAdapter2 = this.f985j;
            if (listAdapter2 != null) {
                listAdapter2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f985j = listAdapter;
        if (listAdapter != null) {
            listAdapter.registerDataSetObserver(this.f1000y);
        }
        C0258ag agVar = this.f979c;
        if (agVar != null) {
            agVar.setAdapter(this.f985j);
        }
    }

    /* renamed from: a */
    public void mo2204a(PopupWindow.OnDismissListener onDismissListener) {
        this.f983g.setOnDismissListener(onDismissListener);
    }

    /* renamed from: a */
    public void mo2205a(boolean z) {
        this.f978J = z;
        this.f983g.setFocusable(z);
    }

    /* renamed from: b */
    public void mo1325b() {
        this.f983g.dismiss();
        mo2672g();
        this.f983g.setContentView((View) null);
        this.f979c = null;
        this.f982f.removeCallbacks(this.f981e);
    }

    /* renamed from: b */
    public void mo2206b(int i) {
        this.f988m = i;
    }

    /* renamed from: b */
    public void mo2207b(View view) {
        this.f1001z = view;
    }

    /* renamed from: b */
    public void mo2208b(boolean z) {
        this.f994s = true;
        this.f993r = z;
    }

    /* renamed from: c */
    public boolean mo1329c() {
        return this.f983g.isShowing();
    }

    /* renamed from: d */
    public Drawable mo2209d() {
        return this.f983g.getBackground();
    }

    /* renamed from: d */
    public void mo2210d(int i) {
        this.f999x = i;
    }

    /* renamed from: e */
    public int mo2211e() {
        if (!this.f991p) {
            return 0;
        }
        return this.f989n;
    }

    /* renamed from: e */
    public void mo2212e(int i) {
        this.f983g.setAnimationStyle(i);
    }

    /* renamed from: f */
    public int mo2213f() {
        return this.f988m;
    }

    /* renamed from: f */
    public void mo2214f(int i) {
        this.f995t = i;
    }

    /* renamed from: g */
    public void mo2215g(int i) {
        this.f987l = i;
    }

    /* renamed from: h */
    public void mo2216h(int i) {
        Drawable background = this.f983g.getBackground();
        if (background != null) {
            background.getPadding(this.f976H);
            this.f987l = this.f976H.left + this.f976H.right + i;
            return;
        }
        mo2215g(i);
    }

    /* renamed from: i */
    public void mo2217i(int i) {
        this.f983g.setInputMethodMode(i);
    }

    /* renamed from: i */
    public boolean mo2218i() {
        return this.f978J;
    }

    /* renamed from: j */
    public View mo2219j() {
        return this.f1001z;
    }

    /* renamed from: j */
    public void mo2220j(int i) {
        C0258ag agVar = this.f979c;
        if (mo1329c() && agVar != null) {
            agVar.setListSelectionHidden(false);
            agVar.setSelection(i);
            if (agVar.getChoiceMode() != 0) {
                agVar.setItemChecked(i, true);
            }
        }
    }

    /* renamed from: j_ */
    public void mo1331j_() {
        int h = mo2673h();
        boolean m = mo2223m();
        C0686h.m2798a(this.f983g, this.f990o);
        boolean z = true;
        if (!this.f983g.isShowing()) {
            int i = this.f987l;
            if (i == -1) {
                i = -1;
            } else if (i == -2) {
                i = mo2219j().getWidth();
            }
            int i2 = this.f986k;
            if (i2 == -1) {
                h = -1;
            } else if (i2 != -2) {
                h = i2;
            }
            this.f983g.setWidth(i);
            this.f983g.setHeight(h);
            mo2237c(true);
            this.f983g.setOutsideTouchable(!this.f997v && !this.f996u);
            this.f983g.setTouchInterceptor(this.f972D);
            if (this.f994s) {
                C0686h.m2800a(this.f983g, this.f993r);
            }
            if (Build.VERSION.SDK_INT <= 28) {
                Method method = f968h;
                if (method != null) {
                    try {
                        method.invoke(this.f983g, new Object[]{this.f977I});
                    } catch (Exception e) {
                        Log.e("ListPopupWindow", "Could not invoke setEpicenterBounds on PopupWindow", e);
                    }
                }
            } else {
                this.f983g.setEpicenterBounds(this.f977I);
            }
            C0686h.m2799a(this.f983g, mo2219j(), this.f988m, this.f989n, this.f995t);
            this.f979c.setSelection(-1);
            if (!this.f978J || this.f979c.isInTouchMode()) {
                mo2222l();
            }
            if (!this.f978J) {
                this.f982f.post(this.f974F);
            }
        } else if (C0656u.m2569B(mo2219j())) {
            int i3 = this.f987l;
            if (i3 == -1) {
                i3 = -1;
            } else if (i3 == -2) {
                i3 = mo2219j().getWidth();
            }
            int i4 = this.f986k;
            if (i4 == -1) {
                if (!m) {
                    h = -1;
                }
                if (m) {
                    this.f983g.setWidth(this.f987l == -1 ? -1 : 0);
                    this.f983g.setHeight(0);
                } else {
                    this.f983g.setWidth(this.f987l == -1 ? -1 : 0);
                    this.f983g.setHeight(-1);
                }
            } else if (i4 != -2) {
                h = i4;
            }
            PopupWindow popupWindow = this.f983g;
            if (this.f997v || this.f996u) {
                z = false;
            }
            popupWindow.setOutsideTouchable(z);
            this.f983g.update(mo2219j(), this.f988m, this.f989n, i3 < 0 ? -1 : i3, h < 0 ? -1 : h);
        }
    }

    /* renamed from: k */
    public int mo2221k() {
        return this.f987l;
    }

    /* renamed from: k_ */
    public ListView mo1332k_() {
        return this.f979c;
    }

    /* renamed from: l */
    public void mo2222l() {
        C0258ag agVar = this.f979c;
        if (agVar != null) {
            agVar.setListSelectionHidden(true);
            agVar.requestLayout();
        }
    }

    /* renamed from: m */
    public boolean mo2223m() {
        return this.f983g.getInputMethodMode() == 2;
    }
}
