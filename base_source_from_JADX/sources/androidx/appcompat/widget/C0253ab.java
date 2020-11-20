package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.RectF;
import android.os.Build;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.concurrent.ConcurrentHashMap;
import org.spongycastle.asn1.cmp.PKIFailureInfo;

/* renamed from: androidx.appcompat.widget.ab */
class C0253ab {

    /* renamed from: a */
    private static final RectF f919a = new RectF();

    /* renamed from: b */
    private static ConcurrentHashMap<String, Method> f920b = new ConcurrentHashMap<>();

    /* renamed from: c */
    private static ConcurrentHashMap<String, Field> f921c = new ConcurrentHashMap<>();

    /* renamed from: d */
    private int f922d = 0;

    /* renamed from: e */
    private boolean f923e = false;

    /* renamed from: f */
    private float f924f = -1.0f;

    /* renamed from: g */
    private float f925g = -1.0f;

    /* renamed from: h */
    private float f926h = -1.0f;

    /* renamed from: i */
    private int[] f927i = new int[0];

    /* renamed from: j */
    private boolean f928j = false;

    /* renamed from: k */
    private TextPaint f929k;

    /* renamed from: l */
    private final TextView f930l;

    /* renamed from: m */
    private final Context f931m;

    C0253ab(TextView textView) {
        this.f930l = textView;
        this.f931m = this.f930l.getContext();
    }

    /* renamed from: a */
    private int m844a(RectF rectF) {
        int length = this.f927i.length;
        if (length != 0) {
            int i = length - 1;
            int i2 = 1;
            int i3 = 0;
            while (i2 <= i) {
                int i4 = (i2 + i) / 2;
                if (m851a(this.f927i[i4], rectF)) {
                    int i5 = i4 + 1;
                    i3 = i2;
                    i2 = i5;
                } else {
                    i3 = i4 - 1;
                    i = i3;
                }
            }
            return this.f927i[i3];
        }
        throw new IllegalStateException("No available text sizes to choose from.");
    }

