package com.cyberneid.p105d.p112e;

import android.util.Log;
import com.cyberneid.p105d.p108b.C1604a;
import com.cyberneid.p105d.p108b.C1605b;
import com.cyberneid.p105d.p108b.C1606c;
import com.cyberneid.p105d.p108b.C1607d;
import com.cyberneid.p105d.p108b.C1608e;
import com.cyberneid.p105d.p108b.C1612h;
import com.cyberneid.p105d.p108b.C1613i;
import com.cyberneid.p105d.p108b.C1614j;
import com.cyberneid.p105d.p108b.C1615k;
import com.cyberneid.p105d.p108b.C1616l;
import com.cyberneid.p105d.p108b.C1617m;
import com.cyberneid.p105d.p108b.C1622p;
import com.cyberneid.p105d.p131h.C1933a;
import java.io.IOException;
import java.util.Arrays;
import org.spongycastle.pqc.math.linearalgebra.Matrix;

/* renamed from: com.cyberneid.d.e.a */
public abstract class C1666a {

    /* renamed from: a */
    protected final C1679k f5510a;

    /* renamed from: b */
    protected C1608e f5511b;

    public C1666a(C1679k kVar) {
        this.f5510a = kVar;
    }

    /* renamed from: a */
    private C1605b m6697a(C1617m mVar) {
        C1608e eVar = this.f5511b;
        if (eVar != null) {
            return eVar.mo7558a(mVar);
        }
        throw new IOException("object reference " + mVar + " at offset " + this.f5510a.mo7792b() + " in content stream");
    }

    /* renamed from: a */
    private void mo7772a(C1607d dVar) {
        C1613i e = mo7754e();
        C1605b r = mo7778r();
        mo7762l();
        if (((char) this.f5510a.mo7795c()) == 'd') {
            String g = mo7757g();
            if (!g.equals("def")) {
                this.f5510a.mo7793b(g.getBytes(C1933a.f6111d));
            } else {
                mo7762l();
            }
        }
        if (r == null) {
            Log.w("PdfBox-Android", "Bad Dictionary Declaration " + this.f5510a);
            return;
        }
        r.mo7504a(true);
        dVar.mo7521a(e, r);
    }

    /* renamed from: b */
    private static boolean m6699b(char c) {
        return m6700f(c) || (c >= 'a' && c <= 'f') || (c >= 'A' && c <= 'F');
    }

    /* renamed from: f */
    protected static boolean m6700f(int i) {
        return i >= 48 && i <= 57;
    }

    /* renamed from: g */
    private int mo7777g(int i) {
        byte[] bArr = new byte[3];
        int a = this.f5510a.mo7789a(bArr);
        if ((a == 3 && bArr[0] == 13 && bArr[1] == 10 && bArr[2] == 47) || (bArr[0] == 13 && bArr[1] == 47)) {
            i = 0;
        }
        if (a > 0) {
            this.f5510a.mo7793b(Arrays.copyOfRange(bArr, 0, a));
        }
        return i;
    }

    /* renamed from: h */
    private boolean m6702h(int i) {
        return 10 == i;
    }

    /* renamed from: i */
    private boolean m6703i(int i) {
        return 13 == i;
    }

