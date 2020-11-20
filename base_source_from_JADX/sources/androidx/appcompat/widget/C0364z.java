package androidx.appcompat.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.PorterDuff;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.widget.TextView;
import androidx.appcompat.C0059a;
import androidx.core.content.p025a.C0540f;
import androidx.core.widget.C0680b;
import java.lang.ref.WeakReference;

/* renamed from: androidx.appcompat.widget.z */
class C0364z {

    /* renamed from: a */
    private final TextView f1274a;

    /* renamed from: b */
    private C0300aw f1275b;

    /* renamed from: c */
    private C0300aw f1276c;

    /* renamed from: d */
    private C0300aw f1277d;

    /* renamed from: e */
    private C0300aw f1278e;

    /* renamed from: f */
    private C0300aw f1279f;

    /* renamed from: g */
    private C0300aw f1280g;

    /* renamed from: h */
    private C0300aw f1281h;

    /* renamed from: i */
    private final C0253ab f1282i;

    /* renamed from: j */
    private int f1283j = 0;

    /* renamed from: k */
    private int f1284k = -1;

    /* renamed from: l */
    private Typeface f1285l;

    /* renamed from: m */
    private boolean f1286m;

    /* renamed from: androidx.appcompat.widget.z$a */
    private static class C0365a extends C0540f.C0541a {

        /* renamed from: a */
        private final WeakReference<C0364z> f1287a;

        /* renamed from: b */
        private final int f1288b;

        /* renamed from: c */
        private final int f1289c;

        /* renamed from: androidx.appcompat.widget.z$a$a */
        private class C0366a implements Runnable {

            /* renamed from: b */
            private final WeakReference<C0364z> f1291b;

            /* renamed from: c */
            private final Typeface f1292c;

            C0366a(WeakReference<C0364z> weakReference, Typeface typeface) {
                this.f1291b = weakReference;
                this.f1292c = typeface;
            }

            public void run() {
                C0364z zVar = (C0364z) this.f1291b.get();
                if (zVar != null) {
                    zVar.mo2691a(this.f1292c);
                }
            }
        }

        C0365a(C0364z zVar, int i, int i2) {
            this.f1287a = new WeakReference<>(zVar);
            this.f1288b = i;
            this.f1289c = i2;
        }

        public void onFontRetrievalFailed(int i) {
        }

        public void onFontRetrieved(Typeface typeface) {
            int i;
            C0364z zVar = (C0364z) this.f1287a.get();
            if (zVar != null) {
                if (Build.VERSION.SDK_INT >= 28 && (i = this.f1288b) != -1) {
                    typeface = Typeface.create(typeface, i, (this.f1289c & 2) != 0);
                }
                zVar.mo2693a((Runnable) new C0366a(this.f1287a, typeface));
            }
        }
    }

    C0364z(TextView textView) {
        this.f1274a = textView;
        this.f1282i = new C0253ab(this.f1274a);
    }

    /* renamed from: a */
    private static C0300aw m1328a(Context context, C0337k kVar, int i) {
        ColorStateList b = kVar.mo2553b(context, i);
        if (b == null) {
            return null;
        }
        C0300aw awVar = new C0300aw();
        awVar.f1091d = true;
        awVar.f1088a = b;
        return awVar;
    }

