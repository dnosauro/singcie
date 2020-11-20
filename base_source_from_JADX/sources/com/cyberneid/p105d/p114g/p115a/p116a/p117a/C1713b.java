package com.cyberneid.p105d.p114g.p115a.p116a.p117a;

import java.util.Stack;

/* renamed from: com.cyberneid.d.g.a.a.a.b */
class C1713b {

    /* renamed from: com.cyberneid.d.g.a.a.a.b$a */
    private static abstract class C1715a implements C1729g {
        private C1715a() {
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract int mo7895a(int i, int i2);

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Object valueOf;
            Stack<Object> a = dVar.mo7897a();
            Object pop = a.pop();
            Object pop2 = a.pop();
            if ((pop2 instanceof Boolean) && (pop instanceof Boolean)) {
                valueOf = Boolean.valueOf(mo7896a(((Boolean) pop2).booleanValue(), ((Boolean) pop).booleanValue()));
            } else if (!(pop2 instanceof Integer) || !(pop instanceof Integer)) {
                throw new ClassCastException("Operands must be bool/bool or int/int");
            } else {
                valueOf = Integer.valueOf(mo7895a(((Integer) pop2).intValue(), ((Integer) pop).intValue()));
            }
            a.push(valueOf);
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public abstract boolean mo7896a(boolean z, boolean z2);
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.b$b */
    static class C1716b extends C1715a {
        C1716b() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7895a(int i, int i2) {
            return i & i2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo7896a(boolean z, boolean z2) {
            return z & z2;
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.b$c */
    static class C1717c implements C1729g {
        C1717c() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> a = dVar.mo7897a();
            int intValue = ((Integer) a.pop()).intValue();
            int intValue2 = ((Integer) a.pop()).intValue();
            a.push(Integer.valueOf(intValue < 0 ? intValue2 >> Math.abs(intValue) : intValue2 << intValue));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.b$d */
    static class C1718d implements C1729g {
        C1718d() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            dVar.mo7897a().push(Boolean.FALSE);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.b$e */
    static class C1719e implements C1729g {
        C1719e() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Object obj;
            Stack<Object> a = dVar.mo7897a();
            Object pop = a.pop();
            if (pop instanceof Boolean) {
                obj = Boolean.valueOf(!((Boolean) pop).booleanValue());
            } else if (pop instanceof Integer) {
                obj = Integer.valueOf(-((Integer) pop).intValue());
            } else {
                throw new ClassCastException("Operand must be bool or int");
            }
            a.push(obj);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.b$f */
    static class C1720f extends C1715a {
        C1720f() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7895a(int i, int i2) {
            return i | i2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo7896a(boolean z, boolean z2) {
            return z | z2;
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.b$g */
    static class C1721g implements C1729g {
        C1721g() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            dVar.mo7897a().push(Boolean.TRUE);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.b$h */
    static class C1722h extends C1715a {
        C1722h() {
            super();
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public int mo7895a(int i, int i2) {
            return i ^ i2;
        }

        /* access modifiers changed from: protected */
        /* renamed from: a */
        public boolean mo7896a(boolean z, boolean z2) {
            return z ^ z2;
        }
    }
}
