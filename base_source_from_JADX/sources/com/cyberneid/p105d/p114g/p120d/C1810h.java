package com.cyberneid.p105d.p114g.p120d;

import android.support.p002v4.media.session.PlaybackStateCompat;
import com.cyberneid.p089b.C1479b;
import com.cyberneid.p089b.p091b.C1489h;
import com.cyberneid.p089b.p091b.C1515n;
import com.cyberneid.p089b.p095f.C1544ab;
import com.cyberneid.p089b.p095f.C1571s;
import com.cyberneid.p089b.p095f.C1576x;
import com.cyberneid.p089b.p096g.C1583d;
import com.cyberneid.p105d.p131h.C1941e;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cyberneid.d.g.d.h */
final class C1810h {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final C1807e f5844a = new C1807e();

    /* renamed from: b */
    private static C1814j f5845b;

    /* renamed from: c */
    private static Map<String, C1809g> f5846c;

    /* renamed from: d */
    private static final C1544ab f5847d;

    /* renamed from: e */
    private static final Map<String, List<String>> f5848e = new HashMap();

    /* renamed from: com.cyberneid.d.g.d.h$a */
    private static class C1811a {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public static final C1814j f5849a = new C1803d(C1810h.f5844a);
    }

    /* renamed from: com.cyberneid.d.g.d.h$b */
    private static class C1812b implements Comparable<C1812b> {

        /* renamed from: a */
        double f5850a;

        /* renamed from: b */
        final C1809g f5851b;

        C1812b(C1809g gVar) {
            this.f5851b = gVar;
        }

        /* renamed from: a */
        public int compareTo(C1812b bVar) {
            return Double.compare(bVar.f5850a, this.f5850a);
        }
    }

