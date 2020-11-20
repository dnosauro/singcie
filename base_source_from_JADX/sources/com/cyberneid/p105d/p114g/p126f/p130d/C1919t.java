package com.cyberneid.p105d.p114g.p126f.p130d;

import com.cyberneid.p105d.p114g.p120d.C1820p;
import java.text.AttributedCharacterIterator;
import java.text.AttributedString;
import java.text.BreakIterator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.cyberneid.d.g.f.d.t */
class C1919t {

    /* renamed from: a */
    private final List<C1921b> f6072a = new ArrayList();

    /* renamed from: com.cyberneid.d.g.f.d.t$a */
    static class C1920a {

        /* renamed from: a */
        private final List<C1923d> f6073a = new ArrayList();

        /* renamed from: b */
        private float f6074b;

        C1920a() {
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public float mo8435a() {
            return this.f6074b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public float mo8436a(C1820p pVar, float f) {
            float f2 = f / 1000.0f;
            float f3 = 0.0f;
            for (C1923d next : this.f6073a) {
                f3 += ((Float) next.mo8445b().getIterator().getAttribute(C1922c.f6076a)).floatValue();
                String a = next.mo8443a();
                if (this.f6073a.indexOf(next) == this.f6073a.size() - 1 && Character.isWhitespace(a.charAt(a.length() - 1))) {
                    f3 -= pVar.mo8162b(a.substring(a.length() - 1)) * f2;
                }
            }
            return f3;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8437a(float f) {
            this.f6074b = f;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8438a(C1923d dVar) {
            this.f6073a.add(dVar);
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public float mo8439b(float f) {
            return (f - this.f6074b) / ((float) (this.f6073a.size() - 1));
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public List<C1923d> mo8440b() {
            return this.f6073a;
        }
    }

    /* renamed from: com.cyberneid.d.g.f.d.t$b */
    static class C1921b {

        /* renamed from: a */
        private final String f6075a;

        C1921b(String str) {
            this.f6075a = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo8441a() {
            return this.f6075a;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public List<C1920a> mo8442a(C1820p pVar, float f, float f2) {
            BreakIterator lineInstance = BreakIterator.getLineInstance();
            lineInstance.setText(this.f6075a);
            float f3 = f / 1000.0f;
            int first = lineInstance.first();
            int next = lineInstance.next();
            ArrayList arrayList = new ArrayList();
            C1920a aVar = new C1920a();
            float f4 = 0.0f;
            while (true) {
                int i = next;
                int i2 = first;
                first = i;
                if (first != -1) {
                    String substring = this.f6075a.substring(i2, first);
                    float b = pVar.mo8162b(substring) * f3;
                    f4 += b;
                    if (f4 >= f2 && Character.isWhitespace(substring.charAt(substring.length() - 1))) {
                        f4 -= pVar.mo8162b(substring.substring(substring.length() - 1)) * f3;
                    }
                    if (f4 >= f2) {
                        aVar.mo8437a(aVar.mo8436a(pVar, f));
                        arrayList.add(aVar);
                        aVar = new C1920a();
                        f4 = pVar.mo8162b(substring) * f3;
                    }
                    AttributedString attributedString = new AttributedString(substring);
                    attributedString.addAttribute(C1922c.f6076a, Float.valueOf(b));
                    C1923d dVar = new C1923d(substring);
                    dVar.mo8444a(attributedString);
                    aVar.mo8438a(dVar);
                    next = lineInstance.next();
                } else {
                    arrayList.add(aVar);
                    return arrayList;
                }
            }
        }
    }

    /* renamed from: com.cyberneid.d.g.f.d.t$c */
    static class C1922c extends AttributedCharacterIterator.Attribute {

        /* renamed from: a */
        public static final AttributedCharacterIterator.Attribute f6076a = new C1922c("width");

        protected C1922c(String str) {
            super(str);
        }
    }

    /* renamed from: com.cyberneid.d.g.f.d.t$d */
    static class C1923d {

        /* renamed from: a */
        private AttributedString f6077a;

        /* renamed from: b */
        private final String f6078b;

        C1923d(String str) {
            this.f6078b = str;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo8443a() {
            return this.f6078b;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public void mo8444a(AttributedString attributedString) {
            this.f6077a = attributedString;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: b */
        public AttributedString mo8445b() {
            return this.f6077a;
        }
    }

    C1919t(String str) {
        List<String> asList = Arrays.asList(str.split("\\n"));
        for (String bVar : asList) {
            this.f6072a.add(new C1921b(bVar));
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<C1921b> mo8434a() {
        return this.f6072a;
    }
}
