package com.cyberneid.p105d.p114g.p115a.p116a.p117a;

import com.cyberneid.p105d.p114g.p115a.p116a.p117a.C1731i;
import java.util.Stack;
import java.util.regex.Pattern;

/* renamed from: com.cyberneid.d.g.a.a.a.f */
public final class C1728f extends C1731i.C1733a {

    /* renamed from: c */
    private static final Pattern f5652c = Pattern.compile("[\\+\\-]?\\d+");

    /* renamed from: d */
    private static final Pattern f5653d = Pattern.compile("[\\-]?\\d*\\.\\d*([Ee]\\-?\\d+)?");

    /* renamed from: a */
    private final C1727e f5654a = new C1727e();

    /* renamed from: b */
    private final Stack<C1727e> f5655b = new Stack<>();

    private C1728f() {
        this.f5655b.push(this.f5654a);
    }

    /* renamed from: a */
    public static int m6970a(String str) {
        if (str.startsWith("+")) {
            str = str.substring(1);
        }
        return Integer.parseInt(str);
    }

    /* renamed from: a */
    public static C1727e m6971a(CharSequence charSequence) {
        C1728f fVar = new C1728f();
        C1731i.m6979a(charSequence, fVar);
        return fVar.mo7907a();
    }

    /* renamed from: b */
    public static float m6972b(String str) {
        return Float.parseFloat(str);
    }

    /* renamed from: b */
    private C1727e m6973b() {
        return this.f5655b.peek();
    }

    /* renamed from: c */
    private void m6974c(String str) {
        if ("{".equals(str)) {
            C1727e eVar = new C1727e();
            m6973b().mo7905a(eVar);
            this.f5655b.push(eVar);
        } else if ("}".equals(str)) {
            this.f5655b.pop();
        } else if (f5652c.matcher(str).matches()) {
            m6973b().mo7903a(m6970a(str));
        } else if (f5653d.matcher(str).matches()) {
            m6973b().mo7902a(m6972b(str));
        } else {
            m6973b().mo7906a(str);
        }
    }

    /* renamed from: a */
    public C1727e mo7907a() {
        return this.f5654a;
    }

    /* renamed from: b */
    public void mo7908b(CharSequence charSequence) {
        m6974c(charSequence.toString());
    }
}
