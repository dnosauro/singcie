package com.cyberneid.p089b.p090a;

import com.cyberneid.p089b.p097h.C1586a;
import java.io.IOException;
import java.io.InputStream;
import java.util.StringTokenizer;
import org.spongycastle.i18n.LocalizedMessage;

/* renamed from: com.cyberneid.b.a.a */
public class C1471a {

    /* renamed from: a */
    private final InputStream f4358a;

    public C1471a(InputStream inputStream) {
        this.f4358a = inputStream;
    }

    /* renamed from: a */
    private String m5539a(String str) {
        if (str.length() >= 2) {
            int i = 0;
            if (str.charAt(0) == '<' && str.charAt(str.length() - 1) == '>') {
                String substring = str.substring(1, str.length() - 1);
                byte[] bArr = new byte[(substring.length() / 2)];
                while (i < substring.length()) {
                    try {
                        bArr[i / 2] = (byte) Integer.parseInt("" + substring.charAt(i) + substring.charAt(i + 1), 16);
                        i += 2;
                    } catch (NumberFormatException e) {
                        throw new IOException("Error parsing AFM file:" + e);
                    }
                }
                return new String(bArr, LocalizedMessage.DEFAULT_ENCODING);
            }
            throw new IOException("String should be enclosed by angle brackets '" + str + "'");
        }
        throw new IOException("Error: Expected hex string of length >= 2 not='" + str);
    }

