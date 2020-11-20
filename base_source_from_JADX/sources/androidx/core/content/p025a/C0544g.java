package androidx.core.content.p025a;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.core.content.a.g */
public class C0544g {
    /* renamed from: a */
    public static float m2153a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, float f) {
        return !m2161a(xmlPullParser, str) ? f : typedArray.getFloat(i, f);
    }

    /* renamed from: a */
    public static int m2154a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m2161a(xmlPullParser, str) ? i2 : typedArray.getInt(i, i2);
    }

    /* renamed from: a */
    public static ColorStateList m2155a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i) {
        if (!m2161a(xmlPullParser, str)) {
            return null;
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        if (typedValue.type != 2) {
            return (typedValue.type < 28 || typedValue.type > 31) ? C0530a.m2105a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme) : m2156a(typedValue);
        }
        throw new UnsupportedOperationException("Failed to resolve attribute at index " + i + ": " + typedValue);
    }

    /* renamed from: a */
    private static ColorStateList m2156a(TypedValue typedValue) {
        return ColorStateList.valueOf(typedValue.data);
    }

    /* renamed from: a */
    public static TypedArray m2157a(Resources resources, Resources.Theme theme, AttributeSet attributeSet, int[] iArr) {
        return theme == null ? resources.obtainAttributes(attributeSet, iArr) : theme.obtainStyledAttributes(attributeSet, iArr, 0, 0);
    }

    /* renamed from: a */
    public static C0531b m2158a(TypedArray typedArray, XmlPullParser xmlPullParser, Resources.Theme theme, String str, int i, int i2) {
        if (m2161a(xmlPullParser, str)) {
            TypedValue typedValue = new TypedValue();
            typedArray.getValue(i, typedValue);
            if (typedValue.type >= 28 && typedValue.type <= 31) {
                return C0531b.m2110a(typedValue.data);
            }
            C0531b a = C0531b.m2112a(typedArray.getResources(), typedArray.getResourceId(i, 0), theme);
            if (a != null) {
                return a;
            }
        }
        return C0531b.m2110a(i2);
    }

    /* renamed from: a */
    public static String m2159a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!m2161a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.getString(i);
    }

    /* renamed from: a */
    public static boolean m2160a(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, boolean z) {
        return !m2161a(xmlPullParser, str) ? z : typedArray.getBoolean(i, z);
    }

    /* renamed from: a */
    public static boolean m2161a(XmlPullParser xmlPullParser, String str) {
        return xmlPullParser.getAttributeValue("http://schemas.android.com/apk/res/android", str) != null;
    }

    /* renamed from: b */
    public static int m2162b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m2161a(xmlPullParser, str) ? i2 : typedArray.getColor(i, i2);
    }

    /* renamed from: b */
    public static TypedValue m2163b(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i) {
        if (!m2161a(xmlPullParser, str)) {
            return null;
        }
        return typedArray.peekValue(i);
    }

    /* renamed from: c */
    public static int m2164c(TypedArray typedArray, XmlPullParser xmlPullParser, String str, int i, int i2) {
        return !m2161a(xmlPullParser, str) ? i2 : typedArray.getResourceId(i, i2);
    }
}
