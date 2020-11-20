package androidx.recyclerview.widget;

import androidx.core.p029g.C0584e;
import androidx.recyclerview.widget.C1084i;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.a */
class C1055a implements C1084i.C1085a {

    /* renamed from: a */
    final ArrayList<C1057b> f3313a;

    /* renamed from: b */
    final ArrayList<C1057b> f3314b;

    /* renamed from: c */
    final C1056a f3315c;

    /* renamed from: d */
    Runnable f3316d;

    /* renamed from: e */
    final boolean f3317e;

    /* renamed from: f */
    final C1084i f3318f;

    /* renamed from: g */
    private C0584e.C0585a<C1057b> f3319g;

    /* renamed from: h */
    private int f3320h;

    /* renamed from: androidx.recyclerview.widget.a$a */
    interface C1056a {
        /* renamed from: a */
        RecyclerView.C1045x mo5495a(int i);

        /* renamed from: a */
        void mo5496a(int i, int i2);

        /* renamed from: a */
        void mo5497a(int i, int i2, Object obj);

        /* renamed from: a */
        void mo5498a(C1057b bVar);

        /* renamed from: b */
        void mo5499b(int i, int i2);

        /* renamed from: b */
        void mo5500b(C1057b bVar);

        /* renamed from: c */
        void mo5501c(int i, int i2);

        /* renamed from: d */
        void mo5503d(int i, int i2);
    }

    /* renamed from: androidx.recyclerview.widget.a$b */
    static class C1057b {

        /* renamed from: a */
        int f3321a;

        /* renamed from: b */
        int f3322b;

        /* renamed from: c */
        Object f3323c;

        /* renamed from: d */
        int f3324d;

        C1057b(int i, int i2, int i3, Object obj) {
            this.f3321a = i;
            this.f3322b = i2;
            this.f3324d = i3;
            this.f3323c = obj;
        }

        /* access modifiers changed from: package-private */
        /* renamed from: a */
        public String mo5938a() {
            int i = this.f3321a;
            if (i == 4) {
                return "up";
            }
            if (i == 8) {
                return "mv";
            }
            switch (i) {
                case 1:
                    return "add";
                case 2:
                    return "rm";
                default:
                    return "??";
            }
        }

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            C1057b bVar = (C1057b) obj;
            int i = this.f3321a;
            if (i != bVar.f3321a) {
                return false;
            }
            if (i == 8 && Math.abs(this.f3324d - this.f3322b) == 1 && this.f3324d == bVar.f3322b && this.f3322b == bVar.f3324d) {
                return true;
            }
            if (this.f3324d != bVar.f3324d || this.f3322b != bVar.f3322b) {
                return false;
            }
            Object obj2 = this.f3323c;
            if (obj2 != null) {
                if (!obj2.equals(bVar.f3323c)) {
                    return false;
                }
            } else if (bVar.f3323c != null) {
                return false;
            }
            return true;
        }

        public int hashCode() {
            return (((this.f3321a * 31) + this.f3322b) * 31) + this.f3324d;
        }

