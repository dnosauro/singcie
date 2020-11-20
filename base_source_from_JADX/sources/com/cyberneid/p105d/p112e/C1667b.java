package com.cyberneid.p105d.p112e;

import android.support.p002v4.media.session.PlaybackStateCompat;
import android.util.Log;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1608e;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1614j;
import com.cyberneid.p105d.p108b.C1615k;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p108b.C1617m;
import com.cyberneid.p105d.p108b.C1619o;
import com.cyberneid.p105d.p111d.C1662h;
import com.cyberneid.p105d.p112e.C1680l;
import com.cyberneid.p105d.p114g.p118b.C1778m;
import com.cyberneid.p105d.p131h.C1933a;
import com.unboundid.ldap.protocol.LDAPMessage;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Vector;
import org.apache.commons.p172io.IOUtils;
import org.spongycastle.asn1.cmp.PKIFailureInfo;
import org.spongycastle.pqc.math.linearalgebra.Matrix;

/* renamed from: com.cyberneid.d.e.b */
public class C1667b extends C1666a {

    /* renamed from: c */
    public static final byte[] f5512c = {LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_REFERENCE, 116, 114, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, LDAPMessage.PROTOCOL_OP_TYPE_BIND_RESPONSE, LDAPMessage.PROTOCOL_OP_TYPE_MODIFY_DN_RESPONSE};

    /* renamed from: d */
    public static final byte[] f5513d = {LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_DONE, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_REQUEST, LDAPMessage.PROTOCOL_OP_TYPE_SEARCH_RESULT_ENTRY, LDAPMessage.PROTOCOL_OP_TYPE_COMPARE_RESPONSE, 98, 106};

    /* renamed from: f */
    protected static final char[] f5514f = {'%', '%', 'E', 'O', 'F'};

    /* renamed from: g */
    protected static final char[] f5515g = {'o', 'b', 'j'};

    /* renamed from: l */
    private static final char[] f5516l = {'x', 'r', 'e', 'f'};

    /* renamed from: m */
    private static final char[] f5517m = {IOUtils.DIR_SEPARATOR_UNIX, 'X', Matrix.MATRIX_TYPE_RANDOM_REGULAR, 'e', 'f'};

    /* renamed from: n */
    private static final char[] f5518n = {'s', 't', 'a', 'r', 't', 'x', 'r', 'e', 'f'};

    /* renamed from: e */
    protected final C1662h f5519e;

    /* renamed from: h */
    protected long f5520h;

    /* renamed from: i */
    protected boolean f5521i = false;

    /* renamed from: j */
    protected C1778m f5522j = null;

    /* renamed from: k */
    protected C1680l f5523k = new C1680l();

    /* renamed from: o */
    private final byte[] f5524o = new byte[2048];

    /* renamed from: p */
    private long f5525p;

    /* renamed from: q */
    private boolean f5526q = true;

    /* renamed from: r */
    private Map<C1617m, Long> f5527r = null;

    /* renamed from: s */
    private List<Long> f5528s = null;

    /* renamed from: t */
    private List<Long> f5529t = null;

    /* renamed from: u */
    private int f5530u = 2048;

    /* renamed from: v */
    private final boolean f5531v = "true".equals(System.getProperty("com.cyberneid.pdfbox.pdfparser.nonSequentialPDFParser.parseMinimal"));

    /* renamed from: w */
    private final byte[] f5532w = new byte[PKIFailureInfo.certRevoked];

    public C1667b(C1662h hVar) {
        super(new C1678j(hVar));
        this.f5519e = hVar;
    }

    /* renamed from: A */
    private void mo7798A() {
        Long l;
        if (this.f5527r == null) {
            this.f5527r = new HashMap();
            long b = this.f5519e.mo7709b();
            char[] charArray = " obj".toCharArray();
            long j = 6;
            long j2 = 6;
            while (true) {
                this.f5519e.mo7706a(j2);
                long b2 = m6751b(charArray);
                int i = (b2 > 0 ? 1 : (b2 == 0 ? 0 : -1));
                if (i < 0) {
                    break;
                }
                long length = b2 - ((long) charArray.length);
                if (i >= 0) {
                    long j3 = length - 1;
                    this.f5519e.mo7706a(j3);
                    int g = this.f5519e.mo7718g();
                    if (mo7761k()) {
                        int i2 = g - 48;
                        long j4 = j3 - 1;
                        this.f5519e.mo7706a(j4);
                        if (mo7760j()) {
                            while (j4 > j && mo7760j()) {
                                j4--;
                                this.f5519e.mo7706a(j4);
                            }
                            int i3 = 0;
                            while (j4 > j && mo7761k()) {
                                j4--;
                                this.f5519e.mo7706a(j4);
                                i3++;
                            }
                            if (i3 > 0) {
                                this.f5519e.read();
                                byte[] c = this.f5519e.mo7712c(i3);
                                try {
                                    l = Long.valueOf(new String(c, 0, c.length, C1933a.f6111d));
                                } catch (NumberFormatException unused) {
                                    l = null;
                                }
                                if (l != null) {
                                    this.f5527r.put(new C1617m(l.longValue(), i2), Long.valueOf(j4 + 1));
                                }
                            }
                        }
                    }
                }
                j2 = b2 + 1;
                if (this.f5519e.mo7716e()) {
                    break;
                }
                j = 6;
            }
            this.f5519e.mo7706a(b);
        }
    }

    /* renamed from: B */
    private void mo7799B() {
        if (this.f5528s == null) {
            this.f5528s = new Vector();
            long b = this.f5519e.mo7709b();
            this.f5519e.mo7706a(6);
            while (!this.f5519e.mo7716e()) {
                if (m6749a(f5516l)) {
                    long b2 = this.f5519e.mo7709b();
                    this.f5519e.mo7706a(b2 - 1);
                    if (mo7759i()) {
                        this.f5528s.add(Long.valueOf(b2));
                    }
                    this.f5519e.mo7706a(b2 + 4);
                }
                this.f5519e.read();
            }
            this.f5519e.mo7706a(b);
        }
    }

    /* renamed from: C */
    private void m6734C() {
        if (this.f5529t == null) {
            this.f5529t = new Vector();
            long b = this.f5519e.mo7709b();
            this.f5519e.mo7706a(6);
            char[] charArray = " obj".toCharArray();
            while (!this.f5519e.mo7716e()) {
                if (m6749a(f5517m)) {
                    long b2 = this.f5519e.mo7709b();
                    boolean z = false;
                    long j = -1;
                    for (int i = 1; i < 30 && !z; i++) {
                        long j2 = b2 - ((long) (i * 10));
                        if (j2 > 0) {
                            this.f5519e.mo7706a(j2);
                            long j3 = j2;
                            int i2 = 0;
                            while (true) {
                                if (i2 >= 10) {
                                    break;
                                } else if (m6749a(charArray)) {
                                    long j4 = j3 - 1;
                                    this.f5519e.mo7706a(j4);
                                    if (m6700f(this.f5519e.mo7718g())) {
                                        long j5 = j4 - 1;
                                        this.f5519e.mo7706a(j5);
                                        if (mo7760j()) {
                                            long j6 = j5 - 1;
                                            this.f5519e.mo7706a(j6);
                                            int i3 = 0;
                                            while (j6 > 6 && mo7761k()) {
                                                j6--;
                                                this.f5519e.mo7706a(j6);
                                                i3++;
                                            }
                                            if (i3 > 0) {
                                                this.f5519e.read();
                                                j = this.f5519e.mo7709b();
                                            }
                                        }
                                    }
                                    Log.d("PdfBox-Android", "Fixed reference for xref stream " + b2 + " -> " + j);
                                    z = true;
                                } else {
                                    j3++;
                                    this.f5519e.read();
                                    i2++;
                                }
                            }
                        }
                    }
                    if (j > -1) {
                        this.f5529t.add(Long.valueOf(j));
                    }
                    this.f5519e.mo7706a(b2 + 5);
                }
                this.f5519e.read();
            }
            this.f5519e.mo7706a(b);
        }
    }