    /* renamed from: a */
    private void m1329a(Context context, C0302ay ayVar) {
        String d;
        Typeface typeface;
        Typeface typeface2;
        this.f1283j = ayVar.mo2407a(C0059a.C0069j.TextAppearance_android_textStyle, this.f1283j);
        boolean z = false;
        if (Build.VERSION.SDK_INT >= 28) {
            this.f1284k = ayVar.mo2407a(C0059a.C0069j.TextAppearance_android_textFontWeight, -1);
            if (this.f1284k != -1) {
                this.f1283j = (this.f1283j & 2) | 0;
            }
        }
        if (ayVar.mo2424g(C0059a.C0069j.TextAppearance_android_fontFamily) || ayVar.mo2424g(C0059a.C0069j.TextAppearance_fontFamily)) {
            this.f1285l = null;
            int i = ayVar.mo2424g(C0059a.C0069j.TextAppearance_fontFamily) ? C0059a.C0069j.TextAppearance_fontFamily : C0059a.C0069j.TextAppearance_android_fontFamily;
            int i2 = this.f1284k;
            int i3 = this.f1283j;
            if (!context.isRestricted()) {
                try {
                    Typeface a = ayVar.mo2408a(i, this.f1283j, (C0540f.C0541a) new C0365a(this, i2, i3));
                    if (a != null) {
                        if (Build.VERSION.SDK_INT >= 28 && this.f1284k != -1) {
                            a = Typeface.create(Typeface.create(a, 0), this.f1284k, (this.f1283j & 2) != 0);
                        }
                        this.f1285l = a;
                    }
                    this.f1286m = this.f1285l == null;
                } catch (Resources.NotFoundException | UnsupportedOperationException unused) {
                }
            }
            if (this.f1285l == null && (d = ayVar.mo2418d(i)) != null) {
                if (Build.VERSION.SDK_INT < 28 || this.f1284k == -1) {
                    typeface = Typeface.create(d, this.f1283j);
                } else {
                    Typeface create = Typeface.create(d, 0);
                    int i4 = this.f1284k;
                    if ((this.f1283j & 2) != 0) {
                        z = true;
                    }
                    typeface = Typeface.create(create, i4, z);
                }
                this.f1285l = typeface;
            }
        } else if (ayVar.mo2424g(C0059a.C0069j.TextAppearance_android_typeface)) {
            this.f1286m = false;
            switch (ayVar.mo2407a(C0059a.C0069j.TextAppearance_android_typeface, 1)) {
                case 1:
                    typeface2 = Typeface.SANS_SERIF;
                    break;
                case 2:
                    typeface2 = Typeface.SERIF;
                    break;
                case 3:
                    typeface2 = Typeface.MONOSPACE;
                    break;
                default:
                    return;
            }
            this.f1285l = typeface2;
        }
    }