    /* renamed from: a */
    private void m5540a(C1475e eVar) {
        while (true) {
            String j = m5552j();
            if (!j.equals("EndKernData")) {
                int i = 0;
                if ("StartTrackKern".equals(j)) {
                    int g = m5549g();
                    while (i < g) {
                        C1478h hVar = new C1478h();
                        hVar.mo7028a(m5549g());
                        hVar.mo7031d(m5550h());
                        hVar.mo7030c(m5550h());
                        hVar.mo7029b(m5550h());
                        hVar.mo7027a(m5550h());
                        eVar.mo6981a(hVar);
                        i++;
                    }
                    String j2 = m5552j();
                    if (!j2.equals("EndTrackKern")) {
                        throw new IOException("Error: Expected 'EndTrackKern' actual '" + j2 + "'");
                    }
                } else if ("StartKernPairs".equals(j)) {
                    int g2 = m5549g();
                    while (i < g2) {
                        eVar.mo6980a(m5545c());
                        i++;
                    }
                    String j3 = m5552j();
                    if (!j3.equals("EndKernPairs")) {
                        throw new IOException("Error: Expected 'EndKernPairs' actual '" + j3 + "'");
                    }
                } else if ("StartKernPairs0".equals(j)) {
                    int g3 = m5549g();
                    while (i < g3) {
                        eVar.mo6988b(m5545c());
                        i++;
                    }
                    String j4 = m5552j();
                    if (!j4.equals("EndKernPairs")) {
                        throw new IOException("Error: Expected 'EndKernPairs' actual '" + j4 + "'");
                    }
                } else if ("StartKernPairs1".equals(j)) {
                    int g4 = m5549g();
                    while (i < g4) {
                        eVar.mo6995c(m5545c());
                        i++;
                    }
                    String j5 = m5552j();
                    if (!j5.equals("EndKernPairs")) {
                        throw new IOException("Error: Expected 'EndKernPairs' actual '" + j5 + "'");
                    }
                } else {
                    throw new IOException("Unknown kerning data type '" + j + "'");
                }
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m5541a(StringTokenizer stringTokenizer) {
        if (stringTokenizer.hasMoreTokens()) {
            String nextToken = stringTokenizer.nextToken();
            if (!nextToken.equals(";")) {
                throw new IOException("Error: Expected semicolon in stream actual='" + nextToken + "'");
            }
            return;
        }
        throw new IOException("CharMetrics is missing a semicolon after a command");
    }

    /* renamed from: a */
    private boolean m5542a(int i) {
        return i == 13 || i == 10;
    }

    /* renamed from: b */
    private C1475e m5543b() {
        C1475e eVar = new C1475e();
        String j = m5552j();
        if ("StartFontMetrics".equals(j)) {
            eVar.mo6976a(m5550h());
            while (true) {
                String j2 = m5552j();
                if ("EndFontMetrics".equals(j2)) {
                    return eVar;
                }
                if ("FontName".equals(j2)) {
                    eVar.mo6996c(m5551i());
                } else if ("FullName".equals(j2)) {
                    eVar.mo7000d(m5551i());
                } else if ("FamilyName".equals(j2)) {
                    eVar.mo7003e(m5551i());
                } else if ("Weight".equals(j2)) {
                    eVar.mo7006f(m5551i());
                } else if ("FontBBox".equals(j2)) {
                    C1586a aVar = new C1586a();
                    aVar.mo7389a(m5550h());
                    aVar.mo7391b(m5550h());
                    aVar.mo7393c(m5550h());
                    aVar.mo7395d(m5550h());
                    eVar.mo6982a(aVar);
                } else if ("Version".equals(j2)) {
                    eVar.mo7018j(m5551i());
                } else if ("Notice".equals(j2)) {
                    eVar.mo7009g(m5551i());
                } else if ("EncodingScheme".equals(j2)) {
                    eVar.mo7012h(m5551i());
                } else if ("MappingScheme".equals(j2)) {
                    eVar.mo6977a(m5549g());
                } else if ("EscChar".equals(j2)) {
                    eVar.mo6987b(m5549g());
                } else if ("CharacterSet".equals(j2)) {
                    eVar.mo7015i(m5551i());
                } else if ("Characters".equals(j2)) {
                    eVar.mo6994c(m5549g());
                } else if ("IsBaseFont".equals(j2)) {
                    eVar.mo6983a(m5548f());
                } else {
                    int i = 0;
                    if ("VVector".equals(j2)) {
                        eVar.mo6984a(new float[]{m5550h(), m5550h()});
                    } else if ("IsFixedV".equals(j2)) {
                        eVar.mo6990b(m5548f());
                    } else if ("CapHeight".equals(j2)) {
                        eVar.mo6986b(m5550h());
                    } else if ("XHeight".equals(j2)) {
                        eVar.mo6993c(m5550h());
                    } else if ("Ascender".equals(j2)) {
                        eVar.mo6999d(m5550h());
                    } else if ("Descender".equals(j2)) {
                        eVar.mo7002e(m5550h());
                    } else if ("StdHW".equals(j2)) {
                        eVar.mo7014i(m5550h());
                    } else if ("StdVW".equals(j2)) {
                        eVar.mo7017j(m5550h());
                    } else if ("Comment".equals(j2)) {
                        eVar.mo6989b(m5551i());
                    } else if ("UnderlinePosition".equals(j2)) {
                        eVar.mo7005f(m5550h());
                    } else if ("UnderlineThickness".equals(j2)) {
                        eVar.mo7008g(m5550h());
                    } else if ("ItalicAngle".equals(j2)) {
                        eVar.mo7011h(m5550h());
                    } else if ("CharWidth".equals(j2)) {
                        eVar.mo6991b(new float[]{m5550h(), m5550h()});
                    } else if ("IsFixedPitch".equals(j2)) {
                        eVar.mo6997c(m5548f());
                    } else if ("StartCharMetrics".equals(j2)) {
                        int g = m5549g();
                        while (i < g) {
                            eVar.mo6978a(m5547e());
                            i++;
                        }
                        String j3 = m5552j();
                        if (!j3.equals("EndCharMetrics")) {
                            throw new IOException("Error: Expected 'EndCharMetrics' actual '" + j3 + "'");
                        }
                    } else if ("StartComposites".equals(j2)) {
                        int g2 = m5549g();
                        while (i < g2) {
                            eVar.mo6979a(m5546d());
                            i++;
                        }
                        String j4 = m5552j();
                        if (!j4.equals("EndComposites")) {
                            throw new IOException("Error: Expected 'EndComposites' actual '" + j4 + "'");
                        }
                    } else if ("StartKernData".equals(j2)) {
                        m5540a(eVar);
                    } else {
                        throw new IOException("Unknown AFM key '" + j2 + "'");
                    }
                }
            }
        } else {
            throw new IOException("Error: The AFM file should start with StartFontMetrics and not '" + j + "'");
        }
    }

    /* renamed from: b */
    private boolean m5544b(int i) {
        return i == 32 || i == 9 || i == 13 || i == 10;
    }

    /* renamed from: c */
    private C1476f m5545c() {
        float f;
        String j;
        String j2;
        C1476f fVar = new C1476f();
        String j3 = m5552j();
        if ("KP".equals(j3)) {
            j = m5552j();
            j2 = m5552j();
        } else if ("KPH".equals(j3)) {
            j = m5539a(m5552j());
            j2 = m5539a(m5552j());
        } else {
            f = 0.0f;
            if ("KPX".equals(j3)) {
                String j4 = m5552j();
                String j5 = m5552j();
                float h = m5550h();
                fVar.mo7022a(j4);
                fVar.mo7024b(j5);
                fVar.mo7021a(h);
                fVar.mo7023b(0.0f);
                return fVar;
            } else if ("KPY".equals(j3)) {
                j = m5552j();
                j2 = m5552j();
                float h2 = m5550h();
                fVar.mo7022a(j);
                fVar.mo7024b(j2);
                fVar.mo7021a(f);
                fVar.mo7023b(h2);
                return fVar;
            } else {
                throw new IOException("Error expected kern pair command actual='" + j3 + "'");
            }
        }
        f = m5550h();
        float h22 = m5550h();
        fVar.mo7022a(j);
        fVar.mo7024b(j2);
        fVar.mo7021a(f);
        fVar.mo7023b(h22);
        return fVar;
    }

    /* renamed from: d */
    private C1473c m5546d() {
        C1473c cVar = new C1473c();
        StringTokenizer stringTokenizer = new StringTokenizer(m5551i(), " ;");
        String nextToken = stringTokenizer.nextToken();
        if (nextToken.equals("CC")) {
            cVar.mo6970a(stringTokenizer.nextToken());
            try {
                int parseInt = Integer.parseInt(stringTokenizer.nextToken());
                int i = 0;
                while (i < parseInt) {
                    C1474d dVar = new C1474d();
                    String nextToken2 = stringTokenizer.nextToken();
                    if (nextToken2.equals("PCC")) {
                        String nextToken3 = stringTokenizer.nextToken();
                        try {
                            int parseInt2 = Integer.parseInt(stringTokenizer.nextToken());
                            int parseInt3 = Integer.parseInt(stringTokenizer.nextToken());
                            dVar.mo6972a(nextToken3);
                            dVar.mo6971a(parseInt2);
                            dVar.mo6973b(parseInt3);
                            cVar.mo6969a(dVar);
                            i++;
                        } catch (NumberFormatException e) {
                            throw new IOException("Error parsing AFM document:" + e);
                        }
                    } else {
                        throw new IOException("Expected 'PCC' actual='" + nextToken2 + "'");
                    }
                }
                return cVar;
            } catch (NumberFormatException e2) {
                throw new IOException("Error parsing AFM document:" + e2);
            }
        } else {
            throw new IOException("Expected 'CC' actual='" + nextToken + "'");
        }
    }

    /* renamed from: e */
    private C1472b m5547e() {
        C1472b bVar = new C1472b();
        StringTokenizer stringTokenizer = new StringTokenizer(m5551i());
        while (stringTokenizer.hasMoreTokens()) {
            try {
                String nextToken = stringTokenizer.nextToken();
                if (nextToken.equals("C")) {
                    bVar.mo6956a(Integer.parseInt(stringTokenizer.nextToken()));
                } else if (nextToken.equals("CH")) {
                    bVar.mo6956a(Integer.parseInt(stringTokenizer.nextToken(), 16));
                } else if (nextToken.equals("WX")) {
                    bVar.mo6965c(Float.parseFloat(stringTokenizer.nextToken()));
                } else if (nextToken.equals("W0X")) {
                    bVar.mo6955a(Float.parseFloat(stringTokenizer.nextToken()));
                } else if (nextToken.equals("W1X")) {
                    bVar.mo6955a(Float.parseFloat(stringTokenizer.nextToken()));
                } else if (nextToken.equals("WY")) {
                    bVar.mo6967d(Float.parseFloat(stringTokenizer.nextToken()));
                } else if (nextToken.equals("W0Y")) {
                    bVar.mo6962b(Float.parseFloat(stringTokenizer.nextToken()));
                } else if (nextToken.equals("W1Y")) {
                    bVar.mo6962b(Float.parseFloat(stringTokenizer.nextToken()));
                } else if (nextToken.equals("W")) {
                    bVar.mo6963b(new float[]{Float.parseFloat(stringTokenizer.nextToken()), Float.parseFloat(stringTokenizer.nextToken())});
                } else if (nextToken.equals("W0")) {
                    bVar.mo6966c(new float[]{Float.parseFloat(stringTokenizer.nextToken()), Float.parseFloat(stringTokenizer.nextToken())});
                } else if (nextToken.equals("W1")) {
                    bVar.mo6968d(new float[]{Float.parseFloat(stringTokenizer.nextToken()), Float.parseFloat(stringTokenizer.nextToken())});
                } else if (nextToken.equals("VV")) {
                    bVar.mo6960a(new float[]{Float.parseFloat(stringTokenizer.nextToken()), Float.parseFloat(stringTokenizer.nextToken())});
                } else if (nextToken.equals("N")) {
                    bVar.mo6959a(stringTokenizer.nextToken());
                } else if (nextToken.equals("B")) {
                    String nextToken2 = stringTokenizer.nextToken();
                    String nextToken3 = stringTokenizer.nextToken();
                    String nextToken4 = stringTokenizer.nextToken();
                    String nextToken5 = stringTokenizer.nextToken();
                    C1586a aVar = new C1586a();
                    aVar.mo7389a(Float.parseFloat(nextToken2));
                    aVar.mo7391b(Float.parseFloat(nextToken3));
                    aVar.mo7393c(Float.parseFloat(nextToken4));
                    aVar.mo7395d(Float.parseFloat(nextToken5));
                    bVar.mo6958a(aVar);
                } else if (nextToken.equals("L")) {
                    String nextToken6 = stringTokenizer.nextToken();
                    String nextToken7 = stringTokenizer.nextToken();
                    C1477g gVar = new C1477g();
                    gVar.mo7026b(nextToken6);
                    gVar.mo7025a(nextToken7);
                    bVar.mo6957a(gVar);
                } else {
                    throw new IOException("Unknown CharMetrics command '" + nextToken + "'");
                }
                m5541a(stringTokenizer);
            } catch (NumberFormatException e) {
                throw new IOException("Error: Corrupt AFM document:" + e);
            }
        }
        return bVar;
    }

    /* renamed from: f */
    private boolean m5548f() {
        return Boolean.valueOf(m5552j()).booleanValue();
    }

    /* renamed from: g */
    private int m5549g() {
        try {
            return Integer.parseInt(m5552j());
        } catch (NumberFormatException e) {
            throw new IOException("Error parsing AFM document:" + e);
        }
    }

    /* renamed from: h */
    private float m5550h() {
        return Float.parseFloat(m5552j());
    }

    /* renamed from: i */
    private String m5551i() {
        int read;
        StringBuilder sb = new StringBuilder();
        do {
            read = this.f4358a.read();
        } while (m5544b(read));
        do {
            sb.append((char) read);
            read = this.f4358a.read();
        } while (!m5542a(read));
        return sb.toString();
    }

    /* renamed from: j */
    private String m5552j() {
        int read;
        StringBuilder sb = new StringBuilder();
        do {
            read = this.f4358a.read();
        } while (m5544b(read));
        do {
            sb.append((char) read);
            read = this.f4358a.read();
        } while (!m5544b(read));
        return sb.toString();
    }

    /* renamed from: a */
    public C1475e mo6953a() {
        return m5543b();
    }
}
