package androidx.appcompat.widget;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.appcompat.C0059a;
import java.lang.ref.WeakReference;

public final class ViewStubCompat extends View {

    /* renamed from: a */
    private int f903a;

    /* renamed from: b */
    private int f904b;

    /* renamed from: c */
    private WeakReference<View> f905c;

    /* renamed from: d */
    private LayoutInflater f906d;

    /* renamed from: e */
    private C0249a f907e;

    /* renamed from: androidx.appcompat.widget.ViewStubCompat$a */
    public interface C0249a {
        /* renamed from: a */
        void mo2038a(ViewStubCompat viewStubCompat, View view);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public ViewStubCompat(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f903a = 0;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C0059a.C0069j.ViewStubCompat, i, 0);
        this.f904b = obtainStyledAttributes.getResourceId(C0059a.C0069j.ViewStubCompat_android_inflatedId, -1);
        this.f903a = obtainStyledAttributes.getResourceId(C0059a.C0069j.ViewStubCompat_android_layout, 0);
        setId(obtainStyledAttributes.getResourceId(C0059a.C0069j.ViewStubCompat_android_id, -1));
        obtainStyledAttributes.recycle();
        setVisibility(8);
        setWillNotDraw(true);
    }

    /* renamed from: a */
    public View mo2026a() {
        ViewParent parent = getParent();
        if (!(parent instanceof ViewGroup)) {
            throw new IllegalStateException("ViewStub must have a non-null ViewGroup viewParent");
        } else if (this.f903a != 0) {
            ViewGroup viewGroup = (ViewGroup) parent;
            LayoutInflater layoutInflater = this.f906d;
            if (layoutInflater == null) {
                layoutInflater = LayoutInflater.from(getContext());
            }
            View inflate = layoutInflater.inflate(this.f903a, viewGroup, false);
            int i = this.f904b;
            if (i != -1) {
                inflate.setId(i);
            }
            int indexOfChild = viewGroup.indexOfChild(this);
            viewGroup.removeViewInLayout(this);
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams != null) {
                viewGroup.addView(inflate, indexOfChild, layoutParams);
            } else {
                viewGroup.addView(inflate, indexOfChild);
            }
            this.f905c = new WeakReference<>(inflate);
            C0249a aVar = this.f907e;
            if (aVar != null) {
                aVar.mo2038a(this, inflate);
            }
            return inflate;
        } else {
            throw new IllegalArgumentException("ViewStub must have a valid layoutResource");
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
    }

    @SuppressLint({"MissingSuperCall"})
    public void draw(Canvas canvas) {
    }

    public int getInflatedId() {
        return this.f904b;
    }

    public LayoutInflater getLayoutInflater() {
        return this.f906d;
    }

    public int getLayoutResource() {
        return this.f903a;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        setMeasuredDimension(0, 0);
    }

    public void setInflatedId(int i) {
        this.f904b = i;
    }

    public void setLayoutInflater(LayoutInflater layoutInflater) {
        this.f906d = layoutInflater;
    }

    public void setLayoutResource(int i) {
        this.f903a = i;
    }

    public void setOnInflateListener(C0249a aVar) {
        this.f907e = aVar;
    }

    public void setVisibility(int i) {
        WeakReference<View> weakReference = this.f905c;
        if (weakReference != null) {
            View view = (View) weakReference.get();
            if (view != null) {
                view.setVisibility(i);
                return;
            }
            throw new IllegalStateException("setVisibility called on un-referenced view");
        }
        super.setVisibility(i);
        if (i == 0 || i == 4) {
            mo2026a();
        }
    }
}
