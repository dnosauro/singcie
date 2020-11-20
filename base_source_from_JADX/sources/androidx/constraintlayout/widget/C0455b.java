package androidx.constraintlayout.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import androidx.constraintlayout.p019a.p020a.C0432j;
import androidx.constraintlayout.widget.C0462f;
import androidx.constraintlayout.widget.ConstraintLayout;
import java.util.Arrays;

/* renamed from: androidx.constraintlayout.widget.b */
public abstract class C0455b extends View {

    /* renamed from: a */
    protected int[] f1790a = new int[32];

    /* renamed from: b */
    protected int f1791b;

    /* renamed from: c */
    protected Context f1792c;

    /* renamed from: d */
    protected C0432j f1793d;

    /* renamed from: e */
    protected boolean f1794e = false;

    /* renamed from: f */
    private String f1795f;

    public C0455b(Context context) {
        super(context);
        this.f1792c = context;
        mo3249a((AttributeSet) null);
    }

    /* renamed from: a */
    private void m1874a(String str) {
        int i;
        Object a;
        if (str != null && this.f1792c != null) {
            String trim = str.trim();
            try {
                i = C0462f.C0463a.class.getField(trim).getInt((Object) null);
            } catch (Exception unused) {
                i = 0;
            }
            if (i == 0) {
                i = this.f1792c.getResources().getIdentifier(trim, "id", this.f1792c.getPackageName());
            }
            if (i == 0 && isInEditMode() && (getParent() instanceof ConstraintLayout) && (a = ((ConstraintLayout) getParent()).mo3213a(0, (Object) trim)) != null && (a instanceof Integer)) {
                i = ((Integer) a).intValue();
            }
            if (i != 0) {
                setTag(i, (Object) null);
                return;
            }
            Log.w("ConstraintHelper", "Could not find id of \"" + trim + "\"");
        }
    }

    private void setIds(String str) {
        if (str != null) {
            int i = 0;
            while (true) {
                int indexOf = str.indexOf(44, i);
                if (indexOf == -1) {
                    m1874a(str.substring(i));
                    return;
                } else {
                    m1874a(str.substring(i, indexOf));
                    i = indexOf + 1;
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3253a() {
        if (this.f1793d != null) {
            ViewGroup.LayoutParams layoutParams = getLayoutParams();
            if (layoutParams instanceof ConstraintLayout.C0452a) {
                ((ConstraintLayout.C0452a) layoutParams).f1759al = this.f1793d;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo3249a(AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C0462f.C0464b.ConstraintLayout_Layout);
            int indexCount = obtainStyledAttributes.getIndexCount();
            for (int i = 0; i < indexCount; i++) {
                int index = obtainStyledAttributes.getIndex(i);
                if (index == C0462f.C0464b.ConstraintLayout_Layout_constraint_referenced_ids) {
                    this.f1795f = obtainStyledAttributes.getString(index);
                    setIds(this.f1795f);
                }
            }
        }
    }

    /* renamed from: a */
    public void mo3254a(ConstraintLayout constraintLayout) {
        if (isInEditMode()) {
            setIds(this.f1795f);
        }
        C0432j jVar = this.f1793d;
        if (jVar != null) {
            jVar.mo3098J();
            for (int i = 0; i < this.f1791b; i++) {
                View a = constraintLayout.mo3209a(this.f1790a[i]);
                if (a != null) {
                    this.f1793d.mo3122b(constraintLayout.mo3210a(a));
                }
            }
        }
    }

    /* renamed from: b */
    public void mo3255b(ConstraintLayout constraintLayout) {
    }

    /* renamed from: c */
    public void mo3256c(ConstraintLayout constraintLayout) {
    }

    public int[] getReferencedIds() {
        return Arrays.copyOf(this.f1790a, this.f1791b);
    }

    public void onDraw(Canvas canvas) {
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f1794e) {
            super.onMeasure(i, i2);
        } else {
            setMeasuredDimension(0, 0);
        }
    }

    public void setReferencedIds(int[] iArr) {
        this.f1791b = 0;
        for (int tag : iArr) {
            setTag(tag, (Object) null);
        }
    }

    public void setTag(int i, Object obj) {
        int i2 = this.f1791b + 1;
        int[] iArr = this.f1790a;
        if (i2 > iArr.length) {
            this.f1790a = Arrays.copyOf(iArr, iArr.length * 2);
        }
        int[] iArr2 = this.f1790a;
        int i3 = this.f1791b;
        iArr2[i3] = i;
        this.f1791b = i3 + 1;
    }
}