    /* renamed from: a */
    private StaticLayout m845a(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f929k, i, alignment, this.f930l.getLineSpacingMultiplier(), this.f930l.getLineSpacingExtra(), this.f930l.getIncludeFontPadding());
    }

    /* renamed from: a */
    private static <T> T m846a(Object obj, String str, T t) {
        try {
            return m847a(str).invoke(obj, new Object[0]);
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#" + str + "() method", e);
            return t;
        }
    }

    /* renamed from: a */
    private static Method m847a(String str) {
        try {
            Method method = f920b.get(str);
            if (method == null && (method = TextView.class.getDeclaredMethod(str, new Class[0])) != null) {
                method.setAccessible(true);
                f920b.put(str, method);
            }
            return method;
        } catch (Exception e) {
            Log.w("ACTVAutoSizeHelper", "Failed to retrieve TextView#" + str + "() method", e);
            return null;
        }
    }

    /* renamed from: a */
    private void m848a(float f) {
        if (f != this.f930l.getPaint().getTextSize()) {
            this.f930l.getPaint().setTextSize(f);
            boolean isInLayout = Build.VERSION.SDK_INT >= 18 ? this.f930l.isInLayout() : false;
            if (this.f930l.getLayout() != null) {
                this.f923e = false;
                try {
                    Method a = m847a("nullLayouts");
                    if (a != null) {
                        a.invoke(this.f930l, new Object[0]);
                    }
                } catch (Exception e) {
                    Log.w("ACTVAutoSizeHelper", "Failed to invoke TextView#nullLayouts() method", e);
                }
                if (!isInLayout) {
                    this.f930l.requestLayout();
                } else {
                    this.f930l.forceLayout();
                }
                this.f930l.invalidate();
            }
        }
    }

    /* renamed from: a */
    private void m849a(float f, float f2, float f3) {
        if (f <= 0.0f) {
            throw new IllegalArgumentException("Minimum auto-size text size (" + f + "px) is less or equal to (0px)");
        } else if (f2 <= f) {
            throw new IllegalArgumentException("Maximum auto-size text size (" + f2 + "px) is less or equal to minimum auto-size text size (" + f + "px)");
        } else if (f3 > 0.0f) {
            this.f922d = 1;
            this.f925g = f;
            this.f926h = f2;
            this.f924f = f3;
            this.f928j = false;
        } else {
            throw new IllegalArgumentException("The auto-size step granularity (" + f3 + "px) is less or equal to (0px)");
        }
    }

    /* renamed from: a */
    private void m850a(TypedArray typedArray) {
        int length = typedArray.length();
        int[] iArr = new int[length];
        if (length > 0) {
            for (int i = 0; i < length; i++) {
                iArr[i] = typedArray.getDimensionPixelSize(i, -1);
            }
            this.f927i = m852a(iArr);
            m857h();
        }
    }

    /* renamed from: a */
    private boolean m851a(int i, RectF rectF) {
        CharSequence transformation;
        CharSequence text = this.f930l.getText();
        TransformationMethod transformationMethod = this.f930l.getTransformationMethod();
        if (!(transformationMethod == null || (transformation = transformationMethod.getTransformation(text, this.f930l)) == null)) {
            text = transformation;
        }
        int maxLines = Build.VERSION.SDK_INT >= 16 ? this.f930l.getMaxLines() : -1;
        mo2096b(i);
        StaticLayout a = mo2089a(text, (Layout.Alignment) m846a((Object) this.f930l, "getLayoutAlignment", Layout.Alignment.ALIGN_NORMAL), Math.round(rectF.right), maxLines);
        return (maxLines == -1 || (a.getLineCount() <= maxLines && a.getLineEnd(a.getLineCount() - 1) == text.length())) && ((float) a.getHeight()) <= rectF.bottom;
    }

    /* renamed from: a */
    private int[] m852a(int[] iArr) {
        if (r0 == 0) {
            return iArr;
        }
        Arrays.sort(iArr);
        ArrayList arrayList = new ArrayList();
        for (int i : iArr) {
            if (i > 0 && Collections.binarySearch(arrayList, Integer.valueOf(i)) < 0) {
                arrayList.add(Integer.valueOf(i));
            }
        }
        if (r0 == arrayList.size()) {
            return iArr;
        }
        int size = arrayList.size();
        int[] iArr2 = new int[size];
        for (int i2 = 0; i2 < size; i2++) {
            iArr2[i2] = ((Integer) arrayList.get(i2)).intValue();
        }
        return iArr2;
    }

    /* renamed from: b */
    private StaticLayout m853b(CharSequence charSequence, Layout.Alignment alignment, int i) {
        return new StaticLayout(charSequence, this.f929k, i, alignment, ((Float) m855b((Object) this.f930l, "mSpacingMult", Float.valueOf(1.0f))).floatValue(), ((Float) m855b((Object) this.f930l, "mSpacingAdd", Float.valueOf(0.0f))).floatValue(), ((Boolean) m855b((Object) this.f930l, "mIncludePad", true)).booleanValue());
    }

    /* renamed from: b */
    private StaticLayout m854b(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        StaticLayout.Builder obtain = StaticLayout.Builder.obtain(charSequence, 0, charSequence.length(), this.f929k, i);
        StaticLayout.Builder hyphenationFrequency = obtain.setAlignment(alignment).setLineSpacing(this.f930l.getLineSpacingExtra(), this.f930l.getLineSpacingMultiplier()).setIncludePad(this.f930l.getIncludeFontPadding()).setBreakStrategy(this.f930l.getBreakStrategy()).setHyphenationFrequency(this.f930l.getHyphenationFrequency());
        if (i2 == -1) {
            i2 = Integer.MAX_VALUE;
        }
        hyphenationFrequency.setMaxLines(i2);
        try {
            obtain.setTextDirection(Build.VERSION.SDK_INT >= 29 ? this.f930l.getTextDirectionHeuristic() : (TextDirectionHeuristic) m846a((Object) this.f930l, "getTextDirectionHeuristic", TextDirectionHeuristics.FIRSTSTRONG_LTR));
        } catch (ClassCastException unused) {
            Log.w("ACTVAutoSizeHelper", "Failed to obtain TextDirectionHeuristic, auto size may be incorrect");
        }
        return obtain.build();
    }

    /* renamed from: b */
    private static <T> T m855b(Object obj, String str, T t) {
        try {
            Field b = m856b(str);
            return b == null ? t : b.get(obj);
        } catch (IllegalAccessException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return t;
        }
    }

    /* renamed from: b */
    private static Field m856b(String str) {
        try {
            Field field = f921c.get(str);
            if (field == null && (field = TextView.class.getDeclaredField(str)) != null) {
                field.setAccessible(true);
                f921c.put(str, field);
            }
            return field;
        } catch (NoSuchFieldException e) {
            Log.w("ACTVAutoSizeHelper", "Failed to access TextView#" + str + " member", e);
            return null;
        }
    }

    /* renamed from: h */
    private boolean m857h() {
        int length = this.f927i.length;
        this.f928j = length > 0;
        if (this.f928j) {
            this.f922d = 1;
            int[] iArr = this.f927i;
            this.f925g = (float) iArr[0];
            this.f926h = (float) iArr[length - 1];
            this.f924f = -1.0f;
        }
        return this.f928j;
    }

    /* renamed from: i */
    private boolean m858i() {
        if (!m860k() || this.f922d != 1) {
            this.f923e = false;
        } else {
            if (!this.f928j || this.f927i.length == 0) {
                int floor = ((int) Math.floor((double) ((this.f926h - this.f925g) / this.f924f))) + 1;
                int[] iArr = new int[floor];
                for (int i = 0; i < floor; i++) {
                    iArr[i] = Math.round(this.f925g + (((float) i) * this.f924f));
                }
                this.f927i = m852a(iArr);
            }
            this.f923e = true;
        }
        return this.f923e;
    }

    /* renamed from: j */
    private void m859j() {
        this.f922d = 0;
        this.f925g = -1.0f;
        this.f926h = -1.0f;
        this.f924f = -1.0f;
        this.f927i = new int[0];
        this.f923e = false;
    }

    /* renamed from: k */
    private boolean m860k() {
        return !(this.f930l instanceof C0339l);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo2088a() {
        return this.f922d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public StaticLayout mo2089a(CharSequence charSequence, Layout.Alignment alignment, int i, int i2) {
        return Build.VERSION.SDK_INT >= 23 ? m854b(charSequence, alignment, i, i2) : Build.VERSION.SDK_INT >= 16 ? m845a(charSequence, alignment, i) : m853b(charSequence, alignment, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2090a(int i) {
        if (m860k()) {
            switch (i) {
                case 0:
                    m859j();
                    return;
                case 1:
                    DisplayMetrics displayMetrics = this.f931m.getResources().getDisplayMetrics();
                    m849a(TypedValue.applyDimension(2, 12.0f, displayMetrics), TypedValue.applyDimension(2, 112.0f, displayMetrics), 1.0f);
                    if (m858i()) {
                        mo2100f();
                        return;
                    }
                    return;
                default:
                    throw new IllegalArgumentException("Unknown auto-size text type: " + i);
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2091a(int i, float f) {
        Context context = this.f931m;
        m848a(TypedValue.applyDimension(i, f, (context == null ? Resources.getSystem() : context.getResources()).getDisplayMetrics()));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2092a(int i, int i2, int i3, int i4) {
        if (m860k()) {
            DisplayMetrics displayMetrics = this.f931m.getResources().getDisplayMetrics();
            m849a(TypedValue.applyDimension(i4, (float) i, displayMetrics), TypedValue.applyDimension(i4, (float) i2, displayMetrics), TypedValue.applyDimension(i4, (float) i3, displayMetrics));
            if (m858i()) {
                mo2100f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2093a(AttributeSet attributeSet, int i) {
        int resourceId;
        TypedArray obtainStyledAttributes = this.f931m.obtainStyledAttributes(attributeSet, C0059a.C0069j.AppCompatTextView, i, 0);
        if (obtainStyledAttributes.hasValue(C0059a.C0069j.AppCompatTextView_autoSizeTextType)) {
            this.f922d = obtainStyledAttributes.getInt(C0059a.C0069j.AppCompatTextView_autoSizeTextType, 0);
        }
        float dimension = obtainStyledAttributes.hasValue(C0059a.C0069j.AppCompatTextView_autoSizeStepGranularity) ? obtainStyledAttributes.getDimension(C0059a.C0069j.AppCompatTextView_autoSizeStepGranularity, -1.0f) : -1.0f;
        float dimension2 = obtainStyledAttributes.hasValue(C0059a.C0069j.AppCompatTextView_autoSizeMinTextSize) ? obtainStyledAttributes.getDimension(C0059a.C0069j.AppCompatTextView_autoSizeMinTextSize, -1.0f) : -1.0f;
        float dimension3 = obtainStyledAttributes.hasValue(C0059a.C0069j.AppCompatTextView_autoSizeMaxTextSize) ? obtainStyledAttributes.getDimension(C0059a.C0069j.AppCompatTextView_autoSizeMaxTextSize, -1.0f) : -1.0f;
        if (obtainStyledAttributes.hasValue(C0059a.C0069j.AppCompatTextView_autoSizePresetSizes) && (resourceId = obtainStyledAttributes.getResourceId(C0059a.C0069j.AppCompatTextView_autoSizePresetSizes, 0)) > 0) {
            TypedArray obtainTypedArray = obtainStyledAttributes.getResources().obtainTypedArray(resourceId);
            m850a(obtainTypedArray);
            obtainTypedArray.recycle();
        }
        obtainStyledAttributes.recycle();
        if (!m860k()) {
            this.f922d = 0;
        } else if (this.f922d == 1) {
            if (!this.f928j) {
                DisplayMetrics displayMetrics = this.f931m.getResources().getDisplayMetrics();
                if (dimension2 == -1.0f) {
                    dimension2 = TypedValue.applyDimension(2, 12.0f, displayMetrics);
                }
                if (dimension3 == -1.0f) {
                    dimension3 = TypedValue.applyDimension(2, 112.0f, displayMetrics);
                }
                if (dimension == -1.0f) {
                    dimension = 1.0f;
                }
                m849a(dimension2, dimension3, dimension);
            }
            m858i();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2094a(int[] iArr, int i) {
        if (m860k()) {
            int length = iArr.length;
            if (length > 0) {
                int[] iArr2 = new int[length];
                if (i == 0) {
                    iArr2 = Arrays.copyOf(iArr, length);
                } else {
                    DisplayMetrics displayMetrics = this.f931m.getResources().getDisplayMetrics();
                    for (int i2 = 0; i2 < length; i2++) {
                        iArr2[i2] = Math.round(TypedValue.applyDimension(i, (float) iArr[i2], displayMetrics));
                    }
                }
                this.f927i = m852a(iArr2);
                if (!m857h()) {
                    throw new IllegalArgumentException("None of the preset sizes is valid: " + Arrays.toString(iArr));
                }
            } else {
                this.f928j = false;
            }
            if (m858i()) {
                mo2100f();
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo2095b() {
        return Math.round(this.f924f);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2096b(int i) {
        TextPaint textPaint = this.f929k;
        if (textPaint == null) {
            this.f929k = new TextPaint();
        } else {
            textPaint.reset();
        }
        this.f929k.set(this.f930l.getPaint());
        this.f929k.setTextSize((float) i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public int mo2097c() {
        return Math.round(this.f925g);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public int mo2098d() {
        return Math.round(this.f926h);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int[] mo2099e() {
        return this.f927i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo2100f() {
        if (mo2101g()) {
            if (this.f923e) {
                if (this.f930l.getMeasuredHeight() > 0 && this.f930l.getMeasuredWidth() > 0) {
                    int measuredWidth = Build.VERSION.SDK_INT >= 29 ? this.f930l.isHorizontallyScrollable() : ((Boolean) m846a((Object) this.f930l, "getHorizontallyScrolling", false)).booleanValue() ? PKIFailureInfo.badCertTemplate : (this.f930l.getMeasuredWidth() - this.f930l.getTotalPaddingLeft()) - this.f930l.getTotalPaddingRight();
                    int height = (this.f930l.getHeight() - this.f930l.getCompoundPaddingBottom()) - this.f930l.getCompoundPaddingTop();
                    if (measuredWidth > 0 && height > 0) {
                        synchronized (f919a) {
                            f919a.setEmpty();
                            f919a.right = (float) measuredWidth;
                            f919a.bottom = (float) height;
                            float a = (float) m844a(f919a);
                            if (a != this.f930l.getTextSize()) {
                                mo2091a(0, a);
                            }
                        }
                    } else {
                        return;
                    }
                } else {
                    return;
                }
            }
            this.f923e = true;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo2101g() {
        return m860k() && this.f922d != 0;
    }
}
