package androidx.p050k.p051a.p052a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.ColorFilter;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.VectorDrawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.p025a.C0531b;
import androidx.core.content.p025a.C0544g;
import androidx.core.graphics.C0590b;
import androidx.core.graphics.drawable.C0595a;
import androidx.p018c.C0400a;
import java.util.ArrayDeque;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

/* renamed from: androidx.k.a.a.i */
public class C0911i extends C0910h {

    /* renamed from: a */
    static final PorterDuff.Mode f2961a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private C0919g f2962b;

    /* renamed from: d */
    private PorterDuffColorFilter f2963d;

    /* renamed from: e */
    private ColorFilter f2964e;

    /* renamed from: f */
    private boolean f2965f;

    /* renamed from: g */
    private boolean f2966g;

    /* renamed from: h */
    private Drawable.ConstantState f2967h;

    /* renamed from: i */
    private final float[] f2968i;

    /* renamed from: j */
    private final Matrix f2969j;

    /* renamed from: k */
    private final Rect f2970k;

    /* renamed from: androidx.k.a.a.i$a */
    private static class C0913a extends C0917e {
        C0913a() {
        }

        C0913a(C0913a aVar) {
            super(aVar);
        }

        /* renamed from: a */
        private void m3634a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2997m = string;
            }
            String string2 = typedArray.getString(1);
            if (string2 != null) {
                this.f2996l = C0590b.m2282b(string2);
            }
            this.f2998n = C0544g.m2154a(typedArray, xmlPullParser, "fillType", 2, 0);
        }

        /* renamed from: a */
        public void mo4917a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            if (C0544g.m2161a(xmlPullParser, "pathData")) {
                TypedArray a = C0544g.m2157a(resources, theme, attributeSet, C0899a.f2934d);
                m3634a(a, xmlPullParser);
                a.recycle();
            }
        }

        /* renamed from: a */
        public boolean mo4918a() {
            return true;
        }
    }

    /* renamed from: androidx.k.a.a.i$b */
    private static class C0914b extends C0917e {

        /* renamed from: a */
        C0531b f2971a;

        /* renamed from: b */
        float f2972b = 0.0f;

        /* renamed from: c */
        C0531b f2973c;

        /* renamed from: d */
        float f2974d = 1.0f;

        /* renamed from: e */
        float f2975e = 1.0f;

        /* renamed from: f */
        float f2976f = 0.0f;

        /* renamed from: g */
        float f2977g = 1.0f;

        /* renamed from: h */
        float f2978h = 0.0f;

        /* renamed from: i */
        Paint.Cap f2979i = Paint.Cap.BUTT;

        /* renamed from: j */
        Paint.Join f2980j = Paint.Join.MITER;

        /* renamed from: k */
        float f2981k = 4.0f;

        /* renamed from: p */
        private int[] f2982p;

        C0914b() {
        }

        C0914b(C0914b bVar) {
            super(bVar);
            this.f2982p = bVar.f2982p;
            this.f2971a = bVar.f2971a;
            this.f2972b = bVar.f2972b;
            this.f2974d = bVar.f2974d;
            this.f2973c = bVar.f2973c;
            this.f2998n = bVar.f2998n;
            this.f2975e = bVar.f2975e;
            this.f2976f = bVar.f2976f;
            this.f2977g = bVar.f2977g;
            this.f2978h = bVar.f2978h;
            this.f2979i = bVar.f2979i;
            this.f2980j = bVar.f2980j;
            this.f2981k = bVar.f2981k;
        }

        /* renamed from: a */
        private Paint.Cap m3637a(int i, Paint.Cap cap) {
            switch (i) {
                case 0:
                    return Paint.Cap.BUTT;
                case 1:
                    return Paint.Cap.ROUND;
                case 2:
                    return Paint.Cap.SQUARE;
                default:
                    return cap;
            }
        }

        /* renamed from: a */
        private Paint.Join m3638a(int i, Paint.Join join) {
            switch (i) {
                case 0:
                    return Paint.Join.MITER;
                case 1:
                    return Paint.Join.ROUND;
                case 2:
                    return Paint.Join.BEVEL;
                default:
                    return join;
            }
        }

        /* renamed from: a */
        private void m3639a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
            this.f2982p = null;
            if (C0544g.m2161a(xmlPullParser, "pathData")) {
                String string = typedArray.getString(0);
                if (string != null) {
                    this.f2997m = string;
                }
                String string2 = typedArray.getString(2);
                if (string2 != null) {
                    this.f2996l = C0590b.m2282b(string2);
                }
                Resources.Theme theme2 = theme;
                this.f2973c = C0544g.m2158a(typedArray, xmlPullParser, theme2, "fillColor", 1, 0);
                this.f2975e = C0544g.m2153a(typedArray, xmlPullParser, "fillAlpha", 12, this.f2975e);
                this.f2979i = m3637a(C0544g.m2154a(typedArray, xmlPullParser, "strokeLineCap", 8, -1), this.f2979i);
                this.f2980j = m3638a(C0544g.m2154a(typedArray, xmlPullParser, "strokeLineJoin", 9, -1), this.f2980j);
                this.f2981k = C0544g.m2153a(typedArray, xmlPullParser, "strokeMiterLimit", 10, this.f2981k);
                this.f2971a = C0544g.m2158a(typedArray, xmlPullParser, theme2, "strokeColor", 3, 0);
                this.f2974d = C0544g.m2153a(typedArray, xmlPullParser, "strokeAlpha", 11, this.f2974d);
                this.f2972b = C0544g.m2153a(typedArray, xmlPullParser, "strokeWidth", 4, this.f2972b);
                this.f2977g = C0544g.m2153a(typedArray, xmlPullParser, "trimPathEnd", 6, this.f2977g);
                this.f2978h = C0544g.m2153a(typedArray, xmlPullParser, "trimPathOffset", 7, this.f2978h);
                this.f2976f = C0544g.m2153a(typedArray, xmlPullParser, "trimPathStart", 5, this.f2976f);
                this.f2998n = C0544g.m2154a(typedArray, xmlPullParser, "fillType", 13, this.f2998n);
            }
        }

        /* renamed from: a */
        public void mo4919a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = C0544g.m2157a(resources, theme, attributeSet, C0899a.f2933c);
            m3639a(a, xmlPullParser, theme);
            a.recycle();
        }

        /* renamed from: a */
        public boolean mo4920a(int[] iArr) {
            return this.f2971a.mo3520a(iArr) | this.f2973c.mo3520a(iArr);
        }

        /* renamed from: b */
        public boolean mo4921b() {
            return this.f2973c.mo3524d() || this.f2971a.mo3524d();
        }

        /* access modifiers changed from: package-private */
        public float getFillAlpha() {
            return this.f2975e;
        }

        /* access modifiers changed from: package-private */
        public int getFillColor() {
            return this.f2973c.mo3521b();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeAlpha() {
            return this.f2974d;
        }

        /* access modifiers changed from: package-private */
        public int getStrokeColor() {
            return this.f2971a.mo3521b();
        }

        /* access modifiers changed from: package-private */
        public float getStrokeWidth() {
            return this.f2972b;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathEnd() {
            return this.f2977g;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathOffset() {
            return this.f2978h;
        }

        /* access modifiers changed from: package-private */
        public float getTrimPathStart() {
            return this.f2976f;
        }

        /* access modifiers changed from: package-private */
        public void setFillAlpha(float f) {
            this.f2975e = f;
        }

        /* access modifiers changed from: package-private */
        public void setFillColor(int i) {
            this.f2973c.mo3522b(i);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeAlpha(float f) {
            this.f2974d = f;
        }

        /* access modifiers changed from: package-private */
        public void setStrokeColor(int i) {
            this.f2971a.mo3522b(i);
        }

        /* access modifiers changed from: package-private */
        public void setStrokeWidth(float f) {
            this.f2972b = f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathEnd(float f) {
            this.f2977g = f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathOffset(float f) {
            this.f2978h = f;
        }

        /* access modifiers changed from: package-private */
        public void setTrimPathStart(float f) {
            this.f2976f = f;
        }
    }

    /* renamed from: androidx.k.a.a.i$c */
    private static class C0915c extends C0916d {

        /* renamed from: a */
        final Matrix f2983a = new Matrix();

        /* renamed from: b */
        final ArrayList<C0916d> f2984b = new ArrayList<>();

        /* renamed from: c */
        float f2985c = 0.0f;

        /* renamed from: d */
        final Matrix f2986d = new Matrix();

        /* renamed from: e */
        int f2987e;

        /* renamed from: f */
        private float f2988f = 0.0f;

        /* renamed from: g */
        private float f2989g = 0.0f;

        /* renamed from: h */
        private float f2990h = 1.0f;

        /* renamed from: i */
        private float f2991i = 1.0f;

        /* renamed from: j */
        private float f2992j = 0.0f;

        /* renamed from: k */
        private float f2993k = 0.0f;

        /* renamed from: l */
        private int[] f2994l;

        /* renamed from: m */
        private String f2995m = null;

        public C0915c() {
            super();
        }

        public C0915c(C0915c cVar, C0400a<String, Object> aVar) {
            super();
            C0917e eVar;
            this.f2985c = cVar.f2985c;
            this.f2988f = cVar.f2988f;
            this.f2989g = cVar.f2989g;
            this.f2990h = cVar.f2990h;
            this.f2991i = cVar.f2991i;
            this.f2992j = cVar.f2992j;
            this.f2993k = cVar.f2993k;
            this.f2994l = cVar.f2994l;
            this.f2995m = cVar.f2995m;
            this.f2987e = cVar.f2987e;
            String str = this.f2995m;
            if (str != null) {
                aVar.put(str, this);
            }
            this.f2986d.set(cVar.f2986d);
            ArrayList<C0916d> arrayList = cVar.f2984b;
            for (int i = 0; i < arrayList.size(); i++) {
                C0916d dVar = arrayList.get(i);
                if (dVar instanceof C0915c) {
                    this.f2984b.add(new C0915c((C0915c) dVar, aVar));
                } else {
                    if (dVar instanceof C0914b) {
                        eVar = new C0914b((C0914b) dVar);
                    } else if (dVar instanceof C0913a) {
                        eVar = new C0913a((C0913a) dVar);
                    } else {
                        throw new IllegalStateException("Unknown object in the tree!");
                    }
                    this.f2984b.add(eVar);
                    if (eVar.f2997m != null) {
                        aVar.put(eVar.f2997m, eVar);
                    }
                }
            }
        }

        /* renamed from: a */
        private void m3643a() {
            this.f2986d.reset();
            this.f2986d.postTranslate(-this.f2988f, -this.f2989g);
            this.f2986d.postScale(this.f2990h, this.f2991i);
            this.f2986d.postRotate(this.f2985c, 0.0f, 0.0f);
            this.f2986d.postTranslate(this.f2992j + this.f2988f, this.f2993k + this.f2989g);
        }

        /* renamed from: a */
        private void m3644a(TypedArray typedArray, XmlPullParser xmlPullParser) {
            this.f2994l = null;
            this.f2985c = C0544g.m2153a(typedArray, xmlPullParser, "rotation", 5, this.f2985c);
            this.f2988f = typedArray.getFloat(1, this.f2988f);
            this.f2989g = typedArray.getFloat(2, this.f2989g);
            this.f2990h = C0544g.m2153a(typedArray, xmlPullParser, "scaleX", 3, this.f2990h);
            this.f2991i = C0544g.m2153a(typedArray, xmlPullParser, "scaleY", 4, this.f2991i);
            this.f2992j = C0544g.m2153a(typedArray, xmlPullParser, "translateX", 6, this.f2992j);
            this.f2993k = C0544g.m2153a(typedArray, xmlPullParser, "translateY", 7, this.f2993k);
            String string = typedArray.getString(0);
            if (string != null) {
                this.f2995m = string;
            }
            m3643a();
        }

        /* renamed from: a */
        public void mo4938a(Resources resources, AttributeSet attributeSet, Resources.Theme theme, XmlPullParser xmlPullParser) {
            TypedArray a = C0544g.m2157a(resources, theme, attributeSet, C0899a.f2932b);
            m3644a(a, xmlPullParser);
            a.recycle();
        }

        /* renamed from: a */
        public boolean mo4920a(int[] iArr) {
            boolean z = false;
            for (int i = 0; i < this.f2984b.size(); i++) {
                z |= this.f2984b.get(i).mo4920a(iArr);
            }
            return z;
        }

        /* renamed from: b */
        public boolean mo4921b() {
            for (int i = 0; i < this.f2984b.size(); i++) {
                if (this.f2984b.get(i).mo4921b()) {
                    return true;
                }
            }
            return false;
        }

        public String getGroupName() {
            return this.f2995m;
        }

        public Matrix getLocalMatrix() {
            return this.f2986d;
        }

        public float getPivotX() {
            return this.f2988f;
        }

        public float getPivotY() {
            return this.f2989g;
        }

        public float getRotation() {
            return this.f2985c;
        }

        public float getScaleX() {
            return this.f2990h;
        }

        public float getScaleY() {
            return this.f2991i;
        }

        public float getTranslateX() {
            return this.f2992j;
        }

        public float getTranslateY() {
            return this.f2993k;
        }

        public void setPivotX(float f) {
            if (f != this.f2988f) {
                this.f2988f = f;
                m3643a();
            }
        }

        public void setPivotY(float f) {
            if (f != this.f2989g) {
                this.f2989g = f;
                m3643a();
            }
        }

        public void setRotation(float f) {
            if (f != this.f2985c) {
                this.f2985c = f;
                m3643a();
            }
        }

        public void setScaleX(float f) {
            if (f != this.f2990h) {
                this.f2990h = f;
                m3643a();
            }
        }

        public void setScaleY(float f) {
            if (f != this.f2991i) {
                this.f2991i = f;
                m3643a();
            }
        }

        public void setTranslateX(float f) {
            if (f != this.f2992j) {
                this.f2992j = f;
                m3643a();
            }
        }

        public void setTranslateY(float f) {
            if (f != this.f2993k) {
                this.f2993k = f;
                m3643a();
            }
        }
    }

    /* renamed from: androidx.k.a.a.i$d */
    private static abstract class C0916d {
        private C0916d() {
        }

        /* renamed from: a */
        public boolean mo4920a(int[] iArr) {
            return false;
        }

        /* renamed from: b */
        public boolean mo4921b() {
            return false;
        }
    }

    /* renamed from: androidx.k.a.a.i$e */
    private static abstract class C0917e extends C0916d {

        /* renamed from: l */
        protected C0590b.C0592b[] f2996l = null;

        /* renamed from: m */
        String f2997m;

        /* renamed from: n */
        int f2998n = 0;

        /* renamed from: o */
        int f2999o;

        public C0917e() {
            super();
        }

        public C0917e(C0917e eVar) {
            super();
            this.f2997m = eVar.f2997m;
            this.f2999o = eVar.f2999o;
            this.f2996l = C0590b.m2280a(eVar.f2996l);
        }

        /* renamed from: a */
        public void mo4955a(Path path) {
            path.reset();
            C0590b.C0592b[] bVarArr = this.f2996l;
            if (bVarArr != null) {
                C0590b.C0592b.m2287a(bVarArr, path);
            }
        }

        /* renamed from: a */
        public boolean mo4918a() {
            return false;
        }

        public C0590b.C0592b[] getPathData() {
            return this.f2996l;
        }

        public String getPathName() {
            return this.f2997m;
        }

        public void setPathData(C0590b.C0592b[] bVarArr) {
            if (!C0590b.m2278a(this.f2996l, bVarArr)) {
                this.f2996l = C0590b.m2280a(bVarArr);
            } else {
                C0590b.m2281b(this.f2996l, bVarArr);
            }
        }
    }

    /* renamed from: androidx.k.a.a.i$f */
    private static class C0918f {

        /* renamed from: n */
        private static final Matrix f3000n = new Matrix();

        /* renamed from: a */
        Paint f3001a;

        /* renamed from: b */
        Paint f3002b;

        /* renamed from: c */
        final C0915c f3003c;

        /* renamed from: d */
        float f3004d;

        /* renamed from: e */
        float f3005e;

        /* renamed from: f */
        float f3006f;

        /* renamed from: g */
        float f3007g;

        /* renamed from: h */
        int f3008h;

        /* renamed from: i */
        String f3009i;

        /* renamed from: j */
        Boolean f3010j;

        /* renamed from: k */
        final C0400a<String, Object> f3011k;

        /* renamed from: l */
        private final Path f3012l;

        /* renamed from: m */
        private final Path f3013m;

        /* renamed from: o */
        private final Matrix f3014o;

        /* renamed from: p */
        private PathMeasure f3015p;

        /* renamed from: q */
        private int f3016q;

        public C0918f() {
            this.f3014o = new Matrix();
            this.f3004d = 0.0f;
            this.f3005e = 0.0f;
            this.f3006f = 0.0f;
            this.f3007g = 0.0f;
            this.f3008h = 255;
            this.f3009i = null;
            this.f3010j = null;
            this.f3011k = new C0400a<>();
            this.f3003c = new C0915c();
            this.f3012l = new Path();
            this.f3013m = new Path();
        }

        public C0918f(C0918f fVar) {
            this.f3014o = new Matrix();
            this.f3004d = 0.0f;
            this.f3005e = 0.0f;
            this.f3006f = 0.0f;
            this.f3007g = 0.0f;
            this.f3008h = 255;
            this.f3009i = null;
            this.f3010j = null;
            this.f3011k = new C0400a<>();
            this.f3003c = new C0915c(fVar.f3003c, this.f3011k);
            this.f3012l = new Path(fVar.f3012l);
            this.f3013m = new Path(fVar.f3013m);
            this.f3004d = fVar.f3004d;
            this.f3005e = fVar.f3005e;
            this.f3006f = fVar.f3006f;
            this.f3007g = fVar.f3007g;
            this.f3016q = fVar.f3016q;
            this.f3008h = fVar.f3008h;
            this.f3009i = fVar.f3009i;
            String str = fVar.f3009i;
            if (str != null) {
                this.f3011k.put(str, this);
            }
            this.f3010j = fVar.f3010j;
        }

        /* renamed from: a */
        private static float m3652a(float f, float f2, float f3, float f4) {
            return (f * f4) - (f2 * f3);
        }

        /* renamed from: a */
        private float m3653a(Matrix matrix) {
            float[] fArr = {0.0f, 1.0f, 1.0f, 0.0f};
            matrix.mapVectors(fArr);
            float a = m3652a(fArr[0], fArr[1], fArr[2], fArr[3]);
            float max = Math.max((float) Math.hypot((double) fArr[0], (double) fArr[1]), (float) Math.hypot((double) fArr[2], (double) fArr[3]));
            if (max > 0.0f) {
                return Math.abs(a) / max;
            }
            return 0.0f;
        }

        /* renamed from: a */
        private void m3654a(C0915c cVar, Matrix matrix, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            cVar.f2983a.set(matrix);
            cVar.f2983a.preConcat(cVar.f2986d);
            canvas.save();
            for (int i3 = 0; i3 < cVar.f2984b.size(); i3++) {
                C0916d dVar = cVar.f2984b.get(i3);
                if (dVar instanceof C0915c) {
                    m3654a((C0915c) dVar, cVar.f2983a, canvas, i, i2, colorFilter);
                } else if (dVar instanceof C0917e) {
                    m3655a(cVar, (C0917e) dVar, canvas, i, i2, colorFilter);
                }
            }
            canvas.restore();
        }

        /* renamed from: a */
        private void m3655a(C0915c cVar, C0917e eVar, Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            float f = ((float) i) / this.f3006f;
            float f2 = ((float) i2) / this.f3007g;
            float min = Math.min(f, f2);
            Matrix matrix = cVar.f2983a;
            this.f3014o.set(matrix);
            this.f3014o.postScale(f, f2);
            float a = m3653a(matrix);
            if (a != 0.0f) {
                eVar.mo4955a(this.f3012l);
                Path path = this.f3012l;
                this.f3013m.reset();
                if (eVar.mo4918a()) {
                    this.f3013m.setFillType(eVar.f2998n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    this.f3013m.addPath(path, this.f3014o);
                    canvas.clipPath(this.f3013m);
                    return;
                }
                C0914b bVar = (C0914b) eVar;
                if (!(bVar.f2976f == 0.0f && bVar.f2977g == 1.0f)) {
                    float f3 = (bVar.f2976f + bVar.f2978h) % 1.0f;
                    float f4 = (bVar.f2977g + bVar.f2978h) % 1.0f;
                    if (this.f3015p == null) {
                        this.f3015p = new PathMeasure();
                    }
                    this.f3015p.setPath(this.f3012l, false);
                    float length = this.f3015p.getLength();
                    float f5 = f3 * length;
                    float f6 = f4 * length;
                    path.reset();
                    if (f5 > f6) {
                        this.f3015p.getSegment(f5, length, path, true);
                        this.f3015p.getSegment(0.0f, f6, path, true);
                    } else {
                        this.f3015p.getSegment(f5, f6, path, true);
                    }
                    path.rLineTo(0.0f, 0.0f);
                }
                this.f3013m.addPath(path, this.f3014o);
                if (bVar.f2973c.mo3525e()) {
                    C0531b bVar2 = bVar.f2973c;
                    if (this.f3002b == null) {
                        this.f3002b = new Paint(1);
                        this.f3002b.setStyle(Paint.Style.FILL);
                    }
                    Paint paint = this.f3002b;
                    if (bVar2.mo3523c()) {
                        Shader a2 = bVar2.mo3519a();
                        a2.setLocalMatrix(this.f3014o);
                        paint.setShader(a2);
                        paint.setAlpha(Math.round(bVar.f2975e * 255.0f));
                    } else {
                        paint.setShader((Shader) null);
                        paint.setAlpha(255);
                        paint.setColor(C0911i.m3624a(bVar2.mo3521b(), bVar.f2975e));
                    }
                    paint.setColorFilter(colorFilter);
                    this.f3013m.setFillType(bVar.f2998n == 0 ? Path.FillType.WINDING : Path.FillType.EVEN_ODD);
                    canvas.drawPath(this.f3013m, paint);
                }
                if (bVar.f2971a.mo3525e()) {
                    C0531b bVar3 = bVar.f2971a;
                    if (this.f3001a == null) {
                        this.f3001a = new Paint(1);
                        this.f3001a.setStyle(Paint.Style.STROKE);
                    }
                    Paint paint2 = this.f3001a;
                    if (bVar.f2980j != null) {
                        paint2.setStrokeJoin(bVar.f2980j);
                    }
                    if (bVar.f2979i != null) {
                        paint2.setStrokeCap(bVar.f2979i);
                    }
                    paint2.setStrokeMiter(bVar.f2981k);
                    if (bVar3.mo3523c()) {
                        Shader a3 = bVar3.mo3519a();
                        a3.setLocalMatrix(this.f3014o);
                        paint2.setShader(a3);
                        paint2.setAlpha(Math.round(bVar.f2974d * 255.0f));
                    } else {
                        paint2.setShader((Shader) null);
                        paint2.setAlpha(255);
                        paint2.setColor(C0911i.m3624a(bVar3.mo3521b(), bVar.f2974d));
                    }
                    paint2.setColorFilter(colorFilter);
                    paint2.setStrokeWidth(bVar.f2972b * min * a);
                    canvas.drawPath(this.f3013m, paint2);
                }
            }
        }

        /* renamed from: a */
        public void mo4959a(Canvas canvas, int i, int i2, ColorFilter colorFilter) {
            m3654a(this.f3003c, f3000n, canvas, i, i2, colorFilter);
        }

        /* renamed from: a */
        public boolean mo4960a() {
            if (this.f3010j == null) {
                this.f3010j = Boolean.valueOf(this.f3003c.mo4921b());
            }
            return this.f3010j.booleanValue();
        }

        /* renamed from: a */
        public boolean mo4961a(int[] iArr) {
            return this.f3003c.mo4920a(iArr);
        }

        public float getAlpha() {
            return ((float) getRootAlpha()) / 255.0f;
        }

        public int getRootAlpha() {
            return this.f3008h;
        }

        public void setAlpha(float f) {
            setRootAlpha((int) (f * 255.0f));
        }

        public void setRootAlpha(int i) {
            this.f3008h = i;
        }
    }

    /* renamed from: androidx.k.a.a.i$g */
    private static class C0919g extends Drawable.ConstantState {

        /* renamed from: a */
        int f3017a;

        /* renamed from: b */
        C0918f f3018b;

        /* renamed from: c */
        ColorStateList f3019c;

        /* renamed from: d */
        PorterDuff.Mode f3020d;

        /* renamed from: e */
        boolean f3021e;

        /* renamed from: f */
        Bitmap f3022f;

        /* renamed from: g */
        ColorStateList f3023g;

        /* renamed from: h */
        PorterDuff.Mode f3024h;

        /* renamed from: i */
        int f3025i;

        /* renamed from: j */
        boolean f3026j;

        /* renamed from: k */
        boolean f3027k;

        /* renamed from: l */
        Paint f3028l;

        public C0919g() {
            this.f3019c = null;
            this.f3020d = C0911i.f2961a;
            this.f3018b = new C0918f();
        }

        public C0919g(C0919g gVar) {
            this.f3019c = null;
            this.f3020d = C0911i.f2961a;
            if (gVar != null) {
                this.f3017a = gVar.f3017a;
                this.f3018b = new C0918f(gVar.f3018b);
                if (gVar.f3018b.f3002b != null) {
                    this.f3018b.f3002b = new Paint(gVar.f3018b.f3002b);
                }
                if (gVar.f3018b.f3001a != null) {
                    this.f3018b.f3001a = new Paint(gVar.f3018b.f3001a);
                }
                this.f3019c = gVar.f3019c;
                this.f3020d = gVar.f3020d;
                this.f3021e = gVar.f3021e;
            }
        }

        /* renamed from: a */
        public Paint mo4966a(ColorFilter colorFilter) {
            if (!mo4969a() && colorFilter == null) {
                return null;
            }
            if (this.f3028l == null) {
                this.f3028l = new Paint();
                this.f3028l.setFilterBitmap(true);
            }
            this.f3028l.setAlpha(this.f3018b.getRootAlpha());
            this.f3028l.setColorFilter(colorFilter);
            return this.f3028l;
        }

        /* renamed from: a */
        public void mo4967a(int i, int i2) {
            this.f3022f.eraseColor(0);
            this.f3018b.mo4959a(new Canvas(this.f3022f), i, i2, (ColorFilter) null);
        }

        /* renamed from: a */
        public void mo4968a(Canvas canvas, ColorFilter colorFilter, Rect rect) {
            canvas.drawBitmap(this.f3022f, (Rect) null, rect, mo4966a(colorFilter));
        }

        /* renamed from: a */
        public boolean mo4969a() {
            return this.f3018b.getRootAlpha() < 255;
        }

        /* renamed from: a */
        public boolean mo4970a(int[] iArr) {
            boolean a = this.f3018b.mo4961a(iArr);
            this.f3027k |= a;
            return a;
        }

        /* renamed from: b */
        public void mo4971b(int i, int i2) {
            if (this.f3022f == null || !mo4974c(i, i2)) {
                this.f3022f = Bitmap.createBitmap(i, i2, Bitmap.Config.ARGB_8888);
                this.f3027k = true;
            }
        }

        /* renamed from: b */
        public boolean mo4972b() {
            return !this.f3027k && this.f3023g == this.f3019c && this.f3024h == this.f3020d && this.f3026j == this.f3021e && this.f3025i == this.f3018b.getRootAlpha();
        }

        /* renamed from: c */
        public void mo4973c() {
            this.f3023g = this.f3019c;
            this.f3024h = this.f3020d;
            this.f3025i = this.f3018b.getRootAlpha();
            this.f3026j = this.f3021e;
            this.f3027k = false;
        }

        /* renamed from: c */
        public boolean mo4974c(int i, int i2) {
            return i == this.f3022f.getWidth() && i2 == this.f3022f.getHeight();
        }

        /* renamed from: d */
        public boolean mo4975d() {
            return this.f3018b.mo4960a();
        }

        public int getChangingConfigurations() {
            return this.f3017a;
        }

        public Drawable newDrawable() {
            return new C0911i(this);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0911i(this);
        }
    }

    /* renamed from: androidx.k.a.a.i$h */
    private static class C0920h extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f3029a;

        public C0920h(Drawable.ConstantState constantState) {
            this.f3029a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f3029a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f3029a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            C0911i iVar = new C0911i();
            iVar.f2960c = (VectorDrawable) this.f3029a.newDrawable();
            return iVar;
        }

        public Drawable newDrawable(Resources resources) {
            C0911i iVar = new C0911i();
            iVar.f2960c = (VectorDrawable) this.f3029a.newDrawable(resources);
            return iVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C0911i iVar = new C0911i();
            iVar.f2960c = (VectorDrawable) this.f3029a.newDrawable(resources, theme);
            return iVar;
        }
    }

    C0911i() {
        this.f2966g = true;
        this.f2968i = new float[9];
        this.f2969j = new Matrix();
        this.f2970k = new Rect();
        this.f2962b = new C0919g();
    }

    C0911i(C0919g gVar) {
        this.f2966g = true;
        this.f2968i = new float[9];
        this.f2969j = new Matrix();
        this.f2970k = new Rect();
        this.f2962b = gVar;
        this.f2963d = mo4892a(this.f2963d, gVar.f3019c, gVar.f3020d);
    }

    /* renamed from: a */
    static int m3624a(int i, float f) {
        return (i & 16777215) | (((int) (((float) Color.alpha(i)) * f)) << 24);
    }

    /* renamed from: a */
    private static PorterDuff.Mode m3625a(int i, PorterDuff.Mode mode) {
        if (i == 3) {
            return PorterDuff.Mode.SRC_OVER;
        }
        if (i == 5) {
            return PorterDuff.Mode.SRC_IN;
        }
        if (i == 9) {
            return PorterDuff.Mode.SRC_ATOP;
        }
        switch (i) {
            case 14:
                return PorterDuff.Mode.MULTIPLY;
            case 15:
                return PorterDuff.Mode.SCREEN;
            case 16:
                return PorterDuff.Mode.ADD;
            default:
                return mode;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034 A[Catch:{ IOException | XmlPullParserException -> 0x0041 }] */
    /* JADX WARNING: Removed duplicated region for block: B:14:0x0039 A[Catch:{ IOException | XmlPullParserException -> 0x0041 }] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static androidx.p050k.p051a.p052a.C0911i m3626a(android.content.res.Resources r4, int r5, android.content.res.Resources.Theme r6) {
        /*
            int r0 = android.os.Build.VERSION.SDK_INT
            r1 = 24
            if (r0 < r1) goto L_0x001f
            androidx.k.a.a.i r0 = new androidx.k.a.a.i
            r0.<init>()
            android.graphics.drawable.Drawable r4 = androidx.core.content.p025a.C0540f.m2151a(r4, r5, r6)
            r0.f2960c = r4
            androidx.k.a.a.i$h r4 = new androidx.k.a.a.i$h
            android.graphics.drawable.Drawable r5 = r0.f2960c
            android.graphics.drawable.Drawable$ConstantState r5 = r5.getConstantState()
            r4.<init>(r5)
            r0.f2967h = r4
            return r0
        L_0x001f:
            android.content.res.XmlResourceParser r5 = r4.getXml(r5)     // Catch:{ XmlPullParserException -> 0x0043, IOException -> 0x0041 }
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r5)     // Catch:{ XmlPullParserException -> 0x0043, IOException -> 0x0041 }
        L_0x0027:
            int r1 = r5.next()     // Catch:{ XmlPullParserException -> 0x0043, IOException -> 0x0041 }
            r2 = 2
            if (r1 == r2) goto L_0x0032
            r3 = 1
            if (r1 == r3) goto L_0x0032
            goto L_0x0027
        L_0x0032:
            if (r1 != r2) goto L_0x0039
            androidx.k.a.a.i r4 = m3627a(r4, r5, r0, r6)     // Catch:{ XmlPullParserException -> 0x0043, IOException -> 0x0041 }
            return r4
        L_0x0039:
            org.xmlpull.v1.XmlPullParserException r4 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ XmlPullParserException -> 0x0043, IOException -> 0x0041 }
            java.lang.String r5 = "No start tag found"
            r4.<init>(r5)     // Catch:{ XmlPullParserException -> 0x0043, IOException -> 0x0041 }
            throw r4     // Catch:{ XmlPullParserException -> 0x0043, IOException -> 0x0041 }
        L_0x0041:
            r4 = move-exception
            goto L_0x0044
        L_0x0043:
            r4 = move-exception
        L_0x0044:
            java.lang.String r5 = "VectorDrawableCompat"
            java.lang.String r6 = "parser error"
            android.util.Log.e(r5, r6, r4)
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p050k.p051a.p052a.C0911i.m3626a(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.k.a.a.i");
    }

    /* renamed from: a */
    public static C0911i m3627a(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0911i iVar = new C0911i();
        iVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return iVar;
    }

    /* renamed from: a */
    private void m3628a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme) {
        C0919g gVar = this.f2962b;
        C0918f fVar = gVar.f3018b;
        gVar.f3020d = m3625a(C0544g.m2154a(typedArray, xmlPullParser, "tintMode", 6, -1), PorterDuff.Mode.SRC_IN);
        ColorStateList a = C0544g.m2155a(typedArray, xmlPullParser, theme, "tint", 1);
        if (a != null) {
            gVar.f3019c = a;
        }
        gVar.f3021e = C0544g.m2160a(typedArray, xmlPullParser, "autoMirrored", 5, gVar.f3021e);
        fVar.f3006f = C0544g.m2153a(typedArray, xmlPullParser, "viewportWidth", 7, fVar.f3006f);
        fVar.f3007g = C0544g.m2153a(typedArray, xmlPullParser, "viewportHeight", 8, fVar.f3007g);
        if (fVar.f3006f <= 0.0f) {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportWidth > 0");
        } else if (fVar.f3007g > 0.0f) {
            fVar.f3004d = typedArray.getDimension(3, fVar.f3004d);
            fVar.f3005e = typedArray.getDimension(2, fVar.f3005e);
            if (fVar.f3004d <= 0.0f) {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires width > 0");
            } else if (fVar.f3005e > 0.0f) {
                fVar.setAlpha(C0544g.m2153a(typedArray, xmlPullParser, "alpha", 4, fVar.getAlpha()));
                String string = typedArray.getString(0);
                if (string != null) {
                    fVar.f3009i = string;
                    fVar.f3011k.put(string, fVar);
                }
            } else {
                throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires height > 0");
            }
        } else {
            throw new XmlPullParserException(typedArray.getPositionDescription() + "<vector> tag requires viewportHeight > 0");
        }
    }

    /* renamed from: a */
    private boolean m3629a() {
        return Build.VERSION.SDK_INT >= 17 && isAutoMirrored() && C0595a.m2332i(this) == 1;
    }

    /* renamed from: b */
    private void m3630b(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int i;
        int i2;
        C0919g gVar = this.f2962b;
        C0918f fVar = gVar.f3018b;
        ArrayDeque arrayDeque = new ArrayDeque();
        arrayDeque.push(fVar.f3003c);
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        boolean z = true;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                C0915c cVar = (C0915c) arrayDeque.peek();
                if ("path".equals(name)) {
                    C0914b bVar = new C0914b();
                    bVar.mo4919a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2984b.add(bVar);
                    if (bVar.getPathName() != null) {
                        fVar.f3011k.put(bVar.getPathName(), bVar);
                    }
                    z = false;
                    i = gVar.f3017a;
                    i2 = bVar.f2999o;
                } else if ("clip-path".equals(name)) {
                    C0913a aVar = new C0913a();
                    aVar.mo4917a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2984b.add(aVar);
                    if (aVar.getPathName() != null) {
                        fVar.f3011k.put(aVar.getPathName(), aVar);
                    }
                    i = gVar.f3017a;
                    i2 = aVar.f2999o;
                } else if ("group".equals(name)) {
                    C0915c cVar2 = new C0915c();
                    cVar2.mo4938a(resources, attributeSet, theme, xmlPullParser);
                    cVar.f2984b.add(cVar2);
                    arrayDeque.push(cVar2);
                    if (cVar2.getGroupName() != null) {
                        fVar.f3011k.put(cVar2.getGroupName(), cVar2);
                    }
                    i = gVar.f3017a;
                    i2 = cVar2.f2987e;
                }
                gVar.f3017a = i2 | i;
            } else if (eventType == 3 && "group".equals(xmlPullParser.getName())) {
                arrayDeque.pop();
            }
            eventType = xmlPullParser.next();
        }
        if (z) {
            throw new XmlPullParserException("no path defined");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PorterDuffColorFilter mo4892a(PorterDuffColorFilter porterDuffColorFilter, ColorStateList colorStateList, PorterDuff.Mode mode) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return new PorterDuffColorFilter(colorStateList.getColorForState(getState(), 0), mode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Object mo4893a(String str) {
        return this.f2962b.f3018b.f3011k.get(str);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo4894a(boolean z) {
        this.f2966g = z;
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    public boolean canApplyTheme() {
        if (this.f2960c == null) {
            return false;
        }
        C0595a.m2327d(this.f2960c);
        return false;
    }

    public /* bridge */ /* synthetic */ void clearColorFilter() {
        super.clearColorFilter();
    }

    public void draw(Canvas canvas) {
        if (this.f2960c != null) {
            this.f2960c.draw(canvas);
            return;
        }
        copyBounds(this.f2970k);
        if (this.f2970k.width() > 0 && this.f2970k.height() > 0) {
            ColorFilter colorFilter = this.f2964e;
            if (colorFilter == null) {
                colorFilter = this.f2963d;
            }
            canvas.getMatrix(this.f2969j);
            this.f2969j.getValues(this.f2968i);
            float abs = Math.abs(this.f2968i[0]);
            float abs2 = Math.abs(this.f2968i[4]);
            float abs3 = Math.abs(this.f2968i[1]);
            float abs4 = Math.abs(this.f2968i[3]);
            if (!(abs3 == 0.0f && abs4 == 0.0f)) {
                abs = 1.0f;
                abs2 = 1.0f;
            }
            int min = Math.min(2048, (int) (((float) this.f2970k.width()) * abs));
            int min2 = Math.min(2048, (int) (((float) this.f2970k.height()) * abs2));
            if (min > 0 && min2 > 0) {
                int save = canvas.save();
                canvas.translate((float) this.f2970k.left, (float) this.f2970k.top);
                if (m3629a()) {
                    canvas.translate((float) this.f2970k.width(), 0.0f);
                    canvas.scale(-1.0f, 1.0f);
                }
                this.f2970k.offsetTo(0, 0);
                this.f2962b.mo4971b(min, min2);
                if (!this.f2966g) {
                    this.f2962b.mo4967a(min, min2);
                } else if (!this.f2962b.mo4972b()) {
                    this.f2962b.mo4967a(min, min2);
                    this.f2962b.mo4973c();
                }
                this.f2962b.mo4968a(canvas, colorFilter, this.f2970k);
                canvas.restoreToCount(save);
            }
        }
    }

    public int getAlpha() {
        return this.f2960c != null ? C0595a.m2326c(this.f2960c) : this.f2962b.f3018b.getRootAlpha();
    }

    public int getChangingConfigurations() {
        return this.f2960c != null ? this.f2960c.getChangingConfigurations() : super.getChangingConfigurations() | this.f2962b.getChangingConfigurations();
    }

    public ColorFilter getColorFilter() {
        return this.f2960c != null ? C0595a.m2328e(this.f2960c) : this.f2964e;
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f2960c != null && Build.VERSION.SDK_INT >= 24) {
            return new C0920h(this.f2960c.getConstantState());
        }
        this.f2962b.f3017a = getChangingConfigurations();
        return this.f2962b;
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f2960c != null ? this.f2960c.getIntrinsicHeight() : (int) this.f2962b.f3018b.f3005e;
    }

    public int getIntrinsicWidth() {
        return this.f2960c != null ? this.f2960c.getIntrinsicWidth() : (int) this.f2962b.f3018b.f3004d;
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        if (this.f2960c != null) {
            return this.f2960c.getOpacity();
        }
        return -3;
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ int[] getState() {
        return super.getState();
    }

    public /* bridge */ /* synthetic */ Region getTransparentRegion() {
        return super.getTransparentRegion();
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet) {
        if (this.f2960c != null) {
            this.f2960c.inflate(resources, xmlPullParser, attributeSet);
        } else {
            inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
        }
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        if (this.f2960c != null) {
            C0595a.m2321a(this.f2960c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        C0919g gVar = this.f2962b;
        gVar.f3018b = new C0918f();
        TypedArray a = C0544g.m2157a(resources, theme, attributeSet, C0899a.f2931a);
        m3628a(a, xmlPullParser, theme);
        a.recycle();
        gVar.f3017a = getChangingConfigurations();
        gVar.f3027k = true;
        m3630b(resources, xmlPullParser, attributeSet, theme);
        this.f2963d = mo4892a(this.f2963d, gVar.f3019c, gVar.f3020d);
    }

    public void invalidateSelf() {
        if (this.f2960c != null) {
            this.f2960c.invalidateSelf();
        } else {
            super.invalidateSelf();
        }
    }

    public boolean isAutoMirrored() {
        return this.f2960c != null ? C0595a.m2324b(this.f2960c) : this.f2962b.f3021e;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x0011, code lost:
        r0 = r1.f2962b;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isStateful() {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r0 = r1.f2960c
            if (r0 == 0) goto L_0x000b
            android.graphics.drawable.Drawable r0 = r1.f2960c
            boolean r0 = r0.isStateful()
            return r0
        L_0x000b:
            boolean r0 = super.isStateful()
            if (r0 != 0) goto L_0x002e
            androidx.k.a.a.i$g r0 = r1.f2962b
            if (r0 == 0) goto L_0x002c
            boolean r0 = r0.mo4975d()
            if (r0 != 0) goto L_0x002e
            androidx.k.a.a.i$g r0 = r1.f2962b
            android.content.res.ColorStateList r0 = r0.f3019c
            if (r0 == 0) goto L_0x002c
            androidx.k.a.a.i$g r0 = r1.f2962b
            android.content.res.ColorStateList r0 = r0.f3019c
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r0 = 0
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.p050k.p051a.p052a.C0911i.isStateful():boolean");
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.f2960c != null) {
            this.f2960c.mutate();
            return this;
        }
        if (!this.f2965f && super.mutate() == this) {
            this.f2962b = new C0919g(this.f2962b);
            this.f2965f = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f2960c != null) {
            this.f2960c.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        if (this.f2960c != null) {
            return this.f2960c.setState(iArr);
        }
        boolean z = false;
        C0919g gVar = this.f2962b;
        if (!(gVar.f3019c == null || gVar.f3020d == null)) {
            this.f2963d = mo4892a(this.f2963d, gVar.f3019c, gVar.f3020d);
            invalidateSelf();
            z = true;
        }
        if (!gVar.mo4975d() || !gVar.mo4970a(iArr)) {
            return z;
        }
        invalidateSelf();
        return true;
    }

    public void scheduleSelf(Runnable runnable, long j) {
        if (this.f2960c != null) {
            this.f2960c.scheduleSelf(runnable, j);
        } else {
            super.scheduleSelf(runnable, j);
        }
    }

    public void setAlpha(int i) {
        if (this.f2960c != null) {
            this.f2960c.setAlpha(i);
        } else if (this.f2962b.f3018b.getRootAlpha() != i) {
            this.f2962b.f3018b.setRootAlpha(i);
            invalidateSelf();
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.f2960c != null) {
            C0595a.m2323a(this.f2960c, z);
        } else {
            this.f2962b.f3021e = z;
        }
    }

    public /* bridge */ /* synthetic */ void setChangingConfigurations(int i) {
        super.setChangingConfigurations(i);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(int i, PorterDuff.Mode mode) {
        super.setColorFilter(i, mode);
    }

    public void setColorFilter(ColorFilter colorFilter) {
        if (this.f2960c != null) {
            this.f2960c.setColorFilter(colorFilter);
            return;
        }
        this.f2964e = colorFilter;
        invalidateSelf();
    }

    public /* bridge */ /* synthetic */ void setFilterBitmap(boolean z) {
        super.setFilterBitmap(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ boolean setState(int[] iArr) {
        return super.setState(iArr);
    }

    public void setTint(int i) {
        if (this.f2960c != null) {
            C0595a.m2317a(this.f2960c, i);
        } else {
            setTintList(ColorStateList.valueOf(i));
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f2960c != null) {
            C0595a.m2319a(this.f2960c, colorStateList);
            return;
        }
        C0919g gVar = this.f2962b;
        if (gVar.f3019c != colorStateList) {
            gVar.f3019c = colorStateList;
            this.f2963d = mo4892a(this.f2963d, colorStateList, gVar.f3020d);
            invalidateSelf();
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2960c != null) {
            C0595a.m2322a(this.f2960c, mode);
            return;
        }
        C0919g gVar = this.f2962b;
        if (gVar.f3020d != mode) {
            gVar.f3020d = mode;
            this.f2963d = mo4892a(this.f2963d, gVar.f3019c, mode);
            invalidateSelf();
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        return this.f2960c != null ? this.f2960c.setVisible(z, z2) : super.setVisible(z, z2);
    }

    public void unscheduleSelf(Runnable runnable) {
        if (this.f2960c != null) {
            this.f2960c.unscheduleSelf(runnable);
        } else {
            super.unscheduleSelf(runnable);
        }
    }
}
