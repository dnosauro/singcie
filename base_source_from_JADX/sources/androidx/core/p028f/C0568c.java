package androidx.core.p028f;

import android.annotation.SuppressLint;
import android.os.Build;
import android.text.PrecomputedText;
import android.text.Spannable;
import android.text.TextDirectionHeuristic;
import android.text.TextDirectionHeuristics;
import android.text.TextPaint;
import android.text.TextUtils;
import android.text.style.MetricAffectingSpan;
import androidx.core.p029g.C0582c;
import java.util.concurrent.Executor;

/* renamed from: androidx.core.f.c */
public class C0568c implements Spannable {

    /* renamed from: a */
    private static final Object f2148a = new Object();

    /* renamed from: b */
    private static Executor f2149b = null;

    /* renamed from: c */
    private final Spannable f2150c;

    /* renamed from: d */
    private final C0569a f2151d;

    /* renamed from: e */
    private final PrecomputedText f2152e;

    /* renamed from: androidx.core.f.c$a */
    public static final class C0569a {

        /* renamed from: a */
        final PrecomputedText.Params f2153a;

        /* renamed from: b */
        private final TextPaint f2154b;

        /* renamed from: c */
        private final TextDirectionHeuristic f2155c;

        /* renamed from: d */
        private final int f2156d;

        /* renamed from: e */
        private final int f2157e;

        /* renamed from: androidx.core.f.c$a$a */
        public static class C0570a {

            /* renamed from: a */
            private final TextPaint f2158a;

            /* renamed from: b */
            private TextDirectionHeuristic f2159b;

            /* renamed from: c */
            private int f2160c;

            /* renamed from: d */
            private int f2161d;

            public C0570a(TextPaint textPaint) {
                this.f2158a = textPaint;
                if (Build.VERSION.SDK_INT >= 23) {
                    this.f2160c = 1;
                    this.f2161d = 1;
                } else {
                    this.f2161d = 0;
                    this.f2160c = 0;
                }
                this.f2159b = Build.VERSION.SDK_INT >= 18 ? TextDirectionHeuristics.FIRSTSTRONG_LTR : null;
            }

            /* renamed from: a */
            public C0570a mo3598a(int i) {
                this.f2160c = i;
                return this;
            }

            /* renamed from: a */
            public C0570a mo3599a(TextDirectionHeuristic textDirectionHeuristic) {
                this.f2159b = textDirectionHeuristic;
                return this;
            }

            /* renamed from: a */
            public C0569a mo3600a() {
                return new C0569a(this.f2158a, this.f2159b, this.f2160c, this.f2161d);
            }

            /* renamed from: b */
            public C0570a mo3601b(int i) {
                this.f2161d = i;
                return this;
            }
        }

        public C0569a(PrecomputedText.Params params) {
            this.f2154b = params.getTextPaint();
            this.f2155c = params.getTextDirection();
            this.f2156d = params.getBreakStrategy();
            this.f2157e = params.getHyphenationFrequency();
            this.f2153a = Build.VERSION.SDK_INT < 29 ? null : params;
        }

        @SuppressLint({"NewApi"})
        C0569a(TextPaint textPaint, TextDirectionHeuristic textDirectionHeuristic, int i, int i2) {
            this.f2153a = Build.VERSION.SDK_INT >= 29 ? new PrecomputedText.Params.Builder(textPaint).setBreakStrategy(i).setHyphenationFrequency(i2).setTextDirection(textDirectionHeuristic).build() : null;
            this.f2154b = textPaint;
            this.f2155c = textDirectionHeuristic;
            this.f2156d = i;
            this.f2157e = i2;
        }

        /* renamed from: a */
        public TextPaint mo3590a() {
            return this.f2154b;
        }

        /* renamed from: a */
        public boolean mo3591a(C0569a aVar) {
            if ((Build.VERSION.SDK_INT >= 23 && (this.f2156d != aVar.mo3593c() || this.f2157e != aVar.mo3594d())) || this.f2154b.getTextSize() != aVar.mo3590a().getTextSize() || this.f2154b.getTextScaleX() != aVar.mo3590a().getTextScaleX() || this.f2154b.getTextSkewX() != aVar.mo3590a().getTextSkewX()) {
                return false;
            }
            if ((Build.VERSION.SDK_INT >= 21 && (this.f2154b.getLetterSpacing() != aVar.mo3590a().getLetterSpacing() || !TextUtils.equals(this.f2154b.getFontFeatureSettings(), aVar.mo3590a().getFontFeatureSettings()))) || this.f2154b.getFlags() != aVar.mo3590a().getFlags()) {
                return false;
            }
            if (Build.VERSION.SDK_INT >= 24) {
                if (!this.f2154b.getTextLocales().equals(aVar.mo3590a().getTextLocales())) {
                    return false;
                }
            } else if (Build.VERSION.SDK_INT >= 17 && !this.f2154b.getTextLocale().equals(aVar.mo3590a().getTextLocale())) {
                return false;
            }
            return this.f2154b.getTypeface() == null ? aVar.mo3590a().getTypeface() == null : this.f2154b.getTypeface().equals(aVar.mo3590a().getTypeface());
        }