        public String toString() {
            return Integer.toHexString(System.identityHashCode(this)) + "[" + mo5938a() + ",s:" + this.f3322b + "c:" + this.f3324d + ",p:" + this.f3323c + "]";
        }
    }

    C1055a(C1056a aVar) {
        this(aVar, false);
    }

    C1055a(C1056a aVar, boolean z) {
        this.f3319g = new C0584e.C0586b(30);
        this.f3313a = new ArrayList<>();
        this.f3314b = new ArrayList<>();
        this.f3320h = 0;
        this.f3315c = aVar;
        this.f3317e = z;
        this.f3318f = new C1084i(this);
    }

    /* renamed from: b */
    private void m4111b(C1057b bVar) {
        m4118g(bVar);
    }

    /* renamed from: c */
    private void m4112c(C1057b bVar) {
        char c;
        boolean z;
        boolean z2;
        int i = bVar.f3322b;
        int i2 = bVar.f3322b + bVar.f3324d;
        int i3 = bVar.f3322b;
        int i4 = 0;
        char c2 = 65535;
        while (i3 < i2) {
            if (this.f3315c.mo5495a(i3) != null || m4115d(i3)) {
                if (c2 == 0) {
                    m4116e(mo5921a(2, i, i4, (Object) null));
                    z2 = true;
                } else {
                    z2 = false;
                }
                c = 1;
            } else {
                if (c2 == 1) {
                    m4118g(mo5921a(2, i, i4, (Object) null));
                    z = true;
                } else {
                    z = false;
                }
                c = 0;
            }
            if (z) {
                i3 -= i4;
                i2 -= i4;
                i4 = 1;
            } else {
                i4++;
            }
            i3++;
            c2 = c;
        }
        if (i4 != bVar.f3324d) {
            mo5923a(bVar);
            bVar = mo5921a(2, i, i4, (Object) null);
        }
        if (c2 == 0) {
            m4116e(bVar);
        } else {
            m4118g(bVar);
        }
    }

    /* renamed from: d */
    private int m4113d(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        for (int size = this.f3314b.size() - 1; size >= 0; size--) {
            C1057b bVar = this.f3314b.get(size);
            if (bVar.f3321a == 8) {
                if (bVar.f3322b < bVar.f3324d) {
                    i5 = bVar.f3322b;
                    i4 = bVar.f3324d;
                } else {
                    i5 = bVar.f3324d;
                    i4 = bVar.f3322b;
                }
                if (i < i5 || i > i4) {
                    if (i < bVar.f3322b) {
                        if (i2 == 1) {
                            bVar.f3322b++;
                            i6 = bVar.f3324d + 1;
                        } else if (i2 == 2) {
                            bVar.f3322b--;
                            i6 = bVar.f3324d - 1;
                        }
                        bVar.f3324d = i6;
                    }
                } else if (i5 == bVar.f3322b) {
                    if (i2 == 1) {
                        i8 = bVar.f3324d + 1;
                    } else {
                        if (i2 == 2) {
                            i8 = bVar.f3324d - 1;
                        }
                        i++;
                    }
                    bVar.f3324d = i8;
                    i++;
                } else {
                    if (i2 == 1) {
                        i7 = bVar.f3322b + 1;
                    } else {
                        if (i2 == 2) {
                            i7 = bVar.f3322b - 1;
                        }
                        i--;
                    }
                    bVar.f3322b = i7;
                    i--;
                }
            } else if (bVar.f3322b > i) {
                if (i2 == 1) {
                    i3 = bVar.f3322b + 1;
                } else if (i2 == 2) {
                    i3 = bVar.f3322b - 1;
                }
                bVar.f3322b = i3;
            } else if (bVar.f3321a == 1) {
                i -= bVar.f3324d;
            } else if (bVar.f3321a == 2) {
                i += bVar.f3324d;
            }
        }
        for (int size2 = this.f3314b.size() - 1; size2 >= 0; size2--) {
            C1057b bVar2 = this.f3314b.get(size2);
            if (bVar2.f3321a == 8) {
                if (bVar2.f3324d != bVar2.f3322b && bVar2.f3324d >= 0) {
                }
            } else if (bVar2.f3324d > 0) {
            }
            this.f3314b.remove(size2);
            mo5923a(bVar2);
        }
        return i;
    }

    /* renamed from: d */
    private void m4114d(C1057b bVar) {
        int i = bVar.f3322b;
        int i2 = bVar.f3322b + bVar.f3324d;
        int i3 = i;
        int i4 = 0;
        char c = 65535;
        for (int i5 = bVar.f3322b; i5 < i2; i5++) {
            if (this.f3315c.mo5495a(i5) != null || m4115d(i5)) {
                if (c == 0) {
                    m4116e(mo5921a(4, i3, i4, bVar.f3323c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 1;
            } else {
                if (c == 1) {
                    m4118g(mo5921a(4, i3, i4, bVar.f3323c));
                    i3 = i5;
                    i4 = 0;
                }
                c = 0;
            }
            i4++;
        }
        if (i4 != bVar.f3324d) {
            Object obj = bVar.f3323c;
            mo5923a(bVar);
            bVar = mo5921a(4, i3, i4, obj);
        }
        if (c == 0) {
            m4116e(bVar);
        } else {
            m4118g(bVar);
        }
    }

    /* renamed from: d */
    private boolean m4115d(int i) {
        int size = this.f3314b.size();
        for (int i2 = 0; i2 < size; i2++) {
            C1057b bVar = this.f3314b.get(i2);
            if (bVar.f3321a == 8) {
                if (mo5920a(bVar.f3324d, i2 + 1) == i) {
                    return true;
                }
            } else if (bVar.f3321a == 1) {
                int i3 = bVar.f3322b + bVar.f3324d;
                for (int i4 = bVar.f3322b; i4 < i3; i4++) {
                    if (mo5920a(i4, i2 + 1) == i) {
                        return true;
                    }
                }
                continue;
            } else {
                continue;
            }
        }
        return false;
    }

    /* renamed from: e */
    private void m4116e(C1057b bVar) {
        int i;
        if (bVar.f3321a == 1 || bVar.f3321a == 8) {
            throw new IllegalArgumentException("should not dispatch add or move for pre layout");
        }
        int d = m4113d(bVar.f3322b, bVar.f3321a);
        int i2 = bVar.f3322b;
        int i3 = bVar.f3321a;
        if (i3 == 2) {
            i = 0;
        } else if (i3 == 4) {
            i = 1;
        } else {
            throw new IllegalArgumentException("op should be remove or update." + bVar);
        }
        int i4 = d;
        int i5 = i2;
        int i6 = 1;
        for (int i7 = 1; i7 < bVar.f3324d; i7++) {
            int d2 = m4113d(bVar.f3322b + (i * i7), bVar.f3321a);
            int i8 = bVar.f3321a;
            if (i8 == 2 ? d2 == i4 : i8 == 4 && d2 == i4 + 1) {
                i6++;
            } else {
                C1057b a = mo5921a(bVar.f3321a, i4, i6, bVar.f3323c);
                mo5924a(a, i5);
                mo5923a(a);
                if (bVar.f3321a == 4) {
                    i5 += i6;
                }
                i4 = d2;
                i6 = 1;
            }
        }
        Object obj = bVar.f3323c;
        mo5923a(bVar);
        if (i6 > 0) {
            C1057b a2 = mo5921a(bVar.f3321a, i4, i6, obj);
            mo5924a(a2, i5);
            mo5923a(a2);
        }
    }

    /* renamed from: f */
    private void m4117f(C1057b bVar) {
        m4118g(bVar);
    }

    /* renamed from: g */
    private void m4118g(C1057b bVar) {
        this.f3314b.add(bVar);
        int i = bVar.f3321a;
        if (i == 4) {
            this.f3315c.mo5497a(bVar.f3322b, bVar.f3324d, bVar.f3323c);
        } else if (i != 8) {
            switch (i) {
                case 1:
                    this.f3315c.mo5501c(bVar.f3322b, bVar.f3324d);
                    return;
                case 2:
                    this.f3315c.mo5499b(bVar.f3322b, bVar.f3324d);
                    return;
                default:
                    throw new IllegalArgumentException("Unknown update op type for " + bVar);
            }
        } else {
            this.f3315c.mo5503d(bVar.f3322b, bVar.f3324d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo5920a(int i, int i2) {
        int size = this.f3314b.size();
        while (i2 < size) {
            C1057b bVar = this.f3314b.get(i2);
            if (bVar.f3321a == 8) {
                if (bVar.f3322b == i) {
                    i = bVar.f3324d;
                } else {
                    if (bVar.f3322b < i) {
                        i--;
                    }
                    if (bVar.f3324d <= i) {
                        i++;
                    }
                }
            } else if (bVar.f3322b > i) {
                continue;
            } else if (bVar.f3321a == 2) {
                if (i < bVar.f3322b + bVar.f3324d) {
                    return -1;
                }
                i -= bVar.f3324d;
            } else if (bVar.f3321a == 1) {
                i += bVar.f3324d;
            }
            i2++;
        }
        return i;
    }

    /* renamed from: a */
    public C1057b mo5921a(int i, int i2, int i3, Object obj) {
        C1057b a = this.f3319g.mo3611a();
        if (a == null) {
            return new C1057b(i, i2, i3, obj);
        }
        a.f3321a = i;
        a.f3322b = i2;
        a.f3324d = i3;
        a.f3323c = obj;
        return a;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5922a() {
        mo5925a((List<C1057b>) this.f3313a);
        mo5925a((List<C1057b>) this.f3314b);
        this.f3320h = 0;
    }

    /* renamed from: a */
    public void mo5923a(C1057b bVar) {
        if (!this.f3317e) {
            bVar.f3323c = null;
            this.f3319g.mo3612a(bVar);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5924a(C1057b bVar, int i) {
        this.f3315c.mo5498a(bVar);
        int i2 = bVar.f3321a;
        if (i2 == 2) {
            this.f3315c.mo5496a(i, bVar.f3324d);
        } else if (i2 == 4) {
            this.f3315c.mo5497a(i, bVar.f3324d, bVar.f3323c);
        } else {
            throw new IllegalArgumentException("only remove and update ops can be dispatched in first pass");
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo5925a(List<C1057b> list) {
        int size = list.size();
        for (int i = 0; i < size; i++) {
            mo5923a(list.get(i));
        }
        list.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5926a(int i) {
        return (i & this.f3320h) != 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5927a(int i, int i2, int i3) {
        if (i == i2) {
            return false;
        }
        if (i3 == 1) {
            this.f3313a.add(mo5921a(8, i, i2, (Object) null));
            this.f3320h |= 8;
            return this.f3313a.size() == 1;
        }
        throw new IllegalArgumentException("Moving more than 1 item is not supported yet");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo5928a(int i, int i2, Object obj) {
        if (i2 < 1) {
            return false;
        }
        this.f3313a.add(mo5921a(4, i, i2, obj));
        this.f3320h |= 4;
        return this.f3313a.size() == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public int mo5929b(int i) {
        return mo5920a(i, 0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo5930b() {
        this.f3318f.mo6032a(this.f3313a);
        int size = this.f3313a.size();
        for (int i = 0; i < size; i++) {
            C1057b bVar = this.f3313a.get(i);
            int i2 = bVar.f3321a;
            if (i2 == 4) {
                m4114d(bVar);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        m4117f(bVar);
                        break;
                    case 2:
                        m4112c(bVar);
                        break;
                }
            } else {
                m4111b(bVar);
            }
            Runnable runnable = this.f3316d;
            if (runnable != null) {
                runnable.run();
            }
        }
        this.f3313a.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo5931b(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f3313a.add(mo5921a(1, i, i2, (Object) null));
        this.f3320h |= 1;
        return this.f3313a.size() == 1;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:34:0x0047, code lost:
        continue;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public int mo5932c(int r6) {
        /*
            r5 = this;
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r0 = r5.f3313a
            int r0 = r0.size()
            r1 = 0
        L_0x0007:
            if (r1 >= r0) goto L_0x004a
            java.util.ArrayList<androidx.recyclerview.widget.a$b> r2 = r5.f3313a
            java.lang.Object r2 = r2.get(r1)
            androidx.recyclerview.widget.a$b r2 = (androidx.recyclerview.widget.C1055a.C1057b) r2
            int r3 = r2.f3321a
            r4 = 8
            if (r3 == r4) goto L_0x0034
            switch(r3) {
                case 1: goto L_0x002c;
                case 2: goto L_0x001b;
                default: goto L_0x001a;
            }
        L_0x001a:
            goto L_0x0047
        L_0x001b:
            int r3 = r2.f3322b
            if (r3 > r6) goto L_0x0047
            int r3 = r2.f3322b
            int r4 = r2.f3324d
            int r3 = r3 + r4
            if (r3 <= r6) goto L_0x0028
            r6 = -1
            return r6
        L_0x0028:
            int r2 = r2.f3324d
            int r6 = r6 - r2
            goto L_0x0047
        L_0x002c:
            int r3 = r2.f3322b
            if (r3 > r6) goto L_0x0047
            int r2 = r2.f3324d
            int r6 = r6 + r2
            goto L_0x0047
        L_0x0034:
            int r3 = r2.f3322b
            if (r3 != r6) goto L_0x003b
            int r6 = r2.f3324d
            goto L_0x0047
        L_0x003b:
            int r3 = r2.f3322b
            if (r3 >= r6) goto L_0x0041
            int r6 = r6 + -1
        L_0x0041:
            int r2 = r2.f3324d
            if (r2 > r6) goto L_0x0047
            int r6 = r6 + 1
        L_0x0047:
            int r1 = r1 + 1
            goto L_0x0007
        L_0x004a:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C1055a.mo5932c(int):int");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo5933c() {
        int size = this.f3314b.size();
        for (int i = 0; i < size; i++) {
            this.f3315c.mo5500b(this.f3314b.get(i));
        }
        mo5925a((List<C1057b>) this.f3314b);
        this.f3320h = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public boolean mo5934c(int i, int i2) {
        if (i2 < 1) {
            return false;
        }
        this.f3313a.add(mo5921a(2, i, i2, (Object) null));
        this.f3320h |= 2;
        return this.f3313a.size() == 1;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo5935d() {
        return this.f3313a.size() > 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo5936e() {
        mo5933c();
        int size = this.f3313a.size();
        for (int i = 0; i < size; i++) {
            C1057b bVar = this.f3313a.get(i);
            int i2 = bVar.f3321a;
            if (i2 == 4) {
                this.f3315c.mo5500b(bVar);
                this.f3315c.mo5497a(bVar.f3322b, bVar.f3324d, bVar.f3323c);
            } else if (i2 != 8) {
                switch (i2) {
                    case 1:
                        this.f3315c.mo5500b(bVar);
                        this.f3315c.mo5501c(bVar.f3322b, bVar.f3324d);
                        break;
                    case 2:
                        this.f3315c.mo5500b(bVar);
                        this.f3315c.mo5496a(bVar.f3322b, bVar.f3324d);
                        break;
                }
            } else {
                this.f3315c.mo5500b(bVar);
                this.f3315c.mo5503d(bVar.f3322b, bVar.f3324d);
            }
            Runnable runnable = this.f3316d;
            if (runnable != null) {
                runnable.run();
            }
        }
        mo5925a((List<C1057b>) this.f3313a);
        this.f3320h = 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo5937f() {
        return !this.f3314b.isEmpty() && !this.f3313a.isEmpty();
    }
}
