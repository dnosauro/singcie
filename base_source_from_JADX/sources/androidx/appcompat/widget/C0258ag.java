package androidx.appcompat.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.ListAdapter;
import android.widget.ListView;
import androidx.appcompat.C0059a;
import androidx.appcompat.p011b.p012a.C0148c;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.p030h.C0668y;
import androidx.core.widget.C0684f;
import java.lang.reflect.Field;

/* renamed from: androidx.appcompat.widget.ag */
class C0258ag extends ListView {

    /* renamed from: a */
    C0260b f937a;

    /* renamed from: b */
    private final Rect f938b = new Rect();

    /* renamed from: c */
    private int f939c = 0;

    /* renamed from: d */
    private int f940d = 0;

    /* renamed from: e */
    private int f941e = 0;

    /* renamed from: f */
    private int f942f = 0;

    /* renamed from: g */
    private int f943g;

    /* renamed from: h */
    private Field f944h;

    /* renamed from: i */
    private C0259a f945i;

    /* renamed from: j */
    private boolean f946j;

    /* renamed from: k */
    private boolean f947k;

    /* renamed from: l */
    private boolean f948l;

    /* renamed from: m */
    private C0668y f949m;

    /* renamed from: n */
    private C0684f f950n;

    /* renamed from: androidx.appcompat.widget.ag$a */
    private static class C0259a extends C0148c {

        /* renamed from: a */
        private boolean f951a = true;

        C0259a(Drawable drawable) {
            super(drawable);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo2145a(boolean z) {
            this.f951a = z;
        }

        public void draw(Canvas canvas) {
            if (this.f951a) {
                super.draw(canvas);
            }
        }

        public void setHotspot(float f, float f2) {
            if (this.f951a) {
                super.setHotspot(f, f2);
            }
        }

        public void setHotspotBounds(int i, int i2, int i3, int i4) {
            if (this.f951a) {
                super.setHotspotBounds(i, i2, i3, i4);
            }
        }

        public boolean setState(int[] iArr) {
            if (this.f951a) {
                return super.setState(iArr);
            }
            return false;
        }

        public boolean setVisible(boolean z, boolean z2) {
            if (this.f951a) {
                return super.setVisible(z, z2);
            }
            return false;
        }
    }

    /* renamed from: androidx.appcompat.widget.ag$b */
    private class C0260b implements Runnable {
        C0260b() {
        }

        /* renamed from: a */
        public void mo2146a() {
            C0258ag agVar = C0258ag.this;
            agVar.f937a = null;
            agVar.removeCallbacks(this);
        }

        /* renamed from: b */
        public void mo2147b() {
            C0258ag.this.post(this);
        }

        public void run() {
            C0258ag agVar = C0258ag.this;
            agVar.f937a = null;
            agVar.drawableStateChanged();
        }
    }

