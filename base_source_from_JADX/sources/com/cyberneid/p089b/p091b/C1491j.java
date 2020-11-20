package com.cyberneid.p089b.p091b;

import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

/* renamed from: com.cyberneid.b.b.j */
public final class C1491j {

    /* renamed from: c */
    private static Map<C1492a, C1491j> f4449c = new LinkedHashMap();

    /* renamed from: d */
    private static Map<String, C1491j> f4450d = new LinkedHashMap();

    /* renamed from: a */
    private C1492a f4451a = null;

    /* renamed from: b */
    private String f4452b = null;

    /* renamed from: com.cyberneid.b.b.j$a */
    public static class C1492a {

        /* renamed from: a */
        private int[] f4453a;

        public C1492a(int i) {
            this(new int[]{i});
        }

        public C1492a(int i, int i2) {
            this(new int[]{i, i2});
        }

        private C1492a(int[] iArr) {
            this.f4453a = null;
            m5689a(iArr);
        }

        /* renamed from: a */
        private void m5689a(int[] iArr) {
            this.f4453a = iArr;
        }

        /* renamed from: a */
        public int[] mo7075a() {
            return this.f4453a;
        }

        public boolean equals(Object obj) {
            if (obj instanceof C1492a) {
                return Arrays.equals(mo7075a(), ((C1492a) obj).mo7075a());
            }
            return false;
        }

        public int hashCode() {
            return Arrays.hashCode(mo7075a());
        }

        public String toString() {
            return Arrays.toString(mo7075a());
        }
    }

    static {
        m5684a(new C1492a(0), "version");
        m5684a(new C1492a(1), "Notice");
        m5684a(new C1492a(12, 0), "Copyright");
        m5684a(new C1492a(2), "FullName");
        m5684a(new C1492a(3), "FamilyName");
        m5684a(new C1492a(4), "Weight");
        m5684a(new C1492a(12, 1), "isFixedPitch");
        m5684a(new C1492a(12, 2), "ItalicAngle");
        m5684a(new C1492a(12, 3), "UnderlinePosition");
        m5684a(new C1492a(12, 4), "UnderlineThickness");
        m5684a(new C1492a(12, 5), "PaintType");
        m5684a(new C1492a(12, 6), "CharstringType");
        m5684a(new C1492a(12, 7), "FontMatrix");
        m5684a(new C1492a(13), "UniqueID");
        m5684a(new C1492a(5), "FontBBox");
        m5684a(new C1492a(12, 8), "StrokeWidth");
        m5684a(new C1492a(14), "XUID");
        m5684a(new C1492a(15), "charset");
        m5684a(new C1492a(16), "Encoding");
        m5684a(new C1492a(17), "CharStrings");
        m5684a(new C1492a(18), "Private");
        m5684a(new C1492a(12, 20), "SyntheticBase");
        m5684a(new C1492a(12, 21), "PostScript");
        m5684a(new C1492a(12, 22), "BaseFontName");
        m5684a(new C1492a(12, 23), "BaseFontBlend");
        m5684a(new C1492a(12, 30), "ROS");
        m5684a(new C1492a(12, 31), "CIDFontVersion");
        m5684a(new C1492a(12, 32), "CIDFontRevision");
        m5684a(new C1492a(12, 33), "CIDFontType");
        m5684a(new C1492a(12, 34), "CIDCount");
        m5684a(new C1492a(12, 35), "UIDBase");
        m5684a(new C1492a(12, 36), "FDArray");
        m5684a(new C1492a(12, 37), "FDSelect");
        m5684a(new C1492a(12, 38), "FontName");
        m5684a(new C1492a(6), "BlueValues");
        m5684a(new C1492a(7), "OtherBlues");
        m5684a(new C1492a(8), "FamilyBlues");
        m5684a(new C1492a(9), "FamilyOtherBlues");
        m5684a(new C1492a(12, 9), "BlueScale");
        m5684a(new C1492a(12, 10), "BlueShift");
        m5684a(new C1492a(12, 11), "BlueFuzz");
        m5684a(new C1492a(10), "StdHW");
        m5684a(new C1492a(11), "StdVW");
        m5684a(new C1492a(12, 12), "StemSnapH");
        m5684a(new C1492a(12, 13), "StemSnapV");
        m5684a(new C1492a(12, 14), "ForceBold");
        m5684a(new C1492a(12, 15), "LanguageGroup");
        m5684a(new C1492a(12, 16), "ExpansionFactor");
        m5684a(new C1492a(12, 17), "initialRandomSeed");
        m5684a(new C1492a(19), "Subrs");
        m5684a(new C1492a(20), "defaultWidthX");
        m5684a(new C1492a(21), "nominalWidthX");
    }

    private C1491j(C1492a aVar, String str) {
        m5685b(aVar);
        m5686b(str);
    }

    /* renamed from: a */
    public static C1491j m5682a(C1492a aVar) {
        return f4449c.get(aVar);
    }

    /* renamed from: a */
    public static C1491j m5683a(String str) {
        return f4450d.get(str);
    }

    /* renamed from: a */
    private static void m5684a(C1492a aVar, String str) {
        C1491j jVar = new C1491j(aVar, str);
        f4449c.put(aVar, jVar);
        f4450d.put(str, jVar);
    }

    /* renamed from: b */
    private void m5685b(C1492a aVar) {
        this.f4451a = aVar;
    }

    /* renamed from: b */
    private void m5686b(String str) {
        this.f4452b = str;
    }

    /* renamed from: a */
    public C1492a mo7070a() {
        return this.f4451a;
    }

    /* renamed from: b */
    public String mo7071b() {
        return this.f4452b;
    }

    public boolean equals(Object obj) {
        if (obj instanceof C1491j) {
            return mo7070a().equals(((C1491j) obj).mo7070a());
        }
        return false;
    }

    public int hashCode() {
        return mo7070a().hashCode();
    }

    public String toString() {
        return mo7071b();
    }
}
