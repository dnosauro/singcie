package androidx.p050k.p051a.p052a;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.drawable.AnimatedVectorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import androidx.core.content.p025a.C0544g;
import androidx.core.graphics.drawable.C0595a;
import androidx.p018c.C0400a;
import java.util.ArrayList;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.k.a.a.c */
public class C0901c extends C0910h implements C0900b {

    /* renamed from: a */
    ArrayList<Object> f2943a;

    /* renamed from: b */
    final Drawable.Callback f2944b;

    /* renamed from: d */
    private C0903a f2945d;

    /* renamed from: e */
    private Context f2946e;

    /* renamed from: f */
    private ArgbEvaluator f2947f;

    /* renamed from: g */
    private Animator.AnimatorListener f2948g;

    /* renamed from: androidx.k.a.a.c$a */
    private static class C0903a extends Drawable.ConstantState {

        /* renamed from: a */
        int f2950a;

        /* renamed from: b */
        C0911i f2951b;

        /* renamed from: c */
        AnimatorSet f2952c;

        /* renamed from: d */
        ArrayList<Animator> f2953d;

        /* renamed from: e */
        C0400a<Animator, String> f2954e;

        public C0903a(Context context, C0903a aVar, Drawable.Callback callback, Resources resources) {
            if (aVar != null) {
                this.f2950a = aVar.f2950a;
                C0911i iVar = aVar.f2951b;
                if (iVar != null) {
                    Drawable.ConstantState constantState = iVar.getConstantState();
                    this.f2951b = (C0911i) (resources != null ? constantState.newDrawable(resources) : constantState.newDrawable());
                    this.f2951b = (C0911i) this.f2951b.mutate();
                    this.f2951b.setCallback(callback);
                    this.f2951b.setBounds(aVar.f2951b.getBounds());
                    this.f2951b.mo4894a(false);
                }
                ArrayList<Animator> arrayList = aVar.f2953d;
                if (arrayList != null) {
                    int size = arrayList.size();
                    this.f2953d = new ArrayList<>(size);
                    this.f2954e = new C0400a<>(size);
                    for (int i = 0; i < size; i++) {
                        Animator animator = aVar.f2953d.get(i);
                        Animator clone = animator.clone();
                        String str = aVar.f2954e.get(animator);
                        clone.setTarget(this.f2951b.mo4893a(str));
                        this.f2953d.add(clone);
                        this.f2954e.put(clone, str);
                    }
                    mo4879a();
                }
            }
        }

        /* renamed from: a */
        public void mo4879a() {
            if (this.f2952c == null) {
                this.f2952c = new AnimatorSet();
            }
            this.f2952c.playTogether(this.f2953d);
        }

        public int getChangingConfigurations() {
            return this.f2950a;
        }

        public Drawable newDrawable() {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }

        public Drawable newDrawable(Resources resources) {
            throw new IllegalStateException("No constant state support for SDK < 24.");
        }
    }

    /* renamed from: androidx.k.a.a.c$b */
    private static class C0904b extends Drawable.ConstantState {

        /* renamed from: a */
        private final Drawable.ConstantState f2955a;

        public C0904b(Drawable.ConstantState constantState) {
            this.f2955a = constantState;
        }

        public boolean canApplyTheme() {
            return this.f2955a.canApplyTheme();
        }

        public int getChangingConfigurations() {
            return this.f2955a.getChangingConfigurations();
        }

        public Drawable newDrawable() {
            C0901c cVar = new C0901c();
            cVar.f2960c = this.f2955a.newDrawable();
            cVar.f2960c.setCallback(cVar.f2944b);
            return cVar;
        }

        public Drawable newDrawable(Resources resources) {
            C0901c cVar = new C0901c();
            cVar.f2960c = this.f2955a.newDrawable(resources);
            cVar.f2960c.setCallback(cVar.f2944b);
            return cVar;
        }

        public Drawable newDrawable(Resources resources, Resources.Theme theme) {
            C0901c cVar = new C0901c();
            cVar.f2960c = this.f2955a.newDrawable(resources, theme);
            cVar.f2960c.setCallback(cVar.f2944b);
            return cVar;
        }
    }

    C0901c() {
        this((Context) null, (C0903a) null, (Resources) null);
    }

    private C0901c(Context context) {
        this(context, (C0903a) null, (Resources) null);
    }

