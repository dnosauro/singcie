package com.cyberneid.p105d.p112e;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1608e;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p113f.C1686c;
import java.io.OutputStream;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

/* renamed from: com.cyberneid.d.e.h */
public class C1673h {

    /* renamed from: a */
    private final Map<Long, Object> f5547a;

    /* renamed from: b */
    private final Set<Long> f5548b;

    /* renamed from: c */
    private final C1619o f5549c;

    /* renamed from: d */
    private long f5550d;

    /* renamed from: com.cyberneid.d.e.h$a */
    class C1674a {

        /* renamed from: a */
        int f5551a;

        /* renamed from: b */
        long f5552b;

        C1674a() {
        }
    }

    /* renamed from: com.cyberneid.d.e.h$b */
    class C1675b {

        /* renamed from: a */
        int f5554a;

        /* renamed from: b */
        long f5555b;

        C1675b() {
        }
    }

    /* renamed from: com.cyberneid.d.e.h$c */
    class C1676c {

        /* renamed from: a */
        long f5557a;

        /* renamed from: b */
        long f5558b;
    }

    public C1673h() {
        this.f5550d = -1;
        this.f5549c = new C1619o();
        this.f5547a = new TreeMap();
        this.f5548b = new TreeSet();
    }

    public C1673h(C1608e eVar) {
        this.f5550d = -1;
        this.f5549c = eVar.mo7559a();
        this.f5547a = new TreeMap();
        this.f5548b = new TreeSet();
    }

    /* renamed from: a */
    private void m6800a(OutputStream outputStream, long j, int i) {
        byte[] bArr = new byte[i];
        long j2 = j;
        for (int i2 = 0; i2 < i; i2++) {
            bArr[i2] = (byte) ((int) (255 & j2));
            j2 >>= 8;
        }
        for (int i3 = 0; i3 < i; i3++) {
            outputStream.write(bArr[(i - i3) - 1]);
        }
    }

    /* renamed from: a */
    private void m6801a(OutputStream outputStream, int[] iArr) {
        long j;
        int i;
        for (Object next : this.f5547a.values()) {
            if (next instanceof C1674a) {
                C1674a aVar = (C1674a) next;
                m6800a(outputStream, 0, iArr[0]);
                m6800a(outputStream, aVar.f5552b, iArr[1]);
                j = (long) aVar.f5551a;
                i = iArr[2];
            } else if (next instanceof C1675b) {
                C1675b bVar = (C1675b) next;
                m6800a(outputStream, 1, iArr[0]);
                m6800a(outputStream, bVar.f5555b, iArr[1]);
                j = (long) bVar.f5554a;
                i = iArr[2];
            } else if (next instanceof C1676c) {
                C1676c cVar = (C1676c) next;
                m6800a(outputStream, 2, iArr[0]);
                m6800a(outputStream, cVar.f5558b, iArr[1]);
                j = cVar.f5557a;
                i = iArr[2];
            } else {
                throw new RuntimeException("unexpected reference type");
            }
            m6800a(outputStream, j, i);
        }
    }

    /* renamed from: b */
    private int[] m6802b() {
        long[] jArr = new long[3];
        Iterator<Object> it = this.f5547a.values().iterator();
        while (true) {
            if (it.hasNext()) {
                Object next = it.next();
                if (next instanceof C1674a) {
                    C1674a aVar = (C1674a) next;
                    jArr[0] = Math.max(jArr[0], 0);
                    jArr[1] = Math.max(jArr[1], aVar.f5552b);
                    jArr[2] = Math.max(jArr[2], (long) aVar.f5551a);
                } else if (next instanceof C1675b) {
                    C1675b bVar = (C1675b) next;
                    jArr[0] = Math.max(jArr[0], 1);
                    jArr[1] = Math.max(jArr[1], bVar.f5555b);
                    jArr[2] = Math.max(jArr[2], (long) bVar.f5554a);
                } else if (next instanceof C1676c) {
                    C1676c cVar = (C1676c) next;
                    jArr[0] = Math.max(jArr[0], 2);
                    jArr[1] = Math.max(jArr[1], cVar.f5558b);
                    jArr[2] = Math.max(jArr[2], cVar.f5557a);
                } else {
                    throw new RuntimeException("unexpected reference type");
                }
            } else {
                int[] iArr = new int[3];
                for (int i = 0; i < iArr.length; i++) {
                    while (jArr[i] > 0) {
                        iArr[i] = iArr[i] + 1;
                        jArr[i] = jArr[i] >> 8;
                    }
                }
                return iArr;
            }
        }
    }