    C0258ag(Context context, boolean z) {
        super(context, (AttributeSet) null, C0059a.C0060a.dropDownListViewStyle);
        this.f947k = z;
        setCacheColorHint(0);
        try {
            this.f944h = AbsListView.class.getDeclaredField("mIsChildViewEnabled");
            this.f944h.setAccessible(true);
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m919a() {
        Drawable selector = getSelector();
        if (selector != null && m927c() && isPressed()) {
            selector.setState(getDrawableState());
        }
    }

    /* renamed from: a */
    private void m920a(int i, View view) {
        Drawable selector = getSelector();
        boolean z = true;
        boolean z2 = (selector == null || i == -1) ? false : true;
        if (z2) {
            selector.setVisible(false, false);
        }
        m926b(i, view);
        if (z2) {
            Rect rect = this.f938b;
            float exactCenterX = rect.exactCenterX();
            float exactCenterY = rect.exactCenterY();
            if (getVisibility() != 0) {
                z = false;
            }
            selector.setVisible(z, false);
            C0595a.m2316a(selector, exactCenterX, exactCenterY);
        }
    }

    /* renamed from: a */
    private void m921a(int i, View view, float f, float f2) {
        m920a(i, view);
        Drawable selector = getSelector();
        if (selector != null && i != -1) {
            C0595a.m2316a(selector, f, f2);
        }
    }

    /* renamed from: a */
    private void m922a(Canvas canvas) {
        Drawable selector;
        if (!this.f938b.isEmpty() && (selector = getSelector()) != null) {
            selector.setBounds(this.f938b);
            selector.draw(canvas);
        }
    }

    /* renamed from: a */
    private void m923a(View view, int i) {
        performItemClick(view, i, getItemIdAtPosition(i));
    }

    /* renamed from: a */
    private void m924a(View view, int i, float f, float f2) {
        View childAt;
        this.f948l = true;
        if (Build.VERSION.SDK_INT >= 21) {
            drawableHotspotChanged(f, f2);
        }
        if (!isPressed()) {
            setPressed(true);
        }
        layoutChildren();
        int i2 = this.f943g;
        if (!(i2 == -1 || (childAt = getChildAt(i2 - getFirstVisiblePosition())) == null || childAt == view || !childAt.isPressed())) {
            childAt.setPressed(false);
        }
        this.f943g = i;
        float left = f - ((float) view.getLeft());
        float top = f2 - ((float) view.getTop());
        if (Build.VERSION.SDK_INT >= 21) {
            view.drawableHotspotChanged(left, top);
        }
        if (!view.isPressed()) {
            view.setPressed(true);
        }
        m921a(i, view, f, f2);
        setSelectorEnabled(false);
        refreshDrawableState();
    }

    /* renamed from: b */
    private void m925b() {
        this.f948l = false;
        setPressed(false);
        drawableStateChanged();
        View childAt = getChildAt(this.f943g - getFirstVisiblePosition());
        if (childAt != null) {
            childAt.setPressed(false);
        }
        C0668y yVar = this.f949m;
        if (yVar != null) {
            yVar.mo3852b();
            this.f949m = null;
        }
    }

    /* renamed from: b */
    private void m926b(int i, View view) {
        Rect rect = this.f938b;
        rect.set(view.getLeft(), view.getTop(), view.getRight(), view.getBottom());
        rect.left -= this.f939c;
        rect.top -= this.f940d;
        rect.right += this.f941e;
        rect.bottom += this.f942f;
        try {
            boolean z = this.f944h.getBoolean(this);
            if (view.isEnabled() != z) {
                this.f944h.set(this, Boolean.valueOf(!z));
                if (i != -1) {
                    refreshDrawableState();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: c */
    private boolean m927c() {
        return this.f948l;
    }

    private void setSelectorEnabled(boolean z) {
        C0259a aVar = this.f945i;
        if (aVar != null) {
            aVar.mo2145a(z);
        }
    }

    /* renamed from: a */
    public int mo2132a(int i, int i2, int i3, int i4, int i5) {
        int listPaddingTop = getListPaddingTop();
        int listPaddingBottom = getListPaddingBottom();
        getListPaddingLeft();
        getListPaddingRight();
        int dividerHeight = getDividerHeight();
        Drawable divider = getDivider();
        ListAdapter adapter = getAdapter();
        if (adapter == null) {
            return listPaddingTop + listPaddingBottom;
        }
        int i6 = listPaddingTop + listPaddingBottom;
        if (dividerHeight <= 0 || divider == null) {
            dividerHeight = 0;
        }
        int count = adapter.getCount();
        int i7 = i6;
        View view = null;
        int i8 = 0;
        int i9 = 0;
        int i10 = 0;
        while (i8 < count) {
            int itemViewType = adapter.getItemViewType(i8);
            if (itemViewType != i9) {
                view = null;
                i9 = itemViewType;
            }
            view = adapter.getView(i8, view, this);
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            if (layoutParams == null) {
                layoutParams = generateDefaultLayoutParams();
                view.setLayoutParams(layoutParams);
            }
            view.measure(i, layoutParams.height > 0 ? View.MeasureSpec.makeMeasureSpec(layoutParams.height, 1073741824) : View.MeasureSpec.makeMeasureSpec(0, 0));
            view.forceLayout();
            if (i8 > 0) {
                i7 += dividerHeight;
            }
            i7 += view.getMeasuredHeight();
            if (i7 >= i4) {
                return (i5 < 0 || i8 <= i5 || i10 <= 0 || i7 == i4) ? i4 : i10;
            }
            if (i5 >= 0 && i8 >= i5) {
                i10 = i7;
            }
            i8++;
        }
        return i7;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x004a  */
    /* JADX WARNING: Removed duplicated region for block: B:22:0x0060  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo2133a(android.view.MotionEvent r8, int r9) {
        /*
            r7 = this;
            int r0 = r8.getActionMasked()
            r1 = 0
            r2 = 1
            switch(r0) {
                case 1: goto L_0x0011;
                case 2: goto L_0x000f;
                case 3: goto L_0x000c;
                default: goto L_0x0009;
            }
        L_0x0009:
            r9 = 0
            r3 = 1
            goto L_0x0041
        L_0x000c:
            r9 = 0
            r3 = 0
            goto L_0x0041
        L_0x000f:
            r3 = 1
            goto L_0x0012
        L_0x0011:
            r3 = 0
        L_0x0012:
            int r9 = r8.findPointerIndex(r9)
            if (r9 >= 0) goto L_0x0019
            goto L_0x000c
        L_0x0019:
            float r4 = r8.getX(r9)
            int r4 = (int) r4
            float r9 = r8.getY(r9)
            int r9 = (int) r9
            int r5 = r7.pointToPosition(r4, r9)
            r6 = -1
            if (r5 != r6) goto L_0x002c
            r9 = 1
            goto L_0x0041
        L_0x002c:
            int r3 = r7.getFirstVisiblePosition()
            int r3 = r5 - r3
            android.view.View r3 = r7.getChildAt(r3)
            float r4 = (float) r4
            float r9 = (float) r9
            r7.m924a((android.view.View) r3, (int) r5, (float) r4, (float) r9)
            if (r0 != r2) goto L_0x0009
            r7.m923a((android.view.View) r3, (int) r5)
            goto L_0x0009
        L_0x0041:
            if (r3 == 0) goto L_0x0045
            if (r9 == 0) goto L_0x0048
        L_0x0045:
            r7.m925b()
        L_0x0048:
            if (r3 == 0) goto L_0x0060
            androidx.core.widget.f r9 = r7.f950n
            if (r9 != 0) goto L_0x0055
            androidx.core.widget.f r9 = new androidx.core.widget.f
            r9.<init>(r7)
            r7.f950n = r9
        L_0x0055:
            androidx.core.widget.f r9 = r7.f950n
            r9.mo3928a((boolean) r2)
            androidx.core.widget.f r9 = r7.f950n
            r9.onTouch(r7, r8)
            goto L_0x0067
        L_0x0060:
            androidx.core.widget.f r8 = r7.f950n
            if (r8 == 0) goto L_0x0067
            r8.mo3928a((boolean) r1)
        L_0x0067:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0258ag.mo2133a(android.view.MotionEvent, int):boolean");
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        m922a(canvas);
        super.dispatchDraw(canvas);
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (this.f937a == null) {
            super.drawableStateChanged();
            setSelectorEnabled(true);
            m919a();
        }
    }

    public boolean hasFocus() {
        return this.f947k || super.hasFocus();
    }

    public boolean hasWindowFocus() {
        return this.f947k || super.hasWindowFocus();
    }

    public boolean isFocused() {
        return this.f947k || super.isFocused();
    }

    public boolean isInTouchMode() {
        return (this.f947k && this.f946j) || super.isInTouchMode();
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        this.f937a = null;
        super.onDetachedFromWindow();
    }

    public boolean onHoverEvent(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT < 26) {
            return super.onHoverEvent(motionEvent);
        }
        int actionMasked = motionEvent.getActionMasked();
        if (actionMasked == 10 && this.f937a == null) {
            this.f937a = new C0260b();
            this.f937a.mo2147b();
        }
        boolean onHoverEvent = super.onHoverEvent(motionEvent);
        if (actionMasked == 9 || actionMasked == 7) {
            int pointToPosition = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
            if (!(pointToPosition == -1 || pointToPosition == getSelectedItemPosition())) {
                View childAt = getChildAt(pointToPosition - getFirstVisiblePosition());
                if (childAt.isEnabled()) {
                    setSelectionFromTop(pointToPosition, childAt.getTop() - getTop());
                }
                m919a();
            }
        } else {
            setSelection(-1);
        }
        return onHoverEvent;
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0) {
            this.f943g = pointToPosition((int) motionEvent.getX(), (int) motionEvent.getY());
        }
        C0260b bVar = this.f937a;
        if (bVar != null) {
            bVar.mo2146a();
        }
        return super.onTouchEvent(motionEvent);
    }

    /* access modifiers changed from: package-private */
    public void setListSelectionHidden(boolean z) {
        this.f946j = z;
    }

    public void setSelector(Drawable drawable) {
        this.f945i = drawable != null ? new C0259a(drawable) : null;
        super.setSelector(this.f945i);
        Rect rect = new Rect();
        if (drawable != null) {
            drawable.getPadding(rect);
        }
        this.f939c = rect.left;
        this.f940d = rect.top;
        this.f941e = rect.right;
        this.f942f = rect.bottom;
    }
}
