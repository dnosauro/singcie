package com.cyberneid.p105d.p114g.p115a.p116a.p117a;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Stack;

/* renamed from: com.cyberneid.d.g.a.a.a.k */
class C1746k {

    /* renamed from: com.cyberneid.d.g.a.a.a.k$a */
    static class C1747a implements C1729g {
        C1747a() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> a = dVar.mo7897a();
            int intValue = ((Number) a.pop()).intValue();
            if (intValue > 0) {
                int size = a.size();
                a.addAll(new ArrayList(a.subList(size - intValue, size)));
            }
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.k$b */
    static class C1748b implements C1729g {
        C1748b() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> a = dVar.mo7897a();
            a.push(a.peek());
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.k$c */
    static class C1749c implements C1729g {
        C1749c() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> a = dVar.mo7897a();
            Object pop = a.pop();
            Object pop2 = a.pop();
            a.push(pop);
            a.push(pop2);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.k$d */
    static class C1750d implements C1729g {
        C1750d() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> a = dVar.mo7897a();
            int intValue = ((Number) a.pop()).intValue();
            if (intValue >= 0) {
                a.push(a.get((a.size() - intValue) - 1));
                return;
            }
            throw new IllegalArgumentException("rangecheck: " + intValue);
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.k$e */
    static class C1751e implements C1729g {
        C1751e() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            dVar.mo7897a().pop();
        }
    }

    /* renamed from: com.cyberneid.d.g.a.a.a.k$f */
    static class C1752f implements C1729g {
        C1752f() {
        }

        /* renamed from: a */
        public void mo7894a(C1726d dVar) {
            Stack<Object> a = dVar.mo7897a();
            int intValue = ((Number) a.pop()).intValue();
            int intValue2 = ((Number) a.pop()).intValue();
            if (intValue != 0) {
                if (intValue2 >= 0) {
                    LinkedList linkedList = new LinkedList();
                    LinkedList linkedList2 = new LinkedList();
                    int i = 0;
                    if (intValue < 0) {
                        int i2 = intValue2 + intValue;
                        while (i < i2) {
                            linkedList2.addFirst(a.pop());
                            i++;
                        }
                        while (intValue < 0) {
                            linkedList.addFirst(a.pop());
                            intValue++;
                        }
                        a.addAll(linkedList2);
                        a.addAll(linkedList);
                        return;
                    }
                    int i3 = intValue2 - intValue;
                    while (intValue > 0) {
                        linkedList.addFirst(a.pop());
                        intValue--;
                    }
                    while (i < i3) {
                        linkedList2.addFirst(a.pop());
                        i++;
                    }
                    a.addAll(linkedList);
                    a.addAll(linkedList2);
                    return;
                }
                throw new IllegalArgumentException("rangecheck: " + intValue2);
            }
        }
    }
}
