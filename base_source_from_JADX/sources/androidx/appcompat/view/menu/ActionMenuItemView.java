package androidx.appcompat.view.menu;

import android.content.Context;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import androidx.appcompat.C0059a;
import androidx.appcompat.view.menu.C0183g;
import androidx.appcompat.view.menu.C0200n;
import androidx.appcompat.widget.ActionMenuView;
import androidx.appcompat.widget.C0252aa;
import androidx.appcompat.widget.C0263ai;
import androidx.appcompat.widget.C0307ba;

public class ActionMenuItemView extends C0252aa implements View.OnClickListener, C0200n.C0201a, ActionMenuView.C0215a {

    /* renamed from: a */
    C0187i f499a;

    /* renamed from: b */
    C0183g.C0185b f500b;

    /* renamed from: c */
    C0170b f501c;

    /* renamed from: e */
    private CharSequence f502e;

    /* renamed from: f */
    private Drawable f503f;

    /* renamed from: g */
    private C0263ai f504g;

    /* renamed from: h */
    private boolean f505h;

    /* renamed from: i */
    private boolean f506i;

    /* renamed from: j */
    private int f507j;

    /* renamed from: k */
    private int f508k;

    /* renamed from: l */
    private int f509l;

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$a */
    private class C0169a extends C0263ai {
        public C0169a() {
            super(ActionMenuItemView.this);
        }

        /* renamed from: a */
        public C0203p mo1218a() {
            if (ActionMenuItemView.this.f501c != null) {
                return ActionMenuItemView.this.f501c.mo1220a();
            }
            return null;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:4:0x0015, code lost:
            r0 = mo1218a();
         */
        /* renamed from: b */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public boolean mo1219b() {
            /*
                r3 = this;
                androidx.appcompat.view.menu.ActionMenuItemView r0 = androidx.appcompat.view.menu.ActionMenuItemView.this
                androidx.appcompat.view.menu.g$b r0 = r0.f500b
                r1 = 0
                if (r0 == 0) goto L_0x0022
                androidx.appcompat.view.menu.ActionMenuItemView r0 = androidx.appcompat.view.menu.ActionMenuItemView.this
                androidx.appcompat.view.menu.g$b r0 = r0.f500b
                androidx.appcompat.view.menu.ActionMenuItemView r2 = androidx.appcompat.view.menu.ActionMenuItemView.this
                androidx.appcompat.view.menu.i r2 = r2.f499a
                boolean r0 = r0.mo1221a(r2)
                if (r0 == 0) goto L_0x0022
                androidx.appcompat.view.menu.p r0 = r3.mo1218a()
                if (r0 == 0) goto L_0x0022
                boolean r0 = r0.mo1329c()
                if (r0 == 0) goto L_0x0022
                r1 = 1
            L_0x0022:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.view.menu.ActionMenuItemView.C0169a.mo1219b():boolean");
        }
    }

    /* renamed from: androidx.appcompat.view.menu.ActionMenuItemView$b */
    public static abstract class C0170b {
        /* renamed from: a */
        public abstract C0203p mo1220a();
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ActionMenuItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Resources resources = context.getResources();
        this.f505h = m525d();
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.C0069j.ActionMenuItemView, i, 0);
        this.f507j = obtainStyledAttributes.getDimensionPixelSize(C0059a.C0069j.ActionMenuItemView_android_minWidth, 0);
        obtainStyledAttributes.recycle();
        this.f509l = (int) ((resources.getDisplayMetrics().density * 32.0f) + 0.5f);
        setOnClickListener(this);
        this.f508k = -1;
        setSaveEnabled(false);
    }

    /* renamed from: d */
    private boolean m525d() {
        Configuration configuration = getContext().getResources().getConfiguration();
        int i = configuration.screenWidthDp;
        return i >= 480 || (i >= 640 && configuration.screenHeightDp >= 480) || configuration.orientation == 2;
    }

    /* renamed from: e */
    private void m526e() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f502e);
        if (this.f503f != null && (!this.f499a.mo1490m() || (!this.f505h && !this.f506i))) {
            z = false;
        }
        boolean z3 = z2 & z;
        CharSequence charSequence = null;
        setText(z3 ? this.f502e : null);
        CharSequence contentDescription = this.f499a.getContentDescription();
        if (TextUtils.isEmpty(contentDescription)) {
            contentDescription = z3 ? null : this.f499a.getTitle();
        }
        setContentDescription(contentDescription);
        CharSequence tooltipText = this.f499a.getTooltipText();
        if (TextUtils.isEmpty(tooltipText)) {
            if (!z3) {
                charSequence = this.f499a.getTitle();
            }
            C0307ba.m1144a(this, charSequence);
            return;
        }
        C0307ba.m1144a(this, tooltipText);
    }

