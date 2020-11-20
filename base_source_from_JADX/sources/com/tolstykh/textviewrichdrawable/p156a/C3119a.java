package com.tolstykh.textviewrichdrawable.p156a;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;
import androidx.core.content.p025a.C0540f;
import androidx.core.graphics.drawable.C0595a;
import androidx.core.p030h.C0656u;
import com.tolstykh.p155a.C3117a;

/* renamed from: com.tolstykh.textviewrichdrawable.a.a */
public class C3119a {

    /* renamed from: a */
    private Context f7252a;

    /* renamed from: b */
    private int f7253b;

    /* renamed from: c */
    private int f7254c;

    /* renamed from: d */
    private int f7255d;

    /* renamed from: e */
    private int f7256e;

    /* renamed from: f */
    private int f7257f;

    /* renamed from: g */
    private int f7258g;

    /* renamed from: h */
    private int f7259h;

    public C3119a(Context context, AttributeSet attributeSet, int i, int i2) {
        this.f7252a = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C3117a.C3118a.TextViewRichDrawable, i, i2);
        try {
            this.f7253b = obtainStyledAttributes.getDimensionPixelSize(C3117a.C3118a.TextViewRichDrawable_compoundDrawableWidth, -1);
            this.f7254c = obtainStyledAttributes.getDimensionPixelSize(C3117a.C3118a.TextViewRichDrawable_compoundDrawableHeight, -1);
            this.f7255d = obtainStyledAttributes.getResourceId(C3117a.C3118a.TextViewRichDrawable_drawableStartVector, -1);
            this.f7256e = obtainStyledAttributes.getResourceId(C3117a.C3118a.TextViewRichDrawable_drawableTopVector, -1);
            this.f7257f = obtainStyledAttributes.getResourceId(C3117a.C3118a.TextViewRichDrawable_drawableEndVector, -1);
            this.f7258g = obtainStyledAttributes.getResourceId(C3117a.C3118a.TextViewRichDrawable_drawableBottomVector, -1);
            this.f7259h = obtainStyledAttributes.getColor(C3117a.C3118a.TextViewRichDrawable_drawableTint2, -1);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private void m8964a(TextView textView, int i, int i2, int i3, int i4) {
        Drawable[] compoundDrawables = textView.getCompoundDrawables();
        m8965a(textView, i, i2, i3, i4, compoundDrawables);
        m8966a(compoundDrawables);
        m8967b(compoundDrawables);
        textView.setCompoundDrawables(compoundDrawables[0], compoundDrawables[1], compoundDrawables[2], compoundDrawables[3]);
    }

    /* renamed from: a */
    private void m8965a(TextView textView, int i, int i2, int i3, int i4, Drawable[] drawableArr) {
        char c = 0;
        boolean z = C0656u.m2621g(textView) == 1;
        if (i != -1) {
            drawableArr[z ? (char) 2 : 0] = m8968e(i);
        }
        if (i2 != -1) {
            drawableArr[1] = m8968e(i2);
        }
        if (i3 != -1) {
            if (!z) {
                c = 2;
            }
            drawableArr[c] = m8968e(i3);
        }
        if (i4 != -1) {
            drawableArr[3] = m8968e(i4);
        }
    }

    /* renamed from: a */
    private void m8966a(Drawable[] drawableArr) {
        float f;
        float f2;
        float f3;
        int i;
        if (this.f7254c > 0 || this.f7253b > 0) {
            for (Drawable drawable : drawableArr) {
                if (drawable != null) {
                    Rect rect = new Rect(0, 0, drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight());
                    float width = (float) rect.width();
                    float height = (float) rect.height();
                    float f4 = height / width;
                    int i2 = this.f7254c;
                    if (i2 <= 0 || (i = this.f7253b) <= 0) {
                        int i3 = this.f7254c;
                        if (i3 > 0) {
                            f3 = (float) i3;
                        } else {
                            f2 = (float) this.f7253b;
                            f = f2 / width;
                            rect.right = rect.left + Math.round(width * f);
                            rect.bottom = rect.top + Math.round(height * f);
                            drawable.setBounds(rect);
                        }
                    } else if (((float) i2) / ((float) i) > f4) {
                        f2 = (float) i;
                        f = f2 / width;
                        rect.right = rect.left + Math.round(width * f);
                        rect.bottom = rect.top + Math.round(height * f);
                        drawable.setBounds(rect);
                    } else {
                        f3 = (float) i2;
                    }
                    f = f3 / height;
                    rect.right = rect.left + Math.round(width * f);
                    rect.bottom = rect.top + Math.round(height * f);
                    drawable.setBounds(rect);
                }
            }
            return;
        }
        for (Drawable drawable2 : drawableArr) {
            if (drawable2 != null) {
                drawable2.setBounds(new Rect(0, 0, drawable2.getIntrinsicWidth(), drawable2.getIntrinsicHeight()));
            }
        }
    }

    /* renamed from: b */
    private void m8967b(Drawable[] drawableArr) {
        if (this.f7259h != -1) {
            for (int i = 0; i < drawableArr.length; i++) {
                if (drawableArr[i] != null) {
                    Drawable g = C0595a.m2330g(drawableArr[i]);
                    C0595a.m2317a(g.mutate(), this.f7259h);
                    drawableArr[i] = g;
                }
            }
        }
    }

    /* renamed from: e */
    private Drawable m8968e(int i) {
        return C0540f.m2151a(this.f7252a.getResources(), i, this.f7252a.getTheme());
    }

    /* renamed from: a */
    public int mo24017a() {
        return this.f7254c;
    }

    /* renamed from: a */
    public void mo24018a(int i) {
        this.f7255d = i;
    }

    /* renamed from: a */
    public void mo24019a(TextView textView) {
        if (this.f7253b > 0 || this.f7254c > 0 || this.f7255d > 0 || this.f7256e > 0 || this.f7257f > 0 || this.f7258g > 0) {
            m8964a(textView, this.f7255d, this.f7256e, this.f7257f, this.f7258g);
        }
    }

    /* renamed from: b */
    public int mo24020b() {
        return this.f7253b;
    }

    /* renamed from: b */
    public void mo24021b(int i) {
        this.f7257f = i;
    }

    /* renamed from: c */
    public void mo24022c(int i) {
        this.f7256e = i;
    }

    /* renamed from: d */
    public void mo24023d(int i) {
        this.f7258g = i;
    }
}
