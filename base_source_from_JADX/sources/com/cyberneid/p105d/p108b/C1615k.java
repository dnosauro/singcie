package com.cyberneid.p105d.p108b;

import java.io.IOException;

/* renamed from: com.cyberneid.d.b.k */
public abstract class C1615k extends C1605b {
    @Deprecated

    /* renamed from: e */
    public static final C1612h f5369e = C1612h.f4886a;
    @Deprecated

    /* renamed from: f */
    public static final C1612h f5370f = C1612h.f4887b;

    /* renamed from: a */
    public static C1615k m6468a(String str) {
        if (str.length() == 1) {
            char charAt = str.charAt(0);
            if ('0' <= charAt && charAt <= '9') {
                return C1612h.m6455a((long) (charAt - '0'));
            }
            if (charAt == '-' || charAt == '.') {
                return C1612h.f4886a;
            }
            throw new IOException("Not a number: " + str);
        } else if (str.indexOf(46) != -1 || str.toLowerCase().indexOf(101) != -1) {
            return new C1609f(str);
        } else {
            try {
                return str.charAt(0) == '+' ? C1612h.m6455a(Long.parseLong(str.substring(1))) : C1612h.m6455a(Long.parseLong(str));
            } catch (NumberFormatException e) {
                throw new IOException("Value is not an integer: " + str, e);
            }
        }
    }

    /* renamed from: a */
    public abstract float mo7583a();

    /* renamed from: b */
    public abstract long mo7585b();

    /* renamed from: c */
    public abstract int mo7586c();
}
