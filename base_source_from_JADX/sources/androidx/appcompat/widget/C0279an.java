package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import androidx.appcompat.p011b.p012a.C0136a;
import androidx.appcompat.p013c.C0151a;
import androidx.core.content.C0529a;
import androidx.core.graphics.drawable.C0595a;
import androidx.p018c.C0400a;
import androidx.p018c.C0405d;
import androidx.p018c.C0406e;
import androidx.p018c.C0414h;
import androidx.p050k.p051a.p052a.C0901c;
import androidx.p050k.p051a.p052a.C0911i;
import java.lang.ref.WeakReference;
import java.util.WeakHashMap;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.appcompat.widget.an */
public final class C0279an {

    /* renamed from: a */
    private static final PorterDuff.Mode f1015a = PorterDuff.Mode.SRC_IN;

    /* renamed from: b */
    private static C0279an f1016b;

    /* renamed from: c */
    private static final C0282c f1017c = new C0282c(6);

    /* renamed from: d */
    private WeakHashMap<Context, C0414h<ColorStateList>> f1018d;

    /* renamed from: e */
    private C0400a<String, C0283d> f1019e;

    /* renamed from: f */
    private C0414h<String> f1020f;

    /* renamed from: g */
    private final WeakHashMap<Context, C0405d<WeakReference<Drawable.ConstantState>>> f1021g = new WeakHashMap<>(0);

    /* renamed from: h */
    private TypedValue f1022h;

    /* renamed from: i */
    private boolean f1023i;

    /* renamed from: j */
    private C0284e f1024j;

    /* renamed from: androidx.appcompat.widget.an$a */
    static class C0280a implements C0283d {
        C0280a() {
        }

        /* renamed from: a */
        public Drawable mo2248a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0136a.m363a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AsldcInflateDelegate", "Exception while inflating <animated-selector>", e);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.an$b */
    private static class C0281b implements C0283d {
        C0281b() {
        }

        /* renamed from: a */
        public Drawable mo2248a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0901c.m3593a(context, context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("AvdcInflateDelegate", "Exception while inflating <animated-vector>", e);
                return null;
            }
        }
    }

    /* renamed from: androidx.appcompat.widget.an$c */
    private static class C0282c extends C0406e<Integer, PorterDuffColorFilter> {
        public C0282c(int i) {
            super(i);
        }

        /* renamed from: b */
        private static int m1015b(int i, PorterDuff.Mode mode) {
            return ((i + 31) * 31) + mode.hashCode();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PorterDuffColorFilter mo2249a(int i, PorterDuff.Mode mode) {
            return (PorterDuffColorFilter) get(Integer.valueOf(m1015b(i, mode)));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public PorterDuffColorFilter mo2250a(int i, PorterDuff.Mode mode, PorterDuffColorFilter porterDuffColorFilter) {
            return (PorterDuffColorFilter) put(Integer.valueOf(m1015b(i, mode)), porterDuffColorFilter);
        }
    }

    /* renamed from: androidx.appcompat.widget.an$d */
    private interface C0283d {
        /* renamed from: a */
        Drawable mo2248a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme);
    }

    /* renamed from: androidx.appcompat.widget.an$e */
    interface C0284e {
        /* renamed from: a */
        ColorStateList mo2251a(Context context, int i);

        /* renamed from: a */
        PorterDuff.Mode mo2252a(int i);

        /* renamed from: a */
        Drawable mo2253a(C0279an anVar, Context context, int i);

        /* renamed from: a */
        boolean mo2254a(Context context, int i, Drawable drawable);

        /* renamed from: b */
        boolean mo2255b(Context context, int i, Drawable drawable);
    }

    /* renamed from: androidx.appcompat.widget.an$f */
    private static class C0285f implements C0283d {
        C0285f() {
        }

        /* renamed from: a */
        public Drawable mo2248a(Context context, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
            try {
                return C0911i.m3627a(context.getResources(), xmlPullParser, attributeSet, theme);
            } catch (Exception e) {
                Log.e("VdcInflateDelegate", "Exception while inflating <vector>", e);
                return null;
            }
        }
    }

    /* renamed from: a */
    private static long m989a(TypedValue typedValue) {
        return (((long) typedValue.assetCookie) << 32) | ((long) typedValue.data);
    }

    /* renamed from: a */
    public static synchronized PorterDuffColorFilter m990a(int i, PorterDuff.Mode mode) {
        PorterDuffColorFilter a;
        synchronized (C0279an.class) {
            a = f1017c.mo2249a(i, mode);
            if (a == null) {
                a = new PorterDuffColorFilter(i, mode);
                f1017c.mo2250a(i, mode, a);
            }
        }
        return a;
    }

