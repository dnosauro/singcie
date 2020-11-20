package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.Interpolator;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.HorizontalScrollView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.appcompat.app.C0086a;
import androidx.appcompat.view.C0155a;
import androidx.appcompat.widget.C0266aj;

/* renamed from: androidx.appcompat.widget.aq */
public class C0288aq extends HorizontalScrollView implements AdapterView.OnItemSelectedListener {

    /* renamed from: j */
    private static final Interpolator f1034j = new DecelerateInterpolator();

    /* renamed from: a */
    Runnable f1035a;

    /* renamed from: b */
    C0266aj f1036b;

    /* renamed from: c */
    int f1037c;

    /* renamed from: d */
    int f1038d;

    /* renamed from: e */
    private C0291b f1039e;

    /* renamed from: f */
    private Spinner f1040f;

    /* renamed from: g */
    private boolean f1041g;

    /* renamed from: h */
    private int f1042h;

    /* renamed from: i */
    private int f1043i;

    /* renamed from: androidx.appcompat.widget.aq$a */
    private class C0290a extends BaseAdapter {
        C0290a() {
        }

        public int getCount() {
            return C0288aq.this.f1036b.getChildCount();
        }

        public Object getItem(int i) {
            return ((C0292c) C0288aq.this.f1036b.getChildAt(i)).mo2326b();
        }

        public long getItemId(int i) {
            return (long) i;
        }

        public View getView(int i, View view, ViewGroup viewGroup) {
            if (view == null) {
                return C0288aq.this.mo2307a((C0086a.C0089c) getItem(i), true);
            }
            ((C0292c) view).mo2325a((C0086a.C0089c) getItem(i));
            return view;
        }
    }

    /* renamed from: androidx.appcompat.widget.aq$b */
    private class C0291b implements View.OnClickListener {
        C0291b() {
        }

