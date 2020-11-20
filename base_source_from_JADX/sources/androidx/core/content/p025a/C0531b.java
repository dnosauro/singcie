package androidx.core.content.p025a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Shader;
import android.util.Log;

/* renamed from: androidx.core.content.a.b */
public final class C0531b {

    /* renamed from: a */
    private final Shader f2056a;

    /* renamed from: b */
    private final ColorStateList f2057b;

    /* renamed from: c */
    private int f2058c;

    private C0531b(Shader shader, ColorStateList colorStateList, int i) {
        this.f2056a = shader;
        this.f2057b = colorStateList;
        this.f2058c = i;
    }

    /* renamed from: a */
    static C0531b m2110a(int i) {
        return new C0531b((Shader) null, (ColorStateList) null, i);
    }

    /* renamed from: a */
    static C0531b m2111a(ColorStateList colorStateList) {
        return new C0531b((Shader) null, colorStateList, colorStateList.getDefaultColor());
    }

    /* renamed from: a */
    public static C0531b m2112a(Resources resources, int i, Resources.Theme theme) {
        try {
            return m2114b(resources, i, theme);
        } catch (Exception e) {
            Log.e("ComplexColorCompat", "Failed to inflate ComplexColor.", e);
            return null;
        }
    }

    /* renamed from: a */
    static C0531b m2113a(Shader shader) {
        return new C0531b(shader, (ColorStateList) null, 0);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0039, code lost:
        if (r1.equals("gradient") != false) goto L_0x003d;
     */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0040  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x005e  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0067  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static androidx.core.content.p025a.C0531b m2114b(android.content.res.Resources r6, int r7, android.content.res.Resources.Theme r8) {
        /*
            android.content.res.XmlResourceParser r7 = r6.getXml(r7)
            android.util.AttributeSet r0 = android.util.Xml.asAttributeSet(r7)
        L_0x0008:
            int r1 = r7.next()
            r2 = 1
            r3 = 2
            if (r1 == r3) goto L_0x0013
            if (r1 == r2) goto L_0x0013
            goto L_0x0008
        L_0x0013:
            if (r1 != r3) goto L_0x0070
            java.lang.String r1 = r7.getName()
            r3 = -1
            int r4 = r1.hashCode()
            r5 = 89650992(0x557f730, float:1.01546526E-35)
            if (r4 == r5) goto L_0x0033
            r2 = 1191572447(0x4705f3df, float:34291.87)
            if (r4 == r2) goto L_0x0029
            goto L_0x003c
        L_0x0029:
            java.lang.String r2 = "selector"
            boolean r2 = r1.equals(r2)
            if (r2 == 0) goto L_0x003c
            r2 = 0
            goto L_0x003d
        L_0x0033:
            java.lang.String r4 = "gradient"
            boolean r4 = r1.equals(r4)
            if (r4 == 0) goto L_0x003c
            goto L_0x003d
        L_0x003c:
            r2 = -1
        L_0x003d:
            switch(r2) {
                case 0: goto L_0x0067;
                case 1: goto L_0x005e;
                default: goto L_0x0040;
            }
        L_0x0040:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r7 = r7.getPositionDescription()
            r8.append(r7)
            java.lang.String r7 = ": unsupported complex color tag "
            r8.append(r7)
            r8.append(r1)
            java.lang.String r7 = r8.toString()
            r6.<init>(r7)
            throw r6
        L_0x005e:
            android.graphics.Shader r6 = androidx.core.content.p025a.C0537d.m2141a(r6, r7, r0, r8)
            androidx.core.content.a.b r6 = m2113a((android.graphics.Shader) r6)
            return r6
        L_0x0067:
            android.content.res.ColorStateList r6 = androidx.core.content.p025a.C0530a.m2107a((android.content.res.Resources) r6, (org.xmlpull.v1.XmlPullParser) r7, (android.util.AttributeSet) r0, (android.content.res.Resources.Theme) r8)
            androidx.core.content.a.b r6 = m2111a((android.content.res.ColorStateList) r6)
            return r6
        L_0x0070:
            org.xmlpull.v1.XmlPullParserException r6 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r7 = "No start tag found"
            r6.<init>(r7)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.p025a.C0531b.m2114b(android.content.res.Resources, int, android.content.res.Resources$Theme):androidx.core.content.a.b");
    }

    /* renamed from: a */
    public Shader mo3519a() {
        return this.f2056a;
    }

    /* renamed from: a */
    public boolean mo3520a(int[] iArr) {
        if (mo3524d()) {
            ColorStateList colorStateList = this.f2057b;
            int colorForState = colorStateList.getColorForState(iArr, colorStateList.getDefaultColor());
            if (colorForState != this.f2058c) {
                this.f2058c = colorForState;
                return true;
            }
        }
        return false;
    }

    /* renamed from: b */
    public int mo3521b() {
        return this.f2058c;
    }

    /* renamed from: b */
    public void mo3522b(int i) {
        this.f2058c = i;
    }

    /* renamed from: c */
    public boolean mo3523c() {
        return this.f2056a != null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = r1.f2057b;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo3524d() {
        /*
            r1 = this;
            android.graphics.Shader r0 = r1.f2056a
            if (r0 != 0) goto L_0x0010
            android.content.res.ColorStateList r0 = r1.f2057b
            if (r0 == 0) goto L_0x0010
            boolean r0 = r0.isStateful()
            if (r0 == 0) goto L_0x0010
            r0 = 1
            goto L_0x0011
        L_0x0010:
            r0 = 0
        L_0x0011:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.p025a.C0531b.mo3524d():boolean");
    }

    /* renamed from: e */
    public boolean mo3525e() {
        return mo3523c() || this.f2058c != 0;
    }
}
