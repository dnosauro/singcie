package com.cyberneid.p105d.p113f;

import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1606c;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1608e;
import com.cyberneid.p105d.p108b.C1609f;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1614j;
import com.cyberneid.p105d.p108b.C1615k;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p108b.C1617m;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p108b.C1623q;
import com.cyberneid.p105d.p108b.C1624r;
import com.cyberneid.p105d.p111d.C1654a;
import com.cyberneid.p105d.p111d.C1660f;
import com.cyberneid.p105d.p111d.C1662h;
import com.cyberneid.p105d.p112e.C1673h;
import com.cyberneid.p105d.p114g.C1783c;
import com.cyberneid.p105d.p114g.p119c.C1784a;
import com.cyberneid.p105d.p114g.p126f.p129c.C1894a;
import com.cyberneid.p105d.p114g.p126f.p129c.C1897d;
import com.cyberneid.p105d.p131h.C1933a;
import com.cyberneid.p105d.p131h.C1939c;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Deque;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Hashtable;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

/* renamed from: com.cyberneid.d.f.b */
public class C1685b implements C1624r, Closeable {

    /* renamed from: a */
    public static final byte[] f5577a = "<<".getBytes(C1933a.f6108a);

    /* renamed from: b */
    public static final byte[] f5578b = ">>".getBytes(C1933a.f6108a);

    /* renamed from: c */
    public static final byte[] f5579c = {32};

    /* renamed from: d */
    public static final byte[] f5580d = {37};

    /* renamed from: e */
    public static final byte[] f5581e = "PDF-1.4".getBytes(C1933a.f6108a);

    /* renamed from: f */
    public static final byte[] f5582f = {-10, -28, -4, -33};

    /* renamed from: g */
    public static final byte[] f5583g = "%%EOF".getBytes(C1933a.f6108a);

    /* renamed from: h */
    public static final byte[] f5584h = "R".getBytes(C1933a.f6108a);

    /* renamed from: i */
    public static final byte[] f5585i = "xref".getBytes(C1933a.f6108a);

    /* renamed from: j */
    public static final byte[] f5586j = "f".getBytes(C1933a.f6108a);

    /* renamed from: k */
    public static final byte[] f5587k = "n".getBytes(C1933a.f6108a);

    /* renamed from: l */
    public static final byte[] f5588l = "trailer".getBytes(C1933a.f6108a);

    /* renamed from: m */
    public static final byte[] f5589m = "startxref".getBytes(C1933a.f6108a);

    /* renamed from: n */
    public static final byte[] f5590n = "obj".getBytes(C1933a.f6108a);

    /* renamed from: o */
    public static final byte[] f5591o = "endobj".getBytes(C1933a.f6108a);

    /* renamed from: p */
    public static final byte[] f5592p = "[".getBytes(C1933a.f6108a);

    /* renamed from: q */
    public static final byte[] f5593q = "]".getBytes(C1933a.f6108a);

    /* renamed from: r */
    public static final byte[] f5594r = "stream".getBytes(C1933a.f6108a);

    /* renamed from: s */
    public static final byte[] f5595s = "endstream".getBytes(C1933a.f6108a);

    /* renamed from: A */
    private final Map<C1617m, C1605b> f5596A = new HashMap();

    /* renamed from: B */
    private final List<C1686c> f5597B = new ArrayList();

    /* renamed from: C */
    private final Set<C1605b> f5598C = new HashSet();

    /* renamed from: D */
    private final Deque<C1605b> f5599D = new LinkedList();

    /* renamed from: E */
    private final Set<C1605b> f5600E = new HashSet();

    /* renamed from: F */
    private final Set<C1605b> f5601F = new HashSet();

    /* renamed from: G */
    private C1617m f5602G = null;

    /* renamed from: H */
    private C1783c f5603H = null;

    /* renamed from: I */
    private C1784a f5604I = null;

    /* renamed from: J */
    private boolean f5605J = false;

    /* renamed from: K */
    private boolean f5606K = false;

    /* renamed from: L */
    private boolean f5607L = false;

    /* renamed from: M */
    private long f5608M;

    /* renamed from: N */
    private long f5609N;

    /* renamed from: O */
    private long f5610O;

    /* renamed from: P */
    private long f5611P;

    /* renamed from: Q */
    private C1662h f5612Q;

    /* renamed from: R */
    private OutputStream f5613R;

    /* renamed from: S */
    private C1897d f5614S;

    /* renamed from: T */
    private byte[] f5615T;

    /* renamed from: U */
    private C1604a f5616U;

    /* renamed from: t */
    private final NumberFormat f5617t = new DecimalFormat("0000000000", DecimalFormatSymbols.getInstance(Locale.US));

    /* renamed from: u */
    private final NumberFormat f5618u = new DecimalFormat("00000", DecimalFormatSymbols.getInstance(Locale.US));

    /* renamed from: v */
    private OutputStream f5619v;

    /* renamed from: w */
    private C1684a f5620w;

    /* renamed from: x */
    private long f5621x = 0;

    /* renamed from: y */
    private long f5622y = 0;

    /* renamed from: z */
    private final Map<C1605b, C1617m> f5623z = new Hashtable();

    public C1685b(OutputStream outputStream) {
        m6849a(outputStream);
        m6848a(new C1684a(this.f5619v));
    }

