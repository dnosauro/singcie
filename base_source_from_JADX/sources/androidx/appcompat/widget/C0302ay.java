package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.util.TypedValue;
import androidx.core.content.p025a.C0540f;

/* renamed from: androidx.appcompat.widget.ay */
public class C0302ay {

    /* renamed from: a */
    private final Context f1093a;

    /* renamed from: b */
    private final TypedArray f1094b;

    /* renamed from: c */
    private TypedValue f1095c;

    private C0302ay(Context context, TypedArray typedArray) {
        this.f1093a = context;
        this.f1094b = typedArray;
    }

    /* renamed from: a */
    public static C0302ay m1076a(Context context, int i, int[] iArr) {
        return new C0302ay(context, context.obtainStyledAttributes(i, iArr));
    }

    /* renamed from: a */
    public static C0302ay m1077a(Context context, AttributeSet attributeSet, int[] iArr) {
        return new C0302ay(context, context.obtainStyledAttributes(attributeSet, iArr));
    }

    /* renamed from: a */
    public static C0302ay m1078a(Context context, AttributeSet attributeSet, int[] iArr, int i, int i2) {
        return new C0302ay(context, context.obtainStyledAttributes(attributeSet, iArr, i, i2));
    }

    /* renamed from: a */
    public float mo2406a(int i, float f) {
        return this.f1094b.getFloat(i, f);
    }

    /* renamed from: a */
    public int mo2407a(int i, int i2) {
        return this.f1094b.getInt(i, i2);
    }

    /* renamed from: a */
    public Typeface mo2408a(int i, int i2, C0540f.C0541a aVar) {
        int resourceId = this.f1094b.getResourceId(i, 0);
        if (resourceId == 0) {
            return null;
        }
        if (this.f1095c == null) {
            this.f1095c = new TypedValue();
        }
        return C0540f.m2148a(this.f1093a, resourceId, this.f1095c, i2, aVar);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0008, code lost:
        r0 = r2.f1094b.getResourceId(r3, 0);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.graphics.drawable.Drawable mo2409a(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f1094b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x0018
            android.content.res.TypedArray r0 = r2.f1094b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x0018
            android.content.Context r3 = r2.f1093a
            android.graphics.drawable.Drawable r3 = androidx.appcompat.p009a.p010a.C0070a.m63b(r3, r0)
            return r3
        L_0x0018:
            android.content.res.TypedArray r0 = r2.f1094b
            android.graphics.drawable.Drawable r3 = r0.getDrawable(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0302ay.mo2409a(int):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    public void mo2410a() {
        this.f1094b.recycle();
    }

    /* renamed from: a */
    public boolean mo2411a(int i, boolean z) {
        return this.f1094b.getBoolean(i, z);
    }

    /* renamed from: b */
    public float mo2412b(int i, float f) {
        return this.f1094b.getDimension(i, f);
    }

    /* renamed from: b */
    public int mo2413b(int i, int i2) {
        return this.f1094b.getColor(i, i2);
    }

    /* renamed from: b */
    public Drawable mo2414b(int i) {
        int resourceId;
        if (!this.f1094b.hasValue(i) || (resourceId = this.f1094b.getResourceId(i, 0)) == 0) {
            return null;
        }
        return C0337k.m1243b().mo2551a(this.f1093a, resourceId, true);
    }

    /* renamed from: c */
    public int mo2415c(int i, int i2) {
        return this.f1094b.getInteger(i, i2);
    }

    /* renamed from: c */
    public CharSequence mo2416c(int i) {
        return this.f1094b.getText(i);
    }

    /* renamed from: d */
    public int mo2417d(int i, int i2) {
        return this.f1094b.getDimensionPixelOffset(i, i2);
    }

    /* renamed from: d */
    public String mo2418d(int i) {
        return this.f1094b.getString(i);
    }

    /* renamed from: e */
    public int mo2419e(int i, int i2) {
        return this.f1094b.getDimensionPixelSize(i, i2);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x0011, code lost:
        r0 = androidx.appcompat.p009a.p010a.C0070a.m60a(r2.f1093a, (r0 = r2.f1094b.getResourceId(r3, 0)));
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public android.content.res.ColorStateList mo2420e(int r3) {
        /*
            r2 = this;
            android.content.res.TypedArray r0 = r2.f1094b
            boolean r0 = r0.hasValue(r3)
            if (r0 == 0) goto L_0x001a
            android.content.res.TypedArray r0 = r2.f1094b
            r1 = 0
            int r0 = r0.getResourceId(r3, r1)
            if (r0 == 0) goto L_0x001a
            android.content.Context r1 = r2.f1093a
            android.content.res.ColorStateList r0 = androidx.appcompat.p009a.p010a.C0070a.m60a(r1, r0)
            if (r0 == 0) goto L_0x001a
            return r0
        L_0x001a:
            android.content.res.TypedArray r0 = r2.f1094b
            android.content.res.ColorStateList r3 = r0.getColorStateList(r3)
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0302ay.mo2420e(int):android.content.res.ColorStateList");
    }

    /* renamed from: f */
    public int mo2421f(int i, int i2) {
        return this.f1094b.getLayoutDimension(i, i2);
    }

    /* renamed from: f */
    public CharSequence[] mo2422f(int i) {
        return this.f1094b.getTextArray(i);
    }

    /* renamed from: g */
    public int mo2423g(int i, int i2) {
        return this.f1094b.getResourceId(i, i2);
    }

    /* renamed from: g */
    public boolean mo2424g(int i) {
        return this.f1094b.hasValue(i);
    }
}
