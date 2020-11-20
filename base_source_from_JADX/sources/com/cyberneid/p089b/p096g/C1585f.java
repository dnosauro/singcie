package com.cyberneid.p089b.p096g;

import com.cyberneid.p089b.p093d.C1538a;
import com.cyberneid.p089b.p093d.C1540c;
import com.cyberneid.p089b.p096g.C1580b;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.cyberneid.b.g.f */
final class C1585f {

    /* renamed from: a */
    private C1584e f4826a;

    /* renamed from: b */
    private C1583d f4827b;

    C1585f() {
    }

    /* renamed from: a */
    private C1580b m6247a(C1580b.C1581a aVar) {
        C1580b a = this.f4826a.mo7385a();
        if (a.mo7376b() == aVar) {
            return a;
        }
        throw new IOException("Found " + a + " but expected " + aVar);
    }

    /* renamed from: a */
    private List<Number> m6248a(List<C1580b> list) {
        Object valueOf;
        ArrayList arrayList = new ArrayList();
        int size = list.size() - 1;
        for (int i = 1; i < size; i++) {
            C1580b bVar = list.get(i);
            if (bVar.mo7376b() == C1580b.f4765d) {
                valueOf = Float.valueOf(bVar.mo7378d());
            } else if (bVar.mo7376b() == C1580b.f4766e) {
                valueOf = Integer.valueOf(bVar.mo7377c());
            } else {
                throw new IOException("Expected INTEGER or REAL but got " + bVar.mo7376b());
            }
            arrayList.add(valueOf);
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m6249a() {
        if (this.f4826a.mo7386b().mo7376b() == C1580b.f4763b) {
            String a = this.f4826a.mo7385a().mo7375a();
            if (a.equals("StandardEncoding")) {
                this.f4827b.f4798b = C1540c.f4565c;
            } else {
                throw new IOException("Unknown encoding: " + a);
            }
        } else {
            m6247a(C1580b.f4766e).mo7377c();
            m6257b(C1580b.f4763b, "array");
            while (true) {
                if (this.f4826a.mo7386b().mo7376b() != C1580b.f4763b || (!this.f4826a.mo7386b().mo7375a().equals("dup") && !this.f4826a.mo7386b().mo7375a().equals("readonly") && !this.f4826a.mo7386b().mo7375a().equals("def"))) {
                    this.f4826a.mo7385a();
                }
            }
            HashMap hashMap = new HashMap();
            while (this.f4826a.mo7386b().mo7376b() == C1580b.f4763b && this.f4826a.mo7386b().mo7375a().equals("dup")) {
                m6251a(C1580b.f4763b, "dup");
                int c = m6247a(C1580b.f4766e).mo7377c();
                String a2 = m6247a(C1580b.f4764c).mo7375a();
                m6251a(C1580b.f4763b, "put");
                hashMap.put(Integer.valueOf(c), a2);
            }
            this.f4827b.f4798b = new C1538a(hashMap);
        }
        m6257b(C1580b.f4763b, "readonly");
        m6251a(C1580b.f4763b, "def");
    }

    /* renamed from: a */
    private void m6250a(int i) {
        int c = m6247a(C1580b.f4766e).mo7377c();
        for (int i2 = 0; i2 < c; i2++) {
            this.f4827b.f4792F.add((Object) null);
        }
        m6251a(C1580b.f4763b, "array");
        for (int i3 = 0; i3 < c && this.f4826a.mo7386b().mo7376b() == C1580b.f4763b && this.f4826a.mo7386b().mo7375a().equals("dup"); i3++) {
            m6251a(C1580b.f4763b, "dup");
            C1580b a = m6247a(C1580b.f4766e);
            m6247a(C1580b.f4766e);
            this.f4827b.f4792F.set(a.mo7377c(), m6256a(m6247a(C1580b.f4771j).mo7380f(), 4330, i));
            m6266h();
        }
        m6265g();
    }

    /* renamed from: a */
    private void m6251a(C1580b.C1581a aVar, String str) {
        C1580b a = m6247a(aVar);
        if (!a.mo7375a().equals(str)) {
            throw new IOException("Found " + a + " but expected " + str);
        }
    }

    /* renamed from: a */
    private void m6252a(String str) {
        List<C1580b> c = m6261c();
        if (str.equals("FontName")) {
            this.f4827b.f4797a = c.get(0).mo7375a();
        } else if (str.equals("PaintType")) {
            this.f4827b.f4799c = c.get(0).mo7377c();
        } else if (str.equals("FontType")) {
            this.f4827b.f4800d = c.get(0).mo7377c();
        } else if (str.equals("FontMatrix")) {
            this.f4827b.f4801e = m6248a(c);
        } else if (str.equals("FontBBox")) {
            this.f4827b.f4802f = m6248a(c);
        } else if (str.equals("UniqueID")) {
            this.f4827b.f4803g = c.get(0).mo7377c();
        } else if (str.equals("StrokeWidth")) {
            this.f4827b.f4804h = c.get(0).mo7378d();
        } else if (str.equals("FID")) {
            this.f4827b.f4805i = c.get(0).mo7375a();
        }
    }

    /* renamed from: a */
    private void m6253a(String str, List<C1580b> list) {
        if (str.equals("BlueValues")) {
            this.f4827b.f4815s = m6248a(list);
        } else if (str.equals("OtherBlues")) {
            this.f4827b.f4816t = m6248a(list);
        } else if (str.equals("FamilyBlues")) {
            this.f4827b.f4817u = m6248a(list);
        } else if (str.equals("FamilyOtherBlues")) {
            this.f4827b.f4818v = m6248a(list);
        } else if (str.equals("BlueScale")) {
            this.f4827b.f4819w = list.get(0).mo7378d();
        } else if (str.equals("BlueShift")) {
            this.f4827b.f4820x = list.get(0).mo7377c();
        } else if (str.equals("BlueFuzz")) {
            this.f4827b.f4821y = list.get(0).mo7377c();
        } else if (str.equals("StdHW")) {
            this.f4827b.f4822z = m6248a(list);
        } else if (str.equals("StdVW")) {
            this.f4827b.f4787A = m6248a(list);
        } else if (str.equals("StemSnapH")) {
            this.f4827b.f4788B = m6248a(list);
        } else if (str.equals("StemSnapV")) {
            this.f4827b.f4789C = m6248a(list);
        } else if (str.equals("ForceBold")) {
            this.f4827b.f4790D = list.get(0).mo7379e();
        } else if (str.equals("LanguageGroup")) {
            this.f4827b.f4791E = list.get(0).mo7377c();
        }
    }

    /* renamed from: a */
    private void m6254a(Map<String, List<C1580b>> map) {
        for (Map.Entry next : map.entrySet()) {
            String str = (String) next.getKey();
            List list = (List) next.getValue();
            if (str.equals("version")) {
                this.f4827b.f4806j = ((C1580b) list.get(0)).mo7375a();
            } else if (str.equals("Notice")) {
                this.f4827b.f4807k = ((C1580b) list.get(0)).mo7375a();
            } else if (str.equals("FullName")) {
                this.f4827b.f4808l = ((C1580b) list.get(0)).mo7375a();
            } else if (str.equals("FamilyName")) {
                this.f4827b.f4809m = ((C1580b) list.get(0)).mo7375a();
            } else if (str.equals("Weight")) {
                this.f4827b.f4810n = ((C1580b) list.get(0)).mo7375a();
            } else if (str.equals("ItalicAngle")) {
                this.f4827b.f4811o = ((C1580b) list.get(0)).mo7378d();
            } else if (str.equals("isFixedPitch")) {
                this.f4827b.f4812p = ((C1580b) list.get(0)).mo7379e();
            } else if (str.equals("UnderlinePosition")) {
                this.f4827b.f4813q = ((C1580b) list.get(0)).mo7378d();
            } else if (str.equals("UnderlineThickness")) {
                this.f4827b.f4814r = ((C1580b) list.get(0)).mo7378d();
            }
        }
    }

    /* renamed from: a */
    private void m6255a(byte[] bArr) {
        if (bArr.length != 0) {
            if (bArr.length >= 2) {
                if (bArr[0] == 37 || bArr[1] == 33) {
                    this.f4826a = new C1584e(bArr);
                    if (this.f4826a.mo7386b().mo7375a().equals("FontDirectory")) {
                        m6251a(C1580b.f4763b, "FontDirectory");
                        m6247a(C1580b.f4764c);
                        m6251a(C1580b.f4763b, "known");
                        m6247a(C1580b.f4769h);
                        m6263e();
                        m6247a(C1580b.f4769h);
                        m6263e();
                        m6251a(C1580b.f4763b, "ifelse");
                    }
                    int c = m6247a(C1580b.f4766e).mo7377c();
                    m6251a(C1580b.f4763b, "dict");
                    m6257b(C1580b.f4763b, "dup");
                    m6251a(C1580b.f4763b, "begin");
                    for (int i = 0; i < c && (this.f4826a.mo7386b().mo7376b() != C1580b.f4763b || !this.f4826a.mo7386b().mo7375a().equals("currentdict")); i++) {
                        String a = m6247a(C1580b.f4764c).mo7375a();
                        if (a.equals("FontInfo")) {
                            m6254a(m6258b());
                        } else if (a.equals("Metrics")) {
                            m6258b();
                        } else if (a.equals("Encoding")) {
                            m6249a();
                        } else {
                            m6252a(a);
                        }
                    }
                    m6251a(C1580b.f4763b, "currentdict");
                    m6251a(C1580b.f4763b, "end");
                    m6251a(C1580b.f4763b, "currentfile");
                    m6251a(C1580b.f4763b, "eexec");
                    return;
                }
            }
            throw new IOException("Invalid start of ASCII segment");
        }
        throw new IllegalArgumentException("byte[] is empty");
    }

    /* renamed from: a */
    private byte[] m6256a(byte[] bArr, int i, int i2) {
        if (i2 == -1) {
            return bArr;
        }
        if (bArr.length == 0 || i2 > bArr.length) {
            return new byte[0];
        }
        byte[] bArr2 = new byte[(bArr.length - i2)];
        for (int i3 = 0; i3 < bArr.length; i3++) {
            byte b = bArr[i3] & 255;
            byte b2 = (i >> 8) ^ b;
            if (i3 >= i2) {
                bArr2[i3 - i2] = (byte) b2;
            }
            i = 65535 & (((b + i) * 52845) + 22719);
        }
        return bArr2;
    }

    /* renamed from: b */
    private C1580b m6257b(C1580b.C1581a aVar, String str) {
        C1580b b = this.f4826a.mo7386b();
        if (b.mo7376b() != aVar || !b.mo7375a().equals(str)) {
            return null;
        }
        return this.f4826a.mo7385a();
    }

    /* renamed from: b */
    private Map<String, List<C1580b>> m6258b() {
        HashMap hashMap = new HashMap();
        int c = m6247a(C1580b.f4766e).mo7377c();
        m6251a(C1580b.f4763b, "dict");
        m6257b(C1580b.f4763b, "dup");
        m6251a(C1580b.f4763b, "begin");
        for (int i = 0; i < c; i++) {
            if (this.f4826a.mo7386b().mo7376b() == C1580b.f4763b && !this.f4826a.mo7386b().mo7375a().equals("end")) {
                m6247a(C1580b.f4763b);
            }
            if (this.f4826a.mo7386b().mo7376b() == C1580b.f4763b && this.f4826a.mo7386b().mo7375a().equals("end")) {
                break;
            }
            hashMap.put(m6247a(C1580b.f4764c).mo7375a(), m6261c());
        }
        m6251a(C1580b.f4763b, "end");
        m6257b(C1580b.f4763b, "readonly");
        m6251a(C1580b.f4763b, "def");
        return hashMap;
    }

    /* renamed from: b */
    private void m6259b(int i) {
        int c = m6247a(C1580b.f4766e).mo7377c();
        m6251a(C1580b.f4763b, "dict");
        m6251a(C1580b.f4763b, "dup");
        m6251a(C1580b.f4763b, "begin");
        for (int i2 = 0; i2 < c && (this.f4826a.mo7386b().mo7376b() != C1580b.f4763b || !this.f4826a.mo7386b().mo7375a().equals("end")); i2++) {
            String a = m6247a(C1580b.f4764c).mo7375a();
            m6247a(C1580b.f4766e);
            this.f4827b.f4793G.put(a, m6256a(m6247a(C1580b.f4771j).mo7380f(), 4330, i));
            m6265g();
        }
        m6251a(C1580b.f4763b, "end");
    }

    /* renamed from: b */
    private void m6260b(byte[] bArr) {
        this.f4826a = new C1584e(m6256a(bArr, 55665, 4));
        while (!this.f4826a.mo7386b().mo7375a().equals("Private")) {
            this.f4826a.mo7385a();
        }
        m6251a(C1580b.f4764c, "Private");
        int c = m6247a(C1580b.f4766e).mo7377c();
        m6251a(C1580b.f4763b, "dict");
        m6257b(C1580b.f4763b, "dup");
        m6251a(C1580b.f4763b, "begin");
        int i = 4;
        for (int i2 = 0; i2 < c && this.f4826a.mo7386b().mo7376b() == C1580b.f4764c; i2++) {
            String a = m6247a(C1580b.f4764c).mo7375a();
            if (a.equals("Subrs")) {
                m6250a(i);
            } else if (a.equals("OtherSubrs")) {
                m6264f();
            } else if (a.equals("lenIV")) {
                i = m6261c().get(0).mo7377c();
            } else {
                if (a.equals("ND")) {
                    m6247a(C1580b.f4769h);
                    m6251a(C1580b.f4763b, "noaccess");
                    m6251a(C1580b.f4763b, "def");
                } else if (a.equals("NP")) {
                    m6247a(C1580b.f4769h);
                    m6251a(C1580b.f4763b, "noaccess");
                    m6247a(C1580b.f4763b);
                } else {
                    m6253a(a, m6261c());
                }
                m6247a(C1580b.f4770i);
                m6251a(C1580b.f4763b, "executeonly");
                m6251a(C1580b.f4763b, "def");
            }
        }
        while (true) {
            if (this.f4826a.mo7386b().mo7376b() != C1580b.f4764c || !this.f4826a.mo7386b().mo7375a().equals("CharStrings")) {
                this.f4826a.mo7385a();
            } else {
                m6251a(C1580b.f4764c, "CharStrings");
                m6259b(i);
                return;
            }
        }
    }

    /* renamed from: c */
    private List<C1580b> m6261c() {
        List<C1580b> d = m6262d();
        m6265g();
        return d;
    }

    /* renamed from: d */
    private List<C1580b> m6262d() {
        ArrayList arrayList = new ArrayList();
        C1580b a = this.f4826a.mo7385a();
        arrayList.add(a);
        if (a.mo7376b() == C1580b.f4767f) {
            int i = 1;
            while (true) {
                if (this.f4826a.mo7386b().mo7376b() == C1580b.f4767f) {
                    i++;
                }
                C1580b a2 = this.f4826a.mo7385a();
                arrayList.add(a2);
                if (a2.mo7376b() == C1580b.f4768g && i - 1 == 0) {
                    break;
                }
            }
        } else if (a.mo7376b() == C1580b.f4769h) {
            arrayList.addAll(m6263e());
        }
        if (this.f4826a.mo7386b().mo7375a().equals("systemdict")) {
            m6251a(C1580b.f4763b, "systemdict");
            m6251a(C1580b.f4764c, "internaldict");
            m6251a(C1580b.f4763b, "known");
            m6247a(C1580b.f4769h);
            m6263e();
            m6247a(C1580b.f4769h);
            m6263e();
            m6251a(C1580b.f4763b, "ifelse");
            m6247a(C1580b.f4769h);
            m6251a(C1580b.f4763b, "pop");
            arrayList.clear();
            arrayList.addAll(m6262d());
            m6247a(C1580b.f4770i);
            m6251a(C1580b.f4763b, "if");
        }
        return arrayList;
    }

    /* renamed from: e */
    private List<C1580b> m6263e() {
        ArrayList arrayList = new ArrayList();
        int i = 1;
        while (true) {
            if (this.f4826a.mo7386b().mo7376b() == C1580b.f4769h) {
                i++;
            }
            C1580b a = this.f4826a.mo7385a();
            arrayList.add(a);
            if (a.mo7376b() == C1580b.f4770i && i - 1 == 0) {
                break;
            }
        }
        C1580b b = m6257b(C1580b.f4763b, "executeonly");
        if (b != null) {
            arrayList.add(b);
        }
        return arrayList;
    }

    /* renamed from: f */
    private void m6264f() {
        if (this.f4826a.mo7386b().mo7376b() == C1580b.f4767f) {
            m6262d();
        } else {
            int c = m6247a(C1580b.f4766e).mo7377c();
            m6251a(C1580b.f4763b, "array");
            for (int i = 0; i < c; i++) {
                m6251a(C1580b.f4763b, "dup");
                m6247a(C1580b.f4766e);
                m6262d();
                m6266h();
            }
        }
        m6265g();
    }

    /* renamed from: g */
    private void m6265g() {
        m6257b(C1580b.f4763b, "readonly");
        m6257b(C1580b.f4763b, "noaccess");
        C1580b a = m6247a(C1580b.f4763b);
        if (!a.mo7375a().equals("ND") && !a.mo7375a().equals("|-")) {
            if (a.mo7375a().equals("noaccess")) {
                a = m6247a(C1580b.f4763b);
            }
            if (!a.mo7375a().equals("def")) {
                throw new IOException("Found " + a + " but expected ND");
            }
        }
    }

    /* renamed from: h */
    private void m6266h() {
        m6257b(C1580b.f4763b, "readonly");
        C1580b a = m6247a(C1580b.f4763b);
        if (!a.mo7375a().equals("NP") && !a.mo7375a().equals("|")) {
            if (a.mo7375a().equals("noaccess")) {
                a = m6247a(C1580b.f4763b);
            }
            if (!a.mo7375a().equals("put")) {
                throw new IOException("Found " + a + " but expected NP");
            }
        }
    }

    /* renamed from: a */
    public C1583d mo7387a(byte[] bArr, byte[] bArr2) {
        this.f4827b = new C1583d(bArr, bArr2);
        m6255a(bArr);
        if (bArr2.length > 0) {
            m6260b(bArr2);
        }
        return this.f4827b;
    }
}
