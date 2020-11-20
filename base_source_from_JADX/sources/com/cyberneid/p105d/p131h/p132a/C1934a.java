package com.cyberneid.p105d.p131h.p132a;

import java.util.HashMap;
import java.util.Map;

/* renamed from: com.cyberneid.d.h.a.a */
class C1934a<T> {

    /* renamed from: a */
    private final C1935a<T> f6113a = new C1935a<>();

    /* renamed from: b */
    private int f6114b;

    /* renamed from: com.cyberneid.d.h.a.a$a */
    static class C1935a<T> {
        /* access modifiers changed from: private */

        /* renamed from: a */
        public final Map<Byte, C1935a<T>> f6115a = new HashMap();

        /* renamed from: b */
        private T f6116b = null;

        C1935a() {
        }

        /* renamed from: a */
        public T mo8476a() {
            return this.f6116b;
        }

        /* renamed from: a */
        public void mo8477a(T t) {
            if (this.f6116b == null) {
                this.f6116b = t;
                return;
            }
            throw new IllegalStateException("Value already set for this trie node");
        }
    }

    C1934a() {
    }

    /* renamed from: a */
    public T mo8473a(byte[] bArr) {
        C1935a<T> aVar = this.f6113a;
        T a = aVar.mo8476a();
        for (byte valueOf : bArr) {
            aVar = (C1935a) aVar.f6115a.get(Byte.valueOf(valueOf));
            if (aVar == null) {
                break;
            }
            if (aVar.mo8476a() != null) {
                a = aVar.mo8476a();
            }
        }
        return a;
    }

    /* renamed from: a */
    public void mo8474a(T t) {
        this.f6113a.mo8477a(t);
    }

    /* renamed from: a */
    public void mo8475a(T t, byte[]... bArr) {
        C1935a<T> aVar = this.f6113a;
        int length = bArr.length;
        C1935a<T> aVar2 = aVar;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            C1935a<T> aVar3 = aVar2;
            for (byte b : bArr[i]) {
                C1935a<T> aVar4 = (C1935a) aVar3.f6115a.get(Byte.valueOf(b));
                if (aVar4 == null) {
                    aVar4 = new C1935a<>();
                    aVar3.f6115a.put(Byte.valueOf(b), aVar4);
                }
                aVar3 = aVar4;
                i2++;
            }
            i++;
            aVar2 = aVar3;
        }
        aVar2.mo8477a(t);
        this.f6114b = Math.max(this.f6114b, i2);
    }
}
