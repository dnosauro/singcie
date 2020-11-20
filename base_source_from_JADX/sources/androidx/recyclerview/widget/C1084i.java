package androidx.recyclerview.widget;

import androidx.recyclerview.widget.C1055a;
import java.util.List;

/* renamed from: androidx.recyclerview.widget.i */
class C1084i {

    /* renamed from: a */
    final C1085a f3443a;

    /* renamed from: androidx.recyclerview.widget.i$a */
    interface C1085a {
        /* renamed from: a */
        C1055a.C1057b mo5921a(int i, int i2, int i3, Object obj);

        /* renamed from: a */
        void mo5923a(C1055a.C1057b bVar);
    }

    C1084i(C1085a aVar) {
        this.f3443a = aVar;
    }

    /* renamed from: a */
    private void m4255a(List<C1055a.C1057b> list, int i, int i2) {
        C1055a.C1057b bVar = list.get(i);
        C1055a.C1057b bVar2 = list.get(i2);
        int i3 = bVar2.f3321a;
        if (i3 != 4) {
            switch (i3) {
                case 1:
                    m4257c(list, i, bVar, i2, bVar2);
                    return;
                case 2:
                    mo6033a(list, i, bVar, i2, bVar2);
                    return;
                default:
                    return;
            }
        } else {
            mo6034b(list, i, bVar, i2, bVar2);
        }
    }