    private C0901c(Context context, C0903a aVar, Resources resources) {
        this.f2947f = null;
        this.f2948g = null;
        this.f2943a = null;
        this.f2944b = new Drawable.Callback() {
            public void invalidateDrawable(Drawable drawable) {
                C0901c.this.invalidateSelf();
            }

            public void scheduleDrawable(Drawable drawable, Runnable runnable, long j) {
                C0901c.this.scheduleSelf(runnable, j);
            }

            public void unscheduleDrawable(Drawable drawable, Runnable runnable) {
                C0901c.this.unscheduleSelf(runnable);
            }
        };
        this.f2946e = context;
        if (aVar != null) {
            this.f2945d = aVar;
        } else {
            this.f2945d = new C0903a(context, aVar, this.f2944b, resources);
        }
    }

    /* renamed from: a */
    public static C0901c m3593a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        C0901c cVar = new C0901c(context);
        cVar.inflate(resources, xmlPullParser, attributeSet, theme);
        return cVar;
    }

    /* renamed from: a */
    private void m3594a(Animator animator) {
        ArrayList<Animator> childAnimations;
        if ((animator instanceof AnimatorSet) && (childAnimations = ((AnimatorSet) animator).getChildAnimations()) != null) {
            for (int i = 0; i < childAnimations.size(); i++) {
                m3594a(childAnimations.get(i));
            }
        }
        if (animator instanceof ObjectAnimator) {
            ObjectAnimator objectAnimator = (ObjectAnimator) animator;
            String propertyName = objectAnimator.getPropertyName();
            if ("fillColor".equals(propertyName) || "strokeColor".equals(propertyName)) {
                if (this.f2947f == null) {
                    this.f2947f = new ArgbEvaluator();
                }
                objectAnimator.setEvaluator(this.f2947f);
            }
        }
    }

    /* renamed from: a */
    private void m3595a(String str, Animator animator) {
        animator.setTarget(this.f2945d.f2951b.mo4893a(str));
        if (Build.VERSION.SDK_INT < 21) {
            m3594a(animator);
        }
        if (this.f2945d.f2953d == null) {
            this.f2945d.f2953d = new ArrayList<>();
            this.f2945d.f2954e = new C0400a<>();
        }
        this.f2945d.f2953d.add(animator);
        this.f2945d.f2954e.put(animator, str);
    }

    public void applyTheme(Resources.Theme theme) {
        if (this.f2960c != null) {
            C0595a.m2320a(this.f2960c, theme);
        }
    }

    public boolean canApplyTheme() {
        if (this.f2960c != null) {
            return C0595a.m2327d(this.f2960c);
        }
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
        this.f2945d.f2951b.draw(canvas);
        if (this.f2945d.f2952c.isStarted()) {
            invalidateSelf();
        }
    }

    public int getAlpha() {
        return this.f2960c != null ? C0595a.m2326c(this.f2960c) : this.f2945d.f2951b.getAlpha();
    }

    public int getChangingConfigurations() {
        return this.f2960c != null ? this.f2960c.getChangingConfigurations() : super.getChangingConfigurations() | this.f2945d.f2950a;
    }

    public ColorFilter getColorFilter() {
        return this.f2960c != null ? C0595a.m2328e(this.f2960c) : this.f2945d.f2951b.getColorFilter();
    }

    public Drawable.ConstantState getConstantState() {
        if (this.f2960c == null || Build.VERSION.SDK_INT < 24) {
            return null;
        }
        return new C0904b(this.f2960c.getConstantState());
    }

    public /* bridge */ /* synthetic */ Drawable getCurrent() {
        return super.getCurrent();
    }

    public int getIntrinsicHeight() {
        return this.f2960c != null ? this.f2960c.getIntrinsicHeight() : this.f2945d.f2951b.getIntrinsicHeight();
    }

    public int getIntrinsicWidth() {
        return this.f2960c != null ? this.f2960c.getIntrinsicWidth() : this.f2945d.f2951b.getIntrinsicWidth();
    }

    public /* bridge */ /* synthetic */ int getMinimumHeight() {
        return super.getMinimumHeight();
    }

    public /* bridge */ /* synthetic */ int getMinimumWidth() {
        return super.getMinimumWidth();
    }

    public int getOpacity() {
        return this.f2960c != null ? this.f2960c.getOpacity() : this.f2945d.f2951b.getOpacity();
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
        inflate(resources, xmlPullParser, attributeSet, (Resources.Theme) null);
    }

    public void inflate(Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray obtainAttributes;
        if (this.f2960c != null) {
            C0595a.m2321a(this.f2960c, resources, xmlPullParser, attributeSet, theme);
            return;
        }
        int eventType = xmlPullParser.getEventType();
        int depth = xmlPullParser.getDepth() + 1;
        while (eventType != 1 && (xmlPullParser.getDepth() >= depth || eventType != 3)) {
            if (eventType == 2) {
                String name = xmlPullParser.getName();
                if ("animated-vector".equals(name)) {
                    obtainAttributes = C0544g.m2157a(resources, theme, attributeSet, C0899a.f2935e);
                    int resourceId = obtainAttributes.getResourceId(0, 0);
                    if (resourceId != 0) {
                        C0911i a = C0911i.m3626a(resources, resourceId, theme);
                        a.mo4894a(false);
                        a.setCallback(this.f2944b);
                        if (this.f2945d.f2951b != null) {
                            this.f2945d.f2951b.setCallback((Drawable.Callback) null);
                        }
                        this.f2945d.f2951b = a;
                    }
                } else if ("target".equals(name)) {
                    obtainAttributes = resources.obtainAttributes(attributeSet, C0899a.f2936f);
                    String string = obtainAttributes.getString(0);
                    int resourceId2 = obtainAttributes.getResourceId(1, 0);
                    if (resourceId2 != 0) {
                        Context context = this.f2946e;
                        if (context != null) {
                            m3595a(string, C0906e.m3601a(context, resourceId2));
                        } else {
                            obtainAttributes.recycle();
                            throw new IllegalStateException("Context can't be null when inflating animators");
                        }
                    }
                } else {
                    continue;
                }
                obtainAttributes.recycle();
            }
            eventType = xmlPullParser.next();
        }
        this.f2945d.mo4879a();
    }

    public boolean isAutoMirrored() {
        return this.f2960c != null ? C0595a.m2324b(this.f2960c) : this.f2945d.f2951b.isAutoMirrored();
    }

    public boolean isRunning() {
        return this.f2960c != null ? ((AnimatedVectorDrawable) this.f2960c).isRunning() : this.f2945d.f2952c.isRunning();
    }

    public boolean isStateful() {
        return this.f2960c != null ? this.f2960c.isStateful() : this.f2945d.f2951b.isStateful();
    }

    public /* bridge */ /* synthetic */ void jumpToCurrentState() {
        super.jumpToCurrentState();
    }

    public Drawable mutate() {
        if (this.f2960c != null) {
            this.f2960c.mutate();
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void onBoundsChange(Rect rect) {
        if (this.f2960c != null) {
            this.f2960c.setBounds(rect);
        } else {
            this.f2945d.f2951b.setBounds(rect);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onLevelChange(int i) {
        return this.f2960c != null ? this.f2960c.setLevel(i) : this.f2945d.f2951b.setLevel(i);
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        return this.f2960c != null ? this.f2960c.setState(iArr) : this.f2945d.f2951b.setState(iArr);
    }

    public void setAlpha(int i) {
        if (this.f2960c != null) {
            this.f2960c.setAlpha(i);
        } else {
            this.f2945d.f2951b.setAlpha(i);
        }
    }

    public void setAutoMirrored(boolean z) {
        if (this.f2960c != null) {
            C0595a.m2323a(this.f2960c, z);
        } else {
            this.f2945d.f2951b.setAutoMirrored(z);
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
        } else {
            this.f2945d.f2951b.setColorFilter(colorFilter);
        }
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
            this.f2945d.f2951b.setTint(i);
        }
    }

    public void setTintList(ColorStateList colorStateList) {
        if (this.f2960c != null) {
            C0595a.m2319a(this.f2960c, colorStateList);
        } else {
            this.f2945d.f2951b.setTintList(colorStateList);
        }
    }

    public void setTintMode(PorterDuff.Mode mode) {
        if (this.f2960c != null) {
            C0595a.m2322a(this.f2960c, mode);
        } else {
            this.f2945d.f2951b.setTintMode(mode);
        }
    }

    public boolean setVisible(boolean z, boolean z2) {
        if (this.f2960c != null) {
            return this.f2960c.setVisible(z, z2);
        }
        this.f2945d.f2951b.setVisible(z, z2);
        return super.setVisible(z, z2);
    }

    public void start() {
        if (this.f2960c != null) {
            ((AnimatedVectorDrawable) this.f2960c).start();
        } else if (!this.f2945d.f2952c.isStarted()) {
            this.f2945d.f2952c.start();
            invalidateSelf();
        }
    }

    public void stop() {
        if (this.f2960c != null) {
            ((AnimatedVectorDrawable) this.f2960c).stop();
        } else {
            this.f2945d.f2952c.end();
        }
    }
}
