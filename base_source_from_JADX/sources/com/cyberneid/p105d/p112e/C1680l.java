package com.cyberneid.p105d.p112e;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1617m;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cyberneid.d.e.l */
public class C1680l {

    /* renamed from: a */
    private final Map<Long, C1683b> f5562a = new HashMap();

    /* renamed from: b */
    private C1683b f5563b = null;

    /* renamed from: c */
    private C1683b f5564c = null;

    /* renamed from: com.cyberneid.d.e.l$a */
    public enum C1682a {
        TABLE,
        STREAM
    }

    /* renamed from: com.cyberneid.d.e.l$b */
    private class C1683b {

        /* renamed from: a */
        protected C1607d f5568a;
        /* access modifiers changed from: private */

        /* renamed from: c */
        public C1682a f5570c;
        /* access modifiers changed from: private */

        /* renamed from: d */
        public final Map<C1617m, Long> f5571d;

        private C1683b() {
            this.f5568a = null;
            this.f5571d = new HashMap();
            this.f5570c = C1682a.TABLE;
        }
    }

    /* renamed from: a */
    public C1682a mo7807a() {
        C1683b bVar = this.f5564c;
        if (bVar == null) {
            return null;
        }
        return bVar.f5570c;
    }

    /* renamed from: a */
    public Set<Long> mo7808a(int i) {
        if (this.f5564c == null) {
            return null;
        }
        HashSet hashSet = new HashSet();
        long j = (long) (-i);
        for (Map.Entry entry : this.f5564c.f5571d.entrySet()) {
            if (((Long) entry.getValue()).longValue() == j) {
                hashSet.add(Long.valueOf(((C1617m) entry.getKey()).mo7613b()));
            }
        }
        return hashSet;
    }

    /* renamed from: a */
    public void mo7809a(long j) {
        if (this.f5564c != null) {
            Log.w("PdfBox-Android", "Method must be called only ones with last startxref value.");
            return;
        }
        this.f5564c = new C1683b();
        this.f5564c.f5568a = new C1607d();
        C1683b bVar = this.f5562a.get(Long.valueOf(j));
        ArrayList<Long> arrayList = new ArrayList<>();
        if (bVar == null) {
            Log.w("PdfBox-Android", "Did not found XRef object at specified startxref position " + j);
            arrayList.addAll(this.f5562a.keySet());
            Collections.sort(arrayList);
        } else {
            C1682a unused = this.f5564c.f5570c = bVar.f5570c;
            arrayList.add(Long.valueOf(j));
            while (true) {
                if (bVar.f5568a == null) {
                    break;
                }
                long b = bVar.f5568a.mo7531b(C1613i.f5190fG, -1);
                if (b == -1) {
                    break;
                }
                bVar = this.f5562a.get(Long.valueOf(b));
                if (bVar != null) {
                    arrayList.add(Long.valueOf(b));
                    if (arrayList.size() >= this.f5562a.size()) {
                        break;
                    }
                } else {
                    Log.w("PdfBox-Android", "Did not found XRef object pointed to by 'Prev' key at position " + b);
                    break;
                }
            }
            Collections.reverse(arrayList);
        }
        for (Long l : arrayList) {
            C1683b bVar2 = this.f5562a.get(l);
            if (bVar2.f5568a != null) {
                this.f5564c.f5568a.mo7516a(bVar2.f5568a);
            }
            this.f5564c.f5571d.putAll(bVar2.f5571d);
        }
    }

    /* renamed from: a */
    public void mo7810a(long j, C1682a aVar) {
        Map<Long, C1683b> map = this.f5562a;
        Long valueOf = Long.valueOf(j);
        C1683b bVar = new C1683b();
        this.f5563b = bVar;
        map.put(valueOf, bVar);
        C1682a unused = this.f5563b.f5570c = aVar;
    }

    /* renamed from: a */
    public void mo7811a(C1607d dVar) {
        C1683b bVar = this.f5563b;
        if (bVar == null) {
            Log.w("PdfBox-Android", "Cannot add trailer because XRef start was not signalled.");
        } else {
            bVar.f5568a = dVar;
        }
    }

    /* renamed from: a */
    public void mo7812a(C1617m mVar, long j) {
        C1683b bVar = this.f5563b;
        if (bVar == null) {
            Log.w("PdfBox-Android", "Cannot add XRef entry for '" + mVar.mo7613b() + "' because XRef start was not signalled.");
            return;
        }
        bVar.f5571d.put(mVar, Long.valueOf(j));
    }

    /* renamed from: b */
    public C1607d mo7813b() {
        return this.f5563b.f5568a;
    }

    /* renamed from: c */
    public C1607d mo7814c() {
        C1683b bVar = this.f5564c;
        if (bVar == null) {
            return null;
        }
        return bVar.f5568a;
    }

    /* renamed from: d */
    public Map<C1617m, Long> mo7815d() {
        C1683b bVar = this.f5564c;
        if (bVar == null) {
            return null;
        }
        return bVar.f5571d;
    }
}