        public void onClick(View view) {
            ((C0292c) view).mo2326b().mo752d();
            int childCount = C0288aq.this.f1036b.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = C0288aq.this.f1036b.getChildAt(i);
                childAt.setSelected(childAt == view);
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.aq$c */
    private class C0292c extends LinearLayout {

        /* renamed from: b */
        private final int[] f1049b = {16842964};

        /* renamed from: c */
        private C0086a.C0089c f1050c;

        /* renamed from: d */
        private TextView f1051d;

        /* renamed from: e */
        private ImageView f1052e;

        /* renamed from: f */
        private View f1053f;

        public C0292c(Context context, C0086a.C0089c cVar, boolean z) {
            super(context, (AttributeSet) null, C0059a.C0060a.actionBarTabStyle);
            this.f1050c = cVar;
            C0302ay a = C0302ay.m1078a(context, (AttributeSet) null, this.f1049b, C0059a.C0060a.actionBarTabStyle, 0);
            if (a.mo2424g(0)) {
                setBackgroundDrawable(a.mo2409a(0));
            }
            a.mo2410a();
            if (z) {
                setGravity(8388627);
            }
            mo2324a();
        }

        /* renamed from: a */
        public void mo2324a() {
            C0086a.C0089c cVar = this.f1050c;
            View c = cVar.mo751c();
            CharSequence charSequence = null;
            if (c != null) {
                ViewParent parent = c.getParent();
                if (parent != this) {
                    if (parent != null) {
                        ((ViewGroup) parent).removeView(c);
                    }
                    addView(c);
                }
                this.f1053f = c;
                TextView textView = this.f1051d;
                if (textView != null) {
                    textView.setVisibility(8);
                }
                ImageView imageView = this.f1052e;
                if (imageView != null) {
                    imageView.setVisibility(8);
                    this.f1052e.setImageDrawable((Drawable) null);
                    return;
                }
                return;
            }
            View view = this.f1053f;
            if (view != null) {
                removeView(view);
                this.f1053f = null;
            }
            Drawable a = cVar.mo749a();
            CharSequence b = cVar.mo750b();
            if (a != null) {
                if (this.f1052e == null) {
                    C0343p pVar = new C0343p(getContext());
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = 16;
                    pVar.setLayoutParams(layoutParams);
                    addView(pVar, 0);
                    this.f1052e = pVar;
                }
                this.f1052e.setImageDrawable(a);
                this.f1052e.setVisibility(0);
            } else {
                ImageView imageView2 = this.f1052e;
                if (imageView2 != null) {
                    imageView2.setVisibility(8);
                    this.f1052e.setImageDrawable((Drawable) null);
                }
            }
            boolean z = !TextUtils.isEmpty(b);
            if (z) {
                if (this.f1051d == null) {
                    C0252aa aaVar = new C0252aa(getContext(), (AttributeSet) null, C0059a.C0060a.actionBarTabTextStyle);
                    aaVar.setEllipsize(TextUtils.TruncateAt.END);
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams2.gravity = 16;
                    aaVar.setLayoutParams(layoutParams2);
                    addView(aaVar);
                    this.f1051d = aaVar;
                }
                this.f1051d.setText(b);
                this.f1051d.setVisibility(0);
            } else {
                TextView textView2 = this.f1051d;
                if (textView2 != null) {
                    textView2.setVisibility(8);
                    this.f1051d.setText((CharSequence) null);
                }
            }
            ImageView imageView3 = this.f1052e;
            if (imageView3 != null) {
                imageView3.setContentDescription(cVar.mo753e());
            }
            if (!z) {
                charSequence = cVar.mo753e();
            }
            C0307ba.m1144a(this, charSequence);
        }

        /* renamed from: a */
        public void mo2325a(C0086a.C0089c cVar) {
            this.f1050c = cVar;
            mo2324a();
        }

        /* renamed from: b */
        public C0086a.C0089c mo2326b() {
            return this.f1050c;
        }

        public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
            super.onInitializeAccessibilityEvent(accessibilityEvent);
            accessibilityEvent.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
            super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
            accessibilityNodeInfo.setClassName("androidx.appcompat.app.ActionBar$Tab");
        }

        public void onMeasure(int i, int i2) {
            super.onMeasure(i, i2);
            if (C0288aq.this.f1037c > 0 && getMeasuredWidth() > C0288aq.this.f1037c) {
                super.onMeasure(View.MeasureSpec.makeMeasureSpec(C0288aq.this.f1037c, 1073741824), i2);
            }
        }

        public void setSelected(boolean z) {
            boolean z2 = isSelected() != z;
            super.setSelected(z);
            if (z2 && z) {
                sendAccessibilityEvent(4);
            }
        }
    }

    /* renamed from: a */
    private boolean m1032a() {
        Spinner spinner = this.f1040f;
        return spinner != null && spinner.getParent() == this;
    }

    /* renamed from: b */
    private void m1033b() {
        if (!m1032a()) {
            if (this.f1040f == null) {
                this.f1040f = m1035d();
            }
            removeView(this.f1036b);
            addView(this.f1040f, new ViewGroup.LayoutParams(-2, -1));
            if (this.f1040f.getAdapter() == null) {
                this.f1040f.setAdapter(new C0290a());
            }
            Runnable runnable = this.f1035a;
            if (runnable != null) {
                removeCallbacks(runnable);
                this.f1035a = null;
            }
            this.f1040f.setSelection(this.f1043i);
        }
    }

    /* renamed from: c */
    private boolean m1034c() {
        if (!m1032a()) {
            return false;
        }
        removeView(this.f1040f);
        addView(this.f1036b, new ViewGroup.LayoutParams(-2, -1));
        setTabSelected(this.f1040f.getSelectedItemPosition());
        return false;
    }

