package com.cyberneid.p105d.p109c;

import android.util.Log;
import com.cyberneid.p099c.p102b.p103a.p104a.C1599e;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1613i;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.EOFException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* renamed from: com.cyberneid.d.c.m */
public class C1651m extends C1647i {
    /* renamed from: a */
    private int m6609a(int i, int i2) {
        if (i >= 2048 - i2) {
            return 12;
        }
        if (i >= 1024 - i2) {
            return 11;
        }
        return i >= 512 - i2 ? 10 : 9;
    }

    /* renamed from: a */
    private int m6610a(List<byte[]> list, byte[] bArr) {
        int i = -1;
        int i2 = 0;
        for (int size = list.size() - 1; size >= 0; size--) {
            if (((long) size) <= 257) {
                if (i != -1) {
                    return i;
                }
                if (bArr.length > 1) {
                    return -1;
                }
            }
            byte[] bArr2 = list.get(size);
            if ((i != -1 || bArr2.length > i2) && Arrays.equals(bArr2, bArr)) {
                i2 = bArr2.length;
                i = size;
            }
        }
        return i;
    }

    /* renamed from: a */
    private List<byte[]> m6611a() {
        ArrayList arrayList = new ArrayList(4096);
        for (int i = 0; i < 256; i++) {
            arrayList.add(new byte[]{(byte) (i & 255)});
        }
        arrayList.add((Object) null);
        arrayList.add((Object) null);
        return arrayList;
    }

    /* renamed from: a */
    private void m6612a(InputStream inputStream, OutputStream outputStream, int i) {
        byte[] copyOf;
        ArrayList arrayList = new ArrayList();
        C1599e eVar = new C1599e(inputStream);
        List<byte[]> list = arrayList;
        loop0:
        while (true) {
            long j = -1;
            int i2 = 9;
            while (true) {
                try {
                    long a = eVar.mo7419a(i2);
                    if (a == 257) {
                        break loop0;
                    } else if (a == 256) {
                        break;
                    } else {
                        if (a < ((long) list.size())) {
                            byte[] bArr = list.get((int) a);
                            byte b = bArr[0];
                            outputStream.write(bArr);
                            if (j != -1) {
                                byte[] bArr2 = list.get((int) j);
                                copyOf = Arrays.copyOf(bArr2, bArr2.length + 1);
                                copyOf[bArr2.length] = b;
                            }
                            i2 = m6609a(list.size(), i);
                            j = a;
                        } else {
                            byte[] bArr3 = list.get((int) j);
                            copyOf = Arrays.copyOf(bArr3, bArr3.length + 1);
                            copyOf[bArr3.length] = bArr3[0];
                            outputStream.write(copyOf);
                        }
                        list.add(copyOf);
                        i2 = m6609a(list.size(), i);
                        j = a;
                    }
                } catch (EOFException unused) {
                    Log.w("PdfBox-Android", "Premature EOF in LZW stream, EOD code missing");
                }
            }
            list = m6611a();
        }
        outputStream.flush();
    }

    /* renamed from: a */
    public C1646h mo7657a(InputStream inputStream, OutputStream outputStream, C1607d dVar, int i) {
        int i2;
        int i3;
        C1607d a = m6599a(dVar, i);
        if (a != null) {
            int g = a.mo7547g(C1613i.f5189fF);
            int b = a.mo7529b(C1613i.f4993bV, 1);
            if (b == 0 || b == 1) {
                int i4 = b;
                i2 = g;
                i3 = i4;
            } else {
                i2 = g;
                i3 = 1;
            }
        } else {
            i3 = 1;
            i2 = -1;
        }
        if (i2 > 1) {
            int min = Math.min(a.mo7529b(C1613i.f4928aJ, 1), 32);
            int b2 = a.mo7529b(C1613i.f4907P, 8);
            int b3 = a.mo7529b(C1613i.f4930aL, 1);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            m6612a(inputStream, (OutputStream) byteArrayOutputStream, i3);
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(byteArrayOutputStream.toByteArray());
            C1652n.m6615a(i2, min, b2, b3, byteArrayInputStream, outputStream);
            outputStream.flush();
            byteArrayOutputStream.reset();
            byteArrayInputStream.reset();
        } else {
            m6612a(inputStream, outputStream, i3);
        }
        return new C1646h(dVar);
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v2, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v3, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v5, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v6, resolved type: byte} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v10, resolved type: byte} */
    /* access modifiers changed from: protected */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7658a(java.io.InputStream r13, java.io.OutputStream r14, com.cyberneid.p105d.p108b.C1607d r15) {
        /*
            r12 = this;
            java.util.List r15 = r12.m6611a()
            com.cyberneid.c.b.a.a.f r0 = new com.cyberneid.c.b.a.a.f
            r0.<init>(r14)
            r1 = 256(0x100, double:1.265E-321)
            r14 = 9
            r0.mo7451a(r1, r14)
            r14 = -1
            r3 = 0
            r4 = r15
            r15 = -1
        L_0x0014:
            int r5 = r13.read()
            r6 = 1
            if (r5 == r14) goto L_0x005f
            byte r5 = (byte) r5
            r7 = 0
            if (r3 != 0) goto L_0x0029
            byte[] r15 = new byte[r6]
            r15[r7] = r5
        L_0x0023:
            r3 = r5 & 255(0xff, float:3.57E-43)
            r11 = r3
            r3 = r15
            r15 = r11
            goto L_0x0014
        L_0x0029:
            int r8 = r3.length
            int r8 = r8 + r6
            byte[] r3 = java.util.Arrays.copyOf(r3, r8)
            int r8 = r3.length
            int r8 = r8 - r6
            r3[r8] = r5
            int r8 = r12.m6610a((java.util.List<byte[]>) r4, (byte[]) r3)
            if (r8 != r14) goto L_0x005d
            int r8 = r4.size()
            int r8 = r8 - r6
            int r8 = r12.m6609a((int) r8, (int) r6)
            long r9 = (long) r15
            r0.mo7451a(r9, r8)
            r4.add(r3)
            int r15 = r4.size()
            r3 = 4096(0x1000, float:5.74E-42)
            if (r15 != r3) goto L_0x0058
            r0.mo7451a(r1, r8)
            java.util.List r4 = r12.m6611a()
        L_0x0058:
            byte[] r15 = new byte[r6]
            r15[r7] = r5
            goto L_0x0023
        L_0x005d:
            r15 = r8
            goto L_0x0014
        L_0x005f:
            if (r15 == r14) goto L_0x006e
            int r13 = r4.size()
            int r13 = r13 - r6
            int r13 = r12.m6609a((int) r13, (int) r6)
            long r14 = (long) r15
            r0.mo7451a(r14, r13)
        L_0x006e:
            int r13 = r4.size()
            int r13 = r12.m6609a((int) r13, (int) r6)
            r14 = 257(0x101, double:1.27E-321)
            r0.mo7451a(r14, r13)
            r13 = 0
            r15 = 7
            r0.mo7451a(r13, r15)
            r0.mo7434i()
            r0.mo7420a()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p109c.C1651m.mo7658a(java.io.InputStream, java.io.OutputStream, com.cyberneid.d.b.d):void");
    }
}
