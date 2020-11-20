package com.cyberneid.p105d.p114g.p115a.p116a.p117a;

import java.util.Stack;

/* renamed from: com.cyberneid.d.g.a.a.a.j */
class C1737j {

    /* renamed from: com.cyberneid.d.g.a.a.a.j$a */
    private static abstract class C1739a implements C1729g {
        private C1739a() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> a = dVar.mo7897a();
            a.push(Boolean.valueOf(mo7913a((Number) a.pop(), (Number) a.pop())));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract boolean mo7913a(Number number, Number number2);
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.j$b */
    static class C1740b implements C1729g {
        C1740b() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> a = dVar.mo7897a();
            a.push(Boolean.valueOf(mo7914a(a.pop(), a.pop())));
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo7914a(Object obj, Object obj2) {
            return (!(obj instanceof Number) || !(obj2 instanceof Number)) ? obj.equals(obj2) : ((Number) obj).floatValue() == ((Number) obj2).floatValue();
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.j$c */
    static class C1741c extends C1739a {
        C1741c() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo7913a(Number number, Number number2) {
            return number.floatValue() >= number2.floatValue();
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.j$d */
    static class C1742d extends C1739a {
        C1742d() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo7913a(Number number, Number number2) {
            return number.floatValue() > number2.floatValue();
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.j$e */
    static class C1743e extends C1739a {
        C1743e() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo7913a(Number number, Number number2) {
            return number.floatValue() <= number2.floatValue();
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.j$f */
    static class C1744f extends C1739a {
        C1744f() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo7913a(Number number, Number number2) {
            return number.floatValue() < number2.floatValue();
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.j$g */
    static class C1745g extends C1740b {
        C1745g() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo7914a(Object obj, Object obj2) {
            return !super.mo7914a(obj, obj2);
        }
    }
}
