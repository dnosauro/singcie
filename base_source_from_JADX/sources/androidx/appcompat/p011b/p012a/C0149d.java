package androidx.appcompat.p011b.p012a;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.util.StateSet;
import androidx.appcompat.p011b.p012a.C0144b;
import androidx.appcompat.p013c.C0151a;
import androidx.appcompat.widget.C0279an;
import androidx.core.content.p025a.C0544g;
import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserException;

@SuppressLint({"RestrictedAPI"})
/* renamed from: androidx.appcompat.b.a.d */
class C0149d extends C0144b {

    /* renamed from: a */
    private C0150a f423a;

    /* renamed from: b */
    private boolean f424b;

    /* renamed from: androidx.appcompat.b.a.d$a */
    static class C0150a extends C0144b.C0147b {

        /* renamed from: L */
        int[][] f425L;

        C0150a(C0150a aVar, C0149d dVar, Resources resources) {
            super(aVar, dVar, resources);
            this.f425L = aVar != null ? aVar.f425L : new int[mo1071c()][];
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public int mo1124a(int[] iArr, Drawable drawable) {
            int a = mo1064a(drawable);
            this.f425L[a] = iArr;
            return a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo1041a() {
            int[][] iArr = this.f425L;
            int[][] iArr2 = new int[iArr.length][];
            for (int length = iArr.length - 1; length >= 0; length--) {
                int[][] iArr3 = this.f425L;
                iArr2[length] = iArr3[length] != null ? (int[]) iArr3[length].clone() : null;
            }
            this.f425L = iArr2;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public int mo1125b(int[] iArr) {
            int[][] iArr2 = this.f425L;
            int d = mo1074d();
            for (int i = 0; i < d; i++) {
                if (StateSet.stateSetMatches(iArr2[i], iArr)) {
                    return i;
                }
            }
            return -1;
        }

        /* renamed from: e */
        public void mo1078e(int i, int i2) {
            super.mo1078e(i, i2);
            int[][] iArr = new int[i2][];
            System.arraycopy(this.f425L, 0, iArr, 0, i);
            this.f425L = iArr;
        }

        public Drawable newDrawable() {
            return new C0149d(this, (Resources) null);
        }

        public Drawable newDrawable(Resources resources) {
            return new C0149d(this, resources);
        }
    }

    C0149d() {
        this((C0150a) null, (Resources) null);
    }

    C0149d(C0150a aVar) {
        if (aVar != null) {
            mo998a((C0144b.C0147b) aVar);
        }
    }

    C0149d(C0150a aVar, Resources resources) {
        mo998a((C0144b.C0147b) new C0150a(aVar, this, resources));
        onStateChange(getState());
    }

    /* renamed from: a */
    private void m435a(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        int next;
        C0150a aVar = this.f423a;
        int depth = xmlPullParser.getDepth() + 1;
        while (true) {
            int next2 = xmlPullParser.next();
            if (next2 != 1) {
                int depth2 = xmlPullParser.getDepth();
                if (depth2 < depth && next2 == 3) {
                    return;
                }
                if (next2 == 2 && depth2 <= depth && xmlPullParser.getName().equals("item")) {
                    TypedArray a = C0544g.m2157a(resources, theme, attributeSet, C0151a.C0153b.StateListDrawableItem);
                    Drawable drawable = null;
                    int resourceId = a.getResourceId(C0151a.C0153b.StateListDrawableItem_android_drawable, -1);
                    if (resourceId > 0) {
                        drawable = C0279an.m994a().mo2241a(context, resourceId);
                    }
                    a.recycle();
                    int[] a2 = mo1123a(attributeSet);
                    if (drawable == null) {
                        do {
                            next = xmlPullParser.next();
                        } while (next == 4);
                        if (next == 2) {
                            drawable = Build.VERSION.SDK_INT >= 21 ? Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet, theme) : Drawable.createFromXmlInner(resources, xmlPullParser, attributeSet);
                        } else {
                            throw new XmlPullParserException(xmlPullParser.getPositionDescription() + ": <item> tag requires a 'drawable' attribute or child tag defining a drawable");
                        }
                    }
                    aVar.mo1124a(a2, drawable);
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m436a(TypedArray typedArray) {
        C0150a aVar = this.f423a;
        if (Build.VERSION.SDK_INT >= 21) {
            aVar.f402f |= typedArray.getChangingConfigurations();
        }
        aVar.f407k = typedArray.getBoolean(C0151a.C0153b.StateListDrawable_android_variablePadding, aVar.f407k);
        aVar.f410n = typedArray.getBoolean(C0151a.C0153b.StateListDrawable_android_constantSize, aVar.f410n);
        aVar.f390C = typedArray.getInt(C0151a.C0153b.StateListDrawable_android_enterFadeDuration, aVar.f390C);
        aVar.f391D = typedArray.getInt(C0151a.C0153b.StateListDrawable_android_exitFadeDuration, aVar.f391D);
        aVar.f422z = typedArray.getBoolean(C0151a.C0153b.StateListDrawable_android_dither, aVar.f422z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo998a(C0144b.C0147b bVar) {
        super.mo998a(bVar);
        if (bVar instanceof C0150a) {
            this.f423a = (C0150a) bVar;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int[] mo1123a(AttributeSet attributeSet) {
        int attributeCount = attributeSet.getAttributeCount();
        int[] iArr = new int[attributeCount];
        int i = 0;
        for (int i2 = 0; i2 < attributeCount; i2++) {
            int attributeNameResource = attributeSet.getAttributeNameResource(i2);
            if (!(attributeNameResource == 0 || attributeNameResource == 16842960 || attributeNameResource == 16843161)) {
                int i3 = i + 1;
                if (!attributeSet.getAttributeBooleanValue(i2, false)) {
                    attributeNameResource = -attributeNameResource;
                }
                iArr[i] = attributeNameResource;
                i = i3;
            }
        }
        return StateSet.trimStateSet(iArr, i);
    }

    public void applyTheme(Resources.Theme theme) {
        super.applyTheme(theme);
        onStateChange(getState());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public C0150a mo1002c() {
        return new C0150a(this.f423a, this, (Resources) null);
    }

    /* renamed from: b */
    public void mo1001b(Context context, Resources resources, XmlPullParser xmlPullParser, AttributeSet attributeSet, Resources.Theme theme) {
        TypedArray a = C0544g.m2157a(resources, theme, attributeSet, C0151a.C0153b.StateListDrawable);
        setVisible(a.getBoolean(C0151a.C0153b.StateListDrawable_android_visible, true), true);
        m436a(a);
        mo1051a(resources);
        a.recycle();
        m435a(context, resources, xmlPullParser, attributeSet, theme);
        onStateChange(getState());
    }

    public boolean isStateful() {
        return true;
    }

    public Drawable mutate() {
        if (!this.f424b && super.mutate() == this) {
            this.f423a.mo1041a();
            this.f424b = true;
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public boolean onStateChange(int[] iArr) {
        boolean onStateChange = super.onStateChange(iArr);
        int b = this.f423a.mo1125b(iArr);
        if (b < 0) {
            b = this.f423a.mo1125b(StateSet.WILD_CARD);
        }
        return mo1053a(b) || onStateChange;
    }
}