    public C1685b(OutputStream outputStream, C1662h hVar) {
        m6849a((OutputStream) new ByteArrayOutputStream());
        m6848a(new C1684a(this.f5619v, (int) hVar.mo7711c()));
        this.f5612Q = hVar;
        this.f5613R = outputStream;
        this.f5606K = true;
    }

    /* renamed from: a */
    private void m6845a(long j, long j2) {
        mo7831b().write(String.valueOf(j).getBytes(C1933a.f6111d));
        mo7831b().write(f5579c);
        mo7831b().write(String.valueOf(j2).getBytes(C1933a.f6111d));
        mo7831b().mo7820d();
    }

    /* renamed from: a */
    private void m6846a(C1608e eVar, long j) {
        if (eVar.mo7582p() || j != -1) {
            C1673h hVar = new C1673h(eVar);
            for (C1686c a : mo7838d()) {
                hVar.mo7805a(a);
            }
            C1607d k = eVar.mo7577k();
            if (this.f5606K) {
                k.mo7520a(C1613i.f5190fG, eVar.mo7581o());
            } else {
                k.mo7553j(C1613i.f5190fG);
            }
            hVar.mo7804a(k);
            hVar.mo7803a(mo7823a() + 2);
            mo7832b(mo7831b().mo7816a());
            mo7825a((C1605b) hVar.mo7802a());
        }
        if (!eVar.mo7582p() || j != -1) {
            C1607d k2 = eVar.mo7577k();
            k2.mo7520a(C1613i.f5190fG, eVar.mo7581o());
            if (j != -1) {
                C1613i iVar = C1613i.f5343ia;
                k2.mo7553j(iVar);
                k2.mo7520a(iVar, mo7835c());
            }
            m6857g();
            mo7839d(eVar);
        }
    }

    /* renamed from: a */
    public static void m6847a(C1622p pVar, OutputStream outputStream) {
        m6851a(pVar.mo7643c(), pVar.mo7640a(), outputStream);
    }

    /* renamed from: a */
    private void m6848a(C1684a aVar) {
        this.f5620w = aVar;
    }

    /* renamed from: a */
    private void m6849a(OutputStream outputStream) {
        this.f5619v = outputStream;
    }

    /* renamed from: a */
    public static void m6850a(byte[] bArr, OutputStream outputStream) {
        m6851a(bArr, false, outputStream);
    }

    /* renamed from: a */
    private static void m6851a(byte[] bArr, boolean z, OutputStream outputStream) {
        boolean z2;
        int i;
        if (!z) {
            int length = bArr.length;
            int i2 = 0;
            while (true) {
                if (i2 >= length) {
                    break;
                }
                byte b = bArr[i2];
                if (!(b < 0 || b == 13 || b == 10)) {
                    i2++;
                }
            }
            z2 = false;
            if (z2 || z) {
                outputStream.write(60);
                C1939c.m7983a(bArr, outputStream);
                i = 62;
            } else {
                outputStream.write(40);
                for (byte b2 : bArr) {
                    if (b2 != 92) {
                        switch (b2) {
                            case 40:
                            case 41:
                                break;
                        }
                    }
                    outputStream.write(92);
                    outputStream.write(b2);
                }
                i = 41;
            }
            outputStream.write(i);
        }
        z2 = true;
        if (z2) {
        }
        outputStream.write(60);
        C1939c.m7983a(bArr, outputStream);
        i = 62;
        outputStream.write(i);
    }

    /* renamed from: b */
    private void m6852b(C1686c cVar) {
        String format = this.f5617t.format(cVar.mo7845c());
        String format2 = this.f5618u.format((long) cVar.mo7844b().mo7611a());
        mo7831b().write(format.getBytes(C1933a.f6111d));
        mo7831b().write(f5579c);
        mo7831b().write(format2.getBytes(C1933a.f6111d));
        mo7831b().write(f5579c);
        mo7831b().write(cVar.mo7847d() ? f5586j : f5587k);
        mo7831b().mo7819c();
    }

