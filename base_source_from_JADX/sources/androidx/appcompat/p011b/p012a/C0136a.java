package androidx.appcompat.p011b.p012a;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.drawable.Animatable;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.p011b.p012a.C0144b;
import androidx.appcompat.p011b.p012a.C0149d;
import androidx.appcompat.p013c.C0151a;
import androidx.appcompat.widget.C0279an;
import androidx.core.content.p025a.C0544g;
import androidx.core.graphics.drawable.C0596b;
import androidx.p018c.C0405d;
import androidx.p018c.C0414h;
import androidx.p050k.p051a.p052a.C0901c;
import androidx.p050k.p051a.p052a.C0911i;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.b.a.a */
public class C0136a extends C0149d implements C0596b {

    /* renamed from: a */
    private static final String f358a = "a";

    /* renamed from: b */
    private C0139b f359b;

    /* renamed from: c */
    private C0143f f360c;

    /* renamed from: d */
    private int f361d;

    /* renamed from: e */
    private int f362e;

    /* renamed from: f */
    private boolean f363f;

    /* renamed from: androidx.appcompat.b.a.a$a */
    private static class C0138a extends C0143f {

        /* renamed from: a */
        private final Animatable f364a;

        C0138a(Animatable animatable) {
            super();
            this.f364a = animatable;
        }

        /* renamed from: a */
        public void mo1034a() {
            this.f364a.start();
        }