        /* renamed from: b */
        public TextDirectionHeuristic mo3592b() {
            return this.f2155c;
        }

        /* renamed from: c */
        public int mo3593c() {
            return this.f2156d;
        }

        /* renamed from: d */
        public int mo3594d() {
            return this.f2157e;
        }

        public boolean equals(Object obj) {
            if (obj == this) {
                return true;
            }
            if (!(obj instanceof C0569a)) {
                return false;
            }
            C0569a aVar = (C0569a) obj;
            if (!mo3591a(aVar)) {
                return false;
            }
            return Build.VERSION.SDK_INT < 18 || this.f2155c == aVar.mo3592b();
        }

        public int hashCode() {
            return C0582c.m2255a(Build.VERSION.SDK_INT >= 24 ? new Object[]{Float.valueOf(this.f2154b.getTextSize()), Float.valueOf(this.f2154b.getTextScaleX()), Float.valueOf(this.f2154b.getTextSkewX()), Float.valueOf(this.f2154b.getLetterSpacing()), Integer.valueOf(this.f2154b.getFlags()), this.f2154b.getTextLocales(), this.f2154b.getTypeface(), Boolean.valueOf(this.f2154b.isElegantTextHeight()), this.f2155c, Integer.valueOf(this.f2156d), Integer.valueOf(this.f2157e)} : Build.VERSION.SDK_INT >= 21 ? new Object[]{Float.valueOf(this.f2154b.getTextSize()), Float.valueOf(this.f2154b.getTextScaleX()), Float.valueOf(this.f2154b.getTextSkewX()), Float.valueOf(this.f2154b.getLetterSpacing()), Integer.valueOf(this.f2154b.getFlags()), this.f2154b.getTextLocale(), this.f2154b.getTypeface(), Boolean.valueOf(this.f2154b.isElegantTextHeight()), this.f2155c, Integer.valueOf(this.f2156d), Integer.valueOf(this.f2157e)} : Build.VERSION.SDK_INT >= 18 ? new Object[]{Float.valueOf(this.f2154b.getTextSize()), Float.valueOf(this.f2154b.getTextScaleX()), Float.valueOf(this.f2154b.getTextSkewX()), Integer.valueOf(this.f2154b.getFlags()), this.f2154b.getTextLocale(), this.f2154b.getTypeface(), this.f2155c, Integer.valueOf(this.f2156d), Integer.valueOf(this.f2157e)} : Build.VERSION.SDK_INT >= 17 ? new Object[]{Float.valueOf(this.f2154b.getTextSize()), Float.valueOf(this.f2154b.getTextScaleX()), Float.valueOf(this.f2154b.getTextSkewX()), Integer.valueOf(this.f2154b.getFlags()), this.f2154b.getTextLocale(), this.f2154b.getTypeface(), this.f2155c, Integer.valueOf(this.f2156d), Integer.valueOf(this.f2157e)} : new Object[]{Float.valueOf(this.f2154b.getTextSize()), Float.valueOf(this.f2154b.getTextScaleX()), Float.valueOf(this.f2154b.getTextSkewX()), Integer.valueOf(this.f2154b.getFlags()), this.f2154b.getTypeface(), this.f2155c, Integer.valueOf(this.f2156d), Integer.valueOf(this.f2157e)});
        }