    /* renamed from: c */
    private long m6803c() {
        return this.f5550d;
    }

    /* renamed from: d */
    private List<Long> m6804d() {
        LinkedList linkedList = new LinkedList();
        Long l = null;
        Long l2 = null;
        for (Long next : this.f5548b) {
            if (l == null) {
                l2 = 1L;
                l = next;
            }
            if (l.longValue() + l2.longValue() == next.longValue()) {
                l2 = Long.valueOf(l2.longValue() + 1);
            }
            if (l.longValue() + l2.longValue() < next.longValue()) {
                linkedList.add(l);
                linkedList.add(l2);
                l2 = 1L;
                l = next;
            }
        }
        linkedList.add(l);
        linkedList.add(l2);
        return linkedList;
    }

    /* renamed from: a */
    public C1619o mo7802a() {
        this.f5549c.mo7521a(C1613i.f5338hw, (C1605b) C1613i.f5315hZ);
        if (this.f5550d != -1) {
            this.f5549c.mo7520a(C1613i.f5288gz, m6803c());
            List<Long> d = m6804d();
            C1604a aVar = new C1604a();
            for (Long longValue : d) {
                aVar.mo7490a((C1605b) C1612h.m6455a(longValue.longValue()));
            }
            this.f5549c.mo7521a(C1613i.f5122ds, (C1605b) aVar);
            int[] b = m6802b();
            C1604a aVar2 = new C1604a();
            for (int i : b) {
                aVar2.mo7490a((C1605b) C1612h.m6455a((long) i));
            }
            this.f5549c.mo7521a(C1613i.f5305hP, (C1605b) aVar2);
            OutputStream a = this.f5549c.mo7623a((C1605b) C1613i.f5028cD);
            m6801a(a, b);
            a.flush();
            a.close();
            for (C1613i c : this.f5549c.mo7540c()) {
                this.f5549c.mo7539c(c).mo7504a(true);
            }
            return this.f5549c;
        }
        throw new IllegalArgumentException("size is not set in xrefstream");
    }

    /* renamed from: a */
    public void mo7803a(long j) {
        this.f5550d = j;
    }

    /* renamed from: a */
    public void mo7804a(C1607d dVar) {
        for (Map.Entry next : dVar.mo7546f()) {
            C1613i iVar = (C1613i) next.getKey();
            if (C1613i.f5124du.equals(iVar) || C1613i.f5271gi.equals(iVar) || C1613i.f5058ch.equals(iVar) || C1613i.f5114dk.equals(iVar) || C1613i.f5190fG.equals(iVar)) {
                this.f5549c.mo7521a(iVar, (C1605b) next.getValue());
            }
        }
    }

    /* renamed from: a */
    public void mo7805a(C1686c cVar) {
        this.f5548b.add(Long.valueOf(cVar.mo7844b().mo7613b()));
        if (cVar.mo7847d()) {
            C1674a aVar = new C1674a();
            aVar.f5551a = cVar.mo7844b().mo7611a();
            aVar.f5552b = cVar.mo7844b().mo7613b();
            this.f5547a.put(Long.valueOf(aVar.f5552b), aVar);
            return;
        }
        C1675b bVar = new C1675b();
        bVar.f5554a = cVar.mo7844b().mo7611a();
        bVar.f5555b = cVar.mo7845c();
        this.f5547a.put(Long.valueOf(cVar.mo7844b().mo7613b()), bVar);
    }
}