        /* renamed from: b */
        public void mo1035b() {
            this.f364a.stop();
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$b */
    static class C0139b extends C0149d.C0150a {

        /* renamed from: a */
        C0405d<Long> f365a;

        /* renamed from: b */
        C0414h<Integer> f366b;

        C0139b(C0139b bVar, C0136a aVar, Resources resources) {
            super(bVar, aVar, resources);
            C0414h<Integer> hVar;
            if (bVar != null) {
                this.f365a = bVar.f365a;
                hVar = bVar.f366b;
            } else {
                this.f365a = new C0405d<>();
                hVar = new C0414h<>();
            }
            this.f366b = hVar;
        }

        /* renamed from: f */
        private static long m377f(int i, int i2) {
            return ((long) i2) | (((long) i) << 32);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1036a(int i) {
            if (i < 0) {
                return 0;
            }
            return this.f366b.mo2970a(i, 0).intValue();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1037a(int i, int i2) {
            return (int) this.f365a.mo2847a(m377f(i, i2), -1L).longValue();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1038a(int i, int i2, Drawable drawable, boolean z) {
            int a = super.mo1064a(drawable);
            long f = m377f(i, i2);
            long j = z ? 8589934592L : 0;
            long j2 = (long) a;
            this.f365a.mo2855c(f, Long.valueOf(j2 | j));
            if (z) {
                this.f365a.mo2855c(m377f(i2, i), Long.valueOf(4294967296L | j2 | j));
            }
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1039a(int[] iArr) {
            int b = super.mo1125b(iArr);
            return b >= 0 ? b : super.mo1125b(StateSet.WILD_CARD);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1040a(int[] iArr, Drawable drawable, int i) {
            int a = super.mo1124a(iArr, drawable);
            this.f366b.mo2973b(a, Integer.valueOf(i));
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1041a() {
            this.f365a = this.f365a.clone();
            this.f366b = this.f366b.clone();
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public boolean mo1042b(int i, int i2) {
            return (this.f365a.mo2847a(m377f(i, i2), -1L).longValue() & 4294967296L) != 0;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: c */
        public boolean mo1043c(int i, int i2) {
            return (this.f365a.mo2847a(m377f(i, i2), -1L).longValue() & 8589934592L) != 0;
        }

        public Drawable newDrawable() {
            return new C0136a(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0136a(this, resources);
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$c */
    private static class C0140c extends C0143f {

        /* renamed from: a */
        private final C0901c f367a;

        C0140c(C0901c cVar) {
            super();
            this.f367a = cVar;
        }

        /* renamed from: a */
        public void mo1034a() {
            this.f367a.start();
        }

        /* renamed from: b */
        public void mo1035b() {
            this.f367a.stop();
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$d */
    private static class C0141d extends C0143f {

        /* renamed from: a */
        private final ObjectAnimator f368a;

        /* renamed from: b */
        private final boolean f369b;

        C0141d(AnimationDrawable animationDrawable, boolean z, boolean z2) {
            super();
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            int i = z ? numberOfFrames - 1 : 0;
            int i2 = z ? 0 : numberOfFrames - 1;
            C0142e eVar = new C0142e(animationDrawable, z);
            ObjectAnimator ofInt = ObjectAnimator.ofInt(animationDrawable, "currentIndex", new int[]{i, i2});
            if (Build.VERSION.SDK_INT >= 18) {
                ofInt.setAutoCancel(true);
            }
            ofInt.setDuration((long) eVar.mo1048a());
            ofInt.setInterpolator(eVar);
            this.f369b = z2;
            this.f368a = ofInt;
        }

        /* renamed from: a */
        public void mo1034a() {
            this.f368a.start();
        }

        /* renamed from: b */
        public void mo1035b() {
            this.f368a.cancel();
        }

        /* renamed from: c */
        public boolean mo1046c() {
            return this.f369b;
        }

        /* renamed from: d */
        public void mo1047d() {
            this.f368a.reverse();
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$e */
    private static class C0142e implements TimeInterpolator {

        /* renamed from: a */
        private int[] f370a;

        /* renamed from: b */
        private int f371b;

        /* renamed from: c */
        private int f372c;

        C0142e(AnimationDrawable animationDrawable, boolean z) {
            mo1049a(animationDrawable, z);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1048a() {
            return this.f372c;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1049a(AnimationDrawable animationDrawable, boolean z) {
            int numberOfFrames = animationDrawable.getNumberOfFrames();
            this.f371b = numberOfFrames;
            int[] iArr = this.f370a;
            if (iArr == null || iArr.length < numberOfFrames) {
                this.f370a = new int[numberOfFrames];
            }
            int[] iArr2 = this.f370a;
            int i = 0;
            for (int i2 = 0; i2 < numberOfFrames; i2++) {
                int duration = animationDrawable.getDuration(z ? (numberOfFrames - i2) - 1 : i2);
                iArr2[i2] = duration;
                i += duration;
            }
            this.f372c = i;
            return i;
        }

        public float getInterpolation(float f) {
            int i = (int) ((f * ((float) this.f372c)) + 0.5f);
            int i2 = this.f371b;
            int[] iArr = this.f370a;
            int i3 = 0;
            while (i3 < i2 && i >= iArr[i3]) {
                i -= iArr[i3];
                i3++;
            }
            return (((float) i3) / ((float) i2)) + (i3 < i2 ? ((float) i) / ((float) this.f372c) : 0.0f);
        }
    }

    /* renamed from: androidx.appcompat.b.a.a$f */
    private static abstract class C0143f {
        private C0143f() {
        }

        /* renamed from: a */
        public abstract void mo1034a();

        /* renamed from: b */
        public abstract void mo1035b();

        /* renamed from: c */
        public boolean mo1046c() {
            return false;
        }

        /* renamed from: d */
        public void mo1047d() {
        }
    }

    public C0136a() {
        this((C0139b) null, (Resources) null);
    }

    C0136a(C0139b bVar, Resources resources) {
        super((C0149d.C0150a) null);
        this.f361d = -1;
        this.f362e = -1;
        mo998a((C0144b.C0147b) new C0139b(bVar, this, resources));
        onStateChange(getState());
        jumpToCurrentState();
    }

    /* renamed from: a */
    public static C0136a m363a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        String name = xmlPullParser.getName();
        if (name.equals("animated-selector")) {
            C0136a aVar = new C0136a();
            aVar.mo1001b(context, resources, xmlPullParser, attributeSet, theme);
            return aVar;
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": invalid animated-selector tag " + name);
    }

    /* renamed from: a */
    private void m364a(TypedArray typedArray) {
        C0139b bVar = this.f359b;
        if (Build.VERSION.SDK_INT >= 21) {
            bVar.f402f |= typedArray.getChangingConfigurations();
        }
        bVar.mo1067a(typedArray.getBoolean(C0151a.C0153b.AnimatedStateListDrawableCompat_android_variablePadding, bVar.f407k));
        bVar.mo1070b(typedArray.getBoolean(C0151a.C0153b.AnimatedStateListDrawableCompat_android_constantSize, bVar.f410n));
        bVar.mo1072c(typedArray.getInt(C0151a.C0153b.AnimatedStateListDrawableCompat_android_enterFadeDuration, bVar.f390C));
        bVar.mo1075d(typedArray.getInt(C0151a.C0153b.AnimatedStateListDrawableCompat_android_exitFadeDuration, bVar.f391D));
        setDither(typedArray.getBoolean(C0151a.C0153b.AnimatedStateListDrawableCompat_android_dither, bVar.f422z));
    }

    /* renamed from: b */
    private boolean m365b(int i) {
        int i2;
        int a;
        C0143f fVar;
        C0143f fVar2 = this.f360c;
        if (fVar2 == null) {
            i2 = mo1054d();
        } else if (i == this.f361d) {
            return true;
        } else {
            if (i != this.f362e || !fVar2.mo1046c()) {
                i2 = this.f361d;
                fVar2.mo1035b();
            } else {
                fVar2.mo1047d();
                this.f361d = this.f362e;
                this.f362e = i;
                return true;
            }
        }
        this.f360c = null;
        this.f362e = -1;
        this.f361d = -1;
        C0139b bVar = this.f359b;
        int a2 = bVar.mo1036a(i2);
        int a3 = bVar.mo1036a(i);
        if (a3 == 0 || a2 == 0 || (a = bVar.mo1037a(a2, a3)) < 0) {
            return false;
        }
        boolean c = bVar.mo1043c(a2, a3);
        mo1053a(a);
        Drawable current = getCurrent();
        if (current instanceof AnimationDrawable) {
            fVar = new C0141d((AnimationDrawable) current, bVar.mo1042b(a2, a3), c);
        } else if (current instanceof C0901c) {
            fVar = new C0140c((C0901c) current);
        } else {
            if (current instanceof Animatable) {
                fVar = new C0138a((Animatable) current);
            }
            return false;
        }
        fVar.mo1034a();
        this.f360c = fVar;
        this.f362e = i2;
        this.f361d = i;
        return true;
    }

    /* renamed from: c */
    private void m366c(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next = xmlPullParser.next();
            if (next != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next == 3) {
                    return;
                }
                if (next == 2 && depth2 <= depth) {
                    if (xmlPullParser.getName().equals("item")) {
                        m368e(context, resources, xmlPullParser, attributeSet, theme);
                    } else if (xmlPullParser.getName().equals("transition")) {
                        m367d(context, resources, xmlPullParser, attributeSet, theme);
                    }
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: d */
    private int m367d(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray a = C0544g.m2157a(resources, theme, attributeSet, C0151a.C0153b.AnimatedStateListDrawableTransition);
        int resourceId = a.getResourceId(C0151a.C0153b.AnimatedStateListDrawableTransition_android_fromId, -1);
        int resourceId2 = a.getResourceId(C0151a.C0153b.AnimatedStateListDrawableTransition_android_toId, -1);
        int resourceId3 = a.getResourceId(C0151a.C0153b.AnimatedStateListDrawableTransition_android_drawable, -1);
        Drawable a2 = resourceId3 > 0 ? C0279an.m994a().mo2241a(context, resourceId3) : null;
        boolean z = a.getBoolean(C0151a.C0153b.AnimatedStateListDrawableTransition_android_reversible, false);
        a.recycle();
        if (a2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                a2 = xmlPullParser.getName().equals("animated-vector") ? C0901c.m3593a(context, resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (a2 == null) {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires a 'drawable' attribute or child tag defining a drawable");
        } else if (resourceId != -1 && resourceId2 != -1) {
            return this.f359b.mo1038a(resourceId, resourceId2, a2, z);
        } else {
            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <transition> tag requires 'fromId' & 'toId' attributes");
        }
    }

    /* renamed from: e */
    private int m368e(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        TypedArray a = C0544g.m2157a(resources, theme, attributeSet, C0151a.C0153b.AnimatedStateListDrawableItem);
        int resourceId = a.getResourceId(C0151a.C0153b.AnimatedStateListDrawableItem_android_id, 0);
        int resourceId2 = a.getResourceId(C0151a.C0153b.AnimatedStateListDrawableItem_android_drawable, -1);
        Drawable a2 = resourceId2 > 0 ? C0279an.m994a().mo2241a(context, resourceId2) : null;
        a.recycle();
        int[] a3 = mo1123a(attributeSet);
        if (a2 == null) {
            do {
                next = xmlPullParser.next();
            } while (next == 4);
            if (next == 2) {
                a2 = xmlPullParser.getName().equals("vector") ? C0911i.m3627a(resources, xmlPullParser, attributeSet, theme) : Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
            } else {
                throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
            }
        }
        if (a2 != null) {
            return this.f359b.mo1040a(a3, a2, resourceId);
        }
        throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
    }

    /* renamed from: e */
    private void m369e() {
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C0139b mo1002c() {
        return new C0139b(this.f359b, this, (Resources) null);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo998a(C0144b.C0147b bVar) {
        super.mo998a(bVar);
        if (bVar instanceof C0139b) {
            this.f359b = (C0139b) bVar;
        }
    }

    public /* bridge */ /* synthetic */ void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
    }

    /* renamed from: b */
    public void mo1001b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray a = C0544g.m2157a(resources, theme, attributeSet, C0151a.C0153b.AnimatedStateListDrawableCompat);
        setVisible(a.getBoolean(C0151a.C0153b.AnimatedStateListDrawableCompat_android_visible, true), true);
        m364a(a);
        mo1051a(resources);
        a.recycle();
        m366c(context, resources, xmlPullParser, attributeSet, theme);
        m369e();
    }

    public /* bridge */ /* synthetic */ boolean canApplyTheme() {
        return super.canApplyTheme();
    }

    public /* bridge */ /* synthetic */ void draw(Canvas canvas) {
        super.draw(canvas);
    }

    public /* bridge */ /* synthetic */ int getAlpha() {
        return super.getAlpha();
    }

    public /* bridge */ /* synthetic */ int getChangingConfigurations() {
        return super.getChangingConfigurations();
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public /* bridge */ /* synthetic */ void getHotspotBounds(Rect rect) {
        super.getHotspotBounds(rect);
    }

    public /* bridge */ /* synthetic */ int getIntrinsicHeight() {
        return super.getIntrinsicHeight();
    }

    public /* bridge */ /* synthetic */ int getIntrinsicWidth() {
        return super.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public /* bridge */ /* synthetic */ int getOpacity() {
        return super.getOpacity();
    }

    public /* bridge */ /* synthetic */ void getOutline(Outline outline) {
        super.getOutline(outline);
    }

    public /* bridge */ /* synthetic */ boolean getPadding(Rect rect) {
        return super.getPadding(rect);
    }

    public /* bridge */ /* synthetic */ void invalidateDrawable(Drawable drawable) {
        super.invalidateDrawable(drawable);
    }

    public /* bridge */ /* synthetic */ boolean isAutoMirrored() {
        return super.isAutoMirrored();
    }

    public boolean isStateful() {
        return true;
    }

    public void jumpToCurrentState() {
        super.jumpToCurrentState();
        C0143f fVar = this.f360c;
        if (fVar != null) {
            fVar.mo1035b();
            this.f360c = null;
            mo1053a(this.f361d);
            this.f361d = -1;
            this.f362e = -1;
        }
    }

    public Drawable mutate() {
        if (!this.f363f && super.mutate() == this) {
            this.f359b.mo1041a();
            this.f363f = true;
        }
        return this;
    }

    public /* bridge */ /* synthetic */ boolean onLayoutDirectionChanged(int i) {
        return super.onLayoutDirectionChanged(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        int a = this.f359b.mo1039a(iArr);
        boolean z = a != mo1054d() && (m365b(a) || mo1053a(a));
        Drawable current = getCurrent();
        return current != null ? z | current.setState(iArr) : z;
    }

    public /* bridge */ /* synthetic */ void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
        super.scheduleDrawable(drawable, runnable, j);
    }

    public /* bridge */ /* synthetic */ void setAlpha(int i) {
        super.setAlpha(i);
    }

    public /* bridge */ /* synthetic */ void setAutoMirrored(boolean z) {
        super.setAutoMirrored(z);
    }

    public /* bridge */ /* synthetic */ void setColorFilter(ColorFilter colorFilter) {
        super.setColorFilter(colorFilter);
    }

    public /* bridge */ /* synthetic */ void setDither(boolean z) {
        super.setDither(z);
    }

    public /* bridge */ /* synthetic */ void setHotspot(float f, float f2) {
        super.setHotspot(f, f2);
    }

    public /* bridge */ /* synthetic */ void setHotspotBounds(int i, int i2, int i3, int i4) {
        super.setHotspotBounds(i, i2, i3, i4);
    }

    public /* bridge */ /* synthetic */ void setTintList(ColorStateList colorStateList) {
        super.setTintList(colorStateList);
    }

    public /* bridge */ /* synthetic */ void setTintMode(PorterDuff.Mode mode) {
        super.setTintMode(mode);
    }

    public boolean setVisible(boolean z, boolean z2) {
        boolean visible = super.setVisible(z, z2);
        if (this.f360c != null && (visible || z2)) {
            if (z) {
                this.f360c.mo1034a();
            } else {
                jumpToCurrentState();
            }
        }
        return visible;
    }

    public /* bridge */ /* synthetic */ void unscheduleDrawable(Drawable drawable, Runnable runnable) {
        super.unscheduleDrawable(drawable, runnable);
    }
}
