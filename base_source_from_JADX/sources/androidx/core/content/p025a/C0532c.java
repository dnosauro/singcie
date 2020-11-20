package androidx.core.content.p025a;

import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.util.Base64;
import android.util.TypedValue;
import android.util.Xml;
import androidx.core.C0481a;
import androidx.core.p027e.C0549a;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import org.xmlpull.v1.XmlPullParser;

/* renamed from: androidx.core.content.a.c */
public class C0532c {

    /* renamed from: androidx.core.content.a.c$a */
    public interface C0533a {
    }

    /* renamed from: androidx.core.content.a.c$b */
    public static final class C0534b implements C0533a {

        /* renamed from: a */
        private final C0535c[] f2059a;

        public C0534b(C0535c[] cVarArr) {
            this.f2059a = cVarArr;
        }

        /* renamed from: a */
        public C0535c[] mo3526a() {
            return this.f2059a;
        }
    }

    /* renamed from: androidx.core.content.a.c$c */
    public static final class C0535c {

        /* renamed from: a */
        private final String f2060a;

        /* renamed from: b */
        private int f2061b;

        /* renamed from: c */
        private boolean f2062c;

        /* renamed from: d */
        private String f2063d;

        /* renamed from: e */
        private int f2064e;

        /* renamed from: f */
        private int f2065f;

        public C0535c(String str, int i, boolean z, String str2, int i2, int i3) {
            this.f2060a = str;
            this.f2061b = i;
            this.f2062c = z;
            this.f2063d = str2;
            this.f2064e = i2;
            this.f2065f = i3;
        }

        /* renamed from: a */
        public String mo3527a() {
            return this.f2060a;
        }

        /* renamed from: b */
        public int mo3528b() {
            return this.f2061b;
        }

        /* renamed from: c */
        public boolean mo3529c() {
            return this.f2062c;
        }

        /* renamed from: d */
        public String mo3530d() {
            return this.f2063d;
        }

        /* renamed from: e */
        public int mo3531e() {
            return this.f2064e;
        }

        /* renamed from: f */
        public int mo3532f() {
            return this.f2065f;
        }
    }

    /* renamed from: androidx.core.content.a.c$d */
    public static final class C0536d implements C0533a {

        /* renamed from: a */
        private final C0549a f2066a;

        /* renamed from: b */
        private final int f2067b;

        /* renamed from: c */
        private final int f2068c;

        public C0536d(C0549a aVar, int i, int i2) {
            this.f2066a = aVar;
            this.f2068c = i;
            this.f2067b = i2;
        }

        /* renamed from: a */
        public C0549a mo3533a() {
            return this.f2066a;
        }

        /* renamed from: b */
        public int mo3534b() {
            return this.f2068c;
        }

        /* renamed from: c */
        public int mo3535c() {
            return this.f2067b;
        }
    }

    /* renamed from: a */
    private static int m2122a(TypedArray typedArray, int i) {
        if (Build.VERSION.SDK_INT >= 21) {
            return typedArray.getType(i);
        }
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        return typedValue.type;
    }