    /* renamed from: a */
    private long m6735a(long j, boolean z) {
        mo7763m();
        mo7764n();
        mo7746a(f5515g, true);
        C1607d a = mo7743a();
        C1619o a2 = mo7772a(a);
        mo7774a(a2, (long) ((int) j), z);
        a2.close();
        return a.mo7549h(C1613i.f5190fG);
    }

    /* renamed from: a */
    private long m6736a(C1616l lVar) {
        return (lVar.mo7608b() << 32) | ((long) lVar.mo7609c());
    }

    /* renamed from: a */
    private long m6737a(List<Long> list, long j) {
        List<Long> list2 = list;
        int size = list.size();
        long j2 = -1;
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            long longValue = j - list2.get(i2).longValue();
            if (j2 == -1 || Math.abs(j2) > Math.abs(longValue)) {
                i = i2;
                j2 = longValue;
            }
        }
        if (i > -1) {
            return list2.get(i).longValue();
        }
        return -1;
    }

    /* renamed from: a */
    private C1615k m6738a(C1605b bVar, C1613i iVar) {
        if (bVar == null) {
            return null;
        }
        if (!(bVar instanceof C1615k)) {
            if (bVar instanceof C1616l) {
                C1616l lVar = (C1616l) bVar;
                if (lVar.mo7604a() == null) {
                    long b = this.f5519e.mo7709b();
                    mo7770a(lVar, C1613i.f5141eK.equals(iVar));
                    this.f5519e.mo7706a(b);
                    if (lVar.mo7604a() == null) {
                        throw new IOException("Length object content was not read.");
                    }
                }
                if (lVar.mo7604a() instanceof C1615k) {
                    bVar = lVar.mo7604a();
                } else {
                    throw new IOException("Wrong type of referenced length object " + lVar + ": " + lVar.mo7604a().getClass().getSimpleName());
                }
            } else {
                throw new IOException("Wrong type of length object: " + bVar.getClass().getSimpleName());
            }
        }
        return (C1615k) bVar;
    }

    /* renamed from: a */
    private String m6739a(long j, int i) {
        return Long.toString(j) + " " + Integer.toString(i) + " obj";
    }

    /* renamed from: a */
    private void m6740a(OutputStream outputStream) {
        byte b;
        byte[] bArr = f5512c;
        int i = 0;
        while (true) {
            int read = this.f5519e.read(this.f5524o, i, 2048 - i);
            if (read <= 0) {
                break;
            }
            int i2 = read + i;
            int i3 = i2 - 5;
            byte[] bArr2 = bArr;
            int i4 = i;
            while (true) {
                if (i >= i2) {
                    break;
                }
                int i5 = i + 5;
                if (i4 != 0 || i5 >= i3 || ((b = this.f5524o[i5]) <= 116 && b >= 97)) {
                    byte b2 = this.f5524o[i];
                    if (b2 == bArr2[i4]) {
                        i4++;
                        if (i4 == bArr2.length) {
                            i++;
                            break;
                        }
                    } else {
                        if (i4 == 3) {
                            bArr2 = f5513d;
                            if (b2 == bArr2[i4]) {
                                i4++;
                            }
                        }
                        i4 = b2 == 101 ? 1 : (b2 == 110 && i4 == 7) ? 2 : 0;
                        bArr2 = f5512c;
                    }
                } else {
                    i = i5;
                }
                i++;
            }
            int max = Math.max(0, i - i4);
            if (max > 0) {
                outputStream.write(this.f5524o, 0, max);
            }
            if (i4 == bArr2.length) {
                this.f5519e.mo7710b(i2 - max);
                break;
            }
            System.arraycopy(bArr2, 0, this.f5524o, 0, i4);
            i = i4;
            bArr = bArr2;
        }
        outputStream.flush();
    }

    /* renamed from: a */
    private void m6741a(OutputStream outputStream, C1615k kVar) {
        long b = kVar.mo7585b();
        while (b > 0) {
            int i = b > PlaybackStateCompat.ACTION_PLAY_FROM_URI ? PKIFailureInfo.certRevoked : (int) b;
            int read = this.f5519e.read(this.f5532w, 0, i);
            if (read > 0) {
                outputStream.write(this.f5532w, 0, read);
                b -= (long) read;
            } else {
                throw new IOException("read error at offset " + this.f5519e.mo7709b() + ": expected " + i + " bytes, but read() returns " + read);
            }
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v6, resolved type: com.cyberneid.d.b.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v7, resolved type: com.cyberneid.d.b.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v11, resolved type: com.cyberneid.d.b.b} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r5v5, resolved type: com.cyberneid.d.b.o} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6742a(java.lang.Long r12, com.cyberneid.p105d.p108b.C1617m r13, com.cyberneid.p105d.p108b.C1616l r14) {
        /*
            r11 = this;
            com.cyberneid.d.d.h r0 = r11.f5519e
            long r1 = r12.longValue()
            r0.mo7706a(r1)
            int r0 = r11.mo7763m()
            long r0 = (long) r0
            int r2 = r11.mo7764n()
            char[] r3 = f5515g
            r4 = 1
            r11.mo7746a(r3, r4)
            long r3 = r13.mo7613b()
            int r5 = (r0 > r3 ? 1 : (r0 == r3 ? 0 : -1))
            if (r5 != 0) goto L_0x0131
            int r3 = r13.mo7611a()
            if (r2 != r3) goto L_0x0131
            r11.mo7762l()
            com.cyberneid.d.b.b r3 = r11.mo7756f()
            java.lang.String r10 = r11.mo7757g()
            java.lang.String r4 = "stream"
            boolean r4 = r10.equals(r4)
            if (r4 == 0) goto L_0x00a8
            com.cyberneid.d.d.h r4 = r11.f5519e
            java.nio.charset.Charset r5 = com.cyberneid.p105d.p131h.C1933a.f6111d
            byte[] r5 = r10.getBytes(r5)
            int r5 = r5.length
            r4.mo7710b(r5)
            boolean r4 = r3 instanceof com.cyberneid.p105d.p108b.C1607d
            if (r4 == 0) goto L_0x008c
            com.cyberneid.d.b.d r3 = (com.cyberneid.p105d.p108b.C1607d) r3
            com.cyberneid.d.b.o r3 = r11.mo7772a((com.cyberneid.p105d.p108b.C1607d) r3)
            com.cyberneid.d.g.b.m r4 = r11.f5522j
            if (r4 == 0) goto L_0x0060
            long r6 = r13.mo7613b()
            int r13 = r13.mo7611a()
            long r8 = (long) r13
            r5 = r3
            r4.mo8033a((com.cyberneid.p105d.p108b.C1619o) r5, (long) r6, (long) r8)
        L_0x0060:
            r11.mo7762l()
            java.lang.String r10 = r11.mo7758h()
            java.lang.String r13 = "endobj"
            boolean r13 = r10.startsWith(r13)
            if (r13 != 0) goto L_0x00b9
            java.lang.String r13 = "endstream"
            boolean r13 = r10.startsWith(r13)
            if (r13 == 0) goto L_0x00b9
            r13 = 9
            java.lang.String r13 = r10.substring(r13)
            java.lang.String r10 = r13.trim()
            int r13 = r10.length()
            if (r13 != 0) goto L_0x00b9
            java.lang.String r10 = r11.mo7758h()
            goto L_0x00b9
        L_0x008c:
            java.io.IOException r13 = new java.io.IOException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r0 = "Stream not preceded by dictionary (offset: "
            r14.append(r0)
            r14.append(r12)
            java.lang.String r12 = ")."
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            r13.<init>(r12)
            throw r13
        L_0x00a8:
            com.cyberneid.d.g.b.m r4 = r11.f5522j
            if (r4 == 0) goto L_0x00b9
            long r6 = r13.mo7613b()
            int r13 = r13.mo7611a()
            long r8 = (long) r13
            r5 = r3
            r4.mo8031a((com.cyberneid.p105d.p108b.C1605b) r5, (long) r6, (long) r8)
        L_0x00b9:
            r14.mo7607a((com.cyberneid.p105d.p108b.C1605b) r3)
            java.lang.String r13 = "endobj"
            boolean r13 = r10.startsWith(r13)
            if (r13 != 0) goto L_0x0130
            boolean r13 = r11.f5526q
            if (r13 == 0) goto L_0x00fc
            java.lang.String r13 = "PdfBox-Android"
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r3 = "Object ("
            r14.append(r3)
            r14.append(r0)
            java.lang.String r0 = ":"
            r14.append(r0)
            r14.append(r2)
            java.lang.String r0 = ") at offset "
            r14.append(r0)
            r14.append(r12)
            java.lang.String r12 = " does not end with 'endobj' but with '"
            r14.append(r12)
            r14.append(r10)
            java.lang.String r12 = "'"
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            android.util.Log.w(r13, r12)
            goto L_0x0130
        L_0x00fc:
            java.io.IOException r13 = new java.io.IOException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r3 = "Object ("
            r14.append(r3)
            r14.append(r0)
            java.lang.String r0 = ":"
            r14.append(r0)
            r14.append(r2)
            java.lang.String r0 = ") at offset "
            r14.append(r0)
            r14.append(r12)
            java.lang.String r12 = " does not end with 'endobj' but with '"
            r14.append(r12)
            r14.append(r10)
            java.lang.String r12 = "'"
            r14.append(r12)
            java.lang.String r12 = r14.toString()
            r13.<init>(r12)
            throw r13
        L_0x0130:
            return
        L_0x0131:
            java.io.IOException r12 = new java.io.IOException
            java.lang.StringBuilder r14 = new java.lang.StringBuilder
            r14.<init>()
            java.lang.String r3 = "XREF for "
            r14.append(r3)
            long r3 = r13.mo7613b()
            r14.append(r3)
            java.lang.String r3 = ":"
            r14.append(r3)
            int r13 = r13.mo7611a()
            r14.append(r13)
            java.lang.String r13 = " points to wrong object: "
            r14.append(r13)
            r14.append(r0)
            java.lang.String r13 = ":"
            r14.append(r13)
            r14.append(r2)
            java.lang.String r13 = r14.toString()
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1667b.m6742a(java.lang.Long, com.cyberneid.d.b.m, com.cyberneid.d.b.l):void");
    }

    /* renamed from: a */
    private void m6743a(Queue<C1605b> queue, C1605b bVar, Set<Long> set) {
        if (!(bVar instanceof C1616l) || set.add(Long.valueOf(m6736a((C1616l) bVar)))) {
            queue.add(bVar);
        }
    }

    /* renamed from: a */
    private void m6744a(Queue<C1605b> queue, Collection<C1605b> collection, Set<Long> set) {
        for (C1605b a : collection) {
            m6743a(queue, a, set);
        }
    }

    /* renamed from: a */
    private void m6745a(C1613i[] iVarArr, C1607d dVar, Set<Long> set) {
        if (iVarArr != null) {
            for (C1613i k : iVarArr) {
                C1605b k2 = dVar.mo7554k(k);
                if (k2 instanceof C1616l) {
                    set.add(Long.valueOf(m6736a((C1616l) k2)));
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m6746a(C1617m mVar, long j) {
        if (j < 6) {
            return false;
        }
        long b = mVar.mo7613b();
        int a = mVar.mo7611a();
        long b2 = this.f5519e.mo7709b();
        this.f5519e.mo7706a(j);
        try {
            if (m6748a(m6739a(b, a).getBytes(C1933a.f6111d))) {
                this.f5519e.mo7706a(b2);
                this.f5519e.mo7706a(b2);
                return true;
            }
        } catch (IOException unused) {
        } catch (Throwable th) {
            this.f5519e.mo7706a(b2);
            throw th;
        }
        this.f5519e.mo7706a(b2);
        return false;
    }

    /* JADX WARNING: Removed duplicated region for block: B:27:0x00d7 A[Catch:{ NumberFormatException -> 0x00de }] */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00eb  */
    /* JADX WARNING: Removed duplicated region for block: B:34:0x00f6  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m6747a(java.lang.String r7, java.lang.String r8) {
        /*
            r6 = this;
            java.lang.String r0 = r6.mo7758h()
            boolean r1 = r0.contains(r7)
            r2 = 0
            if (r1 != 0) goto L_0x0025
        L_0x000b:
            java.lang.String r0 = r6.mo7758h()
            boolean r1 = r0.contains(r7)
            if (r1 != 0) goto L_0x0025
            int r1 = r0.length()
            if (r1 <= 0) goto L_0x000b
            char r1 = r0.charAt(r2)
            boolean r1 = java.lang.Character.isDigit(r1)
            if (r1 == 0) goto L_0x000b
        L_0x0025:
            boolean r1 = r0.contains(r7)
            r3 = 0
            if (r1 != 0) goto L_0x0033
            com.cyberneid.d.d.h r7 = r6.f5519e
            r7.mo7706a(r3)
            return r2
        L_0x0033:
            int r1 = r0.indexOf(r7)
            if (r1 <= 0) goto L_0x0041
            int r5 = r0.length()
            java.lang.String r0 = r0.substring(r1, r5)
        L_0x0041:
            boolean r1 = r0.startsWith(r7)
            if (r1 == 0) goto L_0x0095
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            r1.append(r7)
            java.lang.String r5 = "\\d.\\d"
            r1.append(r5)
            java.lang.String r1 = r1.toString()
            boolean r1 = r0.matches(r1)
            if (r1 != 0) goto L_0x0095
            int r1 = r0.length()
            int r2 = r7.length()
            int r2 = r2 + 3
            if (r1 >= r2) goto L_0x00ca
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            r0.append(r7)
            r0.append(r8)
            java.lang.String r0 = r0.toString()
            java.lang.String r7 = "PdfBox-Android"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "No version found, set to "
            r1.append(r2)
            r1.append(r8)
            java.lang.String r8 = " as default."
            r1.append(r8)
            java.lang.String r8 = r1.toString()
            android.util.Log.d(r7, r8)
            goto L_0x00ca
        L_0x0095:
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            int r1 = r7.length()
            int r1 = r1 + 3
            int r5 = r0.length()
            java.lang.String r1 = r0.substring(r1, r5)
            r8.append(r1)
            java.lang.String r1 = "\n"
            r8.append(r1)
            java.lang.String r8 = r8.toString()
            int r7 = r7.length()
            int r7 = r7 + 3
            java.lang.String r0 = r0.substring(r2, r7)
            com.cyberneid.d.d.h r7 = r6.f5519e
            java.nio.charset.Charset r1 = com.cyberneid.p105d.p131h.C1933a.f6111d
            byte[] r8 = r8.getBytes(r1)
            int r8 = r8.length
            r7.mo7710b(r8)
        L_0x00ca:
            r7 = -1082130432(0xffffffffbf800000, float:-1.0)
            r8 = 1
            java.lang.String r1 = "-"
            java.lang.String[] r1 = r0.split(r1)     // Catch:{ NumberFormatException -> 0x00de }
            int r2 = r1.length     // Catch:{ NumberFormatException -> 0x00de }
            r5 = 2
            if (r2 != r5) goto L_0x00e6
            r1 = r1[r8]     // Catch:{ NumberFormatException -> 0x00de }
            float r7 = java.lang.Float.parseFloat(r1)     // Catch:{ NumberFormatException -> 0x00de }
            goto L_0x00e6
        L_0x00de:
            r1 = move-exception
            java.lang.String r2 = "PdfBox-Android"
            java.lang.String r5 = "Can't parse the header version."
            android.util.Log.d(r2, r5, r1)
        L_0x00e6:
            r1 = 0
            int r1 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r1 < 0) goto L_0x00f6
            com.cyberneid.d.b.e r0 = r6.f5511b
            r0.mo7561a((float) r7)
            com.cyberneid.d.d.h r7 = r6.f5519e
            r7.mo7706a(r3)
            return r8
        L_0x00f6:
            java.io.IOException r7 = new java.io.IOException
            java.lang.StringBuilder r8 = new java.lang.StringBuilder
            r8.<init>()
            java.lang.String r1 = "Error getting header version: "
            r8.append(r1)
            r8.append(r0)
            java.lang.String r8 = r8.toString()
            r7.<init>(r8)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1667b.m6747a(java.lang.String, java.lang.String):boolean");
    }

    /* renamed from: a */
    private boolean m6748a(byte[] bArr) {
        if (this.f5519e.mo7718g() != bArr[0]) {
            return false;
        }
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        int read = this.f5519e.read(bArr2, 0, length);
        while (read < length) {
            int read2 = this.f5519e.read(bArr2, read, length - read);
            if (read2 < 0) {
                break;
            }
            read += read2;
        }
        boolean equals = Arrays.equals(bArr, bArr2);
        this.f5519e.mo7710b(read);
        return equals;
    }

    /* renamed from: a */
    private boolean m6749a(char[] cArr) {
        long b = this.f5519e.mo7709b();
        for (char c : cArr) {
            if (this.f5519e.read() != c) {
                this.f5519e.mo7706a(b);
                return false;
            }
        }
        this.f5519e.mo7706a(b);
        return true;
    }

    /* renamed from: b */
    private long m6750b(long j, boolean z) {
        if (!this.f5526q || j == 0) {
            return j;
        }
        this.f5519e.mo7706a(j - 1);
        if (mo7753d(this.f5519e.read()) && mo7761k()) {
            try {
                mo7763m();
                mo7764n();
                mo7746a(f5515g, true);
                this.f5519e.mo7706a(j);
                return j;
            } catch (IOException unused) {
                this.f5519e.mo7706a(j);
            }
        }
        if (z) {
            return -1;
        }
        return m6752c(j, true);
    }

    /* renamed from: b */
    private long m6751b(char[] cArr) {
        char c = cArr[0];
        while (true) {
            if (this.f5519e.read() == c || this.f5519e.mo7716e()) {
                char c2 = cArr[1];
                int i = 1;
                while (!this.f5519e.mo7716e() && this.f5519e.read() == c2 && i < cArr.length - 1) {
                    i++;
                    c2 = cArr[i];
                }
                if (i == cArr.length - 1) {
                    return this.f5519e.mo7709b();
                }
                c = cArr[0];
                if (this.f5519e.mo7716e()) {
                    return -1;
                }
            }
        }
    }

    /* renamed from: c */
    private long m6752c(long j, boolean z) {
        String str;
        StringBuilder sb;
        if (j < 0) {
            str = "PdfBox-Android";
            sb = new StringBuilder();
            sb.append("Invalid object offset ");
            sb.append(j);
            sb.append(" when searching for a xref table/stream");
        } else {
            long d = m6755d(j, z);
            if (d > -1) {
                Log.d("PdfBox-Android", "Fixed reference for xref table/stream " + j + " -> " + d);
                return d;
            }
            str = "PdfBox-Android";
            sb = new StringBuilder();
            sb.append("Can't find the object axref table/stream at offset ");
            sb.append(j);
        }
        Log.e(str, sb.toString());
        return 0;
    }

    /* renamed from: c */
    private boolean m6753c(long j) {
        long b = this.f5519e.mo7709b();
        long j2 = b + j;
        boolean z = false;
        if (j2 > this.f5520h) {
            Log.w("PdfBox-Android", "The end of the stream is out of range, using workaround to read the stream, stream start position: " + b + ", length: " + j + ", expected end position: " + j2);
        } else {
            this.f5519e.mo7706a(j2);
            mo7762l();
            if (!m6748a(f5512c)) {
                Log.w("PdfBox-Android", "The end of the stream doesn't point to the correct offset, using workaround to read the stream, stream start position: " + b + ", length: " + j + ", expected end position: " + j2);
            } else {
                z = true;
            }
            this.f5519e.mo7706a(b);
        }
        return z;
    }

    /* renamed from: d */
    private long m6754d(long j) {
        if (!this.f5526q) {
            return j;
        }
        this.f5519e.mo7706a(j);
        if (this.f5519e.mo7718g() == 120 && m6749a(f5516l)) {
            return j;
        }
        if (j > 0) {
            long b = m6750b(j, true);
            if (b > -1) {
                return b;
            }
        }
        return m6752c(j, false);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:4:0x000c, code lost:
        r13 = r10.f5528s;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private long m6755d(long r11, boolean r13) {
        /*
            r10 = this;
            if (r13 != 0) goto L_0x0005
            r10.mo7799B()
        L_0x0005:
            r10.m6734C()
            r0 = -1
            if (r13 != 0) goto L_0x0015
            java.util.List<java.lang.Long> r13 = r10.f5528s
            if (r13 == 0) goto L_0x0015
            long r2 = r10.m6737a((java.util.List<java.lang.Long>) r13, (long) r11)
            goto L_0x0016
        L_0x0015:
            r2 = r0
        L_0x0016:
            java.util.List<java.lang.Long> r13 = r10.f5529t
            if (r13 == 0) goto L_0x001f
            long r4 = r10.m6737a((java.util.List<java.lang.Long>) r13, (long) r11)
            goto L_0x0020
        L_0x001f:
            r4 = r0
        L_0x0020:
            int r13 = (r2 > r0 ? 1 : (r2 == r0 ? 0 : -1))
            if (r13 <= 0) goto L_0x004c
            int r6 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r6 <= 0) goto L_0x004c
            long r0 = r11 - r2
            long r11 = r11 - r4
            long r6 = java.lang.Math.abs(r0)
            long r8 = java.lang.Math.abs(r11)
            int r13 = (r6 > r8 ? 1 : (r6 == r8 ? 0 : -1))
            if (r13 <= 0) goto L_0x0042
            java.util.List<java.lang.Long> r13 = r10.f5529t
            java.lang.Long r0 = java.lang.Long.valueOf(r4)
            r13.remove(r0)
            r0 = r11
            goto L_0x0067
        L_0x0042:
            java.util.List<java.lang.Long> r11 = r10.f5528s
            java.lang.Long r12 = java.lang.Long.valueOf(r2)
            r11.remove(r12)
            goto L_0x0067
        L_0x004c:
            if (r13 <= 0) goto L_0x0059
            java.util.List<java.lang.Long> r11 = r10.f5528s
            java.lang.Long r12 = java.lang.Long.valueOf(r2)
            r11.remove(r12)
            r0 = r2
            goto L_0x0067
        L_0x0059:
            int r11 = (r4 > r0 ? 1 : (r4 == r0 ? 0 : -1))
            if (r11 <= 0) goto L_0x0067
            java.util.List<java.lang.Long> r11 = r10.f5529t
            java.lang.Long r12 = java.lang.Long.valueOf(r4)
            r11.remove(r12)
            r0 = r4
        L_0x0067:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1667b.m6755d(long, boolean):long");
    }

    /* renamed from: h */
    private void m6756h(int i) {
        C1605b a = mo7769a((long) i, 0, true);
        if (a instanceof C1619o) {
            C1670e eVar = new C1670e((C1619o) a, this.f5511b);
            eVar.mo7778r();
            Set<Long> a2 = this.f5523k.mo7808a(i);
            for (C1616l next : eVar.mo7779s()) {
                C1617m mVar = new C1617m(next);
                if (a2.contains(Long.valueOf(mVar.mo7613b()))) {
                    this.f5511b.mo7558a(mVar).mo7607a(next.mo7604a());
                }
            }
        }
    }

    /* renamed from: z */
    private void mo7800z() {
        Map<C1617m, Long> d;
        if (this.f5526q && (d = this.f5523k.mo7815d()) != null) {
            boolean z = false;
            Iterator<Map.Entry<C1617m, Long>> it = d.entrySet().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Map.Entry next = it.next();
                C1617m mVar = (C1617m) next.getKey();
                Long l = (Long) next.getValue();
                if (l != null && l.longValue() >= 0 && !m6746a(mVar, l.longValue())) {
                    Log.d("PdfBox-Android", "Stop checking xref offsets as at least one couldn't be dereferenced");
                    z = true;
                    break;
                }
            }
            if (z) {
                mo7798A();
                Map<C1617m, Long> map = this.f5527r;
                if (map != null && !map.isEmpty()) {
                    Log.d("PdfBox-Android", "Replaced read xref table with the results of a brute force search");
                    d.putAll(this.f5527r);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public int mo7768a(char[] cArr, byte[] bArr, int i) {
        int length = cArr.length - 1;
        char c = cArr[length];
        while (true) {
            int i2 = length;
            while (true) {
                i--;
                if (i < 0) {
                    return -1;
                }
                if (bArr[i] == c) {
                    i2--;
                    if (i2 < 0) {
                        return i;
                    }
                    c = cArr[i2];
                } else if (i2 < length) {
                    break;
                }
            }
            c = cArr[length];
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1605b mo7769a(long j, int i, boolean z) {
        C1617m mVar = new C1617m(j, i);
        C1616l a = this.f5511b.mo7558a(mVar);
        if (a.mo7604a() == null) {
            Long l = this.f5523k.mo7815d().get(mVar);
            if (!z || (l != null && l.longValue() > 0)) {
                if (l == null && this.f5526q && this.f5527r == null) {
                    mo7798A();
                    Map<C1617m, Long> map = this.f5527r;
                    if (map != null && !map.isEmpty()) {
                        Log.d("PdfBox-Android", "Add all new read objects from brute force search to the xref table");
                        Map<C1617m, Long> d = this.f5523k.mo7815d();
                        for (Map.Entry next : this.f5527r.entrySet()) {
                            C1617m mVar2 = (C1617m) next.getKey();
                            if (!d.containsKey(mVar2)) {
                                d.put(mVar2, next.getValue());
                            }
                        }
                        l = d.get(mVar);
                    }
                }
                if (l == null) {
                    a.mo7607a((C1605b) C1614j.f5368b);
                } else if (l.longValue() > 0) {
                    m6742a(l, mVar, a);
                } else {
                    m6756h((int) (-l.longValue()));
                }
            } else {
                throw new IOException("Object must be defined and must not be compressed object: " + mVar.mo7613b() + ":" + mVar.mo7611a());
            }
        }
        return a.mo7604a();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final C1605b mo7770a(C1616l lVar, boolean z) {
        return mo7769a(lVar.mo7608b(), lVar.mo7609c(), z);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1607d mo7771a(long j) {
        this.f5519e.mo7706a(j);
        long max = Math.max(0, mo7781u());
        long d = m6754d(max);
        if (d > -1) {
            max = d;
        }
        this.f5511b.mo7562a(max);
        long j2 = max;
        while (true) {
            boolean z = true;
            if (j2 > 0) {
                this.f5519e.mo7706a(j2);
                mo7762l();
                if (this.f5519e.mo7718g() == 120) {
                    mo7776b(j2);
                    this.f5525p = this.f5519e.mo7709b();
                    while (this.f5526q && this.f5519e.mo7718g() != 116) {
                        if (this.f5519e.mo7709b() == this.f5525p) {
                            Log.w("PdfBox-Android", "Expected trailer object at position " + this.f5525p + ", keep trying");
                        }
                        mo7758h();
                    }
                    if (mo7782v()) {
                        C1607d b = this.f5523k.mo7813b();
                        if (b.mo7555l(C1613i.f5343ia)) {
                            int g = b.mo7547g(C1613i.f5343ia);
                            long j3 = (long) g;
                            long b2 = m6750b(j3, false);
                            if (b2 > -1 && b2 != j3) {
                                g = (int) b2;
                                b.mo7518a(C1613i.f5343ia, g);
                            }
                            if (g > 0) {
                                this.f5519e.mo7706a((long) g);
                                mo7762l();
                                m6735a(j2, false);
                            } else if (this.f5526q) {
                                Log.e("PdfBox-Android", "Skipped XRef stream due to a corrupt offset:" + g);
                            } else {
                                throw new IOException("Skipped XRef stream due to a corrupt offset:" + g);
                            }
                        }
                        j2 = (long) b.mo7547g(C1613i.f5190fG);
                        if (j2 > 0) {
                            long d2 = m6754d(j2);
                            if (d2 > -1 && d2 != j2) {
                                b.mo7520a(C1613i.f5190fG, d2);
                                j2 = d2;
                            }
                        }
                    } else {
                        throw new IOException("Expected trailer object at position: " + this.f5519e.mo7709b());
                    }
                } else {
                    j2 = m6735a(j2, true);
                    if (j2 > 0) {
                        long d3 = m6754d(j2);
                        if (d3 > -1 && d3 != j2) {
                            this.f5523k.mo7813b().mo7520a(C1613i.f5190fG, d3);
                            j2 = d3;
                        }
                    }
                }
            } else {
                this.f5523k.mo7809a(max);
                C1607d c = this.f5523k.mo7814c();
                this.f5511b.mo7569c(c);
                C1608e eVar = this.f5511b;
                if (C1680l.C1682a.STREAM != this.f5523k.mo7807a()) {
                    z = false;
                }
                eVar.mo7567b(z);
                mo7800z();
                this.f5511b.mo7564a(this.f5523k.mo7815d());
                return c;
            }
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:28:0x0094  */
    /* JADX WARNING: Removed duplicated region for block: B:29:0x00b9  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.cyberneid.p105d.p108b.C1619o mo7772a(com.cyberneid.p105d.p108b.C1607d r7) {
        /*
            r6 = this;
            com.cyberneid.d.b.e r0 = r6.f5511b
            com.cyberneid.d.b.o r0 = r0.mo7560a((com.cyberneid.p105d.p108b.C1607d) r7)
            r6.mo7757g()
            r6.mo7748b()
            com.cyberneid.d.b.i r1 = com.cyberneid.p105d.p108b.C1613i.f5095dR
            com.cyberneid.d.b.b r1 = r7.mo7554k(r1)
            com.cyberneid.d.b.i r2 = com.cyberneid.p105d.p108b.C1613i.f5338hw
            com.cyberneid.d.b.i r7 = r7.mo7543d(r2)
            com.cyberneid.d.b.k r7 = r6.m6738a((com.cyberneid.p105d.p108b.C1605b) r1, (com.cyberneid.p105d.p108b.C1613i) r7)
            if (r7 != 0) goto L_0x0047
            boolean r1 = r6.f5526q
            if (r1 == 0) goto L_0x003f
            java.lang.String r1 = "PdfBox-Android"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "The stream doesn't provide any stream length, using fallback readUntilEnd, at offset "
            r2.append(r3)
            com.cyberneid.d.d.h r3 = r6.f5519e
            long r3 = r3.mo7709b()
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            android.util.Log.w(r1, r2)
            goto L_0x0047
        L_0x003f:
            java.io.IOException r7 = new java.io.IOException
            java.lang.String r0 = "Missing length for stream."
            r7.<init>(r0)
            throw r7
        L_0x0047:
            if (r7 == 0) goto L_0x0068
            long r1 = r7.mo7585b()
            boolean r1 = r6.m6753c(r1)
            if (r1 == 0) goto L_0x0068
            java.io.OutputStream r1 = r0.mo7631p()
            r6.m6741a((java.io.OutputStream) r1, (com.cyberneid.p105d.p108b.C1615k) r7)     // Catch:{ all -> 0x005e }
            r1.close()
            goto L_0x0079
        L_0x005e:
            r2 = move-exception
            r1.close()
            com.cyberneid.d.b.i r1 = com.cyberneid.p105d.p108b.C1613i.f5095dR
            r0.mo7521a((com.cyberneid.p105d.p108b.C1613i) r1, (com.cyberneid.p105d.p108b.C1605b) r7)
            throw r2
        L_0x0068:
            java.io.OutputStream r1 = r0.mo7631p()
            com.cyberneid.d.e.c r2 = new com.cyberneid.d.e.c     // Catch:{ all -> 0x0135 }
            r2.<init>(r1)     // Catch:{ all -> 0x0135 }
            r6.m6740a((java.io.OutputStream) r2)     // Catch:{ all -> 0x0135 }
            r1.close()
            if (r7 == 0) goto L_0x007f
        L_0x0079:
            com.cyberneid.d.b.i r1 = com.cyberneid.p105d.p108b.C1613i.f5095dR
            r0.mo7521a((com.cyberneid.p105d.p108b.C1613i) r1, (com.cyberneid.p105d.p108b.C1605b) r7)
            goto L_0x0084
        L_0x007f:
            com.cyberneid.d.b.i r7 = com.cyberneid.p105d.p108b.C1613i.f5095dR
            r0.mo7553j(r7)
        L_0x0084:
            java.lang.String r7 = r6.mo7757g()
            java.lang.String r1 = "endobj"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x00b9
            boolean r1 = r6.f5526q
            if (r1 == 0) goto L_0x00b9
            java.lang.String r7 = "PdfBox-Android"
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "stream ends with 'endobj' instead of 'endstream' at offset "
            r1.append(r2)
            com.cyberneid.d.d.h r2 = r6.f5519e
            long r2 = r2.mo7709b()
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            android.util.Log.w(r7, r1)
            com.cyberneid.d.d.h r7 = r6.f5519e
            byte[] r1 = f5513d
            int r1 = r1.length
            r7.mo7710b(r1)
            goto L_0x010f
        L_0x00b9:
            int r1 = r7.length()
            r2 = 9
            if (r1 <= r2) goto L_0x0107
            boolean r1 = r6.f5526q
            if (r1 == 0) goto L_0x0107
            r1 = 0
            java.lang.String r1 = r7.substring(r1, r2)
            java.lang.String r3 = "endstream"
            boolean r1 = r1.equals(r3)
            if (r1 == 0) goto L_0x0107
            java.lang.String r1 = "PdfBox-Android"
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "stream ends with '"
            r3.append(r4)
            r3.append(r7)
            java.lang.String r4 = "' instead of 'endstream' at offset "
            r3.append(r4)
            com.cyberneid.d.d.h r4 = r6.f5519e
            long r4 = r4.mo7709b()
            r3.append(r4)
            java.lang.String r3 = r3.toString()
            android.util.Log.w(r1, r3)
            com.cyberneid.d.d.h r1 = r6.f5519e
            java.lang.String r7 = r7.substring(r2)
            java.nio.charset.Charset r2 = com.cyberneid.p105d.p131h.C1933a.f6111d
            byte[] r7 = r7.getBytes(r2)
            int r7 = r7.length
            r1.mo7710b(r7)
            goto L_0x010f
        L_0x0107:
            java.lang.String r1 = "endstream"
            boolean r1 = r7.equals(r1)
            if (r1 == 0) goto L_0x0110
        L_0x010f:
            return r0
        L_0x0110:
            java.io.IOException r0 = new java.io.IOException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Error reading stream, expected='endstream' actual='"
            r1.append(r2)
            r1.append(r7)
            java.lang.String r7 = "' at offset "
            r1.append(r7)
            com.cyberneid.d.d.h r7 = r6.f5519e
            long r2 = r7.mo7709b()
            r1.append(r2)
            java.lang.String r7 = r1.toString()
            r0.<init>(r7)
            throw r0
        L_0x0135:
            r2 = move-exception
            r1.close()
            if (r7 == 0) goto L_0x0141
            com.cyberneid.d.b.i r1 = com.cyberneid.p105d.p108b.C1613i.f5095dR
            r0.mo7521a((com.cyberneid.p105d.p108b.C1613i) r1, (com.cyberneid.p105d.p108b.C1605b) r7)
            goto L_0x0146
        L_0x0141:
            com.cyberneid.d.b.i r7 = com.cyberneid.p105d.p108b.C1613i.f5095dR
            r0.mo7553j(r7)
        L_0x0146:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1667b.mo7772a(com.cyberneid.d.b.d):com.cyberneid.d.b.o");
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x010b, code lost:
        if (r1.isEmpty() == false) goto L_0x010e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x010e, code lost:
        r14 = ((java.util.List) r1.remove(r1.firstKey())).iterator();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x0120, code lost:
        if (r14.hasNext() == false) goto L_0x001e;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x0122, code lost:
        r4 = (com.cyberneid.p105d.p108b.C1616l) r14.next();
        r5 = mo7770a(r4, false);
        r4.mo7607a(r5);
        m6743a((java.util.Queue<com.cyberneid.p105d.p108b.C1605b>) r0, r5, (java.util.Set<java.lang.Long>) r3);
        r2.add(java.lang.Long.valueOf(m6736a(r4)));
     */
    /* JADX WARNING: Code restructure failed: missing block: B:59:?, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo7773a(com.cyberneid.p105d.p108b.C1607d r14, com.cyberneid.p105d.p108b.C1613i... r15) {
        /*
            r13 = this;
            java.util.LinkedList r0 = new java.util.LinkedList
            r0.<init>()
            java.util.TreeMap r1 = new java.util.TreeMap
            r1.<init>()
            java.util.HashSet r2 = new java.util.HashSet
            r2.<init>()
            java.util.HashSet r3 = new java.util.HashSet
            r3.<init>()
            r13.m6745a((com.cyberneid.p105d.p108b.C1613i[]) r15, (com.cyberneid.p105d.p108b.C1607d) r14, (java.util.Set<java.lang.Long>) r2)
            java.util.Collection r14 = r14.mo7548g()
            r13.m6744a((java.util.Queue<com.cyberneid.p105d.p108b.C1605b>) r0, (java.util.Collection<com.cyberneid.p105d.p108b.C1605b>) r14, (java.util.Set<java.lang.Long>) r3)
        L_0x001e:
            boolean r14 = r0.isEmpty()
            if (r14 == 0) goto L_0x002a
            boolean r14 = r1.isEmpty()
            if (r14 != 0) goto L_0x010d
        L_0x002a:
            java.lang.Object r14 = r0.poll()
            com.cyberneid.d.b.b r14 = (com.cyberneid.p105d.p108b.C1605b) r14
            r15 = 0
            if (r14 == 0) goto L_0x0107
            boolean r4 = r14 instanceof com.cyberneid.p105d.p108b.C1607d
            if (r4 == 0) goto L_0x0041
            com.cyberneid.d.b.d r14 = (com.cyberneid.p105d.p108b.C1607d) r14
            java.util.Collection r14 = r14.mo7548g()
            r13.m6744a((java.util.Queue<com.cyberneid.p105d.p108b.C1605b>) r0, (java.util.Collection<com.cyberneid.p105d.p108b.C1605b>) r14, (java.util.Set<java.lang.Long>) r3)
            goto L_0x002a
        L_0x0041:
            boolean r4 = r14 instanceof com.cyberneid.p105d.p108b.C1604a
            if (r4 == 0) goto L_0x005b
            com.cyberneid.d.b.a r14 = (com.cyberneid.p105d.p108b.C1604a) r14
            java.util.Iterator r14 = r14.iterator()
        L_0x004b:
            boolean r15 = r14.hasNext()
            if (r15 == 0) goto L_0x002a
            java.lang.Object r15 = r14.next()
            com.cyberneid.d.b.b r15 = (com.cyberneid.p105d.p108b.C1605b) r15
            r13.m6743a((java.util.Queue<com.cyberneid.p105d.p108b.C1605b>) r0, (com.cyberneid.p105d.p108b.C1605b) r15, (java.util.Set<java.lang.Long>) r3)
            goto L_0x004b
        L_0x005b:
            boolean r4 = r14 instanceof com.cyberneid.p105d.p108b.C1616l
            if (r4 == 0) goto L_0x002a
            com.cyberneid.d.b.l r14 = (com.cyberneid.p105d.p108b.C1616l) r14
            long r4 = r13.m6736a((com.cyberneid.p105d.p108b.C1616l) r14)
            com.cyberneid.d.b.m r6 = new com.cyberneid.d.b.m
            long r7 = r14.mo7608b()
            int r9 = r14.mo7609c()
            r6.<init>(r7, r9)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            boolean r4 = r2.contains(r4)
            if (r4 != 0) goto L_0x002a
            com.cyberneid.d.e.l r4 = r13.f5523k
            java.util.Map r4 = r4.mo7815d()
            java.lang.Object r4 = r4.get(r6)
            java.lang.Long r4 = (java.lang.Long) r4
            if (r4 == 0) goto L_0x00fa
            long r7 = r4.longValue()
            r9 = 0
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 == 0) goto L_0x00fa
            long r7 = r4.longValue()
            int r5 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r5 <= 0) goto L_0x00a4
            java.util.List r14 = java.util.Collections.singletonList(r14)
            r1.put(r4, r14)
            goto L_0x002a
        L_0x00a4:
            com.cyberneid.d.e.l r5 = r13.f5523k
            java.util.Map r5 = r5.mo7815d()
            com.cyberneid.d.b.m r7 = new com.cyberneid.d.b.m
            long r11 = r4.longValue()
            long r11 = -r11
            int r4 = (int) r11
            long r11 = (long) r4
            r7.<init>(r11, r15)
            java.lang.Object r15 = r5.get(r7)
            java.lang.Long r15 = (java.lang.Long) r15
            if (r15 == 0) goto L_0x00db
            long r4 = r15.longValue()
            int r7 = (r4 > r9 ? 1 : (r4 == r9 ? 0 : -1))
            if (r7 <= 0) goto L_0x00db
            java.lang.Object r4 = r1.get(r15)
            java.util.List r4 = (java.util.List) r4
            if (r4 != 0) goto L_0x00d6
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>()
            r1.put(r15, r4)
        L_0x00d6:
            r4.add(r14)
            goto L_0x002a
        L_0x00db:
            java.io.IOException r14 = new java.io.IOException
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Invalid object stream xref object reference for key '"
            r0.append(r1)
            r0.append(r6)
            java.lang.String r1 = "': "
            r0.append(r1)
            r0.append(r15)
            java.lang.String r15 = r0.toString()
            r14.<init>(r15)
            throw r14
        L_0x00fa:
            com.cyberneid.d.b.e r14 = r13.f5511b
            com.cyberneid.d.b.l r14 = r14.mo7558a((com.cyberneid.p105d.p108b.C1617m) r6)
            com.cyberneid.d.b.j r15 = com.cyberneid.p105d.p108b.C1614j.f5368b
            r14.mo7607a((com.cyberneid.p105d.p108b.C1605b) r15)
            goto L_0x002a
        L_0x0107:
            boolean r14 = r1.isEmpty()
            if (r14 == 0) goto L_0x010e
        L_0x010d:
            return
        L_0x010e:
            java.lang.Object r14 = r1.firstKey()
            java.lang.Object r14 = r1.remove(r14)
            java.util.List r14 = (java.util.List) r14
            java.util.Iterator r14 = r14.iterator()
        L_0x011c:
            boolean r4 = r14.hasNext()
            if (r4 == 0) goto L_0x001e
            java.lang.Object r4 = r14.next()
            com.cyberneid.d.b.l r4 = (com.cyberneid.p105d.p108b.C1616l) r4
            com.cyberneid.d.b.b r5 = r13.mo7770a((com.cyberneid.p105d.p108b.C1616l) r4, (boolean) r15)
            r4.mo7607a((com.cyberneid.p105d.p108b.C1605b) r5)
            r13.m6743a((java.util.Queue<com.cyberneid.p105d.p108b.C1605b>) r0, (com.cyberneid.p105d.p108b.C1605b) r5, (java.util.Set<java.lang.Long>) r3)
            long r4 = r13.m6736a((com.cyberneid.p105d.p108b.C1616l) r4)
            java.lang.Long r4 = java.lang.Long.valueOf(r4)
            r2.add(r4)
            goto L_0x011c
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1667b.mo7773a(com.cyberneid.d.b.d, com.cyberneid.d.b.i[]):void");
    }

    /* renamed from: a */
    public void mo7774a(C1619o oVar, long j, boolean z) {
        if (z) {
            this.f5523k.mo7810a(j, C1680l.C1682a.STREAM);
            this.f5523k.mo7811a((C1607d) oVar);
        }
        new C1677i(oVar, this.f5511b, this.f5523k).mo7778r();
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public C1605b mo7775b(C1607d dVar) {
        for (C1605b next : dVar.mo7548g()) {
            if (next instanceof C1616l) {
                mo7770a((C1616l) next, false);
            }
        }
        C1616l lVar = (C1616l) dVar.mo7554k(C1613i.f5271gi);
        if (lVar != null) {
            return mo7770a(lVar, false);
        }
        throw new IOException("Missing root object specification in trailer.");
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo7776b(long j) {
        if (this.f5519e.mo7718g() != 120 || !mo7757g().trim().equals("xref")) {
            return false;
        }
        String g = mo7757g();
        this.f5519e.mo7710b(g.getBytes(C1933a.f6111d).length);
        this.f5523k.mo7810a(j, C1680l.C1682a.TABLE);
        if (g.startsWith("trailer")) {
            Log.w("PdfBox-Android", "skipping empty xref table");
            return false;
        }
        do {
            long p = mo7766p();
            mo7762l();
            long m = (long) mo7763m();
            int i = 0;
            while (true) {
                if (((long) i) >= p || this.f5519e.mo7716e() || mo7747a((int) (char) this.f5519e.mo7718g()) || this.f5519e.mo7718g() == 116) {
                    break;
                }
                String h = mo7758h();
                String[] split = h.split("\\s");
                if (split.length < 3) {
                    Log.w("PdfBox-Android", "invalid xref line: " + h);
                    break;
                }
                if (split[split.length - 1].equals("n")) {
                    try {
                        long parseLong = Long.parseLong(split[0]);
                        this.f5523k.mo7812a(new C1617m(m, Integer.parseInt(split[1])), parseLong);
                    } catch (NumberFormatException e) {
                        throw new IOException(e);
                    }
                } else if (!split[2].equals("f")) {
                    throw new IOException("Corrupt XRefTable Entry - ObjID:" + m);
                }
                m++;
                mo7762l();
                i++;
            }
            mo7762l();
        } while (mo7761k());
        return true;
    }

    /* renamed from: g */
    public void mo7777g(int i) {
        if (i > 15) {
            this.f5530u = i;
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: protected */
    /* renamed from: r */
    public final long mo7778r() {
        try {
            int i = this.f5520h < ((long) this.f5530u) ? (int) this.f5520h : this.f5530u;
            byte[] bArr = new byte[i];
            long j = this.f5520h - ((long) i);
            this.f5519e.mo7706a(j);
            int i2 = 0;
            while (i2 < i) {
                int i3 = i - i2;
                int read = this.f5519e.read(bArr, i2, i3);
                if (read >= 1) {
                    i2 += read;
                } else {
                    throw new IOException("No more bytes to read for trailing buffer, but expected: " + i3);
                }
            }
            this.f5519e.mo7706a(0);
            int a = mo7768a(f5514f, bArr, bArr.length);
            if (a < 0) {
                if (this.f5526q) {
                    a = bArr.length;
                    Log.d("PdfBox-Android", "Missing end of file marker '" + new String(f5514f) + "'");
                } else {
                    throw new IOException("Missing end of file marker '" + new String(f5514f) + "'");
                }
            }
            int a2 = mo7768a(f5518n, bArr, a);
            long j2 = j + ((long) a2);
            if (a2 >= 0) {
                return j2;
            }
            if (this.f5526q) {
                Log.d("PdfBox-Android", "Can't find offset for startxref");
                return -1;
            }
            throw new IOException("Missing 'startxref' marker.");
        } catch (Throwable th) {
            this.f5519e.mo7706a(0);
            throw th;
        }
    }

    /* renamed from: s */
    public boolean mo7779s() {
        return this.f5526q;
    }

    /* access modifiers changed from: protected */
    /* renamed from: t */
    public final C1607d mo7780t() {
        C1613i iVar;
        C1608e eVar;
        Object key;
        mo7798A();
        if (this.f5527r == null) {
            return null;
        }
        this.f5523k.mo7810a(0, C1680l.C1682a.TABLE);
        for (Map.Entry next : this.f5527r.entrySet()) {
            this.f5523k.mo7812a((C1617m) next.getKey(), ((Long) next.getValue()).longValue());
        }
        this.f5523k.mo7809a(0);
        C1607d c = this.f5523k.mo7814c();
        mo7785y().mo7569c(c);
        for (Map.Entry next2 : this.f5527r.entrySet()) {
            this.f5519e.mo7706a(((Long) next2.getValue()).longValue());
            mo7763m();
            mo7764n();
            mo7746a(f5515g, true);
            try {
                C1607d a = mo7743a();
                if (a != null) {
                    if (C1613i.f4956al.equals(a.mo7543d(C1613i.f5338hw))) {
                        iVar = C1613i.f5271gi;
                        eVar = this.f5511b;
                        key = next2.getKey();
                    } else if (a.mo7555l(C1613i.f5324hi) || a.mo7555l(C1613i.f4895D) || a.mo7555l(C1613i.f5257gU) || a.mo7555l(C1613i.f5083dF) || a.mo7555l(C1613i.f4939aU) || a.mo7555l(C1613i.f5196fM) || a.mo7555l(C1613i.f4938aT)) {
                        iVar = C1613i.f5124du;
                        eVar = this.f5511b;
                        key = next2.getKey();
                    }
                    c.mo7521a(iVar, (C1605b) eVar.mo7558a((C1617m) key));
                }
            } catch (IOException unused) {
                Log.d("PdfBox-Android", "Skipped object " + next2.getKey() + ", either it's corrupt or not a dictionary");
            }
        }
        return c;
    }

    /* access modifiers changed from: protected */
    /* renamed from: u */
    public long mo7781u() {
        if (!m6749a(f5518n)) {
            return -1;
        }
        mo7757g();
        mo7762l();
        return mo7766p();
    }

    /* access modifiers changed from: protected */
    /* renamed from: v */
    public boolean mo7782v() {
        if (this.f5519e.mo7718g() != 116) {
            return false;
        }
        long b = this.f5519e.mo7709b();
        String h = mo7758h();
        if (!h.trim().equals("trailer")) {
            if (!h.startsWith("trailer")) {
                return false;
            }
            this.f5519e.mo7706a(b + ((long) 7));
        }
        mo7762l();
        this.f5523k.mo7811a(mo7743a());
        mo7762l();
        return true;
    }

    /* access modifiers changed from: protected */
    /* renamed from: w */
    public boolean mo7783w() {
        return m6747a("%PDF-", "1.4");
    }

    /* access modifiers changed from: protected */
    /* renamed from: x */
    public boolean mo7784x() {
        return m6747a("%FDF-", "1.0");
    }

    /* renamed from: y */
    public C1608e mo7785y() {
        if (this.f5511b != null) {
            return this.f5511b;
        }
        throw new IOException("You must call parse() before calling getDocument()");
    }
}