    /* renamed from: a */
    public boolean mo1199a() {
        return !TextUtils.isEmpty(getText());
    }

    /* renamed from: b */
    public boolean mo1200b() {
        return mo1199a() && this.f499a.getIcon() == null;
    }

    /* renamed from: c */
    public boolean mo1201c() {
        return mo1199a();
    }

    public C0187i getItemData() {
        return this.f499a;
    }

    public void initialize(C0187i iVar, int i) {
        this.f499a = iVar;
        setIcon(iVar.getIcon());
        setTitle(iVar.mo1453a((C0200n.C0201a) this));
        setId(iVar.getItemId());
        setVisibility(iVar.isVisible() ? 0 : 8);
        setEnabled(iVar.isEnabled());
        if (iVar.hasSubMenu() && this.f504g == null) {
            this.f504g = new C0169a();
        }
    }

    public void onClick(View view) {
        C0183g.C0185b bVar = this.f500b;
        if (bVar != null) {
            bVar.mo1221a(this.f499a);
        }
    }

    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        this.f505h = m525d();
        m526e();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        boolean a = mo1199a();
        if (a && (i3 = this.f508k) >= 0) {
            super.setPadding(i3, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        int measuredWidth = getMeasuredWidth();
        int min = mode == Integer.MIN_VALUE ? Math.min(size, this.f507j) : this.f507j;
        if (mode != 1073741824 && this.f507j > 0 && measuredWidth < min) {
            super.onMeasure(View.MeasureSpec.makeMeasureSpec(min, 1073741824), i2);
        }
        if (!a && this.f503f != null) {
            super.setPadding((getMeasuredWidth() - this.f503f.getBounds().width()) / 2, getPaddingTop(), getPaddingRight(), getPaddingBottom());
        }
    }

    public void onRestoreInstanceState(Parcelable parcelable) {
        super.onRestoreInstanceState((Parcelable) null);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        C0263ai aiVar;
        if (!this.f499a.hasSubMenu() || (aiVar = this.f504g) == null || !aiVar.onTouch(this, motionEvent)) {
            return super.onTouchEvent(motionEvent);
        }
        return true;
    }

    public boolean prefersCondensedTitle() {
        return true;
    }

    public void setCheckable(boolean z) {
    }

    public void setChecked(boolean z) {
    }

    public void setExpandedFormat(boolean z) {
        if (this.f506i != z) {
            this.f506i = z;
            C0187i iVar = this.f499a;
            if (iVar != null) {
                iVar.mo1480h();
            }
        }
    }

    public void setIcon(Drawable drawable) {
        this.f503f = drawable;
        if (drawable != null) {
            int intrinsicWidth = drawable.getIntrinsicWidth();
            int intrinsicHeight = drawable.getIntrinsicHeight();
            int i = this.f509l;
            if (intrinsicWidth > i) {
                intrinsicHeight = (int) (((float) intrinsicHeight) * (((float) i) / ((float) intrinsicWidth)));
                intrinsicWidth = i;
            }
            int i2 = this.f509l;
            if (intrinsicHeight > i2) {
                intrinsicWidth = (int) (((float) intrinsicWidth) * (((float) i2) / ((float) intrinsicHeight)));
                intrinsicHeight = i2;
            }
            drawable.setBounds(0, 0, intrinsicWidth, intrinsicHeight);
        }
        setCompoundDrawables(drawable, (Drawable) null, (Drawable) null, (Drawable) null);
        m526e();
    }

    public void setItemInvoker(C0183g.C0185b bVar) {
        this.f500b = bVar;
    }

    public void setPadding(int i, int i2, int i3, int i4) {
        this.f508k = i;
        super.setPadding(i, i2, i3, i4);
    }

    public void setPopupCallback(C0170b bVar) {
        this.f501c = bVar;
    }

    public void setTitle(CharSequence charSequence) {
        this.f502e = charSequence;
        m526e();
    }
}