    /* renamed from: r */
    private C1605b mo7778r() {
        long b = this.f5510a.mo7792b();
        C1605b f = mo7756f();
        mo7762l();
        if (!mo7761k()) {
            return f;
        }
        long b2 = this.f5510a.mo7792b();
        C1605b f2 = mo7756f();
        mo7762l();
        mo7744a((char) Matrix.MATRIX_TYPE_RANDOM_REGULAR);
        if (!(f instanceof C1612h)) {
            throw new IOException("expected number, actual=" + f + " at offset " + b);
        } else if (f2 instanceof C1612h) {
            return m6697a(new C1617m(((C1612h) f).mo7585b(), ((C1612h) f2).mo7586c()));
        } else {
            throw new IOException("expected number, actual=" + f + " at offset " + b2);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:38:0x008a A[RETURN] */
    /* JADX WARNING: Removed duplicated region for block: B:39:0x008b  */
    /* renamed from: s */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean mo7779s() {
        /*
            r6 = this;
        L_0x0000:
            com.cyberneid.d.e.k r0 = r6.f5510a
            int r0 = r0.mo7788a()
            r1 = -1
            r2 = 0
            r3 = 1
            if (r0 == r1) goto L_0x0088
            r4 = 47
            if (r0 == r4) goto L_0x0088
            r4 = 62
            if (r0 == r4) goto L_0x0088
            r1 = 101(0x65, float:1.42E-43)
            if (r0 != r1) goto L_0x0000
            com.cyberneid.d.e.k r0 = r6.f5510a
            int r0 = r0.mo7788a()
            r4 = 110(0x6e, float:1.54E-43)
            if (r0 != r4) goto L_0x0000
            com.cyberneid.d.e.k r0 = r6.f5510a
            int r0 = r0.mo7788a()
            r4 = 100
            if (r0 != r4) goto L_0x0000
            com.cyberneid.d.e.k r0 = r6.f5510a
            int r0 = r0.mo7788a()
            r4 = 115(0x73, float:1.61E-43)
            if (r0 != r4) goto L_0x0067
            com.cyberneid.d.e.k r4 = r6.f5510a
            int r4 = r4.mo7788a()
            r5 = 116(0x74, float:1.63E-43)
            if (r4 != r5) goto L_0x0067
            com.cyberneid.d.e.k r4 = r6.f5510a
            int r4 = r4.mo7788a()
            r5 = 114(0x72, float:1.6E-43)
            if (r4 != r5) goto L_0x0067
            com.cyberneid.d.e.k r4 = r6.f5510a
            int r4 = r4.mo7788a()
            if (r4 != r1) goto L_0x0067
            com.cyberneid.d.e.k r1 = r6.f5510a
            int r1 = r1.mo7788a()
            r4 = 97
            if (r1 != r4) goto L_0x0067
            com.cyberneid.d.e.k r1 = r6.f5510a
            int r1 = r1.mo7788a()
            r4 = 109(0x6d, float:1.53E-43)
            if (r1 != r4) goto L_0x0067
            r1 = 1
            goto L_0x0068
        L_0x0067:
            r1 = 0
        L_0x0068:
            if (r1 != 0) goto L_0x0083
            r4 = 111(0x6f, float:1.56E-43)
            if (r0 != r4) goto L_0x0083
            com.cyberneid.d.e.k r0 = r6.f5510a
            int r0 = r0.mo7788a()
            r4 = 98
            if (r0 != r4) goto L_0x0083
            com.cyberneid.d.e.k r0 = r6.f5510a
            int r0 = r0.mo7788a()
            r4 = 106(0x6a, float:1.49E-43)
            if (r0 != r4) goto L_0x0083
            r2 = 1
        L_0x0083:
            if (r1 != 0) goto L_0x0087
            if (r2 == 0) goto L_0x0000
        L_0x0087:
            return r3
        L_0x0088:
            if (r0 != r1) goto L_0x008b
            return r3
        L_0x008b:
            com.cyberneid.d.e.k r1 = r6.f5510a
            r1.mo7791a((int) r0)
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1666a.mo7779s():boolean");
    }

    /* renamed from: t */
    private C1622p mo7780t() {
        int a;
        StringBuilder sb = new StringBuilder();
        while (true) {
            int a2 = this.f5510a.mo7788a();
            char c = (char) a2;
            if (!m6699b(c)) {
                if (a2 == 62) {
                    break;
                } else if (a2 < 0) {
                    throw new IOException("Missing closing bracket for hex string. Reached EOS.");
                } else if (!(a2 == 32 || a2 == 10 || a2 == 9 || a2 == 13 || a2 == 8 || a2 == 12)) {
                    if (sb.length() % 2 != 0) {
                        sb.deleteCharAt(sb.length() - 1);
                    }
                    do {
                        a = this.f5510a.mo7788a();
                        if (a == 62) {
                            break;
                        }
                    } while (a >= 0);
                    if (a < 0) {
                        throw new IOException("Missing closing bracket for hex string. Reached EOS.");
                    }
                }
            } else {
                sb.append(c);
            }
        }
        return C1622p.m6500a(sb.toString());
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public C1607d mo7743a() {
        mo7744a('<');
        mo7744a('<');
        mo7762l();
        C1607d dVar = new C1607d();
        boolean z = false;
        while (!z) {
            mo7762l();
            char c = (char) this.f5510a.mo7795c();
            if (c == '>') {
                z = true;
            } else if (c == '/') {
                mo7772a(dVar);
            } else {
                Log.w("PdfBox-Android", "Invalid dictionary, found: '" + c + "' but expected: '/'");
                if (mo7779s()) {
                    return dVar;
                }
            }
        }
        mo7744a('>');
        mo7744a('>');
        return dVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7744a(char c) {
        char a = (char) this.f5510a.mo7788a();
        if (a != c) {
            throw new IOException("expected='" + c + "' actual='" + a + "' at offset " + this.f5510a.mo7792b());
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public void mo7745a(String str) {
        mo7746a(str.toCharArray(), false);
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final void mo7746a(char[] cArr, boolean z) {
        mo7762l();
        int length = cArr.length;
        int i = 0;
        while (i < length) {
            char c = cArr[i];
            if (this.f5510a.mo7788a() == c) {
                i++;
            } else {
                throw new IOException("Expected string '" + new String(cArr) + "' but missed at character '" + c + "' at offset " + this.f5510a.mo7792b());
            }
        }
        mo7762l();
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public boolean mo7747a(int i) {
        return i == 32 || i == 13 || i == 10 || i == 9 || i == 62 || i == 60 || i == 91 || i == 47 || i == 93 || i == 41 || i == 40;
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public void mo7748b() {
        int a;
        do {
            a = this.f5510a.mo7788a();
        } while (32 == a);
        if (13 == a) {
            a = this.f5510a.mo7788a();
            if (10 == a) {
                return;
            }
        } else if (10 == a) {
            return;
        }
        this.f5510a.mo7791a(a);
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public boolean mo7749b(int i) {
        return i == 93;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0028, code lost:
        if (r4 != 0) goto L_0x0032;
     */
    /* JADX WARNING: Removed duplicated region for block: B:59:0x00ef  */
    /* JADX WARNING: Removed duplicated region for block: B:73:0x0019 A[SYNTHETIC] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.cyberneid.p105d.p108b.C1622p mo7750c() {
        /*
            r11 = this;
            com.cyberneid.d.e.k r0 = r11.f5510a
            int r0 = r0.mo7788a()
            char r0 = (char) r0
            r1 = 40
            if (r0 != r1) goto L_0x0108
            r0 = 41
            java.io.ByteArrayOutputStream r2 = new java.io.ByteArrayOutputStream
            r2.<init>()
            com.cyberneid.d.e.k r3 = r11.f5510a
            int r3 = r3.mo7788a()
            r4 = 1
        L_0x0019:
            r5 = -1
            if (r4 <= 0) goto L_0x00f7
            if (r3 == r5) goto L_0x00f7
            char r3 = (char) r3
            r6 = -2
            if (r3 != r0) goto L_0x002e
            int r4 = r4 + -1
            int r4 = r11.mo7777g(r4)
            if (r4 == 0) goto L_0x002b
            goto L_0x0032
        L_0x002b:
            r3 = -2
            goto L_0x00eb
        L_0x002e:
            if (r3 != r1) goto L_0x0036
            int r4 = r4 + 1
        L_0x0032:
            r2.write(r3)
            goto L_0x002b
        L_0x0036:
            r7 = 92
            if (r3 != r7) goto L_0x0032
            com.cyberneid.d.e.k r3 = r11.f5510a
            int r3 = r3.mo7788a()
            char r3 = (char) r3
            r8 = 10
            if (r3 == r8) goto L_0x00dc
            r9 = 13
            if (r3 == r9) goto L_0x00dc
            if (r3 == r7) goto L_0x0032
            r5 = 98
            r10 = 8
            if (r3 == r5) goto L_0x00d7
            r5 = 102(0x66, float:1.43E-43)
            if (r3 == r5) goto L_0x00d4
            r5 = 110(0x6e, float:1.54E-43)
            if (r3 == r5) goto L_0x00cf
            r5 = 114(0x72, float:1.6E-43)
            if (r3 == r5) goto L_0x00ca
            r5 = 116(0x74, float:1.63E-43)
            if (r3 == r5) goto L_0x00c7
            switch(r3) {
                case 40: goto L_0x0032;
                case 41: goto L_0x00ba;
                default: goto L_0x0064;
            }
        L_0x0064:
            switch(r3) {
                case 48: goto L_0x0068;
                case 49: goto L_0x0068;
                case 50: goto L_0x0068;
                case 51: goto L_0x0068;
                case 52: goto L_0x0068;
                case 53: goto L_0x0068;
                case 54: goto L_0x0068;
                case 55: goto L_0x0068;
                default: goto L_0x0067;
            }
        L_0x0067:
            goto L_0x0032
        L_0x0068:
            java.lang.StringBuffer r5 = new java.lang.StringBuffer
            r5.<init>()
            r5.append(r3)
            com.cyberneid.d.e.k r3 = r11.f5510a
            int r3 = r3.mo7788a()
            char r7 = (char) r3
            r8 = 48
            if (r7 < r8) goto L_0x0091
            r9 = 55
            if (r7 > r9) goto L_0x0091
            r5.append(r7)
            com.cyberneid.d.e.k r3 = r11.f5510a
            int r3 = r3.mo7788a()
            char r7 = (char) r3
            if (r7 < r8) goto L_0x0091
            if (r7 > r9) goto L_0x0091
            r5.append(r7)
            r3 = -2
        L_0x0091:
            java.lang.String r7 = r5.toString()     // Catch:{ NumberFormatException -> 0x009d }
            int r5 = java.lang.Integer.parseInt(r7, r10)     // Catch:{ NumberFormatException -> 0x009d }
            r2.write(r5)
            goto L_0x00eb
        L_0x009d:
            r0 = move-exception
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "Error: Expected octal character, actual='"
            r2.append(r3)
            r2.append(r5)
            java.lang.String r3 = "'"
            r2.append(r3)
            java.lang.String r2 = r2.toString()
            r1.<init>(r2, r0)
            throw r1
        L_0x00ba:
            int r4 = r11.mo7777g(r4)
            if (r4 == 0) goto L_0x00c2
            goto L_0x0032
        L_0x00c2:
            r2.write(r7)
            goto L_0x002b
        L_0x00c7:
            r3 = 9
            goto L_0x0067
        L_0x00ca:
            r2.write(r9)
            goto L_0x002b
        L_0x00cf:
            r2.write(r8)
            goto L_0x002b
        L_0x00d4:
            r3 = 12
            goto L_0x0067
        L_0x00d7:
            r2.write(r10)
            goto L_0x002b
        L_0x00dc:
            com.cyberneid.d.e.k r3 = r11.f5510a
            int r3 = r3.mo7788a()
            boolean r7 = r11.mo7751c(r3)
            if (r7 == 0) goto L_0x00eb
            if (r3 == r5) goto L_0x00eb
            goto L_0x00dc
        L_0x00eb:
            if (r3 == r6) goto L_0x00ef
            goto L_0x0019
        L_0x00ef:
            com.cyberneid.d.e.k r3 = r11.f5510a
            int r3 = r3.mo7788a()
            goto L_0x0019
        L_0x00f7:
            if (r3 == r5) goto L_0x00fe
            com.cyberneid.d.e.k r0 = r11.f5510a
            r0.mo7791a((int) r3)
        L_0x00fe:
            com.cyberneid.d.b.p r0 = new com.cyberneid.d.b.p
            byte[] r1 = r2.toByteArray()
            r0.<init>((byte[]) r1)
            return r0
        L_0x0108:
            r1 = 60
            if (r0 != r1) goto L_0x0111
            com.cyberneid.d.b.p r0 = r11.mo7780t()
            return r0
        L_0x0111:
            java.io.IOException r1 = new java.io.IOException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r3 = "parseCOSString string should start with '(' or '<' and not '"
            r2.append(r3)
            r2.append(r0)
            java.lang.String r0 = "' "
            r2.append(r0)
            com.cyberneid.d.e.k r0 = r11.f5510a
            r2.append(r0)
            java.lang.String r0 = r2.toString()
            r1.<init>(r0)
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1666a.mo7750c():com.cyberneid.d.b.p");
    }

    /* access modifiers changed from: protected */
    /* renamed from: c */
    public boolean mo7751c(int i) {
        return m6702h(i) || m6703i(i);
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public C1604a mo7752d() {
        mo7744a('[');
        C1604a aVar = new C1604a();
        while (true) {
            mo7762l();
            int c = this.f5510a.mo7795c();
            if (c <= 0 || ((char) c) == ']') {
                this.f5510a.mo7788a();
                mo7762l();
            } else {
                C1605b f = mo7756f();
                if (f instanceof C1616l) {
                    if (aVar.mo7495b(aVar.mo7494b() - 1) instanceof C1612h) {
                        C1612h hVar = (C1612h) aVar.mo7501d(aVar.mo7494b() - 1);
                        if (aVar.mo7495b(aVar.mo7494b() - 1) instanceof C1612h) {
                            f = m6697a(new C1617m(((C1612h) aVar.mo7501d(aVar.mo7494b() - 1)).mo7585b(), hVar.mo7586c()));
                        }
                    }
                    f = null;
                }
                if (f != null) {
                    aVar.mo7490a(f);
                } else {
                    Log.w("PdfBox-Android", "Corrupt object reference at offset " + this.f5510a.mo7792b());
                    String g = mo7757g();
                    this.f5510a.mo7793b(g.getBytes(C1933a.f6111d));
                    if ("endobj".equals(g) || "endstream".equals(g)) {
                        return aVar;
                    }
                }
            }
        }
        this.f5510a.mo7788a();
        mo7762l();
        return aVar;
    }

    /* access modifiers changed from: protected */
    /* renamed from: d */
    public boolean mo7753d(int i) {
        return i == 0 || i == 9 || i == 12 || i == 10 || i == 13 || i == 32;
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0080, code lost:
        if (mo7747a(r1) == false) goto L_0x0083;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.cyberneid.p105d.p108b.C1613i mo7754e() {
        /*
            r5 = this;
            r0 = 47
            r5.mo7744a((char) r0)
            java.io.ByteArrayOutputStream r0 = new java.io.ByteArrayOutputStream
            r0.<init>()
        L_0x000a:
            com.cyberneid.d.e.k r1 = r5.f5510a
            int r1 = r1.mo7788a()
        L_0x0010:
            r2 = -1
            if (r1 == r2) goto L_0x0087
            r3 = 35
            if (r1 != r3) goto L_0x007c
            com.cyberneid.d.e.k r2 = r5.f5510a
            int r2 = r2.mo7788a()
            char r2 = (char) r2
            com.cyberneid.d.e.k r3 = r5.f5510a
            int r3 = r3.mo7788a()
            char r3 = (char) r3
            boolean r4 = m6699b((char) r2)
            if (r4 == 0) goto L_0x0072
            boolean r4 = m6699b((char) r3)
            if (r4 == 0) goto L_0x0072
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r4 = ""
            r1.append(r4)
            r1.append(r2)
            r1.append(r3)
            java.lang.String r1 = r1.toString()
            r2 = 16
            int r2 = java.lang.Integer.parseInt(r1, r2)     // Catch:{ NumberFormatException -> 0x0055 }
            r0.write(r2)     // Catch:{ NumberFormatException -> 0x0055 }
            com.cyberneid.d.e.k r1 = r5.f5510a
            int r2 = r1.mo7788a()
            goto L_0x007a
        L_0x0055:
            r0 = move-exception
            java.io.IOException r2 = new java.io.IOException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Error: expected hex digit, actual='"
            r3.append(r4)
            r3.append(r1)
            java.lang.String r1 = "'"
            r3.append(r1)
            java.lang.String r1 = r3.toString()
            r2.<init>(r1, r0)
            throw r2
        L_0x0072:
            com.cyberneid.d.e.k r4 = r5.f5510a
            r4.mo7791a((int) r3)
            r0.write(r1)
        L_0x007a:
            r1 = r2
            goto L_0x0010
        L_0x007c:
            boolean r3 = r5.mo7747a((int) r1)
            if (r3 == 0) goto L_0x0083
            goto L_0x0087
        L_0x0083:
            r0.write(r1)
            goto L_0x000a
        L_0x0087:
            if (r1 == r2) goto L_0x008e
            com.cyberneid.d.e.k r2 = r5.f5510a
            r2.mo7791a((int) r1)
        L_0x008e:
            java.lang.String r1 = new java.lang.String
            byte[] r0 = r0.toByteArray()
            java.nio.charset.Charset r2 = com.cyberneid.p105d.p131h.C1933a.f6112e
            r1.<init>(r0, r2)
            com.cyberneid.d.b.i r0 = com.cyberneid.p105d.p108b.C1613i.m6461a((java.lang.String) r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1666a.mo7754e():com.cyberneid.d.b.i");
    }

    /* access modifiers changed from: protected */
    /* renamed from: e */
    public boolean mo7755e(int i) {
        return 32 == i;
    }

    /* access modifiers changed from: protected */
    /* renamed from: f */
    public C1605b mo7756f() {
        int a;
        mo7762l();
        char c = (char) this.f5510a.mo7795c();
        if (c != '(') {
            if (c == '/') {
                return mo7754e();
            }
            if (c == '<') {
                int a2 = this.f5510a.mo7788a();
                char c2 = (char) this.f5510a.mo7795c();
                this.f5510a.mo7791a(a2);
                if (c2 == '<') {
                    C1607d a3 = mo7743a();
                    mo7762l();
                    return a3;
                }
            } else if (c == 'R') {
                this.f5510a.mo7788a();
                return new C1616l((C1605b) null);
            } else if (c == '[') {
                return mo7752d();
            } else {
                if (c == 'f') {
                    String str = new String(this.f5510a.mo7794b(5), C1933a.f6111d);
                    if (str.equals("false")) {
                        return C1606c.f4867d;
                    }
                    throw new IOException("expected false actual='" + str + "' " + this.f5510a + "' at offset " + this.f5510a.mo7792b());
                } else if (c == 'n') {
                    mo7745a("null");
                    return C1614j.f5368b;
                } else if (c == 't') {
                    String str2 = new String(this.f5510a.mo7794b(4), C1933a.f6111d);
                    if (str2.equals("true")) {
                        return C1606c.f4866c;
                    }
                    throw new IOException("expected true actual='" + str2 + "' " + this.f5510a + "' at offset " + this.f5510a.mo7792b());
                } else if (c == 65535) {
                    return null;
                } else {
                    if (Character.isDigit(c) || c == '-' || c == '+' || c == '.') {
                        StringBuilder sb = new StringBuilder();
                        while (true) {
                            a = this.f5510a.mo7788a();
                            char c3 = (char) a;
                            if (!Character.isDigit(c3) && c3 != '-' && c3 != '+' && c3 != '.' && c3 != 'E' && c3 != 'e') {
                                break;
                            }
                            sb.append(c3);
                        }
                        if (a != -1) {
                            this.f5510a.mo7791a(a);
                        }
                        return C1615k.m6468a(sb.toString());
                    }
                    String g = mo7757g();
                    if (g == null || g.length() == 0) {
                        int c4 = this.f5510a.mo7795c();
                        throw new IOException("Unknown dir object c='" + c + "' cInt=" + c + " peek='" + ((char) c4) + "' peekInt=" + c4 + " " + this.f5510a.mo7792b());
                    } else if (!"endobj".equals(g) && !"endstream".equals(g)) {
                        return null;
                    } else {
                        this.f5510a.mo7793b(g.getBytes(C1933a.f6111d));
                        return null;
                    }
                }
            }
        }
        return mo7750c();
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:6:0x001e  */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public java.lang.String mo7757g() {
        /*
            r5 = this;
            r5.mo7762l()
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0008:
            com.cyberneid.d.e.k r1 = r5.f5510a
            int r1 = r1.mo7788a()
            char r2 = (char) r1
            boolean r3 = r5.mo7747a((int) r2)
            r4 = -1
            if (r3 != 0) goto L_0x001c
            if (r1 == r4) goto L_0x001c
            r0.append(r2)
            goto L_0x0008
        L_0x001c:
            if (r1 == r4) goto L_0x0023
            com.cyberneid.d.e.k r2 = r5.f5510a
            r2.mo7791a((int) r1)
        L_0x0023:
            java.lang.String r0 = r0.toString()
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1666a.mo7757g():java.lang.String");
    }

    /* access modifiers changed from: protected */
    /* renamed from: h */
    public String mo7758h() {
        int a;
        if (!this.f5510a.mo7797d()) {
            StringBuilder sb = new StringBuilder(11);
            while (true) {
                a = this.f5510a.mo7788a();
                if (a != -1 && !mo7751c(a)) {
                    sb.append((char) a);
                }
            }
            if (m6703i(a) && m6702h(this.f5510a.mo7795c())) {
                this.f5510a.mo7788a();
            }
            return sb.toString();
        }
        throw new IOException("Error: End-of-File, expected line");
    }

    /* access modifiers changed from: protected */
    /* renamed from: i */
    public boolean mo7759i() {
        return mo7753d(this.f5510a.mo7795c());
    }

    /* access modifiers changed from: protected */
    /* renamed from: j */
    public boolean mo7760j() {
        return mo7755e(this.f5510a.mo7795c());
    }

    /* access modifiers changed from: protected */
    /* renamed from: k */
    public boolean mo7761k() {
        return m6700f(this.f5510a.mo7795c());
    }

    /* access modifiers changed from: protected */
    /* renamed from: l */
    public void mo7762l() {
        int a;
        loop0:
        while (true) {
            a = this.f5510a.mo7788a();
            while (true) {
                if (!mo7753d(a) && a != 37) {
                    break loop0;
                } else if (a == 37) {
                    do {
                        a = this.f5510a.mo7788a();
                        if (mo7751c(a)) {
                            break;
                        }
                    } while (a != -1);
                }
            }
        }
        if (a != -1) {
            this.f5510a.mo7791a(a);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: m */
    public int mo7763m() {
        int o = mo7765o();
        if (o >= 0 && ((long) o) < 10000000000L) {
            return o;
        }
        throw new IOException("Object Number '" + o + "' has more than 10 digits or is negative");
    }

    /* access modifiers changed from: protected */
    /* renamed from: n */
    public int mo7764n() {
        int o = mo7765o();
        if (o >= 0 && ((long) o) <= 65535) {
            return o;
        }
        throw new IOException("Generation Number '" + o + "' has more than 5 digits");
    }

    /* access modifiers changed from: protected */
    /* renamed from: o */
    public int mo7765o() {
        mo7762l();
        StringBuilder q = mo7767q();
        try {
            return Integer.parseInt(q.toString());
        } catch (NumberFormatException e) {
            this.f5510a.mo7793b(q.toString().getBytes(C1933a.f6111d));
            throw new IOException("Error: Expected an integer type at offset " + this.f5510a.mo7792b(), e);
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: p */
    public long mo7766p() {
        mo7762l();
        StringBuilder q = mo7767q();
        try {
            return Long.parseLong(q.toString());
        } catch (NumberFormatException e) {
            this.f5510a.mo7793b(q.toString().getBytes(C1933a.f6111d));
            throw new IOException("Error: Expected a long type at offset " + this.f5510a.mo7792b() + ", instead got '" + q + "'", e);
        }
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x002f  */
    /* renamed from: q */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final java.lang.StringBuilder mo7767q() {
        /*
            r4 = this;
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
        L_0x0005:
            com.cyberneid.d.e.k r1 = r4.f5510a
            int r1 = r1.mo7788a()
            r2 = 32
            r3 = -1
            if (r1 == r2) goto L_0x002d
            r2 = 10
            if (r1 == r2) goto L_0x002d
            r2 = 13
            if (r1 == r2) goto L_0x002d
            r2 = 60
            if (r1 == r2) goto L_0x002d
            r2 = 91
            if (r1 == r2) goto L_0x002d
            r2 = 40
            if (r1 == r2) goto L_0x002d
            if (r1 == 0) goto L_0x002d
            if (r1 == r3) goto L_0x002d
            char r1 = (char) r1
            r0.append(r1)
            goto L_0x0005
        L_0x002d:
            if (r1 == r3) goto L_0x0034
            com.cyberneid.d.e.k r2 = r4.f5510a
            r2.mo7791a((int) r1)
        L_0x0034:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.cyberneid.p105d.p112e.C1666a.mo7767q():java.lang.StringBuilder");
    }
}