    /* renamed from: b */
    private int m4256b(List<C1055a.C1057b> list) {
        boolean z = false;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (list.get(size).f3321a != 8) {
                z = true;
            } else if (z) {
                return size;
            }
        }
        return -1;
    }

    /* renamed from: c */
    private void m4257c(List<C1055a.C1057b> list, int i, C1055a.C1057b bVar, int i2, C1055a.C1057b bVar2) {
        int i3 = bVar.f3324d < bVar2.f3322b ? -1 : 0;
        if (bVar.f3322b < bVar2.f3322b) {
            i3++;
        }
        if (bVar2.f3322b <= bVar.f3322b) {
            bVar.f3322b += bVar2.f3324d;
        }
        if (bVar2.f3322b <= bVar.f3324d) {
            bVar.f3324d += bVar2.f3324d;
        }
        bVar2.f3322b += i3;
        list.set(i, bVar2);
        list.set(i2, bVar);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo6032a(List<C1055a.C1057b> list) {
        while (true) {
            int b = m4256b(list);
            if (b != -1) {
                m4255a(list, b, b + 1);
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:44:0x00c6, code lost:
        if (r11.f3324d > r13.f3322b) goto L_0x00f8;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:56:0x00f6, code lost:
        if (r11.f3324d >= r13.f3322b) goto L_0x00f8;
     */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0036  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x003c  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0068  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x008b  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x0097  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6033a(java.util.List<androidx.recyclerview.widget.C1055a.C1057b> r9, int r10, androidx.recyclerview.widget.C1055a.C1057b r11, int r12, androidx.recyclerview.widget.C1055a.C1057b r13) {
        /*
            r8 = this;
            int r0 = r11.f3322b
            int r1 = r11.f3324d
            r2 = 0
            r3 = 1
            if (r0 >= r1) goto L_0x001b
            int r0 = r13.f3322b
            int r1 = r11.f3322b
            if (r0 != r1) goto L_0x0019
            int r0 = r13.f3324d
            int r1 = r11.f3324d
            int r4 = r11.f3322b
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x0019
            r0 = 0
            goto L_0x002c
        L_0x0019:
            r0 = 0
            goto L_0x002f
        L_0x001b:
            int r0 = r13.f3322b
            int r1 = r11.f3324d
            int r1 = r1 + r3
            if (r0 != r1) goto L_0x002e
            int r0 = r13.f3324d
            int r1 = r11.f3322b
            int r4 = r11.f3324d
            int r1 = r1 - r4
            if (r0 != r1) goto L_0x002e
            r0 = 1
        L_0x002c:
            r2 = 1
            goto L_0x002f
        L_0x002e:
            r0 = 1
        L_0x002f:
            int r1 = r11.f3324d
            int r4 = r13.f3322b
            r5 = 2
            if (r1 >= r4) goto L_0x003c
            int r1 = r13.f3322b
            int r1 = r1 - r3
            r13.f3322b = r1
            goto L_0x005b
        L_0x003c:
            int r1 = r11.f3324d
            int r4 = r13.f3322b
            int r6 = r13.f3324d
            int r4 = r4 + r6
            if (r1 >= r4) goto L_0x005b
            int r10 = r13.f3324d
            int r10 = r10 - r3
            r13.f3324d = r10
            r11.f3321a = r5
            r11.f3324d = r3
            int r10 = r13.f3324d
            if (r10 != 0) goto L_0x005a
            r9.remove(r12)
            androidx.recyclerview.widget.i$a r9 = r8.f3443a
            r9.mo5923a(r13)
        L_0x005a:
            return
        L_0x005b:
            int r1 = r11.f3322b
            int r4 = r13.f3322b
            r6 = 0
            if (r1 > r4) goto L_0x0068
            int r1 = r13.f3322b
            int r1 = r1 + r3
            r13.f3322b = r1
            goto L_0x0089
        L_0x0068:
            int r1 = r11.f3322b
            int r4 = r13.f3322b
            int r7 = r13.f3324d
            int r4 = r4 + r7
            if (r1 >= r4) goto L_0x0089
            int r1 = r13.f3322b
            int r4 = r13.f3324d
            int r1 = r1 + r4
            int r4 = r11.f3322b
            int r1 = r1 - r4
            androidx.recyclerview.widget.i$a r4 = r8.f3443a
            int r7 = r11.f3322b
            int r7 = r7 + r3
            androidx.recyclerview.widget.a$b r6 = r4.mo5921a(r5, r7, r1, r6)
            int r1 = r11.f3322b
            int r3 = r13.f3322b
            int r1 = r1 - r3
            r13.f3324d = r1
        L_0x0089:
            if (r2 == 0) goto L_0x0097
            r9.set(r10, r13)
            r9.remove(r12)
            androidx.recyclerview.widget.i$a r9 = r8.f3443a
            r9.mo5923a(r11)
            return
        L_0x0097:
            if (r0 == 0) goto L_0x00c9
            if (r6 == 0) goto L_0x00b5
            int r0 = r11.f3322b
            int r1 = r6.f3322b
            if (r0 <= r1) goto L_0x00a8
            int r0 = r11.f3322b
            int r1 = r6.f3324d
            int r0 = r0 - r1
            r11.f3322b = r0
        L_0x00a8:
            int r0 = r11.f3324d
            int r1 = r6.f3322b
            if (r0 <= r1) goto L_0x00b5
            int r0 = r11.f3324d
            int r1 = r6.f3324d
            int r0 = r0 - r1
            r11.f3324d = r0
        L_0x00b5:
            int r0 = r11.f3322b
            int r1 = r13.f3322b
            if (r0 <= r1) goto L_0x00c2
            int r0 = r11.f3322b
            int r1 = r13.f3324d
            int r0 = r0 - r1
            r11.f3322b = r0
        L_0x00c2:
            int r0 = r11.f3324d
            int r1 = r13.f3322b
            if (r0 <= r1) goto L_0x00ff
            goto L_0x00f8
        L_0x00c9:
            if (r6 == 0) goto L_0x00e5
            int r0 = r11.f3322b
            int r1 = r6.f3322b
            if (r0 < r1) goto L_0x00d8
            int r0 = r11.f3322b
            int r1 = r6.f3324d
            int r0 = r0 - r1
            r11.f3322b = r0
        L_0x00d8:
            int r0 = r11.f3324d
            int r1 = r6.f3322b
            if (r0 < r1) goto L_0x00e5
            int r0 = r11.f3324d
            int r1 = r6.f3324d
            int r0 = r0 - r1
            r11.f3324d = r0
        L_0x00e5:
            int r0 = r11.f3322b
            int r1 = r13.f3322b
            if (r0 < r1) goto L_0x00f2
            int r0 = r11.f3322b
            int r1 = r13.f3324d
            int r0 = r0 - r1
            r11.f3322b = r0
        L_0x00f2:
            int r0 = r11.f3324d
            int r1 = r13.f3322b
            if (r0 < r1) goto L_0x00ff
        L_0x00f8:
            int r0 = r11.f3324d
            int r1 = r13.f3324d
            int r0 = r0 - r1
            r11.f3324d = r0
        L_0x00ff:
            r9.set(r10, r13)
            int r13 = r11.f3322b
            int r0 = r11.f3324d
            if (r13 == r0) goto L_0x010c
            r9.set(r12, r11)
            goto L_0x010f
        L_0x010c:
            r9.remove(r12)
        L_0x010f:
            if (r6 == 0) goto L_0x0114
            r9.add(r10, r6)
        L_0x0114:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C1084i.mo6033a(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Removed duplicated region for block: B:10:0x0035  */
    /* JADX WARNING: Removed duplicated region for block: B:15:0x005d  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0061  */
    /* JADX WARNING: Removed duplicated region for block: B:18:0x006b  */
    /* JADX WARNING: Removed duplicated region for block: B:20:0x0070  */
    /* JADX WARNING: Removed duplicated region for block: B:22:? A[RETURN, SYNTHETIC] */
    /* JADX WARNING: Removed duplicated region for block: B:9:0x002f  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo6034b(java.util.List<androidx.recyclerview.widget.C1055a.C1057b> r8, int r9, androidx.recyclerview.widget.C1055a.C1057b r10, int r11, androidx.recyclerview.widget.C1055a.C1057b r12) {
        /*
            r7 = this;
            int r0 = r10.f3324d
            int r1 = r12.f3322b
            r2 = 4
            r3 = 0
            r4 = 1
            if (r0 >= r1) goto L_0x000f
            int r0 = r12.f3322b
            int r0 = r0 - r4
            r12.f3322b = r0
            goto L_0x0028
        L_0x000f:
            int r0 = r10.f3324d
            int r1 = r12.f3322b
            int r5 = r12.f3324d
            int r1 = r1 + r5
            if (r0 >= r1) goto L_0x0028
            int r0 = r12.f3324d
            int r0 = r0 - r4
            r12.f3324d = r0
            androidx.recyclerview.widget.i$a r0 = r7.f3443a
            int r1 = r10.f3322b
            java.lang.Object r5 = r12.f3323c
            androidx.recyclerview.widget.a$b r0 = r0.mo5921a(r2, r1, r4, r5)
            goto L_0x0029
        L_0x0028:
            r0 = r3
        L_0x0029:
            int r1 = r10.f3322b
            int r5 = r12.f3322b
            if (r1 > r5) goto L_0x0035
            int r1 = r12.f3322b
            int r1 = r1 + r4
            r12.f3322b = r1
            goto L_0x0056
        L_0x0035:
            int r1 = r10.f3322b
            int r5 = r12.f3322b
            int r6 = r12.f3324d
            int r5 = r5 + r6
            if (r1 >= r5) goto L_0x0056
            int r1 = r12.f3322b
            int r3 = r12.f3324d
            int r1 = r1 + r3
            int r3 = r10.f3322b
            int r1 = r1 - r3
            androidx.recyclerview.widget.i$a r3 = r7.f3443a
            int r5 = r10.f3322b
            int r5 = r5 + r4
            java.lang.Object r4 = r12.f3323c
            androidx.recyclerview.widget.a$b r3 = r3.mo5921a(r2, r5, r1, r4)
            int r2 = r12.f3324d
            int r2 = r2 - r1
            r12.f3324d = r2
        L_0x0056:
            r8.set(r11, r10)
            int r10 = r12.f3324d
            if (r10 <= 0) goto L_0x0061
            r8.set(r9, r12)
            goto L_0x0069
        L_0x0061:
            r8.remove(r9)
            androidx.recyclerview.widget.i$a r10 = r7.f3443a
            r10.mo5923a(r12)
        L_0x0069:
            if (r0 == 0) goto L_0x006e
            r8.add(r9, r0)
        L_0x006e:
            if (r3 == 0) goto L_0x0073
            r8.add(r9, r3)
        L_0x0073:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.recyclerview.widget.C1084i.mo6034b(java.util.List, int, androidx.recyclerview.widget.a$b, int, androidx.recyclerview.widget.a$b):void");
    }
}