    static {
        InputStream inputStream;
        try {
            if (C1941e.m7995a()) {
                inputStream = C1941e.m7993a("com/cyberneid/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
                if (inputStream == null) {
                    throw new IOException("Error loading resource: " + inputStream);
                }
            } else {
                URL resource = C1810h.class.getClassLoader().getResource("com/cyberneid/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
                if (resource != null) {
                    inputStream = resource.openStream();
                } else {
                    throw new IOException("Error loading resource: " + "com/cyberneid/pdfbox/resources/ttf/LiberationSans-Regular.ttf");
                }
            }
            f5847d = new C1576x().mo7333b(inputStream);
            f5848e.put("Courier", Arrays.asList(new String[]{"CourierNew", "CourierNewPSMT", "LiberationMono", "NimbusMonL-Regu", "DroidSansMono"}));
            f5848e.put("Courier-Bold", Arrays.asList(new String[]{"CourierNewPS-BoldMT", "CourierNew-Bold", "LiberationMono-Bold", "NimbusMonL-Bold", "DroidSansMono"}));
            f5848e.put("Courier-Oblique", Arrays.asList(new String[]{"CourierNewPS-ItalicMT", "CourierNew-Italic", "LiberationMono-Italic", "NimbusMonL-ReguObli", "DroidSansMono"}));
            f5848e.put("Courier-BoldOblique", Arrays.asList(new String[]{"CourierNewPS-BoldItalicMT", "CourierNew-BoldItalic", "LiberationMono-BoldItalic", "NimbusMonL-BoldObli", "DroidSansMono"}));
            f5848e.put("Helvetica", Arrays.asList(new String[]{"ArialMT", "Arial", "LiberationSans", "NimbusSanL-Regu", "Roboto-Regular"}));
            f5848e.put("Helvetica-Bold", Arrays.asList(new String[]{"Arial-BoldMT", "Arial-Bold", "LiberationSans-Bold", "NimbusSanL-Bold", "Roboto-Bold"}));
            f5848e.put("Helvetica-Oblique", Arrays.asList(new String[]{"Arial-ItalicMT", "Arial-Italic", "Helvetica-Italic", "LiberationSans-Italic", "NimbusSanL-ReguItal", "Roboto-Italic"}));
            f5848e.put("Helvetica-BoldOblique", Arrays.asList(new String[]{"Arial-BoldItalicMT", "Helvetica-BoldItalic", "LiberationSans-BoldItalic", "NimbusSanL-BoldItal", "Roboto-BoldItalic"}));
            f5848e.put("Times-Roman", Arrays.asList(new String[]{"TimesNewRomanPSMT", "TimesNewRoman", "TimesNewRomanPS", "LiberationSerif", "NimbusRomNo9L-Regu", "DroidSerif-Regular", "Roboto-Regular"}));
            f5848e.put("Times-Bold", Arrays.asList(new String[]{"TimesNewRomanPS-BoldMT", "TimesNewRomanPS-Bold", "TimesNewRoman-Bold", "LiberationSerif-Bold", "NimbusRomNo9L-Medi", "DroidSerif-Bold", "Roboto-Bold"}));
            f5848e.put("Times-Italic", Arrays.asList(new String[]{"TimesNewRomanPS-ItalicMT", "TimesNewRomanPS-Italic", "TimesNewRoman-Italic", "LiberationSerif-Italic", "NimbusRomNo9L-ReguItal", "DroidSerif-Italic", "Roboto-Italic"}));
            f5848e.put("Times-BoldItalic", Arrays.asList(new String[]{"TimesNewRomanPS-BoldItalicMT", "TimesNewRomanPS-BoldItalic", "TimesNewRoman-BoldItalic", "LiberationSerif-BoldItalic", "NimbusRomNo9L-MediItal", "DroidSerif-BoldItalic", "Roboto-BoldItalic"}));
            f5848e.put("Symbol", Arrays.asList(new String[]{"Symbol", "SymbolMT", "StandardSymL"}));
            f5848e.put("ZapfDingbats", Arrays.asList(new String[]{"ZapfDingbatsITC", "Dingbats", "MS-Gothic"}));
            for (String next : C1798ac.m7278a()) {
                if (!f5848e.containsKey(next)) {
                    f5848e.put(next, m7358b(C1798ac.m7281c(next)));
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private C1810h() {
    }

    /* renamed from: a */
    private static C1479b m7345a(C1808f fVar, String str) {
        if (str == null) {
            return null;
        }
        if (f5845b == null) {
            m7348a();
        }
        C1809g b = m7356b(fVar, str);
        if (b != null) {
            return b.mo8123d();
        }
        C1809g b2 = m7356b(fVar, str.replaceAll("-", ""));
        if (b2 != null) {
            return b2.mo8123d();
        }
        for (String b3 : m7359c(str)) {
            C1809g b4 = m7356b(fVar, b3);
            if (b4 != null) {
                return b4.mo8123d();
            }
        }
        C1809g b5 = m7356b(fVar, str.replaceAll(",", "-"));
        if (b5 != null) {
            return b5.mo8123d();
        }
        return null;
    }

    /* renamed from: a */
    public static C1786a m7346a(String str, C1821q qVar, C1819o oVar) {
        C1812b poll;
        C1571s sVar = (C1571s) m7345a(C1808f.OTF, str);
        if (sVar != null) {
            return new C1786a(sVar, (C1479b) null, false);
        }
        C1544ab abVar = (C1544ab) m7345a(C1808f.TTF, str);
        if (abVar != null) {
            return new C1786a((C1571s) null, abVar, false);
        }
        if (oVar != null) {
            String str2 = oVar.mo8153a() + "-" + oVar.mo8154b();
            if ((str2.equals("Adobe-GB1") || str2.equals("Adobe-CNS1") || str2.equals("Adobe-Japan1") || str2.equals("Adobe-Korea1")) && (poll = m7351a(qVar, oVar).poll()) != null) {
                C1479b d = poll.f5851b.mo8123d();
                return d instanceof C1571s ? new C1786a((C1571s) d, (C1479b) null, true) : new C1786a((C1571s) null, d, true);
            }
        }
        return new C1786a((C1571s) null, f5847d, true);
    }

    /* renamed from: a */
    public static C1813i<C1544ab> m7347a(String str, C1821q qVar) {
        C1544ab abVar = (C1544ab) m7345a(C1808f.TTF, str);
        if (abVar != null) {
            return new C1813i<>(abVar, false);
        }
        C1544ab abVar2 = (C1544ab) m7345a(C1808f.TTF, m7349a(qVar));
        if (abVar2 == null) {
            abVar2 = f5847d;
        }
        return new C1813i<>(abVar2, true);
    }

    /* renamed from: a */
    public static synchronized C1814j m7348a() {
        C1814j jVar;
        synchronized (C1810h.class) {
            if (f5845b == null) {
                m7353a(C1811a.f5849a);
            }
            jVar = f5845b;
        }
        return jVar;
    }

    /* renamed from: a */
    private static String m7349a(C1821q qVar) {
        String str;
        StringBuilder sb;
        StringBuilder sb2;
        StringBuilder sb3;
        String str2;
        if (qVar == null) {
            return "Times-Roman";
        }
        boolean z = false;
        if (qVar.mo8198g() != null) {
            String lowerCase = qVar.mo8198g().toLowerCase();
            if (lowerCase.contains("bold") || lowerCase.contains("black") || lowerCase.contains("heavy")) {
                z = true;
            }
        }
        if (qVar.mo8180a()) {
            str = "Courier";
            if (z && qVar.mo8194e()) {
                sb3 = new StringBuilder();
            } else if (z) {
                sb2 = new StringBuilder();
                sb3.append(str);
                str2 = "-Bold";
                sb3.append(str2);
                return sb3.toString();
            } else if (!qVar.mo8194e()) {
                return str;
            } else {
                sb = new StringBuilder();
                sb3.append(str);
                str2 = "-Oblique";
                sb3.append(str2);
                return sb3.toString();
            }
        } else {
            if (qVar.mo8185b()) {
                str = "Times";
                if (z && qVar.mo8194e()) {
                    sb3 = new StringBuilder();
                    sb3.append(str);
                    str2 = "-BoldItalic";
                    sb3.append(str2);
                    return sb3.toString();
                } else if (z) {
                    sb2 = new StringBuilder();
                } else {
                    if (qVar.mo8194e()) {
                        sb3 = new StringBuilder();
                        sb3.append(str);
                        str2 = "-Italic";
                    } else {
                        sb3 = new StringBuilder();
                        sb3.append(str);
                        str2 = "-Roman";
                    }
                    sb3.append(str2);
                    return sb3.toString();
                }
            } else {
                str = "Helvetica";
                if (z && qVar.mo8194e()) {
                    sb3 = new StringBuilder();
                } else if (z) {
                    sb2 = new StringBuilder();
                } else if (!qVar.mo8194e()) {
                    return str;
                } else {
                    sb = new StringBuilder();
                    sb3.append(str);
                    str2 = "-Oblique";
                    sb3.append(str2);
                    return sb3.toString();
                }
            }
            sb3.append(str);
            str2 = "-Bold";
            sb3.append(str2);
            return sb3.toString();
        }
        sb3.append(str);
        str2 = "-BoldOblique";
        sb3.append(str2);
        return sb3.toString();
    }

    /* renamed from: a */
    private static Map<String, C1809g> m7350a(List<? extends C1809g> list) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        for (C1809g gVar : list) {
            for (String put : m7352a(gVar.mo8120a())) {
                linkedHashMap.put(put, gVar);
            }
        }
        return linkedHashMap;
    }

    /* JADX WARNING: Removed duplicated region for block: B:41:0x00dd  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x00e4  */
    /* JADX WARNING: Removed duplicated region for block: B:45:0x00ea  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.util.PriorityQueue<com.cyberneid.p105d.p114g.p120d.C1810h.C1812b> m7351a(com.cyberneid.p105d.p114g.p120d.C1821q r16, com.cyberneid.p105d.p114g.p120d.C1819o r17) {
        /*
            r0 = r17
            java.util.PriorityQueue r1 = new java.util.PriorityQueue
            r2 = 20
            r1.<init>(r2)
            java.util.Map<java.lang.String, com.cyberneid.d.g.d.g> r2 = f5846c
            java.util.Collection r2 = r2.values()
            java.util.Iterator r2 = r2.iterator()
        L_0x0013:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x012e
            java.lang.Object r3 = r2.next()
            com.cyberneid.d.g.d.g r3 = (com.cyberneid.p105d.p114g.p120d.C1809g) r3
            if (r0 == 0) goto L_0x0028
            boolean r4 = m7354a((com.cyberneid.p105d.p114g.p120d.C1819o) r0, (com.cyberneid.p105d.p114g.p120d.C1809g) r3)
            if (r4 != 0) goto L_0x0028
            goto L_0x0013
        L_0x0028:
            com.cyberneid.d.g.d.h$b r4 = new com.cyberneid.d.g.d.h$b
            r4.<init>(r3)
            com.cyberneid.d.g.d.t r5 = r16.mo8211r()
            r6 = 4602678819172646912(0x3fe0000000000000, double:0.5)
            r8 = 4607182418800017408(0x3ff0000000000000, double:1.0)
            if (r5 == 0) goto L_0x0100
            com.cyberneid.d.g.d.u r5 = r3.mo8129j()
            if (r5 == 0) goto L_0x0100
            com.cyberneid.d.g.d.t r5 = r16.mo8211r()
            com.cyberneid.d.g.d.u r5 = r5.mo8212a()
            int r10 = r5.mo8213a()
            com.cyberneid.d.g.d.u r11 = r3.mo8129j()
            int r11 = r11.mo8213a()
            if (r10 != r11) goto L_0x0129
            int r10 = r5.mo8214b()
            com.cyberneid.d.g.d.u r11 = r3.mo8129j()
            int r11 = r11.mo8214b()
            r12 = 4611686018427387904(0x4000000000000000, double:2.0)
            r14 = 2
            if (r10 != r11) goto L_0x006a
            double r10 = r4.f5850a
            double r10 = r10 + r12
        L_0x0067:
            r4.f5850a = r10
            goto L_0x00c8
        L_0x006a:
            int r10 = r5.mo8214b()
            if (r10 < r14) goto L_0x008f
            int r10 = r5.mo8214b()
            r11 = 5
            if (r10 > r11) goto L_0x008f
            com.cyberneid.d.g.d.u r10 = r3.mo8129j()
            int r10 = r10.mo8214b()
            if (r10 < r14) goto L_0x008f
            com.cyberneid.d.g.d.u r10 = r3.mo8129j()
            int r10 = r10.mo8214b()
            if (r10 > r11) goto L_0x008f
        L_0x008b:
            double r10 = r4.f5850a
            double r10 = r10 + r8
            goto L_0x0067
        L_0x008f:
            int r10 = r5.mo8214b()
            r11 = 11
            if (r10 < r11) goto L_0x00b4
            int r10 = r5.mo8214b()
            r15 = 13
            if (r10 > r15) goto L_0x00b4
            com.cyberneid.d.g.d.u r10 = r3.mo8129j()
            int r10 = r10.mo8214b()
            if (r10 < r11) goto L_0x00b4
            com.cyberneid.d.g.d.u r10 = r3.mo8129j()
            int r10 = r10.mo8214b()
            if (r10 > r15) goto L_0x00b4
            goto L_0x008b
        L_0x00b4:
            int r10 = r5.mo8214b()
            if (r10 == 0) goto L_0x00c8
            com.cyberneid.d.g.d.u r10 = r3.mo8129j()
            int r10 = r10.mo8214b()
            if (r10 == 0) goto L_0x00c8
            double r10 = r4.f5850a
            double r10 = r10 - r8
            goto L_0x0067
        L_0x00c8:
            com.cyberneid.d.g.d.u r10 = r3.mo8129j()
            int r10 = r10.mo8215c()
            int r3 = r3.mo8133k()
            int r11 = r10 - r3
            int r11 = java.lang.Math.abs(r11)
            if (r11 <= r14) goto L_0x00dd
            goto L_0x00de
        L_0x00dd:
            r3 = r10
        L_0x00de:
            int r10 = r5.mo8215c()
            if (r10 != r3) goto L_0x00ea
            double r5 = r4.f5850a
            double r5 = r5 + r12
            r4.f5850a = r5
            goto L_0x0129
        L_0x00ea:
            int r10 = r5.mo8215c()
            r11 = 1
            if (r10 <= r11) goto L_0x0129
            if (r3 <= r11) goto L_0x0129
            int r5 = r5.mo8215c()
            int r5 = r5 - r3
            int r3 = java.lang.Math.abs(r5)
            float r3 = (float) r3
            double r10 = r4.f5850a
            goto L_0x0122
        L_0x0100:
            float r5 = r16.mo8200h()
            r10 = 0
            int r5 = (r5 > r10 ? 1 : (r5 == r10 ? 0 : -1))
            if (r5 <= 0) goto L_0x0129
            int r5 = r3.mo8125f()
            if (r5 <= 0) goto L_0x0129
            float r5 = r16.mo8200h()
            int r3 = r3.mo8125f()
            float r3 = (float) r3
            float r5 = r5 - r3
            float r3 = java.lang.Math.abs(r5)
            double r10 = r4.f5850a
            r5 = 1120403456(0x42c80000, float:100.0)
            float r3 = r3 / r5
        L_0x0122:
            double r12 = (double) r3
            double r12 = r12 * r6
            double r8 = r8 - r12
            double r10 = r10 + r8
            r4.f5850a = r10
        L_0x0129:
            r1.add(r4)
            goto L_0x0013
        L_0x012e:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p114g.p120d.C1810h.m7351a(com.cyberneid.d.g.d.q, com.cyberneid.d.g.d.o):java.util.PriorityQueue");
    }

    /* renamed from: a */
    private static Set<String> m7352a(String str) {
        HashSet hashSet = new HashSet();
        hashSet.add(str);
        hashSet.add(str.replaceAll("-", ""));
        return hashSet;
    }

    /* renamed from: a */
    public static synchronized void m7353a(C1814j jVar) {
        synchronized (C1810h.class) {
            f5845b = jVar;
            f5846c = m7350a(jVar.mo8119a());
        }
    }

    /* renamed from: a */
    private static boolean m7354a(C1819o oVar, C1809g gVar) {
        if (gVar.mo8122c() != null) {
            return gVar.mo8122c().mo8115a().equals(oVar.mo8153a()) && gVar.mo8122c().mo8116b().equals(oVar.mo8154b());
        }
        long l = gVar.mo8134l();
        if (oVar.mo8154b().equals("GB1") && (l & PlaybackStateCompat.ACTION_SET_REPEAT_MODE) == PlaybackStateCompat.ACTION_SET_REPEAT_MODE) {
            return true;
        }
        if (oVar.mo8154b().equals("CNS1") && (l & 1048576) == 1048576) {
            return true;
        }
        if (!oVar.mo8154b().equals("Japan1") || (l & PlaybackStateCompat.ACTION_PREPARE_FROM_URI) != PlaybackStateCompat.ACTION_PREPARE_FROM_URI) {
            return (oVar.mo8154b().equals("Korea1") && (l & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) == PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE_ENABLED) || (l & PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE) == PlaybackStateCompat.ACTION_SET_SHUFFLE_MODE;
        }
        return true;
    }

    /* renamed from: b */
    private static C1809g m7356b(C1808f fVar, String str) {
        if (str.contains("+")) {
            str = str.substring(str.indexOf(43) + 1);
        }
        C1809g gVar = f5846c.get(str);
        if (gVar == null || gVar.mo8121b() != fVar) {
            return null;
        }
        return gVar;
    }

    /* renamed from: b */
    public static C1813i<C1479b> m7357b(String str, C1821q qVar) {
        C1479b d = m7360d(str);
        if (d != null) {
            return new C1813i<>(d, false);
        }
        C1479b d2 = m7360d(m7349a(qVar));
        if (d2 == null) {
            d2 = f5847d;
        }
        return new C1813i<>(d2, true);
    }

    /* renamed from: b */
    private static List<String> m7358b(String str) {
        return new ArrayList(f5848e.get(str));
    }

    /* renamed from: c */
    private static List<String> m7359c(String str) {
        List<String> list = f5848e.get(str.replaceAll(" ", ""));
        return list != null ? list : Collections.emptyList();
    }

    /* renamed from: d */
    private static C1479b m7360d(String str) {
        C1583d dVar = (C1583d) m7345a(C1808f.PFB, str);
        if (dVar != null) {
            return dVar;
        }
        C1489h hVar = (C1489h) m7345a(C1808f.OTF, str);
        if (hVar instanceof C1515n) {
            return hVar;
        }
        C1544ab abVar = (C1544ab) m7345a(C1808f.TTF, str);
        if (abVar != null) {
            return abVar;
        }
        return null;
    }
}