    /* renamed from: b */
    private void m6853b(C1783c cVar) {
        if (cVar != null) {
            try {
                C1608e a = cVar.mo8053a();
                Set<C1617m> keySet = a.mo7580n().keySet();
                long l = cVar.mo8053a().mo7578l();
                for (C1617m next : keySet) {
                    C1605b a2 = a.mo7558a(next).mo7604a();
                    if (!(a2 == null || next == null || (a2 instanceof C1615k))) {
                        this.f5623z.put(a2, next);
                        this.f5596A.put(next, a2);
                    }
                    if (next != null) {
                        long b = next.mo7613b();
                        if (b > l) {
                            l = b;
                        }
                    }
                }
                mo7824a(l);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /* renamed from: c */
    private void m6854c(C1605b bVar) {
        C1605b a = bVar instanceof C1616l ? ((C1616l) bVar).mo7604a() : bVar;
        if (!this.f5600E.contains(bVar) && !this.f5598C.contains(bVar) && !this.f5601F.contains(a)) {
            C1605b bVar2 = null;
            C1617m mVar = a != null ? this.f5623z.get(a) : null;
            if (mVar != null) {
                bVar2 = this.f5596A.get(mVar);
            }
            if (a == null || !this.f5623z.containsKey(a) || !(bVar instanceof C1623q) || ((C1623q) bVar).mo7550h() || !(bVar2 instanceof C1623q) || ((C1623q) bVar2).mo7550h()) {
                this.f5599D.add(bVar);
                this.f5598C.add(bVar);
                if (a != null) {
                    this.f5601F.add(a);
                }
            }
        }
    }

    /* renamed from: d */
    private C1617m m6855d(C1605b bVar) {
        C1605b a = bVar instanceof C1616l ? ((C1616l) bVar).mo7604a() : bVar;
        C1617m mVar = this.f5623z.get(bVar);
        if (mVar == null && a != null) {
            mVar = this.f5623z.get(a);
        }
        if (mVar == null) {
            mo7824a(mo7823a() + 1);
            mVar = new C1617m(mo7823a(), 0);
            this.f5623z.put(bVar, mVar);
            if (a != null) {
                this.f5623z.put(a, mVar);
            }
        }
        return mVar;
    }

    /* renamed from: f */
    private void m6856f() {
        while (this.f5599D.size() > 0) {
            C1605b removeFirst = this.f5599D.removeFirst();
            this.f5598C.remove(removeFirst);
            mo7825a(removeFirst);
        }
    }

    /* renamed from: g */
    private void m6857g() {
        mo7826a(C1686c.m6887a());
        Collections.sort(mo7838d());
        mo7832b(mo7831b().mo7816a());
        mo7831b().write(f5585i);
        mo7831b().mo7820d();
        Long[] a = mo7830a(mo7838d());
        int length = a.length;
        int i = 0;
        int i2 = 0;
        while (i < length && length % 2 == 0) {
            int i3 = i + 1;
            m6845a(a[i].longValue(), a[i3].longValue());
            int i4 = i2;
            int i5 = 0;
            while (((long) i5) < a[i3].longValue()) {
                m6852b(this.f5597B.get(i4));
                i5++;
                i4++;
            }
            i += 2;
            i2 = i4;
        }
    }

    /* renamed from: h */
    private void m6858h() {
        C1654a.m6618a(new C1660f(this.f5612Q), this.f5613R);
        this.f5613R.write(((ByteArrayOutputStream) this.f5619v).toByteArray());
    }

    /* renamed from: i */
    private void m6859i() {
        long c = this.f5612Q.mo7711c();
        long j = this.f5608M;
        long j2 = this.f5609N + j;
        long a = (mo7831b().mo7816a() - (this.f5609N + c)) - (this.f5608M - c);
        String str = "0 " + j + " " + j2 + " " + a + "]";
        int i = 0;
        this.f5616U.mo7496b(0, C1612h.f4886a);
        this.f5616U.mo7496b(1, C1612h.m6455a(j));
        this.f5616U.mo7496b(2, C1612h.m6455a(j2));
        this.f5616U.mo7496b(3, C1612h.m6455a(a));
        if (((long) str.length()) <= this.f5611P) {
            ByteArrayOutputStream byteArrayOutputStream = (ByteArrayOutputStream) this.f5619v;
            byteArrayOutputStream.flush();
            this.f5615T = byteArrayOutputStream.toByteArray();
            byte[] bytes = str.getBytes(C1933a.f6111d);
            while (true) {
                long j3 = (long) i;
                if (j3 >= this.f5611P) {
                    break;
                }
                if (i >= bytes.length) {
                    this.f5615T[(int) ((this.f5610O + j3) - c)] = 32;
                } else {
                    this.f5615T[(int) ((this.f5610O + j3) - c)] = bytes[i];
                }
                i++;
            }
            if (this.f5614S != null) {
                mo7829a(this.f5614S.mo8377a(mo7840e()));
                return;
            }
            return;
        }
        throw new IOException("Can't write new byteRange '" + str + "' not enough space: byteRange.length(): " + str.length() + ", byteRangeLength: " + this.f5611P);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public long mo7823a() {
        return this.f5622y;
    }

    /* JADX WARNING: Removed duplicated region for block: B:24:0x0062  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x000e A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object mo7647a(com.cyberneid.p105d.p108b.C1604a r5) {
        /*
            r4 = this;
            com.cyberneid.d.f.a r0 = r4.mo7831b()
            byte[] r1 = f5592p
            r0.write(r1)
            java.util.Iterator r5 = r5.iterator()
            r0 = 0
        L_0x000e:
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x0078
            java.lang.Object r1 = r5.next()
            com.cyberneid.d.b.b r1 = (com.cyberneid.p105d.p108b.C1605b) r1
            boolean r2 = r1 instanceof com.cyberneid.p105d.p108b.C1607d
            if (r2 == 0) goto L_0x0031
            boolean r2 = r1.mo7506e()
            if (r2 == 0) goto L_0x002a
            com.cyberneid.d.b.d r1 = (com.cyberneid.p105d.p108b.C1607d) r1
            r4.mo7649a((com.cyberneid.p105d.p108b.C1607d) r1)
            goto L_0x005a
        L_0x002a:
            r4.m6854c((com.cyberneid.p105d.p108b.C1605b) r1)
            r4.mo7833b((com.cyberneid.p105d.p108b.C1605b) r1)
            goto L_0x005a
        L_0x0031:
            boolean r2 = r1 instanceof com.cyberneid.p105d.p108b.C1616l
            if (r2 == 0) goto L_0x004f
            r2 = r1
            com.cyberneid.d.b.l r2 = (com.cyberneid.p105d.p108b.C1616l) r2
            com.cyberneid.d.b.b r2 = r2.mo7604a()
            boolean r3 = r4.f5605J
            if (r3 != 0) goto L_0x002a
            boolean r3 = r4.f5606K
            if (r3 != 0) goto L_0x002a
            boolean r3 = r2 instanceof com.cyberneid.p105d.p108b.C1607d
            if (r3 != 0) goto L_0x002a
            if (r2 != 0) goto L_0x004b
            goto L_0x002a
        L_0x004b:
            r2.mo7486a((com.cyberneid.p105d.p108b.C1624r) r4)
            goto L_0x005a
        L_0x004f:
            if (r1 != 0) goto L_0x0057
            com.cyberneid.d.b.j r1 = com.cyberneid.p105d.p108b.C1614j.f5368b
            r1.mo7486a((com.cyberneid.p105d.p108b.C1624r) r4)
            goto L_0x005a
        L_0x0057:
            r1.mo7486a((com.cyberneid.p105d.p108b.C1624r) r4)
        L_0x005a:
            int r0 = r0 + 1
            boolean r1 = r5.hasNext()
            if (r1 == 0) goto L_0x000e
            int r1 = r0 % 10
            if (r1 != 0) goto L_0x006e
            com.cyberneid.d.f.a r1 = r4.mo7831b()
            r1.mo7820d()
            goto L_0x000e
        L_0x006e:
            com.cyberneid.d.f.a r1 = r4.mo7831b()
            byte[] r2 = f5579c
            r1.write(r2)
            goto L_0x000e
        L_0x0078:
            com.cyberneid.d.f.a r5 = r4.mo7831b()
            byte[] r0 = f5593q
            r5.write(r0)
            com.cyberneid.d.f.a r5 = r4.mo7831b()
            r5.mo7820d()
            r5 = 0
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p113f.C1685b.mo7647a(com.cyberneid.d.b.a):java.lang.Object");
    }

    /* renamed from: a */
    public Object mo7648a(C1606c cVar) {
        cVar.mo7507a((OutputStream) mo7831b());
        return null;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:38:0x00bd, code lost:
        if (r0 != null) goto L_0x00c0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x00c0, code lost:
        r0.mo7486a((com.cyberneid.p105d.p108b.C1624r) r7);
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object mo7649a(com.cyberneid.p105d.p108b.C1607d r8) {
        /*
            r7 = this;
            boolean r0 = r7.f5607L
            r1 = 1
            if (r0 != 0) goto L_0x001d
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.f5338hw
            com.cyberneid.d.b.b r0 = r8.mo7554k(r0)
            com.cyberneid.d.b.i r2 = com.cyberneid.p105d.p108b.C1613i.f5286gx
            boolean r2 = r2.equals(r0)
            if (r2 != 0) goto L_0x001b
            com.cyberneid.d.b.i r2 = com.cyberneid.p105d.p108b.C1613i.f4981bJ
            boolean r0 = r2.equals(r0)
            if (r0 == 0) goto L_0x001d
        L_0x001b:
            r7.f5607L = r1
        L_0x001d:
            com.cyberneid.d.f.a r0 = r7.mo7831b()
            byte[] r2 = f5577a
            r0.write(r2)
            com.cyberneid.d.f.a r0 = r7.mo7831b()
            r0.mo7820d()
            java.util.Set r8 = r8.mo7546f()
            java.util.Iterator r8 = r8.iterator()
        L_0x0035:
            boolean r0 = r8.hasNext()
            if (r0 == 0) goto L_0x0135
            java.lang.Object r0 = r8.next()
            java.util.Map$Entry r0 = (java.util.Map.Entry) r0
            java.lang.Object r2 = r0.getValue()
            com.cyberneid.d.b.b r2 = (com.cyberneid.p105d.p108b.C1605b) r2
            if (r2 == 0) goto L_0x0035
            java.lang.Object r3 = r0.getKey()
            com.cyberneid.d.b.i r3 = (com.cyberneid.p105d.p108b.C1613i) r3
            r3.mo7486a((com.cyberneid.p105d.p108b.C1624r) r7)
            com.cyberneid.d.f.a r3 = r7.mo7831b()
            byte[] r4 = f5579c
            r3.write(r4)
            boolean r3 = r2 instanceof com.cyberneid.p105d.p108b.C1607d
            if (r3 == 0) goto L_0x00a6
            com.cyberneid.d.b.d r2 = (com.cyberneid.p105d.p108b.C1607d) r2
            boolean r3 = r7.f5606K
            if (r3 != 0) goto L_0x0093
            com.cyberneid.d.b.i r3 = com.cyberneid.p105d.p108b.C1613i.f5314hY
            com.cyberneid.d.b.b r3 = r2.mo7554k(r3)
            if (r3 == 0) goto L_0x007c
            com.cyberneid.d.b.i r4 = com.cyberneid.p105d.p108b.C1613i.f5314hY
            java.lang.Object r5 = r0.getKey()
            boolean r4 = r4.equals(r5)
            if (r4 != 0) goto L_0x007c
            r3.mo7504a((boolean) r1)
        L_0x007c:
            com.cyberneid.d.b.i r3 = com.cyberneid.p105d.p108b.C1613i.f5267ge
            com.cyberneid.d.b.b r3 = r2.mo7554k(r3)
            if (r3 == 0) goto L_0x0093
            com.cyberneid.d.b.i r4 = com.cyberneid.p105d.p108b.C1613i.f5267ge
            java.lang.Object r0 = r0.getKey()
            boolean r0 = r4.equals(r0)
            if (r0 != 0) goto L_0x0093
            r3.mo7504a((boolean) r1)
        L_0x0093:
            boolean r0 = r2.mo7506e()
            if (r0 == 0) goto L_0x009e
            r7.mo7649a((com.cyberneid.p105d.p108b.C1607d) r2)
            goto L_0x012c
        L_0x009e:
            r7.m6854c((com.cyberneid.p105d.p108b.C1605b) r2)
            r7.mo7833b((com.cyberneid.p105d.p108b.C1605b) r2)
            goto L_0x012c
        L_0x00a6:
            boolean r3 = r2 instanceof com.cyberneid.p105d.p108b.C1616l
            if (r3 == 0) goto L_0x00c4
            r0 = r2
            com.cyberneid.d.b.l r0 = (com.cyberneid.p105d.p108b.C1616l) r0
            com.cyberneid.d.b.b r0 = r0.mo7604a()
            boolean r3 = r7.f5605J
            if (r3 != 0) goto L_0x009e
            boolean r3 = r7.f5606K
            if (r3 != 0) goto L_0x009e
            boolean r3 = r0 instanceof com.cyberneid.p105d.p108b.C1607d
            if (r3 != 0) goto L_0x009e
            if (r0 != 0) goto L_0x00c0
            goto L_0x009e
        L_0x00c0:
            r0.mo7486a((com.cyberneid.p105d.p108b.C1624r) r7)
            goto L_0x012c
        L_0x00c4:
            boolean r3 = r7.f5607L
            if (r3 == 0) goto L_0x00ef
            com.cyberneid.d.b.i r3 = com.cyberneid.p105d.p108b.C1613i.f4934aP
            java.lang.Object r4 = r0.getKey()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x00ef
            com.cyberneid.d.f.a r0 = r7.mo7831b()
            long r3 = r0.mo7816a()
            r7.f5608M = r3
            r2.mo7486a((com.cyberneid.p105d.p108b.C1624r) r7)
            com.cyberneid.d.f.a r0 = r7.mo7831b()
            long r2 = r0.mo7816a()
            long r4 = r7.f5608M
            long r2 = r2 - r4
            r7.f5609N = r2
            goto L_0x012c
        L_0x00ef:
            boolean r3 = r7.f5607L
            if (r3 == 0) goto L_0x0129
            com.cyberneid.d.b.i r3 = com.cyberneid.p105d.p108b.C1613i.f4946ab
            java.lang.Object r4 = r0.getKey()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0129
            java.lang.Object r0 = r0.getValue()
            com.cyberneid.d.b.a r0 = (com.cyberneid.p105d.p108b.C1604a) r0
            r7.f5616U = r0
            com.cyberneid.d.f.a r0 = r7.mo7831b()
            long r3 = r0.mo7816a()
            r5 = 1
            long r3 = r3 + r5
            r7.f5610O = r3
            r2.mo7486a((com.cyberneid.p105d.p108b.C1624r) r7)
            com.cyberneid.d.f.a r0 = r7.mo7831b()
            long r2 = r0.mo7816a()
            long r2 = r2 - r5
            long r4 = r7.f5610O
            long r2 = r2 - r4
            r7.f5611P = r2
            r0 = 0
            r7.f5607L = r0
            goto L_0x012c
        L_0x0129:
            r2.mo7486a((com.cyberneid.p105d.p108b.C1624r) r7)
        L_0x012c:
            com.cyberneid.d.f.a r0 = r7.mo7831b()
            r0.mo7820d()
            goto L_0x0035
        L_0x0135:
            com.cyberneid.d.f.a r8 = r7.mo7831b()
            byte[] r0 = f5578b
            r8.write(r0)
            com.cyberneid.d.f.a r8 = r7.mo7831b()
            r8.mo7820d()
            r8 = 0
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p113f.C1685b.mo7649a(com.cyberneid.d.b.d):java.lang.Object");
    }

    /* renamed from: a */
    public Object mo7650a(C1608e eVar) {
        if (!this.f5606K) {
            mo7836c(eVar);
        } else {
            mo7831b().mo7819c();
        }
        mo7834b(eVar);
        C1607d k = eVar.mo7577k();
        long j = -1;
        if (k != null) {
            j = k.mo7549h(C1613i.f5343ia);
        }
        if (this.f5606K || eVar.mo7582p()) {
            m6846a(eVar, j);
        } else {
            m6857g();
            mo7839d(eVar);
        }
        mo7831b().write(f5589m);
        mo7831b().mo7820d();
        mo7831b().write(String.valueOf(mo7835c()).getBytes(C1933a.f6111d));
        mo7831b().mo7820d();
        mo7831b().write(f5583g);
        mo7831b().mo7820d();
        if (!this.f5606K) {
            return null;
        }
        if (this.f5608M == 0 || this.f5610O == 0) {
            m6858h();
            return null;
        }
        m6859i();
        return null;
    }

    /* renamed from: a */
    public Object mo7651a(C1609f fVar) {
        fVar.mo7584a((OutputStream) mo7831b());
        return null;
    }

    /* renamed from: a */
    public Object mo7652a(C1612h hVar) {
        hVar.mo7591a((OutputStream) mo7831b());
        return null;
    }

    /* renamed from: a */
    public Object mo7653a(C1613i iVar) {
        iVar.mo7597a((OutputStream) mo7831b());
        return null;
    }

    /* renamed from: a */
    public Object mo7654a(C1614j jVar) {
        jVar.mo7602a((OutputStream) mo7831b());
        return null;
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0061  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.Object mo7655a(com.cyberneid.p105d.p108b.C1619o r6) {
        /*
            r5 = this;
            boolean r0 = r5.f5605J
            if (r0 == 0) goto L_0x001d
            com.cyberneid.d.g.c r0 = r5.f5603H
            com.cyberneid.d.g.b.f r0 = r0.mo8066d()
            com.cyberneid.d.g.b.m r0 = r0.mo7985a()
            com.cyberneid.d.b.m r1 = r5.f5602G
            long r1 = r1.mo7613b()
            com.cyberneid.d.b.m r3 = r5.f5602G
            int r3 = r3.mo7611a()
            r0.mo8032a((com.cyberneid.p105d.p108b.C1619o) r6, (long) r1, (int) r3)
        L_0x001d:
            r0 = 0
            r5.mo7649a((com.cyberneid.p105d.p108b.C1607d) r6)     // Catch:{ all -> 0x005b }
            com.cyberneid.d.f.a r1 = r5.mo7831b()     // Catch:{ all -> 0x005b }
            byte[] r2 = f5594r     // Catch:{ all -> 0x005b }
            r1.write(r2)     // Catch:{ all -> 0x005b }
            com.cyberneid.d.f.a r1 = r5.mo7831b()     // Catch:{ all -> 0x005b }
            r1.mo7819c()     // Catch:{ all -> 0x005b }
            java.io.InputStream r6 = r6.mo7626k()     // Catch:{ all -> 0x005b }
            com.cyberneid.d.f.a r1 = r5.mo7831b()     // Catch:{ all -> 0x0059 }
            com.cyberneid.p105d.p111d.C1654a.m6618a(r6, r1)     // Catch:{ all -> 0x0059 }
            com.cyberneid.d.f.a r1 = r5.mo7831b()     // Catch:{ all -> 0x0059 }
            r1.mo7819c()     // Catch:{ all -> 0x0059 }
            com.cyberneid.d.f.a r1 = r5.mo7831b()     // Catch:{ all -> 0x0059 }
            byte[] r2 = f5595s     // Catch:{ all -> 0x0059 }
            r1.write(r2)     // Catch:{ all -> 0x0059 }
            com.cyberneid.d.f.a r1 = r5.mo7831b()     // Catch:{ all -> 0x0059 }
            r1.mo7820d()     // Catch:{ all -> 0x0059 }
            if (r6 == 0) goto L_0x0058
            r6.close()
        L_0x0058:
            return r0
        L_0x0059:
            r0 = move-exception
            goto L_0x005f
        L_0x005b:
            r6 = move-exception
            r4 = r0
            r0 = r6
            r6 = r4
        L_0x005f:
            if (r6 == 0) goto L_0x0064
            r6.close()
        L_0x0064:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p113f.C1685b.mo7655a(com.cyberneid.d.b.o):java.lang.Object");
    }

    /* renamed from: a */
    public Object mo7656a(C1622p pVar) {
        if (this.f5605J) {
            this.f5603H.mo8066d().mo7985a().mo8034a(pVar, this.f5602G.mo7613b(), this.f5602G.mo7611a());
        }
        m6847a(pVar, (OutputStream) mo7831b());
        return null;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7824a(long j) {
        this.f5622y = j;
    }

    /* renamed from: a */
    public void mo7825a(C1605b bVar) {
        this.f5600E.add(bVar);
        this.f5602G = m6855d(bVar);
        mo7826a(new C1686c(mo7831b().mo7816a(), bVar, this.f5602G));
        mo7831b().write(String.valueOf(this.f5602G.mo7613b()).getBytes(C1933a.f6111d));
        mo7831b().write(f5579c);
        mo7831b().write(String.valueOf(this.f5602G.mo7611a()).getBytes(C1933a.f6111d));
        mo7831b().write(f5579c);
        mo7831b().write(f5590n);
        mo7831b().mo7820d();
        bVar.mo7486a((C1624r) this);
        mo7831b().mo7820d();
        mo7831b().write(f5591o);
        mo7831b().mo7820d();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7826a(C1686c cVar) {
        mo7838d().add(cVar);
    }

    /* renamed from: a */
    public void mo7827a(C1783c cVar) {
        mo7828a(cVar, (C1897d) null);
    }

    /* JADX WARNING: type inference failed for: r4v1, types: [com.cyberneid.d.b.b] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7828a(com.cyberneid.p105d.p114g.C1783c r8, com.cyberneid.p105d.p114g.p126f.p129c.C1897d r9) {
        /*
            r7 = this;
            java.lang.Long r0 = r8.mo8074l()
            if (r0 != 0) goto L_0x000b
            long r0 = java.lang.System.currentTimeMillis()
            goto L_0x0013
        L_0x000b:
            java.lang.Long r0 = r8.mo8074l()
            long r0 = r0.longValue()
        L_0x0013:
            java.lang.Long r0 = java.lang.Long.valueOf(r0)
            r7.f5603H = r8
            r7.f5614S = r9
            boolean r9 = r7.f5606K
            if (r9 == 0) goto L_0x0022
            r7.m6853b((com.cyberneid.p105d.p114g.C1783c) r8)
        L_0x0022:
            boolean r9 = r8.mo8073k()
            r1 = 1
            r2 = 0
            if (r9 == 0) goto L_0x003a
            r7.f5605J = r2
            com.cyberneid.d.b.e r8 = r8.mo8053a()
            com.cyberneid.d.b.d r8 = r8.mo7577k()
            com.cyberneid.d.b.i r9 = com.cyberneid.p105d.p108b.C1613i.f5058ch
            r8.mo7553j(r9)
            goto L_0x0069
        L_0x003a:
            com.cyberneid.d.g.c r8 = r7.f5603H
            com.cyberneid.d.g.b.f r8 = r8.mo8066d()
            if (r8 == 0) goto L_0x0067
            boolean r8 = r7.f5606K
            if (r8 != 0) goto L_0x0064
            com.cyberneid.d.g.c r8 = r7.f5603H
            com.cyberneid.d.g.b.f r8 = r8.mo8066d()
            com.cyberneid.d.g.b.m r8 = r8.mo7985a()
            boolean r9 = r8.mo8025a()
            if (r9 == 0) goto L_0x005c
            com.cyberneid.d.g.c r9 = r7.f5603H
            r8.mo8024a((com.cyberneid.p105d.p114g.C1783c) r9)
            goto L_0x0064
        L_0x005c:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "PDF contains an encryption dictionary, please remove it with setAllSecurityToBeRemoved() or set a protection policy with protect()"
            r8.<init>(r9)
            throw r8
        L_0x0064:
            r7.f5605J = r1
            goto L_0x0069
        L_0x0067:
            r7.f5605J = r2
        L_0x0069:
            com.cyberneid.d.g.c r8 = r7.f5603H
            com.cyberneid.d.b.e r8 = r8.mo8053a()
            com.cyberneid.d.b.d r9 = r8.mo7577k()
            r3 = 0
            com.cyberneid.d.b.i r4 = com.cyberneid.p105d.p108b.C1613i.f5114dk
            com.cyberneid.d.b.b r4 = r9.mo7539c((com.cyberneid.p105d.p108b.C1613i) r4)
            boolean r5 = r4 instanceof com.cyberneid.p105d.p108b.C1604a
            r6 = 2
            if (r5 == 0) goto L_0x0089
            r3 = r4
            com.cyberneid.d.b.a r3 = (com.cyberneid.p105d.p108b.C1604a) r3
            int r4 = r3.mo7494b()
            if (r4 != r6) goto L_0x0089
            r1 = 0
        L_0x0089:
            if (r3 == 0) goto L_0x0092
            int r4 = r3.mo7494b()
            if (r4 != r6) goto L_0x0092
            r1 = 0
        L_0x0092:
            if (r1 != 0) goto L_0x0098
            boolean r4 = r7.f5606K
            if (r4 == 0) goto L_0x0108
        L_0x0098:
            java.lang.String r4 = "MD5"
            java.security.MessageDigest r4 = java.security.MessageDigest.getInstance(r4)     // Catch:{ NoSuchAlgorithmException -> 0x010c }
            long r5 = r0.longValue()
            java.lang.String r0 = java.lang.Long.toString(r5)
            java.nio.charset.Charset r5 = com.cyberneid.p105d.p131h.C1933a.f6111d
            byte[] r0 = r0.getBytes(r5)
            r4.update(r0)
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.f5124du
            com.cyberneid.d.b.d r0 = r9.mo7514a((com.cyberneid.p105d.p108b.C1613i) r0)
            if (r0 == 0) goto L_0x00d9
            java.util.Collection r0 = r0.mo7548g()
            java.util.Iterator r0 = r0.iterator()
        L_0x00bf:
            boolean r5 = r0.hasNext()
            if (r5 == 0) goto L_0x00d9
            java.lang.Object r5 = r0.next()
            com.cyberneid.d.b.b r5 = (com.cyberneid.p105d.p108b.C1605b) r5
            java.lang.String r5 = r5.toString()
            java.nio.charset.Charset r6 = com.cyberneid.p105d.p131h.C1933a.f6111d
            byte[] r5 = r5.getBytes(r6)
            r4.update(r5)
            goto L_0x00bf
        L_0x00d9:
            if (r1 == 0) goto L_0x00e5
            com.cyberneid.d.b.p r0 = new com.cyberneid.d.b.p
            byte[] r2 = r4.digest()
            r0.<init>((byte[]) r2)
            goto L_0x00eb
        L_0x00e5:
            com.cyberneid.d.b.b r0 = r3.mo7495b((int) r2)
            com.cyberneid.d.b.p r0 = (com.cyberneid.p105d.p108b.C1622p) r0
        L_0x00eb:
            if (r1 == 0) goto L_0x00ef
            r1 = r0
            goto L_0x00f8
        L_0x00ef:
            com.cyberneid.d.b.p r1 = new com.cyberneid.d.b.p
            byte[] r2 = r4.digest()
            r1.<init>((byte[]) r2)
        L_0x00f8:
            com.cyberneid.d.b.a r2 = new com.cyberneid.d.b.a
            r2.<init>()
            r2.mo7490a((com.cyberneid.p105d.p108b.C1605b) r0)
            r2.mo7490a((com.cyberneid.p105d.p108b.C1605b) r1)
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.f5114dk
            r9.mo7521a((com.cyberneid.p105d.p108b.C1613i) r0, (com.cyberneid.p105d.p108b.C1605b) r2)
        L_0x0108:
            r8.mo7486a((com.cyberneid.p105d.p108b.C1624r) r7)
            return
        L_0x010c:
            r8 = move-exception
            java.lang.RuntimeException r9 = new java.lang.RuntimeException
            r9.<init>(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p113f.C1685b.mo7828a(com.cyberneid.d.g.c, com.cyberneid.d.g.f.c.d):void");
    }

    /* renamed from: a */
    public void mo7829a(byte[] bArr) {
        if (this.f5615T == null || this.f5612Q == null) {
            throw new IllegalStateException("PDF not prepared for setting signature");
        }
        byte[] a = C1939c.m7984a(bArr);
        if (((long) a.length) <= this.f5609N - 2) {
            System.arraycopy(a, 0, this.f5615T, ((int) (this.f5608M - this.f5612Q.mo7711c())) + 1, a.length);
            C1654a.m6618a(new C1660f(this.f5612Q), this.f5613R);
            this.f5613R.write(this.f5615T);
            this.f5615T = null;
            return;
        }
        throw new IOException("Can't write signature, not enough space");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public Long[] mo7830a(List<C1686c> list) {
        ArrayList arrayList = new ArrayList();
        long j = -2;
        long j2 = 1;
        for (C1686c b : list) {
            long b2 = (long) ((int) b.mo7844b().mo7613b());
            if (b2 == j + 1) {
                j2++;
            } else if (j != -2) {
                arrayList.add(Long.valueOf((j - j2) + 1));
                arrayList.add(Long.valueOf(j2));
                j2 = 1;
            }
            j = b2;
        }
        if (list.size() > 0) {
            arrayList.add(Long.valueOf((j - j2) + 1));
            arrayList.add(Long.valueOf(j2));
        }
        return (Long[]) arrayList.toArray(new Long[arrayList.size()]);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1684a mo7831b() {
        return this.f5620w;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7832b(long j) {
        this.f5621x = j;
    }

    /* renamed from: b */
    public void mo7833b(C1605b bVar) {
        C1617m d = m6855d(bVar);
        mo7831b().write(String.valueOf(d.mo7613b()).getBytes(C1933a.f6111d));
        mo7831b().write(f5579c);
        mo7831b().write(String.valueOf(d.mo7611a()).getBytes(C1933a.f6111d));
        mo7831b().write(f5579c);
        mo7831b().write(f5584h);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7834b(C1608e eVar) {
        C1607d k = eVar.mo7577k();
        C1607d a = k.mo7514a(C1613i.f5271gi);
        C1607d a2 = k.mo7514a(C1613i.f5124du);
        C1607d a3 = k.mo7514a(C1613i.f5058ch);
        if (a != null) {
            m6854c((C1605b) a);
        }
        if (a2 != null) {
            m6854c((C1605b) a2);
        }
        m6856f();
        this.f5605J = false;
        if (a3 != null) {
            m6854c((C1605b) a3);
        }
        m6856f();
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public long mo7835c() {
        return this.f5621x;
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public void mo7836c(C1608e eVar) {
        String str;
        StringBuilder sb;
        if (this.f5604I != null) {
            sb = new StringBuilder();
            str = "%FDF-";
        } else {
            sb = new StringBuilder();
            str = "%PDF-";
        }
        sb.append(str);
        sb.append(Float.toString(eVar.mo7565b()));
        mo7831b().write(sb.toString().getBytes(C1933a.f6111d));
        mo7831b().mo7820d();
        mo7831b().write(f5580d);
        mo7831b().write(f5582f);
        mo7831b().mo7820d();
    }

    public void close() {
        if (mo7831b() != null) {
            mo7831b().close();
        }
        OutputStream outputStream = this.f5613R;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public List<C1686c> mo7838d() {
        return this.f5597B;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public void mo7839d(C1608e eVar) {
        mo7831b().write(f5588l);
        mo7831b().mo7820d();
        C1607d k = eVar.mo7577k();
        Collections.sort(mo7838d());
        k.mo7520a(C1613i.f5288gz, mo7838d().get(mo7838d().size() - 1).mo7844b().mo7613b() + 1);
        if (!this.f5606K) {
            k.mo7553j(C1613i.f5190fG);
        }
        if (!eVar.mo7582p()) {
            k.mo7553j(C1613i.f5343ia);
        }
        k.mo7553j(C1613i.f4980bI);
        C1604a b = k.mo7532b(C1613i.f5114dk);
        if (b != null) {
            b.mo7504a(true);
        }
        k.mo7486a((C1624r) this);
    }

    /* renamed from: e */
    public InputStream mo7840e() {
        C1662h hVar;
        if (this.f5615T == null || (hVar = this.f5612Q) == null) {
            throw new IllegalStateException("PDF not prepared for signing");
        }
        int c = (int) (this.f5608M - hVar.mo7711c());
        int i = ((int) this.f5609N) + c;
        return new SequenceInputStream(new C1660f(this.f5612Q), new C1894a(this.f5615T, new int[]{0, c, i, this.f5615T.length - i}));
    }
}