        /* JADX WARNING: Removed duplicated region for block: B:12:0x00e7  */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public java.lang.String toString() {
            /*
                r3 = this;
                java.lang.StringBuilder r0 = new java.lang.StringBuilder
                java.lang.String r1 = "{"
                r0.<init>(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = "textSize="
                r1.append(r2)
                android.text.TextPaint r2 = r3.f2154b
                float r2 = r2.getTextSize()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textScaleX="
                r1.append(r2)
                android.text.TextPaint r2 = r3.f2154b
                float r2 = r2.getTextScaleX()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textSkewX="
                r1.append(r2)
                android.text.TextPaint r2 = r3.f2154b
                float r2 = r2.getTextSkewX()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 21
                if (r1 < r2) goto L_0x008f
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", letterSpacing="
                r1.append(r2)
                android.text.TextPaint r2 = r3.f2154b
                float r2 = r2.getLetterSpacing()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", elegantTextHeight="
                r1.append(r2)
                android.text.TextPaint r2 = r3.f2154b
                boolean r2 = r2.isElegantTextHeight()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
            L_0x008f:
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 24
                if (r1 < r2) goto L_0x00b0
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textLocale="
                r1.append(r2)
                android.text.TextPaint r2 = r3.f2154b
                android.os.LocaleList r2 = r2.getTextLocales()
            L_0x00a5:
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                goto L_0x00c7
            L_0x00b0:
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 17
                if (r1 < r2) goto L_0x00c7
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textLocale="
                r1.append(r2)
                android.text.TextPaint r2 = r3.f2154b
                java.util.Locale r2 = r2.getTextLocale()
                goto L_0x00a5
            L_0x00c7:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", typeface="
                r1.append(r2)
                android.text.TextPaint r2 = r3.f2154b
                android.graphics.Typeface r2 = r2.getTypeface()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                int r1 = android.os.Build.VERSION.SDK_INT
                r2 = 26
                if (r1 < r2) goto L_0x0101
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", variationSettings="
                r1.append(r2)
                android.text.TextPaint r2 = r3.f2154b
                java.lang.String r2 = r2.getFontVariationSettings()
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
            L_0x0101:
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", textDir="
                r1.append(r2)
                android.text.TextDirectionHeuristic r2 = r3.f2155c
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", breakStrategy="
                r1.append(r2)
                int r2 = r3.f2156d
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.StringBuilder r1 = new java.lang.StringBuilder
                r1.<init>()
                java.lang.String r2 = ", hyphenationFrequency="
                r1.append(r2)
                int r2 = r3.f2157e
                r1.append(r2)
                java.lang.String r1 = r1.toString()
                r0.append(r1)
                java.lang.String r1 = "}"
                r0.append(r1)
                java.lang.String r0 = r0.toString()
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.core.p028f.C0568c.C0569a.toString():java.lang.String");
        }
    }

    /* renamed from: a */
    public PrecomputedText mo3577a() {
        Spannable spannable = this.f2150c;
        if (spannable instanceof PrecomputedText) {
            return (PrecomputedText) spannable;
        }
        return null;
    }

    /* renamed from: b */
    public C0569a mo3578b() {
        return this.f2151d;
    }

    public char charAt(int i) {
        return this.f2150c.charAt(i);
    }

    public int getSpanEnd(Object obj) {
        return this.f2150c.getSpanEnd(obj);
    }

    public int getSpanFlags(Object obj) {
        return this.f2150c.getSpanFlags(obj);
    }

    public int getSpanStart(Object obj) {
        return this.f2150c.getSpanStart(obj);
    }

    @SuppressLint({"NewApi"})
    public <T> T[] getSpans(int i, int i2, Class<T> cls) {
        return Build.VERSION.SDK_INT >= 29 ? this.f2152e.getSpans(i, i2, cls) : this.f2150c.getSpans(i, i2, cls);
    }

    public int length() {
        return this.f2150c.length();
    }

    public int nextSpanTransition(int i, int i2, Class cls) {
        return this.f2150c.nextSpanTransition(i, i2, cls);
    }

    @SuppressLint({"NewApi"})
    public void removeSpan(Object obj) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be removed from PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2152e.removeSpan(obj);
        } else {
            this.f2150c.removeSpan(obj);
        }
    }

    @SuppressLint({"NewApi"})
    public void setSpan(Object obj, int i, int i2, int i3) {
        if (obj instanceof MetricAffectingSpan) {
            throw new IllegalArgumentException("MetricAffectingSpan can not be set to PrecomputedText.");
        } else if (Build.VERSION.SDK_INT >= 29) {
            this.f2152e.setSpan(obj, i, i2, i3);
        } else {
            this.f2150c.setSpan(obj, i, i2, i3);
        }
    }

    public CharSequence subSequence(int i, int i2) {
        return this.f2150c.subSequence(i, i2);
    }

    public String toString() {
        return this.f2150c.toString();
    }
}