    /* renamed from: a */
    private static PorterDuffColorFilter m991a(ColorStateList colorStateList, PorterDuff.Mode mode, int[] iArr) {
        if (colorStateList == null || mode == null) {
            return null;
        }
        return m990a(colorStateList.getColorForState(iArr, 0), mode);
    }

    /* renamed from: a */
    private Drawable m992a(Context context, int i, boolean z, Drawable drawable) {
        ColorStateList b = mo2247b(context, i);
        if (b != null) {
            if (C0257af.m917c(drawable)) {
                drawable = drawable.mutate();
            }
            Drawable g = C0595a.m2330g(drawable);
            C0595a.m2319a(g, b);
            PorterDuff.Mode a = mo2240a(i);
            if (a == null) {
                return g;
            }
            C0595a.m2322a(g, a);
            return g;
        }
        C0284e eVar = this.f1024j;
        if ((eVar == null || !eVar.mo2254a(context, i, drawable)) && !mo2246a(context, i, drawable) && z) {
            return null;
        }
        return drawable;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002c, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized android.graphics.drawable.Drawable m993a(android.content.Context r4, long r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            java.util.WeakHashMap<android.content.Context, androidx.c.d<java.lang.ref.WeakReference<android.graphics.drawable.Drawable$ConstantState>>> r0 = r3.f1021g     // Catch:{ all -> 0x002d }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x002d }
            androidx.c.d r0 = (androidx.p018c.C0405d) r0     // Catch:{ all -> 0x002d }
            r1 = 0
            if (r0 != 0) goto L_0x000e
            monitor-exit(r3)
            return r1
        L_0x000e:
            java.lang.Object r2 = r0.mo2846a((long) r5)     // Catch:{ all -> 0x002d }
            java.lang.ref.WeakReference r2 = (java.lang.ref.WeakReference) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x002b
            java.lang.Object r2 = r2.get()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable$ConstantState r2 = (android.graphics.drawable.Drawable.ConstantState) r2     // Catch:{ all -> 0x002d }
            if (r2 == 0) goto L_0x0028
            android.content.res.Resources r4 = r4.getResources()     // Catch:{ all -> 0x002d }
            android.graphics.drawable.Drawable r4 = r2.newDrawable(r4)     // Catch:{ all -> 0x002d }
            monitor-exit(r3)
            return r4
        L_0x0028:
            r0.mo2851b((long) r5)     // Catch:{ all -> 0x002d }
        L_0x002b:
            monitor-exit(r3)
            return r1
        L_0x002d:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0279an.m993a(android.content.Context, long):android.graphics.drawable.Drawable");
    }

    /* renamed from: a */
    public static synchronized C0279an m994a() {
        C0279an anVar;
        synchronized (C0279an.class) {
            if (f1016b == null) {
                f1016b = new C0279an();
                m997a(f1016b);
            }
            anVar = f1016b;
        }
        return anVar;
    }

    /* renamed from: a */
    private void m995a(Context context, int i, ColorStateList colorStateList) {
        if (this.f1018d == null) {
            this.f1018d = new WeakHashMap<>();
        }
        C0414h hVar = this.f1018d.get(context);
        if (hVar == null) {
            hVar = new C0414h();
            this.f1018d.put(context, hVar);
        }
        hVar.mo2976c(i, colorStateList);
    }

    /* renamed from: a */
    static void m996a(Drawable drawable, C0300aw awVar, int[] iArr) {
        if (!C0257af.m917c(drawable) || drawable.mutate() == drawable) {
            if (awVar.f1091d || awVar.f1090c) {
                drawable.setColorFilter(m991a(awVar.f1091d ? awVar.f1088a : null, awVar.f1090c ? awVar.f1089b : f1015a, iArr));
            } else {
                drawable.clearColorFilter();
            }
            if (Build.VERSION.SDK_INT <= 23) {
                drawable.invalidateSelf();
                return;
            }
            return;
        }
        Log.d("ResourceManagerInternal", "Mutated drawable is not the same instance as the input.");
    }

    /* renamed from: a */
    private static void m997a(C0279an anVar) {
        if (Build.VERSION.SDK_INT < 24) {
            anVar.m998a("vector", (C0283d) new C0285f());
            anVar.m998a("animated-vector", (C0283d) new C0281b());
            anVar.m998a("animated-selector", (C0283d) new C0280a());
        }
    }

    /* renamed from: a */
    private void m998a(String str, C0283d dVar) {
        if (this.f1019e == null) {
            this.f1019e = new C0400a<>();
        }
        this.f1019e.put(str, dVar);
    }

    /* renamed from: a */
    private synchronized boolean m999a(Context context, long j, Drawable drawable) {
        boolean z;
        Drawable.ConstantState constantState = drawable.getConstantState();
        if (constantState != null) {
            C0405d dVar = this.f1021g.get(context);
            if (dVar == null) {
                dVar = new C0405d();
                this.f1021g.put(context, dVar);
            }
            dVar.mo2852b(j, new WeakReference(constantState));
            z = true;
        } else {
            z = false;
        }
        return z;
    }

    /* renamed from: a */
    private static boolean m1000a(Drawable drawable) {
        return (drawable instanceof C0911i) || "android.graphics.drawable.VectorDrawable".equals(drawable.getClass().getName());
    }

    /* renamed from: b */
    private void m1001b(Context context) {
        if (!this.f1023i) {
            this.f1023i = true;
            Drawable a = mo2241a(context, C0151a.C0152a.abc_vector_test);
            if (a == null || !m1000a(a)) {
                this.f1023i = false;
                throw new IllegalStateException("This app has been built with an incorrect configuration. Please configure your build for VectorDrawableCompat.");
            }
        }
    }

    /* renamed from: c */
    private Drawable m1002c(Context context, int i) {
        if (this.f1022h == null) {
            this.f1022h = new TypedValue();
        }
        TypedValue typedValue = this.f1022h;
        context.getResources().getValue(i, typedValue, true);
        long a = m989a(typedValue);
        Drawable a2 = m993a(context, a);
        if (a2 != null) {
            return a2;
        }
        C0284e eVar = this.f1024j;
        Drawable a3 = eVar == null ? null : eVar.mo2253a(this, context, i);
        if (a3 != null) {
            a3.setChangingConfigurations(typedValue.changingConfigurations);
            m999a(context, a, a3);
        }
        return a3;
    }

    /* JADX WARNING: Removed duplicated region for block: B:30:0x0075 A[Catch:{ Exception -> 0x00a4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x009c A[Catch:{ Exception -> 0x00a4 }] */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private android.graphics.drawable.Drawable m1003d(android.content.Context r10, int r11) {
        /*
            r9 = this;
            androidx.c.a<java.lang.String, androidx.appcompat.widget.an$d> r0 = r9.f1019e
            r1 = 0
            if (r0 == 0) goto L_0x00b6
            boolean r0 = r0.isEmpty()
            if (r0 != 0) goto L_0x00b6
            androidx.c.h<java.lang.String> r0 = r9.f1020f
            if (r0 == 0) goto L_0x0028
            java.lang.Object r0 = r0.mo2969a((int) r11)
            java.lang.String r0 = (java.lang.String) r0
            java.lang.String r2 = "appcompat_skip_skip"
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x0027
            if (r0 == 0) goto L_0x002f
            androidx.c.a<java.lang.String, androidx.appcompat.widget.an$d> r2 = r9.f1019e
            java.lang.Object r0 = r2.get(r0)
            if (r0 != 0) goto L_0x002f
        L_0x0027:
            return r1
        L_0x0028:
            androidx.c.h r0 = new androidx.c.h
            r0.<init>()
            r9.f1020f = r0
        L_0x002f:
            android.util.TypedValue r0 = r9.f1022h
            if (r0 != 0) goto L_0x003a
            android.util.TypedValue r0 = new android.util.TypedValue
            r0.<init>()
            r9.f1022h = r0
        L_0x003a:
            android.util.TypedValue r0 = r9.f1022h
            android.content.res.Resources r1 = r10.getResources()
            r2 = 1
            r1.getValue(r11, r0, r2)
            long r3 = m989a((android.util.TypedValue) r0)
            android.graphics.drawable.Drawable r5 = r9.m993a((android.content.Context) r10, (long) r3)
            if (r5 == 0) goto L_0x004f
            return r5
        L_0x004f:
            java.lang.CharSequence r6 = r0.string
            if (r6 == 0) goto L_0x00ac
            java.lang.CharSequence r6 = r0.string
            java.lang.String r6 = r6.toString()
            java.lang.String r7 = ".xml"
            boolean r6 = r6.endsWith(r7)
            if (r6 == 0) goto L_0x00ac
            android.content.res.XmlResourceParser r1 = r1.getXml(r11)     // Catch:{ Exception -> 0x00a4 }
            android.util.AttributeSet r6 = android.util.Xml.asAttributeSet(r1)     // Catch:{ Exception -> 0x00a4 }
        L_0x0069:
            int r7 = r1.next()     // Catch:{ Exception -> 0x00a4 }
            r8 = 2
            if (r7 == r8) goto L_0x0073
            if (r7 == r2) goto L_0x0073
            goto L_0x0069
        L_0x0073:
            if (r7 != r8) goto L_0x009c
            java.lang.String r2 = r1.getName()     // Catch:{ Exception -> 0x00a4 }
            androidx.c.h<java.lang.String> r7 = r9.f1020f     // Catch:{ Exception -> 0x00a4 }
            r7.mo2976c(r11, r2)     // Catch:{ Exception -> 0x00a4 }
            androidx.c.a<java.lang.String, androidx.appcompat.widget.an$d> r7 = r9.f1019e     // Catch:{ Exception -> 0x00a4 }
            java.lang.Object r2 = r7.get(r2)     // Catch:{ Exception -> 0x00a4 }
            androidx.appcompat.widget.an$d r2 = (androidx.appcompat.widget.C0279an.C0283d) r2     // Catch:{ Exception -> 0x00a4 }
            if (r2 == 0) goto L_0x0091
            android.content.res.Resources$Theme r7 = r10.getTheme()     // Catch:{ Exception -> 0x00a4 }
            android.graphics.drawable.Drawable r1 = r2.mo2248a(r10, r1, r6, r7)     // Catch:{ Exception -> 0x00a4 }
            r5 = r1
        L_0x0091:
            if (r5 == 0) goto L_0x00ac
            int r0 = r0.changingConfigurations     // Catch:{ Exception -> 0x00a4 }
            r5.setChangingConfigurations(r0)     // Catch:{ Exception -> 0x00a4 }
            r9.m999a((android.content.Context) r10, (long) r3, (android.graphics.drawable.Drawable) r5)     // Catch:{ Exception -> 0x00a4 }
            goto L_0x00ac
        L_0x009c:
            org.xmlpull.v1.XmlPullParserException r10 = new org.xmlpull.v1.XmlPullParserException     // Catch:{ Exception -> 0x00a4 }
            java.lang.String r0 = "No start tag found"
            r10.<init>(r0)     // Catch:{ Exception -> 0x00a4 }
            throw r10     // Catch:{ Exception -> 0x00a4 }
        L_0x00a4:
            r10 = move-exception
            java.lang.String r0 = "ResourceManagerInternal"
            java.lang.String r1 = "Exception while inflating drawable"
            android.util.Log.e(r0, r1, r10)
        L_0x00ac:
            if (r5 != 0) goto L_0x00b5
            androidx.c.h<java.lang.String> r10 = r9.f1020f
            java.lang.String r0 = "appcompat_skip_skip"
            r10.mo2976c(r11, r0)
        L_0x00b5:
            return r5
        L_0x00b6:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0279an.m1003d(android.content.Context, int):android.graphics.drawable.Drawable");
    }

    /* renamed from: e */
    private ColorStateList m1004e(Context context, int i) {
        C0414h hVar;
        WeakHashMap<Context, C0414h<ColorStateList>> weakHashMap = this.f1018d;
        if (weakHashMap == null || (hVar = weakHashMap.get(context)) == null) {
            return null;
        }
        return (ColorStateList) hVar.mo2969a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public PorterDuff.Mode mo2240a(int i) {
        C0284e eVar = this.f1024j;
        if (eVar == null) {
            return null;
        }
        return eVar.mo2252a(i);
    }

    /* renamed from: a */
    public synchronized Drawable mo2241a(Context context, int i) {
        return mo2242a(context, i, false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Drawable mo2242a(Context context, int i, boolean z) {
        Drawable d;
        m1001b(context);
        d = m1003d(context, i);
        if (d == null) {
            d = m1002c(context, i);
        }
        if (d == null) {
            d = C0529a.m2093a(context, i);
        }
        if (d != null) {
            d = m992a(context, i, z, d);
        }
        if (d != null) {
            C0257af.m916b(d);
        }
        return d;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Drawable mo2243a(Context context, C0312bd bdVar, int i) {
        Drawable d = m1003d(context, i);
        if (d == null) {
            d = bdVar.mo2450a(i);
        }
        if (d == null) {
            return null;
        }
        return m992a(context, i, false, d);
    }

    /* renamed from: a */
    public synchronized void mo2244a(Context context) {
        C0405d dVar = this.f1021g.get(context);
        if (dVar != null) {
            dVar.mo2859d();
        }
    }

    /* renamed from: a */
    public synchronized void mo2245a(C0284e eVar) {
        this.f1024j = eVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo2246a(Context context, int i, Drawable drawable) {
        C0284e eVar = this.f1024j;
        return eVar != null && eVar.mo2255b(context, i, drawable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized ColorStateList mo2247b(Context context, int i) {
        ColorStateList e;
        e = m1004e(context, i);
        if (e == null) {
            e = this.f1024j == null ? null : this.f1024j.mo2251a(context, i);
            if (e != null) {
                m995a(context, i, e);
            }
        }
        return e;
    }
}