    /* renamed from: a */
    private void m1330a(Drawable drawable, Drawable drawable2, Drawable drawable3, Drawable drawable4, Drawable drawable5, Drawable drawable6) {
        if (Build.VERSION.SDK_INT >= 17 && (drawable5 != null || drawable6 != null)) {
            Drawable[] compoundDrawablesRelative = this.f1274a.getCompoundDrawablesRelative();
            TextView textView = this.f1274a;
            if (drawable5 == null) {
                drawable5 = compoundDrawablesRelative[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawablesRelative[1];
            }
            if (drawable6 == null) {
                drawable6 = compoundDrawablesRelative[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawablesRelative[3];
            }
            textView.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable5, drawable2, drawable6, drawable4);
        } else if (drawable != null || drawable2 != null || drawable3 != null || drawable4 != null) {
            if (Build.VERSION.SDK_INT >= 17) {
                Drawable[] compoundDrawablesRelative2 = this.f1274a.getCompoundDrawablesRelative();
                if (!(compoundDrawablesRelative2[0] == null && compoundDrawablesRelative2[2] == null)) {
                    TextView textView2 = this.f1274a;
                    Drawable drawable7 = compoundDrawablesRelative2[0];
                    if (drawable2 == null) {
                        drawable2 = compoundDrawablesRelative2[1];
                    }
                    Drawable drawable8 = compoundDrawablesRelative2[2];
                    if (drawable4 == null) {
                        drawable4 = compoundDrawablesRelative2[3];
                    }
                    textView2.setCompoundDrawablesRelativeWithIntrinsicBounds(drawable7, drawable2, drawable8, drawable4);
                    return;
                }
            }
            Drawable[] compoundDrawables = this.f1274a.getCompoundDrawables();
            TextView textView3 = this.f1274a;
            if (drawable == null) {
                drawable = compoundDrawables[0];
            }
            if (drawable2 == null) {
                drawable2 = compoundDrawables[1];
            }
            if (drawable3 == null) {
                drawable3 = compoundDrawables[2];
            }
            if (drawable4 == null) {
                drawable4 = compoundDrawables[3];
            }
            textView3.setCompoundDrawablesWithIntrinsicBounds(drawable, drawable2, drawable3, drawable4);
        }
    }

    /* renamed from: a */
    private void m1331a(Drawable drawable, C0300aw awVar) {
        if (drawable != null && awVar != null) {
            C0337k.m1242a(drawable, awVar, this.f1274a.getDrawableState());
        }
    }

    /* renamed from: b */
    private void m1332b(int i, float f) {
        this.f1282i.mo2091a(i, f);
    }

    /* renamed from: l */
    private void m1333l() {
        C0300aw awVar = this.f1281h;
        this.f1275b = awVar;
        this.f1276c = awVar;
        this.f1277d = awVar;
        this.f1278e = awVar;
        this.f1279f = awVar;
        this.f1280g = awVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2684a() {
        mo2697b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2685a(int i) {
        this.f1282i.mo2090a(i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2686a(int i, float f) {
        if (!C0680b.f2403d && !mo2699d()) {
            m1332b(i, f);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2687a(int i, int i2, int i3, int i4) {
        this.f1282i.mo2092a(i, i2, i3, i4);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2688a(Context context, int i) {
        String d;
        ColorStateList e;
        C0302ay a = C0302ay.m1076a(context, i, C0059a.C0069j.TextAppearance);
        if (a.mo2424g(C0059a.C0069j.TextAppearance_textAllCaps)) {
            mo2694a(a.mo2411a(C0059a.C0069j.TextAppearance_textAllCaps, false));
        }
        if (Build.VERSION.SDK_INT < 23 && a.mo2424g(C0059a.C0069j.TextAppearance_android_textColor) && (e = a.mo2420e(C0059a.C0069j.TextAppearance_android_textColor)) != null) {
            this.f1274a.setTextColor(e);
        }
        if (a.mo2424g(C0059a.C0069j.TextAppearance_android_textSize) && a.mo2419e(C0059a.C0069j.TextAppearance_android_textSize, -1) == 0) {
            this.f1274a.setTextSize(0, 0.0f);
        }
        m1329a(context, a);
        if (Build.VERSION.SDK_INT >= 26 && a.mo2424g(C0059a.C0069j.TextAppearance_fontVariationSettings) && (d = a.mo2418d(C0059a.C0069j.TextAppearance_fontVariationSettings)) != null) {
            this.f1274a.setFontVariationSettings(d);
        }
        a.mo2410a();
        Typeface typeface = this.f1285l;
        if (typeface != null) {
            this.f1274a.setTypeface(typeface, this.f1283j);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2689a(ColorStateList colorStateList) {
        if (this.f1281h == null) {
            this.f1281h = new C0300aw();
        }
        C0300aw awVar = this.f1281h;
        awVar.f1088a = colorStateList;
        awVar.f1091d = colorStateList != null;
        m1333l();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2690a(PorterDuff.Mode mode) {
        if (this.f1281h == null) {
            this.f1281h = new C0300aw();
        }
        C0300aw awVar = this.f1281h;
        awVar.f1089b = mode;
        awVar.f1090c = mode != null;
        m1333l();
    }

    /* renamed from: a */
    public void mo2691a(Typeface typeface) {
        if (this.f1286m) {
            this.f1274a.setTypeface(typeface);
            this.f1285l = typeface;
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:46:0x0110  */
    /* JADX WARNING: Removed duplicated region for block: B:47:0x0117  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0124  */
    /* JADX WARNING: Removed duplicated region for block: B:53:0x012b  */
    @android.annotation.SuppressLint({"NewApi"})
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo2692a(android.util.AttributeSet r19, int r20) {
        /*
            r18 = this;
            r7 = r18
            r0 = r19
            r1 = r20
            android.widget.TextView r2 = r7.f1274a
            android.content.Context r2 = r2.getContext()
            androidx.appcompat.widget.k r3 = androidx.appcompat.widget.C0337k.m1243b()
            int[] r4 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper
            r5 = 0
            androidx.appcompat.widget.ay r4 = androidx.appcompat.widget.C0302ay.m1078a(r2, r0, r4, r1, r5)
            int r6 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_textAppearance
            r8 = -1
            int r6 = r4.mo2423g(r6, r8)
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableLeft
            boolean r9 = r4.mo2424g(r9)
            if (r9 == 0) goto L_0x0032
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableLeft
            int r9 = r4.mo2423g(r9, r5)
            androidx.appcompat.widget.aw r9 = m1328a(r2, r3, r9)
            r7.f1275b = r9
        L_0x0032:
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableTop
            boolean r9 = r4.mo2424g(r9)
            if (r9 == 0) goto L_0x0046
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableTop
            int r9 = r4.mo2423g(r9, r5)
            androidx.appcompat.widget.aw r9 = m1328a(r2, r3, r9)
            r7.f1276c = r9
        L_0x0046:
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableRight
            boolean r9 = r4.mo2424g(r9)
            if (r9 == 0) goto L_0x005a
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableRight
            int r9 = r4.mo2423g(r9, r5)
            androidx.appcompat.widget.aw r9 = m1328a(r2, r3, r9)
            r7.f1277d = r9
        L_0x005a:
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableBottom
            boolean r9 = r4.mo2424g(r9)
            if (r9 == 0) goto L_0x006e
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableBottom
            int r9 = r4.mo2423g(r9, r5)
            androidx.appcompat.widget.aw r9 = m1328a(r2, r3, r9)
            r7.f1278e = r9
        L_0x006e:
            int r9 = android.os.Build.VERSION.SDK_INT
            r10 = 17
            if (r9 < r10) goto L_0x009c
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableStart
            boolean r9 = r4.mo2424g(r9)
            if (r9 == 0) goto L_0x0088
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableStart
            int r9 = r4.mo2423g(r9, r5)
            androidx.appcompat.widget.aw r9 = m1328a(r2, r3, r9)
            r7.f1279f = r9
        L_0x0088:
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableEnd
            boolean r9 = r4.mo2424g(r9)
            if (r9 == 0) goto L_0x009c
            int r9 = androidx.appcompat.C0059a.C0069j.AppCompatTextHelper_android_drawableEnd
            int r9 = r4.mo2423g(r9, r5)
            androidx.appcompat.widget.aw r9 = m1328a(r2, r3, r9)
            r7.f1280g = r9
        L_0x009c:
            r4.mo2410a()
            android.widget.TextView r4 = r7.f1274a
            android.text.method.TransformationMethod r4 = r4.getTransformationMethod()
            boolean r4 = r4 instanceof android.text.method.PasswordTransformationMethod
            r9 = 26
            r11 = 23
            if (r6 == r8) goto L_0x0130
            int[] r13 = androidx.appcompat.C0059a.C0069j.TextAppearance
            androidx.appcompat.widget.ay r6 = androidx.appcompat.widget.C0302ay.m1076a((android.content.Context) r2, (int) r6, (int[]) r13)
            if (r4 != 0) goto L_0x00c6
            int r13 = androidx.appcompat.C0059a.C0069j.TextAppearance_textAllCaps
            boolean r13 = r6.mo2424g(r13)
            if (r13 == 0) goto L_0x00c6
            int r13 = androidx.appcompat.C0059a.C0069j.TextAppearance_textAllCaps
            boolean r13 = r6.mo2411a((int) r13, (boolean) r5)
            r14 = r13
            r13 = 1
            goto L_0x00c8
        L_0x00c6:
            r13 = 0
            r14 = 0
        L_0x00c8:
            r7.m1329a((android.content.Context) r2, (androidx.appcompat.widget.C0302ay) r6)
            int r15 = android.os.Build.VERSION.SDK_INT
            if (r15 >= r11) goto L_0x0105
            int r15 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColor
            boolean r15 = r6.mo2424g(r15)
            if (r15 == 0) goto L_0x00de
            int r15 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColor
            android.content.res.ColorStateList r15 = r6.mo2420e(r15)
            goto L_0x00df
        L_0x00de:
            r15 = 0
        L_0x00df:
            int r10 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColorHint
            boolean r10 = r6.mo2424g(r10)
            if (r10 == 0) goto L_0x00ee
            int r10 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColorHint
            android.content.res.ColorStateList r10 = r6.mo2420e(r10)
            goto L_0x00ef
        L_0x00ee:
            r10 = 0
        L_0x00ef:
            int r12 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColorLink
            boolean r12 = r6.mo2424g(r12)
            if (r12 == 0) goto L_0x0103
            int r12 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColorLink
            android.content.res.ColorStateList r12 = r6.mo2420e(r12)
            r17 = r15
            r15 = r12
            r12 = r17
            goto L_0x0108
        L_0x0103:
            r12 = r15
            goto L_0x0107
        L_0x0105:
            r10 = 0
            r12 = 0
        L_0x0107:
            r15 = 0
        L_0x0108:
            int r8 = androidx.appcompat.C0059a.C0069j.TextAppearance_textLocale
            boolean r8 = r6.mo2424g(r8)
            if (r8 == 0) goto L_0x0117
            int r8 = androidx.appcompat.C0059a.C0069j.TextAppearance_textLocale
            java.lang.String r8 = r6.mo2418d(r8)
            goto L_0x0118
        L_0x0117:
            r8 = 0
        L_0x0118:
            int r11 = android.os.Build.VERSION.SDK_INT
            if (r11 < r9) goto L_0x012b
            int r11 = androidx.appcompat.C0059a.C0069j.TextAppearance_fontVariationSettings
            boolean r11 = r6.mo2424g(r11)
            if (r11 == 0) goto L_0x012b
            int r11 = androidx.appcompat.C0059a.C0069j.TextAppearance_fontVariationSettings
            java.lang.String r11 = r6.mo2418d(r11)
            goto L_0x012c
        L_0x012b:
            r11 = 0
        L_0x012c:
            r6.mo2410a()
            goto L_0x0137
        L_0x0130:
            r8 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 0
        L_0x0137:
            int[] r6 = androidx.appcompat.C0059a.C0069j.TextAppearance
            androidx.appcompat.widget.ay r6 = androidx.appcompat.widget.C0302ay.m1078a(r2, r0, r6, r1, r5)
            if (r4 != 0) goto L_0x014e
            int r9 = androidx.appcompat.C0059a.C0069j.TextAppearance_textAllCaps
            boolean r9 = r6.mo2424g(r9)
            if (r9 == 0) goto L_0x014e
            int r9 = androidx.appcompat.C0059a.C0069j.TextAppearance_textAllCaps
            boolean r14 = r6.mo2411a((int) r9, (boolean) r5)
            r13 = 1
        L_0x014e:
            int r9 = android.os.Build.VERSION.SDK_INT
            r5 = 23
            if (r9 >= r5) goto L_0x017e
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColor
            boolean r5 = r6.mo2424g(r5)
            if (r5 == 0) goto L_0x0162
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColor
            android.content.res.ColorStateList r12 = r6.mo2420e(r5)
        L_0x0162:
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColorHint
            boolean r5 = r6.mo2424g(r5)
            if (r5 == 0) goto L_0x0170
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColorHint
            android.content.res.ColorStateList r10 = r6.mo2420e(r5)
        L_0x0170:
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColorLink
            boolean r5 = r6.mo2424g(r5)
            if (r5 == 0) goto L_0x017e
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textColorLink
            android.content.res.ColorStateList r15 = r6.mo2420e(r5)
        L_0x017e:
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_textLocale
            boolean r5 = r6.mo2424g(r5)
            if (r5 == 0) goto L_0x018c
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_textLocale
            java.lang.String r8 = r6.mo2418d(r5)
        L_0x018c:
            int r5 = android.os.Build.VERSION.SDK_INT
            r9 = 26
            if (r5 < r9) goto L_0x01a0
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_fontVariationSettings
            boolean r5 = r6.mo2424g(r5)
            if (r5 == 0) goto L_0x01a0
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_fontVariationSettings
            java.lang.String r11 = r6.mo2418d(r5)
        L_0x01a0:
            int r5 = android.os.Build.VERSION.SDK_INT
            r9 = 28
            if (r5 < r9) goto L_0x01c1
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textSize
            boolean r5 = r6.mo2424g(r5)
            if (r5 == 0) goto L_0x01c1
            int r5 = androidx.appcompat.C0059a.C0069j.TextAppearance_android_textSize
            r9 = -1
            int r5 = r6.mo2419e(r5, r9)
            if (r5 != 0) goto L_0x01c1
            android.widget.TextView r5 = r7.f1274a
            r9 = 0
            r16 = r3
            r3 = 0
            r5.setTextSize(r3, r9)
            goto L_0x01c3
        L_0x01c1:
            r16 = r3
        L_0x01c3:
            r7.m1329a((android.content.Context) r2, (androidx.appcompat.widget.C0302ay) r6)
            r6.mo2410a()
            if (r12 == 0) goto L_0x01d0
            android.widget.TextView r3 = r7.f1274a
            r3.setTextColor(r12)
        L_0x01d0:
            if (r10 == 0) goto L_0x01d7
            android.widget.TextView r3 = r7.f1274a
            r3.setHintTextColor(r10)
        L_0x01d7:
            if (r15 == 0) goto L_0x01de
            android.widget.TextView r3 = r7.f1274a
            r3.setLinkTextColor(r15)
        L_0x01de:
            if (r4 != 0) goto L_0x01e5
            if (r13 == 0) goto L_0x01e5
            r7.mo2694a((boolean) r14)
        L_0x01e5:
            android.graphics.Typeface r3 = r7.f1285l
            if (r3 == 0) goto L_0x01fb
            int r4 = r7.f1284k
            r5 = -1
            if (r4 != r5) goto L_0x01f6
            android.widget.TextView r4 = r7.f1274a
            int r5 = r7.f1283j
            r4.setTypeface(r3, r5)
            goto L_0x01fb
        L_0x01f6:
            android.widget.TextView r4 = r7.f1274a
            r4.setTypeface(r3)
        L_0x01fb:
            if (r11 == 0) goto L_0x0202
            android.widget.TextView r3 = r7.f1274a
            r3.setFontVariationSettings(r11)
        L_0x0202:
            if (r8 == 0) goto L_0x022e
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 24
            if (r3 < r4) goto L_0x0214
            android.widget.TextView r3 = r7.f1274a
            android.os.LocaleList r4 = android.os.LocaleList.forLanguageTags(r8)
            r3.setTextLocales(r4)
            goto L_0x022e
        L_0x0214:
            int r3 = android.os.Build.VERSION.SDK_INT
            r4 = 21
            if (r3 < r4) goto L_0x022e
            r3 = 44
            int r3 = r8.indexOf(r3)
            r4 = 0
            java.lang.String r3 = r8.substring(r4, r3)
            android.widget.TextView r4 = r7.f1274a
            java.util.Locale r3 = java.util.Locale.forLanguageTag(r3)
            r4.setTextLocale(r3)
        L_0x022e:
            androidx.appcompat.widget.ab r3 = r7.f1282i
            r3.mo2093a((android.util.AttributeSet) r0, (int) r1)
            boolean r1 = androidx.core.widget.C0680b.f2403d
            if (r1 == 0) goto L_0x0274
            androidx.appcompat.widget.ab r1 = r7.f1282i
            int r1 = r1.mo2088a()
            if (r1 == 0) goto L_0x0274
            androidx.appcompat.widget.ab r1 = r7.f1282i
            int[] r1 = r1.mo2099e()
            int r3 = r1.length
            if (r3 <= 0) goto L_0x0274
            android.widget.TextView r3 = r7.f1274a
            int r3 = r3.getAutoSizeStepGranularity()
            float r3 = (float) r3
            r4 = -1082130432(0xffffffffbf800000, float:-1.0)
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x026e
            android.widget.TextView r1 = r7.f1274a
            androidx.appcompat.widget.ab r3 = r7.f1282i
            int r3 = r3.mo2097c()
            androidx.appcompat.widget.ab r4 = r7.f1282i
            int r4 = r4.mo2098d()
            androidx.appcompat.widget.ab r5 = r7.f1282i
            int r5 = r5.mo2095b()
            r6 = 0
            r1.setAutoSizeTextTypeUniformWithConfiguration(r3, r4, r5, r6)
            goto L_0x0274
        L_0x026e:
            r6 = 0
            android.widget.TextView r3 = r7.f1274a
            r3.setAutoSizeTextTypeUniformWithPresetSizes(r1, r6)
        L_0x0274:
            int[] r1 = androidx.appcompat.C0059a.C0069j.AppCompatTextView
            androidx.appcompat.widget.ay r8 = androidx.appcompat.widget.C0302ay.m1077a((android.content.Context) r2, (android.util.AttributeSet) r0, (int[]) r1)
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_drawableLeftCompat
            r1 = -1
            int r0 = r8.mo2423g(r0, r1)
            if (r0 == r1) goto L_0x028b
            r3 = r16
            android.graphics.drawable.Drawable r0 = r3.mo2550a((android.content.Context) r2, (int) r0)
            r4 = r0
            goto L_0x028e
        L_0x028b:
            r3 = r16
            r4 = 0
        L_0x028e:
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_drawableTopCompat
            int r0 = r8.mo2423g(r0, r1)
            if (r0 == r1) goto L_0x029c
            android.graphics.drawable.Drawable r0 = r3.mo2550a((android.content.Context) r2, (int) r0)
            r5 = r0
            goto L_0x029d
        L_0x029c:
            r5 = 0
        L_0x029d:
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_drawableRightCompat
            int r0 = r8.mo2423g(r0, r1)
            if (r0 == r1) goto L_0x02ab
            android.graphics.drawable.Drawable r0 = r3.mo2550a((android.content.Context) r2, (int) r0)
            r6 = r0
            goto L_0x02ac
        L_0x02ab:
            r6 = 0
        L_0x02ac:
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_drawableBottomCompat
            int r0 = r8.mo2423g(r0, r1)
            if (r0 == r1) goto L_0x02ba
            android.graphics.drawable.Drawable r0 = r3.mo2550a((android.content.Context) r2, (int) r0)
            r9 = r0
            goto L_0x02bb
        L_0x02ba:
            r9 = 0
        L_0x02bb:
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_drawableStartCompat
            int r0 = r8.mo2423g(r0, r1)
            if (r0 == r1) goto L_0x02c9
            android.graphics.drawable.Drawable r0 = r3.mo2550a((android.content.Context) r2, (int) r0)
            r10 = r0
            goto L_0x02ca
        L_0x02c9:
            r10 = 0
        L_0x02ca:
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_drawableEndCompat
            int r0 = r8.mo2423g(r0, r1)
            if (r0 == r1) goto L_0x02d8
            android.graphics.drawable.Drawable r0 = r3.mo2550a((android.content.Context) r2, (int) r0)
            r11 = r0
            goto L_0x02d9
        L_0x02d8:
            r11 = 0
        L_0x02d9:
            r0 = r18
            r1 = r4
            r2 = r5
            r3 = r6
            r4 = r9
            r5 = r10
            r6 = r11
            r0.m1330a(r1, r2, r3, r4, r5, r6)
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_drawableTint
            boolean r0 = r8.mo2424g(r0)
            if (r0 == 0) goto L_0x02f7
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_drawableTint
            android.content.res.ColorStateList r0 = r8.mo2420e(r0)
            android.widget.TextView r1 = r7.f1274a
            androidx.core.widget.C0687i.m2807a((android.widget.TextView) r1, (android.content.res.ColorStateList) r0)
        L_0x02f7:
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_drawableTintMode
            boolean r0 = r8.mo2424g(r0)
            if (r0 == 0) goto L_0x0311
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_drawableTintMode
            r1 = -1
            int r0 = r8.mo2407a((int) r0, (int) r1)
            r2 = 0
            android.graphics.PorterDuff$Mode r0 = androidx.appcompat.widget.C0257af.m914a(r0, r2)
            android.widget.TextView r2 = r7.f1274a
            androidx.core.widget.C0687i.m2808a((android.widget.TextView) r2, (android.graphics.PorterDuff.Mode) r0)
            goto L_0x0312
        L_0x0311:
            r1 = -1
        L_0x0312:
            int r0 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_firstBaselineToTopHeight
            int r0 = r8.mo2419e(r0, r1)
            int r2 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_lastBaselineToBottomHeight
            int r2 = r8.mo2419e(r2, r1)
            int r3 = androidx.appcompat.C0059a.C0069j.AppCompatTextView_lineHeight
            int r3 = r8.mo2419e(r3, r1)
            r8.mo2410a()
            if (r0 == r1) goto L_0x032e
            android.widget.TextView r4 = r7.f1274a
            androidx.core.widget.C0687i.m2812b(r4, r0)
        L_0x032e:
            if (r2 == r1) goto L_0x0335
            android.widget.TextView r0 = r7.f1274a
            androidx.core.widget.C0687i.m2815c(r0, r2)
        L_0x0335:
            if (r3 == r1) goto L_0x033c
            android.widget.TextView r0 = r7.f1274a
            androidx.core.widget.C0687i.m2817d(r0, r3)
        L_0x033c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.appcompat.widget.C0364z.mo2692a(android.util.AttributeSet, int):void");
    }

    /* renamed from: a */
    public void mo2693a(Runnable runnable) {
        this.f1274a.post(runnable);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2694a(boolean z) {
        this.f1274a.setAllCaps(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2695a(boolean z, int i, int i2, int i3, int i4) {
        if (!C0680b.f2403d) {
            mo2698c();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo2696a(int[] iArr, int i) {
        this.f1282i.mo2094a(iArr, i);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo2697b() {
        if (!(this.f1275b == null && this.f1276c == null && this.f1277d == null && this.f1278e == null)) {
            Drawable[] compoundDrawables = this.f1274a.getCompoundDrawables();
            m1331a(compoundDrawables[0], this.f1275b);
            m1331a(compoundDrawables[1], this.f1276c);
            m1331a(compoundDrawables[2], this.f1277d);
            m1331a(compoundDrawables[3], this.f1278e);
        }
        if (Build.VERSION.SDK_INT < 17) {
            return;
        }
        if (this.f1279f != null || this.f1280g != null) {
            Drawable[] compoundDrawablesRelative = this.f1274a.getCompoundDrawablesRelative();
            m1331a(compoundDrawablesRelative[0], this.f1279f);
            m1331a(compoundDrawablesRelative[2], this.f1280g);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo2698c() {
        this.f1282i.mo2100f();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo2699d() {
        return this.f1282i.mo2101g();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public int mo2700e() {
        return this.f1282i.mo2088a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public int mo2701f() {
        return this.f1282i.mo2095b();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public int mo2702g() {
        return this.f1282i.mo2097c();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public int mo2703h() {
        return this.f1282i.mo2098d();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: i */
    public int[] mo2704i() {
        return this.f1282i.mo2099e();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: j */
    public ColorStateList mo2705j() {
        C0300aw awVar = this.f1281h;
        if (awVar != null) {
            return awVar.f1088a;
        }
        return null;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: k */
    public PorterDuff.Mode mo2706k() {
        C0300aw awVar = this.f1281h;
        if (awVar != null) {
            return awVar.f1089b;
        }
        return null;
    }
}
