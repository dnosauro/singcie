package androidx.p049j;

import android.graphics.Path;
import android.graphics.PathMeasure;
import android.graphics.PointF;
import android.util.Property;

/* renamed from: androidx.j.h */
class C0867h<T> extends Property<T, Float> {

    /* renamed from: a */
    private final Property<T, PointF> f2871a;

    /* renamed from: b */
    private final PathMeasure f2872b;

    /* renamed from: c */
    private final float f2873c;

    /* renamed from: d */
    private final float[] f2874d = new float[2];

    /* renamed from: e */
    private final PointF f2875e = new PointF();

    /* renamed from: f */
    private float f2876f;

    C0867h(Property<T, PointF> property, Path path) {
        super(Float.class, property.getName());
        this.f2871a = property;
        this.f2872b = new PathMeasure(path, false);
        this.f2873c = this.f2872b.getLength();
    }

    /* renamed from: a */
    public Float get(T t) {
        return Float.valueOf(this.f2876f);
    }

    /* renamed from: a */
    public void set(T t, Float f) {
        this.f2876f = f.floatValue();
        this.f2872b.getPosTan(this.f2873c * f.floatValue(), this.f2874d, (float[]) null);
        PointF pointF = this.f2875e;
        float[] fArr = this.f2874d;
        pointF.x = fArr[0];
        pointF.y = fArr[1];
        this.f2871a.set(t, pointF);
    }
}
