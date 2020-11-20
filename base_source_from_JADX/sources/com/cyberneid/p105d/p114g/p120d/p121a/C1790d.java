package com.cyberneid.p105d.p114g.p120d.p121a;

import android.util.Log;
import com.cyberneid.p105d.p131h.C1941e;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.d.g.d.a.d */
public final class C1790d {

    /* renamed from: a */
    private static final C1790d f5801a = m7255b("glyphlist.txt");

    /* renamed from: b */
    private static final C1790d f5802b = m7255b("zapfdingbats.txt");

    /* renamed from: c */
    private final Map<String, String> f5803c = new HashMap();

    /* renamed from: d */
    private final Map<String, String> f5804d = new HashMap();

    /* renamed from: e */
    private final Map<String, String> f5805e = new HashMap();

    static {
        try {
            if (System.getProperty("glyphlist_ext") != null) {
                throw new UnsupportedOperationException("glyphlist_ext is no longer supported, use GlyphList.DEFAULT.addGlyphs(Properties) instead");
            }
        } catch (SecurityException unused) {
        }
    }

    public C1790d(InputStream inputStream) {
        m7253a(inputStream);
    }

    /* renamed from: a */
    public static C1790d m7252a() {
        return f5801a;
    }

    /* renamed from: a */
    private void m7253a(InputStream inputStream) {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, LocalizedMessage.DEFAULT_ENCODING));
        while (true) {
            try {
                String readLine = bufferedReader.readLine();
                if (readLine == null) {
                    return;
                }
                if (!readLine.startsWith("#")) {
                    String[] split = readLine.split(";");
                    if (split.length >= 2) {
                        String str = split[0];
                        String[] split2 = split[1].split(" ");
                        if (this.f5803c.containsKey(str)) {
                            Log.w("PdfBox-Android", "duplicate value for " + str + " -> " + split[1] + " " + this.f5803c.get(str));
                        }
                        int[] iArr = new int[split2.length];
                        int length = split2.length;
                        int i = 0;
                        int i2 = 0;
                        while (i < length) {
                            iArr[i2] = Integer.parseInt(split2[i], 16);
                            i++;
                            i2++;
                        }
                        String str2 = new String(iArr, 0, iArr.length);
                        this.f5803c.put(str, str2);
                        if (!this.f5804d.containsKey(str2)) {
                            this.f5804d.put(str2, str);
                        }
                    } else {
                        throw new IOException("Invalid glyph list entry: " + readLine);
                    }
                }
            } finally {
                bufferedReader.close();
            }
        }
    }

    /* renamed from: b */
    public static C1790d m7254b() {
        return f5802b;
    }

    /* renamed from: b */
    private static C1790d m7255b(String str) {
        try {
            if (C1941e.m7995a()) {
                return new C1790d(C1941e.m7993a("com/cyberneid/pdfbox/resources/glyphlist/" + str));
            }
            ClassLoader classLoader = C1790d.class.getClassLoader();
            return new C1790d(classLoader.getResourceAsStream("com/cyberneid/pdfbox/resources/glyphlist/" + str));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /* renamed from: a */
    public String mo8092a(int i) {
        String str = this.f5804d.get(new String(new int[]{i}, 0, 1));
        return str == null ? ".notdef" : str;
    }

    /* renamed from: a */
    public String mo8093a(String str) {
        String str2;
        StringBuilder sb;
        if (str == null) {
            return null;
        }
        String str3 = this.f5803c.get(str);
        if (str3 != null) {
            return str3;
        }
        String str4 = this.f5805e.get(str);
        if (str4 == null) {
            if (str.indexOf(46) > 0) {
                str4 = mo8093a(str.substring(0, str.indexOf(46)));
            } else if (str.startsWith("uni") && str.length() == 7) {
                int length = str.length();
                StringBuilder sb2 = new StringBuilder();
                int i = 3;
                while (true) {
                    int i2 = i + 4;
                    if (i2 > length) {
                        break;
                    }
                    try {
                        int parseInt = Integer.parseInt(str.substring(i, i2), 16);
                        if (parseInt <= 55295 || parseInt >= 57344) {
                            sb2.append((char) parseInt);
                        } else {
                            Log.w("PdfBox-Android", "Unicode character name with disallowed code area: " + str);
                        }
                        i = i2;
                    } catch (NumberFormatException unused) {
                        str2 = "PdfBox-Android";
                        sb = new StringBuilder();
                        sb.append("Not a number in Unicode character name: ");
                        sb.append(str);
                        Log.w(str2, sb.toString());
                        this.f5805e.put(str, str4);
                        return str4;
                    }
                }
                str4 = sb2.toString();
            } else if (str.startsWith("u") && str.length() == 5) {
                try {
                    int parseInt2 = Integer.parseInt(str.substring(1), 16);
                    if (parseInt2 <= 55295 || parseInt2 >= 57344) {
                        str4 = String.valueOf((char) parseInt2);
                    } else {
                        Log.w("PdfBox-Android", "Unicode character name with disallowed code area: " + str);
                    }
                } catch (NumberFormatException unused2) {
                    str2 = "PdfBox-Android";
                    sb = new StringBuilder();
                    sb.append("Not a number in Unicode character name: ");
                    sb.append(str);
                    Log.w(str2, sb.toString());
                    this.f5805e.put(str, str4);
                    return str4;
                }
            }
            this.f5805e.put(str, str4);
        }
        return str4;
    }
}
