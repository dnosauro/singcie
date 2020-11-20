package com.cyberneid.p105d.p114g.p120d;

import com.cyberneid.p089b.p090a.C1471a;
import com.cyberneid.p089b.p090a.C1475e;
import com.cyberneid.p105d.p131h.C1941e;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cyberneid.d.g.d.ac */
final class C1798ac {

    /* renamed from: a */
    private static final Set<String> f5811a = new HashSet();

    /* renamed from: b */
    private static final Map<String, String> f5812b = new HashMap();

    /* renamed from: c */
    private static final Map<String, C1475e> f5813c;

    static {
        try {
            f5813c = new HashMap();
            m7282d("Courier-Bold");
            m7282d("Courier-BoldOblique");
            m7282d("Courier");
            m7282d("Courier-Oblique");
            m7282d("Helvetica");
            m7282d("Helvetica-Bold");
            m7282d("Helvetica-BoldOblique");
            m7282d("Helvetica-Oblique");
            m7282d("Symbol");
            m7282d("Times-Bold");
            m7282d("Times-BoldItalic");
            m7282d("Times-Italic");
            m7282d("Times-Roman");
            m7282d("ZapfDingbats");
            m7279a("CourierCourierNew", "Courier");
            m7279a("CourierNew", "Courier");
            m7279a("CourierNew,Italic", "Courier-Oblique");
            m7279a("CourierNew,Bold", "Courier-Bold");
            m7279a("CourierNew,BoldItalic", "Courier-BoldOblique");
            m7279a("Arial", "Helvetica");
            m7279a("Arial,Italic", "Helvetica-Oblique");
            m7279a("Arial,Bold", "Helvetica-Bold");
            m7279a("Arial,BoldItalic", "Helvetica-BoldOblique");
            m7279a("TimesNewRoman", "Times-Roman");
            m7279a("TimesNewRoman,Italic", "Times-Italic");
            m7279a("TimesNewRoman,Bold", "Times-Bold");
            m7279a("TimesNewRoman,BoldItalic", "Times-BoldItalic");
            m7279a("Symbol,Italic", "Symbol");
            m7279a("Symbol,Bold", "Symbol");
            m7279a("Symbol,BoldItalic", "Symbol");
            m7279a("Times", "Times-Roman");
            m7279a("Times,Italic", "Times-Italic");
            m7279a("Times,Bold", "Times-Bold");
            m7279a("Times,BoldItalic", "Times-BoldItalic");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public static C1475e m7277a(String str) {
        return f5813c.get(str);
    }

    /* renamed from: a */
    public static Set<String> m7278a() {
        return Collections.unmodifiableSet(f5811a);
    }

    /* renamed from: a */
    private static void m7279a(String str, String str2) {
        InputStream inputStream;
        f5811a.add(str);
        f5812b.put(str, str2);
        if (f5813c.containsKey(str2)) {
            Map<String, C1475e> map = f5813c;
            map.put(str, map.get(str2));
        }
        String str3 = "com/cyberneid/pdfbox/resources/afm/" + str2 + ".afm";
        if (C1941e.m7995a()) {
            inputStream = C1941e.m7993a(str3);
        } else {
            URL resource = C1830z.class.getClassLoader().getResource(str3);
            if (resource != null) {
                inputStream = resource.openStream();
            } else {
                throw new IOException(str3 + " not found");
            }
        }
        try {
            f5813c.put(str, new C1471a(inputStream).mo6953a());
        } finally {
            inputStream.close();
        }
    }

    /* renamed from: b */
    public static boolean m7280b(String str) {
        return f5811a.contains(str);
    }

    /* renamed from: c */
    public static String m7281c(String str) {
        return f5812b.get(str);
    }

    /* renamed from: d */
    private static void m7282d(String str) {
        m7279a(str, str);
    }
}
