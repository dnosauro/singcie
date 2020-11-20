package com.github.barteksc.pdfviewer;

import android.graphics.Bitmap;
import android.graphics.RectF;
import com.github.barteksc.pdfviewer.p143d.C2174b;
import com.github.barteksc.pdfviewer.p146g.C2189a;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.PriorityQueue;

/* renamed from: com.github.barteksc.pdfviewer.b */
class C2156b {

    /* renamed from: a */
    private final PriorityQueue<C2174b> f6698a = new PriorityQueue<>(C2189a.C2190a.f6799a, this.f6702e);

    /* renamed from: b */
    private final PriorityQueue<C2174b> f6699b = new PriorityQueue<>(C2189a.C2190a.f6799a, this.f6702e);

    /* renamed from: c */
    private final List<C2174b> f6700c = new ArrayList();

    /* renamed from: d */
    private final Object f6701d = new Object();

    /* renamed from: e */
    private final C2157a f6702e = new C2157a();

    /* renamed from: com.github.barteksc.pdfviewer.b$a */
    class C2157a implements Comparator<C2174b> {
        C2157a() {
        }

        /* renamed from: a */
        public int compare(C2174b bVar, C2174b bVar2) {
            if (bVar.mo9119a() == bVar2.mo9119a()) {
                return 0;
            }
            return bVar.mo9119a() > bVar2.mo9119a() ? 1 : -1;
        }
    }

    /* renamed from: a */
    private static C2174b m8496a(PriorityQueue<C2174b> priorityQueue, C2174b bVar) {
        Iterator<C2174b> it = priorityQueue.iterator();
        while (it.hasNext()) {
            C2174b next = it.next();
            if (next.equals(bVar)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: a */
    private void m8497a(Collection<C2174b> collection, C2174b bVar) {
        for (C2174b equals : collection) {
            if (equals.equals(bVar)) {
                bVar.mo9122c().recycle();
                return;
            }
        }
        collection.add(bVar);
    }

    /* renamed from: e */
    private void m8498e() {
        synchronized (this.f6701d) {
            while (this.f6699b.size() + this.f6698a.size() >= C2189a.C2190a.f6799a && !this.f6698a.isEmpty()) {
                this.f6698a.poll().mo9122c().recycle();
            }
            while (this.f6699b.size() + this.f6698a.size() >= C2189a.C2190a.f6799a && !this.f6699b.isEmpty()) {
                this.f6699b.poll().mo9122c().recycle();
            }
        }
    }

    /* renamed from: a */
    public void mo9057a() {
        synchronized (this.f6701d) {
            this.f6698a.addAll(this.f6699b);
            this.f6699b.clear();
        }
    }

    /* renamed from: a */
    public void mo9058a(C2174b bVar) {
        synchronized (this.f6701d) {
            m8498e();
            this.f6699b.offer(bVar);
        }
    }

    /* renamed from: a */
    public boolean mo9059a(int i, RectF rectF) {
        C2174b bVar = new C2174b(i, (Bitmap) null, rectF, true, 0);
        synchronized (this.f6700c) {
            for (C2174b equals : this.f6700c) {
                if (equals.equals(bVar)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0031, code lost:
        return r0;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo9060a(int r8, android.graphics.RectF r9, int r10) {
        /*
            r7 = this;
            com.github.barteksc.pdfviewer.d.b r6 = new com.github.barteksc.pdfviewer.d.b
            r2 = 0
            r4 = 0
            r5 = 0
            r0 = r6
            r1 = r8
            r3 = r9
            r0.<init>(r1, r2, r3, r4, r5)
            java.lang.Object r8 = r7.f6701d
            monitor-enter(r8)
            java.util.PriorityQueue<com.github.barteksc.pdfviewer.d.b> r9 = r7.f6698a     // Catch:{ all -> 0x0032 }
            com.github.barteksc.pdfviewer.d.b r9 = m8496a((java.util.PriorityQueue<com.github.barteksc.pdfviewer.p143d.C2174b>) r9, (com.github.barteksc.pdfviewer.p143d.C2174b) r6)     // Catch:{ all -> 0x0032 }
            r0 = 1
            if (r9 == 0) goto L_0x0026
            java.util.PriorityQueue<com.github.barteksc.pdfviewer.d.b> r1 = r7.f6698a     // Catch:{ all -> 0x0032 }
            r1.remove(r9)     // Catch:{ all -> 0x0032 }
            r9.mo9120a(r10)     // Catch:{ all -> 0x0032 }
            java.util.PriorityQueue<com.github.barteksc.pdfviewer.d.b> r10 = r7.f6699b     // Catch:{ all -> 0x0032 }
            r10.offer(r9)     // Catch:{ all -> 0x0032 }
            monitor-exit(r8)     // Catch:{ all -> 0x0032 }
            return r0
        L_0x0026:
            java.util.PriorityQueue<com.github.barteksc.pdfviewer.d.b> r9 = r7.f6699b     // Catch:{ all -> 0x0032 }
            com.github.barteksc.pdfviewer.d.b r9 = m8496a((java.util.PriorityQueue<com.github.barteksc.pdfviewer.p143d.C2174b>) r9, (com.github.barteksc.pdfviewer.p143d.C2174b) r6)     // Catch:{ all -> 0x0032 }
            if (r9 == 0) goto L_0x002f
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            monitor-exit(r8)     // Catch:{ all -> 0x0032 }
            return r0
        L_0x0032:
            r9 = move-exception
            monitor-exit(r8)     // Catch:{ all -> 0x0032 }
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.barteksc.pdfviewer.C2156b.mo9060a(int, android.graphics.RectF, int):boolean");
    }

    /* renamed from: b */
    public List<C2174b> mo9061b() {
        ArrayList arrayList;
        synchronized (this.f6701d) {
            arrayList = new ArrayList(this.f6698a);
            arrayList.addAll(this.f6699b);
        }
        return arrayList;
    }

    /* renamed from: b */
    public void mo9062b(C2174b bVar) {
        synchronized (this.f6700c) {
            while (this.f6700c.size() >= C2189a.C2190a.f6800b) {
                this.f6700c.remove(0).mo9122c().recycle();
            }
            m8497a((Collection<C2174b>) this.f6700c, bVar);
        }
    }

    /* renamed from: c */
    public List<C2174b> mo9063c() {
        List<C2174b> list;
        synchronized (this.f6700c) {
            list = this.f6700c;
        }
        return list;
    }

    /* renamed from: d */
    public void mo9064d() {
        synchronized (this.f6701d) {
            Iterator<C2174b> it = this.f6698a.iterator();
            while (it.hasNext()) {
                it.next().mo9122c().recycle();
            }
            this.f6698a.clear();
            Iterator<C2174b> it2 = this.f6699b.iterator();
            while (it2.hasNext()) {
                it2.next().mo9122c().recycle();
            }
            this.f6699b.clear();
        }
        synchronized (this.f6700c) {
            for (C2174b c : this.f6700c) {
                c.mo9122c().recycle();
            }
            this.f6700c.clear();
        }
    }
}
