package com.cyberneid.p089b.p091b;

import com.parse.ParseException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.cyberneid.b.b.v */
public class C1527v {

    /* renamed from: a */
    private final String f4528a;

    /* renamed from: b */
    private final String f4529b;

    public C1527v(String str, String str2) {
        this.f4528a = str;
        this.f4529b = str2;
    }

    /* renamed from: a */
    private C1519p m5847a(C1522r rVar, int i) {
        return i == 12 ? new C1519p(i, rVar.mo7124h()) : new C1519p(i);
    }

    /* renamed from: a */
    private Integer m5848a(List<Object> list) {
        Object remove = list.remove(list.size() - 1);
        if (remove instanceof Integer) {
            return (Integer) remove;
        }
        C1519p pVar = (C1519p) remove;
        if (pVar.mo7108a().mo7112a()[0] == 12 && pVar.mo7108a().mo7112a()[1] == 12) {
            return Integer.valueOf(((Integer) list.remove(list.size() - 1)).intValue() / ((Integer) list.remove(list.size() - 1)).intValue());
        }
        throw new IOException("Unexpected char string command: " + pVar.mo7108a());
    }

    /* JADX WARNING: Removed duplicated region for block: B:36:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:37:0x0107  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private java.util.List<java.lang.Object> m5849a(byte[] r9, java.util.List<byte[]> r10, java.util.List<java.lang.Object> r11) {
        /*
            r8 = this;
            com.cyberneid.b.b.r r0 = new com.cyberneid.b.b.r
            r0.<init>(r9)
        L_0x0005:
            boolean r9 = r0.mo7121e()
            if (r9 == 0) goto L_0x0153
            int r9 = r0.mo7124h()
            r1 = 10
            r2 = 0
            r3 = 1
            if (r9 != r1) goto L_0x0063
            int r9 = r11.size()
            int r9 = r9 - r3
            java.lang.Object r9 = r11.remove(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r1 = r9.intValue()
            if (r1 < 0) goto L_0x0005
            int r1 = r9.intValue()
            int r4 = r10.size()
            if (r1 >= r4) goto L_0x0005
            int r9 = r9.intValue()
            java.lang.Object r9 = r10.get(r9)
            byte[] r9 = (byte[]) r9
            r8.m5849a(r9, r10, r11)
            int r9 = r11.size()
            int r9 = r9 - r3
            java.lang.Object r9 = r11.get(r9)
            boolean r1 = r9 instanceof com.cyberneid.p089b.p091b.C1519p
            if (r1 == 0) goto L_0x0005
            com.cyberneid.b.b.p r9 = (com.cyberneid.p089b.p091b.C1519p) r9
            com.cyberneid.b.b.p$a r9 = r9.mo7108a()
            int[] r9 = r9.mo7112a()
            r9 = r9[r2]
            r1 = 11
            if (r9 != r1) goto L_0x0005
            int r9 = r11.size()
            int r9 = r9 - r3
            r11.remove(r9)
            goto L_0x0005
        L_0x0063:
            r1 = 12
            if (r9 != r1) goto L_0x0131
            int r4 = r0.mo7119c(r2)
            r5 = 16
            if (r4 != r5) goto L_0x0131
            r0.mo7123g()
            int r9 = r11.size()
            int r9 = r9 - r3
            java.lang.Object r9 = r11.remove(r9)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r4 = r11.size()
            int r4 = r4 - r3
            java.lang.Object r4 = r11.remove(r4)
            java.lang.Integer r4 = (java.lang.Integer) r4
            java.util.Stack r6 = new java.util.Stack
            r6.<init>()
            int r7 = r9.intValue()
            if (r7 != 0) goto L_0x00b9
            java.lang.Integer r9 = r8.m5848a(r11)
            r6.push(r9)
            java.lang.Integer r9 = r8.m5848a(r11)
            r6.push(r9)
            int r9 = r11.size()
            int r9 = r9 - r3
            r11.remove(r9)
            java.lang.Integer r9 = java.lang.Integer.valueOf(r2)
            r11.add(r9)
            com.cyberneid.b.b.p r9 = new com.cyberneid.b.b.p
            r9.<init>(r1, r5)
        L_0x00b5:
            r11.add(r9)
            goto L_0x00ec
        L_0x00b9:
            int r7 = r9.intValue()
            if (r7 != r3) goto L_0x00cc
            java.lang.Integer r9 = java.lang.Integer.valueOf(r3)
            r11.add(r9)
            com.cyberneid.b.b.p r9 = new com.cyberneid.b.b.p
            r9.<init>(r1, r5)
            goto L_0x00b5
        L_0x00cc:
            int r9 = r9.intValue()
            r5 = 3
            if (r9 != r5) goto L_0x00db
            java.lang.Integer r9 = r8.m5848a(r11)
            r6.push(r9)
            goto L_0x00ec
        L_0x00db:
            r9 = 0
        L_0x00dc:
            int r5 = r4.intValue()
            if (r9 >= r5) goto L_0x00ec
            java.lang.Integer r5 = r8.m5848a(r11)
            r6.push(r5)
            int r9 = r9 + 1
            goto L_0x00dc
        L_0x00ec:
            int r9 = r0.mo7119c(r2)
            if (r9 != r1) goto L_0x0107
            int r9 = r0.mo7119c(r3)
            r4 = 17
            if (r9 != r4) goto L_0x0107
            r0.mo7123g()
            r0.mo7123g()
            java.lang.Object r9 = r6.pop()
            java.lang.Integer r9 = (java.lang.Integer) r9
            goto L_0x00b5
        L_0x0107:
            int r9 = r6.size()
            if (r9 <= 0) goto L_0x0005
            java.lang.String r9 = "PdfBox-Android"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Value left on the PostScript stack in glyph "
            r1.append(r2)
            java.lang.String r2 = r8.f4529b
            r1.append(r2)
            java.lang.String r2 = " of font "
            r1.append(r2)
            java.lang.String r2 = r8.f4528a
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r9, r1)
            goto L_0x0005
        L_0x0131:
            if (r9 < 0) goto L_0x0140
            r1 = 31
            if (r9 > r1) goto L_0x0140
            com.cyberneid.b.b.p r9 = r8.m5847a((com.cyberneid.p089b.p091b.C1522r) r0, (int) r9)
        L_0x013b:
            r11.add(r9)
            goto L_0x0005
        L_0x0140:
            r1 = 32
            if (r9 < r1) goto L_0x014d
            r1 = 255(0xff, float:3.57E-43)
            if (r9 > r1) goto L_0x014d
            java.lang.Integer r9 = r8.m5850b(r0, r9)
            goto L_0x013b
        L_0x014d:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            r9.<init>()
            throw r9
        L_0x0153:
            return r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p089b.p091b.C1527v.m5849a(byte[], java.util.List, java.util.List):java.util.List");
    }

    /* renamed from: b */
    private Integer m5850b(C1522r rVar, int i) {
        if (i >= 32 && i <= 246) {
            return Integer.valueOf(i - 139);
        }
        if (i >= 247 && i <= 250) {
            return Integer.valueOf(((i - 247) * 256) + rVar.mo7124h() + 108);
        } else if (i >= 251 && i <= 254) {
            return Integer.valueOf((((-(i - ParseException.INVALID_LINKED_SESSION)) * 256) - rVar.mo7124h()) - 108);
        } else if (i == 255) {
            return Integer.valueOf(rVar.mo7124h() | (rVar.mo7124h() << 24) | (rVar.mo7124h() << 16) | (rVar.mo7124h() << 8));
        } else {
            throw new IllegalArgumentException();
        }
    }

    /* renamed from: a */
    public List<Object> mo7138a(byte[] bArr, List<byte[]> list) {
        return m5849a(bArr, list, new ArrayList());
    }
}