    /* renamed from: d */
    private Spinner m1035d() {
        C0351x xVar = new C0351x(getContext(), (AttributeSet) null, C0059a.C0060a.actionDropDownStyle);
        xVar.setLayoutParams(new C0266aj.C0267a(-2, -1));
        xVar.setOnItemSelectedListener(this);
        return xVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0292c mo2307a(C0086a.C0089c cVar, boolean z) {
        C0292c cVar2 = new C0292c(getContext(), cVar, z);
        if (z) {
            cVar2.setBackgroundDrawable((Drawable) null);
            cVar2.setLayoutParams(new AbsListView.LayoutParams(-1, this.f1042h));
        } else {
            cVar2.setFocusable(true);
            if (this.f1039e == null) {
                this.f1039e = new C0291b();
            }
            cVar2.setOnClickListener(this.f1039e);
        }
        return cVar2;
    }

    /* renamed from: a */
    public void mo2308a(int i) {
        final View childAt = this.f1036b.getChildAt(i);
        Runnable runnable = this.f1035a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
        this.f1035a = new Runnable() {
            public void run() {
                C0288aq.this.smoothScrollTo(childAt.getLeft() - ((C0288aq.this.getWidth() - childAt.getWidth()) / 2), 0);
                C0288aq.this.f1035a = null;
            }
        };
        post(this.f1035a);
    }

    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        Runnable runnable = this.f1035a;
        if (runnable != null) {
            post(runnable);
        }
    }

    /* access modifiers changed from: protected */
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        C0155a a = C0155a.m446a(getContext());
        setContentHeight(a.mo1132e());
        this.f1038d = a.mo1134g();
    }

    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Runnable runnable = this.f1035a;
        if (runnable != null) {
            removeCallbacks(runnable);
        }
    }

    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long j) {
        ((C0292c) view).mo2326b().mo752d();
    }

    public void onMeasure(int i, int i2) {
        int i3;
        int mode = View.MeasureSpec.getMode(i);
        boolean z = true;
        boolean z2 = mode == 1073741824;
        setFillViewport(z2);
        int childCount = this.f1036b.getChildCount();
        if (childCount <= 1 || !(mode == 1073741824 || mode == Integer.MIN_VALUE)) {
            i3 = -1;
        } else {
            if (childCount > 2) {
                this.f1037c = (int) (((float) View.MeasureSpec.getSize(i)) * 0.4f);
            } else {
                this.f1037c = View.MeasureSpec.getSize(i) / 2;
            }
            i3 = Math.min(this.f1037c, this.f1038d);
        }
        this.f1037c = i3;
        int makeMeasureSpec = View.MeasureSpec.makeMeasureSpec(this.f1042h, 1073741824);
        if (z2 || !this.f1041g) {
            z = false;
        }
        if (z) {
            this.f1036b.measure(0, makeMeasureSpec);
            if (this.f1036b.getMeasuredWidth() > View.MeasureSpec.getSize(i)) {
                m1033b();
                int measuredWidth = getMeasuredWidth();
                super.onMeasure(i, makeMeasureSpec);
                int measuredWidth2 = getMeasuredWidth();
                if (z2 && measuredWidth != measuredWidth2) {
                    setTabSelected(this.f1043i);
                    return;
                }
            }
        }
        m1034c();
        int measuredWidth3 = getMeasuredWidth();
        super.onMeasure(i, makeMeasureSpec);
        int measuredWidth22 = getMeasuredWidth();
        if (z2) {
        }
    }

    public void onNothingSelected(AdapterView<?> adapterView) {
    }

    public void setAllowCollapse(boolean z) {
        this.f1041g = z;
    }

    public void setContentHeight(int i) {
        this.f1042h = i;
        requestLayout();
    }

    public void setTabSelected(int i) {
        this.f1043i = i;
        int childCount = this.f1036b.getChildCount();
        int i2 = 0;
        while (i2 < childCount) {
            View childAt = this.f1036b.getChildAt(i2);
            boolean z = i2 == i;
            childAt.setSelected(z);
            if (z) {
                mo2308a(i);
            }
            i2++;
        }
        Spinner spinner = this.f1040f;
        if (spinner != null && i >= 0) {
            spinner.setSelection(i);
        }
    }
}