    /*  JADX ERROR: StackOverflow in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: a */
    public static androidx.core.content.p025a.C0532c.C0533a m2123a(org.xmlpull.v1.XmlPullParser r3, android.content.res.Resources r4) {
        /*
        L_0x0000:
            int r0 = r3.next()
            r1 = 2
            if (r0 == r1) goto L_0x000b
            r2 = 1
            if (r0 == r2) goto L_0x000b
            goto L_0x0000
        L_0x000b:
            if (r0 != r1) goto L_0x0012
            androidx.core.content.a.c$a r3 = m2127b(r3, r4)
            return r3
        L_0x0012:
            org.xmlpull.v1.XmlPullParserException r3 = new org.xmlpull.v1.XmlPullParserException
            java.lang.String r4 = "No start tag found"
            r3.<init>(r4)
            throw r3
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.core.content.p025a.C0532c.m2123a(org.xmlpull.v1.XmlPullParser, android.content.res.Resources):androidx.core.content.a.c$a");
    }

    /* renamed from: a */
    public static List<List<byte[]>> m2124a(Resources resources, int i) {
        if (i == 0) {
            return Collections.emptyList();
        }
        TypedArray obtainTypedArray = resources.obtainTypedArray(i);
        try {
            if (obtainTypedArray.length() == 0) {
                return Collections.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            if (m2122a(obtainTypedArray, 0) == 1) {
                for (int i2 = 0; i2 < obtainTypedArray.length(); i2++) {
                    int resourceId = obtainTypedArray.getResourceId(i2, 0);
                    if (resourceId != 0) {
                        arrayList.add(m2125a(resources.getStringArray(resourceId)));
                    }
                }
            } else {
                arrayList.add(m2125a(resources.getStringArray(i)));
            }
            obtainTypedArray.recycle();
            return arrayList;
        } finally {
            obtainTypedArray.recycle();
        }
    }

    /* renamed from: a */
    private static List<byte[]> m2125a(String[] strArr) {
        ArrayList arrayList = new ArrayList();
        for (String decode : strArr) {
            arrayList.add(Base64.decode(decode, 0));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static void m2126a(XmlPullParser xmlPullParser) {
        int i = 1;
        while (i > 0) {
            switch (xmlPullParser.next()) {
                case 2:
                    i++;
                    break;
                case 3:
                    i--;
                    break;
            }
        }
    }

    /* renamed from: b */
    private static C0533a m2127b(XmlPullParser xmlPullParser, Resources resources) {
        xmlPullParser.require(2, (String) null, "font-family");
        if (xmlPullParser.getName().equals("font-family")) {
            return m2128c(xmlPullParser, resources);
        }
        m2126a(xmlPullParser);
        return null;
    }

    /* renamed from: c */
    private static C0533a m2128c(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0481a.C0485d.FontFamily);
        String string = obtainAttributes.getString(C0481a.C0485d.FontFamily_fontProviderAuthority);
        String string2 = obtainAttributes.getString(C0481a.C0485d.FontFamily_fontProviderPackage);
        String string3 = obtainAttributes.getString(C0481a.C0485d.FontFamily_fontProviderQuery);
        int resourceId = obtainAttributes.getResourceId(C0481a.C0485d.FontFamily_fontProviderCerts, 0);
        int integer = obtainAttributes.getInteger(C0481a.C0485d.FontFamily_fontProviderFetchStrategy, 1);
        int integer2 = obtainAttributes.getInteger(C0481a.C0485d.FontFamily_fontProviderFetchTimeout, 500);
        obtainAttributes.recycle();
        if (string == null || string2 == null || string3 == null) {
            ArrayList arrayList = new ArrayList();
            while (xmlPullParser.next() != 3) {
                if (xmlPullParser.getEventType() == 2) {
                    if (xmlPullParser.getName().equals("font")) {
                        arrayList.add(m2129d(xmlPullParser, resources));
                    } else {
                        m2126a(xmlPullParser);
                    }
                }
            }
            if (arrayList.isEmpty()) {
                return null;
            }
            return new C0534b((C0535c[]) arrayList.toArray(new C0535c[arrayList.size()]));
        }
        while (xmlPullParser.next() != 3) {
            m2126a(xmlPullParser);
        }
        return new C0536d(new C0549a(string, string2, string3, m2124a(resources, resourceId)), integer, integer2);
    }

    /* renamed from: d */
    private static C0535c m2129d(XmlPullParser xmlPullParser, Resources resources) {
        TypedArray obtainAttributes = resources.obtainAttributes(Xml.asAttributeSet(xmlPullParser), C0481a.C0485d.FontFamilyFont);
        int i = obtainAttributes.getInt(obtainAttributes.hasValue(C0481a.C0485d.FontFamilyFont_fontWeight) ? C0481a.C0485d.FontFamilyFont_fontWeight : C0481a.C0485d.FontFamilyFont_android_fontWeight, 400);
        boolean z = 1 == obtainAttributes.getInt(obtainAttributes.hasValue(C0481a.C0485d.FontFamilyFont_fontStyle) ? C0481a.C0485d.FontFamilyFont_fontStyle : C0481a.C0485d.FontFamilyFont_android_fontStyle, 0);
        int i2 = obtainAttributes.hasValue(C0481a.C0485d.FontFamilyFont_ttcIndex) ? C0481a.C0485d.FontFamilyFont_ttcIndex : C0481a.C0485d.FontFamilyFont_android_ttcIndex;
        String string = obtainAttributes.getString(obtainAttributes.hasValue(C0481a.C0485d.FontFamilyFont_fontVariationSettings) ? C0481a.C0485d.FontFamilyFont_fontVariationSettings : C0481a.C0485d.FontFamilyFont_android_fontVariationSettings);
        int i3 = obtainAttributes.getInt(i2, 0);
        int i4 = obtainAttributes.hasValue(C0481a.C0485d.FontFamilyFont_font) ? C0481a.C0485d.FontFamilyFont_font : C0481a.C0485d.FontFamilyFont_android_font;
        int resourceId = obtainAttributes.getResourceId(i4, 0);
        String string2 = obtainAttributes.getString(i4);
        obtainAttributes.recycle();
        while (xmlPullParser.next() != 3) {
            m2126a(xmlPullParser);
        }
        return new C0535c(string2, i, z, string, i3, resourceId);
    }
}
