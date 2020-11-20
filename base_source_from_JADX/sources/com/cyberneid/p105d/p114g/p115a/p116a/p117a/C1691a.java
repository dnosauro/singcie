package com.cyberneid.p105d.p114g.p115a.p116a.p117a;

import java.util.Stack;

/* renamed from: com.cyberneid.d.g.a.a.a.a */
class C1691a {

    /* renamed from: com.cyberneid.d.g.a.a.a.a$a */
    static class C1692a implements C1729g {
        C1692a() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> stack;
            Object obj;
            Number c = dVar.mo7899c();
            if (c instanceof Integer) {
                stack = dVar.mo7897a();
                obj = Integer.valueOf(Math.abs(c.intValue()));
            } else {
                stack = dVar.mo7897a();
                obj = Float.valueOf(Math.abs(c.floatValue()));
            }
            stack.push(obj);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$b */
    static class C1693b implements C1729g {
        C1693b() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> stack;
            Object obj;
            Number c = dVar.mo7899c();
            Number c2 = dVar.mo7899c();
            if (!(c2 instanceof Integer) || !(c instanceof Integer)) {
                stack = dVar.mo7897a();
                obj = Float.valueOf(c2.floatValue() + c.floatValue());
            } else {
                long longValue = c2.longValue() + c.longValue();
                if (longValue < -2147483648L || longValue > 2147483647L) {
                    stack = dVar.mo7897a();
                    obj = Float.valueOf((float) longValue);
                } else {
                    stack = dVar.mo7897a();
                    obj = Integer.valueOf((int) longValue);
                }
            }
            stack.push(obj);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$c */
    static class C1694c implements C1729g {
        C1694c() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            float degrees = ((float) Math.toDegrees((double) ((float) Math.atan2((double) dVar.mo7901e(), (double) dVar.mo7901e())))) % 360.0f;
            if (degrees < 0.0f) {
                degrees += 360.0f;
            }
            dVar.mo7897a().push(Float.valueOf(degrees));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$d */
    static class C1695d implements C1729g {
        C1695d() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> stack;
            Number c = dVar.mo7899c();
            if (c instanceof Integer) {
                stack = dVar.mo7897a();
            } else {
                stack = dVar.mo7897a();
                c = Float.valueOf((float) Math.ceil(c.doubleValue()));
            }
            stack.push(c);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$e */
    static class C1696e implements C1729g {
        C1696e() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            dVar.mo7897a().push(Float.valueOf((float) Math.cos(Math.toRadians((double) dVar.mo7901e()))));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$f */
    static class C1697f implements C1729g {
        C1697f() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            dVar.mo7897a().push(Integer.valueOf(dVar.mo7899c().intValue()));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$g */
    static class C1698g implements C1729g {
        C1698g() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            dVar.mo7897a().push(Float.valueOf(dVar.mo7899c().floatValue()));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$h */
    static class C1699h implements C1729g {
        C1699h() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Number c = dVar.mo7899c();
            dVar.mo7897a().push(Float.valueOf(dVar.mo7899c().floatValue() / c.floatValue()));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$i */
    static class C1700i implements C1729g {
        C1700i() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            dVar.mo7897a().push(Float.valueOf((float) Math.pow(dVar.mo7899c().doubleValue(), dVar.mo7899c().doubleValue())));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$j */
    static class C1701j implements C1729g {
        C1701j() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> stack;
            Number c = dVar.mo7899c();
            if (c instanceof Integer) {
                stack = dVar.mo7897a();
            } else {
                stack = dVar.mo7897a();
                c = Float.valueOf((float) Math.floor(c.doubleValue()));
            }
            stack.push(c);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$k */
    static class C1702k implements C1729g {
        C1702k() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            int d = dVar.mo7900d();
            dVar.mo7897a().push(Integer.valueOf(dVar.mo7900d() / d));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$l */
    static class C1703l implements C1729g {
        C1703l() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            dVar.mo7897a().push(Float.valueOf((float) Math.log(dVar.mo7899c().doubleValue())));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$m */
    static class C1704m implements C1729g {
        C1704m() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            dVar.mo7897a().push(Float.valueOf((float) Math.log10(dVar.mo7899c().doubleValue())));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$n */
    static class C1705n implements C1729g {
        C1705n() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            int d = dVar.mo7900d();
            dVar.mo7897a().push(Integer.valueOf(dVar.mo7900d() % d));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$o */
    static class C1706o implements C1729g {
        C1706o() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> stack;
            Object obj;
            float f;
            Number c = dVar.mo7899c();
            Number c2 = dVar.mo7899c();
            if (!(c2 instanceof Integer) || !(c instanceof Integer)) {
                stack = dVar.mo7897a();
                f = (float) (c2.doubleValue() * c.doubleValue());
            } else {
                long longValue = c2.longValue() * c.longValue();
                if (longValue < -2147483648L || longValue > 2147483647L) {
                    stack = dVar.mo7897a();
                    f = (float) longValue;
                } else {
                    stack = dVar.mo7897a();
                    obj = Integer.valueOf((int) longValue);
                    stack.push(obj);
                }
            }
            obj = Float.valueOf(f);
            stack.push(obj);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$p */
    static class C1707p implements C1729g {
        C1707p() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> stack;
            Object obj;
            Number c = dVar.mo7899c();
            if (!(c instanceof Integer) || c.intValue() == Integer.MIN_VALUE) {
                stack = dVar.mo7897a();
                obj = Float.valueOf(-c.floatValue());
            } else {
                stack = dVar.mo7897a();
                obj = Integer.valueOf(-c.intValue());
            }
            stack.push(obj);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$q */
    static class C1708q implements C1729g {
        C1708q() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> stack;
            Object obj;
            Number c = dVar.mo7899c();
            if (c instanceof Integer) {
                stack = dVar.mo7897a();
                obj = Integer.valueOf(c.intValue());
            } else {
                stack = dVar.mo7897a();
                obj = Float.valueOf((float) Math.round(c.doubleValue()));
            }
            stack.push(obj);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$r */
    static class C1709r implements C1729g {
        C1709r() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            dVar.mo7897a().push(Float.valueOf((float) Math.sin(Math.toRadians((double) dVar.mo7901e()))));
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$s */
    static class C1710s implements C1729g {
        C1710s() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            float e = dVar.mo7901e();
            if (e >= 0.0f) {
                dVar.mo7897a().push(Float.valueOf((float) Math.sqrt((double) e)));
                return;
            }
            throw new IllegalArgumentException("argument must be nonnegative");
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$t */
    static class C1711t implements C1729g {
        C1711t() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Object obj;
            float f;
            Stack<Object> a = dVar.mo7897a();
            Number c = dVar.mo7899c();
            Number c2 = dVar.mo7899c();
            if (!(c2 instanceof Integer) || !(c instanceof Integer)) {
                f = c2.floatValue() - c.floatValue();
            } else {
                long longValue = c2.longValue() - c.longValue();
                if (longValue < -2147483648L || longValue > 2147483647L) {
                    f = (float) longValue;
                } else {
                    obj = Integer.valueOf((int) longValue);
                    a.push(obj);
                }
            }
            obj = Float.valueOf(f);
            a.push(obj);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.a$u */
    static class C1712u implements C1729g {
        C1712u() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> stack;
            Object obj;
            Number c = dVar.mo7899c();
            if (c instanceof Integer) {
                stack = dVar.mo7897a();
                obj = Integer.valueOf(c.intValue());
            } else {
                stack = dVar.mo7897a();
                obj = Float.valueOf((float) ((int) c.floatValue()));
            }
            stack.push(obj);
        }
    }
}
